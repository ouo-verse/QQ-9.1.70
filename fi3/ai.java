package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ai implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f398816a;

    /* renamed from: b, reason: collision with root package name */
    public final View f398817b;

    /* renamed from: c, reason: collision with root package name */
    public final View f398818c;

    /* renamed from: d, reason: collision with root package name */
    public final View f398819d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f398820e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f398821f;

    ai(View view, View view2, View view3, View view4, TextView textView, TextView textView2) {
        this.f398816a = view;
        this.f398817b = view2;
        this.f398818c = view3;
        this.f398819d = view4;
        this.f398820e = textView;
        this.f398821f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f398816a;
    }

    public static ai e(View view) {
        int i3 = R.id.r26;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.r26);
        if (findChildViewById != null) {
            i3 = R.id.r28;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.r28);
            if (findChildViewById2 != null) {
                i3 = R.id.r2b;
                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.r2b);
                if (findChildViewById3 != null) {
                    i3 = R.id.r2d;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r2d);
                    if (textView != null) {
                        i3 = R.id.r2e;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.r2e);
                        if (textView2 != null) {
                            return new ai(view, findChildViewById, findChildViewById2, findChildViewById3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ai f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d9k, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
