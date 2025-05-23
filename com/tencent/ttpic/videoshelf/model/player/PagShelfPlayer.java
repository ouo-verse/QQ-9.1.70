package com.tencent.ttpic.videoshelf.model.player;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.libpag.PagUtil;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;
import org.libpag.PAGText;

/* loaded from: classes27.dex */
public class PagShelfPlayer implements IVideoShelfPlayer {
    public static final String AUDIO_PATH = "pagShelfPlayerAudioFilePath";
    public static final int ERR_AUDIO_PLAYER = -2;
    public static final int ERR_FILE_NOT_FOUND = -1;
    public static final String IMG_GROUP = "imgGroup";
    public static final String PAG_IMG = "pagImgReplace";
    public static final int PAG_SDK_LOW = -3;
    public static final String PAG_TEXT = "pagTextReplace";
    private MediaPlayer mAudioPlayer;
    private Handler mHandler;
    private PAGFile mPagFile;
    private PAGRenderer mPagRender;
    private PAGSurface mPagSurface;
    private PagPlayTimerTask mPlayTask;
    private RenderRunable mRenderRunable;
    private Timer mTimer;
    private IVideoShelfPlayerListener mVideoShelfListener;
    private final String TAG = "PagShelfPlayer";
    private boolean mIsPlaying = false;
    private long mDuration = 0;
    private final int FRAME_GAP_TIME = 40;
    private double mFrameProgressGap = 0.0d;
    private boolean isStoped = true;
    private boolean mIsAudioPlaying = false;
    private long mTime = 0;
    private int mFrameCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class PagPlayTimerTask extends TimerTask {
        boolean mIsLooping;
        double mProgress;
        int mReaptCount;
        boolean mTaskPause;

        PagPlayTimerTask() {
            this.mProgress = 0.0d;
            this.mReaptCount = 1;
            this.mIsLooping = false;
            this.mTaskPause = false;
        }

        public void allEnd() {
            if (this.mTaskPause) {
                return;
            }
            TTPTLogger.i("PagShelfPlayer", "onAnimationEnd.");
            PagShelfPlayer.this.mIsPlaying = false;
            if (PagShelfPlayer.this.mVideoShelfListener != null) {
                PagShelfPlayer.this.mVideoShelfListener.onCompletion();
            }
            if (PagShelfPlayer.this.mAudioPlayer != null) {
                try {
                    PagShelfPlayer.this.mAudioPlayer.stop();
                    PagShelfPlayer.this.isStoped = true;
                } catch (IllegalStateException e16) {
                    TTPTLogger.e("PagShelfPlayer", "onAnimationEnd|audioplayer stop has IllegalStateException:" + e16.getMessage());
                }
            }
            this.mTaskPause = true;
        }

        public boolean isLooping() {
            return this.mIsLooping;
        }

        public void pause() {
            this.mTaskPause = true;
        }

        public void reset() {
            this.mProgress = 0.0d;
        }

        public void resume() {
            this.mTaskPause = false;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.mTaskPause) {
                return;
            }
            PagShelfPlayer.this.mPagRender.setProgress(this.mProgress);
            PagShelfPlayer.this.mHandler.removeCallbacks(PagShelfPlayer.this.mRenderRunable);
            PagShelfPlayer.this.mHandler.post(PagShelfPlayer.this.mRenderRunable);
            double d16 = this.mProgress + PagShelfPlayer.this.mFrameProgressGap;
            this.mProgress = d16;
            if (d16 > 1.0d) {
                int i3 = this.mReaptCount - 1;
                this.mReaptCount = i3;
                if (!this.mIsLooping && i3 <= 0) {
                    PagShelfPlayer.this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer.PagPlayTimerTask.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PagPlayTimerTask.this.allEnd();
                        }
                    });
                }
                this.mProgress = 0.0d;
                if (PagShelfPlayer.this.mIsAudioPlaying && PagShelfPlayer.this.mAudioPlayer != null && !PagShelfPlayer.this.isStoped) {
                    PagShelfPlayer.this.mAudioPlayer.seekTo(0);
                }
            }
        }

        public void setProgress(float f16) {
            this.mProgress = f16;
        }

        public void setReaptTime(int i3) {
            boolean z16;
            this.mReaptCount = i3;
            if (i3 < 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsLooping = z16;
        }
    }

    /* loaded from: classes27.dex */
    private class RenderRunable implements Runnable {
        RenderRunable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PagShelfPlayer.this.setTimeCount();
            PagShelfPlayer.this.mPagRender.flush();
            Log.i("PagShelfPlayer", "progress:" + PagShelfPlayer.this.mPagRender.getProgress());
        }
    }

    public PagShelfPlayer() throws PagNotSupportSystemException {
        if (PagUtil.isSupportPagForVideo()) {
            this.mPagRender = new PAGRenderer();
            if (AEOfflineConfig.isNeedSoftDecode()) {
                PagUtil.useSoftDecode();
            }
            this.mPlayTask = new PagPlayTimerTask();
            this.mHandler = new Handler();
            this.mRenderRunable = new RenderRunable();
            return;
        }
        Log.i("PagShelfPlayer", "\u5f53\u524d\u7cfb\u7edf\u4e0d\u652f\u6301PAG\u3002");
        TTPTLogger.e("PagShelfPlayer", "\u5f53\u524d\u7cfb\u7edf\u4e0d\u652f\u6301PAG\u3002");
        throw new PagNotSupportSystemException("PagShelfPlayer");
    }

    private void setPagfile(PAGFile pAGFile) {
        if (pAGFile == null) {
            TTPTLogger.e("PagShelfPlayer", "pagfile is null.");
            IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mVideoShelfListener;
            if (iVideoShelfPlayerListener != null) {
                iVideoShelfPlayerListener.onError(-1, "pagfile is null", null);
                return;
            }
            return;
        }
        if (pAGFile.tagLevel() > PAGFile.MaxSupportedTagLevel()) {
            IVideoShelfPlayerListener iVideoShelfPlayerListener2 = this.mVideoShelfListener;
            if (iVideoShelfPlayerListener2 != null) {
                iVideoShelfPlayerListener2.onError(-3, "pagsdk version is low", null);
                return;
            }
            return;
        }
        this.mPagFile = pAGFile;
        IVideoShelfPlayerListener iVideoShelfPlayerListener3 = this.mVideoShelfListener;
        if (iVideoShelfPlayerListener3 != null) {
            iVideoShelfPlayerListener3.onChangVideoSize(pAGFile.width(), this.mPagFile.height());
        }
        long duration = pAGFile.duration();
        this.mDuration = duration;
        this.mFrameProgressGap = 40000.0d / duration;
        PagPlayTimerTask pagPlayTimerTask = this.mPlayTask;
        if (pagPlayTimerTask != null) {
            pagPlayTimerTask.reset();
        }
        this.mPagRender.setFile(pAGFile);
        if (AEOfflineConfig.isNeedScale()) {
            Log.i("PagShelfPlayer", "\u4f7f\u7528\u4f4e\u5c3a\u5ea6\u7684PAG\u6587\u4ef6\u8fdb\u884c\u9884\u89c8\u3002");
            TTPTLogger.i("PagShelfPlayer", "\u4f7f\u7528\u4f4e\u5c3a\u5ea6\u7684PAG\u6587\u4ef6\u8fdb\u884c\u9884\u89c8\u3002");
            this.mPagRender.setMaxFrameRate(-1.0f);
            this.mPagRender.setCacheScale(AEOfflineConfig.getPagPlayScale());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeCount() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mTime > 1000) {
            IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mVideoShelfListener;
            if (iVideoShelfPlayerListener != null) {
                iVideoShelfPlayerListener.onUpdateRate(this.mFrameCount);
            }
            this.mTime = currentTimeMillis;
            this.mFrameCount = 0;
        }
        this.mFrameCount++;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void flush() {
        Log.i("VideoShelfPlayView", "PagShelfPlayer-flush");
        this.mPagRender.flush(true);
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public int getCurrentPosition() {
        return (int) ((this.mPagRender.getProgress() * this.mDuration) / 1000.0d);
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public long getDuration() {
        return this.mDuration / 1000;
    }

    public Object getPagRender() {
        return this.mPagRender;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public int getVideoHeight() {
        PAGFile pAGFile = this.mPagFile;
        if (pAGFile != null) {
            return pAGFile.height();
        }
        return 0;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public int getVideoWidth() {
        PAGFile pAGFile = this.mPagFile;
        if (pAGFile != null) {
            return pAGFile.width();
        }
        return 0;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public boolean isPlaying() {
        return this.mIsPlaying;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void pause() {
        TTPTLogger.i("PagShelfPlayer", "pause");
        this.mIsPlaying = false;
        PagPlayTimerTask pagPlayTimerTask = this.mPlayTask;
        if (pagPlayTimerTask != null) {
            pagPlayTimerTask.pause();
        }
        MediaPlayer mediaPlayer = this.mAudioPlayer;
        if (mediaPlayer != null && !this.isStoped) {
            try {
                mediaPlayer.pause();
            } catch (IllegalStateException e16) {
                Log.e("PagShelfPlayer", "audioplayer pause has IllegalStateException:" + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void prepare() {
        MediaPlayer mediaPlayer = this.mAudioPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.prepare();
                this.isStoped = false;
            } catch (IOException | IllegalStateException e16) {
                TTPTLogger.e("PagShelfPlayer", "audioplayer prepare has IOException|IllegalStateException:" + e16.getMessage());
            }
        }
        IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mVideoShelfListener;
        if (iVideoShelfPlayerListener != null) {
            iVideoShelfPlayerListener.onPrepared(this);
        }
        TTPTLogger.i("PagShelfPlayer", "prepare.");
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void reset() {
        TTPTLogger.i("PagShelfPlayer", "reset");
        PagPlayTimerTask pagPlayTimerTask = this.mPlayTask;
        if (pagPlayTimerTask != null) {
            pagPlayTimerTask.reset();
        }
        this.mPagRender.setProgress(0.0d);
        this.mIsPlaying = false;
        PAGSurface pAGSurface = this.mPagSurface;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
        MediaPlayer mediaPlayer = this.mAudioPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void seekTo(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("seekto:");
        double d16 = i3 * 1000.0d;
        sb5.append(d16 / this.mDuration);
        TTPTLogger.i("PagShelfPlayer", sb5.toString());
        this.mPagRender.setProgress(d16 / this.mDuration);
        this.mPagRender.flush();
        MediaPlayer mediaPlayer = this.mAudioPlayer;
        if (mediaPlayer != null) {
            try {
                if (this.isStoped) {
                    mediaPlayer.prepare();
                    this.isStoped = false;
                }
                this.mAudioPlayer.seekTo(i3);
            } catch (IOException | IllegalStateException e16) {
                TTPTLogger.e("PagShelfPlayer", "audioplayer seekto has IllegalStateException:" + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setDataSource(String str) {
        if (str == null) {
            return;
        }
        TTPTLogger.i("PagShelfPlayer", "pag path:" + str);
        setPagfile(PagViewMonitor.Load(str));
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        PAGSurface FromSurface;
        if (surfaceHolder == null) {
            FromSurface = null;
        } else {
            FromSurface = PAGSurface.FromSurface(surfaceHolder.getSurface());
        }
        this.mPagSurface = FromSurface;
        this.mPagRender.setSurface(FromSurface);
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setLooping(boolean z16) {
        int i3;
        PagPlayTimerTask pagPlayTimerTask = this.mPlayTask;
        if (z16) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        pagPlayTimerTask.setReaptTime(i3);
        MediaPlayer mediaPlayer = this.mAudioPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z16);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setParam(String str, Object... objArr) {
        boolean z16;
        HashMap hashMap;
        str.hashCode();
        int i3 = 0;
        switch (str.hashCode()) {
            case -1145231791:
                if (str.equals(PAG_TEXT)) {
                    z16 = false;
                    break;
                }
                z16 = -1;
                break;
            case -716976004:
                if (str.equals(IMG_GROUP)) {
                    z16 = true;
                    break;
                }
                z16 = -1;
                break;
            case 1707690663:
                if (str.equals(PAG_IMG)) {
                    z16 = 2;
                    break;
                }
                z16 = -1;
                break;
            case 1991330946:
                if (str.equals(AUDIO_PATH)) {
                    z16 = 3;
                    break;
                }
                z16 = -1;
                break;
            default:
                z16 = -1;
                break;
        }
        Bitmap bitmap = null;
        switch (z16) {
            case false:
                if (objArr != null && objArr.length >= 2) {
                    Object obj = objArr[0];
                    if (obj instanceof Integer[]) {
                        Object obj2 = objArr[1];
                        if (obj2 instanceof Bitmap) {
                            setParam(PAG_IMG, objArr);
                            return;
                        }
                        if ((obj2 instanceof String) && this.mPagFile != null && this.mPagRender != null) {
                            Integer[] numArr = (Integer[]) obj;
                            int length = numArr.length;
                            while (i3 < length) {
                                int intValue = numArr[i3].intValue();
                                if (intValue >= this.mPagFile.numTexts()) {
                                    return;
                                }
                                PAGText textData = this.mPagFile.getTextData(intValue);
                                if (textData == null) {
                                    TTPTLogger.e("PagShelfPlayer", "\u6587\u5b57\u6837\u5f0f\u5728PAG\u6587\u4ef6\u4e2d\u672a\u627e\u5230\uff0c\u65e0\u6cd5\u8fdb\u884c\u8bbe\u7f6e\u6587\u5b57");
                                    return;
                                } else {
                                    textData.text = (String) objArr[1];
                                    this.mPagRender.setTextData(intValue, textData);
                                    i3++;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                TTPTLogger.e("PagShelfPlayer", "\u4f20\u5165PAG\u7684\u66ff\u6362\u6587\u672c\u53c2\u6570\u6709\u8bef");
                return;
            case true:
                if (objArr != null && objArr.length != 0) {
                    Object obj3 = objArr[0];
                    if ((obj3 instanceof HashMap) && (hashMap = (HashMap) obj3) != null) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            setParam(PAG_IMG, entry.getValue(), entry.getKey());
                        }
                        return;
                    }
                    return;
                }
                return;
            case true:
                if (objArr != null && objArr.length >= 2) {
                    Object obj4 = objArr[0];
                    if (obj4 instanceof int[]) {
                        Object obj5 = objArr[1];
                        if (obj5 instanceof Bitmap) {
                            bitmap = (Bitmap) obj5;
                        } else if (obj5 instanceof String) {
                            bitmap = BitmapUtils.decodeSampledBitmapFromFile((String) obj5, 1080, 1080);
                        }
                        if (bitmap == null) {
                            TTPTLogger.e("PagShelfPlayer", "\u4f20\u5165PAG\u7684\u66ff\u6362\u56fe\u50cf\u4e3a\u7a7a\u3002");
                            return;
                        }
                        PAGImage FromBitmap = PAGImage.FromBitmap(bitmap);
                        FromBitmap.setScaleMode(3);
                        int[] iArr = (int[]) obj4;
                        int length2 = iArr.length;
                        while (i3 < length2) {
                            this.mPagRender.replaceImage(iArr[i3], FromBitmap);
                            i3++;
                        }
                        return;
                    }
                    return;
                }
                TTPTLogger.e("PagShelfPlayer", "\u4f20\u5165PAG\u7684\u66ff\u6362\u56fe\u50cf\u53c2\u6570\u6709\u8bef");
                return;
            case true:
                Object obj6 = objArr[0];
                if (obj6 instanceof Boolean) {
                    try {
                        if (((Boolean) obj6).booleanValue()) {
                            Object obj7 = objArr[1];
                            Object obj8 = objArr[2];
                            if ((obj7 instanceof AssetManager) && (obj8 instanceof String)) {
                                AssetFileDescriptor openFd = ((AssetManager) obj7).openFd((String) obj8);
                                ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
                                this.mAudioPlayer = reportMediaPlayer;
                                reportMediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                                TTPTLogger.i("PagShelfPlayer", "audio path(asset):" + ((String) obj8));
                            }
                        } else {
                            Object obj9 = objArr[1];
                            if (obj9 instanceof String) {
                                ReportMediaPlayer reportMediaPlayer2 = new ReportMediaPlayer();
                                this.mAudioPlayer = reportMediaPlayer2;
                                reportMediaPlayer2.setDataSource((String) obj9);
                                TTPTLogger.i("PagShelfPlayer", "audio path:" + ((String) obj9));
                            }
                        }
                        MediaPlayer mediaPlayer = this.mAudioPlayer;
                        if (mediaPlayer != null) {
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer.1
                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public void onCompletion(MediaPlayer mediaPlayer2) {
                                    TTPTLogger.i("PagShelfPlayer", "\u97f3\u9891\u64ad\u653e\u5b8c\u6bd5");
                                    if (mediaPlayer2 != null) {
                                        mediaPlayer2.stop();
                                        PagShelfPlayer.this.isStoped = true;
                                    }
                                }
                            });
                            this.mAudioPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer.2
                                @Override // android.media.MediaPlayer.OnErrorListener
                                public boolean onError(MediaPlayer mediaPlayer2, int i16, int i17) {
                                    TTPTLogger.e("PagShelfPlayer", "\u97f3\u9891\u64ad\u653e\u51fa\u9519\uff0ccode:" + i16 + ",extrCode:" + i17);
                                    PagShelfPlayer.this.isStoped = true;
                                    if (mediaPlayer2 != null) {
                                        mediaPlayer2.reset();
                                        return false;
                                    }
                                    return false;
                                }
                            });
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mVideoShelfListener;
                        if (iVideoShelfPlayerListener != null) {
                            iVideoShelfPlayerListener.onError(-1, "audio file is null", null);
                        }
                        ReportUtil.report("[" + PagShelfPlayer.class.getSimpleName() + "] mVideoPlayer.setDataSource , error msg = " + e16.toString());
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setSurface(Surface surface) {
        PAGSurface FromSurface;
        TTPTLogger.i("PagShelfPlayer", "setsurface.");
        if (surface == null) {
            FromSurface = null;
        } else {
            FromSurface = PAGSurface.FromSurface(surface);
        }
        this.mPagSurface = FromSurface;
        this.mPagRender.setSurface(FromSurface);
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setVideoShelfPlayerListener(IVideoShelfPlayerListener iVideoShelfPlayerListener) {
        this.mVideoShelfListener = iVideoShelfPlayerListener;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void start() {
        double progress = this.mPagRender.getProgress();
        TTPTLogger.i("PagShelfPlayer", "start:" + progress);
        PagPlayTimerTask pagPlayTimerTask = this.mPlayTask;
        if (pagPlayTimerTask != null) {
            pagPlayTimerTask.resume();
        }
        if (this.mTimer == null) {
            BaseTimer baseTimer = new BaseTimer();
            this.mTimer = baseTimer;
            baseTimer.schedule(this.mPlayTask, 0L, 40L);
        }
        this.mIsPlaying = true;
        MediaPlayer mediaPlayer = this.mAudioPlayer;
        if (mediaPlayer != null) {
            try {
                if (this.isStoped) {
                    mediaPlayer.prepare();
                    this.isStoped = false;
                }
                if (this.mPlayTask.isLooping()) {
                    this.mAudioPlayer.setLooping(this.mPlayTask.isLooping());
                }
                this.mAudioPlayer.seekTo((int) ((this.mDuration * progress) / 1000.0d));
                TTPTLogger.i("PagShelfPlayer", "start:" + ((int) ((this.mDuration * progress) / 1000.0d)));
                this.mAudioPlayer.start();
                this.mIsAudioPlaying = true;
            } catch (IOException | IllegalStateException e16) {
                TTPTLogger.e("PagShelfPlayer", "audioplayer start has IllegalStateException:" + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void stop() {
        TTPTLogger.i("PagShelfPlayer", "stop");
        this.mIsPlaying = false;
        PAGSurface pAGSurface = this.mPagSurface;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
        this.mPagRender.setSurface((PAGSurface) null);
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        PagPlayTimerTask pagPlayTimerTask = this.mPlayTask;
        if (pagPlayTimerTask != null) {
            pagPlayTimerTask.pause();
            this.mPlayTask.cancel();
        }
        MediaPlayer mediaPlayer = this.mAudioPlayer;
        if (mediaPlayer != null) {
            try {
                this.mIsAudioPlaying = false;
                mediaPlayer.stop();
                this.isStoped = true;
                this.mAudioPlayer.release();
            } catch (IllegalStateException e16) {
                Log.e("PagShelfPlayer", "audioplayer stop has IllegalStateException:" + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void surfaceUpdateSize() {
        PAGSurface pAGSurface = this.mPagSurface;
        if (pAGSurface != null) {
            pAGSurface.updateSize();
            this.mPagRender.flush();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setDataSource(AssetManager assetManager, String str) {
        if (assetManager == null || str == null) {
            return;
        }
        setPagfile(PagViewMonitor.Load(assetManager, str));
    }
}
