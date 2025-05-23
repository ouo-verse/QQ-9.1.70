package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421063a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f421064b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421065c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f421066d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f421067e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f421068f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f421069g;

    i(@NonNull View view, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull FrameLayout frameLayout, @NonNull View view2, @NonNull TextView textView3) {
        this.f421063a = view;
        this.f421064b = textView;
        this.f421065c = linearLayout;
        this.f421066d = textView2;
        this.f421067e = frameLayout;
        this.f421068f = view2;
        this.f421069g = textView3;
    }

    @NonNull
    public static i e(@NonNull View view) {
        int i3 = R.id.u2l;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.u2l);
        if (textView != null) {
            i3 = R.id.yrp;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yrp);
            if (linearLayout != null) {
                i3 = R.id.yrr;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.yrr);
                if (textView2 != null) {
                    i3 = R.id.loading_layout;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loading_layout);
                    if (frameLayout != null) {
                        i3 = R.id.enc;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.enc);
                        if (findChildViewById != null) {
                            i3 = R.id.i9b;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.i9b);
                            if (textView3 != null) {
                                return new i(view, textView, linearLayout, textView2, frameLayout, findChildViewById, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static i f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f169111ht1, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421063a;
    }
}
