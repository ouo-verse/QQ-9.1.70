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
public final class be implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418821a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418822b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f418823c;

    be(View view, ImageView imageView, TextView textView) {
        this.f418821a = view;
        this.f418822b = imageView;
        this.f418823c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418821a;
    }

    public static be e(View view) {
        int i3 = R.id.q0h;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q0h);
        if (imageView != null) {
            i3 = R.id.qtc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qtc);
            if (textView != null) {
                return new be(view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static be f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dbx, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
