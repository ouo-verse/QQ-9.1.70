package com.tencent.mobileqq.stt.sub.api.impl;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JV\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/stt/sub/api/impl/k;", "", "", "uin", "videoMd5", "", "errorCode", "totalTime", "cacheType", "extractTime", "audioMime", "extractError", "translateTime", PhotoCategorySinglePicInfo.UPLOAD_TIME, "", "a", "<init>", "()V", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f290825a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19461);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f290825a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String uin, @NotNull String videoMd5, int errorCode, int totalTime, int cacheType, int extractTime, @NotNull String audioMime, int extractError, int translateTime, int uploadTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uin, videoMd5, Integer.valueOf(errorCode), Integer.valueOf(totalTime), Integer.valueOf(cacheType), Integer.valueOf(extractTime), audioMime, Integer.valueOf(extractError), Integer.valueOf(translateTime), Integer.valueOf(uploadTime));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(videoMd5, "videoMd5");
        Intrinsics.checkNotNullParameter(audioMime, "audioMime");
        HashMap hashMap = new HashMap();
        hashMap.put("video_md5", videoMd5);
        hashMap.put("error_code", String.valueOf(errorCode));
        hashMap.put("total_time", String.valueOf(totalTime));
        hashMap.put("cache_type", String.valueOf(cacheType));
        hashMap.put("extract_time", String.valueOf(extractTime));
        hashMap.put("audio_mime", audioMime);
        hashMap.put("extract_error", String.valueOf(extractError));
        hashMap.put("translate_time", String.valueOf(translateTime));
        hashMap.put(s4.c.UPLOAD_TIME, String.valueOf(uploadTime));
        QQBeaconReport.report(uin, "video_subtitle_result", hashMap);
    }
}
