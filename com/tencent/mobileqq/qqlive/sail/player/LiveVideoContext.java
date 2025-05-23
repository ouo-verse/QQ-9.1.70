package com.tencent.mobileqq.qqlive.sail.player;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.player.QQLivePlayerListenerDispatcher;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.player.state.c;
import com.tencent.mobileqq.qqlive.sail.player.state.d;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPVideoSeiInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0003\b\u0083\u0001B\t\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0006\u0010\u0007\u001a\u00020\u0006J\u0013\u0010\b\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J4\u0010\u0016\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J2\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J \u0010 \u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016R*\u0010(\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00106\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b\u001e\u00105R\"\u0010<\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010C\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0017\u0010I\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\"\u0010L\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u00107\u001a\u0004\bE\u00109\"\u0004\bK\u0010;R*\u0010P\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010#\u001a\u0004\bN\u0010%\"\u0004\bO\u0010'R\"\u0010X\u001a\u00020Q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010_\u001a\u00020Y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\"\u0010\\\"\u0004\b]\u0010^R\u0017\u0010e\u001a\u00020`8\u0006\u00a2\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR$\u0010l\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\b1\u0010i\"\u0004\bj\u0010kR$\u0010t\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010u\u001a\u0004\b\u001f\u0010v\"\u0004\bw\u0010xR$\u0010\u007f\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b)\u0010|\"\u0004\b}\u0010~\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCompletionListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoSizeChangedListener;", "", "b", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "onVideoPrepared", "p0", "", "what", "", "p2", "p3", "", "extra", "", "onInfo", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "onError", "onCompletion", "w", h.F, "onVideoSizeChanged", "value", "d", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", AppConstants.Key.KEY_QZONE_VIDEO_URL, "e", "J", "l", "()J", "y", "(J)V", "roomId", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "f", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "i", "()Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "(Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;)V", "playerConfig", "Z", "p", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "isMute", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "o", "()Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "B", "(Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;)V", "xyAxis", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "c", "()Landroid/content/Context;", "appContext", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "shouldPlayWhenPrepared", "D", "getPlayId", "u", "playId", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext$PlayerOperate;", "E", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext$PlayerOperate;", "g", "()Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext$PlayerOperate;", "t", "(Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext$PlayerOperate;)V", "operate", "Lcom/tencent/mobileqq/qqlive/sail/player/state/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/sail/player/state/b;", "()Lcom/tencent/mobileqq/qqlive/sail/player/state/b;", "setCurrentState", "(Lcom/tencent/mobileqq/qqlive/sail/player/state/b;)V", "currentState", "Lcom/tencent/mobileqq/qqlive/sail/player/a;", "G", "Lcom/tencent/mobileqq/qqlive/sail/player/a;", "k", "()Lcom/tencent/mobileqq/qqlive/sail/player/a;", "qualityStatistics", "Lcom/tencent/mobileqq/qqlive/api/player/QQLivePlayerListenerDispatcher;", "H", "Lcom/tencent/mobileqq/qqlive/api/player/QQLivePlayerListenerDispatcher;", "()Lcom/tencent/mobileqq/qqlive/api/player/QQLivePlayerListenerDispatcher;", "r", "(Lcom/tencent/mobileqq/qqlive/api/player/QQLivePlayerListenerDispatcher;)V", "listenerDispatcher", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "I", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "j", "()Lcom/tencent/superplayer/view/ISPlayerVideoView;", HippyTKDListViewAdapter.X, "(Lcom/tencent/superplayer/view/ISPlayerVideoView;)V", "playerView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "()Lcom/tencent/superplayer/api/ISuperPlayer;", "v", "(Lcom/tencent/superplayer/api/ISuperPlayer;)V", "Lcom/tencent/mobileqq/qqlive/sail/player/state/d;", "K", "Lcom/tencent/mobileqq/qqlive/sail/player/state/d;", "()Lcom/tencent/mobileqq/qqlive/sail/player/state/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mobileqq/qqlive/sail/player/state/d;)V", "error", "<init>", "()V", "L", "PlayerOperate", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveVideoContext implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnVideoSizeChangedListener {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean shouldPlayWhenPrepared;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String playId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private PlayerOperate operate;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqlive.sail.player.state.b currentState;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final a qualityStatistics;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QQLivePlayerListenerDispatcher listenerDispatcher;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ISPlayerVideoView playerView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ISuperPlayer player;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private d error;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PlayerConfig playerConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isMute;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IQQLivePlayer.XYAxis xyAxis;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context appContext;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext$PlayerOperate;", "", "(Ljava/lang/String;I)V", "PREPARE", "PLAY", "REPLAY", "SWITCH", Tracker.PAUSE, "STOP", "RELEASE", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class PlayerOperate {
        private static final /* synthetic */ PlayerOperate[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PlayerOperate PAUSE;
        public static final PlayerOperate PLAY;
        public static final PlayerOperate PREPARE;
        public static final PlayerOperate RELEASE;
        public static final PlayerOperate REPLAY;
        public static final PlayerOperate STOP;
        public static final PlayerOperate SWITCH;

        private static final /* synthetic */ PlayerOperate[] $values() {
            return new PlayerOperate[]{PREPARE, PLAY, REPLAY, SWITCH, PAUSE, STOP, RELEASE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43203);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            PREPARE = new PlayerOperate("PREPARE", 0);
            PLAY = new PlayerOperate("PLAY", 1);
            REPLAY = new PlayerOperate("REPLAY", 2);
            SWITCH = new PlayerOperate("SWITCH", 3);
            PAUSE = new PlayerOperate(Tracker.PAUSE, 4);
            STOP = new PlayerOperate("STOP", 5);
            RELEASE = new PlayerOperate("RELEASE", 6);
            $VALUES = $values();
        }

        PlayerOperate(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static PlayerOperate valueOf(String str) {
            return (PlayerOperate) Enum.valueOf(PlayerOperate.class, str);
        }

        public static PlayerOperate[] values() {
            return (PlayerOperate[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.player.LiveVideoContext$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LiveVideoContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.videoUrl = "";
        this.xyAxis = IQQLivePlayer.XYAxis.ORIGINAL_RATIO;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        this.appContext = context;
        this.playId = "";
        this.operate = PlayerOperate.STOP;
        this.currentState = new c(this);
        this.qualityStatistics = new a();
    }

    public final void A(@NotNull String value) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        isBlank = StringsKt__StringsJVMKt.isBlank(value);
        if (!isBlank) {
            this.qualityStatistics.i(value);
            this.videoUrl = value;
        }
    }

    public final void B(@NotNull IQQLivePlayer.XYAxis xYAxis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) xYAxis);
        } else {
            Intrinsics.checkNotNullParameter(xYAxis, "<set-?>");
            this.xyAxis = xYAxis;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(@NotNull Continuation<? super Unit> continuation) {
        LiveVideoContext$changeState$1 liveVideoContext$changeState$1;
        Object coroutine_suspended;
        int i3;
        LiveVideoContext liveVideoContext;
        com.tencent.mobileqq.qqlive.sail.player.state.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return iPatchRedirector.redirect((short) 31, (Object) this, (Object) continuation);
        }
        if (continuation instanceof LiveVideoContext$changeState$1) {
            liveVideoContext$changeState$1 = (LiveVideoContext$changeState$1) continuation;
            int i16 = liveVideoContext$changeState$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveVideoContext$changeState$1.label = i16 - Integer.MIN_VALUE;
                Object obj = liveVideoContext$changeState$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveVideoContext$changeState$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    liveVideoContext = (LiveVideoContext) liveVideoContext$changeState$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.qqlive.sail.player.state.b bVar2 = this.currentState;
                    liveVideoContext$changeState$1.L$0 = this;
                    liveVideoContext$changeState$1.label = 1;
                    obj = bVar2.b(liveVideoContext$changeState$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveVideoContext = this;
                }
                bVar = (com.tencent.mobileqq.qqlive.sail.player.state.b) obj;
                if (bVar != null) {
                    liveVideoContext.currentState = bVar;
                    liveVideoContext$changeState$1.L$0 = null;
                    liveVideoContext$changeState$1.label = 2;
                    if (bVar.a(liveVideoContext$changeState$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        liveVideoContext$changeState$1 = new LiveVideoContext$changeState$1(this, continuation);
        Object obj2 = liveVideoContext$changeState$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveVideoContext$changeState$1.label;
        if (i3 == 0) {
        }
        bVar = (com.tencent.mobileqq.qqlive.sail.player.state.b) obj2;
        if (bVar != null) {
        }
        return Unit.INSTANCE;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        this.operate = PlayerOperate.RELEASE;
        this.qualityStatistics.e();
        this.listenerDispatcher = null;
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
            iSuperPlayer.release();
            iSuperPlayer.setOnVideoPreparedListener(null);
            iSuperPlayer.setOnErrorListener(null);
            iSuperPlayer.setOnCompletionListener(null);
            iSuperPlayer.setOnInfoListener(null);
            iSuperPlayer.setOnVideoSizeChangedListener(null);
        }
        this.player = null;
        this.playerView = null;
        A("");
        this.playerConfig = null;
        this.xyAxis = IQQLivePlayer.XYAxis.ORIGINAL_RATIO;
        this.shouldPlayWhenPrepared = false;
        this.error = null;
    }

    @NotNull
    public final Context c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Context) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.appContext;
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.sail.player.state.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (com.tencent.mobileqq.qqlive.sail.player.state.b) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.currentState;
    }

    @Nullable
    public final d e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (d) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.error;
    }

    @Nullable
    public final QQLivePlayerListenerDispatcher f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (QQLivePlayerListenerDispatcher) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.listenerDispatcher;
    }

    @NotNull
    public final PlayerOperate g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (PlayerOperate) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.operate;
    }

    @Nullable
    public final ISuperPlayer h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ISuperPlayer) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.player;
    }

    @Nullable
    public final PlayerConfig i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PlayerConfig) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.playerConfig;
    }

    @Nullable
    public final ISPlayerVideoView j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ISPlayerVideoView) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.playerView;
    }

    @NotNull
    public final a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (a) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.qualityStatistics;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.shouldPlayWhenPrepared;
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.videoUrl;
    }

    @NotNull
    public final IQQLivePlayer.XYAxis o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IQQLivePlayer.XYAxis) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.xyAxis;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(@Nullable ISuperPlayer p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) p06);
            return;
        }
        QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher = this.listenerDispatcher;
        if (qQLivePlayerListenerDispatcher != null) {
            qQLivePlayerListenerDispatcher.dispatchCompleted();
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(@NotNull ISuperPlayer player, int module, int errorType, int errorCode, @Nullable String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, this, player, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(player, "player");
        QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher = this.listenerDispatcher;
        if (qQLivePlayerListenerDispatcher != null) {
            qQLivePlayerListenerDispatcher.dispatchError(module, errorType, errorCode, extraInfo);
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(@Nullable ISuperPlayer p06, int what, long p26, long p36, @Nullable Object extra) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, this, p06, Integer.valueOf(what), Long.valueOf(p26), Long.valueOf(p36), extra)).booleanValue();
        }
        if (what != 3) {
            if (what != 105) {
                if (what != 126) {
                    if (what != 112) {
                        if (what != 113) {
                            if (what != 253) {
                                if (what == 254) {
                                    AegisLogger.INSTANCE.e("QQLive_Player|LiveVideoContext", "onInfo", "auto recover");
                                }
                            } else {
                                AegisLogger.INSTANCE.e("QQLive_Player|LiveVideoContext", "onInfo", "auto deinit");
                            }
                        } else {
                            this.qualityStatistics.a();
                            QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher = this.listenerDispatcher;
                            if (qQLivePlayerListenerDispatcher != null) {
                                qQLivePlayerListenerDispatcher.dispatchEndBuffer();
                            }
                        }
                    } else {
                        this.qualityStatistics.o();
                        QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher2 = this.listenerDispatcher;
                        if (qQLivePlayerListenerDispatcher2 != null) {
                            qQLivePlayerListenerDispatcher2.dispatchStartBuffer();
                        }
                    }
                } else if (extra instanceof TPVideoSeiInfo) {
                    VideoSeiInfo videoSeiInfo = new VideoSeiInfo();
                    TPVideoSeiInfo tPVideoSeiInfo = (TPVideoSeiInfo) extra;
                    videoSeiInfo.seiData = tPVideoSeiInfo.getSeiData();
                    byte[] seiData = tPVideoSeiInfo.getSeiData();
                    if (seiData != null) {
                        i3 = seiData.length;
                    } else {
                        i3 = 0;
                    }
                    videoSeiInfo.seiDataSize = i3;
                    videoSeiInfo.videoCodecType = tPVideoSeiInfo.getCodecType();
                    videoSeiInfo.videoSeiType = tPVideoSeiInfo.getSeiType();
                    QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher3 = this.listenerDispatcher;
                    if (qQLivePlayerListenerDispatcher3 != null) {
                        qQLivePlayerListenerDispatcher3.dispatchSeiInfoListener(videoSeiInfo);
                    }
                }
            } else {
                this.qualityStatistics.d();
                QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher4 = this.listenerDispatcher;
                if (qQLivePlayerListenerDispatcher4 != null) {
                    qQLivePlayerListenerDispatcher4.dispatchFirstFrameRendered();
                }
            }
        } else {
            QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher5 = this.listenerDispatcher;
            if (qQLivePlayerListenerDispatcher5 != null) {
                qQLivePlayerListenerDispatcher5.dispatchSwitchDefinition();
            }
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(@Nullable ISuperPlayer player) {
        MediaInfo mediaInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) player);
            return;
        }
        QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher = this.listenerDispatcher;
        if (qQLivePlayerListenerDispatcher != null) {
            qQLivePlayerListenerDispatcher.dispatchVideoPrepared();
        }
        if (player != null && (mediaInfo = player.getMediaInfo()) != null) {
            a aVar = this.qualityStatistics;
            String containerFormat = mediaInfo.getContainerFormat();
            Intrinsics.checkNotNullExpressionValue(containerFormat, "it.containerFormat");
            aVar.f(containerFormat);
            String videoCodec = mediaInfo.getVideoCodec();
            Intrinsics.checkNotNullExpressionValue(videoCodec, "it.videoCodec");
            aVar.k(videoCodec);
            aVar.j(mediaInfo.getVideoBitRate());
            aVar.l(mediaInfo.getVideoFps());
            aVar.n(mediaInfo.getVideoWidth());
            aVar.m(mediaInfo.getVideoHeight());
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(@NotNull ISuperPlayer player, int w3, int h16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, player, Integer.valueOf(w3), Integer.valueOf(h16));
            return;
        }
        Intrinsics.checkNotNullParameter(player, "player");
        ISPlayerVideoView iSPlayerVideoView = this.playerView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.setFixedSize(w3, h16);
        }
        QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher = this.listenerDispatcher;
        if (qQLivePlayerListenerDispatcher != null) {
            qQLivePlayerListenerDispatcher.dispatchVideoSizeChanged(w3, h16);
        }
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isMute;
    }

    public final void q(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) dVar);
        } else {
            this.error = dVar;
        }
    }

    public final void r(@Nullable QQLivePlayerListenerDispatcher qQLivePlayerListenerDispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) qQLivePlayerListenerDispatcher);
        } else {
            this.listenerDispatcher = qQLivePlayerListenerDispatcher;
        }
    }

    public final void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isMute = z16;
        }
    }

    public final void t(@NotNull PlayerOperate playerOperate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) playerOperate);
        } else {
            Intrinsics.checkNotNullParameter(playerOperate, "<set-?>");
            this.operate = playerOperate;
        }
    }

    public final void u(@NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        this.qualityStatistics.g(value);
        this.playId = value;
    }

    public final void v(@Nullable ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) iSuperPlayer);
        } else {
            this.player = iSuperPlayer;
        }
    }

    public final void w(@Nullable PlayerConfig playerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) playerConfig);
        } else {
            this.playerConfig = playerConfig;
        }
    }

    public final void x(@Nullable ISPlayerVideoView iSPlayerVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) iSPlayerVideoView);
        } else {
            this.playerView = iSPlayerVideoView;
        }
    }

    public final void y(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.roomId = j3;
        }
    }

    public final void z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.shouldPlayWhenPrepared = z16;
        }
    }
}
