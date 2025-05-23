package com.tencent.mobileqq.guild.feed.performance.report;

import android.util.SparseArray;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedNoticeFragment;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedNoticesRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.richframework.data.base.UIStateData;
import ij1.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J:\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007JL\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000e2$\b\u0002\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0014j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u00152\b\b\u0002\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0007J\"\u0010\u001e\u001a\u00020\u00042\u0018\u0010\u001d\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b\u0018\u00010\u001aH\u0007J \u0010\u001f\u001a\u00020\u000e2\u0016\u0010\u001d\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b0\u001aH\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010#\u001a\u0004\u0018\u00010 H\u0002R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020 0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/g;", "", "Lcom/tencent/mobileqq/guild/feed/fragment/GuildFeedNoticeFragment;", "rootFragment", "", "k", "j", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, VideoProxy.PARAM_ENABLE_CACHE, tl.h.F, "isSuccess", "", "retCode", "", "errorMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedNoticesRsp;", "result", "g", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraInfo", "errCode", "errMsg", "b", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/v;", "uiData", "i", "l", "Lcom/tencent/mobileqq/guild/feed/performance/report/g$a;", "e", "f", "d", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "pageMap", "Lmqq/util/WeakReference;", "c", "Lmqq/util/WeakReference;", "curPage", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f222725a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<a> pageMap = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<GuildFeedNoticeFragment> curPage;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016JX\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/g$a;", "Lcom/tencent/mobileqq/guild/feed/performance/report/GuildFeedBaseReportData;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "taskAttributeParams", "", "v", "", tl.h.F, "event", "eventAttributeParams", "l", DomainData.DOMAIN_NAME, "", "D", "Z", "isReportTimeCost", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends GuildFeedBaseReportData {

        /* renamed from: D, reason: from kotlin metadata */
        private boolean isReportTimeCost;

        private final void v(HashMap<String, String> taskAttributeParams) {
            taskAttributeParams.put("cost_time", String.valueOf(System.currentTimeMillis() - getStartTimestamp()));
        }

        @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
        @NotNull
        public List<String> h() {
            List<String> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"feed_notice_first_item_visible", "feed_notice_show", "feed_list_show_empty"});
            return listOf;
        }

        @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
        public void l(@NotNull String event, @NotNull HashMap<String, String> eventAttributeParams, @NotNull HashMap<String, String> taskAttributeParams) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(eventAttributeParams, "eventAttributeParams");
            Intrinsics.checkNotNullParameter(taskAttributeParams, "taskAttributeParams");
            int hashCode = event.hashCode();
            if (hashCode != -456014037) {
                if (hashCode != 100571) {
                    if (hashCode != 1301826275 || !event.equals("feed_notice_show")) {
                        return;
                    }
                } else {
                    if (event.equals("end") && !this.isReportTimeCost) {
                        taskAttributeParams.put("ret", "-1");
                        taskAttributeParams.put("msg", "cost_time not report");
                        return;
                    }
                    return;
                }
            } else if (!event.equals("feed_list_show_empty")) {
                return;
            }
            if (!this.isReportTimeCost) {
                this.isReportTimeCost = true;
                v(taskAttributeParams);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
        @NotNull
        public String n() {
            return "FeedNoticeReportBean";
        }
    }

    g() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        c(event, null, 0L, null, 14, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(@NotNull String event, @NotNull HashMap<String, String> extraInfo, long errCode, @Nullable String errMsg) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        a d16 = f222725a.d();
        if (d16 != null) {
            d16.c(event, extraInfo, errCode, errMsg);
        }
    }

    public static /* synthetic */ void c(String str, HashMap hashMap, long j3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            hashMap = new HashMap();
        }
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        b(str, hashMap, j3, str2);
    }

    private final a d() {
        GuildFeedNoticeFragment guildFeedNoticeFragment;
        WeakReference<GuildFeedNoticeFragment> weakReference = curPage;
        if (weakReference != null) {
            guildFeedNoticeFragment = weakReference.get();
        } else {
            guildFeedNoticeFragment = null;
        }
        if (guildFeedNoticeFragment == null) {
            return null;
        }
        return pageMap.get(guildFeedNoticeFragment.hashCode());
    }

    private final a e(GuildFeedNoticeFragment rootFragment) {
        int hashCode = rootFragment.hashCode();
        SparseArray<a> sparseArray = pageMap;
        a aVar = sparseArray.get(hashCode);
        if (aVar == null) {
            a aVar2 = new a();
            sparseArray.put(hashCode, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private final a f(GuildFeedNoticeFragment rootFragment) {
        int hashCode = rootFragment.hashCode();
        SparseArray<a> sparseArray = pageMap;
        a aVar = sparseArray.get(hashCode);
        if (aVar != null) {
            sparseArray.remove(hashCode);
        }
        return aVar;
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(boolean isSuccess, boolean isLoadMore, long retCode, @Nullable String errorMsg, @Nullable GProGetFeedNoticesRsp result) {
        String str;
        int i3;
        String trimIndent;
        HashMap hashMapOf;
        ArrayList<GProStNotice> arrayList;
        if (errorMsg == null) {
            str = "";
        } else {
            str = errorMsg;
        }
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
        String generateTraceId = BaseRequest.generateTraceId();
        int nextInt = new Random().nextInt();
        if (result != null && (arrayList = result.notices) != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        trimIndent = StringsKt__IndentKt.trimIndent("\n                    requestNoticeData onReceive: dispatch Success:" + isSuccess + ", \n                    TraceId:  " + generateTraceId + ",\n                    SeqId:  " + nextInt + ",\n                    retCode:  " + retCode + ",\n                    retMessage:  " + errorMsg + ",\n                    isLoadMore:  " + isLoadMore + ",\n                    isCache:  " + isProtocolCache + ",\n                    size:  " + i3 + "\n                ");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feed_notice_receiver_rsp_content", trimIndent), TuplesKt.to("result_code", String.valueOf(retCode)), TuplesKt.to("result_msg", str));
        b("feed_notice_receive_request_result", hashMapOf, retCode, str);
    }

    @JvmStatic
    public static final void h(boolean isLoadMore, boolean enableCache) {
        String trimIndent;
        HashMap hashMapOf;
        trimIndent = StringsKt__IndentKt.trimIndent("\n            sendNoticeRequest, isLoadMore: " + isLoadMore + ",\n            enableCache: " + enableCache + ",\n        ");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feed_notice_send_request_content", trimIndent));
        c("feed_notice_send_request", hashMapOf, 0L, null, 12, null);
    }

    @JvmStatic
    public static final void i(@Nullable UIStateData<List<v<?>>> uiData) {
        HashMap hashMapOf;
        if (uiData == null) {
            uiData = UIStateData.obtainEmpty();
        }
        g gVar = f222725a;
        Intrinsics.checkNotNullExpressionValue(uiData, "stateData");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feed_notice_ui_update_content", gVar.l(uiData)));
        c("feed_notice_ui_update_state", hashMapOf, 0L, null, 12, null);
    }

    @JvmStatic
    public static final void j(@Nullable GuildFeedNoticeFragment rootFragment) {
        a f16;
        if (rootFragment != null && (f16 = f222725a.f(rootFragment)) != null) {
            f16.f();
        }
    }

    @JvmStatic
    public static final void k(@Nullable GuildFeedNoticeFragment rootFragment) {
        if (rootFragment == null) {
            return;
        }
        curPage = new WeakReference<>(rootFragment);
        f222725a.e(rootFragment).u("gpro_quality#event#feed_channel_notice");
    }

    private final String l(UIStateData<List<v<?>>> uiData) {
        int i3;
        List<v<?>> data = uiData.getData();
        if (data != null) {
            i3 = data.size();
        } else {
            i3 = 0;
        }
        return "type: " + uiData.getType() + ", isCache: " + uiData.isCacheData() + ", isLoadMore: " + uiData.getIsLoadMore() + ", listSize: " + i3 + ", state: " + uiData.getState();
    }
}
