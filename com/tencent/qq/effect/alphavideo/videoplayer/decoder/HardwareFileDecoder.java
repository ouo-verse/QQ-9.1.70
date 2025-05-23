package com.tencent.qq.effect.alphavideo.videoplayer.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.qq.effect.utils.LogUtil;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HardwareFileDecoder implements IVideoFileDecoder {
    static IPatchRedirector $redirector_;
    private String TAG;
    private IVideoFileDecodeListener mDecodeListener;
    private MediaExtractor mExtractor;
    private long mFirstFrameSysTime;
    private long mFirstFrameTimeUS;
    private MediaFormat mFormat;
    private ByteBuffer[] mInputBuffers;
    private boolean mLoop;
    private MediaCodec mMediaCodec;
    private String mMime;
    private ByteBuffer[] mOutputBuffers;
    private long mPresentationTimeUs;
    private long mSamplePresentationTimeUs;
    private boolean mStart;

    public HardwareFileDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mMediaCodec = null;
        this.mExtractor = null;
        this.mFormat = null;
        this.mMime = null;
        this.mSamplePresentationTimeUs = 0L;
        this.mPresentationTimeUs = 0L;
        this.mFirstFrameSysTime = 0L;
        this.mFirstFrameTimeUS = 0L;
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
        this.mStart = false;
        this.mLoop = false;
        this.TAG = "VideoPlayer|HardwareFileDecoder";
        this.mDecodeListener = null;
    }

    private void releaseCodec() {
        if (this.mMediaCodec != null) {
            try {
                LogUtil.i(this.TAG, "mMediaCodec stop + release begin!" + hashCode());
                this.mMediaCodec.stop();
                this.mMediaCodec.release();
            } catch (IllegalStateException unused) {
                LogUtil.e(this.TAG, "Failed to stop MediaCodec");
            }
            this.mMediaCodec = null;
        }
    }

    private void releaseExtractor() {
        MediaExtractor mediaExtractor = this.mExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mExtractor = null;
        }
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
    public int createDecoder(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, obj)).intValue();
        }
        int i3 = -1;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mExtractor = mediaExtractor;
            mediaExtractor.setDataSource(str);
            int i16 = 0;
            while (true) {
                try {
                    if (i16 >= this.mExtractor.getTrackCount()) {
                        break;
                    }
                    if (this.mExtractor.getTrackFormat(i16).getString("mime").startsWith("video/")) {
                        this.mExtractor.selectTrack(i16);
                        i3 = i16;
                        break;
                    }
                    i16++;
                } catch (Exception e16) {
                    LogUtil.e(this.TAG, "error read video file and info " + e16.getMessage());
                    IVideoFileDecodeListener iVideoFileDecodeListener = this.mDecodeListener;
                    if (iVideoFileDecodeListener != null) {
                        iVideoFileDecodeListener.onVideoDecodeError(-2);
                    }
                    releaseExtractor();
                    return -2;
                }
            }
            MediaFormat trackFormat = this.mExtractor.getTrackFormat(i3);
            this.mFormat = trackFormat;
            if (trackFormat != null) {
                this.mMime = trackFormat.getString("mime");
            }
            this.mExtractor.selectTrack(i3);
            if (this.mFormat != null && this.mMime.startsWith("video/")) {
                IVideoFileDecodeListener iVideoFileDecodeListener2 = this.mDecodeListener;
                if (iVideoFileDecodeListener2 != null) {
                    iVideoFileDecodeListener2.onVideoFormat(this.mFormat);
                }
                int integer = this.mFormat.getInteger("width");
                int integer2 = this.mFormat.getInteger("height");
                IVideoFileDecodeListener iVideoFileDecodeListener3 = this.mDecodeListener;
                if (iVideoFileDecodeListener3 != null) {
                    iVideoFileDecodeListener3.onVideoSize(integer, integer2);
                }
                try {
                    this.mMediaCodec = MediaCodec.createDecoderByType(this.mMime);
                    LogUtil.i(this.TAG, "mMediaCodec configure begin!" + hashCode());
                    this.mMediaCodec.configure(this.mFormat, (Surface) obj, (MediaCrypto) null, 0);
                    LogUtil.i(this.TAG, "mMediaCodec start begin!" + hashCode());
                    this.mMediaCodec.start();
                    this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                    LogUtil.i(this.TAG, "get mMediaCodec mInputBuffers & mOutputBuffers ");
                    IVideoFileDecodeListener iVideoFileDecodeListener4 = this.mDecodeListener;
                    if (iVideoFileDecodeListener4 != null) {
                        iVideoFileDecodeListener4.onVideoDecoderCreated(true);
                    }
                    return 1;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    IVideoFileDecodeListener iVideoFileDecodeListener5 = this.mDecodeListener;
                    if (iVideoFileDecodeListener5 != null) {
                        iVideoFileDecodeListener5.onVideoDecodeError(-5);
                    }
                    if (this.mMediaCodec != null) {
                        LogUtil.i(this.TAG, "mMediaCodec release begin!" + hashCode());
                        this.mMediaCodec.release();
                        this.mMediaCodec = null;
                    }
                    this.mInputBuffers = null;
                    this.mOutputBuffers = null;
                    releaseExtractor();
                    return -5;
                }
            }
            LogUtil.e(this.TAG, "error: not a video type file, end !");
            IVideoFileDecodeListener iVideoFileDecodeListener6 = this.mDecodeListener;
            if (iVideoFileDecodeListener6 != null) {
                iVideoFileDecodeListener6.onVideoDecodeError(-3);
            }
            releaseExtractor();
            return -3;
        } catch (Exception e18) {
            LogUtil.e(this.TAG, " error mExtractor.setDataSource file path " + e18.getMessage());
            IVideoFileDecodeListener iVideoFileDecodeListener7 = this.mDecodeListener;
            if (iVideoFileDecodeListener7 != null) {
                iVideoFileDecodeListener7.onVideoDecodeError(-1);
            }
            releaseExtractor();
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097 A[Catch: RuntimeException -> 0x0163, TryCatch #1 {RuntimeException -> 0x0163, blocks: (B:84:0x006e, B:88:0x007b, B:90:0x0082, B:24:0x008f, B:26:0x0097, B:28:0x009d, B:29:0x00c3, B:31:0x00d0, B:32:0x00d6, B:34:0x00dc, B:56:0x00a8, B:61:0x00ba, B:65:0x00c0, B:70:0x0107, B:73:0x011b, B:76:0x013c, B:77:0x0145, B:95:0x0066), top: B:87:0x007b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0104 A[SYNTHETIC] */
    @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode() {
        IVideoFileDecodeListener iVideoFileDecodeListener;
        boolean z16;
        int dequeueInputBuffer;
        int i3;
        int i16;
        IVideoFileDecodeListener iVideoFileDecodeListener2;
        int dequeueOutputBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        IVideoFileDecodeListener iVideoFileDecodeListener3 = this.mDecodeListener;
        if (iVideoFileDecodeListener3 != null) {
            iVideoFileDecodeListener3.onVideoDecodeStart();
        }
        long j3 = 0;
        this.mFirstFrameSysTime = 0L;
        this.mFirstFrameTimeUS = 0L;
        synchronized (this) {
            this.mStart = true;
        }
        int i17 = 0;
        boolean z17 = true;
        boolean z18 = false;
        boolean z19 = false;
        while (true) {
            if (z18) {
                break;
            }
            if (!this.mStart) {
                LogUtil.i(this.TAG, "decode stop!");
                break;
            }
            if (!z19) {
                try {
                    dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(1000L);
                } catch (RuntimeException e16) {
                    e = e16;
                    z16 = z18;
                    LogUtil.e(this.TAG, "decoding error:" + e.getMessage());
                    iVideoFileDecodeListener2 = this.mDecodeListener;
                    if (iVideoFileDecodeListener2 != null) {
                        iVideoFileDecodeListener2.onVideoDecodeError(-101);
                    }
                    this.mStart = false;
                    i17 = 0;
                    z17 = false;
                    z18 = z16;
                    j3 = 0;
                }
                if (dequeueInputBuffer >= 0) {
                    int readSampleData = this.mExtractor.readSampleData(this.mInputBuffers[dequeueInputBuffer], i17);
                    if (readSampleData < 0) {
                        LogUtil.d(this.TAG, "saw input EOS. Stopping playback");
                        z19 = true;
                        i3 = i17;
                        z16 = z18;
                    } else {
                        z16 = z18;
                        this.mSamplePresentationTimeUs = this.mExtractor.getSampleTime();
                        i3 = readSampleData;
                    }
                    MediaCodec mediaCodec = this.mMediaCodec;
                    long j16 = this.mSamplePresentationTimeUs;
                    if (z19) {
                        i16 = 4;
                    } else {
                        i16 = 0;
                    }
                    try {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i3, j16, i16);
                        if (!z19) {
                            this.mExtractor.advance();
                        }
                        dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 1000L);
                    } catch (RuntimeException e17) {
                        e = e17;
                        LogUtil.e(this.TAG, "decoding error:" + e.getMessage());
                        iVideoFileDecodeListener2 = this.mDecodeListener;
                        if (iVideoFileDecodeListener2 != null) {
                        }
                        this.mStart = false;
                        i17 = 0;
                        z17 = false;
                        z18 = z16;
                        j3 = 0;
                    }
                    if (dequeueOutputBuffer < 0) {
                        if (this.mFirstFrameSysTime == j3) {
                            this.mFirstFrameSysTime = System.currentTimeMillis();
                            this.mFirstFrameTimeUS = bufferInfo.presentationTimeUs;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis() - this.mFirstFrameSysTime;
                            long j17 = (bufferInfo.presentationTimeUs - this.mFirstFrameTimeUS) / 1000;
                            if (currentTimeMillis < j17) {
                                try {
                                    LockMethodProxy.sleep(j17 - currentTimeMillis);
                                } catch (InterruptedException e18) {
                                    e18.printStackTrace();
                                }
                            }
                        }
                        this.mPresentationTimeUs = bufferInfo.presentationTimeUs;
                        this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                        IVideoFileDecodeListener iVideoFileDecodeListener4 = this.mDecodeListener;
                        if (iVideoFileDecodeListener4 != null) {
                            iVideoFileDecodeListener4.onVideoDecodeFrame(this.mPresentationTimeUs, null);
                        }
                        if ((bufferInfo.flags & 4) != 0) {
                            LogUtil.d(this.TAG, "decode output EOS. End");
                            if (this.mLoop) {
                                try {
                                    this.mFirstFrameSysTime = 0L;
                                    this.mFirstFrameTimeUS = 0L;
                                    this.mPresentationTimeUs = 0L;
                                    this.mExtractor.seekTo(0L, 2);
                                    this.mMediaCodec.flush();
                                    z18 = z16;
                                    z19 = false;
                                } catch (RuntimeException e19) {
                                    e = e19;
                                    z19 = false;
                                    LogUtil.e(this.TAG, "decoding error:" + e.getMessage());
                                    iVideoFileDecodeListener2 = this.mDecodeListener;
                                    if (iVideoFileDecodeListener2 != null) {
                                    }
                                    this.mStart = false;
                                    i17 = 0;
                                    z17 = false;
                                    z18 = z16;
                                    j3 = 0;
                                }
                            } else {
                                z18 = true;
                            }
                            j3 = 0;
                            i17 = 0;
                        }
                    } else if (dequeueOutputBuffer == -3) {
                        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                        LogUtil.d(this.TAG, "output buffers have changed.");
                    } else if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
                        LogUtil.d(this.TAG, "output mFormat has changed to " + outputFormat);
                    } else if (dequeueOutputBuffer == -1) {
                        LogUtil.d(this.TAG, "dequeueOutputBuffer timed out! MediaCodec.INFO_TRY_AGAIN_LATER ");
                    } else {
                        LogUtil.d(this.TAG, " dequeueOutputBuffer returned " + dequeueOutputBuffer);
                    }
                    z18 = z16;
                    j3 = 0;
                    i17 = 0;
                }
            }
            z16 = z18;
            dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 1000L);
            if (dequeueOutputBuffer < 0) {
            }
            z18 = z16;
            j3 = 0;
            i17 = 0;
        }
        boolean z26 = i17;
        if (this.mStart) {
            this.mStart = z26;
        }
        releaseCodec();
        releaseExtractor();
        this.mMime = null;
        this.mFormat = null;
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
        this.mSamplePresentationTimeUs = 0L;
        this.mPresentationTimeUs = 0L;
        this.mFirstFrameTimeUS = 0L;
        this.mFirstFrameSysTime = 0L;
        if (z17 && (iVideoFileDecodeListener = this.mDecodeListener) != null) {
            iVideoFileDecodeListener.onVideoDecodeEnd();
        }
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
    public long getCurPresentationTimeUs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.mPresentationTimeUs;
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
    public IVideoFileDecodeListener getDecodeListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IVideoFileDecodeListener) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mDecodeListener;
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            releaseCodec();
            releaseExtractor();
        }
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
    public void setDecodeListener(IVideoFileDecodeListener iVideoFileDecodeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVideoFileDecodeListener);
        } else {
            this.mDecodeListener = iVideoFileDecodeListener;
        }
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
    public void setLoopState(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mLoop = z16;
        }
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            synchronized (this) {
                this.mStart = false;
            }
        }
    }

    public HardwareFileDecoder(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        this.mMediaCodec = null;
        this.mExtractor = null;
        this.mFormat = null;
        this.mMime = null;
        this.mSamplePresentationTimeUs = 0L;
        this.mPresentationTimeUs = 0L;
        this.mFirstFrameSysTime = 0L;
        this.mFirstFrameTimeUS = 0L;
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
        this.mStart = false;
        this.TAG = "VideoPlayer|HardwareFileDecoder";
        this.mDecodeListener = null;
        this.mLoop = z16;
    }
}
