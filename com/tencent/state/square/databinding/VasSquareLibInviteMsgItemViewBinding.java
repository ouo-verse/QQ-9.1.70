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

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibInviteMsgItemViewBinding implements ViewBinding {
    public final CircleBoarderImageView imgAvatar;
    public final LinearLayout lvTagLine;
    private final RelativeLayout rootView;
    public final TextView tvMsg;

    VasSquareLibInviteMsgItemViewBinding(RelativeLayout relativeLayout, CircleBoarderImageView circleBoarderImageView, LinearLayout linearLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.imgAvatar = circleBoarderImageView;
        this.lvTagLine = linearLayout;
        this.tvMsg = textView;
    }

    public static VasSquareLibInviteMsgItemViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibInviteMsgItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5p, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLibInviteMsgItemViewBinding bind(View view) {
        int i3 = R.id.q1l;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.q1l);
        if (circleBoarderImageView != null) {
            i3 = R.id.q7c;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q7c);
            if (linearLayout != null) {
                i3 = R.id.qtw;
                TextView textView = (TextView) view.findViewById(R.id.qtw);
                if (textView != null) {
                    return new VasSquareLibInviteMsgItemViewBinding((RelativeLayout) view, circleBoarderImageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
