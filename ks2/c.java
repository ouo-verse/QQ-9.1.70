package ks2;

import com.tencent.mm.vfs.QuotaFileSystem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lks2/c;", "", "", "a", "", "I", QuotaFileSystem.STAT_FILE_COUNT, "", "b", "J", "fileTotalSpace", "c", "fileUsedSpace", "<init>", "(IJJ)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int fileCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long fileTotalSpace;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public long fileUsedSpace;

    public c() {
        this(0, 0L, 0L, 7, null);
    }

    public final boolean a() {
        return (this.fileCount == -1 || this.fileTotalSpace == 1 || this.fileUsedSpace == -1) ? false : true;
    }

    public c(int i3, long j3, long j16) {
        this.fileCount = i3;
        this.fileTotalSpace = j3;
        this.fileUsedSpace = j16;
    }

    public /* synthetic */ c(int i3, long j3, long j16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? -1L : j3, (i16 & 4) != 0 ? -1L : j16);
    }
}
