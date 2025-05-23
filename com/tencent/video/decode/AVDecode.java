package com.tencent.video.decode;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AVDecode extends AbstractAVDecode {
    static IPatchRedirector $redirector_ = null;
    private static final int AUDIO_FRAME_INDEX = 6;
    private static final int CHANNELS = 5;
    private static final int CONST_SIZE = 15;
    private static final int DURATION = 2;
    private static final int ERRCODE = 0;
    private static final int FRAME_COUNT = 6;
    private static final int FRAME_INDEX = 5;
    private static final int FRAME_RATE_DEN = 8;
    private static final int FRAME_RATE_NUM = 7;
    private static final int FRAME_ROTATION = 9;
    private static final int HEIGHT = 4;
    private static final int SAMPLE_NUM = 4;
    private static final int SAMPLE_RATE = 3;
    private static final int STREAM_KIND = 1;
    private static final int WIDTH = 3;
    private static volatile boolean sInitedDecodeEnv;
    private static Object sLock;
    private int audioFormat;
    private final int[] mAudioMetaData;
    private final int[] mVideoMetaData;
    private long nativeptr;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            sInitedDecodeEnv = false;
            sLock = new Object();
        }
    }

    AVDecode(AVDecodeOption aVDecodeOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVDecodeOption);
            return;
        }
        this.nativeptr = 0L;
        int[] iArr = new int[15];
        this.mVideoMetaData = iArr;
        int[] iArr2 = new int[15];
        this.mAudioMetaData = iArr2;
        this.audioFormat = AVDecodeOption.ENCODING_PCM_16BIT;
        long nativeOpenFile = nativeOpenFile(aVDecodeOption.filename, aVDecodeOption.cycle, aVDecodeOption.ignore_audio, aVDecodeOption.only_keyframe, aVDecodeOption.audioFormat, iArr, iArr2);
        this.nativeptr = nativeOpenFile;
        if (nativeOpenFile != 0) {
            this.audioFormat = aVDecodeOption.audioFormat;
            convertToAVParam(AbstractAVDecode.STREAM_VIDEO);
            convertToAVParam(AbstractAVDecode.STREAM_AUDIO);
            return;
        }
        AVDecodeError.throwException(iArr[0]);
    }

    private static native void InitDecodeEnv();

    private void convertToAVParam(int i3) {
        if (i3 == 1447642447) {
            AVVideoParam aVVideoParam = this.videoParam;
            int[] iArr = this.mVideoMetaData;
            aVVideoParam.errcode = iArr[0];
            aVVideoParam.stream_kind = iArr[1];
            aVVideoParam.duration = iArr[2];
            aVVideoParam.width = iArr[3];
            aVVideoParam.height = iArr[4];
            aVVideoParam.frame_index = iArr[5];
            aVVideoParam.frame_count = iArr[6];
            aVVideoParam.fps_num = iArr[7];
            aVVideoParam.fps_den = iArr[8];
            aVVideoParam.rotation = iArr[9];
            return;
        }
        if (i3 == 1096108367) {
            AVAudioParam aVAudioParam = this.audioParam;
            int[] iArr2 = this.mAudioMetaData;
            aVAudioParam.errcode = iArr2[0];
            aVAudioParam.stream_kind = iArr2[1];
            aVAudioParam.duration = iArr2[2];
            aVAudioParam.sample_rate = iArr2[3];
            aVAudioParam.numsample = iArr2[4];
            aVAudioParam.channels = iArr2[5];
            aVAudioParam.frameIndex = iArr2[6];
        }
    }

    private static void initDecodeGlobalEnv() {
        if (!sInitedDecodeEnv) {
            synchronized (sLock) {
                if (!sInitedDecodeEnv) {
                    InitDecodeEnv();
                    sInitedDecodeEnv = true;
                }
            }
        }
    }

    private native void nativeFreeFile(long j3);

    private native long nativeOpenFile(String str, boolean z16, boolean z17, boolean z18, int i3, int[] iArr, int[] iArr2);

    private native void nativeResetState(long j3, boolean z16, boolean z17);

    private native Object nativeSeekToNextAudioFrame(long j3, int[] iArr);

    private native int nativeSeekToNextFrame(long j3, Bitmap bitmap, int[] iArr);

    private native void nativeSetWantedFps(long j3, int i3, boolean z16);

    public static AVDecode newInstance(AVDecodeOption aVDecodeOption) {
        AVDecode aVDecode = null;
        try {
            AbstractAVDecode.checkSoLoaded();
            initDecodeGlobalEnv();
            aVDecode = new AVDecode(aVDecodeOption);
        } catch (AVideoException e16) {
            e16.printStackTrace();
        } catch (UnsatisfiedLinkError unused) {
        }
        if (aVDecode != null) {
            aVDecode.setWantedFps((int) aVDecodeOption.wantedFps, aVDecodeOption.fixDuration);
        }
        return aVDecode;
    }

    public static AVDecode newInstanceUncatched(AVDecodeOption aVDecodeOption) {
        AVDecode aVDecode;
        try {
            AbstractAVDecode.checkSoLoaded();
            initDecodeGlobalEnv();
            aVDecode = new AVDecode(aVDecodeOption);
        } catch (UnsatisfiedLinkError unused) {
            AVDecodeError.throwException(-200);
            aVDecode = null;
        }
        if (aVDecode != null) {
            aVDecode.setWantedFps((int) aVDecodeOption.wantedFps, aVDecodeOption.fixDuration);
        }
        return aVDecode;
    }

    private Object seekToNextAudioFrame() throws AVideoException {
        int i3;
        AbstractAVDecode.checkSoLoaded();
        Object obj = null;
        try {
            obj = nativeSeekToNextAudioFrame(this.nativeptr, this.mAudioMetaData);
            i3 = this.mAudioMetaData[0];
        } catch (UnsatisfiedLinkError unused) {
            i3 = -200;
        }
        if (i3 != 0) {
            AVDecodeError.throwException(i3);
        } else {
            convertToAVParam(AbstractAVDecode.STREAM_AUDIO);
        }
        return obj;
    }

    private void setWantedFps(int i3, boolean z16) {
        try {
            long j3 = this.nativeptr;
            if (j3 != 0) {
                nativeSetWantedFps(j3, i3, z16);
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            long j3 = this.nativeptr;
            if (j3 != 0) {
                nativeFreeFile(j3);
                this.nativeptr = 0L;
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public void resetVideoPlayer(AVDecodeOption aVDecodeOption) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVDecodeOption);
            return;
        }
        try {
            nativeResetState(this.nativeptr, aVDecodeOption.cycle, aVDecodeOption.ignore_audio);
            i3 = 0;
        } catch (UnsatisfiedLinkError unused) {
            i3 = -200;
        }
        if (i3 != 0) {
            AVDecodeError.throwException(i3);
        }
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public byte[] seekToNextAudioByteFrame() throws AVideoException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.audioFormat != 65280) {
            AVDecodeError.throwException(-201);
        }
        return (byte[]) seekToNextAudioFrame();
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public float[] seekToNextAudioFloatFrame() throws AVideoException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (float[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.audioFormat != 65282) {
            AVDecodeError.throwException(-201);
        }
        return (float[]) seekToNextAudioFrame();
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public short[] seekToNextAudioShortFrame() throws AVideoException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (short[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.audioFormat != 65281) {
            AVDecodeError.throwException(-201);
        }
        return (short[]) seekToNextAudioFrame();
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public void seekToNextFrame(Bitmap bitmap) throws AVideoException {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
            return;
        }
        AbstractAVDecode.checkSoLoaded();
        try {
            i3 = nativeSeekToNextFrame(this.nativeptr, bitmap, this.mVideoMetaData);
        } catch (UnsatisfiedLinkError unused) {
            i3 = -200;
        }
        if (i3 != 0) {
            AVDecodeError.throwException(i3);
        } else {
            convertToAVParam(AbstractAVDecode.STREAM_VIDEO);
        }
    }
}
