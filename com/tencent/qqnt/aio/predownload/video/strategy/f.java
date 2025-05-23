package com.tencent.qqnt.aio.predownload.video.strategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\b\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/strategy/f;", "", "Lorg/json/JSONObject;", "configJSONObject", "d", "", "toString", "", "a", "Z", "c", "()Z", "setPreDownloadVideo", "(Z)V", "preDownloadVideo", "b", "setPreDownloadThumb", "preDownloadThumb", "", "J", "()J", "setLimitTimeInMinutes", "(J)V", "limitTimeInMinutes", "<init>", "(ZZJ)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean preDownloadVideo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean preDownloadThumb;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long limitTimeInMinutes;

    public f(boolean z16, boolean z17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
            return;
        }
        this.preDownloadVideo = z16;
        this.preDownloadThumb = z17;
        this.limitTimeInMinutes = j3;
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.limitTimeInMinutes;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.preDownloadThumb;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.preDownloadVideo;
    }

    @NotNull
    public final f d(@NotNull JSONObject configJSONObject) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this, (Object) configJSONObject);
        }
        Intrinsics.checkNotNullParameter(configJSONObject, "configJSONObject");
        boolean z17 = false;
        if (configJSONObject.optInt("pre_download_video") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (configJSONObject.optInt("pre_download_thumb") == 1) {
            z17 = true;
        }
        long optLong = configJSONObject.optLong("limit_time_minutes");
        if (optLong <= 0) {
            optLong = Long.MAX_VALUE;
        }
        return new f(z16, z17, optLong);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "(preDownloadVideo=" + this.preDownloadVideo + ", preDownloadThumb=" + this.preDownloadThumb + ", limitTimeInMinutes=" + this.limitTimeInMinutes + ")";
    }
}
