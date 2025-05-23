package com.tencent.mobileqq.register;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.ce;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/register/i;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "", "code", "", "strMsg", "requestCode", "Lam2/a;", "callBack", "", "a", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f280449a;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/register/i$a;", "Lcom/tencent/mobileqq/loginregister/utils/WebViewBridge$c;", "", "c", "", "bridgeSeq", "", "event", "Landroid/os/Bundle;", "data", "a", "requestCode", QzoneIPCModule.RESULT_CODE, "b", "I", "mCode", "mRequestCode", "", "Z", "mFriendVerifyWebBack", "d", "mFriendVerifyBroadcast", "Lam2/a;", "e", "Lam2/a;", "mCallBack", "callBack", "<init>", "(Lam2/a;II)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private static final class a implements WebViewBridge.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int mCode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int mRequestCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean mFriendVerifyWebBack;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean mFriendVerifyBroadcast;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final am2.a mCallBack;

        public a(@NotNull am2.a callBack, int i3, int i16) {
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, callBack, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.mCode = i3;
            this.mRequestCode = i16;
            this.mCallBack = callBack;
        }

        private final void c() {
            Bundle bundle = new Bundle();
            bundle.putInt("key_verify_code", this.mCode);
            cb.f("0X800C3B0", "0X8009C5D", 0, "");
            this.mCallBack.a(bundle);
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void a(int bridgeSeq, @Nullable String event, @Nullable Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(bridgeSeq), event, data);
                return;
            }
            if (!Intrinsics.areEqual("com.tencent.mobileqq.InvitationWebViewPlugin.guaranteeNotice", event)) {
                return;
            }
            QLog.i("FriendVerifyComponent", 1, "FriendVerifyCallBack");
            if (data == null) {
                QLog.e("FriendVerifyComponent", 1, "FriendVerifyCallBack: data is null");
                return;
            }
            if (!data.getBoolean("friend_verify_guaranteed", false)) {
                QLog.e("FriendVerifyComponent", 1, "FriendVerifyCallBack: guaranteed is false");
                return;
            }
            this.mFriendVerifyBroadcast = true;
            if (!this.mFriendVerifyWebBack) {
                return;
            }
            WebViewBridge.f().n(bridgeSeq);
            c();
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void b(int bridgeSeq, int requestCode, int resultCode, @Nullable Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(bridgeSeq), Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
                return;
            }
            if (this.mRequestCode != requestCode) {
                return;
            }
            QLog.i("FriendVerifyComponent", 1, "doOnActivityResult REQUEST_CODE_FRIEND_VERIFY");
            if (resultCode != -1) {
                QLog.i("FriendVerifyComponent", 2, "cancel");
                cb.f("0X800C3B0", "0X8009C5D", 2, "");
                WebViewBridge.f().n(bridgeSeq);
                this.mCallBack.onCancel();
                return;
            }
            this.mFriendVerifyWebBack = true;
            if (this.mFriendVerifyBroadcast) {
                WebViewBridge.f().n(bridgeSeq);
                c();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f280449a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull QBaseActivity context, int code, @Nullable String strMsg, int requestCode, @NotNull am2.a callBack) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        QLog.i("FriendVerifyComponent", 1, "startFriendVerify");
        if (TextUtils.isEmpty(strMsg)) {
            QLog.e("FriendVerifyComponent", 1, "gotoFriendVerify, url is empty");
            ce.k(R.string.g0j, 1);
            callBack.b();
        } else {
            cb.g("0X8009C5D");
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
            WebViewBridge.f().k(context, new a(callBack, code, requestCode)).a(context, strMsg, bundle, requestCode);
            q.c().l(4);
        }
    }
}
