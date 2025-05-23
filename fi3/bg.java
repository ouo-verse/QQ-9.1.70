package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bg implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399083a;

    /* renamed from: b, reason: collision with root package name */
    public final URLImageView f399084b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399085c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399086d;

    /* renamed from: e, reason: collision with root package name */
    public final View f399087e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f399088f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f399089g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f399090h;

    bg(LinearLayout linearLayout, URLImageView uRLImageView, TextView textView, TextView textView2, View view, LinearLayout linearLayout2, ImageView imageView, TextView textView3) {
        this.f399083a = linearLayout;
        this.f399084b = uRLImageView;
        this.f399085c = textView;
        this.f399086d = textView2;
        this.f399087e = view;
        this.f399088f = linearLayout2;
        this.f399089g = imageView;
        this.f399090h = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399083a;
    }

    public static bg g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bg e(View view) {
        int i3 = R.id.pur;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.pur);
        if (uRLImageView != null) {
            i3 = R.id.pus;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pus);
            if (textView != null) {
                i3 = R.id.puu;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.puu);
                if (textView2 != null) {
                    i3 = R.id.f163429q30;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163429q30);
                    if (findChildViewById != null) {
                        i3 = R.id.f163482qd0;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163482qd0);
                        if (linearLayout != null) {
                            i3 = R.id.qdp;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qdp);
                            if (imageView != null) {
                                i3 = R.id.qds;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qds);
                                if (textView3 != null) {
                                    return new bg((LinearLayout) view, uRLImageView, textView, textView2, findChildViewById, linearLayout, imageView, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bg h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddc, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
