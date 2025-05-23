package com.tencent.mobileqq.aio.title;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVM;
import com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent;
import com.tencent.mobileqq.aio.title.AIOTitleContainerUIState;
import com.tencent.mobileqq.aio.title.l;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.api.IAIOContactApi;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0002\u001d!\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R-\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001d0&0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/title/l;", "Lcom/tencent/mobileqq/aio/title/AIOTitleContainerUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/mvi/base/route/k;", "I", "", "height", "", "location", ReportConstant.COSTREPORT_PREFIX, "", "isShotMode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "r", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "p", "e", "[I", "titleLocation", "com/tencent/mobileqq/aio/title/AIODefaultTitleContainerVM$a", "f", "Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVM$a;", "mAction", "com/tencent/mobileqq/aio/title/AIODefaultTitleContainerVM$b", tl.h.F, "Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVM$b;", "mActionR", "", "Lkotlin/Pair;", "", "i", "Lkotlin/Lazy;", "getMMessageList", "()Ljava/util/List;", "mMessageList", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class AIODefaultTitleContainerVM extends com.tencent.qqnt.aio.baseVM.a<l, AIOTitleContainerUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] titleLocation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mActionR;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/title/AIODefaultTitleContainerVM$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIODefaultTitleContainerVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIODefaultTitleContainerVM.this.E(i3);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/title/AIODefaultTitleContainerVM$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIODefaultTitleContainerVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            return AIODefaultTitleContainerVM.this.I(intent);
        }
    }

    public AIODefaultTitleContainerVM() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int[] iArr = new int[2];
        for (int i3 = 0; i3 < 2; i3++) {
            iArr[i3] = -1;
        }
        this.titleLocation = iArr;
        this.mAction = new a();
        this.mActionR = new b();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<? extends Pair<? extends String, ? extends a>>>() { // from class: com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVM$mMessageList$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIODefaultTitleContainerVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Pair<? extends String, ? extends AIODefaultTitleContainerVM.a>> invoke() {
                AIODefaultTitleContainerVM.a aVar;
                List<? extends Pair<? extends String, ? extends AIODefaultTitleContainerVM.a>> listOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                String a16 = com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LongShotModeChangeEvent.class));
                aVar = AIODefaultTitleContainerVM.this.mAction;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(a16, aVar));
                return listOf;
            }
        });
        this.mMessageList = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            q(((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent intent) {
        if (intent instanceof AIOTitleContainerMsgIntent.GetTitleLocation) {
            return o();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final com.tencent.mvi.base.route.k o() {
        int[] iArr = new int[2];
        for (int i3 = 0; i3 < 2; i3++) {
            iArr[i3] = 0;
        }
        updateUI(new AIOTitleContainerUIState.GetTitleContainerLocationInWindow(iArr));
        return new m.e(iArr[0], iArr[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(boolean isShotMode) {
        int i3;
        if (isShotMode) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        updateUI(new AIOTitleContainerUIState.SetMsgShotTitleVisibility(i3, ((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).isRobot(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r() {
        return ((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).isRobot(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(int height, int[] location) {
        this.titleLocation = location;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTitleContainerMsgIntent.NotifyTitleHeight(height, location));
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent.GetTitleLocation");
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull l intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof l.a) {
            l.a aVar = (l.a) intent;
            s(aVar.a(), aVar.b());
        } else if (intent instanceof l.b) {
            ((l.b) intent).b(r());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
    }
}
