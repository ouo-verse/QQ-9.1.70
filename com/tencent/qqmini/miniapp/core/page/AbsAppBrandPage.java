package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout;
import com.tencent.qqmini.sdk.widget.NavigationBar;

/* loaded from: classes23.dex */
public abstract class AbsAppBrandPage extends SwipeBackLayout {
    public AbsAppBrandPage(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View createContentView = createContentView();
        this.mContentView = createContentView;
        if (createContentView != null) {
            addView(createContentView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public abstract View createContentView();

    public abstract String getCurShowingUrl();

    public PageWebview getCurrentPageWebview() {
        return null;
    }

    public abstract NavigationBar getNaviBar();

    public PageWebviewContainer getPageWebviewContainer() {
        return null;
    }

    public abstract AppBrandPageContainer getRootContainer();

    public abstract boolean isCustomNavibar();
}
