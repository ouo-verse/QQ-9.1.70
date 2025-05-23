package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreFacePanelTopOptView;
import com.tencent.sqshow.zootopia.widget.ZPlanAverageLinearLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bv implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f418937a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanAverageLinearLayout f418938b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f418939c;

    /* renamed from: d, reason: collision with root package name */
    public final PortalStoreFacePanelTopOptView f418940d;

    bv(LinearLayout linearLayout, ZPlanAverageLinearLayout zPlanAverageLinearLayout, LinearLayout linearLayout2, PortalStoreFacePanelTopOptView portalStoreFacePanelTopOptView) {
        this.f418937a = linearLayout;
        this.f418938b = zPlanAverageLinearLayout;
        this.f418939c = linearLayout2;
        this.f418940d = portalStoreFacePanelTopOptView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f418937a;
    }

    public static bv g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bv e(View view) {
        int i3 = R.id.q7j;
        ZPlanAverageLinearLayout zPlanAverageLinearLayout = (ZPlanAverageLinearLayout) ViewBindings.findChildViewById(view, R.id.q7j);
        if (zPlanAverageLinearLayout != null) {
            i3 = R.id.qmh;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qmh);
            if (linearLayout != null) {
                i3 = R.id.qs7;
                PortalStoreFacePanelTopOptView portalStoreFacePanelTopOptView = (PortalStoreFacePanelTopOptView) ViewBindings.findChildViewById(view, R.id.qs7);
                if (portalStoreFacePanelTopOptView != null) {
                    return new bv((LinearLayout) view, zPlanAverageLinearLayout, linearLayout, portalStoreFacePanelTopOptView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bv h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.de5, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
