package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EngineInstaller {
    public static final String LOG_TAG = "EngineInstaller";
    private static final String ROOT_DIR = "/xminilib/";
    private static String SP_NAME = "x_mini_engine";
    private static volatile List<InstalledEngine> sInstalledEngine;
    private static File sRootDir;
    private boolean isWorking = false;
    private List<Callback> mCallbacks = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Callback {
        void onEngineWorkAbort();

        void onEngineWorkBegin();

        void onEngineWorkFinish();

        void onMessageUpdate(float f16, String str);
    }

    private static synchronized String getInstallLibDir(File file, EngineVersion engineVersion) {
        synchronized (EngineInstaller.class) {
            File file2 = new File(file, engineVersion.toFolderName());
            QMLog.i("EngineInstaller", "[MiniEng]getInstallLibDir " + file2.getAbsolutePath());
            if (!file2.exists() && !file2.mkdirs()) {
                QMLog.e("EngineInstaller", "[MiniEng] getInstallLibDir failed, is disk writable? " + file2.getAbsolutePath());
                return null;
            }
            return file2.getAbsolutePath();
        }
    }

    public static synchronized ArrayList<InstalledEngine> getInstalledEngine(int i3) {
        ArrayList<InstalledEngine> arrayList;
        synchronized (EngineInstaller.class) {
            updateInstalledEngine();
            arrayList = new ArrayList<>();
            for (InstalledEngine installedEngine : sInstalledEngine) {
                if (installedEngine.engineType == i3) {
                    arrayList.add(installedEngine);
                }
            }
        }
        return arrayList;
    }

    private static File getRootDir() {
        if (sRootDir == null) {
            File file = new File(AppLoaderFactory.g().getContext().getFilesDir().getPath() + ROOT_DIR);
            if (!file.exists() && !file.mkdirs()) {
                QMLog.e("EngineInstaller", "[MiniEng] dir mk failed " + file);
            }
            sRootDir = file;
        }
        return sRootDir;
    }

    public static SharedPreferences getSp() {
        return AppLoaderFactory.g().getContext().getSharedPreferences(SP_NAME, 0);
    }

    private boolean handleUnZipResult(String str, EngineVersion engineVersion, String str2, boolean z16, String str3, int i3) {
        if (i3 == 0) {
            try {
                LockMethodProxy.sleep(100L);
            } catch (InterruptedException unused) {
            }
            updateMessage(1.0f, "\u6b63\u5728\u6821\u9a8c\u5f15\u64ce");
            try {
                LockMethodProxy.sleep(100L);
            } catch (InterruptedException unused2) {
            }
            QMLog.i("EngineInstaller", "[MiniEng]unZip succeed. url:" + str + ", version:" + engineVersion + ",unzipPath:" + str3);
            getSp().edit().putBoolean(str3, true).commit();
            updateInstalledEngine();
            return true;
        }
        QMLog.i("EngineInstaller", "[MiniEng]unZip failed. url:" + str + ", version:" + engineVersion + ",unzipPath:" + str3);
        FileUtils.delete(str3, false);
        updateMessage(0.0f, "\u5f15\u64ce\u89e3\u538b\u7f29\u5931\u8d25");
        return z16;
    }

    private void installFromAssets(String str, String str2, long j3, long j16) {
        synchronized (EngineInstaller.class) {
            updateMessage(0.0f, "\u6b63\u5728\u89e3\u538b\u7f29\u672c\u5730\u5f15\u64ce");
            QMLog.i("EngineInstaller", "[MiniEng] installLocalEngine start url=" + str + ",installBasePath=" + str2);
            if (TextUtils.isEmpty(str2)) {
                updateMessage(0.0f, "\u672c\u5730\u5f15\u64ce\u5b89\u88c5\u5931\u8d25, \u76ee\u5f55\u4e3a\u7a7a");
                QMLog.e("EngineInstaller", "[MiniEng] installLocalEngine failed installBasePath=" + str2);
                workFinish();
                return;
            }
            File file = new File(str2);
            if (!file.exists() && !file.mkdir()) {
                updateMessage(0.0f, "\u672c\u5730\u5f15\u64ce\u5b89\u88c5\u5931\u8d25, \u521b\u5efa\u76ee\u5f55\u5931\u8d25");
                QMLog.e("EngineInstaller", "[MiniEng] installLocalEngine failed targetPath=" + file);
                workFinish();
                return;
            }
            BaseLibManager.g().installMiniGameInnerJsLib();
            QMLog.i("EngineInstaller", "[MiniEng] installLocalEngine finish copied " + j16 + "<>" + j3);
            if (j16 != j3 && j3 >= 0) {
                updateMessage(0.0f, "\u672c\u5730\u5f15\u64ce\u5b89\u88c5\u5931\u8d25");
                workFinish();
            }
            getSp().edit().putBoolean(str2, true).commit();
            updateInstalledEngine();
            updateMessage(1.0f, "\u672c\u5730\u5f15\u64ce\u5b89\u88c5\u5b8c\u6210");
            workFinish();
        }
    }

    private void installedFromNetwork(BaseLibInfo baseLibInfo, String str, long j3, File file, EngineVersion engineVersion, boolean z16) {
        String str2 = AppLoaderFactory.g().getContext().getCacheDir() + File.separator + UUID.randomUUID() + ".zip";
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(str, null, str2, 60, new a(str, baseLibInfo, str2, j3, file, engineVersion, z16));
        if (baseLibInfo.baseLibType == 2) {
            MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, "1");
        }
    }

    private static boolean isCurrentPersistGameEngine(File file) {
        EngineVersion fromFolderName = EngineVersion.fromFolderName(file.getName());
        if (fromFolderName != null && fromFolderName.equals(LocalGameEngine.g().mLocalEngineVersion) && isPersistGameEngine(file)) {
            return true;
        }
        return false;
    }

    private static boolean isPersistGameEngine(File file) {
        if (file == null || !file.exists() || !file.isDirectory() || file.listFiles() == null) {
            return false;
        }
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.qqmini.sdk.manager.EngineInstaller.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.endsWith(".so") || str.endsWith(QZonePatchService.PATCH_SUFFIX)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            return false;
        }
        return true;
    }

    public static synchronized void removeEngine(InstalledEngine installedEngine) {
        synchronized (EngineInstaller.class) {
            if (installedEngine == null) {
                return;
            }
            QMLog.i("EngineInstaller", "[MiniEng] removeEngine " + installedEngine);
            installedEngine.deleteFiles();
            sInstalledEngine.remove(installedEngine);
        }
    }

    public static synchronized void removeOldEngine(int i3) {
        synchronized (EngineInstaller.class) {
            if (sInstalledEngine == null) {
                QMLog.e("EngineInstaller", "[MiniEng]removeOldEngine null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (InstalledEngine installedEngine : sInstalledEngine) {
                if (installedEngine.engineType == i3) {
                    arrayList.add(installedEngine);
                }
            }
            int size = arrayList.size();
            boolean z16 = true;
            for (int i16 = 0; size > 1 && i16 < size; i16++) {
                InstalledEngine installedEngine2 = (InstalledEngine) arrayList.get(i16);
                if (installedEngine2.isPersist) {
                    QMLog.i("EngineInstaller", "[MiniEng] removeOldEngine " + installedEngine2 + " isPersist, so not deleted");
                } else {
                    if (!z16) {
                        installedEngine2.deleteFiles();
                        sInstalledEngine.remove(installedEngine2);
                    } else {
                        QMLog.i("EngineInstaller", "[MiniEng] removeOldEngine " + installedEngine2 + "  is latest, so kept");
                    }
                    z16 = false;
                }
            }
        }
    }

    public static synchronized void removeOutDatedEngine(int i3) {
        EngineVersion engineVersion;
        synchronized (EngineInstaller.class) {
            if (sInstalledEngine == null) {
                QMLog.e("EngineInstaller", "[MiniEng]removeOutDatedEngine null");
                return;
            }
            ArrayList<InstalledEngine> arrayList = new ArrayList();
            for (InstalledEngine installedEngine : sInstalledEngine) {
                if (installedEngine.engineType == i3) {
                    arrayList.add(installedEngine);
                }
            }
            if (i3 == 2) {
                engineVersion = LocalGameEngine.g().mLocalEngineVersion;
            } else {
                engineVersion = null;
            }
            if (engineVersion != null) {
                for (InstalledEngine installedEngine2 : arrayList) {
                    if (installedEngine2.engineVersion.compareTo(engineVersion) < 0) {
                        QMLog.i("EngineInstaller", "[MiniEng] removeOutDatedEngine " + installedEngine2 + " localMinVer:" + engineVersion + ",engineType:" + i3);
                        installedEngine2.deleteFiles();
                        sInstalledEngine.remove(installedEngine2);
                    } else if (installedEngine2.isPersist && !isCurrentPersistGameEngine(new File(installedEngine2.engineDir))) {
                        QMLog.i("EngineInstaller", "[MiniEng] removeOutDatedPersistEngine " + installedEngine2 + " localMinVer:" + engineVersion + ",engineType:" + i3);
                        installedEngine2.deleteFiles();
                        sInstalledEngine.remove(installedEngine2);
                    }
                }
            }
        }
    }

    private static synchronized List<InstalledEngine> scanInstalledEngine() {
        ArrayList arrayList;
        InstalledEngine installedEngine;
        EngineVersion fromFolderName;
        synchronized (EngineInstaller.class) {
            QMLog.i("EngineInstaller", "[MiniEng] scanInstalledEngine");
            long currentTimeMillis = System.currentTimeMillis();
            arrayList = new ArrayList();
            File rootDir = getRootDir();
            if (rootDir.exists() && rootDir.isDirectory() && rootDir.listFiles() != null) {
                for (File file : rootDir.listFiles()) {
                    if (file.exists() && file.isDirectory() && file.listFiles() != null) {
                        try {
                            int parseInt = Integer.parseInt(file.getName());
                            for (final File file2 : file.listFiles()) {
                                try {
                                    installedEngine = new InstalledEngine();
                                    installedEngine.engineType = parseInt;
                                    fromFolderName = EngineVersion.fromFolderName(file2.getName());
                                    installedEngine.engineVersion = fromFolderName;
                                } catch (Exception e16) {
                                    QMLog.i("EngineInstaller", "[MiniEng]delete " + file2.getAbsolutePath() + DebugUtil.getPrintableStackTrace(e16));
                                    ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.EngineInstaller.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            FileUtils.delete(file2.getAbsolutePath(), false);
                                        }
                                    });
                                }
                                if (fromFolderName != null) {
                                    installedEngine.engineDir = file2.getAbsolutePath();
                                    boolean verifyEngine = verifyEngine(installedEngine);
                                    installedEngine.isVerify = verifyEngine;
                                    if (verifyEngine) {
                                        int i3 = installedEngine.engineType;
                                        if (i3 == 2) {
                                            installedEngine.engineName = "MiniGame";
                                            installedEngine.isPersist = isPersistGameEngine(file2);
                                        } else if (i3 == 3) {
                                            installedEngine.engineName = "MiniApp";
                                        }
                                        arrayList.add(installedEngine);
                                    } else {
                                        throw new IllegalStateException("engine verify failed");
                                    }
                                } else {
                                    throw new IllegalStateException("unrecognized engine " + file2.getName());
                                }
                            }
                        } catch (Exception unused) {
                            continue;
                        }
                    }
                }
            }
            Collections.sort(arrayList, Collections.reverseOrder());
            QMLog.i("EngineInstaller", "[MiniEng] scanInstalledEngine finish timecost=" + (System.currentTimeMillis() - currentTimeMillis) + ", found " + arrayList.size());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean unzipEngine(File file, String str, EngineVersion engineVersion, String str2, boolean z16) {
        String installLibDir;
        boolean z17 = false;
        try {
            try {
                installLibDir = getInstallLibDir(file, engineVersion);
            } catch (Exception e16) {
                QMLog.e("EngineInstaller", "[MiniEng] installEngine failed, unzip failed?" + e16 + DebugUtil.getPrintableStackTrace(e16));
                updateMessage(0.0f, "\u5f15\u64ce\u5b89\u88c5\u5f02\u5e38");
                FileUtils.delete(str2, true);
            }
            if (installLibDir == null) {
                workFinish();
                return false;
            }
            if (new File(installLibDir).exists()) {
                FileUtils.delete(installLibDir, false);
            }
            updateMessage(1.0f, "\u6b63\u5728\u89e3\u538b\u7f29\u5f15\u64ce");
            z17 = handleUnZipResult(str, engineVersion, str2, false, installLibDir, ZipUtil.unZipFolder(str2, installLibDir));
            FileUtils.delete(str2, true);
            if (z17) {
                if (z16) {
                    updateMessage(1.0f, "\u5f15\u64ce\u66f4\u65b0\u5b8c\u6210");
                } else {
                    updateMessage(1.0f, "\u5f15\u64ce\u5b89\u88c5\u5b8c\u6210");
                }
                try {
                    LockMethodProxy.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
            workFinish();
            return z17;
        } finally {
            FileUtils.delete(str2, true);
            workFinish();
        }
    }

    public static synchronized void updateInstalledEngine() {
        synchronized (EngineInstaller.class) {
            sInstalledEngine = scanInstalledEngine();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMessage(float f16, String str) {
        for (Callback callback : this.mCallbacks) {
            if (callback != null) {
                callback.onMessageUpdate(f16, str);
            }
        }
    }

    private static boolean verifyEngine(InstalledEngine installedEngine) {
        boolean z16 = false;
        if (getSp() != null) {
            z16 = getSp().getBoolean(installedEngine.engineDir, false);
        }
        QMLog.i("EngineInstaller", "[MiniEng]verifyEngine " + installedEngine.engineDir + " " + z16);
        return z16;
    }

    private synchronized void workAbort() {
        for (Callback callback : this.mCallbacks) {
            if (callback != null) {
                callback.onEngineWorkAbort();
            }
        }
    }

    private synchronized void workBegin() {
        this.isWorking = true;
        for (Callback callback : this.mCallbacks) {
            if (callback != null) {
                callback.onEngineWorkBegin();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void workFinish() {
        this.isWorking = false;
        for (Callback callback : new ArrayList(this.mCallbacks)) {
            if (callback != null) {
                callback.onEngineWorkFinish();
            }
        }
    }

    public synchronized void addCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    public synchronized void installWithCallback(BaseLibInfo baseLibInfo, Callback callback) {
        boolean z16;
        long[] jArr;
        boolean z17;
        String str = baseLibInfo.baseLibUrl;
        if (callback != null) {
            addCallback(callback);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(baseLibInfo.baseLibVersion) && baseLibInfo.baseLibType > 0) {
            File file = new File(getRootDir(), String.valueOf(baseLibInfo.baseLibType));
            try {
                JSONObject jSONObject = new JSONObject(baseLibInfo.baseLibDesc);
                EngineVersion engineVersion = new EngineVersion(baseLibInfo.baseLibVersion);
                long optLong = jSONObject.optLong("file_length", -1L);
                QMLog.w("EngineInstaller", "[MiniEng] installWithCallback " + baseLibInfo);
                if (getSp() == null) {
                    QMLog.w("EngineInstaller", "[MiniEng] shared preference not supported");
                    workAbort();
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    QMLog.e("EngineInstaller", "[MiniEng] empty engine url");
                    workAbort();
                    return;
                }
                if (isWorking()) {
                    QMLog.i("EngineInstaller", "[MiniEng] downloading already in progress");
                    workAbort();
                    return;
                }
                QMLog.i("EngineInstaller", "[MiniEng] installWithCallback callback=" + callback);
                if (baseLibInfo.baseLibType == 2 && !LocalGameEngine.g().isDisabled() && !baseLibInfo.baseLibUrl.startsWith("assets://")) {
                    EngineVersion engineVersion2 = LocalGameEngine.g().mLocalEngineVersion;
                    if (engineVersion2.compareTo(engineVersion) >= 0) {
                        QMLog.i("EngineInstaller", "[MiniEng] refuse install remote baselib:" + engineVersion + ",local:" + engineVersion2);
                        workAbort();
                        return;
                    }
                }
                ArrayList<InstalledEngine> installedEngine = getInstalledEngine(baseLibInfo.baseLibType);
                QMLog.i("EngineInstaller", "[MiniEng] engineForType " + baseLibInfo.baseLibType + ", size=" + installedEngine.size());
                if (installedEngine.size() > 0) {
                    InstalledEngine installedEngine2 = installedEngine.get(0);
                    QMLog.i("EngineInstaller", "[MiniEng]latest engine for type " + baseLibInfo.baseLibType + "," + installedEngine2);
                    if (installedEngine2.engineVersion.compareTo(engineVersion) >= 0) {
                        QMLog.i("EngineInstaller", "[MiniEng]engine type " + baseLibInfo.baseLibType + " has no update, remote:" + engineVersion + ",latest:" + installedEngine2);
                        workAbort();
                        return;
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                workBegin();
                if (z16) {
                    updateMessage(0.0f, "\u66f4\u65b0\u5f15\u64ce(" + baseLibInfo.baseLibVersion + ")");
                } else {
                    updateMessage(0.0f, "\u4e0b\u8f7d\u5f15\u64ce(" + baseLibInfo.baseLibVersion + ")");
                }
                QMLog.i("EngineInstaller", "[MiniEng] installEngine " + str);
                if (!file.exists() && !file.mkdirs()) {
                    QMLog.i("EngineInstaller", "[MiniEng] mkdir failed, is disk writable? " + file.getAbsolutePath());
                    workFinish();
                    return;
                }
                if (baseLibInfo.baseLibType == 2) {
                    z17 = baseLibInfo.baseLibUrl.startsWith("assets://");
                    baseLibInfo.baseLibUrl.replace("assets://", "");
                    jArr = new long[]{0};
                } else {
                    jArr = null;
                    z17 = false;
                }
                if (z17) {
                    installFromAssets(str, getInstallLibDir(file, engineVersion), optLong, jArr[0]);
                } else {
                    installedFromNetwork(baseLibInfo, str, optLong, file, engineVersion, z16);
                }
                return;
            } catch (Exception e16) {
                QMLog.w("EngineInstaller", "[MiniEng] refuse installEngine " + baseLibInfo.baseLibDesc + ":" + baseLibInfo.baseLibVersion + baseLibInfo.baseLibUrl + DebugUtil.getPrintableStackTrace(e16));
                workAbort();
                return;
            }
        }
        QMLog.w("EngineInstaller", "[MiniEng] invalid BaseLibInfo " + baseLibInfo);
        workAbort();
    }

    public synchronized boolean isWorking() {
        return this.isWorking;
    }

    public synchronized void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements DownloaderProxy.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        private float f348110a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f348111b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseLibInfo f348112c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f348113d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f348114e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ File f348115f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ EngineVersion f348116g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f348117h;

        a(String str, BaseLibInfo baseLibInfo, String str2, long j3, File file, EngineVersion engineVersion, boolean z16) {
            this.f348111b = str;
            this.f348112c = baseLibInfo;
            this.f348113d = str2;
            this.f348114e = j3;
            this.f348115f = file;
            this.f348116g = engineVersion;
            this.f348117h = z16;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int i3, String str) {
            QMLog.i("EngineInstaller", "[MiniEng] onDownloadFailed " + this.f348111b);
            if (this.f348112c.baseLibType == 2) {
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, null, null, null, 1, "1", 0L, null);
            }
            EngineInstaller.this.workFinish();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
            if (f16 - this.f348110a > 0.05f) {
                this.f348110a = f16;
                EngineInstaller.this.updateMessage(f16, "\u6b63\u5728\u4e0b\u8f7d\u5f15\u64ce " + String.format(Locale.getDefault(), "%.1f", Float.valueOf(100.0f * f16)) + "%");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[MiniEng]onDownloadProgress, progress=");
                sb5.append(f16);
                QMLog.i("EngineInstaller", sb5.toString());
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
            int i16;
            QMLog.i("EngineInstaller", "[MiniEng] onDownloadSucceed " + this.f348111b);
            File file = new File(this.f348113d);
            long length = file.length();
            long j3 = this.f348114e;
            if (length != j3 && j3 > 0) {
                QMLog.i("EngineInstaller", "[MiniEng]refuse to unzip " + this.f348113d + " length=" + file.length() + ", mEngineFileSize=" + this.f348114e);
                EngineInstaller.this.workFinish();
                return;
            }
            QMLog.i("EngineInstaller", "[MiniEng] onDownloadSucceed length is match " + this.f348114e);
            EngineInstaller.this.updateMessage(1.0f, "\u6b63\u5728\u4e0b\u8f7d\u5f15\u64ce 100%");
            if (this.f348112c.baseLibType == 2) {
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, "1");
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 6, "1");
            }
            synchronized (EngineInstaller.class) {
                boolean unzipEngine = EngineInstaller.this.unzipEngine(this.f348115f, this.f348111b, this.f348116g, this.f348113d, this.f348117h);
                if (this.f348112c.baseLibType == 2) {
                    MiniAppInfo miniAppConfigForPreload = ReportConst.miniAppConfigForPreload();
                    if (unzipEngine) {
                        i16 = 0;
                    } else {
                        i16 = 1;
                    }
                    MiniReportManager.reportEventType(miniAppConfigForPreload, 7, null, null, null, i16, "1", 0L, null);
                }
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
        }
    }
}
