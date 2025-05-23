package com.tencent.icgame.api.cookie.impl;

import com.tencent.icgame.api.cookie.IQQLiveCookieStrategyApi;
import com.tencent.icgame.api.cookie.QQLiveCookieStrategyType;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0016R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/icgame/api/cookie/impl/QQLiveCookieStrategyApiImpl;", "Lcom/tencent/icgame/api/cookie/IQQLiveCookieStrategyApi;", "()V", "strategies", "Ljava/util/HashMap;", "Lcom/tencent/icgame/api/cookie/QQLiveCookieStrategyType;", "Lcom/tencent/timi/game/api/cookie/IQQLiveCookieStrategy;", "Lkotlin/collections/HashMap;", "getCookieStrategy", "type", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class QQLiveCookieStrategyApiImpl implements IQQLiveCookieStrategyApi {

    @NotNull
    private final HashMap<QQLiveCookieStrategyType, IQQLiveCookieStrategy> strategies;

    public QQLiveCookieStrategyApiImpl() {
        HashMap<QQLiveCookieStrategyType, IQQLiveCookieStrategy> hashMap = new HashMap<>();
        this.strategies = hashMap;
        hashMap.put(QQLiveCookieStrategyType.FULL, new lt0.a(false));
        hashMap.put(QQLiveCookieStrategyType.FULL_NO_CACHE, new lt0.a(true));
    }

    @Override // com.tencent.icgame.api.cookie.IQQLiveCookieStrategyApi
    @NotNull
    public IQQLiveCookieStrategy getCookieStrategy(@NotNull QQLiveCookieStrategyType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IQQLiveCookieStrategy iQQLiveCookieStrategy = this.strategies.get(type);
        if (iQQLiveCookieStrategy == null) {
            return new lt0.a(false, 1, null);
        }
        return iQQLiveCookieStrategy;
    }
}
