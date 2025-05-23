package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemInteractionRecordCommBinding implements ViewBinding {
    public final CircleBoarderImageView interactionRecordHeader;
    public final TextView interactionRecordName;
    public final TextView interactionRecordTime;
    private final LinearLayout rootView;
    public final TextView squareInteractionRecordContent;
    public final SquareImageView squareInteractionRecordContentIcon;
    public final LinearLayout vasSquareInteractionRecordAction;
    public final SquareImageView vasSquareInteractionRecordActionIcon;
    public final TextView vasSquareInteractionRecordActionText;

    VasSquareItemInteractionRecordCommBinding(LinearLayout linearLayout, CircleBoarderImageView circleBoarderImageView, TextView textView, TextView textView2, TextView textView3, SquareImageView squareImageView, LinearLayout linearLayout2, SquareImageView squareImageView2, TextView textView4) {
        this.rootView = linearLayout;
        this.interactionRecordHeader = circleBoarderImageView;
        this.interactionRecordName = textView;
        this.interactionRecordTime = textView2;
        this.squareInteractionRecordContent = textView3;
        this.squareInteractionRecordContentIcon = squareImageView;
        this.vasSquareInteractionRecordAction = linearLayout2;
        this.vasSquareInteractionRecordActionIcon = squareImageView2;
        this.vasSquareInteractionRecordActionText = textView4;
    }

    public static VasSquareItemInteractionRecordCommBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemInteractionRecordCommBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5e, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemInteractionRecordCommBinding bind(View view) {
        int i3 = R.id.q28;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.q28);
        if (circleBoarderImageView != null) {
            i3 = R.id.q2_;
            TextView textView = (TextView) view.findViewById(R.id.q2_);
            if (textView != null) {
                i3 = R.id.q2a;
                TextView textView2 = (TextView) view.findViewById(R.id.q2a);
                if (textView2 != null) {
                    i3 = R.id.f163533qn1;
                    TextView textView3 = (TextView) view.findViewById(R.id.f163533qn1);
                    if (textView3 != null) {
                        i3 = R.id.f163534qn2;
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163534qn2);
                        if (squareImageView != null) {
                            i3 = R.id.qwn;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qwn);
                            if (linearLayout != null) {
                                i3 = R.id.qwo;
                                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qwo);
                                if (squareImageView2 != null) {
                                    i3 = R.id.qwp;
                                    TextView textView4 = (TextView) view.findViewById(R.id.qwp);
                                    if (textView4 != null) {
                                        return new VasSquareItemInteractionRecordCommBinding((LinearLayout) view, circleBoarderImageView, textView, textView2, textView3, squareImageView, linearLayout, squareImageView2, textView4);
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
