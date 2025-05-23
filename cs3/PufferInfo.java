package cs3;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcs3/e;", "", "", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "preDownloadInfo", "c", "originalPufferInfo", "<init>", "()V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cs3.e, reason: from toString */
/* loaded from: classes22.dex */
public final class PufferInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String preDownloadInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String originalPufferInfo;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getOriginalPufferInfo() {
        return this.originalPufferInfo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getPreDownloadInfo() {
        return this.preDownloadInfo;
    }

    public final void c(@Nullable String str) {
        this.originalPufferInfo = str;
    }

    public final void d(@Nullable String str) {
        this.preDownloadInfo = str;
    }

    @NotNull
    public String toString() {
        return "PufferInfo(preDownloadInfo=" + this.preDownloadInfo + ", originalPufferInfo=" + this.originalPufferInfo + ')';
    }
}
