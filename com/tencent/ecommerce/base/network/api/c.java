package com.tencent.ecommerce.base.network.api;

import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/c;", "", "Lorg/json/JSONObject;", "data", "", "b", "c", "a", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f100804a = new c();

    c() {
    }

    @JvmStatic
    @NotNull
    public static final JSONObject a(@Nullable byte[] data) {
        JSONObject jSONObject;
        try {
            if (data != null) {
                jSONObject = new JSONObject(new String(data, StandardCharsets.UTF_8));
            } else {
                jSONObject = new JSONObject();
            }
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    @JvmStatic
    @NotNull
    public static final byte[] b(@Nullable JSONObject data) {
        String jSONObject;
        if (data != null && (jSONObject = data.toString()) != null) {
            byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            if (bytes != null) {
                return bytes;
            }
        }
        byte[] bytes2 = "{}".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
        return bytes2;
    }

    @JvmStatic
    @NotNull
    public static final JSONObject c(@Nullable byte[] data) {
        return a(data);
    }
}
