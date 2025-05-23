package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aa implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RoundCorneredRelativeLayout f398774a;

    /* renamed from: b, reason: collision with root package name */
    public final RoundCorneredRelativeLayout f398775b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundCorneredRelativeLayout f398776c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f398777d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f398778e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f398779f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f398780g;

    aa(RoundCorneredRelativeLayout roundCorneredRelativeLayout, RoundCorneredRelativeLayout roundCorneredRelativeLayout2, RoundCorneredRelativeLayout roundCorneredRelativeLayout3, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3) {
        this.f398774a = roundCorneredRelativeLayout;
        this.f398775b = roundCorneredRelativeLayout2;
        this.f398776c = roundCorneredRelativeLayout3;
        this.f398777d = imageView;
        this.f398778e = textView;
        this.f398779f = imageView2;
        this.f398780g = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RoundCorneredRelativeLayout getRoot() {
        return this.f398774a;
    }

    public static aa g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static aa e(View view) {
        int i3 = R.id.qiz;
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) ViewBindings.findChildViewById(view, R.id.qiz);
        if (roundCorneredRelativeLayout != null) {
            RoundCorneredRelativeLayout roundCorneredRelativeLayout2 = (RoundCorneredRelativeLayout) view;
            i3 = R.id.qy_;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qy_);
            if (imageView != null) {
                i3 = R.id.qya;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qya);
                if (textView != null) {
                    i3 = R.id.qyc;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qyc);
                    if (imageView2 != null) {
                        i3 = R.id.f163603r10;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163603r10);
                        if (imageView3 != null) {
                            return new aa(roundCorneredRelativeLayout2, roundCorneredRelativeLayout, roundCorneredRelativeLayout2, imageView, textView, imageView2, imageView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static aa h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d95, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
