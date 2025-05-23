package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.widget.bubble.ZPlanBubbleView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bu implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418934a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f418935b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanBubbleView f418936c;

    bu(View view, LinearLayout linearLayout, ZPlanBubbleView zPlanBubbleView) {
        this.f418934a = view;
        this.f418935b = linearLayout;
        this.f418936c = zPlanBubbleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418934a;
    }

    public static bu e(View view) {
        int i3 = R.id.pgw;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pgw);
        if (linearLayout != null) {
            i3 = R.id.ph7;
            ZPlanBubbleView zPlanBubbleView = (ZPlanBubbleView) ViewBindings.findChildViewById(view, R.id.ph7);
            if (zPlanBubbleView != null) {
                return new bu(view, linearLayout, zPlanBubbleView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bu f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167455de4, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
