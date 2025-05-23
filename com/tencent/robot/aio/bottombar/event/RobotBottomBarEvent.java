package com.tencent.robot.aio.bottombar.event;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/aio/bottombar/event/RobotBottomBarEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "OnRobotBottomBarHide", "OnRobotBottomBarShow", "Lcom/tencent/robot/aio/bottombar/event/RobotBottomBarEvent$OnRobotBottomBarHide;", "Lcom/tencent/robot/aio/bottombar/event/RobotBottomBarEvent$OnRobotBottomBarShow;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class RobotBottomBarEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/bottombar/event/RobotBottomBarEvent$OnRobotBottomBarHide;", "Lcom/tencent/robot/aio/bottombar/event/RobotBottomBarEvent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnRobotBottomBarHide extends RobotBottomBarEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnRobotBottomBarHide f366888d = new OnRobotBottomBarHide();

        OnRobotBottomBarHide() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/bottombar/event/RobotBottomBarEvent$OnRobotBottomBarShow;", "Lcom/tencent/robot/aio/bottombar/event/RobotBottomBarEvent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnRobotBottomBarShow extends RobotBottomBarEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnRobotBottomBarShow f366889d = new OnRobotBottomBarShow();

        OnRobotBottomBarShow() {
            super(null);
        }
    }

    public /* synthetic */ RobotBottomBarEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    RobotBottomBarEvent() {
    }
}
