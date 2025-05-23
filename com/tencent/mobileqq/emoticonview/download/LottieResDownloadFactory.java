package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class LottieResDownloadFactory {
    static IPatchRedirector $redirector_ = null;
    public static final int DOWNLOAD_ANISTICKER_RES = 1;

    public LottieResDownloadFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T extends IEmoticonLottieResDownloader> T createLottieResDownloader(int i3) {
        if (i3 != 1) {
            return null;
        }
        return new AniStickerLottieResDownloader();
    }
}
