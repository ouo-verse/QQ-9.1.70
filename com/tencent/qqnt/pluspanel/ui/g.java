package com.tencent.qqnt.pluspanel.ui;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.pluspanel.data.PlusPanelUiState;
import com.tencent.qqnt.pluspanel.utils.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00017B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0001H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u001a\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R&\u0010)\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R(\u0010+\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/pluspanel/ui/g;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/pluspanel/data/e;", "Lcom/tencent/qqnt/pluspanel/data/PlusPanelUiState;", "", "g1", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "vb", "d1", "i1", "Lcom/tencent/qqnt/pluspanel/data/a;", "appData", "c1", "data", "h1", "e1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "bindViewAndData", "state", "f1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "d", "I", "panelId", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "root", "f", "Lcom/tencent/aio/base/mvvm/a;", "rootVB", tl.h.F, "coverPanel", "Lcom/tencent/qqnt/pluspanel/ui/e;", "i", "Lcom/tencent/qqnt/pluspanel/ui/e;", "mDialog", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hidePlusPanelWhenPokeShow", "<init>", "(I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class g extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.pluspanel.data.e, PlusPanelUiState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int panelId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout root;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> rootVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> coverPanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e mDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean hidePlusPanelWhenPokeShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/ui/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.ui.g$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/pluspanel/ui/g$b", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.aio.base.mvvm.a aVar = g.this.rootVB;
                i iVar = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootVB");
                    aVar = null;
                }
                if (aVar instanceof i) {
                    iVar = (i) aVar;
                }
                if (iVar != null) {
                    iVar.j1(v3, "em_group_panel_application");
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45632);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.panelId = i3;
        boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emoticon_hide_plus_panel_124426206", true);
        QLog.d("PlusPanelContainerVB", 1, "hidePlusPanelWhenPokeShow:" + isSwitchOn);
        this.hidePlusPanelWhenPokeShow = isSwitchOn;
    }

    private final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> c1(com.tencent.qqnt.pluspanel.data.a appData) {
        i iVar;
        int c16 = appData.c();
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        View view = null;
        if (c16 == companion.A()) {
            j jVar = new j();
            if (this.hidePlusPanelWhenPokeShow) {
                com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar = this.rootVB;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootVB");
                    aVar = null;
                }
                if (aVar instanceof i) {
                    iVar = (i) aVar;
                } else {
                    iVar = null;
                }
                if (iVar != null) {
                    view = iVar.getHostView();
                }
                if (view != null) {
                    view.setVisibility(8);
                }
            }
            return jVar;
        }
        boolean z16 = true;
        if (c16 != companion.s() && c16 != companion.q0()) {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        return new a(this.panelId);
    }

    private final void d1(com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> vb5) {
        com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar = this.coverPanel;
        if ((aVar instanceof i) && !(vb5 instanceof i)) {
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.qqnt.pluspanel.ui.PlusPanelVB");
            ((i) aVar).d1();
        }
        addChildVB(vb5);
        this.coverPanel = vb5;
        QLog.e("PlusPanelContainerVB", 1, "changePanel");
    }

    private final void e1() {
        e eVar = this.mDialog;
        if (eVar != null && eVar.isShowing()) {
            eVar.dismiss();
        }
    }

    private final void g1() {
        QLog.d("PlusPanelContainerVB", 1, "PlusPanelContainerVB initPlusPanel: " + this.panelId);
        int i3 = this.panelId;
        if (i3 != 1006) {
            if (i3 == 1009 || i3 == 1010) {
                i iVar = new i();
                this.rootVB = iVar;
                addChildVB(iVar);
                d1(new a(this.panelId));
                return;
            }
            return;
        }
        i iVar2 = new i();
        this.rootVB = iVar2;
        addChildVB(iVar2);
    }

    private final void h1(com.tencent.qqnt.pluspanel.data.a data) {
        e1();
        e eVar = new e(getMContext(), data.d(), new b());
        this.mDialog = eVar;
        eVar.show();
        com.tencent.mobileqq.aio.utils.b.f194119a.p("em_group_more_application_panel");
    }

    private final void i1() {
        i iVar;
        QLog.i("PlusPanelContainerVB", 1, "[removePanel] start: " + this.coverPanel);
        com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar = this.rootVB;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootVB");
            aVar = null;
        }
        if (aVar instanceof i) {
            iVar = (i) aVar;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            iVar.d1();
        }
        com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar2 = this.coverPanel;
        if (aVar2 != null) {
            if (aVar2 instanceof i) {
                Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.qqnt.pluspanel.ui.PlusPanelVB");
                ((i) aVar2).d1();
            }
            removeChildVB(aVar2);
            this.coverPanel = null;
            QLog.e("PlusPanelContainerVB", 1, "removePanel");
        }
        e1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.bindViewAndData();
            g1();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<com.tencent.qqnt.pluspanel.data.e, PlusPanelUiState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.qqnt.pluspanel.logic.d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PlusPanelUiState state) {
        com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.d("PlusPanelContainerVB", 4, "[handleUIState] state: " + state);
        if (state instanceof PlusPanelUiState.OpenExtendPanel) {
            if (this.panelId == 1006 && (c16 = c1(((PlusPanelUiState.OpenExtendPanel) state).a())) != null) {
                d1(c16);
                return;
            }
            return;
        }
        if (state instanceof PlusPanelUiState.CloseExtendPanel) {
            i1();
            return;
        }
        if (state instanceof PlusPanelUiState.RemoveIceBreakHotPic) {
            if (this.panelId != 1009) {
                return;
            }
            i1();
        } else if (state instanceof PlusPanelUiState.RemovePanel) {
            i1();
        } else if (state instanceof PlusPanelUiState.OpenMoreAppPanel) {
            h1(((PlusPanelUiState.OpenMoreAppPanel) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(getMContext());
        this.root = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("PlusPanelContainerVB", 1, "PlusPanelContainerVB onDestroy");
        super.onDestroy();
        com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar = this.rootVB;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootVB");
            aVar = null;
        }
        aVar.destroy();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        QLog.d("PlusPanelContainerVB", 1, "PlusPanelContainerVB onReuseView: " + this.panelId);
        super.onReuseView(reuseParam);
        int i3 = this.panelId;
        if (i3 != 1006) {
            if (i3 == 1009 || i3 == 1010) {
                d1(new a(this.panelId));
                return;
            }
            return;
        }
        if (this.hidePlusPanelWhenPokeShow) {
            com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar = this.rootVB;
            View view = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootVB");
                aVar = null;
            }
            if (aVar instanceof i) {
                iVar = (i) aVar;
            } else {
                iVar = null;
            }
            if (iVar != null) {
                view = iVar.getHostView();
            }
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }
}
