package com.tencent.mobileqq.login.account.impl;

import com.tencent.mobileqq.login.account.ILoginAccountInfoApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/login/account/impl/LoginAccountInfoApiImpl;", "Lcom/tencent/mobileqq/login/account/ILoginAccountInfoApi;", "", "account", "", "def", "account2Uin", "uin", "getNick", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LoginAccountInfoApiImpl implements ILoginAccountInfoApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String KEY_LOGIN_ACCOUNT_UIN_PREFIX = "login_account_uin_";

    @NotNull
    private static final String KEY_LOGIN_UIN_NICK_PREFIX = "login_uin_info_";

    @NotNull
    private static final String TAG = "LoginAccountInfoApiImpl";

    @NotNull
    private static final MMKVOptionEntity entity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/login/account/impl/LoginAccountInfoApiImpl$a;", "", "", "account", "", "a", "uin", "nick", "", "b", "KEY_LOGIN_ACCOUNT_UIN_PREFIX", "Ljava/lang/String;", "KEY_LOGIN_UIN_NICK_PREFIX", "TAG", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.account.impl.LoginAccountInfoApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        
            r8 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r8);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(@Nullable String account) {
            long j3;
            Long longOrNull;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) account)).booleanValue();
            }
            try {
                if (MobileQQ.sMobileQQ.isLoginByNT()) {
                    j3 = 4200000000L;
                } else {
                    j3 = 4000000000L;
                }
                if (account == null || longOrNull == null) {
                    return false;
                }
                long longValue = longOrNull.longValue();
                if (10000 > longValue || longValue > j3) {
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
                return false;
            }
        }

        public final void b(@NotNull String account, @Nullable String uin, @Nullable String nick) {
            boolean z16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, account, uin, nick);
                return;
            }
            Intrinsics.checkNotNullParameter(account, "account");
            QLog.d(LoginAccountInfoApiImpl.TAG, 4, "saveLoginAccountInfo account: " + account + " uin: " + uin + " nick: " + nick);
            boolean z17 = false;
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.e(LoginAccountInfoApiImpl.TAG, 1, "saveLoginAccountInfo uin is null or empty. [" + uin + "]");
            }
            MMKVOptionEntity mMKVOptionEntity = LoginAccountInfoApiImpl.entity;
            String str2 = LoginAccountInfoApiImpl.KEY_LOGIN_ACCOUNT_UIN_PREFIX + account;
            if (uin == null) {
                str = "";
            } else {
                str = uin;
            }
            mMKVOptionEntity.encodeString(str2, str);
            if (nick == null || nick.length() == 0) {
                z17 = true;
            }
            if (z17) {
                QLog.e(LoginAccountInfoApiImpl.TAG, 1, "saveLoginAccountInfo nick is null or empty. [" + nick + "]");
            }
            MMKVOptionEntity mMKVOptionEntity2 = LoginAccountInfoApiImpl.entity;
            String str3 = LoginAccountInfoApiImpl.KEY_LOGIN_UIN_NICK_PREFIX + uin;
            if (nick == null) {
                nick = "";
            }
            mMKVOptionEntity2.encodeString(str3, nick);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19536);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        entity = from;
    }

    public LoginAccountInfoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.login.account.ILoginAccountInfoApi
    public long account2Uin(@Nullable String account, long def) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, this, account, Long.valueOf(def))).longValue();
        }
        if (account == null) {
            return 0L;
        }
        if (INSTANCE.a(account)) {
            if (getNick(account).length() > 0) {
                z16 = true;
            }
            if (z16) {
                return Long.parseLong(account);
            }
            QLog.e(TAG, 1, "account2Uin getNick is empty, return 0");
            return 0L;
        }
        String decodeString = entity.decodeString(KEY_LOGIN_ACCOUNT_UIN_PREFIX + account, "");
        if (decodeString != null) {
            try {
                def = Long.parseLong(decodeString);
            } catch (NumberFormatException unused) {
            }
        }
        QLog.i(TAG, 4, "account2Uin account: " + account + " -> uin: " + def);
        return def;
    }

    @Override // com.tencent.mobileqq.login.account.ILoginAccountInfoApi
    @NotNull
    public String getNick(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin);
        }
        String nick = entity.decodeString(KEY_LOGIN_UIN_NICK_PREFIX + uin, "");
        QLog.d(TAG, 4, "getNick uin: " + uin + " -> nick: " + nick);
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        return nick;
    }

    @Override // com.tencent.mobileqq.login.account.ILoginAccountInfoApi
    @NotNull
    public String getNick(long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? getNick(String.valueOf(uin)) : (String) iPatchRedirector.redirect((short) 4, (Object) this, uin);
    }
}
