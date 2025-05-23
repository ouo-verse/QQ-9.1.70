package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f398822a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f398823b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f398824c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f398825d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f398826e;

    aj(FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, RelativeLayout relativeLayout) {
        this.f398822a = frameLayout;
        this.f398823b = linearLayout;
        this.f398824c = frameLayout2;
        this.f398825d = frameLayout3;
        this.f398826e = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f398822a;
    }

    public static aj e(View view) {
        int i3 = R.id.r27;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.r27);
        if (linearLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i3 = R.id.r2_;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.r2_);
            if (frameLayout2 != null) {
                i3 = R.id.r2a;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.r2a);
                if (relativeLayout != null) {
                    return new aj(frameLayout, linearLayout, frameLayout, frameLayout2, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static aj g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d9l, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
