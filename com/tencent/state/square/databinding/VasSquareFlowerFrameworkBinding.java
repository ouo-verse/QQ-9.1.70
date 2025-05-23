package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.RoundRelativeLayout;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFlowerFrameworkBinding implements ViewBinding {
    public final View blankLayout;
    public final FrameLayout contentContainer;
    public final RoundRelativeLayout contentLayout;
    public final RelativeLayout dialogRoot;
    public final FrameLayout dragHandle;
    public final FrameLayout fragmentContainer;
    public final FrameLayout panelRoot;
    private final RelativeLayout rootView;
    public final SquareImageView vasSquareMsgBoxDragIcon;

    VasSquareFlowerFrameworkBinding(RelativeLayout relativeLayout, View view, FrameLayout frameLayout, RoundRelativeLayout roundRelativeLayout, RelativeLayout relativeLayout2, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, SquareImageView squareImageView) {
        this.rootView = relativeLayout;
        this.blankLayout = view;
        this.contentContainer = frameLayout;
        this.contentLayout = roundRelativeLayout;
        this.dialogRoot = relativeLayout2;
        this.dragHandle = frameLayout2;
        this.fragmentContainer = frameLayout3;
        this.panelRoot = frameLayout4;
        this.vasSquareMsgBoxDragIcon = squareImageView;
    }

    public static VasSquareFlowerFrameworkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFlowerFrameworkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4e, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFlowerFrameworkBinding bind(View view) {
        int i3 = R.id.pdu;
        View findViewById = view.findViewById(R.id.pdu);
        if (findViewById != null) {
            i3 = R.id.pm8;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pm8);
            if (frameLayout != null) {
                i3 = R.id.pm_;
                RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) view.findViewById(R.id.pm_);
                if (roundRelativeLayout != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.pqk;
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.pqk);
                    if (frameLayout2 != null) {
                        i3 = R.id.pvw;
                        FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.pvw);
                        if (frameLayout3 != null) {
                            i3 = R.id.qbn;
                            FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.qbn);
                            if (frameLayout4 != null) {
                                i3 = R.id.qxd;
                                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qxd);
                                if (squareImageView != null) {
                                    return new VasSquareFlowerFrameworkBinding(relativeLayout, findViewById, frameLayout, roundRelativeLayout, relativeLayout, frameLayout2, frameLayout3, frameLayout4, squareImageView);
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
