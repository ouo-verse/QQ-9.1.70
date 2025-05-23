package com.tencent.timi.game.ui;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\u00a8\u0006\u0002"}, d2 = {"", "b", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }
}
