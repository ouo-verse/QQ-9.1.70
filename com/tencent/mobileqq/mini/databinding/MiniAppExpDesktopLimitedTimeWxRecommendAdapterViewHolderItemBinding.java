package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.expDesktop.ui.LimitedTimeRecommendAvatarGroup;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopLimitedTimeWxRecommendAdapterViewHolderItemBinding implements ViewBinding {
    public final LimitedTimeRecommendAvatarGroup miniAppExpDesktopAvatarsContainer;
    public final ImageView moduleTitleMoreIcon;
    public final LinearLayout moduleTitleMoreLayout;
    public final TextView moduleTitleTitleTv;
    private final RelativeLayout rootView;

    MiniAppExpDesktopLimitedTimeWxRecommendAdapterViewHolderItemBinding(RelativeLayout relativeLayout, LimitedTimeRecommendAvatarGroup limitedTimeRecommendAvatarGroup, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.miniAppExpDesktopAvatarsContainer = limitedTimeRecommendAvatarGroup;
        this.moduleTitleMoreIcon = imageView;
        this.moduleTitleMoreLayout = linearLayout;
        this.moduleTitleTitleTv = textView;
    }

    public static MiniAppExpDesktopLimitedTimeWxRecommendAdapterViewHolderItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopLimitedTimeWxRecommendAdapterViewHolderItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dit, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopLimitedTimeWxRecommendAdapterViewHolderItemBinding bind(View view) {
        int i3 = R.id.rgd;
        LimitedTimeRecommendAvatarGroup limitedTimeRecommendAvatarGroup = (LimitedTimeRecommendAvatarGroup) ViewBindings.findChildViewById(view, R.id.rgd);
        if (limitedTimeRecommendAvatarGroup != null) {
            i3 = R.id.rjw;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rjw);
            if (imageView != null) {
                i3 = R.id.rjx;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rjx);
                if (linearLayout != null) {
                    i3 = R.id.rjz;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rjz);
                    if (textView != null) {
                        return new MiniAppExpDesktopLimitedTimeWxRecommendAdapterViewHolderItemBinding((RelativeLayout) view, limitedTimeRecommendAvatarGroup, imageView, linearLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
