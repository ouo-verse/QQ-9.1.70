package com.tencent.youtu.ytagreflectlivecheck;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReflectionData {
    static IPatchRedirector $redirector_;
    public long beginTime;
    public long changePointTime;
    public long[] changePointTimeList;
    public int config_begin;
    public int fixedInterval;
    public int frameNum;
    public byte[] frames;
    public int height;
    public int[] intervals;
    public int landMarkNum;
    public byte[] log;
    public float offsetSys;
    public int randInv;
    public int randShift;
    public byte[] seqCaptchaID;
    public byte[] seqID;
    public int unit;
    public RawImgData[] videoData;
    public int width;

    public ReflectionData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void setCaptcha(int i3, int i16, int i17, int i18, int[] iArr, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), iArr, bArr, bArr2);
            return;
        }
        this.fixedInterval = i3;
        this.unit = i16;
        this.randShift = i17;
        this.randInv = i18;
        this.intervals = iArr;
        this.seqCaptchaID = bArr;
        this.frames = bArr2;
    }

    public void setDataPack(RawImgData[] rawImgDataArr, long j3, long j16, long[] jArr, float f16, int i3, int i16, int i17, int i18, int i19, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, rawImgDataArr, Long.valueOf(j3), Long.valueOf(j16), jArr, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), bArr, bArr2);
            return;
        }
        this.videoData = rawImgDataArr;
        this.beginTime = j3;
        this.changePointTime = j16;
        this.changePointTimeList = jArr;
        this.offsetSys = f16;
        this.frameNum = i3;
        this.landMarkNum = i16;
        this.width = i17;
        this.height = i18;
        this.config_begin = i19;
        this.log = bArr;
        this.seqID = bArr2;
    }
}
