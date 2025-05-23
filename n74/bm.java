package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.avatar.loading.view.ZPlanPageDataErrorHintView;
import com.tencent.sqshow.zootopia.card.view.floatbanner.ZPlanFloatBannerView;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRolePendantContainer;
import com.tencent.sqshow.zootopia.widget.bubble.ZPlanBubbleView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bm implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418856a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanBubbleView f418857b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanFloatBannerView f418858c;

    /* renamed from: d, reason: collision with root package name */
    public final ZPlanPageDataErrorHintView f418859d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f418860e;

    /* renamed from: f, reason: collision with root package name */
    public final ZPlanRolePendantContainer f418861f;

    bm(FrameLayout frameLayout, ZPlanBubbleView zPlanBubbleView, ZPlanFloatBannerView zPlanFloatBannerView, ZPlanPageDataErrorHintView zPlanPageDataErrorHintView, FrameLayout frameLayout2, ZPlanRolePendantContainer zPlanRolePendantContainer) {
        this.f418856a = frameLayout;
        this.f418857b = zPlanBubbleView;
        this.f418858c = zPlanFloatBannerView;
        this.f418859d = zPlanPageDataErrorHintView;
        this.f418860e = frameLayout2;
        this.f418861f = zPlanRolePendantContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418856a;
    }

    public static bm g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bm e(View view) {
        int i3 = R.id.f163348pn2;
        ZPlanBubbleView zPlanBubbleView = (ZPlanBubbleView) ViewBindings.findChildViewById(view, R.id.f163348pn2);
        if (zPlanBubbleView != null) {
            i3 = R.id.puj;
            ZPlanFloatBannerView zPlanFloatBannerView = (ZPlanFloatBannerView) ViewBindings.findChildViewById(view, R.id.puj);
            if (zPlanFloatBannerView != null) {
                i3 = R.id.q6_;
                ZPlanPageDataErrorHintView zPlanPageDataErrorHintView = (ZPlanPageDataErrorHintView) ViewBindings.findChildViewById(view, R.id.q6_);
                if (zPlanPageDataErrorHintView != null) {
                    i3 = R.id.q6f;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q6f);
                    if (frameLayout != null) {
                        i3 = R.id.qhr;
                        ZPlanRolePendantContainer zPlanRolePendantContainer = (ZPlanRolePendantContainer) ViewBindings.findChildViewById(view, R.id.qhr);
                        if (zPlanRolePendantContainer != null) {
                            return new bm((FrameLayout) view, zPlanBubbleView, zPlanFloatBannerView, zPlanPageDataErrorHintView, frameLayout, zPlanRolePendantContainer);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bm h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dd7, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
