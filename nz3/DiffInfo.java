package nz3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\b\u001a\u0004\b\u000f\u0010\nR\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0019\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u001b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0007\u0010\nR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0017\u0010\n\u00a8\u0006 "}, d2 = {"Lnz3/a;", "", "", "j", "i", "", "toString", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "localPath", "", "b", "J", h.F, "()J", "version", "downloadUrl", "d", "md5", "e", "g", "size", "f", "oldMd5", "crc32", "oldCrc32", "<init>", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* renamed from: nz3.a, reason: from toString */
/* loaded from: classes25.dex */
public final class DiffInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String localPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long version;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String downloadUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String md5;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long size;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String old_md5;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String crc32;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String oldCrc32;

    public DiffInfo() {
        this(0L, null, null, 0L, null, null, null, 127, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCrc32() {
        return this.crc32;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getOldCrc32() {
        return this.oldCrc32;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getOld_md5() {
        return this.old_md5;
    }

    /* renamed from: g, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: h, reason: from getter */
    public final long getVersion() {
        return this.version;
    }

    public final boolean i() {
        boolean z16;
        if (this.version <= 0) {
            return false;
        }
        if (this.downloadUrl.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public final boolean j() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this.downloadUrl.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.md5.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && this.size > 0) {
                if (this.old_md5.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.localPath = str;
    }

    @NotNull
    public String toString() {
        return "DiffInfo(version=" + this.version + ", downloadUrl='" + this.downloadUrl + "', md5='" + this.md5 + "', crc32='" + this.crc32 + "', size=" + this.size + ", old_md5='" + this.old_md5 + "', old_crc32='" + this.oldCrc32 + "' localPath='" + this.localPath + "')";
    }

    public DiffInfo(long j3, @NotNull String downloadUrl, @NotNull String md5, long j16, @NotNull String oldMd5, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(downloadUrl, "downloadUrl");
        Intrinsics.checkParameterIsNotNull(md5, "md5");
        Intrinsics.checkParameterIsNotNull(oldMd5, "oldMd5");
        this.version = j3;
        this.downloadUrl = downloadUrl;
        this.md5 = md5;
        this.size = j16;
        this.old_md5 = oldMd5;
        this.crc32 = str;
        this.oldCrc32 = str2;
        this.localPath = "";
    }

    public /* synthetic */ DiffInfo(long j3, String str, String str2, long j16, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? 0L : j16, (i3 & 16) == 0 ? str3 : "", (i3 & 32) != 0 ? null : str4, (i3 & 64) == 0 ? str5 : null);
    }
}
