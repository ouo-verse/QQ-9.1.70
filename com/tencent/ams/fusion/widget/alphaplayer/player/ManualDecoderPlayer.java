package com.tencent.ams.fusion.widget.alphaplayer.player;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;

@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public class ManualDecoderPlayer implements IPlayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CustomMediaPlayer";
    private static final long TIMEOUT_USEC = 10000;
    private int mCurrentPosition;
    private String mDataSource;
    private DecoderThread mDecoderThread;
    private int mDuration;
    private int mFrameRate;
    private volatile boolean mIsPlaying;
    private boolean mLooping;
    private MediaExtractor mMediaExtractor;
    private IPlayer.OnCompletionListener mOnCompletionListener;
    private IPlayer.OnErrorListener mOnErrorListener;
    private IPlayer.OnInfoListener mOnInfoListener;
    private IPlayer.OnPreparedListener mOnPreparedListener;
    private IPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class DecoderThread extends BaseThread {
        static IPatchRedirector $redirector_;

        DecoderThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ManualDecoderPlayer.this);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x019a A[EDGE_INSN: B:57:0x019a->B:49:0x019a BREAK  A[LOOP:0: B:26:0x0114->B:52:0x0114], SYNTHETIC] */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int trackIndex;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Process.setThreadPriority(-10);
            MediaCodec mediaCodec = null;
            boolean z16 = false;
            try {
                ManualDecoderPlayer.this.mMediaExtractor.setDataSource(ManualDecoderPlayer.this.mDataSource);
                trackIndex = ManualDecoderPlayer.this.getTrackIndex("video/");
            } catch (IOException unused) {
            }
            if (trackIndex < 0) {
                return;
            }
            ManualDecoderPlayer.this.mMediaExtractor.selectTrack(trackIndex);
            MediaFormat trackFormat = ManualDecoderPlayer.this.mMediaExtractor.getTrackFormat(trackIndex);
            ManualDecoderPlayer.this.mVideoWidth = trackFormat.getInteger("width");
            ManualDecoderPlayer.this.mVideoHeight = trackFormat.getInteger("height");
            if (trackFormat.containsKey("durationUs")) {
                ManualDecoderPlayer.this.mDuration = (int) (trackFormat.getLong("durationUs") / 1000);
            }
            if (trackFormat.containsKey("frame-rate")) {
                ManualDecoderPlayer.this.mFrameRate = trackFormat.getInteger("frame-rate");
            }
            Logger.v(ManualDecoderPlayer.TAG, "getTrackFormat videoWidth:" + ManualDecoderPlayer.this.mVideoWidth + ", videoHeight:" + ManualDecoderPlayer.this.mVideoHeight + ", mDuration: " + ManualDecoderPlayer.this.mDuration + ", mFrameRate: " + ManualDecoderPlayer.this.mFrameRate);
            trackFormat.setInteger("color-format", 2134292616);
            MediaCodec mediaCodec2 = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
            try {
                mediaCodec2.configure(trackFormat, ManualDecoderPlayer.this.mSurface, (MediaCrypto) null, 0);
            } catch (IOException unused2) {
                mediaCodec = mediaCodec2;
                Logger.w(ManualDecoderPlayer.TAG, "mediaCodec build failed");
                mediaCodec2 = mediaCodec;
                mediaCodec2.start();
                if (ManualDecoderPlayer.this.mOnPreparedListener != null) {
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int i3 = 0;
                long j3 = 0;
                while (true) {
                    if (Thread.interrupted()) {
                    }
                }
                mediaCodec2.stop();
                mediaCodec2.release();
                ManualDecoderPlayer.this.mMediaExtractor.release();
            }
            mediaCodec2.start();
            if (ManualDecoderPlayer.this.mOnPreparedListener != null) {
                ManualDecoderPlayer.this.mOnPreparedListener.onPrepared(ManualDecoderPlayer.this);
            }
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            int i36 = 0;
            long j36 = 0;
            while (true) {
                if (Thread.interrupted()) {
                    break;
                }
                if (ManualDecoderPlayer.this.mIsPlaying) {
                    if (!z16) {
                        ManualDecoderPlayer manualDecoderPlayer = ManualDecoderPlayer.this;
                        z16 = manualDecoderPlayer.putBufferToMediaCodec(manualDecoderPlayer.mMediaExtractor, mediaCodec2);
                    }
                    int dequeueOutputBuffer = mediaCodec2.dequeueOutputBuffer(bufferInfo2, 10000L);
                    if (dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer != -2) {
                            if (dequeueOutputBuffer != -1) {
                                if (j36 == 0) {
                                    j36 = System.currentTimeMillis();
                                }
                                ManualDecoderPlayer.this.sleepRender(bufferInfo2, j36);
                                mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer, true);
                                i36++;
                                Logger.v(ManualDecoderPlayer.TAG, "frameIndex: " + i36);
                            } else {
                                Logger.v(ManualDecoderPlayer.TAG, "info: try again later");
                            }
                        } else {
                            Logger.v(ManualDecoderPlayer.TAG, "info: output format changed");
                        }
                    } else {
                        Logger.v(ManualDecoderPlayer.TAG, "info: output buffers changed");
                    }
                    if ((bufferInfo2.flags & 4) != 0) {
                        Logger.v(ManualDecoderPlayer.TAG, "buffer stream end");
                        if (ManualDecoderPlayer.this.mOnCompletionListener != null) {
                            ManualDecoderPlayer.this.mOnCompletionListener.onCompletion(ManualDecoderPlayer.this);
                        }
                    }
                }
            }
            mediaCodec2.stop();
            mediaCodec2.release();
            ManualDecoderPlayer.this.mMediaExtractor.release();
        }

        /* synthetic */ DecoderThread(ManualDecoderPlayer manualDecoderPlayer, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) manualDecoderPlayer, (Object) anonymousClass1);
        }
    }

    public ManualDecoderPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMediaExtractor = new MediaExtractor();
            this.mIsPlaying = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTrackIndex(String str) {
        int trackCount = this.mMediaExtractor.getTrackCount();
        for (int i3 = 0; i3 < trackCount; i3++) {
            if (this.mMediaExtractor.getTrackFormat(i3).getString("mime").startsWith(str)) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean putBufferToMediaCodec(MediaExtractor mediaExtractor, MediaCodec mediaCodec) {
        int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            return false;
        }
        int readSampleData = mediaExtractor.readSampleData(mediaCodec.getInputBuffer(dequeueInputBuffer), 0);
        if (readSampleData < 0) {
            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            Logger.v(TAG, "media eos");
            return true;
        }
        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
        mediaExtractor.advance();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sleepRender(MediaCodec.BufferInfo bufferInfo, long j3) {
        this.mCurrentPosition = (int) (bufferInfo.presentationTimeUs / 1000);
        try {
            if (this.mFrameRate > 0) {
                LockMethodProxy.sleep(1000 / r5);
            } else {
                while (this.mCurrentPosition > System.currentTimeMillis() - j3) {
                    LockMethodProxy.sleep(10L);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.mCurrentPosition;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mDuration;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getVideoHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mVideoHeight;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getVideoWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mVideoWidth;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.mIsPlaying;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.mIsPlaying = false;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public synchronized void prepareAsync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Logger.i(TAG, "prepareAsync");
        DecoderThread decoderThread = new DecoderThread(this, null);
        this.mDecoderThread = decoderThread;
        decoderThread.start();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        stop();
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setDataSource(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.mDataSource = str;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setLooping(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        Logger.d(TAG, "setLooping:" + z16);
        this.mLooping = z16;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onCompletionListener);
        } else {
            this.mOnCompletionListener = onCompletionListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onErrorListener);
        } else {
            this.mOnErrorListener = onErrorListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onInfoListener);
        } else {
            this.mOnInfoListener = onInfoListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onPreparedListener);
        } else {
            this.mOnPreparedListener = onPreparedListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onSeekCompleteListener);
        } else {
            this.mOnSeekCompleteListener = onSeekCompleteListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setSurface(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) surface);
        } else {
            this.mSurface = surface;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setVolume(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public synchronized void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            Logger.i(TAG, "start");
            this.mIsPlaying = true;
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public synchronized void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.mIsPlaying = false;
        DecoderThread decoderThread = this.mDecoderThread;
        if (decoderThread != null) {
            decoderThread.interrupt();
            try {
                this.mDecoderThread.join();
            } catch (InterruptedException unused) {
            }
            this.mDecoderThread = null;
        }
    }
}
