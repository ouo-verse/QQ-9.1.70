package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareFriendStatusPanelItemBinding implements ViewBinding {
    public final LinearLayout itemContainer;
    public final SquareImageView itemOperatorIcon;
    public final CircleBoarderImageView itemUserAvatar;
    public final TextView itemUserNick;
    private final LinearLayout rootView;

    VasSquareFriendStatusPanelItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, SquareImageView squareImageView, CircleBoarderImageView circleBoarderImageView, TextView textView) {
        this.rootView = linearLayout;
        this.itemContainer = linearLayout2;
        this.itemOperatorIcon = squareImageView;
        this.itemUserAvatar = circleBoarderImageView;
        this.itemUserNick = textView;
    }

    public static VasSquareFriendStatusPanelItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFriendStatusPanelItemBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.q3e;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q3e);
        if (squareImageView != null) {
            i3 = R.id.q3o;
            CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.q3o);
            if (circleBoarderImageView != null) {
                i3 = R.id.q3p;
                TextView textView = (TextView) view.findViewById(R.id.q3p);
                if (textView != null) {
                    return new VasSquareFriendStatusPanelItemBinding((LinearLayout) view, linearLayout, squareImageView, circleBoarderImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareFriendStatusPanelItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4v, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
