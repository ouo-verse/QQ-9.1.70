package com.tencent.mobileqq.search.searchdetail.content.model;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/g;", "", "", "jsonString", "Lorg/json/JSONObject;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", CacheTable.TABLE_NAME, "b", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "jsonReportInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final SearchReportInfo reportInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject jsonReportInfo;

    public g(@Nullable SearchReportInfo searchReportInfo) {
        String str;
        this.reportInfo = searchReportInfo;
        if (searchReportInfo != null) {
            str = searchReportInfo.reportInfo;
        } else {
            str = null;
        }
        this.jsonReportInfo = a(str == null ? "{}" : str);
    }

    private final JSONObject a(String jsonString) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(jsonString);
        if (isBlank) {
            return new JSONObject();
        }
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e16) {
            QLog.e("SearchReportInfoWrapper", 1, "convertReportInfo2JsonObject: " + e16.getMessage());
            return new JSONObject();
        }
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final JSONObject getJsonReportInfo() {
        return this.jsonReportInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }
}
