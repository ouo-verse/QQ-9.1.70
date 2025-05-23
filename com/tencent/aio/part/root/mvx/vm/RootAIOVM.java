package com.tencent.aio.part.root.mvx.vm;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.api.help.d;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.base.mvvm.b;
import com.tencent.aio.helper.CoreHelperFetcher;
import com.tencent.aio.main.businesshelper.f;
import com.tencent.aio.main.businesshelper.old.HelperOldRegister;
import com.tencent.aio.main.businesshelper.old.OldCoreHelperFetcher;
import com.tencent.aio.main.businesshelper.p000new.HelperRegister;
import com.tencent.aio.monitor.trace.TraceTimeReport;
import com.tencent.aio.part.root.mvx.intent.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/aio/part/root/mvx/vm/RootAIOVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/aio/part/root/mvx/intent/a;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "o", DomainData.DOMAIN_NAME, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/main/businesshelper/f;", "e", "Lkotlin/Lazy;", "l", "()Lcom/tencent/aio/main/businesshelper/f;", "helperRegister", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "<init>", "(Lcom/tencent/aio/api/help/d;)V", "f", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
@AIOCacheMarket(level = 1)
/* loaded from: classes3.dex */
public final class RootAIOVM extends b<com.tencent.aio.part.root.mvx.intent.a, MviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy helperRegister;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/mvx/vm/RootAIOVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.mvx.vm.RootAIOVM$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45536);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RootAIOVM(@Nullable final d dVar) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<f>(dVar) { // from class: com.tencent.aio.part.root.mvx.vm.RootAIOVM$helperRegister$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ d $buildHelperProvider;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$buildHelperProvider = dVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) RootAIOVM.this, (Object) dVar);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final f invoke() {
                    com.tencent.aio.api.runtime.a aVar;
                    boolean c16;
                    com.tencent.aio.api.runtime.a aVar2;
                    boolean d16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return (f) iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                    aVar = RootAIOVM.this.aioContext;
                    c16 = a.c(aVar);
                    com.tencent.aio.base.log.a aVar3 = com.tencent.aio.base.log.a.f69187b;
                    aVar3.d("RootAIOVM", "checkRecycleHelper " + c16);
                    aVar2 = RootAIOVM.this.aioContext;
                    d16 = a.d(aVar2);
                    if (!d16) {
                        aVar3.d("RootAIOVM", "useOldPoster");
                        return new HelperOldRegister(OldCoreHelperFetcher.INSTANCE.a(this.$buildHelperProvider, c16));
                    }
                    aVar3.d("RootAIOVM", "useNewPoster");
                    return new HelperRegister(CoreHelperFetcher.INSTANCE.a(this.$buildHelperProvider));
                }
            });
            this.helperRegister = lazy;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        }
    }

    private final f l() {
        return (f) this.helperRegister.getValue();
    }

    private final void n(com.tencent.aio.api.runtime.a context) {
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("RootAIOVM", "handleLifeHelper");
        }
        l().onCreate(context);
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        d16.getLifecycle().addObserver(l());
        TraceTimeReport.f69439e.e(context);
    }

    private final void o(com.tencent.aio.api.runtime.a context) {
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("RootAIOVM", "delayLoad");
        }
        l().V(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.aio.part.root.mvx.intent.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof a.C0634a) {
            o((com.tencent.aio.api.runtime.a) getMContext());
        }
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("RootAIOVM", "onCreate " + context + " resume " + reuse);
        }
        this.aioContext = context;
        n(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        LifecycleOwner d16 = ((com.tencent.aio.api.runtime.a) getMContext()).d();
        Intrinsics.checkNotNullExpressionValue(d16, "mContext.lifecycleOwner");
        d16.getLifecycle().removeObserver(l());
        l().onDestroy();
        TraceTimeReport.f69439e.g();
        this.aioContext = null;
    }
}
