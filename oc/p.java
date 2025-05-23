package oc;

import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.util.ToastUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddReplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteReplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetCommentListCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAAddCommentReq;
import com.tencent.qqnt.kernel.nativeinterface.PAAddCommentRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAAddReplyReq;
import com.tencent.qqnt.kernel.nativeinterface.PAAddReplyRsp;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteCommentReq;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteCommentRsp;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteReplyReq;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteReplyRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAGetCommentListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetCommentListRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.qqnt.kernel.nativeinterface.StRichMsg;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0014J6\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0014J&\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J.\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\"\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u001fH\u0014R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u000209088\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Loc/p;", "Lcom/qzone/reborn/albumx/common/viewmodel/CommonCommentBusinessViewModel;", "Lcom/qzone/reborn/albumx/common/bean/d;", "feed", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "fakeComment", "", "g3", ICustomDataEditor.STRING_ARRAY_PARAM_3, "", "getLogTag", "", "action", "commentCount", "y2", "operationType", "comment", "E2", "type", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "targetReply", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedBusiness", "V2", "actionType", "businessFeedData", "d3", "id", "aInfo", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "C2", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "G", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "getMLayerExtraInfoBean", "()Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", ICustomDataEditor.NUMBER_PARAM_3, "(Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;)V", "mLayerExtraInfoBean", "H", "Ljava/lang/String;", "getSourceFeedId", "()Ljava/lang/String;", "o3", "(Ljava/lang/String;)V", "sourceFeedId", "I", "Z", "getFromFeedDetail", "()Z", "m3", "(Z)V", "fromFeedDetail", "Landroidx/lifecycle/MutableLiveData;", "Lbb/c;", "J", "Landroidx/lifecycle/MutableLiveData;", "j3", "()Landroidx/lifecycle/MutableLiveData;", "commentNumberLiveData", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class p extends CommonCommentBusinessViewModel {

    /* renamed from: G, reason: from kotlin metadata */
    private QZAlbumxLayerExtraInfoBean mLayerExtraInfoBean;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean fromFeedDetail;

    /* renamed from: H, reason: from kotlin metadata */
    private String sourceFeedId = "";

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<bb.c> commentNumberLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(long j3, final Reply reply, final p this$0, final com.qzone.reborn.albumx.common.bean.d feed, final Comment comment, final PAAddReplyRsp pAAddReplyRsp) {
        Intrinsics.checkNotNullParameter(reply, "$reply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        mc.c.f416541a.e("addReply", System.currentTimeMillis() - j3, pAAddReplyRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: oc.n
            @Override // java.lang.Runnable
            public final void run() {
                p.Y2(PAAddReplyRsp.this, reply, this$0, feed, comment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(PAAddReplyRsp pAAddReplyRsp, Reply reply, p this$0, com.qzone.reborn.albumx.common.bean.d feed, Comment comment) {
        Intrinsics.checkNotNullParameter(reply, "$reply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        if (pAAddReplyRsp.result == 0) {
            reply.replyId = pAAddReplyRsp.replyId;
            this$0.t2(1, feed, comment, reply, reply);
            return;
        }
        QLog.d("QZAlbumxLayerCommentViewModel", 1, "addReply fail, trace_id:" + pAAddReplyRsp.traceId + " error:" + pAAddReplyRsp.errMs);
        if (pAAddReplyRsp.result == 10014) {
            ToastUtil.s("\u8bc4\u8bba\u5df2\u8fc7\u671f, \u65e0\u6cd5\u4e92\u52a8", 4);
        } else {
            ToastUtil.s("\u5220\u9664\u56de\u590d\u5931\u8d25", 4);
        }
        this$0.q2(1, feed, comment, reply);
    }

    private final void a3(final com.qzone.reborn.albumx.common.bean.d feed, final Comment fakeComment) {
        PADeleteCommentReq pADeleteCommentReq = new PADeleteCommentReq();
        pADeleteCommentReq.albumId = feed.getAlbumId();
        pADeleteCommentReq.mediaId = feed.getLlocId();
        pADeleteCommentReq.commentId = fakeComment.commentid;
        pADeleteCommentReq.commentType = 1;
        pADeleteCommentReq.albumOwner.uin = feed.getUin();
        z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.deleteComment(pADeleteCommentReq, new IPersonalAlbumServiceDeleteCommentCallback() { // from class: oc.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteCommentCallback
                public final void onDeleteComment(PADeleteCommentRsp pADeleteCommentRsp) {
                    p.b3(p.this, feed, fakeComment, pADeleteCommentRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b3(final p this$0, final com.qzone.reborn.albumx.common.bean.d feed, final Comment fakeComment, final PADeleteCommentRsp pADeleteCommentRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(fakeComment, "$fakeComment");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: oc.k
            @Override // java.lang.Runnable
            public final void run() {
                p.c3(PADeleteCommentRsp.this, this$0, feed, fakeComment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(PADeleteCommentRsp pADeleteCommentRsp, p this$0, com.qzone.reborn.albumx.common.bean.d feed, Comment fakeComment) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(fakeComment, "$fakeComment");
        if (pADeleteCommentRsp.result == 0) {
            this$0.r2(0, feed, fakeComment, fakeComment);
            return;
        }
        QLog.d("QZAlbumxLayerCommentViewModel", 1, "deleteComment fail, trace_id:" + pADeleteCommentRsp.traceId + " error:" + pADeleteCommentRsp.errMs);
        this$0.p2(0, feed, fakeComment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(final p this$0, final int i3, final com.qzone.reborn.albumx.common.bean.d feed, final Comment comment, final Reply reply, final PADeleteReplyRsp pADeleteReplyRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        Intrinsics.checkNotNullParameter(reply, "$reply");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: oc.m
            @Override // java.lang.Runnable
            public final void run() {
                p.f3(PADeleteReplyRsp.this, this$0, i3, feed, comment, reply);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(PADeleteReplyRsp pADeleteReplyRsp, p this$0, int i3, com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        Intrinsics.checkNotNullParameter(reply, "$reply");
        if (pADeleteReplyRsp.result == 0) {
            this$0.t2(i3, feed, comment, reply, reply);
            return;
        }
        QLog.d("QZAlbumxLayerCommentViewModel", 1, "deleteReply fail, trace_id:" + pADeleteReplyRsp.traceId + " error:" + pADeleteReplyRsp.errMs);
        com.qzone.reborn.util.o.f59556a.b(pADeleteReplyRsp.errMs);
    }

    private final void g3(final com.qzone.reborn.albumx.common.bean.d feed, final Comment fakeComment) {
        PAAddCommentReq pAAddCommentReq = new PAAddCommentReq();
        pAAddCommentReq.albumId = feed.getAlbumId();
        pAAddCommentReq.mediaId = feed.getLlocId();
        ArrayList<StRichMsg> arrayList = pAAddCommentReq.content;
        String str = fakeComment.comment;
        Intrinsics.checkNotNullExpressionValue(str, "fakeComment.comment");
        arrayList.addAll(xh.d.f(str));
        pAAddCommentReq.commentType = 1;
        pAAddCommentReq.albumOwner.uin = feed.getUin();
        z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        final long currentTimeMillis = System.currentTimeMillis();
        if (b16 != null) {
            b16.addComment(pAAddCommentReq, new IPersonalAlbumServiceAddCommentCallback() { // from class: oc.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddCommentCallback
                public final void onAddComment(PAAddCommentRsp pAAddCommentRsp) {
                    p.h3(currentTimeMillis, fakeComment, this, feed, pAAddCommentRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(long j3, final Comment fakeComment, final p this$0, final com.qzone.reborn.albumx.common.bean.d feed, final PAAddCommentRsp pAAddCommentRsp) {
        Intrinsics.checkNotNullParameter(fakeComment, "$fakeComment");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        mc.c.f416541a.e("addComment", System.currentTimeMillis() - j3, pAAddCommentRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: oc.l
            @Override // java.lang.Runnable
            public final void run() {
                p.i3(PAAddCommentRsp.this, fakeComment, this$0, feed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i3(PAAddCommentRsp pAAddCommentRsp, Comment fakeComment, p this$0, com.qzone.reborn.albumx.common.bean.d feed) {
        Intrinsics.checkNotNullParameter(fakeComment, "$fakeComment");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        if (pAAddCommentRsp.result == 0) {
            fakeComment.commentid = pAAddCommentRsp.commentId;
            this$0.r2(1, feed, fakeComment, fakeComment);
            return;
        }
        QLog.d("QZAlbumxLayerCommentViewModel", 1, "addComment fail, trace_id:" + pAAddCommentRsp.traceId + " error:" + pAAddCommentRsp.errMs);
        this$0.p2(1, feed, fakeComment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k3(long j3, final p this$0, final boolean z16, final String id5, final PAGetCommentListRsp pAGetCommentListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id5, "$id");
        mc.c.f416541a.e("getCommentList", System.currentTimeMillis() - j3, pAGetCommentListRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: oc.o
            @Override // java.lang.Runnable
            public final void run() {
                p.l3(p.this, pAGetCommentListRsp, z16, id5);
            }
        });
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel
    protected void C2(final String id5, String aInfo, final boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(id5, "id");
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        final long currentTimeMillis = System.currentTimeMillis();
        requestTimelineInfo.requestInvokeTime = currentTimeMillis;
        PAGetCommentListReq pAGetCommentListReq = new PAGetCommentListReq();
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = this.mLayerExtraInfoBean;
        pAGetCommentListReq.albumId = qZAlbumxLayerExtraInfoBean != null ? qZAlbumxLayerExtraInfoBean.getAlbumId() : null;
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean2 = this.mLayerExtraInfoBean;
        pAGetCommentListReq.batchId = qZAlbumxLayerExtraInfoBean2 != null ? qZAlbumxLayerExtraInfoBean2.getBatchId() : null;
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean3 = this.mLayerExtraInfoBean;
        pAGetCommentListReq.lloc = qZAlbumxLayerExtraInfoBean3 != null ? qZAlbumxLayerExtraInfoBean3.getLLoc() : null;
        if (isLoadMore) {
            pAGetCommentListReq.attachInfo = aInfo;
        }
        StUser stUser = pAGetCommentListReq.owner;
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean4 = this.mLayerExtraInfoBean;
        stUser.uin = qZAlbumxLayerExtraInfoBean4 != null ? qZAlbumxLayerExtraInfoBean4.getUin() : null;
        z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.getCommentList(pAGetCommentListReq, new IPersonalAlbumServiceGetCommentListCallback() { // from class: oc.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetCommentListCallback
                public final void onGetCommentList(PAGetCommentListRsp pAGetCommentListRsp) {
                    p.k3(currentTimeMillis, this, isLoadMore, id5, pAGetCommentListRsp);
                }
            });
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel
    protected void D2(int type, com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply, Reply targetReply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        BusinessFeedData a16 = di.a.a(feed);
        if (type == 1) {
            Intrinsics.checkNotNull(comment);
            Intrinsics.checkNotNull(reply);
            V2(feed, a16, comment, reply);
        }
        if (type == 0 || type == 2) {
            Intrinsics.checkNotNull(comment);
            Intrinsics.checkNotNull(reply);
            d3(type, feed, a16, comment, reply);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel
    public void E2(int operationType, com.qzone.reborn.albumx.common.bean.d feed, Comment comment) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(comment, "comment");
        if (operationType == 0) {
            a3(feed, comment);
        } else {
            if (operationType != 1) {
                return;
            }
            g3(feed, comment);
        }
    }

    public final void V2(final com.qzone.reborn.albumx.common.bean.d feed, BusinessFeedData feedBusiness, final Comment comment, final Reply reply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(feedBusiness, "feedBusiness");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        PAAddReplyReq pAAddReplyReq = new PAAddReplyReq();
        pAAddReplyReq.albumId = feed.getAlbumId();
        pAAddReplyReq.mediaId = feed.getLlocId();
        ArrayList<StRichMsg> arrayList = pAAddReplyReq.content;
        String str = reply.content;
        Intrinsics.checkNotNullExpressionValue(str, "reply.content");
        arrayList.addAll(xh.d.f(str));
        pAAddReplyReq.commentType = 1;
        pAAddReplyReq.albumOwner.uin = feed.getUin();
        pAAddReplyReq.commentId = comment.commentid;
        z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        final long currentTimeMillis = System.currentTimeMillis();
        if (b16 != null) {
            b16.addReply(pAAddReplyReq, new IPersonalAlbumServiceAddReplyCallback() { // from class: oc.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddReplyCallback
                public final void onAddReply(PAAddReplyRsp pAAddReplyRsp) {
                    p.W2(currentTimeMillis, reply, this, feed, comment, pAAddReplyRsp);
                }
            });
        }
    }

    public final void d3(final int actionType, final com.qzone.reborn.albumx.common.bean.d feed, BusinessFeedData businessFeedData, final Comment comment, final Reply reply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        PADeleteReplyReq pADeleteReplyReq = new PADeleteReplyReq();
        pADeleteReplyReq.albumId = feed.getAlbumId();
        pADeleteReplyReq.mediaId = feed.getLlocId();
        pADeleteReplyReq.replyId = reply.replyId;
        pADeleteReplyReq.commentType = 1;
        pADeleteReplyReq.albumOwner.uin = feed.getUin();
        pADeleteReplyReq.commentId = comment.commentid;
        z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.deleteReply(pADeleteReplyReq, new IPersonalAlbumServiceDeleteReplyCallback() { // from class: oc.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteReplyCallback
                public final void onDeleteReply(PADeleteReplyRsp pADeleteReplyRsp) {
                    p.e3(p.this, actionType, feed, comment, reply, pADeleteReplyRsp);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxLayerCommentViewModel";
    }

    public final MutableLiveData<bb.c> j3() {
        return this.commentNumberLiveData;
    }

    public final void m3(boolean z16) {
        this.fromFeedDetail = z16;
    }

    public final void n3(QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean) {
        this.mLayerExtraInfoBean = qZAlbumxLayerExtraInfoBean;
    }

    public final void o3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceFeedId = str;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel
    public void y2(int action, com.qzone.reborn.albumx.common.bean.d feed, int commentCount) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        bb.c cVar = new bb.c(action);
        cVar.h(feed.getGroupId());
        cVar.g(feed.getLlocId());
        cVar.d(commentCount);
        this.commentNumberLiveData.postValue(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l3(p this$0, PAGetCommentListRsp pAGetCommentListRsp, boolean z16, String id5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id5, "$id");
        String tag = this$0.getTAG();
        int i3 = pAGetCommentListRsp.seq;
        int i16 = pAGetCommentListRsp.result;
        String str = pAGetCommentListRsp.errMs;
        String str2 = pAGetCommentListRsp.attachInfo;
        boolean z17 = pAGetCommentListRsp.hasMore;
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = this$0.mLayerExtraInfoBean;
        String lLoc = qZAlbumxLayerExtraInfoBean != null ? qZAlbumxLayerExtraInfoBean.getLLoc() : null;
        QLog.e(tag, 1, "sendCommentListRequest seq: " + i3 + " | resultCode: " + i16 + " | errMsg:" + str + " | nextAttachInfo:" + str2 + " | hasMore:" + z17 + " | isLoadMore:" + z16 + " | lloc id" + lLoc + " | traceId " + pAGetCommentListRsp.traceId);
        CellCommentInfo v3 = yh.b.v(pAGetCommentListRsp.comment, null);
        int i17 = pAGetCommentListRsp.result;
        String str3 = pAGetCommentListRsp.errMs;
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean2 = this$0.mLayerExtraInfoBean;
        String albumId = qZAlbumxLayerExtraInfoBean2 != null ? qZAlbumxLayerExtraInfoBean2.getAlbumId() : null;
        Intrinsics.checkNotNull(albumId);
        int i18 = pAGetCommentListRsp.comment.num;
        ArrayList<Comment> arrayList = v3.commments;
        boolean z18 = pAGetCommentListRsp.hasMore;
        String str4 = pAGetCommentListRsp.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str4, "response.attachInfo");
        this$0.l2(i17, str3, albumId, id5, i18, arrayList, z18, z16, str4);
    }
}
