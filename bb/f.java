package bb;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u0013\u0010\u001eR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b \u0010\b\u00a8\u0006$"}, d2 = {"Lbb/f;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "qzoneId", "b", "f", "albumId", "c", "getBatchId", "g", "batchId", tl.h.F, "lLoc", "e", "getUploadUserUid", "l", "uploadUserUid", "getLikeKey", "i", "likeKey", "", "I", "getActionType", "()I", "(I)V", "actionType", "j", "linkId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class f {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int actionType;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String qzoneId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String batchId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String lLoc = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String uploadUserUid = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String likeKey = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String linkId = "";

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getLLoc() {
        return this.lLoc;
    }

    /* renamed from: c, reason: from getter */
    public final String getLinkId() {
        return this.linkId;
    }

    /* renamed from: d, reason: from getter */
    public final String getQzoneId() {
        return this.qzoneId;
    }

    public final void e(int i3) {
        this.actionType = i3;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchId = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lLoc = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.likeKey = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.linkId = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qzoneId = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uploadUserUid = str;
    }
}
