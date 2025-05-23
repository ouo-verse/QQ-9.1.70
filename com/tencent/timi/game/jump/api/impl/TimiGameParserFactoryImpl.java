package com.tencent.timi.game.jump.api.impl;

import com.tencent.mobileqq.app.parser.av;
import com.tencent.timi.game.jump.api.ITimiGameParserFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/TimiGameParserFactoryImpl;", "Lcom/tencent/timi/game/jump/api/ITimiGameParserFactory;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getJumpParserClass", "getTeamCreateParserClass", "getTeamJoinParserClass", "getQQLiveOpenMainParserClass", "getQQLiveStartLiveParserClass", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiGameParserFactoryImpl implements ITimiGameParserFactory {
    @Override // com.tencent.timi.game.jump.api.ITimiGameParserFactory
    @NotNull
    public Class<? extends av> getJumpParserClass() {
        return c.class;
    }

    @Override // com.tencent.timi.game.jump.api.ITimiGameParserFactory
    @NotNull
    public Class<? extends av> getQQLiveOpenMainParserClass() {
        return ii4.b.class;
    }

    @Override // com.tencent.timi.game.jump.api.ITimiGameParserFactory
    @NotNull
    public Class<? extends av> getQQLiveStartLiveParserClass() {
        return ii4.d.class;
    }

    @Override // com.tencent.timi.game.jump.api.ITimiGameParserFactory
    @NotNull
    public Class<? extends av> getTeamCreateParserClass() {
        return j.class;
    }

    @Override // com.tencent.timi.game.jump.api.ITimiGameParserFactory
    @NotNull
    public Class<? extends av> getTeamJoinParserClass() {
        return o.class;
    }
}
