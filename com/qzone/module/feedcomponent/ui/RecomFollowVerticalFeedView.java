package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RecomFollowVerticalFeedView extends AbsFeedView {
    private View feedBody;
    private View mGapView;
    int mTrans;
    private CanvasRecomFollowVerticalView mVerticalView;

    public RecomFollowVerticalFeedView(Context context) {
        super(context);
        this.mTrans = 255;
        setOrientation(1);
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1708), (ViewGroup) null);
        this.feedBody = inflate;
        addView(inflate);
        CanvasRecomFollowVerticalView canvasRecomFollowVerticalView = (CanvasRecomFollowVerticalView) findViewById(com.qzone.adapter.feedcomponent.j.O(2723));
        this.mVerticalView = canvasRecomFollowVerticalView;
        canvasRecomFollowVerticalView.setBackgroundColor(com.qzone.adapter.feedcomponent.j.m());
        View findViewById = findViewById(com.qzone.adapter.feedcomponent.j.O(2724));
        this.mGapView = findViewById;
        findViewById.setBackgroundColor(com.qzone.adapter.feedcomponent.j.s());
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
        this.mTrans = i3;
        View view = this.mGapView;
        if (view != null && view.getBackground() != null) {
            this.mGapView.getBackground().setAlpha(i3);
        }
        CanvasRecomFollowVerticalView canvasRecomFollowVerticalView = this.mVerticalView;
        if (canvasRecomFollowVerticalView == null || canvasRecomFollowVerticalView.getBackground() == null) {
            return;
        }
        this.mVerticalView.getBackground().setAlpha(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mVerticalView.setFeedPosition(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mVerticalView.setOnFeedElementClickListener(gVar);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
        this.mVerticalView.updateFollowInfo(businessFeedData, j3, z16);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getRecBusinessFeedDatas() == null || businessFeedData.getRecommHeader() == null) {
            return;
        }
        this.mVerticalView.setFeedData(businessFeedData);
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
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
