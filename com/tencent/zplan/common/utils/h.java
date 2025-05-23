package com.tencent.zplan.common.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/common/utils/h;", "", "", "paramString", "", "a", "Lorg/json/JSONObject;", "b", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f385294a = new h();

    h() {
    }

    @Nullable
    public final Map<String, String> a(@Nullable String paramString) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(paramString)) {
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(paramString);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object opt = jSONObject.opt(key);
                if (opt != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap.put(key, opt.toString());
                }
            }
        } catch (JSONException e16) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                a16.e("StringUtil", 1, "convertJsonToMap exception !", e16);
            }
        }
        return hashMap;
    }

    @Nullable
    public final JSONObject b(@Nullable String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
            } catch (JSONException unused) {
                return null;
            }
        }
        return new JSONObject(str);
    }
}
