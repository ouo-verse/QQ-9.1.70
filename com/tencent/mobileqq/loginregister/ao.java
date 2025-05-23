package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/loginregister/ao;", "", "a", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ao {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static int f242835b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static String f242836c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static String f242837d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static String f242838e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bQ\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bX\u0010YJ$\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000bR\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u0014\u0010 \u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0011R\u0014\u0010!\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u000bR\u0014\u0010#\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u000bR\u0014\u0010$\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u000bR\u0014\u0010%\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u000bR\u0014\u0010&\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u000bR\u0014\u0010'\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0011R\u0014\u0010)\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0011R\u0014\u0010*\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0011R\u0014\u0010+\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0011R\u0014\u0010,\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0011R\u0014\u0010-\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0011R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0011R\u0014\u0010/\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010\u0011R\u0014\u00100\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0011R\u0014\u00101\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0011R\u0014\u00102\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u0010\u0011R\u0014\u00103\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u0010\u0011R\u0014\u00104\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u0010\u0011R\u0014\u00105\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u0010\u0011R\u0014\u00106\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u0010\u0011R\u0014\u00107\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u0010\u0011R\u0014\u00108\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u0010\u0011R\u0014\u00109\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u0010\u0011R\u0014\u0010:\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u0010\u0011R\u0014\u0010;\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u0010\u0011R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u0010\u0011R\u0014\u0010=\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u0010\u0011R\u0014\u0010>\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u0010\u0011R\u0014\u0010?\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b?\u0010\u0011R\u0014\u0010@\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b@\u0010\u0011R\u0014\u0010A\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bA\u0010\u0011R\u0014\u0010B\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bB\u0010\u0011R\u0014\u0010C\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bC\u0010\u0011R\u0014\u0010D\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bD\u0010\u0011R\u0014\u0010E\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bE\u0010\u0011R\u0014\u0010F\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010\u0011R\u0014\u0010G\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bG\u0010\u0011R\u0014\u0010H\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bH\u0010\u0011R\u0014\u0010I\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bI\u0010\u0011R\u0014\u0010J\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bJ\u0010\u0011R\u0014\u0010K\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bK\u0010\u0011R\u0014\u0010L\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bL\u0010\u0011R\u0014\u0010M\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bM\u0010\u0011R\u0014\u0010N\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bN\u0010\u0011R\u0014\u0010O\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bO\u0010\u0011R\u0014\u0010P\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bP\u0010\u0011R\u0014\u0010Q\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bQ\u0010\u0011R\u0014\u0010R\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bR\u0010\u0011R\u0014\u0010S\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bS\u0010\u0011R\u0014\u0010T\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bT\u0010\u0011R\u0014\u0010U\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bU\u0010\u0011R\u0014\u0010V\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bV\u0010\u0011R\u0016\u0010W\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010\u0011\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/loginregister/ao$a;", "", "", "phoneNum", "countryCode", "countryEngName", "", tl.h.F, "d", "", "mRegisterEntrance", "I", "c", "()I", "g", "(I)V", "mCountryCode", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "mCountryEnglishName", "b", "f", "DEFAULT_ENG_NAME", "EDIT_TEXT_EMPTY", "EDIT_TEXT_HAS_TEXT", "ERROR_CODE_CANCEL", "ERROR_CODE_FAILED", "ERROR_CODE_SUCCESS", "GATEWAY_REGISTER", "PHONE_NUM_REGISTER", "REGISTER_ENTRANCE_ADD_ACCOUNT", "REGISTER_ENTRANCE_GUIDE", "REGISTER_ENTRANCE_LOGIN_VERIFY_PWD", "REGISTER_ENTRANCE_MAIN", "REGISTER_ENTRANCE_OTHER", "REGISTER_ENTRANCE_PHONE_NUM_LOGIN", "REGISTER_ENTRANCE_WECHAT", "T_ACTION_SHEET_EXPOSURE", "T_CHECK_UP_SMS_CLICK", "T_EDIT_AVATAR_COMPLETE_CLICK", "T_EDIT_AVATAR_EXPOSURE", "T_GATEWAY_REGISTER_CLICK", "T_GATEWAY_REGISTER_FRAGMENT_EXPOSURE", "T_GET_MASK_PHONE_REQ", "T_GET_PHONE_SUCCESS", "T_LOGIN_SUCCESS", "T_NICKNAME_CHANGED", "T_NICK_AND_PWD_EXPOSURE_FOR_WECHAT", "T_NICK_AND_PWD_FINISH", "T_NICK_AND_PWD_START", "T_OTHER_REGISTER_CLICK", "T_PHONE_NUM_REGISTER_BACK", "T_PHONE_NUM_REGISTER_CLICK", "T_PHONE_NUM_REGISTER_CLICK_FOR_COUNTRY", "T_PHONE_NUM_REGISTER_EXPOSURE", "T_PHONE_NUM_REGISTER_GET_RESULT", "T_QUICK_REGISTER_TO_NICK_AND_PWD", "T_REGISTER_AND_LOGIN_CLICK_FOR_WECHAT", "T_REGISTER_AVATAR_SELECT", "T_REGISTER_CAPTCHA_FINISH", "T_REGISTER_CAPTCHA_START", "T_REGISTER_CODE_VERIFY_FINISH", "T_REGISTER_CODE_VERIFY_START", "T_REGISTER_FACE_VERIFY_FINISH", "T_REGISTER_FACE_VERIFY_START", "T_REGISTER_FINISH", "T_REGISTER_FRIEND_VERIFY_FINISH", "T_REGISTER_FRIEND_VERIFY_START", "T_REGISTER_GET_PHONE_TOKEN_FINISH", "T_REGISTER_GET_PHONE_TOKEN_START", "T_REGISTER_START", "T_REGISTER_UN_BIND_ACCOUNT_FINISH", "T_REGISTER_UN_BIND_ACCOUNT_START", "T_REGISTER_UP_SMS_VERIFY_FINISH", "T_REGISTER_UP_SMS_VERIFY_START", "T_SEND_SMS_CLICK", "T_SET_AVATAR_CLICK", "T_SET_AVATAR_FROM_ALBUM_CLICK", "T_SET_AVATAR_FROM_CAMERA_CLICK", "T_UP_SMS_EXPOSURE", "T_VALUE_SMS_UP_SHOW", "T_VALUE_SMS_UP_VERIFIED", "T_VERIFY_CODE_EXPOSURE", "T_VERIFY_SUCCESS", "mPhoneNum", "<init>", "()V", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.loginregister.ao$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return ao.f242837d;
            }
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return ao.f242838e;
            }
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ao.f242835b;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return ao.f242836c;
            }
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }

        public final void e(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                ao.f242837d = str;
            }
        }

        public final void f(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                ao.f242838e = str;
            }
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ao.f242835b = i3;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }

        public final void h(@Nullable String phoneNum, @Nullable String countryCode, @Nullable String countryEngName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, phoneNum, countryCode, countryEngName);
                return;
            }
            if (phoneNum == null) {
                phoneNum = "";
            }
            ao.f242836c = phoneNum;
            if (countryCode == null) {
                countryCode = "";
            }
            e(countryCode);
            if (countryEngName == null) {
                countryEngName = LocaleManager.MOBILE_COUNTRY_CODE_CN_STR;
            }
            f(countryEngName);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        f242835b = 7;
        f242836c = "";
        f242837d = "";
        f242838e = LocaleManager.MOBILE_COUNTRY_CODE_CN_STR;
    }
}
