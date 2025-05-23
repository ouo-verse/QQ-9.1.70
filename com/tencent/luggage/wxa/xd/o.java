package com.tencent.luggage.wxa.xd;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.joor.Reflect;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class o extends c {
    private static final int CHECK_ERRNO_CTRL_INDEX_THRESHOLD = 1157;
    public static final String ERRNO_TAG = "errno";
    private static final String TAG = "MicroMsg.AppBrandJsApi";
    private boolean mCanAssertInvalidReturnJson = false;
    private int mCachedCtrlIndex = Integer.MIN_VALUE;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map f144872a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final String f144873b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.af.c f144874c;

        public a(String str, Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                this.f144873b = String.format(str, objArr);
            } else {
                this.f144873b = str;
            }
        }

        public a a(String str, Object obj) {
            this.f144872a.put(str, obj);
            return this;
        }

        public a a(Map map) {
            if (map != null) {
                this.f144872a.putAll(map);
            }
            return this;
        }

        public a(com.tencent.luggage.wxa.af.c cVar, Object... objArr) {
            this.f144874c = cVar;
            this.f144873b = cVar.f121278b;
        }
    }

    public String ERR_MSG_TAG() {
        return "errMsg";
    }

    public final String a(String str, Map map) {
        Map hashMap;
        if ("cancel".equals(str)) {
            str = "fail cancel";
        }
        if (!str.startsWith("fail") && !str.startsWith(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
            String format = String.format(Locale.ENGLISH, "api[%s] assert, argument [reason] must start with special prefix", getName());
            if (!this.mCanAssertInvalidReturnJson) {
                com.tencent.luggage.wxa.tn.w.b(TAG, format);
            } else {
                throw new IllegalArgumentException(format);
            }
        }
        if (map instanceof HashMap) {
            hashMap = map;
        } else if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        if (map != null && map.containsKey(ERR_MSG_TAG())) {
            String str2 = "api " + getName() + ": Cant put errMsg in res!!!";
            if (!this.mCanAssertInvalidReturnJson) {
                com.tencent.luggage.wxa.tn.w.b(TAG, str2);
            } else {
                throw new IllegalArgumentException(str2);
            }
        }
        com.tencent.luggage.wxa.h6.f.a(hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        try {
            jSONObject.putOpt(ERR_MSG_TAG(), getName() + ":" + str);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public boolean canHandleVarianceExecutable() {
        return false;
    }

    public final int getCtrlIndex() {
        if (Integer.MIN_VALUE == this.mCachedCtrlIndex) {
            try {
                this.mCachedCtrlIndex = ((Integer) Reflect.on(getClass()).field("CTRL_INDEX").get()).intValue();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b(TAG, "getCtrlIndex exp = %s", com.tencent.luggage.wxa.tn.w0.a((Throwable) e16));
            }
        }
        return this.mCachedCtrlIndex;
    }

    @Deprecated
    public final String makeReturnJson(@NonNull String str) {
        if (this.mCanAssertInvalidReturnJson && 1157 <= getCtrlIndex()) {
            throw new IllegalArgumentException("makeReturnJson(String) is deprecated for " + getName());
        }
        return makeReturnJson(str, (JSONObject) null);
    }

    public String makeReturnJsonInner(@NonNull String str, @Nullable JSONObject jSONObject) {
        if ("cancel".equals(str)) {
            str = "fail cancel";
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.has(ERR_MSG_TAG())) {
            String str2 = "api " + getName() + ": Cant put errMsg in res!!!";
            if (!this.mCanAssertInvalidReturnJson) {
                com.tencent.luggage.wxa.tn.w.b(TAG, str2);
            } else {
                throw new IllegalArgumentException(str2);
            }
        }
        if (!str.startsWith("fail") && !str.startsWith(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
            String format = String.format(Locale.ENGLISH, "api[%s] assert, argument [reason] must start with special prefix", getName());
            if (!this.mCanAssertInvalidReturnJson) {
                com.tencent.luggage.wxa.tn.w.b(TAG, format);
            } else {
                throw new IllegalArgumentException(format);
            }
        }
        try {
            jSONObject.put(ERR_MSG_TAG(), getName() + ":" + str);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b(TAG, "makeReturnJson with JSONObject, put errMsg, e=%s", e16);
        }
        return jSONObject.toString();
    }

    @Deprecated
    public final String makeReturnJsonWithNativeBuffer(d dVar, String str, Map<String, ? extends Object> map) {
        if (this.mCanAssertInvalidReturnJson && 1157 <= getCtrlIndex()) {
            throw new IllegalArgumentException("makeReturnJsonWithNativeBuffer is deprecated for " + getName());
        }
        if (com.tencent.luggage.wxa.uk.c0.a(dVar.getJsRuntime(), map, (c0.a) dVar.a(c0.a.class)) == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
            return makeReturnJson("fail:convert native buffer parameter fail. native buffer exceed size limit.");
        }
        return makeReturnJson(str, map);
    }

    public ByteBuffer processNativeBuffer(String str, com.tencent.luggage.wxa.ei.l lVar, int i3) {
        return lVar.a(i3, false);
    }

    public final void setCanAssertInvalidReturnJson(boolean z16) {
        this.mCanAssertInvalidReturnJson = z16;
    }

    @Deprecated
    public String makeReturnJson(@NonNull String str, @Nullable Map<String, ? extends Object> map) {
        if (this.mCanAssertInvalidReturnJson && 1157 <= getCtrlIndex()) {
            throw new IllegalArgumentException("makeReturnJson(String, Map<String, ? extends Object>) is deprecated for " + getName());
        }
        return a(str, map);
    }

    public final String makeReturnJsonWithNativeBuffer(d dVar, @NonNull com.tencent.luggage.wxa.af.c cVar, Map<String, ? extends Object> map) {
        if (com.tencent.luggage.wxa.uk.c0.a(dVar.getJsRuntime(), map, (c0.a) dVar.a(c0.a.class)) == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
            return makeReturnJson("fail:convert native buffer parameter fail. native buffer exceed size limit.", com.tencent.luggage.wxa.af.e.f121307c);
        }
        return makeReturnJson(cVar, map);
    }

    @Deprecated
    public String makeReturnJson(@NonNull String str, @Nullable JSONObject jSONObject) {
        if (this.mCanAssertInvalidReturnJson && 1157 <= getCtrlIndex()) {
            throw new IllegalArgumentException("makeReturnJson(String, JSONObject) is deprecated for " + getName());
        }
        return makeReturnJsonInner(str, jSONObject);
    }

    public final String makeReturnJsonWithNativeBuffer(d dVar, String str, @NonNull com.tencent.luggage.wxa.af.c cVar, Map<String, ? extends Object> map) {
        if (com.tencent.luggage.wxa.uk.c0.a(dVar.getJsRuntime(), map, (c0.a) dVar.a(c0.a.class)) == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
            return makeReturnJson("fail:convert native buffer parameter fail. native buffer exceed size limit.", com.tencent.luggage.wxa.af.e.f121307c);
        }
        return makeReturnJson(str, cVar, map);
    }

    public final String makeReturnJson(@NonNull com.tencent.luggage.wxa.af.c cVar) {
        return makeReturnJson((String) null, cVar, (JSONObject) null);
    }

    public final String makeReturnJson(@Nullable String str, @NonNull com.tencent.luggage.wxa.af.c cVar) {
        return makeReturnJson(str, cVar, (JSONObject) null);
    }

    public final String makeReturnJson(@NonNull com.tencent.luggage.wxa.af.c cVar, @Nullable Map<String, ? extends Object> map) {
        return makeReturnJson((String) null, cVar, map);
    }

    public final String makeReturnJson(@Nullable String str, @NonNull com.tencent.luggage.wxa.af.c cVar, @Nullable Map<String, ? extends Object> map) {
        int i3 = cVar.f121277a;
        if (str == null) {
            str = cVar.f121278b;
        }
        if (str == null) {
            str = "";
        }
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            com.tencent.luggage.wxa.tn.w.a(TAG, "makeReturnJson, errno: %d, reason: %s", Integer.valueOf(i3), str);
        }
        if (!(map instanceof HashMap)) {
            map = map == null ? new HashMap<>() : new HashMap(map);
        }
        map.put(ERRNO_TAG, Integer.valueOf(i3));
        return a(str, map);
    }

    public final String makeReturnJson(@NonNull com.tencent.luggage.wxa.af.c cVar, @Nullable JSONObject jSONObject) {
        return makeReturnJson((String) null, cVar, jSONObject);
    }

    public final String makeReturnJson(@Nullable String str, @NonNull com.tencent.luggage.wxa.af.c cVar, @Nullable JSONObject jSONObject) {
        int i3 = cVar.f121277a;
        if (TextUtils.isEmpty(str)) {
            str = cVar.f121278b;
        }
        if (str == null) {
            str = "";
        }
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            com.tencent.luggage.wxa.tn.w.a(TAG, "makeReturnJson, errno: %d, reason: %s", Integer.valueOf(i3), str);
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(ERRNO_TAG, i3);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b(TAG, "makeReturnJson with JSONObject, put errno, e=%s", e16);
        }
        return makeReturnJsonInner(str, jSONObject);
    }
}
