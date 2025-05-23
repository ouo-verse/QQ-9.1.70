package com.tencent.mobileqq.qqlive.verified;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRealNameAuthData;
import com.tencent.mobileqq.qqlive.sso.c;
import com.tencent.mobileqq.qqlive.sso.g;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements IQQLiveVerifyService {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IQQLiveSDK f273460d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends com.tencent.mobileqq.qqlive.sso.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveGetRealNameAuthCallback f273461a;

        a(IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback) {
            this.f273461a = iQQLiveGetRealNameAuthCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) iQQLiveGetRealNameAuthCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sso.a
        public void onBusinessFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            super.onBusinessFailed(i3, str);
            IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback = this.f273461a;
            if (iQQLiveGetRealNameAuthCallback != null) {
                iQQLiveGetRealNameAuthCallback.onFailed(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sso.a, com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            super.onFailed(i3, str);
            IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback = this.f273461a;
            if (iQQLiveGetRealNameAuthCallback != null) {
                iQQLiveGetRealNameAuthCallback.onFailed(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sso.a
        public void onProxyRequestSuccess(int i3, h hVar) throws InvalidProtocolBufferNanoException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) hVar);
                return;
            }
            if (this.f273461a == null) {
                return;
            }
            try {
                fr4.b c16 = fr4.b.c(hVar.e());
                if (c16 == null) {
                    this.f273461a.onFailed(1001, "network error");
                    return;
                }
                QQLiveRealNameAuthData qQLiveRealNameAuthData = new QQLiveRealNameAuthData();
                qQLiveRealNameAuthData.setAuthState(c16.f400375a);
                qQLiveRealNameAuthData.setVerifyUrl(c16.f400376b);
                qQLiveRealNameAuthData.setTipsContent(c16.f400377c);
                this.f273461a.onSuccess(qQLiveRealNameAuthData);
            } catch (InvalidProtocolBufferNanoException unused) {
                this.f273461a.onFailed(1002, "GetRealNameAuthRsp parse error");
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.d("QQLiveVerifyServiceImpl", 4, "destroy");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService
    public void getRealNameAuthState(int i3, IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) iQQLiveGetRealNameAuthCallback);
            return;
        }
        IQQLiveSDK iQQLiveSDK = this.f273460d;
        if (iQQLiveSDK != null && iQQLiveSDK.getExtModule("sso_module") != null) {
            c cVar = (c) this.f273460d.getExtModule("sso_module");
            fr4.a aVar = new fr4.a();
            aVar.f400374a = i3;
            if (cVar != null) {
                cVar.f("trpc.qlive.qlive_real_name_auth_svr.QliveRealNameAuthSvr", "GetRealNameAuth", MessageNano.toByteArray(aVar), new g(new a(iQQLiveGetRealNameAuthCallback)));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.f273460d = iQQLiveSDK;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
