package cy;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.aio.PAInputContainerAboveUIState;
import com.tencent.mobileqq.R;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcy/b;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState;", "Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "params", "", "b1", "d1", "", "leftMargin", "topMargin", "rightMargin", "bottomMargin", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "state", "c1", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mRootLayout", "e", "Landroid/view/View;", "mCurrentView", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.tencent.aio.base.mvvm.a<Object, PAInputContainerAboveUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mRootLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mCurrentView;

    private final void b1(View view, ViewGroup.LayoutParams params) {
        View view2 = this.mCurrentView;
        if (view2 != null) {
            d1(view2);
        }
        d1(view);
        FrameLayout frameLayout = this.mRootLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            frameLayout = null;
        }
        frameLayout.addView(view, params);
        this.mCurrentView = view;
    }

    private final void d1(View view) {
        FrameLayout frameLayout = this.mRootLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            frameLayout = null;
        }
        frameLayout.removeView(view);
    }

    private final void e1(int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        FrameLayout frameLayout = this.mRootLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = leftMargin;
        layoutParams2.topMargin = topMargin;
        layoutParams2.rightMargin = rightMargin;
        layoutParams2.bottomMargin = bottomMargin;
        FrameLayout frameLayout3 = this.mRootLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(PAInputContainerAboveUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof PAInputContainerAboveUIState.AddAboveView) {
            PAInputContainerAboveUIState.AddAboveView addAboveView = (PAInputContainerAboveUIState.AddAboveView) state;
            b1(addAboveView.getView(), addAboveView.getParams());
        } else if (state instanceof PAInputContainerAboveUIState.RemoveAboveView) {
            d1(((PAInputContainerAboveUIState.RemoveAboveView) state).getView());
        } else if (state instanceof PAInputContainerAboveUIState.UpdateAboveParentViewMargin) {
            PAInputContainerAboveUIState.UpdateAboveParentViewMargin updateAboveParentViewMargin = (PAInputContainerAboveUIState.UpdateAboveParentViewMargin) state;
            e1(updateAboveParentViewMargin.getLeftMargin(), updateAboveParentViewMargin.getTopMargin(), updateAboveParentViewMargin.getRightMargin(), updateAboveParentViewMargin.getBottomMargin());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public BaseVM<Object, PAInputContainerAboveUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new dy.a();
    }

    @Override // com.tencent.mvi.mvvm.b
    public View onCreateView(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.p9l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026id.input_container_above)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.mRootLayout = frameLayout;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        return null;
    }
}
