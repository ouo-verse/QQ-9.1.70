package com.tencent.smtt.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5ChildProcessService;
import dalvik.system.DexClassLoader;
import dalvik.system.InMemoryDexClassLoader;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes23.dex */
public class ChildProcessService extends Service {
    private static final String TAG = "ChildProcessService";
    private static ChildProcessDelegate sDelegate;
    private IX5ChildProcessService mService;

    /* loaded from: classes23.dex */
    public static class Privileged extends ChildProcessService {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged0 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged1 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged2 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged3 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged4 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged5 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged6 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged7 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged8 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static final class Privileged9 extends Privileged {
    }

    /* loaded from: classes23.dex */
    public static class Sandboxed extends ChildProcessService {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed0 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed1 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed2 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed3 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed4 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed5 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed6 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed7 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed8 extends Sandboxed {
    }

    /* loaded from: classes23.dex */
    public static final class Sandboxed9 extends Sandboxed {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static final class SealedDexClassLoader extends DexClassLoader {
        private final boolean mNeedsFilter;
        private final String[] mUnsealedPackages;

        public SealedDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, String[] strArr) {
            super(str, str2, str3, classLoader);
            boolean z16;
            this.mUnsealedPackages = strArr;
            if (strArr != null && strArr.length > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mNeedsFilter = z16;
        }

        private Class<?> loadClassBySelfFirst(String str) throws ClassNotFoundException {
            ClassLoader parent;
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass == null) {
                try {
                    findLoadedClass = findClass(str);
                } catch (ClassNotFoundException unused) {
                }
                if (findLoadedClass == null && (parent = getParent()) != null) {
                    return parent.loadClass(str);
                }
                return findLoadedClass;
            }
            return findLoadedClass;
        }

        @Override // java.lang.ClassLoader
        protected Class<?> loadClass(String str, boolean z16) throws ClassNotFoundException {
            if (this.mNeedsFilter && str != null) {
                for (String str2 : this.mUnsealedPackages) {
                    if (str.startsWith(str2)) {
                        return super.loadClass(str, z16);
                    }
                }
            }
            return loadClassBySelfFirst(str);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    private ParcelFileDescriptor getParcelFileDescriptor(Intent intent, String str) throws RemoteException {
        Parcel parcel;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            IBinder binder = extras.getBinder(str);
            if (binder != null) {
                Parcel parcel2 = null;
                try {
                    parcel = Parcel.obtain();
                } catch (Throwable th5) {
                    th = th5;
                    parcel = null;
                }
                try {
                    parcel2 = Parcel.obtain();
                    OaidMonitor.binderTransact(binder, 1, parcel, parcel2, 0);
                    ParcelFileDescriptor readFileDescriptor = parcel2.readFileDescriptor();
                    OaidMonitor.parcelRecycle(parcel2);
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                    if (readFileDescriptor != null) {
                        return readFileDescriptor;
                    }
                    throw new IllegalArgumentException("pfd for " + str + MsgSummary.STR_COLON + readFileDescriptor);
                } catch (Throwable th6) {
                    th = th6;
                    if (parcel2 != null) {
                        OaidMonitor.parcelRecycle(parcel2);
                    }
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("binder for" + str + MsgSummary.STR_COLON + binder);
        }
        throw new IllegalArgumentException("extras: " + extras);
    }

    @SuppressLint({"NewApi"})
    private void onError(Intent intent, Throwable th5) {
        IBinder binder;
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Log.i(TAG, "Initialize failed: " + stringWriter2);
        Bundle extras = intent.getExtras();
        if (extras == null || (binder = extras.getBinder(IX5ChildProcessService.ERROR_CALLBACK_KEY)) == null) {
            return;
        }
        Parcel parcel = null;
        try {
            try {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeString(stringWriter2);
                    OaidMonitor.binderTransact(binder, 1, obtain, null, 0);
                    OaidMonitor.parcelRecycle(obtain);
                } catch (RemoteException e16) {
                    e = e16;
                    parcel = obtain;
                    Log.i(TAG, "Send error message failed", e);
                    e.printStackTrace();
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    parcel = obtain;
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                    throw th;
                }
            } catch (RemoteException e17) {
                e = e17;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private byte[] readDexFile(FileDescriptor fileDescriptor) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(fileDescriptor)));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                zipInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            if (nextEntry.getName().equals("classes.dex")) {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            zipInputStream.closeEntry();
        }
    }

    public static boolean safeGetBooleanExtra(Intent intent, String str, boolean z16) {
        try {
            return intent.getBooleanExtra(str, z16);
        } catch (Throwable unused) {
            Log.e(TAG, "getBooleanExtra failed on intent " + intent);
            return z16;
        }
    }

    public static String[] safeGetStringArrayExtra(Intent intent, String str) {
        try {
            return intent.getStringArrayExtra(str);
        } catch (Throwable unused) {
            Log.e(TAG, "getStringArrayExtra failed on intent " + intent);
            return null;
        }
    }

    public static void setChildProcessDelegate(ChildProcessDelegate childProcessDelegate) {
        sDelegate = childProcessDelegate;
    }

    @SuppressLint({"NewApi"})
    protected ClassLoader createClassLoaderFromFD(Intent intent) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptor = getParcelFileDescriptor(intent, IX5ChildProcessService.ENTRY_DEX_FD_KEY);
        try {
            byte[] readDexFile = readDexFile(parcelFileDescriptor.getFileDescriptor());
            closeQuietly(parcelFileDescriptor);
            return new InMemoryDexClassLoader(ByteBuffer.wrap(readDexFile), ChildProcessService.class.getClassLoader());
        } catch (Throwable th5) {
            closeQuietly(parcelFileDescriptor);
            throw th5;
        }
    }

