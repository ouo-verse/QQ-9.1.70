package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.component.utils.Pair;
import com.tencent.mobileqq.qzoneplayer.ui.RotationSeekBar;
import com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FeedAutoVideoControllerView extends VideoControllerView {
    public static int defaultTimeoutMills = 3000;
    private boolean hasController;
    private RotationSeekBar mBottomSeekBar;
    private View mBottomSeekBarLayout;
    private c mControllerVisibilityListener;
    private int mVideoHeight;
    private int mVideoWidth;
    private BaseVideo videoView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoControllerView.this.doToggleFullscreen();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoControllerView.this.doToggleLandscape();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface c {
    }

    public FeedAutoVideoControllerView(Context context, AttributeSet attributeSet, PlayerResources playerResources) {
        super(context, attributeSet, playerResources);
        initData();
    }

    public void cancelFadeout() {
        this.mHandler.removeMessages(1);
    }

    public VideoControllerView.MediaPlayerControl getPlayer() {
        return this.mPlayer;
    }

    public ProgressBar getSeekBar() {
        return this.mProgress;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public void hide() {
        if (this.mAnchor == null) {
            return;
        }
        if (this.mBottomSeekBarLayout != null && !this.mPlayer.isFullScreen()) {
            this.mBottomSeekBarLayout.setVisibility(0);
        }
        this.mShowing = false;
    }

    public void initData() {
        this.mFullscreenListener = new a();
        this.mSwitchLandscapeListener = new b();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    protected View makeControllerView() {
        View inflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(this.playerResources.getLayoutId(3), (ViewGroup) null);
        this.mRoot = inflate;
        initControllerView(inflate);
        return this.mRoot;
    }

    public void markAtPosition(ArrayList<Pair<Integer, Integer>> arrayList) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null || !(progressBar instanceof RotationSeekBar)) {
            return;
        }
        RotationSeekBar rotationSeekBar = (RotationSeekBar) progressBar;
        if (arrayList != null && arrayList.size() > 0) {
            float[] convertToPercent = convertToPercent(arrayList);
            if (convertToPercent != null) {
                rotationSeekBar.placeMarkerAtPositions(convertToPercent);
                return;
            }
            return;
        }
        rotationSeekBar.placeMarkerAtPositions(null);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public int setProgress(int i3) {
        super.setProgress(i3);
        if (this.mBottomSeekBar == null || this.mShowing) {
            return 0;
        }
        this.mBottomSeekBar.setProgress(this.mProgress.getProgress());
        this.mBottomSeekBar.setSecondaryProgress(this.mProgress.getSecondaryProgress());
        return 0;
    }

    public void setSeekbarRotationChangeListener(RotationSeekBar.OnRotationChangeListener onRotationChangeListener) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null || !(progressBar instanceof RotationSeekBar)) {
            return;
        }
        ((RotationSeekBar) progressBar).setOnRotationChangeListener(onRotationChangeListener);
    }

    public void setVideoBottomSeekBar(View view, RotationSeekBar rotationSeekBar) {
        this.mBottomSeekBarLayout = view;
        this.mBottomSeekBar = rotationSeekBar;
    }

    public void setVideoDimension(int i3, int i16) {
        this.mVideoWidth = i3;
        this.mVideoHeight = i16;
    }

    public void setVideoView(BaseVideo baseVideo) {
        this.videoView = baseVideo;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public void show() {
        resetDraggingState();
        show(defaultTimeoutMills);
    }

    public void startFadeout() {
        startFadeout(defaultTimeoutMills);
    }

    public void updateLayout() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        BaseVideo baseVideo = this.videoView;
        if (baseVideo != null) {
            int i3 = baseVideo.getLayoutParams().height;
            if (i3 == -2) {
                layoutParams.topMargin = this.mVideoHeight - FeedVideoEnv.dp40;
            } else if (i3 == -1) {
                layoutParams.addRule(12);
            }
            setLayoutParams(layoutParams);
        }
    }

    public void startFadeout(int i3) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        if (i3 == 0) {
            this.mHandler.sendEmptyMessage(1);
        } else {
            this.mHandler.sendMessageDelayed(obtainMessage, i3);
        }
    }

    public FeedAutoVideoControllerView(Context context, boolean z16, PlayerResources playerResources) {
        super(context, z16, playerResources);
        initData();
    }

    private float[] convertToPercent(ArrayList<Pair<Integer, Integer>> arrayList) {
        int intValue;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<Pair<Integer, Integer>> it = arrayList.iterator();
        int i3 = -1;
        int i16 = 0;
        int i17 = 0;
        while (it.hasNext()) {
            Pair<Integer, Integer> next = it.next();
            if (((Integer) next.first).intValue() >= i3 && (intValue = ((Integer) next.second).intValue() - ((Integer) next.first).intValue()) > 0) {
                i16 += intValue;
                iArr[i17] = intValue;
                i3 = ((Integer) next.second).intValue();
                i17++;
            }
        }
        int i18 = 0;
        for (int i19 = 0; i19 < size; i19++) {
            fArr[i18] = (i18 == 0 ? 0.0f : fArr[i18 - 1]) + (iArr[i19] / i16);
            i18++;
        }
        return fArr;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public void show(int i3) {
        if (!this.mShowing && this.mAnchor != null) {
            postSetProgress();
            disableUnsupportedButtons();
            updateLayout();
            if (!this.hasController) {
                this.mAnchor.addView(this);
                this.hasController = true;
            }
            this.mShowing = true;
        }
        View view = this.mBottomSeekBarLayout;
        if (view != null) {
            view.setVisibility(4);
        }
        updatePausePlay();
        updateFullScreen();
        updateLandscapeIndicator();
        updateStreamNameButton();
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessage(2);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        this.mHandler.removeMessages(1);
        if (i3 != 0) {
            this.mHandler.sendMessageDelayed(obtainMessage, i3);
        }
    }

    public FeedAutoVideoControllerView(Context context, PlayerResources playerResources) {
        super(context, playerResources);
        initData();
    }

    public void setControllerVisibilityListener(c cVar) {
    }
}
