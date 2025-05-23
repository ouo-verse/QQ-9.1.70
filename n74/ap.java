package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ap implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418684a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f418685b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanMediaView f418686c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f418687d;

    ap(View view, LinearLayout linearLayout, ZPlanMediaView zPlanMediaView, TextView textView) {
        this.f418684a = view;
        this.f418685b = linearLayout;
        this.f418686c = zPlanMediaView;
        this.f418687d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418684a;
    }

    public static ap e(View view) {
        int i3 = R.id.pgw;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pgw);
        if (linearLayout != null) {
            i3 = R.id.f163317ph1;
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.f163317ph1);
            if (zPlanMediaView != null) {
                i3 = R.id.ph6;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ph6);
                if (textView != null) {
                    return new ap(view, linearLayout, zPlanMediaView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ap f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dao, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
