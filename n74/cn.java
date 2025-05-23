package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cn implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419040a;

    /* renamed from: b, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419041b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f419042c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f419043d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f419044e;

    cn(View view, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.f419040a = view;
        this.f419041b = zplanExcludeFontPaddingTextView;
        this.f419042c = linearLayout;
        this.f419043d = linearLayout2;
        this.f419044e = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419040a;
    }

    public static cn e(View view) {
        int i3 = R.id.pgs;
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.pgs);
        if (zplanExcludeFontPaddingTextView != null) {
            i3 = R.id.f163345pm4;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163345pm4);
            if (linearLayout != null) {
                i3 = R.id.pm5;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pm5);
                if (linearLayout2 != null) {
                    i3 = R.id.q0c;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q0c);
                    if (linearLayout3 != null) {
                        return new cn(view, zplanExcludeFontPaddingTextView, linearLayout, linearLayout2, linearLayout3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cn f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dev, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
