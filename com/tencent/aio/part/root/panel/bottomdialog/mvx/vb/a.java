package com.tencent.aio.part.root.panel.bottomdialog.mvx.vb;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aio.part.root.panel.bottomdialog.mvx.intent.a;
import com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a;
import com.tencent.aio.part.root.panel.bottomdialog.mvx.state.BottomDialogState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.mvi.MviUIState;
import dt.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0015H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R(\u0010*\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020&\u0012\u0006\b\u0001\u0012\u00020'\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/vb/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/intent/a;", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/state/BottomDialogState;", "", HippyTKDListViewAdapter.X, "y", "", "dialogType", "", "f1", "Landroid/view/View;", "anchorView", "g1", "type", "c1", "d1", "onPreCreate", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "b1", "bindViewAndData", "state", "e1", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/a;", "d", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/a;", "curPopWindow", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a;", "e", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/vm/a;", "curVM", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "fakeViewGroup", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", h.F, "Lcom/tencent/aio/base/mvvm/a;", "subVB", "i", "Lcom/tencent/mvi/api/help/a;", "curCreateViewParams", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "subViewHeight", "Ldt/b;", BdhLogUtil.LogTag.Tag_Conn, "Ldt/b;", "dialogFactory", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends com.tencent.aio.base.mvvm.a<com.tencent.aio.part.root.panel.bottomdialog.mvx.intent.a, BottomDialogState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private b dialogFactory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a curPopWindow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.part.root.panel.bottomdialog.mvx.vm.a curVM;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout fakeViewGroup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> subVB;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mvi.api.help.a curCreateViewParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int subViewHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/part/root/panel/bottomdialog/mvx/vb/a$a", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/a$b;", "", ViewStickEventHelper.IS_SHOW, "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.bottomdialog.mvx.vb.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0637a implements a.b {
        static IPatchRedirector $redirector_;

        C0637a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a.b
        public void a(boolean isShow) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, isShow);
            } else {
                a.this.sendIntent(new a.C0635a(isShow));
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    private final void c1(String type) {
        com.tencent.mvi.api.help.a aVar = this.curCreateViewParams;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curCreateViewParams");
        }
        com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a aVar2 = new com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a(aVar.a(), -1, -2);
        this.curPopWindow = aVar2;
        Intrinsics.checkNotNull(aVar2);
        aVar2.c(new C0637a());
        b bVar = this.dialogFactory;
        if (bVar != null) {
            bVar.a(type);
        }
        this.subVB = null;
    }

    private final void d1() {
        com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar = this.subVB;
        if (aVar != null) {
            aVar.destroy();
        }
        com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a aVar2 = this.curPopWindow;
        if (aVar2 != null) {
            aVar2.dismiss();
        }
    }

    private final void f1(int x16, int y16, String dialogType) {
        c1(dialogType);
        com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a aVar = this.curPopWindow;
        if (aVar != null) {
            aVar.d(getHostView(), 80, x16, y16, 1.0f);
        }
        com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a aVar2 = this.curPopWindow;
        if (aVar2 != null) {
            aVar2.e();
        }
    }

    private final void g1(View anchorView, String dialogType) {
        c1(dialogType);
        int i3 = -(this.subViewHeight + anchorView.getHeight());
        com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.a aVar = this.curPopWindow;
        if (aVar != null) {
            aVar.showAsDropDown(anchorView, 0, i3, 8388611);
        }
    }

    static /* synthetic */ void h1(a aVar, int i3, int i16, String str, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            str = "";
        }
        aVar.f1(i3, i16, str);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.aio.part.root.panel.bottomdialog.mvx.intent.a, BottomDialogState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.aio.part.root.panel.bottomdialog.mvx.vm.a aVar = new com.tencent.aio.part.root.panel.bottomdialog.mvx.vm.a();
        this.curVM = aVar;
        return aVar;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.bindViewAndData();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull BottomDialogState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        boolean f16 = state.f();
        if (f16) {
            int c16 = state.c();
            if (c16 != 1) {
                if (c16 != 2) {
                    h1(this, 0, 0, null, 4, null);
                    return;
                } else {
                    if (state.a() != null) {
                        View a16 = state.a();
                        Intrinsics.checkNotNull(a16);
                        g1(a16, state.b());
                        return;
                    }
                    throw new NullPointerException("Use anchor type to show win, but anchor is null");
                }
            }
            f1(state.d(), state.e(), state.b());
            return;
        }
        if (!f16) {
            d1();
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
        this.curCreateViewParams = createViewParams;
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        this.fakeViewGroup = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onPreCreate() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        super.onPreCreate();
        com.tencent.mvi.runtime.strategy.b mStrategyService = getMStrategyService();
        if (mStrategyService != null) {
            bVar = (b) mStrategyService.b(b.class);
        } else {
            bVar = null;
        }
        this.dialogFactory = bVar;
    }
}
