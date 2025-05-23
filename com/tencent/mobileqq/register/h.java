package com.tencent.mobileqq.register;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.cb;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J.\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/register/h;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "", "code", "", "strMsg", "requestCode", "Lam2/a;", "callBack", "", "a", "url", "b", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f280443a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/register/h$a;", "Lcom/tencent/mobileqq/loginregister/utils/WebViewBridge$c;", "", "c", "", "bridgeSeq", "", "event", "Landroid/os/Bundle;", "data", "a", "requestCode", QzoneIPCModule.RESULT_CODE, "b", "I", "mCode", "mRequestCode", "", "Z", "mFaceRecognizeWebBack", "d", "mReceiveFaceBroadcast", "Lam2/a;", "e", "Lam2/a;", "mCallBack", "callBack", "<init>", "(Lam2/a;II)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements WebViewBridge.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int mCode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int mRequestCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean mFaceRecognizeWebBack;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean mReceiveFaceBroadcast;

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
            cb.f("0X800B7C8", "0X800C3AD", 0, "");
            this.mCallBack.a(bundle);
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void a(int bridgeSeq, @Nullable String event, @Nullable Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(bridgeSeq), event, data);
                return;
            }
            if (!Intrinsics.areEqual("action_qq_register_face_recognize_assist", event)) {
                return;
            }
            QLog.i("FaceVerifyComponent", 1, "FaceRecognizeCallBack");
            if (data == null) {
                QLog.e("FaceVerifyComponent", 1, "FaceRecognizeCallBack: data is null");
                return;
            }
            String string = data.getString("reg_sig");
            String string2 = data.getString(MsfConstants.ATTRIBUTE_MAP_FACE_RESULT);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                q.c().j(new com.tencent.mobileqq.register.bean.b(string, string2));
                this.mReceiveFaceBroadcast = true;
                if (!this.mFaceRecognizeWebBack) {
                    return;
                }
                WebViewBridge.f().n(bridgeSeq);
                c();
                return;
            }
            QLog.e("FaceVerifyComponent", 1, "FaceRecognizeCallBack: face result is empty");
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
            QLog.i("FaceVerifyComponent", 1, "doOnActivityResult REQUEST_CODE_FACE_RECOGNIZE");
            if (resultCode != -1) {
                QLog.i("FaceVerifyComponent", 2, "cancel");
                cb.f("0X800B7C8", "0X800C3AD", 2, "");
                WebViewBridge.f().n(bridgeSeq);
                this.mCallBack.onCancel();
                return;
            }
            this.mFaceRecognizeWebBack = true;
            if (this.mReceiveFaceBroadcast) {
                WebViewBridge.f().n(bridgeSeq);
                c();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f280443a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull QBaseActivity context, int code, @Nullable String strMsg, int requestCode, @NotNull am2.a callBack) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("https://graph.qq.com/safe/face/identification?authType=regist&regsig=%s&uin=1854000000", Arrays.copyOf(new Object[]{strMsg}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        f280443a.b(context, code, format, requestCode, callBack);
    }

    public final void b(@NotNull QBaseActivity context, int code, @NotNull String url, int requestCode, @NotNull am2.a callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(code), url, Integer.valueOf(requestCode), callBack);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        QLog.i("FaceVerifyComponent", 1, "startFaceVerify");
        cb.g("0X800C3AD");
        WebViewBridge.f().k(context, new a(callBack, code, requestCode)).a(context, url, null, requestCode);
        q.c().l(5);
        q.c().j(null);
    }
}
