package hn2;

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
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405392a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405393b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405394c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f405395d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f405396e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405397f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f405398g;

    n(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull FlexboxLayout flexboxLayout, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f405392a = linearLayout;
        this.f405393b = textView;
        this.f405394c = textView2;
        this.f405395d = flexboxLayout;
        this.f405396e = imageView;
        this.f405397f = textView3;
        this.f405398g = textView4;
    }

    @NonNull
    public static n e(@NonNull View view) {
        int i3 = R.id.vua;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vua);
        if (textView != null) {
            i3 = R.id.vuc;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.vuc);
            if (textView2 != null) {
                i3 = R.id.zf9;
                FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, R.id.zf9);
                if (flexboxLayout != null) {
                    i3 = R.id.i_n;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.i_n);
                    if (imageView != null) {
                        i3 = R.id.ian;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.ian);
                        if (textView3 != null) {
                            i3 = R.id.jmp;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.jmp);
                            if (textView4 != null) {
                                return new n((LinearLayout) view, textView, textView2, flexboxLayout, imageView, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static n g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hoi, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405392a;
    }
}
