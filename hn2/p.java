package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f405402a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f405403b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405404c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405405d;

    p(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout) {
        this.f405402a = frameLayout;
        this.f405403b = imageView;
        this.f405404c = textView;
        this.f405405d = constraintLayout;
    }

    @NonNull
    public static p e(@NonNull View view) {
        int i3 = R.id.f763941j;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f763941j);
        if (imageView != null) {
            i3 = R.id.f764141l;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f764141l);
            if (textView != null) {
                i3 = R.id.f764441o;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.f764441o);
                if (constraintLayout != null) {
                    return new p((FrameLayout) view, imageView, textView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static p g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hp_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f405402a;
    }
}
