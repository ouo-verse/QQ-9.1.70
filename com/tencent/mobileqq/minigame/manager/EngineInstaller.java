package com.tencent.mobileqq.minigame.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.manager.AbstractDownloader;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.oskplayer.util.StorageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class EngineInstaller {
    public static final String LOG_TAG = "EngineInstaller";
    private static final String ROOT_DIR = "/xminilib/";
    private static String SP_NAME = "x_mini_engine";
    private static volatile List<InstalledEngine> sInstalledEngine;
    private static File sRootDir;
    private boolean isWorking = false;
    private List<Callback> mCallbacks = new ArrayList();
    private AbstractDownloader mDownloader;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface Callback {
        void onEngineWorkAbort();

        void onEngineWorkBegin();

        void onEngineWorkFinish();

        void onMessageUpdate(float f16, String str);
    }

    public EngineInstaller(AbstractDownloader abstractDownloader) {
        this.mDownloader = abstractDownloader;
    }

    private static synchronized String getInstallLibDir(File file, EngineVersion engineVersion) {
        synchronized (EngineInstaller.class) {
            File file2 = new File(file, engineVersion.toFolderName());
            QLog.i("EngineInstaller", 1, "[MiniEng]getInstallLibDir " + file2.getAbsolutePath());
            if (!file2.exists() && !file2.mkdirs()) {
                QLog.e("EngineInstaller", 1, "[MiniEng] getInstallLibDir failed, is disk writable? " + file2.getAbsolutePath());
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
            File file = new File(BaseApplicationImpl.getApplication().getFilesDir().getPath() + ROOT_DIR);
            if (!file.exists() && !file.mkdirs()) {
                QLog.e("EngineInstaller", 1, "[MiniEng] dir mk failed " + file);
            }
            sRootDir = file;
        }
        return sRootDir;
    }

    public static SharedPreferences getSp() {
        return BaseApplication.getContext().getSharedPreferences(SP_NAME, 0);
    }

    private static boolean isCurrentPersistGameEngine(File file) {
        EngineVersion fromFolderName = EngineVersion.fromFolderName(file.getName());
        return fromFolderName != null && fromFolderName.equals(LocalGameEngine.g().mLocalEngineVersion) && isPersistGameEngine(file);
    }

    public static synchronized void removeEngine(InstalledEngine installedEngine) {
        synchronized (EngineInstaller.class) {
            if (installedEngine == null) {
                return;
            }
            QLog.i("EngineInstaller", 1, "[MiniEng] removeEngine " + installedEngine);
            installedEngine.deleteFiles();
            sInstalledEngine.remove(installedEngine);
        }
    }

    public static synchronized void removeOldEngine(int i3) {
        synchronized (EngineInstaller.class) {
            if (sInstalledEngine == null) {
                QLog.e("EngineInstaller", 1, "[MiniEng]removeOldEngine null");
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
                    QLog.i("EngineInstaller", 1, "[MiniEng] removeOldEngine " + installedEngine2 + " isPersist, so not deleted");
                } else {
                    if (!z16) {
                        installedEngine2.deleteFiles();
                        sInstalledEngine.remove(installedEngine2);
                    } else {
                        QLog.i("EngineInstaller", 1, "[MiniEng] removeOldEngine " + installedEngine2 + "  is latest, so kept");
                    }
                    z16 = false;
                }
            }
        }
    }

    public static synchronized void removeOutDatedEngine(int i3) {
        synchronized (EngineInstaller.class) {
            if (sInstalledEngine == null) {
                QLog.e("EngineInstaller", 1, "[MiniEng]removeOutDatedEngine null");
                return;
            }
            ArrayList<InstalledEngine> arrayList = new ArrayList();
            for (InstalledEngine installedEngine : sInstalledEngine) {
                if (installedEngine.engineType == i3) {
                    arrayList.add(installedEngine);
                }
            }
            EngineVersion engineVersion = i3 == 2 ? LocalGameEngine.g().mLocalEngineVersion : null;
            if (engineVersion != null) {
                QLog.i("EngineInstaller", 1, "[MiniEng] removeOutDatedEngine, localMinVer:" + engineVersion);
                for (InstalledEngine installedEngine2 : arrayList) {
                    if (installedEngine2.engineVersion.compareTo(engineVersion) >= 0 && (i3 != 2 || installedEngine2.engineVersion.mMinor.compareTo(engineVersion.mMinor) >= 0)) {
                        if (installedEngine2.isPersist && !isCurrentPersistGameEngine(new File(installedEngine2.engineDir))) {
                            QLog.i("EngineInstaller", 1, "[MiniEng] removeOutDatedPersistEngine " + installedEngine2 + " localMinVer:" + engineVersion + ",engineType:" + i3);
                            installedEngine2.deleteFiles();
                            sInstalledEngine.remove(installedEngine2);
                        }
                    }
                    QLog.i("EngineInstaller", 1, "[MiniEng] removeOutDatedEngine " + installedEngine2 + " localMinVer:" + engineVersion + ",engineType:" + i3);
                    installedEngine2.deleteFiles();
                    sInstalledEngine.remove(installedEngine2);
                }
            } else {
                QLog.w("EngineInstaller", 1, "[MiniEng] removeOutDatedEngine, localMinVer is null");
            }
        }
    }

    private static synchronized List<InstalledEngine> scanInstalledEngine() {
        ArrayList arrayList;
        InstalledEngine installedEngine;
        EngineVersion fromFolderName;
        synchronized (EngineInstaller.class) {
            QLog.i("EngineInstaller", 1, "[MiniEng] scanInstalledEngine");
            long currentTimeMillis = System.currentTimeMillis();
            arrayList = new ArrayList();
            File rootDir = getRootDir();
            if (rootDir.exists() && rootDir.isDirectory() && rootDir.listFiles() != null) {
                for (File file : rootDir.listFiles()) {
                    if (file.exists() && file.isDirectory() && file.listFiles() != null) {
                        try {
                            int parseInt = Integer.parseInt(file.getName());
                            for (File file2 : file.listFiles()) {
                                QLog.d("scanInstalledEngine", 4, "f2: " + file2.getAbsolutePath());
                                try {
                                    installedEngine = new InstalledEngine();
                                    installedEngine.engineType = parseInt;
                                    fromFolderName = EngineVersion.fromFolderName(file2.getName());
                                    installedEngine.engineVersion = fromFolderName;
                                } catch (Exception e16) {
                                    QLog.i("EngineInstaller", 1, "[MiniEng]delete " + file2.getAbsolutePath() + DebugUtil.getPrintableStackTrace(e16));
                                    FileUtils.delete(file2.getAbsolutePath(), false);
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
            QLog.i("EngineInstaller", 1, "[MiniEng] scanInstalledEngine finish timecost=" + (System.currentTimeMillis() - currentTimeMillis) + ", found " + arrayList.size());
        }
        return arrayList;
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

    private boolean verifyBaselib(String str, String str2) {
        long uncompressedFileSize = ZipUtils.getUncompressedFileSize(str);
        if (uncompressedFileSize <= 0) {
            QLog.e("EngineInstaller", 1, "[MiniEng] getUncompressedFileSize error " + str + ", sz=" + uncompressedFileSize);
            return false;
        }
        long dirUsedSpace = StorageUtil.getDirUsedSpace(str2);
        if (dirUsedSpace <= 0) {
            QLog.e("EngineInstaller", 1, "[MiniEng] getDirUsedSpace error " + str2 + ", sz2=" + dirUsedSpace);
            return false;
        }
        if (uncompressedFileSize == dirUsedSpace) {
            getSp().edit().putBoolean(str2, true).commit();
            return true;
        }
        QLog.e("EngineInstaller", 1, "[MiniEng] verifyBaselib failed sz1=" + uncompressedFileSize + ", sz2=" + dirUsedSpace);
        return false;
    }

    private static boolean verifyEngine(InstalledEngine installedEngine) {
        boolean z16 = getSp() != null ? getSp().getBoolean(installedEngine.engineDir, false) : false;
        QLog.i("EngineInstaller", 1, "[MiniEng]verifyEngine " + installedEngine.engineDir + " " + z16);
        return z16;
    }

    private synchronized void workAbort() {
        for (Callback callback : new ArrayList(this.mCallbacks)) {
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

    public synchronized boolean isWorking() {
        return this.isWorking;
    }

    public synchronized void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }

    private void installedFromNetwork(final BaseLibInfo baseLibInfo, final String str, final long j3, final File file, final EngineVersion engineVersion, final boolean z16) {
        this.mDownloader.setUrl(str);
        this.mDownloader.setDownloadListener(new AbstractDownloader.DownloadListener() { // from class: com.tencent.mobileqq.minigame.manager.EngineInstaller.1
            private float lastProgress = 0.0f;

            @Override // com.tencent.mobileqq.minigame.manager.AbstractDownloader.DownloadListener
            public void onDownloadFailed(String str2) {
                QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadFailed " + str2);
                if (baseLibInfo.baseLibType == 2) {
                    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, null, null, null, 1, "1", 0L, null);
                }
                EngineInstaller.this.workFinish();
            }

            @Override // com.tencent.mobileqq.minigame.manager.AbstractDownloader.DownloadListener
            public void onDownloadProgress(String str2, float f16) {
                if (f16 - this.lastProgress > 0.05f) {
                    this.lastProgress = f16;
                    EngineInstaller.this.updateMessage(f16, HardCodeUtil.qqStr(R.string.f171953m94) + String.format(Locale.getDefault(), "%.1f", Float.valueOf(100.0f * f16)) + "%");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[MiniEng]onDownloadProgress, progress=");
                    sb5.append(f16);
                    QLog.i("EngineInstaller", 1, sb5.toString());
                }
            }

            @Override // com.tencent.mobileqq.minigame.manager.AbstractDownloader.DownloadListener
            public void onDownloadSucceed(String str2, String str3) {
                QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadSucceed " + str2);
                File file2 = new File(str3);
                long length = file2.length();
                long j16 = j3;
                if (length != j16 && j16 > 0) {
                    QLog.i("EngineInstaller", 1, "[MiniEng]refuse to unzip " + str3 + " length=" + file2.length() + ", mEngineFileSize=" + j3);
                    EngineInstaller.this.workFinish();
                    return;
                }
                QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadSucceed length is match " + j3);
                EngineInstaller.this.updateMessage(1.0f, HardCodeUtil.qqStr(R.string.m95));
                if (baseLibInfo.baseLibType == 2) {
                    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, "1");
                    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 6, "1");
                }
                synchronized (EngineInstaller.class) {
                    boolean unzipEngine = EngineInstaller.this.unzipEngine(file, str, engineVersion, str3, z16);
                    if (baseLibInfo.baseLibType == 2) {
                        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 7, null, null, null, unzipEngine ? 0 : 1, "1", 0L, null);
                    }
                }
            }

            @Override // com.tencent.mobileqq.minigame.manager.AbstractDownloader.DownloadListener
            public void onDownloadCanceled(String str2) {
                QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadCanceled");
                EngineInstaller.this.workFinish();
            }
        });
        try {
            LockMethodProxy.sleep(100L);
        } catch (InterruptedException unused) {
        }
        if (baseLibInfo.baseLibType == 2) {
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 4, "1");
        }
        this.mDownloader.download();
    }

    private static boolean isPersistGameEngine(File file) {
        if (file == null || !file.exists() || !file.isDirectory() || file.listFiles() == null) {
            return false;
        }
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.mobileqq.minigame.manager.EngineInstaller.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return str.endsWith(".so") || str.endsWith(QZonePatchService.PATCH_SUFFIX);
            }
        });
        return listFiles == null || listFiles.length <= 0;
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
                QLog.w("EngineInstaller", 1, "[MiniEng] installWithCallback " + baseLibInfo);
                if (!AppUtil.isMainProcess()) {
                    QLog.w("EngineInstaller", 1, "[MiniEng] download triggered at wrong process");
                    workAbort();
                    return;
                }
                if (getSp() == null) {
                    QLog.w("EngineInstaller", 1, "[MiniEng] shared preference not supported");
                    workAbort();
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    QLog.e("EngineInstaller", 1, "[MiniEng] empty engine url");
                    workAbort();
                    return;
                }
                if (isWorking()) {
                    QLog.i("EngineInstaller", 1, "[MiniEng] downloading already in progress");
                    workAbort();
                    return;
                }
                QLog.i("EngineInstaller", 1, "[MiniEng] installWithCallback callback=" + callback);
                if (baseLibInfo.baseLibType == 2 && !LocalGameEngine.g().isDisabled() && !baseLibInfo.baseLibUrl.startsWith("assets://")) {
                    EngineVersion engineVersion2 = LocalGameEngine.g().mLocalEngineVersion;
                    if (engineVersion2.compareTo(engineVersion) >= 0) {
                        QLog.i("EngineInstaller", 1, "[MiniEng] refuse install remote baselib:" + engineVersion + ",local:" + engineVersion2);
                        workAbort();
                        return;
                    }
                }
                ArrayList<InstalledEngine> installedEngine = getInstalledEngine(baseLibInfo.baseLibType);
                QLog.i("EngineInstaller", 1, "[MiniEng] engineForType " + baseLibInfo.baseLibType + ", size=" + installedEngine.size());
                if (installedEngine.size() > 0) {
                    InstalledEngine installedEngine2 = installedEngine.get(0);
                    QLog.i("EngineInstaller", 1, "[MiniEng]latest engine for type " + baseLibInfo.baseLibType + "," + installedEngine2);
                    if (installedEngine2.engineVersion.compareTo(engineVersion) >= 0) {
                        QLog.i("EngineInstaller", 1, "[MiniEng]engine type " + baseLibInfo.baseLibType + " has no update, remote:" + engineVersion + ",latest:" + installedEngine2);
                        workAbort();
                        return;
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                workBegin();
                if (z16) {
                    updateMessage(0.0f, HardCodeUtil.qqStr(R.string.m8y) + baseLibInfo.baseLibVersion + ")");
                } else {
                    updateMessage(0.0f, HardCodeUtil.qqStr(R.string.f171952m93) + baseLibInfo.baseLibVersion + ")");
                }
                QLog.i("EngineInstaller", 1, "[MiniEng] installEngine " + str);
                if (!file.exists() && !file.mkdirs()) {
                    QLog.i("EngineInstaller", 1, "[MiniEng] mkdir failed, is disk writable? " + file.getAbsolutePath());
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
                    synchronized (EngineInstaller.class) {
                        updateMessage(0.0f, HardCodeUtil.qqStr(R.string.m8z));
                        String installLibDir = getInstallLibDir(file, engineVersion);
                        QLog.i("EngineInstaller", 1, "[MiniEng] installLocalEngine start url=" + str + ",installBasePath=" + installLibDir);
                        if (TextUtils.isEmpty(installLibDir)) {
                            updateMessage(0.0f, HardCodeUtil.qqStr(R.string.m9_));
                            QLog.e("EngineInstaller", 1, "[MiniEng] installLocalEngine failed installBasePath=" + installLibDir);
                            workFinish();
                            return;
                        }
                        File file2 = new File(installLibDir);
                        if (!file2.exists() && !file2.mkdir()) {
                            updateMessage(0.0f, HardCodeUtil.qqStr(R.string.f171951m92));
                            QLog.e("EngineInstaller", 1, "[MiniEng] installLocalEngine failed targetPath=" + file2);
                            workFinish();
                            return;
                        }
                        BaseLibManager.g().installMiniGameInnerJsLib();
                        QLog.i("EngineInstaller", 1, "[MiniEng] installLocalEngine finish copied " + jArr[0] + "<>" + optLong);
                        if (jArr[0] != optLong && optLong >= 0) {
                            updateMessage(0.0f, HardCodeUtil.qqStr(R.string.m98));
                            workFinish();
                        }
                        getSp().edit().putBoolean(installLibDir, true).commit();
                        updateInstalledEngine();
                        updateMessage(1.0f, HardCodeUtil.qqStr(R.string.m8x));
                        workFinish();
                    }
                } else {
                    installedFromNetwork(baseLibInfo, str, optLong, file, engineVersion, z16);
                }
                return;
            } catch (Exception e16) {
                QLog.w("EngineInstaller", 1, "[MiniEng] refuse installEngine " + baseLibInfo.baseLibDesc + ":" + baseLibInfo.baseLibVersion + baseLibInfo.baseLibUrl + DebugUtil.getPrintableStackTrace(e16));
                workAbort();
                return;
            }
        }
        QLog.w("EngineInstaller", 1, "[MiniEng] invalid BaseLibInfo " + baseLibInfo);
        workAbort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean unzipEngine(File file, String str, EngineVersion engineVersion, String str2, boolean z16) {
        String installLibDir;
        boolean verifyBaselib;
        boolean z17 = false;
        try {
            try {
                installLibDir = getInstallLibDir(file, engineVersion);
            } catch (Exception e16) {
                QLog.e("EngineInstaller", 1, "[MiniEng] installEngine failed, unzip failed?" + e16 + DebugUtil.getPrintableStackTrace(e16));
                updateMessage(0.0f, HardCodeUtil.qqStr(R.string.m99));
                FileUtils.delete(str2, true);
            }
            if (installLibDir == null) {
                workFinish();
                return false;
            }
            if (new File(installLibDir).exists()) {
                FileUtils.delete(installLibDir, false);
            }
            updateMessage(1.0f, HardCodeUtil.qqStr(R.string.f171949m90));
            int unZipFolder = ZipUtils.unZipFolder(str2, installLibDir);
            if (unZipFolder == 0) {
                try {
                    LockMethodProxy.sleep(100L);
                } catch (InterruptedException unused) {
                }
                updateMessage(1.0f, HardCodeUtil.qqStr(R.string.m97));
                try {
                    LockMethodProxy.sleep(100L);
                } catch (InterruptedException unused2) {
                }
                verifyBaselib = verifyBaselib(str2, installLibDir);
            } else {
                verifyBaselib = true;
            }
            if (unZipFolder == 0 && verifyBaselib) {
                QLog.i("EngineInstaller", 1, "[MiniEng]unZip succeed. url:" + str + ", version:" + engineVersion + ",unzipPath:" + installLibDir);
                updateInstalledEngine();
                z17 = true;
            } else {
                QLog.i("EngineInstaller", 1, "[MiniEng]unZip failed. url:" + str + ", version:" + engineVersion + ",unzipPath:" + installLibDir);
                FileUtils.delete(installLibDir, false);
                if (unZipFolder != 0) {
                    updateMessage(0.0f, HardCodeUtil.qqStr(R.string.m8w));
                } else if (!verifyBaselib) {
                    updateMessage(0.0f, HardCodeUtil.qqStr(R.string.m96));
                }
            }
            FileUtils.delete(str2, true);
            if (z17) {
                if (z16) {
                    updateMessage(1.0f, HardCodeUtil.qqStr(R.string.m8v));
                } else {
                    updateMessage(1.0f, HardCodeUtil.qqStr(R.string.f171950m91));
                }
                try {
                    LockMethodProxy.sleep(100L);
                } catch (InterruptedException unused3) {
                }
            }
            workFinish();
            return z17;
        } finally {
            FileUtils.delete(str2, true);
            workFinish();
        }
    }
}
