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
public final class cw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f419176a;

    /* renamed from: b, reason: collision with root package name */
    public final bh f419177b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419178c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f419179d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f419180e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f419181f;

    cw(ConstraintLayout constraintLayout, bh bhVar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f419176a = constraintLayout;
        this.f419177b = bhVar;
        this.f419178c = textView;
        this.f419179d = textView2;
        this.f419180e = textView3;
        this.f419181f = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f419176a;
    }

    public static cw e(View view) {
        int i3 = R.id.pxe;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pxe);
        if (findChildViewById != null) {
            bh e16 = bh.e(findChildViewById);
            i3 = R.id.pxk;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pxk);
            if (textView != null) {
                i3 = R.id.pxo;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pxo);
                if (textView2 != null) {
                    i3 = R.id.qrh;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qrh);
                    if (textView3 != null) {
                        i3 = R.id.qys;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qys);
                        if (textView4 != null) {
                            return new cw((ConstraintLayout) view, e16, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cw g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.df_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
