package com.tencent.mobileqq.troop.homework.utils;

import android.os.SystemClock;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.troop.utils.bg;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJV\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002H\u0007J:\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J:\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\"\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J.\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/utils/a;", "", "", QzoneIPCModule.RESULT_CODE, "", "resultMsg", "", "costTime", "fileSize", "rawSize", TagName.FILE_TYPE, "troopUin", "mediaWidth", "mediaHeight", "", "e", "mode", "uin", "a", "c", "Lcom/tencent/mobileqq/troop/homework/xmediaeditor/model/ImageInfo;", "info", "b", "isModify", "d", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final a f297343a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54277);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f297343a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(int r26, @Nullable String resultMsg, long costTime, int mode, @NotNull String uin, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        HashMap hashMap = new HashMap();
        hashMap.put("result_code", Integer.valueOf(r26));
        if (resultMsg != null) {
            hashMap.put("result_msg", resultMsg);
        }
        hashMap.put("cost_time", Long.valueOf(costTime));
        int i3 = 1;
        if (mode == 1) {
            i3 = 0;
        }
        hashMap.put("is_modify", Integer.valueOf(i3));
        hashMap.put("quin", uin);
        hashMap.put("group_code", troopUin);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_homework_publish", hashMap);
    }

    @JvmStatic
    public static final void b(int r122, @Nullable String resultMsg, @NotNull ImageInfo info) {
        long m3;
        Intrinsics.checkNotNullParameter(info, "info");
        if (info instanceof VideoInfo) {
            m3 = q.m(((VideoInfo) info).f297392v) / 1024;
        } else {
            m3 = q.m(info.f297361f) / 1024;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - info.f297372q;
        int c16 = info.c();
        String str = info.f297373r;
        Intrinsics.checkNotNullExpressionValue(str, "info.mTroopUin");
        c(r122, resultMsg, elapsedRealtime, m3, c16, str);
    }

    @JvmStatic
    public static final void c(int r26, @Nullable String resultMsg, long costTime, long fileSize, int r85, @NotNull String troopUin) {
        String str;
        String currentUin;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        HashMap hashMap = new HashMap();
        hashMap.put("result_code", Integer.valueOf(r26));
        if (resultMsg != null) {
            hashMap.put("result_msg", resultMsg);
        }
        hashMap.put("cost_time", Long.valueOf(costTime));
        hashMap.put("file_size", Long.valueOf(fileSize));
        if (r85 != 1) {
            if (r85 != 2) {
                if (r85 != 3) {
                    str = "other";
                } else {
                    str = "audio";
                }
            } else {
                str = "video";
            }
        } else {
            str = "image";
        }
        hashMap.put("file_type", str);
        AppRuntime f16 = bg.f();
        if (f16 != null && (currentUin = f16.getCurrentUin()) != null) {
            hashMap.put("quin", currentUin);
        }
        hashMap.put("group_code", troopUin);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("homework_publish_media_upload", hashMap);
    }

    @JvmStatic
    public static final void e(int r26, @Nullable String resultMsg, long costTime, long fileSize, long rawSize, @NotNull String r102, @NotNull String troopUin, int mediaWidth, int mediaHeight) {
        String currentUin;
        Intrinsics.checkNotNullParameter(r102, "fileType");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        HashMap hashMap = new HashMap();
        hashMap.put("result_code", Integer.valueOf(r26));
        if (resultMsg != null) {
            hashMap.put("result_msg", resultMsg);
        }
        hashMap.put("cost_time", Long.valueOf(costTime));
        long j3 = 1024;
        hashMap.put("file_size", Long.valueOf(fileSize / j3));
        hashMap.put("raw_size", Long.valueOf(rawSize / j3));
        hashMap.put("file_type", r102);
        AppRuntime f16 = bg.f();
        if (f16 != null && (currentUin = f16.getCurrentUin()) != null) {
            hashMap.put("quin", currentUin);
        }
        hashMap.put("group_code", troopUin);
        hashMap.put("media_width", Integer.valueOf(mediaWidth));
        hashMap.put("media_height", Integer.valueOf(mediaHeight));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("school_home_media_upload", hashMap);
    }

    public static /* synthetic */ void f(int i3, String str, long j3, long j16, long j17, String str2, String str3, int i16, int i17, int i18, Object obj) {
        int i19;
        int i26;
        if ((i18 & 128) != 0) {
            i19 = 0;
        } else {
            i19 = i16;
        }
        if ((i18 & 256) != 0) {
            i26 = 0;
        } else {
            i26 = i17;
        }
        e(i3, str, j3, j16, j17, str2, str3, i19, i26);
    }

    public final void d(int r56, @NotNull String resultMsg, long costTime, int isModify, @NotNull String troopUin) {
        String currentUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(r56), resultMsg, Long.valueOf(costTime), Integer.valueOf(isModify), troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        HashMap hashMap = new HashMap();
        hashMap.put("result_code", Integer.valueOf(r56));
        hashMap.put("result_msg", resultMsg);
        hashMap.put("cost_time", Long.valueOf(costTime));
        hashMap.put("is_modify", Integer.valueOf(isModify));
        AppRuntime f16 = bg.f();
        if (f16 != null && (currentUin = f16.getCurrentUin()) != null) {
            hashMap.put("quin", currentUin);
        }
        hashMap.put("group_code", troopUin);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_homework_submit", hashMap);
    }
}
