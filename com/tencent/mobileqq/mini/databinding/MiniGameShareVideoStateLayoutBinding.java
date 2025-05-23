package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.CircleProgress;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameShareVideoStateLayoutBinding implements ViewBinding {
    public final CircleProgress miniGameShareLoadingBar;
    public final FrameLayout miniGameShareLoadingContainer;
    public final TextView miniGameShareLoadingText;
    public final ImageView miniGameShareVideoPause;
    public final ImageView miniGameShareVideoPlay;
    private final FrameLayout rootView;

    MiniGameShareVideoStateLayoutBinding(FrameLayout frameLayout, CircleProgress circleProgress, FrameLayout frameLayout2, TextView textView, ImageView imageView, ImageView imageView2) {
        this.rootView = frameLayout;
        this.miniGameShareLoadingBar = circleProgress;
        this.miniGameShareLoadingContainer = frameLayout2;
        this.miniGameShareLoadingText = textView;
        this.miniGameShareVideoPause = imageView;
        this.miniGameShareVideoPlay = imageView2;
    }

    public static MiniGameShareVideoStateLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameShareVideoStateLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkh, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameShareVideoStateLayoutBinding bind(View view) {
        int i3 = R.id.ri9;
        CircleProgress circleProgress = (CircleProgress) ViewBindings.findChildViewById(view, R.id.ri9);
        if (circleProgress != null) {
            i3 = R.id.ri_;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.ri_);
            if (frameLayout != null) {
                i3 = R.id.ria;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ria);
                if (textView != null) {
                    i3 = R.id.rig;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rig);
                    if (imageView != null) {
                        i3 = R.id.rih;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rih);
                        if (imageView2 != null) {
                            return new MiniGameShareVideoStateLayoutBinding((FrameLayout) view, circleProgress, frameLayout, textView, imageView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
