package com.tencent.tavcut.render.player;

import ae4.MediaBuilderOutput;
import ae4.a;
import android.content.Context;
import android.util.Log;
import android.view.Surface;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderScene;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.videocut.utils.r;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
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
import tl.h;
import zd4.b;
import zd4.e;

@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001?B\u0011\u0012\b\u0010|\u001a\u0004\u0018\u00010{\u00a2\u0006\u0004\b}\u0010~J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0016J \u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\u0016\u0010-\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\fH\u0016J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\fH\u0016J\u0016\u00105\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000403H\u0016JB\u0010?\u001a\u00020\u00042\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u00062\u0018\u0010>\u001a\u0014\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00040<H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AH\u0016J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AH\u0016J\b\u0010E\u001a\u00020\u0004H\u0016J\b\u0010F\u001a\u00020\u0006H\u0016R\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR,\u0010X\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00040<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020A0Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010^R\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020g0f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010^R\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010^R\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010^R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010[R\u001c\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010[R\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010[R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010^R \u0010z\u001a\u000e\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020x0v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010y\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/tavcut/render/player/MoviePlayer;", "Lcom/tencent/tavcut/render/player/IPlayer;", "Landroid/content/Context;", "context", "", HippyTKDListViewAdapter.X, "", "seekTime", "v", "w", "preSeekTime", "curSeekTime", "", ReportConstant.COSTREPORT_PREFIX, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "u", "Lcom/tencent/tavkit/composition/TAVComposition;", "tavComposition", "seekToPosition", "D", "seekToPositionUs", "Lcom/tencent/tav/coremedia/CMTime;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "play", "pause", "isPlaying", "release", "timeUs", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "isInAccurate", "B", "selectedStartTimeUs", "selectedDurationUs", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/Surface;", "surface", "", "surfaceWidth", "surfaceHeight", "setUpSurface", "", "Lcom/tencent/tavcut/model/ClipSource;", "clipsAssets", "setClipAssets", "destroySurface", "autoPlay", "setAutoPlay", "loopPlay", "setLoopPlay", "Lkotlin/Function0;", "runnable", Method.POST, "", "templateDir", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "isInit", "targetTime", "Lkotlin/Function2;", "Lzd4/b;", "updateCallBack", "b", "getTotalDurationUs", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "playerListener", "a", "c", "requestRender", "getCurrentPlayUs", "Lcom/tencent/tavkit/component/TAVPlayer;", "Lcom/tencent/tavkit/component/TAVPlayer;", "tavPlayer", "Lcom/tencent/tav/player/Player;", "Lcom/tencent/tav/player/Player;", "player", "Lcom/tencent/tavkit/composition/TAVComposition;", "playerComposition", "d", "Lzd4/b;", "playerRenderManager", "Lcom/tencent/tavcut/composition/model/component/Size;", "e", "Lcom/tencent/tavcut/composition/model/component/Size;", "renderSize", "f", "Lkotlin/jvm/functions/Function2;", "positionChangeCallBack", "", "g", "Ljava/util/List;", "playerListeners", h.F, "J", "currentPlayUs", "i", "Z", "j", "seekToLastPosition", "k", "durationUs", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "l", "Ljava/util/LinkedList;", "runOnCompositionUpdatedEvent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lastCallSeekTime", DomainData.DOMAIN_NAME, "lastSeekTime", "o", "interceptSeekTime", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "clipIFrameTimestamps", "r", "cutDurationTimestamps", "", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "Ljava/util/Map;", "playerStatusMap", "Landroid/widget/FrameLayout;", "playerContainer", "<init>", "(Landroid/widget/FrameLayout;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class MoviePlayer implements IPlayer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final TAVPlayer tavPlayer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Player player;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private TAVComposition playerComposition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b playerRenderManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Size renderSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function2<? super Long, ? super Long, Unit> positionChangeCallBack;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private List<IPlayer.a> playerListeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long currentPlayUs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean seekToLastPosition;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long durationUs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<Runnable> runOnCompositionUpdatedEvent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long lastCallSeekTime;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long lastSeekTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long interceptSeekTime;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private List<ClipSource> clipsAssets;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private List<Long> clipIFrameTimestamps;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private List<Long> cutDurationTimestamps;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private long preSeekTime;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Map<IPlayer.PlayerStatus, IPlayer.PlayerStatus> playerStatusMap;

    /* renamed from: u, reason: collision with root package name */
    private static int f374400u = 1000000;

    /* renamed from: v, reason: collision with root package name */
    private static int f374401v = 500000;

    /* renamed from: w, reason: collision with root package name */
    private static int f374402w = 100000;

    /* renamed from: x, reason: collision with root package name */
    private static int f374403x = 2;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/tavcut/render/player/MoviePlayer$a", "Lcom/tencent/tavkit/component/TAVPlayer$PlayerListener;", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "playerStatus", "Lcom/tencent/tav/player/Player;", "player", "", "onStatusChanged", "Lcom/tencent/tav/coremedia/CMTime;", "cmTime", "playerDuration", "onPositionChanged", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class a implements TAVPlayer.PlayerListener {
        a() {
        }

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
            MoviePlayer.this.z();
            MoviePlayer moviePlayer2 = MoviePlayer.this;
            moviePlayer2.currentPlayUs = moviePlayer2.currentPlayUs > MoviePlayer.this.durationUs ? MoviePlayer.this.durationUs : MoviePlayer.this.currentPlayUs;
            MoviePlayer.this.positionChangeCallBack.invoke(Long.valueOf(MoviePlayer.this.currentPlayUs), Long.valueOf(MoviePlayer.this.durationUs));
            synchronized (MoviePlayer.this.playerListeners) {
                Iterator it = MoviePlayer.this.playerListeners.iterator();
                while (it.hasNext()) {
                    ((IPlayer.a) it.next()).onPositionChanged(MoviePlayer.this.currentPlayUs, MoviePlayer.this.durationUs);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.tavkit.component.TAVPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @Nullable Player player) {
            synchronized (MoviePlayer.this.playerListeners) {
                Iterator it = MoviePlayer.this.playerListeners.iterator();
                while (it.hasNext()) {
                    ((IPlayer.a) it.next()).a((IPlayer.PlayerStatus) MoviePlayer.this.playerStatusMap.get(playerStatus), MoviePlayer.this);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", StateEvent.ProcessResult.SUCCEED, "", "onUpdated"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class c implements OnCompositionUpdateListener {
        c() {
        }

        @Override // com.tencent.tav.player.OnCompositionUpdateListener
        public final void onUpdated(Player player, boolean z16) {
            MoviePlayer.this.player = player;
            Player.setPlayerStaticConfig(Player.PlayerStaticConfigKey.CONFIG_STATIC_AUDIO_SYNC_ENABLE, false);
            MoviePlayer moviePlayer = MoviePlayer.this;
            moviePlayer.C(0L, moviePlayer.durationUs);
            Player player2 = MoviePlayer.this.player;
            if (player2 != null) {
                player2.setIgnorePreparePosition(true);
            }
            while (!MoviePlayer.this.runOnCompositionUpdatedEvent.isEmpty()) {
                ((Runnable) MoviePlayer.this.runOnCompositionUpdatedEvent.poll()).run();
            }
            synchronized (MoviePlayer.this.playerListeners) {
                Iterator it = MoviePlayer.this.playerListeners.iterator();
                while (it.hasNext()) {
                    ((IPlayer.a) it.next()).b(MoviePlayer.this);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (MoviePlayer.this.autoPlay && z16) {
                player.play();
            }
        }
    }

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
        this.tavPlayer = tAVPlayer;
        this.renderSize = RenderModel.INSTANCE.getDEFAULT_SIZE();
        this.positionChangeCallBack = new Function2<Long, Long, Unit>() { // from class: com.tencent.tavcut.render.player.MoviePlayer$positionChangeCallBack$1
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
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.cutDurationTimestamps = emptyList2;
        this.preSeekTime = -1L;
        mapOf = MapsKt__MapsKt.mapOf(new Pair(IPlayer.PlayerStatus.IDLE, IPlayer.PlayerStatus.IDLE), new Pair(IPlayer.PlayerStatus.READY, IPlayer.PlayerStatus.READY), new Pair(IPlayer.PlayerStatus.PLAYING, IPlayer.PlayerStatus.PLAYING), new Pair(IPlayer.PlayerStatus.STOPPED, IPlayer.PlayerStatus.STOPPED), new Pair(IPlayer.PlayerStatus.PAUSED, IPlayer.PlayerStatus.PAUSED), new Pair(IPlayer.PlayerStatus.FINISHED, IPlayer.PlayerStatus.FINISHED), new Pair(IPlayer.PlayerStatus.ERROR, IPlayer.PlayerStatus.ERROR), new Pair(IPlayer.PlayerStatus.REPLAY, IPlayer.PlayerStatus.REPLAY));
        this.playerStatusMap = mapOf;
        tAVPlayer.setPlayerListener(new a());
        if (frameLayout != null) {
            context = frameLayout.getContext();
        } else {
            context = null;
        }
        x(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CMTime A(long seekToPositionUs) {
        if (seekToPositionUs < 0) {
            ee4.b.a("TavCut_MoviePlayer", "error seek time " + seekToPositionUs + " small  then 0 auto adjust to 0");
            seekToPositionUs = 0L;
        } else if (seekToPositionUs > this.durationUs) {
            ee4.b.a("TavCut_MoviePlayer", "error seek time " + seekToPositionUs + " big then " + this.durationUs + " auto adjust to " + this.durationUs);
            seekToPositionUs = this.durationUs - 3333;
        }
        return ie4.a.f407564a.a(seekToPositionUs);
    }

    private final void D(TAVComposition tavComposition, long seekToPosition) {
        this.tavPlayer.updateComposition(tavComposition, A(seekToPosition), this.autoPlay, new c());
    }

    private final boolean s(long preSeekTime, long curSeekTime) {
        if (preSeekTime - curSeekTime > f374402w) {
            return true;
        }
        return false;
    }

    private final boolean t(long preSeekTime, long curSeekTime) {
        ee4.b.e("TavCut_MoviePlayer", "preSeekTime: " + preSeekTime + " curSeekTime: " + curSeekTime);
        boolean z16 = false;
        if (preSeekTime < curSeekTime) {
            long u16 = u(preSeekTime);
            long u17 = u(curSeekTime);
            ee4.b.e("TavCut_MoviePlayer", "preIFrameTime: " + u16 + " curIFrameTime: " + u17);
            if ((u16 != u17 && curSeekTime - preSeekTime > f374401v) || curSeekTime - preSeekTime > f374400u) {
                z16 = true;
            }
        }
        ee4.b.e("TavCut_MoviePlayer", "isFastSeek: " + z16);
        return z16;
    }

    private final long u(long seekTime) {
        List sortedDescending;
        sortedDescending = CollectionsKt___CollectionsKt.sortedDescending(this.clipIFrameTimestamps);
        Iterator it = sortedDescending.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            if (seekTime > longValue) {
                return longValue;
            }
        }
        return -1L;
    }

    private final long v(long seekTime) {
        long j3;
        long u16 = u(seekTime);
        long w3 = w(seekTime);
        if (u16 < w3) {
            j3 = w3;
        } else {
            j3 = u16;
        }
        long j16 = 0;
        if (j3 >= 0) {
            j16 = j3 + ((seekTime - j3) / f374403x);
        }
        ee4.b.a("TavCut_MoviePlayer", "getInAccurateSeekTime iFrameTime: " + u16 + " , preLimitTime:" + w3 + ", afterChangeSeekTime : " + j16);
        return j16;
    }

    private final long w(long seekTime) {
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

    private final void x(Context context) {
        int phonePerfLevel = OfflineConfig.getPhonePerfLevel(context);
        ee4.b.e("TavCut_MoviePlayer", "MoviePlayer phoneLevel: " + phonePerfLevel);
        if (phonePerfLevel <= 3) {
            f374400u = 500000;
            f374401v = 200000;
            f374403x = 5;
        }
    }

    private final void y() {
        this.lastSeekTime = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        r rVar = r.f384266a;
        if (rVar.d(this.lastSeekTime) == rVar.d(this.currentPlayUs)) {
            y();
        }
        long j3 = this.interceptSeekTime;
        if (j3 != -1) {
            this.lastCallSeekTime = 0L;
            seek(j3);
        }
    }

    public void B(long timeUs, boolean isInAccurate) {
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = timeUs;
        if (isInAccurate && (s(this.preSeekTime, timeUs) || t(this.preSeekTime, longRef.element))) {
            longRef.element = v(longRef.element);
        }
        this.preSeekTime = timeUs;
        ee4.b.e("TavCut_MoviePlayer", "in moviePlayer timeUs: " + timeUs + " finalSeek: " + longRef.element);
        if (this.player != null) {
            this.tavPlayer.seekToTime(A(longRef.element));
        } else {
            this.runOnCompositionUpdatedEvent.add(new Runnable() { // from class: com.tencent.tavcut.render.player.MoviePlayer$seek$2
                @Override // java.lang.Runnable
                public final void run() {
                    TAVPlayer tAVPlayer;
                    CMTime A;
                    ee4.b.a("TavCut_MoviePlayer", "in moviePlayer runnable seek");
                    tAVPlayer = MoviePlayer.this.tavPlayer;
                    A = MoviePlayer.this.A(longRef.element);
                    tAVPlayer.seekToTime(A);
                }
            });
        }
    }

    public void C(long selectedStartTimeUs, long selectedDurationUs) {
        Log.i("TavCut_MoviePlayer", "setPlayTimeRange start " + selectedStartTimeUs + " end " + (selectedDurationUs + selectedStartTimeUs));
        CMTimeRange b16 = ie4.a.f407564a.b(selectedStartTimeUs, selectedDurationUs);
        this.tavPlayer.setPlayRange(b16);
        Player player = this.player;
        if (player != null) {
            player.setPlayRange(b16);
        }
        b bVar = this.playerRenderManager;
        if (bVar != null) {
            bVar.setRenderTimeRange(this.tavPlayer.getPlayRange());
        }
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void a(@NotNull IPlayer.a playerListener) {
        Intrinsics.checkParameterIsNotNull(playerListener, "playerListener");
        synchronized (playerListener) {
            this.playerListeners.add(playerListener);
        }
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void b(@NotNull String templateDir, @NotNull RenderModel renderModel, boolean isInit, long targetTime, @NotNull Function2<? super b, ? super RenderModel, Unit> updateCallBack) {
        RenderModel copy;
        float f16;
        long j3 = targetTime;
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(updateCallBack, "updateCallBack");
        if (renderModel.getRoot() == null) {
            return;
        }
        b bVar = this.playerRenderManager;
        if (bVar != null) {
            bVar.release();
        }
        copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : RenderScene.PLAY, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : null, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : null, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : 0L, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
        MediaBuilderOutput a16 = a.C0030a.a(ae4.b.f25939a.a(e.f452395c.b()), templateDir, copy, isInit, false, 8, null);
        if (a16 != null) {
            Size size = a16.getRenderModel().getPainting().renderSize;
            if (size == null) {
                size = RenderModel.INSTANCE.getDEFAULT_SIZE();
            }
            this.renderSize = size;
            TAVComposition composition = a16.getComposition();
            Integer num = this.renderSize.width;
            float f17 = 0.0f;
            if (num != null) {
                f16 = num.intValue();
            } else {
                f16 = 0.0f;
            }
            Integer num2 = this.renderSize.height;
            if (num2 != null) {
                f17 = num2.intValue();
            }
            composition.setRenderSize(new CGSize(f16, f17));
            a16.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
            if (j3 > 0) {
                this.currentPlayUs = j3;
            } else if (this.seekToLastPosition) {
                j3 = this.currentPlayUs;
            } else {
                j3 = 0;
            }
            this.durationUs = a16.getDurationUs();
            this.playerComposition = a16.getComposition();
            b renderChainManager = a16.getRenderChainManager();
            this.playerRenderManager = renderChainManager;
            if (renderChainManager != null) {
                renderChainManager.registerDurationObserver(new Function2<Long, Long, Unit>() { // from class: com.tencent.tavcut.render.player.MoviePlayer$updatePlayer$1
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
                        if (j17 >= 0) {
                            MoviePlayer.this.currentPlayUs = j17;
                        }
                        MoviePlayer.this.C(0L, j16);
                        synchronized (MoviePlayer.this.playerListeners) {
                            Iterator it = MoviePlayer.this.playerListeners.iterator();
                            while (it.hasNext()) {
                                ((IPlayer.a) it.next()).onPositionChanged(MoviePlayer.this.currentPlayUs, MoviePlayer.this.durationUs);
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
            }
            D(a16.getComposition(), j3);
            updateCallBack.invoke(a16.getRenderChainManager(), a16.getRenderModel());
        }
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void c(@NotNull IPlayer.a playerListener) {
        Intrinsics.checkParameterIsNotNull(playerListener, "playerListener");
        synchronized (playerListener) {
            Iterator<IPlayer.a> it = this.playerListeners.iterator();
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

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void destroySurface() {
        this.tavPlayer.onSurfaceDestory();
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public long getCurrentPlayUs() {
        return this.currentPlayUs;
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    /* renamed from: getTotalDurationUs, reason: from getter */
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public boolean isPlaying() {
        return this.tavPlayer.isPlaying();
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void pause() {
        this.tavPlayer.pause();
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void play() {
        this.tavPlayer.play();
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void post(@NotNull final Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        this.tavPlayer.post(new Runnable() { // from class: com.tencent.tavcut.render.player.MoviePlayer$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkExpressionValueIsNotNull(Function0.this.invoke(), "invoke(...)");
            }
        });
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void release() {
        synchronized (this.playerListeners) {
            this.playerListeners = new ArrayList();
            Unit unit = Unit.INSTANCE;
        }
        this.tavPlayer.release();
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void requestRender() {
        Player player = this.player;
        if (player != null) {
            player.refresh();
        } else {
            this.runOnCompositionUpdatedEvent.add(new Runnable() { // from class: com.tencent.tavcut.render.player.MoviePlayer$requestRender$2
                @Override // java.lang.Runnable
                public final void run() {
                    Player player2 = MoviePlayer.this.player;
                    if (player2 != null) {
                        player2.refresh();
                    }
                }
            });
        }
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void seek(long timeUs) {
        B(timeUs, false);
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public synchronized void setClipAssets(@NotNull final List<ClipSource> clipsAssets) {
        Intrinsics.checkParameterIsNotNull(clipsAssets, "clipsAssets");
        this.clipsAssets = clipsAssets;
        this.clipIFrameTimestamps.clear();
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = 0L;
        com.tencent.videocut.utils.thread.c.f384289c.c(new Runnable() { // from class: com.tencent.tavcut.render.player.MoviePlayer$setClipAssets$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                for (ClipSource clipSource : clipsAssets) {
                    if (clipSource.type == ClipSource.ClipType.VIDEO) {
                        List<Long> a16 = le4.a.a(clipSource.path);
                        Intrinsics.checkExpressionValueIsNotNull(a16, "CutMediaExtractor.getKeyFrameTime(clip.path)");
                        Iterator<T> it = a16.iterator();
                        while (it.hasNext()) {
                            long longValue = ((Number) it.next()).longValue();
                            ee4.b.a("TavCut_MoviePlayer", "add timestamp: " + (longRef.element + longValue));
                            list = MoviePlayer.this.clipIFrameTimestamps;
                            list.add(Long.valueOf(longRef.element + longValue));
                        }
                    }
                    longRef.element += clipSource.duration;
                    ee4.b.a("TavCut_MoviePlayer", "lastClipDuration: " + longRef.element);
                }
            }
        });
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void setLoopPlay(boolean loopPlay) {
        this.tavPlayer.setLoopPlay(loopPlay);
    }

    @Override // com.tencent.tavcut.render.player.IPlayer
    public void setUpSurface(@NotNull Surface surface, int surfaceWidth, int surfaceHeight) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        this.tavPlayer.onSurfaceCreate(surface, surfaceWidth, surfaceHeight);
    }
}
