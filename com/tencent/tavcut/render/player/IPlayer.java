package com.tencent.tavcut.render.player;

import android.view.Surface;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.rendermodel.RenderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd4.b;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002 .J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H&J\u0016\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH&JB\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00020\u0017H&J\b\u0010\u001b\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u0002H&J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH&J\b\u0010\"\u001a\u00020\u0002H&J \u0010(\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H&J\u0016\u0010,\u001a\u00020\u00022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H&J\b\u0010-\u001a\u00020\u0002H&\u00a8\u0006/"}, d2 = {"Lcom/tencent/tavcut/render/player/IPlayer;", "", "", "play", "pause", "", "isPlaying", "", "timeUs", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "autoPlay", "setAutoPlay", "loopPlay", "setLoopPlay", "Lkotlin/Function0;", "runnable", Method.POST, "", "templateDir", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "isInit", "targetTime", "Lkotlin/Function2;", "Lzd4/b;", "updateCallBack", "b", "getTotalDurationUs", "getCurrentPlayUs", "release", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "playerListener", "a", "c", "requestRender", "Landroid/view/Surface;", "surface", "", "surfaceWidth", "surfaceHeight", "setUpSurface", "", "Lcom/tencent/tavcut/model/ClipSource;", "clipsAssets", "setClipAssets", "destroySurface", "PlayerStatus", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface IPlayer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "", "(Ljava/lang/String;I)V", "IDLE", "READY", "PLAYING", "STOPPED", "PAUSED", "FINISHED", RLog.ERROR, "REPLAY", "lib_tavcut_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public enum PlayerStatus {
        IDLE,
        READY,
        PLAYING,
        STOPPED,
        PAUSED,
        FINISHED,
        ERROR,
        REPLAY
    }

    void a(@NotNull a playerListener);

    void b(@NotNull String templateDir, @NotNull RenderModel renderModel, boolean isInit, long targetTime, @NotNull Function2<? super b, ? super RenderModel, Unit> updateCallBack);

    void c(@NotNull a playerListener);

    void destroySurface();

    long getCurrentPlayUs();

    long getTotalDurationUs();

    boolean isPlaying();

    void pause();

    void play();

    void post(@NotNull Function0<Unit> runnable);

    void release();

    void requestRender();

    void seek(long timeUs);

    void setAutoPlay(boolean autoPlay);

    void setClipAssets(@NotNull List<ClipSource> clipsAssets);

    void setLoopPlay(boolean loopPlay);

    void setUpSurface(@NotNull Surface surface, int surfaceWidth, int surfaceHeight);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/render/player/IPlayer$a;", "", "", "currentDurationUs", "playerDurationUs", "", "onPositionChanged", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/render/player/IPlayer;", "iPlayer", "a", "b", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public interface a {
        void a(@Nullable PlayerStatus status, @NotNull IPlayer iPlayer);

        void b(@NotNull IPlayer iPlayer);

        void onPositionChanged(long currentDurationUs, long playerDurationUs);

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* renamed from: com.tencent.tavcut.render.player.IPlayer$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9881a {
            public static void a(a aVar, @NotNull IPlayer iPlayer) {
                Intrinsics.checkParameterIsNotNull(iPlayer, "iPlayer");
            }

            public static void c(a aVar, @Nullable PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
                Intrinsics.checkParameterIsNotNull(iPlayer, "iPlayer");
            }

            public static void b(a aVar, long j3, long j16) {
            }
        }
    }
}
