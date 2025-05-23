package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniAppSearchPageListItemLayoutBinding implements ViewBinding {
    public final ImageView imageApp;
    public final ImageView imageNumber;
    public final FrameLayout imageUseLayout;
    public final ImageView imageUser1;
    public final ImageView imageUser2;
    private final RelativeLayout rootView;
    public final TextView textAppDesc;
    public final TextView textAppName;
    public final QUIButton textGoto;

    MiniAppSearchPageListItemLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, QUIButton qUIButton) {
        this.rootView = relativeLayout;
        this.imageApp = imageView;
        this.imageNumber = imageView2;
        this.imageUseLayout = frameLayout;
        this.imageUser1 = imageView3;
        this.imageUser2 = imageView4;
        this.textAppDesc = textView;
        this.textAppName = textView2;
        this.textGoto = qUIButton;
    }

    public static MiniAppSearchPageListItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppSearchPageListItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppSearchPageListItemLayoutBinding bind(View view) {
        int i3 = R.id.rdx;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rdx);
        if (imageView != null) {
            i3 = R.id.rdy;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rdy);
            if (imageView2 != null) {
                i3 = R.id.rdz;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rdz);
                if (frameLayout != null) {
                    i3 = R.id.f163673re0;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163673re0);
                    if (imageView3 != null) {
                        i3 = R.id.f163674re1;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163674re1);
                        if (imageView4 != null) {
                            i3 = R.id.rld;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rld);
                            if (textView != null) {
                                i3 = R.id.rle;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rle);
                                if (textView2 != null) {
                                    i3 = R.id.rlf;
                                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.rlf);
                                    if (qUIButton != null) {
                                        return new MiniAppSearchPageListItemLayoutBinding((RelativeLayout) view, imageView, imageView2, frameLayout, imageView3, imageView4, textView, textView2, qUIButton);
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
