package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameVaInstallAppLoadingFragmentBinding implements ViewBinding {
    public final ImageView loadingImage;
    public final ProgressBar progressBar;
    public final TextView progressText;
    private final FrameLayout rootView;

    MiniGameVaInstallAppLoadingFragmentBinding(FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar, TextView textView) {
        this.rootView = frameLayout;
        this.loadingImage = imageView;
        this.progressBar = progressBar;
        this.progressText = textView;
    }

    public static MiniGameVaInstallAppLoadingFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameVaInstallAppLoadingFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameVaInstallAppLoadingFragmentBinding bind(View view) {
        int i3 = R.id.f163681rf3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163681rf3);
        if (imageView != null) {
            i3 = R.id.rkk;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.rkk);
            if (progressBar != null) {
                i3 = R.id.rkm;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rkm);
                if (textView != null) {
                    return new MiniGameVaInstallAppLoadingFragmentBinding((FrameLayout) view, imageView, progressBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
