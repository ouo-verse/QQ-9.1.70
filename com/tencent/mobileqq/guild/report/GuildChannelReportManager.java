package com.tencent.mobileqq.guild.report;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0005\u001b\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JH\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\fJ\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\fR \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager;", "", "Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$PageType;", "pageType", "Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$a;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "pageView", "", "dtPageId", "", "params", "Lcom/tencent/mobileqq/guild/report/f;", "plugin", "", "c", "g", "e", "f", "", "b", "Ljava/util/Map;", "channelPageCache", "<init>", "()V", "PageState", "PageType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildChannelReportManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildChannelReportManager f231987a = new GuildChannelReportManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<PageType, a> channelPageCache = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$PageState;", "", "(Ljava/lang/String;I)V", "CHANNEL_PAGE_STATE_INIT", "CHANNEL_PAGE_STATE_IN", "CHANNEL_PAGE_STATE_OUT", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum PageState {
        CHANNEL_PAGE_STATE_INIT,
        CHANNEL_PAGE_STATE_IN,
        CHANNEL_PAGE_STATE_OUT
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$PageType;", "", "(Ljava/lang/String;I)V", "CHANNEL_PAGE_FEED_LIST", "CHANNEL_PAGE_FEED_MEDIA_VIEWER", "CHANNEL_PAGE_LIVE", "CHANNEL_PAGE_SCHEDULE_LIST", "CHANNEL_PAGE_SCHEDULE_DETAIL", "CHANNEL_PAGE_SCHEDULE_MEMBER_LIST", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum PageType {
        CHANNEL_PAGE_FEED_LIST,
        CHANNEL_PAGE_FEED_MEDIA_VIEWER,
        CHANNEL_PAGE_LIVE,
        CHANNEL_PAGE_SCHEDULE_LIST,
        CHANNEL_PAGE_SCHEDULE_DETAIL,
        CHANNEL_PAGE_SCHEDULE_MEMBER_LIST
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\t\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R!\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\n\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\u001a\u0010\"\"\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$a;", "", "Landroid/view/View;", "c", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "dtPageId", "", "b", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "params", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakRefView", "Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$PageState;", "Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$PageState;", "f", "()Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$PageState;", "i", "(Lcom/tencent/mobileqq/guild/report/GuildChannelReportManager$PageState;)V", "state", "", "e", "J", "()J", "g", "(J)V", "exposureTime", "Lcom/tencent/mobileqq/guild/report/f;", "Lcom/tencent/mobileqq/guild/report/f;", "()Lcom/tencent/mobileqq/guild/report/f;", tl.h.F, "(Lcom/tencent/mobileqq/guild/report/f;)V", "plugin", "pageView", "<init>", "(Ljava/lang/String;Ljava/util/Map;Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String dtPageId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, ?> params;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<View> weakRefView;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private PageState state;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long exposureTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private f plugin;

        public a(@NotNull String dtPageId, @NotNull Map<String, ?> params, @Nullable View view) {
            Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
            Intrinsics.checkNotNullParameter(params, "params");
            this.dtPageId = dtPageId;
            this.params = params;
            this.weakRefView = new WeakReference<>(view);
            this.state = PageState.CHANNEL_PAGE_STATE_INIT;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getDtPageId() {
            return this.dtPageId;
        }

        /* renamed from: b, reason: from getter */
        public final long getExposureTime() {
            return this.exposureTime;
        }

        @Nullable
        public final View c() {
            WeakReference<View> weakReference = this.weakRefView;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @NotNull
        public final Map<String, ?> d() {
            return this.params;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final f getPlugin() {
            return this.plugin;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final PageState getState() {
            return this.state;
        }

        public final void g(long j3) {
            this.exposureTime = j3;
        }

        public final void h(@Nullable f fVar) {
            this.plugin = fVar;
        }

        public final void i(@NotNull PageState pageState) {
            Intrinsics.checkNotNullParameter(pageState, "<set-?>");
            this.state = pageState;
        }
    }

    GuildChannelReportManager() {
    }

    private final a a(PageType pageType) {
        a aVar = channelPageCache.get(pageType);
        if (aVar == null) {
            QLog.i("GuildChannelReportManager", 1, "getChannelPageInfo: pageInfo is null. pageType[" + pageType + "]");
            return null;
        }
        if (TextUtils.isEmpty(aVar.getDtPageId())) {
            QLog.i("GuildChannelReportManager", 1, "getChannelPageInfo: pageId is null. pageType[" + pageType + "]");
            return null;
        }
        if (aVar.c() == null) {
            QLog.i("GuildChannelReportManager", 1, "getChannelPageInfo: pageView is null. pageType[" + pageType + "]");
            return null;
        }
        return aVar;
    }

    public static /* synthetic */ void d(GuildChannelReportManager guildChannelReportManager, Activity activity, View view, PageType pageType, String str, Map map, f fVar, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            fVar = null;
        }
        guildChannelReportManager.c(activity, view, pageType, str, map, fVar);
    }

    @JvmOverloads
    public final void b(@NotNull Activity activity, @NotNull View pageView, @NotNull PageType pageType, @NotNull String dtPageId, @Nullable Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        d(this, activity, pageView, pageType, dtPageId, map, null, 32, null);
    }

    @JvmOverloads
    public final void c(@NotNull Activity activity, @NotNull View pageView, @NotNull PageType pageType, @NotNull String dtPageId, @Nullable Map<String, ?> params, @Nullable f plugin) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        QLog.i("GuildChannelReportManager", 1, "registerPageInfo: pageType[" + pageType + "] pageId[" + dtPageId + "]");
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(pageView, dtPageId);
        VideoReport.setPageReportPolicy(pageView, PageReportPolicy.REPORT_NONE);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (params != null) {
            linkedHashMap.putAll(params);
        }
        linkedHashMap.put("dt_pgid", dtPageId);
        linkedHashMap.putAll(b.d());
        VideoReport.setPageParams(pageView, new PageParams(linkedHashMap));
        Map<PageType, a> map = channelPageCache;
        map.remove(pageType);
        a aVar = new a(dtPageId, linkedHashMap, pageView);
        if (plugin != null) {
            aVar.h(plugin);
        }
        map.put(pageType, aVar);
        f plugin2 = aVar.getPlugin();
        if (plugin2 != null) {
            plugin2.d();
        }
    }

    public final void e(@NotNull PageType pageType, @Nullable Map<String, ?> params) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        QLog.i("GuildChannelReportManager", 1, "reportPageIn: pageType[" + pageType + "]");
        a a16 = a(pageType);
        if (a16 == null) {
            return;
        }
        if (a16.getState() != PageState.CHANNEL_PAGE_STATE_INIT && a16.getState() != PageState.CHANNEL_PAGE_STATE_OUT) {
            QLog.i("GuildChannelReportManager", 1, "reportPageIn: error! current pageType[" + a16.getState() + "]");
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(a16.d());
        if (params != null) {
            linkedHashMap.putAll(params);
        }
        a16.i(PageState.CHANNEL_PAGE_STATE_IN);
        VideoReport.reportEvent("pgin", a16.c(), linkedHashMap);
        a16.g(System.currentTimeMillis());
        f plugin = a16.getPlugin();
        if (plugin != null) {
            plugin.a();
        }
    }

    public final void f(@NotNull PageType pageType, @Nullable Map<String, ?> params) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        QLog.i("GuildChannelReportManager", 1, "reportPageOut: pageType[" + pageType + "]");
        a a16 = a(pageType);
        if (a16 == null) {
            return;
        }
        if (a16.getState() != PageState.CHANNEL_PAGE_STATE_IN) {
            QLog.i("GuildChannelReportManager", 1, "reportPageOut: error! current pageType[" + a16.getState() + "]");
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(a16.d());
        linkedHashMap.put(DTParamKey.REPORT_KEY_LVTM, Long.valueOf(System.currentTimeMillis() - a16.getExposureTime()));
        if (params != null) {
            linkedHashMap.putAll(params);
        }
        a16.i(PageState.CHANNEL_PAGE_STATE_OUT);
        VideoReport.reportEvent("pgout", a16.c(), linkedHashMap);
        a16.g(0L);
        f plugin = a16.getPlugin();
        if (plugin != null) {
            plugin.c();
        }
    }

    public final void g(@NotNull PageType pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        QLog.i("GuildChannelReportManager", 1, "unregisterPageInfo: pageType[" + pageType + "]");
        a remove = channelPageCache.remove(pageType);
        if (remove == null) {
            QLog.e("GuildChannelReportManager", 1, "unregisterPageInfo: error, please check. pageType[" + pageType + "]");
            return;
        }
        f plugin = remove.getPlugin();
        if (plugin != null) {
            plugin.b();
        }
    }
}
