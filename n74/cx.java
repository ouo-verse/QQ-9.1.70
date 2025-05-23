package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cx implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f419182a;

    /* renamed from: b, reason: collision with root package name */
    public final bi f419183b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419184c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419185d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f419186e;

    cx(ConstraintLayout constraintLayout, bi biVar, TextView textView, TextView textView2, TextView textView3) {
        this.f419182a = constraintLayout;
        this.f419183b = biVar;
        this.f419184c = textView;
        this.f419185d = textView2;
        this.f419186e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f419182a;
    }

    public static cx e(View view) {
        int i3 = R.id.pxe;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pxe);
        if (findChildViewById != null) {
            bi e16 = bi.e(findChildViewById);
            i3 = R.id.pxk;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pxk);
            if (textView != null) {
                i3 = R.id.pxo;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pxo);
                if (textView2 != null) {
                    i3 = R.id.qrh;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qrh);
                    if (textView3 != null) {
                        return new cx((ConstraintLayout) view, e16, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cx g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dfa, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
