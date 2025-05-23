package hp2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class aa implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405525a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f405526b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405527c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405528d;

    aa(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.f405525a = linearLayout;
        this.f405526b = imageView;
        this.f405527c = linearLayout2;
        this.f405528d = textView;
    }

    @NonNull
    public static aa e(@NonNull View view) {
        int i3 = R.id.dum;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dum);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f107036_b);
            if (textView != null) {
                return new aa(linearLayout, imageView, linearLayout, textView);
            }
            i3 = R.id.f107036_b;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405525a;
    }
}
