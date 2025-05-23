package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ar implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f398901a;

    /* renamed from: b, reason: collision with root package name */
    public final URLImageView f398902b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f398903c;

    /* renamed from: d, reason: collision with root package name */
    public final RoundCornerImageView f398904d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f398905e;

    /* renamed from: f, reason: collision with root package name */
    public final View f398906f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f398907g;

    /* renamed from: h, reason: collision with root package name */
    public final View f398908h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f398909i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f398910j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f398911k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f398912l;

    /* renamed from: m, reason: collision with root package name */
    public final FrameLayout f398913m;

    ar(View view, URLImageView uRLImageView, TextView textView, RoundCornerImageView roundCornerImageView, ImageView imageView, View view2, ImageView imageView2, View view3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, FrameLayout frameLayout) {
        this.f398901a = view;
        this.f398902b = uRLImageView;
        this.f398903c = textView;
        this.f398904d = roundCornerImageView;
        this.f398905e = imageView;
        this.f398906f = view2;
        this.f398907g = imageView2;
        this.f398908h = view3;
        this.f398909i = textView2;
        this.f398910j = textView3;
        this.f398911k = textView4;
        this.f398912l = textView5;
        this.f398913m = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f398901a;
    }

    public static ar e(View view) {
        int i3 = R.id.f163288pb1;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f163288pb1);
        if (uRLImageView != null) {
            i3 = R.id.pgq;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pgq);
            if (textView != null) {
                i3 = R.id.q0o;
                RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.q0o);
                if (roundCornerImageView != null) {
                    i3 = R.id.q0r;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q0r);
                    if (imageView != null) {
                        i3 = R.id.q0u;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.q0u);
                        if (findChildViewById != null) {
                            i3 = R.id.f163421q14;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163421q14);
                            if (imageView2 != null) {
                                i3 = R.id.q5i;
                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.q5i);
                                if (findChildViewById2 != null) {
                                    i3 = R.id.qup;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qup);
                                    if (textView2 != null) {
                                        i3 = R.id.qur;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qur);
                                        if (textView3 != null) {
                                            i3 = R.id.quv;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.quv);
                                            if (textView4 != null) {
                                                i3 = R.id.quw;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.quw);
                                                if (textView5 != null) {
                                                    i3 = R.id.qvr;
                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qvr);
                                                    if (frameLayout != null) {
                                                        return new ar(view, uRLImageView, textView, roundCornerImageView, imageView, findChildViewById, imageView2, findChildViewById2, textView2, textView3, textView4, textView5, frameLayout);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ar f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dav, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
