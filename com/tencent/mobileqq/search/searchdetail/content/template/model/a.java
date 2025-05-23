package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.util.ad;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.SearchGuildJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchLayOut;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\"\u0010\u001c\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R.\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010G\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u0017\u001a\u0004\bE\u0010\u0019\"\u0004\bF\u0010\u001b\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "Lcom/tencent/mobileqq/search/searchdetail/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "", "u", "", "k", "", "l", "()Ljava/lang/Long;", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", "b", "a", "", "e", "other", "equals", "", "hashCode", tl.h.F, "I", "getTemplateId", "()I", "setTemplateId", "(I)V", "templateId", "i", "Ljava/lang/String;", "getTemplateData", "()Ljava/lang/String;", "setTemplateData", "(Ljava/lang/String;)V", "templateData", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLayOut;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLayOut;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchLayOut;", "setLayoutInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchLayOut;)V", "layoutInfo", "Lcom/tencent/mobileqq/search/searchdetail/content/model/g;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/content/model/g;", "t", "()Lcom/tencent/mobileqq/search/searchdetail/content/model/g;", "setReportInfoWrapper", "(Lcom/tencent/mobileqq/search/searchdetail/content/model/g;)V", "reportInfoWrapper", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "r", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "w", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;)V", "jumpLink", "", "E", "Ljava/util/Map;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/Map;", "setExtensionMap", "(Ljava/util/Map;)V", "extensionMap", UserInfo.SEX_FEMALE, "p", "v", "docPosition", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class a extends com.tencent.mobileqq.search.searchdetail.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private SearchJump jumpLink;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> extensionMap;

    /* renamed from: F, reason: from kotlin metadata */
    private int docPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int templateId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String templateData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SearchLayOut layoutInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        this.templateData = "";
        this.layoutInfo = new SearchLayOut();
        this.extensionMap = new LinkedHashMap();
        this.docPosition = -1;
        u(template);
    }

    private final void u(SearchTemplate template) {
        this.templateId = template.templateId;
        String str = template.data;
        if (str == null) {
            str = "";
        }
        this.templateData = str;
        SearchLayOut searchLayOut = template.layOut;
        Intrinsics.checkNotNullExpressionValue(searchLayOut, "template.layOut");
        this.layoutInfo = searchLayOut;
        this.reportInfoWrapper = new com.tencent.mobileqq.search.searchdetail.content.model.g(template.reportInfo);
        SearchJump searchJump = template.jumpLink;
        this.jumpLink = searchJump;
        if (searchJump != null) {
            Intrinsics.checkNotNullExpressionValue(searchJump.stringExtension, "it.stringExtension");
            if (!StringsKt.isBlank(r0)) {
                this.extensionMap.putAll(b.a(searchJump));
            }
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public boolean a(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(newItem, this);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public boolean b(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof a) || !super.b(newItem)) {
            return false;
        }
        a aVar = (a) newItem;
        if (!Intrinsics.areEqual(getCommonInfo().getLayoutContent(), aVar.getCommonInfo().getLayoutContent()) || this.templateId != aVar.templateId || !Intrinsics.areEqual(this.templateData, aVar.templateData)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.c
    @Nullable
    public Object e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.FALSE;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.templateId == aVar.templateId && Intrinsics.areEqual(this.templateData, aVar.templateData) && Intrinsics.areEqual(this.layoutInfo, aVar.layoutInfo) && Intrinsics.areEqual(this.reportInfoWrapper, aVar.reportInfoWrapper) && Intrinsics.areEqual(this.jumpLink, aVar.jumpLink) && Intrinsics.areEqual(this.extensionMap, aVar.extensionMap) && this.docPosition == aVar.docPosition) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int hashCode = ((((this.templateId * 31) + this.templateData.hashCode()) * 31) + this.layoutInfo.hashCode()) * 31;
        com.tencent.mobileqq.search.searchdetail.content.model.g gVar = this.reportInfoWrapper;
        int i16 = 0;
        if (gVar != null) {
            i3 = gVar.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (hashCode + i3) * 31;
        SearchJump searchJump = this.jumpLink;
        if (searchJump != null) {
            i16 = searchJump.hashCode();
        }
        return ((((i17 + i16) * 31) + this.extensionMap.hashCode()) * 31) + this.docPosition;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a
    @NotNull
    public String k() {
        JSONObject jsonReportInfo;
        String optString;
        String str;
        com.tencent.mobileqq.search.searchdetail.content.model.g gVar = this.reportInfoWrapper;
        if (gVar == null || (jsonReportInfo = gVar.getJsonReportInfo()) == null || (optString = jsonReportInfo.optString("sgrp_channel_extension_info")) == null) {
            return "";
        }
        JSONObject a16 = ad.f284990a.a(optString);
        if (a16 != null) {
            str = a16.optString("doc_id");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a
    @Nullable
    public Long l() {
        SearchGuildJump searchGuildJump;
        SearchJump searchJump = this.jumpLink;
        if (searchJump != null && (searchGuildJump = searchJump.guildJump) != null) {
            return Long.valueOf(searchGuildJump.guildId);
        }
        return null;
    }

    /* renamed from: p, reason: from getter */
    public final int getDocPosition() {
        return this.docPosition;
    }

    @NotNull
    public final Map<String, String> q() {
        return this.extensionMap;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final SearchJump getJumpLink() {
        return this.jumpLink;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final SearchLayOut getLayoutInfo() {
        return this.layoutInfo;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final com.tencent.mobileqq.search.searchdetail.content.model.g getReportInfoWrapper() {
        return this.reportInfoWrapper;
    }

    public final void v(int i3) {
        this.docPosition = i3;
    }

    public final void w(@Nullable SearchJump searchJump) {
        this.jumpLink = searchJump;
    }
}
