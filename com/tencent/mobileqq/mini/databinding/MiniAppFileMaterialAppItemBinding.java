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
import com.tencent.widget.RoundRectURLImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppFileMaterialAppItemBinding implements ViewBinding {
    public final ImageView ivExpTips;
    public final TextView miniAppModuleTitle;
    public final RoundRectURLImageView miniappItemsImage;
    private final RelativeLayout rootView;
    public final TextView tvDesc;

    MiniAppFileMaterialAppItemBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, RoundRectURLImageView roundRectURLImageView, TextView textView2) {
        this.rootView = relativeLayout;
        this.ivExpTips = imageView;
        this.miniAppModuleTitle = textView;
        this.miniappItemsImage = roundRectURLImageView;
        this.tvDesc = textView2;
    }

    public static MiniAppFileMaterialAppItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppFileMaterialAppItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dj9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppFileMaterialAppItemBinding bind(View view) {
        int i3 = R.id.ref;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ref);
        if (imageView != null) {
            i3 = R.id.rgt;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rgt);
            if (textView != null) {
                i3 = R.id.rjn;
                RoundRectURLImageView roundRectURLImageView = (RoundRectURLImageView) ViewBindings.findChildViewById(view, R.id.rjn);
                if (roundRectURLImageView != null) {
                    i3 = R.id.rlj;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rlj);
                    if (textView2 != null) {
                        return new MiniAppFileMaterialAppItemBinding((RelativeLayout) view, imageView, textView, roundRectURLImageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
