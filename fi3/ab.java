package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.sqshow.zootopia.widget.ZootopiaRecycleView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ab implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RoundCorneredRelativeLayout f398781a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaRecycleView f398782b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundCorneredRelativeLayout f398783c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f398784d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f398785e;

    /* renamed from: f, reason: collision with root package name */
    public final RelativeLayout f398786f;

    ab(RoundCorneredRelativeLayout roundCorneredRelativeLayout, ZootopiaRecycleView zootopiaRecycleView, RoundCorneredRelativeLayout roundCorneredRelativeLayout2, TextView textView, TextView textView2, RelativeLayout relativeLayout) {
        this.f398781a = roundCorneredRelativeLayout;
        this.f398782b = zootopiaRecycleView;
        this.f398783c = roundCorneredRelativeLayout2;
        this.f398784d = textView;
        this.f398785e = textView2;
        this.f398786f = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RoundCorneredRelativeLayout getRoot() {
        return this.f398781a;
    }

    public static ab e(View view) {
        int i3 = R.id.qgp;
        ZootopiaRecycleView zootopiaRecycleView = (ZootopiaRecycleView) ViewBindings.findChildViewById(view, R.id.qgp);
        if (zootopiaRecycleView != null) {
            RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) view;
            i3 = R.id.r1i;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r1i);
            if (textView != null) {
                i3 = R.id.r1j;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.r1j);
                if (textView2 != null) {
                    i3 = R.id.f163609r20;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163609r20);
                    if (relativeLayout != null) {
                        return new ab(roundCorneredRelativeLayout, zootopiaRecycleView, roundCorneredRelativeLayout, textView, textView2, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ab g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d96, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
