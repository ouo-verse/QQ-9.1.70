package com.tencent.qmethod.monitor.config;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.config.bean.ConfigRule;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.api.ApiInvokeAnalyse;
import com.tencent.qmethod.pandoraex.api.b;
import com.tencent.qmethod.pandoraex.api.v;
import com.tencent.qmethod.pandoraex.core.g;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import fr3.f;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00102\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b8\u00109J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\n\"\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\n\"\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0014J\"\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\u0012J\u000f\u0010\u001b\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\u000e\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\bR&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020&0%8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010)R6\u00101\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020,0+j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020,`-8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b!\u0010.\u001a\u0004\b/\u00100R\"\u00107\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b$\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/qmethod/monitor/config/c;", "", "Lcom/tencent/qmethod/monitor/config/bean/d;", "", "k", "Lcom/tencent/qmethod/monitor/config/GlobalConfigType;", "type", "a", "", "module", "", DTConstants.TAG.API, "Lfr3/b;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;[Ljava/lang/String;)Lfr3/b;", "Lfr3/d;", "d", "(Ljava/lang/String;[Ljava/lang/String;)Lfr3/d;", "", "rate", "", "maxReport", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "scene", "o", "apiName", "l", "e", "()Lcom/tencent/qmethod/monitor/config/bean/d;", "f", "g", "business", "Lfr3/e;", "b", "permLocation", "Lfr3/f;", "c", "", "Lcom/tencent/qmethod/monitor/config/bean/ConfigRule;", "Ljava/util/Map;", h.F, "()Ljava/util/Map;", "appConfigRules", "Ljava/util/HashMap;", "Lcom/tencent/qmethod/monitor/config/bean/e;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "j", "()Ljava/util/HashMap;", "sceneSampleRateMap", "Lcom/tencent/qmethod/monitor/config/GlobalConfigType;", "i", "()Lcom/tencent/qmethod/monitor/config/GlobalConfigType;", "setGlobalConfigType$qmethod_privacy_monitor_tencentBuglyRelease", "(Lcom/tencent/qmethod/monitor/config/GlobalConfigType;)V", "globalConfigType", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, ConfigRule> appConfigRules = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, e> sceneSampleRateMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GlobalConfigType globalConfigType = GlobalConfigType.NORMAL_NORMAL_NORMAL;

    private final void k(@NotNull com.tencent.qmethod.monitor.config.bean.d dVar) {
        int i3 = d.f343590a[this.globalConfigType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        List<com.tencent.qmethod.pandoraex.api.b> d16 = dVar.d();
                        com.tencent.qmethod.pandoraex.api.b b16 = new b.a().f("default_module").a(new v.a().g("before").i("normal").a()).a(new v.a().g("deny_retry").i("ban").a()).a(new v.a().g("back").i("normal").a()).a(new v.a().g("silence").h(10000L).i("normal").a()).a(new v.a().g("high_freq").c(new com.tencent.qmethod.pandoraex.api.c(10000L, 10)).i("normal").a()).a(new v.a().g("normal").i("normal").a()).a(new v.a().g("mod_no_perm").i("ban").a()).b();
                        Intrinsics.checkExpressionValueIsNotNull(b16, "Config.Builder()\n       \u2026                 .build()");
                        d16.add(b16);
                    }
                } else {
                    Map<String, com.tencent.qmethod.pandoraex.api.b> a16 = g.a();
                    Intrinsics.checkExpressionValueIsNotNull(a16, "getInitConfigMap()");
                    for (Map.Entry<String, com.tencent.qmethod.pandoraex.api.b> entry : a16.entrySet()) {
                        List<com.tencent.qmethod.pandoraex.api.b> d17 = dVar.d();
                        com.tencent.qmethod.pandoraex.api.b value = entry.getValue();
                        Intrinsics.checkExpressionValueIsNotNull(value, "it.value");
                        d17.add(value);
                    }
                }
            } else {
                List<com.tencent.qmethod.pandoraex.api.b> d18 = dVar.d();
                com.tencent.qmethod.pandoraex.api.b b17 = new b.a().f("default_module").a(new v.a().g("before").i("ban").a()).a(new v.a().g("deny_retry").i("ban").a()).a(new v.a().g("back").i("normal").a()).a(new v.a().g("silence").h(10000L).i("normal").a()).a(new v.a().g("high_freq").c(new com.tencent.qmethod.pandoraex.api.c(10000L, 10)).i("normal").a()).a(new v.a().g("normal").i("normal").a()).a(new v.a().g("mod_no_perm").i("ban").a()).b();
                Intrinsics.checkExpressionValueIsNotNull(b17, "Config.Builder()\n       \u2026                 .build()");
                d18.add(b17);
            }
        } else {
            List<com.tencent.qmethod.pandoraex.api.b> d19 = dVar.d();
            com.tencent.qmethod.pandoraex.api.b b18 = new b.a().f("default_module").a(new v.a().g("before").i("ban").a()).a(new v.a().g("deny_retry").i("ban").a()).a(new v.a().g("back").i("ban").a()).a(new v.a().g("silence").h(10000L).i("normal").a()).a(new v.a().g("high_freq").c(new com.tencent.qmethod.pandoraex.api.c(10000L, 10)).i("normal").a()).a(new v.a().g("normal").i("normal").a()).a(new v.a().g("mod_no_perm").i("ban").a()).b();
            Intrinsics.checkExpressionValueIsNotNull(b18, "Config.Builder()\n       \u2026                 .build()");
            d19.add(b18);
        }
        o.e("RuleConfig", "globalConfigType=" + this.globalConfigType);
    }

    @NotNull
    public final c a(@NotNull GlobalConfigType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.globalConfigType = type;
        return this;
    }

    @NotNull
    public final fr3.e b(@NotNull String business) {
        Intrinsics.checkParameterIsNotNull(business, "business");
        return new fr3.e(business);
    }

    @NotNull
    public final f c(@NotNull String permLocation) {
        Intrinsics.checkParameterIsNotNull(permLocation, "permLocation");
        return new f(permLocation);
    }

    @NotNull
    public final fr3.d d(@NotNull String module, @NotNull String... api) {
        Set mutableSetOf;
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(api, "api");
        mutableSetOf = SetsKt__SetsKt.mutableSetOf((String[]) Arrays.copyOf(api, api.length));
        return new fr3.d(this, module, mutableSetOf);
    }

    @NotNull
    public final com.tencent.qmethod.monitor.config.bean.d e() {
        com.tencent.qmethod.monitor.config.bean.d d16 = com.tencent.qmethod.monitor.config.bean.d.INSTANCE.d();
        k(d16);
        for (Map.Entry<String, e> entry : this.sceneSampleRateMap.entrySet()) {
            d16.g().put(entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<String, ConfigRule>> it = this.appConfigRules.entrySet().iterator();
        while (it.hasNext()) {
            d16.d().add(it.next().getValue().m());
        }
        return d16;
    }

    @NotNull
    public final com.tencent.qmethod.monitor.config.bean.d f() {
        com.tencent.qmethod.monitor.config.bean.d dVar = new com.tencent.qmethod.monitor.config.bean.d(0L, null, null, 7, null);
        if (this.globalConfigType != GlobalConfigType.NORMAL_NORMAL_NORMAL) {
            k(dVar);
        }
        Iterator<Map.Entry<String, ConfigRule>> it = this.appConfigRules.entrySet().iterator();
        while (it.hasNext()) {
            dVar.d().add(it.next().getValue().m());
        }
        return dVar;
    }

    @NotNull
    public final com.tencent.qmethod.monitor.config.bean.d g() {
        com.tencent.qmethod.monitor.config.bean.d dVar = new com.tencent.qmethod.monitor.config.bean.d(0L, null, null, 7, null);
        for (Map.Entry<String, e> entry : this.sceneSampleRateMap.entrySet()) {
            dVar.g().put(entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<String, ConfigRule>> it = this.appConfigRules.entrySet().iterator();
        while (it.hasNext()) {
            dVar.d().add(it.next().getValue().m());
        }
        return dVar;
    }

    @NotNull
    public final Map<String, ConfigRule> h() {
        return this.appConfigRules;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final GlobalConfigType getGlobalConfigType() {
        return this.globalConfigType;
    }

    @NotNull
    public final HashMap<String, e> j() {
        return this.sceneSampleRateMap;
    }

    @NotNull
    public final c l(@NotNull String apiName, @FloatRange(from = 0.0d, to = 1.0d) double rate) {
        Intrinsics.checkParameterIsNotNull(apiName, "apiName");
        o.e("SampleHelper", "currentSampleInfo Analyse: api=" + apiName + ", rate=" + rate);
        ApiInvokeAnalyse.f343783d.h(apiName, rate);
        return this;
    }

    @NotNull
    public final c m(@FloatRange(from = 1.0E-4d, to = 1.0d) double rate, @IntRange(from = 35) int maxReport) {
        this.sceneSampleRateMap.put(ReadInJoyMMapKvStorage.NAME_DEFAULT, e.INSTANCE.b(ReadInJoyMMapKvStorage.NAME_DEFAULT, rate, maxReport));
        return this;
    }

    @NotNull
    public final fr3.b n(@NotNull String module, @NotNull String... api) {
        Set mutableSetOf;
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(api, "api");
        mutableSetOf = SetsKt__SetsKt.mutableSetOf((String[]) Arrays.copyOf(api, api.length));
        return new fr3.b(this, module, mutableSetOf);
    }

    @NotNull
    public final c o(@NotNull String scene, @FloatRange(from = 0.05d, to = 1.0d) double rate, @IntRange(from = 10) int maxReport) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        this.sceneSampleRateMap.put(scene, e.INSTANCE.b(scene, rate, maxReport));
        return this;
    }
}
