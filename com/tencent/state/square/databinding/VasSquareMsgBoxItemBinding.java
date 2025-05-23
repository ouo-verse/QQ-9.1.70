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
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareMsgBoxItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final CircleBoarderImageView vasSquareMsgBoxItemAvatar;
    public final FrameLayout vasSquareMsgBoxItemAvatarContainer;
    public final LinearLayout vasSquareMsgBoxItemContainer;
    public final RelativeLayout vasSquareMsgBoxItemContentContainer;
    public final TextView vasSquareMsgBoxItemFrom;
    public final TextView vasSquareMsgBoxItemNick;
    public final RelativeLayout vasSquareMsgBoxItemOperateAdd;
    public final SquareImageView vasSquareMsgBoxItemOperateAddIcon;
    public final TextView vasSquareMsgBoxItemOperateAddText;
    public final FrameLayout vasSquareMsgBoxItemOperateContainer;
    public final RelativeLayout vasSquareMsgBoxItemOperateLocate;
    public final SquareImageView vasSquareMsgBoxItemOperateLocateIcon;
    public final TextView vasSquareMsgBoxItemOperateLocateText;
    public final LinearLayout vasSquareMsgBoxItemPreviewContainer;
    public final TextView vasSquareMsgBoxItemReddot;
    public final FrameLayout vasSquareMsgBoxItemSummaryContainer;
    public final TextView vasSquareMsgBoxItemSummaryText;
    public final TextView vasSquareMsgBoxItemTime;

    VasSquareMsgBoxItemBinding(LinearLayout linearLayout, CircleBoarderImageView circleBoarderImageView, FrameLayout frameLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, RelativeLayout relativeLayout2, SquareImageView squareImageView, TextView textView3, FrameLayout frameLayout2, RelativeLayout relativeLayout3, SquareImageView squareImageView2, TextView textView4, LinearLayout linearLayout3, TextView textView5, FrameLayout frameLayout3, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.vasSquareMsgBoxItemAvatar = circleBoarderImageView;
        this.vasSquareMsgBoxItemAvatarContainer = frameLayout;
        this.vasSquareMsgBoxItemContainer = linearLayout2;
        this.vasSquareMsgBoxItemContentContainer = relativeLayout;
        this.vasSquareMsgBoxItemFrom = textView;
        this.vasSquareMsgBoxItemNick = textView2;
        this.vasSquareMsgBoxItemOperateAdd = relativeLayout2;
        this.vasSquareMsgBoxItemOperateAddIcon = squareImageView;
        this.vasSquareMsgBoxItemOperateAddText = textView3;
        this.vasSquareMsgBoxItemOperateContainer = frameLayout2;
        this.vasSquareMsgBoxItemOperateLocate = relativeLayout3;
        this.vasSquareMsgBoxItemOperateLocateIcon = squareImageView2;
        this.vasSquareMsgBoxItemOperateLocateText = textView4;
        this.vasSquareMsgBoxItemPreviewContainer = linearLayout3;
        this.vasSquareMsgBoxItemReddot = textView5;
        this.vasSquareMsgBoxItemSummaryContainer = frameLayout3;
        this.vasSquareMsgBoxItemSummaryText = textView6;
        this.vasSquareMsgBoxItemTime = textView7;
    }

    public static VasSquareMsgBoxItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareMsgBoxItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareMsgBoxItemBinding bind(View view) {
        int i3 = R.id.qxh;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.qxh);
        if (circleBoarderImageView != null) {
            i3 = R.id.qxi;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qxi);
            if (frameLayout != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i3 = R.id.qxk;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qxk);
                if (relativeLayout != null) {
                    i3 = R.id.qxl;
                    TextView textView = (TextView) view.findViewById(R.id.qxl);
                    if (textView != null) {
                        i3 = R.id.qxm;
                        TextView textView2 = (TextView) view.findViewById(R.id.qxm);
                        if (textView2 != null) {
                            i3 = R.id.qxn;
                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qxn);
                            if (relativeLayout2 != null) {
                                i3 = R.id.qxo;
                                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qxo);
                                if (squareImageView != null) {
                                    i3 = R.id.qxp;
                                    TextView textView3 = (TextView) view.findViewById(R.id.qxp);
                                    if (textView3 != null) {
                                        i3 = R.id.qxq;
                                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.qxq);
                                        if (frameLayout2 != null) {
                                            i3 = R.id.qxr;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.qxr);
                                            if (relativeLayout3 != null) {
                                                i3 = R.id.qxs;
                                                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qxs);
                                                if (squareImageView2 != null) {
                                                    i3 = R.id.qxt;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.qxt);
                                                    if (textView4 != null) {
                                                        i3 = R.id.qxu;
                                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.qxu);
                                                        if (linearLayout2 != null) {
                                                            i3 = R.id.qxv;
                                                            TextView textView5 = (TextView) view.findViewById(R.id.qxv);
                                                            if (textView5 != null) {
                                                                i3 = R.id.qxw;
                                                                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.qxw);
                                                                if (frameLayout3 != null) {
                                                                    i3 = R.id.qxx;
                                                                    TextView textView6 = (TextView) view.findViewById(R.id.qxx);
                                                                    if (textView6 != null) {
                                                                        i3 = R.id.qxy;
                                                                        TextView textView7 = (TextView) view.findViewById(R.id.qxy);
                                                                        if (textView7 != null) {
                                                                            return new VasSquareMsgBoxItemBinding(linearLayout, circleBoarderImageView, frameLayout, linearLayout, relativeLayout, textView, textView2, relativeLayout2, squareImageView, textView3, frameLayout2, relativeLayout3, squareImageView2, textView4, linearLayout2, textView5, frameLayout3, textView6, textView7);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
