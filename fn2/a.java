package fn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f400105a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f400106b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f400107c;

    a(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull ImageView imageView) {
        this.f400105a = relativeLayout;
        this.f400106b = view;
        this.f400107c = imageView;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.t16;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.t16);
        if (findChildViewById != null) {
            i3 = R.id.f763141b;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f763141b);
            if (imageView != null) {
                return new a((RelativeLayout) view, findChildViewById, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168854h22, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f400105a;
    }
}
