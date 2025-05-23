package com.tencent.mobileqq.wifiphoto.data;

import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.PlatformType;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0006\u0010\t\u001a\u00020\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f\u001a\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006\u001a@\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0012\u001a@\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0012\u001a@\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0012\u001a@\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0012\u001a\u001a\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0018\u00a8\u0006\u001a"}, d2 = {"", "type", "", "duration", "", h.F, "", "page", "b", "i", "", "isPageIn", "", "pageId", "g", "elementId", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "d", "j", "f", "k", "", "a", "wifiphoto_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    public static final void a(@NotNull Map<String, Object> map) {
        int i3;
        Intrinsics.checkNotNullParameter(map, "map");
        QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
        PlatformType D = qFileBridgeService.D();
        if (D != null) {
            i3 = D.ordinal();
        } else {
            i3 = 0;
        }
        map.put("computer_system", Integer.valueOf(i3));
        map.put("login_mode", Integer.valueOf(qFileBridgeService.E().ordinal()));
    }

    public static final void b(@NotNull Object page) {
        Intrinsics.checkNotNullParameter(page, "page");
        VideoReport.setElementId(page, "em_bas_msglist_small_bar");
        HashMap hashMap = new HashMap();
        hashMap.put("smallbar_service_type", "WifiPhoto");
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("clck", page, hashMap);
    }

    public static final void c(@NotNull String elementId, @NotNull Object page) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(page, "page");
        VideoReport.setPageId(page, "pg_bas_mobile_album_licensing");
        VideoReport.setElementId(page, elementId);
    }

    public static final void d(@NotNull String elementId, @NotNull String pageId, @Nullable HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("dt_eid", elementId);
        hashMap.put("dt_pgid", pageId);
        VideoReport.reportEvent("clck", hashMap);
    }

    public static /* synthetic */ void e(String str, String str2, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            hashMap = null;
        }
        d(str, str2, hashMap);
    }

    public static final void f(@NotNull String elementId, @NotNull String pageId, @Nullable HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("dt_eid", elementId);
        hashMap.put("dt_pgid", pageId);
        VideoReport.reportEvent("imp", hashMap);
    }

    public static final void g(boolean z16, @NotNull Object page, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        VideoReport.setPageId(page, pageId);
        if (z16) {
            VideoReport.reportPgIn(page, false);
        } else {
            VideoReport.reportPgOut(page);
        }
    }

    public static final void h(int i3, long j3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("stay_time", String.valueOf(j3));
        linkedHashMap.put("access_type", String.valueOf(i3));
        VideoReport.reportEvent("ev_bas_mobile_album_licensing_lvtm", linkedHashMap);
    }

    public static final void i() {
        VideoReport.reportEvent("ev_bas_access_album_background_push", new LinkedHashMap());
    }

    public static final void j(@NotNull String elementId, @NotNull String pageId, @Nullable HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("dt_eid", elementId);
        hashMap.put("dt_pgid", pageId);
        hashMap.put("qq_pgid", pageId);
        hashMap.put("qq_eid", elementId);
        VideoReport.reportEvent("qq_clck", hashMap);
    }

    public static final void k(@NotNull String elementId, @NotNull String pageId, @Nullable HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("dt_eid", elementId);
        hashMap.put("qq_eid", elementId);
        hashMap.put("dt_pgid", pageId);
        hashMap.put("qq_pgid", pageId);
        VideoReport.reportEvent("qq_imp", hashMap);
    }
}
