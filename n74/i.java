package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.action.FacePanelTopOptView;
import com.tencent.sqshow.zootopia.widget.ZPlanAverageLinearLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f419347a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanAverageLinearLayout f419348b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f419349c;

    /* renamed from: d, reason: collision with root package name */
    public final FacePanelTopOptView f419350d;

    i(LinearLayout linearLayout, ZPlanAverageLinearLayout zPlanAverageLinearLayout, LinearLayout linearLayout2, FacePanelTopOptView facePanelTopOptView) {
        this.f419347a = linearLayout;
        this.f419348b = zPlanAverageLinearLayout;
        this.f419349c = linearLayout2;
        this.f419350d = facePanelTopOptView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f419347a;
    }

    public static i g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static i e(View view) {
        int i3 = R.id.q7j;
        ZPlanAverageLinearLayout zPlanAverageLinearLayout = (ZPlanAverageLinearLayout) ViewBindings.findChildViewById(view, R.id.q7j);
        if (zPlanAverageLinearLayout != null) {
            i3 = R.id.qmh;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qmh);
            if (linearLayout != null) {
                i3 = R.id.qs7;
                FacePanelTopOptView facePanelTopOptView = (FacePanelTopOptView) ViewBindings.findChildViewById(view, R.id.qs7);
                if (facePanelTopOptView != null) {
                    return new i((LinearLayout) view, zPlanAverageLinearLayout, linearLayout, facePanelTopOptView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static i h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
