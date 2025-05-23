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
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399245a;

    /* renamed from: b, reason: collision with root package name */
    public final CircleBoarderImageView f399246b;

    /* renamed from: c, reason: collision with root package name */
    public final CircleBoarderImageView f399247c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399248d;

    d(LinearLayout linearLayout, CircleBoarderImageView circleBoarderImageView, CircleBoarderImageView circleBoarderImageView2, TextView textView) {
        this.f399245a = linearLayout;
        this.f399246b = circleBoarderImageView;
        this.f399247c = circleBoarderImageView2;
        this.f399248d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399245a;
    }

    public static d g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static d e(View view) {
        int i3 = R.id.pbe;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) ViewBindings.findChildViewById(view, R.id.pbe);
        if (circleBoarderImageView != null) {
            i3 = R.id.pbf;
            CircleBoarderImageView circleBoarderImageView2 = (CircleBoarderImageView) ViewBindings.findChildViewById(view, R.id.pbf);
            if (circleBoarderImageView2 != null) {
                i3 = R.id.f163556qr4;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163556qr4);
                if (textView != null) {
                    return new d((LinearLayout) view, circleBoarderImageView, circleBoarderImageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static d h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d49, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
