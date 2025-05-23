package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHeadLayout;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountNavBar;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebView;

/* loaded from: classes33.dex */
public final class MiniGamePublicAccountLayoutBinding implements ViewBinding {
    public final URLImageView gameCenterBtn2;
    public final LinearLayout layoutTitle;
    public final MiniGamePublicAccountHeadLayout qqgameHeadLayout;
    public final MiniGamePublicAccountWebView qqgameWebview;
    public final MiniGamePublicAccountNavBar rlCommenTitle;
    public final LinearLayout root;
    public final FrameLayout rootContainer;
    private final FrameLayout rootView;

    MiniGamePublicAccountLayoutBinding(FrameLayout frameLayout, URLImageView uRLImageView, LinearLayout linearLayout, MiniGamePublicAccountHeadLayout miniGamePublicAccountHeadLayout, MiniGamePublicAccountWebView miniGamePublicAccountWebView, MiniGamePublicAccountNavBar miniGamePublicAccountNavBar, LinearLayout linearLayout2, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.gameCenterBtn2 = uRLImageView;
        this.layoutTitle = linearLayout;
        this.qqgameHeadLayout = miniGamePublicAccountHeadLayout;
        this.qqgameWebview = miniGamePublicAccountWebView;
        this.rlCommenTitle = miniGamePublicAccountNavBar;
        this.root = linearLayout2;
        this.rootContainer = frameLayout2;
    }

    public static MiniGamePublicAccountLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGamePublicAccountLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dka, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniGamePublicAccountLayoutBinding bind(View view) {
        int i3 = R.id.rdn;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.rdn);
        if (uRLImageView != null) {
            i3 = R.id.rem;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rem);
            if (linearLayout != null) {
                i3 = R.id.rkq;
                MiniGamePublicAccountHeadLayout miniGamePublicAccountHeadLayout = (MiniGamePublicAccountHeadLayout) ViewBindings.findChildViewById(view, R.id.rkq);
                if (miniGamePublicAccountHeadLayout != null) {
                    i3 = R.id.rkr;
                    MiniGamePublicAccountWebView miniGamePublicAccountWebView = (MiniGamePublicAccountWebView) ViewBindings.findChildViewById(view, R.id.rkr);
                    if (miniGamePublicAccountWebView != null) {
                        i3 = R.id.f163708rl0;
                        MiniGamePublicAccountNavBar miniGamePublicAccountNavBar = (MiniGamePublicAccountNavBar) ViewBindings.findChildViewById(view, R.id.f163708rl0);
                        if (miniGamePublicAccountNavBar != null) {
                            i3 = R.id.f163710rl2;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163710rl2);
                            if (linearLayout2 != null) {
                                FrameLayout frameLayout = (FrameLayout) view;
                                return new MiniGamePublicAccountLayoutBinding(frameLayout, uRLImageView, linearLayout, miniGamePublicAccountHeadLayout, miniGamePublicAccountWebView, miniGamePublicAccountNavBar, linearLayout2, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
