package com.tencent.mobileqq.icgame.sso;

import com.tencent.common.app.AppInterface;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.xweb.FileReaderX5;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k implements c {

    /* renamed from: d, reason: collision with root package name */
    private IQQLiveSDK f237788d;

    /* renamed from: e, reason: collision with root package name */
    private IAegisLogApi f237789e = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    private i k(String str, String str2, int i3, String str3) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg();
        fromServiceMsg.setBusinessFail(i3, str3);
        return new i(fromServiceMsg, str, str2);
    }

    @Override // com.tencent.mobileqq.icgame.sso.c
    public void f(String str, String str2, byte[] bArr, g gVar) {
        g(str, str2, bArr, false, gVar);
    }

    @Override // com.tencent.mobileqq.icgame.sso.c
    public void g(String str, String str2, byte[] bArr, boolean z16, g gVar) {
        IQQLiveSDK iQQLiveSDK = this.f237788d;
        if (iQQLiveSDK != null && iQQLiveSDK.isInited()) {
            if (this.f237788d.isDestroyed()) {
                this.f237789e.a("ICGameSsoModuleImpl", 1, "liveSDK.isDestroyed, cmd=" + str);
                gVar.onReceive(0, false, k(this.f237788d.getAppId(), str, -100001, "cannot send req after destroy instance."));
                return;
            }
            AppInterface a16 = t42.d.a();
            if (a16 == null) {
                this.f237789e.a("ICGameSsoModuleImpl", 1, "sendQQLiveMsfReq_getAppInterface_null cmd=" + str + ",subCmd=" + str2);
                gVar.onReceive(0, false, k(this.f237788d.getAppId(), str, FileReaderX5.ERR_CODE_NOT_SUPPORT, "getAppInterface null."));
                return;
            }
            ((QQLiveBusinessHandler) a16.getBusinessHandler(QQLiveBusinessHandler.QQ_LIVE_HANDLER)).sendQQLiveReq(this.f237788d.getAppId(), str, str2, bArr, 15000, 0, z16, gVar);
            return;
        }
        this.f237789e.a("ICGameSsoModuleImpl", 1, "the_live_sdk_is_null cmd=" + str + ",subCmd=" + str2);
        gVar.onReceive(0, false, k("", str, -100001, "do you forget init sdk instance ?"));
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.f237788d = iQQLiveSDK;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
    }
}
