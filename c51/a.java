package c51;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f30332a;

    /* renamed from: b, reason: collision with root package name */
    public final PAGViewDelegate f30333b;

    /* renamed from: c, reason: collision with root package name */
    public final QUIPolarLightView f30334c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f30335d;

    a(ConstraintLayout constraintLayout, PAGViewDelegate pAGViewDelegate, QUIPolarLightView qUIPolarLightView, TextView textView) {
        this.f30332a = constraintLayout;
        this.f30333b = pAGViewDelegate;
        this.f30334c = qUIPolarLightView;
        this.f30335d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f30332a;
    }

    public static a e(View view) {
        int i3 = R.id.f163139oi3;
        PAGViewDelegate pAGViewDelegate = (PAGViewDelegate) ViewBindings.findChildViewById(view, R.id.f163139oi3);
        if (pAGViewDelegate != null) {
            i3 = R.id.f163162on1;
            QUIPolarLightView qUIPolarLightView = (QUIPolarLightView) ViewBindings.findChildViewById(view, R.id.f163162on1);
            if (qUIPolarLightView != null) {
                i3 = R.id.oqp;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.oqp);
                if (textView != null) {
                    return new a((ConstraintLayout) view, pAGViewDelegate, qUIPolarLightView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static a g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.cwp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
