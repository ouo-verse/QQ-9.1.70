package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareChatLandSpeakBubbleBinding implements ViewBinding {
    public final SquareImageView bubbleArrow;
    private final RelativeLayout rootView;
    public final LinearLayout textContainer;
    public final TextView textView;

    VasSquareChatLandSpeakBubbleBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, LinearLayout linearLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.bubbleArrow = squareImageView;
        this.textContainer = linearLayout;
        this.textView = textView;
    }

    public static VasSquareChatLandSpeakBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareChatLandSpeakBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3t, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandSpeakBubbleBinding bind(View view) {
        int i3 = R.id.pgt;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pgt);
        if (squareImageView != null) {
            i3 = R.id.qqf;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qqf);
            if (linearLayout != null) {
                i3 = R.id.qql;
                TextView textView = (TextView) view.findViewById(R.id.qql);
                if (textView != null) {
                    return new VasSquareChatLandSpeakBubbleBinding((RelativeLayout) view, squareImageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
