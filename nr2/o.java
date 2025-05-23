package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.remind.widget.WheelView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class o implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f421098a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f421099b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421100c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f421101d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final WheelView f421102e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f421103f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421104g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final WheelView f421105h;

    o(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2, @NonNull WheelView wheelView, @NonNull View view, @NonNull RelativeLayout relativeLayout3, @NonNull WheelView wheelView2) {
        this.f421098a = relativeLayout;
        this.f421099b = textView;
        this.f421100c = relativeLayout2;
        this.f421101d = textView2;
        this.f421102e = wheelView;
        this.f421103f = view;
        this.f421104g = relativeLayout3;
        this.f421105h = wheelView2;
    }

    @NonNull
    public static o e(@NonNull View view) {
        int i3 = R.id.tlc;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tlc);
        if (textView != null) {
            i3 = R.id.u3s;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.u3s);
            if (relativeLayout != null) {
                i3 = R.id.b7n;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.b7n);
                if (textView2 != null) {
                    i3 = R.id.v6r;
                    WheelView wheelView = (WheelView) ViewBindings.findChildViewById(view, R.id.v6r);
                    if (wheelView != null) {
                        i3 = R.id.enf;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.enf);
                        if (findChildViewById != null) {
                            RelativeLayout relativeLayout2 = (RelativeLayout) view;
                            i3 = R.id.f81634ep;
                            WheelView wheelView2 = (WheelView) ViewBindings.findChildViewById(view, R.id.f81634ep);
                            if (wheelView2 != null) {
                                return new o(relativeLayout2, textView, relativeLayout, textView2, wheelView, findChildViewById, relativeLayout2, wheelView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static o g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static o h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hte, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f421098a;
    }
}
