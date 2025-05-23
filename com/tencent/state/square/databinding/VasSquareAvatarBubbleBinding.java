package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.RoundImageView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareAvatarBubbleBinding implements ViewBinding {
    public final SquareImageView bubbleArrow;
    public final RoundImageView iconLbsEntrance;
    public final TextView lbsTextView;
    public final LinearLayout onlineLbsContainer;
    public final LinearLayout onlineStatusAvatarBubble;
    public final RelativeLayout onlineStatusAvatarBubbleMain;
    public final LinearLayout onlineStatusAvatarBubbleMsg;
    private final View rootView;

    VasSquareAvatarBubbleBinding(View view, SquareImageView squareImageView, RoundImageView roundImageView, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, LinearLayout linearLayout3) {
        this.rootView = view;
        this.bubbleArrow = squareImageView;
        this.iconLbsEntrance = roundImageView;
        this.lbsTextView = textView;
        this.onlineLbsContainer = linearLayout;
        this.onlineStatusAvatarBubble = linearLayout2;
        this.onlineStatusAvatarBubbleMain = relativeLayout;
        this.onlineStatusAvatarBubbleMsg = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareAvatarBubbleBinding bind(View view) {
        int i3 = R.id.pgt;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pgt);
        if (squareImageView != null) {
            i3 = R.id.q0q;
            RoundImageView roundImageView = (RoundImageView) view.findViewById(R.id.q0q);
            if (roundImageView != null) {
                i3 = R.id.q4k;
                TextView textView = (TextView) view.findViewById(R.id.q4k);
                if (textView != null) {
                    i3 = R.id.q_p;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q_p);
                    if (linearLayout != null) {
                        i3 = R.id.q_q;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.q_q);
                        if (linearLayout2 != null) {
                            i3 = R.id.q_r;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.q_r);
                            if (relativeLayout != null) {
                                i3 = R.id.q_s;
                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.q_s);
                                if (linearLayout3 != null) {
                                    return new VasSquareAvatarBubbleBinding(view, squareImageView, roundImageView, textView, linearLayout, linearLayout2, relativeLayout, linearLayout3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareAvatarBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d39, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
