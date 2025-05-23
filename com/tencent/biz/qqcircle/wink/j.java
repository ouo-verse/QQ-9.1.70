package com.tencent.biz.qqcircle.wink;

import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/wink/j;", "", "", QZoneDTLoginReporter.SCHEMA, "Lkotlin/Pair;", "a", "c", "key", "b", "", "Ljava/util/List;", "materialTypes", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f93954a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> materialTypes;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"meterial", "template", "sticker", "filter", "music", "libtemplate", "url"});
        materialTypes = listOf;
    }

    j() {
    }

    @NotNull
    public final Pair<String, String> a(@Nullable String schema) {
        boolean isBlank;
        String str;
        String str2;
        Object obj;
        boolean isBlank2;
        String b16 = b(schema, "xsj_material_type");
        isBlank = StringsKt__StringsJVMKt.isBlank(b16);
        if (!isBlank) {
            return new Pair<>(b16, b(schema, "xsj_material_id"));
        }
        Iterator<T> it = materialTypes.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                str2 = (String) obj;
                isBlank2 = StringsKt__StringsJVMKt.isBlank(f93954a.b(schema, str2));
                if (!isBlank2) {
                    break;
                }
                b16 = str2;
            } else {
                str2 = b16;
                obj = null;
                break;
            }
        }
        String str3 = (String) obj;
        if (str3 != null) {
            str = f93954a.b(schema, str3);
        }
        if (str == null) {
            return new Pair<>("", "");
        }
        if (Intrinsics.areEqual(str2, "url")) {
            return new Pair<>("page", str);
        }
        return new Pair<>(str2, str);
    }

    @NotNull
    public final String b(@Nullable String schema, @NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            String queryParameter = Uri.parse(schema).getQueryParameter(key);
            if (queryParameter == null) {
                queryParameter = "";
            }
            Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(key).run { this ?: \"\" }");
            return queryParameter;
        } catch (Exception e16) {
            QLog.e("QQWinkSchemaParamsRetriever", 1, "parseSchema error, schema: " + schema + ", key: " + key, e16);
            return "";
        }
    }

    @NotNull
    public final String c(@Nullable String schema) {
        return b(schema, "taskid");
    }
}
