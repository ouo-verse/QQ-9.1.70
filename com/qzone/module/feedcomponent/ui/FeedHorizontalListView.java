package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import com.qzone.module.feedcomponent.actionreport.UserActionReportHelper;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.widget.HorizontalListView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedHorizontalListView extends HorizontalListView implements com.qzone.proxy.feedcomponent.widget.g, FeedChildView {
    public static FeedViewSection.SectionController FriendPlayingController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedHorizontalListView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData != null && businessFeedData.isFriendPlayingFeed() && businessFeedData.getPicTextInfo() != null) {
                return false;
            }
            if (businessFeedData == null || !businessFeedData.isPublicAccountContainer()) {
                return businessFeedData == null || !businessFeedData.isRecommendQQCircleFeed();
            }
            return false;
        }
    };
    private static final String TAG = "FRIENDPLAYING";
    protected BaseAdapter mAdapter;
    protected float mAlpha;
    protected Context mContext;
    int mDownX;
    int mDownY;
    protected BusinessFeedData mFeedData;
    private Integer mFeedPos;
    private boolean mIsFriendPlayingCardV2;
    private com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    private boolean mUsed;
    boolean scrollDirectionDetermined;

    public FeedHorizontalListView(Context context) {
        super(context);
        this.mUsed = false;
        this.mIsFriendPlayingCardV2 = false;
        this.mAlpha = 255.0f;
        this.mDownX = 0;
        this.mDownY = 0;
        this.scrollDirectionDetermined = false;
        this.mContext = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r2 != 3) goto L19;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.scrollDirectionDetermined) {
                        int abs = Math.abs(x16 - this.mDownX);
                        int abs2 = Math.abs(y16 - this.mDownY);
                        if (Math.max(abs, abs2) > AreaConst.SCROLL_DIRECTION_THRESHHOLD) {
                            this.scrollDirectionDetermined = true;
                        }
                        if (abs < abs2) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
            }
            this.scrollDirectionDetermined = false;
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
        } else {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
            getParent().requestDisallowInterceptTouchEvent(true);
            this.mDownX = x16;
            this.mDownY = y16;
        }
        UserActionReportHelper.containerOnTouchEvent(motionEvent, this.mAdapter);
        return super.dispatchTouchEvent(motionEvent);
    }

    public Integer getFeedPos() {
        return this.mFeedPos;
    }

    public boolean hasUsed() {
        return this.mUsed;
    }

    @Override // com.tencent.widget.HorizontalListView, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17 = AreaManager.dp201_5;
        if (this.mIsFriendPlayingCardV2) {
            i17 = AreaConst.dp213;
            int i18 = AreaConst.dp5;
            setPadding(i18, 0, i18, 0);
        }
        setMeasuredDimension(FeedGlobalEnv.g().getScreenWidth(), i17);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter instanceof com.qzone.proxy.feedcomponent.widget.g) {
            ((com.qzone.proxy.feedcomponent.widget.g) spinnerAdapter).onRecycled();
        }
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        this.mAlpha = f16;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        this.mIsFriendPlayingCardV2 = businessFeedData != null && businessFeedData.isFriendPlayingFeedV2();
        BaseAdapter adapter = getAdapter(businessFeedData);
        this.mAdapter = adapter;
        this.mUsed = true;
        setAdapter((ListAdapter) adapter);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
        this.mFeedPos = Integer.valueOf(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
    }

    public void setUsed(boolean z16) {
        this.mUsed = z16;
    }

    public void reset() {
        this.mOnFeedElementClickListener = null;
        this.mUsed = false;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
        this.mAlpha = i3;
    }

    private BaseAdapter getAdapter(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.isFriendPlayingFeed() && businessFeedData.getPicTextInfo() != null) {
            FriendPlayingAdapter friendPlayingAdapter = new FriendPlayingAdapter(this.mContext, this.mAlpha, this.mIsFriendPlayingCardV2, this.mFeedData, getFeedPos(), this.mOnFeedElementClickListener);
            friendPlayingAdapter.setPicText(businessFeedData.getPicTextInfo().picTexts);
            return friendPlayingAdapter;
        }
        if (businessFeedData == null) {
            return null;
        }
        if (!businessFeedData.isPublicAccountContainer() && !businessFeedData.isRecommendQQCircleFeed()) {
            return null;
        }
        PublicAccountContainerAdapter publicAccountContainerAdapter = new PublicAccountContainerAdapter(this.mContext, this.mAlpha, this.mFeedData, getFeedPos(), this.mOnFeedElementClickListener);
        publicAccountContainerAdapter.setRecFeedDatas(businessFeedData.getRecBusinessFeedDatas());
        return publicAccountContainerAdapter;
    }

    public FeedHorizontalListView(Context context, boolean z16) {
        super(context, z16);
        this.mUsed = false;
        this.mIsFriendPlayingCardV2 = false;
        this.mAlpha = 255.0f;
        this.mDownX = 0;
        this.mDownY = 0;
        this.scrollDirectionDetermined = false;
        this.mContext = context;
    }

    public FeedHorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUsed = false;
        this.mIsFriendPlayingCardV2 = false;
        this.mAlpha = 255.0f;
        this.mDownX = 0;
        this.mDownY = 0;
        this.scrollDirectionDetermined = false;
        this.mContext = context;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    public FeedHorizontalListView(Context context, AttributeSet attributeSet, boolean z16) {
        super(context, attributeSet, z16);
        this.mUsed = false;
        this.mIsFriendPlayingCardV2 = false;
        this.mAlpha = 255.0f;
        this.mDownX = 0;
        this.mDownY = 0;
        this.scrollDirectionDetermined = false;
        this.mContext = context;
    }
}
