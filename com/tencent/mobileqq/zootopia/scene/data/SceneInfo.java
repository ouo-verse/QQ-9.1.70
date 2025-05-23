package com.tencent.mobileqq.zootopia.scene.data;

import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \r2\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\n\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0014\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\t\u0010\u0016\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zootopia/scene/data/c;", "", "", DomainData.DOMAIN_NAME, "other", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "i", "Lorg/json/JSONObject;", h.F, "", "e", "j", "c", "f", "b", "", "needRemoveKeys", "", "o", "k", "l", "toString", "hashCode", "equals", "a", "I", "g", "()I", "sceneType", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setJsonStr", "(Ljava/lang/String;)V", "jsonStr", "<init>", "(ILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.scene.data.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class SceneInfo {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final SceneInfo f329126d = new SceneInfo(-1, "");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sceneType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jsonStr;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/scene/data/c$a;", "", "", "jsonStr", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "b", "paramJson", "key", "value", "a", PatternUtils.NO_MATCH, "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "c", "()Lcom/tencent/mobileqq/zootopia/scene/data/c;", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.scene.data.c$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@NotNull String paramJson, @NotNull String key, @NotNull Object value) {
            JSONObject jSONObject;
            Intrinsics.checkNotNullParameter(paramJson, "paramJson");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                jSONObject = new JSONObject(paramJson);
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return paramJson;
            }
            jSONObject.put(key, value);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "paramsJson.toString()");
            return jSONObject2;
        }

        @Nullable
        public final SceneInfo b(@Nullable String jsonStr) {
            boolean z16;
            JSONObject jSONObject;
            if (jsonStr != null && jsonStr.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
            try {
                jSONObject = new JSONObject(jsonStr);
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("ViewType");
            if (optInt <= 0) {
                optInt = jSONObject.optInt("sceneType");
            }
            return new SceneInfo(optInt, jsonStr);
        }

        @NotNull
        public final SceneInfo c() {
            return SceneInfo.f329126d;
        }

        Companion() {
        }
    }

    public SceneInfo(int i3, @NotNull String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        this.sceneType = i3;
        this.jsonStr = jsonStr;
    }

    @NotNull
    public final String b() {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        String str = null;
        try {
            jSONObject = new JSONObject(this.jsonStr);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return "";
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("SubScene");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("ActionParams")) != null) {
            str = optJSONObject.toString();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final int c() {
        return h().optInt("BrandId", -1);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getJsonStr() {
        return this.jsonStr;
    }

    @NotNull
    public final String e() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(this.jsonStr);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return "";
        }
        String optString = jSONObject.optString("NativePageHash");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsJson.optString(Zoo\u2026nts.KEY_NATIVE_PAGE_HASH)");
        return optString;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SceneInfo)) {
            return false;
        }
        SceneInfo sceneInfo = (SceneInfo) other;
        if (this.sceneType == sceneInfo.sceneType && Intrinsics.areEqual(this.jsonStr, sceneInfo.jsonStr)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        String jSONObject = h().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "paramsJson.toString()");
        return jSONObject;
    }

    /* renamed from: g, reason: from getter */
    public final int getSceneType() {
        return this.sceneType;
    }

    @NotNull
    public final JSONObject h() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(this.jsonStr);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return new JSONObject();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("SubScene");
        if (optJSONObject != null) {
            jSONObject2 = optJSONObject.optJSONObject("SceneParams");
        }
        if (jSONObject2 == null) {
            return new JSONObject();
        }
        return jSONObject2;
    }

    public int hashCode() {
        return (this.sceneType * 31) + this.jsonStr.hashCode();
    }

    public final int i() {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        try {
            jSONObject = new JSONObject(this.jsonStr);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("SubScene")) == null) {
            return -1;
        }
        return optJSONObject.optInt("SceneType");
    }

    public final int j() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(this.jsonStr);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return -1;
        }
        return jSONObject.optInt("ViewportType", -1);
    }

    public final boolean k() {
        int i3 = i();
        if (i3 == 1 || i3 == 6) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        if (i() == 0) {
            return true;
        }
        return false;
    }

    public final boolean m(@Nullable SceneInfo other) {
        if (other == null || other.sceneType != this.sceneType || other.i() != i() || other.j() != j() || !Intrinsics.areEqual(other.e(), e()) || !a.a(other.h(), h())) {
            return false;
        }
        return true;
    }

    public final boolean n() {
        if (this.sceneType > 0) {
            return true;
        }
        return false;
    }

    public final void o(@NotNull List<String> needRemoveKeys) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(needRemoveKeys, "needRemoveKeys");
        try {
            jSONObject = new JSONObject(this.jsonStr);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<T> it = needRemoveKeys.iterator();
        while (it.hasNext()) {
            jSONObject.remove((String) it.next());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "paramsJson.toString()");
        this.jsonStr = jSONObject2;
    }

    @NotNull
    public String toString() {
        return "SceneInfo(sceneType=" + this.sceneType + ", jsonStr=" + this.jsonStr + ')';
    }
}
