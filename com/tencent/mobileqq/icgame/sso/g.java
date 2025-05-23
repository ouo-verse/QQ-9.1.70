package com.tencent.mobileqq.icgame.sso;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class g implements BusinessObserver {
    private static final int BUSINESS_ERROR = 4;
    private static final int MSF_ERROR = 2;
    private static final int PROXY_ERROR = 3;
    private static final String TAG = "ICGameIQQLiveBusinessObserver";
    private String appID = "";
    private IAegisLogApi mAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    private void addErrorParams(Map<String, String> map, int i3, String str, int i16) {
        map.put("ext2", String.valueOf(i16));
        map.put("event_code", String.valueOf(i3));
        map.put(AudienceReportConst.EVENT_MSG, str);
    }

    private String getAccountStr() {
        AppInterface a16 = t42.d.a();
        if (a16 == null) {
            return null;
        }
        return a16.getAccount();
    }

    private boolean isError(boolean z16, i iVar) {
        if (iVar != null && z16 && iVar.g() == 0 && iVar.b() == 0) {
            return false;
        }
        return true;
    }

    private void reportErrorCode(boolean z16, i iVar, String str) {
        if (!TextUtils.isEmpty(this.appID) && !TextUtils.isEmpty(str)) {
            if (iVar != null && iVar.h() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("ext1", iVar.d());
                if (!z16) {
                    addErrorParams(hashMap, iVar.h().getBusinessFailCode(), iVar.h().getBusinessFailMsg(), 2);
                } else if (iVar.g() != 0) {
                    addErrorParams(hashMap, iVar.g(), iVar.f(), 3);
                } else if (iVar.b() != 0) {
                    addErrorParams(hashMap, iVar.b(), iVar.c(), 4);
                }
                com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_sso_request_error", hashMap);
                return;
            }
            this.mAegisLog.e(TAG, 1, "reportErrorCode get rspData null");
            return;
        }
        this.mAegisLog.e(TAG, 1, "reportErrorCode get UIN null");
    }

    public String getAppId() {
        return this.appID;
    }

    public abstract void onReceive(int i3, boolean z16, i iVar);

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public final void onUpdate(int i3, boolean z16, Object obj) {
        i iVar = (i) obj;
        if (getAppId() != null && !getAppId().equals(iVar.a())) {
            if (QLog.isColorLevel()) {
                this.mAegisLog.i(TAG, 2, "[" + iVar.d() + "-checkAppId] reqAppId:" + iVar.a() + ", sdkAppId:" + getAppId());
                return;
            }
            return;
        }
        if (isError(z16, iVar)) {
            reportErrorCode(z16, iVar, getAccountStr());
        }
        onReceive(i3, z16, iVar);
    }

    public void setAppId(String str) {
        this.appID = str;
    }
}
