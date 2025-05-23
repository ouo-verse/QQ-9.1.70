package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareMsgBoxBubbleBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final SquareImageView vasSquareMsgBoxBubbleArrow;
    public final CircleBoarderImageView vasSquareMsgBoxBubbleAvatar1;
    public final CircleBoarderImageView vasSquareMsgBoxBubbleAvatar2;
    public final FrameLayout vasSquareMsgBoxBubbleAvatarContainer;
    public final RelativeLayout vasSquareMsgBoxBubbleContainer;
    public final FrameLayout vasSquareMsgBoxBubbleContent;
    public final TextView vasSquareMsgBoxBubbleTips;

    VasSquareMsgBoxBubbleBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, CircleBoarderImageView circleBoarderImageView, CircleBoarderImageView circleBoarderImageView2, FrameLayout frameLayout, RelativeLayout relativeLayout2, FrameLayout frameLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.vasSquareMsgBoxBubbleArrow = squareImageView;
        this.vasSquareMsgBoxBubbleAvatar1 = circleBoarderImageView;
        this.vasSquareMsgBoxBubbleAvatar2 = circleBoarderImageView2;
        this.vasSquareMsgBoxBubbleAvatarContainer = frameLayout;
        this.vasSquareMsgBoxBubbleContainer = relativeLayout2;
        this.vasSquareMsgBoxBubbleContent = frameLayout2;
        this.vasSquareMsgBoxBubbleTips = textView;
    }

    public static VasSquareMsgBoxBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareMsgBoxBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6b, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareMsgBoxBubbleBinding bind(View view) {
        int i3 = R.id.qx6;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qx6);
        if (squareImageView != null) {
            i3 = R.id.qx7;
            CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.qx7);
            if (circleBoarderImageView != null) {
                i3 = R.id.qx8;
                CircleBoarderImageView circleBoarderImageView2 = (CircleBoarderImageView) view.findViewById(R.id.qx8);
                if (circleBoarderImageView2 != null) {
                    i3 = R.id.qx9;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qx9);
                    if (frameLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i3 = R.id.qxa;
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.qxa);
                        if (frameLayout2 != null) {
                            i3 = R.id.qxb;
                            TextView textView = (TextView) view.findViewById(R.id.qxb);
                            if (textView != null) {
                                return new VasSquareMsgBoxBubbleBinding(relativeLayout, squareImageView, circleBoarderImageView, circleBoarderImageView2, frameLayout, relativeLayout, frameLayout2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
