package com.tencent.mobileqq.zootopia;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zootopia/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getMapId", "()I", "mapId", "b", "getDownloadStatus", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "c", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "version", "<init>", "(IILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.h, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZootopiaDownloadResData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mapId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int downloadStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String version;

    public ZootopiaDownloadResData(int i3, int i16, @NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        this.mapId = i3;
        this.downloadStatus = i16;
        this.version = version;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaDownloadResData)) {
            return false;
        }
        ZootopiaDownloadResData zootopiaDownloadResData = (ZootopiaDownloadResData) other;
        if (this.mapId == zootopiaDownloadResData.mapId && this.downloadStatus == zootopiaDownloadResData.downloadStatus && Intrinsics.areEqual(this.version, zootopiaDownloadResData.version)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.mapId * 31) + this.downloadStatus) * 31) + this.version.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZootopiaDownloadResData(mapId=" + this.mapId + ", downloadStatus=" + this.downloadStatus + ", version=" + this.version + ')';
    }
}
