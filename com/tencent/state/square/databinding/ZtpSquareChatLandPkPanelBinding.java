package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class ZtpSquareChatLandPkPanelBinding implements ViewBinding {
    public final SquareImageView closeBtn;
    public final ZtpSquareChatLandPkItemBinding opposeItem;
    public final RelativeLayout panelContainer;
    public final LinearLayout pkItemContainer;
    public final TextView pkTitle;
    public final SquareImageView pkTopicIcon;
    private final View rootView;
    public final ZtpSquareChatLandPkItemBinding supportItem;

    ZtpSquareChatLandPkPanelBinding(View view, SquareImageView squareImageView, ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding, RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, SquareImageView squareImageView2, ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding2) {
        this.rootView = view;
        this.closeBtn = squareImageView;
        this.opposeItem = ztpSquareChatLandPkItemBinding;
        this.panelContainer = relativeLayout;
        this.pkItemContainer = linearLayout;
        this.pkTitle = textView;
        this.pkTopicIcon = squareImageView2;
        this.supportItem = ztpSquareChatLandPkItemBinding2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ZtpSquareChatLandPkPanelBinding bind(View view) {
        int i3 = R.id.pk9;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pk9);
        if (squareImageView != null) {
            i3 = R.id.qaj;
            View findViewById = view.findViewById(R.id.qaj);
            if (findViewById != null) {
                ZtpSquareChatLandPkItemBinding bind = ZtpSquareChatLandPkItemBinding.bind(findViewById);
                i3 = R.id.qbk;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qbk);
                if (relativeLayout != null) {
                    i3 = R.id.qcq;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qcq);
                    if (linearLayout != null) {
                        i3 = R.id.qct;
                        TextView textView = (TextView) view.findViewById(R.id.qct);
                        if (textView != null) {
                            i3 = R.id.qcu;
                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qcu);
                            if (squareImageView2 != null) {
                                i3 = R.id.qox;
                                View findViewById2 = view.findViewById(R.id.qox);
                                if (findViewById2 != null) {
                                    return new ZtpSquareChatLandPkPanelBinding(view, squareImageView, bind, relativeLayout, linearLayout, textView, squareImageView2, ZtpSquareChatLandPkItemBinding.bind(findViewById2));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ZtpSquareChatLandPkPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dhq, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
