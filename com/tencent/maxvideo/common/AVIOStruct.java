package com.tencent.maxvideo.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AVIOStruct implements Cloneable {
    static IPatchRedirector $redirector_;
    public int aBitrate;
    public int aChannel;
    public int aFormat;
    public int aSampleRate;
    public int pBlockIndex;
    public int pCodec;
    public int pControlFlag;
    public int pFrameIndex;
    public int vBitrate;
    public int vFPS;
    public int vFormat;
    public long vFrameTime;
    public int vHeight;
    public int vOrientation;
    public int vWidth;

    public AVIOStruct() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            return (AVIOStruct) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public boolean isWriteFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.pControlFlag != ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue() && this.pControlFlag != ControlFlagEnum.WRITE_FRAME_DATA.getValue() && this.pControlFlag != ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue()) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AVIOStruct [pBlockIndex=" + this.pBlockIndex + ", pFrameIndex=" + this.pFrameIndex + ", pCodec=" + this.pCodec + ", pControlFlag=" + this.pControlFlag + ", vWidth=" + this.vWidth + ", vHeight=" + this.vHeight + ", vOrientation=" + this.vOrientation + ", vFPS=" + this.vFPS + ", vFormat=" + this.vFormat + ", vBitrate=" + this.vBitrate + ", aSampleRate=" + this.aSampleRate + ", aChannel=" + this.aChannel + ", aFormat=" + this.aFormat + ", aBitrate=" + this.aBitrate + "]";
    }
}
