package com.tencent.qmethod.monitor.config.bean;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u0000 12\u00020\u0001:\u0001\u0011B%\u0012\b\b\u0003\u0010*\u001a\u00020$\u0012\b\b\u0002\u00100\u001a\u00020\b\u0012\b\b\u0002\u00103\u001a\u00020\b\u00a2\u0006\u0004\b4\u00105J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J,\u0010\f\u001a\u00020\u00052\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0000H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0000J\b\u0010\u0015\u001a\u00020\bH\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000J\t\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R3\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00103\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/\u00a8\u00066"}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/d;", "", "", "Lcom/tencent/qmethod/pandoraex/api/b;", "newConfig", "", "i", "Ljava/util/HashMap;", "", "Lcom/tencent/qmethod/monitor/config/bean/e;", "Lkotlin/collections/HashMap;", "newSceneSampleRates", "k", "newDynamicConfig", "j", "", "b", "a", "Lorg/json/JSONObject;", "e", "c", "toString", h.F, "", "hashCode", "other", "equals", "Ljava/util/HashMap;", "g", "()Ljava/util/HashMap;", "sceneSampleRate", "", "Ljava/util/List;", "d", "()Ljava/util/List;", Constants.Configs.CONFIGS, "", "J", "getTimestamp", "()J", DomainData.DOMAIN_NAME, "(J)V", "timestamp", "Ljava/lang/String;", "getSignature", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "signature", "f", "l", "md5", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final /* data */ class d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, e> sceneSampleRate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qmethod.pandoraex.api.b> configs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long timestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String signature;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String md5;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/d$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "md5", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "Lcom/tencent/qmethod/monitor/config/bean/d;", "b", "input", "a", "d", "", "KEY_NOT_FOUND", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.config.bean.d$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ d c(Companion companion, JSONObject jSONObject, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            return companion.b(jSONObject, str, z16);
        }

        @Nullable
        public final d a(@NotNull String input) {
            Intrinsics.checkParameterIsNotNull(input, "input");
            try {
                JSONObject jSONObject = new JSONObject(input);
                String optString = jSONObject.optString("md5");
                Intrinsics.checkExpressionValueIsNotNull(optString, "json.optString(\"md5\")");
                return c(this, jSONObject, optString, false, 4, null);
            } catch (JSONException e16) {
                o.c("DynamicConfig", "convert to DConfig fail, " + e16);
                return null;
            }
        }

        @Nullable
        public final d b(@NotNull JSONObject json, @NotNull String md5, boolean first) {
            IntRange intRange;
            int first2;
            int last;
            IntRange intRange2;
            int first3;
            int last2;
            Intrinsics.checkParameterIsNotNull(json, "json");
            Intrinsics.checkParameterIsNotNull(md5, "md5");
            long optLong = json.optLong("timestamp");
            String optString = json.optString("signature");
            Intrinsics.checkExpressionValueIsNotNull(optString, "json.optString(\"signature\")");
            d dVar = new d(optLong, optString, md5);
            double d16 = -1;
            double optDouble = json.optDouble("sampleRate", d16);
            int optInt = json.optInt("totalReportLimit", -1);
            if (d16 != optDouble && -1 != optInt) {
                dVar.g().put(ReadInJoyMMapKvStorage.NAME_DEFAULT, new e(ReadInJoyMMapKvStorage.NAME_DEFAULT, optDouble, optInt));
            }
            JSONArray optJSONArray = json.optJSONArray("sceneSampleRate");
            if (optJSONArray != null && (first3 = (intRange2 = new IntRange(0, optJSONArray.length() - 1)).getFirst()) <= (last2 = intRange2.getLast())) {
                while (true) {
                    HashMap<String, e> g16 = dVar.g();
                    String optString2 = optJSONArray.optJSONObject(first3).optString("scene");
                    Intrinsics.checkExpressionValueIsNotNull(optString2, "it.optJSONObject(i).optString(\"scene\")");
                    e.Companion companion = e.INSTANCE;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(first3);
                    Intrinsics.checkExpressionValueIsNotNull(optJSONObject, "it.optJSONObject(i)");
                    g16.put(optString2, companion.a(optJSONObject));
                    if (first3 == last2) {
                        break;
                    }
                    first3++;
                }
            }
            JSONArray optJSONArray2 = json.optJSONArray(Constants.Configs.CONFIGS);
            if (optJSONArray2 != null && (first2 = (intRange = new IntRange(0, optJSONArray2.length() - 1)).getFirst()) <= (last = intRange.getLast())) {
                while (true) {
                    com.tencent.qmethod.monitor.config.a aVar = com.tencent.qmethod.monitor.config.a.f343552a;
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(first2);
                    Intrinsics.checkExpressionValueIsNotNull(optJSONObject2, "it.optJSONObject(i)");
                    Iterator<T> it = aVar.b(optJSONObject2).iterator();
                    while (it.hasNext()) {
                        dVar.d().add((com.tencent.qmethod.pandoraex.api.b) it.next());
                    }
                    if (first2 == last) {
                        break;
                    }
                    first2++;
                }
            }
            if (first) {
                dVar.m(dVar.a());
                return dVar;
            }
            if (dVar.b()) {
                o.a("DynamicConfig", "convert to DConfig checkPass!");
                return dVar;
            }
            o.c("DynamicConfig", "convert to DConfig fail, check fail= " + dVar);
            return null;
        }

        @NotNull
        public final d d() {
            d dVar = new d(0L, null, null, 7, null);
            dVar.g().put("before", new e("before", 0.5d, 10));
            dVar.g().put("deny_retry", new e("deny_retry", 0.1d, 10));
            dVar.g().put("illegal_scene", new e("illegal_scene", 0.1d, 10));
            dVar.g().put("back", new e("back", 0.2d, 15));
            dVar.g().put("mod_no_perm", new e("mod_no_perm", 0.2d, 15));
            dVar.g().put("silence", new e("silence", 0.2d, 15));
            dVar.g().put("high_freq", new e("high_freq", 0.2d, 15));
            dVar.g().put("normal", new e("normal", 0.1d, 10));
            dVar.g().put(ReadInJoyMMapKvStorage.NAME_DEFAULT, new e(ReadInJoyMMapKvStorage.NAME_DEFAULT, 0.005d, 35));
            dVar.g().put("func_invoke_user", new e("func_invoke_user", 0.001d, 30));
            dVar.g().put("func_invoke_api", new e("func_invoke_api", 0.001d, 0));
            dVar.g().put("func_app_download", new e("func_app_download", 0.001d, 5));
            dVar.g().put("func_auto_monitor", new e("func_auto_monitor", 0.001d, 5));
            dVar.g().put("func_dynamic_resource", new e("func_dynamic_resource", 0.001d, 0));
            dVar.g().put("func_receiver_monitor", new e("func_receiver_monitor", 0.001d, 2));
            dVar.g().put("func_screenshot_monitor", new e("func_screenshot_monitor", 0.001d, 2));
            dVar.g().put("func_traffic_user", new e("func_traffic_user", 0.001d, 30));
            dVar.g().put("func_traffic_event", new e("func_traffic_event", 0.01d, 5));
            dVar.g().put("func_http_plain_user", new e("func_http_plain_user", 0.001d, 30));
            dVar.g().put("func_http_plain_event", new e("func_http_plain_event", 0.01d, 5));
            dVar.g().put("func_net_stack_event", new e("func_net_stack_event", 0.01d, 5));
            dVar.g().put("secondary_sample", new e("secondary_sample", 0.5d, 0));
            dVar.g().put("func_jump_interrupt", new e("func_jump_interrupt", 0.005d, 0));
            return dVar;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d() {
        this(0L, null, null, 7, null);
    }

    private final void i(List<? extends com.tencent.qmethod.pandoraex.api.b> newConfig) {
        Iterator<T> it = newConfig.iterator();
        while (it.hasNext()) {
            this.configs.add((com.tencent.qmethod.pandoraex.api.b) it.next());
        }
    }

    private final void j(d newDynamicConfig) {
        long j3 = newDynamicConfig.timestamp;
        if (j3 != 0) {
            this.timestamp = j3;
        }
        if (!TextUtils.isEmpty(newDynamicConfig.md5)) {
            this.md5 = newDynamicConfig.md5;
        }
    }

    private final void k(HashMap<String, e> newSceneSampleRates) {
        for (Map.Entry<String, e> entry : newSceneSampleRates.entrySet()) {
            if (Intrinsics.areEqual(ReadInJoyMMapKvStorage.NAME_DEFAULT, entry.getKey())) {
                if (this.sceneSampleRate.get(ReadInJoyMMapKvStorage.NAME_DEFAULT) == null) {
                    this.sceneSampleRate.put(ReadInJoyMMapKvStorage.NAME_DEFAULT, entry.getValue());
                } else {
                    if (-1 != entry.getValue().getRate()) {
                        e eVar = this.sceneSampleRate.get(ReadInJoyMMapKvStorage.NAME_DEFAULT);
                        if (eVar == null) {
                            Intrinsics.throwNpe();
                        }
                        eVar.h(entry.getValue().getRate());
                    }
                    if (-1 != entry.getValue().getMaxReport()) {
                        e eVar2 = this.sceneSampleRate.get(ReadInJoyMMapKvStorage.NAME_DEFAULT);
                        if (eVar2 == null) {
                            Intrinsics.throwNpe();
                        }
                        eVar2.g(entry.getValue().getMaxReport());
                    }
                }
            } else if (-1 != entry.getValue().getRate() && -1 != entry.getValue().getMaxReport()) {
                this.sceneSampleRate.put(entry.getValue().getScene(), entry.getValue());
            }
        }
    }

    @NotNull
    public final String a() {
        com.tencent.qmethod.monitor.base.util.e eVar = com.tencent.qmethod.monitor.base.util.e.f343535a;
        StringBuilder sb5 = new StringBuilder();
        JSONObject e16 = e();
        e16.remove("signature");
        sb5.append(e16);
        sb5.append(com.tencent.qmethod.monitor.a.f343451h.g().getAppId());
        String sb6 = sb5.toString();
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkExpressionValueIsNotNull(defaultCharset, "Charset.defaultCharset()");
        if (sb6 != null) {
            byte[] bytes = sb6.getBytes(defaultCharset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return eVar.b(bytes);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean b() {
        String a16 = a();
        o.a("DynamicConfig", "signature=" + a16);
        return Intrinsics.areEqual(this.signature, a16);
    }

    @NotNull
    public final d c() {
        d dVar = new d(this.timestamp, this.signature, this.md5);
        for (Map.Entry<String, e> entry : this.sceneSampleRate.entrySet()) {
            dVar.sceneSampleRate.put(entry.getKey(), new e(entry.getValue().getScene(), entry.getValue().getRate(), entry.getValue().getMaxReport()));
        }
        for (com.tencent.qmethod.pandoraex.api.b bVar : this.configs) {
            List<com.tencent.qmethod.pandoraex.api.b> list = dVar.configs;
            com.tencent.qmethod.pandoraex.api.b a16 = com.tencent.qmethod.pandoraex.api.b.a(bVar);
            Intrinsics.checkExpressionValueIsNotNull(a16, "Config.getCopy(it)");
            list.add(a16);
        }
        return dVar;
    }

    @NotNull
    public final List<com.tencent.qmethod.pandoraex.api.b> d() {
        return this.configs;
    }

    @NotNull
    public final JSONObject e() {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("signature", this.signature);
        e eVar = this.sceneSampleRate.get(ReadInJoyMMapKvStorage.NAME_DEFAULT);
        int i3 = -1;
        if (eVar != null) {
            obj = Double.valueOf(eVar.getRate());
        } else {
            obj = -1;
        }
        jSONObject.put("sampleRate", obj);
        jSONObject.put("md5", this.md5);
        e eVar2 = this.sceneSampleRate.get(ReadInJoyMMapKvStorage.NAME_DEFAULT);
        if (eVar2 != null) {
            i3 = eVar2.getMaxReport();
        }
        jSONObject.put("totalReportLimit", i3);
        JSONArray jSONArray = new JSONArray();
        HashMap<String, e> hashMap = this.sceneSampleRate;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, e> entry : hashMap.entrySet()) {
            if (!ReadInJoyMMapKvStorage.NAME_DEFAULT.contentEquals(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(((e) ((Map.Entry) it.next()).getValue()).c());
        }
        jSONObject.put("sceneSampleRate", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        Iterator<T> it5 = this.configs.iterator();
        while (it5.hasNext()) {
            jSONArray2.mo162put(com.tencent.qmethod.monitor.config.a.f343552a.a((com.tencent.qmethod.pandoraex.api.b) it5.next()));
        }
        jSONObject.put(Constants.Configs.CONFIGS, jSONArray2);
        return jSONObject;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof d) {
                d dVar = (d) other;
                if (this.timestamp != dVar.timestamp || !Intrinsics.areEqual(this.signature, dVar.signature) || !Intrinsics.areEqual(this.md5, dVar.md5)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final HashMap<String, e> g() {
        return this.sceneSampleRate;
    }

    @NotNull
    public final d h(@NotNull d newDynamicConfig) {
        Intrinsics.checkParameterIsNotNull(newDynamicConfig, "newDynamicConfig");
        i(newDynamicConfig.configs);
        k(newDynamicConfig.sceneSampleRate);
        j(newDynamicConfig);
        return this;
    }

    public int hashCode() {
        int i3;
        int a16 = androidx.fragment.app.a.a(this.timestamp) * 31;
        String str = this.signature;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (a16 + i3) * 31;
        String str2 = this.md5;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.md5 = str;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.signature = str;
    }

    public final void n(long j3) {
        this.timestamp = j3;
    }

    @NotNull
    public String toString() {
        String jSONObject = e().toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "getJSONObject().toString()");
        return jSONObject;
    }

    public d(@androidx.annotation.IntRange(from = 0) long j3, @NotNull String signature, @NotNull String md5) {
        Intrinsics.checkParameterIsNotNull(signature, "signature");
        Intrinsics.checkParameterIsNotNull(md5, "md5");
        this.timestamp = j3;
        this.signature = signature;
        this.md5 = md5;
        this.sceneSampleRate = new HashMap<>();
        this.configs = new ArrayList();
    }

    public /* synthetic */ d(long j3, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2);
    }
}
