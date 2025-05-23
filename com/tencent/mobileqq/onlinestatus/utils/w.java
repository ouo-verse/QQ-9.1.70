package com.tencent.mobileqq.onlinestatus.utils;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007J0\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J0\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J0\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/w;", "", "Landroid/view/View;", "target", "", "pagId", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", tl.h.F, "", "d", "e", "", "isApertureFree", "b", "a", "elementId", "params", "c", "f", "elementCustomKey", "g", "<init>", "()V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f256380a = new w();

    w() {
    }

    @JvmStatic
    public static final void a(boolean isApertureFree) {
        String str;
        HashMap hashMap = new HashMap();
        if (isApertureFree) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_aperture_free", str);
        c("em_bas_avatar", hashMap);
    }

    @JvmStatic
    public static final void b(boolean isApertureFree) {
        String str;
        HashMap hashMap = new HashMap();
        if (isApertureFree) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_aperture_free", str);
        f("em_bas_avatar", hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r3 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r3);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (params == null || mutableMap == null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(new HashMap());
        }
        mutableMap.put("qq_eid", elementId);
        mutableMap.put("qq_pgid", "pg_bas_friend_status_aggregation");
        VideoReport.reportEvent("qq_clck", mutableMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("OnlineStatusDTReportUtils", 4, "reportClick " + elementId + ", newMap = " + mutableMap);
        }
    }

    @JvmStatic
    public static final void d(@Nullable View target, @NotNull String pagId, @Nullable Map<String, ? extends Object> pageParams) {
        Intrinsics.checkNotNullParameter(pagId, "pagId");
        if (target == null) {
            return;
        }
        VideoReport.setPageId(target, pagId);
        if (pageParams != null) {
            VideoReport.setPageParams(target, new PageParams(pageParams));
        }
        VideoReport.reportPgIn(target);
    }

    @JvmStatic
    public static final void e(@Nullable View target, @NotNull String pagId, @Nullable Map<String, ? extends Object> pageParams) {
        Intrinsics.checkNotNullParameter(pagId, "pagId");
        if (target == null) {
            return;
        }
        VideoReport.setPageId(target, pagId);
        if (pageParams != null) {
            VideoReport.setPageParams(target, new PageParams(pageParams));
        }
        VideoReport.reportPgOut(target);
    }

    @JvmStatic
    public static final void f(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        g(elementId, params, "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r0 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r4);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void g(@NotNull String elementId, @Nullable Map<String, ? extends Object> params, @Nullable String elementCustomKey) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (params == null || mutableMap == null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(new HashMap());
        }
        mutableMap.put(elementId + elementCustomKey, Long.valueOf(System.currentTimeMillis()));
        mutableMap.put("qq_eid", elementId);
        mutableMap.put("qq_pgid", "pg_bas_friend_status_aggregation");
        if (params != null) {
            mutableMap.putAll(params);
        }
        VideoReport.reportEvent("qq_imp", mutableMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("OnlineStatusDTReportUtils", 4, "reportQQImp " + elementId + ", newMap = " + mutableMap);
        }
    }

    @JvmStatic
    public static final void h(@NotNull View target, @NotNull String pagId, @Nullable Map<String, Object> pageParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pagId, "pagId");
        VideoReport.setPageId(target, pagId);
        if (pageParams != null) {
            VideoReport.setPageParams(target, new PageParams((Map<String, ?>) pageParams));
        }
    }
}
