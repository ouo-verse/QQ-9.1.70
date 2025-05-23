package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399315a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399316b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewPager f399317c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399318d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399319e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399320f;

    /* renamed from: g, reason: collision with root package name */
    public final RelativeLayout f399321g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f399322h;

    p(RelativeLayout relativeLayout, ImageView imageView, ViewPager viewPager, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout2, TextView textView4) {
        this.f399315a = relativeLayout;
        this.f399316b = imageView;
        this.f399317c = viewPager;
        this.f399318d = textView;
        this.f399319e = textView2;
        this.f399320f = textView3;
        this.f399321g = relativeLayout2;
        this.f399322h = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399315a;
    }

    public static p e(View view) {
        int i3 = R.id.pcx;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pcx);
        if (imageView != null) {
            i3 = R.id.pq_;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.pq_);
            if (viewPager != null) {
                i3 = R.id.pqg;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pqg);
                if (textView != null) {
                    i3 = R.id.pqh;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pqh);
                    if (textView2 != null) {
                        i3 = R.id.pqi;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.pqi);
                        if (textView3 != null) {
                            i3 = R.id.qp7;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qp7);
                            if (relativeLayout != null) {
                                i3 = R.id.qr6;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qr6);
                                if (textView4 != null) {
                                    return new p((RelativeLayout) view, imageView, viewPager, textView, textView2, textView3, relativeLayout, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static p g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7u, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
