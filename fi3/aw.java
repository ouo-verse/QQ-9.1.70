package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f398960a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f398961b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f398962c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f398963d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f398964e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f398965f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f398966g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f398967h;

    aw(ConstraintLayout constraintLayout, Button button, LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout2, ImageView imageView2) {
        this.f398960a = constraintLayout;
        this.f398961b = button;
        this.f398962c = linearLayout;
        this.f398963d = textView;
        this.f398964e = textView2;
        this.f398965f = imageView;
        this.f398966g = linearLayout2;
        this.f398967h = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f398960a;
    }

    public static aw g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static aw e(View view) {
        int i3 = R.id.pfp;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.pfp);
        if (button != null) {
            i3 = R.id.pgd;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pgd);
            if (linearLayout != null) {
                i3 = R.id.pmf;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pmf);
                if (textView != null) {
                    i3 = R.id.pmh;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pmh);
                    if (textView2 != null) {
                        i3 = R.id.pvd;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pvd);
                        if (imageView != null) {
                            i3 = R.id.qrv;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qrv);
                            if (linearLayout2 != null) {
                                i3 = R.id.qsc;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qsc);
                                if (imageView2 != null) {
                                    return new aw((ConstraintLayout) view, button, linearLayout, textView, textView2, imageView, linearLayout2, imageView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static aw h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.db9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
