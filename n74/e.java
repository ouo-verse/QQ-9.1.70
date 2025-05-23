package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419329a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f419330b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f419331c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419332d;

    e(View view, Button button, ImageView imageView, TextView textView) {
        this.f419329a = view;
        this.f419330b = button;
        this.f419331c = imageView;
        this.f419332d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419329a;
    }

    public static e e(View view) {
        int i3 = R.id.pg_;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.pg_);
        if (button != null) {
            i3 = R.id.q47;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q47);
            if (imageView != null) {
                i3 = R.id.qtx;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qtx);
                if (textView != null) {
                    return new e(view, button, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static e f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d8d, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
