package com.tencent.timi.game.jump.api.impl;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.jump.api.IQQLiveAnchorJumpApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/QQLiveAnchorJumpApiImpl;", "Lcom/tencent/timi/game/jump/api/IQQLiveAnchorJumpApi;", "()V", "interruptJumpAction", "", "context", "Landroid/content/Context;", "openAnchorRoomPage", "jumpContext", "fromSource", "", "actionCmd", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class QQLiveAnchorJumpApiImpl implements IQQLiveAnchorJumpApi {
    @Override // com.tencent.timi.game.jump.api.IQQLiveAnchorJumpApi
    public void interruptJumpAction(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QQToast.makeText(context, 1, R.string.f210135ha, 0).show();
    }

    @Override // com.tencent.timi.game.jump.api.IQQLiveAnchorJumpApi
    public void openAnchorRoomPage(@NotNull Context jumpContext, int fromSource, @Nullable String actionCmd) {
        Intrinsics.checkNotNullParameter(jumpContext, "jumpContext");
        ((ni4.a) mm4.b.b(ni4.a.class)).openAnchorRoomPage(jumpContext, fromSource, actionCmd);
    }
}
