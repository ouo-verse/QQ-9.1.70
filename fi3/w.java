package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailFloatBar;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f399420a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaDetailFloatBar f399421b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399422c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399423d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f399424e;

    /* renamed from: f, reason: collision with root package name */
    public final ShimmerLinearLayout f399425f;

    w(FrameLayout frameLayout, ZootopiaDetailFloatBar zootopiaDetailFloatBar, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, ShimmerLinearLayout shimmerLinearLayout) {
        this.f399420a = frameLayout;
        this.f399421b = zootopiaDetailFloatBar;
        this.f399422c = imageView;
        this.f399423d = imageView2;
        this.f399424e = recyclerView;
        this.f399425f = shimmerLinearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f399420a;
    }

    public static w e(View view) {
        int i3 = R.id.puk;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar = (ZootopiaDetailFloatBar) ViewBindings.findChildViewById(view, R.id.puk);
        if (zootopiaDetailFloatBar != null) {
            i3 = R.id.f163410pz4;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163410pz4);
            if (imageView != null) {
                i3 = R.id.pz5;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pz5);
                if (imageView2 != null) {
                    i3 = R.id.qgp;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.qgp);
                    if (recyclerView != null) {
                        i3 = R.id.f163505qh3;
                        ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.f163505qh3);
                        if (shimmerLinearLayout != null) {
                            return new w((FrameLayout) view, zootopiaDetailFloatBar, imageView, imageView2, recyclerView, shimmerLinearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static w g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d8a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
