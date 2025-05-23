package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class CoverAutoVideo extends BaseVideo {
    public CoverAutoVideo(Context context) {
        super(context);
        a();
        initData();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        this.mVideoCover = new CoverAutoVideoImage(context, this);
        addView(this.mVideoCover, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected int getDelayHideCoverTime() {
        return 650;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected boolean needShowSoundLine() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int screenWidth = ViewUtils.getScreenWidth();
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo != null) {
            i18 = videoPlayInfo.width;
            i17 = videoPlayInfo.height;
        } else {
            i17 = 0;
            i18 = 0;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            super.onMeasure(i3, i16);
            return;
        }
        int defaultSize = View.getDefaultSize(0, i3);
        int defaultSize2 = View.getDefaultSize(0, i16);
        if (i18 > 0 && i17 > 0) {
            if (i18 > i17) {
                defaultSize = (i18 * screenWidth) / i17;
                defaultSize2 = screenWidth;
            } else {
                defaultSize2 = (i17 * screenWidth) / i18;
                defaultSize = screenWidth;
            }
        }
        View view = this.mVideoView;
        if (view != null && view.getVisibility() != 8) {
            this.mVideoView.measure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2 - (((ViewGroup.MarginLayoutParams) this.mVideoView.getLayoutParams()).topMargin * 2), 1073741824));
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(screenWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(screenWidth, 1073741824);
        ViewGroup.LayoutParams layoutParams2 = this.mVideoCover.getLayoutParams();
        layoutParams2.height = CoverEnv.getFinalCoverHeight();
        layoutParams2.width = screenWidth;
        this.mVideoCover.setLayoutParams(layoutParams2);
        this.mVideoCover.measure(makeMeasureSpec, makeMeasureSpec2);
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onReceivedMessage(Message message) {
        super.onReceivedMessage(message);
        int i3 = message.what;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        super.setVideoPlayInfo(videoPlayInfo);
        ((ViewGroup) getParent()).setContentDescription("videoContainer");
    }

    private void a() {
        this.mTimeview = null;
        this.mSoundLinesLayout = null;
    }

    private void initData() {
    }
}
