package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f399434a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f399435b;

    /* renamed from: c, reason: collision with root package name */
    public final View f399436c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f399437d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399438e;

    y(View view, TextView textView, View view2, FrameLayout frameLayout, TextView textView2) {
        this.f399434a = view;
        this.f399435b = textView;
        this.f399436c = view2;
        this.f399437d = frameLayout;
        this.f399438e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f399434a;
    }

    public static y e(View view) {
        int i3 = R.id.r4g;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r4g);
        if (textView != null) {
            i3 = R.id.r4h;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.r4h);
            if (findChildViewById != null) {
                i3 = R.id.r4i;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.r4i);
                if (frameLayout != null) {
                    i3 = R.id.r4l;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.r4l);
                    if (textView2 != null) {
                        return new y(view, textView, findChildViewById, frameLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static y f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d8c, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
