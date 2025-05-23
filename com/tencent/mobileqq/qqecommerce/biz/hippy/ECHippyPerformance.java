package com.tencent.mobileqq.qqecommerce.biz.hippy;

import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012$\b\u0002\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020'j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`(\u0012$\b\u0002\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0'j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.`(\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u0010\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0015\u0010#\"\u0004\b$\u0010%R>\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020'j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010)\u001a\u0004\b!\u0010*\"\u0004\b+\u0010,R>\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0'j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.`(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010)\u001a\u0004\b\t\u0010*\"\u0004\b/\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hippy/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "g", "()Z", "setPreloaded", "(Z)V", "isPreloaded", "b", "f", "setPreDraw", "isPreDraw", "Lcom/tencent/hippy/qq/api/TabPreloadItem$PreloadType;", "c", "Lcom/tencent/hippy/qq/api/TabPreloadItem$PreloadType;", "d", "()Lcom/tencent/hippy/qq/api/TabPreloadItem$PreloadType;", "setPreloadType", "(Lcom/tencent/hippy/qq/api/TabPreloadItem$PreloadType;)V", OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE, "Ljava/lang/String;", "()Ljava/lang/String;", "setModuleName", "(Ljava/lang/String;)V", "moduleName", "e", "I", "()I", "setModuleVersion", "(I)V", "moduleVersion", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setReportExtraParams", "(Ljava/util/HashMap;)V", "reportExtraParams", "", "setLoadStepsTime", "loadStepsTime", "<init>", "(ZZLcom/tencent/hippy/qq/api/TabPreloadItem$PreloadType;Ljava/lang/String;ILjava/util/HashMap;Ljava/util/HashMap;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.hippy.b, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class ECHippyPerformance {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isPreloaded;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isPreDraw;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private TabPreloadItem.PreloadType preloadType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String moduleName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int moduleVersion;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private HashMap<String, String> reportExtraParams;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private HashMap<String, Long> loadStepsTime;

    public ECHippyPerformance() {
        this(false, false, null, null, 0, null, null, 127, null);
    }

    public final HashMap<String, Long> a() {
        return this.loadStepsTime;
    }

    /* renamed from: b, reason: from getter */
    public final String getModuleName() {
        return this.moduleName;
    }

    /* renamed from: c, reason: from getter */
    public final int getModuleVersion() {
        return this.moduleVersion;
    }

    /* renamed from: d, reason: from getter */
    public final TabPreloadItem.PreloadType getPreloadType() {
        return this.preloadType;
    }

    public final HashMap<String, String> e() {
        return this.reportExtraParams;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsPreDraw() {
        return this.isPreDraw;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsPreloaded() {
        return this.isPreloaded;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z16 = this.isPreloaded;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.isPreDraw;
        return ((((((((((i3 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.preloadType.hashCode()) * 31) + this.moduleName.hashCode()) * 31) + this.moduleVersion) * 31) + this.reportExtraParams.hashCode()) * 31) + this.loadStepsTime.hashCode();
    }

    public String toString() {
        return "ECHippyPerformance(isPreloaded=" + this.isPreloaded + ", isPreDraw=" + this.isPreDraw + ", preloadType=" + this.preloadType + ", moduleName=" + this.moduleName + ", moduleVersion=" + this.moduleVersion + ", reportExtraParams=" + this.reportExtraParams + ", loadStepsTime=" + this.loadStepsTime + ")";
    }

    public ECHippyPerformance(boolean z16, boolean z17, TabPreloadItem.PreloadType preloadType, String moduleName, int i3, HashMap<String, String> reportExtraParams, HashMap<String, Long> loadStepsTime) {
        Intrinsics.checkNotNullParameter(preloadType, "preloadType");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(reportExtraParams, "reportExtraParams");
        Intrinsics.checkNotNullParameter(loadStepsTime, "loadStepsTime");
        this.isPreloaded = z16;
        this.isPreDraw = z17;
        this.preloadType = preloadType;
        this.moduleName = moduleName;
        this.moduleVersion = i3;
        this.reportExtraParams = reportExtraParams;
        this.loadStepsTime = loadStepsTime;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECHippyPerformance)) {
            return false;
        }
        ECHippyPerformance eCHippyPerformance = (ECHippyPerformance) other;
        return this.isPreloaded == eCHippyPerformance.isPreloaded && this.isPreDraw == eCHippyPerformance.isPreDraw && this.preloadType == eCHippyPerformance.preloadType && Intrinsics.areEqual(this.moduleName, eCHippyPerformance.moduleName) && this.moduleVersion == eCHippyPerformance.moduleVersion && Intrinsics.areEqual(this.reportExtraParams, eCHippyPerformance.reportExtraParams) && Intrinsics.areEqual(this.loadStepsTime, eCHippyPerformance.loadStepsTime);
    }

    public /* synthetic */ ECHippyPerformance(boolean z16, boolean z17, TabPreloadItem.PreloadType preloadType, String str, int i3, HashMap hashMap, HashMap hashMap2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? false : z17, (i16 & 4) != 0 ? TabPreloadItem.PreloadType.NO_PRELOAD : preloadType, (i16 & 8) != 0 ? "" : str, (i16 & 16) == 0 ? i3 : 0, (i16 & 32) != 0 ? new HashMap() : hashMap, (i16 & 64) != 0 ? new HashMap() : hashMap2);
    }
}
