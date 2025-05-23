package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class GroupLiveTRTCVideoFrame {
    static IPatchRedirector $redirector_;
    public ByteBuffer buffer;
    public int bufferType;
    public byte[] data;
    public int height;
    public int pixelFormat;
    public int rotation;
    public GroupLiveTRTCTexture texture;
    public long timestamp;
    public int width;

    public GroupLiveTRTCVideoFrame(int i3, int i16, GroupLiveTRTCTexture groupLiveTRTCTexture, byte[] bArr, int i17, int i18, long j3, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), groupLiveTRTCTexture, bArr, Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3), Integer.valueOf(i19));
            return;
        }
        this.pixelFormat = i3;
        this.bufferType = i16;
        this.texture = groupLiveTRTCTexture;
        this.data = bArr;
        this.width = i17;
        this.height = i18;
        this.timestamp = j3;
        this.rotation = i19;
    }
}
