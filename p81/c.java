package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f425717a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f425718b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f425719c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f425720d;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f425717a = constraintLayout;
        this.f425718b = imageView;
        this.f425719c = textView;
        this.f425720d = textView2;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
        if (imageView != null) {
            i3 = R.id.f26300d6;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f26300d6);
            if (textView != null) {
                i3 = R.id.i_w;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.i_w);
                if (textView2 != null) {
                    return new c((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.duf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f425717a;
    }
}
