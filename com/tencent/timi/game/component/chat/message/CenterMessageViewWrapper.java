package com.tencent.timi.game.component.chat.message;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/CenterMessageViewWrapper;", "Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "g", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "", "k", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class CenterMessageViewWrapper extends CenterMessageView {
    @Override // com.tencent.timi.game.component.chat.message.CenterMessageView
    @Nullable
    protected LongClickOperOption[] g() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.CenterMessageView
    public void k(@NotNull com.tencent.timi.game.tim.api.message.a msg2, @Nullable CommonOuterClass$QQUserId selfUserId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.k(msg2, selfUserId);
        throw null;
    }
}
