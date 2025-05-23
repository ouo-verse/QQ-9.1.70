package com.tencent.liteav.videobase.common;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.nio.ByteBuffer;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class EncodedVideoFrame {
    private static final String TAG = "EncodedVideoFrame";
    public ByteBuffer data;
    public long dts;
    public int height;
    public long pts;
    public int rotation;
    public MediaFormat videoFormat;
    public int width;
    public final ProducerChainTimestamp producerChainTimestamp = new ProducerChainTimestamp();
    public final ConsumerChainTimestamp consumerChainTimestamp = new ConsumerChainTimestamp();
    public long nativePtr = 0;
    public c nalType = c.UNKNOWN;
    public d profileType = d.UNKNOWN;
    public CodecType codecType = CodecType.H264;
    public long gopIndex = 0;
    public long gopFrameIndex = 0;
    public long frameIndex = 0;
    public long refFrameIndex = 0;
    public Integer svcInfo = null;
    public boolean isEosFrame = false;
    public b hdrType = b.UNKNOWN;
    public MediaCodec.BufferInfo info = null;

    public static EncodedVideoFrame createEncodedVideoFrame(ByteBuffer byteBuffer, int i3, int i16, int i17, long j3, long j16, long j17, long j18, long j19, long j26, int i18, long j27, int i19, int i26, boolean z16, int i27, int i28) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.data = byteBuffer;
        encodedVideoFrame.nativePtr = j27;
        encodedVideoFrame.nalType = c.a(i3);
        encodedVideoFrame.profileType = d.a(i16);
        encodedVideoFrame.codecType = CodecType.a(i18);
        encodedVideoFrame.rotation = i17;
        encodedVideoFrame.dts = j3;
        encodedVideoFrame.pts = j16;
        encodedVideoFrame.gopIndex = j17;
        encodedVideoFrame.gopFrameIndex = j18;
        encodedVideoFrame.frameIndex = j19;
        encodedVideoFrame.refFrameIndex = j26;
        encodedVideoFrame.info = null;
        encodedVideoFrame.width = i19;
        encodedVideoFrame.height = i26;
        if (z16) {
            encodedVideoFrame.svcInfo = Integer.valueOf(i27);
        } else {
            encodedVideoFrame.svcInfo = null;
        }
        encodedVideoFrame.hdrType = b.a(i28);
        return encodedVideoFrame;
    }

    private c getNalTypeFromH264NALHeader(ByteBuffer byteBuffer, int i3) {
        int i16 = byteBuffer.get(i3) & 31;
        if (i16 != 5) {
            if (i16 != 6) {
                if (i16 != 7) {
                    if (i16 != 8) {
                        return c.UNKNOWN;
                    }
                    return c.PPS;
                }
                return c.SPS;
            }
            return c.SEI;
        }
        return c.IDR;
    }

    private c getNalTypeFromH265NALHeader(ByteBuffer byteBuffer, int i3) {
        int i16 = (byteBuffer.get(i3) & 126) >> 1;
        if (i16 != 39) {
            switch (i16) {
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    return c.IDR;
                default:
                    switch (i16) {
                        case 32:
                            return c.VPS;
                        case 33:
                            return c.SPS;
                        case 34:
                            return c.PPS;
                        default:
                            return c.UNKNOWN;
                    }
            }
        }
        return c.SEI;
    }

    public static int getNextNALHeaderPos(int i3, ByteBuffer byteBuffer) {
        while (true) {
            int i16 = i3 + 3;
            if (i16 < byteBuffer.remaining()) {
                if (byteBuffer.get(i3) == 0 && byteBuffer.get(i3 + 1) == 0 && byteBuffer.get(i3 + 2) == 0 && byteBuffer.get(i16) == 1) {
                    return i3 + 4;
                }
                if (byteBuffer.get(i3) == 0 && byteBuffer.get(i3 + 1) == 0 && byteBuffer.get(i3 + 2) == 1) {
                    return i16;
                }
                i3++;
            } else {
                return -1;
            }
        }
    }

    private native void nativeRelease(long j3);

    public static long resetEncodedVideoFrame(EncodedVideoFrame encodedVideoFrame) {
        long j3 = encodedVideoFrame.nativePtr;
        if (j3 == 0 || encodedVideoFrame.data == null) {
            return 0L;
        }
        encodedVideoFrame.data = null;
        encodedVideoFrame.nativePtr = 0L;
        return j3;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativePtr != 0) {
            LiteavLog.w(TAG, "nativePtr != 0, must call release before finalize ");
            release();
        }
    }

    public boolean isH265() {
        if (this.codecType == CodecType.H265) {
            return true;
        }
        return false;
    }

    public boolean isHDRFrame() {
        b bVar = this.hdrType;
        if (bVar != null && bVar != b.UNKNOWN) {
            return true;
        }
        return false;
    }

    public boolean isIDRFrame() {
        boolean z16;
        c cVar = this.nalType;
        if (cVar != null) {
            if (cVar == c.IDR) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public boolean isRPSEnable() {
        d dVar = this.profileType;
        if (dVar != d.BASELINE_RPS && dVar != d.MAIN_RPS && dVar != d.HIGH_RPS) {
            return false;
        }
        return true;
    }

    public boolean isSVCEnable() {
        if (this.svcInfo != null) {
            return true;
        }
        return false;
    }

    public boolean isValidFrame() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null && byteBuffer.remaining() > 0 && this.nalType != null && this.codecType != null && this.width > 0 && this.height > 0) {
            return true;
        }
        return false;
    }

    public void release() {
        long j3 = this.nativePtr;
        if (j3 != 0) {
            nativeRelease(j3);
            this.nativePtr = 0L;
        }
    }

    public String toString() {
        return "nalType = " + this.nalType + ", profiletype=" + this.profileType + ", rotation=" + this.rotation + ", codecType=" + this.codecType + ", dts=" + this.dts + ", pts=" + this.pts + ", gopIndex=" + this.gopIndex + ", gopFrameIndex=" + this.gopFrameIndex + ", frameIndex=" + this.frameIndex;
    }

    public void updateNALTypeAccordingNALHeader() {
        c nalTypeFromH264NALHeader;
        if (this.data != null) {
            c cVar = this.nalType;
            if (cVar == null || cVar == c.UNKNOWN) {
                int i3 = 0;
                while (true) {
                    i3 = getNextNALHeaderPos(i3, this.data);
                    if (i3 != -1 && i3 < this.data.remaining()) {
                        c cVar2 = c.UNKNOWN;
                        if (isH265()) {
                            nalTypeFromH264NALHeader = getNalTypeFromH265NALHeader(this.data, i3);
                        } else {
                            nalTypeFromH264NALHeader = getNalTypeFromH264NALHeader(this.data, i3);
                        }
                        c cVar3 = this.nalType;
                        if (cVar3 == null || cVar3 == c.UNKNOWN || nalTypeFromH264NALHeader == c.IDR) {
                            this.nalType = nalTypeFromH264NALHeader;
                        }
                        c cVar4 = this.nalType;
                        if (cVar4 != c.SPS && cVar4 != c.PPS && cVar4 != c.VPS && cVar4 != c.SEI) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
