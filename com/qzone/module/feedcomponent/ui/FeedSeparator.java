package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellSeparator;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.component.media.image.view.AsyncImageable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedSeparator extends BaseFeedView implements FeedChildView {
    public static FeedViewSection.SectionController FeedSeparatorController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedSeparator.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.getSeparatorInfo() == null;
        }
    };
    AsyncImageable.AsyncImageListener mAsyncImageListener;
    AsyncImageView mAsyncImageView;
    CellSeparator mCellSeparator;
    View.OnClickListener mListener;

    public FeedSeparator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedSeparator.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedSeparator feedSeparator = FeedSeparator.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedSeparator.onFeedElementClickListener;
                FeedElement feedElement = FeedElement.SEPARATOR;
                int i3 = feedSeparator.feedPosition;
                gVar.onClick(view, feedElement, i3, Integer.valueOf(i3));
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mAsyncImageListener = new AsyncImageable.AsyncImageListener() { // from class: com.qzone.module.feedcomponent.ui.FeedSeparator.3
            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageLoaded(AsyncImageable asyncImageable) {
                Drawable drawable = ((AsyncImageView) asyncImageable).getDrawable();
                if (drawable != null) {
                    drawable.getIntrinsicWidth();
                }
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageFailed(AsyncImageable asyncImageable) {
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageStarted(AsyncImageable asyncImageable) {
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            }
        };
        initUI(context);
    }

    void initUI(Context context) {
        AsyncImageView asyncImageView = new AsyncImageView(context);
        this.mAsyncImageView = asyncImageView;
        asyncImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.mAsyncImageView.setAsyncImageListener(this.mAsyncImageListener);
        this.mAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.mAsyncImageView);
        setOnClickListener(this.mListener);
    }

    public boolean isDataValid() {
        CellSeparator cellSeparator = this.mCellSeparator;
        return (cellSeparator == null || TextUtils.isEmpty(cellSeparator.picUrl)) ? false : true;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        return this.mCellSeparator == null;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        AsyncImageView asyncImageView = this.mAsyncImageView;
        if (asyncImageView != null) {
            asyncImageView.setImageDrawable(null);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
        CellSeparator cellSeparator = this.mCellSeparator;
        if (cellSeparator == null || this.mAsyncImageView == null) {
            return;
        }
        updateImageViewLayout(cellSeparator);
        this.mAsyncImageView.setAsyncImage(this.mCellSeparator.picUrl);
        setViewVisbile(this);
    }

    public void setData(CellSeparator cellSeparator) {
        this.mCellSeparator = cellSeparator;
        if (cellSeparator == null || this.mAsyncImageView == null) {
            return;
        }
        updateImageViewLayout(cellSeparator);
        this.mAsyncImageView.setAsyncImage(cellSeparator.picUrl);
        setViewVisbile(this);
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.mCellSeparator = null;
        AsyncImageView asyncImageView = this.mAsyncImageView;
        if (asyncImageView != null) {
            asyncImageView.setAsyncImage(null);
        }
    }

    private void updateImageViewLayout(CellSeparator cellSeparator) {
        if (cellSeparator == null || this.mAsyncImageView == null || cellSeparator.picHeight <= 0 || cellSeparator.picWidth <= 0) {
            return;
        }
        this.mAsyncImageView.setLayoutParams(new FrameLayout.LayoutParams(FeedGlobalEnv.g().getScreenWidth(), (cellSeparator.picHeight * FeedGlobalEnv.g().getScreenWidth()) / cellSeparator.picWidth));
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getSeparatorInfo() == null) {
            return;
        }
        setData(businessFeedData.getSeparatorInfo());
        update();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
