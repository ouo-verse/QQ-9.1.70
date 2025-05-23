package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.expDesktop.ui.MiniAppExpDesktopTabBar;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopHostItemLayoutBinding implements ViewBinding {
    public final MiniAppExpDesktopTabBar miniAppDropDownPanelTab;
    public final MiniAppExpDesktopMoreLayoutBinding miniAppMoreLayout;
    private final LinearLayout rootView;

    MiniAppExpDesktopHostItemLayoutBinding(LinearLayout linearLayout, MiniAppExpDesktopTabBar miniAppExpDesktopTabBar, MiniAppExpDesktopMoreLayoutBinding miniAppExpDesktopMoreLayoutBinding) {
        this.rootView = linearLayout;
        this.miniAppDropDownPanelTab = miniAppExpDesktopTabBar;
        this.miniAppMoreLayout = miniAppExpDesktopMoreLayoutBinding;
    }

    public static MiniAppExpDesktopHostItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopHostItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dip, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopHostItemLayoutBinding bind(View view) {
        int i3 = R.id.rga;
        MiniAppExpDesktopTabBar miniAppExpDesktopTabBar = (MiniAppExpDesktopTabBar) ViewBindings.findChildViewById(view, R.id.rga);
        if (miniAppExpDesktopTabBar != null) {
            i3 = R.id.rgv;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.rgv);
            if (findChildViewById != null) {
                return new MiniAppExpDesktopHostItemLayoutBinding((LinearLayout) view, miniAppExpDesktopTabBar, MiniAppExpDesktopMoreLayoutBinding.bind(findChildViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
