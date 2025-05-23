package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.widget.WebViewProgressBar;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppGuildNavigationBarBinding implements ViewBinding {
    public final TextView btnJoin;
    public final ImageView btnShare;
    public final RelativeLayout miniSdkLoadingNavContainer;
    public final SquareImageView miniSdkNavCustomConfigIcon;
    public final WebViewProgressBar miniSdkNavLoading;
    public final ProgressBar miniSdkNavLoadingView;
    public final View miniSdkNavMask;
    public final TextView miniSdkNavTitle;
    public final RelativeLayout miniSdkNavigationContainer;
    public final ImageView miniSdkTopBarTitleBack;
    public final RelativeLayout miniSdkTopBarTitleBackContainer;
    private final RelativeLayout rootView;

    MiniAppGuildNavigationBarBinding(RelativeLayout relativeLayout, TextView textView, ImageView imageView, RelativeLayout relativeLayout2, SquareImageView squareImageView, WebViewProgressBar webViewProgressBar, ProgressBar progressBar, View view, TextView textView2, RelativeLayout relativeLayout3, ImageView imageView2, RelativeLayout relativeLayout4) {
        this.rootView = relativeLayout;
        this.btnJoin = textView;
        this.btnShare = imageView;
        this.miniSdkLoadingNavContainer = relativeLayout2;
        this.miniSdkNavCustomConfigIcon = squareImageView;
        this.miniSdkNavLoading = webViewProgressBar;
        this.miniSdkNavLoadingView = progressBar;
        this.miniSdkNavMask = view;
        this.miniSdkNavTitle = textView2;
        this.miniSdkNavigationContainer = relativeLayout3;
        this.miniSdkTopBarTitleBack = imageView2;
        this.miniSdkTopBarTitleBackContainer = relativeLayout4;
    }

    public static MiniAppGuildNavigationBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppGuildNavigationBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dja, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppGuildNavigationBarBinding bind(View view) {
        int i3 = R.id.rch;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rch);
        if (textView != null) {
            i3 = R.id.rck;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rck);
            if (imageView != null) {
                i3 = R.id.rj_;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rj_);
                if (relativeLayout != null) {
                    i3 = R.id.rja;
                    SquareImageView squareImageView = (SquareImageView) ViewBindings.findChildViewById(view, R.id.rja);
                    if (squareImageView != null) {
                        i3 = R.id.rjb;
                        WebViewProgressBar webViewProgressBar = (WebViewProgressBar) ViewBindings.findChildViewById(view, R.id.rjb);
                        if (webViewProgressBar != null) {
                            i3 = R.id.rjc;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.rjc);
                            if (progressBar != null) {
                                i3 = R.id.rjd;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.rjd);
                                if (findChildViewById != null) {
                                    i3 = R.id.rje;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rje);
                                    if (textView2 != null) {
                                        RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                        i3 = R.id.rjg;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rjg);
                                        if (imageView2 != null) {
                                            i3 = R.id.rjh;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rjh);
                                            if (relativeLayout3 != null) {
                                                return new MiniAppGuildNavigationBarBinding(relativeLayout2, textView, imageView, relativeLayout, squareImageView, webViewProgressBar, progressBar, findChildViewById, textView2, relativeLayout2, imageView2, relativeLayout3);
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
