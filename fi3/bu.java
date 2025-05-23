package fi3;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bu implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399153a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399154b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399155c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399156d;

    /* renamed from: e, reason: collision with root package name */
    public final RoundCornerImageView f399157e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f399158f;

    /* renamed from: g, reason: collision with root package name */
    public final RoundCornerImageView f399159g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f399160h;

    /* renamed from: i, reason: collision with root package name */
    public final RoundCornerImageView f399161i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f399162j;

    /* renamed from: k, reason: collision with root package name */
    public final View f399163k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f399164l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f399165m;

    bu(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RoundCornerImageView roundCornerImageView, ImageView imageView4, RoundCornerImageView roundCornerImageView2, TextView textView, RoundCornerImageView roundCornerImageView3, LinearLayout linearLayout2, View view, TextView textView2, TextView textView3) {
        this.f399153a = linearLayout;
        this.f399154b = imageView;
        this.f399155c = imageView2;
        this.f399156d = imageView3;
        this.f399157e = roundCornerImageView;
        this.f399158f = imageView4;
        this.f399159g = roundCornerImageView2;
        this.f399160h = textView;
        this.f399161i = roundCornerImageView3;
        this.f399162j = linearLayout2;
        this.f399163k = view;
        this.f399164l = textView2;
        this.f399165m = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399153a;
    }

    public static bu e(View view) {
        int i3 = R.id.p_b;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p_b);
        if (imageView != null) {
            i3 = R.id.pjn;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pjn);
            if (imageView2 != null) {
                i3 = R.id.pjo;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pjo);
                if (imageView3 != null) {
                    i3 = R.id.pms;
                    RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.pms);
                    if (roundCornerImageView != null) {
                        i3 = R.id.pmv;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.pmv);
                        if (imageView4 != null) {
                            i3 = R.id.f163351po0;
                            RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.f163351po0);
                            if (roundCornerImageView2 != null) {
                                i3 = R.id.f163352po1;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163352po1);
                                if (textView != null) {
                                    i3 = R.id.poo;
                                    RoundCornerImageView roundCornerImageView3 = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.poo);
                                    if (roundCornerImageView3 != null) {
                                        LinearLayout linearLayout = (LinearLayout) view;
                                        i3 = R.id.qcw;
                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.qcw);
                                        if (findChildViewById != null) {
                                            i3 = R.id.qoa;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qoa);
                                            if (textView2 != null) {
                                                i3 = R.id.qve;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qve);
                                                if (textView3 != null) {
                                                    return new bu(linearLayout, imageView, imageView2, imageView3, roundCornerImageView, imageView4, roundCornerImageView2, textView, roundCornerImageView3, linearLayout, findChildViewById, textView2, textView3);
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
}
