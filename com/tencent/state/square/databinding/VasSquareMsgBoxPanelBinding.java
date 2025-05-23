package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareMsgBoxPanelBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RelativeLayout vasSquareMsgBoxContent;
    public final SquareImageView vasSquareMsgBoxDragIcon;
    public final RelativeLayout vasSquareMsgBoxEmptyContainer;
    public final SquareImageView vasSquareMsgBoxEmptyIcon;
    public final TextView vasSquareMsgBoxEmptyTips;
    public final RecyclerView vasSquareMsgBoxList;
    public final RelativeLayout vasSquareMsgBoxPanelContainer;
    public final TextView vasSquareMsgBoxTitle;

    VasSquareMsgBoxPanelBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, SquareImageView squareImageView, RelativeLayout relativeLayout3, SquareImageView squareImageView2, TextView textView, RecyclerView recyclerView, RelativeLayout relativeLayout4, TextView textView2) {
        this.rootView = relativeLayout;
        this.vasSquareMsgBoxContent = relativeLayout2;
        this.vasSquareMsgBoxDragIcon = squareImageView;
        this.vasSquareMsgBoxEmptyContainer = relativeLayout3;
        this.vasSquareMsgBoxEmptyIcon = squareImageView2;
        this.vasSquareMsgBoxEmptyTips = textView;
        this.vasSquareMsgBoxList = recyclerView;
        this.vasSquareMsgBoxPanelContainer = relativeLayout4;
        this.vasSquareMsgBoxTitle = textView2;
    }

    public static VasSquareMsgBoxPanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareMsgBoxPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6e, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareMsgBoxPanelBinding bind(View view) {
        int i3 = R.id.qxc;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qxc);
        if (relativeLayout != null) {
            i3 = R.id.qxd;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qxd);
            if (squareImageView != null) {
                i3 = R.id.qxe;
                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qxe);
                if (relativeLayout2 != null) {
                    i3 = R.id.qxf;
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qxf);
                    if (squareImageView2 != null) {
                        i3 = R.id.qxg;
                        TextView textView = (TextView) view.findViewById(R.id.qxg);
                        if (textView != null) {
                            i3 = R.id.qxz;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.qxz);
                            if (recyclerView != null) {
                                RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                i3 = R.id.f163589qy2;
                                TextView textView2 = (TextView) view.findViewById(R.id.f163589qy2);
                                if (textView2 != null) {
                                    return new VasSquareMsgBoxPanelBinding(relativeLayout3, relativeLayout, squareImageView, relativeLayout2, squareImageView2, textView, recyclerView, relativeLayout3, textView2);
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
