package ci;

import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\u0018\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lci/a;", "", "", "a", "J", "getBatchId", "()J", "d", "(J)V", "batchId", "", "b", "Ljava/lang/String;", "getAlbumId", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "albumId", "", "Z", "()Z", "f", "(Z)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "e", "lLoc", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long batchId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isVideo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String lLoc = "";

    /* renamed from: a, reason: from getter */
    public final String getLLoc() {
        return this.lLoc;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void d(long j3) {
        this.batchId = j3;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lLoc = str;
    }

    public final void f(boolean z16) {
        this.isVideo = z16;
    }
}
