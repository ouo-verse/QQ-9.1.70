package com.tencent.halley.downloader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class DownloaderTaskPriority {
    static IPatchRedirector $redirector_;
    public static final DownloaderTaskPriority HIGH;
    public static final DownloaderTaskPriority LOW;
    public static final DownloaderTaskPriority NORMAL;
    public static final DownloaderTaskPriority URGENT;

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ DownloaderTaskPriority[] f113576a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DownloaderTaskPriority downloaderTaskPriority = new DownloaderTaskPriority("LOW", 0);
        LOW = downloaderTaskPriority;
        DownloaderTaskPriority downloaderTaskPriority2 = new DownloaderTaskPriority(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 1);
        NORMAL = downloaderTaskPriority2;
        DownloaderTaskPriority downloaderTaskPriority3 = new DownloaderTaskPriority("HIGH", 2);
        HIGH = downloaderTaskPriority3;
        DownloaderTaskPriority downloaderTaskPriority4 = new DownloaderTaskPriority("URGENT", 3);
        URGENT = downloaderTaskPriority4;
        f113576a = new DownloaderTaskPriority[]{downloaderTaskPriority, downloaderTaskPriority2, downloaderTaskPriority3, downloaderTaskPriority4};
    }

    DownloaderTaskPriority(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static DownloaderTaskPriority valueOf(String str) {
        return (DownloaderTaskPriority) Enum.valueOf(DownloaderTaskPriority.class, str);
    }

    public static DownloaderTaskPriority[] values() {
        return (DownloaderTaskPriority[]) f113576a.clone();
    }
}
