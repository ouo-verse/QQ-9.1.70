package com.tencent.mobileqq.search.searchdetail.content.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchRecommendGuide;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/c;", "Lcom/tencent/mobileqq/search/searchdetail/a;", "", "bytesExtension", "", ReportConstant.COSTREPORT_PREFIX, "", "getItemType", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", "a", "p", "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "", tl.h.F, "Ljava/lang/String;", "r", "()Ljava/lang/String;", "text", "Lorg/json/JSONObject;", "i", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lorg/json/JSONObject;", CacheTable.TABLE_NAME, "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchRecommendGuide;", "emptyCard", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchRecommendGuide;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends com.tencent.mobileqq.search.searchdetail.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject reportInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull CommonInfo commonInfo, @NotNull SearchRecommendGuide emptyCard) {
        super(commonInfo);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(emptyCard, "emptyCard");
        this.reportInfo = new JSONObject();
        String str = emptyCard.text;
        Intrinsics.checkNotNullExpressionValue(str, "emptyCard.text");
        this.text = str;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public boolean a(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof c) && Intrinsics.areEqual(this.text, ((c) newItem).text)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 14;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.c
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Boolean e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.FALSE;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final JSONObject getReportInfo() {
        return this.reportInfo;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final void s(@NotNull byte[] bytesExtension) {
        String decodeToString;
        Intrinsics.checkNotNullParameter(bytesExtension, "bytesExtension");
        decodeToString = StringsKt__StringsJVMKt.decodeToString(bytesExtension);
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(decodeToString).optString("report"));
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "reportJson.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.reportInfo.put(str, jSONObject.opt(str));
            }
        } catch (Exception e16) {
            QLog.e("NetSearchItemEmptyItem", 1, "initExtension   parseJsonError:" + e16);
        }
    }
}
