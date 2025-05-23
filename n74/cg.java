package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceTabView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cg implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419006a;

    /* renamed from: b, reason: collision with root package name */
    public final MakeFaceTabView f419007b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419008c;

    cg(View view, MakeFaceTabView makeFaceTabView, TextView textView) {
        this.f419006a = view;
        this.f419007b = makeFaceTabView;
        this.f419008c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419006a;
    }

    public static cg e(View view) {
        int i3 = R.id.ptk;
        MakeFaceTabView makeFaceTabView = (MakeFaceTabView) ViewBindings.findChildViewById(view, R.id.ptk);
        if (makeFaceTabView != null) {
            i3 = R.id.qj5;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qj5);
            if (textView != null) {
                return new cg(view, makeFaceTabView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cg f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dei, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
