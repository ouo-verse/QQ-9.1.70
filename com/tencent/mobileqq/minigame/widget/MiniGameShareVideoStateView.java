package com.tencent.mobileqq.minigame.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameShareVideoStateView extends FrameLayout implements View.OnClickListener {
    static final int STATE_NONE = 0;
    static final int STATE_PLAY = 1;
    static final int STATE_PROGRESSING = 4;
    static final int STATE_RETRY = 3;
    private static final String TAG = "MiniGameShareVideoStateView";
    private CircleProgress circleProgress;
    private MiniGameShareMediaViewClickListener clickListener;
    private int currentState;
    private ImageView playIcon;
    private FrameLayout progressContainer;
    private TextView progressText;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes33.dex */
    public @interface MiniGameShareMediaState {
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface MiniGameShareMediaViewClickListener {
        void onPlayClick();

        void onRetryClick();
    }

    public MiniGameShareVideoStateView(Context context) {
        this(context, null, 0, 0);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.dkh, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.rih);
        this.playIcon = imageView;
        imageView.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ri_);
        this.progressContainer = frameLayout;
        frameLayout.setOnClickListener(this);
        this.progressText = (TextView) findViewById(R.id.ria);
        CircleProgress circleProgress = (CircleProgress) findViewById(R.id.ri9);
        this.circleProgress = circleProgress;
        circleProgress.setProgress(0.0f);
        this.circleProgress.setStrokeWidth(2.0f);
        this.circleProgress.setBgAndProgressColor(50, -1, 100, -1);
        this.circleProgress.setBgAndProgressUseAlpha(true, true);
    }

    private void updateStateUi() {
        int i3 = this.currentState;
        if (i3 == 1) {
            this.playIcon.setVisibility(0);
            this.progressContainer.setVisibility(8);
            return;
        }
        if (i3 == 3) {
            this.playIcon.setVisibility(8);
            this.progressContainer.setVisibility(0);
            this.progressText.setText("\u91cd\u8bd5");
            this.circleProgress.setProgress(0.0f);
            return;
        }
        if (i3 != 4) {
            this.playIcon.setVisibility(8);
            this.progressContainer.setVisibility(8);
        } else {
            this.playIcon.setVisibility(8);
            this.progressContainer.setVisibility(0);
            this.progressText.setText("0%");
            this.circleProgress.setProgress(0.0f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MiniGameShareMediaViewClickListener miniGameShareMediaViewClickListener = this.clickListener;
        if (miniGameShareMediaViewClickListener == null) {
            return;
        }
        if (view == this.playIcon) {
            miniGameShareMediaViewClickListener.onPlayClick();
        } else if (view == this.progressContainer && this.currentState == 3) {
            miniGameShareMediaViewClickListener.onRetryClick();
        }
    }

    public void setClickListener(MiniGameShareMediaViewClickListener miniGameShareMediaViewClickListener) {
        this.clickListener = miniGameShareMediaViewClickListener;
    }

    public void updateIconState(int i3) {
        QLog.d(TAG, 2, "updateState old:" + this.currentState + ", new:" + i3);
        this.currentState = i3;
        updateStateUi();
    }

    public void updateProgress(float f16) {
        if (this.currentState != 4) {
            QLog.e(TAG, 1, "update progress but current state is " + this.currentState + ", you need to call updateState(STATE_PROGRESSING) first");
            return;
        }
        this.progressText.setText(f16 + "%");
        this.circleProgress.setProgress(f16);
    }

    public MiniGameShareVideoStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public MiniGameShareVideoStateView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public MiniGameShareVideoStateView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.currentState = 0;
        initView(context);
    }
}
