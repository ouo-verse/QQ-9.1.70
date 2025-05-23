package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419397a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f419398b;

    q(View view, LinearLayout linearLayout) {
        this.f419397a = view;
        this.f419398b = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419397a;
    }

    public static q e(View view) {
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pm6);
        if (linearLayout != null) {
            return new q(view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.pm6)));
    }

    public static q f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d_c, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
