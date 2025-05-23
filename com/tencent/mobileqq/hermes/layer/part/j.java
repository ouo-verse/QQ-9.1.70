package com.tencent.mobileqq.hermes.layer.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.indicator.QUIPageIndicator;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/part/j;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "x9", "", "isPartEnable", "onInitView", "d", "Landroid/view/View;", "getBottomView", "()Landroid/view/View;", "setBottomView", "(Landroid/view/View;)V", "bottomView", "Lcom/tencent/biz/qui/indicator/QUIPageIndicator;", "e", "Lcom/tencent/biz/qui/indicator/QUIPageIndicator;", "getPageIndicatorView", "()Lcom/tencent/biz/qui/indicator/QUIPageIndicator;", "setPageIndicatorView", "(Lcom/tencent/biz/qui/indicator/QUIPageIndicator;)V", "pageIndicatorView", "f", "Z", "isEnablePageIndicator", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class j extends RFWLayerBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIPageIndicator pageIndicatorView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEnablePageIndicator;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isEnablePageIndicator = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("HERMES_ENABLE_PAGE_INDICATOR", true);
        }
    }

    private final void x9(View rootView) {
        QUIPageIndicator qUIPageIndicator = null;
        this.bottomView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f_v, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = ImmersiveUtils.getScreenHeight() / 15;
        View view = this.bottomView;
        if (view != null) {
            view.setClickable(false);
        }
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.bottomView, layoutParams);
        View view2 = this.bottomView;
        if (view2 != null) {
            qUIPageIndicator = (QUIPageIndicator) view2.findViewById(R.id.x9v);
        }
        this.pageIndicatorView = qUIPageIndicator;
        if (qUIPageIndicator != null) {
            View findViewById = rootView.findViewById(R.id.vh_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.gallery_card_rv)");
            qUIPageIndicator.d((RecyclerView) findViewById);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isEnablePageIndicator;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        x9(rootView);
    }
}
