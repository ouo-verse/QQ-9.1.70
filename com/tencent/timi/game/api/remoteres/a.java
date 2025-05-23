package com.tencent.timi.game.api.remoteres;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/api/remoteres/a;", "", "", "a", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a {
    void a();

    void onFailed(int errorCode, @Nullable String errorMsg);

    void onSuccess();
}
