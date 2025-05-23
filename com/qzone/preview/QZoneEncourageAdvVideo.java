package com.qzone.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneEncourageAdvVideo extends BaseVideo {

    /* renamed from: d, reason: collision with root package name */
    private int f49676d;

    /* renamed from: e, reason: collision with root package name */
    private int f49677e;

    public QZoneEncourageAdvVideo(Context context) {
        super(context);
        a();
        initData();
    }

    private void initData() {
        a aVar = new a();
        this.mVideoClickListener = aVar;
        setOnClickListener(aVar);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        this.mVideoCover = new QZoneEncourageAdvCover(context, this);
        addView(this.mVideoCover, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public boolean b() {
        return getBaseVideoManager().isCurSoundOpened();
    }

    public void c() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(this);
        getBaseVideoManager().onListIdleSingleVideo(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17 = this.f49676d;
        if (i17 == 0) {
            i17 = this.mVideoCover.getPicWidth();
        }
        int i18 = this.f49677e;
        if (i18 == 0) {
            i18 = this.mVideoCover.getPicHeight();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            super.onMeasure(i3, i16);
            return;
        }
        int defaultSize = View.getDefaultSize(0, i3);
        int defaultSize2 = View.getDefaultSize(0, i16);
        if (i17 > 0 && i18 > 0) {
            int i19 = i17 * defaultSize2;
            int i26 = defaultSize * i18;
            if (i19 > i26) {
                defaultSize2 = i26 / i17;
            } else if (i19 < i26) {
                defaultSize = i19 / i18;
            }
        }
        View view = this.mVideoView;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVideoView.getLayoutParams();
            this.mVideoView.measure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2 - (marginLayoutParams.topMargin * 2), 1073741824));
        }
        this.mVideoCover.measure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setSoundOn(boolean z16) {
        boolean isCurSoundOpened = getBaseVideoManager().isCurSoundOpened();
        if (!isCurSoundOpened && z16) {
            getBaseVideoManager().enableAutoVideoSound();
        }
        if (!isCurSoundOpened || z16) {
            return;
        }
        getBaseVideoManager().f();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void stop() {
        getBaseVideoManager().D(new LinkedList());
    }

    private void a() {
        this.hasTimeview = false;
        this.hasPlayCountView = false;
        this.hasSoundTipLayout = false;
        this.hasSoundLinesLayout = false;
        this.mTimeview = null;
        this.mSoundLinesLayout = null;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        this.f49676d = 0;
        this.f49677e = 0;
        super.setVideoPlayInfo(videoPlayInfo);
    }

    public void setVideoPlayInofCallBack(BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener) {
        if (videoPlayInfoListener != null) {
            BaseVideoManager.getFeedVideoManager().setVideoPlayInfoListener(videoPlayInfoListener);
        }
    }

    public QZoneEncourageAdvVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoSizeChanged(int i3, int i16) {
        if (i3 != 0 && i16 != 0) {
            this.f49676d = i3;
            this.f49677e = i16;
        }
        super.onVideoSizeChanged(i3, i16);
    }

    public QZoneEncourageAdvVideo(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
