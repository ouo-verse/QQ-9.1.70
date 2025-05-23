package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareQzoneFeedBubbleBinding implements ViewBinding {
    public final SquareImageView bubbleArrow;
    public final LinearLayout bubbleBg;
    public final FrameLayout bubbleIcon;
    public final TextView feedsNewTips;
    private final LinearLayout rootView;

    VasSquareQzoneFeedBubbleBinding(LinearLayout linearLayout, SquareImageView squareImageView, LinearLayout linearLayout2, FrameLayout frameLayout, TextView textView) {
        this.rootView = linearLayout;
        this.bubbleArrow = squareImageView;
        this.bubbleBg = linearLayout2;
        this.bubbleIcon = frameLayout;
        this.feedsNewTips = textView;
    }

    public static VasSquareQzoneFeedBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareQzoneFeedBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6q, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareQzoneFeedBubbleBinding bind(View view) {
        int i3 = R.id.pgt;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pgt);
        if (squareImageView != null) {
            i3 = R.id.pgu;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pgu);
            if (linearLayout != null) {
                i3 = R.id.f163317ph1;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f163317ph1);
                if (frameLayout != null) {
                    i3 = R.id.ptx;
                    TextView textView = (TextView) view.findViewById(R.id.ptx);
                    if (textView != null) {
                        return new VasSquareQzoneFeedBubbleBinding((LinearLayout) view, squareImageView, linearLayout, frameLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
