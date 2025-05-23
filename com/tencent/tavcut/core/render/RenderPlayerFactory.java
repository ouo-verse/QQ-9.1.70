package com.tencent.tavcut.core.render;

import android.widget.FrameLayout;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.player.MoviePlayer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tavcut/core/render/RenderPlayerFactory;", "", "()V", "TAV_PLAYER", "", "createPlayer", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "playerContainer", "Landroid/widget/FrameLayout;", "type", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class RenderPlayerFactory {
    public static final RenderPlayerFactory INSTANCE = new RenderPlayerFactory();
    public static final int TAV_PLAYER = 1;

    RenderPlayerFactory() {
    }

    @NotNull
    public final IPlayer createPlayer(@Nullable FrameLayout playerContainer, int type) {
        if (type != 1) {
            return new MoviePlayer(playerContainer);
        }
        return new MoviePlayer(playerContainer);
    }
}
