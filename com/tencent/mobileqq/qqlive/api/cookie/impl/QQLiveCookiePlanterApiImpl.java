package com.tencent.mobileqq.qqlive.api.cookie.impl;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.CookieDataCallback;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategyApi;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.timi.game.api.cookie.QQLiveCookieStrategyType;
import com.tencent.timi.game.api.cookie.impl.QQLiveCookiePlanter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/cookie/impl/QQLiveCookiePlanterApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/cookie/IQQLiveCookiePlanterApi;", "()V", "cookiePlanter", "Lcom/tencent/timi/game/api/cookie/impl/QQLiveCookiePlanter;", "iLiveCookie", "Lcom/tencent/timi/game/api/cookie/IQQLiveCookieStrategy;", "plantInWorkThread", "", "qqLiveCookie", "getILiveCookies", "", "", "cookies", "getSubPskey", "pskey", "plantCookies", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveCookiePlanterApiImpl implements IQQLiveCookiePlanterApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final QQLiveCookiePlanter cookiePlanter;

    @NotNull
    private final IQQLiveCookieStrategy iLiveCookie;
    private final boolean plantInWorkThread;

    @NotNull
    private final IQQLiveCookieStrategy qqLiveCookie;

    public QQLiveCookiePlanterApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.qqLiveCookie = ((IQQLiveCookieStrategyApi) QRoute.api(IQQLiveCookieStrategyApi.class)).getCookieStrategy(QQLiveCookieStrategyType.FULL);
        this.iLiveCookie = ((IQQLiveCookieStrategyApi) QRoute.api(IQQLiveCookieStrategyApi.class)).getCookieStrategy(QQLiveCookieStrategyType.ILIVE);
        this.cookiePlanter = new QQLiveCookiePlanter();
        this.plantInWorkThread = ht3.a.e("qqlive_task_cookie_policy", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> getILiveCookies(Map<String, String> cookies) {
        Map<String, String> mapOf;
        Pair[] pairArr = new Pair[2];
        String str = cookies.get(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_QQ_LIVE_PSKEY);
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_QQ_LIVE_PSKEY, str);
        String str3 = cookies.get(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN);
        if (str3 != null) {
            str2 = str3;
        }
        pairArr[1] = TuplesKt.to(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_QLIVE_P_UIN, str2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSubPskey(String pskey) {
        if (pskey != null && pskey.length() > 5) {
            String substring = pskey.substring(0, 5);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void plantCookies$lambda$0(final QQLiveCookiePlanterApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean isCookieExpired = this$0.qqLiveCookie.isCookieExpired(QQLiveCookieConstants.QQ_LIVE_DOMAIN);
        boolean isCookieExpired2 = this$0.iLiveCookie.isCookieExpired(QQLiveCookieConstants.I_LIVE_DOMAIN);
        QLog.i("QQLiveCookiePlanterApiImpl", 1, "plantCookies qqLiveExpired:" + isCookieExpired + ",iLiveExpired:" + isCookieExpired2);
        if (isCookieExpired || isCookieExpired2) {
            this$0.qqLiveCookie.removeCookies(QQLiveCookieConstants.QQ_LIVE_DOMAIN);
            this$0.iLiveCookie.removeCookies(QQLiveCookieConstants.I_LIVE_DOMAIN);
            this$0.qqLiveCookie.buildAsync(new CookieDataCallback() { // from class: com.tencent.mobileqq.qqlive.api.cookie.impl.QQLiveCookiePlanterApiImpl$plantCookies$task$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveCookiePlanterApiImpl.this);
                    }
                }

                @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
                public void onFailed(int code, @NotNull String msg2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, code, (Object) msg2);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.i("QQLiveCookiePlanterApiImpl", 1, "plant onFailed,code:" + code + ",msg:" + msg2);
                }

                @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
                public void onSuccess(@NotNull Map<String, String> cookies) {
                    QQLiveCookiePlanter qQLiveCookiePlanter;
                    QQLiveCookiePlanter qQLiveCookiePlanter2;
                    Map<String, String> iLiveCookies;
                    String subPskey;
                    IQQLiveCookieStrategy iQQLiveCookieStrategy;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) cookies);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(cookies, "cookies");
                    qQLiveCookiePlanter = QQLiveCookiePlanterApiImpl.this.cookiePlanter;
                    qQLiveCookiePlanter.c(QQLiveCookieConstants.QQ_LIVE_DOMAIN, cookies);
                    qQLiveCookiePlanter2 = QQLiveCookiePlanterApiImpl.this.cookiePlanter;
                    iLiveCookies = QQLiveCookiePlanterApiImpl.this.getILiveCookies(cookies);
                    qQLiveCookiePlanter2.c(QQLiveCookieConstants.I_LIVE_DOMAIN, iLiveCookies);
                    subPskey = QQLiveCookiePlanterApiImpl.this.getSubPskey(cookies.get("p_skey"));
                    iQQLiveCookieStrategy = QQLiveCookiePlanterApiImpl.this.qqLiveCookie;
                    QLog.i("QQLiveCookiePlanterApiImpl", 1, "plant onSuccess,cookieLegal:" + iQQLiveCookieStrategy.isCookieLegal(cookies) + ", subPskey:" + subPskey);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi
    public void plantCookies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.cookie.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveCookiePlanterApiImpl.plantCookies$lambda$0(QQLiveCookiePlanterApiImpl.this);
            }
        };
        boolean areEqual = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        QLog.i("QQLiveCookiePlanterApiImpl", 1, "plantCookies config.plantInWorkThread:" + this.plantInWorkThread + ",current.isMainThread:" + areEqual);
        if (this.plantInWorkThread && areEqual) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi
    public void plantCookies(@NotNull Map<String, String> cookies) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cookies);
            return;
        }
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        String subPskey = getSubPskey(cookies.get("p_skey"));
        QLog.i("QQLiveCookiePlanterApiImpl", 1, "plantCookies with cookies,cookieLegal:" + this.qqLiveCookie.isCookieLegal(cookies) + ", subPskey:" + subPskey);
        this.qqLiveCookie.removeCookies(QQLiveCookieConstants.QQ_LIVE_DOMAIN);
        this.iLiveCookie.removeCookies(QQLiveCookieConstants.I_LIVE_DOMAIN);
        this.cookiePlanter.c(QQLiveCookieConstants.QQ_LIVE_DOMAIN, cookies);
        this.cookiePlanter.c(QQLiveCookieConstants.I_LIVE_DOMAIN, getILiveCookies(cookies));
        QLog.d("QQLiveCookiePlanterApiImpl", 4, "plant onSuccess");
    }
}
