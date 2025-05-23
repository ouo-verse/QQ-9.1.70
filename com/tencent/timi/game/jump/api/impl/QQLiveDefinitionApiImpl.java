package com.tencent.timi.game.jump.api.impl;

import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.timi.game.jump.api.IQQLiveDefinitionApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/QQLiveDefinitionApiImpl;", "Lcom/tencent/timi/game/jump/api/IQQLiveDefinitionApi;", "", "roomId", "getDefinitionLevel", "<init>", "()V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveDefinitionApiImpl implements IQQLiveDefinitionApi {

    @NotNull
    private static final String MMKV_DEFINITION_KEY = "USER_SELECT_DEFINITON_LEVEL";

    @Override // com.tencent.timi.game.jump.api.IQQLiveDefinitionApi
    @NotNull
    public String getDefinitionLevel(@NotNull String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        return String.valueOf(ct3.a.g(MMKV_DEFINITION_KEY, StreamDefinition.SHD.getValue()));
    }
}
