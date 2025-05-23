package com.tencent.mobileqq.guild.share.util;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/c;", "", "Lcom/tencent/mobileqq/guild/share/m;", "", "style", "", "c", "", "url", "paramValue", "a", "paramName", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f235122a = new c();

    c() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String url, @Nullable String paramValue) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105954", false)) {
            str = "b";
        } else {
            str = "businessType";
        }
        return b(url, str, paramValue);
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String url, @NotNull String paramName, @Nullable String paramValue) {
        boolean contains$default;
        String queryParameter;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        if (TextUtils.isEmpty(url)) {
            return url;
        }
        String str = ContainerUtils.FIELD_DELIMITER + paramName + ContainerUtils.KEY_VALUE_DELIMITER;
        String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + paramName + ContainerUtils.KEY_VALUE_DELIMITER;
        Uri parse = Uri.parse(url);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) str, false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) str2, false, 2, (Object) null);
            if (!contains$default2) {
                String builder = parse.buildUpon().appendQueryParameter(paramName, paramValue).toString();
                Intrinsics.checkNotNullExpressionValue(builder, "uri.buildUpon().appendQu\u2026e, paramValue).toString()");
                return builder;
            }
        }
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.getQueryParameterNames()");
        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
        Intrinsics.checkNotNullExpressionValue(clearQuery, "uri.buildUpon().clearQuery()");
        for (String str3 : queryParameterNames) {
            if (Intrinsics.areEqual(str3, paramName)) {
                queryParameter = paramValue;
            } else {
                queryParameter = parse.getQueryParameter(str3);
            }
            clearQuery.appendQueryParameter(str3, queryParameter);
            url = clearQuery.build().toString();
            Intrinsics.checkNotNullExpressionValue(url, "newUriBuilder.build().toString()");
        }
        return url;
    }

    @JvmStatic
    public static final void c(@NotNull m mVar, int i3) {
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        if (i3 == 1) {
            mVar.d(196, null);
            mVar.d(197, null);
            mVar.d(213, null);
        }
    }
}
