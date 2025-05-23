package com.tencent.robot.aio.stopgeneratingbutton;

import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState;", "Lcom/tencent/aio/base/mvi/part/Reserve2UIState;", "()V", "ButtonBottomMargin", "ButtonVisible", "Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState$ButtonBottomMargin;", "Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState$ButtonVisible;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotStopGenerateUIState implements Reserve2UIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState$ButtonBottomMargin;", "Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState;", "", "d", "I", "a", "()I", "bottomMargin", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class ButtonBottomMargin extends RobotStopGenerateUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int bottomMargin;

        public ButtonBottomMargin(int i3) {
            super(null);
            this.bottomMargin = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottomMargin() {
            return this.bottomMargin;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState$ButtonVisible;", "Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState;", "", "d", "Z", "a", "()Z", NodeProps.VISIBLE, "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class ButtonVisible extends RobotStopGenerateUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean visible;

        public ButtonVisible(boolean z16) {
            super(null);
            this.visible = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }
    }

    public /* synthetic */ RobotStopGenerateUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotStopGenerateUIState() {
    }
}
