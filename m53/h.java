package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final NestedScrollView f416251a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f416252b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIButton f416253c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUIButton f416254d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUIButton f416255e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final Group f416256f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final Group f416257g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f416258h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f416259i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f416260j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f416261k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f416262l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f416263m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f416264n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f416265o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final View f416266p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final View f416267q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final View f416268r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final View f416269s;

    h(@NonNull NestedScrollView nestedScrollView, @NonNull QUIButton qUIButton, @NonNull QUIButton qUIButton2, @NonNull QUIButton qUIButton3, @NonNull QUIButton qUIButton4, @NonNull Group group, @NonNull Group group2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull View view4) {
        this.f416251a = nestedScrollView;
        this.f416252b = qUIButton;
        this.f416253c = qUIButton2;
        this.f416254d = qUIButton3;
        this.f416255e = qUIButton4;
        this.f416256f = group;
        this.f416257g = group2;
        this.f416258h = textView;
        this.f416259i = textView2;
        this.f416260j = textView3;
        this.f416261k = textView4;
        this.f416262l = textView5;
        this.f416263m = textView6;
        this.f416264n = textView7;
        this.f416265o = textView8;
        this.f416266p = view;
        this.f416267q = view2;
        this.f416268r = view3;
        this.f416269s = view4;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.tbw;
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.tbw);
        if (qUIButton != null) {
            i3 = R.id.tby;
            QUIButton qUIButton2 = (QUIButton) ViewBindings.findChildViewById(view, R.id.tby);
            if (qUIButton2 != null) {
                i3 = R.id.f164648tc4;
                QUIButton qUIButton3 = (QUIButton) ViewBindings.findChildViewById(view, R.id.f164648tc4);
                if (qUIButton3 != null) {
                    i3 = R.id.tc_;
                    QUIButton qUIButton4 = (QUIButton) ViewBindings.findChildViewById(view, R.id.tc_);
                    if (qUIButton4 != null) {
                        i3 = R.id.vh7;
                        Group group = (Group) ViewBindings.findChildViewById(view, R.id.vh7);
                        if (group != null) {
                            i3 = R.id.vh8;
                            Group group2 = (Group) ViewBindings.findChildViewById(view, R.id.vh8);
                            if (group2 != null) {
                                i3 = R.id.f10507651;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f10507651);
                                if (textView != null) {
                                    i3 = R.id.f10508652;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f10508652);
                                    if (textView2 != null) {
                                        i3 = R.id.f10509653;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f10509653);
                                        if (textView3 != null) {
                                            i3 = R.id.f1051665_;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f1051665_);
                                            if (textView4 != null) {
                                                i3 = R.id.f1051765a;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f1051765a);
                                                if (textView5 != null) {
                                                    i3 = R.id.f1053765u;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f1053765u);
                                                    if (textView6 != null) {
                                                        i3 = R.id.f1053865v;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f1053865v);
                                                        if (textView7 != null) {
                                                            i3 = R.id.f1057066q;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.f1057066q);
                                                            if (textView8 != null) {
                                                                i3 = R.id.f115876x8;
                                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f115876x8);
                                                                if (findChildViewById != null) {
                                                                    i3 = R.id.f115896x_;
                                                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f115896x_);
                                                                    if (findChildViewById2 != null) {
                                                                        i3 = R.id.f115906xa;
                                                                        View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.f115906xa);
                                                                        if (findChildViewById3 != null) {
                                                                            i3 = R.id.f115976xh;
                                                                            View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.f115976xh);
                                                                            if (findChildViewById4 != null) {
                                                                                return new h((NestedScrollView) view, qUIButton, qUIButton2, qUIButton3, qUIButton4, group, group2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static h g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static h h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e_p, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f416251a;
    }
}
