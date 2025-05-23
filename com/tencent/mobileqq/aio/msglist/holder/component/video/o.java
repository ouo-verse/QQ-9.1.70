package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqnt.compress.api.IVideoCompressApi;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J*\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/o;", "", "", "videoPath", "", "b", "", "width", "height", "maxSize", "Lkotlin/Pair;", "a", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "msgItem", "videoCodecFormat", "", "c", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f192253a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63950);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f192253a = new o();
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Pair<Integer, Integer> a(int width, int height, int maxSize) {
        int i3;
        int coerceAtMost;
        String str;
        int i16;
        String str2;
        int i17;
        int i18;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(maxSize));
        }
        int i19 = 100;
        if (width > 0) {
            i3 = width;
        } else {
            i3 = 100;
        }
        if (height > 0) {
            i19 = height;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(maxSize, com.tencent.mobileqq.aio.utils.p.c(305));
        if (i3 < i19) {
            z16 = false;
        }
        if (z16) {
            float f16 = i3 / i19;
            if (f16 > 1.5555556f) {
                i18 = (int) (((coerceAtMost * 9) / 16) + 0.5d);
                str3 = "landscape close to 16:9";
            } else if (f16 > 1.1666667f) {
                i18 = (int) (((coerceAtMost * 3) / 4) + 0.5d);
                str3 = "landscape close to 4:3";
            } else {
                str = "landscape close to 1:1";
                i16 = coerceAtMost;
                str2 = str;
                i17 = i16;
            }
            str2 = str3;
            i17 = i18;
            i16 = coerceAtMost;
        } else if (i19 / i3 > 1.3f) {
            i16 = (int) (((coerceAtMost * 10) / 16) + 0.5d);
            str2 = "portrait close to 10:16";
            i17 = coerceAtMost;
        } else {
            str = "portrait close to 1:1";
            i16 = coerceAtMost;
            str2 = str;
            i17 = i16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RichMediaUtil", 2, "adjustSize " + str2 + " maxPixel:" + coerceAtMost + " in:" + width + "," + height + " out:" + i16 + "," + i17);
        }
        return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public final long b(@Nullable String videoPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) videoPath)).longValue();
        }
        long j3 = -1;
        if (TextUtils.isEmpty(videoPath)) {
            return -1L;
        }
        Intrinsics.checkNotNull(videoPath);
        if (!new File(videoPath).exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("RichMediaUtil", 2, "[getDuration] file not exists! path:" + videoPath);
            }
            return -1L;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            try {
                reportMediaPlayer.setDataSource(videoPath);
                reportMediaPlayer.prepare();
                j3 = reportMediaPlayer.getDuration();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("RichMediaUtil", 2, "[getDuration] fail, path=" + videoPath + ", exc=" + e16);
                }
            }
            return j3;
        } finally {
            reportMediaPlayer.release();
        }
    }

    public final void c(@NotNull AppRuntime appRuntime, @NotNull ShortVideoMsgItem msgItem, int videoCodecFormat) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, msgItem, Integer.valueOf(videoCodecFormat));
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!((IVideoCompressApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVideoCompressApi.class)).isAIOConfigEnableH265Video(appRuntime)) {
            QLog.d("NT_ShortVideoPreDownloaderWithSdkSupport", 1, " handleReqSucForH265 return, config disable h265 video.");
            return;
        }
        u a16 = msgItem.z2().a();
        if (TextUtils.isEmpty(a16.c())) {
            a16.g(String.valueOf(videoCodecFormat));
        } else if (a16.a()) {
            if (TextUtils.equals(a16.c(), String.valueOf(videoCodecFormat))) {
                str = "1";
            } else {
                str = "0";
            }
            a16.h(str);
        }
        a16.f(String.valueOf(videoCodecFormat));
        msgItem.Y2();
        QLog.d("NT_ShortVideoPreDownloaderWithSdkSupport", 1, a16);
    }
}
