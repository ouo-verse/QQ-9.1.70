package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419372a;

    /* renamed from: b, reason: collision with root package name */
    public final NativePanelLoadingIgv f419373b;

    m(View view, NativePanelLoadingIgv nativePanelLoadingIgv) {
        this.f419372a = view;
        this.f419373b = nativePanelLoadingIgv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419372a;
    }

    public static m e(View view) {
        NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.q65);
        if (nativePanelLoadingIgv != null) {
            return new m(view, nativePanelLoadingIgv);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.q65)));
    }

    public static m f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d_7, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
