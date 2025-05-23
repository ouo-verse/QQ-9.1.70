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
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class bf implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421018a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f421019b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f421020c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f421021d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421022e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f421023f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f421024g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final Switch f421025h;

    bf(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull View view2, @NonNull TextView textView2, @NonNull Switch r85) {
        this.f421018a = view;
        this.f421019b = textView;
        this.f421020c = imageView;
        this.f421021d = imageView2;
        this.f421022e = linearLayout;
        this.f421023f = view2;
        this.f421024g = textView2;
        this.f421025h = r85;
    }

    @NonNull
    public static bf e(@NonNull View view) {
        int i3 = R.id.sxd;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sxd);
        if (textView != null) {
            i3 = R.id.t2e;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.t2e);
            if (imageView != null) {
                i3 = R.id.tza;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.tza);
                if (imageView2 != null) {
                    i3 = R.id.u7u;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.u7u);
                    if (linearLayout != null) {
                        i3 = R.id.f84014l4;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f84014l4);
                        if (findChildViewById != null) {
                            i3 = R.id.f86474rr;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f86474rr);
                            if (textView2 != null) {
                                i3 = R.id.f911154a;
                                Switch r102 = (Switch) ViewBindings.findChildViewById(view, R.id.f911154a);
                                if (r102 != null) {
                                    return new bf(view, textView, imageView, imageView2, linearLayout, findChildViewById, textView2, r102);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bf f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hxu, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421018a;
    }
}
