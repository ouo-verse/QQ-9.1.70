package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u001a\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "", "", "a", "key", "", "value", "", "b", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    @NotNull
    public static final Map<String, String> a(@NotNull SearchJump searchJump) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(searchJump, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String stringExtension = searchJump.stringExtension;
        Intrinsics.checkNotNullExpressionValue(stringExtension, "stringExtension");
        isBlank = StringsKt__StringsJVMKt.isBlank(stringExtension);
        if (!isBlank) {
            try {
                JSONObject jSONObject = new JSONObject(searchJump.stringExtension);
                Iterator keys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "extensionObj.keys()");
                while (keys.hasNext()) {
                    String it = (String) keys.next();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String optString = jSONObject.optString(it, "");
                    Intrinsics.checkNotNullExpressionValue(optString, "extensionObj.optString(it, \"\")");
                    linkedHashMap.put(it, optString);
                }
            } catch (JSONException e16) {
                QLog.e("BaseTemplateItem", 1, "jsonParseStr:" + searchJump.stringExtension + " \n" + e16);
            }
        }
        return linkedHashMap;
    }

    public static final void b(@NotNull SearchJump searchJump, @NotNull String key, @NotNull Object value) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(searchJump, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(searchJump.stringExtension);
            jSONObject.put(key, value);
            searchJump.stringExtension = jSONObject.toString();
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("BaseTemplateItem", 1, "putExtension:" + m479exceptionOrNullimpl);
        }
    }
}
