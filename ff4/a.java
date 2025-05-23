package ff4;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.timi.game.api.cookie.impl.BaseCookieStrategy;
import com.tencent.timi.game.api.ticket.IQQLiveTicketApi;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0016R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lff4/a;", "Lcom/tencent/timi/game/api/cookie/impl/BaseCookieStrategy;", "", "domain", "", "isCookieExpired", "", "cookies", "isCookieLegal", "", "Lcom/tencent/timi/game/api/cookie/impl/a;", "c", "Ljava/util/List;", "()Ljava/util/List;", "cookieBuilders", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends BaseCookieStrategy {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.timi.game.api.cookie.impl.a> cookieBuilders;

    public a() {
        Set of5;
        Set of6;
        List<com.tencent.timi.game.api.cookie.impl.a> listOf;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"uin", QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN});
        of6 = SetsKt__SetsJVMKt.setOf(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_NOW_PSKEY);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.timi.game.api.cookie.impl.a[]{new com.tencent.timi.game.api.cookie.impl.a(of5, new gf4.b()), new com.tencent.timi.game.api.cookie.impl.a(of6, new gf4.a(QQLiveCookieConstants.NOW_DOMAIN, false, 2, null))});
        this.cookieBuilders = listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.api.cookie.impl.BaseCookieStrategy
    @NotNull
    public List<com.tencent.timi.game.api.cookie.impl.a> c() {
        return this.cookieBuilders;
    }

    @Override // com.tencent.timi.game.api.cookie.impl.BaseCookieStrategy, com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy
    public boolean isCookieExpired(@NotNull String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        if (((IQQLiveTicketApi) QRoute.api(IQQLiveTicketApi.class)).isPsKeyExpired(QQLiveCookieConstants.NOW_DOMAIN)) {
            QLog.d("FallbackCookieStrategy", 1, "domain:now.qq.com isExpired");
            return true;
        }
        return super.isCookieExpired(domain);
    }

    @Override // com.tencent.timi.game.api.cookie.impl.BaseCookieStrategy, com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy
    public boolean isCookieLegal(@NotNull Map<String, String> cookies) {
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        if (super.isCookieLegal(cookies) && Intrinsics.areEqual(cookies.get(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN), cookies.get("uin")) && Intrinsics.areEqual(cookies.get("uin"), a())) {
            return true;
        }
        return false;
    }
}
