package com.tencent.mobileqq.guild.feed.gallery.constants;

import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage;", "", "<init>", "()V", "a", "CommentPanelShowArgs", "b", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$a;", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$b;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class GuildFeedGalleryMessage {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\nB\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$a;", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "feedId", "I", "c", "()I", "setType", "(I)V", "type", "count", "<init>", "(Ljava/lang/String;II)V", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentDataChangeArgs extends GuildFeedGalleryMessage {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int type;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int count;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentDataChangeArgs(@NotNull String feedId, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.feedId = feedId;
            this.type = i3;
            this.count = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: c, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentDataChangeArgs)) {
                return false;
            }
            CommentDataChangeArgs commentDataChangeArgs = (CommentDataChangeArgs) other;
            if (Intrinsics.areEqual(this.feedId, commentDataChangeArgs.feedId) && this.type == commentDataChangeArgs.type && this.count == commentDataChangeArgs.count) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.feedId.hashCode() * 31) + this.type) * 31) + this.count;
        }

        @NotNull
        public String toString() {
            return "CommentDataChangeArgs(feedId=" + this.feedId + ", type=" + this.type + ", count=" + this.count + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$b;", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "c", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "speakType", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "args", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;", "()Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;", "showArgs", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentPanelShowProxyArgs extends GuildFeedGalleryMessage {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final SpeakPermissionType speakType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ShowInputComponentArgs args;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CommentPanelShowArgs showArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentPanelShowProxyArgs(@NotNull SpeakPermissionType speakType, @NotNull ShowInputComponentArgs args, @NotNull CommentPanelShowArgs showArgs) {
            super(null);
            Intrinsics.checkNotNullParameter(speakType, "speakType");
            Intrinsics.checkNotNullParameter(args, "args");
            Intrinsics.checkNotNullParameter(showArgs, "showArgs");
            this.speakType = speakType;
            this.args = args;
            this.showArgs = showArgs;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ShowInputComponentArgs getArgs() {
            return this.args;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CommentPanelShowArgs getShowArgs() {
            return this.showArgs;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final SpeakPermissionType getSpeakType() {
            return this.speakType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentPanelShowProxyArgs)) {
                return false;
            }
            CommentPanelShowProxyArgs commentPanelShowProxyArgs = (CommentPanelShowProxyArgs) other;
            if (this.speakType == commentPanelShowProxyArgs.speakType && Intrinsics.areEqual(this.args, commentPanelShowProxyArgs.args) && Intrinsics.areEqual(this.showArgs, commentPanelShowProxyArgs.showArgs)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.speakType.hashCode() * 31) + this.args.hashCode()) * 31) + this.showArgs.hashCode();
        }

        @NotNull
        public String toString() {
            return "CommentPanelShowProxyArgs(speakType=" + this.speakType + ", args=" + this.args + ", showArgs=" + this.showArgs + ")";
        }
    }

    public /* synthetic */ GuildFeedGalleryMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    GuildFeedGalleryMessage() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\b\u0010#\u001a\u00020\bH\u0016R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;", "Ljava/io/Serializable;", "initBean", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "reopen", "", "autoShowInputDialog", "needInsertCommentID", "", "needInsertCommentIDS", "", "showInputOnly", "(Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;ZZLjava/lang/String;Ljava/util/List;Z)V", "getAutoShowInputDialog", "()Z", "getInitBean", "()Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "getNeedInsertCommentID", "()Ljava/lang/String;", "getNeedInsertCommentIDS", "()Ljava/util/List;", "getReopen", "getShowInputOnly", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentPanelShowArgs implements Serializable {
        private final boolean autoShowInputDialog;

        @NotNull
        private final GuildGalleryCommentPanelParams initBean;

        @NotNull
        private final String needInsertCommentID;

        @NotNull
        private final List<String> needInsertCommentIDS;
        private final boolean reopen;
        private final boolean showInputOnly;

        public CommentPanelShowArgs(@NotNull GuildGalleryCommentPanelParams initBean, boolean z16, boolean z17, @NotNull String needInsertCommentID, @NotNull List<String> needInsertCommentIDS, boolean z18) {
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            Intrinsics.checkNotNullParameter(needInsertCommentID, "needInsertCommentID");
            Intrinsics.checkNotNullParameter(needInsertCommentIDS, "needInsertCommentIDS");
            this.initBean = initBean;
            this.reopen = z16;
            this.autoShowInputDialog = z17;
            this.needInsertCommentID = needInsertCommentID;
            this.needInsertCommentIDS = needInsertCommentIDS;
            this.showInputOnly = z18;
        }

        public static /* synthetic */ CommentPanelShowArgs copy$default(CommentPanelShowArgs commentPanelShowArgs, GuildGalleryCommentPanelParams guildGalleryCommentPanelParams, boolean z16, boolean z17, String str, List list, boolean z18, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                guildGalleryCommentPanelParams = commentPanelShowArgs.initBean;
            }
            if ((i3 & 2) != 0) {
                z16 = commentPanelShowArgs.reopen;
            }
            boolean z19 = z16;
            if ((i3 & 4) != 0) {
                z17 = commentPanelShowArgs.autoShowInputDialog;
            }
            boolean z26 = z17;
            if ((i3 & 8) != 0) {
                str = commentPanelShowArgs.needInsertCommentID;
            }
            String str2 = str;
            if ((i3 & 16) != 0) {
                list = commentPanelShowArgs.needInsertCommentIDS;
            }
            List list2 = list;
            if ((i3 & 32) != 0) {
                z18 = commentPanelShowArgs.showInputOnly;
            }
            return commentPanelShowArgs.copy(guildGalleryCommentPanelParams, z19, z26, str2, list2, z18);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final GuildGalleryCommentPanelParams getInitBean() {
            return this.initBean;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getReopen() {
            return this.reopen;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAutoShowInputDialog() {
            return this.autoShowInputDialog;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getNeedInsertCommentID() {
            return this.needInsertCommentID;
        }

        @NotNull
        public final List<String> component5() {
            return this.needInsertCommentIDS;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getShowInputOnly() {
            return this.showInputOnly;
        }

        @NotNull
        public final CommentPanelShowArgs copy(@NotNull GuildGalleryCommentPanelParams initBean, boolean reopen, boolean autoShowInputDialog, @NotNull String needInsertCommentID, @NotNull List<String> needInsertCommentIDS, boolean showInputOnly) {
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            Intrinsics.checkNotNullParameter(needInsertCommentID, "needInsertCommentID");
            Intrinsics.checkNotNullParameter(needInsertCommentIDS, "needInsertCommentIDS");
            return new CommentPanelShowArgs(initBean, reopen, autoShowInputDialog, needInsertCommentID, needInsertCommentIDS, showInputOnly);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentPanelShowArgs)) {
                return false;
            }
            CommentPanelShowArgs commentPanelShowArgs = (CommentPanelShowArgs) other;
            if (Intrinsics.areEqual(this.initBean, commentPanelShowArgs.initBean) && this.reopen == commentPanelShowArgs.reopen && this.autoShowInputDialog == commentPanelShowArgs.autoShowInputDialog && Intrinsics.areEqual(this.needInsertCommentID, commentPanelShowArgs.needInsertCommentID) && Intrinsics.areEqual(this.needInsertCommentIDS, commentPanelShowArgs.needInsertCommentIDS) && this.showInputOnly == commentPanelShowArgs.showInputOnly) {
                return true;
            }
            return false;
        }

        public final boolean getAutoShowInputDialog() {
            return this.autoShowInputDialog;
        }

        @NotNull
        public final GuildGalleryCommentPanelParams getInitBean() {
            return this.initBean;
        }

        @NotNull
        public final String getNeedInsertCommentID() {
            return this.needInsertCommentID;
        }

        @NotNull
        public final List<String> getNeedInsertCommentIDS() {
            return this.needInsertCommentIDS;
        }

        public final boolean getReopen() {
            return this.reopen;
        }

        public final boolean getShowInputOnly() {
            return this.showInputOnly;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.initBean.hashCode() * 31;
            boolean z16 = this.reopen;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.autoShowInputDialog;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int hashCode2 = (((((i17 + i18) * 31) + this.needInsertCommentID.hashCode()) * 31) + this.needInsertCommentIDS.hashCode()) * 31;
            boolean z18 = this.showInputOnly;
            if (!z18) {
                i3 = z18 ? 1 : 0;
            }
            return hashCode2 + i3;
        }

        @NotNull
        public String toString() {
            return "feedId:" + this.initBean.getFeedId() + ", guildId:" + this.initBean.getGuildId() + " channelId:" + this.initBean.getChannelId() + ", reopen:" + this.reopen + ", autoShowInputDialog:" + this.autoShowInputDialog + ", needInsertCommentID:" + this.needInsertCommentID + ", needInsertCommentIDS:" + this.needInsertCommentIDS;
        }

        public /* synthetic */ CommentPanelShowArgs(GuildGalleryCommentPanelParams guildGalleryCommentPanelParams, boolean z16, boolean z17, String str, List list, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(guildGalleryCommentPanelParams, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 32) == 0 ? z18 : false);
        }
    }
}
