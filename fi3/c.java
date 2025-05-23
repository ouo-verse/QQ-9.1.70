package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399212a;

    /* renamed from: b, reason: collision with root package name */
    public final CircleBoarderImageView f399213b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399214c;

    c(LinearLayout linearLayout, CircleBoarderImageView circleBoarderImageView, TextView textView) {
        this.f399212a = linearLayout;
        this.f399213b = circleBoarderImageView;
        this.f399214c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399212a;
    }

    public static c g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static c e(View view) {
        int i3 = R.id.pbe;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) ViewBindings.findChildViewById(view, R.id.pbe);
        if (circleBoarderImageView != null) {
            i3 = R.id.f163556qr4;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163556qr4);
            if (textView != null) {
                return new c((LinearLayout) view, circleBoarderImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static c h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d48, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
