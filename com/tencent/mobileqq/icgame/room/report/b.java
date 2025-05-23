package com.tencent.mobileqq.icgame.room.report;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.impl.room.corelog.EnterRoomLogKt;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.techreport.d;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002\u001a\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004\u001a\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/report/c;", QQPermissionConstants.Permission.AUIDO_GROUP, "", "errorCode", "", "errorMsg", "", "f", "c", "e", "isForceReport", "g", "url", "d", "b", "", "a", "ic-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    private static final Map<String, String> a(ReportRecord reportRecord) {
        HashMap hashMap = new HashMap();
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(reportRecord.getRoomId()));
        hashMap.put("user_id", reportRecord.getUid());
        hashMap.put("ext1", reportRecord.getId());
        hashMap.put("ext2", String.valueOf(reportRecord.getStartClickTime()));
        hashMap.put("ext3", String.valueOf(reportRecord.getStartPreloadTime()));
        hashMap.put("ext4", String.valueOf(reportRecord.getStartSwitchTime()));
        hashMap.put("ext5", reportRecord.getJumpSource());
        return hashMap;
    }

    public static final void b(@NotNull ReportRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        d.g("ev_icgame_start_enter_room", a(record));
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "reportClickEnterRoom} >>> " + record);
    }

    public static final void c(@NotNull ReportRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        long f16 = record.f();
        long v3 = record.v();
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "roomId: " + record.getRoomId() + ", realFirstFrameCost " + f16 + ", userAwareFirstFrameCost " + v3 + ", core timeStamp " + record.i());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        if (r4 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(@NotNull ReportRecord record, @NotNull String url) {
        String str;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean contains$default;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(url, "url");
        if (record.getStartClickTime() <= 0) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "StartClickTime is Zero,No Report format! source:" + record.getJumpSource() + " url:" + url);
            return;
        }
        if (TextUtils.isEmpty(url)) {
            str = GlobalUtil.DEF_STRING;
        } else {
            str = "rtmp";
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "rtmp", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
                if (startsWith$default2) {
                    str = "flv";
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "flv", false, 2, (Object) null);
                }
                str = "other";
            }
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(a(record));
        mutableMap.put("ext6", str);
        d.g("ev_icgame_video_format", mutableMap);
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "report video format:" + str + " , url:" + url);
    }

    public static final void e(@NotNull ReportRecord record, int i3, @NotNull String errorMsg) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        mutableMap = MapsKt__MapsKt.toMutableMap(a(record));
        mutableMap.put("event_code", String.valueOf(i3));
        mutableMap.put(AudienceReportConst.EVENT_MSG, errorMsg);
        mutableMap.put("cost_time", String.valueOf(record.e()));
        d.g("ev_icgame_enter_room", mutableMap);
        QLog.i(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "startReportEnterRoomTime:" + record.e() + " >>> " + record + ", errCode:" + i3 + ", errMsg:" + errorMsg);
    }

    public static final void f(@NotNull ReportRecord record, int i3, @NotNull String errorMsg) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        mutableMap = MapsKt__MapsKt.toMutableMap(a(record));
        mutableMap.put("event_code", String.valueOf(i3));
        mutableMap.put(AudienceReportConst.EVENT_MSG, errorMsg);
        mutableMap.put("cost_time", String.valueOf(record.f()));
        d.g("ev_icgame_first_frame", mutableMap);
        QLog.i(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "reportFirstFrameComTime:" + record.f() + " >>> " + record + ", errCode:" + i3 + ", errMsg:" + errorMsg);
    }

    public static final void g(@NotNull ReportRecord record, int i3) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(record, "record");
        mutableMap = MapsKt__MapsKt.toMutableMap(a(record));
        mutableMap.put(AudienceReportConst.EVENT_MSG, String.valueOf(record.g()));
        mutableMap.put("ext6", String.valueOf(i3));
        d.g("ev_icgame_video_error", mutableMap);
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "startReportVideoLoadError:" + record.g() + " >>> " + record);
    }
}
