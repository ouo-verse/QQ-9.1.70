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

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ce implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419000a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f419001b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f419002c;

    ce(View view, TextView textView, ImageView imageView) {
        this.f419000a = view;
        this.f419001b = textView;
        this.f419002c = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419000a;
    }

    public static ce e(View view) {
        int i3 = R.id.pho;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pho);
        if (textView != null) {
            i3 = R.id.qj6;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qj6);
            if (imageView != null) {
                return new ce(view, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ce f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.deg, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
