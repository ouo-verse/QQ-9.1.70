package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppMigrateInfoLayoutBinding implements ViewBinding {
    public final ImageView backIv;
    public final TextView developerDescTv;
    public final Button gotoWxMiniAppBtn;
    public final ImageView microappEntryNavbarLayout;
    public final RelativeLayout miniAppItemLayout;
    public final TextView miniAppName;
    public final RoundRectImageView miniappItemsImage;
    private final LinearLayout rootView;

    MiniAppMigrateInfoLayoutBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, Button button, ImageView imageView2, RelativeLayout relativeLayout, TextView textView2, RoundRectImageView roundRectImageView) {
        this.rootView = linearLayout;
        this.backIv = imageView;
        this.developerDescTv = textView;
        this.gotoWxMiniAppBtn = button;
        this.microappEntryNavbarLayout = imageView2;
        this.miniAppItemLayout = relativeLayout;
        this.miniAppName = textView2;
        this.miniappItemsImage = roundRectImageView;
    }

    public static MiniAppMigrateInfoLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppMigrateInfoLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djc, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppMigrateInfoLayoutBinding bind(View view) {
        int i3 = R.id.rc6;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rc6);
        if (imageView != null) {
            i3 = R.id.rcz;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rcz);
            if (textView != null) {
                i3 = R.id.rdr;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.rdr);
                if (button != null) {
                    i3 = R.id.rf8;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rf8);
                    if (imageView2 != null) {
                        i3 = R.id.rgp;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rgp);
                        if (relativeLayout != null) {
                            i3 = R.id.rgz;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rgz);
                            if (textView2 != null) {
                                i3 = R.id.rjn;
                                RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.rjn);
                                if (roundRectImageView != null) {
                                    return new MiniAppMigrateInfoLayoutBinding((LinearLayout) view, imageView, textView, button, imageView2, relativeLayout, textView2, roundRectImageView);
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
