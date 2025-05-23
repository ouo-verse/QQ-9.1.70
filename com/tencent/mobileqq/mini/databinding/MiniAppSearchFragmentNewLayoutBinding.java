package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppSearchFragmentNewLayoutBinding implements ViewBinding {
    public final LinearLayout miniAppLoadingContainer;
    public final QUISearchBar miniAppSearchBar;
    public final LinearLayout miniAppSearchHistory;
    public final RelativeLayout miniAppSearchHistoryNewStyle;
    public final LinearLayout miniAppSearchLayoutRoot;
    public final RelativeLayout miniAppSearchNoResultRootView;
    public final FrameLayout miniAppSearchPageContent;
    public final RelativeLayout miniAppSearchResultContainer;
    public final RecyclerView miniAppSearchResultRecyclerView;
    public final SmartRefreshLayout miniAppSearchResultRefreshRoot;
    private final LinearLayout rootView;

    MiniAppSearchFragmentNewLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, QUISearchBar qUISearchBar, LinearLayout linearLayout3, RelativeLayout relativeLayout, LinearLayout linearLayout4, RelativeLayout relativeLayout2, FrameLayout frameLayout, RelativeLayout relativeLayout3, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        this.rootView = linearLayout;
        this.miniAppLoadingContainer = linearLayout2;
        this.miniAppSearchBar = qUISearchBar;
        this.miniAppSearchHistory = linearLayout3;
        this.miniAppSearchHistoryNewStyle = relativeLayout;
        this.miniAppSearchLayoutRoot = linearLayout4;
        this.miniAppSearchNoResultRootView = relativeLayout2;
        this.miniAppSearchPageContent = frameLayout;
        this.miniAppSearchResultContainer = relativeLayout3;
        this.miniAppSearchResultRecyclerView = recyclerView;
        this.miniAppSearchResultRefreshRoot = smartRefreshLayout;
    }

    public static MiniAppSearchFragmentNewLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppSearchFragmentNewLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djg, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public LinearLayout getMRv() {
        return this.rootView;
    }

    public static MiniAppSearchFragmentNewLayoutBinding bind(View view) {
        int i3 = R.id.rgr;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rgr);
        if (linearLayout != null) {
            i3 = R.id.rhh;
            QUISearchBar qUISearchBar = (QUISearchBar) ViewBindings.findChildViewById(view, R.id.rhh);
            if (qUISearchBar != null) {
                i3 = R.id.rhj;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rhj);
                if (linearLayout2 != null) {
                    i3 = R.id.rhk;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rhk);
                    if (relativeLayout != null) {
                        LinearLayout linearLayout3 = (LinearLayout) view;
                        i3 = R.id.rho;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rho);
                        if (relativeLayout2 != null) {
                            i3 = R.id.rhp;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rhp);
                            if (frameLayout != null) {
                                i3 = R.id.rhq;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rhq);
                                if (relativeLayout3 != null) {
                                    i3 = R.id.rhr;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rhr);
                                    if (recyclerView != null) {
                                        i3 = R.id.rhs;
                                        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.rhs);
                                        if (smartRefreshLayout != null) {
                                            return new MiniAppSearchFragmentNewLayoutBinding(linearLayout3, linearLayout, qUISearchBar, linearLayout2, relativeLayout, linearLayout3, relativeLayout2, frameLayout, relativeLayout3, recyclerView, smartRefreshLayout);
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
