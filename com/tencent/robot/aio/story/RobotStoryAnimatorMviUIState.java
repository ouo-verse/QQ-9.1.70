package com.tencent.robot.aio.story;

import com.tencent.mvi.base.mvi.MviUIState;
import hn2.q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "CreateStoryAnimatorView", "StartStoryViewAnimator", "StopStoryViewAnimator", "Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState$CreateStoryAnimatorView;", "Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState$StartStoryViewAnimator;", "Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState$StopStoryViewAnimator;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotStoryAnimatorMviUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState$CreateStoryAnimatorView;", "Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class CreateStoryAnimatorView extends RobotStoryAnimatorMviUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final CreateStoryAnimatorView f367371d = new CreateStoryAnimatorView();

        CreateStoryAnimatorView() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState$StartStoryViewAnimator;", "Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState;", "Lhn2/q;", "d", "Lhn2/q;", "a", "()Lhn2/q;", "binding", "<init>", "(Lhn2/q;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class StartStoryViewAnimator extends RobotStoryAnimatorMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final q binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartStoryViewAnimator(@NotNull q binding) {
            super(null);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final q getBinding() {
            return this.binding;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState$StopStoryViewAnimator;", "Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class StopStoryViewAnimator extends RobotStoryAnimatorMviUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final StopStoryViewAnimator f367373d = new StopStoryViewAnimator();

        StopStoryViewAnimator() {
            super(null);
        }
    }

    public /* synthetic */ RobotStoryAnimatorMviUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    RobotStoryAnimatorMviUIState() {
    }
}
