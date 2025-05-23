package com.tencent.qmethod.monitor.config.bean;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001\nB_\u0012\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015\u0012\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0013j\b\u0012\u0004\u0012\u00020\u001a`\u0015\u0012\u0018\b\u0002\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0013j\b\u0012\u0004\u0012\u00020\u001e`\u0015\u0012\b\b\u0002\u0010%\u001a\u00020\u000f\u00a2\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005J\t\u0010\u000b\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R'\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R'\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0013j\b\u0012\u0004\u0012\u00020\u001a`\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R'\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0013j\b\u0012\u0004\u0012\u00020\u001e`\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u0017\u0010%\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/a;", "", "", "b", "()V", "", "module", DTConstants.TAG.API, "sceneName", "Lcom/tencent/qmethod/monitor/config/bean/b;", "a", "toString", "", "hashCode", "other", "", "equals", "Z", "isInitDefault", "Ljava/util/ArrayList;", "Lcom/tencent/qmethod/monitor/config/bean/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getSceneReport", "()Ljava/util/ArrayList;", "sceneReport", "Lcom/tencent/qmethod/monitor/config/bean/ConfigRule;", "c", "getRules", "rules", "Lcom/tencent/qmethod/monitor/config/bean/e;", "d", "getSample", "sample", "e", "getInitDefault", "()Z", "initDefault", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V", "f", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qmethod.monitor.config.bean.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class ConstitutionConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isInitDefault;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<ConstitutionSceneReportConfig> sceneReport;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<ConfigRule> rules;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<e> sample;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean initDefault;

    public ConstitutionConfig() {
        this(null, null, null, false, 15, null);
    }

    @Nullable
    public final ConstitutionSceneConfig a(@NotNull String module, @Nullable String api, @NotNull String sceneName) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(sceneName, "sceneName");
        if (api == null) {
            return null;
        }
        for (ConstitutionSceneReportConfig constitutionSceneReportConfig : this.sceneReport) {
            if (!(!Intrinsics.areEqual(constitutionSceneReportConfig.getModule(), module)) && (!(!constitutionSceneReportConfig.a().isEmpty()) || constitutionSceneReportConfig.a().contains(api))) {
                for (ConstitutionSceneConfig constitutionSceneConfig : constitutionSceneReportConfig.c()) {
                    if (Intrinsics.areEqual(constitutionSceneConfig.getName(), sceneName)) {
                        return constitutionSceneConfig;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        List<Pair> listOf;
        if (this.isInitDefault) {
            return;
        }
        this.isInitDefault = true;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("device", "TM#G_MID#I"), new Pair("device", "TM#G_MID"), new Pair("device", "TM#G_DID"), new Pair("device", "TM#G_DID#I"), new Pair("device", "SE#G_AID"), new Pair("device", "BU#SER"), new Pair("device", "TM#G_IM"), new Pair("device", "TM#G_IM#I"), new Pair("device", "TM#G_SID"), new Pair("device", "TM#G_SIM_SE_NUM"), new Pair("network", "NI#G_HW_ADDR"), new Pair("network", "WI#G_MA_ADDR"), new Pair("network", "BA#G_ADDR")});
        for (Pair pair : listOf) {
            ArrayList<ConstitutionSceneReportConfig> arrayList = this.sceneReport;
            ConstitutionSceneReportConfig constitutionSceneReportConfig = new ConstitutionSceneReportConfig((String) pair.getFirst());
            constitutionSceneReportConfig.a().add(pair.getSecond());
            List<ConstitutionSceneConfig> c16 = constitutionSceneReportConfig.c();
            ConstitutionSceneConfig constitutionSceneConfig = new ConstitutionSceneConfig("normal");
            constitutionSceneConfig.c(ConstitutionSceneReportType.FORCE);
            c16.add(constitutionSceneConfig);
            arrayList.add(constitutionSceneReportConfig);
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ConstitutionConfig) {
                ConstitutionConfig constitutionConfig = (ConstitutionConfig) other;
                if (!Intrinsics.areEqual(this.sceneReport, constitutionConfig.sceneReport) || !Intrinsics.areEqual(this.rules, constitutionConfig.rules) || !Intrinsics.areEqual(this.sample, constitutionConfig.sample) || this.initDefault != constitutionConfig.initDefault) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        ArrayList<ConstitutionSceneReportConfig> arrayList = this.sceneReport;
        int i17 = 0;
        if (arrayList != null) {
            i3 = arrayList.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        ArrayList<ConfigRule> arrayList2 = this.rules;
        if (arrayList2 != null) {
            i16 = arrayList2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        ArrayList<e> arrayList3 = this.sample;
        if (arrayList3 != null) {
            i17 = arrayList3.hashCode();
        }
        int i26 = (i19 + i17) * 31;
        boolean z16 = this.initDefault;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        return i26 + i27;
    }

    @NotNull
    public String toString() {
        return "ConstitutionConfig(sceneReport=" + this.sceneReport + ", rules=" + this.rules + ", sample=" + this.sample + ", initDefault=" + this.initDefault + ")";
    }

    public ConstitutionConfig(@NotNull ArrayList<ConstitutionSceneReportConfig> sceneReport, @NotNull ArrayList<ConfigRule> rules, @NotNull ArrayList<e> sample, boolean z16) {
        Intrinsics.checkParameterIsNotNull(sceneReport, "sceneReport");
        Intrinsics.checkParameterIsNotNull(rules, "rules");
        Intrinsics.checkParameterIsNotNull(sample, "sample");
        this.sceneReport = sceneReport;
        this.rules = rules;
        this.sample = sample;
        this.initDefault = z16;
        if (z16) {
            b();
        }
    }

    public /* synthetic */ ConstitutionConfig(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : arrayList, (i3 & 2) != 0 ? new ArrayList() : arrayList2, (i3 & 4) != 0 ? new ArrayList() : arrayList3, (i3 & 8) != 0 ? false : z16);
    }
}
