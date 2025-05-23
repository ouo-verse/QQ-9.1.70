package com.tencent.timi.game.api.cookie;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J\r\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/api/cookie/IDataSupplier;", "T", "", "getDataAsync", "", "callback", "Lcom/tencent/timi/game/api/cookie/DataSupplierCallback;", "getDataSync", "()Ljava/lang/Object;", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public interface IDataSupplier<T> {
    void getDataAsync(@NotNull DataSupplierCallback<T> callback);

    T getDataSync();
}
