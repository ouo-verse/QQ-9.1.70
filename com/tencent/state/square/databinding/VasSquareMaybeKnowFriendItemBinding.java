package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.MayKnowAvatarImageView;
import com.tencent.state.view.SquareTabLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareMaybeKnowFriendItemBinding implements ViewBinding {
    public final Button mayKnowButton;
    public final MayKnowAvatarImageView mayKnowCardAvatar;
    public final SquareTabLayout mayKnowLabelsContainer;
    public final RelativeLayout mayKnowNameContainer;
    public final TextView mayKnowNick;
    public final CircleBoarderImageView mayKnowQqAvatar;
    public final TextView mayKnowReason;
    private final RelativeLayout rootView;

    VasSquareMaybeKnowFriendItemBinding(RelativeLayout relativeLayout, Button button, MayKnowAvatarImageView mayKnowAvatarImageView, SquareTabLayout squareTabLayout, RelativeLayout relativeLayout2, TextView textView, CircleBoarderImageView circleBoarderImageView, TextView textView2) {
        this.rootView = relativeLayout;
        this.mayKnowButton = button;
        this.mayKnowCardAvatar = mayKnowAvatarImageView;
        this.mayKnowLabelsContainer = squareTabLayout;
        this.mayKnowNameContainer = relativeLayout2;
        this.mayKnowNick = textView;
        this.mayKnowQqAvatar = circleBoarderImageView;
        this.mayKnowReason = textView2;
    }

    public static VasSquareMaybeKnowFriendItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareMaybeKnowFriendItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareMaybeKnowFriendItemBinding bind(View view) {
        int i3 = R.id.f163458q81;
        Button button = (Button) view.findViewById(R.id.f163458q81);
        if (button != null) {
            i3 = R.id.f163459q82;
            MayKnowAvatarImageView mayKnowAvatarImageView = (MayKnowAvatarImageView) view.findViewById(R.id.f163459q82);
            if (mayKnowAvatarImageView != null) {
                i3 = R.id.f163461q84;
                SquareTabLayout squareTabLayout = (SquareTabLayout) view.findViewById(R.id.f163461q84);
                if (squareTabLayout != null) {
                    i3 = R.id.q86;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.q86);
                    if (relativeLayout != null) {
                        i3 = R.id.q87;
                        TextView textView = (TextView) view.findViewById(R.id.q87);
                        if (textView != null) {
                            i3 = R.id.q88;
                            CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.q88);
                            if (circleBoarderImageView != null) {
                                i3 = R.id.q89;
                                TextView textView2 = (TextView) view.findViewById(R.id.q89);
                                if (textView2 != null) {
                                    return new VasSquareMaybeKnowFriendItemBinding((RelativeLayout) view, button, mayKnowAvatarImageView, squareTabLayout, relativeLayout, textView, circleBoarderImageView, textView2);
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
