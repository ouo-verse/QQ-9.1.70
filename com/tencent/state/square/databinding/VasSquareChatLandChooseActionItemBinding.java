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
public final class VasSquareChatLandChooseActionItemBinding implements ViewBinding {
    public final SquareImageView actionImage;
    public final TextView actionName;
    private final LinearLayout rootView;

    VasSquareChatLandChooseActionItemBinding(LinearLayout linearLayout, SquareImageView squareImageView, TextView textView) {
        this.rootView = linearLayout;
        this.actionImage = squareImageView;
        this.actionName = textView;
    }

    public static VasSquareChatLandChooseActionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareChatLandChooseActionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3m, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandChooseActionItemBinding bind(View view) {
        int i3 = R.id.p9t;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.p9t);
        if (squareImageView != null) {
            i3 = R.id.p9u;
            TextView textView = (TextView) view.findViewById(R.id.p9u);
            if (textView != null) {
                return new VasSquareChatLandChooseActionItemBinding((LinearLayout) view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
