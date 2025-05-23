package com.tencent.biz.qqcircle.immersive.personal.bean;

import android.net.Uri;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import feedcloud.FeedCloudRead$StTemplateInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$MapEntry;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001\tB[\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 \u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0010\u0010\u001eR\u0019\u0010#\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\u001c\u0010\"R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b%\u0010\fR\u0011\u0010'\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\f\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/bean/t;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "coverUrl", tl.h.F, "title", "c", "e", "subtitle", "d", QZoneDTLoginReporter.SCHEMA, "Z", "i", "()Z", "isLogo", "f", "j", "isProfile", "g", "I", "()I", "order", "Lfeedcloud/FeedCloudRead$StTemplateInfo;", "Lfeedcloud/FeedCloudRead$StTemplateInfo;", "()Lfeedcloud/FeedCloudRead$StTemplateInfo;", "templateInfo", "adId", "getTraceInfo", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, MiniAppGetGameTaskTicketServlet.KEY_TASKID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILfeedcloud/FeedCloudRead$StTemplateInfo;Ljava/lang/String;Ljava/lang/String;)V", "k", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.personal.bean.t, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSPersonalTemplateCarouselInfo {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String subtitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String schema;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isLogo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isProfile;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int order;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FeedCloudRead$StTemplateInfo templateInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String adId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\n\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/bean/t$a;", "", "", "", "map", "Lfeedcloud/FeedCloudRead$StTemplateInfo;", "templateInfo", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/t;", "d", "", "c", "Ltianshu/QQCircleTianShu$AdItem;", "adItem", "a", "", "Ltianshu/QQCircleTianShu$RspEntry;", "rspEntryList", "b", "AD_ID", "Ljava/lang/String;", "TAG", "TASK_ID", "TRACE_INFO", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.bean.t$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.biz.qqcircle.immersive.personal.bean.t$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0897a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((QFSPersonalTemplateCarouselInfo) t16).getOrder()), Integer.valueOf(((QFSPersonalTemplateCarouselInfo) t17).getOrder()));
                return compareValues;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<String, String> a(QQCircleTianShu$AdItem adItem) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<QQCircleTianShu$MapEntry> list = adItem.argList.get();
            Intrinsics.checkNotNullExpressionValue(list, "adItem.argList.get()");
            for (QQCircleTianShu$MapEntry qQCircleTianShu$MapEntry : list) {
                String str = qQCircleTianShu$MapEntry.key.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.key.get()");
                String str2 = qQCircleTianShu$MapEntry.value.get();
                Intrinsics.checkNotNullExpressionValue(str2, "it.value.get()");
                linkedHashMap.put(str, str2);
            }
            linkedHashMap.put("ad_id", String.valueOf(adItem.iAdId.get()));
            String str3 = adItem.traceinfo.get();
            Intrinsics.checkNotNullExpressionValue(str3, "adItem.traceinfo.get()");
            linkedHashMap.put("trace_info", str3);
            QLog.d("QFSPersonalTemplateCarouselInfo", 1, "adItem2Map, map: " + linkedHashMap);
            return linkedHashMap;
        }

        private final boolean c(Map<String, String> map) {
            return Intrinsics.areEqual(map.get("card_type"), "5");
        }

        private final QFSPersonalTemplateCarouselInfo d(Map<String, String> map, FeedCloudRead$StTemplateInfo templateInfo) {
            String str;
            String str2;
            String str3;
            String str4;
            int i3;
            String str5;
            String str6;
            String str7 = map.get("background_img");
            if (str7 == null) {
                str = "";
            } else {
                str = str7;
            }
            String str8 = map.get("main_title");
            if (str8 == null) {
                str2 = "";
            } else {
                str2 = str8;
            }
            String str9 = map.get("sub_title");
            if (str9 == null) {
                str3 = "";
            } else {
                str3 = str9;
            }
            String str10 = map.get(QZoneDTLoginReporter.SCHEMA);
            if (str10 == null) {
                str4 = "";
            } else {
                str4 = str10;
            }
            boolean areEqual = Intrinsics.areEqual(map.get("logo"), "1");
            boolean areEqual2 = Intrinsics.areEqual(map.get("profile"), "1");
            try {
                String str11 = map.get("order");
                if (str11 != null) {
                    i3 = Integer.parseInt(str11);
                } else {
                    i3 = 0;
                }
            } catch (Exception e16) {
                QLog.w("QFSPersonalTemplateCarouselInfo", 1, "map2TemplateCarouselInfo, error", e16);
                i3 = -1;
            }
            int i16 = i3;
            String str12 = map.get("ad_id");
            if (str12 == null) {
                str5 = "";
            } else {
                str5 = str12;
            }
            String str13 = map.get("trace_info");
            if (str13 == null) {
                str6 = "";
            } else {
                str6 = str13;
            }
            return new QFSPersonalTemplateCarouselInfo(str, str2, str3, str4, areEqual, areEqual2, i16, templateInfo, str5, str6);
        }

        @NotNull
        public final List<QFSPersonalTemplateCarouselInfo> b(@Nullable List<QQCircleTianShu$RspEntry> rspEntryList, @NotNull FeedCloudRead$StTemplateInfo templateInfo) {
            boolean z16;
            Object obj;
            List<QFSPersonalTemplateCarouselInfo> sortedWith;
            List<QFSPersonalTemplateCarouselInfo> emptyList;
            List<QFSPersonalTemplateCarouselInfo> emptyList2;
            boolean z17;
            List<QFSPersonalTemplateCarouselInfo> emptyList3;
            Intrinsics.checkNotNullParameter(templateInfo, "templateInfo");
            List<QQCircleTianShu$RspEntry> list = rspEntryList;
            boolean z18 = false;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.d("QFSPersonalTemplateCarouselInfo", 1, "from, rspEntryList is null or empty ");
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList3;
            }
            Iterator<T> it = rspEntryList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((QQCircleTianShu$RspEntry) obj).key.get() == 1040) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry = (QQCircleTianShu$RspEntry) obj;
            if (qQCircleTianShu$RspEntry == null) {
                QLog.d("QFSPersonalTemplateCarouselInfo", 1, "from, rspEntry is null ");
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            List<QQCircleTianShu$AdItem> adItemList = qQCircleTianShu$RspEntry.value.lst.get();
            List<QQCircleTianShu$AdItem> list2 = adItemList;
            if (list2 == null || list2.isEmpty()) {
                z18 = true;
            }
            if (z18) {
                QLog.d("QFSPersonalTemplateCarouselInfo", 1, "from, adItemList is null or empty ");
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            QLog.d("QFSPersonalTemplateCarouselInfo", 1, "from, ad size:" + adItemList.size());
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNullExpressionValue(adItemList, "adItemList");
            for (QQCircleTianShu$AdItem it5 : adItemList) {
                Companion companion = QFSPersonalTemplateCarouselInfo.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                Map<String, String> a16 = companion.a(it5);
                if (companion.c(a16)) {
                    arrayList.add(companion.d(a16, templateInfo));
                }
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new C0897a());
            return sortedWith;
        }

        Companion() {
        }
    }

    public QFSPersonalTemplateCarouselInfo(@NotNull String coverUrl, @NotNull String title, @NotNull String subtitle, @NotNull String schema, boolean z16, boolean z17, int i3, @Nullable FeedCloudRead$StTemplateInfo feedCloudRead$StTemplateInfo, @NotNull String adId, @NotNull String traceInfo) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
        this.coverUrl = coverUrl;
        this.title = title;
        this.subtitle = subtitle;
        this.schema = schema;
        this.isLogo = z16;
        this.isProfile = z17;
        this.order = i3;
        this.templateInfo = feedCloudRead$StTemplateInfo;
        this.adId = adId;
        this.traceInfo = traceInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: c, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSPersonalTemplateCarouselInfo)) {
            return false;
        }
        QFSPersonalTemplateCarouselInfo qFSPersonalTemplateCarouselInfo = (QFSPersonalTemplateCarouselInfo) other;
        if (Intrinsics.areEqual(this.coverUrl, qFSPersonalTemplateCarouselInfo.coverUrl) && Intrinsics.areEqual(this.title, qFSPersonalTemplateCarouselInfo.title) && Intrinsics.areEqual(this.subtitle, qFSPersonalTemplateCarouselInfo.subtitle) && Intrinsics.areEqual(this.schema, qFSPersonalTemplateCarouselInfo.schema) && this.isLogo == qFSPersonalTemplateCarouselInfo.isLogo && this.isProfile == qFSPersonalTemplateCarouselInfo.isProfile && this.order == qFSPersonalTemplateCarouselInfo.order && Intrinsics.areEqual(this.templateInfo, qFSPersonalTemplateCarouselInfo.templateInfo) && Intrinsics.areEqual(this.adId, qFSPersonalTemplateCarouselInfo.adId) && Intrinsics.areEqual(this.traceInfo, qFSPersonalTemplateCarouselInfo.traceInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        try {
            String queryParameter = Uri.parse(this.schema).getQueryParameter("taskid");
            if (queryParameter == null) {
                return "";
            }
            return queryParameter;
        } catch (Exception unused) {
            return "";
        }
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final FeedCloudRead$StTemplateInfo getTemplateInfo() {
        return this.templateInfo;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.coverUrl.hashCode() * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.schema.hashCode()) * 31;
        boolean z16 = this.isLogo;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isProfile;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (((i17 + i3) * 31) + this.order) * 31;
        FeedCloudRead$StTemplateInfo feedCloudRead$StTemplateInfo = this.templateInfo;
        if (feedCloudRead$StTemplateInfo == null) {
            hashCode = 0;
        } else {
            hashCode = feedCloudRead$StTemplateInfo.hashCode();
        }
        return ((((i18 + hashCode) * 31) + this.adId.hashCode()) * 31) + this.traceInfo.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsLogo() {
        return this.isLogo;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsProfile() {
        return this.isProfile;
    }

    @NotNull
    public String toString() {
        return "QFSPersonalTemplateCarouselInfo(coverUrl=" + this.coverUrl + ", title=" + this.title + ", subtitle=" + this.subtitle + ", schema=" + this.schema + ", isLogo=" + this.isLogo + ", isProfile=" + this.isProfile + ", order=" + this.order + ", templateInfo=" + this.templateInfo + ", adId=" + this.adId + ", traceInfo=" + this.traceInfo + ")";
    }
}
