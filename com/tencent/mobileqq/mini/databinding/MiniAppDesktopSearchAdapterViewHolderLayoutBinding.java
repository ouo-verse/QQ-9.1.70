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
public final class MiniAppDesktopSearchAdapterViewHolderLayoutBinding implements ViewBinding {
    public final QUISearchBar qsbMiniappSearch;
    private final RelativeLayout rootView;

    MiniAppDesktopSearchAdapterViewHolderLayoutBinding(RelativeLayout relativeLayout, QUISearchBar qUISearchBar) {
        this.rootView = relativeLayout;
        this.qsbMiniappSearch = qUISearchBar;
    }

    public static MiniAppDesktopSearchAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppDesktopSearchAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dik, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopSearchAdapterViewHolderLayoutBinding bind(View view) {
        QUISearchBar qUISearchBar = (QUISearchBar) ViewBindings.findChildViewById(view, R.id.rks);
        if (qUISearchBar != null) {
            return new MiniAppDesktopSearchAdapterViewHolderLayoutBinding((RelativeLayout) view, qUISearchBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rks)));
    }
}
