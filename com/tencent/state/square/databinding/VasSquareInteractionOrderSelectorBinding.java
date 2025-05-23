package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareInteractionOrderSelectorBinding implements ViewBinding {
    public final SquareImageView hintImgView;
    private final LinearLayout rootView;
    public final TextView titleView;

    VasSquareInteractionOrderSelectorBinding(LinearLayout linearLayout, SquareImageView squareImageView, TextView textView) {
        this.rootView = linearLayout;
        this.hintImgView = squareImageView;
        this.titleView = textView;
    }

    public static VasSquareInteractionOrderSelectorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareInteractionOrderSelectorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167406d51, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareInteractionOrderSelectorBinding bind(View view) {
        int i3 = R.id.pzg;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pzg);
        if (squareImageView != null) {
            i3 = R.id.qrk;
            TextView textView = (TextView) view.findViewById(R.id.qrk);
            if (textView != null) {
                return new VasSquareInteractionOrderSelectorBinding((LinearLayout) view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
