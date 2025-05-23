package com.tencent.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.image.VideoDrawable;
import com.tencent.image.api.ILog;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.video.decode.AVDecodeFactory;
import com.tencent.video.decode.AVDecodeOption;
import com.tencent.video.decode.AVVideoParam;
import com.tencent.video.decode.AVideoException;
import com.tencent.video.decode.AbstractAVDecode;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NativeVideoImage extends AbstractVideoImage {
    static IPatchRedirector $redirector_ = null;
    static final int DEFAULT_AUDIO_FORMAT = 65281;
    public static final Bitmap.Config DEFAULT_CONFIG;
    public static String TAG;
    static final String TAG_AUDIO;
    private static int TIME_BASE;
    static Handler sDecodeHander;
    static HandlerThread sDecodeThread;
    static boolean sLibLoaded;
    static Handler sReleaseHandler;
    protected static Handler sUIHandler;
    static boolean sVideoEngineAvaliable;
    static HandlerThread sWorkThread;
    private int ID;
    public boolean debug;
    private long drawTime;
    protected volatile AbstractAVDecode mAVDecode;
    protected DoAccumulativeRunnable mAccumulativeRunnable;
    private int mAudioFrameDuration;
    private Object mAudioLock;
    private volatile boolean mAudioThreadFinish;
    AudioTrack mAudioTrack;
    private Bitmap mCompatibleBitmap;
    private AtomicInteger mCount;
    protected Bitmap mCurFrameBitmap;
    protected Bitmap mCurFrameBitmapBuffer;
    protected Bitmap.Config mCurrentConfig;
    private DataReport mDataReport;
    protected volatile boolean mDecodeNextFrameEnd;
    public float mDefaultRoundCorner;
    private boolean mEnableAntiAlias;
    private boolean mEnableFilter;
    protected Bitmap mFirstFrameBitmap;
    private Object mLock;
    AVDecodeOption mOption;
    volatile boolean mPlayAudioFrame;
    volatile boolean mPlayAudioOnceFinished;
    PlayAudioThread mPlayAudioThread;
    int mPlayRepeatCount;
    int mReqHeight;
    int mReqWidth;
    public boolean mRequireAudioFocus;
    boolean mResetFlag;
    private int mRotation;
    protected final String mSrcVideoFile;
    private float mTotalDeviation;
    private volatile boolean mVideoDecodeFinish;
    private int mVideoFrameDuration;
    VideoDrawable.VideoDrawableParams mVideoParams;
    int mlastVideoFrameIndex;
    private long refreshTime;
    int sImageIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class DecodeFrameJob implements Runnable {
        static IPatchRedirector $redirector_;
        final long mNextFrameTime;

        public DecodeFrameJob(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NativeVideoImage.this, Long.valueOf(j3));
            } else {
                this.mNextFrameTime = j3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (NativeVideoImage.this.getNextFrame()) {
                long uptimeMillis = SystemClock.uptimeMillis();
                NativeVideoImage nativeVideoImage = NativeVideoImage.this;
                RefreshJob refreshJob = new RefreshJob(nativeVideoImage.mCount.get());
                long j3 = this.mNextFrameTime;
                if (uptimeMillis < j3) {
                    NativeVideoImage.sUIHandler.postDelayed(refreshJob, j3 - uptimeMillis);
                    NativeVideoImage.this.mDataReport.onVideoFrameDroped(false, -1);
                    if (URLDrawable.depImp.mLog.isColorLevel() && NativeVideoImage.this.debug) {
                        URLDrawable.depImp.mLog.d(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "after getFrame, now < mNextFrameTime, delay:" + (this.mNextFrameTime - uptimeMillis) + "ms, index=" + NativeVideoImage.this.mCount.get());
                        return;
                    }
                    return;
                }
                NativeVideoImage.sUIHandler.post(refreshJob);
                NativeVideoImage.this.mDataReport.onVideoFrameDroped(true, (int) (uptimeMillis - this.mNextFrameTime));
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.w(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "after getFrame, now > mNextFrameTime, delayedTime=" + (uptimeMillis - this.mNextFrameTime) + "ms, index=" + NativeVideoImage.this.mCount.get());
                    return;
                }
                return;
            }
            NativeVideoImage.this.mDecodeNextFrameEnd = true;
            URLDrawable.depImp.mLog.e(NativeVideoImage.TAG + NativeVideoImage.this.ID, 1, "after getFrame, return false ");
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DoAccumulativeRunnable extends ArgumentsRunnable<WeakReference<WrappedRefreshImg>> {
        static IPatchRedirector $redirector_;
        public int delay;
        long lastRefreshTime;

        public DoAccumulativeRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.delay = 0;
                this.lastRefreshTime = 0L;
            }
        }

        @Override // com.tencent.image.ArgumentsRunnable
        protected void run(List<WeakReference<WrappedRefreshImg>> list) {
            WrappedRefreshImg wrappedRefreshImg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            for (WeakReference<WrappedRefreshImg> weakReference : list) {
                if (weakReference != null && (wrappedRefreshImg = weakReference.get()) != null) {
                    wrappedRefreshImg.img.doApplyNextFrame(wrappedRefreshImg.refeshId);
                }
            }
            this.lastRefreshTime = SystemClock.uptimeMillis();
        }

        @Override // com.tencent.image.ArgumentsRunnable
        protected void submit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.lastRefreshTime;
            if (j3 != 0) {
                long j16 = uptimeMillis - j3;
                int i3 = this.delay;
                if (j16 < i3) {
                    NativeVideoImage.sUIHandler.postDelayed(this, i3 - (uptimeMillis - j3));
                    return;
                }
            }
            run();
            this.lastRefreshTime = uptimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class PlayAudioThread extends BaseThread {
        static IPatchRedirector $redirector_ = null;
        static final int LIMIT_TIME_USED = 1;

        public PlayAudioThread(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NativeVideoImage.this, (Object) str);
                return;
            }
            setName(str + "-" + getId());
        }

        /* JADX WARN: Code restructure failed: missing block: B:130:0x040a, code lost:
        
            com.tencent.image.URLDrawable.depImp.mLog.d(com.tencent.image.NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x0416, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x0168, code lost:
        
            if (r3 != null) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x016a, code lost:
        
            r3.release();
            r15.this$0.mAudioTrack = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0183, code lost:
        
            if (r3 == null) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:211:0x030c, code lost:
        
            if (r3 != null) goto L149;
         */
        /* JADX WARN: Code restructure failed: missing block: B:212:0x030e, code lost:
        
            r3.release();
            r15.this$0.mAudioTrack = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:217:0x0327, code lost:
        
            if (r3 == null) goto L160;
         */
        /* JADX WARN: Code restructure failed: missing block: B:239:0x03c5, code lost:
        
            if (r3 != null) goto L191;
         */
        /* JADX WARN: Code restructure failed: missing block: B:240:0x03c7, code lost:
        
            r3.release();
            r15.this$0.mAudioTrack = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:245:0x03e0, code lost:
        
            if (r3 == null) goto L202;
         */
        /* JADX WARN: Code restructure failed: missing block: B:265:0x0424, code lost:
        
            if (r4 != null) goto L214;
         */
        /* JADX WARN: Code restructure failed: missing block: B:266:0x0426, code lost:
        
            r4.release();
            r15.this$0.mAudioTrack = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:271:0x043f, code lost:
        
            if (r4 == null) goto L225;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0081, code lost:
        
            if (r3 == null) goto L33;
         */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            AudioTrack audioTrack;
            AudioTrack audioTrack2;
            AudioTrack audioTrack3;
            AudioTrack audioTrack4;
            AbstractAVDecode abstractAVDecode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    NativeVideoImage.this.mAudioThreadFinish = false;
                    NativeVideoImage nativeVideoImage = NativeVideoImage.this;
                    if (nativeVideoImage.mAudioTrack == null) {
                        nativeVideoImage.initAudioTrack();
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    AudioTrack audioTrack5 = NativeVideoImage.this.mAudioTrack;
                    if (audioTrack5 == null) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "mAudioTrack == null, return.. ");
                        }
                        AudioTrack audioTrack6 = NativeVideoImage.this.mAudioTrack;
                        if (audioTrack6 != null) {
                            try {
                                try {
                                    audioTrack6.stop();
                                } finally {
                                    AudioTrack audioTrack7 = NativeVideoImage.this.mAudioTrack;
                                    if (audioTrack7 != null) {
                                        audioTrack7.release();
                                        NativeVideoImage.this.mAudioTrack = null;
                                    }
                                }
                            } catch (IllegalStateException e16) {
                                URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", e16);
                                AudioTrack audioTrack8 = NativeVideoImage.this.mAudioTrack;
                            }
                        }
                        if (NativeVideoImage.this.mRequireAudioFocus) {
                            AudioUtils.abandonAudioFoucus();
                        }
                        NativeVideoImage.this.mAudioThreadFinish = true;
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
                            return;
                        }
                        return;
                    }
                    audioTrack5.play();
                    while (true) {
                        try {
                            synchronized (AbstractVideoImage.sPauseLock) {
                                while (AbstractVideoImage.sPaused && NativeVideoImage.this.mSupportGlobalPause) {
                                    try {
                                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                                            URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "begin wait ===> ");
                                        }
                                        if (NativeVideoImage.this.mRequireAudioFocus) {
                                            AudioUtils.abandonAudioFoucus();
                                        }
                                        LockMethodProxy.wait(AbstractVideoImage.sPauseLock);
                                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                                            URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + " wait end <=== ");
                                        }
                                        if (NativeVideoImage.this.mRequireAudioFocus) {
                                            AudioUtils.requesetAudioFoucus();
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        } catch (AVideoException e17) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (currentTimeMillis - currentTimeMillis2 > MiniBoxNoticeInfo.MIN_5) {
                                if (URLDrawable.depImp.mLog.isColorLevel() && NativeVideoImage.this.debug) {
                                    URLDrawable.depImp.mLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame ", e17);
                                }
                                currentTimeMillis = currentTimeMillis2;
                            }
                            int i3 = e17.mErrCode;
                            if (i3 == -116 || i3 == -110) {
                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                    URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, AudioDecode end...");
                                }
                                if (NativeVideoImage.this.mPlayAudioOnceFinished) {
                                    synchronized (NativeVideoImage.this.mAudioLock) {
                                        while (!NativeVideoImage.this.mVideoDecodeFinish) {
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode begin to wait....");
                                            }
                                            LockMethodProxy.wait(NativeVideoImage.this.mAudioLock);
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode finish wait....");
                                            }
                                        }
                                    }
                                } else {
                                    NativeVideoImage.this.mPlayAudioOnceFinished = true;
                                    NativeVideoImage nativeVideoImage2 = NativeVideoImage.this;
                                    VideoDrawable.VideoDrawableParams videoDrawableParams = nativeVideoImage2.mVideoParams;
                                    nativeVideoImage2.mPlayAudioFrame = false;
                                    videoDrawableParams.mPlayAudioFrame = false;
                                    NativeVideoImage.this.mOption.ignore_audio = true;
                                    NativeVideoImage.sUIHandler.post(new Runnable() { // from class: com.tencent.image.NativeVideoImage.PlayAudioThread.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayAudioThread.this);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                                return;
                                            }
                                            VideoDrawable.OnAudioPlayOnceListener onAudioPlayOnceListener = NativeVideoImage.this.mPlayOnceListener;
                                            if (onAudioPlayOnceListener != null) {
                                                onAudioPlayOnceListener.onFinish();
                                                NativeVideoImage.this.mPlayOnceListener = null;
                                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                    URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, mPlayOnceListener.onFinish()");
                                                }
                                            }
                                        }
                                    });
                                    AudioTrack audioTrack9 = NativeVideoImage.this.mAudioTrack;
                                    if (audioTrack9 != null) {
                                        try {
                                            try {
                                                audioTrack9.stop();
                                                audioTrack3 = NativeVideoImage.this.mAudioTrack;
                                            } finally {
                                                AudioTrack audioTrack10 = NativeVideoImage.this.mAudioTrack;
                                                if (audioTrack10 != null) {
                                                    audioTrack10.release();
                                                    NativeVideoImage.this.mAudioTrack = null;
                                                }
                                            }
                                        } catch (IllegalStateException e18) {
                                            URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", e18);
                                            audioTrack3 = NativeVideoImage.this.mAudioTrack;
                                        }
                                    }
                                    if (NativeVideoImage.this.mRequireAudioFocus) {
                                        AudioUtils.abandonAudioFoucus();
                                    }
                                    NativeVideoImage.this.mAudioThreadFinish = true;
                                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                                        URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                continue;
                            }
                        }
                        if (!NativeVideoImage.this.mPlayAudioFrame) {
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.i(NativeVideoImage.TAG_AUDIO, 2, "mPlayAudioFrame is false, so quit audio decode... ");
                            }
                            AudioTrack audioTrack11 = NativeVideoImage.this.mAudioTrack;
                            if (audioTrack11 != null) {
                                try {
                                    try {
                                        audioTrack11.stop();
                                        audioTrack4 = NativeVideoImage.this.mAudioTrack;
                                    } finally {
                                        AudioTrack audioTrack12 = NativeVideoImage.this.mAudioTrack;
                                        if (audioTrack12 != null) {
                                            audioTrack12.release();
                                            NativeVideoImage.this.mAudioTrack = null;
                                        }
                                    }
                                } catch (IllegalStateException e19) {
                                    URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", e19);
                                    audioTrack4 = NativeVideoImage.this.mAudioTrack;
                                }
                            }
                            if (NativeVideoImage.this.mRequireAudioFocus) {
                                AudioUtils.abandonAudioFoucus();
                            }
                            NativeVideoImage.this.mAudioThreadFinish = true;
                            if (!URLDrawable.depImp.mLog.isColorLevel()) {
                                return;
                            }
                        } else {
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame: before <<<=== ");
                            }
                            long currentTimeMillis3 = System.currentTimeMillis();
                            synchronized (NativeVideoImage.this.mLock) {
                                abstractAVDecode = NativeVideoImage.this.mAVDecode;
                            }
                            short[] seekToNextAudioShortFrame = abstractAVDecode.seekToNextAudioShortFrame();
                            long currentTimeMillis4 = System.currentTimeMillis();
                            NativeVideoImage.this.mAudioTrack.write(seekToNextAudioShortFrame, 0, seekToNextAudioShortFrame.length);
                            long currentTimeMillis5 = System.currentTimeMillis();
                            int i16 = abstractAVDecode.audioParam.duration;
                            if (i16 <= 0) {
                                i16 = NativeVideoImage.this.mVideoFrameDuration > 0 ? NativeVideoImage.this.mAudioFrameDuration : 0;
                            } else {
                                NativeVideoImage.this.mAudioFrameDuration = i16;
                            }
                            long j3 = currentTimeMillis4 - currentTimeMillis3;
                            long j16 = currentTimeMillis5 - currentTimeMillis4;
                            if ((j3 >= 1 || j16 >= 1) && URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.i(NativeVideoImage.TAG_AUDIO, 2, "[seekToNextAudioFrame: " + j3 + ", audioTrackTime: " + j16 + ", duration: " + i16 + "]__[1]");
                            }
                            int i17 = (int) (i16 - j16);
                            if (i17 <= 0) {
                                URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "seekToNextAudioFrame duration =" + i17 + ", jump sleep.");
                            } else {
                                try {
                                    LockMethodProxy.sleep(i17);
                                } catch (InterruptedException e26) {
                                    e26.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (Exception e27) {
                    URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", e27);
                    AudioTrack audioTrack13 = NativeVideoImage.this.mAudioTrack;
                    if (audioTrack13 != null) {
                        try {
                            try {
                                audioTrack13.stop();
                                audioTrack2 = NativeVideoImage.this.mAudioTrack;
                            } finally {
                                AudioTrack audioTrack14 = NativeVideoImage.this.mAudioTrack;
                                if (audioTrack14 != null) {
                                    audioTrack14.release();
                                    NativeVideoImage.this.mAudioTrack = null;
                                }
                            }
                        } catch (IllegalStateException e28) {
                            URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", e28);
                            audioTrack2 = NativeVideoImage.this.mAudioTrack;
                        }
                    }
                    if (NativeVideoImage.this.mRequireAudioFocus) {
                        AudioUtils.abandonAudioFoucus();
                    }
                    NativeVideoImage.this.mAudioThreadFinish = true;
                    if (!URLDrawable.depImp.mLog.isColorLevel()) {
                    }
                }
            } catch (Throwable th5) {
                AudioTrack audioTrack15 = NativeVideoImage.this.mAudioTrack;
                if (audioTrack15 != null) {
                    try {
                        try {
                            audioTrack15.stop();
                            audioTrack = NativeVideoImage.this.mAudioTrack;
                        } finally {
                            AudioTrack audioTrack16 = NativeVideoImage.this.mAudioTrack;
                            if (audioTrack16 != null) {
                                audioTrack16.release();
                                NativeVideoImage.this.mAudioTrack = null;
                            }
                        }
                    } catch (IllegalStateException e29) {
                        URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", e29);
                        audioTrack = NativeVideoImage.this.mAudioTrack;
                    }
                }
                if (NativeVideoImage.this.mRequireAudioFocus) {
                    AudioUtils.abandonAudioFoucus();
                }
                NativeVideoImage.this.mAudioThreadFinish = true;
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
                }
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class RefreshJob implements Runnable {
        static IPatchRedirector $redirector_;
        int refreshId;

        public RefreshJob(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NativeVideoImage.this, i3);
            } else {
                this.refreshId = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (URLDrawable.depImp.mLog.isColorLevel() && NativeVideoImage.this.debug) {
                URLDrawable.depImp.mLog.d(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "RefreshJob.run(): refreshId:" + this.refreshId);
            }
            WrappedRefreshImg wrappedRefreshImg = new WrappedRefreshImg();
            NativeVideoImage nativeVideoImage = NativeVideoImage.this;
            wrappedRefreshImg.img = nativeVideoImage;
            wrappedRefreshImg.refeshId = this.refreshId;
            nativeVideoImage.mAccumulativeRunnable.add(new WeakReference(wrappedRefreshImg));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ReleaseTask implements Runnable {
        static IPatchRedirector $redirector_;
        AbstractAVDecode mDecoder;

        public ReleaseTask(AbstractAVDecode abstractAVDecode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAVDecode);
            } else {
                this.mDecoder = abstractAVDecode;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AbstractAVDecode abstractAVDecode = this.mDecoder;
            if (abstractAVDecode != null) {
                try {
                    abstractAVDecode.close();
                    this.mDecoder = null;
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d(NativeVideoImage.TAG, 2, "..ReleaseTask close AVDecode..");
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class WrappedRefreshImg {
        static IPatchRedirector $redirector_;
        public AbstractVideoImage img;
        public int refeshId;

        public WrappedRefreshImg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
        TAG = URLDrawable.TAG + NativeVideoImage.class.getSimpleName() + "_";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(TAG);
        sb5.append("_Audio");
        TAG_AUDIO = sb5.toString();
        sUIHandler = new Handler(Looper.getMainLooper());
        sLibLoaded = false;
        sVideoEngineAvaliable = true;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Video-Release-Task");
        sWorkThread = baseHandlerThread;
        baseHandlerThread.start();
        sReleaseHandler = new Handler(sWorkThread.getLooper());
        BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread("Video-Decode-Thread");
        sDecodeThread = baseHandlerThread2;
        baseHandlerThread2.start();
        sDecodeHander = new Handler(sDecodeThread.getLooper());
        TIME_BASE = 12;
    }

    public NativeVideoImage(File file, boolean z16) {
        this(file, z16, 0, 0, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, file, Boolean.valueOf(z16));
    }

    static void loadLibrary(Context context) {
        if (!sLibLoaded) {
            try {
                int LoadExtractedShortVideo = ShortVideoSoLoad.LoadExtractedShortVideo("AVCodec");
                if (LoadExtractedShortVideo == 0) {
                    sVideoEngineAvaliable = true;
                } else if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "loadLibrary() failure....");
                }
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(TAG, 2, "loadLibrary(): status=" + LoadExtractedShortVideo);
                }
            } catch (Throwable th5) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "System.loadLibrary(AVCodec) failed");
                }
                th5.printStackTrace();
            }
            sLibLoaded = true;
        }
    }

    @Override // com.tencent.image.AbstractVideoImage
    protected synchronized void applyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Canvas canvas = new Canvas(this.mCurFrameBitmap);
        this.mCurFrameBitmap.eraseColor(0);
        Paint paint = new Paint();
        if (this.mDefaultRoundCorner > 0.0f) {
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            RectF rectF = new RectF(0.0f, 0.0f, this.mCurFrameBitmap.getWidth(), this.mCurFrameBitmap.getHeight());
            float f16 = this.mDefaultRoundCorner;
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        if (this.mRotation != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(this.mRotation, this.mCurFrameBitmapBuffer.getWidth() / 2, this.mCurFrameBitmapBuffer.getHeight() / 2);
            matrix.postTranslate((this.mCurFrameBitmap.getWidth() - this.mCurFrameBitmapBuffer.getWidth()) / 2.0f, (this.mCurFrameBitmap.getHeight() - this.mCurFrameBitmapBuffer.getHeight()) / 2.0f);
            canvas.drawBitmap(this.mCurFrameBitmapBuffer, matrix, paint);
        } else {
            canvas.drawBitmap(this.mCurFrameBitmapBuffer, 0.0f, 0.0f, paint);
        }
        if (URLDrawable.depImp.mLog.isColorLevel() && this.debug) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "applyNextFrame, cost=" + currentTimeMillis2 + "ms");
        }
    }

    @Override // com.tencent.image.AbstractVideoImage
    public void disableGlobalPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        synchronized (AbstractVideoImage.sPauseLock) {
            this.mSupportGlobalPause = false;
            AbstractVideoImage.sPauseLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.AbstractVideoImage
    public void doApplyNextFrame(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.mDecodeNextFrameEnd = true;
        super.doApplyNextFrame(i3);
        if (URLDrawable.depImp.mLog.isColorLevel() && this.debug) {
            URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "doApplyNextFrame: invalidateSelf, index:" + i3);
        }
        this.refreshTime = SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.AbstractVideoImage
    public void draw(Canvas canvas, Rect rect, Paint paint, boolean z16) {
        AVDecodeOption aVDecodeOption;
        AVDecodeOption aVDecodeOption2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, canvas, rect, paint, Boolean.valueOf(z16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (sUIHandler == null) {
            sUIHandler = new Handler();
        }
        if (this.mAccumulativeRunnable == null) {
            this.mAccumulativeRunnable = new DoAccumulativeRunnable();
        }
        if (URLDrawable.depImp.mLog.isColorLevel() && this.debug) {
            URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "======>draw():start");
        }
        this.drawTime = SystemClock.uptimeMillis();
        if (paint != null) {
            paint.setAntiAlias(this.mEnableAntiAlias);
            paint.setFilterBitmap(this.mEnableFilter);
        }
        Bitmap bitmap = this.mCurFrameBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.drawTime;
        if (!z16) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "draw(): No animation");
                return;
            }
            return;
        }
        if (this.mSupportGlobalPause) {
            if (!AbstractVideoImage.sPaused) {
                executeNewTask(uptimeMillis);
                if (this.mPlayAudioFrame && (aVDecodeOption2 = this.mOption) != null && !aVDecodeOption2.ignore_audio) {
                    startPlayAudio();
                }
            } else if (!this.mIsInPendingAction) {
                AbstractVideoImage.sPendingActions.add(new WeakReference<>(this));
                this.mIsInPendingAction = true;
            }
        } else {
            executeNewTask(uptimeMillis);
            if (this.mPlayAudioFrame && (aVDecodeOption = this.mOption) != null && !aVDecodeOption.ignore_audio) {
                startPlayAudio();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            if (this.debug || currentTimeMillis2 > TIME_BASE) {
                URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "<======draw() end, cost: " + currentTimeMillis2 + " ms, drawCost:" + uptimeMillis);
            }
        }
    }

    protected void executeNewTask(long j3) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
            return;
        }
        if (this.mDecodeNextFrameEnd) {
            int i3 = 0;
            this.mDecodeNextFrameEnd = false;
            this.mVideoDecodeFinish = false;
            long j17 = this.drawTime;
            long j18 = this.refreshTime;
            if (j17 > j18 && j18 != -1) {
                j16 = j17 - j18;
            } else {
                j16 = 0;
            }
            if (this.mVideoFrameDuration < 0) {
                int i16 = this.mAVDecode.videoParam.fps_den;
                int i17 = this.mAVDecode.videoParam.fps_num;
                if (i17 > 0) {
                    float f16 = (i16 * 1000.0f) / i17;
                    int i18 = (int) f16;
                    this.mTotalDeviation = f16 - i18;
                    i3 = i18;
                } else if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(), error!!  mAVDecode.videoParam.fps_num = " + this.mAVDecode.videoParam.fps_num + ", srcFilePath = " + this.mSrcVideoFile);
                }
                float f17 = (i17 * 1.0f) / i16;
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(TAG + this.ID, 1, "executeNewTask(), fps_den = " + i16 + ",fps_num = " + i17 + ",fpsDuration = " + i3 + ",fps = " + f17 + " ,mTotalDeviation=" + this.mTotalDeviation + " ,totalFrame=" + this.mAVDecode.videoParam.frame_count);
                }
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(TAG + this.ID, 1, "executeNewTask()[], mOption.wantedFps = " + this.mOption.wantedFps + " fps=" + f17);
                }
                float f18 = this.mOption.wantedFps;
                if (f18 != 0.0f && f18 >= f17 / 2.0f && f18 <= f17) {
                    float f19 = 1000.0f / f18;
                    i3 = (int) f19;
                    this.mTotalDeviation = f19 - i3;
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d(TAG + this.ID, 1, "executeNewTask(), mOption.wantedFps = " + this.mOption.wantedFps + ",fpsDuration = " + i3 + ",fps = " + f17 + ",mVideoParams.mRequestedFPS = " + this.mVideoParams.mRequestedFPS + " ,mTotalDeviation=" + this.mTotalDeviation);
                    }
                }
                if (i3 > 0) {
                    this.mVideoFrameDuration = i3;
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(),1 mVideoFrameDuration = " + this.mVideoFrameDuration);
                    }
                } else if (this.mAVDecode.videoParam.duration > 0) {
                    this.mVideoFrameDuration = this.mAVDecode.videoParam.duration;
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(),2 mVideoFrameDuration = " + this.mVideoFrameDuration);
                    }
                } else {
                    this.mVideoFrameDuration = 50;
                    URLDrawable.depImp.mLog.e(TAG, 1, "executeNewTask(), error... mVideoFrameDuration: " + this.mVideoFrameDuration + ", mAVDecode.videoParam.duration " + this.mAVDecode.videoParam.duration + ", fpsDuration: " + i3);
                }
            } else if (this.mAVDecode != null && this.mAVDecode.videoParam != null && this.mAVDecode.videoParam.duration > 0) {
                int i19 = this.mAVDecode.videoParam.duration;
            }
            if (j16 > 100) {
                j16 = 100;
            }
            long j19 = j3 + j16;
            if (j19 >= this.mVideoFrameDuration) {
                if (URLDrawable.depImp.mLog.isColorLevel() && this.debug) {
                    URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(), overhead:" + j19 + ", >= frameDuration overhead=" + j19 + " mVideoFrameDuration=" + this.mVideoFrameDuration);
                }
                j19 = this.mVideoFrameDuration;
            }
            sDecodeHander.post(new DecodeFrameJob((SystemClock.uptimeMillis() + this.mVideoFrameDuration) - j19));
            if (URLDrawable.depImp.mLog.isColorLevel() && this.debug) {
                URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "executeNewTask(), duration: " + this.mVideoFrameDuration + ", drawCost: " + j3 + ",refreshCost:" + j16 + ",sync:true");
                return;
            }
            return;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(): mDecodeNextFrameEnd false");
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Handler handler = sReleaseHandler;
        if (handler != null) {
            handler.post(new ReleaseTask(this.mAVDecode));
        }
    }

    @Override // com.tencent.image.AbstractVideoImage
    @TargetApi(12)
    public int getByteSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        long bitmapSize = Utils.getBitmapSize(this.mCurFrameBitmap) + 0 + Utils.getBitmapSize(this.mCurFrameBitmapBuffer) + Utils.getBitmapSize(this.mFirstFrameBitmap);
        if (this.mCompatibleBitmap != null) {
            bitmapSize += Utils.getBitmapSize(r2);
        }
        return (int) bitmapSize;
    }

    Rect getFrameSize(File file) {
        Rect rect = new Rect();
        if (this.mAVDecode != null) {
            rect.set(0, 0, this.mAVDecode.videoParam.width, this.mAVDecode.videoParam.height);
        } else {
            rect.set(0, 0, 200, 200);
        }
        return rect;
    }

    @Override // com.tencent.image.AbstractVideoImage
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        Bitmap bitmap = this.mCurFrameBitmap;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return 0;
    }

    protected synchronized boolean getNextFrame() {
        AbstractAVDecode abstractAVDecode;
        int i3;
        int i16;
        long currentTimeMillis;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean z16 = false;
        try {
            abstractAVDecode = this.mAVDecode;
            AVVideoParam aVVideoParam = abstractAVDecode.videoParam;
            i3 = aVVideoParam.width;
            i16 = aVVideoParam.height;
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (AVideoException e16) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "seekToNextFrame, exception:" + e16);
                }
                if (e16.mErrCode == -110) {
                    this.mVideoDecodeFinish = true;
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "seekToNextFrame, VideoDecode End....");
                    }
                    if (!this.mPlayAudioOnceFinished) {
                        this.mPlayAudioOnceFinished = true;
                        VideoDrawable.VideoDrawableParams videoDrawableParams = this.mVideoParams;
                        this.mPlayAudioFrame = false;
                        videoDrawableParams.mPlayAudioFrame = false;
                        this.mOption.ignore_audio = true;
                        sUIHandler.post(new Runnable() { // from class: com.tencent.image.NativeVideoImage.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NativeVideoImage.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                VideoDrawable.OnAudioPlayOnceListener onAudioPlayOnceListener = NativeVideoImage.this.mPlayOnceListener;
                                if (onAudioPlayOnceListener != null) {
                                    onAudioPlayOnceListener.onFinish();
                                    NativeVideoImage.this.mPlayOnceListener = null;
                                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                                        URLDrawable.depImp.mLog.e(NativeVideoImage.TAG, 2, "getNextFrame(), mPlayOnceListener.onFinish()");
                                    }
                                }
                            }
                        });
                    }
                    if (this.mVideoParams.mPlayAudioFrame) {
                        synchronized (this.mLock) {
                            Handler handler = sReleaseHandler;
                            if (handler != null) {
                                handler.post(new ReleaseTask(this.mAVDecode));
                            }
                            this.mAVDecode = AVDecodeFactory.newDecode(this.mOption);
                            synchronized (this.mAudioLock) {
                                this.mVideoDecodeFinish = true;
                                this.mAudioLock.notifyAll();
                            }
                        }
                    } else {
                        Handler handler2 = sReleaseHandler;
                        if (handler2 != null) {
                            handler2.post(new ReleaseTask(this.mAVDecode));
                        }
                        AVDecodeOption aVDecodeOption = this.mOption;
                        aVDecodeOption.cycle = true;
                        this.mAVDecode = AVDecodeFactory.newDecode(aVDecodeOption);
                    }
                    this.sImageIndex++;
                }
            }
        } catch (OutOfMemoryError e17) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                showOOM("mFirstFrameBitmap");
            }
            URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "getNextFrame()", e17);
        }
        if (!this.mResetFlag) {
            if (i3 == this.mReqWidth && i16 == this.mReqHeight) {
                abstractAVDecode.seekToNextFrame(this.mCurFrameBitmapBuffer);
            } else {
                if (i16 != 0 && i3 != 0) {
                    if (this.mCompatibleBitmap == null) {
                        this.mCompatibleBitmap = Bitmap.createBitmap(i3, i16, this.mCurrentConfig);
                    }
                    abstractAVDecode.seekToNextFrame(this.mCompatibleBitmap);
                    try {
                        this.mCurFrameBitmapBuffer = Bitmap.createScaledBitmap(this.mCompatibleBitmap, this.mReqWidth, this.mReqHeight, true);
                    } catch (NullPointerException unused) {
                    }
                }
                URLDrawable.depImp.mLog.e(TAG, 2, "getNextFrame video width or height = 0,return false");
                return false;
            }
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            if (URLDrawable.depImp.mLog.isColorLevel() && (this.debug || currentTimeMillis3 > 9)) {
                URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "getNextFrame(): costCFunc=" + currentTimeMillis3 + "ms [>9]");
            }
            int i17 = abstractAVDecode.videoParam.frame_index;
            if (i17 == 1 && this.mlastVideoFrameIndex > i17) {
                this.mPlayRepeatCount++;
                synchronized (this.mListener) {
                    for (int size = this.mListener.size() - 1; size >= 0; size--) {
                        VideoDrawable.OnPlayRepeatListener onPlayRepeatListener = this.mListener.get(size).get();
                        if (onPlayRepeatListener != null) {
                            onPlayRepeatListener.onPlayRepeat(this.mPlayRepeatCount);
                        }
                    }
                }
            }
            this.mlastVideoFrameIndex = i17;
            this.sImageIndex++;
            z16 = true;
            this.mCount.addAndGet(1);
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
            if (URLDrawable.depImp.mLog.isColorLevel() && (this.debug || currentTimeMillis4 > TIME_BASE || !z16)) {
                URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "getNextFrame(): cost=" + currentTimeMillis4 + "ms, index=" + this.mCount.get() + ", ret=" + z16);
            }
            return z16;
        }
        this.mResetFlag = false;
        throw new AVideoException(-110, -1, " reset player error");
    }

    @Override // com.tencent.image.AbstractVideoImage
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        Bitmap bitmap = this.mCurFrameBitmap;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return 0;
    }

    void init(boolean z16) {
        boolean z17;
        if (sVideoEngineAvaliable) {
            try {
                this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
            } catch (OutOfMemoryError unused) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    showOOM("create mCurFrameBitmapBuffer");
                }
                if (this.mCurrentConfig == Bitmap.Config.ARGB_8888) {
                    try {
                        Bitmap.Config config = Bitmap.Config.RGB_565;
                        this.mCurrentConfig = config;
                        this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, config);
                    } catch (OutOfMemoryError unused2) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            showOOM("create mCurFrameBitmapBuffer");
                        }
                        URLDrawable.clearMemoryCache();
                        this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                    }
                } else {
                    URLDrawable.clearMemoryCache();
                    this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                }
            }
            try {
                int i3 = this.mRotation;
                if (i3 != 0 && i3 != 180) {
                    this.mCurFrameBitmap = Bitmap.createBitmap(this.mReqHeight, this.mReqWidth, this.mCurrentConfig);
                } else {
                    this.mCurFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                }
            } catch (OutOfMemoryError unused3) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    showOOM("create mCurFrameBitmap");
                }
            }
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                ILog iLog = URLDrawable.depImp.mLog;
                String str = TAG + this.ID;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("use mCurFrameBitmapBuffer: ");
                if (this.mCurFrameBitmapBuffer != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                iLog.d(str, 2, sb5.toString());
            }
        }
        getNextFrame();
        applyNextFrame();
        if (z16) {
            try {
                Bitmap bitmap = this.mCurFrameBitmap;
                this.mFirstFrameBitmap = bitmap.copy(bitmap.getConfig(), false);
            } catch (OutOfMemoryError unused4) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    showOOM("create mFirstFrameBitmap");
                }
            }
        }
    }

    void initAudioTrack() {
        int i3;
        if (this.mAVDecode.audioParam.channels <= 1) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        int i16 = this.mAVDecode.audioParam.sample_rate;
        if (i16 <= 0) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.e(TAG + this.ID, 2, "initAudioTrack(), sampleRateInHz=" + i16 + ", <= 0, return...");
                return;
            }
            return;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i16, i3, 2);
        if (minBufferSize < 1024) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "initAudioTrack(), minBufSize=" + minBufferSize + " < 1024, so mutiply 2");
            }
            minBufferSize *= 2;
            if (minBufferSize < 1024) {
                minBufferSize = 1024;
            }
        }
        int i17 = minBufferSize * 2;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "initAudioTrack(): cost=channelConfig: " + i3 + ", sampleRateInHz: " + i16 + ", minBufSize: " + minBufferSize + ", primePlaySize: " + i17);
        }
        this.mAudioTrack = new ReportAudioTrack(3, i16, i3, 2, i17, 1);
    }

    @Override // com.tencent.image.AbstractVideoImage
    public boolean isAudioPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.mPlayAudioFrame;
    }

    @Override // com.tencent.image.AbstractVideoImage
    public void resetAndPlayAudioCircle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
        }
        this.mPlayAudioOnceFinished = false;
        VideoDrawable.VideoDrawableParams videoDrawableParams = this.mVideoParams;
        this.mPlayAudioFrame = true;
        videoDrawableParams.mPlayAudioFrame = true;
        this.mOption.ignore_audio = !this.mPlayAudioFrame;
        this.mOption.cycle = true;
        try {
            this.mAVDecode.resetVideoPlayer(this.mOption);
        } catch (AVideoException e16) {
            URLDrawable.depImp.mLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", e16);
        }
        reDraw();
    }

    @Override // com.tencent.image.AbstractVideoImage
    public void resetAndPlayAudioOnce() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
        }
        this.mPlayAudioOnceFinished = false;
        VideoDrawable.VideoDrawableParams videoDrawableParams = this.mVideoParams;
        this.mPlayAudioFrame = true;
        videoDrawableParams.mPlayAudioFrame = true;
        this.mOption.ignore_audio = !this.mPlayAudioFrame;
        this.mOption.cycle = false;
        try {
            this.mAVDecode.resetVideoPlayer(this.mOption);
        } catch (AVideoException e16) {
            URLDrawable.depImp.mLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", e16);
        }
        reDraw();
    }

    public void showOOM(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            sUIHandler.post(new Runnable(str) { // from class: com.tencent.image.NativeVideoImage.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$tips;

                {
                    this.val$tips = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NativeVideoImage.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Toast.makeText(URLDrawable.depImp.mTool.getContext(), "[NativeVideoImage]OOM:" + this.val$tips, 0).show();
                }
            });
        }
    }

    void startPlayAudio() {
        if (this.mPlayAudioThread == null || this.mAudioThreadFinish) {
            PlayAudioThread playAudioThread = new PlayAudioThread("AudioPlayThread");
            this.mPlayAudioThread = playAudioThread;
            playAudioThread.start();
            if (this.mRequireAudioFocus) {
                AudioUtils.requesetAudioFoucus();
            }
        }
    }

    @Override // com.tencent.image.AbstractVideoImage
    public void stopPlayAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "stopPlayAudio()");
        }
        this.mPlayAudioFrame = false;
    }

    public NativeVideoImage(File file, boolean z16, int i3, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, file, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), obj);
            return;
        }
        this.debug = true;
        this.mDefaultRoundCorner = 0.0f;
        this.mRequireAudioFocus = true;
        this.mCurrentConfig = DEFAULT_CONFIG;
        this.mDecodeNextFrameEnd = true;
        this.mReqWidth = 0;
        this.mReqHeight = 0;
        this.sImageIndex = 0;
        this.mlastVideoFrameIndex = 0;
        this.mPlayRepeatCount = 0;
        this.mResetFlag = false;
        this.mPlayAudioFrame = false;
        this.mPlayAudioOnceFinished = true;
        this.mCompatibleBitmap = null;
        this.mEnableAntiAlias = false;
        this.mEnableFilter = false;
        this.mVideoDecodeFinish = false;
        this.mVideoFrameDuration = -1;
        this.mAudioFrameDuration = -1;
        this.mTotalDeviation = 0.0f;
        this.ID = -1;
        this.mLock = new Object();
        this.refreshTime = -1L;
        this.drawTime = -1L;
        this.mCount = new AtomicInteger(0);
        this.mAudioThreadFinish = true;
        this.mAudioLock = new Object();
        String absolutePath = file.getAbsolutePath();
        this.mSrcVideoFile = absolutePath;
        this.ID = absolutePath.hashCode();
        if (URLDrawable.depImp.mLog.isColorLevel() && obj != null) {
            URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "NativeVideoImage(): cacheFirstFrame=" + z16 + ", maxWidth= " + i3 + ", maxHeight= " + i16 + ", videoParams= " + obj.toString());
        }
        if (obj != null && VideoDrawable.VideoDrawableParams.class.isInstance(obj)) {
            this.mVideoParams = (VideoDrawable.VideoDrawableParams) obj;
        } else if (obj != null) {
            throw new RuntimeException(" NativeVideoImage(): videoParams is illegal, not VideoDrawableParams, " + obj.toString());
        }
        boolean z17 = this.mVideoParams.mPlayAudioFrame;
        this.mPlayAudioFrame = z17;
        this.debug = z17;
        VideoDrawable.VideoDrawableParams videoDrawableParams = this.mVideoParams;
        this.mDefaultRoundCorner = videoDrawableParams.mVideoRoundCorner;
        this.mEnableAntiAlias = videoDrawableParams.mEnableAntiAlias;
        this.mEnableFilter = videoDrawableParams.mEnableFilter;
        this.mOption = new AVDecodeOption();
        boolean z18 = this.mPlayAudioFrame ? false : AbstractVideoImage.loopEnable;
        AVDecodeOption aVDecodeOption = this.mOption;
        aVDecodeOption.cycle = z18;
        aVDecodeOption.ignore_audio = !this.mPlayAudioFrame;
        AVDecodeOption aVDecodeOption2 = this.mOption;
        aVDecodeOption2.only_keyframe = false;
        aVDecodeOption2.filename = absolutePath;
        aVDecodeOption2.audioFormat = 65281;
        VideoDrawable.VideoDrawableParams videoDrawableParams2 = this.mVideoParams;
        aVDecodeOption2.wantedFps = videoDrawableParams2.mRequestedFPS;
        aVDecodeOption2.mDecodeType = videoDrawableParams2.mDecodeType;
        aVDecodeOption2.mVfPath = videoDrawableParams2.mVfPath;
        aVDecodeOption2.mAfPath = videoDrawableParams2.mAfPath;
        aVDecodeOption2.mTotalTime = videoDrawableParams2.mTotalTime;
        aVDecodeOption2.mVideoFrames = videoDrawableParams2.mVideoFrames;
        try {
            this.mAVDecode = AVDecodeFactory.newDecodeUncatched(aVDecodeOption2);
        } catch (AVideoException e16) {
            e16.printStackTrace();
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.e(TAG + this.ID, 2, "NativeVideoImage()[newDecodeUncatched]", e16);
            }
        }
        if (this.mAVDecode == null && URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(TAG + this.ID, 2, "NativeVideoImage()[mAVDecode == null]....");
        }
        this.mRotation = this.mAVDecode.videoParam.rotation;
        int i17 = this.mAVDecode.videoParam.fps_den;
        int i18 = this.mAVDecode.videoParam.fps_num;
        float f16 = (i18 * 1.0f) / i17;
        if (this.mAVDecode.audioParam.errcode == -106) {
            this.mPlayAudioFrame = false;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.e(TAG + this.ID, 2, "NativeVideoImage() => VIDEO_NO_MEDIA_DATA_ERR, \u4e0d\u5b58\u5728\u97f3\u9891\u6570\u636e, mSrcVideoFile=" + this.mSrcVideoFile);
            }
        }
        Rect frameSize = getFrameSize(file);
        int width = frameSize.width();
        int height = frameSize.height();
        if (i3 > 0 && i16 > 0) {
            float f17 = width;
            float f18 = i3 / f17;
            float f19 = height;
            float f26 = i16 / f19;
            f18 = f18 >= f26 ? f26 : f18;
            if (f18 < 1.0f) {
                width = (int) (f17 * f18);
                height = (int) (f19 * f18);
            }
        }
        this.mReqWidth = width;
        this.mReqHeight = height;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            ILog iLog = URLDrawable.depImp.mLog;
            String str = TAG + this.ID;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" NativeVideoImage(): ");
            sb5.append("videoParams[ frame_count:" + this.mAVDecode.videoParam.frame_count + "\n mSrcVideoFile:" + this.mSrcVideoFile + "\n duration:" + this.mAVDecode.videoParam.duration + "\n fps_den:" + i17 + "\n fps_num:" + i18 + "\n fps:" + f16 + "\n mReqWidth:" + this.mReqWidth + "\n mReqHeight:" + this.mReqHeight + "\n mRotation:" + this.mRotation);
            iLog.d(str, 2, sb5.toString());
        }
        init(z16);
        this.mDataReport = new DataReport();
    }
}
