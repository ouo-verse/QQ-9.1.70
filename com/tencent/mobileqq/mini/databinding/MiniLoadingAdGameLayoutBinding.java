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
public final class MiniLoadingAdGameLayoutBinding implements ViewBinding {
    public final ImageView miniLoadingAdGameIcon;
    public final TextView miniLoadingAdGameInstruction;
    public final RelativeLayout miniLoadingAdGameLayout;
    public final TextView miniLoadingAdGameName;
    private final RelativeLayout rootView;

    MiniLoadingAdGameLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, RelativeLayout relativeLayout2, TextView textView2) {
        this.rootView = relativeLayout;
        this.miniLoadingAdGameIcon = imageView;
        this.miniLoadingAdGameInstruction = textView;
        this.miniLoadingAdGameLayout = relativeLayout2;
        this.miniLoadingAdGameName = textView2;
    }

    public static MiniLoadingAdGameLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniLoadingAdGameLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniLoadingAdGameLayoutBinding bind(View view) {
        int i3 = R.id.rix;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rix);
        if (imageView != null) {
            i3 = R.id.riy;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.riy);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i3 = R.id.f163699rj1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163699rj1);
                if (textView2 != null) {
                    return new MiniLoadingAdGameLayoutBinding(relativeLayout, imageView, textView, relativeLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
