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
public final class MiniAppDesktopTitlebarPartLayoutBinding implements ViewBinding {
    public final RelativeLayout microappEntryNavbarLayout;
    public final ImageView miniAppCloseDesktopBtn;
    public final RelativeLayout miniAppDesktopCapsule;
    public final ImageView miniAppDesktopCapsuleLeftBtn;
    public final RelativeLayout miniAppDesktopCapsuleLeftBtnContainer;
    public final TextView miniAppDesktopCapsuleLeftBtnRedDot;
    public final TextView miniAppDesktopTitle;
    private final RelativeLayout rootView;

    MiniAppDesktopTitlebarPartLayoutBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, RelativeLayout relativeLayout3, ImageView imageView2, RelativeLayout relativeLayout4, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.microappEntryNavbarLayout = relativeLayout2;
        this.miniAppCloseDesktopBtn = imageView;
        this.miniAppDesktopCapsule = relativeLayout3;
        this.miniAppDesktopCapsuleLeftBtn = imageView2;
        this.miniAppDesktopCapsuleLeftBtnContainer = relativeLayout4;
        this.miniAppDesktopCapsuleLeftBtnRedDot = textView;
        this.miniAppDesktopTitle = textView2;
    }

    public static MiniAppDesktopTitlebarPartLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppDesktopTitlebarPartLayoutBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i3 = R.id.rff;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rff);
        if (imageView != null) {
            i3 = R.id.rfn;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rfn);
            if (relativeLayout2 != null) {
                i3 = R.id.rfo;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rfo);
                if (imageView2 != null) {
                    i3 = R.id.rfp;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rfp);
                    if (relativeLayout3 != null) {
                        i3 = R.id.rfr;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rfr);
                        if (textView != null) {
                            i3 = R.id.rg8;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rg8);
                            if (textView2 != null) {
                                return new MiniAppDesktopTitlebarPartLayoutBinding(relativeLayout, relativeLayout, imageView, relativeLayout2, imageView2, relativeLayout3, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static MiniAppDesktopTitlebarPartLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dil, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
