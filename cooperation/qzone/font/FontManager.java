package cooperation.qzone.font;

import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.VasFontIPCModule;
import com.etrump.mixlayout.o;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.lyric.util.e;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.NetworkState;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.io.FileFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class FontManager {
    public static final String FONT_DOWN_LOAD_RUL = "https://qzonestyle.gtimg.cn/qzone/space_item/qzone_act/ziti/HYMiaoXJJF.zip";
    public static final int FONT_ID = 1000;
    public static final String FONT_SUFFIX_FTF = ".ftf";
    public static final String FONT_SUFFIX_TTF = ".ttf";
    static final String TAG = "FontManager";
    private static FileCacheService mFileCache;
    private static final e<FontManager, Void> sSingleton = new e<FontManager, Void>() { // from class: cooperation.qzone.font.FontManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.lyric.util.e
        public FontManager create(Void r16) {
            return new FontManager();
        }
    };
    private ConcurrentHashMap<Integer, ArrayList<DownLoadFontTask>> downloadingFontIDs;
    private String fontDir;
    private String fontDownloadDir;
    private String processName;
    private ConcurrentHashMap<Integer, FontInfo> catchFontInfoMap = new ConcurrentHashMap<>();
    private FileFilter fontFilter = new FileFilter() { // from class: cooperation.qzone.font.FontManager.5
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            return name.endsWith(FontManager.FONT_SUFFIX_FTF) || name.endsWith(".ttf");
        }
    };
    private FileFilter fullTypeFilter = new FileFilter() { // from class: cooperation.qzone.font.FontManager.6
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(FontManager.FONT_SUFFIX_FTF);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class DownLoadFontTask {
        String extend;
        int fontID;
        int fontType;
        WeakReference<FontInterface.FontResult> result;

        DownLoadFontTask() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private interface FontType {
        public static final int FullType = 0;
        public static final int TrueType = 1;
    }

    public FontManager() {
        loadFontInfo();
        ThreadManagerV2.init();
    }

    private void addDownloadTask(final int i3, final String str, final int i16, final String str2, final FontInterface.FontResult fontResult) {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.font.FontManager.3
            @Override // java.lang.Runnable
            public void run() {
                FontInterface.FontResult fontResult2;
                File file = new File(FontManager.this.getFontPath(i3, i16));
                if (file.exists()) {
                    if (fontResult != null) {
                        FontManager.i().updateLruFile(file.getAbsolutePath(), true);
                        fontResult.result(i3, file.getAbsolutePath(), str2);
                        return;
                    }
                } else if (i16 == 1) {
                    File file2 = new File(FontManager.this.getFontPath(i3, 0));
                    if (file2.exists()) {
                        String fontPath = FontManager.this.getFontPath(i3, 1);
                        if (FontManager.this.convertFontFile(file2.getAbsolutePath(), fontPath)) {
                            FontInterface.FontResult fontResult3 = fontResult;
                            if (fontResult3 != null) {
                                fontResult3.result(i3, fontPath, str2);
                                return;
                            }
                            return;
                        }
                    }
                }
                if (FontManager.this.doRealDownload(i3, str, i16, str2, fontResult) || (fontResult2 = fontResult) == null) {
                    return;
                }
                fontResult2.result(i3, null, str2);
            }
        }, 8, null, false);
    }

    private void addFontInfoToCatch(int i3) {
        this.catchFontInfoMap.put(Integer.valueOf(i3), new FontInfo(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackResult(int i3) {
        ArrayList<DownLoadFontTask> remove;
        ConcurrentHashMap<Integer, ArrayList<DownLoadFontTask>> concurrentHashMap = this.downloadingFontIDs;
        if (concurrentHashMap == null) {
            return;
        }
        synchronized (concurrentHashMap) {
            remove = this.downloadingFontIDs.remove(Integer.valueOf(i3));
        }
        if (remove == null) {
            return;
        }
        Iterator<DownLoadFontTask> it = remove.iterator();
        while (it.hasNext()) {
            DownLoadFontTask next = it.next();
            FontInterface.FontResult fontResult = next.result.get();
            if (fontResult != null) {
                fontResult.result(i3, getFontPathIfExist(i3, next.fontType), next.extend);
            }
        }
    }

    private boolean checkFontIDValidity(int i3) {
        if (i3 > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean convertFontFile(String str, String str2) {
        boolean z16;
        boolean z17 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str2 + "." + getProcessName() + ".tmp";
            try {
                ETEngine.getInstanceForSpace();
                z16 = ETEngine.native_ftf2ttf(str, str3);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "call native_ftf2ttf error, errMsg = " + th5.toString());
                z16 = false;
            }
            if (z16) {
                File file = new File(str3);
                File file2 = new File(str2);
                if (!file2.exists()) {
                    z16 = file.renameTo(file2);
                }
                if (z16) {
                    if (com.tencent.mobileqq.vas.updatesystem.api.a.f311148a.a(str2, str, str3)) {
                        getFileCache().updateLruFile(str2, true);
                    }
                    VasCommonReporter.newReport("qzone_ttf").setNum1(z17 ? 1L : 0L).setNum2(file2.length()).setValue1(file2.getName()).report(z17);
                    z16 = z17;
                } else {
                    QLog.e(TAG, 1, "failed to move trueType font file, from path = " + file.getAbsolutePath());
                }
                z17 = z16;
                VasCommonReporter.newReport("qzone_ttf").setNum1(z17 ? 1L : 0L).setNum2(file2.length()).setValue1(file2.getName()).report(z17);
                z16 = z17;
            } else {
                QLog.e(TAG, 1, "call native_ftf2ttf error");
                VasCommonReporter.newReport("qzone_ttf").setNum1(0L).setValue1(str2).report(false);
            }
            return z16;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doRealDownload(final int i3, final String str, int i16, String str2, FontInterface.FontResult fontResult) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "fontUrl is empty.");
            return false;
        }
        if (this.downloadingFontIDs == null) {
            this.downloadingFontIDs = new ConcurrentHashMap<>();
        }
        DownLoadFontTask downLoadFontTask = new DownLoadFontTask();
        downLoadFontTask.fontID = i3;
        downLoadFontTask.fontType = i16;
        downLoadFontTask.extend = str2;
        downLoadFontTask.result = new WeakReference<>(fontResult);
        synchronized (this.downloadingFontIDs) {
            ArrayList<DownLoadFontTask> arrayList = this.downloadingFontIDs.get(Integer.valueOf(i3));
            if (arrayList == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "add new download task. fontId =" + i3);
                }
                ArrayList<DownLoadFontTask> arrayList2 = new ArrayList<>();
                arrayList2.add(downLoadFontTask);
                this.downloadingFontIDs.put(Integer.valueOf(i3), arrayList2);
                ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.font.FontManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isDevelopLevel()) {
                            QLog.d(FontManager.TAG, 4, "begin to download font file from network, url =" + str);
                        }
                        if (HttpDownloadUtil.download((AppRuntime) null, str, new File(FontManager.this.getDownloadZipPath(i3)))) {
                            FontManager.this.unzipFont(i3);
                        } else {
                            QLog.e(FontManager.TAG, 1, "Font Download Failed, font url = " + str);
                        }
                        FontManager.this.callbackResult(i3);
                    }
                }, 5, null, false);
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "attache download task. fontId =" + i3);
            }
            arrayList.add(downLoadFontTask);
            return true;
        }
    }

    private void downloadTaskAndCheckNetwork(int i3, String str, int i16, String str2, boolean z16, FontInterface.FontResult fontResult) {
        if (!NetworkState.isNetSupport() || getETEngine() == null) {
            if (fontResult != null) {
                fontResult.result(i3, null, str2);
                return;
            }
            return;
        }
        if (!z16) {
            boolean isWifiConn = NetworkState.isWifiConn();
            int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZ_CUSTOM_FONT, QzoneConfig.SECONDARY_DOWNLOAD_FONT_ANYWAY, 0);
            if (!isWifiConn && config == 0 && fontResult != null) {
                fontResult.result(i3, null, str2);
                return;
            }
        }
        addDownloadTask(i3, str, i16, str2, fontResult);
    }

    private File[] getAllFontInFolder(File file) {
        return file.listFiles(this.fontFilter);
    }

    private String getDownLoadDir() {
        if (!TextUtils.isEmpty(this.fontDownloadDir)) {
            return this.fontDownloadDir + File.separator;
        }
        this.fontDownloadDir = getFontDir() + getProcessName();
        File file = new File(this.fontDownloadDir);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return this.fontDownloadDir + File.separator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDownloadZipPath(int i3) {
        return getDownLoadDir() + i3 + ".zip";
    }

    private static FileCacheService getFileCache() {
        if (mFileCache == null) {
            mFileCache = CacheManager.getPersonaliseFontCacheService();
        }
        return mFileCache;
    }

    private String getFontDir() {
        if (!TextUtils.isEmpty(this.fontDir)) {
            return this.fontDir + File.separator;
        }
        this.fontDir = CacheManager.getPersonaliseFontDir();
        File file = new File(this.fontDir);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return this.fontDir + File.separator;
    }

    private int getFontIDFromFile(File file) {
        try {
            String name = file.getName();
            return Integer.parseInt(name.substring(0, name.indexOf(46)));
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFontPath(int i3, int i16) {
        return getFontDir() + getFontName(i3, i16);
    }

    private String getFontPathIfExist(int i3, int i16) {
        String fontPath = getFontPath(i3, i16);
        if (new File(fontPath).exists()) {
            return fontPath;
        }
        return null;
    }

    public static FontManager getInstance() {
        return sSingleton.get(null);
    }

    private String getProcessName() {
        if (TextUtils.isEmpty(this.processName)) {
            String qQProcessName = BaseApplicationImpl.getApplication().getQQProcessName();
            int indexOf = qQProcessName.indexOf(58);
            if (indexOf > 0 && indexOf < qQProcessName.length() - 1) {
                this.processName = qQProcessName.substring(indexOf + 1);
            } else {
                this.processName = qQProcessName;
            }
        }
        return this.processName;
    }

    private String getUnzipDir(int i3) {
        String str = getDownLoadDir() + i3;
        File file = new File(str);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return str + File.separator;
    }

    static /* bridge */ /* synthetic */ FileCacheService i() {
        return getFileCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTrueTypeFont$0(int i3) {
        com.tencent.mobileqq.vas.updatesystem.api.a.f311148a.b(i3, getFontPath(i3, 1), getFontPath(i3, 0), getProcessName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startFontSoDownload$1(EIPCResultCallback eIPCResultCallback) {
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.H, null, eIPCResultCallback);
    }

    private void loadFontInfo() {
        File file = new File(getFontDir());
        if (!file.exists()) {
            QLog.d(TAG, 1, "cache font dir not found, cache font size = 0.");
            return;
        }
        File[] allFontInFolder = getAllFontInFolder(file);
        if (allFontInFolder != null && allFontInFolder.length > 0) {
            HashSet hashSet = new HashSet();
            for (File file2 : allFontInFolder) {
                int fontIDFromFile = getFontIDFromFile(file2);
                if (checkFontIDValidity(fontIDFromFile)) {
                    hashSet.add(Integer.valueOf(fontIDFromFile));
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                addFontInfoToCatch(((Integer) it.next()).intValue());
            }
        }
        QLog.d(TAG, 1, "cache font size = " + this.catchFontInfoMap.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean unzipFont(int i3) {
        String downloadZipPath = getDownloadZipPath(i3);
        String unzipDir = getUnzipDir(i3);
        boolean z16 = false;
        try {
            try {
                try {
                    boolean unzip = FileUtils.unzip(new File(downloadZipPath), new File(unzipDir));
                    if (unzip) {
                        File[] listFiles = new File(unzipDir).listFiles();
                        if (listFiles != null && listFiles.length > 0) {
                            File file = listFiles[0];
                            try {
                                ETEngine.getInstanceForSpace();
                                int native_getFontType = ETEngine.native_getFontType(file.getAbsolutePath());
                                if (native_getFontType == 2) {
                                    File file2 = new File(getFontPath(i3, 1));
                                    if (!file2.exists()) {
                                        unzip = file.renameTo(file2);
                                    }
                                    if (unzip) {
                                        getFileCache().updateLruFile(file2.getAbsolutePath(), true);
                                    }
                                } else if (native_getFontType == 1) {
                                    File file3 = new File(getFontPath(i3, 0));
                                    if (!file3.exists()) {
                                        unzip = file.renameTo(file3);
                                    }
                                    if (unzip) {
                                        getFileCache().updateLruFile(file3.getAbsolutePath(), true);
                                        unzip = convertFontFile(file3.getAbsolutePath(), getFontPath(i3, 1));
                                    }
                                } else {
                                    unzip = false;
                                }
                                if (unzip) {
                                    FontInfo fontInfo = new FontInfo();
                                    fontInfo.fontId = i3;
                                    this.catchFontInfoMap.put(Integer.valueOf(i3), fontInfo);
                                } else {
                                    QLog.e(TAG, 1, "failed to move file, from path = " + file.getAbsolutePath());
                                }
                            } catch (Throwable th5) {
                                QLog.e(TAG, 1, "call native_getFontType error, errMsg = " + th5.toString());
                                try {
                                    FileUtils.deleteFile(new File(downloadZipPath));
                                    FileUtils.deleteFile(new File(unzipDir));
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                                return false;
                            }
                        } else {
                            QLog.e(TAG, 1, "unzipDir.listFiles is empty.");
                        }
                    } else {
                        QLog.e(TAG, 1, "unzip the downloaded archive failed. path = " + downloadZipPath);
                    }
                    z16 = unzip;
                    FileUtils.deleteFile(new File(downloadZipPath));
                    FileUtils.deleteFile(new File(unzipDir));
                } catch (Throwable th6) {
                    try {
                        FileUtils.deleteFile(new File(downloadZipPath));
                        FileUtils.deleteFile(new File(unzipDir));
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    throw th6;
                }
            } catch (Exception e18) {
                QLog.w(TAG, 1, "unzip_font", e18);
                FileUtils.deleteFile(new File(downloadZipPath));
                FileUtils.deleteFile(new File(unzipDir));
            }
        } catch (Exception e19) {
            e19.printStackTrace();
        }
        return z16;
    }

    public boolean ETEngineLoaded() {
        return o.b();
    }

    public DefaultBarrageEffectInfo getDefaultBarrageEffectInfo(long j3) {
        String[] split;
        String string4Uin = LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.QZONE_BARRAGE_EFFECT_SAVE_DATA, "", j3);
        if (TextUtils.isEmpty(string4Uin) || (split = string4Uin.split(";")) == null || split.length < 2) {
            return null;
        }
        DefaultBarrageEffectInfo defaultBarrageEffectInfo = new DefaultBarrageEffectInfo();
        try {
            defaultBarrageEffectInfo.itemId = Integer.valueOf(split[0]).intValue();
            defaultBarrageEffectInfo.jsonStr = split[1];
            return defaultBarrageEffectInfo;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "loadDefaultFontData Throwable, errMsg = " + th5.getMessage());
            return null;
        }
    }

    public DefaultFontInfo getDefaultFont(long j3) {
        String string4Uin = LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.QZONE_FONT_SAVE_DATA, "", j3);
        if (TextUtils.isEmpty(string4Uin)) {
            return null;
        }
        DefaultFontInfo defaultFontInfo = new DefaultFontInfo();
        defaultFontInfo.readFrom(string4Uin);
        return defaultFontInfo;
    }

    public DefaultSuperFontInfo getDefaultSuperFont(long j3) {
        String[] split;
        String string4Uin = LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.QZONE_SUPER_FONT_SAVE_DATA, "", j3);
        if (TextUtils.isEmpty(string4Uin) || (split = string4Uin.split(";")) == null || split.length < 2) {
            return null;
        }
        DefaultSuperFontInfo defaultSuperFontInfo = new DefaultSuperFontInfo();
        try {
            defaultSuperFontInfo.fontId = Integer.valueOf(split[0]).intValue();
            defaultSuperFontInfo.jsonStr = split[1];
            return defaultSuperFontInfo;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "loadDefaultFontData Throwable, errMsg = " + th5.getMessage());
            return null;
        }
    }

    public ETEngine getETEngine() {
        boolean z16;
        if (!o.b() && o.a()) {
            z16 = o.c();
        } else {
            if (!o.a()) {
                startFontSoDownload(null);
                QLog.d(TAG, 1, "initEngine but libvipfont.so didn't download, start download.");
                return null;
            }
            z16 = true;
        }
        if (z16) {
            return ETEngine.getInstanceForSpace();
        }
        return null;
    }

    public String getFullTypeFont(int i3, String str, String str2, FontInterface.FullTypeResult fullTypeResult) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getFullTypeFont fontId:" + i3 + ", strUrl = " + str);
        }
        if (!checkFontIDValidity(i3)) {
            return null;
        }
        String fontPath = getFontPath(i3, 0);
        if (!new File(fontPath).exists()) {
            downloadTaskAndCheckNetwork(i3, str, 0, str2, false, fullTypeResult);
            return null;
        }
        getFileCache().updateLruFile(fontPath, true);
        return fontPath;
    }

    public String getTrueTypeFont(final int i3, String str, String str2, boolean z16, FontInterface.TrueTypeResult trueTypeResult) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getTrueTypeFont fontId:" + i3 + ", strUrl = " + str);
        }
        if (!checkFontIDValidity(i3)) {
            return null;
        }
        String fontPath = getFontPath(i3, 1);
        if (!new File(fontPath).exists()) {
            downloadTaskAndCheckNetwork(i3, str, 1, str2, z16, trueTypeResult);
            return null;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.qzone.font.a
            @Override // java.lang.Runnable
            public final void run() {
                FontManager.this.lambda$getTrueTypeFont$0(i3);
            }
        }, 16, null, false);
        getFileCache().updateLruFile(fontPath, true);
        return fontPath;
    }

    public void startFontSoDownload(com.tencent.mobileqq.earlydownload.b bVar) {
        final EIPCResultCallback eIPCResultCallback = new EIPCResultCallback() { // from class: cooperation.qzone.font.FontManager.2
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                if (QLog.isColorLevel()) {
                    QLog.d(FontManager.TAG, 2, "startFontSoDownload download so success");
                }
            }
        };
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qzone.font.b
            @Override // java.lang.Runnable
            public final void run() {
                FontManager.lambda$startFontSoDownload$1(EIPCResultCallback.this);
            }
        });
    }

    public void setDefaultBarrageEffect(long j3, DefaultBarrageEffectInfo defaultBarrageEffectInfo) {
        String str;
        if (defaultBarrageEffectInfo != null && defaultBarrageEffectInfo.itemId > 0 && !TextUtils.isEmpty(defaultBarrageEffectInfo.jsonStr)) {
            str = defaultBarrageEffectInfo.itemId + ";" + defaultBarrageEffectInfo.jsonStr + ";";
            setDefaultFont(j3, null);
            setDefaultSuperFont(j3, null);
        } else {
            str = "";
        }
        LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_BARRAGE_EFFECT_SAVE_DATA, str, j3);
    }

    public void setDefaultFont(long j3, DefaultFontInfo defaultFontInfo) {
        String str;
        if (defaultFontInfo != null && defaultFontInfo.fontId > 0 && !TextUtils.isEmpty(defaultFontInfo.fontUrl)) {
            str = defaultFontInfo.toString();
            setDefaultBarrageEffect(j3, null);
        } else {
            str = "";
        }
        LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_FONT_SAVE_DATA, str, j3);
    }

    public void setDefaultSuperFont(long j3, DefaultSuperFontInfo defaultSuperFontInfo) {
        String str;
        if (defaultSuperFontInfo != null && defaultSuperFontInfo.fontId > 0 && !TextUtils.isEmpty(defaultSuperFontInfo.jsonStr)) {
            str = defaultSuperFontInfo.fontId + ";" + defaultSuperFontInfo.jsonStr + ";";
            setDefaultBarrageEffect(j3, null);
        } else {
            str = "";
        }
        LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_SUPER_FONT_SAVE_DATA, str, j3);
    }

    private String getFontName(int i3, int i16) {
        String str;
        if (i16 == 1) {
            str = ".ttf";
        } else if (i16 == 0) {
            str = FONT_SUFFIX_FTF;
        } else {
            throw new IllegalArgumentException("fontType = " + i16);
        }
        return i3 + str;
    }
}
