package com.tencent.timi.game.api.cookie;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/api/cookie/IQQLiveCookieStrategyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getCookieStrategy", "Lcom/tencent/timi/game/api/cookie/IQQLiveCookieStrategy;", "type", "Lcom/tencent/timi/game/api/cookie/QQLiveCookieStrategyType;", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IQQLiveCookieStrategyApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ IQQLiveCookieStrategy getCookieStrategy$default(IQQLiveCookieStrategyApi iQQLiveCookieStrategyApi, QQLiveCookieStrategyType qQLiveCookieStrategyType, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    qQLiveCookieStrategyType = QQLiveCookieStrategyType.FULL;
                }
                return iQQLiveCookieStrategyApi.getCookieStrategy(qQLiveCookieStrategyType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCookieStrategy");
        }
    }

    @NotNull
    IQQLiveCookieStrategy getCookieStrategy(@NotNull QQLiveCookieStrategyType type);
}
