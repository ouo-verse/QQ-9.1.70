package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareDetailMeDressBubbleBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final SquareImageView tipsArrow;
    public final TextView tipsText;
    public final RelativeLayout vasSquareMsgBoxBubbleContainer;

    VasSquareDetailMeDressBubbleBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, TextView textView, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.tipsArrow = squareImageView;
        this.tipsText = textView;
        this.vasSquareMsgBoxBubbleContainer = relativeLayout2;
    }

    public static VasSquareDetailMeDressBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareDetailMeDressBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167400d41, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareDetailMeDressBubbleBinding bind(View view) {
        int i3 = R.id.f163554qr2;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163554qr2);
        if (squareImageView != null) {
            i3 = R.id.f163556qr4;
            TextView textView = (TextView) view.findViewById(R.id.f163556qr4);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                return new VasSquareDetailMeDressBubbleBinding(relativeLayout, squareImageView, textView, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
