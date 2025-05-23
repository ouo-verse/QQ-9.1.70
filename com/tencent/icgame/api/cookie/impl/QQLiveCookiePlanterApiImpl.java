package com.tencent.icgame.api.cookie.impl;

import android.os.Looper;
import com.tencent.icgame.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.icgame.api.cookie.IQQLiveCookieStrategyApi;
import com.tencent.icgame.api.cookie.QQLiveCookieStrategyType;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.CookieDataCallback;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/icgame/api/cookie/impl/QQLiveCookiePlanterApiImpl;", "Lcom/tencent/icgame/api/cookie/IQQLiveCookiePlanterApi;", "()V", "cookiePlanter", "Lcom/tencent/icgame/api/cookie/impl/QQLiveCookiePlanter;", "cookieStrategy", "Lcom/tencent/timi/game/api/cookie/IQQLiveCookieStrategy;", "domain", "", "getSubPskey", "pskey", "plantCookies", "", "cookies", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class QQLiveCookiePlanterApiImpl implements IQQLiveCookiePlanterApi {

    @NotNull
    private final IQQLiveCookieStrategy cookieStrategy = ((IQQLiveCookieStrategyApi) QRoute.api(IQQLiveCookieStrategyApi.class)).getCookieStrategy(QQLiveCookieStrategyType.FULL);

    @NotNull
    private final QQLiveCookiePlanter cookiePlanter = new QQLiveCookiePlanter();

    @NotNull
    private final String domain = QQLiveCookieConstants.NOW_DOMAIN;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/api/cookie/impl/QQLiveCookiePlanterApiImpl$a", "Lcom/tencent/timi/game/api/cookie/CookieDataCallback;", "", "", "cookies", "", "onSuccess", "", "code", "msg", "onFailed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements CookieDataCallback {
        a() {
        }

        @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
        public void onFailed(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("ICGameCookiePlanterApiImpl", 1, "plant onFailed,code:" + code + ",msg:" + msg2);
        }

        @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
        public void onSuccess(@NotNull Map<String, String> cookies) {
            Intrinsics.checkNotNullParameter(cookies, "cookies");
            QQLiveCookiePlanterApiImpl.this.cookiePlanter.c(QQLiveCookiePlanterApiImpl.this.domain, cookies);
            String subPskey = QQLiveCookiePlanterApiImpl.this.getSubPskey(cookies.get("p_skey"));
            QLog.i("ICGameCookiePlanterApiImpl", 1, "plant onSuccess,cookieLegal:" + QQLiveCookiePlanterApiImpl.this.cookieStrategy.isCookieLegal(cookies) + ", subPskey:" + subPskey);
        }
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
    public static final void plantCookies$lambda$0(QQLiveCookiePlanterApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean isCookieExpired = this$0.cookieStrategy.isCookieExpired(this$0.domain);
        QLog.i("ICGameCookiePlanterApiImpl", 1, "plantCookies cookieExpired:" + isCookieExpired);
        if (isCookieExpired) {
            this$0.cookieStrategy.removeCookies(this$0.domain);
            this$0.cookieStrategy.buildAsync(new a());
        }
    }

    @Override // com.tencent.icgame.api.cookie.IQQLiveCookiePlanterApi
    public void plantCookies() {
        Runnable runnable = new Runnable() { // from class: com.tencent.icgame.api.cookie.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveCookiePlanterApiImpl.plantCookies$lambda$0(QQLiveCookiePlanterApiImpl.this);
            }
        };
        boolean areEqual = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        QLog.i("ICGameCookiePlanterApiImpl", 1, "plantCookies");
        if (areEqual) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.icgame.api.cookie.IQQLiveCookiePlanterApi
    public void plantCookies(@NotNull Map<String, String> cookies) {
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        String subPskey = getSubPskey(cookies.get("p_skey"));
        QLog.i("ICGameCookiePlanterApiImpl", 1, "plantCookies with cookies,cookieLegal:" + this.cookieStrategy.isCookieLegal(cookies) + ", subPskey:" + subPskey);
        this.cookieStrategy.removeCookies(this.domain);
        this.cookiePlanter.c(this.domain, cookies);
        QLog.d("ICGameCookiePlanterApiImpl", 4, "plant onSuccess");
    }
}
