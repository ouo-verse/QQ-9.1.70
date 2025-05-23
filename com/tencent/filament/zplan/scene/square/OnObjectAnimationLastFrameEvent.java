package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/OnObjectAnimationLastFrameEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class OnObjectAnimationLastFrameEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_ANIMATION_LAST_FRAME";

    @NotNull
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnObjectAnimationLastFrameEvent(@NotNull String id5) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }
}
