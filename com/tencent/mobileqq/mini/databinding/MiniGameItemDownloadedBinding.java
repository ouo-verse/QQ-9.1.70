package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameItemDownloadedBinding implements ViewBinding {
    public final Button controller;
    public final RoundImageView cover;
    public final Button delete;
    public final TextView occupySpaceTxv;
    private final RelativeLayout rootView;
    public final TextView title;

    MiniGameItemDownloadedBinding(RelativeLayout relativeLayout, Button button, RoundImageView roundImageView, Button button2, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.controller = button;
        this.cover = roundImageView;
        this.delete = button2;
        this.occupySpaceTxv = textView;
        this.title = textView2;
    }

    public static MiniGameItemDownloadedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameItemDownloadedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167484dk3, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameItemDownloadedBinding bind(View view) {
        int i3 = R.id.rcq;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.rcq);
        if (button != null) {
            i3 = R.id.rcr;
            RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.rcr);
            if (roundImageView != null) {
                i3 = R.id.rct;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.rct);
                if (button2 != null) {
                    i3 = R.id.rk_;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rk_);
                    if (textView != null) {
                        i3 = R.id.rlg;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rlg);
                        if (textView2 != null) {
                            return new MiniGameItemDownloadedBinding((RelativeLayout) view, button, roundImageView, button2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
