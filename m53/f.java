package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qui.profileskin.widget.QUIImageButton;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f416226a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f416227b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIImageButton f416228c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageButton f416229d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f416230e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ProgressBar f416231f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f416232g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f416233h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final QUITextView f416234i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f416235j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f416236k;

    f(@NonNull LinearLayout linearLayout, @NonNull QUIButton qUIButton, @NonNull QUIImageButton qUIImageButton, @NonNull ImageButton imageButton, @NonNull RoundCornerImageView roundCornerImageView, @NonNull ProgressBar progressBar, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull QUITextView qUITextView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f416226a = linearLayout;
        this.f416227b = qUIButton;
        this.f416228c = qUIImageButton;
        this.f416229d = imageButton;
        this.f416230e = roundCornerImageView;
        this.f416231f = progressBar;
        this.f416232g = linearLayout2;
        this.f416233h = relativeLayout;
        this.f416234i = qUITextView;
        this.f416235j = textView;
        this.f416236k = textView2;
    }

    @NonNull
    public static f e(@NonNull View view) {
        int i3 = R.id.agu;
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.agu);
        if (qUIButton != null) {
            i3 = R.id.xcj;
            QUIImageButton qUIImageButton = (QUIImageButton) ViewBindings.findChildViewById(view, R.id.xcj);
            if (qUIImageButton != null) {
                i3 = R.id.xck;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.xck);
                if (imageButton != null) {
                    i3 = R.id.f165929y35;
                    RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.f165929y35);
                    if (roundCornerImageView != null) {
                        i3 = R.id.f234906k;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.f234906k);
                        if (progressBar != null) {
                            i3 = R.id.g1v;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.g1v);
                            if (linearLayout != null) {
                                i3 = R.id.title_container;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.title_container);
                                if (relativeLayout != null) {
                                    i3 = R.id.tv_name;
                                    QUITextView qUITextView = (QUITextView) ViewBindings.findChildViewById(view, R.id.tv_name);
                                    if (qUITextView != null) {
                                        i3 = R.id.f110116hn;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f110116hn);
                                        if (textView != null) {
                                            i3 = R.id.kbs;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
                                            if (textView2 != null) {
                                                return new f((LinearLayout) view, qUIButton, qUIImageButton, imageButton, roundCornerImageView, progressBar, linearLayout, relativeLayout, qUITextView, textView, textView2);
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
    public static f g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e_l, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f416226a;
    }
}
