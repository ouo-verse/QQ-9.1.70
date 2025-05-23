package ci;

import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\u0003\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lci/g;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "groupId", "b", "j", "albumId", "", "c", "Z", tl.h.F, "()Z", "setVideo", "(Z)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "k", "batchId", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lLoc", "f", "g", "o", "uploadUserUid", DomainData.DOMAIN_NAME, "likeKey", "", "I", "()I", "i", "(I)V", "actionType", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isVideo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int actionType;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String groupId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String batchId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String lLoc = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String uploadUserUid = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String likeKey = "";

    /* renamed from: a, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: b, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: c, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    /* renamed from: d, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: e, reason: from getter */
    public final String getLLoc() {
        return this.lLoc;
    }

    /* renamed from: f, reason: from getter */
    public final String getLikeKey() {
        return this.likeKey;
    }

    /* renamed from: g, reason: from getter */
    public final String getUploadUserUid() {
        return this.uploadUserUid;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void i(int i3) {
        this.actionType = i3;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchId = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lLoc = str;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.likeKey = str;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uploadUserUid = str;
    }
}
