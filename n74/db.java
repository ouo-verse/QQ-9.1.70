package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.ui.VasPagView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class db implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419201a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419202b;

    /* renamed from: c, reason: collision with root package name */
    public final VasPagView f419203c;

    db(FrameLayout frameLayout, ImageView imageView, VasPagView vasPagView) {
        this.f419201a = frameLayout;
        this.f419202b = imageView;
        this.f419203c = vasPagView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419201a;
    }

    public static db e(View view) {
        int i3 = R.id.qcx;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qcx);
        if (imageView != null) {
            i3 = R.id.qwi;
            VasPagView vasPagView = (VasPagView) ViewBindings.findChildViewById(view, R.id.qwi);
            if (vasPagView != null) {
                return new db((FrameLayout) view, imageView, vasPagView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static db g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dg_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
