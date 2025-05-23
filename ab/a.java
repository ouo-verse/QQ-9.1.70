package ab;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.InviteJoinStatus;
import com.tencent.qqnt.kernel.nativeinterface.JoinApprovalStatus;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010 \u001a\u0004\b\u0012\u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b%\u0010\b\u00a8\u0006)"}, d2 = {"Lab/a;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "g", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", DomainData.DOMAIN_NAME, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", QCircleAlphaUserReporter.KEY_USER, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", h.F, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "albumInfo", "", "c", "I", "()I", "i", "(I)V", "approvalStatus", "d", "e", "l", "inviteStatus", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "loginUserStatus", "", "Ljava/lang/String;", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "entranceAlbumId", "k", "entranceAlbumOwner", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int loginUserStatus;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CommonStUser user = new CommonStUser();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumInfo albumInfo = new CommonAlbumInfo();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int approvalStatus = JoinApprovalStatus.KAPPROVALSTATUSNONE.ordinal();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int inviteStatus = InviteJoinStatus.KINVITESTATUSNONE.ordinal();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String entranceAlbumId = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private CommonStUser entranceAlbumOwner = new CommonStUser();

    /* renamed from: a, reason: from getter */
    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getApprovalStatus() {
        return this.approvalStatus;
    }

    /* renamed from: c, reason: from getter */
    public final String getEntranceAlbumId() {
        return this.entranceAlbumId;
    }

    /* renamed from: d, reason: from getter */
    public final CommonStUser getEntranceAlbumOwner() {
        return this.entranceAlbumOwner;
    }

    /* renamed from: e, reason: from getter */
    public final int getInviteStatus() {
        return this.inviteStatus;
    }

    /* renamed from: f, reason: from getter */
    public final int getLoginUserStatus() {
        return this.loginUserStatus;
    }

    /* renamed from: g, reason: from getter */
    public final CommonStUser getUser() {
        return this.user;
    }

    public final void h(CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(commonAlbumInfo, "<set-?>");
        this.albumInfo = commonAlbumInfo;
    }

    public final void i(int i3) {
        this.approvalStatus = i3;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.entranceAlbumId = str;
    }

    public final void k(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<set-?>");
        this.entranceAlbumOwner = commonStUser;
    }

    public final void l(int i3) {
        this.inviteStatus = i3;
    }

    public final void m(int i3) {
        this.loginUserStatus = i3;
    }

    public final void n(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<set-?>");
        this.user = commonStUser;
    }
}
