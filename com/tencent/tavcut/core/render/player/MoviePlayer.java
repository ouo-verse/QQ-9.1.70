package com.tencent.tavcut.core.render.player;

import android.content.Context;
import android.graphics.PointF;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tav.player.Player;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.RenderConfig;
import com.tencent.tavcut.core.render.builder.IMediaBuilder;
import com.tencent.tavcut.core.render.builder.MediaBuildFactory;
import com.tencent.tavcut.core.render.builder.MediaBuilderOutput;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.RenderScene;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.util.CMTimeUtil;
import com.tencent.tavcut.core.utils.a;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.videocut.utils.r;
import com.tencent.videocut.utils.thread.c;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.device.OfflineConfig;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.Size;
import org.light.listener.OnClipAssetListener;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u0085\u00012\u00020\u0001:\u0002\u0085\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u001bH\u0016J\u0018\u00102\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000bH\u0002J\u0018\u00104\u001a\u00020&2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u00020&H\u0016J\u0018\u00109\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000bH\u0002J\b\u0010:\u001a\u00020\u000bH\u0016J\b\u0010;\u001a\u00020\u000bH\u0016J\b\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002J\b\u0010D\u001a\u00020)H\u0016J\b\u0010E\u001a\u00020\u000bH\u0016J\u0012\u0010F\u001a\u00020&2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020&H\u0016J\b\u0010K\u001a\u00020&H\u0016J\u0016\u0010L\u001a\u00020&2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020&0NH\u0016J\u0010\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020&H\u0016J\u0010\u0010S\u001a\u00020&2\u0006\u00101\u001a\u00020\u001bH\u0016J\b\u0010T\u001a\u00020&H\u0016J\b\u0010U\u001a\u00020&H\u0002J\b\u0010V\u001a\u00020&H\u0002J\b\u0010W\u001a\u00020&H\u0016J\u0010\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u0010\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020\u000bH\u0016J\u0018\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u0006H\u0016J\u0010\u0010^\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010_\u001a\u00020&2\u0006\u0010`\u001a\u000206H\u0016J\u0016\u0010a\u001a\u00020&2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0016J\u0016\u0010b\u001a\u00020&2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010d\u001a\u00020&2\u0006\u0010e\u001a\u00020\u0006H\u0016J\u0010\u0010f\u001a\u00020&2\u0006\u0010g\u001a\u00020\u0006H\u0016J\u0018\u0010h\u001a\u00020&2\u0006\u0010i\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u000bH\u0016J\u0012\u0010k\u001a\u00020&2\b\u0010l\u001a\u0004\u0018\u00010#H\u0016J \u0010m\u001a\u00020&2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u0002062\u0006\u0010q\u001a\u00020\u0006H\u0016J\u0010\u0010r\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0006H\u0016J\u0012\u0010s\u001a\u00020&2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J \u0010v\u001a\u00020&2\u0006\u0010w\u001a\u00020x2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0016J\u0010\u0010y\u001a\u00020&2\u0006\u0010\\\u001a\u00020\u000bH\u0016J\u0018\u0010z\u001a\u00020&2\u0006\u0010{\u001a\u00020\u00192\u0006\u0010|\u001a\u00020\u000bH\u0002J=\u0010}\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u007f\u0018\u00010~2\u0007\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\u007f2\u0007\u0010\u0082\u0001\u001a\u00020\u000b2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010$\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020&0%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/tavcut/core/render/player/MoviePlayer;", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "playerContainer", "Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "autoPlay", "", "clipIFrameTimestampCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "clipIFrameTimestamps", "", "clipsAssets", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "currentPlayUs", "cutDurationTimestamps", "durationUs", "interceptSeekTime", "lastCallSeekTime", "lastSeekTime", "player", "Lcom/tencent/tav/player/Player;", "playerComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "playerListeners", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerRenderManager", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "playerStatusMap", "", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "playerThread", "Landroid/os/HandlerThread;", "positionChangeCallBack", "Lkotlin/Function2;", "", "preSeekTime", "renderSize", "Lorg/light/lightAssetKit/components/Size;", "runOnCompositionUpdatedEvent", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "seekToLastPosition", "tavPlayer", "Lcom/tencent/tavkit/component/TAVPlayer;", "addPlayerListener", "playerListener", "backFastSeek", "curSeekTime", "changeSurfaceSize", "surfaceWidth", "", "surfaceHeight", "destroySurface", "forwardFastSeek", "getClipAssetsDurationUs", "getCurrentPlayUs", "getGlViewPort", "Lorg/light/lightAssetKit/components/Rect;", "getIFrameTimestamp", "seekTime", "getInAccurateSeekTime", "getPlayTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getPreLimitTime", "getRenderSize", "getTotalDurationUs", "initInAccurateSeekParam", "context", "Landroid/content/Context;", "isPlaying", "pause", "play", Method.POST, "runnable", "Lkotlin/Function0;", "readSnapShootBitmap", "listener", "Lcom/tencent/tav/player/OnReadSnapShootListener;", "release", "removePlayerListener", "requestRender", "resetLastSeekTime", "resetSeekWhenSeekFinished", "resetToTotalTimeRange", "safeSeekPositionConvert", "Lcom/tencent/tav/coremedia/CMTime;", "seekToPositionUs", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "timeUs", "isInAccurate", "setAutoPlay", "setBgColor", "bgColor", "setClipAssets", "setCutDurationList", "timeList", "setEnableSync", "enable", "setLoopPlay", "loopPlay", "setPlayTimeRange", "selectedStartTimeUs", "selectedDurationUs", "setPlayerThread", MosaicConstants$JsProperty.PROP_THREAD, "setRate", "rate", "", "maxCacheFrameSize", FileReaderHelper.OPEN_FILE_FROM_FORCE, "setSeekToLastPosition", "setSurfaceTextureListener", "surfaceTextureListener", "Landroid/view/TextureView$SurfaceTextureListener;", "setUpSurface", "surface", "Landroid/view/Surface;", "stop", "updateComposition", "tavComposition", "seekToPosition", "updatePlayer", "Lkotlin/Pair;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "templateDir", "renderModel", "targetTime", "onAssetListener", "Lorg/light/listener/OnClipAssetListener;", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class MoviePlayer implements IPlayer {
    private static final long PER_FRAME_DURATION_US = 3333;
    private static final int PLAYER_SEEK_TOLERANCE = 0;
    private static final long SEEK_CALLED_INTERVAL = 50;
    private static final String TAG = "TavCut_MoviePlayer";
    private boolean autoPlay;
    private final ConcurrentHashMap<String, List<Long>> clipIFrameTimestampCache;
    private List<Long> clipIFrameTimestamps;
    private List<ClipSource> clipsAssets;
    private long currentPlayUs;
    private List<Long> cutDurationTimestamps;
    private long durationUs;
    private long interceptSeekTime;
    private long lastCallSeekTime;
    private long lastSeekTime;
    private Player player;
    private TAVComposition playerComposition;
    private List<IPlayer.PlayerListener> playerListeners;
    private IRenderChainManager playerRenderManager;
    private final Map<IPlayer.PlayerStatus, IPlayer.PlayerStatus> playerStatusMap;
    private HandlerThread playerThread;
    private Function2<? super Long, ? super Long, Unit> positionChangeCallBack;
    private long preSeekTime;
    private Size renderSize;
    private final LinkedList<Runnable> runOnCompositionUpdatedEvent;
    private boolean seekToLastPosition;
    private final TAVPlayer tavPlayer;
    private static int FAST_SEEK_MIN_TIME = 1000000;
    private static int HALF_FAST_SEEK_MIN_TIME = 500000;
    private static int BACK_FAST_SEEK_TIME = 100000;
    private static int IFRAME_DISTANCE_DIVIDER = 2;

    public MoviePlayer(@Nullable FrameLayout frameLayout) {
        TAVPlayer tAVPlayer;
        List<ClipSource> emptyList;
        List<Long> emptyList2;
        Map<IPlayer.PlayerStatus, IPlayer.PlayerStatus> mapOf;
        Context context;
        if (frameLayout != null) {
            tAVPlayer = new TAVPlayer(frameLayout);
        } else {
            tAVPlayer = new TAVPlayer();
        }
        tAVPlayer.setVideoThread(this.playerThread);
        this.tavPlayer = tAVPlayer;
        this.renderSize = LAKRenderModel.INSTANCE.getDEFAULT_SIZE();
        this.positionChangeCallBack = new Function2<Long, Long, Unit>() { // from class: com.tencent.tavcut.core.render.player.MoviePlayer$positionChangeCallBack$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Long l3, @Nullable Long l16) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, Long l16) {
                invoke2(l3, l16);
                return Unit.INSTANCE;
            }
        };
        this.playerListeners = new ArrayList();
        this.runOnCompositionUpdatedEvent = new LinkedList<>();
        this.lastSeekTime = -1L;
        this.interceptSeekTime = -1L;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.clipsAssets = emptyList;
        this.clipIFrameTimestamps = new ArrayList();
        this.clipIFrameTimestampCache = new ConcurrentHashMap<>();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.cutDurationTimestamps = emptyList2;
        this.preSeekTime = -1L;
        mapOf = MapsKt__MapsKt.mapOf(new Pair(IPlayer.PlayerStatus.IDLE, IPlayer.PlayerStatus.IDLE), new Pair(IPlayer.PlayerStatus.READY, IPlayer.PlayerStatus.READY), new Pair(IPlayer.PlayerStatus.PLAYING, IPlayer.PlayerStatus.PLAYING), new Pair(IPlayer.PlayerStatus.STOPPED, IPlayer.PlayerStatus.STOPPED), new Pair(IPlayer.PlayerStatus.PAUSED, IPlayer.PlayerStatus.PAUSED), new Pair(IPlayer.PlayerStatus.FINISHED, IPlayer.PlayerStatus.FINISHED), new Pair(IPlayer.PlayerStatus.ERROR, IPlayer.PlayerStatus.ERROR), new Pair(IPlayer.PlayerStatus.REPLAY, IPlayer.PlayerStatus.REPLAY));
        this.playerStatusMap = mapOf;
        tAVPlayer.setPlayerListener(new TAVPlayer.PlayerListener() { // from class: com.tencent.tavcut.core.render.player.MoviePlayer.1
            @Override // com.tencent.tavkit.component.TAVPlayer.PlayerListener
            public void onPositionChanged(@Nullable CMTime cmTime, @Nullable CMTime playerDuration) {
                long j3;
                MoviePlayer moviePlayer = MoviePlayer.this;
                if (cmTime != null) {
                    j3 = cmTime.getTimeUs();
                } else {
                    j3 = 0;
                }
                moviePlayer.currentPlayUs = j3;
                long j16 = MoviePlayer.this.currentPlayUs;
                if (j16 > MoviePlayer.this.durationUs) {
                    j16 = MoviePlayer.this.durationUs;
                }
                MoviePlayer.this.resetSeekWhenSeekFinished();
                MoviePlayer moviePlayer2 = MoviePlayer.this;
                moviePlayer2.currentPlayUs = moviePlayer2.currentPlayUs > MoviePlayer.this.durationUs ? MoviePlayer.this.durationUs : MoviePlayer.this.currentPlayUs;
                MoviePlayer.this.positionChangeCallBack.invoke(Long.valueOf(j16), Long.valueOf(MoviePlayer.this.durationUs));
                synchronized (MoviePlayer.this.playerListeners) {
                    for (IPlayer.PlayerListener playerListener : MoviePlayer.this.playerListeners) {
                        TavLogger.d(MoviePlayer.TAG, "currentPosition: " + j16 + " duration: " + MoviePlayer.this.durationUs);
                        playerListener.onPositionChanged(j16, MoviePlayer.this.durationUs);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // com.tencent.tavkit.component.TAVPlayer.PlayerListener
            public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @Nullable Player player) {
                synchronized (MoviePlayer.this.playerListeners) {
                    Iterator it = MoviePlayer.this.playerListeners.iterator();
                    while (it.hasNext()) {
                        ((IPlayer.PlayerListener) it.next()).onStatusChanged((IPlayer.PlayerStatus) MoviePlayer.this.playerStatusMap.get(playerStatus), MoviePlayer.this);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
        if (frameLayout != null) {
            context = frameLayout.getContext();
        } else {
            context = null;
        }
        initInAccurateSeekParam(context);
    }

    private final boolean backFastSeek(long preSeekTime, long curSeekTime) {
        if (preSeekTime - curSeekTime > BACK_FAST_SEEK_TIME) {
            return true;
        }
        return false;
    }

    private final boolean forwardFastSeek(long preSeekTime, long curSeekTime) {
        TavLogger.d(TAG, "preSeekTime: " + preSeekTime + " curSeekTime: " + curSeekTime);
        boolean z16 = false;
        if (preSeekTime < curSeekTime) {
            long iFrameTimestamp = getIFrameTimestamp(preSeekTime);
            long iFrameTimestamp2 = getIFrameTimestamp(curSeekTime);
            TavLogger.d(TAG, "preIFrameTime: " + iFrameTimestamp + " curIFrameTime: " + iFrameTimestamp2);
            if ((iFrameTimestamp != iFrameTimestamp2 && curSeekTime - preSeekTime > HALF_FAST_SEEK_MIN_TIME) || curSeekTime - preSeekTime > FAST_SEEK_MIN_TIME) {
                z16 = true;
            }
        }
        TavLogger.d(TAG, "isFastSeek: " + z16);
        return z16;
    }

    private final long getIFrameTimestamp(long seekTime) {
        List sortedDescending;
        synchronized (this.clipIFrameTimestamps) {
            sortedDescending = CollectionsKt___CollectionsKt.sortedDescending(this.clipIFrameTimestamps);
            Iterator it = sortedDescending.iterator();
            while (it.hasNext()) {
                long longValue = ((Number) it.next()).longValue();
                if (seekTime > longValue) {
                    return longValue;
                }
            }
            Unit unit = Unit.INSTANCE;
            return -1L;
        }
    }

    private final long getInAccurateSeekTime(long seekTime) {
        long j3;
        long iFrameTimestamp = getIFrameTimestamp(seekTime);
        long preLimitTime = getPreLimitTime(seekTime);
        if (iFrameTimestamp < preLimitTime) {
            j3 = preLimitTime;
        } else {
            j3 = iFrameTimestamp;
        }
        long j16 = 0;
        if (j3 >= 0) {
            j16 = j3 + ((seekTime - j3) / IFRAME_DISTANCE_DIVIDER);
        }
        TavLogger.d(TAG, "getInAccurateSeekTime iFrameTime: " + iFrameTimestamp + " , preLimitTime:" + preLimitTime + ", afterChangeSeekTime : " + j16);
        return j16;
    }

    private final long getPreLimitTime(long seekTime) {
        boolean z16;
        List<Long> list = this.cutDurationTimestamps;
        Long l3 = null;
        if (list != null) {
            ListIterator<Long> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                Long previous = listIterator.previous();
                if (previous.longValue() < seekTime) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    l3 = previous;
                    break;
                }
            }
            l3 = l3;
        }
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    private final void initInAccurateSeekParam(Context context) {
        int phonePerfLevel = OfflineConfig.getPhonePerfLevel(context);
        TavLogger.i(TAG, "MoviePlayer phoneLevel: " + phonePerfLevel);
        if (phonePerfLevel <= 3) {
            FAST_SEEK_MIN_TIME = 500000;
            HALF_FAST_SEEK_MIN_TIME = 200000;
            IFRAME_DISTANCE_DIVIDER = 5;
        }
    }

    private final void resetLastSeekTime() {
        this.lastSeekTime = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetSeekWhenSeekFinished() {
        r rVar = r.f384266a;
        if (rVar.d(this.lastSeekTime) == rVar.d(this.currentPlayUs)) {
            resetLastSeekTime();
        }
        long j3 = this.interceptSeekTime;
        if (j3 != -1) {
            this.lastCallSeekTime = 0L;
            seek(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CMTime safeSeekPositionConvert(long seekToPositionUs) {
        if (seekToPositionUs < 0) {
            TavLogger.d(TAG, "error seek time " + seekToPositionUs + " small  then 0 auto adjust to 0");
            seekToPositionUs = 0L;
        } else if (seekToPositionUs > this.durationUs) {
            TavLogger.d(TAG, "error seek time " + seekToPositionUs + " big then " + this.durationUs + " auto adjust to " + this.durationUs);
            seekToPositionUs = this.durationUs - PER_FRAME_DURATION_US;
        }
        return CMTimeUtil.INSTANCE.genCMTimeFromUs(seekToPositionUs);
    }

    private final void updateComposition(TAVComposition tavComposition, long seekToPosition) {
        this.tavPlayer.updateComposition(tavComposition, safeSeekPositionConvert(seekToPosition), this.autoPlay, new OnCompositionUpdateListener() { // from class: com.tencent.tavcut.core.render.player.MoviePlayer$updateComposition$1
            /* JADX WARN: Incorrect condition in loop: B:6:0x002d */
            @Override // com.tencent.tav.player.OnCompositionUpdateListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onUpdated(Player player, boolean z16) {
                Player player2;
                LinkedList linkedList;
                boolean z17;
                LinkedList linkedList2;
                MoviePlayer.this.player = player;
                Player.setPlayerStaticConfig(Player.PlayerStaticConfigKey.CONFIG_STATIC_AUDIO_SYNC_ENABLE, false);
                MoviePlayer moviePlayer = MoviePlayer.this;
                moviePlayer.setPlayTimeRange(0L, moviePlayer.durationUs);
                player2 = MoviePlayer.this.player;
                if (player2 != null) {
                    player2.setIgnorePreparePosition(true);
                }
                while (!linkedList.isEmpty()) {
                    linkedList2 = MoviePlayer.this.runOnCompositionUpdatedEvent;
                    ((Runnable) linkedList2.poll()).run();
                }
                synchronized (MoviePlayer.this.playerListeners) {
                    Iterator it = MoviePlayer.this.playerListeners.iterator();
                    while (it.hasNext()) {
                        ((IPlayer.PlayerListener) it.next()).onPlayerSourceReady(MoviePlayer.this);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                z17 = MoviePlayer.this.autoPlay;
                if (z17 && z16) {
                    player.play();
                }
            }
        });
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void addPlayerListener(@NotNull IPlayer.PlayerListener playerListener) {
        Intrinsics.checkParameterIsNotNull(playerListener, "playerListener");
        synchronized (playerListener) {
            this.playerListeners.add(playerListener);
        }
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void changeSurfaceSize(int surfaceWidth, int surfaceHeight) {
        this.tavPlayer.onSurfaceSizeChanged(surfaceWidth, surfaceHeight);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void destroySurface() {
        this.tavPlayer.onSurfaceDestory();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public long getClipAssetsDurationUs() {
        IRenderChainManager iRenderChainManager = this.playerRenderManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getClipAssetsDuration();
        }
        return -1L;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public long getCurrentPlayUs() {
        return this.currentPlayUs;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    @NotNull
    public Rect getGlViewPort() {
        CGRect cGRect;
        Player player = this.player;
        if (player == null || (cGRect = player.getGlViewport()) == null) {
            cGRect = new CGRect();
        }
        Intrinsics.checkExpressionValueIsNotNull(cGRect, "player?.glViewport ?: CGRect()");
        PointF pointF = cGRect.origin;
        float f16 = pointF.x;
        float f17 = pointF.y;
        CGSize cGSize = cGRect.size;
        return new Rect(f16, f17, cGSize.width + f16, cGSize.height + f17);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    @NotNull
    public CMTimeRange getPlayTimeRange() {
        CMTimeRange cMTimeRange;
        CMTime duration;
        Player player = this.player;
        CMTimeRange cMTimeRange2 = null;
        if (player != null) {
            cMTimeRange = player.getPlayRange();
        } else {
            cMTimeRange = null;
        }
        if (cMTimeRange == null) {
            long j3 = 0;
            CMTime fromUs = CMTime.fromUs(0L);
            Player player2 = this.player;
            if (player2 != null && (duration = player2.duration()) != null) {
                j3 = duration.getTimeUs();
            }
            return new CMTimeRange(fromUs, CMTime.fromUs(j3));
        }
        Player player3 = this.player;
        if (player3 != null) {
            cMTimeRange2 = player3.getPlayRange();
        }
        if (cMTimeRange2 == null) {
            Intrinsics.throwNpe();
        }
        return cMTimeRange2;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    @NotNull
    public Size getRenderSize() {
        return this.renderSize;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    /* renamed from: getTotalDurationUs, reason: from getter */
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public boolean isPlaying() {
        return this.tavPlayer.isPlaying();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void pause() {
        this.tavPlayer.pause();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void play() {
        this.tavPlayer.play();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void post(@NotNull final Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        this.tavPlayer.post(new Runnable() { // from class: com.tencent.tavcut.core.render.player.MoviePlayer$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkExpressionValueIsNotNull(Function0.this.invoke(), "invoke(...)");
            }
        });
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void readSnapShootBitmap(@NotNull OnReadSnapShootListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.tavPlayer.readSnapShootBitmap(listener);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void release() {
        synchronized (this.playerListeners) {
            this.playerListeners = new ArrayList();
            Unit unit = Unit.INSTANCE;
        }
        this.tavPlayer.release();
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void removePlayerListener(@NotNull IPlayer.PlayerListener playerListener) {
        Intrinsics.checkParameterIsNotNull(playerListener, "playerListener");
        synchronized (playerListener) {
            Iterator<IPlayer.PlayerListener> it = this.playerListeners.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(it.next(), playerListener)) {
                    it.remove();
                    break;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void requestRender() {
        Player player = this.player;
        if (player != null) {
            player.refresh();
        } else {
            this.runOnCompositionUpdatedEvent.add(new Runnable() { // from class: com.tencent.tavcut.core.render.player.MoviePlayer$requestRender$2
                @Override // java.lang.Runnable
                public final void run() {
                    Player player2;
                    player2 = MoviePlayer.this.player;
                    if (player2 != null) {
                        player2.refresh();
                    }
                }
            });
        }
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void resetToTotalTimeRange() {
        setPlayTimeRange(0L, this.durationUs);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void seek(long timeUs) {
        seek(timeUs, false);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setBgColor(int bgColor) {
        this.tavPlayer.setBgColor(bgColor);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setClipAssets(@NotNull final List<ClipSource> clipsAssets) {
        Intrinsics.checkParameterIsNotNull(clipsAssets, "clipsAssets");
        this.clipsAssets = clipsAssets;
        c.f384289c.c(new Runnable() { // from class: com.tencent.tavcut.core.render.player.MoviePlayer$setClipAssets$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List list2;
                List list3;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                ArrayList arrayList = new ArrayList();
                long j3 = 0;
                for (ClipSource clipSource : clipsAssets) {
                    if (clipSource.getType() == ClipType.VIDEO) {
                        concurrentHashMap = MoviePlayer.this.clipIFrameTimestampCache;
                        List<Long> list4 = (List) concurrentHashMap.get(clipSource.getPath());
                        if (list4 == null) {
                            list4 = a.b(clipSource.getPath());
                            concurrentHashMap2 = MoviePlayer.this.clipIFrameTimestampCache;
                            concurrentHashMap2.put(clipSource.getPath(), list4);
                        }
                        if (list4 != null) {
                            Iterator<T> it = list4.iterator();
                            while (it.hasNext()) {
                                long longValue = ((Number) it.next()).longValue();
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("add timestamp: ");
                                long j16 = longValue + j3;
                                sb5.append(j16);
                                TavLogger.d("TavCut_MoviePlayer", sb5.toString());
                                arrayList.add(Long.valueOf(j16));
                            }
                        }
                    }
                    j3 += clipSource.getDuration();
                    TavLogger.d("TavCut_MoviePlayer", "lastClipDuration: " + j3);
                }
                list = MoviePlayer.this.clipIFrameTimestamps;
                synchronized (list) {
                    list2 = MoviePlayer.this.clipIFrameTimestamps;
                    list2.clear();
                    list3 = MoviePlayer.this.clipIFrameTimestamps;
                    list3.addAll(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setCutDurationList(@NotNull List<Long> timeList) {
        Intrinsics.checkParameterIsNotNull(timeList, "timeList");
        this.cutDurationTimestamps = timeList;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setEnableSync(boolean enable) {
        this.tavPlayer.setEnableSync(enable);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setLoopPlay(boolean loopPlay) {
        this.tavPlayer.setLoopPlay(loopPlay);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setPlayTimeRange(long selectedStartTimeUs, long selectedDurationUs) {
        Log.i(TAG, "setPlayTimeRange start " + selectedStartTimeUs + " end " + (selectedDurationUs + selectedStartTimeUs));
        CMTimeRange genCMTimeRangeFromUs = CMTimeUtil.INSTANCE.genCMTimeRangeFromUs(selectedStartTimeUs, selectedDurationUs);
        this.tavPlayer.setPlayRange(genCMTimeRangeFromUs);
        Player player = this.player;
        if (player != null) {
            player.setPlayRange(genCMTimeRangeFromUs);
        }
        IRenderChainManager iRenderChainManager = this.playerRenderManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setRenderTimeRange(this.tavPlayer.getPlayRange());
        }
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setPlayerThread(@Nullable HandlerThread thread) {
        this.playerThread = thread;
        this.tavPlayer.setVideoThread(thread);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setRate(float rate, int maxCacheFrameSize, boolean force) {
        Player player = this.player;
        if (player != null) {
            player.setRate(rate, maxCacheFrameSize, force);
        }
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setSeekToLastPosition(boolean seekToLastPosition) {
        this.seekToLastPosition = seekToLastPosition;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.tavPlayer.setSurfaceTextureListener(surfaceTextureListener);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void setUpSurface(@NotNull Surface surface, int surfaceWidth, int surfaceHeight) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        this.tavPlayer.onSurfaceCreate(surface, surfaceWidth, surfaceHeight);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void stop(long timeUs) {
        seek(timeUs);
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    @Nullable
    public Pair<IRenderChainManager, LAKRenderModel> updatePlayer(@NotNull String templateDir, @NotNull LAKRenderModel renderModel, long targetTime, @Nullable OnClipAssetListener onAssetListener) {
        boolean z16;
        LAKRenderModel copy;
        long j3 = targetTime;
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        if (renderModel.getJsonData() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        IRenderChainManager iRenderChainManager = this.playerRenderManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.release();
        }
        copy = renderModel.copy((r37 & 1) != 0 ? renderModel.renderScene : RenderScene.PLAY, (r37 & 2) != 0 ? renderModel.root : null, (r37 & 4) != 0 ? renderModel.jsonData : null, (r37 & 8) != 0 ? renderModel.inputSources : null, (r37 & 16) != 0 ? renderModel.painting : null, (r37 & 32) != 0 ? renderModel.clipsAssets : null, (r37 & 64) != 0 ? renderModel.modifyClipsDuration : false, (r37 & 128) != 0 ? renderModel.seekTolerance : 0, (r37 & 256) != 0 ? renderModel.properties : null, (r37 & 512) != 0 ? renderModel.audioAssets : null, (r37 & 1024) != 0 ? renderModel.timeLines : null, (r37 & 2048) != 0 ? renderModel.maxDuration : 0L, (r37 & 4096) != 0 ? renderModel.componentLevel : 0, (r37 & 8192) != 0 ? renderModel.voiceChangerConfig : null, (r37 & 16384) != 0 ? renderModel.customRenderConfig : null, (r37 & 32768) != 0 ? renderModel.exportMode : false, (r37 & 65536) != 0 ? renderModel.stickerValue : null, (r37 & 131072) != 0 ? renderModel.watermarkConfig : null);
        MediaBuilderOutput buildComposition$default = IMediaBuilder.DefaultImpls.buildComposition$default(MediaBuildFactory.INSTANCE.getMediaBuilder(RenderConfig.INSTANCE.getRenderType()), templateDir, copy, z16, false, onAssetListener, null, 40, null);
        if (buildComposition$default != null) {
            Size renderSize = buildComposition$default.getRenderModel().getPainting().getRenderSize();
            if (renderSize == null) {
                renderSize = LAKRenderModel.INSTANCE.getDEFAULT_SIZE();
            }
            this.renderSize = renderSize;
            TAVComposition composition = buildComposition$default.getComposition();
            Size size = this.renderSize;
            composition.setRenderSize(new CGSize(size.width, size.height));
            buildComposition$default.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
            if (j3 > 0) {
                this.currentPlayUs = j3;
            } else if (this.seekToLastPosition) {
                j3 = this.currentPlayUs;
            } else {
                j3 = 0;
            }
            this.durationUs = buildComposition$default.getDurationUs();
            TavLogger.i(TAG, "updatePlayer: output.durationUs:" + buildComposition$default.getDurationUs());
            this.playerComposition = buildComposition$default.getComposition();
            IRenderChainManager renderChainManager = buildComposition$default.getRenderChainManager();
            this.playerRenderManager = renderChainManager;
            if (renderChainManager != null) {
                renderChainManager.registerDurationObserver(new Function2<Long, Long, Unit>() { // from class: com.tencent.tavcut.core.render.player.MoviePlayer$updatePlayer$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Long l3, Long l16) {
                        invoke(l3.longValue(), l16.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j16, long j17) {
                        MoviePlayer.this.durationUs = j16;
                        TavLogger.i("TavCut_MoviePlayer", "updatePlayer: DurationObserver :" + MoviePlayer.this.durationUs);
                        if (j17 >= 0) {
                            MoviePlayer.this.currentPlayUs = j17;
                        }
                        MoviePlayer.this.setPlayTimeRange(0L, j16);
                        synchronized (MoviePlayer.this.playerListeners) {
                            Iterator it = MoviePlayer.this.playerListeners.iterator();
                            while (it.hasNext()) {
                                ((IPlayer.PlayerListener) it.next()).onPositionChanged(MoviePlayer.this.currentPlayUs, MoviePlayer.this.durationUs);
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
            }
            updateComposition(buildComposition$default.getComposition(), j3);
            return TuplesKt.to(buildComposition$default.getRenderChainManager(), buildComposition$default.getRenderModel());
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.render.player.IPlayer
    public void seek(long timeUs, boolean isInAccurate) {
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = timeUs;
        if (isInAccurate && (backFastSeek(this.preSeekTime, timeUs) || forwardFastSeek(this.preSeekTime, longRef.element))) {
            longRef.element = getInAccurateSeekTime(longRef.element);
        }
        this.preSeekTime = timeUs;
        TavLogger.d(TAG, "in moviePlayer timeUs: " + timeUs + " finalSeek: " + longRef.element);
        if (this.player != null) {
            this.tavPlayer.seekToTime(safeSeekPositionConvert(longRef.element));
        } else {
            this.runOnCompositionUpdatedEvent.add(new Runnable() { // from class: com.tencent.tavcut.core.render.player.MoviePlayer$seek$2
                @Override // java.lang.Runnable
                public final void run() {
                    TAVPlayer tAVPlayer;
                    CMTime safeSeekPositionConvert;
                    TavLogger.d("TavCut_MoviePlayer", "in moviePlayer runnable seek");
                    tAVPlayer = MoviePlayer.this.tavPlayer;
                    safeSeekPositionConvert = MoviePlayer.this.safeSeekPositionConvert(longRef.element);
                    tAVPlayer.seekToTime(safeSeekPositionConvert);
                }
            });
        }
    }
}
