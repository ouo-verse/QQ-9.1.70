package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class dc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419204a;

    /* renamed from: b, reason: collision with root package name */
    public final URLImageView f419205b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanMediaView f419206c;

    /* renamed from: d, reason: collision with root package name */
    public final ZPlanPAGView f419207d;

    /* renamed from: e, reason: collision with root package name */
    public final Space f419208e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f419209f;

    dc(View view, URLImageView uRLImageView, ZPlanMediaView zPlanMediaView, ZPlanPAGView zPlanPAGView, Space space, TextView textView) {
        this.f419204a = view;
        this.f419205b = uRLImageView;
        this.f419206c = zPlanMediaView;
        this.f419207d = zPlanPAGView;
        this.f419208e = space;
        this.f419209f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f419204a;
    }

    public static dc e(View view) {
        int i3 = R.id.q0d;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.q0d);
        if (uRLImageView != null) {
            i3 = R.id.qiv;
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.qiv);
            if (zPlanMediaView != null) {
                i3 = R.id.qp_;
                ZPlanPAGView zPlanPAGView = (ZPlanPAGView) ViewBindings.findChildViewById(view, R.id.qp_);
                if (zPlanPAGView != null) {
                    i3 = R.id.qs6;
                    Space space = (Space) ViewBindings.findChildViewById(view, R.id.qs6);
                    if (space != null) {
                        i3 = R.id.qux;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qux);
                        if (textView != null) {
                            return new dc(view, uRLImageView, zPlanMediaView, zPlanPAGView, space, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static dc f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dgh, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
