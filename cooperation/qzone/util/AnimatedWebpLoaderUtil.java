package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import java.io.File;
import tp3.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AnimatedWebpLoaderUtil {
    public static final boolean IS_ENABLE_ANIMATE_WEBP;
    public static final String PREFERENCE_SO_MD5_KEY = "PREFERENCE_SO_MD5_KEY";
    public static final String TAG = "AnimatedWebpLoaderUtil";
    public static final String WEBP_SO_MD5 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_MD5_SECONDARY_KEY, QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_MD5);
    private static boolean hasCheckSupportAnimWebp;
    private static boolean loadSoFail;
    private static boolean supportAnimWebp;

    static {
        boolean z16 = true;
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ENABLE_ANIMATED_WEBP, 1) != 1) {
            z16 = false;
        }
        IS_ENABLE_ANIMATE_WEBP = z16;
        loadSoFail = false;
        hasCheckSupportAnimWebp = false;
        supportAnimWebp = false;
    }

    private static boolean doLoadSo() {
        try {
            String moduleFilePath = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_SO);
            if (TextUtils.isEmpty(moduleFilePath)) {
                return false;
            }
            ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.context.getBaseContext(), moduleFilePath);
            System.load(moduleFilePath);
            return true;
        } catch (Throwable th5) {
            loadSoFail = true;
            QZLog.e(TAG, "load webp so fail", th5);
            return false;
        }
    }

    private static boolean isNeedUpdate() {
        if (TextUtils.isEmpty(a.b().getString(PREFERENCE_SO_MD5_KEY, null))) {
            return true;
        }
        return !r0.equalsIgnoreCase(WEBP_SO_MD5);
    }

    public static boolean isSOExit() {
        String moduleFilePath = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_SO);
        if (TextUtils.isEmpty(moduleFilePath)) {
            QZLog.i(TAG, "isWebp SO path not exit");
            return false;
        }
        boolean exists = new File(moduleFilePath).exists();
        QZLog.i(TAG, "isWebp SO path exit : " + exists);
        return exists;
    }

    public static boolean isSupportAnimWebp() {
        boolean z16;
        if (!hasCheckSupportAnimWebp) {
            if (IS_ENABLE_ANIMATE_WEBP && !loadSoFail && ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 1)) {
                z16 = true;
            } else {
                z16 = false;
            }
            supportAnimWebp = z16;
            hasCheckSupportAnimWebp = true;
        }
        return supportAnimWebp;
    }

    public static boolean loadSo() {
        if (!isSupportAnimWebp()) {
            QZLog.i(TAG, "enable animtedWebp false");
            return false;
        }
        if (!isNeedUpdate() && isSOExit()) {
            return doLoadSo();
        }
        ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).downloadModule(QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_SO, new ModuleDownloadListener() { // from class: cooperation.qzone.util.AnimatedWebpLoaderUtil.1
            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadFailed(String str) {
                QZLog.i(AnimatedWebpLoaderUtil.TAG, "download webp so fail");
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadSucceed(String str) {
                if (!str.equals(QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_SO)) {
                    return;
                }
                a.b().edit().putString(AnimatedWebpLoaderUtil.PREFERENCE_SO_MD5_KEY, AnimatedWebpLoaderUtil.WEBP_SO_MD5).commit();
                QZLog.i(AnimatedWebpLoaderUtil.TAG, "download webp so succ");
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadCanceled(String str) {
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadProgress(String str, float f16) {
            }
        });
        return false;
    }
}
