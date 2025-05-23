package com.tencent.qcircle.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.report.check.qfsimpl.api.QFSTestRegisterEvent;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IZhenYanApi;
import com.tencent.qcircle.application.initprocess.QCircleInitChain;
import com.tencent.qcircle.application.initprocess.QCircleLazyLoadProcess;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import uq3.g;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QCircleApplication extends Application {
    public static Application APP = getAPP();
    public static final String PLUGIN_VERSION_KEY = "version";
    public static final String PLUGIN_VERSION_SP_NAME = "QCirclePluginVersion";
    public static final String SP_FILE_NAME_BUGLY_SDK = "BuglySdkInfos";
    public static final String SP_KEY_SUB_PRODUCT_ID = "9b16ced79b";
    private static final String TAG = "QCircleApplication";
    private static Application sAPP;
    public static boolean sHasInit;
    public static boolean sLazyLoadDone;

    public static Application getAPP() {
        if (sAPP == null && (RFWApplication.getApplication() instanceof Application)) {
            sAPP = RFWApplication.getApplication();
        }
        return sAPP;
    }

    public static synchronized void init(Application application) {
        synchronized (QCircleApplication.class) {
            ((IZhenYanApi) QRoute.api(IZhenYanApi.class)).setUp();
            sAPP = application;
            APP = application;
            AutoShadowPluginRuntime.getInstance().setApplication(application);
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.qcircle.application.QCircleApplication.1
                @Override // java.lang.Runnable
                public void run() {
                    QCircleApplication.initCrashReport();
                }
            });
            QLog.d(TAG, 1, "QCircleInitChain doProcess start");
            new QCircleInitChain().a().b();
            if (sAPP != null) {
                sHasInit = true;
            }
            QLog.d(TAG, 1, "APP init success");
            initRFWTest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initCrashReport() {
        SharedPreferences a16 = g.a("BuglySdkInfos", false, false);
        if (a16 == null) {
            return;
        }
        SharedPreferences.Editor edit = a16.edit();
        edit.putString(SP_KEY_SUB_PRODUCT_ID, QCirclePluginGlobalInfo.v());
        edit.apply();
        savePluginInfo();
    }

    private static void initQCircleFolderTabInfoManager() {
        QCircleFolderTabInfoManager.A();
        QCircleFolderTabInfoManager.m();
    }

    public static boolean isRDMVersion() {
        if (!TextUtils.isEmpty(HostDataTransUtils.getQUA3()) && HostDataTransUtils.getQUA3().endsWith("RDM_B") && !HostAppSettingUtil.isPublicVersion() && !HostAppSettingUtil.isGrayVersion()) {
            return true;
        }
        return false;
    }

    public static void makeSureApplicationLazyLoad() {
        if (sLazyLoadDone) {
            return;
        }
        new QCircleLazyLoadProcess().process();
        QLog.d(TAG, 1, "doLazyLoadDone");
        sLazyLoadDone = true;
    }

    public static void onAccountChanged() {
        HostDataTransUtils.resetAccount();
        initQCircleFolderTabInfoManager();
    }

    public static void savePluginInfo() {
        String u16 = QCirclePluginGlobalInfo.u();
        QMMKV.from(RFWApplication.getApplication(), PLUGIN_VERSION_SP_NAME).encodeString("version", u16);
        QLog.d(TAG, 1, "savePluginInfo:" + u16);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    @QFSTestRegisterEvent(id = "EVENT_APP_START")
    private static void initRFWTest() {
    }
}
