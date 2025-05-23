package com.tencent.mobileqq.search.searchdetail;

import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\u000b\u0010\u000e\u001a\u00070\u0002\u00a2\u0006\u0002\b\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010!\u001a\u00020\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012O\u0010/\u001aK\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010+\u0012\u0004\u0012\u00020,0&\u00a2\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\u000e\u001a\u00070\u0002\u00a2\u0006\u0002\b\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0010\u0010 R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b$\u0010\rR`\u0010/\u001aK\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010+\u0012\u0004\u0012\u00020,0&8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b\u001e\u0010.R\u0011\u00100\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\rR\u0013\u00102\u001a\u0004\u0018\u00010*8F\u00a2\u0006\u0006\u001a\u0004\b\"\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/search/searchdetail/IInteractiveIconType;", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "key", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "icon", "i", "reuseIdForReport", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", tl.h.F, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", CacheTable.TABLE_NAME, "", "e", "J", "()J", "guildId", "f", "docId", "j", "traceId", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "likeStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "", "", "Lkotlin/jvm/functions/Function6;", "()Lkotlin/jvm/functions/Function6;", "jumpClick", "iconText", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "jumpLink", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function6;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.n, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SearchInteractiveData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SearchIcon icon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String reuseIdForReport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchReportInfo reportInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String docId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function6<Long, String, String, Integer, SearchJump, Map<String, String>, Unit> jumpClick;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchInteractiveData(@NotNull String key, @NotNull SearchIcon icon, @NotNull String reuseIdForReport, @Nullable SearchReportInfo searchReportInfo, long j3, @NotNull String docId, @NotNull String traceId, @NotNull Function6<? super Long, ? super String, ? super String, ? super Integer, ? super SearchJump, ? super Map<String, String>, Unit> jumpClick) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(reuseIdForReport, "reuseIdForReport");
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(jumpClick, "jumpClick");
        this.key = key;
        this.icon = icon;
        this.reuseIdForReport = reuseIdForReport;
        this.reportInfo = searchReportInfo;
        this.guildId = j3;
        this.docId = docId;
        this.traceId = traceId;
        this.jumpClick = jumpClick;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final SearchIcon getIcon() {
        return this.icon;
    }

    @NotNull
    public final String d() {
        String str = this.icon.title.text;
        Intrinsics.checkNotNullExpressionValue(str, "icon.title.text");
        return str;
    }

    @NotNull
    public final Function6<Long, String, String, Integer, SearchJump, Map<String, String>, Unit> e() {
        return this.jumpClick;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchInteractiveData)) {
            return false;
        }
        SearchInteractiveData searchInteractiveData = (SearchInteractiveData) other;
        if (Intrinsics.areEqual(this.key, searchInteractiveData.key) && Intrinsics.areEqual(this.icon, searchInteractiveData.icon) && Intrinsics.areEqual(this.reuseIdForReport, searchInteractiveData.reuseIdForReport) && Intrinsics.areEqual(this.reportInfo, searchInteractiveData.reportInfo) && this.guildId == searchInteractiveData.guildId && Intrinsics.areEqual(this.docId, searchInteractiveData.docId) && Intrinsics.areEqual(this.traceId, searchInteractiveData.traceId) && Intrinsics.areEqual(this.jumpClick, searchInteractiveData.jumpClick)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final SearchJump f() {
        return this.icon.jumpLink;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.key.hashCode() * 31) + this.icon.hashCode()) * 31) + this.reuseIdForReport.hashCode()) * 31;
        SearchReportInfo searchReportInfo = this.reportInfo;
        if (searchReportInfo == null) {
            hashCode = 0;
        } else {
            hashCode = searchReportInfo.hashCode();
        }
        return ((((((((hashCode2 + hashCode) * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + this.docId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.jumpClick.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getReuseIdForReport() {
        return this.reuseIdForReport;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    @NotNull
    public String toString() {
        return "SearchInteractiveData(key=" + this.key + ", icon=" + this.icon + ", reuseIdForReport=" + this.reuseIdForReport + ", reportInfo=" + this.reportInfo + ", guildId=" + this.guildId + ", docId=" + this.docId + ", traceId=" + this.traceId + ", jumpClick=" + this.jumpClick + ")";
    }
}
