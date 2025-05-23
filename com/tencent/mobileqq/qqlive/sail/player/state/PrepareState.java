package com.tencent.mobileqq.qqlive.sail.player.state;

import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.player.QQLivePlayerListenerDispatcher;
import com.tencent.mobileqq.qqlive.api.player.TPOptionalParamBuilder;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.player.LiveVideoContext;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mi2.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0002\u0014:B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\u0013\u0010\u0011\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0013\u0010\u0014\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0012J*\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010#R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010-R\u0014\u00101\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00100R\u0014\u00105\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00100R\u0014\u00106\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/PrepareState;", "Lcom/tencent/mobileqq/qqlive/sail/player/state/b;", "Lmi2/c;", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", DownloadInfo.spKey_Config, "", "l", "", "url", "", h.F, "Lcom/tencent/superplayer/api/SuperPlayerOption;", "option", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "f", "e", DomainData.DOMAIN_NAME, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extraInfo", "onError", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "d", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "context", "Ljava/lang/String;", "currentUrl", "Lcom/tencent/mobileqq/qqlive/api/player/TPOptionalParamBuilder;", "Lcom/tencent/mobileqq/qqlive/api/player/TPOptionalParamBuilder;", "optionalParamBuilder", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/CancellableContinuation;", "waitVideoPreparedContinuation", "Lcom/tencent/mobileqq/qqlive/sail/player/state/PrepareState$PrepareStatus;", "i", "Lcom/tencent/mobileqq/qqlive/sail/player/state/PrepareState$PrepareStatus;", "prepareStatus", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "preloadDownloadJob", "k", "()Z", "isVideoPreparing", "j", "isVideoPrepared", "g", "canPlay", "isThePrepareVideo", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;)V", BdhLogUtil.LogTag.Tag_Conn, "PrepareStatus", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PrepareState implements com.tencent.mobileqq.qqlive.sail.player.state.b, mi2.c {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveVideoContext context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TPOptionalParamBuilder optionalParamBuilder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CancellableContinuation<? super Boolean> waitVideoPreparedContinuation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PrepareStatus prepareStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job preloadDownloadJob;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/PrepareState$PrepareStatus;", "", "(Ljava/lang/String;I)V", "NOT_PREPARE", "PREPARING", "PREPARED", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class PrepareStatus {
        private static final /* synthetic */ PrepareStatus[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PrepareStatus NOT_PREPARE;
        public static final PrepareStatus PREPARED;
        public static final PrepareStatus PREPARING;

        private static final /* synthetic */ PrepareStatus[] $values() {
            return new PrepareStatus[]{NOT_PREPARE, PREPARING, PREPARED};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44239);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            NOT_PREPARE = new PrepareStatus("NOT_PREPARE", 0);
            PREPARING = new PrepareStatus("PREPARING", 1);
            PREPARED = new PrepareStatus("PREPARED", 2);
            $VALUES = $values();
        }

        PrepareStatus(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static PrepareStatus valueOf(String str) {
            return (PrepareStatus) Enum.valueOf(PrepareStatus.class, str);
        }

        public static PrepareStatus[] values() {
            return (PrepareStatus[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/PrepareState$a;", "", "", "STATE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.player.state.PrepareState$a, reason: from kotlin metadata */
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
        public static final /* synthetic */ int[] f272354a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44242);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[LiveVideoContext.PlayerOperate.values().length];
            try {
                iArr[LiveVideoContext.PlayerOperate.RELEASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.REPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.SWITCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PREPARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f272354a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/sail/player/state/PrepareState$c", "Lmi2/g;", "", "onVideoPrepared", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f272356e;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f272356e = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrepareState.this, (Object) cancellableContinuation);
            }
        }

        @Override // mi2.g
        public void onVideoPrepared() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("QQLive_Player|State|PrepareState", "onVideoPrepared", "roomId=" + PrepareState.this.context.l() + ", active=" + this.f272356e.isActive());
            }
            QQLivePlayerListenerDispatcher f16 = PrepareState.this.context.f();
            if (f16 != null) {
                f16.removeVideoPreparedListener(this);
            }
            if (this.f272356e.isActive()) {
                PrepareState.this.context.k().b();
                CancellableContinuation<Boolean> cancellableContinuation = this.f272356e;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44251);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PrepareState(@NotNull LiveVideoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.currentUrl = "";
        this.optionalParamBuilder = new TPOptionalParamBuilder();
        this.prepareStatus = PrepareStatus.NOT_PREPARE;
    }

    private final com.tencent.mobileqq.qqlive.sail.player.state.b e() {
        Boolean bool;
        if (!i()) {
            AegisLogger.INSTANCE.i("QQLive_Player|State|PrepareState", "checkCanPlay", "roomId=" + this.context.l() + ", different url, current=" + this.currentUrl + ", new=" + this.context.n());
            return new ResetState(this.context);
        }
        if (g()) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isDevelopLevel()) {
                companion.d("QQLive_Player|State|PrepareState", "checkCanPlay", "roomId=" + this.context.l() + ", playUrl=" + this.currentUrl);
            }
            this.context.t(LiveVideoContext.PlayerOperate.PLAY);
            return new PlayState(this.context);
        }
        AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
        if (companion2.isColorLevel()) {
            long l3 = this.context.l();
            boolean m3 = this.context.m();
            PlayerConfig i3 = this.context.i();
            if (i3 != null) {
                bool = Boolean.valueOf(i3.k());
            } else {
                bool = null;
            }
            companion2.i("QQLive_Player|State|PrepareState", "checkCanPlay", "roomId=" + l3 + ", cannot play, " + m3 + ", " + bool);
        }
        return null;
    }

    private final void f(PlayerConfig config, SuperPlayerOption option, SuperPlayerVideoInfo videoInfo) {
        if (config.f() == StreamFormat.FLV && !h(this.currentUrl)) {
            if (config.p()) {
                option.enableDownloadProxy = Boolean.TRUE;
                option.superPlayerDownOption.enableFlvPreloadMode = true;
                HashMap<String, String> extraDownloadParams = videoInfo.getExtraDownloadParams();
                Intrinsics.checkNotNullExpressionValue(extraDownloadParams, "videoInfo.extraDownloadParams");
                extraDownloadParams.put("dl_param_preload_duration", String.valueOf(config.d()));
                HashMap<String, String> extraDownloadParams2 = videoInfo.getExtraDownloadParams();
                Intrinsics.checkNotNullExpressionValue(extraDownloadParams2, "videoInfo.extraDownloadParams");
                extraDownloadParams2.put("dl_param_preload_size", String.valueOf(config.e()));
            }
            if (config.r()) {
                option.enableDownloadProxy = Boolean.TRUE;
                if (config.b()) {
                    option.superPlayerDownOption.quicEnableMode = 2;
                }
                option.superPlayerDownOption.enableQuicPlaintext = config.c();
            }
        }
        Map<String, String> g16 = config.g();
        if (g16 != null) {
            option.httpHeader = g16;
        }
    }

    private final boolean g() {
        boolean z16;
        if (!j() || !this.context.m()) {
            return false;
        }
        PlayerConfig i3 = this.context.i();
        if (i3 != null && i3.k()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    private final boolean h(String url) {
        boolean startsWith$default;
        if (!TextUtils.isEmpty(url)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "rtmp://", false, 2, null);
            if (!startsWith$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean i() {
        return Intrinsics.areEqual(this.context.n(), this.currentUrl);
    }

    private final boolean j() {
        if (this.prepareStatus == PrepareStatus.PREPARED) {
            return true;
        }
        return false;
    }

    private final boolean k() {
        if (this.prepareStatus == PrepareStatus.PREPARING) {
            return true;
        }
        return false;
    }

    private final void l(PlayerConfig config) {
        int i3;
        ArrayList<Object> buildOptionalParams = this.optionalParamBuilder.buildOptionalParams(config);
        ISuperPlayer h16 = this.context.h();
        if (h16 != null) {
            h16.setPlayerOptionalParamList(buildOptionalParams);
        }
        SuperPlayerOption option = SuperPlayerOption.obtain();
        if (config.f() == StreamFormat.FLV && !h(this.currentUrl)) {
            i3 = 202;
        } else if (h(this.currentUrl)) {
            i3 = 103;
        } else {
            i3 = 203;
        }
        SuperPlayerVideoInfo videoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.currentUrl, i3, (String) null);
        Intrinsics.checkNotNullExpressionValue(option, "option");
        Intrinsics.checkNotNullExpressionValue(videoInfo, "videoInfo");
        f(config, option, videoInfo);
        ISuperPlayer h17 = this.context.h();
        if (h17 != null) {
            h17.openMediaPlayer(this.context.c(), videoInfo, 0L, option);
        }
        this.context.k().p();
    }

    private final void m() {
        Job launch$default;
        Job job = this.preloadDownloadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(LiveCoroutineScopes.f273421a.b().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new PrepareState$preloadDownload$1(this, null), 3, null);
        this.preloadDownloadJob = launch$default;
    }

    private final Object n(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("QQLive_Player|State|PrepareState", "waitVideoPrepared", "roomId=" + this.context.l() + ", error=" + this.context.e());
        }
        if (this.context.e() == null) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            if (this.context.e() == null) {
                this.waitVideoPreparedContinuation = cancellableContinuationImpl;
                QQLivePlayerListenerDispatcher f16 = this.context.f();
                if (f16 != null) {
                    f16.addVideoPreparedListener(new c(cancellableContinuationImpl));
                }
            } else {
                companion.i("QQLive_Player|State|PrepareState", "waitVideoPrepared", "roomId=" + this.context.l() + ", has error");
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        companion.i("QQLive_Player|State|PrepareState", "waitVideoPrepared", "roomId=" + this.context.l() + ", has error, return immediately");
        return Boxing.boxBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0206 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0073  */
    @Override // com.tencent.mobileqq.qqlive.sail.player.state.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull Continuation<? super Unit> continuation) {
        PrepareState$run$1 prepareState$run$1;
        Object coroutine_suspended;
        int i3;
        boolean isBlank;
        PrepareState prepareState;
        Integer num;
        AegisLogger.Companion companion;
        LiveVideoContext liveVideoContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) continuation);
        }
        if (continuation instanceof PrepareState$run$1) {
            prepareState$run$1 = (PrepareState$run$1) continuation;
            int i16 = prepareState$run$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                prepareState$run$1.label = i16 - Integer.MIN_VALUE;
                Object obj = prepareState$run$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = prepareState$run$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 == 5) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    prepareState = (PrepareState) prepareState$run$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    if (((Boolean) obj).booleanValue()) {
                                        prepareState.prepareStatus = PrepareStatus.PREPARED;
                                        prepareState.m();
                                    }
                                    companion = AegisLogger.INSTANCE;
                                    if (companion.isDevelopLevel()) {
                                        companion.d("QQLive_Player|State|PrepareState", TencentLocation.RUN_MODE, "roomId=" + prepareState.context.l() + ", after wait");
                                    }
                                    liveVideoContext = prepareState.context;
                                    prepareState$run$1.L$0 = null;
                                    prepareState$run$1.label = 5;
                                    if (liveVideoContext.a(prepareState$run$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                    if (companion2.isColorLevel()) {
                        long l3 = this.context.l();
                        LiveVideoContext.PlayerOperate g16 = this.context.g();
                        ISuperPlayer h16 = this.context.h();
                        if (h16 != null) {
                            num = Boxing.boxInt(h16.getCurrentPlayerState());
                        } else {
                            num = null;
                        }
                        companion2.i("QQLive_Player|State|PrepareState", TencentLocation.RUN_MODE, "roomId=" + l3 + ", operate=" + g16 + ", superPlayerState=" + num);
                    }
                    if (k()) {
                        companion2.i("QQLive_Player|State|PrepareState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", video is preparing");
                        return Unit.INSTANCE;
                    }
                    if (j()) {
                        companion2.i("QQLive_Player|State|PrepareState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", video is prepared, try to next state");
                        LiveVideoContext liveVideoContext2 = this.context;
                        prepareState$run$1.label = 1;
                        if (liveVideoContext2.a(prepareState$run$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    this.prepareStatus = PrepareStatus.PREPARING;
                    String n3 = this.context.n();
                    isBlank = StringsKt__StringsJVMKt.isBlank(n3);
                    if (isBlank) {
                        this.context.q(new d(-10000010L, com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE.d(-10000010L), 0, 0, 12, null));
                        LiveVideoContext liveVideoContext3 = this.context;
                        prepareState$run$1.label = 2;
                        if (liveVideoContext3.a(prepareState$run$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    this.currentUrl = n3;
                    PlayerConfig i17 = this.context.i();
                    if (i17 == null) {
                        this.context.q(new d(-10000011L, com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE.d(-10000011L), 0, 0, 12, null));
                        LiveVideoContext liveVideoContext4 = this.context;
                        prepareState$run$1.label = 3;
                        if (liveVideoContext4.a(prepareState$run$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    QQLivePlayerListenerDispatcher f16 = this.context.f();
                    if (f16 != null) {
                        f16.addErrorListener(this);
                    }
                    l(i17);
                    if (companion2.isDevelopLevel()) {
                        companion2.d("QQLive_Player|State|PrepareState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", before wait");
                    }
                    prepareState$run$1.L$0 = this;
                    prepareState$run$1.label = 4;
                    obj = n(prepareState$run$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    prepareState = this;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    companion = AegisLogger.INSTANCE;
                    if (companion.isDevelopLevel()) {
                    }
                    liveVideoContext = prepareState.context;
                    prepareState$run$1.L$0 = null;
                    prepareState$run$1.label = 5;
                    if (liveVideoContext.a(prepareState$run$1) == coroutine_suspended) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        prepareState$run$1 = new PrepareState$run$1(this, continuation);
        Object obj2 = prepareState$run$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = prepareState$run$1.label;
        if (i3 == 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.player.state.b
    @Nullable
    public Object b(@NotNull Continuation<? super com.tencent.mobileqq.qqlive.sail.player.state.b> continuation) {
        Long l3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) continuation);
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("QQLive_Player|State|PrepareState", "advance", "roomId=" + this.context.l() + ", operate=" + this.context.g());
        }
        CancellableContinuation<? super Boolean> cancellableContinuation = this.waitVideoPreparedContinuation;
        if (cancellableContinuation != null) {
            Boxing.boxBoolean(CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null));
        }
        QQLivePlayerListenerDispatcher f16 = this.context.f();
        if (f16 != null) {
            f16.removeErrorListener(this);
        }
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
            } else {
                str = null;
            }
            companion.e("QQLive_Player|State|PrepareState", "advance", "roomId=" + l16 + ", errCode=" + l3 + ", errMsg=" + str);
            Job job = this.preloadDownloadJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            return new a(this.context);
        }
        switch (b.f272354a[this.context.g().ordinal()]) {
            case 1:
                Job job2 = this.preloadDownloadJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                return new e(this.context);
            case 2:
            case 3:
                Job job3 = this.preloadDownloadJob;
                if (job3 != null) {
                    Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                }
                return e();
            case 4:
                Job job4 = this.preloadDownloadJob;
                if (job4 != null) {
                    Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
                }
                return new ResetState(this.context);
            case 5:
            case 6:
            case 7:
                if (!companion.isColorLevel()) {
                    return null;
                }
                companion.i("QQLive_Player|State|PrepareState", "advance", "roomId=" + this.context.l() + ", terminate, operate=" + this.context.g());
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // mi2.c
    public void onError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo);
            return;
        }
        LiveVideoContext liveVideoContext = this.context;
        long j3 = errorCode;
        if (extraInfo == null) {
            extraInfo = "";
        }
        liveVideoContext.q(new d(j3, extraInfo, errorType, module));
        AegisLogger.INSTANCE.e("QQLive_Player|State|PrepareState", "onError", "roomId=" + this.context.l() + ", error=" + this.context.e());
        CancellableContinuation<? super Boolean> cancellableContinuation = this.waitVideoPreparedContinuation;
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }
}
