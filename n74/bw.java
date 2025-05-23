package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418941a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f418942b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f418943c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418944d;

    bw(View view, LinearLayout linearLayout, ImageView imageView, ImageView imageView2) {
        this.f418941a = view;
        this.f418942b = linearLayout;
        this.f418943c = imageView;
        this.f418944d = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418941a;
    }

    public static bw e(View view) {
        int i3 = R.id.pzn;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pzn);
        if (linearLayout != null) {
            i3 = R.id.q4f;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q4f);
            if (imageView != null) {
                i3 = R.id.q_f;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q_f);
                if (imageView2 != null) {
                    return new bw(view, linearLayout, imageView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bw f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.de6, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
