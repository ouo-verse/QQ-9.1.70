package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.h;
import java.nio.ByteBuffer;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class SpsInfo {
    public int width = 0;
    public int height = 0;
    public Integer videoFormat = null;
    public Integer videoFullRangeFlag = null;
    public Integer colourPrimaries = null;
    public Integer transferCharacteristics = null;
    public Integer matrixCoefficients = null;
    public Integer maxNumRefFrames = null;

    public static native SpsInfo nativeDecodeSps(boolean z16, ByteBuffer byteBuffer);

    public static native byte[] nativeGetSpsPps(byte[] bArr, boolean z16, boolean z17);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpsInfo)) {
            return false;
        }
        SpsInfo spsInfo = (SpsInfo) obj;
        if (spsInfo.width == this.width && spsInfo.height == this.height && h.a(this.videoFormat, spsInfo.videoFormat) && h.a(this.videoFullRangeFlag, spsInfo.videoFullRangeFlag) && h.a(this.colourPrimaries, spsInfo.colourPrimaries) && h.a(this.transferCharacteristics, spsInfo.transferCharacteristics) && h.a(this.matrixCoefficients, spsInfo.matrixCoefficients) && h.a(this.maxNumRefFrames, spsInfo.maxNumRefFrames)) {
            return true;
        }
        return false;
    }

    public void set(SpsInfo spsInfo) {
        if (spsInfo == null) {
            spsInfo = new SpsInfo();
        }
        this.width = spsInfo.width;
        this.height = spsInfo.height;
        this.videoFormat = spsInfo.videoFormat;
        this.videoFullRangeFlag = spsInfo.videoFullRangeFlag;
        this.colourPrimaries = spsInfo.colourPrimaries;
        this.transferCharacteristics = spsInfo.transferCharacteristics;
        this.matrixCoefficients = spsInfo.matrixCoefficients;
        this.maxNumRefFrames = spsInfo.maxNumRefFrames;
    }

    public void setColourPrimaries(int i3) {
        this.colourPrimaries = Integer.valueOf(i3);
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setMatrixCoefficients(int i3) {
        this.matrixCoefficients = Integer.valueOf(i3);
    }

    public void setMaxNumRefFrames(int i3) {
        this.maxNumRefFrames = Integer.valueOf(i3);
    }

    public void setTransferCharacteristics(int i3) {
        this.transferCharacteristics = Integer.valueOf(i3);
    }

    public void setVideoFormat(int i3) {
        this.videoFormat = Integer.valueOf(i3);
    }

    public void setVideoFullRangeFlag(int i3) {
        this.videoFullRangeFlag = Integer.valueOf(i3);
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    public String toString() {
        return "SpsInfo(" + ("width=" + this.width + ",height=" + this.height + ",videoFormat=" + this.videoFormat + ",videoFullRangeFlag=" + this.videoFullRangeFlag + ",colourPrimaries=" + this.colourPrimaries + ",transferCharacteristics=" + this.transferCharacteristics + ",matrixCoefficients=" + this.matrixCoefficients + ",maxNumRefFrames=" + this.maxNumRefFrames) + ")";
    }
}
