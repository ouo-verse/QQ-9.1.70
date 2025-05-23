package com.tencent.mobileqq.nearbypro.api.router;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0005R\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\b\u0010\u000bR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/router/a;", "", "", "a", "I", "()I", "appId", "", "b", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "posterUserId", "c", "g", "posterGender", "d", "e", "feedId", "", "[B", "f", "()[B", "feedPbByteArray", WSAutoShowCommentParams.KEY_COMMENT_ID, "commentReplyId", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "ext", "<init>", "(ILjava/lang/String;ILjava/lang/String;[BLjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String posterUserId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int posterGender;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String feedId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final byte[] feedPbByteArray;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String commentId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String commentReplyId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final JSONObject ext;

    public a(int i3, @NotNull String posterUserId, int i16, @NotNull String feedId, @Nullable byte[] bArr, @Nullable String str, @Nullable String str2, @Nullable JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(posterUserId, "posterUserId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.appId = i3;
        this.posterUserId = posterUserId;
        this.posterGender = i16;
        this.feedId = feedId;
        this.feedPbByteArray = bArr;
        this.commentId = str;
        this.commentReplyId = str2;
        this.ext = jSONObject;
    }

    /* renamed from: a, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getCommentReplyId() {
        return this.commentReplyId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final JSONObject getExt() {
        return this.ext;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final byte[] getFeedPbByteArray() {
        return this.feedPbByteArray;
    }

    /* renamed from: g, reason: from getter */
    public final int getPosterGender() {
        return this.posterGender;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getPosterUserId() {
        return this.posterUserId;
    }

    public /* synthetic */ a(int i3, String str, int i16, String str2, byte[] bArr, String str3, String str4, JSONObject jSONObject, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, str2, (i17 & 16) != 0 ? null : bArr, (i17 & 32) != 0 ? null : str3, (i17 & 64) != 0 ? null : str4, (i17 & 128) != 0 ? null : jSONObject);
    }
}
