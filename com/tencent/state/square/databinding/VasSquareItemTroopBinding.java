package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.view.SquareImageView;
import com.tencent.state.view.SquareTroopMessageBubble;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemTroopBinding implements ViewBinding {
    public final RelativeLayout baseBubble;
    public final TextView debugTips;
    public final SquareAvatarView ownerAvatar;
    private final RelativeLayout rootView;
    public final RelativeLayout summaryContainer;
    public final SquareImageView troopIcon;
    public final SquareTroopMessageBubble troopMessageBubble;
    public final TextView troopNick;
    public final LinearLayout troopNickContainer;
    public final FrameLayout troopPag;
    public final FrameLayout troopRingPag;
    public final RelativeLayout troopRoot;
    public final RelativeLayout troopRootView;
    public final SquareImageView troopTent;
    public final TextView unreadNum;
    public final TextView unreadText;

    public static VasSquareItemTroopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    VasSquareItemTroopBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, SquareAvatarView squareAvatarView, RelativeLayout relativeLayout3, SquareImageView squareImageView, SquareTroopMessageBubble squareTroopMessageBubble, TextView textView2, LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, SquareImageView squareImageView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.baseBubble = relativeLayout2;
        this.debugTips = textView;
        this.ownerAvatar = squareAvatarView;
        this.summaryContainer = relativeLayout3;
        this.troopIcon = squareImageView;
        this.troopMessageBubble = squareTroopMessageBubble;
        this.troopNick = textView2;
        this.troopNickContainer = linearLayout;
        this.troopPag = frameLayout;
        this.troopRingPag = frameLayout2;
        this.troopRoot = relativeLayout4;
        this.troopRootView = relativeLayout5;
        this.troopTent = squareImageView2;
        this.unreadNum = textView3;
        this.unreadText = textView4;
    }

    public static VasSquareItemTroopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5o, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemTroopBinding bind(View view) {
        int i3 = R.id.pdj;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pdj);
        if (relativeLayout != null) {
            i3 = R.id.poi;
            TextView textView = (TextView) view.findViewById(R.id.poi);
            if (textView != null) {
                i3 = R.id.f163474qb2;
                SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.f163474qb2);
                if (squareAvatarView != null) {
                    i3 = R.id.qow;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qow);
                    if (relativeLayout2 != null) {
                        i3 = R.id.qsm;
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qsm);
                        if (squareImageView != null) {
                            i3 = R.id.qsn;
                            SquareTroopMessageBubble squareTroopMessageBubble = (SquareTroopMessageBubble) view.findViewById(R.id.qsn);
                            if (squareTroopMessageBubble != null) {
                                i3 = R.id.qso;
                                TextView textView2 = (TextView) view.findViewById(R.id.qso);
                                if (textView2 != null) {
                                    i3 = R.id.qsp;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qsp);
                                    if (linearLayout != null) {
                                        i3 = R.id.qsq;
                                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qsq);
                                        if (frameLayout != null) {
                                            i3 = R.id.qsr;
                                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.qsr);
                                            if (frameLayout2 != null) {
                                                RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                                i3 = R.id.qst;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.qst);
                                                if (relativeLayout4 != null) {
                                                    i3 = R.id.qsu;
                                                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qsu);
                                                    if (squareImageView2 != null) {
                                                        i3 = R.id.qv_;
                                                        TextView textView3 = (TextView) view.findViewById(R.id.qv_);
                                                        if (textView3 != null) {
                                                            i3 = R.id.qvc;
                                                            TextView textView4 = (TextView) view.findViewById(R.id.qvc);
                                                            if (textView4 != null) {
                                                                return new VasSquareItemTroopBinding(relativeLayout3, relativeLayout, textView, squareAvatarView, relativeLayout2, squareImageView, squareTroopMessageBubble, textView2, linearLayout, frameLayout, frameLayout2, relativeLayout3, relativeLayout4, squareImageView2, textView3, textView4);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
