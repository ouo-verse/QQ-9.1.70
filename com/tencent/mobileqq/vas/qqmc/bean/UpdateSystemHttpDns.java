package com.tencent.mobileqq.vas.qqmc.bean;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/bean/UpdateSystemHttpDns;", "Lcom/tencent/freesia/IConfigData;", "useVasDownloader", "", "useHttpDns", "(ZZ)V", "getUseHttpDns", "()Z", "getUseVasDownloader", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class UpdateSystemHttpDns implements IConfigData {

    @SerializedName("use_http_dns")
    private final boolean useHttpDns;

    @SerializedName("use_vas_downloader")
    private final boolean useVasDownloader;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UpdateSystemHttpDns() {
        this(r2, r2, 3, null);
        boolean z16 = false;
    }

    public static /* synthetic */ UpdateSystemHttpDns copy$default(UpdateSystemHttpDns updateSystemHttpDns, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = updateSystemHttpDns.useVasDownloader;
        }
        if ((i3 & 2) != 0) {
            z17 = updateSystemHttpDns.useHttpDns;
        }
        return updateSystemHttpDns.copy(z16, z17);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getUseVasDownloader() {
        return this.useVasDownloader;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getUseHttpDns() {
        return this.useHttpDns;
    }

    @NotNull
    public final UpdateSystemHttpDns copy(boolean useVasDownloader, boolean useHttpDns) {
        return new UpdateSystemHttpDns(useVasDownloader, useHttpDns);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateSystemHttpDns)) {
            return false;
        }
        UpdateSystemHttpDns updateSystemHttpDns = (UpdateSystemHttpDns) other;
        if (this.useVasDownloader == updateSystemHttpDns.useVasDownloader && this.useHttpDns == updateSystemHttpDns.useHttpDns) {
            return true;
        }
        return false;
    }

    public final boolean getUseHttpDns() {
        return this.useHttpDns;
    }

    public final boolean getUseVasDownloader() {
        return this.useVasDownloader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.useVasDownloader;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.useHttpDns;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "UpdateSystemHttpDns(useVasDownloader=" + this.useVasDownloader + ", useHttpDns=" + this.useHttpDns + ")";
    }

    public UpdateSystemHttpDns(boolean z16, boolean z17) {
        this.useVasDownloader = z16;
        this.useHttpDns = z17;
    }

    public /* synthetic */ UpdateSystemHttpDns(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
    }
}
