package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class o implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FlexboxLayout f405399a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f405400b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405401c;

    o(@NonNull FlexboxLayout flexboxLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f405399a = flexboxLayout;
        this.f405400b = imageView;
        this.f405401c = textView;
    }

    @NonNull
    public static o e(@NonNull View view) {
        int i3 = R.id.vub;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vub);
        if (imageView != null) {
            i3 = R.id.vud;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vud);
            if (textView != null) {
                return new o((FlexboxLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static o g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hoq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout getRoot() {
        return this.f405399a;
    }
}
