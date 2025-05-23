package com.tencent.mobileqq.qqlive.sail.player.state;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.player.QQLivePlayerListenerDispatcher;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.player.LiveVideoContext;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.player.MediaInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u00012\u00020\u0002:\u0001\u000eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\"\u0010#J\u0013\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0013\u0010\u000e\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u0005J\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0005J*\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/PlayState;", "Lcom/tencent/mobileqq/qqlive/sail/player/state/b;", "Lmi2/c;", "", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "i", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "", "f", "", h.F, "a", "b", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "onError", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "d", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "context", "Ljava/lang/String;", "currentUrl", "J", "lastPauseTimestamp", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "watchDogJob", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;)V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PlayState implements com.tencent.mobileqq.qqlive.sail.player.state.b, mi2.c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveVideoContext context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastPauseTimestamp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job watchDogJob;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/PlayState$a;", "", "", "MIN_WATCH_DOG_UPDATE_INTERVAL_MS", "J", "", "STATE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.player.state.PlayState$a, reason: from kotlin metadata */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272347a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44232);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[LiveVideoContext.PlayerOperate.values().length];
            try {
                iArr[LiveVideoContext.PlayerOperate.PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.REPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.SWITCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.RELEASE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PREPARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f272347a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44235);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlayState(@NotNull LiveVideoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.currentUrl = "";
        this.lastPauseTimestamp = Long.MAX_VALUE;
    }

    private final void e() {
        Job job = this.watchDogJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.watchDogJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long f(ISuperPlayer player) {
        MediaInfo mediaInfo;
        if (player != null) {
            mediaInfo = player.getMediaInfo();
        } else {
            mediaInfo = null;
        }
        if (mediaInfo == null) {
            return 0L;
        }
        return (player.getPlayableDurationMs() / 1000) * ((mediaInfo.getVideoBitRate() + mediaInfo.getVideoBitRate()) / 8);
    }

    private final Object g(Continuation<? super Unit> continuation) {
        long j3;
        Object coroutine_suspended;
        ISuperPlayer h16 = this.context.h();
        boolean z16 = false;
        if (h16 != null && h16.isPlaying()) {
            z16 = true;
        }
        if (z16) {
            return Unit.INSTANCE;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d("QQLive_Player|State|PlayState", "handlePlay", "roomId=" + this.context.l() + ", playUrl=" + this.currentUrl);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.lastPauseTimestamp;
        PlayerConfig i3 = this.context.i();
        if (i3 != null) {
            j3 = i3.l();
        } else {
            j3 = Long.MAX_VALUE;
        }
        if (currentTimeMillis > j3) {
            companion.i("QQLive_Player|State|PlayState", "handlePlay", "roomId=" + this.context.l() + ", goto replay, interval=" + currentTimeMillis);
            ISuperPlayer h17 = this.context.h();
            if (h17 != null) {
                h17.stop();
            }
            this.context.t(LiveVideoContext.PlayerOperate.REPLAY);
            Object a16 = this.context.a(continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (a16 == coroutine_suspended) {
                return a16;
            }
            return Unit.INSTANCE;
        }
        QQLivePlayerListenerDispatcher f16 = this.context.f();
        if (f16 != null) {
            f16.addErrorListener(this);
        }
        ISuperPlayer h18 = this.context.h();
        if (h18 != null) {
            h18.resumeDownload();
        }
        ISuperPlayer h19 = this.context.h();
        if (h19 != null) {
            h19.setOutputMute(this.context.p());
        }
        ISuperPlayer h26 = this.context.h();
        if (h26 != null) {
            h26.start();
        }
        this.context.k().h(System.currentTimeMillis());
        i();
        return Unit.INSTANCE;
    }

    private final boolean h() {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        boolean isBlank4;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.currentUrl);
        if (!isBlank) {
            isBlank4 = StringsKt__StringsJVMKt.isBlank(this.context.n());
            if (isBlank4) {
                return true;
            }
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(this.currentUrl);
        if (isBlank2) {
            isBlank3 = StringsKt__StringsJVMKt.isBlank(this.context.n());
            if (!isBlank3) {
                return true;
            }
        }
        return Intrinsics.areEqual(this.currentUrl, this.context.n());
    }

    private final void i() {
        long j3;
        Job launch$default;
        e();
        PlayerConfig i3 = this.context.i();
        if (i3 != null) {
            j3 = i3.o();
        } else {
            j3 = 0;
        }
        if (j3 >= 1000) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(LiveCoroutineScopes.f273421a.b().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new PlayState$tryStartWatchDog$1(this, j3, null), 3, null);
            this.watchDogJob = launch$default;
            return;
        }
        AegisLogger.INSTANCE.i("QQLive_Player|State|PlayState", "tryStartWatchDog", "invalid interval, " + j3);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.player.state.b
    @Nullable
    public Object a(@NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) continuation);
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("QQLive_Player|State|PlayState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", operate=" + this.context.g());
        }
        if (this.context.g() == LiveVideoContext.PlayerOperate.SWITCH) {
            this.currentUrl = this.context.n();
        }
        if (h()) {
            this.currentUrl = this.context.n();
        } else {
            companion.i("QQLive_Player|State|PlayState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", play different url, current=" + this.currentUrl + ", new=" + this.context.n());
            this.context.t(LiveVideoContext.PlayerOperate.REPLAY);
        }
        switch (b.f272347a[this.context.g().ordinal()]) {
            case 1:
                Object g16 = g(continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (g16 == coroutine_suspended) {
                    return g16;
                }
                return Unit.INSTANCE;
            case 2:
            case 3:
                ISuperPlayer h16 = this.context.h();
                if (h16 != null) {
                    h16.stop();
                }
                Object a16 = this.context.a(continuation);
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (a16 == coroutine_suspended2) {
                    return a16;
                }
                return Unit.INSTANCE;
            case 4:
                this.currentUrl = this.context.n();
                ISuperPlayer h17 = this.context.h();
                if (h17 != null) {
                    h17.switchDefinitionForUrl(this.currentUrl, 2);
                    break;
                }
                break;
            case 5:
                ISuperPlayer h18 = this.context.h();
                if (h18 != null) {
                    h18.pause();
                }
                this.lastPauseTimestamp = System.currentTimeMillis();
                break;
            case 6:
                ISuperPlayer h19 = this.context.h();
                if (h19 != null) {
                    h19.stop();
                }
                Object a17 = this.context.a(continuation);
                coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (a17 == coroutine_suspended3) {
                    return a17;
                }
                return Unit.INSTANCE;
            default:
                companion.w("QQLive_Player|State|PlayState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", no handle operate " + this.context.g());
                break;
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.player.state.b
    @Nullable
    public Object b(@NotNull Continuation<? super com.tencent.mobileqq.qqlive.sail.player.state.b> continuation) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) continuation);
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("QQLive_Player|State|PlayState", "advance", "roomId=" + this.context.l() + ", operate=" + this.context.g());
        }
        e();
        QQLivePlayerListenerDispatcher f16 = this.context.f();
        if (f16 != null) {
            f16.removeErrorListener(this);
        }
        String str = null;
        if (this.context.e() != null) {
            long l16 = this.context.l();
            d e16 = this.context.e();
            if (e16 != null) {
                l3 = Boxing.boxLong(e16.a());
            } else {
                l3 = null;
            }
            d e17 = this.context.e();
            if (e17 != null) {
                str = e17.b();
            }
            companion.e("QQLive_Player|State|PlayState", "advance", "roomId=" + l16 + ", errCode=" + l3 + ", errMsg=" + str);
            return new a(this.context);
        }
        switch (b.f272347a[this.context.g().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return new ResetState(this.context);
            case 4:
            case 5:
            case 7:
                companion.w("QQLive_Player|State|PlayState", "advance", "roomId=" + this.context.l() + ", no handle operate " + this.context.g());
                return null;
            case 6:
                return new e(this.context);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // mi2.c
    public void onError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PlayState$onError$1(this, errorCode, extraInfo, errorType, module, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo);
        }
    }
}
