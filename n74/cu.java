package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cu implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f419154a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419155b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f419156c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419157d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f419158e;

    /* renamed from: f, reason: collision with root package name */
    public final bi f419159f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f419160g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f419161h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f419162i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f419163j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f419164k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f419165l;

    cu(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, bi biVar, LinearLayout linearLayout, TextView textView3, ImageView imageView3, TextView textView4, LinearLayout linearLayout2, TextView textView5) {
        this.f419154a = constraintLayout;
        this.f419155b = imageView;
        this.f419156c = imageView2;
        this.f419157d = textView;
        this.f419158e = textView2;
        this.f419159f = biVar;
        this.f419160g = linearLayout;
        this.f419161h = textView3;
        this.f419162i = imageView3;
        this.f419163j = textView4;
        this.f419164k = linearLayout2;
        this.f419165l = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f419154a;
    }

    public static cu e(View view) {
        int i3 = R.id.pnf;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pnf);
        if (imageView != null) {
            i3 = R.id.pnh;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pnh);
            if (imageView2 != null) {
                i3 = R.id.pnj;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pnj);
                if (textView != null) {
                    i3 = R.id.pt_;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pt_);
                    if (textView2 != null) {
                        i3 = R.id.pxe;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pxe);
                        if (findChildViewById != null) {
                            bi e16 = bi.e(findChildViewById);
                            i3 = R.id.pxj;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pxj);
                            if (linearLayout != null) {
                                i3 = R.id.pxo;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.pxo);
                                if (textView3 != null) {
                                    i3 = R.id.q2q;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.q2q);
                                    if (imageView3 != null) {
                                        i3 = R.id.qap;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qap);
                                        if (textView4 != null) {
                                            i3 = R.id.qaq;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qaq);
                                            if (linearLayout2 != null) {
                                                i3 = R.id.qar;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qar);
                                                if (textView5 != null) {
                                                    return new cu((ConstraintLayout) view, imageView, imageView2, textView, textView2, e16, linearLayout, textView3, imageView3, textView4, linearLayout2, textView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cu g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.df8, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
