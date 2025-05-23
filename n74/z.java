package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class z implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ScrollView f419473a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f419474b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f419475c;

    z(ScrollView scrollView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.f419473a = scrollView;
        this.f419474b = linearLayout;
        this.f419475c = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f419473a;
    }

    public static z g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static z e(View view) {
        int i3 = R.id.f163383pu2;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163383pu2);
        if (linearLayout != null) {
            i3 = R.id.qmn;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qmn);
            if (linearLayout2 != null) {
                return new z((ScrollView) view, linearLayout, linearLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static z h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_n, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
