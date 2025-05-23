package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ZtpSquareGiftItemBinding implements ViewBinding {
    public final LinearLayout giftBackground;
    public final LinearLayout giftButton;
    public final TextView giftButtonTitle;
    public final SquareImageView imageView;
    public final SquareImageView lockIcon;
    public final TextView nameLabel;
    private final RelativeLayout rootView;
    public final TextView validTimeLabel;

    ZtpSquareGiftItemBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.giftBackground = linearLayout;
        this.giftButton = linearLayout2;
        this.giftButtonTitle = textView;
        this.imageView = squareImageView;
        this.lockIcon = squareImageView2;
        this.nameLabel = textView2;
        this.validTimeLabel = textView3;
    }

    public static ZtpSquareGiftItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareGiftItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dhr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ZtpSquareGiftItemBinding bind(View view) {
        int i3 = R.id.pwt;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pwt);
        if (linearLayout != null) {
            i3 = R.id.pwu;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.pwu);
            if (linearLayout2 != null) {
                i3 = R.id.pwv;
                TextView textView = (TextView) view.findViewById(R.id.pwv);
                if (textView != null) {
                    i3 = R.id.q1e;
                    SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q1e);
                    if (squareImageView != null) {
                        i3 = R.id.q76;
                        SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.q76);
                        if (squareImageView2 != null) {
                            i3 = R.id.q_8;
                            TextView textView2 = (TextView) view.findViewById(R.id.q_8);
                            if (textView2 != null) {
                                i3 = R.id.qwh;
                                TextView textView3 = (TextView) view.findViewById(R.id.qwh);
                                if (textView3 != null) {
                                    return new ZtpSquareGiftItemBinding((RelativeLayout) view, linearLayout, linearLayout2, textView, squareImageView, squareImageView2, textView2, textView3);
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
