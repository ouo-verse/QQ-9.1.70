package com.tencent.mobileqq.qqlive.sail.player.state;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.player.LiveVideoContext;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0001H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/ResetState;", "Lcom/tencent/mobileqq/qqlive/sail/player/state/b;", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "d", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "context", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;)V", "e", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ResetState implements com.tencent.mobileqq.qqlive.sail.player.state.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveVideoContext context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/state/ResetState$a;", "", "", "STATE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.player.state.ResetState$a, reason: from kotlin metadata */
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
        public static final /* synthetic */ int[] f272359a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44262);
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
                iArr[LiveVideoContext.PlayerOperate.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.REPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PLAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.STOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LiveVideoContext.PlayerOperate.SWITCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f272359a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ResetState(@NotNull LiveVideoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    @Override // com.tencent.mobileqq.qqlive.sail.player.state.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull Continuation<? super Unit> continuation) {
        ResetState$run$1 resetState$run$1;
        Object coroutine_suspended;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) continuation);
        }
        if (continuation instanceof ResetState$run$1) {
            resetState$run$1 = (ResetState$run$1) continuation;
            int i16 = resetState$run$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                resetState$run$1.label = i16 - Integer.MIN_VALUE;
                Object obj = resetState$run$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = resetState$run$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    if (companion.isColorLevel()) {
                        companion.i("QQLive_Player|State|ResetState", TencentLocation.RUN_MODE, "roomId=" + this.context.l() + ", operate=" + this.context.g());
                    }
                    LiveVideoContext liveVideoContext = this.context;
                    ISuperPlayer h16 = liveVideoContext.h();
                    if (h16 != null) {
                        h16.stop();
                        h16.reset();
                        h16.setXYaxis(liveVideoContext.o().getValue());
                        h16.updatePlayerVideoView(liveVideoContext.j());
                    }
                    liveVideoContext.z(false);
                    liveVideoContext.q(null);
                    liveVideoContext.z(false);
                    resetState$run$1.L$0 = liveVideoContext;
                    resetState$run$1.label = 1;
                    if (liveVideoContext.a(resetState$run$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        resetState$run$1 = new ResetState$run$1(this, continuation);
        Object obj2 = resetState$run$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = resetState$run$1.label;
        if (i3 == 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.player.state.b
    @Nullable
    public Object b(@NotNull Continuation<? super com.tencent.mobileqq.qqlive.sail.player.state.b> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) continuation);
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("QQLive_Player|State|ResetState", "advance", "roomId=" + this.context.l() + ", operate=" + this.context.g());
        }
        switch (b.f272359a[this.context.g().ordinal()]) {
            case 1:
                return new e(this.context);
            case 2:
                return new InitState(this.context);
            case 3:
            case 4:
                this.context.z(true);
                return new InitState(this.context);
            case 5:
            case 6:
            case 7:
                return new c(this.context);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
