package com.qzone.reborn.albumx.common.bean;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\"\u00102\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010.\u001a\u0004\b\u0012\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/d;", "", "", "a", "Z", "g", "()Z", DomainData.DOMAIN_NAME, "(Z)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "groupId", "c", tl.h.F, "albumId", "i", "batchId", "e", "l", "llocId", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "uin", "", "J", "getCreateTime", "()J", "j", "(J)V", WadlProxyConsts.CREATE_TIME, "getContent", "setContent", "content", "getCommentId", "setCommentId", WSAutoShowCommentParams.KEY_COMMENT_ID, "getReplyClientKey", "setReplyClientKey", "replyClientKey", "", "I", "()I", "setCommentNum", "(I)V", "commentNum", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isVideo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long createTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int commentNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String groupId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String batchId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String llocId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String uin = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String content = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String commentId = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String replyClientKey = "";

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    /* renamed from: c, reason: from getter */
    public final int getCommentNum() {
        return this.commentNum;
    }

    /* renamed from: d, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: e, reason: from getter */
    public final String getLlocId() {
        return this.llocId;
    }

    /* renamed from: f, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchId = str;
    }

    public final void j(long j3) {
        this.createTime = j3;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.llocId = str;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    public final void n(boolean z16) {
        this.isVideo = z16;
    }
}
