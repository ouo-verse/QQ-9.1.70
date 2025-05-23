package com.tencent.aio.frame.drawer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0003\r\u0013\u0012B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aio/frame/drawer/DrawerFrameManager;", "", "Lkotlinx/coroutines/flow/Flow;", "d", "Lcom/tencent/aio/frame/api/c;", "drawerFrameProvider", "Landroid/view/View;", "chatFrame", "Lcom/tencent/aio/frame/drawer/DrawerFrameViewGroup;", "containerView", "", "c", "Lcom/tencent/aio/api/frame/a;", "a", "Lcom/tencent/aio/api/frame/a;", "framesConfig", "<init>", "(Lcom/tencent/aio/api/frame/a;)V", "b", "DrawerChildFrameLazy", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class DrawerFrameManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.api.frame.a framesConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/frame/drawer/DrawerFrameManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.frame.drawer.DrawerFrameManager$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aio/frame/drawer/DrawerFrameManager$b;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface b {
        @Nullable
        View createView(@NotNull Context context);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/frame/drawer/DrawerFrameManager$c", "Lcom/tencent/aio/frame/drawer/DrawerFrameManager$b;", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class c implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.frame.api.c f69275a;

        c(com.tencent.aio.frame.api.c cVar) {
            this.f69275a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            }
        }

        @Override // com.tencent.aio.frame.drawer.DrawerFrameManager.b
        @Nullable
        public View createView(@NotNull Context context) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (View) iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
            if (!aVar.g()) {
                view = this.f69275a.j();
            } else {
                aVar.b("getRightFrame");
                String str = "AIO#getRightFrame";
                if (!aVar.h()) {
                    view = this.f69275a.j();
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    View j3 = this.f69275a.j();
                    Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                    view = j3;
                }
                aVar.e();
            }
            if (!aVar.g()) {
                this.f69275a.k();
            } else {
                aVar.b("rightFrameCreate");
                String str2 = "AIO#rightFrameCreate";
                if (!aVar.h()) {
                    this.f69275a.k();
                    Unit unit = Unit.INSTANCE;
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    this.f69275a.k();
                    Unit unit2 = Unit.INSTANCE;
                    Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis2));
                }
                aVar.e();
            }
            return view;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10456);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DrawerFrameManager(@NotNull com.tencent.aio.api.frame.a framesConfig) {
        Intrinsics.checkNotNullParameter(framesConfig, "framesConfig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) framesConfig);
        } else {
            this.framesConfig = framesConfig;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Object> d() {
        return FlowKt.callbackFlow(new DrawerFrameManager$buildIdleFlow$1(null));
    }

    public final void c(@NotNull com.tencent.aio.frame.api.c drawerFrameProvider, @NotNull View chatFrame, @NotNull DrawerFrameViewGroup containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, drawerFrameProvider, chatFrame, containerView);
            return;
        }
        Intrinsics.checkNotNullParameter(drawerFrameProvider, "drawerFrameProvider");
        Intrinsics.checkNotNullParameter(chatFrame, "chatFrame");
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Context context = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        containerView.d(new DrawerChildFrame(chatFrame, context));
        Context context2 = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "containerView.context");
        containerView.e(new DrawerChildFrameLazy(this, context2, new c(drawerFrameProvider), null, 4, null));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0019\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/aio/frame/drawer/DrawerFrameManager$DrawerChildFrameLazy;", "Lcom/tencent/aio/frame/drawer/DrawerChildFrame;", "", "source", "", "j", "g", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "k", "()Lkotlinx/coroutines/Job;", "setBuildJob", "(Lkotlinx/coroutines/Job;)V", "buildJob", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "l", "()J", "setLazyStartTime", "(J)V", "lazyStartTime", "", BdhLogUtil.LogTag.Tag_Conn, "I", "limitCreateTime", "Lcom/tencent/aio/frame/drawer/DrawerFrameManager$b;", "D", "Lcom/tencent/aio/frame/drawer/DrawerFrameManager$b;", "viewCreator", "Landroid/view/View;", "E", "Landroid/view/View;", "getHostView", "()Landroid/view/View;", "hostView", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/aio/frame/drawer/DrawerFrameManager;Landroid/content/Context;Lcom/tencent/aio/frame/drawer/DrawerFrameManager$b;Landroid/view/View;)V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public final class DrawerChildFrameLazy extends DrawerChildFrame {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private final int limitCreateTime;

        /* renamed from: D, reason: from kotlin metadata */
        private final b viewCreator;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final View hostView;
        final /* synthetic */ DrawerFrameManager F;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Job buildJob;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private long lazyStartTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
        @DebugMetadata(c = "com.tencent.aio.frame.drawer.DrawerFrameManager$DrawerChildFrameLazy$1", f = "DrawerFrameManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.aio.frame.drawer.DrawerFrameManager$DrawerChildFrameLazy$1, reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            static IPatchRedirector $redirector_;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
            @DebugMetadata(c = "com.tencent.aio.frame.drawer.DrawerFrameManager$DrawerChildFrameLazy$1$1", f = "DrawerFrameManager.kt", i = {0}, l = {73}, m = "invokeSuspend", n = {"delayCreateTime"}, s = {"J$0"})
            /* renamed from: com.tencent.aio.frame.drawer.DrawerFrameManager$DrawerChildFrameLazy$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C06291 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ CoroutineScope $this_launch;
                long J$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C06291(CoroutineScope coroutineScope, Continuation continuation) {
                    super(2, continuation);
                    this.$this_launch = coroutineScope;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, AnonymousClass1.this, coroutineScope, continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
                    }
                    Intrinsics.checkNotNullParameter(completion, "completion");
                    return new C06291(this.$this_launch, completion);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return iPatchRedirector.redirect((short) 4, (Object) this, obj, (Object) continuation);
                    }
                    return ((C06291) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x00a1  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    long j3;
                    Job k3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                j3 = this.J$0;
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            long currentTimeMillis = System.currentTimeMillis() - DrawerChildFrameLazy.this.l();
                            ct.a.a(this.$this_launch, "DrawerFrameManager", "ideDuration " + currentTimeMillis);
                            if (currentTimeMillis < DrawerChildFrameLazy.this.limitCreateTime) {
                                j3 = DrawerChildFrameLazy.this.limitCreateTime - currentTimeMillis;
                                this.J$0 = j3;
                                this.label = 1;
                                if (DelayKt.delay(j3, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            DrawerChildFrameLazy.this.j("ide");
                            k3 = DrawerChildFrameLazy.this.k();
                            if (k3 != null) {
                                Job.DefaultImpls.cancel$default(k3, (CancellationException) null, 1, (Object) null);
                            }
                            return Unit.INSTANCE;
                        }
                        ct.a.a(this.$this_launch, "DrawerFrameManager", "delayCreateTime " + j3);
                        DrawerChildFrameLazy.this.j("ide");
                        k3 = DrawerChildFrameLazy.this.k();
                        if (k3 != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    return iPatchRedirector.redirect((short) 1, (Object) this, obj);
                }
            }

            AnonymousClass1(Continuation continuation) {
                super(2, continuation);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) DrawerChildFrameLazy.this, (Object) continuation);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
                }
                Intrinsics.checkNotNullParameter(completion, "completion");
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        DrawerChildFrameLazy.this.setLazyStartTime(System.currentTimeMillis());
                        FlowKt.launchIn(FlowKt.onEach(DrawerChildFrameLazy.this.F.d(), new C06291(coroutineScope, null)), coroutineScope);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return iPatchRedirector.redirect((short) 1, (Object) this, obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DrawerChildFrameLazy(@NotNull DrawerFrameManager drawerFrameManager, @NotNull Context context, @Nullable b viewCreator, View view) {
            super(view, context);
            Job launch$default;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
            this.F = drawerFrameManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, drawerFrameManager, context, viewCreator, view);
                return;
            }
            this.viewCreator = viewCreator;
            this.hostView = view;
            this.limitCreateTime = 250;
            launch$default = BuildersKt__Builders_commonKt.launch$default(drawerFrameManager.framesConfig.c(), null, null, new AnonymousClass1(null), 3, null);
            this.buildJob = launch$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(String source) {
            if (getChildCount() == 0) {
                Job job = this.buildJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                b bVar = this.viewCreator;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                View createView = bVar.createView(context);
                if (createView != null) {
                    addView(createView);
                    ct.a.a(this, "DrawerFrameManager", source + " build Content  at " + System.currentTimeMillis());
                }
            }
        }

        @Override // com.tencent.aio.frame.drawer.DrawerChildFrame
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                j("frameVisible");
                super.g();
            }
        }

        @Nullable
        public final Job k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (Job) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.buildJob;
        }

        public final long l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.lazyStartTime;
        }

        public final void setBuildJob(@Nullable Job job) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) job);
            } else {
                this.buildJob = job;
            }
        }

        public final void setLazyStartTime(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            } else {
                this.lazyStartTime = j3;
            }
        }

        public /* synthetic */ DrawerChildFrameLazy(DrawerFrameManager drawerFrameManager, Context context, b bVar, View view, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(drawerFrameManager, context, bVar, (i3 & 4) != 0 ? null : view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, this, drawerFrameManager, context, bVar, view, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }
}
