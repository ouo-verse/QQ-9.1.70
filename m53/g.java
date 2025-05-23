package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f416237a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f416238b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f416239c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f416240d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f416241e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f416242f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f416243g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f416244h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f416245i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f416246j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f416247k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f416248l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final View f416249m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f416250n;

    g(@NonNull ConstraintLayout constraintLayout, @NonNull QUIButton qUIButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull View view4) {
        this.f416237a = constraintLayout;
        this.f416238b = qUIButton;
        this.f416239c = textView;
        this.f416240d = textView2;
        this.f416241e = textView3;
        this.f416242f = textView4;
        this.f416243g = textView5;
        this.f416244h = textView6;
        this.f416245i = textView7;
        this.f416246j = textView8;
        this.f416247k = view;
        this.f416248l = view2;
        this.f416249m = view3;
        this.f416250n = view4;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.tbw;
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.tbw);
        if (qUIButton != null) {
            i3 = R.id.f97785lb;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f97785lb);
            if (textView != null) {
                i3 = R.id.f1051665_;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f1051665_);
                if (textView2 != null) {
                    i3 = R.id.f1051765a;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f1051765a);
                    if (textView3 != null) {
                        i3 = R.id.f1053765u;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f1053765u);
                        if (textView4 != null) {
                            i3 = R.id.f1053865v;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f1053865v);
                            if (textView5 != null) {
                                i3 = R.id.f10547664;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f10547664);
                                if (textView6 != null) {
                                    i3 = R.id.f10548665;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f10548665);
                                    if (textView7 != null) {
                                        i3 = R.id.f1057066q;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.f1057066q);
                                        if (textView8 != null) {
                                            i3 = R.id.f115896x_;
                                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f115896x_);
                                            if (findChildViewById != null) {
                                                i3 = R.id.f115906xa;
                                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f115906xa);
                                                if (findChildViewById2 != null) {
                                                    i3 = R.id.f115966xg;
                                                    View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.f115966xg);
                                                    if (findChildViewById3 != null) {
                                                        i3 = R.id.f115976xh;
                                                        View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.f115976xh);
                                                        if (findChildViewById4 != null) {
                                                            return new g((ConstraintLayout) view, qUIButton, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static g g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static g h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e_m, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f416237a;
    }
}
