package com.tencent.biz.qrcode.util;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0014\u0010\n\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J&\u0010\u0010\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qrcode/util/g;", "", "Landroid/os/Bundle;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "c", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "d", "b", "", "bizType", "data", "", "defaultSig", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f95060a = new g();

    g() {
    }

    @JvmStatic
    public static final void a(@NotNull Bundle bundle, int i3, @NotNull JSONObject data, @Nullable String str) {
        boolean z16;
        String str2;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        if (i3 == 2 && data.has("url") && !data.isNull("url")) {
            String optString = data.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString, "data.optString(KEY_URL)");
            if (optString.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str2 = Uri.parse(optString).getQueryParameter("authKey");
            } else {
                str2 = null;
            }
            if (str2 != null) {
                str = str2;
            }
            bundle.putString("authSig", str);
            return;
        }
        bundle.putString("authSig", str);
    }

    @JvmStatic
    public static final void b(@NotNull Bundle bundle, @NotNull Uri uri) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter(ReportConstant.COSTREPORT_PREFIX);
        int i3 = 0;
        if (queryParameter != null && !TextUtils.isEmpty(queryParameter)) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(queryParameter);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            }
            bundle.putInt(ReportConstant.COSTREPORT_PREFIX, i3);
        } else {
            bundle.putInt(ReportConstant.COSTREPORT_PREFIX, 0);
        }
        bundle.putString("market_channel_source", uri.getQueryParameter("market_channel_source"));
    }

    @JvmStatic
    public static final void c(@NotNull Bundle bundle, @NotNull JSONObject json) {
        boolean z16;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        boolean z17 = true;
        if (Intrinsics.areEqual(json.optString("wpa"), "1")) {
            bundle.putBoolean("issupportwpa", true);
        }
        if (json.has("extvalue") && !json.isNull("extvalue")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!Intrinsics.areEqual(json.optString("exttype"), "1") && !Intrinsics.areEqual(json.optString("exttype"), "2")) {
            z17 = false;
        }
        if (z17 && z16) {
            String optString = json.optString("exttype");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(UrlQRProcessor.EXT_TYPE)");
            String optString2 = json.optString("extvalue");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(UrlQRProcessor.EXT_VALUE)");
            bundle.putString("exttype", optString);
            bundle.putString("extvalue", optString2);
        }
    }

    @JvmStatic
    public static final void d(@NotNull Bundle bundle, @NotNull Uri uri) {
        boolean equals;
        boolean equals2;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter("jump_from");
        equals = StringsKt__StringsJVMKt.equals("webapi", queryParameter, true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals("wegame", queryParameter, true);
            if (equals2) {
                bundle.putString("jump_from", "wegame");
                return;
            }
            return;
        }
        bundle.putString("sourceId", "3_40002");
    }
}
