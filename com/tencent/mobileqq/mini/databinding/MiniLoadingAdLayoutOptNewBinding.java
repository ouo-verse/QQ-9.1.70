package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniLoadingAdLayoutOptNewBinding implements ViewBinding {
    public final TextView developerDesc;
    public final TextView gamePublicationInfoFirst;
    public final TextView gamePublicationInfoSecond;
    public final ConstraintLayout loadingAdContainer;
    public final TextView loadingAdCountdownText;
    public final ImageView loadingAdImg;
    public final FrameLayout loadingAdParent;
    public final TextView loadingAdSign;
    public final View loadingAdSlideArea;
    public final View loadingAdSlideAreaMask;
    public final ViewStub miniLoadingAdAppLayoutStub;
    public final TextView miniLoadingAdAppText;
    public final ImageView miniLoadingAdBar;
    public final ImageView miniLoadingAdBarIcon;
    public final FrameLayout miniLoadingAdBottomLayoutContainer;
    public final ImageView miniLoadingAdCountdownBg;
    public final LinearLayout miniLoadingAdDeveloperDescLayout;
    public final ViewStub miniLoadingAdGameLayoutStub;
    public final URLImageView miniLoadingAdSlideIcon;
    public final ViewStub miniLoadingSlideLayoutStub;
    private final FrameLayout rootView;

    MiniLoadingAdLayoutOptNewBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, TextView textView4, ImageView imageView, FrameLayout frameLayout2, TextView textView5, View view, View view2, ViewStub viewStub, TextView textView6, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout3, ImageView imageView4, LinearLayout linearLayout, ViewStub viewStub2, URLImageView uRLImageView, ViewStub viewStub3) {
        this.rootView = frameLayout;
        this.developerDesc = textView;
        this.gamePublicationInfoFirst = textView2;
        this.gamePublicationInfoSecond = textView3;
        this.loadingAdContainer = constraintLayout;
        this.loadingAdCountdownText = textView4;
        this.loadingAdImg = imageView;
        this.loadingAdParent = frameLayout2;
        this.loadingAdSign = textView5;
        this.loadingAdSlideArea = view;
        this.loadingAdSlideAreaMask = view2;
        this.miniLoadingAdAppLayoutStub = viewStub;
        this.miniLoadingAdAppText = textView6;
        this.miniLoadingAdBar = imageView2;
        this.miniLoadingAdBarIcon = imageView3;
        this.miniLoadingAdBottomLayoutContainer = frameLayout3;
        this.miniLoadingAdCountdownBg = imageView4;
        this.miniLoadingAdDeveloperDescLayout = linearLayout;
        this.miniLoadingAdGameLayoutStub = viewStub2;
        this.miniLoadingAdSlideIcon = uRLImageView;
        this.miniLoadingSlideLayoutStub = viewStub3;
    }

    public static MiniLoadingAdLayoutOptNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniLoadingAdLayoutOptNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniLoadingAdLayoutOptNewBinding bind(View view) {
        int i3 = R.id.rcy;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rcy);
        if (textView != null) {
            i3 = R.id.rdo;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rdo);
            if (textView2 != null) {
                i3 = R.id.rdp;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rdp);
                if (textView3 != null) {
                    i3 = R.id.rew;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.rew);
                    if (constraintLayout != null) {
                        i3 = R.id.rex;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.rex);
                        if (textView4 != null) {
                            i3 = R.id.rey;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rey);
                            if (imageView != null) {
                                FrameLayout frameLayout = (FrameLayout) view;
                                i3 = R.id.f163678rf0;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f163678rf0);
                                if (textView5 != null) {
                                    i3 = R.id.f163679rf1;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163679rf1);
                                    if (findChildViewById != null) {
                                        i3 = R.id.f163680rf2;
                                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f163680rf2);
                                        if (findChildViewById2 != null) {
                                            i3 = R.id.rio;
                                            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.rio);
                                            if (viewStub != null) {
                                                i3 = R.id.riq;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.riq);
                                                if (textView6 != null) {
                                                    i3 = R.id.rir;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rir);
                                                    if (imageView2 != null) {
                                                        i3 = R.id.ris;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.ris);
                                                        if (imageView3 != null) {
                                                            i3 = R.id.rit;
                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rit);
                                                            if (frameLayout2 != null) {
                                                                i3 = R.id.riu;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.riu);
                                                                if (imageView4 != null) {
                                                                    i3 = R.id.riv;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.riv);
                                                                    if (linearLayout != null) {
                                                                        i3 = R.id.f163698rj0;
                                                                        ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f163698rj0);
                                                                        if (viewStub2 != null) {
                                                                            i3 = R.id.f163702rj4;
                                                                            URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f163702rj4);
                                                                            if (uRLImageView != null) {
                                                                                i3 = R.id.rj7;
                                                                                ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, R.id.rj7);
                                                                                if (viewStub3 != null) {
                                                                                    return new MiniLoadingAdLayoutOptNewBinding(frameLayout, textView, textView2, textView3, constraintLayout, textView4, imageView, frameLayout, textView5, findChildViewById, findChildViewById2, viewStub, textView6, imageView2, imageView3, frameLayout2, imageView4, linearLayout, viewStub2, uRLImageView, viewStub3);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
