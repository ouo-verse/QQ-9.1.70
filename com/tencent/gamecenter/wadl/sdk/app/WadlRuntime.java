package com.tencent.gamecenter.wadl.sdk.app;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.sdk.ipc.WadlRemoteHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlRuntime extends AppRuntime {
    public static final String TAG = "Wadl_WadlRuntime";
    public static final String WADL_MODULE_ID = "qqwadl.apk";

    @Override // mqq.app.AppRuntime
    public BaseApplication getApp() {
        String str = MobileQQ.QQ_PACKAGE_NAME;
        return BaseApplication.getContext();
    }

    @Override // mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return null;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        return WADL_MODULE_ID;
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        boolean isAnyTaskActive = WadlRemoteHandler.getInstance().isAnyTaskActive(true);
        QLog.d(TAG, 1, "highPriorityWhenBackground isAnyTaskActive=" + isAnyTaskActive);
        return isAnyTaskActive;
    }

    @Override // mqq.app.AppRuntime
    public boolean isProcessIdle() {
        boolean isAnyTaskActive = WadlRemoteHandler.getInstance().isAnyTaskActive(true);
        QLog.d(TAG, 1, "isProcessIdle isAnyTaskActive=" + isAnyTaskActive);
        return !isAnyTaskActive;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i(TAG, 1, "onCreate...");
    }

    @Override // mqq.app.AppRuntime
    public void preExit() {
        QLog.d(TAG, 1, "preExit");
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_ATTA_05076).setOperId(WadlProxyConsts.OPER_ID_PROCESS_MONITOR).setOperType("555").setExt(48, "service pre exit").report();
        WadlUtils.notifyPreExit();
        WadlRemoteHandler.getInstance().onDestroy();
    }
}
