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

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLikeItemBinding implements ViewBinding {
    public final TextView likeFrom;
    public final TextView likeTime;
    public final SquareImageView masterLikeIcon;
    private final LinearLayout rootView;
    public final CircleBoarderImageView userAvatar;
    public final TextView userNick;

    VasSquareLikeItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2, SquareImageView squareImageView, CircleBoarderImageView circleBoarderImageView, TextView textView3) {
        this.rootView = linearLayout;
        this.likeFrom = textView;
        this.likeTime = textView2;
        this.masterLikeIcon = squareImageView;
        this.userAvatar = circleBoarderImageView;
        this.userNick = textView3;
    }

    public static VasSquareLikeItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLikeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167415d64, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLikeItemBinding bind(View view) {
        int i3 = R.id.q56;
        TextView textView = (TextView) view.findViewById(R.id.q56);
        if (textView != null) {
            i3 = R.id.q5d;
            TextView textView2 = (TextView) view.findViewById(R.id.q5d);
            if (textView2 != null) {
                i3 = R.id.q7y;
                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q7y);
                if (squareImageView != null) {
                    i3 = R.id.qvu;
                    CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.qvu);
                    if (circleBoarderImageView != null) {
                        i3 = R.id.qwc;
                        TextView textView3 = (TextView) view.findViewById(R.id.qwc);
                        if (textView3 != null) {
                            return new VasSquareLikeItemBinding((LinearLayout) view, textView, textView2, squareImageView, circleBoarderImageView, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
