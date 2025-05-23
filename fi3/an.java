package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class an implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f398864a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f398865b;

    an(View view, FrameLayout frameLayout) {
        this.f398864a = view;
        this.f398865b = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f398864a;
    }

    public static an e(View view) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qmi);
        if (frameLayout != null) {
            return new an(view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qmi)));
    }

    public static an f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.da_, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
