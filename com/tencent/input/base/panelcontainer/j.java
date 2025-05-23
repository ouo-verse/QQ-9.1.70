package com.tencent.input.base.panelcontainer;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerUIState;
import com.tencent.input.base.panelcontainer.i;
import com.tencent.input.base.panelcontainer.k;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0003:\u0001;B\u0015\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000 \u00a2\u0006\u0004\b8\u00109J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00180\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R^\u0010+\u001aJ\u0012\u0004\u0012\u00020\b\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020&\u0012\u0006\b\u0001\u0012\u00020'\u0012\u0004\u0012\u00028\u00000%0$j$\u0012\u0004\u0012\u00020\b\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020&\u0012\u0006\b\u0001\u0012\u00020'\u0012\u0004\u0012\u00028\u00000%`(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/input/base/panelcontainer/j;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/core/a;", "Lcom/tencent/input/base/panelcontainer/i;", "Lcom/tencent/input/base/panelcontainer/PanelContainerUIState;", "Lcom/tencent/input/base/panelcontainer/d;", "f1", "", "panelId", "Landroid/view/View;", "g1", "Landroid/os/Bundle;", "h1", "i1", "", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "j1", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/input/base/panelcontainer/c;", "d", "Lcom/tencent/input/base/panelcontainer/c;", "mBuildPanelApi", "Ljava/util/HashMap;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "mPanelVBCache", "Lcom/tencent/mvi/log/b;", "f", "Lcom/tencent/mvi/log/b;", "mLogger", "Lpz0/a;", tl.h.F, "Lpz0/a;", "mMMKVAdapter", "Lcom/tencent/input/base/panelcontainer/e;", "i", "Lcom/tencent/input/base/panelcontainer/e;", "mLayoutWrapper", "<init>", "(Lcom/tencent/input/base/panelcontainer/c;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class j<C extends com.tencent.mvi.api.runtime.b> extends com.tencent.input.base.core.a<i, PanelContainerUIState, C> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c<C> mBuildPanelApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Integer, BaseVB<? extends ol3.b, ? extends MviUIState, C>> mPanelVBCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mvi.log.b mLogger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private pz0.a mMMKVAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mLayoutWrapper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/input/base/panelcontainer/j$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.input.base.panelcontainer.j$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/input/base/panelcontainer/j$b", "Lcom/tencent/input/base/panelcontainer/d;", "", "curPanelHeight", "", "d", "Lpz0/a;", "b", "PanelId", "Landroid/view/View;", "a", "", "isShowPanel", "panelId", "e", "Lpz0/b;", "c", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<C> f116862a;

        b(j<C> jVar) {
            this.f116862a = jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jVar);
            }
        }

        @Override // com.tencent.input.base.panelcontainer.d
        @NotNull
        public View a(int PanelId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return this.f116862a.g1(PanelId);
            }
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, PanelId);
        }

        @Override // com.tencent.input.base.panelcontainer.d
        @Nullable
        public pz0.a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (pz0.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (pz0.a) this.f116862a.getMStrategyService().b(pz0.a.class);
        }

        @Override // com.tencent.input.base.panelcontainer.d
        @Nullable
        public pz0.b c(int panelId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (pz0.b) iPatchRedirector.redirect((short) 6, (Object) this, panelId);
            }
            Object obj = ((j) this.f116862a).mPanelVBCache.get(Integer.valueOf(panelId));
            if (obj instanceof pz0.b) {
                return (pz0.b) obj;
            }
            return null;
        }

        @Override // com.tencent.input.base.panelcontainer.d
        public void d(int curPanelHeight) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, curPanelHeight);
            } else {
                this.f116862a.sendIntent(new i.a(curPanelHeight));
            }
        }

        @Override // com.tencent.input.base.panelcontainer.d
        public void e(boolean isShowPanel, int panelId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                com.tencent.mvi.log.b bVar = ((j) this.f116862a).mLogger;
                if (bVar != null) {
                    bVar.i("PanelContainerVB", "onPanelStateChanged isShowPanel = " + isShowPanel + " panelId = " + panelId);
                }
                this.f116862a.sendIntent(new i.b(isShowPanel, panelId));
                return;
            }
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isShowPanel), Integer.valueOf(panelId));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33200);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j(@NotNull c<C> mBuildPanelApi) {
        Intrinsics.checkNotNullParameter(mBuildPanelApi, "mBuildPanelApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mBuildPanelApi);
            return;
        }
        this.mBuildPanelApi = mBuildPanelApi;
        this.mPanelVBCache = new HashMap<>();
        this.mLayoutWrapper = new PanelContainerLayoutWrapper(f1());
    }

    private final void e1() {
        Iterator<Map.Entry<Integer, BaseVB<? extends ol3.b, ? extends MviUIState, C>>> it = this.mPanelVBCache.entrySet().iterator();
        while (it.hasNext()) {
            removeChildVB(it.next().getValue());
        }
        this.mPanelVBCache.clear();
    }

    private final d f1() {
        return new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View g1(int panelId) {
        if (this.mPanelVBCache.containsKey(Integer.valueOf(panelId))) {
            BaseVB<? extends ol3.b, ? extends MviUIState, C> baseVB = this.mPanelVBCache.get(Integer.valueOf(panelId));
            Intrinsics.checkNotNull(baseVB);
            BaseVB<? extends ol3.b, ? extends MviUIState, C> baseVB2 = baseVB;
            baseVB2.resumeVB(new com.tencent.mvi.api.help.b(getMContext(), (ViewGroup) getHostView()));
            return baseVB2.getHostView();
        }
        BaseVB<? extends ol3.b, ? extends MviUIState, C> b16 = this.mBuildPanelApi.b(panelId);
        this.mPanelVBCache.put(Integer.valueOf(panelId), b16);
        com.tencent.mvi.mvvm.framework.b.a(this, b16);
        return b16.getHostView();
    }

    private final Bundle h1() {
        boolean z16;
        Bundle bundle = new Bundle();
        int i3 = this.mLayoutWrapper.i();
        if (i3 != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("is_show_panel", z16);
        bundle.putInt("current_panel_id", i3);
        return bundle;
    }

    private final Bundle i1() {
        Bundle a16 = k.c.f116865b.a();
        a16.putInt("normal_panel_height", this.mLayoutWrapper.b());
        a16.putInt("current_height", this.mLayoutWrapper.c());
        return a16;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mLayoutWrapper.a();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<i, PanelContainerUIState, C> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new l(this.mLogger, this.mMMKVAdapter);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bundle) iPatchRedirector.redirect((short) 7, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof k.b) {
            return h1();
        }
        if (stateCmd instanceof k.c) {
            return i1();
        }
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends PanelContainerUIState>> getObserverStates() {
        List<Class<? extends PanelContainerUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{PanelContainerUIState.ShowPanelUIState.class, PanelContainerUIState.HidePanelUIState.class, PanelContainerUIState.HideAllPanelUIState.class, PanelContainerUIState.HideAllPanelAndKeyboardUIState.class, PanelContainerUIState.MultiWindowModeChangedUIState.class, PanelContainerUIState.ConfigurationChangedUIState.class, PanelContainerUIState.KeyboardShowStateChangedUIState.class, PanelContainerUIState.PanelPlusHeightUIState.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PanelContainerUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof PanelContainerUIState.ShowPanelUIState) {
            PanelContainerUIState.ShowPanelUIState showPanelUIState = (PanelContainerUIState.ShowPanelUIState) state;
            this.mLayoutWrapper.g(showPanelUIState.c(), showPanelUIState.b(), showPanelUIState.a());
            return;
        }
        if (state instanceof PanelContainerUIState.HidePanelUIState) {
            PanelContainerUIState.HidePanelUIState hidePanelUIState = (PanelContainerUIState.HidePanelUIState) state;
            this.mLayoutWrapper.h(hidePanelUIState.b(), hidePanelUIState.a());
            return;
        }
        if (state instanceof PanelContainerUIState.HideAllPanelUIState) {
            this.mLayoutWrapper.j(((PanelContainerUIState.HideAllPanelUIState) state).a());
            return;
        }
        if (state instanceof PanelContainerUIState.HideAllPanelAndKeyboardUIState) {
            PanelContainerUIState.HideAllPanelAndKeyboardUIState hideAllPanelAndKeyboardUIState = (PanelContainerUIState.HideAllPanelAndKeyboardUIState) state;
            this.mLayoutWrapper.e(hideAllPanelAndKeyboardUIState.b(), hideAllPanelAndKeyboardUIState.a());
            return;
        }
        if (state instanceof PanelContainerUIState.MultiWindowModeChangedUIState) {
            this.mLayoutWrapper.onMultiWindowModeChanged(((PanelContainerUIState.MultiWindowModeChangedUIState) state).a());
            return;
        }
        if (state instanceof PanelContainerUIState.ConfigurationChangedUIState) {
            this.mLayoutWrapper.onConfigurationChanged(((PanelContainerUIState.ConfigurationChangedUIState) state).a());
            return;
        }
        if (state instanceof PanelContainerUIState.KeyboardShowStateChangedUIState) {
            PanelContainerUIState.KeyboardShowStateChangedUIState keyboardShowStateChangedUIState = (PanelContainerUIState.KeyboardShowStateChangedUIState) state;
            this.mLayoutWrapper.f(keyboardShowStateChangedUIState.b(), keyboardShowStateChangedUIState.a());
        } else if (state instanceof PanelContainerUIState.PanelPlusHeightUIState) {
            PanelContainerUIState.PanelPlusHeightUIState panelPlusHeightUIState = (PanelContainerUIState.PanelPlusHeightUIState) state;
            this.mLayoutWrapper.k(panelPlusHeightUIState.a(), panelPlusHeightUIState.b());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        this.mLogger = (com.tencent.mvi.log.b) getMStrategyService().b(com.tencent.mvi.log.b.class);
        this.mMMKVAdapter = (pz0.a) getMStrategyService().b(pz0.a.class);
        return this.mLayoutWrapper.d(createViewParams, getMStrategyService());
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerVB", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        super.onDestroy();
        this.mLayoutWrapper.e(MosaicConstants$JsFunction.FUNC_ON_DESTROY, false);
        e1();
        destroyVM();
        this.mLayoutWrapper.onDestroy();
    }
}
