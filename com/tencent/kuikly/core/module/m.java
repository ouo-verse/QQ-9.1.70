package com.tencent.kuikly.core.module;

import com.tencent.kuikly.core.base.ExecuteMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001\tBO\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010,\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\t\u0010\u001dR\u0019\u0010#\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010&\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u0019\u0010,\u001a\u0004\u0018\u00010'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/kuikly/core/module/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getPageExistTime", "()I", "pageExistTime", "Lcom/tencent/kuikly/core/base/ExecuteMode;", "b", "Lcom/tencent/kuikly/core/base/ExecuteMode;", "getMode", "()Lcom/tencent/kuikly/core/base/ExecuteMode;", "mode", "c", "Z", "isFirstLaunchOfProcess", "()Z", "d", "isFirstLaunchOfPage", "Lcom/tencent/kuikly/core/module/g;", "e", "Lcom/tencent/kuikly/core/module/g;", "()Lcom/tencent/kuikly/core/module/g;", "pageLoadTime", "f", "Ljava/lang/Integer;", "getMainFPS", "()Ljava/lang/Integer;", "mainFPS", "g", "getKotlinFPS", "kotlinFPS", "Lcom/tencent/kuikly/core/module/h;", tl.h.F, "Lcom/tencent/kuikly/core/module/h;", "getMemory", "()Lcom/tencent/kuikly/core/module/h;", "memory", "<init>", "(ILcom/tencent/kuikly/core/base/ExecuteMode;ZZLcom/tencent/kuikly/core/module/g;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/kuikly/core/module/h;)V", "i", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class m {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int pageExistTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ExecuteMode mode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isFirstLaunchOfProcess;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isFirstLaunchOfPage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LaunchData pageLoadTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Integer mainFPS;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Integer kotlinFPS;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final MemoryData memory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/module/m$a;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "jsonObject", "Lcom/tencent/kuikly/core/module/m;", "a", "", "KEY_IS_FIRST_PAGE_LAUNCH", "Ljava/lang/String;", "KEY_IS_FIRST_PAGE_PROCESS", "KEY_KOTLIN_FPS", "KEY_MAIN_FPS", "KEY_MEMORY", "KEY_MODE", "KEY_PAGE_EXIST_TIME", "KEY_PAGE_LOAD_TIME", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.module.m$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final m a(com.tencent.kuikly.core.nvi.serialization.json.e jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            ExecuteMode a16 = ExecuteMode.INSTANCE.a(jsonObject.j("mode"));
            int j3 = jsonObject.j("pageExistTime");
            boolean f16 = jsonObject.f("isFirstLaunchOfProcess");
            boolean f17 = jsonObject.f("isFirstLaunchOfPage");
            LaunchData a17 = LaunchData.INSTANCE.a(jsonObject.m("pageLoadTime"));
            int j16 = jsonObject.j("mainFPS");
            int j17 = jsonObject.j("kotlinFPS");
            return new m(j3, a16, f16, f17, a17, Integer.valueOf(j16), Integer.valueOf(j17), MemoryData.INSTANCE.a(jsonObject.m("memory")));
        }
    }

    public m(int i3, ExecuteMode mode, boolean z16, boolean z17, LaunchData launchData, Integer num, Integer num2, MemoryData memoryData) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.pageExistTime = i3;
        this.mode = mode;
        this.isFirstLaunchOfProcess = z16;
        this.isFirstLaunchOfPage = z17;
        this.pageLoadTime = launchData;
        this.mainFPS = num;
        this.kotlinFPS = num2;
        this.memory = memoryData;
    }

    /* renamed from: a, reason: from getter */
    public final LaunchData getPageLoadTime() {
        return this.pageLoadTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.pageExistTime * 31) + this.mode.hashCode()) * 31;
        boolean z16 = this.isFirstLaunchOfProcess;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.isFirstLaunchOfPage;
        int i17 = (i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        LaunchData launchData = this.pageLoadTime;
        int hashCode2 = (i17 + (launchData == null ? 0 : launchData.hashCode())) * 31;
        Integer num = this.mainFPS;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.kotlinFPS;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        MemoryData memoryData = this.memory;
        return hashCode4 + (memoryData != null ? memoryData.hashCode() : 0);
    }

    public String toString() {
        return "PerformanceData: \npageExistTime=" + this.pageExistTime + " \nmode=" + this.mode + " \nisFirstLaunchOfProcess=" + this.isFirstLaunchOfProcess + " \nisFirstLaunchOfPage=" + this.isFirstLaunchOfPage + " \npageLoadTime=" + this.pageLoadTime + " \nmainFPS=" + this.mainFPS + " \nkotlinFPS=" + this.kotlinFPS + " \nmemory=" + this.memory;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof m)) {
            return false;
        }
        m mVar = (m) other;
        return this.pageExistTime == mVar.pageExistTime && this.mode == mVar.mode && this.isFirstLaunchOfProcess == mVar.isFirstLaunchOfProcess && this.isFirstLaunchOfPage == mVar.isFirstLaunchOfPage && Intrinsics.areEqual(this.pageLoadTime, mVar.pageLoadTime) && Intrinsics.areEqual(this.mainFPS, mVar.mainFPS) && Intrinsics.areEqual(this.kotlinFPS, mVar.kotlinFPS) && Intrinsics.areEqual(this.memory, mVar.memory);
    }
}
