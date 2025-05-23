package com.tencent.mobileqq.mini.container;

import com.tencent.mobileqq.mini.api.ContainerLoadParams;
import com.tencent.mobileqq.mini.api.IMiniLoadCallback;
import com.tencent.mobileqq.mini.widget.DefaultMiniLoadingViewHolder;
import com.tencent.mobileqq.mini.widget.DefaultMiniRetryViewHolder;
import com.tencent.qqmini.container.core.MiniView;
import com.tencent.qqmini.container.core.l;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniLoadCallbackImpl implements l, DefaultMiniRetryViewHolder.RetryListener {
    private DefaultMiniLoadingViewHolder mLoadingViewHolder;
    private IMiniLoadCallback mMiniLoadCallback;
    private DefaultMiniRetryViewHolder mRetryViewHolder;

    public MiniLoadCallbackImpl(ContainerLoadParams containerLoadParams, MiniView miniView) {
        this.mMiniLoadCallback = containerLoadParams.getLoadCallback();
        if (containerLoadParams.isAddDefaultRetryView()) {
            DefaultMiniRetryViewHolder defaultMiniRetryViewHolder = new DefaultMiniRetryViewHolder();
            this.mRetryViewHolder = defaultMiniRetryViewHolder;
            defaultMiniRetryViewHolder.setRetryListener(this);
            this.mRetryViewHolder.setForceDark(containerLoadParams.isForceDefaultUIDarkMode());
            this.mRetryViewHolder.attachMiniView(miniView);
        }
        if (containerLoadParams.isAddDefaultLoadingView()) {
            DefaultMiniLoadingViewHolder defaultMiniLoadingViewHolder = new DefaultMiniLoadingViewHolder();
            this.mLoadingViewHolder = defaultMiniLoadingViewHolder;
            defaultMiniLoadingViewHolder.setForceDarkMode(containerLoadParams.isForceDefaultUIDarkMode());
            this.mLoadingViewHolder.attachMiniView(miniView);
            miniView.setLoadingView(this.mLoadingViewHolder);
        }
    }

    private void hideLoading() {
        DefaultMiniLoadingViewHolder defaultMiniLoadingViewHolder = this.mLoadingViewHolder;
        if (defaultMiniLoadingViewHolder != null) {
            defaultMiniLoadingViewHolder.hide();
        }
    }

    private void hideRetry() {
        DefaultMiniRetryViewHolder defaultMiniRetryViewHolder = this.mRetryViewHolder;
        if (defaultMiniRetryViewHolder != null) {
            defaultMiniRetryViewHolder.hide();
        }
    }

    private void showLoading() {
        DefaultMiniLoadingViewHolder defaultMiniLoadingViewHolder = this.mLoadingViewHolder;
        if (defaultMiniLoadingViewHolder != null) {
            defaultMiniLoadingViewHolder.show();
        }
    }

    private void showRetry() {
        DefaultMiniRetryViewHolder defaultMiniRetryViewHolder = this.mRetryViewHolder;
        if (defaultMiniRetryViewHolder != null) {
            defaultMiniRetryViewHolder.show();
        }
    }

    @Override // com.tencent.mobileqq.mini.widget.DefaultMiniRetryViewHolder.RetryListener
    public void onRetry() {
        showLoading();
    }

    @Override // com.tencent.qqmini.container.core.l
    public void onLoaded(int i3, String str) {
        boolean z16 = i3 == 0;
        IMiniLoadCallback iMiniLoadCallback = this.mMiniLoadCallback;
        if (iMiniLoadCallback != null) {
            iMiniLoadCallback.onLoaded(i3, str);
        }
        if (z16) {
            hideRetry();
        } else {
            showRetry();
            hideLoading();
        }
    }
}
