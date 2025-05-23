package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedResult;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$CommentAndReplyRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import u72.SignalEntryInfo;
import u72.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007\u00a2\u0006\u0004\bP\u0010QJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J.\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0010J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J)\u0010 \u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001eJ\b\u0010'\u001a\u00020\u0006H\u0014R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001d\u00106\u001a\b\u0012\u0004\u0012\u0002030,8\u0006\u00a2\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00101R#\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0,8\u0006\u00a2\u0006\f\n\u0004\b7\u0010/\u001a\u0004\b8\u00101R(\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010/\u001a\u0004\b;\u00101\"\u0004\b<\u0010=R.\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010/\u001a\u0004\bB\u00101\"\u0004\bC\u0010=R)\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040E0,8\u0006\u00a2\u0006\f\n\u0004\bF\u0010/\u001a\u0004\bG\u00101R#\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0,8\u0006\u00a2\u0006\f\n\u0004\bI\u0010/\u001a\u0004\bJ\u00101R\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/viewmodel/QQStrangerSquareViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feed", "", "operationType", "", "R1", "N1", SemanticAttributes.DbSystemValues.H2, "", "Z1", "e2", "d2", "c2", "i2", "", "content", "P1", "openId", "feedId", WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID, "Q1", "O1", "index", "M1", "g2", "k2", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "", "isLike", "l2", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "commentCount", "j2", "(Ljava/lang/String;Ljava/lang/Integer;)V", "loadCacheFirst", "f2", "onCleared", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository;", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository;", "feedRepository", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "X1", "()Landroidx/lifecycle/MutableLiveData;", "loadFeedListLiveData", "Lu72/c;", BdhLogUtil.LogTag.Tag_Conn, "b2", "updateSignalLiveData", "D", ICustomDataEditor.STRING_ARRAY_PARAM_2, "updateFeedListLiveData", "E", "S1", "setBigPicFeedCommentCnt", "(Landroidx/lifecycle/MutableLiveData;)V", "bigPicFeedCommentCnt", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository$b;", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$CommentAndReplyRsp;", UserInfo.SEX_FEMALE, "T1", "setBigPicFeedCommentRespData", "bigPicFeedCommentRespData", "Lkotlin/Pair;", "G", "W1", "deleteFeedResultLiveData", "H", "U1", "commentReplyResultLiveData", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "I", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "onSignalInfoUpdateListener", "<init>", "()V", "J", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSquareViewModel extends ViewModel {

    /* renamed from: I, reason: from kotlin metadata */
    private a onSignalInfoUpdateListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerFeedRepository feedRepository = new QQStrangerFeedRepository();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<QQStrangerFeedResult> loadFeedListLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<SignalEntryInfo> updateSignalLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<List<FeedPB$Feed>> updateFeedListLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<Integer> bigPicFeedCommentCnt = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private MutableLiveData<QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp>> bigPicFeedCommentRespData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Pair<String, Integer>> deleteFeedResultLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp>> commentReplyResultLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/framework/viewmodel/QQStrangerSquareViewModel$b", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "signalInfo", "", "justNowPublish", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.a
        public void a(SignalPlazaSvrPB$SignalInfo signalInfo, boolean justNowPublish) {
            SignalEntryInfo signalEntryInfo;
            QLog.i("QQStrangerSquareViewModel", 1, "onSelfSignalInfoUpdate justNowPublish=" + justNowPublish);
            MutableLiveData<SignalEntryInfo> b26 = QQStrangerSquareViewModel.this.b2();
            if (signalInfo != null && (signalEntryInfo = d.a(signalInfo)) != null) {
                signalEntryInfo.a(justNowPublish);
            } else {
                signalEntryInfo = new SignalEntryInfo(0L, null, 0L, false, 15, null);
            }
            b26.postValue(signalEntryInfo);
        }
    }

    private final void N1() {
        if (this.onSignalInfoUpdateListener == null) {
            b bVar = new b();
            this.onSignalInfoUpdateListener = bVar;
            com.tencent.mobileqq.matchfriend.reborn.content.signal.b bVar2 = com.tencent.mobileqq.matchfriend.reborn.content.signal.b.f244871a;
            Intrinsics.checkNotNull(bVar);
            bVar2.a(bVar);
        }
    }

    private final void R1(FeedPB$Feed feed, int operationType) {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$doLikeFeed$1(this, feed, operationType, null), 12, null);
    }

    private final void h2() {
        a aVar = this.onSignalInfoUpdateListener;
        if (aVar != null) {
            com.tencent.mobileqq.matchfriend.reborn.content.signal.b.f244871a.f(aVar);
            this.onSignalInfoUpdateListener = null;
        }
    }

    public final void M1(int index, FeedPB$Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$addFeed$1(this, index, feed, null), 12, null);
    }

    public final void O1(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$deleteFeed$1(this, feedId, null), 12, null);
    }

    public final void P1(FeedPB$Feed feed, String content) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(content, "content");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$doComment$1(this, feed, content, null), 12, null);
    }

    public final void Q1(String openId, String feedId, String commentId, String replyId, String content) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        Intrinsics.checkNotNullParameter(content, "content");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$doCommentReply$1(this, openId, feedId, commentId, replyId, content, null), 12, null);
    }

    public final MutableLiveData<Integer> S1() {
        return this.bigPicFeedCommentCnt;
    }

    public final MutableLiveData<QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp>> T1() {
        return this.bigPicFeedCommentRespData;
    }

    public final MutableLiveData<QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp>> U1() {
        return this.commentReplyResultLiveData;
    }

    public final MutableLiveData<Pair<String, Integer>> W1() {
        return this.deleteFeedResultLiveData;
    }

    public final MutableLiveData<QQStrangerFeedResult> X1() {
        return this.loadFeedListLiveData;
    }

    public final List<FeedPB$Feed> Z1() {
        return this.feedRepository.r();
    }

    public final MutableLiveData<List<FeedPB$Feed>> a2() {
        return this.updateFeedListLiveData;
    }

    public final MutableLiveData<SignalEntryInfo> b2() {
        return this.updateSignalLiveData;
    }

    public final void c2(FeedPB$Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        R1(feed, 1);
    }

    public final void d2() {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$loadMoreFeeds$1(this, null), 12, null);
    }

    public final void e2() {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$refreshFeeds$1(this, null), 12, null);
    }

    public final void f2(boolean loadCacheFirst) {
        N1();
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$refreshSignalInfo$1(loadCacheFirst, null), 12, null);
    }

    public final void g2(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$removeFeed$1(this, feedId, null), 12, null);
    }

    public final void i2(FeedPB$Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        R1(feed, 0);
    }

    public final void j2(String feedId, Integer commentCount) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$updateCommentInfo$1(this, feedId, commentCount, null), 12, null);
    }

    public final void k2(FeedPB$Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$updateFeed$1(this, feed, null), 12, null);
    }

    public final void l2(String feedId, Integer likeCount, Boolean isLike) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSquareViewModel$updateLikeInfo$1(this, feedId, likeCount, isLike, null), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QLog.d("QQStrangerSquareViewModel", 1, "onCleared");
        h2();
    }
}
