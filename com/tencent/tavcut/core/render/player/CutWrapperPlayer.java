package com.tencent.tavcut.core.render.player;

import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0016\u0010\u001d\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u001aH\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u001aH\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\fH\u0016J\u0016\u0010.\u001a\u00020\u00072\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\u0016\u00102\u001a\u00020\u00072\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001000H\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u001aH\u0016J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u001aH\u0016J\u0018\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0010H\u0016J\u0012\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J \u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u001aH\u0016J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u001aH\u0016J\u0012\u0010E\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J \u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020J2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0010H\u0016J8\u0010L\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020O\u0018\u00010M2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u00020\u00102\b\u0010T\u001a\u0004\u0018\u00010UH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006V"}, d2 = {"Lcom/tencent/tavcut/core/render/player/CutWrapperPlayer;", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "player", "(Lcom/tencent/tavcut/core/render/player/IPlayer;)V", "getPlayer", "()Lcom/tencent/tavcut/core/render/player/IPlayer;", "addPlayerListener", "", "playerListener", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "changeSurfaceSize", "surfaceWidth", "", "surfaceHeight", "destroySurface", "getClipAssetsDurationUs", "", "getCurrentPlayUs", "getGlViewPort", "Lorg/light/lightAssetKit/components/Rect;", "getPlayTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderSize", "Lorg/light/lightAssetKit/components/Size;", "getTotalDurationUs", "isPlaying", "", "pause", "play", Method.POST, "runnable", "Lkotlin/Function0;", "readSnapShootBitmap", "listener", "Lcom/tencent/tav/player/OnReadSnapShootListener;", "release", "removePlayerListener", "requestRender", "resetToTotalTimeRange", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "timeUs", "isAccurate", "setAutoPlay", "autoPlay", "setBgColor", "bgColor", "setClipAssets", "clipsAssets", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "setCutDurationList", "timeList", "setEnableSync", "enable", "setLoopPlay", "loopPlay", "setPlayTimeRange", "selectedStartTimeUs", "selectedDurationUs", "setPlayerThread", MosaicConstants$JsProperty.PROP_THREAD, "Landroid/os/HandlerThread;", "setRate", "rate", "", "maxCacheFrameSize", FileReaderHelper.OPEN_FILE_FROM_FORCE, "setSeekToLastPosition", "seekToLastPosition", "setSurfaceTextureListener", "surfaceTextureListener", "Landroid/view/TextureView$SurfaceTextureListener;", "setUpSurface", "surface", "Landroid/view/Surface;", "stop", "updatePlayer", "Lkotlin/Pair;", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "templateDir", "", "renderModel", "targetTime", "onAssetListener", "Lorg/light/listener/OnClipAssetListener;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class CutWrapperPlayer implements IPlayer {

    @NotNull
    private final IPlayer player;

    public CutWrapperPlayer(@NotNull IPlayer player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.player = player;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void addPlayerListener(@NotNull IPlayer.PlayerListener playerListener) {
        Intrinsics.checkParameterIsNotNull(playerListener, "playerListener");
        this.player.addPlayerListener(playerListener);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void changeSurfaceSize(int surfaceWidth, int surfaceHeight) {
        this.player.changeSurfaceSize(surfaceWidth, surfaceHeight);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void destroySurface() {
        this.player.destroySurface();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public long getClipAssetsDurationUs() {
        return this.player.getClipAssetsDurationUs();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public long getCurrentPlayUs() {
        return this.player.getCurrentPlayUs();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    @NotNull
    public Rect getGlViewPort() {
        return this.player.getGlViewPort();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    @NotNull
    public CMTimeRange getPlayTimeRange() {
        return this.player.getPlayTimeRange();
    }

    @NotNull
    public final IPlayer getPlayer() {
        return this.player;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    @NotNull
    public Size getRenderSize() {
        return this.player.getRenderSize();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    /* renamed from: getTotalDurationUs */
    public long getDurationUs() {
        return this.player.getDurationUs();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public boolean isPlaying() {
        return this.player.isPlaying();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void pause() {
        this.player.pause();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void play() {
        this.player.play();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void post(@NotNull Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        this.player.post(runnable);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void readSnapShootBitmap(@NotNull OnReadSnapShootListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.player.readSnapShootBitmap(listener);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void release() {
        this.player.release();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void removePlayerListener(@NotNull IPlayer.PlayerListener playerListener) {
        Intrinsics.checkParameterIsNotNull(playerListener, "playerListener");
        this.player.removePlayerListener(playerListener);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void requestRender() {
        this.player.requestRender();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void resetToTotalTimeRange() {
        this.player.resetToTotalTimeRange();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void seek(long timeUs) {
        this.player.seek(timeUs);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setAutoPlay(boolean autoPlay) {
        this.player.setAutoPlay(autoPlay);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setBgColor(int bgColor) {
        this.player.setBgColor(bgColor);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setClipAssets(@NotNull List<ClipSource> clipsAssets) {
        Intrinsics.checkParameterIsNotNull(clipsAssets, "clipsAssets");
        this.player.setClipAssets(clipsAssets);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setCutDurationList(@NotNull List<Long> timeList) {
        Intrinsics.checkParameterIsNotNull(timeList, "timeList");
        this.player.setCutDurationList(timeList);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setEnableSync(boolean enable) {
        this.player.setEnableSync(enable);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setLoopPlay(boolean loopPlay) {
        this.player.setLoopPlay(loopPlay);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setPlayTimeRange(long selectedStartTimeUs, long selectedDurationUs) {
        this.player.setPlayTimeRange(selectedStartTimeUs, selectedDurationUs);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setPlayerThread(@Nullable HandlerThread thread) {
        this.player.setPlayerThread(thread);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setRate(float rate, int maxCacheFrameSize, boolean force) {
        this.player.setRate(rate, maxCacheFrameSize, force);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setSeekToLastPosition(boolean seekToLastPosition) {
        this.player.setSeekToLastPosition(seekToLastPosition);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.player.setSurfaceTextureListener(surfaceTextureListener);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setUpSurface(@NotNull Surface surface, int surfaceWidth, int surfaceHeight) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        this.player.setUpSurface(surface, surfaceWidth, surfaceHeight);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void stop(long timeUs) {
        this.player.stop(timeUs);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    @Nullable
    public Pair<IRenderChainManager, LAKRenderModel> updatePlayer(@NotNull String templateDir, @NotNull LAKRenderModel renderModel, long targetTime, @Nullable OnClipAssetListener onAssetListener) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        return this.player.updatePlayer(templateDir, renderModel, targetTime, onAssetListener);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void seek(long timeUs, boolean isAccurate) {
        this.player.seek(timeUs, isAccurate);
    }
}
