package com.tencent.input.base.panelcontainer;

import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.f;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.PanelContainerUIState;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.input.base.panelcontainer.i;
import com.tencent.input.base.panelcontainer.k;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002$(\b\u0007\u0018\u0000 \u0015*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0004:\u00012B\u001b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010#\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b0\u00101J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/input/base/panelcontainer/l;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/input/base/core/b;", "Lcom/tencent/input/base/panelcontainer/i;", "Lcom/tencent/input/base/panelcontainer/PanelContainerUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "E", "", "curPanelHeight", "p", "", "isShowOrHidePanel", "panelId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mvi/base/route/k;", "I", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "context", "onCreate", "(Lcom/tencent/mvi/api/runtime/b;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "o", "Lcom/tencent/mvi/log/b;", "d", "Lcom/tencent/mvi/log/b;", "mLogger", "Lpz0/a;", "e", "Lpz0/a;", "mMMKVAdapter", "com/tencent/input/base/panelcontainer/l$b", "f", "Lcom/tencent/input/base/panelcontainer/l$b;", "mAction", "com/tencent/input/base/panelcontainer/l$c", tl.h.F, "Lcom/tencent/input/base/panelcontainer/l$c;", "mActionR", "Lcom/tencent/input/base/panelcontainer/keyboard/f;", "i", "Lcom/tencent/input/base/panelcontainer/keyboard/f;", "mKeyboardVMDelegate", "<init>", "(Lcom/tencent/mvi/log/b;Lpz0/a;)V", "a", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class l<C extends com.tencent.mvi.api.runtime.b> extends com.tencent.input.base.core.b<i, PanelContainerUIState, C> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mvi.log.b mLogger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final pz0.a mMMKVAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mActionR;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.input.base.panelcontainer.keyboard.f<C> mKeyboardVMDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/input/base/panelcontainer/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.input.base.panelcontainer.l$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/input/base/panelcontainer/l$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l<C> f116903d;

        b(l<C> lVar) {
            this.f116903d = lVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lVar);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                this.f116903d.E(i3);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/input/base/panelcontainer/l$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l<C> f116904d;

        c(l<C> lVar) {
            this.f116904d = lVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lVar);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return this.f116904d.I(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33295);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l(@Nullable com.tencent.mvi.log.b bVar, @Nullable pz0.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) aVar);
            return;
        }
        this.mLogger = bVar;
        this.mMMKVAdapter = aVar;
        this.mAction = new b(this);
        this.mActionR = new c(this);
        com.tencent.input.base.panelcontainer.keyboard.f<C> fVar = new com.tencent.input.base.panelcontainer.keyboard.f<>();
        fVar.i(bVar);
        fVar.j(aVar);
        Unit unit = Unit.INSTANCE;
        this.mKeyboardVMDelegate = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent msgIntent) {
        if (msgIntent instanceof PanelContainerMsgIntent.ShowPanelMsgIntent) {
            com.tencent.mvi.log.b bVar = this.mLogger;
            if (bVar != null) {
                bVar.i("PanelContainerVM", Intrinsics.stringPlus("[showPanel]: source=", ((PanelContainerMsgIntent.ShowPanelMsgIntent) msgIntent).d()));
            }
            PanelContainerMsgIntent.ShowPanelMsgIntent showPanelMsgIntent = (PanelContainerMsgIntent.ShowPanelMsgIntent) msgIntent;
            updateUI(new PanelContainerUIState.ShowPanelUIState(showPanelMsgIntent.c(), showPanelMsgIntent.b(), showPanelMsgIntent.a()));
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.HidePanelMsgIntent) {
            com.tencent.mvi.log.b bVar2 = this.mLogger;
            if (bVar2 != null) {
                bVar2.i("PanelContainerVM", Intrinsics.stringPlus("[hidePanel]: source=", ((PanelContainerMsgIntent.HidePanelMsgIntent) msgIntent).c()));
            }
            PanelContainerMsgIntent.HidePanelMsgIntent hidePanelMsgIntent = (PanelContainerMsgIntent.HidePanelMsgIntent) msgIntent;
            updateUI(new PanelContainerUIState.HidePanelUIState(hidePanelMsgIntent.b(), hidePanelMsgIntent.a()));
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.HideAllPanelMsgIntent) {
            com.tencent.mvi.log.b bVar3 = this.mLogger;
            if (bVar3 != null) {
                bVar3.i("PanelContainerVM", Intrinsics.stringPlus("[hideAllPanel]: source=", ((PanelContainerMsgIntent.HideAllPanelMsgIntent) msgIntent).b()));
            }
            updateUI(new PanelContainerUIState.HideAllPanelUIState(((PanelContainerMsgIntent.HideAllPanelMsgIntent) msgIntent).a()));
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent) {
            PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent hideAllPanelAndKeyboardMsgIntent = (PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent) msgIntent;
            updateUI(new PanelContainerUIState.HideAllPanelAndKeyboardUIState(hideAllPanelAndKeyboardMsgIntent.b(), hideAllPanelAndKeyboardMsgIntent.a()));
            return;
        }
        if (msgIntent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            com.tencent.mvi.log.b bVar4 = this.mLogger;
            if (bVar4 != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[OnKeyboardStateChanged]: isShowKeyboard=");
                KeyboardMsgIntent.OnKeyboardStateChanged onKeyboardStateChanged = (KeyboardMsgIntent.OnKeyboardStateChanged) msgIntent;
                sb5.append(onKeyboardStateChanged.b());
                sb5.append(" keyboardHeight = ");
                sb5.append(onKeyboardStateChanged.a());
                bVar4.i("PanelContainerVM", sb5.toString());
            }
            KeyboardMsgIntent.OnKeyboardStateChanged onKeyboardStateChanged2 = (KeyboardMsgIntent.OnKeyboardStateChanged) msgIntent;
            updateUI(new PanelContainerUIState.KeyboardShowStateChangedUIState(onKeyboardStateChanged2.b(), onKeyboardStateChanged2.a()));
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.OnConfigurationChanged) {
            com.tencent.mvi.log.b bVar5 = this.mLogger;
            if (bVar5 != null) {
                bVar5.i("PanelContainerVM", "[OnKeyboardStateChanged]: OnConfigurationChanged");
            }
            updateUI(new PanelContainerUIState.ConfigurationChangedUIState(((PanelContainerMsgIntent.OnConfigurationChanged) msgIntent).a()));
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.OnMultiWindowModeChanged) {
            com.tencent.mvi.log.b bVar6 = this.mLogger;
            if (bVar6 != null) {
                bVar6.i("PanelContainerVM", Intrinsics.stringPlus("[OnMultiWindowModeChanged]: OnMultiWindowModeChanged = ", Boolean.valueOf(((PanelContainerMsgIntent.OnMultiWindowModeChanged) msgIntent).a())));
            }
            updateUI(new PanelContainerUIState.MultiWindowModeChangedUIState(((PanelContainerMsgIntent.OnMultiWindowModeChanged) msgIntent).a()));
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent) {
            PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent setPanelHeightOffsetMsgIntent = (PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent) msgIntent;
            updateUI(new PanelContainerUIState.PanelPlusHeightUIState(setPanelHeightOffsetMsgIntent.a(), setPanelHeightOffsetMsgIntent.b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent msgIntent) {
        if (msgIntent instanceof PanelContainerMsgIntent.GetPanelContainerStateMsgIntent) {
            return n();
        }
        if (msgIntent instanceof PanelContainerMsgIntent.GetPanelHeightParamMsgIntent) {
            return m();
        }
        return new com.tencent.input.base.utils.a();
    }

    private final com.tencent.mvi.base.route.k m() {
        Bundle b16 = fetchVBState(k.c.f116865b).b();
        return new h.b(b16.getInt("current_height"), b16.getInt("normal_panel_height"));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mvi.api.runtime.b] */
    private final com.tencent.mvi.base.route.k n() {
        d.a aVar;
        boolean a16;
        com.tencent.mvi.base.route.k k3 = getMContext().e().k(KeyboardMsgIntent.GetKeyboardStatusMsgIntent.f116881d);
        if (k3 instanceof d.a) {
            aVar = (d.a) k3;
        } else {
            aVar = null;
        }
        boolean z16 = false;
        if (aVar == null) {
            a16 = false;
        } else {
            a16 = aVar.a();
        }
        int i3 = -1;
        if (!a16) {
            Bundle b16 = fetchVBState(k.b.f116864b).b();
            z16 = b16.getBoolean("is_show_panel", false);
            i3 = b16.getInt("current_panel_id", -1);
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerVM", "handleGetPanelContainerStateMsgIntent isShowKeyboard = " + a16 + " isShowPanel = " + a16 + " showPanelId = " + i3);
        }
        return new h.a(a16, z16, Integer.valueOf(i3));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mvi.api.runtime.b] */
    private final void p(int curPanelHeight) {
        getMContext().e().h(new PanelContainerMsgIntent.OnPanelHeightChanged(curPanelHeight));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mvi.api.runtime.b] */
    private final void q(boolean isShowOrHidePanel, int panelId) {
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerVM", "handlePanelStateChangedMviIntent isShowOrHidePanel = " + isShowOrHidePanel + " panelId = " + panelId);
        }
        getMContext().e().h(new PanelContainerMsgIntent.OnPanelStateChangedMsgIntent(isShowOrHidePanel, panelId));
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.ShowPanelMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.HidePanelMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.HideAllPanelMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnConfigurationChanged");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnMultiWindowModeChanged");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.GetPanelContainerStateMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.GetPanelHeightParamMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull i intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof i.a) {
            p(((i.a) intent).a());
        } else if (intent instanceof i.b) {
            i.b bVar = (i.b) intent;
            q(bVar.b(), bVar.a());
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mvi.api.runtime.b] */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerVM", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        super.onDestroy();
        this.mKeyboardVMDelegate.onDestroy();
        com.tencent.mvi.base.route.j e16 = getMContext().e();
        e16.i(this, this.mAction);
        e16.e(this);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mvi.api.runtime.b] */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull C context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerVM", "onCreate");
        }
        super.onCreate((l<C>) context);
        com.tencent.mvi.base.route.j e16 = getMContext().e();
        e16.f(this, this.mAction);
        e16.l(this, this.mActionR);
        f.a.a(this.mKeyboardVMDelegate, context, false, 2, null);
    }
}
