package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "resName", "Ljava/lang/String;", "getResName", "()Ljava/lang/String;", "setResName", "(Ljava/lang/String;)V", "pkgSuffix", "a", "setPkgSuffix", "preload", "Z", "getPreload", "()Z", "setPreload", "(Z)V", "", "Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "preloadEngine", "Ljava/util/List;", "getPreloadEngine", "()Ljava/util/List;", "setPreloadEngine", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.config.business.qflutter.a, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class ResDescription {

    @SerializedName("pkg_suffix")
    @NotNull
    private String pkgSuffix;

    @SerializedName("preload")
    private boolean preload;

    @SerializedName("preload_engine")
    @NotNull
    private List<? extends PreloadEngineOption> preloadEngine;

    @SerializedName("res_name")
    @NotNull
    private String resName;

    public ResDescription() {
        this(null, null, false, null, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getPkgSuffix() {
        return this.pkgSuffix;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResDescription)) {
            return false;
        }
        ResDescription resDescription = (ResDescription) other;
        if (Intrinsics.areEqual(this.resName, resDescription.resName) && Intrinsics.areEqual(this.pkgSuffix, resDescription.pkgSuffix) && this.preload == resDescription.preload && Intrinsics.areEqual(this.preloadEngine, resDescription.preloadEngine)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.resName.hashCode() * 31) + this.pkgSuffix.hashCode()) * 31;
        boolean z16 = this.preload;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.preloadEngine.hashCode();
    }

    @NotNull
    public String toString() {
        return "ResDescription(resName=" + this.resName + ", pkgSuffix=" + this.pkgSuffix + ", preload=" + this.preload + ", preloadEngine=" + this.preloadEngine + ")";
    }

    public ResDescription(@NotNull String resName, @NotNull String pkgSuffix, boolean z16, @NotNull List<? extends PreloadEngineOption> preloadEngine) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        Intrinsics.checkNotNullParameter(pkgSuffix, "pkgSuffix");
        Intrinsics.checkNotNullParameter(preloadEngine, "preloadEngine");
        this.resName = resName;
        this.pkgSuffix = pkgSuffix;
        this.preload = z16;
        this.preloadEngine = preloadEngine;
    }

    public /* synthetic */ ResDescription(String str, String str2, boolean z16, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? CollectionsKt__CollectionsJVMKt.listOf(PreloadEngineOption.NEVER_PRELOAD) : list);
    }
}
