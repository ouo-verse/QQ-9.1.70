package com.tencent.mobileqq.qqlive.sail.player.state;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.player.LiveVideoContext;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
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
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\t\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0013\u0010\f\u001a\u00020\u0001H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/InitState;", "Lcom/tencent/mobileqq/qqlive/sail/player/state/b;", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", DownloadInfo.spKey_Config, "", "g", "(Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "e", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "b", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "d", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "context", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;)V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class InitState implements com.tencent.mobileqq.qqlive.sail.player.state.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveVideoContext context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/InitState$a;", "", "", "STATE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.player.state.InitState$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272340a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44209);
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
                iArr[LiveVideoContext.PlayerOperate.STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PREPARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.REPLAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.SWITCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PLAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f272340a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isSucceed", "", "onSDKInited"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class c implements SDKInitListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f272341d;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f272341d = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public final void onSDKInited(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (this.f272341d.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f272341d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InitState(@NotNull LiveVideoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    private final void e(PlayerConfig config) {
        if (this.context.h() != null) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isDevelopLevel()) {
                companion.d("QQLive_Player|State|InitState", "doCreateSuperPlayer", "roomId=" + this.context.l() + ", already have a player");
                return;
            }
            return;
        }
        LiveVideoContext liveVideoContext = this.context;
        liveVideoContext.s(config.q());
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(liveVideoContext.c(), config.m(), liveVideoContext.j());
        createMediaPlayer.updatePlayerSceneId(config.m());
        createMediaPlayer.setOutputMute(config.q());
        createMediaPlayer.setXYaxis(this.context.o().getValue());
        createMediaPlayer.setOnVideoPreparedListener(this.context);
        createMediaPlayer.setOnErrorListener(this.context);
        createMediaPlayer.setOnCompletionListener(this.context);
        createMediaPlayer.setOnInfoListener(this.context);
        createMediaPlayer.setOnVideoSizeChangedListener(this.context);
        liveVideoContext.v(createMediaPlayer);
        AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
        if (companion2.isDevelopLevel()) {
            companion2.d("QQLive_Player|State|InitState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", create player success");
        }
    }

    private final Object f(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QQVideoPlaySDKManager.initSDKAsync(this.context.c(), new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(PlayerConfig playerConfig, Continuation<? super Boolean> continuation) {
        InitState$tryCreateSuperPlayer$1 initState$tryCreateSuperPlayer$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        InitState initState;
        if (continuation instanceof InitState$tryCreateSuperPlayer$1) {
            initState$tryCreateSuperPlayer$1 = (InitState$tryCreateSuperPlayer$1) continuation;
            int i16 = initState$tryCreateSuperPlayer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                initState$tryCreateSuperPlayer$1.label = i16 - Integer.MIN_VALUE;
                obj = initState$tryCreateSuperPlayer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = initState$tryCreateSuperPlayer$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        playerConfig = (PlayerConfig) initState$tryCreateSuperPlayer$1.L$1;
                        initState = (InitState) initState$tryCreateSuperPlayer$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (QQVideoPlaySDKManager.isSDKReady()) {
                        e(playerConfig);
                        return Boxing.boxBoolean(true);
                    }
                    initState$tryCreateSuperPlayer$1.L$0 = this;
                    initState$tryCreateSuperPlayer$1.L$1 = playerConfig;
                    initState$tryCreateSuperPlayer$1.label = 1;
                    obj = f(initState$tryCreateSuperPlayer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initState = this;
                }
                if (!((Boolean) obj).booleanValue()) {
                    initState.e(playerConfig);
                    return Boxing.boxBoolean(true);
                }
                AegisLogger.INSTANCE.w("QQLive_Player|State|InitState", "tryCreateSuperPlayer", "roomId=" + initState.context.l() + ", init video sdk failed");
                return Boxing.boxBoolean(false);
            }
        }
        initState$tryCreateSuperPlayer$1 = new InitState$tryCreateSuperPlayer$1(this, continuation);
        obj = initState$tryCreateSuperPlayer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = initState$tryCreateSuperPlayer$1.label;
        if (i3 == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0061  */
    @Override // com.tencent.mobileqq.qqlive.sail.player.state.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull Continuation<? super Unit> continuation) {
        InitState$run$1 initState$run$1;
        Object coroutine_suspended;
        int i3;
        InitState initState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) continuation);
        }
        if (continuation instanceof InitState$run$1) {
            initState$run$1 = (InitState$run$1) continuation;
            int i16 = initState$run$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                initState$run$1.label = i16 - Integer.MIN_VALUE;
                Object obj = initState$run$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = initState$run$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        initState = (InitState) initState$run$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                            initState.context.q(new d(-10000009L, com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE.d(-10000009L), 0, 0, 12, null));
                            LiveVideoContext liveVideoContext = initState.context;
                            initState$run$1.L$0 = null;
                            initState$run$1.label = 3;
                            if (liveVideoContext.a(initState$run$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        LiveVideoContext liveVideoContext2 = initState.context;
                        initState$run$1.L$0 = null;
                        initState$run$1.label = 4;
                        if (liveVideoContext2.a(initState$run$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (companion.isColorLevel()) {
                    companion.i("QQLive_Player|State|InitState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", operate=" + this.context.g());
                }
                PlayerConfig i17 = this.context.i();
                if (i17 == null) {
                    this.context.q(new d(-10000011L, com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE.d(-10000011L), 0, 0, 12, null));
                    LiveVideoContext liveVideoContext3 = this.context;
                    initState$run$1.label = 1;
                    if (liveVideoContext3.a(initState$run$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                initState$run$1.L$0 = this;
                initState$run$1.label = 2;
                obj = g(i17, initState$run$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                initState = this;
                if (((Boolean) obj).booleanValue()) {
                }
            }
        }
        initState$run$1 = new InitState$run$1(this, continuation);
        Object obj2 = initState$run$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = initState$run$1.label;
        if (i3 == 0) {
        }
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
            companion.i("QQLive_Player|State|InitState", "advance", "roomId=" + this.context.l() + ", operate=" + this.context.g());
        }
        if (this.context.e() != null) {
            long l16 = this.context.l();
            d e16 = this.context.e();
            String str = null;
            if (e16 != null) {
                l3 = Boxing.boxLong(e16.a());
            } else {
                l3 = null;
            }
            d e17 = this.context.e();
            if (e17 != null) {
                str = e17.b();
            }
            companion.e("QQLive_Player|State|InitState", "advance", "roomId=" + l16 + ", errCode=" + l3 + ", errMsg=" + str);
            return new a(this.context);
        }
        switch (b.f272340a[this.context.g().ordinal()]) {
            case 1:
                return new e(this.context);
            case 2:
                return new ResetState(this.context);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return new PrepareState(this.context);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
