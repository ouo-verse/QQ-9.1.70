package com.tencent.mobileqq.ark.api.impl;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import com.tencent.mobileqq.ark.core.d;
import com.tencent.mobileqq.ark.p;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkServiceImpl implements IArkService {
    private static final String TAG = "ArkApp.ArkService";
    ArkAppCenter arkAppCenter;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements BusinessObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16) {
                QLog.i(ArkServiceImpl.TAG, 1, "ArkSafe,doReport, sso request failed");
                return;
            }
            QLog.d(ArkServiceImpl.TAG, 2, "ArkSafe.doReport.server.back=" + obj);
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkService
    public void doURLReport(String str) {
        if (this.arkAppCenter == null) {
            QLog.i(TAG, 1, "doURLReport: arkAppCenter is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "ArkSafe,doReport=null");
            return;
        }
        d k3 = this.arkAppCenter.k();
        if (k3 == null) {
            return;
        }
        QLog.i(TAG, 1, "ArkSafe,doReport=" + str);
        k3.sendAppMsg("ArkAppReport.URLCheck", str, 10000, 0, new a());
    }

    @Override // com.tencent.mobileqq.ark.api.IArkService
    public p getSSO() {
        ArkAppCenter arkAppCenter = this.arkAppCenter;
        if (arkAppCenter == null) {
            QLog.i(TAG, 1, "getSSO: arkAppCenter is null");
            return null;
        }
        return arkAppCenter.k();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.arkAppCenter = new ArkAppCenter(appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.arkAppCenter.r();
        this.arkAppCenter = null;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkService
    public void reportPredownloadFirstHit(String str, boolean z16) {
        ArkAppCenter arkAppCenter = this.arkAppCenter;
        if (arkAppCenter == null) {
            QLog.i(TAG, 1, "reportPredownloadFirstHit: arkAppCenter is null");
        } else {
            arkAppCenter.j().p(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkService
    public void sendAppMsg(String str, String str2, int i3, int i16, BusinessObserver businessObserver) {
        ArkAppCenter arkAppCenter = this.arkAppCenter;
        if (arkAppCenter == null) {
            QLog.i(TAG, 1, "sendAppMsg: arkAppCenter is null");
            if (businessObserver != null) {
                businessObserver.onUpdate(i16, false, null);
                return;
            }
            return;
        }
        arkAppCenter.k().sendAppMsg(str, str2, i3, i16, businessObserver);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkService
    public void startPreloadApp() {
        ArkAppCenter arkAppCenter = this.arkAppCenter;
        if (arkAppCenter == null) {
            return;
        }
        arkAppCenter.j().r();
    }
}
