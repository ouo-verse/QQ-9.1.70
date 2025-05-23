package com.tencent.hlyyb.downloader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class DownloaderTaskStatus {
    static IPatchRedirector $redirector_;
    public static final DownloaderTaskStatus COMPLETE;
    public static final DownloaderTaskStatus DELETED;
    public static final DownloaderTaskStatus DOWNLOADING;
    public static final DownloaderTaskStatus FAILED;
    public static final DownloaderTaskStatus PAUSED;
    public static final DownloaderTaskStatus PENDING;
    public static final DownloaderTaskStatus STARTED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloaderTaskStatus[] f114363a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DownloaderTaskStatus downloaderTaskStatus = new DownloaderTaskStatus("PENDING", 0);
        PENDING = downloaderTaskStatus;
        DownloaderTaskStatus downloaderTaskStatus2 = new DownloaderTaskStatus("STARTED", 1);
        STARTED = downloaderTaskStatus2;
        DownloaderTaskStatus downloaderTaskStatus3 = new DownloaderTaskStatus("DOWNLOADING", 2);
        DOWNLOADING = downloaderTaskStatus3;
        DownloaderTaskStatus downloaderTaskStatus4 = new DownloaderTaskStatus("COMPLETE", 3);
        COMPLETE = downloaderTaskStatus4;
        DownloaderTaskStatus downloaderTaskStatus5 = new DownloaderTaskStatus("FAILED", 4);
        FAILED = downloaderTaskStatus5;
        DownloaderTaskStatus downloaderTaskStatus6 = new DownloaderTaskStatus("PAUSED", 5);
        PAUSED = downloaderTaskStatus6;
        DownloaderTaskStatus downloaderTaskStatus7 = new DownloaderTaskStatus("DELETED", 6);
        DELETED = downloaderTaskStatus7;
        f114363a = new DownloaderTaskStatus[]{downloaderTaskStatus, downloaderTaskStatus2, downloaderTaskStatus3, downloaderTaskStatus4, downloaderTaskStatus5, downloaderTaskStatus6, downloaderTaskStatus7};
    }

    public DownloaderTaskStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static DownloaderTaskStatus valueOf(String str) {
        return (DownloaderTaskStatus) Enum.valueOf(DownloaderTaskStatus.class, str);
    }

    public static DownloaderTaskStatus[] values() {
        return (DownloaderTaskStatus[]) f114363a.clone();
    }
}
