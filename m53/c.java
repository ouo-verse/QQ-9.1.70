package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.PastablePwdEditText;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final NestedScrollView f416196a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f416197b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f416198c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f416199d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f416200e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final PastablePwdEditText f416201f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f416202g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f416203h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f416204i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f416205j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f416206k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f416207l;

    c(@NonNull NestedScrollView nestedScrollView, @NonNull QUIButton qUIButton, @NonNull QUICheckBox qUICheckBox, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull PastablePwdEditText pastablePwdEditText, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull View view) {
        this.f416196a = nestedScrollView;
        this.f416197b = qUIButton;
        this.f416198c = qUICheckBox;
        this.f416199d = textView;
        this.f416200e = imageView;
        this.f416201f = pastablePwdEditText;
        this.f416202g = imageView2;
        this.f416203h = textView2;
        this.f416204i = textView3;
        this.f416205j = textView4;
        this.f416206k = textView5;
        this.f416207l = view;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.f166147yu4;
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f166147yu4);
        if (qUIButton != null) {
            i3 = R.id.yue;
            QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.yue);
            if (qUICheckBox != null) {
                i3 = R.id.yuh;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.yuh);
                if (textView != null) {
                    i3 = R.id.fis;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.fis);
                    if (imageView != null) {
                        i3 = R.id.f226504a;
                        PastablePwdEditText pastablePwdEditText = (PastablePwdEditText) ViewBindings.findChildViewById(view, R.id.f226504a);
                        if (pastablePwdEditText != null) {
                            i3 = R.id.fiu;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.fiu);
                            if (imageView2 != null) {
                                i3 = R.id.f226704c;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f226704c);
                                if (textView2 != null) {
                                    i3 = R.id.f1051665_;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f1051665_);
                                    if (textView3 != null) {
                                        i3 = R.id.f1057066q;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f1057066q);
                                        if (textView4 != null) {
                                            i3 = R.id.kbr;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.kbr);
                                            if (textView5 != null) {
                                                i3 = R.id.f115986xi;
                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f115986xi);
                                                if (findChildViewById != null) {
                                                    return new c((NestedScrollView) view, qUIButton, qUICheckBox, textView, imageView, pastablePwdEditText, imageView2, textView2, textView3, textView4, textView5, findChildViewById);
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
    public static c g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static c h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e9y, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f416196a;
    }
}
