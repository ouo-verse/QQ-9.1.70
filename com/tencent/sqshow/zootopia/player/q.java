package com.tencent.sqshow.zootopia.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.VideoUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u00017B\u0007\u00a2\u0006\u0004\bq\u0010rJ\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J$\u0010\u000e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\rH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u001c\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u001a\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010(\u001a\u00020+H\u0016J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020+H\u0016J\n\u0010.\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020\u0014H\u0016J\u0006\u00103\u001a\u00020\u0007J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\u0012\u00106\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u00107\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u000208J\n\u0010;\u001a\u0004\u0018\u000108H\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u001fH\u0016J\b\u0010@\u001a\u00020\u0007H\u0016J\b\u0010A\u001a\u00020\u0007H\u0016J\u0012\u0010C\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010D\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u000104H\u0016J\"\u0010G\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u0001042\u0006\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020\u001fH\u0016J4\u0010M\u001a\u00020\u00142\b\u0010B\u001a\u0004\u0018\u0001042\u0006\u0010H\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\b\u0010L\u001a\u0004\u0018\u00010KH\u0016J4\u0010Q\u001a\u00020\u00142\b\u0010B\u001a\u0004\u0018\u0001042\u0006\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010P\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010UR\u0018\u0010X\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010WR\u0016\u0010[\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR$\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\\0\nj\b\u0012\u0004\u0012\u00020\\`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010cR\u0016\u0010f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010ZR\u0016\u0010g\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010ZR\u0016\u0010h\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010ZR\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020+0i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010jR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020'0i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010jR\u0018\u0010n\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010mR\u0016\u0010p\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010#\u00a8\u0006s"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/q;", "Lcom/tencent/sqshow/zootopia/player/c;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCompletionListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoSizeChangedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "", "u", "t", "Ljava/util/ArrayList;", "Lcom/tencent/thumbplayer/api/optionalparam/TPOptionalParam;", "", "Lkotlin/collections/ArrayList;", "r", "O", "N", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "url", "", "isOutputMute", "K", "o", "P", "M", "G", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "E", "y", "", "errorCode", "msg", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "H", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "getVideoView", "Lcom/tencent/sqshow/zootopia/player/a;", "listener", "d", "c", "Lcom/tencent/sqshow/zootopia/player/b;", "b", "e", "getPlayUrl", "Lcom/tencent/sqshow/zootopia/player/PlayStatus;", "getCurrentStatus", "isReady", "isPrepared", "L", "Lcom/tencent/superplayer/api/ISuperPlayer;", "f", "startPlay", "a", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "w", ReportConstant.COSTREPORT_PREFIX, "pause", "reset", "xy", QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, "recycle", "destroy", "superPlayer", "onVideoPrepared", "onCompletion", "p1", "p2", "onVideoSizeChanged", "type", "", "p3", "", "p4", "onInfo", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "extraInfo", "onError", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "superPlayerView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", tl.h.F, "Z", "isSdkPreparing", "Ljava/lang/Runnable;", "i", "Ljava/util/ArrayList;", "preOperate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "currentUrl", "Lcom/tencent/sqshow/zootopia/player/PlayStatus;", "currStatus", "D", "isPlaySoon", "isDestroy", "hasSetScreenXY", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "playerListeners", "recycleListeners", "Lcom/tencent/sqshow/zootopia/player/f;", "playerOptions", "J", "videoXYaxis", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q implements c, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnVideoSizeChangedListener, ISuperPlayer.OnInfoListener {

    /* renamed from: K, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static long L;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isPlaySoon;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasSetScreenXY;

    /* renamed from: I, reason: from kotlin metadata */
    private f playerOptions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ISPlayerVideoView superPlayerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ISuperPlayer player;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSdkPreparing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String currentUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Runnable> preOperate = new ArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    private PlayStatus currStatus = PlayStatus.NOT_PREPARE;

    /* renamed from: G, reason: from kotlin metadata */
    private final CopyOnWriteArrayList<b> playerListeners = new CopyOnWriteArrayList<>();

    /* renamed from: H, reason: from kotlin metadata */
    private final CopyOnWriteArrayList<a> recycleListeners = new CopyOnWriteArrayList<>();

    /* renamed from: J, reason: from kotlin metadata */
    private int videoXYaxis = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/q$a;", "", "", "a", "sLastDownloadAvgSpeed", "J", "b", "()J", "setSLastDownloadAvgSpeed", "(J)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.player.q$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return b();
        }

        public final long b() {
            return q.L;
        }

        Companion() {
        }
    }

    public q() {
        u();
    }

    private final void A(int errorCode, String msg2) {
        Iterator<b> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onError(errorCode, msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDestroy) {
            return;
        }
        this$0.M();
        this$0.currStatus = PlayStatus.NOT_PREPARE;
    }

    private final void C() {
        Iterator<b> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onFirstFrameCome();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
    }

    private final void E() {
        Iterator<b> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    private final void F() {
        Iterator<b> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPlay();
        }
    }

    private final void G(String url) {
        Iterator<b> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().c(url);
        }
    }

    private final void H() {
        Iterator<b> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onRelease();
        }
    }

    private final void I() {
        Iterator<b> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZootopiaSuperPlayer", 1, "onVideoPrepared, player:" + this$0);
        if (this$0.isDestroy || this$0.currStatus == PlayStatus.PLAY_STATUS_STOP) {
            return;
        }
        if (this$0.isPlaySoon) {
            this$0.P();
            this$0.isPlaySoon = false;
            ISuperPlayer iSuperPlayer = this$0.player;
            if (iSuperPlayer != null) {
                iSuperPlayer.start();
            }
            this$0.currStatus = PlayStatus.PLAY_STATUS_PLAYING;
            this$0.F();
        }
        this$0.currStatus = PlayStatus.PREPARED;
    }

    private final void K(String url, boolean isOutputMute) {
        QLog.i("ZootopiaSuperPlayer", 1, "openMediaPlayer");
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.enableDownloadProxy = Boolean.TRUE;
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(isOutputMute);
        }
        ISuperPlayer iSuperPlayer2 = this.player;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.setLoopback(true);
        }
        ArrayList<TPOptionalParam<int[]>> r16 = r();
        if (isOutputMute) {
            r16.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_AUDIO_RENDERER_TYPE, new int[]{-1}));
        }
        ISuperPlayer iSuperPlayer3 = this.player;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.setPlayerOptionalParamList(r16);
        }
        ISuperPlayer iSuperPlayer4 = this.player;
        if (iSuperPlayer4 != null) {
            iSuperPlayer4.openMediaPlayer(this.context, SuperPlayerFactory.createVideoInfoForUrl(url, 203, (String) null), 0L, obtain);
        }
    }

    private final void M() {
        QLog.i("ZootopiaSuperPlayer", 1, this + " resetPlayerInner");
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        ISuperPlayer iSuperPlayer2 = this.player;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.reset();
        }
        this.playerOptions = null;
        this.hasSetScreenXY = false;
        this.currStatus = PlayStatus.NOT_PREPARE;
        O();
    }

    private final void N() {
        t();
        VideoUtils videoUtils = VideoUtils.f373236a;
        f fVar = this.playerOptions;
        String f16 = fVar != null ? fVar.f() : null;
        f fVar2 = this.playerOptions;
        SuperPlayerVideoInfo f17 = videoUtils.f(f16, fVar2 != null ? fVar2.j() : null);
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.accurateSeekOnOpen = true;
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(this);
        }
        this.isPlaySoon = true;
        d.f372208a.a(this.playerOptions, this);
        ISuperPlayer iSuperPlayer2 = this.player;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.openMediaPlayer(this.context, f17, 0L, obtain);
        }
    }

    private final void P() {
        if (this.hasSetScreenXY) {
            return;
        }
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.setXYaxis(this.videoXYaxis);
        }
        this.hasSetScreenXY = true;
    }

    private final boolean o(final String url) {
        if (this.player != null) {
            return true;
        }
        if (this.isSdkPreparing) {
            this.preOperate.add(new Runnable() { // from class: com.tencent.sqshow.zootopia.player.o
                @Override // java.lang.Runnable
                public final void run() {
                    q.p(q.this, url);
                }
            });
            return false;
        }
        A(-1, "video sdk not init");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(q this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startPlay(str);
    }

    private final void q() {
        if (this.preOperate.size() > 0) {
            Iterator<Runnable> it = this.preOperate.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
        this.preOperate.clear();
    }

    private final ArrayList<TPOptionalParam<int[]>> r() {
        ArrayList<TPOptionalParam<int[]>> arrayList = new ArrayList<>();
        arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_VIDEO_DECODER_TYPE, new int[]{102, 101}));
        return arrayList;
    }

    private final void t() {
        if (this.player == null) {
            this.player = SuperPlayerFactory.createMediaPlayer(this.context, 124, this.superPlayerView);
        } else {
            O();
        }
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(this);
        }
        ISuperPlayer iSuperPlayer2 = this.player;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.setOnErrorListener(this);
        }
        ISuperPlayer iSuperPlayer3 = this.player;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.setOnCompletionListener(this);
        }
        ISuperPlayer iSuperPlayer4 = this.player;
        if (iSuperPlayer4 != null) {
            iSuperPlayer4.setOnInfoListener(this);
        }
        ISuperPlayer iSuperPlayer5 = this.player;
        if (iSuperPlayer5 != null) {
            iSuperPlayer5.setOnVideoSizeChangedListener(this);
        }
        ISuperPlayer iSuperPlayer6 = this.player;
        if (iSuperPlayer6 != null) {
            iSuperPlayer6.setOutputMute(true);
        }
        ISuperPlayer iSuperPlayer7 = this.player;
        if (iSuperPlayer7 != null) {
            iSuperPlayer7.setLoopback(true);
        }
        ISuperPlayer iSuperPlayer8 = this.player;
        if (iSuperPlayer8 != null) {
            iSuperPlayer8.setPlayerOptionalParamList(r());
        }
    }

    private final void u() {
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        this.context = applicationContext;
        this.superPlayerView = SuperPlayerFactory.createPlayerVideoView(applicationContext, true);
        if (QQVideoPlaySDKManager.isSDKReady()) {
            t();
        } else {
            this.isSdkPreparing = true;
            QQVideoPlaySDKManager.initSDKAsync(this.context, new SDKInitListener() { // from class: com.tencent.sqshow.zootopia.player.j
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    q.v(q.this, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(q this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isSdkPreparing = false;
        if (z16) {
            this$0.t();
            this$0.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(q this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isSdkPreparing = false;
        if (z16) {
            this$0.N();
        }
    }

    private final void y() {
        Iterator<b> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDestroy) {
            return;
        }
        QLog.i("ZootopiaSuperPlayer", 4, "onCompletion resetPlayerInner");
        this$0.M();
        this$0.currStatus = PlayStatus.PLAY_STATUS_COMPLETE;
        this$0.y();
    }

    public final void L() {
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        ISuperPlayer iSuperPlayer2 = this.player;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.release();
        }
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void a(String url, boolean isOutputMute) {
        QLog.i("ZootopiaSuperPlayer", 1, this + " startPlay curStatus " + this.currStatus);
        QLog.i("ZootopiaSuperPlayer", 1, this + " startPlay " + this.player);
        if (o(url)) {
            String str = this.currentUrl;
            if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(url, this.currentUrl)) {
                QLog.i("ZootopiaSuperPlayer", 1, "resetPlayerInner " + url);
                M();
            }
            PlayStatus playStatus = this.currStatus;
            if (playStatus == PlayStatus.NOT_PREPARE) {
                this.isPlaySoon = true;
                this.currentUrl = url;
                this.currStatus = PlayStatus.PREPARING;
                G(url);
                K(url, isOutputMute);
                return;
            }
            if (playStatus == PlayStatus.PLAY_STATUS_STOP) {
                P();
                ISuperPlayer iSuperPlayer = this.player;
                if (iSuperPlayer != null) {
                    iSuperPlayer.start();
                }
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void b(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.playerListeners.contains(listener)) {
            return;
        }
        this.playerListeners.add(listener);
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void c(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.recycleListeners.remove(listener);
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void d(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.recycleListeners.contains(listener)) {
            return;
        }
        this.recycleListeners.add(listener);
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void destroy() {
        QLog.i("ZootopiaSuperPlayer", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.isDestroy = true;
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
            H();
            this.player = null;
        }
        this.playerOptions = null;
        this.superPlayerView = null;
        this.preOperate.clear();
        this.playerListeners.clear();
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void e(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.playerListeners.remove(listener);
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    /* renamed from: f, reason: from getter */
    public ISuperPlayer getPlayer() {
        return this.player;
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    /* renamed from: getCurrentStatus, reason: from getter */
    public PlayStatus getCurrStatus() {
        return this.currStatus;
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    /* renamed from: getPlayUrl, reason: from getter */
    public String getCurrentUrl() {
        return this.currentUrl;
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    /* renamed from: getVideoView, reason: from getter */
    public ISPlayerVideoView getSuperPlayerView() {
        return this.superPlayerView;
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public boolean isPrepared() {
        ISuperPlayer iSuperPlayer = this.player;
        return iSuperPlayer != null && iSuperPlayer.getCurrentPlayerState() == 4;
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public boolean isReady() {
        return this.player != null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer superPlayer, int module, int errorType, int errorCode, String extraInfo) {
        QLog.i("ZootopiaSuperPlayer", 4, "onError, player:" + superPlayer + ", module:" + module + ", errorType:" + errorType + ", errorCode" + errorCode + ", extraInfo:" + extraInfo);
        d.f372208a.b(this.playerOptions, module, errorType, errorCode, extraInfo);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.player.k
            @Override // java.lang.Runnable
            public final void run() {
                q.B(q.this);
            }
        });
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer superPlayer, int type, long p26, long p36, Object p46) {
        if (!this.isDestroy && type == 105) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.player.n
                @Override // java.lang.Runnable
                public final void run() {
                    q.D(q.this);
                }
            });
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer superPlayer) {
        QLog.i("ZootopiaSuperPlayer", 1, "onVideoPrepared, player:" + this);
        if (d.f372208a.c(this.playerOptions, this)) {
            QLog.i("ZootopiaSuperPlayer", 1, "handler by listeners::" + this);
            this.currStatus = PlayStatus.PREPARED;
            this.isPlaySoon = false;
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.player.l
            @Override // java.lang.Runnable
            public final void run() {
                q.J(q.this);
            }
        });
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer superPlayer, int p16, int p26) {
        QLog.i("ZootopiaSuperPlayer", 4, "onVideoSizeChanged " + p16 + " " + p26);
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void recycle() {
        Object obj = this.superPlayerView;
        if (obj != null && (obj instanceof View)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            ViewParent parent = ((View) obj).getParent();
            if (parent instanceof ViewGroup) {
                Object obj2 = this.superPlayerView;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
                ((ViewGroup) parent).removeView((View) obj2);
            }
        }
        Iterator<a> it = this.recycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onRecycle();
        }
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void reset() {
        QLog.i("ZootopiaSuperPlayer", 1, this + " reset player");
        if (this.isDestroy) {
            return;
        }
        this.currStatus = PlayStatus.NOT_PREPARE;
        this.currentUrl = "";
        this.isPlaySoon = false;
        Object obj = this.superPlayerView;
        if (obj != null && (obj instanceof View)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            ViewParent parent = ((View) obj).getParent();
            if (parent instanceof ViewGroup) {
                Object obj2 = this.superPlayerView;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
                ((ViewGroup) parent).removeView((View) obj2);
            }
        }
        if (this.player != null) {
            M();
            I();
        }
        this.playerOptions = null;
        this.playerListeners.clear();
        this.preOperate.clear();
    }

    /* renamed from: s, reason: from getter */
    public f getPlayerOptions() {
        return this.playerOptions;
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void setXYaxis(int xy5) {
        this.videoXYaxis = xy5;
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            this.hasSetScreenXY = true;
            iSuperPlayer.setXYaxis(xy5);
        }
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void startPlay(String url) {
        a(url, true);
    }

    public final void w(f options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.playerOptions = options;
        if (QQVideoPlaySDKManager.isSDKReady()) {
            N();
        } else {
            this.isSdkPreparing = true;
            QQVideoPlaySDKManager.initSDKAsync(this.context, new SDKInitListener() { // from class: com.tencent.sqshow.zootopia.player.p
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    q.x(q.this, z16);
                }
            });
        }
    }

    private final void O() {
        QLog.i("ZootopiaSuperPlayer", 1, "setVideoSurface");
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.updatePlayerVideoView(this.superPlayerView);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer superPlayer) {
        QLog.i("ZootopiaSuperPlayer", 4, "onCompletion");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.player.m
            @Override // java.lang.Runnable
            public final void run() {
                q.z(q.this);
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void pause() {
        QLog.i("ZootopiaSuperPlayer", 1, "pause");
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
        this.currStatus = PlayStatus.PLAY_STATUS_STOP;
        E();
    }

    @Override // com.tencent.sqshow.zootopia.player.c
    public void startPlay() {
        P();
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
    }
}
