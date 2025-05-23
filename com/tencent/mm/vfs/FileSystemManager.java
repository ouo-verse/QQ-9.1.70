package com.tencent.mm.vfs;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.util.Pair;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mm.vfs.VFSUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class FileSystemManager implements Handler.Callback {
    private static final int BROADCAST_FILE_VERSION = 2;
    private static final String FILE_BROADCAST = "fs.bin";
    private static final String FILE_MAINTENANCE_TIMESTAMP = "maintain.timestamp";
    private static final int MSG_MAINTENANCE = 2;
    private static final int MSG_REFRESH_VFS = 1;
    private static final String TAG = "VFS.FileSystemManager";
    private static final String VFS_DIR = ".vfs";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context sContext = null;
    private static volatile KeyGen sKeyGen = null;
    private static volatile boolean sLoadBroadcast = true;
    private static StatisticsCallback sStatisticsCallback;
    private final Context mContext;
    private final ResolverState mInitialState;
    private Resolution mInvalidResolution;
    private final Object mLock;
    private final Handler mMaintenanceHandler;
    private volatile long mMaintenanceInterval;
    private final MaintenanceBroadcastReceiver mMaintenanceReceiver;
    private final HandlerThread mMaintenanceThread;
    private volatile boolean mMaintenanceUseWakeLock;
    private volatile long mMaintenanceWaitTime;
    private volatile boolean mPublishOnEditorCommit;
    private volatile BroadcastReceiver mRefreshReceiver;
    private int mRevision;
    private ResolverState mState;
    private final File mVFSDir;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class Editor {
        private final HashMap<String, SchemeResolver> mSchemeResolvers = new HashMap<>();
        private final HashMap<String, FileSystem> mFileSystems = new HashMap<>();
        private final TreeMap<String, String> mMountPoints = new TreeMap<>();
        private final HashMap<String, String> mEnvVars = new HashMap<>();
        private FileSystem mRoot = null;
        private boolean mClean = false;

        public Editor() {
        }

        public Editor clear() {
            this.mFileSystems.clear();
            this.mMountPoints.clear();
            this.mEnvVars.clear();
            this.mRoot = null;
            this.mClean = true;
            return this;
        }

        public void commit() {
            commit(FileSystemManager.this.mPublishOnEditorCommit);
        }

        public Editor install(String str, FileSystem fileSystem) {
            this.mFileSystems.put(str, fileSystem);
            return this;
        }

        public Editor mount(String str, String str2) {
            this.mMountPoints.put(VFSUtils.normalizePath(str, true, false), str2);
            return this;
        }

        public Editor root(FileSystem fileSystem) {
            this.mRoot = fileSystem;
            return this;
        }

        public Editor scheme(String str, SchemeResolver schemeResolver) {
            this.mSchemeResolvers.put(str, schemeResolver);
            return this;
        }

        public Editor setEnv(String str, String str2) {
            this.mEnvVars.put(str, str2);
            return this;
        }

        public Editor uninstall(String str) {
            this.mFileSystems.put(str, null);
            return this;
        }

        public Editor unmount(String str) {
            this.mMountPoints.put(VFSUtils.normalizePath(str, true, false), null);
            return this;
        }

        public Editor unsetEnv(String str) {
            this.mEnvVars.put(str, null);
            return this;
        }

        public void commit(boolean z16) {
            FileSystemManager.this.updateFileSystems(this, z16);
            this.mFileSystems.clear();
            this.mMountPoints.clear();
            this.mEnvVars.clear();
            this.mClean = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface KeyGen {
        Key generate(String str, Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class MaintenanceBroadcastReceiver extends BroadcastReceiver {
        private CancellationSignalCompat mCancellationSignal;
        private boolean mIsCharging;
        private boolean mIsInteractive;

        MaintenanceBroadcastReceiver() {
        }

        private void triggerIdle() {
            if (QLog.isColorLevel()) {
                QLog.i(FileSystemManager.TAG, 2, "Idle status changed: charging = " + this.mIsCharging + ", interactive = " + this.mIsInteractive);
            }
            boolean z16 = this.mIsCharging;
            if (z16 && !this.mIsInteractive && this.mCancellationSignal == null) {
                long j3 = FileSystemManager.this.mMaintenanceWaitTime;
                if (j3 < 0) {
                    return;
                }
                this.mCancellationSignal = new CancellationSignalCompat();
                FileSystemManager.this.mMaintenanceHandler.sendMessageDelayed(Message.obtain(FileSystemManager.this.mMaintenanceHandler, 2, this.mCancellationSignal), j3);
                if (QLog.isColorLevel()) {
                    QLog.i(FileSystemManager.TAG, 2, "System idle, trigger maintenance timer for " + (j3 / 1000) + " seconds.");
                    return;
                }
                return;
            }
            if ((!z16 || this.mIsInteractive) && this.mCancellationSignal != null) {
                FileSystemManager.this.mMaintenanceHandler.removeMessages(2);
                this.mCancellationSignal.cancel();
                this.mCancellationSignal = null;
                if (QLog.isColorLevel()) {
                    QLog.i(FileSystemManager.TAG, 2, "Exit idle state, maintenance cancelled.");
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            char c16 = '\uffff';
            switch (action.hashCode()) {
                case -2128145023:
                    if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -1454123155:
                    if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        c16 = 3;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    this.mIsInteractive = false;
                    break;
                case 1:
                    this.mIsCharging = false;
                    break;
                case 2:
                    this.mIsInteractive = true;
                    break;
                case 3:
                    this.mIsCharging = true;
                    break;
            }
            triggerIdle();
        }

        void refreshIdleStatus(Context context) {
            boolean z16;
            this.mIsInteractive = ((PowerManager) context.getSystemService("power")).isScreenOn();
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                if (intExtra != 2 && intExtra != 5) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                this.mIsCharging = z16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class Resolution {
        final FileSystem fileSystem;
        final String path;
        final int revision;

        public String toString() {
            return this.path + " -> " + this.fileSystem.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean valid() {
            if (this.fileSystem != null) {
                return true;
            }
            return false;
        }

        Resolution(FileSystem fileSystem, String str, int i3) {
            this.fileSystem = fileSystem;
            this.path = str;
            this.revision = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class SingletonHolder {

        @SuppressLint({"StaticFieldLeak"})
        static final FileSystemManager INSTANCE;

        static {
            FileSystemManager fileSystemManager = new FileSystemManager();
            INSTANCE = fileSystemManager;
            fileSystemManager.initialize();
        }

        SingletonHolder() {
        }
    }

    private void clearInvalidFiles(CancellationSignalCompat cancellationSignalCompat) {
        StatisticsCallback statisticsCallback = sStatisticsCallback;
        if (statisticsCallback != null) {
            statisticsCallback.deleteFiles(cancellationSignalCompat);
        }
    }

    private void doMaintenance(CancellationSignalCompat cancellationSignalCompat) {
        PowerManager.WakeLock wakeLock;
        long j3 = this.mMaintenanceInterval;
        File file = new File(this.mVFSDir, FILE_MAINTENANCE_TIMESTAMP);
        long currentTimeMillis = System.currentTimeMillis();
        long lastModified = file.lastModified();
        boolean z16 = false;
        if (currentTimeMillis - lastModified < j3) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", Long.valueOf(currentTimeMillis), Long.valueOf(lastModified), Long.valueOf(j3)));
                return;
            }
            return;
        }
        boolean z17 = this.mMaintenanceUseWakeLock;
        if (z17) {
            if (this.mContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z16 = true;
            }
            z17 = z16;
        }
        if (z17) {
            wakeLock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, "VFS:Maintenance");
        } else {
            wakeLock = null;
        }
        try {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "Maintenance started. WakeLock: " + z17);
                }
                if (wakeLock != null) {
                    wakeLock.acquire(ShortVideoConstants.VIDEO_MAX_DURATION);
                }
                maintain(cancellationSignalCompat);
                clearInvalidFiles(cancellationSignalCompat);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "Maintenance finished.");
                }
                if (wakeLock == null || !wakeLock.isHeld()) {
                    return;
                }
            } catch (OperationCanceledException unused) {
                QLog.e(TAG, 1, "Maintenance cancelled.");
                if (wakeLock == null || !wakeLock.isHeld()) {
                    return;
                }
            } catch (Exception unused2) {
                QLog.e(TAG, 1, "Maintenance failed.");
                if (wakeLock == null || !wakeLock.isHeld()) {
                    return;
                }
            }
            wakeLock.release();
        } catch (Throwable th5) {
            if (wakeLock != null && wakeLock.isHeld()) {
                wakeLock.release();
            }
            throw th5;
        }
    }

    private static ResolverState generateInitialState(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(null, FileSchemeResolver.instance());
        hashMap.put("", FileSchemeResolver.instance());
        hashMap.put("file", FileSchemeResolver.instance());
        hashMap.put("wcf", WcfSchemeResolver.instance());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("data", context.getCacheDir().getParent());
        hashMap2.put("dataCache", context.getCacheDir().getPath());
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            hashMap2.put("extData", externalCacheDir.getParent());
            hashMap2.put("extCache", externalCacheDir.getPath());
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            hashMap2.put(QQPermissionConstants.Permission.STORAGE_GROUP, externalStorageDirectory.getPath());
        }
        return new ResolverState().update(hashMap, Collections.emptyMap(), new TreeMap(), hashMap2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeyGen getKeyGenerator() {
        return sKeyGen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize() {
        DataInputStream dataInputStream;
        File file;
        long length;
        int readInt;
        boolean z16 = sLoadBroadcast;
        VFSTrack.track(null, "initialize");
        this.mVFSDir.mkdir();
        QLog.d(TAG, 1, "initialize is called pid = " + Process.myPid());
        if (z16) {
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    file = new File(this.mVFSDir, FILE_BROADCAST);
                    length = file.length();
                } catch (VFSUtils.FileSystemVersionException e16) {
                    e = e16;
                    dataInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    dataInputStream = null;
                }
                if (length <= 1048576 && length > 4) {
                    int i3 = ((int) length) - 4;
                    byte[] bArr = new byte[i3];
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        readInt = dataInputStream.readInt();
                    } catch (VFSUtils.FileSystemVersionException e17) {
                        e = e17;
                        QLog.e(TAG, 1, e.getMessage());
                        reportErrorInner(new Throwable("VFSSystemManager config error", e));
                        VFSUtils.closeQuietly(dataInputStream);
                        OaidMonitor.parcelRecycle(obtain);
                        setBroadcastReceivingEnabled(z16);
                        enableMaintenance();
                        VFSTrack.track("initialize", null);
                    } catch (Throwable th6) {
                        th = th6;
                        reportErrorInner(th);
                        QLog.e(TAG, 1, new Throwable("VFSSystemManager config error", th), new Object[0]);
                        VFSUtils.closeQuietly(dataInputStream);
                        OaidMonitor.parcelRecycle(obtain);
                        setBroadcastReceivingEnabled(z16);
                        enableMaintenance();
                        VFSTrack.track("initialize", null);
                    }
                    if (readInt == 2) {
                        int i16 = 0;
                        while (i16 < i3) {
                            i16 += dataInputStream.read(bArr, i16, i3 - i16);
                        }
                        dataInputStream.close();
                        obtain.unmarshall(bArr, 0, i16);
                        obtain.setDataPosition(0);
                        loadFromBundle(obtain.readBundle(FileSystem.class.getClassLoader()));
                        VFSUtils.closeQuietly((Closeable) null);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        throw new VFSUtils.FileSystemVersionException(FileSystemManager.class, readInt, 2);
                    }
                }
                QLog.e(TAG, 1, "Invalid parcel file size: " + length);
                VFSUtils.closeQuietly((Closeable) null);
                OaidMonitor.parcelRecycle(obtain);
            } finally {
                VFSUtils.closeQuietly(dataInputStream);
                OaidMonitor.parcelRecycle(obtain);
            }
        }
        setBroadcastReceivingEnabled(z16);
        enableMaintenance();
        VFSTrack.track("initialize", null);
    }

    public static FileSystemManager instance() {
        return SingletonHolder.INSTANCE;
    }

    private void loadFromBundle(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getInt("pid") == Process.myPid()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Ignore filesystem change broadcast from the same process.");
                return;
            }
            return;
        }
        ResolverState loadFromBundle = ResolverState.loadFromBundle(bundle);
        Map<String, String> envVars = loadFromBundle.envVars();
        synchronized (this.mLock) {
            this.mState = loadFromBundle;
            int i3 = this.mRevision + 1;
            this.mRevision = i3;
            this.mInvalidResolution = new Resolution(null, 0 == true ? 1 : 0, i3);
            VFSTrack.track(null, VFSTrack.MIGRATE_CONFIGUE_TIME_1);
            loadFromBundle.mRootFileSystem.configure(envVars);
            Iterator<SchemeResolver> it = loadFromBundle.mSchemeResolvers.values().iterator();
            while (it.hasNext()) {
                it.next().configure(envVars);
            }
            Iterator<FileSystem> it5 = loadFromBundle.mFileSystems.values().iterator();
            while (it5.hasNext()) {
                it5.next().configure(envVars);
            }
            QLog.d(TAG, 1, "loadFromBundle. fileSystem size" + loadFromBundle.mFileSystems.size());
            VFSTrack.track(VFSTrack.MIGRATE_CONFIGUE_TIME_1, null);
        }
        StringBuilder sb5 = new StringBuilder(2048);
        sb5.append("[Schemes]\n");
        printChange(loadFromBundle.mSchemeResolvers, sb5);
        sb5.append("[File systems]\n");
        printChange(loadFromBundle.mFileSystems, sb5);
        sb5.append("[Mount points]\n");
        printChange(loadFromBundle.mMountPoints, sb5);
        sb5.append("[Environment]\n");
        printChange(loadFromBundle.mEnvVars, sb5);
        sb5.append("[Root]\n  ");
        sb5.append(loadFromBundle.mRootFileSystem.toString());
        sb5.append('\n');
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Loaded file system from bundle:\n" + sb5.toString());
        }
    }

    private static <K, V> void printChange(Map<K, V> map, StringBuilder sb5) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb5.append("  ");
            sb5.append(entry.getKey());
            if (entry.getValue() == null) {
                sb5.append(" (deleted)\n");
            } else {
                sb5.append(" => ");
                sb5.append(entry.getValue().toString());
                sb5.append('\n');
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void publishFileSystems(ResolverState resolverState) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        VFSTrack.track(null, VFSTrack.CONFIGURE_PUBLISH);
        Bundle writeToBundle = resolverState.writeToBundle();
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(writeToBundle);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        try {
            File file = new File(this.mVFSDir, FILE_BROADCAST);
            if (!file.exists()) {
                file.createNewFile();
            }
            dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        } catch (IOException e16) {
            e = e16;
            dataOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            VFSUtils.closeQuietly(dataOutputStream2);
            throw th;
        }
        try {
            try {
                dataOutputStream.writeInt(2);
                dataOutputStream.write(marshall);
            } catch (Throwable th6) {
                th = th6;
                dataOutputStream2 = dataOutputStream;
                VFSUtils.closeQuietly(dataOutputStream2);
                throw th;
            }
        } catch (IOException e17) {
            e = e17;
            reportErrorInner(new Throwable("VFSSystemManager config error", e));
            QLog.e(TAG, 1, "Cannot write parcel file: " + e.getMessage());
            VFSUtils.closeQuietly(dataOutputStream);
            Intent intent = new Intent(this.mContext.getPackageName() + ".REFRESH_VFS");
            intent.putExtras(writeToBundle);
            intent.putExtra("pid", Process.myPid());
            this.mContext.sendBroadcast(intent);
            StringBuilder sb5 = new StringBuilder(2048);
            sb5.append("[Schemes]\n");
            printChange(resolverState.mSchemeResolvers, sb5);
            sb5.append("[File systems]\n");
            printChange(resolverState.mFileSystems, sb5);
            sb5.append("[Mount points]\n");
            printChange(resolverState.mMountPoints, sb5);
            sb5.append("[Environment]\n");
            printChange(resolverState.mEnvVars, sb5);
            sb5.append("[Root]\n  ");
            sb5.append(resolverState.mRootFileSystem.toString());
            sb5.append('\n');
            if (QLog.isColorLevel()) {
            }
            VFSTrack.track(VFSTrack.CONFIGURE_PUBLISH, null);
        }
        VFSUtils.closeQuietly(dataOutputStream);
        Intent intent2 = new Intent(this.mContext.getPackageName() + ".REFRESH_VFS");
        intent2.putExtras(writeToBundle);
        intent2.putExtra("pid", Process.myPid());
        this.mContext.sendBroadcast(intent2);
        StringBuilder sb52 = new StringBuilder(2048);
        sb52.append("[Schemes]\n");
        printChange(resolverState.mSchemeResolvers, sb52);
        sb52.append("[File systems]\n");
        printChange(resolverState.mFileSystems, sb52);
        sb52.append("[Mount points]\n");
        printChange(resolverState.mMountPoints, sb52);
        sb52.append("[Environment]\n");
        printChange(resolverState.mEnvVars, sb52);
        sb52.append("[Root]\n  ");
        sb52.append(resolverState.mRootFileSystem.toString());
        sb52.append('\n');
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Filesystem published:\n" + sb52.toString());
        }
        VFSTrack.track(VFSTrack.CONFIGURE_PUBLISH, null);
    }

    private void reportErrorInner(Throwable th5) {
        StatisticsCallback statisticsCallback = sStatisticsCallback;
        if (statisticsCallback != null) {
            statisticsCallback.reportError(th5);
        }
    }

    public static void setContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        sContext = context;
    }

    public static void setKeyGenerator(KeyGen keyGen) {
        sKeyGen = keyGen;
    }

    public static void setLoadBroadcast(boolean z16) {
        sLoadBroadcast = z16;
    }

    public static void setStatisticsCallback(StatisticsCallback statisticsCallback) {
        sStatisticsCallback = statisticsCallback;
    }

    public static StatisticsCallback statisticsCallback() {
        return sStatisticsCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateFileSystems(Editor editor, boolean z16) {
        ResolverState resolverState;
        int i3;
        FileSystem fileSystem;
        ResolverState update;
        Map<String, String> envVars;
        int i16;
        byte b16;
        byte b17;
        HashMap hashMap = editor.mSchemeResolvers;
        HashMap hashMap2 = editor.mFileSystems;
        TreeMap treeMap = editor.mMountPoints;
        HashMap hashMap3 = editor.mEnvVars;
        FileSystem fileSystem2 = editor.mRoot;
        boolean z17 = editor.mClean;
        StringBuilder sb5 = new StringBuilder();
        if (z17) {
            sb5.append("[CLEAN ALL]\n");
        }
        if (!hashMap.isEmpty()) {
            sb5.append("[Scheme]\n");
            printChange(hashMap, sb5);
        }
        if (!hashMap2.isEmpty()) {
            sb5.append("[File systems]\n");
            printChange(hashMap2, sb5);
        }
        if (!treeMap.isEmpty()) {
            sb5.append("[Mount points]\n");
            printChange(treeMap, sb5);
        }
        QLog.d(TAG, 1, "updateFileSystems is called, fsChange size = " + hashMap2.size() + ", mount change = " + treeMap.size() + ", publish = " + z16);
        if (!hashMap3.isEmpty()) {
            sb5.append("[Environment]\n");
            printChange(hashMap3, sb5);
        }
        if (fileSystem2 != null) {
            sb5.append("[Root]\n  ");
            sb5.append(fileSystem2);
            sb5.append('\n');
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "File system configuration changed:\n" + sb5.toString());
        }
        synchronized (this.mLock) {
            if (z17) {
                resolverState = this.mInitialState;
            } else {
                resolverState = this.mState;
            }
            i3 = this.mRevision;
        }
        ResolverState resolverState2 = resolverState;
        int i17 = i3;
        while (true) {
            fileSystem = null;
            b17 = 0;
            b16 = 0;
            VFSTrack.track(null, "update");
            update = resolverState2.update(hashMap, hashMap2, treeMap, hashMap3, fileSystem2);
            VFSTrack.track("update", null);
            envVars = update.envVars();
            QLog.d(TAG, 1, "updateFileSystems is called revision = " + i17 + ", mRevision = " + this.mRevision);
            synchronized (this.mLock) {
                i16 = this.mRevision;
                if (i17 == i16) {
                    break;
                } else if (z17) {
                    resolverState2 = this.mInitialState;
                } else {
                    resolverState2 = this.mState;
                }
            }
            if (z16) {
                publishFileSystems(update);
                return;
            }
            return;
            i17 = i16;
        }
        this.mState = update;
        int i18 = i17 + 1;
        this.mRevision = i18;
        this.mInvalidResolution = new Resolution(fileSystem, b16 == true ? 1 : 0, i18);
        VFSTrack.track(null, VFSTrack.MIGRATE_CONFIGUE_TIME_2);
        if (!z17 && hashMap3.isEmpty()) {
            if (fileSystem2 != null) {
                update.mRootFileSystem.configure(envVars);
            }
            for (SchemeResolver schemeResolver : hashMap.values()) {
                if (schemeResolver != null) {
                    schemeResolver.configure(envVars);
                }
            }
            for (FileSystem fileSystem3 : hashMap2.values()) {
                if (fileSystem3 != null) {
                    fileSystem3.configure(envVars);
                }
            }
            VFSTrack.track(VFSTrack.MIGRATE_CONFIGUE_TIME_2, null);
            if (z16) {
            }
        }
        update.mRootFileSystem.configure(envVars);
        Iterator<SchemeResolver> it = update.mSchemeResolvers.values().iterator();
        while (it.hasNext()) {
            it.next().configure(envVars);
        }
        Iterator<FileSystem> it5 = update.mFileSystems.values().iterator();
        while (it5.hasNext()) {
            it5.next().configure(envVars);
        }
        VFSTrack.track(VFSTrack.MIGRATE_CONFIGUE_TIME_2, null);
        if (z16) {
        }
    }

    public void disableMaintenance() {
        enableMaintenance(-1L, Long.MAX_VALUE, false);
    }

    public Editor edit() {
        return new Editor();
    }

    public void enableMaintenance() {
        VFSTrack.track(null, "enableMaintenance");
        enableMaintenance(420000L, 259200000L, true);
        VFSTrack.track("enableMaintenance", null);
    }

    public Map<String, String> environmentVariables() {
        Map<String, String> envVars;
        synchronized (this.mLock) {
            envVars = this.mState.envVars();
        }
        return envVars;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri exportUri(Uri uri) {
        ResolverState resolverState;
        synchronized (this.mLock) {
            resolverState = this.mState;
        }
        SchemeResolver schemeResolver = resolverState.mSchemeResolvers.get(uri.getScheme());
        if (schemeResolver == null) {
            return null;
        }
        return schemeResolver.exportUri(resolverState, uri);
    }

    public Map<String, FileSystem> fileSystems() {
        Map<String, FileSystem> fileSystems;
        synchronized (this.mLock) {
            fileSystems = this.mState.fileSystems();
        }
        return fileSystems;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            doMaintenance((CancellationSignalCompat) message.obj);
            return true;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(FileSystem.class.getClassLoader());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Refresh file system from broadcast.");
        }
        try {
            loadFromBundle(intent.getExtras());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "Failed to refresh file system from broadcast.", th5);
        }
        return true;
    }

    public boolean isValidConfigFile(Context context) {
        if (context != null) {
            File parentFile = context.getFilesDir().getParentFile();
            if (parentFile == null) {
                parentFile = context.getCacheDir();
            }
            File file = new File(new File(parentFile, VFS_DIR), FILE_BROADCAST);
            if (!file.exists()) {
                reportErrorInner(new Throwable("VFSSystemManager isValidConfigFile broadcastFile not exist!"));
            }
            long length = file.length();
            if (length <= 1048576 && length > 4) {
                return true;
            }
            reportErrorInner(new Throwable("VFSSystemManager Invalid parcel file size: " + length));
        }
        return false;
    }

    public void maintain(CancellationSignalCompat cancellationSignalCompat) throws OperationCanceledException {
        ResolverState resolverState;
        File file = new File(this.mVFSDir, FILE_MAINTENANCE_TIMESTAMP);
        synchronized (this.mLock) {
            resolverState = this.mState;
        }
        for (Map.Entry<String, SchemeResolver> entry : resolverState.mSchemeResolvers.entrySet()) {
            SchemeResolver value = entry.getValue();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[Maintenance] " + entry.getKey() + " => " + value.toString());
            }
            value.maintain(cancellationSignalCompat);
        }
        for (Map.Entry<String, FileSystem> entry2 : resolverState.mFileSystems.entrySet()) {
            FileSystem value2 = entry2.getValue();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[Maintenance] " + entry2.getKey() + " => " + value2.toString());
            }
            value2.maintain(cancellationSignalCompat);
        }
        try {
            file.createNewFile();
            file.setLastModified(System.currentTimeMillis());
        } catch (IOException e16) {
            reportErrorInner(new Throwable("VFSSystemManager maintain error", e16));
            QLog.e(TAG, 1, "Unable to update maintenance timestamp: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Looper maintenanceLooper() {
        return this.mMaintenanceThread.getLooper();
    }

    public void publish() {
        ResolverState resolverState;
        synchronized (this.mLock) {
            resolverState = this.mState;
        }
        publishFileSystems(resolverState);
    }

    public void publishOnEditorCommit(boolean z16) {
        this.mPublishOnEditorCommit = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resolution resolve(Uri uri, Resolution resolution) {
        synchronized (this.mLock) {
            if (resolution != null) {
                if (resolution.revision == this.mRevision) {
                    return resolution;
                }
            }
            ResolverState resolverState = this.mState;
            int i3 = this.mRevision;
            Resolution resolution2 = this.mInvalidResolution;
            SchemeResolver schemeResolver = resolverState.mSchemeResolvers.get(uri.getScheme());
            if (schemeResolver == null) {
                QLog.e(TAG, 1, "resolve is wrong! revoler is null,  resolvers size = " + resolverState.mSchemeResolvers.size());
                return resolution2;
            }
            Pair<FileSystem, String> resolve = schemeResolver.resolve(resolverState, uri);
            return resolve == null ? resolution2 : new Resolution((FileSystem) resolve.first, (String) resolve.second, i3);
        }
    }

    public void setBroadcastReceivingEnabled(boolean z16) {
        VFSTrack.track(null, "setBroadcastReceivingEnabled");
        BroadcastReceiver broadcastReceiver = this.mRefreshReceiver;
        if (broadcastReceiver == null && z16) {
            BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.tencent.mm.vfs.FileSystemManager.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    FileSystemManager.this.mMaintenanceHandler.sendMessageAtFrontOfQueue(Message.obtain(FileSystemManager.this.mMaintenanceHandler, 1, intent));
                }
            };
            this.mRefreshReceiver = broadcastReceiver2;
            String packageName = this.mContext.getPackageName();
            this.mContext.registerReceiver(broadcastReceiver2, new IntentFilter(packageName + ".REFRESH_VFS"), "com.tencent.mobileqq.permission.MM_MESSAGE", null);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Broadcast receiving enabled.");
            }
        } else if (broadcastReceiver != null && !z16) {
            this.mContext.unregisterReceiver(broadcastReceiver);
            this.mRefreshReceiver = null;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Broadcast receiving disabled.");
            }
        }
        VFSTrack.track("setBroadcastReceivingEnabled", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> staticEnvironment() {
        return this.mInitialState.envVars();
    }

    FileSystemManager() {
        this.mLock = new Object();
        Context context = sContext;
        this.mContext = context;
        if (context != null) {
            File parentFile = context.getFilesDir().getParentFile();
            this.mVFSDir = new File(parentFile == null ? context.getCacheDir() : parentFile, VFS_DIR);
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VFS.Maintenance", 4);
            this.mMaintenanceThread = baseHandlerThread;
            baseHandlerThread.start();
            VFSTrack.track(null, VFSTrack.CONSTRUCTOR_TIME);
            this.mMaintenanceHandler = new Handler(baseHandlerThread.getLooper(), this);
            this.mMaintenanceReceiver = new MaintenanceBroadcastReceiver();
            this.mMaintenanceWaitTime = -1L;
            this.mMaintenanceInterval = Long.MAX_VALUE;
            this.mPublishOnEditorCommit = true;
            ResolverState generateInitialState = generateInitialState(context);
            this.mInitialState = generateInitialState;
            this.mState = generateInitialState;
            this.mRevision = 0;
            this.mInvalidResolution = new Resolution(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0);
            VFSTrack.track(VFSTrack.CONSTRUCTOR_TIME, null);
            return;
        }
        throw new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
    }

    public void enableMaintenance(long j3, long j16, boolean z16) {
        long j17 = this.mMaintenanceWaitTime;
        if (j3 >= 0 && j17 < 0) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            this.mContext.registerReceiver(this.mMaintenanceReceiver, intentFilter);
            this.mMaintenanceReceiver.refreshIdleStatus(this.mContext);
        } else if (j3 < 0 && j17 >= 0) {
            this.mContext.unregisterReceiver(this.mMaintenanceReceiver);
        }
        this.mMaintenanceWaitTime = j3;
        this.mMaintenanceInterval = j16;
        this.mMaintenanceUseWakeLock = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resolution resolve(Uri uri) {
        return resolve(uri, null);
    }
}
