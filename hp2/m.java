package hp2;

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
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405695a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405696b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f405697c;

    m(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f405695a = linearLayout;
        this.f405696b = textView;
        this.f405697c = imageView;
    }

    @NonNull
    public static m e(@NonNull View view) {
        int i3 = R.id.u8m;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.u8m);
        if (textView != null) {
            i3 = R.id.imo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imo);
            if (imageView != null) {
                return new m((LinearLayout) view, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static m g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168332fo3, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405695a;
    }
}
