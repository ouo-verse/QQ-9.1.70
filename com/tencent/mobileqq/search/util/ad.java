package com.tencent.mobileqq.search.util;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/search/util/ad;", "", "", "jsonString", "Lorg/json/JSONObject;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ad f284990a = new ad();

    ad() {
    }

    @Nullable
    public final JSONObject a(@NotNull String jsonString) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        isBlank = StringsKt__StringsJVMKt.isBlank(jsonString);
        if (isBlank) {
            return null;
        }
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e16) {
            QLog.e("SearchJsonUtils", 1, "convertReportInfo2JsonObject: " + e16.getMessage());
            return null;
        }
    }
}
