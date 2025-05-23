package db1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f393501a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f393502b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f393503c;

    a(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull ImageView imageView) {
        this.f393501a = constraintLayout;
        this.f393502b = view;
        this.f393503c = imageView;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.byb;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.byb);
        if (findChildViewById != null) {
            i3 = R.id.y4u;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y4u);
            if (imageView != null) {
                return new a((ConstraintLayout) view, findChildViewById, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e5d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f393501a;
    }
}
