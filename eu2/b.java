package eu2;

import bu2.TVideoAccountInfo;
import bu2.c;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.account.qqconnect.TVideoQQConnectToken;
import com.tencent.mobileqq.tvideo.account.tenvideo.model.request.VideoLoginRequest;
import com.tencent.mobileqq.tvideo.account.tenvideo.model.request.VideoLogoutRequest;
import com.tencent.mobileqq.tvideo.account.tenvideo.model.request.VideoRefreshTokenRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.LoginResponse;
import tvideo.LogoutResponse;
import tvideo.RefreshTokenResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001%B\u0013\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J4\u0010\u0010\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J6\u0010\u0011\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J4\u0010\u0013\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0012H\u0002J6\u0010\u0014\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0002J4\u0010\u0016\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0015H\u0002J6\u0010\u0017\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015H\u0002J\u0016\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u0002R\u0016\u0010'\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Leu2/b;", "", "", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "Ltvideo/LoginResponse;", "response", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ltvideo/LogoutResponse;", "t", ReportConstant.COSTREPORT_PREFIX, "Ltvideo/RefreshTokenResponse;", "v", "u", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "qqToken", QCircleDaTongConstant.ElementParamValue.MANUAL, "", DomainData.DOMAIN_NAME, "Lbu2/a;", "account", "o", "p", "priority", "w", "j", "Leu2/a;", "a", "Leu2/a;", "callback", "Leu2/e;", "b", "Leu2/e;", "requestState", "<init>", "(Leu2/a;)V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e requestState = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"eu2/b$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Ltvideo/LoginResponse;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "response", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: eu2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C10266b implements VSDispatchObserver.OnVSRspCallBack<LoginResponse> {
        C10266b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable LoginResponse response) {
            QLog.d("TVideoLoginRequestModel", 1, "login onReceive: " + response);
            b.this.k();
            if (!isSuccess || retCode != 0 || response == null || response.err_code != 0) {
                b.this.q(request, isSuccess, retCode, errMsg, response);
            } else {
                b.this.r(request, isSuccess, retCode, errMsg, response);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"eu2/b$c", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Ltvideo/LogoutResponse;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "response", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements VSDispatchObserver.OnVSRspCallBack<LogoutResponse> {
        c() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable LogoutResponse response) {
            QLog.d("TVideoLoginRequestModel", 1, "logout onReceive: " + response);
            b.this.l();
            if (!isSuccess || retCode != 0 || response == null || response.err_code != 0) {
                b.this.s(request, isSuccess, retCode, errMsg, response);
            } else {
                b.this.t(request, isSuccess, retCode, errMsg, response);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"eu2/b$d", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Ltvideo/RefreshTokenResponse;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "response", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements VSDispatchObserver.OnVSRspCallBack<RefreshTokenResponse> {
        d() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable RefreshTokenResponse response) {
            QLog.d("TVideoLoginRequestModel", 1, "refresh onReceive: " + response);
            b.this.m();
            if (!isSuccess || retCode != 0 || response == null || response.err_code != 0) {
                b.this.u(request, isSuccess, retCode, errMsg, response);
            } else {
                b.this.v(request, isSuccess, retCode, errMsg, response);
            }
        }
    }

    public b(@Nullable a aVar) {
        this.callback = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void k() {
        this.requestState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void l() {
        this.requestState.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void m() {
        this.requestState.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(BaseRequest request, boolean isSuccess, long retCode, String errMsg, LoginResponse response) {
        if (retCode != 0) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.a(eu2.c.f397144a.a(retCode));
                return;
            }
            return;
        }
        if (response == null) {
            a aVar2 = this.callback;
            if (aVar2 != null) {
                aVar2.a(eu2.c.f397144a.b());
                return;
            }
            return;
        }
        int l3 = eu2.c.f397144a.l(Integer.valueOf(response.err_code));
        String str = response.err_msg;
        a aVar3 = this.callback;
        if (aVar3 != null) {
            aVar3.a(new c.C0152c(Integer.valueOf(l3), str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(BaseRequest request, boolean isSuccess, long retCode, String errMsg, LoginResponse response) {
        TVideoAccountInfo b16 = eu2.d.f397145a.b(response);
        if (b16 != null) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.c(b16);
                return;
            }
            return;
        }
        a aVar2 = this.callback;
        if (aVar2 != null) {
            aVar2.a(eu2.c.f397144a.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(BaseRequest request, boolean isSuccess, long retCode, String errMsg, LogoutResponse response) {
        if (retCode != 0) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.b(eu2.c.f397144a.e(retCode));
                return;
            }
            return;
        }
        if (response == null) {
            a aVar2 = this.callback;
            if (aVar2 != null) {
                aVar2.b(eu2.c.f397144a.f());
                return;
            }
            return;
        }
        String str = response.err_msg + ":" + response.err_code;
        a aVar3 = this.callback;
        if (aVar3 != null) {
            aVar3.b(new c.C0152c(4, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(BaseRequest request, boolean isSuccess, long retCode, String errMsg, LogoutResponse response) {
        a aVar = this.callback;
        if (aVar != null) {
            aVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(BaseRequest request, boolean isSuccess, long retCode, String errMsg, RefreshTokenResponse response) {
        if (retCode != 0) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.f(eu2.c.f397144a.h(retCode));
                return;
            }
            return;
        }
        if (response == null) {
            a aVar2 = this.callback;
            if (aVar2 != null) {
                aVar2.f(eu2.c.f397144a.i());
                return;
            }
            return;
        }
        int m3 = eu2.c.f397144a.m(Integer.valueOf(response.err_code));
        String str = response.err_msg;
        a aVar3 = this.callback;
        if (aVar3 != null) {
            aVar3.f(new c.C0152c(Integer.valueOf(m3), str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(BaseRequest request, boolean isSuccess, long retCode, String errMsg, RefreshTokenResponse response) {
        TVideoAccountInfo c16 = eu2.d.f397145a.c(response);
        if (c16 != null) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.d(c16);
                return;
            }
            return;
        }
        a aVar2 = this.callback;
        if (aVar2 != null) {
            aVar2.f(eu2.c.f397144a.k());
        }
    }

    public final synchronized void j() {
        this.requestState.a();
    }

    public final synchronized int n(@NotNull TVideoQQConnectToken qqToken, boolean manual) {
        Intrinsics.checkNotNullParameter(qqToken, "qqToken");
        j();
        if (this.requestState.g()) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.a(eu2.c.f397144a.c());
            }
            return -1;
        }
        int sendRequest = VSNetworkHelper.getInstance().sendRequest(new VideoLoginRequest(qqToken, manual), new C10266b());
        this.requestState.i(sendRequest);
        return sendRequest;
    }

    public final synchronized int o(@NotNull bu2.a account) {
        Intrinsics.checkNotNullParameter(account, "account");
        j();
        if (this.requestState.g()) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.b(eu2.c.f397144a.g());
            }
            return -1;
        }
        int sendRequest = VSNetworkHelper.getInstance().sendRequest(new VideoLogoutRequest(account), new c());
        this.requestState.j(sendRequest);
        return sendRequest;
    }

    public final synchronized void p(@NotNull bu2.a account) {
        Intrinsics.checkNotNullParameter(account, "account");
        o(account);
        this.requestState.b();
    }

    public final synchronized int w(@NotNull bu2.a account, int priority) {
        Intrinsics.checkNotNullParameter(account, "account");
        if (this.requestState.f()) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.f(eu2.c.f397144a.j(this.requestState));
            }
            return -1;
        }
        int sendRequest = VSNetworkHelper.getInstance().sendRequest(new VideoRefreshTokenRequest(account, priority), new d());
        this.requestState.k(sendRequest);
        return sendRequest;
    }
}
