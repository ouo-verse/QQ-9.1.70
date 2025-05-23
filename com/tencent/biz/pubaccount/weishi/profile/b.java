package com.tencent.biz.pubaccount.weishi.profile;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J,\u0010\r\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J$\u0010\u0012\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0007J$\u0010\u0014\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0003J\u001c\u0010\u0015\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\u0016\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J,\u0010\u0019\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\tH\u0007J8\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001aj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0003J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000bH\u0003J@\u0010#\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\"\u001a\u00020\tH\u0007J@\u0010$\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\"\u001a\u00020\tH\u0007J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0002H\u0007J \u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0002H\u0007J\u0012\u0010)\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0003J\u001a\u0010+\u001a\u00020*2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0003J\u0018\u0010-\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\tH\u0003J\u0018\u00100\u001a\u00020\u00052\u0006\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u0002H\u0003J\u0010\u00101\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0003J\u0010\u00102\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0003J\u0012\u00103\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u00066"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/b;", "", "", "from", "ownerId", "", "t", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "followStatus", "", "isShowPraise", "l", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "k", "curFollowStatus", "o", "position", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "positionId", "actionId", "p", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", tl.h.F, "isHost", "i", "feedId", "tabType", "tagId", "y", HippyTKDListViewAdapter.X, "jumpType", "r", "isConfirm", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "Lcom/tencent/biz/pubaccount/weishi/report/WSStatisticsReporter$Builder;", "a", "requestScene", "b", "builder", AdMetricTag.EVENT_NAME, "c", "f", "d", "g", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f81279a = new b();

    b() {
    }

    @JvmStatic
    private static final WSStatisticsReporter.Builder a(String ownerId, String positionId) {
        WSStatisticsReporter.Builder addParams = b(j(ownerId), 10015).addParams("position", positionId).addParams("feed_id", "");
        if (ownerId == null) {
            ownerId = "";
        }
        WSStatisticsReporter.Builder addParams2 = addParams.addParams("owner_id", ownerId);
        Intrinsics.checkNotNullExpressionValue(addParams2, "createReportBuilder(isHo\u2026_OWNER_ID, ownerId ?: \"\")");
        return addParams2;
    }

    @JvmStatic
    private static final WSStatisticsReporter.Builder b(boolean isHost, int requestScene) {
        WSStatisticsReporter.Builder flush = new WSStatisticsReporter.Builder().setSopName(i(isHost)).setTestId(bb.x(requestScene)).setPushId(v.b().c()).setFlush(true);
        Intrinsics.checkNotNullExpressionValue(flush, "Builder()\n              \u2026          .setFlush(true)");
        return flush;
    }

    @JvmStatic
    private static final void c(WSStatisticsReporter.Builder builder, String eventName) {
        builder.build(eventName).report();
    }

    @JvmStatic
    private static final HashMap<String, String> e(String from, String ownerId) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("homepage_from", g(from));
        if (ownerId == null) {
            ownerId = "";
        }
        hashMap.put("owner_id", ownerId);
        return hashMap;
    }

    @JvmStatic
    public static final String h(String ownerId) {
        return i(j(ownerId));
    }

    @JvmStatic
    private static final boolean j(String ownerId) {
        boolean equals$default;
        equals$default = StringsKt__StringsJVMKt.equals$default(ownerId, bb.q(), false, 2, null);
        return equals$default;
    }

    @JvmStatic
    public static final void k(String ownerId) {
        WSStatisticsReporter.Builder builder = a(ownerId, "wesee_info").addParams("action_id", "1000001");
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }

    @JvmStatic
    public static final void l(String from, String ownerId, int followStatus, boolean isShowPraise) {
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        hashMap.put("btn_status", String.valueOf(followStatus));
        hashMap.put("tab_status", f(isShowPraise));
        WSStatisticsReporter.Builder builder = a(ownerId, "homepage_exp").addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_exposure");
    }

    @JvmStatic
    public static final void m(String from, String ownerId) {
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        WSStatisticsReporter.Builder builder = a(ownerId, "homepage_exp").addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_exposure");
    }

    @JvmStatic
    public static final void n(String from, String ownerId) {
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        WSStatisticsReporter.Builder builder = a(ownerId, "feedback").addParams("action_id", "1000001").addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }

    @JvmStatic
    public static final void o(String from, String ownerId, int curFollowStatus) {
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        hashMap.put("btn_status", String.valueOf(curFollowStatus));
        WSStatisticsReporter.Builder builder = a(ownerId, "follow").addParams("action_id", d(curFollowStatus)).addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }

    @JvmStatic
    public static final void p(String from, String positionId, String ownerId, int actionId) {
        Intrinsics.checkNotNullParameter(positionId, "positionId");
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        WSStatisticsReporter.Builder builder = a(ownerId, positionId).addParams("action_id", String.valueOf(actionId)).addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }

    @JvmStatic
    public static final void q(boolean isConfirm, boolean isHost, String jumpType) {
        String str;
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(jumpType, "jumpType");
        Pair[] pairArr = new Pair[2];
        if (isConfirm) {
            str = "1";
        } else {
            str = "2";
        }
        pairArr[0] = TuplesKt.to("btn_type", str);
        pairArr[1] = TuplesKt.to(QCircleSchemeAttr.WebView.OPEN_TYPE, jumpType);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        WSStatisticsReporter.Builder builder = b(isHost, 10019).addParams("position", "jump_weishi_btn").addParams("feed_id", "").addParams("owner_id", "").addParams("action_id", String.valueOf(isConfirm ? 1000003 : 1000001)).addExtParams(mapOf);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }

    @JvmStatic
    public static final void r(boolean isHost, String jumpType) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(jumpType, "jumpType");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(QCircleSchemeAttr.WebView.OPEN_TYPE, jumpType));
        WSStatisticsReporter.Builder builder = b(isHost, 10019).addParams("position", "jump_weishi").addParams("feed_id", "").addParams("owner_id", "").addExtParams(mapOf);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_exposure");
    }

    @JvmStatic
    public static final void s(String from, String ownerId) {
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        WSStatisticsReporter.Builder builder = a(ownerId, "more_operations").addParams("action_id", "1000001").addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }

    @JvmStatic
    public static final void t(String from, String ownerId) {
        WSPublicAccReport.getInstance().reportPageVisitEnter(h(ownerId), e(from, ownerId));
    }

    @JvmStatic
    public static final void u(String from, String ownerId) {
        WSPublicAccReport.getInstance().reportPageVisitExit(h(ownerId), e(from, ownerId));
    }

    @JvmStatic
    public static final void v(String from, String ownerId) {
        w(from, ownerId, "like_tab");
    }

    @JvmStatic
    private static final void w(String from, String ownerId, String position) {
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        WSStatisticsReporter.Builder builder = a(ownerId, position).addParams("action_id", "1000001").addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }

    @JvmStatic
    public static final void x(String from, String positionId, String feedId, String ownerId, String tabType, int tagId) {
        Intrinsics.checkNotNullParameter(positionId, "positionId");
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        if (tabType == null) {
            tabType = "";
        }
        hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, tabType);
        hashMap.put("tag_id", String.valueOf(tagId));
        WSStatisticsReporter.Builder builder = b(j(ownerId), 10019).addParams("position", positionId).addParams("feed_id", feedId).addParams("owner_id", ownerId).addParams("action_id", "1000001").addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }

    @JvmStatic
    public static final void y(String from, String positionId, String feedId, String ownerId, String tabType, int tagId) {
        Intrinsics.checkNotNullParameter(positionId, "positionId");
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", g(from));
        if (tabType == null) {
            tabType = "";
        }
        hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, tabType);
        hashMap.put("tag_id", String.valueOf(tagId));
        WSStatisticsReporter.Builder builder = b(j(ownerId), 10019).addParams("position", positionId).addParams("feed_id", feedId).addParams("owner_id", ownerId).addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_exposure");
    }

    @JvmStatic
    public static final void z(String from, String ownerId) {
        w(from, ownerId, "works_tab");
    }

    @JvmStatic
    private static final String f(boolean isShowPraise) {
        if (isShowPraise) {
            return "1";
        }
        return "0";
    }

    @JvmStatic
    public static final String g(String from) {
        if (from != null) {
            switch (from.hashCode()) {
                case -1849961962:
                    if (from.equals("my_profile")) {
                        return "3";
                    }
                    return "";
                case -1283821122:
                    if (from.equals("msg_fans")) {
                        return "10";
                    }
                    return "";
                case -1283634795:
                    if (from.equals("msg_like")) {
                        return "9";
                    }
                    return "";
                case -1209335648:
                    if (from.equals("qq_schema")) {
                        return "4";
                    }
                    return "";
                case -874136537:
                    if (from.equals("msg_section")) {
                        return "11";
                    }
                    return "";
                case -694359057:
                    if (from.equals("at_nick")) {
                        return "5";
                    }
                    return "";
                case -596386102:
                    if (from.equals("slide_enter")) {
                        return "1";
                    }
                    return "";
                case 108417:
                    if (from.equals("msg")) {
                        return "7";
                    }
                    return "";
                case 3343801:
                    if (from.equals("main")) {
                        return "6";
                    }
                    return "";
                case 193277936:
                    if (from.equals("click_avatar")) {
                        return "2";
                    }
                    return "";
                default:
                    return "";
            }
        }
        return "";
    }

    @JvmStatic
    private static final String i(boolean isHost) {
        if (isHost) {
            return "homepage_main";
        }
        return "homepage_guest";
    }

    @JvmStatic
    private static final String d(int curFollowStatus) {
        if (curFollowStatus != 1 && curFollowStatus != 3) {
            return "1004001";
        }
        return "1004002";
    }
}
