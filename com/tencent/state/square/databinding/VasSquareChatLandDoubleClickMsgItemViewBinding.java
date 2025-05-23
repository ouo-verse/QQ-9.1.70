package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareChatLandDoubleClickMsgItemViewBinding implements ViewBinding {
    public final SquareImageView iconPai;
    public final CircleBoarderImageView imgAvatar;
    public final TextView lvName;
    public final LinearLayout lvTagLine;
    private final RelativeLayout rootView;
    public final TextView tvMsg;

    VasSquareChatLandDoubleClickMsgItemViewBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, CircleBoarderImageView circleBoarderImageView, TextView textView, LinearLayout linearLayout, TextView textView2) {
        this.rootView = relativeLayout;
        this.iconPai = squareImageView;
        this.imgAvatar = circleBoarderImageView;
        this.lvName = textView;
        this.lvTagLine = linearLayout;
        this.tvMsg = textView2;
    }

    public static VasSquareChatLandDoubleClickMsgItemViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareChatLandDoubleClickMsgItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3n, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandDoubleClickMsgItemViewBinding bind(View view) {
        int i3 = R.id.q0v;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q0v);
        if (squareImageView != null) {
            i3 = R.id.q1l;
            CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.q1l);
            if (circleBoarderImageView != null) {
                i3 = R.id.q7b;
                TextView textView = (TextView) view.findViewById(R.id.q7b);
                if (textView != null) {
                    i3 = R.id.q7c;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q7c);
                    if (linearLayout != null) {
                        i3 = R.id.qtw;
                        TextView textView2 = (TextView) view.findViewById(R.id.qtw);
                        if (textView2 != null) {
                            return new VasSquareChatLandDoubleClickMsgItemViewBinding((RelativeLayout) view, squareImageView, circleBoarderImageView, textView, linearLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
