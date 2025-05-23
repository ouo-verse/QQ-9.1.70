package com.tencent.biz.qqcircle.immersive.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoReporter;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static volatile h f87227d;

    /* renamed from: a, reason: collision with root package name */
    private String f87228a;

    /* renamed from: b, reason: collision with root package name */
    private String f87229b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f87230c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            h.this.f(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            h.this.g(intent);
        }
    }

    h() {
        m();
    }

    private List<FeedCloudCommon$Entry> c(RFWPlayerOptions rFWPlayerOptions, List<FeedCloudCommon$Entry> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(QCircleReportHelper.newEntry("video_url", rFWPlayerOptions.getRealPlayUrl()));
        return arrayList;
    }

    private String d(List<FeedCloudCommon$Entry> list, String str, String str2) {
        if (list != null && !list.isEmpty()) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if (TextUtils.equals(feedCloudCommon$Entry.key.get(), str) && !TextUtils.isEmpty(feedCloudCommon$Entry.value.get())) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return str2;
    }

    private String e(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return String.valueOf(new JSONObject(str).get(str2));
            } catch (JSONException unused) {
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Intent intent) {
        if (intent == null) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[handlerHodorBroadcastReceive] intent == null.");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[handlerHodorBroadcastReceive] extras == null.");
            return;
        }
        String string = extras.getString("caseName");
        RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[handlerHodorBroadcastReceive] testCaseName: " + string);
        this.f87228a = string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Intent intent) {
        if (intent == null) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[handlerPrefdogBroadcastReceive] intent == null.");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[handlerPrefdogBroadcastReceive] extras == null.");
            return;
        }
        String string = extras.getString("caseName");
        String string2 = extras.getString("archive_url");
        RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[handlerPrefdogBroadcastReceive] testCaseName: " + string + " | archiveUrl: " + string2);
        this.f87228a = string;
        this.f87229b = string2;
    }

    public static h i() {
        if (f87227d == null) {
            synchronized (h.class) {
                if (f87227d == null) {
                    f87227d = new h();
                }
            }
        }
        return f87227d;
    }

    private boolean j() {
        return false;
    }

    private String k(int i3, long j3, int i16, int i17, int i18) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("test_name", this.f87228a);
            jSONObject.put(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER, i3);
            jSONObject.put("second_buffering_time", j3);
            jSONObject.put("second_buffering_count", i16);
            jSONObject.put("drop_frame_rate", i17);
            jSONObject.put("play_error_code", i18);
            jSONObject.put("archive_url", this.f87229b);
        } catch (Throwable th5) {
            RFWLog.e("QFSTestPerformanceManager", RFWLog.USR, "[updateVideoReporterError] e:", th5);
        }
        return jSONObject.toString();
    }

    private String l(List<FeedCloudCommon$Entry> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                sb5.append(feedCloudCommon$Entry.key.get());
                sb5.append(":");
                sb5.append(feedCloudCommon$Entry.value.get());
                sb5.append(", ");
            }
            return sb5.toString();
        }
        RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[obtainReportEntryStr] list should not be null.");
        return "";
    }

    private void m() {
        if (!j() || this.f87230c) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        a aVar = new a();
        intentFilter.addAction("circle_hodor_collect_command");
        RFWApplication.getApplication().registerReceiver(aVar, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        b bVar = new b();
        intentFilter2.addAction("circle_prefdog_collect_command");
        RFWApplication.getApplication().registerReceiver(bVar, intentFilter2);
        this.f87230c = true;
    }

    private void n(RFWPlayerOptions rFWPlayerOptions, long j3, RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        Object obj;
        String str = "0";
        String l3 = AppSetting.l();
        JSONObject jSONObject = new JSONObject();
        boolean hitPreloadCache = rFWPlayerOptions.hitPreloadCache();
        boolean hasPreLoadPlayer = rFWPlayerOptions.hasPreLoadPlayer();
        try {
            int parseFloat = (int) (Float.parseFloat(d(list, "time_cost", "0")) * 1000.0f);
            jSONObject.put("git_commit_id", l3);
            jSONObject.put("test_name", this.f87228a);
            if (!hitPreloadCache) {
                obj = "0";
            } else {
                obj = "1";
            }
            jSONObject.put("is_hit_pre_download", obj);
            if (hasPreLoadPlayer) {
                str = "1";
            }
            jSONObject.put("is_hit_pre_render", str);
            jSONObject.put(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER, parseFloat);
        } catch (Throwable th5) {
            RFWLog.e("QFSTestPerformanceManager", RFWLog.USR, "[updateFirstBufferTime] e: ", th5);
        }
        o(rFWPlayerOptions, "event_video_first_buffer", j3, jSONObject.toString(), rFWPlayerReportInfo, list);
    }

    private void o(RFWPlayerOptions rFWPlayerOptions, String str, long j3, String str2, RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        if (!j()) {
            return;
        }
        if (TextUtils.isEmpty(this.f87228a)) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[reportHodorPlayerFastScrollQuality] " + str + " test is null, not report!!!");
            return;
        }
        if (!TextUtils.equals("video_test_fast_scroll", this.f87228a)) {
            return;
        }
        RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[reportHodorPlayerFastScrollQuality] tag: " + rFWPlayerOptions.tag() + " | event: " + str + " | feedId: " + rFWPlayerReportInfo.getFeedId() + " | videoPlayId: " + j3 + " | info: " + l(list) + " | jsonStr: " + str2);
        List<FeedCloudCommon$Entry> c16 = c(rFWPlayerOptions, list);
        c16.add(QCircleReportHelper.newEntry("attach_info", str2));
        RFWVideoReporter.getInstance().report(j3, "video_hodor_player_fast_scroll_quality", rFWPlayerReportInfo, c16);
    }

    private void p(RFWPlayerOptions rFWPlayerOptions, String str, long j3, String str2, RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        if (!j()) {
            return;
        }
        if (TextUtils.isEmpty(this.f87228a)) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[reportPrefdogPlayerSlowScrollQuality] " + str + " test is null, not report!!!");
            return;
        }
        if (!TextUtils.equals("video_test_slow_scroll_1", this.f87228a) && !TextUtils.equals("video_test_slow_scroll_2", this.f87228a)) {
            return;
        }
        RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[reportPrefdogPlayerSlowScrollQuality] tag: " + rFWPlayerOptions.tag() + " | event: " + str + " | feedId: " + rFWPlayerReportInfo.getFeedId() + " | videoPlayId: " + j3 + " | info: " + l(list) + " | jsonStr: " + str2);
        List<FeedCloudCommon$Entry> c16 = c(rFWPlayerOptions, list);
        c16.add(QCircleReportHelper.newEntry("attach_info", str2));
        RFWVideoReporter.getInstance().report(j3, "video_prefdog_player_slow_scroll_quality", rFWPlayerReportInfo, c16);
    }

    public void h() {
        m();
    }

    public void q(RFWPlayerOptions rFWPlayerOptions, long j3, RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        if (rFWPlayerReportInfo == null || rFWPlayerOptions == null || list == null || TextUtils.isEmpty(rFWPlayerOptions.getFileId())) {
            return;
        }
        if (TextUtils.equals(this.f87228a, "video_test_fast_scroll")) {
            n(rFWPlayerOptions, j3, rFWPlayerReportInfo, list);
        } else if (TextUtils.equals(this.f87228a, "video_test_slow_scroll_1") || TextUtils.equals(this.f87228a, "video_test_slow_scroll_2")) {
            p(rFWPlayerOptions, "event_video_first_buffer", j3, k((int) (Float.parseFloat(d(list, "time_cost", String.valueOf(0))) * 1000.0f), 0L, 0, 0, 0), rFWPlayerReportInfo, list);
        }
    }

    public void r(RFWPlayerOptions rFWPlayerOptions, long j3, RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        if (rFWPlayerReportInfo == null) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[updateSecondBufferTime] info should not be null.");
        } else {
            p(rFWPlayerOptions, "event_second_buffer_time", j3, k(0, Integer.parseInt(d(list, "time_cost", String.valueOf(0))) * 1000, Integer.parseInt(d(list, "buffer_count", String.valueOf(0))), 0, 0), rFWPlayerReportInfo, list);
        }
    }

    public void s(RFWPlayerOptions rFWPlayerOptions, long j3, RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        if (rFWPlayerReportInfo == null) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[updateVideoDropFrame] info should not be null.");
            return;
        }
        int parseInt = Integer.parseInt(d(list, "dropFrame", String.valueOf(0)));
        if (parseInt <= 0) {
            return;
        }
        p(rFWPlayerOptions, "event_video_drop_frame", j3, k(0, 0L, 0, parseInt, 0), rFWPlayerReportInfo, list);
    }

    public void t(RFWPlayerOptions rFWPlayerOptions, long j3, RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        int i3 = 0;
        if (rFWPlayerReportInfo == null) {
            RFWLog.d("QFSTestPerformanceManager", RFWLog.USR, "[updateVideoReporterError] info should not be null.");
            return;
        }
        String d16 = d(list, "attach_info", "");
        if (!TextUtils.isEmpty(d16)) {
            i3 = Integer.parseInt(e(d16, "errorCode"));
        }
        p(rFWPlayerOptions, "event_video_reporter_error", j3, k(0, 0L, 0, 0, i3), rFWPlayerReportInfo, list);
    }
}
