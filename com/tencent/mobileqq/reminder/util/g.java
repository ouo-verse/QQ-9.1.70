package com.tencent.mobileqq.reminder.util;

import android.os.Looper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000\u001a8\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0006\u001a:\u0010\t\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0006H\u0002\u00a8\u0006\n"}, d2 = {"", "event", "busId", "", "b", "elementId", "", QQBrowserActivity.APP_PARAM, "c", "f", "qqreminder-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g {
    public static final void b(@NotNull String event, @NotNull String busId) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(busId, "busId");
        d(event, busId, "em_bas_QQreminder", null, 8, null);
    }

    public static final void c(@NotNull final String event, @NotNull final String busId, @NotNull final String elementId, @Nullable final Map<String, String> map) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(busId, "busId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.reminder.util.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.e(event, busId, elementId, map);
                }
            }, 128, null, true);
        } else {
            f(event, busId, elementId, map);
        }
    }

    public static /* synthetic */ void d(String str, String str2, String str3, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        c(str, str2, str3, map);
    }

    public static final void e(String event, String busId, String elementId, Map map) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(busId, "$busId");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        f(event, busId, elementId, map);
    }

    private static final void f(String str, String str2, String str3, Map<String, String> map) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", str2);
        hashMap.put("qq_eid", str3);
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        String str4 = "";
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        hashMap.put("home_uin", currentAccountUin);
        String currentUid = peekAppRuntime.getCurrentUid();
        if (currentUid != null) {
            str4 = currentUid;
        }
        hashMap.put("uid", str4);
        hashMap.put("msglist_type", "0");
        hashMap.put("qq_pgid", "pg_bas_msglist");
        if (map != null) {
            hashMap.putAll(map);
        }
        VideoReport.reportEvent(str, hashMap);
    }
}
