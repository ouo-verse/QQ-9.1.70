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

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppDesktopAdapterViewHolderTitleLayoutBinding implements ViewBinding {
    public final TextView miniAppModuleTitle;
    public final ImageView miniAppMoreIcon;
    public final LinearLayout miniAppMoreLayout;
    public final TextView miniAppMoreText;
    private final RelativeLayout rootView;

    MiniAppDesktopAdapterViewHolderTitleLayoutBinding(RelativeLayout relativeLayout, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2) {
        this.rootView = relativeLayout;
        this.miniAppModuleTitle = textView;
        this.miniAppMoreIcon = imageView;
        this.miniAppMoreLayout = linearLayout;
        this.miniAppMoreText = textView2;
    }

    public static MiniAppDesktopAdapterViewHolderTitleLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppDesktopAdapterViewHolderTitleLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dia, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopAdapterViewHolderTitleLayoutBinding bind(View view) {
        int i3 = R.id.rgt;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rgt);
        if (textView != null) {
            i3 = R.id.rgu;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rgu);
            if (imageView != null) {
                i3 = R.id.rgv;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rgv);
                if (linearLayout != null) {
                    i3 = R.id.rgw;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rgw);
                    if (textView2 != null) {
                        return new MiniAppDesktopAdapterViewHolderTitleLayoutBinding((RelativeLayout) view, textView, imageView, linearLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
