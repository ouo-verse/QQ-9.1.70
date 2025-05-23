package com.tencent.mobileqq.aio.reserve2.huaweidrag;

import android.content.Context;
import android.graphics.Canvas;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.reserve2.huaweidrag.HuaweiDragUIState;
import com.tencent.mobileqq.aio.reserve2.huaweidrag.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/HuaWeiDragMaskVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/d;", "Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/HuaweiDragUIState;", "Landroid/view/View$OnDragListener;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "", "onReuseView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", "Landroid/view/DragEvent;", "event", "", "onDrag", "state", "b1", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class HuaWeiDragMaskVB extends com.tencent.aio.base.mvvm.a<d, HuaweiDragUIState> implements View.OnDragListener {
    static IPatchRedirector $redirector_;

    public HuaWeiDragMaskVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull HuaweiDragUIState state) {
        ViewGroup.LayoutParams layoutParams;
        View safetyGetHostView;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        View safetyGetHostView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if ((state instanceof HuaweiDragUIState.BackgroundColorState) && (safetyGetHostView2 = safetyGetHostView()) != null) {
            safetyGetHostView2.setBackgroundColor(((HuaweiDragUIState.BackgroundColorState) state).a());
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = null;
        if ((state instanceof HuaweiDragUIState.BottomLayoutHeightChanged) && (safetyGetHostView = safetyGetHostView()) != null) {
            ViewGroup.LayoutParams layoutParams2 = safetyGetHostView.getLayoutParams();
            boolean z16 = layoutParams2 instanceof ViewGroup.MarginLayoutParams;
            if (z16) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            } else {
                marginLayoutParams = null;
            }
            boolean z17 = false;
            if (marginLayoutParams != null && marginLayoutParams.bottomMargin == ((HuaweiDragUIState.BottomLayoutHeightChanged) state).a()) {
                z17 = true;
            }
            if (!z17) {
                if (z16) {
                    marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                } else {
                    marginLayoutParams2 = null;
                }
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.bottomMargin = ((HuaweiDragUIState.BottomLayoutHeightChanged) state).a();
                }
                safetyGetHostView.setLayoutParams(layoutParams2);
            }
        }
        if (state instanceof HuaweiDragUIState.TopPadding) {
            View safetyGetHostView3 = safetyGetHostView();
            if (safetyGetHostView3 != null) {
                layoutParams = safetyGetHostView3.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams3 != null) {
                HuaweiDragUIState.TopPadding topPadding = (HuaweiDragUIState.TopPadding) state;
                topPadding.a();
                marginLayoutParams3.topMargin = topPadding.a();
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<d, HuaweiDragUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new HuaWeiDragMaskVM();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        final Context a16 = createViewParams.a();
        FrameLayout frameLayout = new FrameLayout(a16) { // from class: com.tencent.mobileqq.aio.reserve2.huaweidrag.HuaWeiDragMaskVB$onCreateView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(a16);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a16);
                }
            }

            @Override // android.view.View
            protected void onDraw(@Nullable Canvas canvas) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) canvas);
                } else {
                    super.onDraw(canvas);
                }
            }
        };
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setOnDragListener(this);
        frameLayout.setWillNotDraw(false);
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        View safetyGetHostView = safetyGetHostView();
        if (safetyGetHostView != null) {
            safetyGetHostView.setOnDragListener(null);
        }
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(@NotNull View v3, @NotNull DragEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        sendIntent(new d.a(event));
        return true;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        View safetyGetHostView = safetyGetHostView();
        if (safetyGetHostView != null) {
            safetyGetHostView.setOnDragListener(this);
        }
    }
}
