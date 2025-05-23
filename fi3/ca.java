package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ca implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f399215a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f399216b;

    /* renamed from: c, reason: collision with root package name */
    public final Space f399217c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399218d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399219e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399220f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f399221g;

    /* renamed from: h, reason: collision with root package name */
    public final RelativeLayout f399222h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f399223i;

    /* renamed from: j, reason: collision with root package name */
    public final ScrollView f399224j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f399225k;

    ca(FrameLayout frameLayout, LinearLayout linearLayout, Space space, TextView textView, TextView textView2, TextView textView3, TextView textView4, RelativeLayout relativeLayout, FrameLayout frameLayout2, ScrollView scrollView, ImageView imageView) {
        this.f399215a = frameLayout;
        this.f399216b = linearLayout;
        this.f399217c = space;
        this.f399218d = textView;
        this.f399219e = textView2;
        this.f399220f = textView3;
        this.f399221g = textView4;
        this.f399222h = relativeLayout;
        this.f399223i = frameLayout2;
        this.f399224j = scrollView;
        this.f399225k = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f399215a;
    }

    public static ca e(View view) {
        int i3 = R.id.f163310pf4;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163310pf4);
        if (linearLayout != null) {
            i3 = R.id.pf5;
            Space space = (Space) ViewBindings.findChildViewById(view, R.id.pf5);
            if (space != null) {
                i3 = R.id.ppm;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ppm);
                if (textView != null) {
                    i3 = R.id.ppn;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ppn);
                    if (textView2 != null) {
                        i3 = R.id.ppo;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.ppo);
                        if (textView3 != null) {
                            i3 = R.id.ppp;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.ppp);
                            if (textView4 != null) {
                                i3 = R.id.ppv;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ppv);
                                if (relativeLayout != null) {
                                    i3 = R.id.q9l;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q9l);
                                    if (frameLayout != null) {
                                        i3 = R.id.qjb;
                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.qjb);
                                        if (scrollView != null) {
                                            i3 = R.id.qs5;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qs5);
                                            if (imageView != null) {
                                                return new ca((FrameLayout) view, linearLayout, space, textView, textView2, textView3, textView4, relativeLayout, frameLayout, scrollView, imageView);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ca g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dgy, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
