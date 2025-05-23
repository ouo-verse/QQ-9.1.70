package com.tencent.mobileqq.guild.performance.report;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.event.GuildFeedDetailReportEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u00c7\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bJ\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a`\u001bH\u0016J\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0006R\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010(\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/w;", "Lcom/tencent/mobileqq/guild/performance/report/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/event/GuildFeedDetailReportEvent;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", tl.h.F, "", "startTime", "o", "", "to", "logTime", "k", AdMetricTag.EVENT_NAME, "l", "linkEndTime", "isColdStart", "j", "b", "d", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "i", "isAlive", DomainData.DOMAIN_NAME, "J", "linkStartTime", BdhLogUtil.LogTag.Tag_Conn, "lastTimestamp", "D", "Ljava/lang/String;", "fromMsg", "E", "Z", "isAliveToolsProcess", UserInfo.SEX_FEMALE, "isFirstOpen", "G", "isLinking", "H", "shouldCheck", "I", "isStarting", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes14.dex */
public final class w extends b implements SimpleEventReceiver<GuildFeedDetailReportEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    private static boolean isAliveToolsProcess;

    /* renamed from: G, reason: from kotlin metadata */
    private static boolean isLinking;

    /* renamed from: H, reason: from kotlin metadata */
    private static boolean shouldCheck;

    /* renamed from: I, reason: from kotlin metadata */
    private static boolean isStarting;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static long linkStartTime;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final w f231064i = new w();

    /* renamed from: C, reason: from kotlin metadata */
    private static long lastTimestamp = System.currentTimeMillis();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private static String fromMsg = "";

    /* renamed from: F, reason: from kotlin metadata */
    private static boolean isFirstOpen = true;

    w() {
    }

    private final boolean h() {
        boolean z16;
        if (isStarting && (((z16 = shouldCheck) && isLinking) || !z16)) {
            return true;
        }
        return false;
    }

    private final void m() {
        isStarting = false;
        isLinking = false;
        shouldCheck = false;
        isAliveToolsProcess = false;
        i();
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    @NotNull
    public String b() {
        return "GuildPublicPushToDetailFullLinkReport";
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    @NotNull
    public String d() {
        return "gpro_quality#event#public_push_to_detail";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildFeedDetailReportEvent>> getEventClass() {
        ArrayList<Class<GuildFeedDetailReportEvent>> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedDetailReportEvent.class);
        return arrayList;
    }

    public final void i() {
        lastTimestamp = System.currentTimeMillis();
        fromMsg = "";
    }

    public final void j(long linkEndTime, boolean isColdStart) {
        HashMap<String, String> hashMapOf;
        if (!h()) {
            return;
        }
        long j3 = linkStartTime;
        long j16 = 0;
        if (linkEndTime - j3 > 0) {
            j16 = linkEndTime - j3;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("end_time", String.valueOf(linkEndTime)), TuplesKt.to("link_trip_time", String.valueOf(j16)), TuplesKt.to("is_cold_start", String.valueOf(isColdStart)), TuplesKt.to("tools_process_alive", String.valueOf(isAliveToolsProcess)), TuplesKt.to("is_first_open_detail", String.valueOf(isFirstOpen)));
        e("event_link_end", hashMapOf);
        endTask();
        isFirstOpen = false;
        m();
    }

    public final void k(@NotNull String to5, long logTime) {
        Intrinsics.checkNotNullParameter(to5, "to");
        if (!h()) {
            return;
        }
        lastTimestamp = logTime;
        fromMsg = to5;
    }

    public final void l(@NotNull String eventName, @NotNull String to5, long logTime) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(to5, "to");
        if (h()) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("from", fromMsg), TuplesKt.to("to", to5), TuplesKt.to("trip_time", String.valueOf(logTime - lastTimestamp)));
            e(eventName, hashMapOf);
            lastTimestamp = logTime;
            fromMsg = to5;
        }
    }

    public final void n(boolean isAlive) {
        isAliveToolsProcess = isAlive;
    }

    public final void o(long startTime) {
        HashMap<String, String> hashMapOf;
        m();
        c();
        linkStartTime = startTime;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("start_time", String.valueOf(startTime)));
        a(hashMapOf);
        e("event_link_start", hashMapOf);
        SimpleEventBus.getInstance().registerReceiver(this);
        isStarting = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (h() && (event instanceof GuildFeedDetailReportEvent)) {
            ((GuildFeedDetailReportEvent) event).logEvent();
        }
    }
}
