package com.tencent.mobileqq.qwallet.h5;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.mobileqq.qwallet.openlogin.QWalletOAuthLoginManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0002J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/b;", "", "", "url", "", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$Cookie;", "cookies", "", "e", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "appId", "", "appType", "f", "", "b", "c", "d", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f277185a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qwallet/h5/b$a", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$c;", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthResult;", "oauthResult", "", "a", "", "retCode", "", "retMsg", "Lcom/tencent/mobileqq/qwallet/openlogin/QWalletOAuthLoginManager$OAuthStatisticBean;", "statisticBean", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements QWalletOAuthLoginManager.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f277186a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277187b;

        a(int i3, String str) {
            this.f277186a = i3;
            this.f277187b = str;
        }

        @Override // com.tencent.mobileqq.qwallet.openlogin.QWalletOAuthLoginManager.c
        public void a(@NotNull QWalletOAuthLoginManager.OAuthResult oauthResult) {
            Intrinsics.checkNotNullParameter(oauthResult, "oauthResult");
            QLog.i("FinancialOpenPreAuthModule", 1, "pre login success");
            if (this.f277186a == 6) {
                b.f277185a.d(this.f277187b);
            }
        }

        @Override // com.tencent.mobileqq.qwallet.openlogin.QWalletOAuthLoginManager.c
        public void b(int retCode, @NotNull String retMsg, @NotNull QWalletOAuthLoginManager.OAuthStatisticBean statisticBean) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            Intrinsics.checkNotNullParameter(statisticBean, "statisticBean");
            QLog.i("FinancialOpenPreAuthModule", 1, "pre login fail: " + retCode + " " + retMsg);
        }
    }

    b() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        if (r6 != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(String url, List<QWalletOAuthLoginManager.Cookie> cookies) {
        boolean z16;
        List filterNotNull;
        boolean z17;
        boolean z18;
        boolean contains$default;
        List<QWalletOAuthLoginManager.Cookie> list = cookies;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("FinancialOpenPreAuthModule", 1, "plainCookies fail, cookies is null");
            return;
        }
        CookieSyncManager.createInstance(MobileQQ.sMobileQQ);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(cookies);
        ArrayList<QWalletOAuthLoginManager.Cookie> arrayList = new ArrayList();
        for (Object obj : filterNotNull) {
            QWalletOAuthLoginManager.Cookie cookie = (QWalletOAuthLoginManager.Cookie) obj;
            if (url != null) {
                String domain = cookie.getDomain();
                if (domain != null && domain.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) cookie.getDomain(), false, 2, (Object) null);
                }
                z17 = false;
                if (!z17) {
                    arrayList.add(obj);
                }
            }
            z17 = true;
            if (!z17) {
            }
        }
        for (QWalletOAuthLoginManager.Cookie cookie2 : arrayList) {
            cookieManager.setCookie(cookie2.getDomain(), cookie2.toString());
            QLog.i("FinancialOpenPreAuthModule", 1, "plainCookies: " + cookie2);
        }
        CookieSyncManager.getInstance().sync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String str, WeakReference activityRef, int i3, String url) {
        Intrinsics.checkNotNullParameter(activityRef, "$activityRef");
        Intrinsics.checkNotNullParameter(url, "$url");
        QWalletOAuthLoginManager qWalletOAuthLoginManager = QWalletOAuthLoginManager.f278603a;
        if (qWalletOAuthLoginManager.h(str) != null) {
            QLog.i("FinancialOpenPreAuthModule", 1, "pre login finish, has cache.");
        } else {
            qWalletOAuthLoginManager.j(activityRef, true, str, Integer.valueOf(i3), url, new a(i3, url));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(@Nullable String url) {
        boolean z16;
        boolean contains$default;
        boolean contains$default2;
        if (url == null) {
            return false;
        }
        CookieSyncManager.createInstance(MobileQQ.sMobileQQ);
        String cookie = CookieManager.getInstance().getCookie(url);
        if (cookie != null) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) cookie, (CharSequence) "qpay-lc-skey", false, 2, (Object) null);
            if (contains$default2) {
                z16 = true;
                if (z16) {
                    Intrinsics.checkNotNullExpressionValue(cookie, "cookie");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) cookie, (CharSequence) "qpay-lc-openid", false, 2, (Object) null);
                    if (contains$default) {
                        QLog.i("FinancialOpenPreAuthModule", 1, "has login cookie: " + cookie);
                        return true;
                    }
                }
                return false;
            }
        }
        z16 = false;
        if (z16) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:0: B:28:0x0073->B:45:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(@NotNull String url) {
        List<QWalletOAuthLoginManager.Cookie> list;
        boolean z16;
        boolean z17;
        boolean contains$default;
        boolean z18;
        List<QWalletOAuthLoginManager.Cookie> b16;
        boolean contains$default2;
        boolean z19;
        boolean contains$default3;
        boolean contains$default4;
        Intrinsics.checkNotNullParameter(url, "url");
        CookieSyncManager.createInstance(MobileQQ.sMobileQQ);
        String webCookies = CookieManager.getInstance().getCookie(url);
        List<QWalletOAuthLoginManager.Cookie> list2 = null;
        QWalletOAuthLoginManager.OAuthResult h16 = QWalletOAuthLoginManager.f278603a.h(null);
        if (h16 != null) {
            list = h16.b();
        } else {
            list = null;
        }
        List<QWalletOAuthLoginManager.Cookie> list3 = list;
        if (list3 != null && !list3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (webCookies != null) {
            contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) webCookies, (CharSequence) "qpay-lc-skey", false, 2, (Object) null);
            if (contains$default4) {
                z17 = true;
                if (z17) {
                    Intrinsics.checkNotNullExpressionValue(webCookies, "webCookies");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) webCookies, (CharSequence) "qpay-lc-openid", false, 2, (Object) null);
                    if (contains$default) {
                        if (h16 != null && (b16 = h16.b()) != null) {
                            List<QWalletOAuthLoginManager.Cookie> list4 = b16;
                            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                                for (QWalletOAuthLoginManager.Cookie cookie : list4) {
                                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) webCookies, (CharSequence) cookie.getName(), false, 2, (Object) null);
                                    if (contains$default2) {
                                        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) webCookies, (CharSequence) cookie.getValue(), false, 2, (Object) null);
                                        if (!contains$default3) {
                                            z19 = true;
                                            if (!z19) {
                                                z18 = true;
                                                break;
                                            }
                                        }
                                    }
                                    z19 = false;
                                    if (!z19) {
                                    }
                                }
                            }
                        }
                        z18 = false;
                        if (z18) {
                            QWalletOAuthLoginManager.f278603a.f();
                            if (h16 != null) {
                                list2 = h16.b();
                            }
                            QLog.i("FinancialOpenPreAuthModule", 1, "remove invalid cookie cache, web=" + webCookies + " cache=" + list2);
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z17 = false;
        if (z17) {
        }
        return false;
    }

    public final boolean d(@Nullable String url) {
        boolean contains$default;
        List<QWalletOAuthLoginManager.Cookie> list = null;
        if (url != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) IQWalletKuiklyApi.URL_ABILITY_KEY_H5_PRELOGIN, false, 2, (Object) null);
            if (!contains$default) {
                return false;
            }
            QLog.i("FinancialOpenPreAuthModule", 1, "start check login: " + url);
            if (b(url)) {
                QLog.i("FinancialOpenPreAuthModule", 1, "checkPreLogin finish: has cookies");
                return true;
            }
        }
        QWalletOAuthLoginManager.OAuthResult h16 = QWalletOAuthLoginManager.f278603a.h(null);
        if (h16 != null) {
            list = h16.b();
        }
        e(url, list);
        QLog.i("FinancialOpenPreAuthModule", 1, "plain cookies finish");
        if (!b(url)) {
            return false;
        }
        QLog.i("FinancialOpenPreAuthModule", 1, "double checkPreLogin finish: has cookies");
        return true;
    }

    public final void f(@NotNull QBaseActivity activity, @Nullable final String appId, final int appType, @NotNull final String url) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) IQWalletKuiklyApi.URL_ABILITY_KEY_KUIKLY_PRELOGIN, false, 2, (Object) null);
        if (contains$default && !activity.isDestroyed() && !activity.isFinishing()) {
            final WeakReference weakReference = new WeakReference(activity);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.h5.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.g(appId, weakReference, appType, url);
                }
            }, 32, null, true);
        }
    }
}
