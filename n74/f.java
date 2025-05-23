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
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419333a;

    /* renamed from: b, reason: collision with root package name */
    public final View f419334b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f419335c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419336d;

    f(View view, View view2, ImageView imageView, TextView textView) {
        this.f419333a = view;
        this.f419334b = view2;
        this.f419335c = imageView;
        this.f419336d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419333a;
    }

    public static f e(View view) {
        int i3 = R.id.prs;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.prs);
        if (findChildViewById != null) {
            i3 = R.id.q1o;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q1o);
            if (imageView != null) {
                i3 = R.id.qtq;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qtq);
                if (textView != null) {
                    return new f(view, findChildViewById, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static f f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d8e, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
