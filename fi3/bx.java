package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bx implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399180a;

    /* renamed from: b, reason: collision with root package name */
    public final SuitPagView f399181b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f399182c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f399183d;

    /* renamed from: e, reason: collision with root package name */
    public final SuitPagView f399184e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399185f;

    bx(ConstraintLayout constraintLayout, SuitPagView suitPagView, FrameLayout frameLayout, FrameLayout frameLayout2, SuitPagView suitPagView2, TextView textView) {
        this.f399180a = constraintLayout;
        this.f399181b = suitPagView;
        this.f399182c = frameLayout;
        this.f399183d = frameLayout2;
        this.f399184e = suitPagView2;
        this.f399185f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399180a;
    }

    public static bx e(View view) {
        int i3 = R.id.qoj;
        SuitPagView suitPagView = (SuitPagView) ViewBindings.findChildViewById(view, R.id.qoj);
        if (suitPagView != null) {
            i3 = R.id.qop;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qop);
            if (frameLayout != null) {
                i3 = R.id.qoq;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qoq);
                if (frameLayout2 != null) {
                    i3 = R.id.qor;
                    SuitPagView suitPagView2 = (SuitPagView) ViewBindings.findChildViewById(view, R.id.qor);
                    if (suitPagView2 != null) {
                        i3 = R.id.qos;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qos);
                        if (textView != null) {
                            return new bx((ConstraintLayout) view, suitPagView, frameLayout, frameLayout2, suitPagView2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bx g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dfy, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
