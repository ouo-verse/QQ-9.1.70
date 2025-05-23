package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniAppExpDesktopPartHostSubLayoutBinding implements ViewBinding {
    public final LinearLayout llMiniAppSubPage;
    public final RelativeLayout microappEntrySubNavbarLayout;
    public final RecyclerView microappSubRecyclerview;
    public final ImageView miniAppOperationAppBackView;
    public final TextView miniAppSubTitle;
    private final LinearLayout rootView;

    MiniAppExpDesktopPartHostSubLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, RecyclerView recyclerView, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.llMiniAppSubPage = linearLayout2;
        this.microappEntrySubNavbarLayout = relativeLayout;
        this.microappSubRecyclerview = recyclerView;
        this.miniAppOperationAppBackView = imageView;
        this.miniAppSubTitle = textView;
    }

    public static MiniAppExpDesktopPartHostSubLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopPartHostSubLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.rf_;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rf_);
        if (relativeLayout != null) {
            i3 = R.id.rfb;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rfb);
            if (recyclerView != null) {
                i3 = R.id.rh6;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rh6);
                if (imageView != null) {
                    i3 = R.id.rhu;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rhu);
                    if (textView != null) {
                        return new MiniAppExpDesktopPartHostSubLayoutBinding(linearLayout, linearLayout, relativeLayout, recyclerView, imageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static MiniAppExpDesktopPartHostSubLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.diz, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
