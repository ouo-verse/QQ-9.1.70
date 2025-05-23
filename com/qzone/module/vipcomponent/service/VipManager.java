package com.qzone.module.vipcomponent.service;

import NS_VipReminderSvrProto.GetReminderReq;
import NS_VipReminderSvrProto.ReportPayFailedReq;
import NS_VipReminderSvrProto.ReportReminderReq;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.proxy.vipcomponent.adapter.IVipManager;
import com.qzone.proxy.vipcomponent.adapter.ResultWrapper;
import com.qzone.proxy.vipcomponent.adapter.ServiceCallbackWrapper;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import cooperation.vip.vipcomponent.util.b;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VipManager implements IVipManager.RequestCallbackListener, IVipManager {
    public static final String TAG = "VipManager";

    /* renamed from: a, reason: collision with root package name */
    private Handler f49044a;

    /* renamed from: b, reason: collision with root package name */
    private IVipManager.IEnvironment f49045b;

    @Override // com.qzone.proxy.vipcomponent.adapter.IVipManager
    public void getVipReminder(long j3, int i3, String str, int i16, ServiceCallbackWrapper serviceCallbackWrapper) {
        HashMap hashMap;
        if (this.f49045b != null) {
            if (VipEnv.isIndepend()) {
                hashMap = null;
            } else {
                hashMap = new HashMap();
                hashMap.put("CMD_CHECK_OS", "android");
                hashMap.put("CMD_CHECK_APP_VER", "");
            }
            this.f49045b.sendRequest(i16, new GetReminderReq(j3, i3, str, null, hashMap), "vipreminder.get", serviceCallbackWrapper, this);
        }
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.IVipManager
    public void init(IVipManager.IEnvironment iEnvironment) {
        this.f49044a = new Handler(VipEnv.getBackGroundLopper());
        this.f49045b = iEnvironment;
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.IVipManager
    public void reportReminder(long j3, int i3, int i16, String str, ServiceCallbackWrapper serviceCallbackWrapper) {
        if (this.f49045b != null) {
            this.f49045b.sendRequest(1, new ReportReminderReq(j3, i3, i16, str), "vipreminder.report", serviceCallbackWrapper, this);
        }
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.IVipManager
    public void reportPayFailedReminder(String str, int i3, int i16, String str2, ServiceCallbackWrapper serviceCallbackWrapper) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.f49045b == null) {
            return;
        }
        this.f49045b.sendRequest(2, new ReportPayFailedReq(str, VipEnv.getLoginUin(), VipEnv.getQUA(), VipEnv.isIndepend() ? 1 : 2, i3, i16, str2), "vipreminder.reportpayfailed", serviceCallbackWrapper, this);
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.IVipManager.RequestCallbackListener
    public void onFailed(ResultWrapper resultWrapper, int i3) {
        if (resultWrapper == null) {
            return;
        }
        if (i3 == 0) {
            b.b(TAG, "vipreminder.getfail ret code = " + resultWrapper.getReturnCode() + "msg = " + resultWrapper.getFailedMsg());
        } else if (i3 == 1) {
            b.b(TAG, "vipreminder.reportfail ret code = " + resultWrapper.getReturnCode() + "msg = " + resultWrapper.getFailedMsg());
        } else if (i3 == 2) {
            b.b(TAG, "vipreminder.reportpayfailedfail ret code = " + resultWrapper.getReturnCode() + "msg = " + resultWrapper.getFailedMsg());
        }
        resultWrapper.serviceCallback();
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.IVipManager.RequestCallbackListener
    public void onSucceed(ResultWrapper resultWrapper, int i3) {
        if (resultWrapper == null) {
            return;
        }
        IVipManager.IEnvironment iEnvironment = this.f49045b;
        if (iEnvironment != null) {
            iEnvironment.dealResultAfterRequestSucceed(i3, resultWrapper);
        }
        resultWrapper.serviceCallback();
    }
}
