package com.tencent.qqnt.qbasealbum.filter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/filter/a;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "image", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "filter", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilteringCode;", "b", "video", "c", QAdVrReportParams.ParamKey.MEDIA, "a", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f361199a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38975);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f361199a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MediaFilteringCode b(LocalMediaInfo image, MediaFilter filter) {
        boolean z16;
        boolean z17;
        int g16 = filter.g();
        int c16 = filter.c();
        int mediaWidth = image.getMediaWidth();
        boolean z18 = true;
        if (g16 <= mediaWidth && mediaWidth <= c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return MediaFilteringCode.IMAGE_INVALID_RESOLUTION;
        }
        int e16 = filter.e();
        int a16 = filter.a();
        int mediaHeight = image.getMediaHeight();
        if (e16 <= mediaHeight && mediaHeight <= a16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return MediaFilteringCode.IMAGE_INVALID_RESOLUTION;
        }
        float f16 = filter.f();
        float b16 = filter.b();
        float mediaWidth2 = image.getMediaWidth() / image.getMediaHeight();
        if (f16 > mediaWidth2 || mediaWidth2 > b16) {
            z18 = false;
        }
        if (!z18) {
            return MediaFilteringCode.IMAGE_INVALID_RATIO;
        }
        if (image.getFileSize() > filter.j()) {
            return MediaFilteringCode.IMAGE_EXCEED_SIZE_LIMIT;
        }
        return MediaFilteringCode.MEDIA_VALID;
    }

    private final MediaFilteringCode c(LocalMediaInfo video, MediaFilter filter) {
        boolean z16;
        boolean z17;
        int s16 = filter.s();
        int o16 = filter.o();
        int mediaWidth = video.getMediaWidth();
        boolean z18 = true;
        if (s16 <= mediaWidth && mediaWidth <= o16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return MediaFilteringCode.VIDEO_INVALID_RESOLUTION;
        }
        int q16 = filter.q();
        int m3 = filter.m();
        int mediaHeight = video.getMediaHeight();
        if (q16 <= mediaHeight && mediaHeight <= m3) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return MediaFilteringCode.VIDEO_INVALID_RESOLUTION;
        }
        float r16 = filter.r();
        float n3 = filter.n();
        float mediaWidth2 = video.getMediaWidth() / video.getMediaHeight();
        if (r16 > mediaWidth2 || mediaWidth2 > n3) {
            z18 = false;
        }
        if (!z18) {
            return MediaFilteringCode.VIDEO_INVALID_RATIO;
        }
        if (video.getFileSize() > filter.t()) {
            return MediaFilteringCode.VIDEO_EXCEED_SIZE_LIMIT;
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.f(video) < filter.p()) {
            return MediaFilteringCode.VIDEO_INVALID_MIN_DURATION;
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.f(video) > filter.l()) {
            return MediaFilteringCode.VIDEO_INVALID_MAX_DURATION;
        }
        return MediaFilteringCode.MEDIA_VALID;
    }

    @NotNull
    public final MediaFilteringCode a(@NotNull LocalMediaInfo media, @NotNull MediaFilter filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MediaFilteringCode) iPatchRedirector.redirect((short) 2, (Object) this, (Object) media, (Object) filter);
        }
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(filter, "filter");
        int mMediaType = media.getMMediaType();
        if (mMediaType != 0) {
            if (mMediaType != 1) {
                return MediaFilteringCode.MEDIA_VALID;
            }
            return c(media, filter);
        }
        return b(media, filter);
    }
}
