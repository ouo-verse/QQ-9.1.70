package com.tencent.qqmini.sdk.widget.media;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.qqmini.sdk.R;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VideoGestureLayout extends RelativeLayout {
    private static final String TAG = "VideoGestureLayout";
    private int duration;
    private ImageView ivCenter;
    private HideRunnable mHideRunnable;

    /* renamed from: pb, reason: collision with root package name */
    private ProgressBar f348403pb;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class HideRunnable implements Runnable {
        HideRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoGestureLayout.this.setVisibility(8);
        }
    }

    public VideoGestureLayout(Context context) {
        super(context);
        this.duration = 1000;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mini_sdk_video_gesture_layout, this);
        this.ivCenter = (ImageView) findViewById(R.id.iv_center);
        this.f348403pb = (ProgressBar) findViewById(R.id.f348011pb);
        this.mHideRunnable = new HideRunnable();
        setVisibility(8);
    }

    public void setDuration(int i3) {
        this.duration = i3;
    }

    public void setImageResource(int i3) {
        this.ivCenter.setImageResource(i3);
    }

    public void setProgress(int i3) {
        this.f348403pb.setProgress(i3);
        Log.d(TAG, "setProgress: " + i3);
    }

    public void show() {
        setVisibility(0);
        removeCallbacks(this.mHideRunnable);
        postDelayed(this.mHideRunnable, this.duration);
    }

    public VideoGestureLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duration = 1000;
        init(context);
    }
}
