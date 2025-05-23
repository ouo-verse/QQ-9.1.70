package com.tencent.mobileqq.zplan.cc.util;

import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/b;", "", "", "b", "d", "a", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/zplan/cc/util/Event;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "map", "", "Ljava/lang/String;", "getOutFrom", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "outFrom", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Event, Long> map = new HashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String outFrom = "";

    public final void a() {
        HashMap<Event, Long> hashMap = this.map;
        Event event = Event.TAKE_PICTURE;
        if (hashMap.get(event) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.map.put(Event.FIRST_THUMB, Long.valueOf(currentTimeMillis));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.outFrom);
        Long l3 = this.map.get(event);
        Intrinsics.checkNotNull(l3);
        linkedHashMap.put("zplan_loading_lvtm", Long.valueOf(currentTimeMillis - l3.longValue()));
        VideoReport.reportEvent("ev_zplan_first_template_loading_success", linkedHashMap);
    }

    public final void b() {
        this.map.clear();
        this.map.put(Event.INIT, Long.valueOf(System.currentTimeMillis()));
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.outFrom = str;
    }

    public final void d() {
        HashMap<Event, Long> hashMap = this.map;
        Event event = Event.INIT;
        if (hashMap.get(event) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.map.put(Event.TAKE_PICTURE, Long.valueOf(currentTimeMillis));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.outFrom);
        linkedHashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        Long l3 = this.map.get(event);
        Intrinsics.checkNotNull(l3);
        linkedHashMap.put("zplan_loading_lvtm", Long.valueOf(currentTimeMillis - l3.longValue()));
        VideoReport.reportEvent("ev_zplan_sculpt_identify_success", linkedHashMap);
    }
}
