package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameItemDownloadingBinding implements ViewBinding {
    public final Button cancel;
    public final Button controller;
    public final RoundImageView cover;
    public final TextView progressDes;
    public final ProgressBar progressbar;
    private final RelativeLayout rootView;
    public final TextView title;

    MiniGameItemDownloadingBinding(RelativeLayout relativeLayout, Button button, Button button2, RoundImageView roundImageView, TextView textView, ProgressBar progressBar, TextView textView2) {
        this.rootView = relativeLayout;
        this.cancel = button;
        this.controller = button2;
        this.cover = roundImageView;
        this.progressDes = textView;
        this.progressbar = progressBar;
        this.title = textView2;
    }

    public static MiniGameItemDownloadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameItemDownloadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167485dk4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameItemDownloadingBinding bind(View view) {
        int i3 = R.id.rcl;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.rcl);
        if (button != null) {
            i3 = R.id.rcq;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.rcq);
            if (button2 != null) {
                i3 = R.id.rcr;
                RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.rcr);
                if (roundImageView != null) {
                    i3 = R.id.rkl;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rkl);
                    if (textView != null) {
                        i3 = R.id.rkn;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.rkn);
                        if (progressBar != null) {
                            i3 = R.id.rlg;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rlg);
                            if (textView2 != null) {
                                return new MiniGameItemDownloadingBinding((RelativeLayout) view, button, button2, roundImageView, textView, progressBar, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
