package com.tencent.maxvideo.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.video.decode.ShortVideoSoLoad;

/* compiled from: P */
/* loaded from: classes9.dex */
public class GlobalInit {
    static IPatchRedirector $redirector_;

    public GlobalInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int loadLibraryWithFullPath(String str) {
        return ShortVideoSoLoad.LoadExtractedShortVideo(str);
    }

    public static native boolean nativeAsyncProcessMsg(MessageStruct messageStruct, Object obj);

    public static native boolean nativeSyncProcessMsg(MessageStruct messageStruct, MessageStruct messageStruct2, Object obj);
}
