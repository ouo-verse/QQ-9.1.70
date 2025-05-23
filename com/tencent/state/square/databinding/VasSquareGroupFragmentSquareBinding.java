package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CommonDragView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareGroupFragmentSquareBinding implements ViewBinding {
    public final LinearLayout countDownBottomBox;
    public final View countDownCircle;
    public final CommonDragView floatingCallback;
    public final FrameLayout floatingCallbackCirclePag;
    public final SquareImageView floatingCallbackClose;
    public final SquareImageView floatingCallbackImage;
    public final FrameLayout floatingNoticePag;
    public final FrameLayout fragmentContainer;
    public final TextSwitcher libraryCallbackTips;
    private final FrameLayout rootView;

    VasSquareGroupFragmentSquareBinding(FrameLayout frameLayout, LinearLayout linearLayout, View view, CommonDragView commonDragView, FrameLayout frameLayout2, SquareImageView squareImageView, SquareImageView squareImageView2, FrameLayout frameLayout3, FrameLayout frameLayout4, TextSwitcher textSwitcher) {
        this.rootView = frameLayout;
        this.countDownBottomBox = linearLayout;
        this.countDownCircle = view;
        this.floatingCallback = commonDragView;
        this.floatingCallbackCirclePag = frameLayout2;
        this.floatingCallbackClose = squareImageView;
        this.floatingCallbackImage = squareImageView2;
        this.floatingNoticePag = frameLayout3;
        this.fragmentContainer = frameLayout4;
        this.libraryCallbackTips = textSwitcher;
    }

    public static VasSquareGroupFragmentSquareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareGroupFragmentSquareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4y, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareGroupFragmentSquareBinding bind(View view) {
        int i3 = R.id.pmo;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pmo);
        if (linearLayout != null) {
            i3 = R.id.pmp;
            View findViewById = view.findViewById(R.id.pmp);
            if (findViewById != null) {
                i3 = R.id.pum;
                CommonDragView commonDragView = (CommonDragView) view.findViewById(R.id.pum);
                if (commonDragView != null) {
                    i3 = R.id.pun;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pun);
                    if (frameLayout != null) {
                        i3 = R.id.puo;
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.puo);
                        if (squareImageView != null) {
                            i3 = R.id.pup;
                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pup);
                            if (squareImageView2 != null) {
                                i3 = R.id.puq;
                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.puq);
                                if (frameLayout2 != null) {
                                    i3 = R.id.pvw;
                                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.pvw);
                                    if (frameLayout3 != null) {
                                        i3 = R.id.q4x;
                                        TextSwitcher textSwitcher = (TextSwitcher) view.findViewById(R.id.q4x);
                                        if (textSwitcher != null) {
                                            return new VasSquareGroupFragmentSquareBinding((FrameLayout) view, linearLayout, findViewById, commonDragView, frameLayout, squareImageView, squareImageView2, frameLayout2, frameLayout3, textSwitcher);
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
