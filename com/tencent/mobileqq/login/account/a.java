package com.tencent.mobileqq.login.account;

import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010#\u001a\u00020\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\u0013\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/login/account/a;", "", "", "c", "Lkotlin/Pair;", "e", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "uin", "b", "Z", "g", "()Z", h.F, "(Z)V", QAdLoginDefine$LoginStatus.IS_LOGIN, "setLoginAccount", "loginAccount", "d", "j", "nickname", "I", "()I", "i", "(I)V", TangramHippyConstants.LOGIN_TYPE, "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;I)V", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isLogin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String loginAccount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String nickname;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int loginType;

    public a(@NotNull String uin, boolean z16, @Nullable String str, @Nullable String str2, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uin, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
            return;
        }
        this.uin = uin;
        this.isLogin = z16;
        this.loginAccount = str;
        this.nickname = str2;
        this.loginType = i3;
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.loginAccount;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.loginType;
    }

    @Nullable
    public final String c() {
        Pair<String, String> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        int i3 = this.loginType;
        if ((i3 == 7 || i3 == 5) && (e16 = e()) != null) {
            String first = e16.getFirst();
            String second = e16.getSecond();
            if (second.length() > 5) {
                StringBuilder sb5 = new StringBuilder();
                int length = second.length() - 6;
                if (length >= 0) {
                    int i16 = 0;
                    while (true) {
                        sb5.append('*');
                        if (i16 == length) {
                            break;
                        }
                        i16++;
                    }
                }
                StringBuilder sb6 = new StringBuilder();
                String substring = second.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                sb6.append(substring);
                sb6.append((Object) sb5);
                String substring2 = second.substring(second.length() - 2);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                sb6.append(substring2);
                second = sb6.toString();
            }
            return '+' + first + TokenParser.SP + second;
        }
        return this.loginAccount;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.nickname;
    }

    @Nullable
    public final Pair<String, String> e() {
        List list;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Pair) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        int i3 = this.loginType;
        if (i3 != 7 && i3 != 5) {
            return null;
        }
        try {
            String str = this.loginAccount;
            if (str != null) {
                list = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{TokenParser.SP}, false, 0, 6, (Object) null);
            } else {
                list = null;
            }
            if (list != null && list.size() == 2) {
                String str2 = (String) list.get(0);
                String str3 = (String) list.get(1);
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, Marker.ANY_NON_NULL_MARKER, false, 2, null);
                if (startsWith$default) {
                    String substring = str2.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(str3) && bv.b(substring, 0L) != 0 && bv.b(str3, 0L) != 0) {
                        return new Pair<>(substring, str3);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.w("LoginAccount", 1, "splitPhoneNum exception", e16);
        }
        return null;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.uin, aVar.uin) && this.isLogin == aVar.isLogin && Intrinsics.areEqual(this.loginAccount, aVar.loginAccount) && Intrinsics.areEqual(this.nickname, aVar.nickname) && this.loginType == aVar.loginType) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.uin;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isLogin;
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.isLogin = z16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int hashCode2 = this.uin.hashCode() * 31;
        boolean z16 = this.isLogin;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        String str = this.loginAccount;
        int i17 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        String str2 = this.nickname;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return ((i18 + i17) * 31) + this.loginType;
    }

    public final void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.loginType = i3;
        }
    }

    public final void j(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.nickname = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "LoginAccount(uin=" + this.uin + ", isLogin=" + this.isLogin + ", loginAccount=" + this.loginAccount + ", nickname=" + this.nickname + ", loginType=" + this.loginType + ')';
    }
}
