package ge;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u001d\u0010\u0019\u00a8\u0006!"}, d2 = {"Lge/g;", "", "", "a", "Ljava/lang/String;", "getAlbumId", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "albumId", "b", "j", "lLoc", "c", "k", "leftAttachInfo", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "rightAttachInfo", "", "e", "Z", "f", "()Z", "l", "(Z)V", "isRefresh", "i", "isFetchRight", tl.h.F, "isFetchLeft", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String lLoc = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String leftAttachInfo = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String rightAttachInfo = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isRefresh;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isFetchRight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isFetchLeft;

    /* renamed from: a, reason: from getter */
    public final String getLLoc() {
        return this.lLoc;
    }

    /* renamed from: b, reason: from getter */
    public final String getLeftAttachInfo() {
        return this.leftAttachInfo;
    }

    /* renamed from: c, reason: from getter */
    public final String getRightAttachInfo() {
        return this.rightAttachInfo;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsFetchLeft() {
        return this.isFetchLeft;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsFetchRight() {
        return this.isFetchRight;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void h(boolean z16) {
        this.isFetchLeft = z16;
    }

    public final void i(boolean z16) {
        this.isFetchRight = z16;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lLoc = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftAttachInfo = str;
    }

    public final void l(boolean z16) {
        this.isRefresh = z16;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightAttachInfo = str;
    }
}
