package com.tencent.aio.part.root.panel.mvx.vm;

import com.tencent.aio.base.route.msg.InputMsg$ShowKeyboardMsg;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.aio.part.root.panel.mvx.intent.a;
import com.tencent.aio.part.root.panel.mvx.result.a;
import com.tencent.aio.part.root.panel.mvx.state.DemoPanelState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0003 $'\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/vm/a;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/aio/part/root/panel/mvx/intent/a;", "Lcom/tencent/aio/part/root/panel/mvx/state/DemoPanelState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "o", "Lcom/tencent/mvi/base/route/k;", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "intent", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/data/AIOParam;", "d", "Lcom/tencent/aio/data/AIOParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/aio/data/AIOParam;", "setAioParam", "(Lcom/tencent/aio/data/AIOParam;)V", "aioParam", "", "e", "Ljava/lang/Integer;", "curPanelId", "", "f", "Ljava/lang/Boolean;", "isShowKeyboard", "com/tencent/aio/part/root/panel/mvx/vm/a$b", h.F, "Lcom/tencent/aio/part/root/panel/mvx/vm/a$b;", "mAction1", "com/tencent/aio/part/root/panel/mvx/vm/a$a", "Lcom/tencent/aio/part/root/panel/mvx/vm/a$a;", "actionR", "com/tencent/aio/part/root/panel/mvx/vm/a$c", "Lcom/tencent/aio/part/root/panel/mvx/vm/a$c;", "multiWindowModeChangedCallback", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends com.tencent.aio.base.mvvm.b<com.tencent.aio.part.root.panel.mvx.intent.a, DemoPanelState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public AIOParam aioParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Integer curPanelId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Boolean isShowKeyboard;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b mAction1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final C0654a actionR;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final c multiWindowModeChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/part/root/panel/mvx/vm/a$a", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.mvx.vm.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0654a implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        C0654a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (k) iPatchRedirector.redirect((short) 1, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return a.this.p(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/part/root/panel/mvx/vm/a$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                a.this.o(i3);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/part/root/panel/mvx/vm/a$c", "Lcom/tencent/aio/api/runtime/emitter/c;", "", "isInMultiWindowMode", "", "onMultiWindowModeChanged", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class c implements com.tencent.aio.api.runtime.emitter.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.aio.api.runtime.emitter.c
        public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, isInMultiWindowMode);
            } else {
                a.this.updateUI(new DemoPanelState.MultiWindowModeChangedPanel(isInMultiWindowMode));
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.isShowKeyboard = Boolean.FALSE;
        this.mAction1 = new b();
        this.actionR = new C0654a();
        this.multiWindowModeChangedCallback = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(MsgIntent i3) {
        if (i3 instanceof PanelMsg.ShowPanel) {
            PanelMsg.ShowPanel showPanel = (PanelMsg.ShowPanel) i3;
            updateUI(new DemoPanelState.ShowPanel(showPanel.b(), showPanel.a()));
            return;
        }
        if (i3 instanceof PanelMsg.ShowExpandPanel) {
            PanelMsg.ShowExpandPanel showExpandPanel = (PanelMsg.ShowExpandPanel) i3;
            updateUI(new DemoPanelState.ShowExpandPanel(showExpandPanel.a(), showExpandPanel.b()));
            return;
        }
        if (i3 instanceof PanelMsg.HideAllPanelAndKeyboard) {
            updateUI(new DemoPanelState.HideAllPanelAndKeyboard(((PanelMsg.HideAllPanelAndKeyboard) i3).a()));
            return;
        }
        if (i3 instanceof PanelMsg.ShowKeyboardWhenNone) {
            updateUI(DemoPanelState.ShowKeyboardWhenNone.f69739d);
        } else if (i3 instanceof PanelMsg.ShowKeyboardAnyStatus) {
            updateUI(DemoPanelState.ShowKeyboard.f69738d);
        } else if (i3 instanceof PanelMsg.RollbackExpandPanel) {
            updateUI(new DemoPanelState.RollbackExpandPanel(((PanelMsg.RollbackExpandPanel) i3).a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k p(MsgIntent i3) {
        if (i3 instanceof PanelMsg.IsShowingPanelOrKeyboard) {
            return new a.C0653a(this.curPanelId, this.isShowKeyboard);
        }
        return new a.b();
    }

    @NotNull
    public final AIOParam m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIOParam) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        AIOParam aIOParam = this.aioParam;
        if (aIOParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioParam");
        }
        return aIOParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.aio.part.root.panel.mvx.intent.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C0652a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputMsg$ShowKeyboardMsg());
            return;
        }
        if (intent instanceof a.c) {
            com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("PanelStatusChange, hide: ");
            a.c cVar = (a.c) intent;
            sb5.append(cVar.a());
            sb5.append(", show: ");
            sb5.append(cVar.b());
            aVar.d("PanelContainerVM", sb5.toString());
            if (cVar.b() != null) {
                this.curPanelId = cVar.b();
            } else if (Intrinsics.areEqual(this.curPanelId, cVar.a()) || cVar.a() == null) {
                this.curPanelId = null;
            }
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelStatusIntent.PanelStatusChangeIntent(this.curPanelId, this.isShowKeyboard));
            return;
        }
        if (intent instanceof a.b) {
            com.tencent.aio.base.log.a aVar2 = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("KeyboardStatusChange, keyboard: ");
            a.b bVar = (a.b) intent;
            sb6.append(bVar.a());
            aVar2.d("PanelContainerVM", sb6.toString());
            this.isShowKeyboard = bVar.a();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelStatusIntent.PanelStatusChangeIntent(this.curPanelId, this.isShowKeyboard));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.c.class).c(this.multiWindowModeChangedCallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        this.aioParam = g16;
        context.e().d(Reflection.getOrCreateKotlinClass(PanelMsg.ShowPanel.class).getQualifiedName(), this.mAction1);
        context.e().d(Reflection.getOrCreateKotlinClass(PanelMsg.ShowExpandPanel.class).getQualifiedName(), this.mAction1);
        context.e().d(Reflection.getOrCreateKotlinClass(PanelMsg.RollbackExpandPanel.class).getQualifiedName(), this.mAction1);
        context.e().d(Reflection.getOrCreateKotlinClass(PanelMsg.HideAllPanelAndKeyboard.class).getQualifiedName(), this.mAction1);
        context.e().d(Reflection.getOrCreateKotlinClass(PanelMsg.ShowKeyboardWhenNone.class).getQualifiedName(), this.mAction1);
        context.e().d(Reflection.getOrCreateKotlinClass(PanelMsg.ShowKeyboardAnyStatus.class).getQualifiedName(), this.mAction1);
        context.e().j(Reflection.getOrCreateKotlinClass(PanelMsg.IsShowingPanelOrKeyboard.class).getQualifiedName(), this.actionR);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.c.class).a(this.multiWindowModeChangedCallback);
        AIOParam aIOParam = this.aioParam;
        if (aIOParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioParam");
        }
        if (aIOParam.m() == 1) {
            updateUI(DemoPanelState.ShowKeyboard.f69738d);
        }
    }
}
