package com.tencent.tavcut.core.render.player;

import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.Size;
import org.light.listener.OnClipAssetListener;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002RSJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0016\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u0003H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\fH&J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0016H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0016H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\bH&J\u0016\u0010*\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H&J\u0016\u0010.\u001a\u00020\u00032\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0,H&J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0016H&J\u0010\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0016H&J\u0018\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH&J\u0012\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u000109H&J \u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u0016H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0016H&J\u0012\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010CH&J \u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020F2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\fH&J:\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K\u0018\u00010I2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020\f2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010QH&\u00a8\u0006T"}, d2 = {"Lcom/tencent/tavcut/core/render/player/IPlayer;", "", "addPlayerListener", "", "playerListener", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "changeSurfaceSize", "surfaceWidth", "", "surfaceHeight", "destroySurface", "getClipAssetsDurationUs", "", "getCurrentPlayUs", "getGlViewPort", "Lorg/light/lightAssetKit/components/Rect;", "getPlayTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderSize", "Lorg/light/lightAssetKit/components/Size;", "getTotalDurationUs", "isPlaying", "", "pause", "play", Method.POST, "runnable", "Lkotlin/Function0;", "readSnapShootBitmap", "listener", "Lcom/tencent/tav/player/OnReadSnapShootListener;", "release", "removePlayerListener", "requestRender", "resetToTotalTimeRange", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "timeUs", "isInAccurate", "setAutoPlay", "autoPlay", "setBgColor", "bgColor", "setClipAssets", "clipsAssets", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "setCutDurationList", "timeList", "setEnableSync", "enable", "setLoopPlay", "loopPlay", "setPlayTimeRange", "selectedStartTimeUs", "selectedDurationUs", "setPlayerThread", MosaicConstants$JsProperty.PROP_THREAD, "Landroid/os/HandlerThread;", "setRate", "rate", "", "maxCacheFrameSize", FileReaderHelper.OPEN_FILE_FROM_FORCE, "setSeekToLastPosition", "seekToLastPosition", "setSurfaceTextureListener", "surfaceTextureListener", "Landroid/view/TextureView$SurfaceTextureListener;", "setUpSurface", "surface", "Landroid/view/Surface;", "stop", "updatePlayer", "Lkotlin/Pair;", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "templateDir", "", "renderModel", "targetTime", "onAssetListener", "Lorg/light/listener/OnClipAssetListener;", "PlayerListener", "PlayerStatus", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IPlayer {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Pair updatePlayer$default(IPlayer iPlayer, String str, LAKRenderModel lAKRenderModel, long j3, OnClipAssetListener onClipAssetListener, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    onClipAssetListener = null;
                }
                return iPlayer.updatePlayer(str, lAKRenderModel, j3, onClipAssetListener);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePlayer");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "", "(Ljava/lang/String;I)V", "IDLE", "READY", "PLAYING", "STOPPED", "PAUSED", "FINISHED", RLog.ERROR, "REPLAY", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
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

    void addPlayerListener(@NotNull PlayerListener playerListener);

    void changeSurfaceSize(int surfaceWidth, int surfaceHeight);

    void destroySurface();

    long getClipAssetsDurationUs();

    long getCurrentPlayUs();

    @NotNull
    Rect getGlViewPort();

    @NotNull
    CMTimeRange getPlayTimeRange();

    @NotNull
    Size getRenderSize();

    long getTotalDurationUs();

    boolean isPlaying();

    void pause();

    void play();

    void post(@NotNull Function0<Unit> runnable);

    void readSnapShootBitmap(@NotNull OnReadSnapShootListener listener);

    void release();

    void removePlayerListener(@NotNull PlayerListener playerListener);

    void requestRender();

    void resetToTotalTimeRange();

    void seek(long timeUs);

    void seek(long timeUs, boolean isInAccurate);

    void setAutoPlay(boolean autoPlay);

    void setBgColor(int bgColor);

    void setClipAssets(@NotNull List<ClipSource> clipsAssets);

    void setCutDurationList(@NotNull List<Long> timeList);

    void setEnableSync(boolean enable);

    void setLoopPlay(boolean loopPlay);

    void setPlayTimeRange(long selectedStartTimeUs, long selectedDurationUs);

    void setPlayerThread(@Nullable HandlerThread thread);

    void setRate(float rate, int maxCacheFrameSize, boolean force);

    void setSeekToLastPosition(boolean seekToLastPosition);

    void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener);

    void setUpSurface(@NotNull Surface surface, int surfaceWidth, int surfaceHeight);

    void stop(long timeUs);

    @Nullable
    Pair<IRenderChainManager, LAKRenderModel> updatePlayer(@NotNull String templateDir, @NotNull LAKRenderModel renderModel, long targetTime, @Nullable OnClipAssetListener onAssetListener);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "", "onPlayerSourceReady", "", "iPlayer", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "onPositionChanged", "currentDurationUs", "", "playerDurationUs", "onStatusChanged", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public interface PlayerListener {
        void onPlayerSourceReady(@NotNull IPlayer iPlayer);

        void onPositionChanged(long currentDurationUs, long playerDurationUs);

        void onStatusChanged(@Nullable PlayerStatus status, @NotNull IPlayer iPlayer);

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class DefaultImpls {
            public static void onPlayerSourceReady(PlayerListener playerListener, @NotNull IPlayer iPlayer) {
                Intrinsics.checkParameterIsNotNull(iPlayer, "iPlayer");
            }

            public static void onStatusChanged(PlayerListener playerListener, @Nullable PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
                Intrinsics.checkParameterIsNotNull(iPlayer, "iPlayer");
            }

            public static void onPositionChanged(PlayerListener playerListener, long j3, long j16) {
            }
        }
    }
}
