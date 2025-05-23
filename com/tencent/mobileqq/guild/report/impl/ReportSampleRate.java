package com.tencent.mobileqq.guild.report.impl;

import android.util.Log;
import androidx.collection.SparseArrayCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'J\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010#R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/report/impl/ReportSampleRate;", "", "", "key", "", "default", "d", "Landroidx/collection/SparseArrayCompat;", h.F, "", "i", "j", "g", "toString", "", "hashCode", "other", "equals", "a", UserInfo.SEX_FEMALE, "grayPersonal", "b", "publicPersonal", "c", "Ljava/lang/String;", "freesiaName", "Lkotlin/Lazy;", "f", "()Landroidx/collection/SparseArrayCompat;", "sampleRateList", "", "e", "Ljava/util/Set;", "fullSampleSets", "", "D", "sampleValue", "eventSampleValue", "<init>", "(FFLjava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class ReportSampleRate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float grayPersonal;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float publicPersonal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String freesiaName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy sampleRateList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Set<Integer> fullSampleSets;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private double sampleValue;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private double eventSampleValue;

    public ReportSampleRate() {
        this(0.0f, 0.0f, null, 7, null);
    }

    private final float d(String key, float r36) {
        Float f16 = f().get(key.hashCode(), Float.valueOf(r36));
        Intrinsics.checkNotNullExpressionValue(f16, "sampleRateList.get(key.hashCode(), default)");
        return f16.floatValue();
    }

    private final SparseArrayCompat<Float> f() {
        return (SparseArrayCompat) this.sampleRateList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SparseArrayCompat<Float> h() {
        SparseArrayCompat<Float> sparseArrayCompat = new SparseArrayCompat<>();
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(this.freesiaName, "");
        try {
            JSONObject jSONObject = new JSONObject(loadAsString);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str == null) {
                    str = "";
                }
                if (Intrinsics.areEqual(str, "all_report_events")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(str);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            this.fullSampleSets.add(Integer.valueOf(optJSONArray.getString(i3).hashCode()));
                        }
                    }
                } else {
                    sparseArrayCompat.putIfAbsent(str.hashCode(), Float.valueOf((float) jSONObject.optDouble(str)));
                }
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(PerformanceReportApiImpl.LOG_TAG, "loaded " + loadAsString + " \nsample value: " + this.sampleValue + " / " + this.eventSampleValue);
            }
        } catch (Exception unused) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "content:" + loadAsString;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(PerformanceReportApiImpl.LOG_TAG, 1, (String) it.next(), null);
            }
        }
        return sparseArrayCompat;
    }

    public final boolean g(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.fullSampleSets.contains(Integer.valueOf(key.hashCode()));
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.grayPersonal) * 31) + Float.floatToIntBits(this.publicPersonal)) * 31) + this.freesiaName.hashCode();
    }

    public final boolean i() {
        String str = "buildType=" + PerformanceReportApiImpl.INSTANCE.c() + ",fressia=" + this.freesiaName + ",gray=" + this.grayPersonal + ",public=" + this.publicPersonal + ",rateList.size=" + f().size();
        double d16 = this.sampleValue;
        boolean z16 = d16 < ((double) this.publicPersonal) || d16 < ((double) e(this, "public_personal", 0.0f, 2, null));
        Logger.f235387a.d().i(PerformanceReportApiImpl.LOG_TAG, 1, "ReportSampleRate, isSample=" + z16 + ", " + str);
        return z16;
    }

    public final boolean j(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Float sampleRate = f().get(key.hashCode(), Float.valueOf(1.0f));
        Intrinsics.checkNotNullExpressionValue(sampleRate, "sampleRate");
        return sampleRate.floatValue() >= 0.0f && this.eventSampleValue < ((double) sampleRate.floatValue());
    }

    public String toString() {
        return "ReportSampleRate(grayPersonal=" + this.grayPersonal + ", publicPersonal=" + this.publicPersonal + ", freesiaName=" + this.freesiaName + ")";
    }

    public ReportSampleRate(float f16, float f17, String freesiaName) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(freesiaName, "freesiaName");
        this.grayPersonal = f16;
        this.publicPersonal = f17;
        this.freesiaName = freesiaName;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SparseArrayCompat<Float>>() { // from class: com.tencent.mobileqq.guild.report.impl.ReportSampleRate$sampleRateList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SparseArrayCompat<Float> invoke() {
                SparseArrayCompat<Float> h16;
                h16 = ReportSampleRate.this.h();
                return h16;
            }
        });
        this.sampleRateList = lazy;
        this.fullSampleSets = new LinkedHashSet();
        this.sampleValue = Math.random();
        this.eventSampleValue = Math.random();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportSampleRate)) {
            return false;
        }
        ReportSampleRate reportSampleRate = (ReportSampleRate) other;
        return Float.compare(this.grayPersonal, reportSampleRate.grayPersonal) == 0 && Float.compare(this.publicPersonal, reportSampleRate.publicPersonal) == 0 && Intrinsics.areEqual(this.freesiaName, reportSampleRate.freesiaName);
    }

    static /* synthetic */ float e(ReportSampleRate reportSampleRate, String str, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 0.0f;
        }
        return reportSampleRate.d(str, f16);
    }

    public /* synthetic */ ReportSampleRate(float f16, float f17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? "argus_page_scene_sample" : str);
    }
}
