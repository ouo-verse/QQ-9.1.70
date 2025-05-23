package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f419357a;

    /* renamed from: b, reason: collision with root package name */
    public final View f419358b;

    /* renamed from: c, reason: collision with root package name */
    public final URLImageView f419359c;

    /* renamed from: d, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419360d;

    /* renamed from: e, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419361e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f419362f;

    /* renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f419363g;

    /* renamed from: h, reason: collision with root package name */
    public final Guideline f419364h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f419365i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f419366j;

    k(LinearLayout linearLayout, View view, URLImageView uRLImageView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2, ImageView imageView, ConstraintLayout constraintLayout, Guideline guideline, LinearLayout linearLayout2, TextView textView) {
        this.f419357a = linearLayout;
        this.f419358b = view;
        this.f419359c = uRLImageView;
        this.f419360d = zplanExcludeFontPaddingTextView;
        this.f419361e = zplanExcludeFontPaddingTextView2;
        this.f419362f = imageView;
        this.f419363g = constraintLayout;
        this.f419364h = guideline;
        this.f419365i = linearLayout2;
        this.f419366j = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f419357a;
    }

    public static k g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static k e(View view) {
        int i3 = R.id.pig;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pig);
        if (findChildViewById != null) {
            i3 = R.id.pih;
            URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.pih);
            if (uRLImageView != null) {
                i3 = R.id.pii;
                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.pii);
                if (zplanExcludeFontPaddingTextView != null) {
                    i3 = R.id.pij;
                    ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.pij);
                    if (zplanExcludeFontPaddingTextView2 != null) {
                        i3 = R.id.pik;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pik);
                        if (imageView != null) {
                            i3 = R.id.pil;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.pil);
                            if (constraintLayout != null) {
                                i3 = R.id.pym;
                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.pym);
                                if (guideline != null) {
                                    i3 = R.id.pyr;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pyr);
                                    if (linearLayout != null) {
                                        i3 = R.id.pys;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pys);
                                        if (textView != null) {
                                            return new k((LinearLayout) view, findChildViewById, uRLImageView, zplanExcludeFontPaddingTextView, zplanExcludeFontPaddingTextView2, imageView, constraintLayout, guideline, linearLayout, textView);
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

    public static k h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_5, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
