package com.tencent.sqshow.zootopia.samestyle;

import com.tencent.ams.dsdk.core.DKConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\u000bR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u0019\u0010\u000bR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0017\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "errCode", "b", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "errMsg", "", "c", "J", "()J", "tabId", "d", "pageIndex", "e", "getPerPageNum", "perPageNum", "f", "totalPage", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "g", "Ljava/util/List;", "()Ljava/util/List;", DKConfiguration.Directory.TEMPLATES, "<init>", "(ILjava/lang/String;JIIILjava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.samestyle.f, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class TemplateRsp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long tabId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pageIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int perPageNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalPage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ZPlanTemplate> templates;

    public TemplateRsp() {
        this(0, null, 0L, 0, 0, 0, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    /* renamed from: b, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: c, reason: from getter */
    public final long getTabId() {
        return this.tabId;
    }

    public final List<ZPlanTemplate> d() {
        return this.templates;
    }

    /* renamed from: e, reason: from getter */
    public final int getTotalPage() {
        return this.totalPage;
    }

    public int hashCode() {
        int i3 = this.errCode * 31;
        String str = this.errMsg;
        return ((((((((((i3 + (str == null ? 0 : str.hashCode())) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.tabId)) * 31) + this.pageIndex) * 31) + this.perPageNum) * 31) + this.totalPage) * 31) + this.templates.hashCode();
    }

    public String toString() {
        return "TemplateRsp(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", tabId=" + this.tabId + ", pageIndex=" + this.pageIndex + ", perPageNum=" + this.perPageNum + ", totalPage=" + this.totalPage + ", templates=" + this.templates + ")";
    }

    public TemplateRsp(int i3, String str, long j3, int i16, int i17, int i18, List<ZPlanTemplate> templates) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        this.errCode = i3;
        this.errMsg = str;
        this.tabId = j3;
        this.pageIndex = i16;
        this.perPageNum = i17;
        this.totalPage = i18;
        this.templates = templates;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateRsp)) {
            return false;
        }
        TemplateRsp templateRsp = (TemplateRsp) other;
        return this.errCode == templateRsp.errCode && Intrinsics.areEqual(this.errMsg, templateRsp.errMsg) && this.tabId == templateRsp.tabId && this.pageIndex == templateRsp.pageIndex && this.perPageNum == templateRsp.perPageNum && this.totalPage == templateRsp.totalPage && Intrinsics.areEqual(this.templates, templateRsp.templates);
    }

    public /* synthetic */ TemplateRsp(int i3, String str, long j3, int i16, int i17, int i18, List list, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? null : str, (i19 & 4) != 0 ? -1L : j3, (i19 & 8) != 0 ? -1 : i16, (i19 & 16) != 0 ? -1 : i17, (i19 & 32) == 0 ? i18 : -1, (i19 & 64) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
