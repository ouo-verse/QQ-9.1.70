package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.widget.Gallery;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f399270a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageAnimationView f399271b;

    /* renamed from: c, reason: collision with root package name */
    public final View f399272c;

    /* renamed from: d, reason: collision with root package name */
    public final Gallery f399273d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f399274e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f399275f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f399276g;

    h(FrameLayout frameLayout, ImageAnimationView imageAnimationView, View view, Gallery gallery, RelativeLayout relativeLayout, FrameLayout frameLayout2, TextView textView) {
        this.f399270a = frameLayout;
        this.f399271b = imageAnimationView;
        this.f399272c = view;
        this.f399273d = gallery;
        this.f399274e = relativeLayout;
        this.f399275f = frameLayout2;
        this.f399276g = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f399270a;
    }

    public static h e(View view) {
        int i3 = R.id.pai;
        ImageAnimationView imageAnimationView = (ImageAnimationView) ViewBindings.findChildViewById(view, R.id.pai);
        if (imageAnimationView != null) {
            i3 = R.id.pd8;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.pd8);
            if (findChildViewById != null) {
                i3 = R.id.pwm;
                Gallery gallery = (Gallery) ViewBindings.findChildViewById(view, R.id.pwm);
                if (gallery != null) {
                    i3 = R.id.qir;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qir);
                    if (relativeLayout != null) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        i3 = R.id.qqa;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qqa);
                        if (textView != null) {
                            return new h(frameLayout, imageAnimationView, findChildViewById, gallery, relativeLayout, frameLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static h g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7k, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
