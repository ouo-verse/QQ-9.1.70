package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.view.CircleBoarderImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemLibraryAvatarBinding implements ViewBinding {
    public final SquareAvatarView avatar;
    public final RelativeLayout bubble;
    public final TextView focusText;
    public final CircleBoarderImageView head;
    public final View hitArea;
    public final TextView nick;
    private final RelativeLayout rootView;

    VasSquareItemLibraryAvatarBinding(RelativeLayout relativeLayout, SquareAvatarView squareAvatarView, RelativeLayout relativeLayout2, TextView textView, CircleBoarderImageView circleBoarderImageView, View view, TextView textView2) {
        this.rootView = relativeLayout;
        this.avatar = squareAvatarView;
        this.bubble = relativeLayout2;
        this.focusText = textView;
        this.head = circleBoarderImageView;
        this.hitArea = view;
        this.nick = textView2;
    }

    public static VasSquareItemLibraryAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemLibraryAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5i, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemLibraryAvatarBinding bind(View view) {
        int i3 = R.id.pax;
        SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.pax);
        if (squareAvatarView != null) {
            i3 = R.id.pgr;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pgr);
            if (relativeLayout != null) {
                i3 = R.id.pv5;
                TextView textView = (TextView) view.findViewById(R.id.pv5);
                if (textView != null) {
                    i3 = R.id.pyt;
                    CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.pyt);
                    if (circleBoarderImageView != null) {
                        i3 = R.id.pzs;
                        View findViewById = view.findViewById(R.id.pzs);
                        if (findViewById != null) {
                            i3 = R.id.q_h;
                            TextView textView2 = (TextView) view.findViewById(R.id.q_h);
                            if (textView2 != null) {
                                return new VasSquareItemLibraryAvatarBinding((RelativeLayout) view, squareAvatarView, relativeLayout, textView, circleBoarderImageView, findViewById, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
