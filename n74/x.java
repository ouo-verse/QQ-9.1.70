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

/* compiled from: P */
/* loaded from: classes38.dex */
public final class x implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419462a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f419463b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f419464c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419465d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f419466e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f419467f;

    x(View view, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, TextView textView2) {
        this.f419462a = view;
        this.f419463b = linearLayout;
        this.f419464c = linearLayout2;
        this.f419465d = textView;
        this.f419466e = linearLayout3;
        this.f419467f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419462a;
    }

    public static x e(View view) {
        int i3 = R.id.pzn;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pzn);
        if (linearLayout != null) {
            i3 = R.id.qlm;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qlm);
            if (linearLayout2 != null) {
                i3 = R.id.qln;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qln);
                if (textView != null) {
                    i3 = R.id.qlo;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qlo);
                    if (linearLayout3 != null) {
                        i3 = R.id.qlp;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qlp);
                        if (textView2 != null) {
                            return new x(view, linearLayout, linearLayout2, textView, linearLayout3, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static x f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d_l, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
