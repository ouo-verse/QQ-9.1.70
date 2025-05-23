package com.tencent.timi.game.api.cookie.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.IQQLiveCookieApi;
import com.tencent.timi.game.api.cookie.QQLiveCookie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0002J\"\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/timi/game/api/cookie/impl/QQLiveCookiePlanter;", "", "", "Lcom/tencent/timi/game/api/cookie/QQLiveCookie;", "cookies", "", "d", "", "domain", "", "b", "c", "Lcom/tencent/timi/game/api/cookie/IQQLiveCookieApi;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/timi/game/api/cookie/IQQLiveCookieApi;", "cookieApi", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveCookiePlanter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cookieApi;

    public QQLiveCookiePlanter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQQLiveCookieApi>() { // from class: com.tencent.timi.game.api.cookie.impl.QQLiveCookiePlanter$cookieApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQQLiveCookieApi invoke() {
                return (IQQLiveCookieApi) QRoute.api(IQQLiveCookieApi.class);
            }
        });
        this.cookieApi = lazy;
    }

    private final IQQLiveCookieApi a() {
        return (IQQLiveCookieApi) this.cookieApi.getValue();
    }

    private final List<QQLiveCookie> b(String domain, Map<String, String> cookies) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : cookies.entrySet()) {
            arrayList.add(a().makeCookie(domain, TuplesKt.to(entry.getKey(), entry.getValue()), 43200L));
        }
        return arrayList;
    }

    private final void d(List<QQLiveCookie> cookies) {
        a().setAcceptCookie(true);
        for (QQLiveCookie qQLiveCookie : cookies) {
            a().setCookie(qQLiveCookie.getDomain(), qQLiveCookie.getValue());
        }
        a().sync();
    }

    public final void c(@NotNull String domain, @NotNull Map<String, String> cookies) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        d(b(domain, cookies));
        if (QLog.isColorLevel()) {
            QLog.i("QQLiveCookiePlanter", 2, "after plant,[" + domain + "] sys cookie:" + a().getSysCookie(domain));
            QLog.i("QQLiveCookiePlanter", 2, "after plant,[" + domain + "] tbs cookie:" + a().getTbsCookie(domain));
        }
    }
}
