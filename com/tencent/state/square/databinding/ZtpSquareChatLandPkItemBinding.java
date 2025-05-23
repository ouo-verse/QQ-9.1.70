package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class ZtpSquareChatLandPkItemBinding implements ViewBinding {
    public final SquareImageView chooseBackground;
    public final SquareImageView chooseSelectedIcon;
    public final TextView chooseText;
    public final SquareImageView chooseWatermark;
    private final RelativeLayout rootView;

    ZtpSquareChatLandPkItemBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView, SquareImageView squareImageView3) {
        this.rootView = relativeLayout;
        this.chooseBackground = squareImageView;
        this.chooseSelectedIcon = squareImageView2;
        this.chooseText = textView;
        this.chooseWatermark = squareImageView3;
    }

    public static ZtpSquareChatLandPkItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareChatLandPkItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dhp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ZtpSquareChatLandPkItemBinding bind(View view) {
        int i3 = R.id.pjm;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pjm);
        if (squareImageView != null) {
            i3 = R.id.pjv;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pjv);
            if (squareImageView2 != null) {
                i3 = R.id.pjw;
                TextView textView = (TextView) view.findViewById(R.id.pjw);
                if (textView != null) {
                    i3 = R.id.pjx;
                    SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.pjx);
                    if (squareImageView3 != null) {
                        return new ZtpSquareChatLandPkItemBinding((RelativeLayout) view, squareImageView, squareImageView2, textView, squareImageView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
