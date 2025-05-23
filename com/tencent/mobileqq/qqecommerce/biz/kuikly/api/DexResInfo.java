package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "resVersion", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/a;", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/a;", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/a;", DownloadInfo.spKey_Config, "Ljava/lang/String;", "()Ljava/lang/String;", "filePath", "<init>", "(JLcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/a;Ljava/lang/String;)V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class DexResInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long resVersion;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final DexConfig config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String filePath;

    public DexResInfo(long j3, @Nullable DexConfig dexConfig, @Nullable String str) {
        this.resVersion = j3;
        this.config = dexConfig;
        this.filePath = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final DexConfig getConfig() {
        return this.config;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: c, reason: from getter */
    public final long getResVersion() {
        return this.resVersion;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DexResInfo)) {
            return false;
        }
        DexResInfo dexResInfo = (DexResInfo) other;
        if (this.resVersion == dexResInfo.resVersion && Intrinsics.areEqual(this.config, dexResInfo.config) && Intrinsics.areEqual(this.filePath, dexResInfo.filePath)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int a16 = androidx.fragment.app.a.a(this.resVersion) * 31;
        DexConfig dexConfig = this.config;
        int i3 = 0;
        if (dexConfig == null) {
            hashCode = 0;
        } else {
            hashCode = dexConfig.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        String str = this.filePath;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "DexResInfo(resVersion=" + this.resVersion + ", config=" + this.config + ", filePath=" + this.filePath + ')';
    }
}
