package com.tencent.timi.game.live.impl.danmuku;

import android.view.View;
import com.tencent.common.danmaku.core.DanmakuManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/a;", "Lcom/tencent/common/danmaku/core/DanmakuManager;", "", "enable", "", "J0", "disable", "I0", "Landroid/view/View;", "danmakuView", "Lcom/tencent/common/danmaku/inject/b;", "danmakuContext", "<init>", "(Landroid/view/View;Lcom/tencent/common/danmaku/inject/b;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends DanmakuManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View danmakuView, @NotNull com.tencent.common.danmaku.inject.b danmakuContext) {
        super(danmakuView, danmakuContext);
        Intrinsics.checkNotNullParameter(danmakuView, "danmakuView");
        Intrinsics.checkNotNullParameter(danmakuContext, "danmakuContext");
    }

    public final void I0(boolean disable) {
        this.D.f(disable);
    }

    public void J0(boolean enable) {
        this.D.d(enable);
    }
}
