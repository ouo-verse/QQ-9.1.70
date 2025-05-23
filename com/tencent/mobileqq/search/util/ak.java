package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0007J4\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007Jz\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0014H\u0007\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/search/util/ak;", "", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "a", "", "tag", "errorMsg", "b", "message", "f", "cmd", "", "time", "", "errorCode", "word", "", "isExactSearch", "c", "start", "end", "reqTab", "endReqTab", "reqCtx", "endReqCtx", "reqGps", "endReqGps", "isFromActivePage", "renderCost", "isSucc", "e", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ak f285002a = new ak();

    ak() {
    }

    @JvmStatic
    public static final void a(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res) {
        if (req != null && res != null) {
            long j3 = req.extraData.getLong(ISearchReportApi.KEY_SEND_REQ_TIME);
            if (j3 <= 0) {
                return;
            }
            String uin = req.getUin();
            long currentTimeMillis = System.currentTimeMillis() - j3;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("eventCode", "troop_recommend_search_request_quality");
            linkedHashMap.put("duration", String.valueOf(currentTimeMillis));
            linkedHashMap.put("errorCode", String.valueOf(res.getResultCode()));
            String serviceCmd = req.getServiceCmd();
            Intrinsics.checkNotNullExpressionValue(serviceCmd, "req.serviceCmd");
            linkedHashMap.put("name", serviceCmd);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            linkedHashMap.put("uin", uin);
            QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", uin, "troop_recommend_search_request_quality", true, linkedHashMap, true);
            if (QLog.isColorLevel()) {
                QLog.i("SearchPerformanceUtil", 2, "troop_recommend_search_request_quality baseReport data:" + linkedHashMap);
            }
        }
    }

    @JvmStatic
    public static final void b(@Nullable String tag, @Nullable String errorMsg) {
        if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(errorMsg)) {
            String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("eventCode", "event_search_error_message");
            Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
            linkedHashMap.put("uin", currentUin);
            linkedHashMap.put("type", "1");
            linkedHashMap.put("tag", String.valueOf(tag));
            linkedHashMap.put("message", String.valueOf(errorMsg));
            QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentUin, "event_search_error_message", true, linkedHashMap, true);
        }
    }

    @JvmStatic
    public static final void c(@NotNull String cmd, long time, int errorCode, @NotNull String word, boolean isExactSearch) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(word, "word");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("eventCode", "ktv_page_request_quality");
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        linkedHashMap.put("uin", currentUin);
        linkedHashMap.put("pageName", "qsearch_detail_native");
        linkedHashMap.put("cmdName", cmd);
        linkedHashMap.put("duration", String.valueOf(time));
        linkedHashMap.put("errorCode", String.valueOf(errorCode));
        linkedHashMap.put("isExactSearch", String.valueOf(isExactSearch));
        linkedHashMap.put("word", word);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("SearchPerformanceUtil", 2, " report reportNetQuality: " + linkedHashMap);
        }
        QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentUin, "ktv_page_request_quality", true, linkedHashMap, true);
    }

    public static /* synthetic */ void d(String str, long j3, int i3, String str2, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i16 & 16) != 0) {
            z16 = false;
        }
        c(str, j3, i3, str3, z16);
    }

    @JvmStatic
    public static final void e(long start, long end, @NotNull String word, long reqTab, long endReqTab, long reqCtx, long endReqCtx, long reqGps, long endReqGps, boolean isFromActivePage, long renderCost, boolean isSucc) {
        Intrinsics.checkNotNullParameter(word, "word");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("eventCode", "kuikly_net_search");
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        linkedHashMap.put("uin", currentUin);
        linkedHashMap.put("app_env", String.valueOf(2));
        linkedHashMap.put("search_start", String.valueOf(start));
        linkedHashMap.put("result_show", String.valueOf(end));
        linkedHashMap.put("cost_in_total", String.valueOf(end - start));
        linkedHashMap.put("lbs_cost", String.valueOf(endReqGps - reqGps));
        linkedHashMap.put("lbs_start_timestamp", String.valueOf(reqGps));
        linkedHashMap.put("lbs_end_timestamp", String.valueOf(endReqGps));
        linkedHashMap.put("keyword", word);
        linkedHashMap.put("tab_req_start_timestamp", String.valueOf(reqTab));
        linkedHashMap.put("tab_req_end_timestamp", String.valueOf(endReqTab));
        linkedHashMap.put("tab_req_cost", String.valueOf(endReqTab - reqTab));
        linkedHashMap.put("ctx_req_start_timestamp", String.valueOf(reqCtx));
        linkedHashMap.put("ctx_req_end_timestamp", String.valueOf(endReqCtx));
        linkedHashMap.put("ctx_req_cost", String.valueOf(endReqCtx - reqCtx));
        linkedHashMap.put("is_from_active_page", String.valueOf(isFromActivePage));
        linkedHashMap.put("render_cost", String.valueOf(renderCost));
        linkedHashMap.put("is_native", "true");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("SearchPerformanceUtil", 2, " report Search detail: " + linkedHashMap);
        }
        QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentUin, "kuikly_net_search", isSucc, linkedHashMap, true);
    }

    @JvmStatic
    public static final void f(@Nullable String tag, @Nullable String message) {
        if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(message)) {
            String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("eventCode", "event_search_error_message");
            Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
            linkedHashMap.put("uin", currentUin);
            linkedHashMap.put("tag", String.valueOf(tag));
            linkedHashMap.put("type", "2");
            linkedHashMap.put("message", String.valueOf(message));
            QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentUin, "event_search_error_message", true, linkedHashMap, true);
        }
    }
}
