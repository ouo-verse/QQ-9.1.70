package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareSingleCheckBoxView;

/* loaded from: classes38.dex */
public final class VasSquareChatLandInteractionMotionInvitePanelBinding implements ViewBinding {
    public final TextView btnAgree;
    public final TextView btnIgnore;
    public final View checkBoxIgnoreHotspot;
    public final SquareSingleCheckBoxView checkboxIgnore;
    public final CircleBoarderImageView imgAvatar;
    public final LinearLayout lvBtns;
    private final View rootView;
    public final TextView tvNickname;
    public final TextView tvTitle;

    VasSquareChatLandInteractionMotionInvitePanelBinding(View view, TextView textView, TextView textView2, View view2, SquareSingleCheckBoxView squareSingleCheckBoxView, CircleBoarderImageView circleBoarderImageView, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        this.rootView = view;
        this.btnAgree = textView;
        this.btnIgnore = textView2;
        this.checkBoxIgnoreHotspot = view2;
        this.checkboxIgnore = squareSingleCheckBoxView;
        this.imgAvatar = circleBoarderImageView;
        this.lvBtns = linearLayout;
        this.tvNickname = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandInteractionMotionInvitePanelBinding bind(View view) {
        int i3 = R.id.pf8;
        TextView textView = (TextView) view.findViewById(R.id.pf8);
        if (textView != null) {
            i3 = R.id.pg5;
            TextView textView2 = (TextView) view.findViewById(R.id.pg5);
            if (textView2 != null) {
                i3 = R.id.pj7;
                View findViewById = view.findViewById(R.id.pj7);
                if (findViewById != null) {
                    i3 = R.id.pjd;
                    SquareSingleCheckBoxView squareSingleCheckBoxView = (SquareSingleCheckBoxView) view.findViewById(R.id.pjd);
                    if (squareSingleCheckBoxView != null) {
                        i3 = R.id.q1l;
                        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.q1l);
                        if (circleBoarderImageView != null) {
                            i3 = R.id.q7a;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q7a);
                            if (linearLayout != null) {
                                i3 = R.id.qty;
                                TextView textView3 = (TextView) view.findViewById(R.id.qty);
                                if (textView3 != null) {
                                    i3 = R.id.que;
                                    TextView textView4 = (TextView) view.findViewById(R.id.que);
                                    if (textView4 != null) {
                                        return new VasSquareChatLandInteractionMotionInvitePanelBinding(view, textView, textView2, findViewById, squareSingleCheckBoxView, circleBoarderImageView, linearLayout, textView3, textView4);
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

    public static VasSquareChatLandInteractionMotionInvitePanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3p, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
