package com.tencent.mobileqq.login.account;

import com.tencent.mobileqq.login.account.ILoginAccountInfoApi;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/login/account/b;", "", "", "account", "a", "uin", "c", "Lmqq/manager/WtloginManager;", "d", "str", "b", "", "Z", "isLoginByNt", "<init>", "()V", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f241842a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean isLoginByNt;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32239);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f241842a = new b();
            isLoginByNt = MobileQQ.sMobileQQ.isLoginByNT();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable String account) {
        if (isLoginByNt) {
            QRouteApi api = QRoute.api(ILoginAccountInfoApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(ILoginAccountInfoApi::class.java)");
            long a16 = ILoginAccountInfoApi.a.a((ILoginAccountInfoApi) api, account, 0L, 2, null);
            QLog.i("LoginAccountInfoHelper", 1, "account2Uin: " + account + " -> " + a16);
            if (a16 > 0) {
                return String.valueOf(a16);
            }
        }
        b bVar = f241842a;
        WtloginManager d16 = bVar.d();
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        d16.getBasicUserInfo(account, wloginSimpleInfo);
        byte[] bArr = wloginSimpleInfo._nick;
        Intrinsics.checkNotNullExpressionValue(bArr, "baseInfo._nick");
        QLog.i("LoginAccountInfoHelper", 1, "account2Uin baseInfo[" + account + "] uin:[" + wloginSimpleInfo._uin + "]: [" + bVar.b(new String(bArr, Charsets.UTF_8)) + ']');
        return String.valueOf(wloginSimpleInfo._uin);
    }

    private final String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] encode = PluginBaseInfoHelper.Base64Helper.encode(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(encode, "encode(str.toByteArray(), Base64Util.NO_WRAP)");
            return new String(encode, charset);
        } catch (Exception e16) {
            QLog.e("LoginAccountInfoHelper", 1, "getEncryptedString error", e16);
            return "";
        }
    }

    @JvmStatic
    @NotNull
    public static final String c(@Nullable String uin) {
        boolean z16;
        if (isLoginByNt) {
            String nick = ((ILoginAccountInfoApi) QRoute.api(ILoginAccountInfoApi.class)).getNick(uin);
            QLog.i("LoginAccountInfoHelper", 1, "getNick: " + StringUtil.getSimpleUinForPrint(uin) + " -> " + f241842a.b(nick));
            if (nick.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return nick;
            }
        }
        b bVar = f241842a;
        WtloginManager d16 = bVar.d();
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        d16.getBasicUserInfo(uin, wloginSimpleInfo);
        byte[] bArr = wloginSimpleInfo._nick;
        Intrinsics.checkNotNullExpressionValue(bArr, "baseInfo._nick");
        String str = new String(bArr, Charsets.UTF_8);
        QLog.d("LoginAccountInfoHelper", 1, "getNick uin[" + uin + "]: " + bVar.b(str));
        return str;
    }

    private final WtloginManager d() {
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(1);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.WtloginManager");
        return (WtloginManager) manager;
    }
}
