package com.tencent.biz.qqcircle.immersive.part.commentimage;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.utils.ct;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u0000 A2\u00020\u0001:\u0001\rBE\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010$\u001a\u0004\u0018\u00010 \u0012\u0006\u0010)\u001a\u00020\u000b\u0012\u0006\u0010,\u001a\u00020\u000b\u0012\b\b\u0002\u0010.\u001a\u00020\u000b\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010$\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010)\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010,\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u0017\u0010.\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(R\u001b\u00101\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010\u0010R\u0011\u00103\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b2\u0010\u0010R\u0011\u00104\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010(R\u0011\u00105\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010(R\u0013\u00109\u001a\u0004\u0018\u0001068F\u00a2\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u0010=\u001a\u00020:8F\u00a2\u0006\u0006\u001a\u0004\b;\u0010<R\u0011\u0010?\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b>\u0010\u0010R\u0011\u0010@\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u0010R\u0011\u0010B\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bA\u0010\u0010R\u0011\u0010D\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bC\u0010\u0010R\u0011\u0010G\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0011\u0010I\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010FR\u0011\u0010K\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010(\u00a8\u0006N"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "", "", "text", "v", "", "d", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "feedId", "Lfeedcloud/FeedCloudMeta$StComment;", "b", "Lfeedcloud/FeedCloudMeta$StComment;", "r", "()Lfeedcloud/FeedCloudMeta$StComment;", "w", "(Lfeedcloud/FeedCloudMeta$StComment;)V", "stComment", "Lfeedcloud/FeedCloudMeta$StReply;", "c", "Lfeedcloud/FeedCloudMeta$StReply;", "t", "()Lfeedcloud/FeedCloudMeta$StReply;", "stReply", "Lfeedcloud/FeedCloudMeta$StImage;", "Lfeedcloud/FeedCloudMeta$StImage;", ReportConstant.COSTREPORT_PREFIX, "()Lfeedcloud/FeedCloudMeta$StImage;", "stImage", "e", "Z", "getHaveSaveOperate", "()Z", "haveSaveOperate", "f", "getHaveEmojiOperate", "haveEmojiOperate", "g", "isEmojiImage", tl.h.F, "Lkotlin/Lazy;", "content", "l", "id", "canSave", "canEmoji", "Lfeedcloud/FeedCloudMeta$StFeed;", "j", "()Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "Lfeedcloud/FeedCloudMeta$StUser;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lfeedcloud/FeedCloudMeta$StUser;", QAdVrReport.ElementID.AD_POSTER, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "inputHintText", "downloadUrl", "i", "emojiUrl", "p", "nickname", "o", "()I", "likeDrawableId", DomainData.DOMAIN_NAME, MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "u", "isMyLike", "<init>", "(Ljava/lang/String;Lfeedcloud/FeedCloudMeta$StComment;Lfeedcloud/FeedCloudMeta$StReply;Lfeedcloud/FeedCloudMeta$StImage;ZZZ)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final /* data */ class QFSCommentImageInfo {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    private static final int f87856j = R.drawable.or5;

    /* renamed from: k, reason: collision with root package name */
    private static final int f87857k = R.drawable.qui_comment_like_unlike_icon_white;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private FeedCloudMeta$StComment stComment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FeedCloudMeta$StReply stReply;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FeedCloudMeta$StImage stImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean haveSaveOperate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean haveEmojiOperate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEmojiImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo$a;", "", "", "LIKE_DRAWABLE_ID", "I", "a", "()I", "UNLIKE_DRAWABLE_ID", "b", "", "HEAD_TAIL_SPACE_PATTEN", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageInfo$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QFSCommentImageInfo.f87856j;
        }

        public final int b() {
            return QFSCommentImageInfo.f87857k;
        }

        Companion() {
        }
    }

    public QFSCommentImageInfo(@NotNull String feedId, @NotNull FeedCloudMeta$StComment stComment, @Nullable FeedCloudMeta$StReply feedCloudMeta$StReply, @Nullable FeedCloudMeta$StImage feedCloudMeta$StImage, boolean z16, boolean z17, boolean z18) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(stComment, "stComment");
        this.feedId = feedId;
        this.stComment = stComment;
        this.stReply = feedCloudMeta$StReply;
        this.stImage = feedCloudMeta$StImage;
        this.haveSaveOperate = z16;
        this.haveEmojiOperate = z17;
        this.isEmojiImage = z18;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageInfo$content$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String rawContent;
                String v3;
                PBStringField pBStringField;
                FeedCloudMeta$StReply stReply = QFSCommentImageInfo.this.getStReply();
                if (stReply == null || (pBStringField = stReply.content) == null || (rawContent = pBStringField.get()) == null) {
                    rawContent = QFSCommentImageInfo.this.getStComment().content.get();
                }
                QFSCommentImageInfo qFSCommentImageInfo = QFSCommentImageInfo.this;
                Intrinsics.checkNotNullExpressionValue(rawContent, "rawContent");
                v3 = qFSCommentImageInfo.v(rawContent);
                return v3;
            }
        });
        this.content = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v(String text) {
        boolean contains$default;
        String replace$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) "\\", false, 2, (Object) null);
        if (contains$default) {
            replace$default = StringsKt__StringsJVMKt.replace$default(text, "^\\s+|\\s+$", "", false, 4, (Object) null);
            return replace$default;
        }
        return text;
    }

    public final void d() {
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.stReply;
        if (feedCloudMeta$StReply != null) {
            int i3 = feedCloudMeta$StReply.likeInfo.count.get();
            if (this.stReply.likeInfo.status.get() > 0) {
                this.stReply.likeInfo.status.set(0);
                this.stReply.likeInfo.count.set(i3 - 1);
                return;
            } else {
                this.stReply.likeInfo.status.set(1);
                this.stReply.likeInfo.count.set(i3 + 1);
                return;
            }
        }
        int i16 = this.stComment.likeInfo.count.get();
        if (this.stComment.likeInfo.status.get() > 0) {
            this.stComment.likeInfo.status.set(0);
            this.stComment.likeInfo.count.set(i16 - 1);
        } else {
            this.stComment.likeInfo.status.set(1);
            this.stComment.likeInfo.count.set(i16 + 1);
        }
    }

    public final boolean e() {
        String str;
        boolean isBlank;
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.stImage;
        if (feedCloudMeta$StImage == null || (str = ct.c(feedCloudMeta$StImage)) == null) {
            str = "";
        }
        if (this.haveEmojiOperate) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if ((!isBlank) && ud2.a.f438849a.a()) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSCommentImageInfo)) {
            return false;
        }
        QFSCommentImageInfo qFSCommentImageInfo = (QFSCommentImageInfo) other;
        if (Intrinsics.areEqual(this.feedId, qFSCommentImageInfo.feedId) && Intrinsics.areEqual(this.stComment, qFSCommentImageInfo.stComment) && Intrinsics.areEqual(this.stReply, qFSCommentImageInfo.stReply) && Intrinsics.areEqual(this.stImage, qFSCommentImageInfo.stImage) && this.haveSaveOperate == qFSCommentImageInfo.haveSaveOperate && this.haveEmojiOperate == qFSCommentImageInfo.haveEmojiOperate && this.isEmojiImage == qFSCommentImageInfo.isEmojiImage) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        boolean z16;
        if (!this.haveSaveOperate) {
            return false;
        }
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.stImage;
        if (feedCloudMeta$StImage != null) {
            z16 = ct.a(feedCloudMeta$StImage);
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String g() {
        return (String) this.content.getValue();
    }

    @NotNull
    public final String h() {
        String b16;
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.stImage;
        if (feedCloudMeta$StImage == null || (b16 = ct.b(feedCloudMeta$StImage)) == null) {
            return "";
        }
        return b16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.feedId.hashCode() * 31) + this.stComment.hashCode()) * 31;
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.stReply;
        int i3 = 0;
        if (feedCloudMeta$StReply == null) {
            hashCode = 0;
        } else {
            hashCode = feedCloudMeta$StReply.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.stImage;
        if (feedCloudMeta$StImage != null) {
            i3 = feedCloudMeta$StImage.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.haveSaveOperate;
        int i18 = 1;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (i17 + i19) * 31;
        boolean z17 = this.haveEmojiOperate;
        int i27 = z17;
        if (z17 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z18 = this.isEmojiImage;
        if (!z18) {
            i18 = z18 ? 1 : 0;
        }
        return i28 + i18;
    }

    @NotNull
    public final String i() {
        String c16;
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.stImage;
        if (feedCloudMeta$StImage == null || (c16 = ct.c(feedCloudMeta$StImage)) == null) {
            return "";
        }
        return c16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final FeedCloudMeta$StFeed j() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        e30.b bVar;
        MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, this.feedId);
        if (globalData != null && (bVar = (e30.b) globalData.getValue()) != null) {
            feedCloudMeta$StFeed = bVar.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSCommentImageInfo", 1, "no feed found");
        }
        return feedCloudMeta$StFeed;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final String l() {
        String str;
        PBStringField pBStringField;
        String str2 = this.feedId;
        String str3 = this.stComment.f398447id.get();
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.stReply;
        if (feedCloudMeta$StReply != null && (pBStringField = feedCloudMeta$StReply.f398460id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        return str2 + "-" + str3 + "-" + str;
    }

    @NotNull
    public final String m() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(p());
        if (!isBlank) {
            return "\u56de\u590d\u7ed9\uff1a" + p();
        }
        return "";
    }

    public final int n() {
        PBUInt32Field pBUInt32Field;
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.stReply;
        if (feedCloudMeta$StReply == null || (feedCloudMeta$StLike = feedCloudMeta$StReply.likeInfo) == null || (pBUInt32Field = feedCloudMeta$StLike.count) == null) {
            pBUInt32Field = this.stComment.likeInfo.count;
        }
        return pBUInt32Field.get();
    }

    public final int o() {
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.stReply;
        if (feedCloudMeta$StReply != null) {
            if (feedCloudMeta$StReply.likeInfo.status.get() == 1) {
                return f87856j;
            }
            return f87857k;
        }
        if (this.stComment.likeInfo.status.get() == 1) {
            return f87856j;
        }
        return f87857k;
    }

    @NotNull
    public final String p() {
        String str;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.stReply;
        if (feedCloudMeta$StReply != null && (feedCloudMeta$StUser = feedCloudMeta$StReply.postUser) != null && (pBStringField = feedCloudMeta$StUser.nick) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            String str2 = this.stComment.postUser.nick.get();
            Intrinsics.checkNotNullExpressionValue(str2, "stComment.postUser.nick.get()");
            return str2;
        }
        return str;
    }

    @NotNull
    public final FeedCloudMeta$StUser q() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StUser feedCloudMeta$StUser2;
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.stReply;
        if (feedCloudMeta$StReply != null && (feedCloudMeta$StUser2 = feedCloudMeta$StReply.postUser) != null) {
            feedCloudMeta$StUser = feedCloudMeta$StUser2.get();
        } else {
            feedCloudMeta$StUser = null;
        }
        if (feedCloudMeta$StUser == null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser3 = this.stComment.postUser.get();
            Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StUser3, "stComment.postUser.get()");
            return feedCloudMeta$StUser3;
        }
        return feedCloudMeta$StUser;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final FeedCloudMeta$StComment getStComment() {
        return this.stComment;
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final FeedCloudMeta$StImage getStImage() {
        return this.stImage;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final FeedCloudMeta$StReply getStReply() {
        return this.stReply;
    }

    @NotNull
    public String toString() {
        return "QFSCommentImageInfo(feedId=" + this.feedId + ", stComment=" + this.stComment + ", stReply=" + this.stReply + ", stImage=" + this.stImage + ", haveSaveOperate=" + this.haveSaveOperate + ", haveEmojiOperate=" + this.haveEmojiOperate + ", isEmojiImage=" + this.isEmojiImage + ")";
    }

    public final boolean u() {
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.stReply;
        if (feedCloudMeta$StReply != null) {
            if (feedCloudMeta$StReply.likeInfo.status.get() != 1) {
                return false;
            }
        } else if (this.stComment.likeInfo.status.get() != 1) {
            return false;
        }
        return true;
    }

    public final void w(@NotNull FeedCloudMeta$StComment feedCloudMeta$StComment) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StComment, "<set-?>");
        this.stComment = feedCloudMeta$StComment;
    }

    public /* synthetic */ QFSCommentImageInfo(String str, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StImage feedCloudMeta$StImage, boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, feedCloudMeta$StComment, feedCloudMeta$StReply, feedCloudMeta$StImage, z16, z17, (i3 & 64) != 0 ? false : z18);
    }
}
