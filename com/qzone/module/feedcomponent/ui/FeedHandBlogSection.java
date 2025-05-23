package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.ditto.shell.DittoUIEngine;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedHandBlogSection extends FeedViewSection implements FeedChildView {
    private CellTextView mBlogSummary;
    private CellTextView mBlogTitle;
    private TextView mImageCount;
    private AsyncImageView mImageView;
    private boolean mIsForward;
    private ViewGroup mRootView;
    private static Drawable DEFAULT_BACKGROUND = com.qzone.adapter.feedcomponent.j.g(7);
    private static NormalFeedImageProcessor cropProcessor = new NormalFeedImageProcessor(AreaConst.feedWidth, (AreaConst.dp10 * 18) + AreaConst.f48749dp4);
    private static RoundCornerProcessor roundCornerProcessor = new RoundCornerProcessor(new float[]{8.0f, 8.0f, 8.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f});
    private static ImageProcessor handBlogProcessor = new ImageProcessor() { // from class: com.qzone.module.feedcomponent.ui.FeedHandBlogSection.1
        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            return FeedHandBlogSection.roundCornerProcessor.process(FeedHandBlogSection.cropProcessor.process(drawable));
        }
    };
    protected static FeedViewSection.SectionController HandBlogController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedHandBlogSection.2
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || !businessFeedData.isHandBlog();
        }
    };
    protected static FeedViewSection.SectionController HandBlogForwardController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedHandBlogSection.3
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.getOriginalInfo() == null || !businessFeedData.getOriginalInfo().isHandBlog();
        }
    };

    public FeedHandBlogSection(Context context, FeedView feedView) {
        super(context, feedView);
        setForward(false);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.mRootView == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(DittoUIEngine.g().getResourceId("@layout/qzone_widget_feed_handblog"), (ViewGroup) null);
            this.mRootView = viewGroup;
            viewGroup.setLayoutParams(generateLayoutParams());
            this.mImageView = (AsyncImageView) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2835));
            this.mImageCount = (TextView) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2836));
            this.mBlogTitle = (CellTextView) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2837));
            this.mBlogSummary = (CellTextView) this.mRootView.findViewById(com.qzone.adapter.feedcomponent.j.O(2838));
            this.mBlogTitle.setClickable(false);
            this.mBlogTitle.setLongclickable(false);
            this.mBlogSummary.setClickable(false);
            this.mBlogSummary.setLongclickable(false);
        }
        return this.mRootView;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
        onUpdate();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
        String str;
        String str2;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (this.mIsForward) {
            businessFeedData = businessFeedData.getOriginalInfo();
        }
        if (businessFeedData != null && businessFeedData.isHandBlog()) {
            this.mRootView.setVisibility(0);
            if (com.qzone.adapter.feedcomponent.i.H().p1()) {
                this.mRootView.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.g(966));
            } else {
                this.mRootView.setBackgroundDrawable(com.qzone.adapter.feedcomponent.j.g(965));
            }
            this.mImageView.setAsyncDefaultImage(DEFAULT_BACKGROUND);
            if (businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null && businessFeedData.getPictureInfo().pics.size() > 0) {
                PictureItem pictureItem = businessFeedData.getPictureInfo().pics.get(0);
                if (pictureItem != null && pictureItem.currentUrl != null) {
                    this.mImageView.setAsyncImageProcessor(handBlogProcessor);
                    this.mImageView.setAsyncImage(pictureItem.currentUrl.url);
                }
            } else {
                this.mImageView.setAsyncImage(null);
            }
            String str3 = "";
            if (businessFeedData.getPictureInfo() != null) {
                this.mImageCount.setText("" + businessFeedData.getPictureInfo().uploadnum);
            } else {
                this.mImageCount.setText("0");
            }
            CellTextView cellTextView = this.mBlogTitle;
            if (businessFeedData.getTitleInfoV2() == null) {
                str = "";
            } else {
                str = businessFeedData.getTitleInfoV2().displayTitle;
            }
            cellTextView.setRichText(str);
            CellTextView cellTextView2 = this.mBlogSummary;
            if (businessFeedData.getCellSummaryV2() == null) {
                str2 = "";
            } else {
                str2 = businessFeedData.getCellSummaryV2().summary;
            }
            cellTextView2.setRichText(str2);
            if (businessFeedData.getFeedCommInfo().extendInfo != null) {
                try {
                    int intValue = businessFeedData.getFeedCommInfo().extendInfo.containsKey("diy_font_id") ? Integer.valueOf(businessFeedData.getFeedCommInfo().extendInfo.get("diy_font_id")).intValue() : 0;
                    int intValue2 = businessFeedData.getFeedCommInfo().extendInfo.containsKey("diy_font_type") ? Integer.valueOf(businessFeedData.getFeedCommInfo().extendInfo.get("diy_font_type")).intValue() : 0;
                    if (businessFeedData.getFeedCommInfo().extendInfo.containsKey("diy_font_url")) {
                        str3 = businessFeedData.getFeedCommInfo().extendInfo.get("diy_font_url");
                    }
                    this.mBlogTitle.setFont(intValue, str3, intValue2);
                    this.mBlogSummary.setFont(intValue, str3, intValue2);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void setForward(boolean z16) {
        this.mIsForward = z16;
        if (z16) {
            setSectionController(HandBlogForwardController);
        } else {
            setSectionController(HandBlogController);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mFeedData = null;
        setOnFeedElementClickListener(null);
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        this.mFeedData = null;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
    }
}
