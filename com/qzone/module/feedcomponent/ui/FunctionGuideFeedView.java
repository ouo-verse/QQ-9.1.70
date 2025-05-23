package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FunctionGuideFeedView extends AbsFeedView {
    View feedBody;
    View gap;
    CellTextView mButton;
    View mButtonContainer;
    CellGuiding mCellFunctionGuide;
    View mContentArea;
    protected int mFeedPosition;
    AsyncImageView mFunctionBanner;
    protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    AsyncImageView mRightCornerIcon;
    CellTextView mSummary;
    CellTextView mTitle;
    int mTrans;

    public FunctionGuideFeedView(Context context) {
        super(context);
        this.mTrans = 255;
        setOrientation(1);
        setBackgroundColor(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FunctionGuideFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        View view = new View(context);
        this.gap = view;
        view.setBackgroundColor(com.qzone.adapter.feedcomponent.j.s());
        this.gap.setLayoutParams(new LinearLayout.LayoutParams(-1, AreaConst.dp15));
        addView(this.gap);
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1675), (ViewGroup) null);
        this.feedBody = inflate;
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.feedBody.setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
        addView(this.feedBody);
        this.mRightCornerIcon = (AsyncImageView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2415));
        this.mFunctionBanner = (AsyncImageView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2416));
        CellTextView cellTextView = (CellTextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2417));
        this.mTitle = cellTextView;
        cellTextView.setTextColor(com.qzone.adapter.feedcomponent.j.o());
        CellTextView cellTextView2 = (CellTextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2418));
        this.mSummary = cellTextView2;
        cellTextView2.setTextColor(com.qzone.adapter.feedcomponent.j.F());
        this.mSummary.setTextGravity(1);
        this.mButtonContainer = this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2852));
        CellTextView cellTextView3 = (CellTextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2419));
        this.mButton = cellTextView3;
        cellTextView3.setTextColor(-1);
        this.mButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FunctionGuideFeedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                FunctionGuideFeedView functionGuideFeedView = FunctionGuideFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = functionGuideFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(functionGuideFeedView.mButton, FeedElement.FEED_FUNCTION_GUIDE_BUTTON_CLICKED, functionGuideFeedView.mFeedPosition, functionGuideFeedView.mCellFunctionGuide);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mRightCornerIcon.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FunctionGuideFeedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                FunctionGuideFeedView functionGuideFeedView = FunctionGuideFeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = functionGuideFeedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    AsyncImageView asyncImageView = functionGuideFeedView.mRightCornerIcon;
                    FeedElement feedElement = FeedElement.FEEDBACK;
                    int i3 = functionGuideFeedView.mFeedPosition;
                    gVar.onClick(asyncImageView, feedElement, i3, Integer.valueOf(i3));
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPosition;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        Drawable background;
        this.mTrans = i3;
        View view = this.gap;
        if (view == null || (background = view.getBackground()) == null) {
            return;
        }
        background.setAlpha(this.mTrans);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            this.feedBody.setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
            this.mFeedData = businessFeedData;
            CellGuiding cellGuiding = businessFeedData.getCellGuiding();
            this.mCellFunctionGuide = cellGuiding;
            if (cellGuiding != null) {
                CellTextView cellTextView = this.mTitle;
                String str = cellGuiding.title;
                if (str == null) {
                    str = "";
                }
                cellTextView.setRichText(str);
                CellTextView cellTextView2 = this.mSummary;
                String str2 = cellGuiding.summary;
                cellTextView2.setRichText(str2 != null ? str2 : "");
                if (!TextUtils.isEmpty(cellGuiding.button_title)) {
                    this.mButton.setRichText(cellGuiding.button_title);
                } else {
                    this.mButtonContainer.setVisibility(8);
                }
                PictureItem pictureItem = cellGuiding.pic;
                if (pictureItem != null) {
                    int screenWidth = FeedGlobalEnv.g().getScreenWidth();
                    PictureUrl pictureUrl = pictureItem.currentUrl;
                    this.mFunctionBanner.setAsyncImageProcessor(new NormalFeedImageProcessor(screenWidth, (int) (pictureUrl.height * (screenWidth / pictureUrl.width)), pictureItem.pivotXRate, pictureItem.pivotYRate));
                    this.mFunctionBanner.setAsyncImage(com.qzone.adapter.feedcomponent.j.D(pictureItem.currentUrl.url));
                }
            }
        }
        if (com.qzone.adapter.feedcomponent.i.O0()) {
            this.gap.setBackgroundColor(com.qzone.adapter.feedcomponent.j.s());
            this.gap.setVisibility(0);
        } else {
            this.gap.setVisibility(8);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedFirstDrawListener(com.qzone.proxy.feedcomponent.ui.i iVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, Boolean bool) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
