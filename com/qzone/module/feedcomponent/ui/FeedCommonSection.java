package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.module.feedcomponent.ui.FeedViewSection;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedCommonSection extends FeedViewSection {
    protected ViewGroup.LayoutParams mLayoutParams;
    protected boolean mShouldBeenPutBackToPool;
    protected FeedChildView mView;
    private Class<? extends FeedChildView> mViewClass;
    protected int mViewId;

    public <T extends FeedChildView> FeedCommonSection(Class<T> cls, FeedView feedView) {
        this(feedView.getContext(), cls, null, feedView, null);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public FeedChildView getView() {
        return this.mView;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public boolean haveMultipleViews() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.mView == null) {
            FeedChildView feedChildView = (FeedChildView) generateView(this.mViewClass, Integer.MIN_VALUE, !this.mOptions.isDetail);
            this.mView = feedChildView;
            int i3 = this.mViewId;
            if (i3 > 0) {
                ((View) feedChildView).setId(i3);
            }
        }
        return (View) this.mView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onApplyFeedData() {
        Object obj = this.mView;
        if (obj != null) {
            ViewGroup.LayoutParams layoutParams = this.mLayoutParams;
            if (layoutParams != null) {
                ((View) obj).setLayoutParams(layoutParams);
            }
            com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
            if (gVar != null) {
                this.mView.setOnFeedElementClickListener(gVar);
            }
            this.mView.setFeedPosition(this.feedPosition);
            this.mView.setFeedData(this.mFeedData);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        FeedChildView feedChildView = this.mView;
        if (feedChildView != null) {
            feedChildView.onRecycled();
            this.mView.setOnFeedElementClickListener(null);
            FeedViewSection.FeedViewOptions feedViewOptions = this.mOptions;
            if (feedViewOptions != null && !feedViewOptions.isDetail && (feedViewOptions.isPreGenerateView || this.mShouldBeenPutBackToPool)) {
                FeedViewSection.putViewBackToCache((View) this.mView);
                this.mView = null;
            }
        }
        this.mFeedData = null;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
        FeedChildView feedChildView = this.mView;
        if (feedChildView != null) {
            feedChildView.onStateIdle();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
        FeedChildView feedChildView = this.mView;
        if (feedChildView != null) {
            feedChildView.onStateScrolling();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
        FeedChildView feedChildView;
        if (isEmpty() || (feedChildView = this.mView) == null) {
            return;
        }
        feedChildView.setAlpha(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedPosition(int i3) {
        FeedChildView feedChildView;
        super.setFeedPosition(i3);
        if (isEmpty() || (feedChildView = this.mView) == null) {
            return;
        }
        feedChildView.setFeedPosition(i3);
    }

    public FeedCommonSection setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.mLayoutParams = layoutParams;
        return this;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        FeedChildView feedChildView;
        super.setOnFeedElementClickListener(gVar);
        if (isEmpty() || (feedChildView = this.mView) == null) {
            return;
        }
        feedChildView.setOnFeedElementClickListener(gVar);
    }

    public FeedCommonSection setShouldBeenPutBackToPool(boolean z16) {
        this.mShouldBeenPutBackToPool = z16;
        return this;
    }

    public FeedCommonSection setView(FeedChildView feedChildView) {
        this.mView = feedChildView;
        return this;
    }

    public FeedCommonSection setViewClass(Class<? extends FeedChildView> cls) {
        this.mViewClass = cls;
        return this;
    }

    public FeedCommonSection setViewId(int i3) {
        this.mViewId = i3;
        return this;
    }

    public <T extends FeedChildView> FeedCommonSection(Context context, Class<T> cls, FeedViewSection.SectionController sectionController, FeedView feedView) {
        this(context, cls, sectionController, feedView, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends FeedChildView> FeedCommonSection(Context context, Class<T> cls, FeedViewSection.SectionController sectionController, FeedView feedView, ViewGroup.LayoutParams layoutParams) {
        super(context, feedView);
        this.mShouldBeenPutBackToPool = true;
        setSectionController(sectionController);
        this.mViewClass = cls;
        this.mLayoutParams = layoutParams;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void attachView(NormalAbsFeedView normalAbsFeedView) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
    }
}
