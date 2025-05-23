package ci;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010$\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u0019\u0010\u001c\"\u0004\b#\u0010\u001e\u00a8\u0006'"}, d2 = {"Lci/h;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "groupId", "b", "j", "albumId", "d", "o", "lLocId", "k", "batchId", "e", "p", "leftAttachInfo", "f", "r", "rightAttachInfo", "", "g", "Z", "i", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "isRefresh", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isFetchRight", "l", "isFetchLeft", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String lLocId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String batchId;

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
    public final String getBatchId() {
        return this.batchId;
    }

    /* renamed from: c, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: d, reason: from getter */
    public final String getLLocId() {
        return this.lLocId;
    }

    /* renamed from: e, reason: from getter */
    public final String getLeftAttachInfo() {
        return this.leftAttachInfo;
    }

    /* renamed from: f, reason: from getter */
    public final String getRightAttachInfo() {
        return this.rightAttachInfo;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsFetchLeft() {
        return this.isFetchLeft;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsFetchRight() {
        return this.isFetchRight;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final void j(String str) {
        this.albumId = str;
    }

    public final void k(String str) {
        this.batchId = str;
    }

    public final void l(boolean z16) {
        this.isFetchLeft = z16;
    }

    public final void m(boolean z16) {
        this.isFetchRight = z16;
    }

    public final void n(String str) {
        this.groupId = str;
    }

    public final void o(String str) {
        this.lLocId = str;
    }

    public final void p(String str) {
        this.leftAttachInfo = str;
    }

    public final void q(boolean z16) {
        this.isRefresh = z16;
    }

    public final void r(String str) {
        this.rightAttachInfo = str;
    }
}
