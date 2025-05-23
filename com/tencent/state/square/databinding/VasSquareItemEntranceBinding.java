package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.MotionBubbleView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemEntranceBinding implements ViewBinding {
    public final FrameLayout buildingPag;
    public final TextView debugTips;
    public final VasSquareEntranceBubbleBinding entranceBubble;
    public final SquareImageView entranceImage;
    public final View hotClickArea;
    public final MotionBubbleView motionBubbleView;
    public final TextView name;
    private final FrameLayout rootView;
    public final SquareImageView typeIcon;

    VasSquareItemEntranceBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, VasSquareEntranceBubbleBinding vasSquareEntranceBubbleBinding, SquareImageView squareImageView, View view, MotionBubbleView motionBubbleView, TextView textView2, SquareImageView squareImageView2) {
        this.rootView = frameLayout;
        this.buildingPag = frameLayout2;
        this.debugTips = textView;
        this.entranceBubble = vasSquareEntranceBubbleBinding;
        this.entranceImage = squareImageView;
        this.hotClickArea = view;
        this.motionBubbleView = motionBubbleView;
        this.name = textView2;
        this.typeIcon = squareImageView2;
    }

    public static VasSquareItemEntranceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemEntranceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5c, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemEntranceBinding bind(View view) {
        int i3 = R.id.ph9;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ph9);
        if (frameLayout != null) {
            i3 = R.id.poi;
            TextView textView = (TextView) view.findViewById(R.id.poi);
            if (textView != null) {
                i3 = R.id.ps9;
                View findViewById = view.findViewById(R.id.ps9);
                if (findViewById != null) {
                    VasSquareEntranceBubbleBinding bind = VasSquareEntranceBubbleBinding.bind(findViewById);
                    i3 = R.id.pse;
                    SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pse);
                    if (squareImageView != null) {
                        i3 = R.id.q09;
                        View findViewById2 = view.findViewById(R.id.q09);
                        if (findViewById2 != null) {
                            i3 = R.id.q9j;
                            MotionBubbleView motionBubbleView = (MotionBubbleView) view.findViewById(R.id.q9j);
                            if (motionBubbleView != null) {
                                i3 = R.id.q_6;
                                TextView textView2 = (TextView) view.findViewById(R.id.q_6);
                                if (textView2 != null) {
                                    i3 = R.id.quz;
                                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.quz);
                                    if (squareImageView2 != null) {
                                        return new VasSquareItemEntranceBinding((FrameLayout) view, frameLayout, textView, bind, squareImageView, findViewById2, motionBubbleView, textView2, squareImageView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
