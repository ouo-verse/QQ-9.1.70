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
import com.tencent.state.view.CircleBoarderImageView;

/* loaded from: classes38.dex */
public final class VasSquareChatLandMsgPanelViewBinding implements ViewBinding {
    public final FrameLayout container;
    public final LinearLayout itemAddSquare;
    public final LinearLayout itemViewMerge;
    public final LinearLayout itemViewProfile;
    public final LinearLayout itemViewSayHi;
    public final LinearLayout mergePanel;
    public final LinearLayout receiverContainer;
    public final CircleBoarderImageView receiverHeader;
    public final TextView receiverName;
    private final FrameLayout rootView;
    public final LinearLayout senderContainer;
    public final CircleBoarderImageView senderHeader;
    public final TextView senderName;
    public final RelativeLayout singlePanel;

    VasSquareChatLandMsgPanelViewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, CircleBoarderImageView circleBoarderImageView, TextView textView, LinearLayout linearLayout7, CircleBoarderImageView circleBoarderImageView2, TextView textView2, RelativeLayout relativeLayout) {
        this.rootView = frameLayout;
        this.container = frameLayout2;
        this.itemAddSquare = linearLayout;
        this.itemViewMerge = linearLayout2;
        this.itemViewProfile = linearLayout3;
        this.itemViewSayHi = linearLayout4;
        this.mergePanel = linearLayout5;
        this.receiverContainer = linearLayout6;
        this.receiverHeader = circleBoarderImageView;
        this.receiverName = textView;
        this.senderContainer = linearLayout7;
        this.senderHeader = circleBoarderImageView2;
        this.senderName = textView2;
        this.singlePanel = relativeLayout;
    }

    public static VasSquareChatLandMsgPanelViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareChatLandMsgPanelViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3q, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandMsgPanelViewBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i3 = R.id.q37;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q37);
        if (linearLayout != null) {
            i3 = R.id.q3q;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.q3q);
            if (linearLayout2 != null) {
                i3 = R.id.q3r;
                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.q3r);
                if (linearLayout3 != null) {
                    i3 = R.id.q3s;
                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.q3s);
                    if (linearLayout4 != null) {
                        i3 = R.id.f163465q93;
                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.f163465q93);
                        if (linearLayout5 != null) {
                            i3 = R.id.qfj;
                            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.qfj);
                            if (linearLayout6 != null) {
                                i3 = R.id.qfk;
                                CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.qfk);
                                if (circleBoarderImageView != null) {
                                    i3 = R.id.qfl;
                                    TextView textView = (TextView) view.findViewById(R.id.qfl);
                                    if (textView != null) {
                                        i3 = R.id.qkc;
                                        LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.qkc);
                                        if (linearLayout7 != null) {
                                            i3 = R.id.qkd;
                                            CircleBoarderImageView circleBoarderImageView2 = (CircleBoarderImageView) view.findViewById(R.id.qkd);
                                            if (circleBoarderImageView2 != null) {
                                                i3 = R.id.qkf;
                                                TextView textView2 = (TextView) view.findViewById(R.id.qkf);
                                                if (textView2 != null) {
                                                    i3 = R.id.qm9;
                                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qm9);
                                                    if (relativeLayout != null) {
                                                        return new VasSquareChatLandMsgPanelViewBinding((FrameLayout) view, frameLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, circleBoarderImageView, textView, linearLayout7, circleBoarderImageView2, textView2, relativeLayout);
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
