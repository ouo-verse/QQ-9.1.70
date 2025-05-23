package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class VideoSize {
    private static final /* synthetic */ VideoSize[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final VideoSize SIZE_480P;
    public static final VideoSize SIZE_720P;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21364);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        VideoSize videoSize = new VideoSize("SIZE_480P", 0);
        SIZE_480P = videoSize;
        VideoSize videoSize2 = new VideoSize("SIZE_720P", 1);
        SIZE_720P = videoSize2;
        $VALUES = new VideoSize[]{videoSize, videoSize2};
    }

    VideoSize(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static VideoSize valueOf(String str) {
        return (VideoSize) Enum.valueOf(VideoSize.class, str);
    }

    public static VideoSize[] values() {
        return (VideoSize[]) $VALUES.clone();
    }
}
