package bb;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0014\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b\u0010\u0010\u001e\"\u0004\b\"\u0010 R\"\u0010$\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\f\u0010\u001e\"\u0004\b\u001c\u0010 \u00a8\u0006'"}, d2 = {"Lbb/g;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "uin", "f", "albumId", "c", "getLLocId", "i", "lLocId", "d", "getLinkId", "k", "linkId", "e", "getLeftAttachInfo", "j", "leftAttachInfo", "getRightAttachInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "rightAttachInfo", "", "g", "Z", "()Z", "l", "(Z)V", "isRefresh", tl.h.F, "isFetchRight", "isFetchLeft", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String lLocId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String linkId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String leftAttachInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String rightAttachInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isRefresh;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFetchRight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFetchLeft;

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsFetchLeft() {
        return this.isFetchLeft;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsFetchRight() {
        return this.isFetchRight;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final void f(String str) {
        this.albumId = str;
    }

    public final void g(boolean z16) {
        this.isFetchLeft = z16;
    }

    public final void h(boolean z16) {
        this.isFetchRight = z16;
    }

    public final void i(String str) {
        this.lLocId = str;
    }

    public final void j(String str) {
        this.leftAttachInfo = str;
    }

    public final void k(String str) {
        this.linkId = str;
    }

    public final void l(boolean z16) {
        this.isRefresh = z16;
    }

    public final void m(String str) {
        this.rightAttachInfo = str;
    }

    public final void n(String str) {
        this.uin = str;
    }
}
