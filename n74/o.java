package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.view.widget.CurrencyView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419383a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419384b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419385c;

    /* renamed from: d, reason: collision with root package name */
    public final CurrencyView f419386d;

    o(View view, ImageView imageView, TextView textView, CurrencyView currencyView) {
        this.f419383a = view;
        this.f419384b = imageView;
        this.f419385c = textView;
        this.f419386d = currencyView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419383a;
    }

    public static o e(View view) {
        int i3 = R.id.f163299pd3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163299pd3);
        if (imageView != null) {
            i3 = R.id.ph8;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ph8);
            if (textView != null) {
                i3 = R.id.pkn;
                CurrencyView currencyView = (CurrencyView) ViewBindings.findChildViewById(view, R.id.pkn);
                if (currencyView != null) {
                    return new o(view, imageView, textView, currencyView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static o f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d__, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
