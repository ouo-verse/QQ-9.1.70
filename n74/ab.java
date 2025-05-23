package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ab implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418584a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f418585b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f418586c;

    ab(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout) {
        this.f418584a = frameLayout;
        this.f418585b = frameLayout2;
        this.f418586c = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418584a;
    }

    public static ab e(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.prt);
        if (linearLayout != null) {
            return new ab(frameLayout, frameLayout, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.prt)));
    }

    public static ab g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ab h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_p, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
