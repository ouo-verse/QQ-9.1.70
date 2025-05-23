package com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0016\u0018\u00002\u00020\u0001:\u0012\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "viewType", "b", "visibility", "<init>", "(II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class BottomInteractiveVisibilityChangeMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int viewType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibility;

        public BottomInteractiveVisibilityChangeMessage(int i3, int i16) {
            this.viewType = i3;
            this.visibility = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getViewType() {
            return this.viewType;
        }

        /* renamed from: b, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BottomInteractiveVisibilityChangeMessage)) {
                return false;
            }
            BottomInteractiveVisibilityChangeMessage bottomInteractiveVisibilityChangeMessage = (BottomInteractiveVisibilityChangeMessage) other;
            if (this.viewType == bottomInteractiveVisibilityChangeMessage.viewType && this.visibility == bottomInteractiveVisibilityChangeMessage.visibility) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.viewType * 31) + this.visibility;
        }

        @NotNull
        public String toString() {
            return "BottomInteractiveVisibilityChangeMessage(viewType=" + this.viewType + ", visibility=" + this.visibility + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "source", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentFeedMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ShowInputComponentArgs inputArgs;

        public CommentFeedMessage(@NotNull String source, @NotNull ShowInputComponentArgs inputArgs) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
            this.source = source;
            this.inputArgs = inputArgs;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ShowInputComponentArgs getInputArgs() {
            return this.inputArgs;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentFeedMessage)) {
                return false;
            }
            CommentFeedMessage commentFeedMessage = (CommentFeedMessage) other;
            if (Intrinsics.areEqual(this.source, commentFeedMessage.source) && Intrinsics.areEqual(this.inputArgs, commentFeedMessage.inputArgs)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.source.hashCode() * 31) + this.inputArgs.hashCode();
        }

        @NotNull
        public String toString() {
            return "CommentFeedMessage(source=" + this.source + ", inputArgs=" + this.inputArgs + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "guildId", "b", "channelId", "c", "feedId", "", "J", "()J", WadlProxyConsts.CREATE_TIME, "e", "posterId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentMainFeedData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String channelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long createTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String posterId;

        public CommentMainFeedData() {
            this(null, null, null, 0L, null, 31, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* renamed from: b, reason: from getter */
        public final long getCreateTime() {
            return this.createTime;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getPosterId() {
            return this.posterId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentMainFeedData)) {
                return false;
            }
            CommentMainFeedData commentMainFeedData = (CommentMainFeedData) other;
            if (Intrinsics.areEqual(this.guildId, commentMainFeedData.guildId) && Intrinsics.areEqual(this.channelId, commentMainFeedData.channelId) && Intrinsics.areEqual(this.feedId, commentMainFeedData.feedId) && this.createTime == commentMainFeedData.createTime && Intrinsics.areEqual(this.posterId, commentMainFeedData.posterId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTime)) * 31) + this.posterId.hashCode();
        }

        @NotNull
        public String toString() {
            return "CommentMainFeedData(guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", createTime=" + this.createTime + ", posterId=" + this.posterId + ")";
        }

        public CommentMainFeedData(@NotNull String guildId, @NotNull String channelId, @NotNull String feedId, long j3, @NotNull String posterId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(posterId, "posterId");
            this.guildId = guildId;
            this.channelId = channelId;
            this.feedId = feedId;
            this.createTime = j3;
            this.posterId = posterId;
        }

        public /* synthetic */ CommentMainFeedData(String str, String str2, String str3, long j3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? 0L : j3, (i3 & 16) != 0 ? "" : str4);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", QCircleDaTongConstant.ElementParamValue.OPERATION, "Ljava/lang/String;", "()Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$d, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentRequestOperation extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int operation;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String commentId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object payload;

        public CommentRequestOperation(int i3, @NotNull String commentId, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(commentId, "commentId");
            this.operation = i3;
            this.commentId = commentId;
            this.payload = obj;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCommentId() {
            return this.commentId;
        }

        /* renamed from: b, reason: from getter */
        public final int getOperation() {
            return this.operation;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Object getPayload() {
            return this.payload;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentRequestOperation)) {
                return false;
            }
            CommentRequestOperation commentRequestOperation = (CommentRequestOperation) other;
            if (this.operation == commentRequestOperation.operation && Intrinsics.areEqual(this.commentId, commentRequestOperation.commentId) && Intrinsics.areEqual(this.payload, commentRequestOperation.payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.operation * 31) + this.commentId.hashCode()) * 31;
            Object obj = this.payload;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "CommentRequestOperation(operation=" + this.operation + ", commentId=" + this.commentId + ", payload=" + this.payload + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b\u001a\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$e;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "e", "()Z", "isSuccess", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$d;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$d;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$d;", "operationMessage", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "fakeComment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "d", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "response", "<init>", "(ZLcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$d;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$e, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentRequestOperationResult extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CommentRequestOperation operationMessage;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStComment fakeComment;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStDoCommentReq req;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStDoCommentRsp response;

        public /* synthetic */ CommentRequestOperationResult(boolean z16, CommentRequestOperation commentRequestOperation, GProStComment gProStComment, GProStDoCommentReq gProStDoCommentReq, GProStDoCommentRsp gProStDoCommentRsp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, commentRequestOperation, (i3 & 4) != 0 ? null : gProStComment, (i3 & 8) != 0 ? null : gProStDoCommentReq, (i3 & 16) != 0 ? null : gProStDoCommentRsp);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final GProStComment getFakeComment() {
            return this.fakeComment;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CommentRequestOperation getOperationMessage() {
            return this.operationMessage;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final GProStDoCommentReq getReq() {
            return this.req;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final GProStDoCommentRsp getResponse() {
            return this.response;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentRequestOperationResult)) {
                return false;
            }
            CommentRequestOperationResult commentRequestOperationResult = (CommentRequestOperationResult) other;
            if (this.isSuccess == commentRequestOperationResult.isSuccess && Intrinsics.areEqual(this.operationMessage, commentRequestOperationResult.operationMessage) && Intrinsics.areEqual(this.fakeComment, commentRequestOperationResult.fakeComment) && Intrinsics.areEqual(this.req, commentRequestOperationResult.req) && Intrinsics.areEqual(this.response, commentRequestOperationResult.response)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode3 = ((r06 * 31) + this.operationMessage.hashCode()) * 31;
            GProStComment gProStComment = this.fakeComment;
            int i3 = 0;
            if (gProStComment == null) {
                hashCode = 0;
            } else {
                hashCode = gProStComment.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            GProStDoCommentReq gProStDoCommentReq = this.req;
            if (gProStDoCommentReq == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = gProStDoCommentReq.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            GProStDoCommentRsp gProStDoCommentRsp = this.response;
            if (gProStDoCommentRsp != null) {
                i3 = gProStDoCommentRsp.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "CommentRequestOperationResult(isSuccess=" + this.isSuccess + ", operationMessage=" + this.operationMessage + ", fakeComment=" + this.fakeComment + ", req=" + this.req + ", response=" + this.response + ")";
        }

        public CommentRequestOperationResult(boolean z16, @NotNull CommentRequestOperation operationMessage, @Nullable GProStComment gProStComment, @Nullable GProStDoCommentReq gProStDoCommentReq, @Nullable GProStDoCommentRsp gProStDoCommentRsp) {
            Intrinsics.checkNotNullParameter(operationMessage, "operationMessage");
            this.isSuccess = z16;
            this.operationMessage = operationMessage;
            this.fakeComment = gProStComment;
            this.req = gProStDoCommentReq;
            this.response = gProStDoCommentRsp;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u001e\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$f;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", h.F, "(Ljava/lang/String;)V", "feedId", "Z", "c", "()Z", "needNotifyUpdateList", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "j", "(Ljava/lang/Integer;)V", "preferStatus", "d", "i", "preferCount", "g", "commentCount", "f", "k", "shareCount", "<init>", "(Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$f, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ModifyBottomInteractiveDataMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String feedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needNotifyUpdateList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Integer preferStatus;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Integer preferCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Integer commentCount;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Integer shareCount;

        public ModifyBottomInteractiveDataMessage() {
            this(null, false, null, null, null, null, 63, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Integer getCommentCount() {
            return this.commentCount;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getNeedNotifyUpdateList() {
            return this.needNotifyUpdateList;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final Integer getPreferCount() {
            return this.preferCount;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final Integer getPreferStatus() {
            return this.preferStatus;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModifyBottomInteractiveDataMessage)) {
                return false;
            }
            ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = (ModifyBottomInteractiveDataMessage) other;
            if (Intrinsics.areEqual(this.feedId, modifyBottomInteractiveDataMessage.feedId) && this.needNotifyUpdateList == modifyBottomInteractiveDataMessage.needNotifyUpdateList && Intrinsics.areEqual(this.preferStatus, modifyBottomInteractiveDataMessage.preferStatus) && Intrinsics.areEqual(this.preferCount, modifyBottomInteractiveDataMessage.preferCount) && Intrinsics.areEqual(this.commentCount, modifyBottomInteractiveDataMessage.commentCount) && Intrinsics.areEqual(this.shareCount, modifyBottomInteractiveDataMessage.shareCount)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final Integer getShareCount() {
            return this.shareCount;
        }

        public final void g(@Nullable Integer num) {
            this.commentCount = num;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.feedId = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4 = this.feedId.hashCode() * 31;
            boolean z16 = this.needNotifyUpdateList;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode4 + i3) * 31;
            Integer num = this.preferStatus;
            int i17 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i18 = (i16 + hashCode) * 31;
            Integer num2 = this.preferCount;
            if (num2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num2.hashCode();
            }
            int i19 = (i18 + hashCode2) * 31;
            Integer num3 = this.commentCount;
            if (num3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = num3.hashCode();
            }
            int i26 = (i19 + hashCode3) * 31;
            Integer num4 = this.shareCount;
            if (num4 != null) {
                i17 = num4.hashCode();
            }
            return i26 + i17;
        }

        public final void i(@Nullable Integer num) {
            this.preferCount = num;
        }

        public final void j(@Nullable Integer num) {
            this.preferStatus = num;
        }

        public final void k(@Nullable Integer num) {
            this.shareCount = num;
        }

        @NotNull
        public String toString() {
            return "ModifyBottomInteractiveDataMessage(feedId=" + this.feedId + ", needNotifyUpdateList=" + this.needNotifyUpdateList + ", preferStatus=" + this.preferStatus + ", preferCount=" + this.preferCount + ", commentCount=" + this.commentCount + ", shareCount=" + this.shareCount + ")";
        }

        public /* synthetic */ ModifyBottomInteractiveDataMessage(String str, boolean z16, Integer num, Integer num2, Integer num3, Integer num4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : num2, (i3 & 16) != 0 ? null : num3, (i3 & 32) == 0 ? num4 : null);
        }

        public ModifyBottomInteractiveDataMessage(@NotNull String feedId, boolean z16, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.feedId = feedId;
            this.needNotifyUpdateList = z16;
            this.preferStatus = num;
            this.preferCount = num2;
            this.commentCount = num3;
            this.shareCount = num4;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$g;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "d", "()Z", "isSuccess", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "c", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "fakeComment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "commentReq", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "commentRsp", "<init>", "(ZLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$g, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnCommentCompletedMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStComment fakeComment;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStDoCommentReq commentReq;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStDoCommentRsp commentRsp;

        public OnCommentCompletedMessage(boolean z16, @NotNull GProStComment fakeComment, @NotNull GProStDoCommentReq commentReq, @Nullable GProStDoCommentRsp gProStDoCommentRsp) {
            Intrinsics.checkNotNullParameter(fakeComment, "fakeComment");
            Intrinsics.checkNotNullParameter(commentReq, "commentReq");
            this.isSuccess = z16;
            this.fakeComment = fakeComment;
            this.commentReq = commentReq;
            this.commentRsp = gProStDoCommentRsp;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GProStDoCommentReq getCommentReq() {
            return this.commentReq;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final GProStDoCommentRsp getCommentRsp() {
            return this.commentRsp;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final GProStComment getFakeComment() {
            return this.fakeComment;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnCommentCompletedMessage)) {
                return false;
            }
            OnCommentCompletedMessage onCommentCompletedMessage = (OnCommentCompletedMessage) other;
            if (this.isSuccess == onCommentCompletedMessage.isSuccess && Intrinsics.areEqual(this.fakeComment, onCommentCompletedMessage.fakeComment) && Intrinsics.areEqual(this.commentReq, onCommentCompletedMessage.commentReq) && Intrinsics.areEqual(this.commentRsp, onCommentCompletedMessage.commentRsp)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode2 = ((((r06 * 31) + this.fakeComment.hashCode()) * 31) + this.commentReq.hashCode()) * 31;
            GProStDoCommentRsp gProStDoCommentRsp = this.commentRsp;
            if (gProStDoCommentRsp == null) {
                hashCode = 0;
            } else {
                hashCode = gProStDoCommentRsp.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "OnCommentCompletedMessage(isSuccess=" + this.isSuccess + ", fakeComment=" + this.fakeComment + ", commentReq=" + this.commentReq + ", commentRsp=" + this.commentRsp + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "b", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;)V", "mainFeedData", "<init>", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$h, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnCommentMainFeedDataResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private CommentMainFeedData mainFeedData;

        public OnCommentMainFeedDataResult() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final CommentMainFeedData getMainFeedData() {
            return this.mainFeedData;
        }

        public final void b(@Nullable CommentMainFeedData commentMainFeedData) {
            this.mainFeedData = commentMainFeedData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnCommentMainFeedDataResult) && Intrinsics.areEqual(this.mainFeedData, ((OnCommentMainFeedDataResult) other).mainFeedData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            CommentMainFeedData commentMainFeedData = this.mainFeedData;
            if (commentMainFeedData == null) {
                return 0;
            }
            return commentMainFeedData.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnCommentMainFeedDataResult(mainFeedData=" + this.mainFeedData + ")";
        }

        public OnCommentMainFeedDataResult(@Nullable CommentMainFeedData commentMainFeedData) {
            this.mainFeedData = commentMainFeedData;
        }

        public /* synthetic */ OnCommentMainFeedDataResult(CommentMainFeedData commentMainFeedData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : commentMainFeedData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "fakeComment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "getReq", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "req", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$i, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnCommentSendingMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStComment fakeComment;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStDoCommentReq req;

        public OnCommentSendingMessage(@NotNull GProStComment fakeComment, @NotNull GProStDoCommentReq req) {
            Intrinsics.checkNotNullParameter(fakeComment, "fakeComment");
            Intrinsics.checkNotNullParameter(req, "req");
            this.fakeComment = fakeComment;
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GProStComment getFakeComment() {
            return this.fakeComment;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnCommentSendingMessage)) {
                return false;
            }
            OnCommentSendingMessage onCommentSendingMessage = (OnCommentSendingMessage) other;
            if (Intrinsics.areEqual(this.fakeComment, onCommentSendingMessage.fakeComment) && Intrinsics.areEqual(this.req, onCommentSendingMessage.req)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.fakeComment.hashCode() * 31) + this.req.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnCommentSendingMessage(fakeComment=" + this.fakeComment + ", req=" + this.req + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$j;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "feedId", "b", "I", "()I", "newPreferStatus", "<init>", "(Ljava/lang/String;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$j, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnDoPreferMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int newPreferStatus;

        public OnDoPreferMessage(@NotNull String feedId, int i3) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.feedId = feedId;
            this.newPreferStatus = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getNewPreferStatus() {
            return this.newPreferStatus;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnDoPreferMessage)) {
                return false;
            }
            OnDoPreferMessage onDoPreferMessage = (OnDoPreferMessage) other;
            if (Intrinsics.areEqual(this.feedId, onDoPreferMessage.feedId) && this.newPreferStatus == onDoPreferMessage.newPreferStatus) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.feedId.hashCode() * 31) + this.newPreferStatus;
        }

        @NotNull
        public String toString() {
            return "OnDoPreferMessage(feedId=" + this.feedId + ", newPreferStatus=" + this.newPreferStatus + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u000e\u0010\u001fR\u0019\u0010%\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getReplyType", "()I", "replyType", "b", "Z", "d", "()Z", "isSuccess", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "fakeReply", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "replyRsp", "f", "Ljava/lang/Object;", "getPayload", "()Ljava/lang/Object;", "payload", "<init>", "(IZLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$k, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnReplyCommentCompletedMessage {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int replyType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStReply fakeReply;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStDoReplyReq req;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStDoReplyRsp replyRsp;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object payload;

        public OnReplyCommentCompletedMessage(int i3, boolean z16, @NotNull GProStReply fakeReply, @NotNull GProStDoReplyReq req, @Nullable GProStDoReplyRsp gProStDoReplyRsp, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(fakeReply, "fakeReply");
            Intrinsics.checkNotNullParameter(req, "req");
            this.replyType = i3;
            this.isSuccess = z16;
            this.fakeReply = fakeReply;
            this.req = req;
            this.replyRsp = gProStDoReplyRsp;
            this.payload = obj;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GProStReply getFakeReply() {
            return this.fakeReply;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final GProStDoReplyRsp getReplyRsp() {
            return this.replyRsp;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final GProStDoReplyReq getReq() {
            return this.req;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnReplyCommentCompletedMessage)) {
                return false;
            }
            OnReplyCommentCompletedMessage onReplyCommentCompletedMessage = (OnReplyCommentCompletedMessage) other;
            if (this.replyType == onReplyCommentCompletedMessage.replyType && this.isSuccess == onReplyCommentCompletedMessage.isSuccess && Intrinsics.areEqual(this.fakeReply, onReplyCommentCompletedMessage.fakeReply) && Intrinsics.areEqual(this.req, onReplyCommentCompletedMessage.req) && Intrinsics.areEqual(this.replyRsp, onReplyCommentCompletedMessage.replyRsp) && Intrinsics.areEqual(this.payload, onReplyCommentCompletedMessage.payload)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int i3 = this.replyType * 31;
            boolean z16 = this.isSuccess;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int hashCode2 = (((((i3 + i16) * 31) + this.fakeReply.hashCode()) * 31) + this.req.hashCode()) * 31;
            GProStDoReplyRsp gProStDoReplyRsp = this.replyRsp;
            int i17 = 0;
            if (gProStDoReplyRsp == null) {
                hashCode = 0;
            } else {
                hashCode = gProStDoReplyRsp.hashCode();
            }
            int i18 = (hashCode2 + hashCode) * 31;
            Object obj = this.payload;
            if (obj != null) {
                i17 = obj.hashCode();
            }
            return i18 + i17;
        }

        @NotNull
        public String toString() {
            return "OnReplyCommentCompletedMessage(replyType=" + this.replyType + ", isSuccess=" + this.isSuccess + ", fakeReply=" + this.fakeReply + ", req=" + this.req + ", replyRsp=" + this.replyRsp + ", payload=" + this.payload + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "replyType", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "fakeReply", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "req", "d", "Ljava/lang/Object;", "getPayload", "()Ljava/lang/Object;", "payload", "<init>", "(ILcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$l, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnReplyCommentSendingMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int replyType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStReply fakeReply;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStDoReplyReq req;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object payload;

        public OnReplyCommentSendingMessage(int i3, @NotNull GProStReply fakeReply, @NotNull GProStDoReplyReq req, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(fakeReply, "fakeReply");
            Intrinsics.checkNotNullParameter(req, "req");
            this.replyType = i3;
            this.fakeReply = fakeReply;
            this.req = req;
            this.payload = obj;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GProStReply getFakeReply() {
            return this.fakeReply;
        }

        /* renamed from: b, reason: from getter */
        public final int getReplyType() {
            return this.replyType;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final GProStDoReplyReq getReq() {
            return this.req;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnReplyCommentSendingMessage)) {
                return false;
            }
            OnReplyCommentSendingMessage onReplyCommentSendingMessage = (OnReplyCommentSendingMessage) other;
            if (this.replyType == onReplyCommentSendingMessage.replyType && Intrinsics.areEqual(this.fakeReply, onReplyCommentSendingMessage.fakeReply) && Intrinsics.areEqual(this.req, onReplyCommentSendingMessage.req) && Intrinsics.areEqual(this.payload, onReplyCommentSendingMessage.payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((this.replyType * 31) + this.fakeReply.hashCode()) * 31) + this.req.hashCode()) * 31;
            Object obj = this.payload;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "OnReplyCommentSendingMessage(replyType=" + this.replyType + ", fakeReply=" + this.fakeReply + ", req=" + this.req + ", payload=" + this.payload + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$m;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "newSpeakPermission", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$m, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnSpeakPermissionChangedMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final SpeakPermissionType newSpeakPermission;

        public OnSpeakPermissionChangedMessage(@NotNull SpeakPermissionType newSpeakPermission) {
            Intrinsics.checkNotNullParameter(newSpeakPermission, "newSpeakPermission");
            this.newSpeakPermission = newSpeakPermission;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final SpeakPermissionType getNewSpeakPermission() {
            return this.newSpeakPermission;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnSpeakPermissionChangedMessage) && this.newSpeakPermission == ((OnSpeakPermissionChangedMessage) other).newSpeakPermission) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.newSpeakPermission.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnSpeakPermissionChangedMessage(newSpeakPermission=" + this.newSpeakPermission + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$n;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "source", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$n, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ReplyCommentMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ShowInputComponentArgs inputArgs;

        public ReplyCommentMessage(@NotNull String source, @NotNull ShowInputComponentArgs inputArgs) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
            this.source = source;
            this.inputArgs = inputArgs;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ShowInputComponentArgs getInputArgs() {
            return this.inputArgs;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyCommentMessage)) {
                return false;
            }
            ReplyCommentMessage replyCommentMessage = (ReplyCommentMessage) other;
            if (Intrinsics.areEqual(this.source, replyCommentMessage.source) && Intrinsics.areEqual(this.inputArgs, replyCommentMessage.inputArgs)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.source.hashCode() * 31) + this.inputArgs.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReplyCommentMessage(source=" + this.source + ", inputArgs=" + this.inputArgs + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$o;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", QCircleDaTongConstant.ElementParamValue.OPERATION, "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", WSAutoShowCommentParams.KEY_REPLY_ID, "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$o, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ReplyRequestOperation extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int operation;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String replyId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object payload;

        public ReplyRequestOperation(int i3, @NotNull String replyId, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(replyId, "replyId");
            this.operation = i3;
            this.replyId = replyId;
            this.payload = obj;
        }

        /* renamed from: a, reason: from getter */
        public final int getOperation() {
            return this.operation;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Object getPayload() {
            return this.payload;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getReplyId() {
            return this.replyId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyRequestOperation)) {
                return false;
            }
            ReplyRequestOperation replyRequestOperation = (ReplyRequestOperation) other;
            if (this.operation == replyRequestOperation.operation && Intrinsics.areEqual(this.replyId, replyRequestOperation.replyId) && Intrinsics.areEqual(this.payload, replyRequestOperation.payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.operation * 31) + this.replyId.hashCode()) * 31;
            Object obj = this.payload;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "ReplyRequestOperation(operation=" + this.operation + ", replyId=" + this.replyId + ", payload=" + this.payload + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b\u001a\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$p;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "e", "()Z", "isSuccess", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$o;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$o;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$o;", "operationMessage", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "fakeReply", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "d", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "response", "<init>", "(ZLcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$o;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$p, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ReplyRequestOperationResult extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ReplyRequestOperation operationMessage;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStReply fakeReply;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStDoReplyReq req;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStDoReplyRsp response;

        public ReplyRequestOperationResult(boolean z16, @NotNull ReplyRequestOperation operationMessage, @Nullable GProStReply gProStReply, @Nullable GProStDoReplyReq gProStDoReplyReq, @Nullable GProStDoReplyRsp gProStDoReplyRsp) {
            Intrinsics.checkNotNullParameter(operationMessage, "operationMessage");
            this.isSuccess = z16;
            this.operationMessage = operationMessage;
            this.fakeReply = gProStReply;
            this.req = gProStDoReplyReq;
            this.response = gProStDoReplyRsp;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final GProStReply getFakeReply() {
            return this.fakeReply;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ReplyRequestOperation getOperationMessage() {
            return this.operationMessage;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final GProStDoReplyReq getReq() {
            return this.req;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final GProStDoReplyRsp getResponse() {
            return this.response;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyRequestOperationResult)) {
                return false;
            }
            ReplyRequestOperationResult replyRequestOperationResult = (ReplyRequestOperationResult) other;
            if (this.isSuccess == replyRequestOperationResult.isSuccess && Intrinsics.areEqual(this.operationMessage, replyRequestOperationResult.operationMessage) && Intrinsics.areEqual(this.fakeReply, replyRequestOperationResult.fakeReply) && Intrinsics.areEqual(this.req, replyRequestOperationResult.req) && Intrinsics.areEqual(this.response, replyRequestOperationResult.response)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode3 = ((r06 * 31) + this.operationMessage.hashCode()) * 31;
            GProStReply gProStReply = this.fakeReply;
            int i3 = 0;
            if (gProStReply == null) {
                hashCode = 0;
            } else {
                hashCode = gProStReply.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            GProStDoReplyReq gProStDoReplyReq = this.req;
            if (gProStDoReplyReq == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = gProStDoReplyReq.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            GProStDoReplyRsp gProStDoReplyRsp = this.response;
            if (gProStDoReplyRsp != null) {
                i3 = gProStDoReplyRsp.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "ReplyRequestOperationResult(isSuccess=" + this.isSuccess + ", operationMessage=" + this.operationMessage + ", fakeReply=" + this.fakeReply + ", req=" + this.req + ", response=" + this.response + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$q;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$q, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ShowInputComponentMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ShowInputComponentArgs inputArgs;

        public ShowInputComponentMessage(@NotNull ShowInputComponentArgs inputArgs) {
            Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
            this.inputArgs = inputArgs;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ShowInputComponentArgs getInputArgs() {
            return this.inputArgs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ShowInputComponentMessage) && Intrinsics.areEqual(this.inputArgs, ((ShowInputComponentMessage) other).inputArgs)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.inputArgs.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowInputComponentMessage(inputArgs=" + this.inputArgs + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0010\u0010\u001aR\u001f\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u0018\u0010\u001fR\u0019\u0010$\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$r;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "e", "()Z", "needClearInput", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "c", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "d", "Ljava/lang/Object;", "()Ljava/lang/Object;", "extData", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "f", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "originalPic", "<init>", "(ZLcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;Ljava/lang/String;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Boolean;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a$r, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class TryToSendInputContentMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needClearInput;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ShowInputComponentArgs inputArgs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String content;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object extData;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final ArrayList<LocalMediaInfo> localMediaInfos;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Boolean originalPic;

        public /* synthetic */ TryToSendInputContentMessage(boolean z16, ShowInputComponentArgs showInputComponentArgs, String str, Object obj, ArrayList arrayList, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, showInputComponentArgs, str, (i3 & 8) != 0 ? null : obj, (i3 & 16) != 0 ? null : arrayList, (i3 & 32) != 0 ? Boolean.FALSE : bool);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Object getExtData() {
            return this.extData;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final ShowInputComponentArgs getInputArgs() {
            return this.inputArgs;
        }

        @Nullable
        public final ArrayList<LocalMediaInfo> d() {
            return this.localMediaInfos;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getNeedClearInput() {
            return this.needClearInput;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TryToSendInputContentMessage)) {
                return false;
            }
            TryToSendInputContentMessage tryToSendInputContentMessage = (TryToSendInputContentMessage) other;
            if (this.needClearInput == tryToSendInputContentMessage.needClearInput && Intrinsics.areEqual(this.inputArgs, tryToSendInputContentMessage.inputArgs) && Intrinsics.areEqual(this.content, tryToSendInputContentMessage.content) && Intrinsics.areEqual(this.extData, tryToSendInputContentMessage.extData) && Intrinsics.areEqual(this.localMediaInfos, tryToSendInputContentMessage.localMediaInfos) && Intrinsics.areEqual(this.originalPic, tryToSendInputContentMessage.originalPic)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final Boolean getOriginalPic() {
            return this.originalPic;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            boolean z16 = this.needClearInput;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode4 = ((r06 * 31) + this.inputArgs.hashCode()) * 31;
            String str = this.content;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode4 + hashCode) * 31;
            Object obj = this.extData;
            if (obj == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = obj.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            ArrayList<LocalMediaInfo> arrayList = this.localMediaInfos;
            if (arrayList == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = arrayList.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Boolean bool = this.originalPic;
            if (bool != null) {
                i3 = bool.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "TryToSendInputContentMessage(needClearInput=" + this.needClearInput + ", inputArgs=" + this.inputArgs + ", content=" + this.content + ", extData=" + this.extData + ", localMediaInfos=" + this.localMediaInfos + ", originalPic=" + this.originalPic + ")";
        }

        public TryToSendInputContentMessage(boolean z16, @NotNull ShowInputComponentArgs inputArgs, @Nullable String str, @Nullable Object obj, @Nullable ArrayList<LocalMediaInfo> arrayList, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
            this.needClearInput = z16;
            this.inputArgs = inputArgs;
            this.content = str;
            this.extData = obj;
            this.localMediaInfos = arrayList;
            this.originalPic = bool;
        }
    }
}
