package com.tencent.robot.aio.playvideo;

import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "ConfigChange", "DismissVideoView", "Pause", "Resume", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public class PlayVideoUIState implements MviUIState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoUIState$ConfigChange;", "Lcom/tencent/robot/aio/playvideo/PlayVideoUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ConfigChange extends PlayVideoUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ConfigChange f367276d = new ConfigChange();

        ConfigChange() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoUIState$DismissVideoView;", "Lcom/tencent/robot/aio/playvideo/PlayVideoUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class DismissVideoView extends PlayVideoUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final DismissVideoView f367277d = new DismissVideoView();

        DismissVideoView() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoUIState$Pause;", "Lcom/tencent/robot/aio/playvideo/PlayVideoUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class Pause extends PlayVideoUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final Pause f367278d = new Pause();

        Pause() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoUIState$Resume;", "Lcom/tencent/robot/aio/playvideo/PlayVideoUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class Resume extends PlayVideoUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final Resume f367279d = new Resume();

        Resume() {
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
