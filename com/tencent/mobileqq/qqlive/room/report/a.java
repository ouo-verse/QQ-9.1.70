package com.tencent.mobileqq.qqlive.room.report;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.impl.room.corelog.EnterRoomLogKt;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveBeaconReportApi;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import ft3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002\u001a\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004\u001a\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/report/b;", QQPermissionConstants.Permission.AUIDO_GROUP, "", "errorCode", "", "errorMsg", "", "f", "c", "e", "isForceReport", "g", "url", "d", "b", "Lft3/c;", "a", "qq-live-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    private static final c a(b bVar) {
        String qQLiveAppId = QQLiveSDKConfigHelper.getQQLiveAppId();
        c newReportTask = ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).newReportTask();
        long q16 = bVar.q();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(q16);
        c addKeyValue = newReportTask.addKeyValue(AudienceReportConst.ROOM_ID, sb5.toString()).addKeyValue("report_id", bVar.k()).addKeyValue(PerfTracer.PARAM_CLICK_TIME, bVar.s()).addKeyValue("preload_time", bVar.t()).addKeyValue("switch_room_time", bVar.u()).addKeyValue("room_type", bVar.r()).addKeyValue("jump_source", bVar.l()).addKeyValue("network_status", NetworkState.getNetworkType()).addKeyValue("uid", bVar.v()).addKeyValue("app_id", qQLiveAppId).addKeyValue("use_live_sdk", bVar.w() ? 1 : 0);
        Intrinsics.checkNotNullExpressionValue(addKeyValue, "api(IQQLiveBeaconReportA\u2026ord.useLivesdk) 1 else 0)");
        return addKeyValue;
    }

    public static final void b(@NotNull b record) {
        Intrinsics.checkNotNullParameter(record, "record");
        a(record).a("ev_qq_live_start_enter_room").send();
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "reportClickEnterRoom} >>> " + record);
    }

    public static final void c(@NotNull b record) {
        Intrinsics.checkNotNullParameter(record, "record");
        long f16 = record.f();
        long x16 = record.x();
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "roomId: " + record.q() + ", realFirstFrameCost " + f16 + ", userAwareFirstFrameCost " + x16 + ", core timeStamp " + record.i());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        if (r4 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(@NotNull b record, @NotNull String url) {
        String str;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(url, "url");
        if (record.s() <= 0) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "StartClickTime is Zero,No Report format! source:" + record.l() + " url:" + url);
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
        a(record).a("ev_qq_live_video_format").addKeyValue("video_format", str).send();
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "report video format:" + str + " , url:" + url);
    }

    public static final void e(@NotNull b record, int i3, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        a(record).a("ev_qq_live_enter_room").addKeyValue("enter_time", record.e()).addKeyValue("errorcode", i3).addKeyValue("errormsg", errorMsg).send();
        QLog.i(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "startReportEnterRoomTime:" + record.e() + " >>> " + record + ", errCode:" + i3 + ", errMsg:" + errorMsg);
    }

    public static final void f(@NotNull b record, int i3, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        a(record).a("ev_qq_live_first_frame").addKeyValue("first_frame_time", record.f()).addKeyValue("errorcode", i3).addKeyValue("errormsg", errorMsg).send();
        QLog.i(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "reportFirstFrameComTime:" + record.f() + " >>> " + record + ", errCode:" + i3 + ", errMsg:" + errorMsg);
    }

    public static final void g(@NotNull b record, int i3) {
        Intrinsics.checkNotNullParameter(record, "record");
        a(record).a("ev_qq_live_video_error").addKeyValue("video_error_no_callback", record.g()).addKeyValue("force_report", i3).send();
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(EnterRoomLogKt.TAG_ENTER_ROOM, 1, "startReportVideoLoadError:" + record.g() + " >>> " + record);
    }
}
