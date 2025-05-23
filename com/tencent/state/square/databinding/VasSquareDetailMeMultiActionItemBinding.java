package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareDetailMeMultiActionItemBinding implements ViewBinding {
    public final RelativeLayout detailMeMultiActionItemContent;
    public final SquareImageView detailMeMultiActionItemIcon;
    public final View detailMeMultiActionItemLock;
    public final TextView detailMeMultiActionItemName;
    public final View detailMeMultiActionItemReddot;
    public final FrameLayout detailMeMultiActionItemRoot;
    private final FrameLayout rootView;

    VasSquareDetailMeMultiActionItemBinding(FrameLayout frameLayout, RelativeLayout relativeLayout, SquareImageView squareImageView, View view, TextView textView, View view2, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.detailMeMultiActionItemContent = relativeLayout;
        this.detailMeMultiActionItemIcon = squareImageView;
        this.detailMeMultiActionItemLock = view;
        this.detailMeMultiActionItemName = textView;
        this.detailMeMultiActionItemReddot = view2;
        this.detailMeMultiActionItemRoot = frameLayout2;
    }

    public static VasSquareDetailMeMultiActionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareDetailMeMultiActionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167401d42, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareDetailMeMultiActionItemBinding bind(View view) {
        int i3 = R.id.pp5;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pp5);
        if (relativeLayout != null) {
            i3 = R.id.pp6;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pp6);
            if (squareImageView != null) {
                i3 = R.id.pp7;
                View findViewById = view.findViewById(R.id.pp7);
                if (findViewById != null) {
                    i3 = R.id.pp8;
                    TextView textView = (TextView) view.findViewById(R.id.pp8);
                    if (textView != null) {
                        i3 = R.id.pp9;
                        View findViewById2 = view.findViewById(R.id.pp9);
                        if (findViewById2 != null) {
                            FrameLayout frameLayout = (FrameLayout) view;
                            return new VasSquareDetailMeMultiActionItemBinding(frameLayout, relativeLayout, squareImageView, findViewById, textView, findViewById2, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
