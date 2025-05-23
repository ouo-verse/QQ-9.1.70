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
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f425721a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f425722b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f425723c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f425724d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f425725e;

    d(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f425721a = constraintLayout;
        this.f425722b = imageView;
        this.f425723c = textView;
        this.f425724d = textView2;
        this.f425725e = textView3;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
        if (imageView != null) {
            i3 = R.id.f71393o1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f71393o1);
            if (textView != null) {
                i3 = R.id.f71553og;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f71553og);
                if (textView2 != null) {
                    i3 = R.id.it6;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.it6);
                    if (textView3 != null) {
                        return new d((ConstraintLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dug, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f425721a;
    }
}
