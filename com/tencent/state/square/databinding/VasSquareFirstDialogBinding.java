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
public final class VasSquareFirstDialogBinding implements ViewBinding {
    public final CircleBoarderImageView avatarIcon;
    public final TextView avatarName;
    public final TextView btnLeft;
    public final TextView btnRight;
    public final RelativeLayout contentContainer;
    public final FrameLayout dialogRoot;
    public final SquareImageView imgBg;
    private final FrameLayout rootView;
    public final SquareImageView troopIcon;
    public final TextView txtTips;
    public final TextView txtTitle;

    VasSquareFirstDialogBinding(FrameLayout frameLayout, CircleBoarderImageView circleBoarderImageView, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout, FrameLayout frameLayout2, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView4, TextView textView5) {
        this.rootView = frameLayout;
        this.avatarIcon = circleBoarderImageView;
        this.avatarName = textView;
        this.btnLeft = textView2;
        this.btnRight = textView3;
        this.contentContainer = relativeLayout;
        this.dialogRoot = frameLayout2;
        this.imgBg = squareImageView;
        this.troopIcon = squareImageView2;
        this.txtTips = textView4;
        this.txtTitle = textView5;
    }

    public static VasSquareFirstDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFirstDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4b, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFirstDialogBinding bind(View view) {
        int i3 = R.id.pby;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.pby);
        if (circleBoarderImageView != null) {
            i3 = R.id.pcf;
            TextView textView = (TextView) view.findViewById(R.id.pcf);
            if (textView != null) {
                i3 = R.id.pg6;
                TextView textView2 = (TextView) view.findViewById(R.id.pg6);
                if (textView2 != null) {
                    i3 = R.id.pgf;
                    TextView textView3 = (TextView) view.findViewById(R.id.pgf);
                    if (textView3 != null) {
                        i3 = R.id.pm8;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pm8);
                        if (relativeLayout != null) {
                            FrameLayout frameLayout = (FrameLayout) view;
                            i3 = R.id.q1n;
                            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q1n);
                            if (squareImageView != null) {
                                i3 = R.id.qsm;
                                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qsm);
                                if (squareImageView2 != null) {
                                    i3 = R.id.quu;
                                    TextView textView4 = (TextView) view.findViewById(R.id.quu);
                                    if (textView4 != null) {
                                        i3 = R.id.quv;
                                        TextView textView5 = (TextView) view.findViewById(R.id.quv);
                                        if (textView5 != null) {
                                            return new VasSquareFirstDialogBinding(frameLayout, circleBoarderImageView, textView, textView2, textView3, relativeLayout, frameLayout, squareImageView, squareImageView2, textView4, textView5);
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
