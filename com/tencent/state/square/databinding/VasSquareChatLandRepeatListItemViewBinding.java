package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareChatLandRepeatListItemViewBinding implements ViewBinding {
    public final CircleBoarderImageView headImage;
    public final TextView nickName;
    private final LinearLayout rootView;

    VasSquareChatLandRepeatListItemViewBinding(LinearLayout linearLayout, CircleBoarderImageView circleBoarderImageView, TextView textView) {
        this.rootView = linearLayout;
        this.headImage = circleBoarderImageView;
        this.nickName = textView;
    }

    public static VasSquareChatLandRepeatListItemViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareChatLandRepeatListItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3r, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandRepeatListItemViewBinding bind(View view) {
        int i3 = R.id.pyx;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.pyx);
        if (circleBoarderImageView != null) {
            i3 = R.id.q_i;
            TextView textView = (TextView) view.findViewById(R.id.q_i);
            if (textView != null) {
                return new VasSquareChatLandRepeatListItemViewBinding((LinearLayout) view, circleBoarderImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
