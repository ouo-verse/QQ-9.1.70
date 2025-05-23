package com.tencent.mobileqq.login.account;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u0016\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J,\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/login/account/d;", "", "", "uin", "lastLoginAccount", "", "o", "", TangramHippyConstants.LOGIN_TYPE, DomainData.DOMAIN_NAME, "d", "g", "", "Lcom/tencent/mobileqq/login/account/a;", "f", "Lcom/tencent/mobileqq/loginregister/a;", "observer", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "e", "loginAccount", "b", "p", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "proAvatarView", "size", "backupUrl", h.F, "url", "k", "", "J", "AVATAR_TIME_STAMP", "Lcom/tencent/mobileqq/login/account/d$a;", "Lcom/tencent/mobileqq/login/account/d$a;", "extraCache", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "accountChangeObservers", "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final d f241848a;

    /* renamed from: b, reason: from kotlin metadata */
    private static final long AVATAR_TIME_STAMP;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final a extraCache;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static final ArrayList<com.tencent.mobileqq.loginregister.a> accountChangeObservers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/login/account/d$a;", "", "", "uin", "Lcom/tencent/mobileqq/login/account/a;", "a", "loginAccount", "", TangramHippyConstants.LOGIN_TYPE, "", "b", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final com.tencent.mobileqq.login.account.a a(@NotNull String uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.login.account.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (TextUtils.isEmpty(uin)) {
                return null;
            }
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            String decodeString = from.decodeString("login_account_extra_info_" + uin, "");
            if (TextUtils.isEmpty(decodeString)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(decodeString);
                return new com.tencent.mobileqq.login.account.a(uin, true, jSONObject.optString("loginAccount"), "", jSONObject.optInt(TangramHippyConstants.LOGIN_TYPE));
            } catch (Exception e16) {
                QLog.e("LoginAccountManager", 1, "LoginAccountExtraCache read exception", e16);
                return null;
            }
        }

        public final void b(@NotNull String uin, @Nullable String loginAccount, int r75) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, uin, loginAccount, Integer.valueOf(r75));
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", uin);
            jSONObject.put("loginAccount", loginAccount);
            jSONObject.put(TangramHippyConstants.LOGIN_TYPE, r75);
            from.encodeString("login_account_extra_info_" + uin, jSONObject.toString());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19521);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f241848a = new d();
        AVATAR_TIME_STAMP = System.currentTimeMillis();
        extraCache = new a();
        accountChangeObservers = new ArrayList<>();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int d() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeInt("login_last_login_account_type", 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[Catch: Exception -> 0x006b, TryCatch #0 {Exception -> 0x006b, blocks: (B:12:0x0032, B:14:0x003b, B:16:0x0043, B:21:0x004f, B:23:0x0066), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String g(String uin) {
        boolean z16;
        AppRuntime peekAppRuntime;
        String str;
        boolean z17;
        String nickName = MobileQQ.sMobileQQ.getProperty(Constants.PropertiesKey.nickName.toString() + uin);
        boolean z18 = false;
        if (nickName != null && nickName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
            return nickName;
        }
        try {
            peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
        } catch (Exception e16) {
            QLog.e("LoginAccountManager", 1, "getNickNameByUin error: ", e16);
        }
        if (str != null && str.length() != 0) {
            z17 = false;
            if (!z17) {
                IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
                Friends friendFromMemoryCache = ((IFriendDataService) runtimeService).getFriendFromMemoryCache(uin);
                nickName = friendFromMemoryCache != null ? friendFromMemoryCache.name : null;
            }
            if (nickName != null || nickName.length() == 0) {
                z18 = true;
            }
            if (!z18) {
                uin = nickName;
            }
            Intrinsics.checkNotNullExpressionValue(uin, "nickName");
            return uin;
        }
        z17 = true;
        if (!z17) {
        }
        if (nickName != null) {
        }
        z18 = true;
        if (!z18) {
        }
        Intrinsics.checkNotNullExpressionValue(uin, "nickName");
        return uin;
    }

    public static /* synthetic */ void i(d dVar, QQProAvatarView qQProAvatarView, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 140;
        }
        if ((i16 & 8) != 0) {
            str2 = null;
        }
        dVar.h(qQProAvatarView, str, i3, str2);
    }

    public static final void j(String uin, int i3, QQProAvatarView proAvatarView, String str) {
        Drawable drawable;
        String str2;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(proAvatarView, "$proAvatarView");
        Resources resources = MobileQQ.sMobileQQ.getResources();
        if (resources == null || (drawable = resources.getDrawable(R.drawable.csy)) == null) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        Setting n3 = com.tencent.mobileqq.avatar.utils.c.n(uin);
        QLog.i("LoginAccountManager", 4, "loadUserAvatar " + n3);
        if (n3 != null) {
            proAvatarView.z(new com.tencent.qqnt.avatar.fetch.c(new b.a(1, uin, i3, false, 8, null).a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE).a("KEY_BEAN_KEY_SUFFIX", "sz_local_" + n3.headImgTimestamp).a(FaceConstant.ProAvatarBeanKeys.USE_LOCAL_AVATAR_INFO, n3).b(), null, drawable, null, false, null, 58, null), false);
            return;
        }
        if (str == null) {
            str2 = com.tencent.mobileqq.avatar.utils.c.c(uin);
        } else {
            str2 = str;
        }
        if (str2 == null) {
            proAvatarView.setImageDrawable(drawable);
            return;
        }
        Uri parse = Uri.parse(str2);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
        proAvatarView.z(new com.tencent.qqnt.avatar.fetch.c(new b.a(parse, false).a("KEY_BEAN_KEY_SUFFIX", str2).b(), null, drawable, null, false, null, 58, null), false);
    }

    private final void n(int i3) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeInt("login_last_login_account_type", i3);
    }

    @JvmStatic
    public static final void o(@Nullable String uin, @Nullable String lastLoginAccount) {
        String str;
        String a16;
        if (TextUtils.isEmpty(lastLoginAccount)) {
            return;
        }
        if (uin == null) {
            QLog.w("LoginAccountManager", 1, "updateLoginAccount uin is null");
            return;
        }
        QLog.i("LoginAccountManager", 1, "updateLoginAccount uin=" + StringUtil.getSimpleUinForPrint(uin));
        a aVar = extraCache;
        com.tencent.mobileqq.login.account.a a17 = aVar.a(uin);
        Intrinsics.checkNotNull(lastLoginAccount);
        if (lastLoginAccount.charAt(0) == '+') {
            if (a17 == null || (a16 = a17.a()) == null || lastLoginAccount.length() != a16.length()) {
                return;
            }
            int length = lastLoginAccount.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (lastLoginAccount.charAt(i3) != '*' && lastLoginAccount.charAt(i3) != a16.charAt(i3)) {
                    return;
                }
            }
            a17.i(1);
            extraCache.b(uin, uin, a17.b());
            QLog.i("LoginAccountManager", 1, "updateLoginAccount maskPhone changed to uin");
            return;
        }
        if (a17 != null) {
            str = a17.a();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(lastLoginAccount, str)) {
            aVar.b(uin, uin, a17.b());
            QLog.i("LoginAccountManager", 1, "updateLoginAccount qid changed to uin");
        }
    }

    public final void b(@Nullable String uin, @Nullable String loginAccount, int r85) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, uin, loginAccount, Integer.valueOf(r85));
            return;
        }
        if (uin == null) {
            QLog.w("LoginAccountManager", 1, "addLoginAccount uin is null");
            return;
        }
        QLog.i("LoginAccountManager", 1, "addLoginAccount uin=" + StringUtil.getSimpleUinForPrint(uin) + " loginType=" + r85);
        a aVar = extraCache;
        if (aVar.a(uin) == null) {
            aVar.b(uin, loginAccount, r85);
        } else {
            aVar.b(uin, loginAccount, r85);
        }
        n(r85);
    }

    public final synchronized void c(@NotNull com.tencent.mobileqq.loginregister.a observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            accountChangeObservers.add(observer);
        }
    }

    @Nullable
    public final com.tencent.mobileqq.login.account.a e(@NotNull String uin) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.login.account.a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null && (!allAccounts.isEmpty())) {
            for (SimpleAccount simpleAccount : allAccounts) {
                if (Intrinsics.areEqual(simpleAccount.getUin(), uin)) {
                    z16 = simpleAccount.isLogined();
                    break;
                }
            }
        }
        z16 = false;
        com.tencent.mobileqq.login.account.a a16 = extraCache.a(uin);
        if (a16 != null) {
            a16.h(z16);
        }
        return a16;
    }

    @NotNull
    public final List<com.tencent.mobileqq.login.account.a> f() {
        List<com.tencent.mobileqq.login.account.a> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts == null || allAccounts.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (SimpleAccount simpleAccount : allAccounts) {
            if (!TextUtils.isEmpty(simpleAccount.getUin())) {
                a aVar = extraCache;
                String uin = simpleAccount.getUin();
                Intrinsics.checkNotNullExpressionValue(uin, "simpleAccount.uin");
                com.tencent.mobileqq.login.account.a a16 = aVar.a(uin);
                if (a16 != null) {
                    a16.h(simpleAccount.isLogined());
                } else {
                    String uin2 = simpleAccount.getUin();
                    Intrinsics.checkNotNullExpressionValue(uin2, "simpleAccount.uin");
                    a16 = new com.tencent.mobileqq.login.account.a(uin2, simpleAccount.isLogined(), "", "", 0);
                }
                String uin3 = simpleAccount.getUin();
                Intrinsics.checkNotNullExpressionValue(uin3, "simpleAccount.uin");
                a16.j(g(uin3));
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    public final void h(@NotNull final QQProAvatarView proAvatarView, @NotNull final String uin, final int i3, @Nullable final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, proAvatarView, uin, Integer.valueOf(i3), str);
            return;
        }
        Intrinsics.checkNotNullParameter(proAvatarView, "proAvatarView");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.login.account.c
            @Override // java.lang.Runnable
            public final void run() {
                d.j(uin, i3, proAvatarView, str);
            }
        };
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("login_account_load_avatar_sub_thread_switch", true);
        QLog.d("LoginAccountManager", 4, "loadUserAvatar subThreadSwitch = " + isSwitchOn);
        if (isSwitchOn) {
            ThreadManagerV2.excute(runnable, 32, null, false);
        } else {
            runnable.run();
        }
    }

    public final void k(@NotNull QQProAvatarView proAvatarView, @Nullable String url) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) proAvatarView, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(proAvatarView, "proAvatarView");
        Resources resources = MobileQQ.sMobileQQ.getResources();
        if (resources == null || (drawable = resources.getDrawable(R.drawable.csy)) == null) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        Drawable drawable2 = drawable;
        if (url == null) {
            proAvatarView.setImageDrawable(drawable2);
            return;
        }
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
        proAvatarView.z(new com.tencent.qqnt.avatar.fetch.c(new b.a(parse, false).a("KEY_BEAN_KEY_SUFFIX", url).b(), null, drawable2, null, false, null, 58, null), false);
    }

    public final synchronized void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.loginregister.a> it = accountChangeObservers.iterator();
        while (it.hasNext()) {
            it.next().accountChange();
        }
    }

    public final synchronized void m(@NotNull com.tencent.mobileqq.loginregister.a observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        ArrayList<com.tencent.mobileqq.loginregister.a> arrayList = accountChangeObservers;
        if (arrayList.contains(observer)) {
            arrayList.remove(observer);
        }
    }

    public final void p(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) uin);
            return;
        }
        if (TextUtils.isEmpty(uin)) {
            QLog.e("LoginAccountManager", 1, "updateLoginAccount uin is null");
            return;
        }
        a aVar = extraCache;
        Intrinsics.checkNotNull(uin);
        com.tencent.mobileqq.login.account.a a16 = aVar.a(uin);
        if (a16 != null) {
            if (a16.b() != 4 && a16.b() != 5 && a16.b() != 7) {
                QLog.d("LoginAccountManager", 1, "updateUnbindAccount last login type is not phone");
            } else {
                a16.i(1);
                aVar.b(uin, uin, a16.b());
            }
        }
    }
}
