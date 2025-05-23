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
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniGamePcInstructionDialogLayoutBinding implements ViewBinding {
    public final URLImageView ivBg;
    public final LinearLayout ivBottomContainer;
    public final ImageView ivBottomImg;
    public final TextView ivBottomText;
    public final ImageView ivClose;
    public final TextView ivText;
    public final LinearLayout ivTopContainer;
    public final ImageView ivTopImg;
    public final LinearLayout miniGamePcDialogContainer;
    private final RelativeLayout rootView;
    public final TextView tvTittle;

    MiniGamePcInstructionDialogLayoutBinding(RelativeLayout relativeLayout, URLImageView uRLImageView, LinearLayout linearLayout, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, LinearLayout linearLayout2, ImageView imageView3, LinearLayout linearLayout3, TextView textView3) {
        this.rootView = relativeLayout;
        this.ivBg = uRLImageView;
        this.ivBottomContainer = linearLayout;
        this.ivBottomImg = imageView;
        this.ivBottomText = textView;
        this.ivClose = imageView2;
        this.ivText = textView2;
        this.ivTopContainer = linearLayout2;
        this.ivTopImg = imageView3;
        this.miniGamePcDialogContainer = linearLayout3;
        this.tvTittle = textView3;
    }

    public static MiniGamePcInstructionDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGamePcInstructionDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dk8, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGamePcInstructionDialogLayoutBinding bind(View view) {
        int i3 = R.id.re9;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.re9);
        if (uRLImageView != null) {
            i3 = R.id.re_;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.re_);
            if (linearLayout != null) {
                i3 = R.id.rea;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rea);
                if (imageView != null) {
                    i3 = R.id.reb;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.reb);
                    if (textView != null) {
                        i3 = R.id.rec;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rec);
                        if (imageView2 != null) {
                            i3 = R.id.reh;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.reh);
                            if (textView2 != null) {
                                i3 = R.id.rei;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rei);
                                if (linearLayout2 != null) {
                                    i3 = R.id.rej;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.rej);
                                    if (imageView3 != null) {
                                        i3 = R.id.ri6;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ri6);
                                        if (linearLayout3 != null) {
                                            i3 = R.id.rlu;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rlu);
                                            if (textView3 != null) {
                                                return new MiniGamePcInstructionDialogLayoutBinding((RelativeLayout) view, uRLImageView, linearLayout, imageView, textView, imageView2, textView2, linearLayout2, imageView3, linearLayout3, textView3);
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
