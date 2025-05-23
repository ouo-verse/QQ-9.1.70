package jy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f411141a;

    /* renamed from: b, reason: collision with root package name */
    public final CustomMenuBar f411142b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f411143c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f411144d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f411145e;

    /* renamed from: f, reason: collision with root package name */
    public final RelativeLayout f411146f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f411147g;

    a(RelativeLayout relativeLayout, CustomMenuBar customMenuBar, LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, FrameLayout frameLayout) {
        this.f411141a = relativeLayout;
        this.f411142b = customMenuBar;
        this.f411143c = linearLayout;
        this.f411144d = imageView;
        this.f411145e = relativeLayout2;
        this.f411146f = relativeLayout3;
        this.f411147g = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f411141a;
    }

    public static a e(View view) {
        int i3 = R.id.p9g;
        CustomMenuBar customMenuBar = (CustomMenuBar) ViewBindings.findChildViewById(view, R.id.p9g);
        if (customMenuBar != null) {
            i3 = R.id.p9h;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.p9h);
            if (linearLayout != null) {
                i3 = R.id.p9i;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p9i);
                if (imageView != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.p9k;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.p9k);
                    if (relativeLayout2 != null) {
                        i3 = R.id.p9l;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.p9l);
                        if (frameLayout != null) {
                            return new a(relativeLayout, customMenuBar, linearLayout, imageView, relativeLayout, relativeLayout2, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static a g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d2d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
