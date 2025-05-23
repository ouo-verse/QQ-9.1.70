package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class be implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399074a;

    /* renamed from: b, reason: collision with root package name */
    public final View f399075b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399076c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399077d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399078e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressBar f399079f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f399080g;

    be(ConstraintLayout constraintLayout, View view, ImageView imageView, TextView textView, TextView textView2, ProgressBar progressBar, TextView textView3) {
        this.f399074a = constraintLayout;
        this.f399075b = view;
        this.f399076c = imageView;
        this.f399077d = textView;
        this.f399078e = textView2;
        this.f399079f = progressBar;
        this.f399080g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399074a;
    }

    public static be g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static be e(View view) {
        int i3 = R.id.f163361pq0;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163361pq0);
        if (findChildViewById != null) {
            i3 = R.id.r5j;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.r5j);
            if (imageView != null) {
                i3 = R.id.r5k;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r5k);
                if (textView != null) {
                    i3 = R.id.r5l;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.r5l);
                    if (textView2 != null) {
                        i3 = R.id.r5m;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.r5m);
                        if (progressBar != null) {
                            i3 = R.id.r5n;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.r5n);
                            if (textView3 != null) {
                                return new be((ConstraintLayout) view, findChildViewById, imageView, textView, textView2, progressBar, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static be h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167449dd3, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
