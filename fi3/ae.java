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
public final class ae implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f398801a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f398802b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f398803c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f398804d;

    ae(View view, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.f398801a = view;
        this.f398802b = frameLayout;
        this.f398803c = frameLayout2;
        this.f398804d = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f398801a;
    }

    public static ae e(View view) {
        int i3 = R.id.plx;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.plx);
        if (frameLayout != null) {
            i3 = R.id.ply;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.ply);
            if (frameLayout2 != null) {
                i3 = R.id.plz;
                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.plz);
                if (frameLayout3 != null) {
                    return new ae(view, frameLayout, frameLayout2, frameLayout3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ae f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d9e, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
