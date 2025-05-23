package lg;

import com.qzone.common.account.LoginData;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFriendFeedManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.report.QZonePushReporter;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\"\u0010\u000e\u001a\u00020\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\tH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0016J\"\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u001f\u001a\u00020\u0004J \u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00122\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tJ\u001e\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00122\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\tJ\u0006\u0010#\u001a\u00020\u0002R\u0016\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010&\u00a8\u0006*"}, d2 = {"Llg/g;", "", "", "msg", "", "f", "", "d", "e", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedDataList", "Lorg/json/JSONObject;", "eventValue", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", DomainData.DOMAIN_NAME, "b", "", "time", "k", "j", "", "o", "forceRefresh", "Lcom/qzone/feed/business/service/QZoneFeedService;", "curFeedService", "", "pushTransChannel", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "duration", tl.h.F, "g", "c", "J", "sFriendFeedLastTime", "Ljava/lang/String;", "mRefreshId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static long sFriendFeedLastTime;

    /* renamed from: a, reason: collision with root package name */
    public static final g f414459a = new g();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String mRefreshId = "";

    g() {
    }

    private final String b() {
        return LoginData.getInstance().getUinString() + "_" + System.currentTimeMillis();
    }

    private final int d() {
        int m3;
        gd.a aVar = gd.a.f401926a;
        if (aVar.b() && (m3 = aVar.a("KEY_FEED_REFRESH_INTERVAL_HAS_PASSIVE", 0)) > 0) {
            RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "getRefreshIntervalWhenHasPassive debug value: " + m3);
        } else {
            m3 = com.qzone.reborn.configx.g.f53821a.l().m();
        }
        return m3 * 1000;
    }

    private final int e() {
        int n3;
        gd.a aVar = gd.a.f401926a;
        if (aVar.b() && (n3 = aVar.a("KEY_FEED_REFRESH_INTERVAL_NO_PASSIVE", 0)) > 0) {
            RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "getRefreshIntervalWhenNoPassive debug value: " + n3);
        } else {
            n3 = com.qzone.reborn.configx.g.f53821a.l().n();
        }
        return n3 * 1000;
    }

    private final void f(String msg2) {
        RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "do refresh because of " + msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        u5.c.I("friendfeeddestorytime", sFriendFeedLastTime, LoginData.getInstance().getUin());
    }

    private final void n(JSONObject eventValue, List<CommonFeed> feedDataList) {
        CharSequence removeSuffix;
        CharSequence removeSuffix2;
        if (feedDataList.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            Iterator<T> it = feedDataList.iterator();
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                CommonFeed commonFeed = (CommonFeed) next;
                String l3 = yd.b.l(xd.c.h(commonFeed));
                if (l3.length() > 0) {
                    sb6.append(l3);
                    sb6.append("|");
                    sb6.append(i3);
                    sb6.append("#");
                } else {
                    if (CommonFeedExtKt.getFeedUniqueKey(commonFeed).length() <= 0) {
                        z16 = false;
                    }
                    if (z16) {
                        sb5.append(CommonFeedExtKt.getFeedUniqueKey(commonFeed));
                        sb5.append("|");
                        sb5.append(i3);
                        sb5.append("#");
                    }
                }
                i3 = i16;
            }
            if (sb5.length() > 0) {
                removeSuffix2 = StringsKt__StringsKt.removeSuffix(sb5, "#");
                eventValue.put("ugc_id", removeSuffix2);
            }
            if (sb6.length() > 0) {
                removeSuffix = StringsKt__StringsKt.removeSuffix(sb6, "#");
                eventValue.put("trace_id", removeSuffix);
            }
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneFriendFeedxRefreshManager", RFWLog.USR, th5);
        }
    }

    public final String c() {
        return mRefreshId;
    }

    public final void g(long duration, List<CommonFeed> feedDataList) {
        Intrinsics.checkNotNullParameter(feedDataList, "feedDataList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_feed");
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE2, "refresh");
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE3, "response");
        String i3 = com.tencent.open.adapter.a.f().i();
        Intrinsics.checkNotNullExpressionValue(i3, "getInstance().getQUA3()");
        linkedHashMap.put("qua", i3);
        linkedHashMap.put(QZoneDTLoginReporter.PAGE_STYLE, Integer.valueOf(com.qzone.reborn.feedpro.utils.d.f54318a.b() ? 1 : 0));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("refresh_id", mRefreshId);
        jSONObject.put("request_duration", duration);
        n(jSONObject, feedDataList);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "eventValue.toString()");
        linkedHashMap.put(QZonePushReporter.EVENT_VALUE, jSONObject2);
        fo.c.c("ev_qz_feed_refresh_response", linkedHashMap);
    }

    public final void h(long duration, List<? extends BusinessFeedData> feedDataList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_feed");
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE2, "refresh");
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE3, "response");
        String i3 = com.tencent.open.adapter.a.f().i();
        Intrinsics.checkNotNullExpressionValue(i3, "getInstance().getQUA3()");
        linkedHashMap.put("qua", i3);
        linkedHashMap.put(QZoneDTLoginReporter.PAGE_STYLE, Integer.valueOf(com.qzone.reborn.feedpro.utils.d.f54318a.b() ? 1 : 0));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("refresh_id", mRefreshId);
        jSONObject.put("request_duration", duration);
        m(feedDataList, jSONObject);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "eventValue.toString()");
        linkedHashMap.put(QZonePushReporter.EVENT_VALUE, jSONObject2);
        fo.c.c("ev_qz_feed_refresh_response", linkedHashMap);
    }

    public final void i() {
        mRefreshId = b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_feed");
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE2, "refresh");
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE3, Const.BUNDLE_KEY_REQUEST);
        String i3 = com.tencent.open.adapter.a.f().i();
        Intrinsics.checkNotNullExpressionValue(i3, "getInstance().getQUA3()");
        linkedHashMap.put("qua", i3);
        linkedHashMap.put(QZoneDTLoginReporter.PAGE_STYLE, Integer.valueOf(com.qzone.reborn.feedpro.utils.d.f54318a.b() ? 1 : 0));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("refresh_id", mRefreshId);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "eventValue.toString()");
        linkedHashMap.put(QZonePushReporter.EVENT_VALUE, jSONObject2);
        fo.c.c("ev_qz_feed_refresh_request", linkedHashMap);
    }

    public final void k(long time) {
        sFriendFeedLastTime = time;
        if (com.qzone.reborn.configx.g.f53821a.l().o()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: lg.f
            @Override // java.lang.Runnable
            public final void run() {
                g.l();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[Catch: all -> 0x00bb, TRY_ENTER, TryCatch #0 {all -> 0x00bb, blocks: (B:5:0x000a, B:6:0x001c, B:9:0x0026, B:11:0x002e, B:12:0x0031, B:14:0x0039, B:16:0x003f, B:23:0x0058, B:27:0x006b, B:29:0x0071, B:35:0x0080, B:43:0x0092, B:47:0x009d, B:48:0x00a7, B:52:0x00b0), top: B:4:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080 A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:5:0x000a, B:6:0x001c, B:9:0x0026, B:11:0x002e, B:12:0x0031, B:14:0x0039, B:16:0x003f, B:23:0x0058, B:27:0x006b, B:29:0x0071, B:35:0x0080, B:43:0x0092, B:47:0x009d, B:48:0x00a7, B:52:0x00b0), top: B:4:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m(List<? extends BusinessFeedData> feedDataList, JSONObject eventValue) {
        CharSequence removeSuffix;
        CharSequence removeSuffix2;
        boolean z16;
        String a16;
        String traceId;
        if (feedDataList == null || feedDataList.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            Iterator<T> it = feedDataList.iterator();
            int i3 = 0;
            while (true) {
                boolean z17 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                BusinessFeedData businessFeedData = (BusinessFeedData) next;
                GdtAd E = GdtFeedUtilForQZone.E(businessFeedData);
                if (E != null && (traceId = E.getTraceId()) != null) {
                    Intrinsics.checkNotNullExpressionValue(traceId, "traceId");
                    if (traceId.length() > 0) {
                        z16 = true;
                        if (z16) {
                            if (businessFeedData != null && (a16 = ef.b.a(businessFeedData)) != null) {
                                if (a16.length() > 0) {
                                    if (!z17) {
                                        sb5.append(ef.b.a(businessFeedData));
                                        sb5.append("|");
                                        sb5.append(i3);
                                        sb5.append("#");
                                    }
                                }
                            }
                            z17 = false;
                            if (!z17) {
                            }
                        } else {
                            sb6.append(E.getTraceId());
                            sb6.append("|");
                            sb6.append(i3);
                            sb6.append("#");
                        }
                        i3 = i16;
                    }
                }
                z16 = false;
                if (z16) {
                }
                i3 = i16;
            }
            if (sb5.length() > 0) {
                removeSuffix2 = StringsKt__StringsKt.removeSuffix(sb5, "#");
                eventValue.put("ugc_id", removeSuffix2);
            }
            if (sb6.length() > 0) {
                removeSuffix = StringsKt__StringsKt.removeSuffix(sb6, "#");
                eventValue.put("trace_id", removeSuffix);
            }
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneFriendFeedxRefreshManager", RFWLog.USR, th5);
        }
    }

    public final void j() {
        sFriendFeedLastTime = 0L;
    }

    public final boolean o() {
        return p(false, null, null);
    }

    public final boolean p(boolean forceRefresh, QZoneFeedService curFeedService, byte[] pushTransChannel) {
        if (forceRefresh) {
            f("forceRefresh");
            return true;
        }
        if (curFeedService != null && !curFeedService.f0()) {
            f("has no cache");
            return true;
        }
        if (pushTransChannel != null) {
            f("pushTransChannel != null");
            return true;
        }
        if (sFriendFeedLastTime <= 0 && com.qzone.reborn.configx.g.f53821a.l().o()) {
            f("sFriendFeedLastTime <= 0");
            return true;
        }
        dh.d dVar = dh.d.f393812a;
        if (dVar.E()) {
            f("has active red dot");
            return true;
        }
        if (u5.c.n(LoginData.getInstance().getUinString())) {
            u5.c.R(LoginData.getInstance().getUinString(), false);
            f("has share action");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - sFriendFeedLastTime;
        if (dVar.F()) {
            int d16 = d();
            if (currentTimeMillis > d16) {
                f("has passive red dot, and interval: " + currentTimeMillis + " > " + d16);
                return true;
            }
            RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "don't need refresh, has passive, timeInternal: " + currentTimeMillis);
        } else {
            if (!com.qzone.reborn.configx.g.f53821a.l().o()) {
                sFriendFeedLastTime = u5.c.m("friendfeeddestorytime", sFriendFeedLastTime, LoginData.getInstance().getUin());
                currentTimeMillis = System.currentTimeMillis() - sFriendFeedLastTime;
            }
            int e16 = e();
            if (currentTimeMillis > e16) {
                f("no passive red dot, but interval: " + currentTimeMillis + " > " + e16);
                return true;
            }
            RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "don't need refresh, has no passive, timeInternal: " + currentTimeMillis);
        }
        RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "don't need refresh");
        return false;
    }

    public final boolean q(boolean forceRefresh) {
        if (forceRefresh) {
            f("forceRefresh");
            return true;
        }
        if (!QzoneFriendFeedManager.INSTANCE.hasFeedMemoryCache()) {
            f("has no cache");
            return true;
        }
        if (sFriendFeedLastTime <= 0 && com.qzone.reborn.configx.g.f53821a.l().o()) {
            f("sFriendFeedLastTime <= 0");
            return true;
        }
        dh.d dVar = dh.d.f393812a;
        if (dVar.E()) {
            f("has active red dot");
            return true;
        }
        if (u5.c.n(LoginData.getInstance().getUinString())) {
            u5.c.R(LoginData.getInstance().getUinString(), false);
            f("has share action");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - sFriendFeedLastTime;
        if (dVar.F()) {
            int d16 = d();
            if (currentTimeMillis > d16) {
                f("has passive red dot, and interval: " + currentTimeMillis + " > " + d16);
                return true;
            }
            RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "don't need refresh, has passive, timeInternal: " + currentTimeMillis);
        } else {
            if (!com.qzone.reborn.configx.g.f53821a.l().o()) {
                sFriendFeedLastTime = u5.c.m("friendfeeddestorytime", sFriendFeedLastTime, LoginData.getInstance().getUin());
                currentTimeMillis = System.currentTimeMillis() - sFriendFeedLastTime;
            }
            int e16 = e();
            if (currentTimeMillis > e16) {
                f("no passive red dot, but interval: " + currentTimeMillis + " > " + e16);
                return true;
            }
            RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "don't need refresh, has no passive, timeInternal: " + currentTimeMillis);
        }
        RFWLog.i("QZoneFriendFeedxRefreshManager", RFWLog.USR, "don't need refresh");
        return false;
    }
}
