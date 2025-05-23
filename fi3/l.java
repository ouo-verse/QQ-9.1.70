package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.widget.RoundRectURLImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399295a;

    /* renamed from: b, reason: collision with root package name */
    public final Guideline f399296b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundRectURLImageView f399297c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f399298d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399299e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399300f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f399301g;

    l(ConstraintLayout constraintLayout, Guideline guideline, RoundRectURLImageView roundRectURLImageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.f399295a = constraintLayout;
        this.f399296b = guideline;
        this.f399297c = roundRectURLImageView;
        this.f399298d = linearLayout;
        this.f399299e = textView;
        this.f399300f = textView2;
        this.f399301g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399295a;
    }

    public static l e(View view) {
        int i3 = R.id.pyn;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.pyn);
        if (guideline != null) {
            i3 = R.id.pyw;
            RoundRectURLImageView roundRectURLImageView = (RoundRectURLImageView) ViewBindings.findChildViewById(view, R.id.pyw);
            if (roundRectURLImageView != null) {
                i3 = R.id.q4j;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q4j);
                if (linearLayout != null) {
                    i3 = R.id.quh;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.quh);
                    if (textView != null) {
                        i3 = R.id.quj;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.quj);
                        if (textView2 != null) {
                            i3 = R.id.quk;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.quk);
                            if (textView3 != null) {
                                return new l((ConstraintLayout) view, guideline, roundRectURLImageView, linearLayout, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static l g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7q, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
