package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareChatLandChooseActionDialogBinding implements ViewBinding {
    public final SquareImageView closeBtn;
    public final FrameLayout container;
    private final LinearLayout rootView;
    public final RecyclerView vasSquareChooseActionList;

    VasSquareChatLandChooseActionDialogBinding(LinearLayout linearLayout, SquareImageView squareImageView, FrameLayout frameLayout, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.closeBtn = squareImageView;
        this.container = frameLayout;
        this.vasSquareChooseActionList = recyclerView;
    }

    public static VasSquareChatLandChooseActionDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareChatLandChooseActionDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3l, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandChooseActionDialogBinding bind(View view) {
        int i3 = R.id.pk9;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pk9);
        if (squareImageView != null) {
            i3 = R.id.plw;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.plw);
            if (frameLayout != null) {
                i3 = R.id.qwj;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.qwj);
                if (recyclerView != null) {
                    return new VasSquareChatLandChooseActionDialogBinding((LinearLayout) view, squareImageView, frameLayout, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
