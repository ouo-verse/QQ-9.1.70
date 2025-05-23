package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class dg implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419242a;

    /* renamed from: b, reason: collision with root package name */
    public final ShimmerLinearLayout f419243b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f419244c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f419245d;

    dg(FrameLayout frameLayout, ShimmerLinearLayout shimmerLinearLayout, RecyclerView recyclerView, RelativeLayout relativeLayout) {
        this.f419242a = frameLayout;
        this.f419243b = shimmerLinearLayout;
        this.f419244c = recyclerView;
        this.f419245d = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419242a;
    }

    public static dg e(View view) {
        int i3 = R.id.pla;
        ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.pla);
        if (shimmerLinearLayout != null) {
            i3 = R.id.f163341pm0;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f163341pm0);
            if (recyclerView != null) {
                i3 = R.id.pst;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pst);
                if (relativeLayout != null) {
                    return new dg((FrameLayout) view, shimmerLinearLayout, recyclerView, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static dg g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dgs, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
