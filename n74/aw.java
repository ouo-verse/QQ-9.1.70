package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418760a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418761b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f418762c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418763d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f418764e;

    aw(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, ImageView imageView2, RelativeLayout relativeLayout3) {
        this.f418760a = relativeLayout;
        this.f418761b = imageView;
        this.f418762c = relativeLayout2;
        this.f418763d = imageView2;
        this.f418764e = relativeLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f418760a;
    }

    public static aw g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static aw e(View view) {
        int i3 = R.id.pd6;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pd6);
        if (imageView != null) {
            i3 = R.id.pd7;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pd7);
            if (relativeLayout != null) {
                i3 = R.id.qdu;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qdu);
                if (imageView2 != null) {
                    i3 = R.id.qdw;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qdw);
                    if (relativeLayout2 != null) {
                        return new aw((RelativeLayout) view, imageView, relativeLayout, imageView2, relativeLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static aw h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
