package hp2;

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
/* loaded from: classes18.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405665a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f405666b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405667c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405668d;

    h(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f405665a = constraintLayout;
        this.f405666b = imageView;
        this.f405667c = textView;
        this.f405668d = textView2;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.tvd;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.tvd);
        if (imageView != null) {
            i3 = R.id.bg6;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bg6);
            if (textView != null) {
                i3 = R.id.title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                if (textView2 != null) {
                    return new h((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static h g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fnx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405665a;
    }
}
