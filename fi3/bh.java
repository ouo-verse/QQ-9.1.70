package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bh implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399091a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399092b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399093c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399094d;

    /* renamed from: e, reason: collision with root package name */
    public final QUIButton f399095e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399096f;

    /* renamed from: g, reason: collision with root package name */
    public final RelativeLayout f399097g;

    bh(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, QUIButton qUIButton, TextView textView, RelativeLayout relativeLayout2) {
        this.f399091a = relativeLayout;
        this.f399092b = imageView;
        this.f399093c = imageView2;
        this.f399094d = imageView3;
        this.f399095e = qUIButton;
        this.f399096f = textView;
        this.f399097g = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399091a;
    }

    public static bh g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bh e(View view) {
        int i3 = R.id.pk9;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pk9);
        if (imageView != null) {
            i3 = R.id.ppf;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ppf);
            if (imageView2 != null) {
                i3 = R.id.ppg;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.ppg);
                if (imageView3 != null) {
                    i3 = R.id.ppi;
                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.ppi);
                    if (qUIButton != null) {
                        i3 = R.id.ppp;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ppp);
                        if (textView != null) {
                            i3 = R.id.q98;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.q98);
                            if (relativeLayout != null) {
                                return new bh((RelativeLayout) view, imageView, imageView2, imageView3, qUIButton, textView, relativeLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bh h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
