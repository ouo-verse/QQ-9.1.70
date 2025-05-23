package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ZtpSquareGiftSettingDialogBinding implements ViewBinding {
    public final TextView awardDesc;
    public final TextView closeButton;
    public final Button confirmButton;
    private final RelativeLayout rootView;
    public final SquareImageView taskAwardIcon;
    public final TextView taskAwardName;
    public final TextView taskTitle;

    ZtpSquareGiftSettingDialogBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, Button button, SquareImageView squareImageView, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.awardDesc = textView;
        this.closeButton = textView2;
        this.confirmButton = button;
        this.taskAwardIcon = squareImageView;
        this.taskAwardName = textView3;
        this.taskTitle = textView4;
    }

    public static ZtpSquareGiftSettingDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareGiftSettingDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dhs, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ZtpSquareGiftSettingDialogBinding bind(View view) {
        int i3 = R.id.pcw;
        TextView textView = (TextView) view.findViewById(R.id.pcw);
        if (textView != null) {
            i3 = R.id.pk_;
            TextView textView2 = (TextView) view.findViewById(R.id.pk_);
            if (textView2 != null) {
                i3 = R.id.plr;
                Button button = (Button) view.findViewById(R.id.plr);
                if (button != null) {
                    i3 = R.id.qpk;
                    SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qpk);
                    if (squareImageView != null) {
                        i3 = R.id.qpl;
                        TextView textView3 = (TextView) view.findViewById(R.id.qpl);
                        if (textView3 != null) {
                            i3 = R.id.qq6;
                            TextView textView4 = (TextView) view.findViewById(R.id.qq6);
                            if (textView4 != null) {
                                return new ZtpSquareGiftSettingDialogBinding((RelativeLayout) view, textView, textView2, button, squareImageView, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
