package com.tencent.mobileqq.videoplatform.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.VideoPlayerInnerCallback;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.PlayerState;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.mobileqq.videoplatform.util.UIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.List;

/* loaded from: classes20.dex */
public class QQVideoPlayView extends RelativeLayout implements IBaseVideoView, VideoPlayerInnerCallback, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    static IPatchRedirector $redirector_ = null;
    public static final float MAX_PROGRESS = 10000.0f;
    BaseVideoView mBaseVideoView;
    public RelativeLayout mBufferPanel;
    private ImageView mCenterPlayBtn;
    private LinearLayout mErrLayout;
    private boolean mIsPlay;
    public SeekBar mPlayBar;
    public ImageView mPlayButton;
    public RelativeLayout mPlayPanel;
    public TextView mProgressTime;
    public TextView mRateText;
    public TextView mTotalTime;

    public QQVideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mIsPlay = false;
        this.mBaseVideoView = new BaseVideoView(context, 0L, null, null, this);
        initView();
    }

    private void addBaseVideoView() {
        this.mBaseVideoView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.mBaseVideoView);
    }

    private void addBuffView() {
        this.mBufferPanel = (RelativeLayout) View.inflate(getContext(), R.layout.i3j, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mBufferPanel.setVisibility(8);
        addView(this.mBufferPanel, layoutParams);
        TextView textView = (TextView) this.mBufferPanel.findViewById(R.id.hvh);
        this.mRateText = textView;
        textView.setVisibility(8);
    }

    private void addCenterPlayBtn() {
        ImageView imageView = new ImageView(getContext());
        this.mCenterPlayBtn = imageView;
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.f162653oc3));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mCenterPlayBtn.setLayoutParams(layoutParams);
        addView(this.mCenterPlayBtn);
        this.mCenterPlayBtn.bringToFront();
        this.mCenterPlayBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.videoplatform.view.QQVideoPlayView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQVideoPlayView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (LogUtil.isColorLevel()) {
                        LogUtil.d(QQVideoPlayView.this.getLogTag(), 2, "mCenterPlayBtn onClick.");
                    }
                    QQVideoPlayView.this.play();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private void addErrView() {
        this.mErrLayout = (LinearLayout) View.inflate(getContext(), R.layout.i3k, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.mErrLayout, layoutParams);
    }

    private void addPlayCtlView() {
        this.mPlayPanel = (RelativeLayout) View.inflate(getContext(), R.layout.i3l, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mPlayPanel.setLayoutParams(layoutParams);
        addView(this.mPlayPanel);
        this.mPlayPanel.bringToFront();
        this.mPlayBar = (SeekBar) this.mPlayPanel.findViewById(R.id.ilh);
        ImageView imageView = (ImageView) this.mPlayPanel.findViewById(R.id.fff);
        this.mPlayButton = imageView;
        imageView.setImageResource(R.drawable.f162650oc0);
        this.mProgressTime = (TextView) this.mPlayPanel.findViewById(R.id.g1m);
        this.mTotalTime = (TextView) this.mPlayPanel.findViewById(R.id.jut);
        updateTotalTime();
        this.mPlayButton.setOnClickListener(this);
        this.mPlayBar.setMax(10000);
        this.mPlayBar.setOnSeekBarChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogTag() {
        return "[VideoPlatForm]QQVideoPlayView[" + this.mBaseVideoView.getLogId() + "]";
    }

    private void initView() {
        addBaseVideoView();
        addPlayCtlView();
        addBuffView();
        addErrView();
        addCenterPlayBtn();
    }

    private void updateTotalTime() {
        TextView textView;
        if (getVideoDurationMs() > 0 && (textView = this.mTotalTime) != null) {
            textView.setText(UIUtil.stringForTime(getVideoDurationMs()));
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void addSubtitleSource(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, str2, str3);
        } else {
            this.mBaseVideoView.addSubtitleSource(str, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void captureCurFrame(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mBaseVideoView.captureCurFrame(j3, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void createMediaPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.mBaseVideoView.createMediaPlayer();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public Drawable getCoverDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mBaseVideoView.getCoverDrawable();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public ImageView getCoverImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ImageView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mBaseVideoView.getCoverImage();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public long getCurPlayingPos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.mBaseVideoView.getCurPlayingPos();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public long getVideoDurationMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.mBaseVideoView.getVideoDurationMs();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public boolean isLocalPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.mBaseVideoView.isLocalPlay();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public boolean isMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.mBaseVideoView.isMute();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mBaseVideoView.isPlaying();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
        } else {
            this.mBaseVideoView.onCapFrame(j3, z16, i3, i16, bitmap);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) view);
        } else if (view.getId() == R.id.fff) {
            if (this.mIsPlay) {
                pause();
            } else {
                play();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadComplete(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, j3);
        } else {
            this.mBaseVideoView.onDownloadComplete(j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.mBaseVideoView.onDownloadProgress(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onFirstFrameRendered(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, j3);
        } else {
            this.mBaseVideoView.onFirstFrameRendered(j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onLoopBack(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.mBaseVideoView.onLoopBack(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayError(long j3, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        String string = getContext().getString(R.string.f238387jm);
        if (i3 == 1) {
            string = getContext().getString(R.string.f238377jl);
        }
        if (i17 == 14011001) {
            string = getContext().getString(R.string.f238397jn);
        }
        ThreadUtil.postOnUIThread(new Runnable(string) { // from class: com.tencent.mobileqq.videoplatform.view.QQVideoPlayView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$erroText;

            {
                this.val$erroText = string;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQVideoPlayView.this, (Object) string);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QQVideoPlayView.this.mBufferPanel.setVisibility(8);
                QQVideoPlayView.this.mErrLayout.setVisibility(0);
                QQVideoPlayView.this.mCenterPlayBtn.setVisibility(8);
                QQVideoPlayView.this.mPlayButton.setImageResource(R.drawable.f162650oc0);
                TextView textView = (TextView) QQVideoPlayView.this.mErrLayout.findViewById(R.id.byl);
                if (textView != null) {
                    textView.setText(this.val$erroText);
                }
            }
        });
        this.mBaseVideoView.onPlayError(j3, i3, i16, i17, str);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onPlayProgress , id = " + j3 + ", positionMs=" + j16);
        }
        if (this.mBaseVideoView.getVideoDurationMs() > 0) {
            this.mProgressTime.setText(UIUtil.stringForTime(j16));
            this.mPlayBar.setProgress((int) ((j16 / this.mBaseVideoView.getVideoDurationMs()) * 10000.0d));
        }
        this.mBaseVideoView.onPlayProgress(j3, j16);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, seekBar, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else if (z16) {
            this.mBaseVideoView.seekTo((int) ((i3 / 10000.0f) * ((float) this.mBaseVideoView.getVideoDurationMs())));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) seekBar);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onStateChange(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onStateChange , state = " + PlayerState.getStateStr(i3) + ", msgUniseq=" + j3);
        }
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 == 8 || i3 == 9) {
                    this.mBufferPanel.setVisibility(8);
                    this.mErrLayout.setVisibility(8);
                    this.mCenterPlayBtn.setVisibility(0);
                    this.mPlayButton.setImageResource(R.drawable.f162650oc0);
                }
            } else {
                BaseVideoView baseVideoView = this.mBaseVideoView;
                if (baseVideoView != null) {
                    if (baseVideoView.isPlaying()) {
                        this.mBufferPanel.setVisibility(0);
                    } else {
                        this.mBufferPanel.setVisibility(8);
                    }
                }
                this.mErrLayout.setVisibility(8);
            }
        } else {
            this.mBufferPanel.setVisibility(8);
            this.mErrLayout.setVisibility(8);
            this.mCenterPlayBtn.setVisibility(8);
            updateTotalTime();
        }
        this.mBaseVideoView.onStateChange(j3, i3);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) seekBar);
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.tencent.mobileqq.videoplatform.VideoPlayerInnerCallback
    public void onSurfaceDestroy(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, j3);
        } else {
            this.mBaseVideoView.onSurfaceDestroy(j3);
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.mIsPlay = false;
        this.mBufferPanel.setVisibility(8);
        this.mErrLayout.setVisibility(8);
        this.mCenterPlayBtn.setVisibility(0);
        this.mPlayButton.setImageResource(R.drawable.f162650oc0);
        this.mBaseVideoView.pause();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void pauseDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.mBaseVideoView.pauseDownload();
        }
    }

    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.mIsPlay = true;
        this.mErrLayout.setVisibility(8);
        this.mCenterPlayBtn.setVisibility(8);
        this.mPlayButton.setImageResource(R.drawable.f162651oc1);
        this.mBaseVideoView.play();
    }

    public void releasePlayer(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.mBaseVideoView.releasePlayer(z16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.mIsPlay) {
            this.mBaseVideoView.resume();
            this.mCenterPlayBtn.setVisibility(8);
            this.mPlayButton.setImageResource(R.drawable.f162651oc1);
        } else {
            this.mCenterPlayBtn.setVisibility(0);
            this.mPlayButton.setImageResource(R.drawable.f162650oc0);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void resumeDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.mBaseVideoView.resumeDownload();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            this.mBaseVideoView.seekTo(i3);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setCoverDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
        } else {
            this.mBaseVideoView.setCoverDrawable(drawable);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setID(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.mBaseVideoView.setID(j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.mBaseVideoView.setMute(z16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) onSubtitleDataListener);
        } else {
            this.mBaseVideoView.setOnSubtitleDataListener(onSubtitleDataListener);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setPlayerOptionalParamList(List<TPOptionalParam> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) list);
        } else {
            this.mBaseVideoView.setPlayerOptionalParamList(list);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setVideoParam(VideoPlayParam videoPlayParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoPlayParam);
            return;
        }
        if (videoPlayParam != null) {
            videoPlayParam.mNeedPlayProgress = true;
        }
        this.mBaseVideoView.setVideoParam(videoPlayParam);
        updateTotalTime();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void showCover(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable);
        } else {
            this.mBaseVideoView.showCover(drawable);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void seekTo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            this.mBaseVideoView.seekTo(i3, i16);
        } else {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public QQVideoPlayView(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(j3), videoPlayParam, imageView);
            return;
        }
        this.mIsPlay = false;
        if (videoPlayParam != null) {
            videoPlayParam.mNeedPlayProgress = true;
        }
        this.mBaseVideoView = new BaseVideoView(context, j3, videoPlayParam, imageView, this);
        initView();
    }
}
