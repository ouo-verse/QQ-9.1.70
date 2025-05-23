package com.tencent.hlyyb.downloader.e;

import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.hlyyb.downloader.e.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f114463a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f114464b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11642);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[c.a.a().length];
        f114464b = iArr;
        try {
            iArr[c.a.f114472a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f114464b[c.a.f114473b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f114464b[c.a.f114474c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f114464b[c.a.f114475d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f114464b[c.a.f114476e.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f114464b[c.a.f114477f.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f114464b[c.a.f114478g.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f114464b[c.a.f114479h.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        int[] iArr2 = new int[DownloaderTaskStatus.values().length];
        f114463a = iArr2;
        try {
            iArr2[DownloaderTaskStatus.PENDING.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f114463a[DownloaderTaskStatus.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f114463a[DownloaderTaskStatus.DOWNLOADING.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f114463a[DownloaderTaskStatus.COMPLETE.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f114463a[DownloaderTaskStatus.FAILED.ordinal()] = 5;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f114463a[DownloaderTaskStatus.PAUSED.ordinal()] = 6;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f114463a[DownloaderTaskStatus.DELETED.ordinal()] = 7;
        } catch (NoSuchFieldError unused15) {
        }
    }
}
