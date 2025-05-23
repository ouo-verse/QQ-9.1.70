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
public final class ak implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f398827a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f398828b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f398829c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f398830d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f398831e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f398832f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f398833g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearLayout f398834h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f398835i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f398836j;

    ak(ConstraintLayout constraintLayout, Button button, Button button2, LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView2) {
        this.f398827a = constraintLayout;
        this.f398828b = button;
        this.f398829c = button2;
        this.f398830d = linearLayout;
        this.f398831e = textView;
        this.f398832f = textView2;
        this.f398833g = imageView;
        this.f398834h = linearLayout2;
        this.f398835i = linearLayout3;
        this.f398836j = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f398827a;
    }

    public static ak e(View view) {
        int i3 = R.id.pfr;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.pfr);
        if (button != null) {
            i3 = R.id.pfs;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.pfs);
            if (button2 != null) {
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
                                i3 = R.id.q7_;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q7_);
                                if (linearLayout2 != null) {
                                    i3 = R.id.qrv;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qrv);
                                    if (linearLayout3 != null) {
                                        i3 = R.id.qsc;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qsc);
                                        if (imageView2 != null) {
                                            return new ak((ConstraintLayout) view, button, button2, linearLayout, textView, textView2, imageView, linearLayout2, linearLayout3, imageView2);
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

    public static ak g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d9s, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
