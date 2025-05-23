package com.tencent.kuikly.core.render.android.performace;

import k01.KRMemoryData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 42\u00020\u0001:\u0001\u0003BM\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\b\u0010+\u001a\u0004\u0018\u00010&\u0012\b\u00101\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b2\u00103J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010+\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u00101\u001a\u0004\u0018\u00010,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/c;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "pageName", "", "b", "J", "getSpentTime", "()J", "spentTime", "c", "Z", "isColdLaunch", "()Z", "d", "isPageColdLaunch", "e", "I", "getExecuteMode", "()I", "executeMode", "Lj01/a;", "f", "Lj01/a;", "getLaunchData", "()Lj01/a;", "launchData", "Lcom/tencent/kuikly/core/render/android/performace/frame/c;", "g", "Lcom/tencent/kuikly/core/render/android/performace/frame/c;", "getFrameData", "()Lcom/tencent/kuikly/core/render/android/performace/frame/c;", "frameData", "Lk01/a;", h.F, "Lk01/a;", "getMemoryData", "()Lk01/a;", "memoryData", "<init>", "(Ljava/lang/String;JZZILj01/a;Lcom/tencent/kuikly/core/render/android/performace/frame/c;Lk01/a;)V", "i", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final /* data */ class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long spentTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isColdLaunch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isPageColdLaunch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int executeMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final j01.a launchData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.kuikly.core.render.android.performace.frame.c frameData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final KRMemoryData memoryData;

    public c(@NotNull String pageName, long j3, boolean z16, boolean z17, int i3, @Nullable j01.a aVar, @Nullable com.tencent.kuikly.core.render.android.performace.frame.c cVar, @Nullable KRMemoryData kRMemoryData) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        this.pageName = pageName;
        this.spentTime = j3;
        this.isColdLaunch = z16;
        this.isPageColdLaunch = z17;
        this.executeMode = i3;
        this.launchData = aVar;
        this.frameData = cVar;
        this.memoryData = kRMemoryData;
    }

    @NotNull
    public final JSONObject a() {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mode", this.executeMode);
        jSONObject.put("pageExistTime", this.spentTime);
        jSONObject.put("isFirstLaunchOfProcess", this.isColdLaunch);
        jSONObject.put("isFirstLaunchOfPage", this.isPageColdLaunch);
        com.tencent.kuikly.core.render.android.performace.frame.c cVar = this.frameData;
        Object obj2 = 0;
        if (cVar != null) {
            obj = Float.valueOf(cVar.c());
        } else {
            obj = obj2;
        }
        jSONObject.put("mainFPS", obj);
        com.tencent.kuikly.core.render.android.performace.frame.c cVar2 = this.frameData;
        if (cVar2 != null) {
            obj2 = Float.valueOf(cVar2.f());
        }
        jSONObject.put("kotlinFPS", obj2);
        j01.a aVar = this.launchData;
        if (aVar != null) {
            jSONObject.put("pageLoadTime", aVar.o());
        }
        KRMemoryData kRMemoryData = this.memoryData;
        if (kRMemoryData != null) {
            jSONObject.put("memory", kRMemoryData.h());
        }
        return jSONObject;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof c) {
                c cVar = (c) other;
                if (!Intrinsics.areEqual(this.pageName, cVar.pageName) || this.spentTime != cVar.spentTime || this.isColdLaunch != cVar.isColdLaunch || this.isPageColdLaunch != cVar.isPageColdLaunch || this.executeMode != cVar.executeMode || !Intrinsics.areEqual(this.launchData, cVar.launchData) || !Intrinsics.areEqual(this.frameData, cVar.frameData) || !Intrinsics.areEqual(this.memoryData, cVar.memoryData)) {
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
        int i17;
        String str = this.pageName;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        long j3 = this.spentTime;
        int i19 = ((i3 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        boolean z16 = this.isColdLaunch;
        int i26 = 1;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        int i28 = (i19 + i27) * 31;
        boolean z17 = this.isPageColdLaunch;
        if (!z17) {
            i26 = z17 ? 1 : 0;
        }
        int i29 = (((i28 + i26) * 31) + this.executeMode) * 31;
        j01.a aVar = this.launchData;
        if (aVar != null) {
            i16 = aVar.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        com.tencent.kuikly.core.render.android.performace.frame.c cVar = this.frameData;
        if (cVar != null) {
            i17 = cVar.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (i36 + i17) * 31;
        KRMemoryData kRMemoryData = this.memoryData;
        if (kRMemoryData != null) {
            i18 = kRMemoryData.hashCode();
        }
        return i37 + i18;
    }

    @NotNull
    public String toString() {
        return "[KRLaunchMeta] pageName: " + this.pageName + ", spentTime: " + this.spentTime + ", isColdLaunch: " + this.isColdLaunch + ", executeMode: " + this.executeMode;
    }
}
