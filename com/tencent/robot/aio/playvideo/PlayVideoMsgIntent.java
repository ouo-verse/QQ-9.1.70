package com.tencent.robot.aio.playvideo;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnVideoPlayEnd", "OnVideoPlayStart", "Lcom/tencent/robot/aio/playvideo/PlayVideoMsgIntent$OnVideoPlayEnd;", "Lcom/tencent/robot/aio/playvideo/PlayVideoMsgIntent$OnVideoPlayStart;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class PlayVideoMsgIntent implements MsgIntent {

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoMsgIntent$OnVideoPlayEnd;", "Lcom/tencent/robot/aio/playvideo/PlayVideoMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnVideoPlayEnd extends PlayVideoMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnVideoPlayEnd f367274d = new OnVideoPlayEnd();

        OnVideoPlayEnd() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.aio.playvideo.PlayVideoMsgIntent.OnVideoPlayEnd";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoMsgIntent$OnVideoPlayStart;", "Lcom/tencent/robot/aio/playvideo/PlayVideoMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnVideoPlayStart extends PlayVideoMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnVideoPlayStart f367275d = new OnVideoPlayStart();

        OnVideoPlayStart() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.aio.playvideo.PlayVideoMsgIntent.OnVideoPlayStart";
        }
    }

    public /* synthetic */ PlayVideoMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    PlayVideoMsgIntent() {
    }
}
