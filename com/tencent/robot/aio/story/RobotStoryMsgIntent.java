package com.tencent.robot.aio.story;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/aio/story/RobotStoryMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "RobotStoryAnimEnd", "Lcom/tencent/robot/aio/story/RobotStoryMsgIntent$RobotStoryAnimEnd;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotStoryMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/story/RobotStoryMsgIntent$RobotStoryAnimEnd;", "Lcom/tencent/robot/aio/story/RobotStoryMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class RobotStoryAnimEnd extends RobotStoryMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RobotStoryAnimEnd f367379d = new RobotStoryAnimEnd();

        RobotStoryAnimEnd() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.aio.story.RobotStoryMsgIntent.RobotStoryAnimEnd";
        }
    }

    public /* synthetic */ RobotStoryMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    RobotStoryMsgIntent() {
    }
}
