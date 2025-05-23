package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareLikeListPanelBinding implements ViewBinding {
    public final RecyclerView list;
    private final FrameLayout rootView;
    public final SquareImageView vasSquareLikeListPanelDragIcon;
    public final TextView vasSquareLikeListPanelTitle;

    VasSquareLikeListPanelBinding(FrameLayout frameLayout, RecyclerView recyclerView, SquareImageView squareImageView, TextView textView) {
        this.rootView = frameLayout;
        this.list = recyclerView;
        this.vasSquareLikeListPanelDragIcon = squareImageView;
        this.vasSquareLikeListPanelTitle = textView;
    }

    public static VasSquareLikeListPanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLikeListPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d65, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLikeListPanelBinding bind(View view) {
        int i3 = R.id.q5l;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.q5l);
        if (recyclerView != null) {
            i3 = R.id.f163586qx4;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163586qx4);
            if (squareImageView != null) {
                i3 = R.id.qx5;
                TextView textView = (TextView) view.findViewById(R.id.qx5);
                if (textView != null) {
                    return new VasSquareLikeListPanelBinding((FrameLayout) view, recyclerView, squareImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
