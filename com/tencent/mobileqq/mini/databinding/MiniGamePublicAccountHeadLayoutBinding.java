package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator;
import com.tencent.mobileqq.minigame.publicaccount.view.MiniGamePubViewpager;

/* loaded from: classes33.dex */
public final class MiniGamePublicAccountHeadLayoutBinding implements ViewBinding {
    public final LinearLayout emptyHeader;
    public final URLImageView emptyImage;
    public final MiniGamePubViewpager feedsHeader;
    public final URLImageView gameCenterBtn1;
    public final LinearLayout headerLayout;
    public final FrameLayout headerLayoutBg;
    public final LinearLayout headerLayoutRoot;
    public final ImageView imgFrame;
    public final LinearLayout layoutMiniGameHead;
    public final LinearLayout loadLayout;
    public final TextView moreMsgBtn;
    public final RelativeLayout moreMsgLayout;
    public final TextView moreMsgText;
    public final MiniGamePublicAccountViewPagerIndicator pagerIndicator;
    private final FrameLayout rootView;

    MiniGamePublicAccountHeadLayoutBinding(FrameLayout frameLayout, LinearLayout linearLayout, URLImageView uRLImageView, MiniGamePubViewpager miniGamePubViewpager, URLImageView uRLImageView2, LinearLayout linearLayout2, FrameLayout frameLayout2, LinearLayout linearLayout3, ImageView imageView, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView, RelativeLayout relativeLayout, TextView textView2, MiniGamePublicAccountViewPagerIndicator miniGamePublicAccountViewPagerIndicator) {
        this.rootView = frameLayout;
        this.emptyHeader = linearLayout;
        this.emptyImage = uRLImageView;
        this.feedsHeader = miniGamePubViewpager;
        this.gameCenterBtn1 = uRLImageView2;
        this.headerLayout = linearLayout2;
        this.headerLayoutBg = frameLayout2;
        this.headerLayoutRoot = linearLayout3;
        this.imgFrame = imageView;
        this.layoutMiniGameHead = linearLayout4;
        this.loadLayout = linearLayout5;
        this.moreMsgBtn = textView;
        this.moreMsgLayout = relativeLayout;
        this.moreMsgText = textView2;
        this.pagerIndicator = miniGamePublicAccountViewPagerIndicator;
    }

    public static MiniGamePublicAccountHeadLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGamePublicAccountHeadLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dk_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniGamePublicAccountHeadLayoutBinding bind(View view) {
        int i3 = R.id.rdh;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rdh);
        if (linearLayout != null) {
            i3 = R.id.rdi;
            URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.rdi);
            if (uRLImageView != null) {
                i3 = R.id.rdk;
                MiniGamePubViewpager miniGamePubViewpager = (MiniGamePubViewpager) ViewBindings.findChildViewById(view, R.id.rdk);
                if (miniGamePubViewpager != null) {
                    i3 = R.id.rdm;
                    URLImageView uRLImageView2 = (URLImageView) ViewBindings.findChildViewById(view, R.id.rdm);
                    if (uRLImageView2 != null) {
                        i3 = R.id.rds;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rds);
                        if (linearLayout2 != null) {
                            i3 = R.id.rdt;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rdt);
                            if (frameLayout != null) {
                                i3 = R.id.rdu;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rdu);
                                if (linearLayout3 != null) {
                                    i3 = R.id.f163676re3;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163676re3);
                                    if (imageView != null) {
                                        i3 = R.id.rel;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rel);
                                        if (linearLayout4 != null) {
                                            i3 = R.id.rev;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rev);
                                            if (linearLayout5 != null) {
                                                i3 = R.id.f163705rk2;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163705rk2);
                                                if (textView != null) {
                                                    i3 = R.id.f163706rk3;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163706rk3);
                                                    if (relativeLayout != null) {
                                                        i3 = R.id.f163707rk4;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163707rk4);
                                                        if (textView2 != null) {
                                                            i3 = R.id.rka;
                                                            MiniGamePublicAccountViewPagerIndicator miniGamePublicAccountViewPagerIndicator = (MiniGamePublicAccountViewPagerIndicator) ViewBindings.findChildViewById(view, R.id.rka);
                                                            if (miniGamePublicAccountViewPagerIndicator != null) {
                                                                return new MiniGamePublicAccountHeadLayoutBinding((FrameLayout) view, linearLayout, uRLImageView, miniGamePubViewpager, uRLImageView2, linearLayout2, frameLayout, linearLayout3, imageView, linearLayout4, linearLayout5, textView, relativeLayout, textView2, miniGamePublicAccountViewPagerIndicator);
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
