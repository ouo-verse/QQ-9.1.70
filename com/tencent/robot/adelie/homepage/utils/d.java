package com.tencent.robot.adelie.homepage.utils;

import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J2\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/d;", "", "", com.heytap.mcssdk.a.a.f36102l, "eventCode", "", "params", "", "b", "Ljava/lang/String;", "KEY_DEVICE_NET_TYPE", "c", "KEY_TIMESTAMP_MS", "d", "KEY_USER_ID", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a */
    @NotNull
    public static final d f366652a = new d();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static String KEY_DEVICE_NET_TYPE = "device_net_type";

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static String KEY_TIMESTAMP_MS = "params_timestamp";

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static String KEY_USER_ID = "params_uin";

    d() {
    }

    @JvmStatic
    public static final void b(@NotNull final String r16, @NotNull final String eventCode, @Nullable final Map<String, String> params) {
        Intrinsics.checkNotNullParameter(r16, "appKey");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                d.d(params, r16, eventCode);
            }
        }, 128, null, false);
    }

    public static /* synthetic */ void c(String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            map = null;
        }
        b(str, str2, map);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        r6 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(Map map, String appKey, String eventCode) {
        Map<String, String> linkedHashMap;
        Intrinsics.checkNotNullParameter(appKey, "$appKey");
        Intrinsics.checkNotNullParameter(eventCode, "$eventCode");
        if (map == null || linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put(KEY_DEVICE_NET_TYPE, String.valueOf(HttpUtil.getNetWorkTypeContain5G()));
        linkedHashMap.put(KEY_TIMESTAMP_MS, String.valueOf(System.currentTimeMillis()));
        String str = KEY_USER_ID;
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        linkedHashMap.put(str, currentUin);
        EventResult report = BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey(appKey).withCode(eventCode).withParams(linkedHashMap).build());
        if (QLog.isColorLevel()) {
            QLog.i("AdelieBeaconReportUtil", 2, "report EventResult{ eventID:" + report.eventID + ", errorCode:" + report.errorCode + ", errorMsg:" + report.errMsg + "}, appKey:" + appKey + ", eventCode:" + eventCode + ", params:" + linkedHashMap);
        }
    }
}
