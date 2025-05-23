package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.c2c.item.ZootopiaC2CAvatarRecyclerView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419191a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaLoadFailView f419192b;

    /* renamed from: c, reason: collision with root package name */
    public final ShimmerLinearLayout f419193c;

    /* renamed from: d, reason: collision with root package name */
    public final ZootopiaC2CAvatarRecyclerView f419194d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f419195e;

    d(FrameLayout frameLayout, ZootopiaLoadFailView zootopiaLoadFailView, ShimmerLinearLayout shimmerLinearLayout, ZootopiaC2CAvatarRecyclerView zootopiaC2CAvatarRecyclerView, ImageView imageView) {
        this.f419191a = frameLayout;
        this.f419192b = zootopiaLoadFailView;
        this.f419193c = shimmerLinearLayout;
        this.f419194d = zootopiaC2CAvatarRecyclerView;
        this.f419195e = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419191a;
    }

    public static d e(View view) {
        int i3 = R.id.psw;
        ZootopiaLoadFailView zootopiaLoadFailView = (ZootopiaLoadFailView) ViewBindings.findChildViewById(view, R.id.psw);
        if (zootopiaLoadFailView != null) {
            i3 = R.id.q5p;
            ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.q5p);
            if (shimmerLinearLayout != null) {
                i3 = R.id.qgp;
                ZootopiaC2CAvatarRecyclerView zootopiaC2CAvatarRecyclerView = (ZootopiaC2CAvatarRecyclerView) ViewBindings.findChildViewById(view, R.id.qgp);
                if (zootopiaC2CAvatarRecyclerView != null) {
                    i3 = R.id.qlj;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qlj);
                    if (imageView != null) {
                        return new d((FrameLayout) view, zootopiaLoadFailView, shimmerLinearLayout, zootopiaC2CAvatarRecyclerView, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static d g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
