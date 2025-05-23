package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f425713a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f425714b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f425715c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f425716d;

    b(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f425713a = relativeLayout;
        this.f425714b = textView;
        this.f425715c = textView2;
        this.f425716d = imageView;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.f166300zd0;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f166300zd0);
        if (textView != null) {
            i3 = R.id.f166302zd2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f166302zd2);
            if (textView2 != null) {
                i3 = R.id.f82074fw;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f82074fw);
                if (imageView != null) {
                    return new b((RelativeLayout) view, textView, textView2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.drs, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f425713a;
    }
}
