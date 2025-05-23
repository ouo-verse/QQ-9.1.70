package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareOperateLikeViewBinding implements ViewBinding {
    public final LinearLayout dog;
    public final LinearLayout eye;
    public final LinearLayout good;
    public final LinearLayout heart;
    private final LinearLayout rootView;
    public final LinearLayout solute;

    VasSquareOperateLikeViewBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6) {
        this.rootView = linearLayout;
        this.dog = linearLayout2;
        this.eye = linearLayout3;
        this.good = linearLayout4;
        this.heart = linearLayout5;
        this.solute = linearLayout6;
    }

    public static VasSquareOperateLikeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareOperateLikeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6j, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareOperateLikeViewBinding bind(View view) {
        int i3 = R.id.pq6;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pq6);
        if (linearLayout != null) {
            i3 = R.id.ptc;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ptc);
            if (linearLayout2 != null) {
                i3 = R.id.px9;
                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.px9);
                if (linearLayout3 != null) {
                    i3 = R.id.pz6;
                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.pz6);
                    if (linearLayout4 != null) {
                        i3 = R.id.qmm;
                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.qmm);
                        if (linearLayout5 != null) {
                            return new VasSquareOperateLikeViewBinding((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
