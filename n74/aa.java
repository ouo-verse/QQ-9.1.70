package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aa implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f418582a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f418583b;

    aa(LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.f418582a = linearLayout;
        this.f418583b = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f418582a;
    }

    public static aa g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static aa e(View view) {
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.plw);
        if (linearLayout != null) {
            return new aa((LinearLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.plw)));
    }

    public static aa h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_o, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
