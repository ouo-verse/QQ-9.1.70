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
public final class VasSquareInteractionOptionItemBinding implements ViewBinding {
    public final SquareImageView changeBtnView;
    public final SquareImageView closeBtnView;
    public final SquareImageView coverView;
    public final FrameLayout emptyView;
    public final TextView preView;
    private final FrameLayout rootView;
    public final LinearLayout selectedView;
    public final RelativeLayout selectedViewContainer;
    public final TextView titleView;

    VasSquareInteractionOptionItemBinding(FrameLayout frameLayout, SquareImageView squareImageView, SquareImageView squareImageView2, SquareImageView squareImageView3, FrameLayout frameLayout2, TextView textView, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView2) {
        this.rootView = frameLayout;
        this.changeBtnView = squareImageView;
        this.closeBtnView = squareImageView2;
        this.coverView = squareImageView3;
        this.emptyView = frameLayout2;
        this.preView = textView;
        this.selectedView = linearLayout;
        this.selectedViewContainer = relativeLayout;
        this.titleView = textView2;
    }

    public static VasSquareInteractionOptionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareInteractionOptionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167405d50, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareInteractionOptionItemBinding bind(View view) {
        int i3 = R.id.pix;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pix);
        if (squareImageView != null) {
            i3 = R.id.pk5;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pk5);
            if (squareImageView2 != null) {
                i3 = R.id.pmu;
                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.pmu);
                if (squareImageView3 != null) {
                    i3 = R.id.prg;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.prg);
                    if (frameLayout != null) {
                        i3 = R.id.qdg;
                        TextView textView = (TextView) view.findViewById(R.id.qdg);
                        if (textView != null) {
                            i3 = R.id.f163521qk4;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f163521qk4);
                            if (linearLayout != null) {
                                i3 = R.id.qk5;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qk5);
                                if (relativeLayout != null) {
                                    i3 = R.id.qrk;
                                    TextView textView2 = (TextView) view.findViewById(R.id.qrk);
                                    if (textView2 != null) {
                                        return new VasSquareInteractionOptionItemBinding((FrameLayout) view, squareImageView, squareImageView2, squareImageView3, frameLayout, textView, linearLayout, relativeLayout, textView2);
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
