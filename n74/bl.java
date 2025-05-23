package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bl implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418853a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418854b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f418855c;

    bl(FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout) {
        this.f418853a = frameLayout;
        this.f418854b = imageView;
        this.f418855c = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418853a;
    }

    public static bl e(View view) {
        int i3 = R.id.pzy;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pzy);
        if (imageView != null) {
            i3 = R.id.qp8;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qp8);
            if (linearLayout != null) {
                return new bl((FrameLayout) view, imageView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bl g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dcy, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
