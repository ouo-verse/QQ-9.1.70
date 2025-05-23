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
import com.tencent.mobileqq.mini.ui.WechatBindingAndAuthContentView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopNotificationLayoutBinding implements ViewBinding {
    public final RelativeLayout gotoQqminiappNotification;
    public final WechatBindingAndAuthContentView miniAppBindingAndAuthContent;
    public final ImageView miniAppNotificationBackView;
    public final LinearLayout miniAppNotificationLayout;
    public final RelativeLayout miniAppNotificationNavbarLayout;
    public final TextView miniAppNotificationTitle;
    private final LinearLayout rootView;

    MiniAppExpDesktopNotificationLayoutBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, WechatBindingAndAuthContentView wechatBindingAndAuthContentView, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.gotoQqminiappNotification = relativeLayout;
        this.miniAppBindingAndAuthContent = wechatBindingAndAuthContentView;
        this.miniAppNotificationBackView = imageView;
        this.miniAppNotificationLayout = linearLayout2;
        this.miniAppNotificationNavbarLayout = relativeLayout2;
        this.miniAppNotificationTitle = textView;
    }

    public static MiniAppExpDesktopNotificationLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopNotificationLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dix, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopNotificationLayoutBinding bind(View view) {
        int i3 = R.id.rdq;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rdq);
        if (relativeLayout != null) {
            i3 = R.id.rfe;
            WechatBindingAndAuthContentView wechatBindingAndAuthContentView = (WechatBindingAndAuthContentView) ViewBindings.findChildViewById(view, R.id.rfe);
            if (wechatBindingAndAuthContentView != null) {
                i3 = R.id.f163689rh1;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163689rh1);
                if (imageView != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i3 = R.id.f163692rh4;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163692rh4);
                    if (relativeLayout2 != null) {
                        i3 = R.id.rh5;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rh5);
                        if (textView != null) {
                            return new MiniAppExpDesktopNotificationLayoutBinding(linearLayout, relativeLayout, wechatBindingAndAuthContentView, imageView, linearLayout, relativeLayout2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
