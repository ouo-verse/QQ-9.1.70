package com.tencent.mobileqq.z1.download.data;

import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\t\u0010\"\u001a\u00020\fH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003JQ\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "Ljava/io/Serializable;", "summaryData", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;", "url", "", "version", "size", "", "modVersionSimpleData", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/z1/download/data/ZootopiaExtraData;", "diffPatchInfo", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "(Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;Lcom/tencent/mobileqq/z1/download/data/ZootopiaExtraData;Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;)V", "getDiffPatchInfo", "()Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "getExtraData", "()Lcom/tencent/mobileqq/z1/download/data/ZootopiaExtraData;", "getModVersionSimpleData", "()Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "getSize", "()J", "getSummaryData", "()Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;", "getUrl", "()Ljava/lang/String;", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ZootopiaDownloadParams implements Serializable {

    @Nullable
    private final ZPlanMapDiffPatchInfo diffPatchInfo;

    @NotNull
    private final ZootopiaExtraData extraData;

    @NotNull
    private final ZPlanModVersionSimpleData modVersionSimpleData;
    private final long size;

    @NotNull
    private final ZootopiaSummaryData summaryData;

    @NotNull
    private final String url;

    @NotNull
    private final String version;

    public ZootopiaDownloadParams(@NotNull ZootopiaSummaryData summaryData, @NotNull String url, @NotNull String version, long j3, @NotNull ZPlanModVersionSimpleData modVersionSimpleData, @NotNull ZootopiaExtraData extraData, @Nullable ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo) {
        Intrinsics.checkNotNullParameter(summaryData, "summaryData");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(modVersionSimpleData, "modVersionSimpleData");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.summaryData = summaryData;
        this.url = url;
        this.version = version;
        this.size = j3;
        this.modVersionSimpleData = modVersionSimpleData;
        this.extraData = extraData;
        this.diffPatchInfo = zPlanMapDiffPatchInfo;
    }

    public static /* synthetic */ ZootopiaDownloadParams copy$default(ZootopiaDownloadParams zootopiaDownloadParams, ZootopiaSummaryData zootopiaSummaryData, String str, String str2, long j3, ZPlanModVersionSimpleData zPlanModVersionSimpleData, ZootopiaExtraData zootopiaExtraData, ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo, int i3, Object obj) {
        ZootopiaSummaryData zootopiaSummaryData2;
        String str3;
        String str4;
        long j16;
        ZPlanModVersionSimpleData zPlanModVersionSimpleData2;
        ZootopiaExtraData zootopiaExtraData2;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo2;
        if ((i3 & 1) != 0) {
            zootopiaSummaryData2 = zootopiaDownloadParams.summaryData;
        } else {
            zootopiaSummaryData2 = zootopiaSummaryData;
        }
        if ((i3 & 2) != 0) {
            str3 = zootopiaDownloadParams.url;
        } else {
            str3 = str;
        }
        if ((i3 & 4) != 0) {
            str4 = zootopiaDownloadParams.version;
        } else {
            str4 = str2;
        }
        if ((i3 & 8) != 0) {
            j16 = zootopiaDownloadParams.size;
        } else {
            j16 = j3;
        }
        if ((i3 & 16) != 0) {
            zPlanModVersionSimpleData2 = zootopiaDownloadParams.modVersionSimpleData;
        } else {
            zPlanModVersionSimpleData2 = zPlanModVersionSimpleData;
        }
        if ((i3 & 32) != 0) {
            zootopiaExtraData2 = zootopiaDownloadParams.extraData;
        } else {
            zootopiaExtraData2 = zootopiaExtraData;
        }
        if ((i3 & 64) != 0) {
            zPlanMapDiffPatchInfo2 = zootopiaDownloadParams.diffPatchInfo;
        } else {
            zPlanMapDiffPatchInfo2 = zPlanMapDiffPatchInfo;
        }
        return zootopiaDownloadParams.copy(zootopiaSummaryData2, str3, str4, j16, zPlanModVersionSimpleData2, zootopiaExtraData2, zPlanMapDiffPatchInfo2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ZootopiaSummaryData getSummaryData() {
        return this.summaryData;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final ZPlanModVersionSimpleData getModVersionSimpleData() {
        return this.modVersionSimpleData;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final ZootopiaExtraData getExtraData() {
        return this.extraData;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final ZPlanMapDiffPatchInfo getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    @NotNull
    public final ZootopiaDownloadParams copy(@NotNull ZootopiaSummaryData summaryData, @NotNull String url, @NotNull String version, long size, @NotNull ZPlanModVersionSimpleData modVersionSimpleData, @NotNull ZootopiaExtraData extraData, @Nullable ZPlanMapDiffPatchInfo diffPatchInfo) {
        Intrinsics.checkNotNullParameter(summaryData, "summaryData");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(modVersionSimpleData, "modVersionSimpleData");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        return new ZootopiaDownloadParams(summaryData, url, version, size, modVersionSimpleData, extraData, diffPatchInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaDownloadParams)) {
            return false;
        }
        ZootopiaDownloadParams zootopiaDownloadParams = (ZootopiaDownloadParams) other;
        if (Intrinsics.areEqual(this.summaryData, zootopiaDownloadParams.summaryData) && Intrinsics.areEqual(this.url, zootopiaDownloadParams.url) && Intrinsics.areEqual(this.version, zootopiaDownloadParams.version) && this.size == zootopiaDownloadParams.size && Intrinsics.areEqual(this.modVersionSimpleData, zootopiaDownloadParams.modVersionSimpleData) && Intrinsics.areEqual(this.extraData, zootopiaDownloadParams.extraData) && Intrinsics.areEqual(this.diffPatchInfo, zootopiaDownloadParams.diffPatchInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final ZPlanMapDiffPatchInfo getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    @NotNull
    public final ZootopiaExtraData getExtraData() {
        return this.extraData;
    }

    @NotNull
    public final ZPlanModVersionSimpleData getModVersionSimpleData() {
        return this.modVersionSimpleData;
    }

    public final long getSize() {
        return this.size;
    }

    @NotNull
    public final ZootopiaSummaryData getSummaryData() {
        return this.summaryData;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.summaryData.hashCode() * 31) + this.url.hashCode()) * 31) + this.version.hashCode()) * 31) + a.a(this.size)) * 31) + this.modVersionSimpleData.hashCode()) * 31) + this.extraData.hashCode()) * 31;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffPatchInfo;
        if (zPlanMapDiffPatchInfo == null) {
            hashCode = 0;
        } else {
            hashCode = zPlanMapDiffPatchInfo.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "ZootopiaDownloadParams(summaryData=" + this.summaryData + ", url=" + this.url + ", version=" + this.version + ", size=" + this.size + ", modVersionSimpleData=" + this.modVersionSimpleData + ", extraData=" + this.extraData + ", diffPatchInfo=" + this.diffPatchInfo + ')';
    }
}
