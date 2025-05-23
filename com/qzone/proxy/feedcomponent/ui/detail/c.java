package com.qzone.proxy.feedcomponent.ui.detail;

import android.content.Context;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class c {
    protected Context context;
    View view;

    public c(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

    public View getRootView() {
        return this.view;
    }

    public View getView() {
        return this.view;
    }

    public int getVisibility() {
        View view = this.view;
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        View view = this.view;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setVisibility(int i3) {
        View view = this.view;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public void onRecycled() {
    }

    public void setData(BusinessFeedData businessFeedData) {
    }
}
