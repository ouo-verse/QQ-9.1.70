package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.search.QUISearchBar;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopSearchAdapterViewHolderLayoutBinding implements ViewBinding {
    public final QUISearchBar miniAppDesktopSearchbar;
    private final RelativeLayout rootView;

    MiniAppExpDesktopSearchAdapterViewHolderLayoutBinding(RelativeLayout relativeLayout, QUISearchBar qUISearchBar) {
        this.rootView = relativeLayout;
        this.miniAppDesktopSearchbar = qUISearchBar;
    }

    public static MiniAppExpDesktopSearchAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopSearchAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dj7, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopSearchAdapterViewHolderLayoutBinding bind(View view) {
        QUISearchBar qUISearchBar = (QUISearchBar) ViewBindings.findChildViewById(view, R.id.rg7);
        if (qUISearchBar != null) {
            return new MiniAppExpDesktopSearchAdapterViewHolderLayoutBinding((RelativeLayout) view, qUISearchBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rg7)));
    }
}
