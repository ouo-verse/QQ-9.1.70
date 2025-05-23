package com.tencent.mobileqq.zootopia.utils;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005R\u001b\u0010\u0010\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/DataConvertUtil;", "", "Landroid/os/Bundle;", "bundle", "", "", "c", "map", "Lorg/json/JSONObject;", "d", "str", "b", "Lcom/google/gson/Gson;", "Lkotlin/Lazy;", "a", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class DataConvertUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final DataConvertUtil f329546a = new DataConvertUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy gson;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.zootopia.utils.DataConvertUtil$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
                gsonBuilder.disableHtmlEscaping();
                return gsonBuilder.create();
            }
        });
        gson = lazy;
    }

    DataConvertUtil() {
    }

    public final Gson a() {
        Object value = gson.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gson>(...)");
        return (Gson) value;
    }

    public final Map<String, Object> c(Bundle bundle) {
        return xb4.b.f447772a.r(bundle);
    }

    public final JSONObject d(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return xb4.b.f447772a.s(map);
    }

    public final String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable th5) {
            QLog.e("DataConvertUtil", 1, "safelyURLDecode, err.", th5);
            return str;
        }
    }
}
