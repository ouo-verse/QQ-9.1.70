package com.tencent.robot.slash.dialog.content.middle;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/middle/SlashContainerUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "UpdateContainerTipState", "Lcom/tencent/robot/slash/dialog/content/middle/SlashContainerUIState$UpdateContainerTipState;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class SlashContainerUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/middle/SlashContainerUIState$UpdateContainerTipState;", "Lcom/tencent/robot/slash/dialog/content/middle/SlashContainerUIState;", "", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "state", "<init>", "(Ljava/lang/Object;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class UpdateContainerTipState extends SlashContainerUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateContainerTipState(@NotNull Object state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Object getState() {
            return this.state;
        }
    }

    public /* synthetic */ SlashContainerUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    SlashContainerUIState() {
    }
}
