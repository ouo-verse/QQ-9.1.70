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
import com.tencent.state.square.chatland.view.ChatLandSpeakBubbleView;
import com.tencent.state.view.AvatarOnlineStatusSimpleBubble;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemChatLandAvatarBinding implements ViewBinding {
    public final SquareImageView arrow;
    public final SquareAvatarView avatar;
    public final TextView avatarName;
    public final FrameLayout avatarNameContainer;
    public final LinearLayout avatarNameInteractionContainer;
    public final FrameLayout bubbleContainer;
    public final ChatLandSpeakBubbleView chatLandSpeakBubble;
    public final TextView firstName;
    public final View hitArea;
    public final LinearLayout pkResultArea;
    public final TextView pkResultTitle;
    public final FrameLayout ringPag;
    private final RelativeLayout rootView;
    public final TextView secondName;
    public final AvatarOnlineStatusSimpleBubble squareAvatarBubble;

    VasSquareItemChatLandAvatarBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, SquareAvatarView squareAvatarView, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, ChatLandSpeakBubbleView chatLandSpeakBubbleView, TextView textView2, View view, LinearLayout linearLayout2, TextView textView3, FrameLayout frameLayout3, TextView textView4, AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble) {
        this.rootView = relativeLayout;
        this.arrow = squareImageView;
        this.avatar = squareAvatarView;
        this.avatarName = textView;
        this.avatarNameContainer = frameLayout;
        this.avatarNameInteractionContainer = linearLayout;
        this.bubbleContainer = frameLayout2;
        this.chatLandSpeakBubble = chatLandSpeakBubbleView;
        this.firstName = textView2;
        this.hitArea = view;
        this.pkResultArea = linearLayout2;
        this.pkResultTitle = textView3;
        this.ringPag = frameLayout3;
        this.secondName = textView4;
        this.squareAvatarBubble = avatarOnlineStatusSimpleBubble;
    }

    public static VasSquareItemChatLandAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemChatLandAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemChatLandAvatarBinding bind(View view) {
        int i3 = R.id.pap;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pap);
        if (squareImageView != null) {
            i3 = R.id.pax;
            SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.pax);
            if (squareAvatarView != null) {
                i3 = R.id.pcf;
                TextView textView = (TextView) view.findViewById(R.id.pcf);
                if (textView != null) {
                    i3 = R.id.pcg;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pcg);
                    if (frameLayout != null) {
                        i3 = R.id.pch;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pch);
                        if (linearLayout != null) {
                            i3 = R.id.pgw;
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.pgw);
                            if (frameLayout2 != null) {
                                i3 = R.id.f163328pj2;
                                ChatLandSpeakBubbleView chatLandSpeakBubbleView = (ChatLandSpeakBubbleView) view.findViewById(R.id.f163328pj2);
                                if (chatLandSpeakBubbleView != null) {
                                    i3 = R.id.pu8;
                                    TextView textView2 = (TextView) view.findViewById(R.id.pu8);
                                    if (textView2 != null) {
                                        i3 = R.id.pzs;
                                        View findViewById = view.findViewById(R.id.pzs);
                                        if (findViewById != null) {
                                            i3 = R.id.qcr;
                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.qcr);
                                            if (linearLayout2 != null) {
                                                i3 = R.id.qcs;
                                                TextView textView3 = (TextView) view.findViewById(R.id.qcs);
                                                if (textView3 != null) {
                                                    i3 = R.id.qhz;
                                                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.qhz);
                                                    if (frameLayout3 != null) {
                                                        i3 = R.id.qjj;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.qjj);
                                                        if (textView4 != null) {
                                                            i3 = R.id.qmx;
                                                            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = (AvatarOnlineStatusSimpleBubble) view.findViewById(R.id.qmx);
                                                            if (avatarOnlineStatusSimpleBubble != null) {
                                                                return new VasSquareItemChatLandAvatarBinding((RelativeLayout) view, squareImageView, squareAvatarView, textView, frameLayout, linearLayout, frameLayout2, chatLandSpeakBubbleView, textView2, findViewById, linearLayout2, textView3, frameLayout3, textView4, avatarOnlineStatusSimpleBubble);
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
