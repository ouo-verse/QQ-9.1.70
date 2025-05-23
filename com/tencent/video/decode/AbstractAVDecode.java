package com.tencent.video.decode;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class AbstractAVDecode {
    static IPatchRedirector $redirector_ = null;
    public static final int STREAM_AUDIO = 1096108367;
    public static final int STREAM_VIDEO = 1447642447;
    private static volatile boolean sInitedStatus;
    public static boolean soLoaded;
    public final AVAudioParam audioParam;
    public final AVVideoParam videoParam;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            soLoaded = false;
            sInitedStatus = false;
        }
    }

    public AbstractAVDecode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.videoParam = new AVVideoParam();
            this.audioParam = new AVAudioParam();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkSoLoaded() {
        if (!isLoadDecodeLib()) {
            AVDecodeError.throwException(-202);
        }
    }

    private static boolean isLoadDecodeLib() {
        boolean z16;
        if (!sInitedStatus) {
            if (ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            soLoaded = z16;
            sInitedStatus = true;
        }
        return soLoaded;
    }

    public abstract void close();

    public abstract void resetVideoPlayer(AVDecodeOption aVDecodeOption);

    public abstract byte[] seekToNextAudioByteFrame() throws AVideoException;

    public abstract float[] seekToNextAudioFloatFrame() throws AVideoException;

    public abstract short[] seekToNextAudioShortFrame() throws AVideoException;

    public abstract void seekToNextFrame(Bitmap bitmap) throws AVideoException;
}
