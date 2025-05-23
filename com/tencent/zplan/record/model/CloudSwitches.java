package com.tencent.zplan.record.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/record/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "setEnableCloudCache", "(Z)V", "enableCloudCache", "b", "setEnableUploadToCloud", "enableUploadToCloud", "c", "setUploadToIDC", "uploadToIDC", "<init>", "(ZZZ)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.record.model.b, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class CloudSwitches {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enableCloudCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enableUploadToCloud;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean uploadToIDC;

    public CloudSwitches() {
        this(false, false, false, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableCloudCache() {
        return this.enableCloudCache;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableUploadToCloud() {
        return this.enableUploadToCloud;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getUploadToIDC() {
        return this.uploadToIDC;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CloudSwitches) {
                CloudSwitches cloudSwitches = (CloudSwitches) other;
                if (this.enableCloudCache != cloudSwitches.enableCloudCache || this.enableUploadToCloud != cloudSwitches.enableUploadToCloud || this.uploadToIDC != cloudSwitches.uploadToIDC) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.enableCloudCache;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.enableUploadToCloud;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.uploadToIDC;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "CloudSwitches(enableCloudCache=" + this.enableCloudCache + ", enableUploadToCloud=" + this.enableUploadToCloud + ", uploadToIDC=" + this.uploadToIDC + ")";
    }

    public CloudSwitches(boolean z16, boolean z17, boolean z18) {
        this.enableCloudCache = z16;
        this.enableUploadToCloud = z17;
        this.uploadToIDC = z18;
    }

    public /* synthetic */ CloudSwitches(boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18);
    }
}
