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
public final class x implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405784a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f405785b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405786c;

    x(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f405784a = linearLayout;
        this.f405785b = imageView;
        this.f405786c = textView;
    }

    @NonNull
    public static x e(@NonNull View view) {
        int i3 = R.id.f82664hh;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f82664hh);
        if (imageView != null) {
            i3 = R.id.jfb;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jfb);
            if (textView != null) {
                return new x((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405784a;
    }
}
