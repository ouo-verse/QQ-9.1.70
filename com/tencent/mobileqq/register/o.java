package com.tencent.mobileqq.register;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.cb;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/register/o;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "", "phoneProtectUinsUrl", "Lcom/tencent/mobileqq/register/o$a;", "callback", "", "a", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f280527a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/register/o$a;", "", "", "onSuccess", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface a {
        void onCancel();

        void onSuccess();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J*\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/register/o$b", "Lcom/tencent/mobileqq/loginregister/utils/WebViewBridge$c;", "", "bridgeSeq", "", "event", "Landroid/os/Bundle;", "data", "", "a", "requestCode", QzoneIPCModule.RESULT_CODE, "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements WebViewBridge.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f280528a;

        b(a aVar) {
            this.f280528a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void a(int bridgeSeq, @NotNull String event, @NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(bridgeSeq), event, data);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!Intrinsics.areEqual("com.tencent.mobileqq.InvitationWebViewPlugin.registerWithNickAndPwd", event)) {
                return;
            }
            QLog.d("RegisterLimitComponent", 1, "jumpWithPhoneProtectUinsUrl onReceiveEvent");
            ReportController.y(null, "0X800B338");
            cb.f("0X800C3B6", "0X800C3B5", 0, "");
            WebViewBridge.f().n(bridgeSeq);
            this.f280528a.onSuccess();
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void b(int bridgeSeq, int requestCode, int resultCode, @Nullable Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(bridgeSeq), Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            } else if (resultCode != -1) {
                QLog.i("RegisterLimitComponent", 2, "cancel");
                cb.f("0X800C3B6", "0X800C3B5", 2, "");
                WebViewBridge.f().n(bridgeSeq);
                this.f280528a.onCancel();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25475);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f280527a = new o();
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull QBaseActivity context, @NotNull String phoneProtectUinsUrl, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneProtectUinsUrl, "phoneProtectUinsUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (TextUtils.isEmpty(phoneProtectUinsUrl)) {
            QLog.e("RegisterLimitComponent", 1, "jumpWithPhoneProtectUinsUrl error: params invalid");
            return;
        }
        QLog.d("RegisterLimitComponent", 1, "jumpWithPhoneProtectUinsUrl, phoneProtectUinsUrl: " + phoneProtectUinsUrl);
        cb.g("0X800C3B5");
        WebViewBridge.f().k(context, new b(callback)).a(context, phoneProtectUinsUrl, null, 0);
    }
}