    protected ClassLoader createClassLoaderFromPath(Intent intent) throws Throwable {
        String str;
        String stringExtra = intent.getStringExtra(IX5ChildProcessService.INSTALLATION_DIRECTORY_KEY);
        String stringExtra2 = intent.getStringExtra(IX5ChildProcessService.ENTRY_DEX_FILE_KEY);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            File file = new File(stringExtra, stringExtra2);
            String absolutePath = file.getAbsolutePath();
            if (file.exists()) {
                file.setReadOnly();
                boolean safeGetBooleanExtra = safeGetBooleanExtra(intent, IX5ChildProcessService.DISABLE_SEALED_CLASSLOADER_KEY, false);
                String[] safeGetStringArrayExtra = safeGetStringArrayExtra(intent, IX5ChildProcessService.UNSEALED_PACKAGES_KEY);
                ApplicationInfo applicationInfo = getApplicationInfo();
                if (applicationInfo != null) {
                    str = DexLoader.getPrivateDexFilePath(absolutePath, applicationInfo.targetSdkVersion);
                } else {
                    str = absolutePath;
                }
                if (safeGetBooleanExtra) {
                    return new DexClassLoader(str, stringExtra, stringExtra, ChildProcessService.class.getClassLoader());
                }
                return new SealedDexClassLoader(str, stringExtra, stringExtra, ChildProcessService.class.getClassLoader(), safeGetStringArrayExtra);
            }
            throw new FileNotFoundException(absolutePath);
        }
        throw new IllegalArgumentException("installationDirectory: " + stringExtra + ", dexFile: " + stringExtra2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        if (sDelegate != null && intent.hasExtra(IX5ChildProcessService.CRASH_RECORD_FD0_KEY) && intent.hasExtra(IX5ChildProcessService.CRASH_RECORD_FD1_KEY)) {
            try {
                sDelegate.onReceiveCrashRecordFileDescriptors(getParcelFileDescriptor(intent, IX5ChildProcessService.CRASH_RECORD_FD0_KEY), getParcelFileDescriptor(intent, IX5ChildProcessService.CRASH_RECORD_FD1_KEY));
            } catch (Throwable th5) {
                Log.i(TAG, "Set crash record file descriptors failed", th5);
                th5.printStackTrace();
            }
        }
        try {
            if (this.mService == null) {
                Log.i(TAG, "Initialize ...");
                String stringExtra = intent.getStringExtra(IX5ChildProcessService.ENTRY_CLASS_NAME_KEY);
                if (!TextUtils.isEmpty(stringExtra)) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    ClassLoader onCreateClassLoader = onCreateClassLoader(intent);
                    Log.i(TAG, "Created " + onCreateClassLoader + ", cost " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                    this.mService = (IX5ChildProcessService) onCreateClassLoader.loadClass(stringExtra).newInstance();
                    Log.i(TAG, "Initialize success");
                    this.mService.onCreate(this, intent);
                } else {
                    throw new IllegalArgumentException("className: " + stringExtra);
                }
            }
            return this.mService.onBind(this, intent);
        } catch (Throwable th6) {
            onError(intent, th6);
            throw new RuntimeException(th6);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.i(TAG, "onCreate");
        IX5ChildProcessService iX5ChildProcessService = this.mService;
        if (iX5ChildProcessService != null) {
            iX5ChildProcessService.onCreate(this, null);
        }
    }

    protected ClassLoader onCreateClassLoader(Intent intent) throws Throwable {
        if (intent.hasExtra(IX5ChildProcessService.ENTRY_DEX_FD_KEY)) {
            return createClassLoaderFromFD(intent);
        }
        return createClassLoaderFromPath(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        IX5ChildProcessService iX5ChildProcessService = this.mService;
        if (iX5ChildProcessService != null) {
            iX5ChildProcessService.onDestroy(this);
            this.mService = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        return 2;
    }
}
