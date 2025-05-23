package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.chatland.view.ChatLandInteractionMotionIndicator;
import com.tencent.state.square.chatland.view.ChatLandInteractionMotionInvitePanel;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareFragmentChatLandActionPanelBinding implements ViewBinding {
    public final FrameLayout exitButton;
    public final ChatLandInteractionMotionIndicator interactionMotionIndicator;
    public final ChatLandInteractionMotionInvitePanel interactionMotionInvitePanel;
    public final FrameLayout publicChatBtnContainer;
    public final FrameLayout publicChatListContainer;
    private final FrameLayout rootView;
    public final LinearLayout seatButtonWrapper;
    public final SquareImageView taskButton;
    public final RelativeLayout taskContainer;
    public final View taskRedDot;

    VasSquareFragmentChatLandActionPanelBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ChatLandInteractionMotionIndicator chatLandInteractionMotionIndicator, ChatLandInteractionMotionInvitePanel chatLandInteractionMotionInvitePanel, FrameLayout frameLayout3, FrameLayout frameLayout4, LinearLayout linearLayout, SquareImageView squareImageView, RelativeLayout relativeLayout, View view) {
        this.rootView = frameLayout;
        this.exitButton = frameLayout2;
        this.interactionMotionIndicator = chatLandInteractionMotionIndicator;
        this.interactionMotionInvitePanel = chatLandInteractionMotionInvitePanel;
        this.publicChatBtnContainer = frameLayout3;
        this.publicChatListContainer = frameLayout4;
        this.seatButtonWrapper = linearLayout;
        this.taskButton = squareImageView;
        this.taskContainer = relativeLayout;
        this.taskRedDot = view;
    }

    public static VasSquareFragmentChatLandActionPanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentChatLandActionPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4i, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentChatLandActionPanelBinding bind(View view) {
        int i3 = R.id.pt9;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pt9);
        if (frameLayout != null) {
            i3 = R.id.f163427q24;
            ChatLandInteractionMotionIndicator chatLandInteractionMotionIndicator = (ChatLandInteractionMotionIndicator) view.findViewById(R.id.f163427q24);
            if (chatLandInteractionMotionIndicator != null) {
                i3 = R.id.f163428q25;
                ChatLandInteractionMotionInvitePanel chatLandInteractionMotionInvitePanel = (ChatLandInteractionMotionInvitePanel) view.findViewById(R.id.f163428q25);
                if (chatLandInteractionMotionInvitePanel != null) {
                    i3 = R.id.qeg;
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.qeg);
                    if (frameLayout2 != null) {
                        i3 = R.id.qeh;
                        FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.qeh);
                        if (frameLayout3 != null) {
                            i3 = R.id.qjg;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qjg);
                            if (linearLayout != null) {
                                i3 = R.id.qpn;
                                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qpn);
                                if (squareImageView != null) {
                                    i3 = R.id.qpt;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qpt);
                                    if (relativeLayout != null) {
                                        i3 = R.id.f163551qq4;
                                        View findViewById = view.findViewById(R.id.f163551qq4);
                                        if (findViewById != null) {
                                            return new VasSquareFragmentChatLandActionPanelBinding((FrameLayout) view, frameLayout, chatLandInteractionMotionIndicator, chatLandInteractionMotionInvitePanel, frameLayout2, frameLayout3, linearLayout, squareImageView, relativeLayout, findViewById);
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
