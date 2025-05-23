package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421035a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421036b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f421037c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f421038d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f421039e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f421040f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f421041g;

    c(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f421035a = view;
        this.f421036b = linearLayout;
        this.f421037c = imageView;
        this.f421038d = imageView2;
        this.f421039e = textView;
        this.f421040f = textView2;
        this.f421041g = textView3;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.s7s;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.s7s);
        if (linearLayout != null) {
            i3 = R.id.svq;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.svq);
            if (imageView != null) {
                i3 = R.id.x_l;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.x_l);
                if (imageView2 != null) {
                    i3 = R.id.x_n;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x_n);
                    if (textView != null) {
                        i3 = R.id.f2263049;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f2263049);
                        if (textView2 != null) {
                            i3 = R.id.f7774457;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f7774457);
                            if (textView3 != null) {
                                return new c(view, linearLayout, imageView, imageView2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hsm, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421035a;
    }
}
