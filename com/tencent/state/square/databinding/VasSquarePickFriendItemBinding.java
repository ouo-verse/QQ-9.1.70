package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;

/* loaded from: classes38.dex */
public final class VasSquarePickFriendItemBinding implements ViewBinding {
    public final CircleBoarderImageView pickFriendHeader;
    public final TextView pickFriendNickName;
    private final LinearLayout rootView;

    VasSquarePickFriendItemBinding(LinearLayout linearLayout, CircleBoarderImageView circleBoarderImageView, TextView textView) {
        this.rootView = linearLayout;
        this.pickFriendHeader = circleBoarderImageView;
        this.pickFriendNickName = textView;
    }

    public static VasSquarePickFriendItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquarePickFriendItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6m, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquarePickFriendItemBinding bind(View view) {
        int i3 = R.id.qcf;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.qcf);
        if (circleBoarderImageView != null) {
            i3 = R.id.qcg;
            TextView textView = (TextView) view.findViewById(R.id.qcg);
            if (textView != null) {
                return new VasSquarePickFriendItemBinding((LinearLayout) view, circleBoarderImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
