package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareEntranceBubbleBinding implements ViewBinding {
    public final RelativeLayout bubbleContainer;
    public final SquareImageView entranceBubbleArrow;
    public final CircleBoarderImageView entranceBubbleIcon;
    public final TextView entranceBubbleText;
    private final LinearLayout rootView;

    VasSquareEntranceBubbleBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, SquareImageView squareImageView, CircleBoarderImageView circleBoarderImageView, TextView textView) {
        this.rootView = linearLayout;
        this.bubbleContainer = relativeLayout;
        this.entranceBubbleArrow = squareImageView;
        this.entranceBubbleIcon = circleBoarderImageView;
        this.entranceBubbleText = textView;
    }

    public static VasSquareEntranceBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareEntranceBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d46, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareEntranceBubbleBinding bind(View view) {
        int i3 = R.id.pgw;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pgw);
        if (relativeLayout != null) {
            i3 = R.id.ps_;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.ps_);
            if (squareImageView != null) {
                i3 = R.id.psa;
                CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.psa);
                if (circleBoarderImageView != null) {
                    i3 = R.id.psb;
                    TextView textView = (TextView) view.findViewById(R.id.psb);
                    if (textView != null) {
                        return new VasSquareEntranceBubbleBinding((LinearLayout) view, relativeLayout, squareImageView, circleBoarderImageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
