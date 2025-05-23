package c51;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f30344a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f30345b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f30346c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f30347d;

    c(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        this.f30344a = linearLayout;
        this.f30345b = imageView;
        this.f30346c = linearLayout2;
        this.f30347d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f30344a;
    }

    public static c e(View view) {
        int i3 = R.id.oiu;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.oiu);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.oiw);
            if (textView != null) {
                return new c(linearLayout, imageView, linearLayout, textView);
            }
            i3 = R.id.oiw;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static c g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.cxd, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
