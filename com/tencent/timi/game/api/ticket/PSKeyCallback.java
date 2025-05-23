package com.tencent.timi.game.api.ticket;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "", "onFailed", "", "msg", "", "onSuccess", "pSKeys", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", "onTimeout", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public interface PSKeyCallback {
    void onFailed(@Nullable String msg2);

    void onSuccess(@NotNull List<PSKey> pSKeys);

    void onTimeout(@Nullable String msg2);
}
