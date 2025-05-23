package com.tencent.mobileqq.wink.schema;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J$\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002J,\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ,\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J,\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J<\u0010 \u001a\u00020\u001f2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004J\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u001e\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u001e\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/schema/d;", "", "", "prefix", "", "args", "j", QZoneDTLoginReporter.SCHEMA, "o", "attrValue", "", "c", "Lkotlin/Pair;", h.F, "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Landroid/content/Intent;", "intent", "e", "Landroid/os/Bundle;", "bundle", "f", "schemaKey", "k", "l", "schemaAttrsMap", "schemaKeyReplaceMap", "", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "formatString", "key", "value", DomainData.DOMAIN_NAME, "g", "formatSchema", "argsJson", "", "needEncode", "p", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f326305a = new d();

    d() {
    }

    private final String j(String prefix, Map<String, String> args) {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(args.entrySet(), ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
        return prefix + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + joinToString$default;
    }

    private final String o(String schema, Map<String, String> args) {
        List split$default;
        Map<String, String> mutableMap;
        split$default = StringsKt__StringsKt.split$default((CharSequence) schema, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 2, 2, (Object) null);
        String str = (String) split$default.get(0);
        if (split$default.size() >= 2) {
            mutableMap = MapsKt__MapsKt.toMutableMap(m(schema));
        } else {
            mutableMap = new LinkedHashMap<>();
        }
        for (Map.Entry<String, String> entry : args.entrySet()) {
            mutableMap.put(entry.getKey(), entry.getValue());
        }
        return j(str, mutableMap);
    }

    public final void a(@Nullable Map<String, String> schemaAttrsMap, @Nullable Intent intent, @Nullable Map<String, String> schemaKeyReplaceMap) {
        if (schemaAttrsMap != null && intent != null) {
            QLog.i("WinkSchemeAttrsUtils", 1, "flatmapSchemaToIntent" + schemaAttrsMap.keySet());
            for (String str : schemaAttrsMap.keySet()) {
                if (!Intrinsics.areEqual("key_scheme", str)) {
                    boolean z16 = false;
                    if (schemaKeyReplaceMap != null && schemaKeyReplaceMap.containsKey(str)) {
                        z16 = true;
                    }
                    if (z16) {
                        intent.putExtra(schemaKeyReplaceMap.get(str), schemaAttrsMap.get(str));
                    } else {
                        intent.putExtra(str, schemaAttrsMap.get(str));
                    }
                }
            }
            return;
        }
        QLog.d("WinkSchemeAttrsUtils", 1, "flatmapSchemaToIntent schemaAttrsMap or bundle empty");
    }

    @Nullable
    public final Map<String, String> b(@Nullable String attrValue) {
        Map<String, String> map;
        try {
            List<String> c16 = c(attrValue);
            if (c16 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                Pair<String, String> h16 = f326305a.h((String) it.next());
                if (h16 != null) {
                    arrayList.add(h16);
                }
            }
            map = MapsKt__MapsKt.toMap(arrayList);
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public final List<String> c(@Nullable String attrValue) {
        boolean z16;
        List<String> split$default;
        if (attrValue != null && attrValue.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) attrValue, new String[]{","}, false, 0, 6, (Object) null);
            return split$default;
        }
        return null;
    }

    @NotNull
    public final HashMap<String, String> d(@Nullable Activity activity) {
        Intent intent;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        return e(intent);
    }

    @NotNull
    public final HashMap<String, String> e(@Nullable Intent intent) {
        Bundle bundle;
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        return f(bundle);
    }

    @NotNull
    public final HashMap<String, String> f(@Nullable Bundle bundle) {
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("key_attrs");
            if (serializable instanceof HashMap) {
                return (HashMap) serializable;
            }
        }
        return new HashMap<>();
    }

    @NotNull
    public final String g(@NotNull String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        String encodedUrl = URLEncoder.encode(schema, "UTF-8");
        Intrinsics.checkNotNullExpressionValue(encodedUrl, "encodedUrl");
        return encodedUrl;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0011 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[Catch: Exception -> 0x0037, TRY_LEAVE, TryCatch #0 {Exception -> 0x0037, blocks: (B:13:0x0005, B:7:0x0012), top: B:12:0x0005 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<String, String> h(@Nullable String attrValue) {
        boolean z16;
        int indexOf$default;
        if (attrValue != null) {
            try {
                if (attrValue.length() != 0) {
                    z16 = false;
                    if (z16) {
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) attrValue, "@", 0, false, 6, (Object) null);
                        String substring = attrValue.substring(0, indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        String substring2 = attrValue.substring(indexOf$default + 1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                        return TuplesKt.to(substring, substring2);
                    }
                    return null;
                }
            } catch (Exception unused) {
                return null;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @NotNull
    public final String i(@NotNull String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        try {
            String jSONObject = new JSONObject(m(schema)).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n            val argsMa\u2026Map).toString()\n        }");
            return jSONObject;
        } catch (Exception unused) {
            return "{}";
        }
    }

    @Nullable
    public final String k(@NotNull String schemaKey, @Nullable Intent intent) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(schemaKey, "schemaKey");
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        return l(schemaKey, bundle);
    }

    @Nullable
    public final String l(@NotNull String schemaKey, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(schemaKey, "schemaKey");
        return f(bundle).get(schemaKey);
    }

    @NotNull
    public final Map<String, String> m(@NotNull String schema) {
        Map<String, String> emptyMap;
        List split$default;
        List split$default2;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        List split$default3;
        Pair pair;
        Map<String, String> emptyMap2;
        Intrinsics.checkNotNullParameter(schema, "schema");
        try {
            split$default = StringsKt__StringsKt.split$default((CharSequence) schema, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 2, 2, (Object) null);
            if (split$default.size() < 2) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
                return emptyMap2;
            }
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            List list = split$default2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 2, 2, (Object) null);
                if (split$default3.size() == 2) {
                    pair = TuplesKt.to(split$default3.get(0), split$default3.get(1));
                } else {
                    pair = TuplesKt.to(split$default3.get(0), "");
                }
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        } catch (Exception unused) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }

    @NotNull
    public final String n(@NotNull String formatString, @NotNull String key, @NotNull String value) {
        boolean contains$default;
        String replace$default;
        Intrinsics.checkNotNullParameter(formatString, "formatString");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            String str = "${" + key + "}";
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) formatString, (CharSequence) str, false, 2, (Object) null);
            if (contains$default) {
                replace$default = StringsKt__StringsJVMKt.replace$default(formatString, str, value, false, 4, (Object) null);
                return replace$default;
            }
            return formatString;
        } catch (Exception unused) {
            return formatString;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0033, code lost:
    
        r8 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r5, "}", r4, false, 4, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String p(@NotNull String formatSchema, @NotNull String argsJson, boolean needEncode) {
        int indexOf$default;
        int indexOf$default2;
        Intrinsics.checkNotNullParameter(formatSchema, "formatSchema");
        Intrinsics.checkNotNullParameter(argsJson, "argsJson");
        try {
            JSONObject jSONObject = new JSONObject(argsJson);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) formatSchema, "${", 0, false, 6, (Object) null);
            String str = formatSchema;
            while (indexOf$default != -1 && indexOf$default2 != -1) {
                String substring = str.substring(indexOf$default + 2, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String optString = jSONObject.optString(substring, "");
                String substring2 = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String substring3 = str.substring(indexOf$default2 + 1);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                str = substring2 + optString + substring3;
                linkedHashSet.add(substring);
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "${", 0, false, 6, (Object) null);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                if (!linkedHashSet.contains(key)) {
                    if (needEncode) {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        String optString2 = jSONObject.optString(key, "");
                        Intrinsics.checkNotNullExpressionValue(optString2, "argsObj.optString(key, \"\")");
                        linkedHashMap.put(key, g(optString2));
                    } else {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        String optString3 = jSONObject.optString(key, "");
                        Intrinsics.checkNotNullExpressionValue(optString3, "argsObj.optString(key, \"\")");
                        linkedHashMap.put(key, optString3);
                    }
                }
            }
            if (!linkedHashMap.isEmpty()) {
                return o(str, linkedHashMap);
            }
            return str;
        } catch (Exception unused) {
            return formatSchema;
        }
    }
}
