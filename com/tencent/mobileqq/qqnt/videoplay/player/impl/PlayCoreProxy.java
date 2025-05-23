package com.tencent.mobileqq.qqnt.videoplay.player.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.param.c;
import com.tencent.mobileqq.qqnt.videoplay.api.param.f;
import com.tencent.mobileqq.qqnt.videoplay.player.PlayState;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 42\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u00100\u001a\u00020\"\u0012\u0006\u00101\u001a\u00020&\u00a2\u0006\u0004\b2\u00103J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/PlayCoreProxy;", "Lcom/tencent/mobileqq/qqnt/videoplay/player/a;", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "getVideoView", "", "getVideoDurationMs", "getCurrentPositionMs", "Lcom/tencent/mobileqq/qqnt/videoplay/player/PlayState;", "getPlayState", "", "time", "", "seekTo", "startPlay", "resumePlay", QZoneJsConstants.METHOD_RECORDER_PAUSE_PLAY, "", "needRecordPosition", QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, "newState", "d", "(Lcom/tencent/mobileqq/qqnt/videoplay/player/PlayState;)V", "e", "()V", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "playParam", "a", "isMute", "setMute", "Lcom/tencent/mobileqq/qqnt/videoplay/player/PlayState;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "b", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "mVideoParam", "Lcom/tencent/mobileqq/qqnt/videoplay/player/b;", "c", "Lcom/tencent/mobileqq/qqnt/videoplay/player/b;", "mCallback", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "mCoroutineScope", "Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/b;", "Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/b;", "playProxyDelegate", "Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/a;", "f", "Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/a;", "mPlayerCore", "callback", "coroutineScope", "<init>", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;Lcom/tencent/mobileqq/qqnt/videoplay/player/b;Lkotlinx/coroutines/CoroutineScope;)V", "g", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PlayCoreProxy implements com.tencent.mobileqq.qqnt.videoplay.player.a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile PlayState playState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c mVideoParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqnt.videoplay.player.b mCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope mCoroutineScope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b playProxyDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a mPlayerCore;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.qqnt.videoplay.player.impl.PlayCoreProxy$1", f = "PlayCoreProxy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.player.impl.PlayCoreProxy$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PlayCoreProxy.this, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        com.tencent.mobileqq.qqnt.videoplay.player.sdk.b bVar = com.tencent.mobileqq.qqnt.videoplay.player.sdk.b.f274236a;
                        BaseApplication context = BaseApplication.context;
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        com.tencent.mobileqq.qqnt.videoplay.player.sdk.b.f(bVar, context, null, 2, null);
                    } catch (Exception e16) {
                        QLog.e("VideoPlay_PlayCoreProxy", 1, "InitSdk err", e16);
                    }
                    PlayCoreProxy.this.d(PlayState.STATE_SDK_INITED);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/PlayCoreProxy$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.player.impl.PlayCoreProxy$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlayCoreProxy(@NotNull c playParam, @NotNull com.tencent.mobileqq.qqnt.videoplay.player.b callback, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(playParam, "playParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, playParam, callback, coroutineScope);
            return;
        }
        this.playState = PlayState.STATE_IDLE;
        this.mVideoParam = playParam;
        this.mCallback = callback;
        this.mCoroutineScope = coroutineScope;
        this.playProxyDelegate = new b(this, callback);
        this.mPlayerCore = new a(playParam, this.playProxyDelegate);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public void a(@NotNull c playParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) playParam);
            return;
        }
        Intrinsics.checkNotNullParameter(playParam, "playParam");
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_PlayCoreProxy", 1, "setVideoParam, path=" + playParam.e());
        }
        stopPlay(false);
        this.mVideoParam = playParam;
        this.mPlayerCore.k(playParam);
    }

    public final void d(@NotNull PlayState newState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) newState);
            return;
        }
        Intrinsics.checkNotNullParameter(newState, "newState");
        if (newState == this.playState) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_PlayCoreProxy", 2, "changeState, old:" + this.playState + ", current:" + newState);
        }
        this.playState = newState;
        BuildersKt__Builders_commonKt.launch$default(this.mCoroutineScope, Dispatchers.getMain(), null, new PlayCoreProxy$changeState$1(this, null), 2, null);
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (this.playState.isPreparing() && this.mVideoParam.a().a()) {
            this.mPlayerCore.l();
            d(PlayState.STATE_PLAYING);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public long getCurrentPositionMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mPlayerCore.c();
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    @NotNull
    public PlayState getPlayState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (PlayState) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.playState;
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public long getVideoDurationMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.mPlayerCore.d();
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    @Nullable
    public ISPlayerVideoView getVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ISPlayerVideoView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mPlayerCore.e();
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public boolean isMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.mPlayerCore.f();
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public void pausePlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.playState.isPlayStarted()) {
            this.mPlayerCore.h();
            d(PlayState.STATE_PAUSE);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public void resumePlay() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        boolean z17 = false;
        if (!this.playState.isPaused() && !this.playState.isPlayCompleted()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.playState.isPreparing() && !this.mVideoParam.a().a()) {
            z17 = true;
        }
        if (z16 || z17) {
            this.mPlayerCore.l();
            d(PlayState.STATE_PLAYING);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public void seekTo(int time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, time);
        } else {
            this.mPlayerCore.i(time);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public void setMute(boolean isMute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, isMute);
        } else {
            this.mPlayerCore.j(isMute);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public void startPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.playState.isSDKInited() || this.playState.isReleased()) {
            QLog.i("VideoPlay_PlayCoreProxy", 1, "[startPlay], proxy: " + this + ", playerCore: " + this.mPlayerCore + ", playParam: " + this.mVideoParam.e());
            this.mPlayerCore.b();
            f i3 = this.mVideoParam.i();
            if (i3 != null) {
                i3.createPlayer();
            }
            if (this.mPlayerCore.g()) {
                d(PlayState.STATE_PREPARING);
                return;
            }
            QLog.i("VideoPlay_PlayCoreProxy", 1, "[startPlay] openPlayer FAILED. proxy: " + this + ", playerCore: " + this.mPlayerCore);
        }
    }

    @Override // com.tencent.mobileqq.qqnt.videoplay.player.a
    public void stopPlay(boolean needRecordPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, needRecordPosition);
            return;
        }
        QLog.i("VideoPlay_PlayCoreProxy", 2, "[stopPlay], proxy: " + this + ", playerCore: " + this.mPlayerCore + ", playParam: " + this.mVideoParam.e());
        boolean isPlayError = this.playState.isPlayError();
        d(PlayState.STATE_RELEASED);
        if (this.playState.isReleased()) {
            if (needRecordPosition) {
                this.mVideoParam.a().j(getCurrentPositionMs());
            }
            this.mPlayerCore.m(isPlayError);
        }
    }
}
