package com.tencent.sqshow.zootopia.utils;

import android.net.Uri;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\"\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/x;", "", "", "url", "paramsName", "a", "jsonString", RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f373307a = new x();

    x() {
    }

    public final String a(String url, String paramsName) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(paramsName, "paramsName");
        String queryParameter = Uri.parse(url).getQueryParameter(paramsName);
        if (queryParameter == null) {
            queryParameter = "";
        }
        return ISchemeApi.INSTANCE.a(queryParameter);
    }

    public final String b(String jsonString, String paramsName, String defaultValue) {
        Intrinsics.checkNotNullParameter(paramsName, "paramsName");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (jsonString == null || jsonString.length() == 0) {
            return defaultValue;
        }
        String optString = new JSONObject(jsonString).optString(paramsName, defaultValue);
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(paramsName, defaultValue)");
        return optString;
    }
}
