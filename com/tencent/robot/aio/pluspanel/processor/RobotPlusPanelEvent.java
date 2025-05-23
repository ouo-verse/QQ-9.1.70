package com.tencent.robot.aio.pluspanel.processor;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/pluspanel/processor/RobotPlusPanelEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnClickCamera", "OnClickPicture", "Lcom/tencent/robot/aio/pluspanel/processor/RobotPlusPanelEvent$OnClickCamera;", "Lcom/tencent/robot/aio/pluspanel/processor/RobotPlusPanelEvent$OnClickPicture;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotPlusPanelEvent implements MsgIntent {

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/pluspanel/processor/RobotPlusPanelEvent$OnClickCamera;", "Lcom/tencent/robot/aio/pluspanel/processor/RobotPlusPanelEvent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnClickCamera extends RobotPlusPanelEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnClickCamera f367320d = new OnClickCamera();

        OnClickCamera() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.aio.pluspanel.processor.RobotPlusPanelEvent.OnClickCamera";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/pluspanel/processor/RobotPlusPanelEvent$OnClickPicture;", "Lcom/tencent/robot/aio/pluspanel/processor/RobotPlusPanelEvent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnClickPicture extends RobotPlusPanelEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnClickPicture f367321d = new OnClickPicture();

        OnClickPicture() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.aio.pluspanel.processor.RobotPlusPanelEvent.OnClickPicture";
        }
    }

    public /* synthetic */ RobotPlusPanelEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    RobotPlusPanelEvent() {
    }
}
