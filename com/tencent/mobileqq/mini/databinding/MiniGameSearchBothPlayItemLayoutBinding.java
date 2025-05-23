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

/* loaded from: classes33.dex */
public final class MiniGameSearchBothPlayItemLayoutBinding implements ViewBinding {
    public final RelativeLayout bothPlayItemIconContainer;
    public final TextView bothPlayItemRankText;
    public final ImageView imageApp;
    public final ImageView imageNumber;
    private final RelativeLayout rootView;
    public final TextView textAppDesc;
    public final TextView textAppName;

    MiniGameSearchBothPlayItemLayoutBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.bothPlayItemIconContainer = relativeLayout2;
        this.bothPlayItemRankText = textView;
        this.imageApp = imageView;
        this.imageNumber = imageView2;
        this.textAppDesc = textView2;
        this.textAppName = textView3;
    }

    public static MiniGameSearchBothPlayItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameSearchBothPlayItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dke, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameSearchBothPlayItemLayoutBinding bind(View view) {
        int i3 = R.id.rc7;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rc7);
        if (relativeLayout != null) {
            i3 = R.id.rc9;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rc9);
            if (textView != null) {
                i3 = R.id.rdx;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rdx);
                if (imageView != null) {
                    i3 = R.id.rdy;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rdy);
                    if (imageView2 != null) {
                        i3 = R.id.rld;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rld);
                        if (textView2 != null) {
                            i3 = R.id.rle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rle);
                            if (textView3 != null) {
                                return new MiniGameSearchBothPlayItemLayoutBinding((RelativeLayout) view, relativeLayout, textView, imageView, imageView2, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
