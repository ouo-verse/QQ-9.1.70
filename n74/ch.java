package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.view.widget.PortalStoreCurrencyView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ch implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419009a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419010b;

    /* renamed from: c, reason: collision with root package name */
    public final PortalStoreCurrencyView f419011c;

    ch(View view, ImageView imageView, PortalStoreCurrencyView portalStoreCurrencyView) {
        this.f419009a = view;
        this.f419010b = imageView;
        this.f419011c = portalStoreCurrencyView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419009a;
    }

    public static ch e(View view) {
        int i3 = R.id.f163299pd3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163299pd3);
        if (imageView != null) {
            i3 = R.id.pkn;
            PortalStoreCurrencyView portalStoreCurrencyView = (PortalStoreCurrencyView) ViewBindings.findChildViewById(view, R.id.pkn);
            if (portalStoreCurrencyView != null) {
                return new ch(view, imageView, portalStoreCurrencyView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ch f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dej, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
