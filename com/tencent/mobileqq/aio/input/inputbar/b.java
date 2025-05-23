package com.tencent.mobileqq.aio.input.inputbar;

import android.view.View;
import android.widget.EditText;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.AIOInputMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.g;
import com.tencent.mobileqq.aio.input.inputbar.vbcmd.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.api.ability.e;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0003\u0018\u001c \b\u0007\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001)B\u0013\u0012\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/b;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mvi/base/route/g;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "I", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "intent", "handleIntent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/aio/input/inputbar/b$c", "e", "Lcom/tencent/mobileqq/aio/input/inputbar/b$c;", "mDelegateHost", "com/tencent/mobileqq/aio/input/inputbar/b$d", "f", "Lcom/tencent/mobileqq/aio/input/inputbar/b$d;", "mDelegateMediator", "com/tencent/mobileqq/aio/input/inputbar/b$b", h.F, "Lcom/tencent/mobileqq/aio/input/inputbar/b$b;", "mActionR", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "adornApi", "<init>", "(Lcom/tencent/mobileqq/aio/input/adorn/a;)V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends com.tencent.qqnt.aio.baseVM.a<at.a, InputUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mDelegateHost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mDelegateMediator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7271b mActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.inputbar.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/inputbar/b$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.inputbar.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7271b implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        C7271b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return b.this.I(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/aio/input/inputbar/b$c", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lkotlinx/coroutines/CoroutineScope;", "vmScope", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "state", "", "a", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Lcom/tencent/mvi/api/ability/e;", "fetchVBState", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mobileqq.aio.input.adorn.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(@NotNull InputUIState state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) state);
            } else {
                Intrinsics.checkNotNullParameter(state, "state");
                b.this.updateUI(state);
            }
        }

        @Override // com.tencent.mvi.api.ability.b
        @NotNull
        public e fetchVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (e) iPatchRedirector.redirect((short) 4, (Object) this, (Object) stateCmd);
            }
            Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
            return b.this.fetchVBState(stateCmd);
        }

        @Override // ll3.a
        @NotNull
        public CoroutineScope vmScope() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CoroutineScope) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return b.this.vmScope();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006J2\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\tj\u0002`\n0\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/aio/input/inputbar/b$d", "Lcom/tencent/input/base/mvicompat/h;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/inputbar/InputVMDelegateMediator;", "host", "", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends com.tencent.input.base.mvicompat.h<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.input.adorn.a<?> f189703h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.tencent.mobileqq.aio.input.adorn.a<?> aVar, c cVar) {
            super(cVar);
            this.f189703h = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) cVar);
            }
        }

        @Override // com.tencent.input.base.mvicompat.DelegateMediator
        @NotNull
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> i(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            return this.f189703h.c(host);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull com.tencent.mobileqq.aio.input.adorn.a<?> adornApi) {
        Intrinsics.checkNotNullParameter(adornApi, "adornApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) adornApi);
            return;
        }
        c cVar = new c();
        this.mDelegateHost = cVar;
        this.mDelegateMediator = new d(adornApi, cVar);
        this.mActionR = new C7271b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent msgIntent) {
        if (msgIntent instanceof InputEvent.GetInputBarHeight) {
            return n();
        }
        if (msgIntent instanceof InputEvent.GetEditText) {
            return m();
        }
        if (msgIntent instanceof AIOInputMsgIntent.GetGeometryReaderIntent) {
            return p();
        }
        if (msgIntent instanceof AIOInputMsgIntent.GetInputDialogAnchor) {
            return o();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final k m() {
        a.C7273a c7273a = new a.C7273a(null, 1, null);
        fetchVBState(c7273a);
        EditText a16 = c7273a.a();
        if (a16 != null) {
            return new d.a(a16);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final k n() {
        return new d.c(fetchVBState(a.b.f189729a).b().getInt("input_height", 0));
    }

    private final k o() {
        a.c cVar = new a.c(null, 1, null);
        fetchVBState(cVar);
        View a16 = cVar.a();
        if (a16 != null) {
            return new d.e(a16);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final k p() {
        a.C7273a c7273a = new a.C7273a(null, 1, null);
        fetchVBState(c7273a);
        EditText a16 = c7273a.a();
        if (a16 != null) {
            return new d.b(new g(a16));
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.GetEditText");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.GetInputBarHeight");
        hashSet.add("com.tencent.mobileqq.aio.input.AIOInputMsgIntent.GetGeometryReaderIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.AIOInputMsgIntent.GetInputDialogAnchor");
        return hashSet;
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
        q();
        this.mDelegateMediator.b(context, reuse);
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mDelegateMediator.onDestroy();
            r();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.mDelegateMediator.f(intent);
        }
    }
}
