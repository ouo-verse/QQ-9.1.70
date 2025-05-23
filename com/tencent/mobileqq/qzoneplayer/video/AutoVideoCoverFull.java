package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class AutoVideoCoverFull extends BaseVideoCover {
    public AutoVideoCoverFull(Context context, BaseVideo baseVideo) {
        super(context, baseVideo);
    }

    public void a() {
        ViewGroup.LayoutParams layoutParams = this.mParent.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        }
        if (layoutParams != null) {
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
        }
        setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawPlayIcon(Canvas canvas) {
        Drawable drawable = this.playIcon;
        drawable.setBounds((this.mCoverWidth - drawable.getIntrinsicWidth()) / 2, (this.mCoverHeight - this.playIcon.getIntrinsicHeight()) / 2, (this.mCoverWidth + this.playIcon.getIntrinsicWidth()) / 2, (this.mCoverHeight + this.playIcon.getIntrinsicHeight()) / 2);
        this.playIcon.draw(canvas);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, android.view.View
    protected void onMeasure(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            int i17 = this.picWidth;
            this.mCoverWidth = i17;
            int i18 = this.picHeight;
            this.mCoverHeight = i18;
            setMeasuredDimension(i17, i18);
            return;
        }
        this.mCoverWidth = View.getDefaultSize(this.picWidth, i3);
        this.mCoverHeight = View.getDefaultSize(this.picHeight, i16);
        setMeasuredDimension(View.getDefaultSize(this.picWidth, i3), View.getDefaultSize(this.picHeight, i16));
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.storeIconClicked && isShowStoreIcon();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void reCaculateSize(int i3, int i16) {
        super.reCaculateSize(i3, i16);
        setCoverRelatView(this.picHeight);
    }

    public void setCoverRelatView(final int i3) {
        BaseVideo baseVideo = this.mParent;
        if (baseVideo == null || !(baseVideo instanceof FeedAutoVideoFull)) {
            return;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.AutoVideoCoverFull.1
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams;
                View view = AutoVideoCoverFull.this.mCoverRelatView;
                if (view == null || (layoutParams = view.getLayoutParams()) == null) {
                    return;
                }
                int i16 = layoutParams.height;
                int i17 = i3;
                if (i16 != i17) {
                    layoutParams.width = -1;
                    layoutParams.height = i17;
                    AutoVideoCoverFull.this.mCoverRelatView.setLayoutParams(layoutParams);
                }
            }
        });
    }
}
