package com.tencent.mobileqq.loginregister.impl;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.loginregister.IPrettyAccountRegisterApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.prettyaccount.PrettyAccountRegisterAutoLoginHelper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/loginregister/impl/PrettyAccountRegisterApiImpl;", "Lcom/tencent/mobileqq/loginregister/IPrettyAccountRegisterApi;", "", "uin", "pwd", PreloadTRTCPlayerParams.KEY_SIG, "Lcom/tencent/mobileqq/login/aa;", "callback", "", "login", "Lcom/tencent/mobileqq/register/prettyaccount/PrettyAccountRegisterAutoLoginHelper;", "helper", "Lcom/tencent/mobileqq/register/prettyaccount/PrettyAccountRegisterAutoLoginHelper;", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PrettyAccountRegisterApiImpl implements IPrettyAccountRegisterApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "PrettyAccountRegisterApi";

    @NotNull
    private final PrettyAccountRegisterAutoLoginHelper helper;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/loginregister/impl/PrettyAccountRegisterApiImpl$a;", "", "", PreloadTRTCPlayerParams.KEY_SIG, "", "c", ReportConstant.COSTREPORT_PREFIX, "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.loginregister.impl.PrettyAccountRegisterApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        private final byte[] b(String s16) {
            int length = s16.length();
            if (length % 2 != 0) {
                return new byte[0];
            }
            try {
                byte[] bArr = new byte[length / 2];
                for (int i3 = 0; i3 < length; i3 += 2) {
                    bArr[i3 / 2] = (byte) ((Character.digit(s16.charAt(i3), 16) << 4) + Character.digit(s16.charAt(i3 + 1), 16));
                }
                return bArr;
            } catch (Exception e16) {
                QLog.e(PrettyAccountRegisterApiImpl.TAG, 1, "hexStringToByteArray exception", e16);
                return new byte[0];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final byte[] c(String sig) {
            if (MobileQQ.sMobileQQ.isLoginByNT()) {
                byte[] bytes = sig.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            return b(sig);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PrettyAccountRegisterApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.helper = new PrettyAccountRegisterAutoLoginHelper();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.IPrettyAccountRegisterApi
    public void login(@NotNull String uin, @NotNull String pwd, @NotNull String sig, @Nullable aa callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uin, pwd, sig, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        Intrinsics.checkNotNullParameter(sig, "sig");
        QLog.i(TAG, 1, "login " + MsfSdkUtils.getShortUin(uin));
        this.helper.m(uin, pwd, INSTANCE.c(sig), callback);
    }
}
