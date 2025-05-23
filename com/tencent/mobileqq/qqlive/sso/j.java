package com.tencent.mobileqq.qqlive.sso;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.xweb.FileReaderX5;

/* compiled from: P */
/* loaded from: classes17.dex */
public class j implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IQQLiveSDK f273214d;

    /* renamed from: e, reason: collision with root package name */
    private IAegisLogApi f273215e;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273215e = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    private h j(String str, String str2, int i3, String str3) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg();
        fromServiceMsg.setBusinessFail(i3, str3);
        return new h(fromServiceMsg, str, str2);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sso.c
    public void f(String str, String str2, byte[] bArr, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, bArr, fVar);
        } else {
            h(str, str2, bArr, false, fVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sso.c
    public void g(String str, String str2, byte[] bArr, int i3, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, bArr, Integer.valueOf(i3), fVar);
        } else {
            k(str, str2, bArr, i3, false, fVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sso.c
    public void h(String str, String str2, byte[] bArr, boolean z16, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, bArr, Boolean.valueOf(z16), fVar);
            return;
        }
        IQQLiveSDK iQQLiveSDK = this.f273214d;
        if (iQQLiveSDK != null && iQQLiveSDK.isInited()) {
            if (this.f273214d.isDestroyed()) {
                this.f273215e.a("QQLiveSsoModuleImpl", 1, "liveSDK.isDestroyed, cmd=" + str);
                fVar.onReceive(0, false, j(this.f273214d.getAppId(), str, -100001, "cannot send req after destroy instance."));
                return;
            }
            AppInterface a16 = com.tencent.mobileqq.qqlive.utils.g.a();
            if (a16 == null) {
                this.f273215e.a("QQLiveSsoModuleImpl", 1, "sendQQLiveMsfReq_getAppInterface_null cmd=" + str + ",subCmd=" + str2);
                fVar.onReceive(0, false, j(this.f273214d.getAppId(), str, FileReaderX5.ERR_CODE_NOT_SUPPORT, "getAppInterface null."));
                return;
            }
            ((QQLiveBusinessHandler) a16.getBusinessHandler(QQLiveBusinessHandler.QQ_LIVE_HANDLER)).sendQQLiveReq(this.f273214d.getAppId(), str, str2, bArr, 15000, 0, z16, fVar);
            return;
        }
        this.f273215e.a("QQLiveSsoModuleImpl", 1, "the_live_sdk_is_null cmd=" + str + ",subCmd=" + str2);
        fVar.onReceive(0, false, j("", str, -100001, "do you forget init sdk instance ?"));
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.f273214d = iQQLiveSDK;
        }
    }

    public void k(String str, String str2, byte[] bArr, int i3, boolean z16, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, bArr, Integer.valueOf(i3), Boolean.valueOf(z16), fVar);
            return;
        }
        if (this.f273214d == null) {
            this.f273215e.a("QQLiveSsoModuleImpl", 1, "the_live_sdk_is_null cmd=" + str + ",subCmd=" + str2);
            return;
        }
        AppInterface a16 = com.tencent.mobileqq.qqlive.utils.g.a();
        if (a16 == null) {
            this.f273215e.a("QQLiveSsoModuleImpl", 1, "sendQQLiveMsfReq_getAppInterface_null cmd=" + str + ",subCmd=" + str2);
            return;
        }
        ((QQLiveBusinessHandler) a16.getBusinessHandler(QQLiveBusinessHandler.QQ_LIVE_HANDLER)).sendQQLiveReq(this.f273214d.getAppId(), str, str2, bArr, 15000, i3, z16, fVar);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }
}
