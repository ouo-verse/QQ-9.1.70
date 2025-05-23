package nr2;

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
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class af implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f420798a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420799b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f420800c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f420801d;

    af(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f420798a = linearLayout;
        this.f420799b = textView;
        this.f420800c = imageView;
        this.f420801d = textView2;
    }

    @NonNull
    public static af e(@NonNull View view) {
        int i3 = R.id.aek;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.aek);
        if (textView != null) {
            i3 = R.id.icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
            if (imageView != null) {
                i3 = R.id.jm8;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.jm8);
                if (textView2 != null) {
                    return new af((LinearLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static af g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hv_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f420798a;
    }
}
