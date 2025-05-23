package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ExFeedTitleView extends FrameLayout implements r {
    public static final int HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(58.0f);
    BusinessFeedData mFeedData;
    com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    int mPos;
    protected CanvasTitleView mSimpleTitleView;
    int mTrans;
    private VideoPlayInfo videoPlayInfo;

    public ExFeedTitleView(Context context) {
        super(context);
        initUI(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.mFeedData == null) {
            setMeasuredDimension(0, 0);
        } else {
            this.mSimpleTitleView.measure(i3, i16);
            setMeasuredDimension(View.MeasureSpec.getSize(i3), HEIGHT);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        if (com.qzone.adapter.feedcomponent.i.H().o0()) {
            this.mSimpleTitleView.onRecycled();
        }
    }

    public void onUpdate() {
        if (getVisibility() != 0) {
            return;
        }
        this.mSimpleTitleView.setFeedData(this.mFeedData, false, false);
        this.mSimpleTitleView.update();
        this.mSimpleTitleView.forceLayout();
    }

    public void setAlpha(int i3) {
        this.mTrans = i3;
        if (getBackground() != null) {
            getBackground().setAlpha(this.mTrans);
        }
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
    }

    public void setFeedPos(int i3, int i16) {
        this.mPos = i3;
        this.mSimpleTitleView.setFeedPosition(i3, i16);
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
        this.mSimpleTitleView.setOnFeedElementClickListener(gVar);
    }

    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        this.videoPlayInfo = videoPlayInfo;
        this.mSimpleTitleView.setVideoPlayInfo(videoPlayInfo);
    }

    void initUI(Context context) {
        setBackgroundColor(-1);
        this.mSimpleTitleView = new CanvasTitleView(context, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AreaConst.feedWidth_Rec, HEIGHT);
        layoutParams.gravity = 48;
        this.mSimpleTitleView.setLayoutParams(layoutParams);
        CanvasTitleView canvasTitleView = this.mSimpleTitleView;
        int i3 = AreaConst.dp10;
        int i16 = AreaConst.f48748dp3;
        canvasTitleView.setPadding(i3, i16, 0, i16);
        addView(this.mSimpleTitleView);
    }

    public ExFeedTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public ExFeedTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initUI(context);
    }
}
