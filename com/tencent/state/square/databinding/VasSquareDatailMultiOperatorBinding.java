package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareDatailMultiOperatorBinding implements ViewBinding {
    public final SquareImageView customSingleQzoneIcon;
    public final LinearLayout multiOperatorContainer;
    public final View operatorDressMallRedDot;
    public final RelativeLayout operatorEnterDressMallContainer;
    public final SquareImageView operatorEnterDressMallIcon;
    public final TextView operatorEnterDressMallText;
    public final RelativeLayout operatorEnterQzoneContainer;
    public final SquareImageView operatorEnterQzoneIcon;
    public final View operatorEnterQzoneRedDot;
    public final TextView operatorEnterQzoneText;
    public final RelativeLayout operatorEnterSmallHomeContainer;
    public final SquareImageView operatorEnterSmallHomeIcon;
    public final View operatorEnterSmallHomeRedDot;
    public final TextView operatorEnterSmallHomeText;
    private final FrameLayout rootView;
    public final RelativeLayout singleOperatorContainer;
    public final View singleOperatorQzoneRedDot;

    VasSquareDatailMultiOperatorBinding(FrameLayout frameLayout, SquareImageView squareImageView, LinearLayout linearLayout, View view, RelativeLayout relativeLayout, SquareImageView squareImageView2, TextView textView, RelativeLayout relativeLayout2, SquareImageView squareImageView3, View view2, TextView textView2, RelativeLayout relativeLayout3, SquareImageView squareImageView4, View view3, TextView textView3, RelativeLayout relativeLayout4, View view4) {
        this.rootView = frameLayout;
        this.customSingleQzoneIcon = squareImageView;
        this.multiOperatorContainer = linearLayout;
        this.operatorDressMallRedDot = view;
        this.operatorEnterDressMallContainer = relativeLayout;
        this.operatorEnterDressMallIcon = squareImageView2;
        this.operatorEnterDressMallText = textView;
        this.operatorEnterQzoneContainer = relativeLayout2;
        this.operatorEnterQzoneIcon = squareImageView3;
        this.operatorEnterQzoneRedDot = view2;
        this.operatorEnterQzoneText = textView2;
        this.operatorEnterSmallHomeContainer = relativeLayout3;
        this.operatorEnterSmallHomeIcon = squareImageView4;
        this.operatorEnterSmallHomeRedDot = view3;
        this.operatorEnterSmallHomeText = textView3;
        this.singleOperatorContainer = relativeLayout4;
        this.singleOperatorQzoneRedDot = view4;
    }

    public static VasSquareDatailMultiOperatorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareDatailMultiOperatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3x, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareDatailMultiOperatorBinding bind(View view) {
        int i3 = R.id.po8;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.po8);
        if (squareImageView != null) {
            i3 = R.id.q9w;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q9w);
            if (linearLayout != null) {
                i3 = R.id.qa8;
                View findViewById = view.findViewById(R.id.qa8);
                if (findViewById != null) {
                    i3 = R.id.qa9;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qa9);
                    if (relativeLayout != null) {
                        i3 = R.id.qa_;
                        SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qa_);
                        if (squareImageView2 != null) {
                            i3 = R.id.qaa;
                            TextView textView = (TextView) view.findViewById(R.id.qaa);
                            if (textView != null) {
                                i3 = R.id.qab;
                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qab);
                                if (relativeLayout2 != null) {
                                    i3 = R.id.qac;
                                    SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.qac);
                                    if (squareImageView3 != null) {
                                        i3 = R.id.qad;
                                        View findViewById2 = view.findViewById(R.id.qad);
                                        if (findViewById2 != null) {
                                            i3 = R.id.qae;
                                            TextView textView2 = (TextView) view.findViewById(R.id.qae);
                                            if (textView2 != null) {
                                                i3 = R.id.qaf;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.qaf);
                                                if (relativeLayout3 != null) {
                                                    i3 = R.id.qag;
                                                    SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.qag);
                                                    if (squareImageView4 != null) {
                                                        i3 = R.id.qah;
                                                        View findViewById3 = view.findViewById(R.id.qah);
                                                        if (findViewById3 != null) {
                                                            i3 = R.id.qai;
                                                            TextView textView3 = (TextView) view.findViewById(R.id.qai);
                                                            if (textView3 != null) {
                                                                i3 = R.id.qm7;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.qm7);
                                                                if (relativeLayout4 != null) {
                                                                    i3 = R.id.qm8;
                                                                    View findViewById4 = view.findViewById(R.id.qm8);
                                                                    if (findViewById4 != null) {
                                                                        return new VasSquareDatailMultiOperatorBinding((FrameLayout) view, squareImageView, linearLayout, findViewById, relativeLayout, squareImageView2, textView, relativeLayout2, squareImageView3, findViewById2, textView2, relativeLayout3, squareImageView4, findViewById3, textView3, relativeLayout4, findViewById4);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
