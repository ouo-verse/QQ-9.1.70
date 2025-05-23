package com.tencent.open.agent.quickauth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.quickauth.f;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqnt.kernel.nativeinterface.IRapidLoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.RapidLoginReq;
import com.tencent.qqnt.kernel.nativeinterface.RapidLoginRsp;
import com.tencent.qqnt.kernel.nativeinterface.av;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.RSACrypt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/open/agent/quickauth/f;", "Lcom/tencent/open/agent/quickauth/j;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l", "a", "Landroid/content/Intent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Lcom/tencent/open/agent/quickauth/z;", "e", "", "Ljava/lang/String;", "mSrcPackageName", "", "f", "[B", "mPublicKey", "g", "preAccount", "Lcom/tencent/mobileqq/loginregister/servlet/f;", tl.h.F, "Lcom/tencent/mobileqq/loginregister/servlet/f;", "ssoLoginObserver", "Lcom/tencent/qqnt/kernel/nativeinterface/IRapidLoginCallback;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/IRapidLoginCallback;", "rapidLoginCallback", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/open/agent/quickauth/i;", "view", "Landroid/os/Bundle;", "mParams", "<init>", "(Landroid/app/Activity;Lcom/tencent/open/agent/quickauth/i;Landroid/os/Bundle;)V", "j", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f extends j {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSrcPackageName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] mPublicKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String preAccount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.loginregister.servlet.f ssoLoginObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRapidLoginCallback rapidLoginCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/open/agent/quickauth/f$b", "Lcom/tencent/mobileqq/loginregister/servlet/f;", "", "ssoAccount", "", "ret", "", "wtTicket", "targetTicket", "Landroid/os/Bundle;", "data", "", "b", "action", "d", "a", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends com.tencent.mobileqq.loginregister.servlet.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f340421e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f340422f;

        b(Activity activity, i iVar) {
            this.f340421e = activity;
            this.f340422f = iVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Activity activity, String str, String str2, final i view, final String str3) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(view, "$view");
            AuthUIUtil.g(activity, str, str2, new DialogInterface.OnClickListener() { // from class: com.tencent.open.agent.quickauth.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    f.b.h(i.this, str3, dialogInterface, i3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(i view, String str, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(view, "$view");
            if (str == null) {
                str = "";
            }
            view.F0(str);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void a(@Nullable final String ssoAccount, int action, int ret, @Nullable Bundle data) {
            ErrMsg errMsg;
            String string;
            String title;
            com.tencent.open.agent.util.t.e(SSOAccountObserver.TAG, "-->onFailed--action = " + action + ", ret = " + ret + ", ssoAccount = *" + com.tencent.open.agent.util.g.C(ssoAccount));
            this.f340422f.L();
            if (ret == -1000) {
                Activity activity = this.f340421e;
                AuthUIUtil.h(activity, activity.getResources().getString(R.string.f171155cp4));
                return;
            }
            String str = null;
            if (data != null) {
                errMsg = (ErrMsg) data.getParcelable("errMsg");
            } else {
                errMsg = null;
            }
            if (errMsg != null) {
                str = errMsg.getMessage();
            }
            if (!TextUtils.isEmpty(str)) {
                string = str + "(" + ret + ")";
            } else {
                string = this.f340421e.getString(R.string.f171152cp0);
            }
            final String str2 = string;
            if (errMsg == null) {
                title = this.f340421e.getString(R.string.h5k);
            } else {
                title = errMsg.getTitle();
            }
            final String str3 = title;
            com.tencent.open.agent.util.t.e(SSOAccountObserver.TAG, "ssoAccount failed, error: " + errMsg);
            final Activity activity2 = this.f340421e;
            final i iVar = this.f340422f;
            activity2.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.quickauth.g
                @Override // java.lang.Runnable
                public final void run() {
                    f.b.g(activity2, str3, str2, iVar, ssoAccount);
                }
            });
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void b(@Nullable String ssoAccount, int ret, @NotNull byte[] wtTicket, int targetTicket, @Nullable Bundle data) {
            String message;
            Intrinsics.checkNotNullParameter(wtTicket, "wtTicket");
            com.tencent.open.agent.util.t.f(SSOAccountObserver.TAG, "-->onGetA1WithA1--ret = " + ret + ", ssoAccount = *" + com.tencent.open.agent.util.g.C(ssoAccount));
            f fVar = f.this;
            String b16 = OpenSdkVirtualUtil.b(ssoAccount);
            Intrinsics.checkNotNullExpressionValue(b16, "account2uin(ssoAccount)");
            fVar.n(b16);
            ErrMsg errMsg = null;
            f.this.preAccount = null;
            byte[] EncryptData = new RSACrypt(this.f340421e).EncryptData(f.this.mPublicKey, wtTicket);
            if (data != null) {
                errMsg = (ErrMsg) data.getParcelable("errMsg");
            }
            i iVar = this.f340422f;
            String currentAccount = f.this.getCurrentAccount();
            if (errMsg == null) {
                message = "";
            } else {
                message = errMsg.getMessage();
            }
            iVar.r0(ret, EncryptData, currentAccount, message);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void d(@Nullable String ssoAccount, int action, @Nullable Bundle data) {
            com.tencent.open.agent.util.t.f(SSOAccountObserver.TAG, "-->onUserCancel--action = " + action + ", ssoAccount = *" + com.tencent.open.agent.util.g.C(ssoAccount));
            this.f340422f.L();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Activity activity, @NotNull final i view, @NotNull Bundle mParams) {
        super(activity, view, mParams);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mParams, "mParams");
        this.mPublicKey = mParams.getByteArray("publickey");
        this.mSrcPackageName = mParams.getString("packagename");
        this.ssoLoginObserver = new b(activity, view);
        this.rapidLoginCallback = new IRapidLoginCallback() { // from class: com.tencent.open.agent.quickauth.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IRapidLoginCallback
            public final void onResult(RapidLoginRsp rapidLoginRsp) {
                f.A(f.this, view, rapidLoginRsp);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(f this$0, i view, RapidLoginRsp rapidLoginRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        this$0.preAccount = null;
        if (rapidLoginRsp == null) {
            com.tencent.open.agent.util.t.f("AppQuickAuthHandler", "rapidLoginCb onResult rsp is null");
            view.r0(Integer.MIN_VALUE, null, this$0.getCurrentAccount(), "login api return null");
            return;
        }
        com.tencent.open.agent.util.t.f("AppQuickAuthHandler", "rapidLoginCb onResult rsp: " + rapidLoginRsp);
        if (rapidLoginRsp.retCode == 0 && !TextUtils.isEmpty(rapidLoginRsp.url)) {
            view.r0(rapidLoginRsp.retCode, Base64.decode(rapidLoginRsp.url, 2), this$0.getCurrentAccount(), rapidLoginRsp.errorMsg);
        } else {
            view.r0(rapidLoginRsp.retCode, null, this$0.getCurrentAccount(), rapidLoginRsp.errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final f this$0, final boolean z16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.quickauth.d
            @Override // java.lang.Runnable
            public final void run() {
                f.w(z16, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(boolean z16, f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.z();
        } else {
            this$0.getView().u0();
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.cp9, 0).show(this$0.h().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final f this$0, final boolean z16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.quickauth.e
            @Override // java.lang.Runnable
            public final void run() {
                f.y(z16, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(boolean z16, f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            com.tencent.open.agent.util.t.b("AppQuickAuthHandler", "login have");
            this$0.getView().q0();
        } else {
            this$0.getView().u0();
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.cp9, 0).show(this$0.h().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    private final void z() {
        byte[] bArr;
        getView().showProgress(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getString(R.string.f171153cp1));
        long j3 = getMParams().getLong("dstSsoVer", 0L);
        long j16 = getMParams().getLong("subDstAppid", 0L);
        long j17 = getMParams().getLong("dstAppid", 0L);
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            RapidLoginReq rapidLoginReq = new RapidLoginReq();
            rapidLoginReq.uin = Long.parseLong(getCurrentAccount());
            rapidLoginReq.destAppid = j17;
            rapidLoginReq.destSubAppid = j16;
            rapidLoginReq.publicKey = com.tencent.open.agent.util.s.a(this.mPublicKey);
            rapidLoginReq.bundleId = this.mSrcPackageName;
            com.tencent.open.agent.util.t.b("AppQuickAuthHandler", "doAuthorize rapidReq: " + rapidLoginReq);
            av.z().rapidLogin(rapidLoginReq, this.rapidLoginCallback);
            return;
        }
        byte[] byteArray = getMParams().getByteArray("dstAppVer");
        Manager manager = d().getManager(1);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.WtloginManager");
        byte[] a16 = com.tencent.open.agent.util.n.a(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), this.mSrcPackageName);
        Bundle bundle = new Bundle();
        if (!((WtloginManager) manager).isUserHaveA1(getCurrentAccount(), 16L)) {
            bundle.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            bundle.putLong("dwSubSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILoginServletService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026onstant.ALL\n            )");
        ILoginServletService iLoginServletService = (ILoginServletService) runtimeService;
        String currentAccount = getCurrentAccount();
        String str = this.mSrcPackageName;
        if (str != null) {
            bArr = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        } else {
            bArr = null;
        }
        iLoginServletService.ssoGetA1WithA1(currentAccount, bArr, j3, j17, j16, byteArray, a16, this.ssoLoginObserver, bundle);
    }

    @Override // com.tencent.open.agent.quickauth.j
    public void a() {
        com.tencent.open.agent.util.g.g(getCurrentAccount(), new com.tencent.open.agent.util.u() { // from class: com.tencent.open.agent.quickauth.b
            @Override // com.tencent.open.agent.util.u
            public final void onResult(boolean z16, String str) {
                f.v(f.this, z16, str);
            }
        });
    }

    @Override // com.tencent.open.agent.quickauth.j
    public void b() {
        com.tencent.open.agent.util.g.g(getCurrentAccount(), new com.tencent.open.agent.util.u() { // from class: com.tencent.open.agent.quickauth.c
            @Override // com.tencent.open.agent.util.u
            public final void onResult(boolean z16, String str) {
                f.x(f.this, z16, str);
            }
        });
    }

    @Override // com.tencent.open.agent.quickauth.j
    @NotNull
    public QuickAuthApp e() {
        String str;
        String string = getMParams().getString("packagename");
        if (string != null) {
            str = ad.f340395a.b(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), string);
        } else {
            str = "";
        }
        return new QuickAuthApp(str, 0L, string, "");
    }

    @Override // com.tencent.open.agent.quickauth.j
    public void l() {
        getView().n1(null);
    }

    @Override // com.tencent.open.agent.quickauth.j
    public void m(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("key_req_src", 2);
        intent.putExtra("appid", String.valueOf(getMParams().getLong("dstAppid", 0L)));
    }
}
