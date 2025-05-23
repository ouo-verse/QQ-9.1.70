package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.interaction.widget.InteractionOptionList;
import com.tencent.state.square.interaction.widget.InteractionOrderSelector;
import com.tencent.state.square.interaction.widget.InteractionPlayer;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFragmentInteractionSettingsBinding implements ViewBinding {
    public final LinearLayout buttonsContainer;
    public final Button cancelBtn;
    public final LinearLayout dialogTitle;
    public final TextView dialogTitleText;
    public final LinearLayout listContainer;
    public final InteractionOptionList optionListView;
    public final InteractionOrderSelector orderSelect;
    public final InteractionPlayer player;
    public final FrameLayout playerWrapper;
    private final RelativeLayout rootView;
    public final TextView statusText;
    public final Button submitBtn;

    VasSquareFragmentInteractionSettingsBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, Button button, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, InteractionOptionList interactionOptionList, InteractionOrderSelector interactionOrderSelector, InteractionPlayer interactionPlayer, FrameLayout frameLayout, TextView textView2, Button button2) {
        this.rootView = relativeLayout;
        this.buttonsContainer = linearLayout;
        this.cancelBtn = button;
        this.dialogTitle = linearLayout2;
        this.dialogTitleText = textView;
        this.listContainer = linearLayout3;
        this.optionListView = interactionOptionList;
        this.orderSelect = interactionOrderSelector;
        this.player = interactionPlayer;
        this.playerWrapper = frameLayout;
        this.statusText = textView2;
        this.submitBtn = button2;
    }

    public static VasSquareFragmentInteractionSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentInteractionSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4m, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentInteractionSettingsBinding bind(View view) {
        int i3 = R.id.phm;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.phm);
        if (linearLayout != null) {
            i3 = R.id.pi6;
            Button button = (Button) view.findViewById(R.id.pi6);
            if (button != null) {
                i3 = R.id.ppt;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ppt);
                if (linearLayout2 != null) {
                    i3 = R.id.ppu;
                    TextView textView = (TextView) view.findViewById(R.id.ppu);
                    if (textView != null) {
                        i3 = R.id.q5n;
                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.q5n);
                        if (linearLayout3 != null) {
                            i3 = R.id.qak;
                            InteractionOptionList interactionOptionList = (InteractionOptionList) view.findViewById(R.id.qak);
                            if (interactionOptionList != null) {
                                i3 = R.id.qao;
                                InteractionOrderSelector interactionOrderSelector = (InteractionOrderSelector) view.findViewById(R.id.qao);
                                if (interactionOrderSelector != null) {
                                    i3 = R.id.f163486qd4;
                                    InteractionPlayer interactionPlayer = (InteractionPlayer) view.findViewById(R.id.f163486qd4);
                                    if (interactionPlayer != null) {
                                        i3 = R.id.qd6;
                                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qd6);
                                        if (frameLayout != null) {
                                            i3 = R.id.qnl;
                                            TextView textView2 = (TextView) view.findViewById(R.id.qnl);
                                            if (textView2 != null) {
                                                i3 = R.id.qob;
                                                Button button2 = (Button) view.findViewById(R.id.qob);
                                                if (button2 != null) {
                                                    return new VasSquareFragmentInteractionSettingsBinding((RelativeLayout) view, linearLayout, button, linearLayout2, textView, linearLayout3, interactionOptionList, interactionOrderSelector, interactionPlayer, frameLayout, textView2, button2);
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
