package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniLoadingAdSlideLayoutBinding implements ViewBinding {
    public final TextView miniLoadingAdDownText;
    public final RelativeLayout miniLoadingAdSlideBar;
    public final ImageView miniLoadingAdSlideMask;
    public final TextView miniLoadingAdUpText;
    private final RelativeLayout rootView;

    MiniLoadingAdSlideLayoutBinding(RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, ImageView imageView, TextView textView2) {
        this.rootView = relativeLayout;
        this.miniLoadingAdDownText = textView;
        this.miniLoadingAdSlideBar = relativeLayout2;
        this.miniLoadingAdSlideMask = imageView;
        this.miniLoadingAdUpText = textView2;
    }

    public static MiniLoadingAdSlideLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniLoadingAdSlideLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniLoadingAdSlideLayoutBinding bind(View view) {
        int i3 = R.id.riw;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.riw);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i3 = R.id.rj5;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rj5);
            if (imageView != null) {
                i3 = R.id.rj6;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rj6);
                if (textView2 != null) {
                    return new MiniLoadingAdSlideLayoutBinding(relativeLayout, textView, relativeLayout, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
