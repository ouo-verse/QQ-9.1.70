package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.portal.aigc.view.AigcWatermarkView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class al implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f398837a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f398838b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f398839c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f398840d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f398841e;

    /* renamed from: f, reason: collision with root package name */
    public final AigcWatermarkView f398842f;

    al(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, RelativeLayout relativeLayout, FrameLayout frameLayout, AigcWatermarkView aigcWatermarkView) {
        this.f398837a = constraintLayout;
        this.f398838b = constraintLayout2;
        this.f398839c = textView;
        this.f398840d = relativeLayout;
        this.f398841e = frameLayout;
        this.f398842f = aigcWatermarkView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f398837a;
    }

    public static al e(View view) {
        int i3 = R.id.qr6;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.qr6);
        if (constraintLayout != null) {
            i3 = R.id.qrg;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qrg);
            if (textView != null) {
                i3 = R.id.r2s;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.r2s);
                if (relativeLayout != null) {
                    i3 = R.id.r2t;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.r2t);
                    if (frameLayout != null) {
                        i3 = R.id.r2u;
                        AigcWatermarkView aigcWatermarkView = (AigcWatermarkView) ViewBindings.findChildViewById(view, R.id.r2u);
                        if (aigcWatermarkView != null) {
                            return new al((ConstraintLayout) view, constraintLayout, textView, relativeLayout, frameLayout, aigcWatermarkView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static al g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d9t, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
