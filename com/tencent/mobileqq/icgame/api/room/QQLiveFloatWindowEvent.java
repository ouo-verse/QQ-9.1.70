package com.tencent.mobileqq.icgame.api.room;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/room/QQLiveFloatWindowEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isHasAudienceFloat", "", "isHasAnchorFloat", "curOperateFloatWindow", "Lcom/tencent/mobileqq/icgame/api/room/FloatWindow;", "(ZZLcom/tencent/mobileqq/icgame/api/room/FloatWindow;)V", "getCurOperateFloatWindow", "()Lcom/tencent/mobileqq/icgame/api/room/FloatWindow;", "()Z", "toString", "", "Companion", "ic-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class QQLiveFloatWindowEvent extends SimpleBaseEvent {
    public static final int HAS_FLOAT = 1;
    public static final int NO_FLOAT = 0;

    @Nullable
    private final FloatWindow curOperateFloatWindow;
    private final boolean isHasAnchorFloat;
    private final boolean isHasAudienceFloat;

    public /* synthetic */ QQLiveFloatWindowEvent(boolean z16, boolean z17, FloatWindow floatWindow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, z17, (i3 & 4) != 0 ? null : floatWindow);
    }

    @Nullable
    public final FloatWindow getCurOperateFloatWindow() {
        return this.curOperateFloatWindow;
    }

    /* renamed from: isHasAnchorFloat, reason: from getter */
    public final boolean getIsHasAnchorFloat() {
        return this.isHasAnchorFloat;
    }

    /* renamed from: isHasAudienceFloat, reason: from getter */
    public final boolean getIsHasAudienceFloat() {
        return this.isHasAudienceFloat;
    }

    @NotNull
    public String toString() {
        return "QQLiveFloatWindowEvent(isHasAudienceFloat=" + this.isHasAudienceFloat + ", isHasAnchorFloat=" + this.isHasAnchorFloat + ", curOperateFloatWindow=" + this.curOperateFloatWindow + ')';
    }

    public QQLiveFloatWindowEvent(boolean z16, boolean z17, @Nullable FloatWindow floatWindow) {
        this.isHasAudienceFloat = z16;
        this.isHasAnchorFloat = z17;
        this.curOperateFloatWindow = floatWindow;
    }
}
