package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.profileskin.widget.QUIImageButton;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.richmedialist.view.RichMediaListView;
import com.tencent.mobileqq.widget.search.QUISearchBar;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f416211a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f416212b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f416213c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUISearchBar f416214d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RichMediaListView f416215e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final QUIImageButton f416216f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final QUIImageButton f416217g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final QUIImageButton f416218h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f416219i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final QUIButton f416220j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f416221k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f416222l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final QUITextView f416223m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final QUITextView f416224n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f416225o;

    e(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull QUISearchBar qUISearchBar, @NonNull RichMediaListView richMediaListView, @NonNull QUIImageButton qUIImageButton, @NonNull QUIImageButton qUIImageButton2, @NonNull QUIImageButton qUIImageButton3, @NonNull RelativeLayout relativeLayout2, @NonNull QUIButton qUIButton, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull QUITextView qUITextView, @NonNull QUITextView qUITextView2, @NonNull TextView textView) {
        this.f416211a = linearLayout;
        this.f416212b = frameLayout;
        this.f416213c = relativeLayout;
        this.f416214d = qUISearchBar;
        this.f416215e = richMediaListView;
        this.f416216f = qUIImageButton;
        this.f416217g = qUIImageButton2;
        this.f416218h = qUIImageButton3;
        this.f416219i = relativeLayout2;
        this.f416220j = qUIButton;
        this.f416221k = relativeLayout3;
        this.f416222l = relativeLayout4;
        this.f416223m = qUITextView;
        this.f416224n = qUITextView2;
        this.f416225o = textView;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.acl;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.acl);
        if (frameLayout != null) {
            i3 = R.id.content;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.content);
            if (relativeLayout != null) {
                i3 = R.id.v5c;
                QUISearchBar qUISearchBar = (QUISearchBar) ViewBindings.findChildViewById(view, R.id.v5c);
                if (qUISearchBar != null) {
                    i3 = R.id.vh6;
                    RichMediaListView richMediaListView = (RichMediaListView) ViewBindings.findChildViewById(view, R.id.vh6);
                    if (richMediaListView != null) {
                        i3 = R.id.xcj;
                        QUIImageButton qUIImageButton = (QUIImageButton) ViewBindings.findChildViewById(view, R.id.xcj);
                        if (qUIImageButton != null) {
                            i3 = R.id.xcm;
                            QUIImageButton qUIImageButton2 = (QUIImageButton) ViewBindings.findChildViewById(view, R.id.xcm);
                            if (qUIImageButton2 != null) {
                                i3 = R.id.xcn;
                                QUIImageButton qUIImageButton3 = (QUIImageButton) ViewBindings.findChildViewById(view, R.id.xcn);
                                if (qUIImageButton3 != null) {
                                    i3 = R.id.ye9;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ye9);
                                    if (relativeLayout2 != null) {
                                        i3 = R.id.f30480og;
                                        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f30480og);
                                        if (qUIButton != null) {
                                            i3 = R.id.title_container;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.title_container);
                                            if (relativeLayout3 != null) {
                                                i3 = R.id.f98905oc;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f98905oc);
                                                if (relativeLayout4 != null) {
                                                    i3 = R.id.f1064768t;
                                                    QUITextView qUITextView = (QUITextView) ViewBindings.findChildViewById(view, R.id.f1064768t);
                                                    if (qUITextView != null) {
                                                        i3 = R.id.f111146kf;
                                                        QUITextView qUITextView2 = (QUITextView) ViewBindings.findChildViewById(view, R.id.f111146kf);
                                                        if (qUITextView2 != null) {
                                                            i3 = R.id.kbs;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
                                                            if (textView != null) {
                                                                return new e((LinearLayout) view, frameLayout, relativeLayout, qUISearchBar, richMediaListView, qUIImageButton, qUIImageButton2, qUIImageButton3, relativeLayout2, qUIButton, relativeLayout3, relativeLayout4, qUITextView, qUITextView2, textView);
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
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e_k, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getMContainer() {
        return this.f416211a;
    }
}
