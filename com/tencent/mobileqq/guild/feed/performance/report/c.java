package com.tencent.mobileqq.guild.feed.performance.report;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedReportBean;
import com.tencent.mobileqq.guild.feed.event.GuildDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedReportEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001f\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007JL\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007J8\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0011H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001c0\u001bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001c`\u001dH\u0016R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedReportEvent;", "Lcom/tencent/mobileqq/guild/feed/performance/report/d;", "initData", "", "e", "d", "", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraInfo", "", "errCode", "errMsg", "a", "", "map", "g", "", "c", "", "state", "f", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "com/tencent/mobileqq/guild/feed/performance/report/c$b", "Lcom/tencent/mobileqq/guild/feed/performance/report/c$b;", "destroyWebViewReceiver", "Lcom/tencent/mobileqq/guild/feed/performance/report/c$a;", "Lcom/tencent/mobileqq/guild/feed/performance/report/c$a;", "curReportBean", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements SimpleEventReceiver<GuildFeedReportEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f222706d = new c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b destroyWebViewReceiver = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a curReportBean;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u00020\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/c$a;", "Lcom/tencent/mobileqq/guild/feed/performance/report/GuildFeedBaseReportData;", "Lcom/tencent/mobileqq/guild/feed/performance/report/d;", "initData", "", "v", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "eventAttributeParams", ReportConstant.COSTREPORT_PREFIX, "", "o", DomainData.DOMAIN_NAME, "D", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "setFeedId", "(Ljava/lang/String;)V", "feedId", "E", "getPosterTinyId", "setPosterTinyId", "posterTinyId", UserInfo.SEX_FEMALE, "getFrom", "setFrom", "from", "<init>", "(Lcom/tencent/mobileqq/guild/feed/performance/report/d;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends GuildFeedBaseReportData {

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private String feedId;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private String posterTinyId;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private String from;

        public a(@NotNull GuildFeedDetailInitData initData) {
            Intrinsics.checkNotNullParameter(initData, "initData");
            this.feedId = "";
            this.posterTinyId = "";
            this.from = "";
            v(initData);
        }

        private final void v(GuildFeedDetailInitData initData) {
            String mGuildId = initData.getMGuildId();
            if (mGuildId != null) {
                t(mGuildId);
            }
            String mChannelId = initData.getMChannelId();
            if (mChannelId != null) {
                r(mChannelId);
            }
            String mFeedId = initData.getMFeedId();
            if (mFeedId != null) {
                this.feedId = mFeedId;
            }
            String mFrom = initData.getMFrom();
            if (mFrom != null) {
                this.from = mFrom;
            }
            String mPosterTinyId = initData.getMPosterTinyId();
            if (mPosterTinyId != null) {
                this.posterTinyId = mPosterTinyId;
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
        @NotNull
        public String n() {
            return "FeedDetailBusinessReportBean";
        }

        @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
        @NotNull
        public List<String> o() {
            List listOf;
            List<String> plus;
            List<String> o16 = super.o();
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"is_first_load", "is_hit_index_offline", "is_hit_detail_cache_data", "web_process_status"});
            plus = CollectionsKt___CollectionsKt.plus((Collection) o16, (Iterable) listOf);
            return plus;
        }

        @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
        public void s(@NotNull HashMap<String, String> eventAttributeParams) {
            Intrinsics.checkNotNullParameter(eventAttributeParams, "eventAttributeParams");
            super.s(eventAttributeParams);
            eventAttributeParams.put("feed_id", this.feedId);
            eventAttributeParams.put("poster_tiny_id", this.posterTinyId);
            eventAttributeParams.put("from", this.from);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/performance/report/c$b", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/event/GuildDetailViewDestroyEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "p0", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements SimpleEventReceiver<GuildDetailViewDestroyEvent> {
        b() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<GuildDetailViewDestroyEvent>> getEventClass() {
            ArrayList<Class<GuildDetailViewDestroyEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildDetailViewDestroyEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent p06) {
            c.d();
        }
    }

    c() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull String event, @NotNull HashMap<String, String> extraInfo, long errCode, @Nullable String errMsg) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        a aVar = curReportBean;
        if (aVar != null) {
            aVar.c(event, extraInfo, errCode, errMsg);
        }
    }

    public static /* synthetic */ void b(String str, HashMap hashMap, long j3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            hashMap = new HashMap();
        }
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        a(str, hashMap, j3, str2);
    }

    private final List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"html_render", "resource_request"});
        return listOf;
    }

    @JvmStatic
    public static final void d() {
        bl.c().e(f222706d);
        bl.c().e(destroyWebViewReceiver);
        a aVar = curReportBean;
        if (aVar != null) {
            aVar.f();
        }
        curReportBean = null;
    }

    @JvmStatic
    public static final void e(@NotNull GuildFeedDetailInitData initData) {
        Intrinsics.checkNotNullParameter(initData, "initData");
        if (curReportBean != null) {
            d();
        }
        bl.c().d(f222706d);
        bl.c().d(destroyWebViewReceiver);
        a aVar = new a(initData);
        curReportBean = aVar;
        aVar.u("gpro_quality#event#feed_channel_business_detail");
    }

    private final HashMap<String, String> g(Map<String, String> map) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (map.isEmpty()) {
            return hashMap;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    public final void f(int state) {
        HashMap hashMapOf;
        String str;
        String str2;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feed_detail_send_comment_state", String.valueOf(state)));
        long j3 = 0;
        String str3 = "";
        if (state != 4) {
            if (state != 5 && state != 6) {
                str = "feed_detail_start_send_comment";
            } else {
                j3 = state;
                if (state == 5) {
                    str2 = "state_upload_fail";
                } else {
                    str2 = "state_comment_fail";
                }
                str3 = str2;
                str = "feed_detail_send_comment_failed";
            }
        } else {
            str = "feed_detail_send_comment_success";
        }
        a(str, hashMapOf, j3, str3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildFeedReportEvent>> getEventClass() {
        ArrayList<Class<GuildFeedReportEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedReportEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        GuildFeedReportEvent guildFeedReportEvent;
        GuildFeedReportBean guildFeedReportBean;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedDetailBusinessReportTask", 2, "onReceiveEvent " + event);
        }
        if (event instanceof GuildFeedReportEvent) {
            guildFeedReportEvent = (GuildFeedReportEvent) event;
        } else {
            guildFeedReportEvent = null;
        }
        if (guildFeedReportEvent == null || (guildFeedReportBean = guildFeedReportEvent.getGuildFeedReportBean()) == null) {
            return;
        }
        List<String> c16 = c();
        List<GuildFeedReportBean.ReportBean> reportList = guildFeedReportBean.getReportList();
        if (reportList != null) {
            ArrayList<GuildFeedReportBean.ReportBean> arrayList = new ArrayList();
            for (Object obj : reportList) {
                if (!c16.contains(((GuildFeedReportBean.ReportBean) obj).getEvent())) {
                    arrayList.add(obj);
                }
            }
            for (GuildFeedReportBean.ReportBean reportBean : arrayList) {
                String event2 = reportBean.getEvent();
                Intrinsics.checkNotNullExpressionValue(event2, "it.event");
                c cVar = f222706d;
                Map<String, String> params = reportBean.getParams();
                Intrinsics.checkNotNullExpressionValue(params, "it.params");
                a(event2, cVar.g(params), 0L, "");
            }
        }
    }
}
