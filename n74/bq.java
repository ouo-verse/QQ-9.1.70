package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bq implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418894a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f418895b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f418896c;

    bq(View view, TextView textView, ConstraintLayout constraintLayout) {
        this.f418894a = view;
        this.f418895b = textView;
        this.f418896c = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418894a;
    }

    public static bq e(View view) {
        int i3 = R.id.ppa;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ppa);
        if (textView != null) {
            i3 = R.id.ppb;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.ppb);
            if (constraintLayout != null) {
                return new bq(view, textView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bq f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.ddu, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
