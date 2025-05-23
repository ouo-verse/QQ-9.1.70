package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.minixwconnected.view.ZPlanMinihomeNeighborFloatingView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399108a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanMinihomeNeighborFloatingView f399109b;

    bj(RelativeLayout relativeLayout, ZPlanMinihomeNeighborFloatingView zPlanMinihomeNeighborFloatingView) {
        this.f399108a = relativeLayout;
        this.f399109b = zPlanMinihomeNeighborFloatingView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399108a;
    }

    public static bj g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bj e(View view) {
        ZPlanMinihomeNeighborFloatingView zPlanMinihomeNeighborFloatingView = (ZPlanMinihomeNeighborFloatingView) ViewBindings.findChildViewById(view, R.id.qfd);
        if (zPlanMinihomeNeighborFloatingView != null) {
            return new bj((RelativeLayout) view, zPlanMinihomeNeighborFloatingView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qfd)));
    }

    public static bj h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddh, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
