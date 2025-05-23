package com.tencent.aio.part.fitwindow.vb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.aio.api.factory.c;
import com.tencent.aio.base.mvvm.a;
import com.tencent.aio.part.fitwindow.vb.FitSystemWindowVB;
import com.tencent.aio.part.root.panel.content.mvx.vb.ContentVb;
import com.tencent.aio.part.root.panel.mvx.vb.AbsPanelContainerVB;
import com.tencent.aio.part.root.panel.mvx.vb.PanelContainerVB;
import com.tencent.aio.widget.FitSystemWindowsRelativeLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001)B\u000f\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010\u000e2\u0006\u0010\r\u001a\u00020\tH\u0016J$\u0010\u0013\u001a\u00020\u000b2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016R(\u0010\u0016\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/tencent/aio/part/fitwindow/vb/FitSystemWindowVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "h1", "g1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "onPreCreate", "hostView", "", "initializeChildVB", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "mUIModel", "afterCreateVM", "d", "Lcom/tencent/aio/base/mvvm/a;", "panelAreaVB", "e", "Z", "addPanelVB", "Lcom/tencent/aio/part/root/panel/content/mvx/vb/ContentVb;", "f", "Lcom/tencent/aio/part/root/panel/content/mvx/vb/ContentVb;", "contentVb", h.F, "hasCustomPanel", "Lcom/tencent/aio/part/root/panel/content/mvx/vb/a;", "i", "Lcom/tencent/aio/part/root/panel/content/mvx/vb/a;", "panelCompatVB", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "useDispatcher", "<init>", "(Z)V", BdhLogUtil.LogTag.Tag_Conn, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class FitSystemWindowVB extends com.tencent.aio.base.mvvm.a<b, MviUIState> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState> panelAreaVB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean addPanelVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ContentVb contentVb;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasCustomPanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.part.root.panel.content.mvx.vb.a panelCompatVB;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean useDispatcher;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/fitwindow/vb/FitSystemWindowVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45494);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            C = new a(null);
        }
    }

    public FitSystemWindowVB(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        this.useDispatcher = z16;
        this.contentVb = new ContentVb(false, 1, null);
    }

    private final boolean g1() {
        return this.panelAreaVB instanceof AbsPanelContainerVB;
    }

    private final boolean h1() {
        if (this.panelAreaVB != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<b, MviUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState> aVar;
        com.tencent.aio.api.runtime.a mAIOContext$sdk_debug;
        com.tencent.mvi.api.runtime.a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        if (isPreload() || g1() || !this.useDispatcher || this.panelCompatVB != null || this.addPanelVB) {
            return;
        }
        c cVar = (c) getMStrategyService().b(c.class);
        if (cVar != null) {
            aVar = cVar.a();
        } else {
            aVar = null;
        }
        this.panelAreaVB = aVar;
        if (!(aVar instanceof AbsPanelContainerVB) && h1() && (mAIOContext$sdk_debug = getMAIOContext$sdk_debug()) != null && (a16 = mAIOContext$sdk_debug.a()) != null) {
            this.addPanelVB = true;
            a16.f(new Runnable() { // from class: com.tencent.aio.part.fitwindow.vb.FitSystemWindowVB$afterCreateVM$$inlined$let$lambda$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FitSystemWindowVB.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a aVar2;
                    FitSystemWindowVB.a unused;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FitSystemWindowVB.this.hasCustomPanel = true;
                        if (com.tencent.aio.base.a.f69150c.a()) {
                            com.tencent.aio.base.log.a aVar3 = com.tencent.aio.base.log.a.f69187b;
                            unused = FitSystemWindowVB.C;
                            aVar3.e("FitSystemWindowVB", "afterCreateVM add  PanelContainerVb ");
                        }
                        aVar2 = FitSystemWindowVB.this.panelAreaVB;
                        if (aVar2 != null) {
                            com.tencent.aio.part.root.panel.content.mvx.vb.a aVar4 = new com.tencent.aio.part.root.panel.content.mvx.vb.a(aVar2);
                            FitSystemWindowVB.this.panelCompatVB = aVar4;
                            FitSystemWindowVB.this.addChildVB(aVar4);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.base.mvvm.AIOBaseVB<com.tencent.mvi.base.mvi.MviIntent, com.tencent.mvi.base.mvi.MviUIState>");
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ArrayList arrayList = new ArrayList();
        if (!h1()) {
            arrayList.add(this.contentVb);
            return arrayList;
        }
        if (g1()) {
            com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState> aVar = this.panelAreaVB;
            if (aVar != null) {
                AbsPanelContainerVB absPanelContainerVB = (AbsPanelContainerVB) aVar;
                absPanelContainerVB.h1(this.contentVb);
                Unit unit = Unit.INSTANCE;
                arrayList.add(absPanelContainerVB);
                return arrayList;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.vb.AbsPanelContainerVB");
        }
        com.tencent.aio.base.log.a.f69187b.e("FitSystemWindowVB", "initializeChildVB useDispatcher " + this.useDispatcher + "  checkSdKPanelArea() " + g1() + " isPreload  " + isPreload());
        arrayList.add(this.contentVb);
        this.hasCustomPanel = true;
        if (!isPreload() && (z16 = this.useDispatcher)) {
            if (!z16) {
                com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState> aVar2 = this.panelAreaVB;
                if (aVar2 != null) {
                    com.tencent.aio.part.root.panel.content.mvx.vb.a aVar3 = new com.tencent.aio.part.root.panel.content.mvx.vb.a(aVar2);
                    this.panelCompatVB = aVar3;
                    Unit unit2 = Unit.INSTANCE;
                    arrayList.add(aVar3);
                    return arrayList;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.base.mvvm.AIOBaseVB<com.tencent.mvi.base.mvi.MviIntent, com.tencent.mvi.base.mvi.MviUIState>");
            }
            return arrayList;
        }
        com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState> aVar4 = this.panelAreaVB;
        if (aVar4 != null) {
            com.tencent.aio.part.root.panel.content.mvx.vb.a aVar5 = new com.tencent.aio.part.root.panel.content.mvx.vb.a(aVar4);
            this.panelCompatVB = aVar5;
            Unit unit3 = Unit.INSTANCE;
            arrayList.add(aVar5);
            return arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.base.mvvm.AIOBaseVB<com.tencent.mvi.base.mvi.MviIntent, com.tencent.mvi.base.mvi.MviUIState>");
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull final com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (View) iPatchRedirector.redirect((short) 1, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        final Context a16 = createViewParams.a();
        FitSystemWindowsRelativeLayout fitSystemWindowsRelativeLayout = new FitSystemWindowsRelativeLayout(createViewParams, a16) { // from class: com.tencent.aio.part.fitwindow.vb.FitSystemWindowVB$onCreateView$1
            static IPatchRedirector $redirector_;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.tencent.mvi.api.help.a f69476f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a16);
                this.f69476f = createViewParams;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, FitSystemWindowVB.this, createViewParams, a16);
                }
            }

            @Override // android.view.ViewGroup
            public void addView(@NotNull View child) {
                ContentVb contentVb;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) child);
                    return;
                }
                Intrinsics.checkNotNullParameter(child, "child");
                super.addView(child);
                contentVb = FitSystemWindowVB.this.contentVb;
                if (Intrinsics.areEqual(child, contentVb.safetyGetHostView())) {
                    ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                    if (layoutParams != null) {
                        ((RelativeLayout.LayoutParams) layoutParams).addRule(2, com.tencent.aio.part.root.panel.content.mvx.vb.b.a());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
        };
        fitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
        return fitSystemWindowsRelativeLayout;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onPreCreate() {
        com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState> aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onPreCreate();
        c cVar = (c) getMStrategyService().b(c.class);
        if (cVar != null) {
            aVar = cVar.a();
        } else {
            aVar = null;
        }
        this.panelAreaVB = aVar;
        if (aVar == null && getMStrategyService().a(com.tencent.aio.part.root.panel.mvx.config.a.class)) {
            this.panelAreaVB = new PanelContainerVB();
        }
    }
}
