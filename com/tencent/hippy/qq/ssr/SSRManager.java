package com.tencent.hippy.qq.ssr;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.sign.MD5;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SSRManager {
    public static final String ASSET_SSR_COMMON_JS_PATH = "hippy/ssr/vendor_ssr.js";
    public static final int ASSET_SSR_COMMON_JS_VERSION = 10;
    private static final String KEY_COMMON_JS_MD5 = "md5";
    private static final String KEY_COMMON_JS_URL = "url";
    private static final String KEY_COMMON_JS_VERSION = "version";
    public static final String SSR_COMMON_JS_DOWNLOAD_FILE_NAME = "vendor_ssr.zip";
    public static final String SSR_COMMON_JS_FILE_NAME = "vendor_ssr.js";
    private static final String TAG = "SSRManager";
    private static volatile SSRManager gSSRManager;
    private volatile boolean mIsCommonJsDownloading;

    private void downloadCommonJs(String str, String str2, int i3) {
        File commonJsVersionDir = getCommonJsVersionDir(i3);
        if (!commonJsVersionDir.exists()) {
            commonJsVersionDir.mkdirs();
        }
        File commonJsDownloadFile = getCommonJsDownloadFile(i3);
        g gVar = new g(str, commonJsDownloadFile);
        gVar.U = true;
        gVar.Q = true;
        gVar.f313008f = 2;
        gVar.W = true;
        gVar.X = true;
        gVar.D = true;
        if (((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.waitAppRuntime()) != 0 || !commonJsDownloadFile.exists() || commonJsDownloadFile.length() <= 0 || !str2.equals(MD5.getFileMd5(commonJsDownloadFile.getAbsolutePath()))) {
            return;
        }
        boolean unzipSSRCommonJs = unzipSSRCommonJs(i3, commonJsDownloadFile, FaceUtil.IMG_TEMP);
        FileUtils.deleteFile(new File(commonJsVersionDir, FaceUtil.IMG_TEMP));
        if (unzipSSRCommonJs) {
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(MMKVCommonFileKeys.SSR_COMMON_JS_VERSION, i3).commitAsync();
        }
    }

    private File getCommonJsDownloadFile(int i3) {
        return new File(getCommonJsVersionDir(i3), SSR_COMMON_JS_DOWNLOAD_FILE_NAME);
    }

    private File getCommonJsFile(int i3) {
        return new File(getCommonJsVersionDir(i3), SSR_COMMON_JS_FILE_NAME);
    }

    private File getCommonJsVersionDir(int i3) {
        return new File(HippyQQFileUtil.getSSRCommonDir(), String.valueOf(i3));
    }

    public static SSRManager getInstance() {
        if (gSSRManager == null) {
            synchronized (SSRManager.class) {
                if (gSSRManager == null) {
                    gSSRManager = new SSRManager();
                }
            }
        }
        return gSSRManager;
    }

    private int getLocalCommonJsVersion() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        int decodeInt = from.decodeInt(MMKVCommonFileKeys.SSR_COMMON_JS_VERSION, 0);
        if (decodeInt > 0 && !isCommonJsExists(decodeInt)) {
            from.encodeInt(MMKVCommonFileKeys.SSR_COMMON_JS_VERSION, 0).commitAsync();
            return 0;
        }
        return decodeInt;
    }

    private boolean isCommonJsExists(int i3) {
        return getCommonJsFile(i3).exists();
    }

    private boolean isNeedUpdateCommonJs(int i3) {
        if (i3 <= 10 || i3 <= getLocalCommonJsVersion()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSSRCommonJs$0(String str, String str2, int i3) {
        downloadCommonJs(str, str2, i3);
        this.mIsCommonJsDownloading = false;
    }

    private boolean unzipSSRCommonJs(int i3, File file, String str) {
        File file2;
        try {
            file2 = new File(getCommonJsVersionDir(i3), str);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "unzip failed:", th5);
        }
        if (!cooperation.qzone.util.FileUtils.unzip(file, file2)) {
            QLog.e(TAG, 1, "unzip common js failed, version:" + i3);
            return false;
        }
        File file3 = new File(file2, SSR_COMMON_JS_FILE_NAME);
        if (file3.exists() && file3.length() > 0) {
            File commonJsFile = getCommonJsFile(i3);
            if (commonJsFile.exists()) {
                FileUtils.deleteFile(commonJsFile);
            }
            if (file3.renameTo(commonJsFile)) {
                return commonJsFile.exists();
            }
            QLog.e(TAG, 1, "rename temp SSR file failed");
            return false;
        }
        QLog.e(TAG, 1, "unzipped common js doesn't exist");
        return false;
    }

    public int getSSRCommonJsVersion() {
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(MMKVCommonFileKeys.SSR_COMMON_JS_VERSION, 0);
        if (decodeInt <= 10) {
            return 10;
        }
        return decodeInt;
    }

    public boolean loadSSRCommonJs(HippyQQEngine hippyQQEngine, int i3) {
        boolean z16;
        String str;
        int localCommonJsVersion = getLocalCommonJsVersion();
        if (10 >= localCommonJsVersion) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && 10 >= i3) {
            str = FileUtils.readStringFromAsset(ASSET_SSR_COMMON_JS_PATH);
        } else if (!z16 && localCommonJsVersion >= i3) {
            str = FileUtils.readFileContent(getCommonJsFile(localCommonJsVersion));
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        hippyQQEngine.runJavaScript(str);
        return true;
    }

    public void updateSSRCommonJs() {
        ToggleProxy toggleProxy = VasToggle.HIPPY_SSR_COMMON_JS;
        if (!toggleProxy.isEnable(false)) {
            return;
        }
        final String stringDataSet = toggleProxy.getStringDataSet("url", null);
        final String stringDataSet2 = toggleProxy.getStringDataSet("md5", null);
        final int stringToInt = NumberUtil.stringToInt(toggleProxy.getStringDataSet("version", null));
        if (!TextUtils.isEmpty(stringDataSet) && !TextUtils.isEmpty(stringDataSet2) && stringToInt > 0) {
            if (!isNeedUpdateCommonJs(stringToInt) || this.mIsCommonJsDownloading) {
                return;
            }
            this.mIsCommonJsDownloading = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.ssr.a
                @Override // java.lang.Runnable
                public final void run() {
                    SSRManager.this.lambda$updateSSRCommonJs$0(stringDataSet, stringDataSet2, stringToInt);
                }
            }, 128, null, true);
            return;
        }
        QLog.e(TAG, 1, "updateSSRCommonJs parameters error");
    }
}
