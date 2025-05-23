package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemHideListBinding implements ViewBinding {
    public final TextView cancelHide;
    public final TextView nick;
    private final RelativeLayout rootView;
    public final CircleBoarderImageView userHead;

    VasSquareItemHideListBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, CircleBoarderImageView circleBoarderImageView) {
        this.rootView = relativeLayout;
        this.cancelHide = textView;
        this.nick = textView2;
        this.userHead = circleBoarderImageView;
    }

    public static VasSquareItemHideListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemHideListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemHideListBinding bind(View view) {
        int i3 = R.id.pi7;
        TextView textView = (TextView) view.findViewById(R.id.pi7);
        if (textView != null) {
            i3 = R.id.q_h;
            TextView textView2 = (TextView) view.findViewById(R.id.q_h);
            if (textView2 != null) {
                i3 = R.id.qw8;
                CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.qw8);
                if (circleBoarderImageView != null) {
                    return new VasSquareItemHideListBinding((RelativeLayout) view, textView, textView2, circleBoarderImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
