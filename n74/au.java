package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.widget.AlphaClickableLinearLayout;
import com.tencent.sqshow.zootopia.widget.ZPlanAsyncTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class au implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418746a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f418747b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanAsyncTextView f418748c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f418749d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f418750e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f418751f;

    /* renamed from: g, reason: collision with root package name */
    public final AlphaClickableLinearLayout f418752g;

    /* renamed from: h, reason: collision with root package name */
    public final ShimmerLinearLayout f418753h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f418754i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f418755j;

    /* renamed from: k, reason: collision with root package name */
    public final View f418756k;

    au(RelativeLayout relativeLayout, TextView textView, ZPlanAsyncTextView zPlanAsyncTextView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, AlphaClickableLinearLayout alphaClickableLinearLayout, ShimmerLinearLayout shimmerLinearLayout, LinearLayout linearLayout3, TextView textView3, View view) {
        this.f418746a = relativeLayout;
        this.f418747b = textView;
        this.f418748c = zPlanAsyncTextView;
        this.f418749d = linearLayout;
        this.f418750e = textView2;
        this.f418751f = linearLayout2;
        this.f418752g = alphaClickableLinearLayout;
        this.f418753h = shimmerLinearLayout;
        this.f418754i = linearLayout3;
        this.f418755j = textView3;
        this.f418756k = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f418746a;
    }

    public static au g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static au e(View view) {
        int i3 = R.id.poj;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.poj);
        if (textView != null) {
            i3 = R.id.pot;
            ZPlanAsyncTextView zPlanAsyncTextView = (ZPlanAsyncTextView) ViewBindings.findChildViewById(view, R.id.pot);
            if (zPlanAsyncTextView != null) {
                i3 = R.id.pql;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pql);
                if (linearLayout != null) {
                    i3 = R.id.pqm;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pqm);
                    if (textView2 != null) {
                        i3 = R.id.q_9;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q_9);
                        if (linearLayout2 != null) {
                            i3 = R.id.qdv;
                            AlphaClickableLinearLayout alphaClickableLinearLayout = (AlphaClickableLinearLayout) ViewBindings.findChildViewById(view, R.id.qdv);
                            if (alphaClickableLinearLayout != null) {
                                i3 = R.id.qld;
                                ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.qld);
                                if (shimmerLinearLayout != null) {
                                    i3 = R.id.qpf;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qpf);
                                    if (linearLayout3 != null) {
                                        i3 = R.id.qr6;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qr6);
                                        if (textView3 != null) {
                                            i3 = R.id.qyd;
                                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.qyd);
                                            if (findChildViewById != null) {
                                                return new au((RelativeLayout) view, textView, zPlanAsyncTextView, linearLayout, textView2, linearLayout2, alphaClickableLinearLayout, shimmerLinearLayout, linearLayout3, textView3, findChildViewById);
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

    public static au h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbi, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
