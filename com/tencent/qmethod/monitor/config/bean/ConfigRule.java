package com.tencent.qmethod.monitor.config.bean;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.config.CacheTime;
import com.tencent.qmethod.monitor.config.GeneralRule;
import com.tencent.qmethod.monitor.config.HighFrequency;
import com.tencent.qmethod.monitor.config.Silence;
import com.tencent.qmethod.pandoraex.api.v;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0002\u00066BG\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0019\u0012\b\u0010&\u001a\u0004\u0018\u00010!\u0012\b\u0010-\u001a\u0004\u0018\u00010'\u0012\b\u00103\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\"\u001a\u0004\b\u001a\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00103\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010/\u001a\u0004\b\u0016\u00100\"\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/ConfigRule;", "", "Lorg/json/JSONObject;", DomainData.DOMAIN_NAME, "", "Lcom/tencent/qmethod/pandoraex/api/v;", "a", "Lcom/tencent/qmethod/pandoraex/api/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "module", "b", DTConstants.TAG.API, "c", "f", "page", "Lcom/tencent/qmethod/monitor/config/GeneralRule;", "d", "Lcom/tencent/qmethod/monitor/config/GeneralRule;", "g", "()Lcom/tencent/qmethod/monitor/config/GeneralRule;", "k", "(Lcom/tencent/qmethod/monitor/config/GeneralRule;)V", TransferConfig.ExtendParamFloats.KEY_RULE, "Lcom/tencent/qmethod/monitor/config/HighFrequency;", "Lcom/tencent/qmethod/monitor/config/HighFrequency;", "()Lcom/tencent/qmethod/monitor/config/HighFrequency;", "j", "(Lcom/tencent/qmethod/monitor/config/HighFrequency;)V", "highFrequency", "Lcom/tencent/qmethod/monitor/config/Silence;", "Lcom/tencent/qmethod/monitor/config/Silence;", h.F, "()Lcom/tencent/qmethod/monitor/config/Silence;", "l", "(Lcom/tencent/qmethod/monitor/config/Silence;)V", "silence", "Lcom/tencent/qmethod/monitor/config/CacheTime;", "Lcom/tencent/qmethod/monitor/config/CacheTime;", "()Lcom/tencent/qmethod/monitor/config/CacheTime;", "i", "(Lcom/tencent/qmethod/monitor/config/CacheTime;)V", "cacheTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qmethod/monitor/config/GeneralRule;Lcom/tencent/qmethod/monitor/config/HighFrequency;Lcom/tencent/qmethod/monitor/config/Silence;Lcom/tencent/qmethod/monitor/config/CacheTime;)V", "RuleName", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final /* data */ class ConfigRule {

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<RuleName, v.a> f343553h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<GeneralRule, ArrayList<v.a>> f343554i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String module;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String api;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String page;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GeneralRule rule;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HighFrequency highFrequency;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Silence silence;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CacheTime cacheTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/ConfigRule$RuleName;", "", "(Ljava/lang/String;I)V", "BEFORE_BAN_RULE", "BACK_BAN_RULE", "BACK_CACHE_ONLY_RULE", "BACK_MEMORY_RULE", "BACK_NORMAL_RULE", "BACK_STORAGE_RULE", "FRONT_BAN_RULE", "FRONT_MEMORY_RULE", "FRONT_NORMAL_RULE", "FRONT_STORAGE_RULE", "FRONT_CACHE_ONLY_RULE", "HIGH_FREQ_BAN_RULE", "HIGH_FREQ_MEMORY_RULE", "HIGH_FREQ_NORMAL_RULE", "HIGH_FREQ_STORAGE_RULE", "ILLEGAL_API_RULE", "ILLEGAL_SCENE_RULE", "SILENCE_NORMAL_RULE", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public enum RuleName {
        BEFORE_BAN_RULE,
        BACK_BAN_RULE,
        BACK_CACHE_ONLY_RULE,
        BACK_MEMORY_RULE,
        BACK_NORMAL_RULE,
        BACK_STORAGE_RULE,
        FRONT_BAN_RULE,
        FRONT_MEMORY_RULE,
        FRONT_NORMAL_RULE,
        FRONT_STORAGE_RULE,
        FRONT_CACHE_ONLY_RULE,
        HIGH_FREQ_BAN_RULE,
        HIGH_FREQ_MEMORY_RULE,
        HIGH_FREQ_NORMAL_RULE,
        HIGH_FREQ_STORAGE_RULE,
        ILLEGAL_API_RULE,
        ILLEGAL_SCENE_RULE,
        SILENCE_NORMAL_RULE
    }

    static {
        Set<String> of5;
        HashMap<RuleName, v.a> hashMapOf;
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        ArrayList arrayListOf5;
        ArrayList arrayListOf6;
        ArrayList arrayListOf7;
        ArrayList arrayListOf8;
        ArrayList arrayListOf9;
        ArrayList arrayListOf10;
        ArrayList arrayListOf11;
        ArrayList arrayListOf12;
        HashMap<GeneralRule, ArrayList<v.a>> hashMapOf2;
        RuleName ruleName = RuleName.BEFORE_BAN_RULE;
        RuleName ruleName2 = RuleName.BACK_BAN_RULE;
        RuleName ruleName3 = RuleName.BACK_CACHE_ONLY_RULE;
        RuleName ruleName4 = RuleName.BACK_MEMORY_RULE;
        RuleName ruleName5 = RuleName.BACK_STORAGE_RULE;
        RuleName ruleName6 = RuleName.BACK_NORMAL_RULE;
        RuleName ruleName7 = RuleName.FRONT_BAN_RULE;
        RuleName ruleName8 = RuleName.FRONT_MEMORY_RULE;
        RuleName ruleName9 = RuleName.FRONT_CACHE_ONLY_RULE;
        RuleName ruleName10 = RuleName.FRONT_STORAGE_RULE;
        RuleName ruleName11 = RuleName.FRONT_NORMAL_RULE;
        RuleName ruleName12 = RuleName.ILLEGAL_API_RULE;
        v.a f16 = new v.a().g("illegal_scene").i("ban").f(1);
        of5 = SetsKt__SetsJVMKt.setOf("==");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(ruleName, new v.a().g("before").i("ban").f(1)), TuplesKt.to(ruleName2, new v.a().g("back").i("ban").f(1)), TuplesKt.to(ruleName3, new v.a().g("back").i("cache_only").f(1)), TuplesKt.to(ruleName4, new v.a().g("back").i("memory").f(1).b(0L)), TuplesKt.to(ruleName5, new v.a().g("back").i(QQPermissionConstants.Permission.STORAGE_GROUP).f(1).b(0L)), TuplesKt.to(ruleName6, new v.a().g("back").i("normal").f(1)), TuplesKt.to(ruleName7, new v.a().g("normal").i("ban")), TuplesKt.to(ruleName8, new v.a().g("normal").i("memory").b(0L)), TuplesKt.to(ruleName9, new v.a().g("normal").i("cache_only")), TuplesKt.to(ruleName10, new v.a().g("normal").i(QQPermissionConstants.Permission.STORAGE_GROUP).b(0L)), TuplesKt.to(ruleName11, new v.a().g("normal").i("normal")), TuplesKt.to(RuleName.HIGH_FREQ_BAN_RULE, new v.a().g("high_freq").i("ban").f(1)), TuplesKt.to(RuleName.HIGH_FREQ_MEMORY_RULE, new v.a().g("high_freq").i("memory").f(1)), TuplesKt.to(RuleName.HIGH_FREQ_STORAGE_RULE, new v.a().g("high_freq").i(QQPermissionConstants.Permission.STORAGE_GROUP).f(1)), TuplesKt.to(RuleName.HIGH_FREQ_NORMAL_RULE, new v.a().g("high_freq").i("normal").f(1)), TuplesKt.to(ruleName12, f16.e(of5)), TuplesKt.to(RuleName.ILLEGAL_SCENE_RULE, new v.a().g("illegal_scene").i("ban").f(1)), TuplesKt.to(RuleName.SILENCE_NORMAL_RULE, new v.a().g("silence").i("normal").f(1)));
        f343553h = hashMapOf;
        GeneralRule generalRule = GeneralRule.BACK_BAN_AND_FRONT_BAN;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName2), hashMapOf.get(ruleName7));
        GeneralRule generalRule2 = GeneralRule.BACK_BAN_AND_FRONT_CACHE;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName2), hashMapOf.get(ruleName8));
        GeneralRule generalRule3 = GeneralRule.BACK_BAN_AND_FRONT_NORMAL;
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName2), hashMapOf.get(ruleName11));
        GeneralRule generalRule4 = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_CACHE;
        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName3), hashMapOf.get(ruleName8));
        GeneralRule generalRule5 = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_NORMAL;
        arrayListOf5 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName3), hashMapOf.get(ruleName11));
        GeneralRule generalRule6 = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_CACHE_ONLY;
        arrayListOf6 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName3), hashMapOf.get(ruleName9));
        GeneralRule generalRule7 = GeneralRule.BACK_CACHE_AND_FRONT_CACHE;
        arrayListOf7 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName4), hashMapOf.get(ruleName8));
        GeneralRule generalRule8 = GeneralRule.BACK_CACHE_AND_FRONT_NORMAL;
        arrayListOf8 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName4), hashMapOf.get(ruleName11));
        GeneralRule generalRule9 = GeneralRule.BACK_STORAGE_AND_FRONT_STORAGE;
        arrayListOf9 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName5), hashMapOf.get(ruleName10));
        GeneralRule generalRule10 = GeneralRule.BACK_BAN_AND_FRONT_STORAGE;
        arrayListOf10 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName2), hashMapOf.get(ruleName10));
        GeneralRule generalRule11 = GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL;
        arrayListOf11 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName6), hashMapOf.get(ruleName11));
        GeneralRule generalRule12 = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_STORAGE;
        arrayListOf12 = CollectionsKt__CollectionsKt.arrayListOf(hashMapOf.get(ruleName), hashMapOf.get(ruleName3), hashMapOf.get(ruleName10));
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(generalRule, arrayListOf), TuplesKt.to(generalRule2, arrayListOf2), TuplesKt.to(generalRule3, arrayListOf3), TuplesKt.to(generalRule4, arrayListOf4), TuplesKt.to(generalRule5, arrayListOf5), TuplesKt.to(generalRule6, arrayListOf6), TuplesKt.to(generalRule7, arrayListOf7), TuplesKt.to(generalRule8, arrayListOf8), TuplesKt.to(generalRule9, arrayListOf9), TuplesKt.to(generalRule10, arrayListOf10), TuplesKt.to(generalRule11, arrayListOf11), TuplesKt.to(generalRule12, arrayListOf12));
        f343554i = hashMapOf2;
    }

    public ConfigRule(@NotNull String module, @NotNull String api, @NotNull String page, @Nullable GeneralRule generalRule, @Nullable HighFrequency highFrequency, @Nullable Silence silence, @Nullable CacheTime cacheTime) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(api, "api");
        Intrinsics.checkParameterIsNotNull(page, "page");
        this.module = module;
        this.api = api;
        this.page = page;
        this.rule = generalRule;
        this.highFrequency = highFrequency;
        this.silence = silence;
        this.cacheTime = cacheTime;
    }

    private final List<v> a() {
        String front;
        String str;
        boolean isBlank;
        Set<String> of5;
        Set<String> of6;
        boolean isBlank2;
        Set<String> of7;
        ArrayList<v> arrayList = new ArrayList();
        GeneralRule generalRule = this.rule;
        String str2 = "normal";
        if (generalRule != null) {
            ArrayList<v.a> arrayList2 = f343554i.get(generalRule);
            if (arrayList2 != null) {
                for (v.a aVar : arrayList2) {
                    if (aVar != null) {
                        arrayList.add(aVar.a());
                    }
                }
            }
            if (GeneralRule.BACK_BAN_AND_FRONT_BAN == generalRule) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(this.page);
                if (isBlank2) {
                    v.a aVar2 = f343553h.get(RuleName.ILLEGAL_API_RULE);
                    if (aVar2 == null) {
                        Intrinsics.throwNpe();
                    }
                    arrayList.add(aVar2.a());
                } else {
                    v vVar = new v();
                    vVar.f343990a = "illegal_scene";
                    vVar.f343991b = "ban";
                    vVar.f343995f = 1;
                    of7 = SetsKt__SetsJVMKt.setOf(this.page);
                    vVar.f343997h = of7;
                    arrayList.add(vVar);
                }
            } else {
                isBlank = StringsKt__StringsJVMKt.isBlank(this.page);
                if (!isBlank) {
                    v vVar2 = new v();
                    vVar2.f343990a = "illegal_scene";
                    vVar2.f343991b = "ban";
                    vVar2.f343995f = 1;
                    of6 = SetsKt__SetsJVMKt.setOf(this.page);
                    vVar2.f343996g = of6;
                    arrayList.add(vVar2);
                } else {
                    v vVar3 = new v();
                    vVar3.f343990a = "illegal_scene";
                    vVar3.f343991b = "normal";
                    vVar3.f343995f = 1;
                    of5 = SetsKt__SetsJVMKt.setOf("==");
                    vVar3.f343997h = of5;
                    arrayList.add(vVar3);
                }
            }
        }
        if (this.highFrequency == null) {
            this.highFrequency = HighFrequency.HIGH;
        }
        HighFrequency highFrequency = this.highFrequency;
        if (highFrequency != null) {
            v vVar4 = new v();
            vVar4.f343990a = "high_freq";
            GeneralRule generalRule2 = this.rule;
            if (generalRule2 == null || (str = generalRule2.getFront()) == null) {
                str = "normal";
            }
            vVar4.f343991b = str;
            vVar4.f343995f = 1;
            vVar4.f343992c = new com.tencent.qmethod.pandoraex.api.c(highFrequency.getDurationMillSecond(), highFrequency.getCount());
            arrayList.add(vVar4);
        }
        if (this.silence == null) {
            this.silence = Silence.TEN_SECOND;
        }
        Silence silence = this.silence;
        if (silence != null) {
            v vVar5 = new v();
            vVar5.f343990a = "silence";
            GeneralRule generalRule3 = this.rule;
            if (generalRule3 != null && (front = generalRule3.getFront()) != null) {
                str2 = front;
            }
            vVar5.f343991b = str2;
            vVar5.f343995f = 1;
            vVar5.f343994e = silence.getSilenceTime();
            arrayList.add(vVar5);
        }
        CacheTime cacheTime = this.cacheTime;
        if (cacheTime != null) {
            for (v vVar6 : arrayList) {
                if (Intrinsics.areEqual("memory", vVar6.f343991b) || Intrinsics.areEqual(QQPermissionConstants.Permission.STORAGE_GROUP, vVar6.f343991b)) {
                    vVar6.f343993d = cacheTime.getCacheTime();
                }
            }
        }
        return arrayList;
    }

    private final JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("module", this.module);
        jSONObject.put(DTConstants.TAG.API, this.api);
        jSONObject.put("page", this.page);
        GeneralRule generalRule = this.rule;
        if (generalRule != null) {
            jSONObject.put(TransferConfig.ExtendParamFloats.KEY_RULE, generalRule.name());
        }
        HighFrequency highFrequency = this.highFrequency;
        if (highFrequency != null) {
            jSONObject.put("highFrequency", highFrequency.name());
        }
        Silence silence = this.silence;
        if (silence != null) {
            jSONObject.put("silence", silence.name());
        }
        CacheTime cacheTime = this.cacheTime;
        if (cacheTime != null) {
            jSONObject.put("cacheTime", cacheTime.name());
        }
        return jSONObject;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final CacheTime getCacheTime() {
        return this.cacheTime;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final HighFrequency getHighFrequency() {
        return this.highFrequency;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ConfigRule) {
                ConfigRule configRule = (ConfigRule) other;
                if (!Intrinsics.areEqual(this.module, configRule.module) || !Intrinsics.areEqual(this.api, configRule.api) || !Intrinsics.areEqual(this.page, configRule.page) || !Intrinsics.areEqual(this.rule, configRule.rule) || !Intrinsics.areEqual(this.highFrequency, configRule.highFrequency) || !Intrinsics.areEqual(this.silence, configRule.silence) || !Intrinsics.areEqual(this.cacheTime, configRule.cacheTime)) {
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
    public final String getPage() {
        return this.page;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final GeneralRule getRule() {
        return this.rule;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final Silence getSilence() {
        return this.silence;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        String str = this.module;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = i3 * 31;
        String str2 = this.api;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        String str3 = this.page;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i36 = (i29 + i17) * 31;
        GeneralRule generalRule = this.rule;
        if (generalRule != null) {
            i18 = generalRule.hashCode();
        } else {
            i18 = 0;
        }
        int i37 = (i36 + i18) * 31;
        HighFrequency highFrequency = this.highFrequency;
        if (highFrequency != null) {
            i19 = highFrequency.hashCode();
        } else {
            i19 = 0;
        }
        int i38 = (i37 + i19) * 31;
        Silence silence = this.silence;
        if (silence != null) {
            i26 = silence.hashCode();
        } else {
            i26 = 0;
        }
        int i39 = (i38 + i26) * 31;
        CacheTime cacheTime = this.cacheTime;
        if (cacheTime != null) {
            i27 = cacheTime.hashCode();
        }
        return i39 + i27;
    }

    public final void i(@Nullable CacheTime cacheTime) {
        this.cacheTime = cacheTime;
    }

    public final void j(@Nullable HighFrequency highFrequency) {
        this.highFrequency = highFrequency;
    }

    public final void k(@Nullable GeneralRule generalRule) {
        this.rule = generalRule;
    }

    public final void l(@Nullable Silence silence) {
        this.silence = silence;
    }

    @NotNull
    public final com.tencent.qmethod.pandoraex.api.b m() {
        com.tencent.qmethod.pandoraex.api.b bVar = new com.tencent.qmethod.pandoraex.api.b();
        bVar.f343878a = this.module;
        bVar.f343879b = this.api;
        bVar.f343881d = this.page;
        for (v vVar : a()) {
            if (vVar.f343990a != null) {
                Map<String, v> rules = bVar.f343880c;
                Intrinsics.checkExpressionValueIsNotNull(rules, "rules");
                rules.put(vVar.f343990a, vVar);
            }
        }
        return bVar;
    }

    @NotNull
    public String toString() {
        String jSONObject = n().toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJsonObject().toString()");
        return jSONObject;
    }
}
