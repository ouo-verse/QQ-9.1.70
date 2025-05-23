package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;
import com.tencent.state.view.SquareTabLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemMayKnowBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SquareImageView squareMayKnowEntrance;
    public final SquareTabLayout squareMayKnowLabelContainer;
    public final TextView squareMayKnowReason;

    VasSquareItemMayKnowBinding(LinearLayout linearLayout, SquareImageView squareImageView, SquareTabLayout squareTabLayout, TextView textView) {
        this.rootView = linearLayout;
        this.squareMayKnowEntrance = squareImageView;
        this.squareMayKnowLabelContainer = squareTabLayout;
        this.squareMayKnowReason = textView;
    }

    public static VasSquareItemMayKnowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemMayKnowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5m, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemMayKnowBinding bind(View view) {
        int i3 = R.id.f163535qn3;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163535qn3);
        if (squareImageView != null) {
            i3 = R.id.f163536qn4;
            SquareTabLayout squareTabLayout = (SquareTabLayout) view.findViewById(R.id.f163536qn4);
            if (squareTabLayout != null) {
                i3 = R.id.qn5;
                TextView textView = (TextView) view.findViewById(R.id.qn5);
                if (textView != null) {
                    return new VasSquareItemMayKnowBinding((LinearLayout) view, squareImageView, squareTabLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
