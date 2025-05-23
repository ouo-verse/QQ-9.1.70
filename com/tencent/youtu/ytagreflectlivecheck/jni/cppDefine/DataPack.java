package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class DataPack {
    static IPatchRedirector $redirector_;
    public long beginTime;
    public long changePointTime;
    public long[] changePointTimeList;
    public int config_begin;
    public int frameNum;
    public int height;
    public int landMarkNum;
    public byte[] log;
    public float offsetSys;
    public byte[] seqID;
    public RawImgData[] videoData;
    public int width;

    public DataPack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
