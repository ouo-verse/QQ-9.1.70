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
public final class VasSquareBubbleSettingPannelBinding implements ViewBinding {
    public final RecyclerView bubbleList;
    public final SquareImageView close;
    private final RelativeLayout rootView;
    public final TextView title;

    VasSquareBubbleSettingPannelBinding(RelativeLayout relativeLayout, RecyclerView recyclerView, SquareImageView squareImageView, TextView textView) {
        this.rootView = relativeLayout;
        this.bubbleList = recyclerView;
        this.close = squareImageView;
        this.title = textView;
    }

    public static VasSquareBubbleSettingPannelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareBubbleSettingPannelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3h, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareBubbleSettingPannelBinding bind(View view) {
        int i3 = R.id.f163319ph3;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f163319ph3);
        if (recyclerView != null) {
            i3 = R.id.f163335pk4;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163335pk4);
            if (squareImageView != null) {
                i3 = R.id.qr6;
                TextView textView = (TextView) view.findViewById(R.id.qr6);
                if (textView != null) {
                    return new VasSquareBubbleSettingPannelBinding((RelativeLayout) view, recyclerView, squareImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
