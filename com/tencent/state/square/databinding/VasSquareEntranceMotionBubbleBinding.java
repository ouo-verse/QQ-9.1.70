package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareEntranceMotionBubbleBinding implements ViewBinding {
    public final RelativeLayout bubbleContainer;
    public final SquareImageView entranceBubbleArrow;
    public final TextView entranceBubbleText;
    private final View rootView;

    VasSquareEntranceMotionBubbleBinding(View view, RelativeLayout relativeLayout, SquareImageView squareImageView, TextView textView) {
        this.rootView = view;
        this.bubbleContainer = relativeLayout;
        this.entranceBubbleArrow = squareImageView;
        this.entranceBubbleText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareEntranceMotionBubbleBinding bind(View view) {
        int i3 = R.id.pgw;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pgw);
        if (relativeLayout != null) {
            i3 = R.id.ps_;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.ps_);
            if (squareImageView != null) {
                i3 = R.id.psb;
                TextView textView = (TextView) view.findViewById(R.id.psb);
                if (textView != null) {
                    return new VasSquareEntranceMotionBubbleBinding(view, relativeLayout, squareImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareEntranceMotionBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d47, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
