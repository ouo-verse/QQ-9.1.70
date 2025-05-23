package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class af implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f398805a;

    /* renamed from: b, reason: collision with root package name */
    public final RoundCornerImageView f398806b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f398807c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f398808d;

    af(View view, RoundCornerImageView roundCornerImageView, TextView textView, TextView textView2) {
        this.f398805a = view;
        this.f398806b = roundCornerImageView;
        this.f398807c = textView;
        this.f398808d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f398805a;
    }

    public static af e(View view) {
        int i3 = R.id.q0i;
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.q0i);
        if (roundCornerImageView != null) {
            i3 = R.id.qus;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qus);
            if (textView != null) {
                i3 = R.id.qut;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qut);
                if (textView2 != null) {
                    return new af(view, roundCornerImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static af f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d9h, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
