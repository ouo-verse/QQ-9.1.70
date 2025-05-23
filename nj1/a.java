package nj1;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\n\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b\u001c\u0010\u0012R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010\u0012\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lnj1/a;", "", "", "toString", "", "a", "I", "getMaxLength", "()I", "maxLength", "", "b", "Z", "k", "()Z", "isReply", "c", "Ljava/lang/String;", "()Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "", "d", "J", "e", "()J", WadlProxyConsts.CREATE_TIME, "g", "replyTargetId", "f", "commentPosterId", h.F, "replyTargetUserId", "activeType", "i", "clickRegion", "j", "placeHolder", "l", "(Z)V", "supportAt", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "troopName", "<init>", "(IZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxLength;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isReply;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String commentId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long createTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String replyTargetId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String commentPosterId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String replyTargetUserId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int activeType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int clickRegion;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String placeHolder;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean supportAt;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopName;

    public a(int i3, boolean z16, @NotNull String commentId, long j3, @NotNull String replyTargetId, @NotNull String commentPosterId, @NotNull String replyTargetUserId, int i16, int i17, @NotNull String placeHolder, boolean z17, @NotNull String troopName) {
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyTargetId, "replyTargetId");
        Intrinsics.checkNotNullParameter(commentPosterId, "commentPosterId");
        Intrinsics.checkNotNullParameter(replyTargetUserId, "replyTargetUserId");
        Intrinsics.checkNotNullParameter(placeHolder, "placeHolder");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        this.maxLength = i3;
        this.isReply = z16;
        this.commentId = commentId;
        this.createTime = j3;
        this.replyTargetId = replyTargetId;
        this.commentPosterId = commentPosterId;
        this.replyTargetUserId = replyTargetUserId;
        this.activeType = i16;
        this.clickRegion = i17;
        this.placeHolder = placeHolder;
        this.supportAt = z17;
        this.troopName = troopName;
    }

    /* renamed from: a, reason: from getter */
    public final int getActiveType() {
        return this.activeType;
    }

    /* renamed from: b, reason: from getter */
    public final int getClickRegion() {
        return this.clickRegion;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCommentPosterId() {
        return this.commentPosterId;
    }

    /* renamed from: e, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPlaceHolder() {
        return this.placeHolder;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getReplyTargetId() {
        return this.replyTargetId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getReplyTargetUserId() {
        return this.replyTargetUserId;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getSupportAt() {
        return this.supportAt;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getTroopName() {
        return this.troopName;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsReply() {
        return this.isReply;
    }

    public final void l(boolean z16) {
        this.supportAt = z16;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.troopName = str;
    }

    @NotNull
    public String toString() {
        return "maxLength=" + this.maxLength + " isReply=" + this.isReply + " replyTargetId=" + this.replyTargetId + " commentPosterId=" + this.commentPosterId + " replyTargetUserId=" + this.replyTargetUserId + " activeType=" + this.activeType + " clickRegion=" + this.clickRegion + " placeHolder=" + this.placeHolder + " supportAt=" + this.supportAt;
    }

    public /* synthetic */ a(int i3, boolean z16, String str, long j3, String str2, String str3, String str4, int i16, int i17, String str5, boolean z17, String str6, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, z16, str, j3, str2, str3, str4, i16, i17, str5, (i18 & 1024) != 0 ? false : z17, (i18 & 2048) != 0 ? "" : str6);
    }
}
