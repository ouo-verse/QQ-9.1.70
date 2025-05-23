package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.qbasealbum.view.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f425768a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f425769b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f425770c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f425771d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f425772e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f425773f;

    k(@NonNull LinearLayout linearLayout, @NonNull QUIButton qUIButton, @NonNull RoundCornerImageView roundCornerImageView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f425768a = linearLayout;
        this.f425769b = qUIButton;
        this.f425770c = roundCornerImageView;
        this.f425771d = imageView;
        this.f425772e = textView;
        this.f425773f = textView2;
    }

    @NonNull
    public static k e(@NonNull View view) {
        int i3 = R.id.tcq;
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.tcq);
        if (qUIButton != null) {
            i3 = R.id.y4u;
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.y4u);
            if (roundCornerImageView != null) {
                i3 = R.id.f28730jq;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f28730jq);
                if (imageView != null) {
                    i3 = R.id.title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (textView != null) {
                        i3 = R.id.f110866jo;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f110866jo);
                        if (textView2 != null) {
                            return new k((LinearLayout) view, qUIButton, roundCornerImageView, imageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static k g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static k h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dz9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f425768a;
    }
}
