package com.tencent.mobileqq.qqlive.sso;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.impl.QQGameReportServiceImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class f implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    private static final int BUSINESS_ERROR = 4;
    private static final int MSF_ERROR = 2;
    private static final int PROXY_ERROR = 3;
    private static final String TAG = "IQQLiveBusinessObserver";
    private String appID;
    private IAegisLogApi mAegisLog;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.appID = "";
            this.mAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    private ft3.c createReportTask() {
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(this.appID);
        if (sDKImpl == null) {
            this.mAegisLog.e(TAG, 1, "reportErrorCode get sdk null");
            return null;
        }
        return sDKImpl.getDataReportModule().newReportTask();
    }

    private String getAccountStr() {
        AppInterface a16 = com.tencent.mobileqq.qqlive.utils.g.a();
        if (a16 == null) {
            return null;
        }
        return a16.getAccount();
    }

    private void handleError(ft3.c cVar, int i3, String str, int i16) {
        cVar.addKeyValue("errorcode", i3);
        cVar.addKeyValue("errormsg", str);
        cVar.addKeyValue(QQGameReportServiceImpl.ATTA_KEY_ERROR_TYPE, i16);
    }

    private boolean isError(boolean z16, h hVar) {
        if (hVar != null && z16 && hVar.g() == 0 && hVar.b() == 0) {
            return false;
        }
        return true;
    }

    private void reportErrorCode(boolean z16, h hVar, String str) {
        if (!TextUtils.isEmpty(this.appID) && !TextUtils.isEmpty(str)) {
            if (hVar != null && hVar.h() != null) {
                ft3.c createReportTask = createReportTask();
                if (createReportTask == null) {
                    return;
                }
                createReportTask.a("req_error");
                createReportTask.addKeyValue("appid", this.appID);
                createReportTask.addKeyValue(AudienceReportConst.USER_QQ, str);
                createReportTask.addKeyValue("service", hVar.d());
                if (!z16) {
                    handleError(createReportTask, hVar.h().getBusinessFailCode(), hVar.h().getBusinessFailMsg(), 2);
                } else if (hVar.g() != 0) {
                    handleError(createReportTask, hVar.g(), hVar.f(), 3);
                } else if (hVar.b() != 0) {
                    handleError(createReportTask, hVar.b(), hVar.c(), 4);
                }
                createReportTask.send();
                return;
            }
            this.mAegisLog.e(TAG, 1, "reportErrorCode get rspData null");
            return;
        }
        this.mAegisLog.e(TAG, 1, "reportErrorCode get UIN null");
    }

    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appID;
    }

    public abstract void onReceive(int i3, boolean z16, h hVar);

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public final void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        h hVar = (h) obj;
        if (getAppId() != null && !getAppId().equals(hVar.a())) {
            if (QLog.isColorLevel()) {
                this.mAegisLog.i(TAG, 2, "[" + hVar.d() + "-checkAppId] reqAppId:" + hVar.a() + ", sdkAppId:" + getAppId());
                return;
            }
            return;
        }
        if (isError(z16, hVar)) {
            reportErrorCode(z16, hVar, getAccountStr());
        }
        onReceive(i3, z16, hVar);
    }

    public void setAppId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.appID = str;
        }
    }
}
