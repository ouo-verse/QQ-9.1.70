package com.tencent.mobileqq.springhb.interactive.helper;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.api.runtime.emitter.a;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import com.tencent.mobileqq.springhb.interactive.config.c;
import com.tencent.mobileqq.springhb.interactive.ui.InteractivePopManager;
import com.tencent.mobileqq.springhb.interactive.ui.e;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.d;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rr1.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b*\u0001B\b\u0000\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u000f\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010\u0014\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0010*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u00160\u0010H\u0002J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u00160\u0010*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0010*\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u0010*\b\u0012\u0004\u0012\u00020\f0\u0010H\u0003J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u001eH\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020*H\u0016R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0004\u0018\u00010:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/helper/GuildInteractiveAnimationHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mobileqq/springhb/interactive/ui/e;", "", "t", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "p", "Lrr1/i;", "notifyData", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "msg", "v", "Landroid/app/Activity;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/msg/d;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/springhb/entry/model/DragonCardConfigData;", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", DomainData.DOMAIN_NAME, "r", "u", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "interestedIn", "state", "onMoveToState", "", "onBackEvent", "a", "Lcom/tencent/mobileqq/springhb/interactive/api/b;", "d", "Lcom/tencent/mobileqq/springhb/interactive/api/b;", "provider", "Ljava/lang/ref/WeakReference;", "e", "Ljava/lang/ref/WeakReference;", "weakActivity", "f", "Lcom/tencent/aio/api/runtime/a;", h.F, "I", "lifeState", "Lcom/tencent/mobileqq/springhb/interactive/api/a;", "Lcom/tencent/mobileqq/springhb/interactive/api/a;", "frequencyController", "Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager;", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager;", "popManager", "com/tencent/mobileqq/springhb/interactive/helper/GuildInteractiveAnimationHelper$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/springhb/interactive/helper/GuildInteractiveAnimationHelper$b;", "action", "<init>", "(Lcom/tencent/mobileqq/springhb/interactive/api/b;)V", "D", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class GuildInteractiveAnimationHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.aio.api.runtime.emitter.a, e {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a D;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.interactive.api.b provider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Activity> weakActivity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lifeState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.springhb.interactive.api.a frequencyController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/helper/GuildInteractiveAnimationHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/springhb/interactive/helper/GuildInteractiveAnimationHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GuildInteractiveAnimationHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                GuildInteractiveAnimationHelper.this.p(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            D = new a(null);
        }
    }

    public GuildInteractiveAnimationHelper(@NotNull com.tencent.mobileqq.springhb.interactive.api.b provider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(provider, "provider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) provider);
            return;
        }
        this.provider = provider;
        this.lifeState = -2147483647;
        this.frequencyController = provider.d();
        lazy = LazyKt__LazyJVMKt.lazy(GuildInteractiveAnimationHelper$popManager$2.INSTANCE);
        this.popManager = lazy;
        this.action = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity i() {
        boolean z16;
        WeakReference<Activity> weakReference = this.weakActivity;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weakActivity");
            weakReference = null;
        }
        Activity activity = weakReference.get();
        boolean z17 = true;
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (activity == null || !activity.isDestroyed()) {
                z17 = false;
            }
            if (!z17) {
                return activity;
            }
        }
        return null;
    }

    private final Flow<d> j(Flow<? extends d> flow, com.tencent.aio.api.runtime.a aVar) {
        return FlowKt.flow(new GuildInteractiveAnimationHelper$filterAIOMsg$$inlined$transform$1(flow, null, this, aVar));
    }

    private final Flow<d> k(Flow<? extends d> flow) {
        return FlowKt.flow(new GuildInteractiveAnimationHelper$filterPrefix$$inlined$transform$1(flow, null, this));
    }

    private final Flow<d> m(Flow<? extends d> flow) {
        return FlowKt.flow(new GuildInteractiveAnimationHelper$filterTextMsg$$inlined$transform$1(flow, null, this));
    }

    private final Flow<Pair<d, DragonCardConfigData>> n(Flow<? extends d> flow) {
        return FlowKt.flow(new GuildInteractiveAnimationHelper$filterTimeEffective$$inlined$transform$1(flow, null));
    }

    private final InteractivePopManager o() {
        return (InteractivePopManager) this.popManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(MsgIntent i3) {
        if (i3 instanceof MFGestureListIntent.NotifyEvent) {
            s(((MFGestureListIntent.NotifyEvent) i3).getNotifyData());
        }
    }

    private final void q(Flow<? extends d> flow, com.tencent.aio.api.runtime.a aVar) {
        LifecycleOwner it = aVar.d();
        Flow flowOn = FlowKt.flowOn(u(FlowKt.flowOn(r(w(n(m(j(k(flow), aVar))))), Dispatchers.getDefault())), Dispatchers.getMain());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        FlowKt.launchIn(flowOn, LifecycleOwnerKt.getLifecycleScope(it));
    }

    private final Flow<InteractiveRecord> r(Flow<? extends InteractiveRecord> flow) {
        return FlowKt.flow(new GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1(flow, null));
    }

    private final void s(i notifyData) {
        if (notifyData.h()) {
            o().o("aioBeginMove");
        }
    }

    private final void t() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.d();
        Flow<d> b16 = this.provider.b();
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar3 = null;
        }
        q(b16, aVar3);
        Flow<d> f16 = this.provider.f();
        com.tencent.aio.api.runtime.a aVar4 = this.aioContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar4;
        }
        q(f16, aVar2);
    }

    @MainThread
    private final Flow<InteractiveRecord> u(Flow<? extends InteractiveRecord> flow) {
        return FlowKt.flow(new GuildInteractiveAnimationHelper$showPop$$inlined$transform$1(flow, null, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(InteractiveRecord msg2) {
        if (((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isLoadingShowing()) {
            QLog.i("GuildInteractiveAnimationHelper", 1, "webLoading !!");
            return;
        }
        if (!a()) {
            QLog.i("GuildInteractiveAnimationHelper", 1, "helper not active ");
            return;
        }
        QLog.i("GuildInteractiveAnimationHelper", 1, "showPop ");
        if (o().m()) {
            QLog.i("GuildInteractiveAnimationHelper", 1, "popManager isShow ");
            return;
        }
        com.tencent.mobileqq.springhb.interactive.api.a aVar = this.frequencyController;
        if (aVar != null && !aVar.a(msg2)) {
            QLog.i("GuildInteractiveAnimationHelper", 1, "frequency limit!! ");
            return;
        }
        if (i() != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar2 = null;
            }
            Fragment fragment = aVar2.c();
            final c a16 = c.INSTANCE.a(msg2);
            if (a16 != null) {
                com.tencent.mobileqq.springhb.interactive.api.a aVar3 = this.frequencyController;
                if (aVar3 != null) {
                    aVar3.b(msg2);
                }
                InteractivePopManager o16 = o();
                Intrinsics.checkNotNullExpressionValue(fragment, "fragment");
                o16.t(fragment, a16, this, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper$showPop$1$1$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GuildInteractiveAnimationHelper this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                    @DebugMetadata(c = "com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper$showPop$1$1$1$1$1", f = "GuildInteractiveAnimationHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper$showPop$1$1$1$1$1, reason: invalid class name */
                    /* loaded from: classes18.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        static IPatchRedirector $redirector_;
                        int label;
                        final /* synthetic */ GuildInteractiveAnimationHelper this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(GuildInteractiveAnimationHelper guildInteractiveAnimationHelper, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = guildInteractiveAnimationHelper;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) guildInteractiveAnimationHelper, (Object) continuation);
                            }
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                            }
                            return new AnonymousClass1(this.this$0, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    if (this.this$0.a()) {
                                        this.this$0.i();
                                        return Unit.INSTANCE;
                                    }
                                    QLog.i("GuildInteractiveAnimationHelper", 1, "noActive jumpReturn");
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

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        com.tencent.aio.api.runtime.a aVar4;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (c.this.getType() == 1) {
                            return;
                        }
                        aVar4 = this.this$0.aioContext;
                        if (aVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                            aVar4 = null;
                        }
                        LifecycleOwner d16 = aVar4.d();
                        Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), null, null, new AnonymousClass1(this.this$0, null), 3, null);
                    }
                });
            }
        }
    }

    private final Flow<InteractiveRecord> w(Flow<? extends Pair<? extends d, ? extends DragonCardConfigData>> flow) {
        return FlowKt.flow(new GuildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1(flow, null, this));
    }

    @Override // com.tencent.mobileqq.springhb.interactive.ui.e
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        int i3 = this.lifeState;
        if (i3 < 0 || i3 >= 8) {
            return false;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        if (!com.tencent.guild.aio.util.ex.a.g(aVar)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 32;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "GuildInteractiveAnimationHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{0, 3, 4, 12, 8, 9};
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (o().m()) {
            o().o("onBackEvent");
        }
        return a.C0623a.a(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.aioContext = param.a();
        this.weakActivity = new WeakReference<>(param.a().c().requireActivity());
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        ml3.a a16 = aVar.b().a(com.tencent.aio.api.runtime.emitter.a.class);
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar3 = null;
        }
        LifecycleOwner d16 = aVar3.d();
        Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
        a16.b(this, d16);
        t();
        com.tencent.aio.api.runtime.a aVar4 = this.aioContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar4;
        }
        aVar2.e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
            return;
        }
        this.lifeState = state;
        if (state == 8 || state == 9 || state == 12) {
            o().o("lifeChange" + state);
        }
        if (state == 3) {
            o().o("lifeChange" + state);
        }
    }
}
