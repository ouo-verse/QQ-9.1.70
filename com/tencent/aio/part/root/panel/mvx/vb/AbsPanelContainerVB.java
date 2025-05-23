package com.tencent.aio.part.root.panel.mvx.vb;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.CallSuper;
import com.tencent.aio.part.root.panel.content.mvx.vb.ContentVb;
import com.tencent.aio.part.root.panel.mvx.intent.a;
import com.tencent.aio.part.root.panel.mvx.state.DemoPanelState;
import com.tencent.aio.part.root.panel.mvx.widget.PanelContainer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ml3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J#\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0017\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0010\u0012\u0006\b\u0001\u0012\u00020\u00110\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0017J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R/\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\r0(8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/vb/AbsPanelContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/aio/part/root/panel/mvx/intent/a;", "Lcom/tencent/aio/part/root/panel/mvx/state/DemoPanelState;", "Lcom/tencent/aio/part/root/panel/mvx/state/DemoPanelState$ShowPanel;", "state", "", "g1", "", "showPanelId", "hidePanelId", "f1", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/view/View;", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "e1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/mvx/widget/PanelContainer;", "d", "Lcom/tencent/aio/part/root/panel/mvx/widget/PanelContainer;", "panelContainer", "e", "Ljava/lang/Integer;", "Lcom/tencent/aio/part/root/panel/content/mvx/vb/ContentVb;", "f", "Lcom/tencent/aio/part/root/panel/content/mvx/vb/ContentVb;", "getContentVb$sdk_debug", "()Lcom/tencent/aio/part/root/panel/content/mvx/vb/ContentVb;", "h1", "(Lcom/tencent/aio/part/root/panel/content/mvx/vb/ContentVb;)V", "contentVb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "panelId", "d1", "()Lkotlin/jvm/functions/Function1;", "panelFetcher", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class AbsPanelContainerVB extends com.tencent.aio.base.mvvm.a<com.tencent.aio.part.root.panel.mvx.intent.a, DemoPanelState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PanelContainer panelContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Integer showPanelId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ContentVb contentVb;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/part/root/panel/mvx/vb/AbsPanelContainerVB$a", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) AbsPanelContainerVB.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animation) {
            b b16;
            com.tencent.aio.part.root.panel.mvx.service.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
                return;
            }
            com.tencent.aio.api.runtime.a mAIOContext$sdk_debug = AbsPanelContainerVB.this.getMAIOContext$sdk_debug();
            if (mAIOContext$sdk_debug != null && (b16 = mAIOContext$sdk_debug.b()) != null && (aVar = (com.tencent.aio.part.root.panel.mvx.service.a) b16.b(com.tencent.aio.part.root.panel.mvx.service.a.class)) != null) {
                aVar.f();
            }
        }
    }

    public AbsPanelContainerVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    private final void g1(DemoPanelState.ShowPanel state) {
        Integer num = this.showPanelId;
        int b16 = state.b();
        if (num != null && num.intValue() == b16) {
            return;
        }
        this.showPanelId = Integer.valueOf(state.b());
        PanelContainer panelContainer = this.panelContainer;
        if (panelContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        }
        panelContainer.D(state.b(), state.a(), d1());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.aio.part.root.panel.mvx.intent.a, DemoPanelState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new com.tencent.aio.part.root.panel.mvx.vm.a();
    }

    @NotNull
    public abstract Function1<Integer, View> d1();

    @Override // com.tencent.mvi.mvvm.BaseVB
    @CallSuper
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull DemoPanelState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof DemoPanelState.HideAllPanelAndKeyboard) {
            PanelContainer panelContainer = this.panelContainer;
            if (panelContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            }
            panelContainer.l(((DemoPanelState.HideAllPanelAndKeyboard) state).a());
            return;
        }
        if (state instanceof DemoPanelState.HideAllPanel) {
            PanelContainer panelContainer2 = this.panelContainer;
            if (panelContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            }
            panelContainer2.j(((DemoPanelState.HideAllPanel) state).a());
            return;
        }
        if (state instanceof DemoPanelState.HideKeyboard) {
            PanelContainer panelContainer3 = this.panelContainer;
            if (panelContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            }
            panelContainer3.m();
            return;
        }
        if (state instanceof DemoPanelState.ShowPanel) {
            g1((DemoPanelState.ShowPanel) state);
            return;
        }
        if (state instanceof DemoPanelState.ShowKeyboard) {
            PanelContainer panelContainer4 = this.panelContainer;
            if (panelContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            }
            panelContainer4.B();
            sendIntent(new a.C0652a());
            return;
        }
        if (state instanceof DemoPanelState.ShowKeyboardWhenNone) {
            PanelContainer panelContainer5 = this.panelContainer;
            if (panelContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            }
            panelContainer5.C();
            sendIntent(new a.C0652a());
            return;
        }
        if (state instanceof DemoPanelState.ShowExpandPanel) {
            PanelContainer panelContainer6 = this.panelContainer;
            if (panelContainer6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            }
            DemoPanelState.ShowExpandPanel showExpandPanel = (DemoPanelState.ShowExpandPanel) state;
            panelContainer6.A(showExpandPanel.a(), showExpandPanel.b());
            return;
        }
        if (state instanceof DemoPanelState.RollbackExpandPanel) {
            PanelContainer panelContainer7 = this.panelContainer;
            if (panelContainer7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            }
            panelContainer7.y(((DemoPanelState.RollbackExpandPanel) state).a());
            return;
        }
        if (state instanceof DemoPanelState.MultiWindowModeChangedPanel) {
            PanelContainer panelContainer8 = this.panelContainer;
            if (panelContainer8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            }
            panelContainer8.w(((DemoPanelState.MultiWindowModeChangedPanel) state).a());
        }
    }

    @Deprecated(message = "\u4e3a\u4e86\u517c\u5bb9\u5e9f\u5f03\u9762\u677f \u903b\u8f91")
    public void f1(@Nullable Integer showPanelId, @Nullable Integer hidePanelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) showPanelId, (Object) hidePanelId);
        }
    }

    public final void h1(@Nullable ContentVb contentVb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) contentVb);
        } else {
            this.contentVb = contentVb;
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> mutableListOf;
        dt.b bVar;
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ContentVb contentVb = this.contentVb;
        if (contentVb == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Intrinsics.checkNotNull(contentVb);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(contentVb);
        com.tencent.mvi.runtime.strategy.b mStrategyService = getMStrategyService();
        if (mStrategyService != null) {
            bVar = (dt.b) mStrategyService.b(dt.b.class);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            mutableListOf.add(new com.tencent.aio.part.root.panel.bottomdialog.mvx.vb.a());
        }
        return mutableListOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        PanelContainer panelContainer = new PanelContainer(createViewParams.a());
        this.panelContainer = panelContainer;
        panelContainer.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -1));
        PanelContainer panelContainer2 = this.panelContainer;
        if (panelContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        }
        panelContainer2.setKeyBoardStatusObserver(new Function1<Boolean, Unit>() { // from class: com.tencent.aio.part.root.panel.mvx.vb.AbsPanelContainerVB$onCreateView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsPanelContainerVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Boolean bool) {
                com.tencent.aio.api.runtime.a mAIOContext$sdk_debug;
                b b16;
                com.tencent.aio.part.root.panel.mvx.service.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) bool);
                    return;
                }
                AbsPanelContainerVB.this.sendIntent(new a.b(bool));
                if (!Intrinsics.areEqual(bool, Boolean.TRUE) || (mAIOContext$sdk_debug = AbsPanelContainerVB.this.getMAIOContext$sdk_debug()) == null || (b16 = mAIOContext$sdk_debug.b()) == null || (aVar = (com.tencent.aio.part.root.panel.mvx.service.a) b16.b(com.tencent.aio.part.root.panel.mvx.service.a.class)) == null) {
                    return;
                }
                aVar.f();
            }
        });
        PanelContainer panelContainer3 = this.panelContainer;
        if (panelContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        }
        panelContainer3.setPanelStatusObserver(new Function2<Integer, Integer, Unit>() { // from class: com.tencent.aio.part.root.panel.mvx.vb.AbsPanelContainerVB$onCreateView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsPanelContainerVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke2(num, num2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num, @Nullable Integer num2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) num, (Object) num2);
                    return;
                }
                AbsPanelContainerVB.this.f1(num, num2);
                AbsPanelContainerVB.this.sendIntent(new a.c(num, num2));
                AbsPanelContainerVB.this.showPanelId = num;
            }
        });
        PanelContainer panelContainer4 = this.panelContainer;
        if (panelContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        }
        panelContainer4.setPanelAnimUpdateListener(new a());
        PanelContainer panelContainer5 = this.panelContainer;
        if (panelContainer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        }
        return panelContainer5;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        PanelContainer panelContainer = this.panelContainer;
        if (panelContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        }
        panelContainer.t();
    }
}
