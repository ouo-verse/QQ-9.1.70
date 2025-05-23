package ll2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.publicaccount.controller.TabLayoutController;
import com.tencent.mobileqq.qwallet.publicaccount.nt.QWalletPABottomTabState;
import com.tencent.mobileqq.qwallet.publicaccount.nt.QWalletPABottomTabVM;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ll2.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0016J$\u0010\r\u001a\u00020\f2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lll2/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lll2/a;", "Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "mUIModel", "", "afterCreateVM", "state", "b1", "d", "Landroid/view/View;", "bottomTabs", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends com.tencent.aio.base.mvvm.a<a, QWalletPABottomTabState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomTabs;

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<a, QWalletPABottomTabState, com.tencent.aio.api.runtime.a> mUIModel) {
        super.afterCreateVM(mUIModel);
        sendIntent(a.C10731a.f414985d);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull QWalletPABottomTabState state) {
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof QWalletPABottomTabState.ChangeTabVisibilityState) {
            View view = this.bottomTabs;
            if (view != null) {
                if (((QWalletPABottomTabState.ChangeTabVisibilityState) state).getVisible()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                view.setVisibility(i3);
                return;
            }
            return;
        }
        if (!(state instanceof QWalletPABottomTabState.HidePAMenuState)) {
            super.handleUIState(state);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<a, QWalletPABottomTabState, com.tencent.aio.api.runtime.a> createVM() {
        return new QWalletPABottomTabVM();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        int parseColor;
        int i3;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Context a16 = createViewParams.a();
        View tabLayout = LayoutInflater.from(a16).inflate(R.layout.hjn, createViewParams.b(), false);
        if (QQTheme.isNowThemeIsNight()) {
            parseColor = Color.parseColor("#FF161616");
            i3 = -16777216;
        } else {
            parseColor = Color.parseColor("#FFCCCCCC");
            i3 = -1;
        }
        if (tabLayout instanceof LinearLayout) {
            ((LinearLayout) tabLayout).getDividerDrawable().setColorFilter(new PorterDuffColorFilter(parseColor, PorterDuff.Mode.SRC_ATOP));
            tabLayout.setBackgroundColor(i3);
            TabLayoutController tabLayoutController = new TabLayoutController((LinearLayout) tabLayout);
            tabLayoutController.f(com.tencent.mobileqq.qwallet.publicaccount.conf.a.f279114a.d());
            tabLayoutController.g();
        }
        this.bottomTabs = tabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "tabLayout");
        return tabLayout;
    }
}
