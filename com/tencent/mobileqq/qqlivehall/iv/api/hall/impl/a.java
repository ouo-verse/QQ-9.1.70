package com.tencent.mobileqq.qqlivehall.iv.api.hall.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/api/hall/impl/a;", "", "", "url", "paramName", "paramValue", "a", "mqq", "", "b", "<init>", "()V", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f274100a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f274100a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String a(@NotNull String url, @NotNull String paramName, @Nullable String paramValue) {
        boolean contains$default;
        String queryParameter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, url, paramName, paramValue);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        if (TextUtils.isEmpty(url)) {
            return url;
        }
        String str = Typography.amp + paramName + '=';
        Uri parse = Uri.parse(url);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) str, false, 2, (Object) null);
        if (contains$default) {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.getQueryParameterNames()");
            Uri.Builder clearQuery = parse.buildUpon().clearQuery();
            Intrinsics.checkNotNullExpressionValue(clearQuery, "uri.buildUpon().clearQuery()");
            for (String str2 : queryParameterNames) {
                if (Intrinsics.areEqual(str2, paramName)) {
                    queryParameter = paramValue;
                } else {
                    queryParameter = parse.getQueryParameter(str2);
                }
                clearQuery.appendQueryParameter(str2, queryParameter);
                url = clearQuery.build().toString();
                Intrinsics.checkNotNullExpressionValue(url, "newUriBuilder.build().toString()");
            }
            return url;
        }
        String builder = parse.buildUpon().appendQueryParameter(paramName, paramValue).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "uri.buildUpon().appendQu\u2026e, paramValue).toString()");
        return builder;
    }

    @NotNull
    public final Map<String, String> b(@NotNull String mqq2) {
        List split$default;
        List split$default2;
        boolean contains$default;
        int indexOf$default;
        List split$default3;
        List split$default4;
        boolean contains$default2;
        int indexOf$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mqq2);
        }
        Intrinsics.checkNotNullParameter(mqq2, "mqq");
        HashMap hashMap = new HashMap();
        try {
            split$default = StringsKt__StringsKt.split$default((CharSequence) mqq2, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            boolean z16 = false;
            for (String str : strArr) {
                split$default4 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                Object[] array2 = split$default4.toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr2 = (String[]) array2;
                if (strArr2.length == 2) {
                    String str2 = strArr2[0];
                    if (str2 != null) {
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                        if (contains$default2) {
                            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str2, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
                            str2 = str2.substring(indexOf$default2 + 1);
                            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (Intrinsics.areEqual("roomid", str2)) {
                        z16 = true;
                    }
                }
            }
            if (!z16) {
                String decode = URLDecoder.decode(mqq2, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(decode, "decode(mqq, \"UTF-8\")");
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) decode, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
                Object[] array3 = split$default3.toArray(new String[0]);
                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                strArr = (String[]) array3;
            }
            for (String str3 : strArr) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                Object[] array4 = split$default2.toArray(new String[0]);
                Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr3 = (String[]) array4;
                if (strArr3 != null && strArr3.length == 2) {
                    String str4 = strArr3[0];
                    if (str4 != null) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                        if (contains$default) {
                            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str4, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
                            str4 = str4.substring(indexOf$default + 1);
                            Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    String decode2 = URLDecoder.decode(strArr3[1]);
                    Intrinsics.checkNotNullExpressionValue(decode2, "decode(value)");
                    hashMap.put(str4, decode2);
                }
            }
        } catch (Exception e16) {
            QLog.e("SchemeUriUtil", 1, "parse mqq schema error " + e16);
        }
        return hashMap;
    }
}
