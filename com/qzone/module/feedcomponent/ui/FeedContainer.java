package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommHeader;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.tencent.mobileqq.richstatus.RichStatus;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedContainer extends AbsFeedView {
    public static int alpha = 255;
    FeedContainerAdapter adapter;
    GalleryEx gallery;
    boolean hasRecyled;
    boolean isBusinessPhotoFeed;
    CellTextView leftCorner;
    int mFeedPos;
    BusinessFeedData mFeeddata;
    int mSelectedPos;
    FeedView mSelectedView;
    Paint paint;

    public FeedContainer(Context context) {
        super(context);
        this.mSelectedPos = -1;
        this.mFeedPos = -1;
        this.paint = new Paint();
        this.type = 1;
        setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        setDrawingCacheEnabled(false);
        setWillNotDraw(false);
        setOrientation(1);
        this.leftCorner = new CellTextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = AreaConst.dp6;
        this.leftCorner.setLayoutParams(layoutParams);
        this.leftCorner.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
        this.leftCorner.setTextSize(FeedGlobalEnv.g().getSpValue(13.0f));
        this.leftCorner.setPadding(AreaConst.dp10, 0, 0, 0);
        addView(this.leftCorner);
        GalleryEx galleryEx = new GalleryEx(context);
        this.gallery = galleryEx;
        galleryEx.setOverScrollMode(2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = AreaConst.dp5;
        this.gallery.setLayoutParams(layoutParams2);
        FeedContainerAdapter feedContainerAdapter = new FeedContainerAdapter();
        this.adapter = feedContainerAdapter;
        this.gallery.setAdapter(feedContainerAdapter);
        addView(this.gallery);
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public BusinessFeedData getFeedData() {
        return this.mFeeddata;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPos;
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

    boolean isTouchAboveFeedView(MotionEvent motionEvent) {
        if (!this.isBusinessPhotoFeed) {
            return false;
        }
        int action = motionEvent.getAction();
        return action != 0 ? action == 1 && motionEvent.getY() < ((float) this.gallery.getTop()) : motionEvent.getY() < ((float) this.gallery.getTop());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.isBusinessPhotoFeed) {
            this.paint.setColor(-1);
            this.paint.setAlpha(alpha);
            int i3 = AreaConst.dp10;
            canvas.drawRect(0.0f, i3, getMeasuredWidth(), getMeasuredHeight(), this.paint);
            this.paint.setColor(com.qzone.adapter.feedcomponent.j.s());
            this.paint.setAlpha(alpha);
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), i3, this.paint);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onPause() {
        int subViewCounts = this.gallery.getSubViewCounts();
        for (int i3 = 0; i3 < subViewCounts; i3++) {
            ((FeedView) this.gallery.getSubView(i3)).onPause();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mFeeddata.currShowIndex = this.gallery.getScrollX();
        if (this.hasRecyled) {
            return;
        }
        this.hasRecyled = true;
        int subViewCounts = this.gallery.getSubViewCounts();
        ViewLoader viewLoader = ViewLoader.getInstance();
        for (int i3 = 0; i3 < subViewCounts; i3++) {
            FeedView feedView = (FeedView) this.gallery.getSubView(i3);
            feedView.onRecycled();
            viewLoader.recyleFeedViewInContainer(feedView);
        }
        this.gallery.resetView();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
        int subViewCounts = this.gallery.getSubViewCounts();
        for (int i3 = 0; i3 < subViewCounts; i3++) {
            ((FeedView) this.gallery.getSubView(i3)).onPause();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isTouchAboveFeedView(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        alpha = i3;
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeeddata = businessFeedData;
        if (this.mFeedData.getFeedCommInfo().recomtype == 7) {
            this.isBusinessPhotoFeed = true;
            setPadding(0, 0, 0, 0);
        } else {
            int i3 = AreaConst.dp10;
            setPadding(0, i3, 0, i3);
        }
        this.hasRecyled = false;
        this.adapter.setData(businessFeedData.getRecBusinessFeedDatas(), getContext());
        CellRecommHeader recommHeader = businessFeedData.getRecommHeader();
        if (recommHeader != null) {
            this.leftCorner.setRichText(recommHeader.desLeftTitle);
        }
        this.gallery.scrollTo(this.mFeeddata.currShowIndex, 1);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPos = i3;
        this.adapter.mFeedPos = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.adapter.mOnFeedElementClickListener = gVar;
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
