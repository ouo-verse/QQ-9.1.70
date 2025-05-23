package com.tencent.biz.qqcircle.comment;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedAttrBean;
import com.tencent.biz.qqcircle.beans.QFSReplyExtraBean;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSInteractActionEvent;
import com.tencent.biz.qqcircle.events.QFSReplyListEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoCommentRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoReplyRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoStickyRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetCommentListRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetReplyListRequest;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.cg;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.global.QCircleUserLabelConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudRead$CmtShowConfig;
import feedcloud.FeedCloudRead$CommDialog;
import feedcloud.FeedCloudRead$StGetCommentListRsp;
import feedcloud.FeedCloudRead$StGetReplyListRsp;
import feedcloud.FeedCloudRead$UploadPhotoIcon;
import feedcloud.FeedCloudWrite$StDoCommentRsp;
import feedcloud.FeedCloudWrite$StDoReplyRsp;
import feedcloud.FeedCloudWrite$StDoTopRsp;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h implements IQCircleReportSessionOperation {
    private static volatile h Q;
    private boolean I;
    private ByteStringMicro J;
    private FeedCloudRead$CommDialog K;
    private boolean L;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, ArrayList<FeedCloudMeta$StComment>> f83656d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, HashMap<String, String>> f83657e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, ArrayList<String>> f83658f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Integer> f83659h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Boolean> f83660i = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, List<String>> f83661m = new HashMap();
    private final List<String> C = new ArrayList();
    private final List<String> D = new ArrayList();
    private Map<String, String> E = new HashMap();
    private final Map<String, j> F = new HashMap();
    private final Map<String, FeedCloudRead$UploadPhotoIcon> G = new HashMap();
    private final QCircleReporterAgent H = QCircleReporterAgent.obtain(61);
    private int M = 0;
    private int N = 0;
    private int P = 0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetCommentListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83662a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f83663b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QCircleGetCommentListRequest f83664c;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, QCircleGetCommentListRequest qCircleGetCommentListRequest) {
            this.f83662a = feedCloudMeta$StFeed;
            this.f83663b = i3;
            this.f83664c = qCircleGetCommentListRequest;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetCommentListRsp feedCloudRead$StGetCommentListRsp) {
            QLog.d("QFSCommentBusiness", 1, "[getCommentsFromMessageList] -> onReceive: " + z16 + " | feedId:" + this.f83662a.f398449id.get() + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            h.this.N(this.f83663b, z16, j3, str, feedCloudRead$StGetCommentListRsp, this.f83662a, false, true);
            h.this.P(z16, j3, str, this.f83664c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetReplyListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCircleGetReplyListRequest f83666a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f83667b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QFSReplyExtraBean f83668c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83669d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f83670e;

        b(QCircleGetReplyListRequest qCircleGetReplyListRequest, int i3, QFSReplyExtraBean qFSReplyExtraBean, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
            this.f83666a = qCircleGetReplyListRequest;
            this.f83667b = i3;
            this.f83668c = qFSReplyExtraBean;
            this.f83669d = feedCloudMeta$StFeed;
            this.f83670e = feedCloudMeta$StComment;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetReplyListRsp feedCloudRead$StGetReplyListRsp) {
            QLog.i("QFSCommentBusiness", 1, "[getReplyList]  onReceive | isSuccess = " + z16 + " | retCode =" + j3 + " | errMsg = " + str + " | cmdName = " + this.f83666a.getCmd() + " | traceId = " + this.f83666a.getTraceId());
            if (!z16 || j3 != 0 || feedCloudRead$StGetReplyListRsp == null) {
                h.this.e0(j3, str);
                QLog.e("QFSCommentBusiness", 1, "getReplyList error:" + j3 + "  errorMsg:" + str);
                SimpleEventBus.getInstance().dispatchEvent(new QFSReplyListEvent(this.f83667b, false, this.f83668c));
                return;
            }
            h.this.O(this.f83667b, this.f83669d, this.f83670e, feedCloudRead$StGetReplyListRsp, this.f83668c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetCommentListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83672a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f83673b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f83674c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QCircleGetCommentListRequest f83675d;

        c(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, boolean z16, QCircleGetCommentListRequest qCircleGetCommentListRequest) {
            this.f83672a = feedCloudMeta$StFeed;
            this.f83673b = i3;
            this.f83674c = z16;
            this.f83675d = qCircleGetCommentListRequest;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetCommentListRsp feedCloudRead$StGetCommentListRsp) {
            QLog.d("QFSCommentBusiness", 1, "QFSCommentBusiness->onReceive: " + z16 + " |feedId:" + this.f83672a.f398449id.get() + " |traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            h.this.M(this.f83673b, z16, j3, str, feedCloudRead$StGetCommentListRsp, this.f83672a, this.f83674c);
            h.this.P(z16, j3, str, this.f83675d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoCommentRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83677a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f83678b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f83679c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f83680d;

        d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3, boolean z16) {
            this.f83677a = feedCloudMeta$StFeed;
            this.f83678b = feedCloudMeta$StComment;
            this.f83679c = i3;
            this.f83680d = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoCommentRsp feedCloudWrite$StDoCommentRsp) {
            QLog.d("QFSCommentBusiness", 1, "[addFeedComment] -> onReceive: " + z16 + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            QFSCommentHelper.L().s0(QFSCommentPublishFeedAttrBean.COMMENT_PIC_PUBLISH_TYPE);
            if (z16 && j3 == 0 && feedCloudWrite$StDoCommentRsp != null) {
                com.tencent.biz.qqcircle.helpers.l.e().a(this.f83678b, this.f83677a);
                QLog.d("QFSCommentBusiness", 1, "addFeedComment Success, comment id: " + feedCloudWrite$StDoCommentRsp.comment.f398447id.get());
                String str2 = this.f83678b.f398447id.get();
                this.f83678b.f398447id.set(feedCloudWrite$StDoCommentRsp.comment.f398447id.get());
                this.f83678b.createTime.set(feedCloudWrite$StDoCommentRsp.comment.createTime.get());
                this.f83678b.likeInfo.set(feedCloudWrite$StDoCommentRsp.comment.likeInfo.get());
                this.f83678b.commentPic.set(feedCloudWrite$StDoCommentRsp.comment.commentPic.get());
                this.f83678b.show_submit_ran_comment_btn.set(feedCloudWrite$StDoCommentRsp.comment.show_submit_ran_comment_btn.get());
                if (feedCloudWrite$StDoCommentRsp.comment.goodsInfo.has()) {
                    this.f83678b.goodsInfo.set(feedCloudWrite$StDoCommentRsp.comment.goodsInfo.get());
                }
                feedCloudWrite$StDoCommentRsp.comment.set(this.f83678b);
                h.this.k0(this.f83677a.f398449id.get(), h.this.I(this.f83677a) + 1);
                h.this.n(this.f83677a.f398449id.get(), this.f83678b);
                QCircleCommentUpdateEvent qCircleCommentUpdateEvent = new QCircleCommentUpdateEvent(3, this.f83677a.f398449id.get(), this.f83678b, h.this.I(this.f83677a), this.f83679c);
                qCircleCommentUpdateEvent.fakeCommentId = str2;
                qCircleCommentUpdateEvent.isFeedOwner = QCirclePluginUtil.isFeedOwner(this.f83677a);
                SimpleEventBus.getInstance().dispatchEvent(qCircleCommentUpdateEvent);
                SimpleEventBus.getInstance().dispatchEvent(new QFSInteractActionEvent(this.f83677a.f398449id.get(), 2));
                h hVar = h.this;
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f83677a;
                hVar.W(feedCloudMeta$StFeed, hVar.I(feedCloudMeta$StFeed));
                if (this.f83680d) {
                    h.this.d0(this.f83678b.commentFeed.has());
                    if (this.f83678b.commentFeed.has()) {
                        af.m(this.f83677a.f398449id.get(), true, true, this.f83678b.f398447id.get());
                    }
                }
                h.this.Y(this.f83677a, feedCloudWrite$StDoCommentRsp.comment.f398447id.get());
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(9, this.f83677a.f398449id.get(), this.f83678b, (FeedCloudMeta$StReply) null, this.f83679c));
            com.tencent.biz.qqcircle.helpers.l.e().k(this.f83678b, this.f83677a);
            h.this.c0(j3, str, this.f83678b.commentFeed.has());
            if (this.f83678b.commentFeed.has()) {
                af.m(this.f83677a.f398449id.get(), false, true, this.f83678b.f398447id.get());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class e implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoCommentRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f83682a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83683b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f83684c;

        e(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
            this.f83682a = feedCloudMeta$StComment;
            this.f83683b = feedCloudMeta$StFeed;
            this.f83684c = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoCommentRsp feedCloudWrite$StDoCommentRsp) {
            QLog.d("QFSCommentBusiness", 1, "[deleteFeedComment] -> onReceive: " + z16 + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16 && j3 == 0 && feedCloudWrite$StDoCommentRsp != null) {
                com.tencent.biz.qqcircle.helpers.l.e().k(this.f83682a, this.f83683b);
                feedCloudWrite$StDoCommentRsp.comment.f398447id.set(this.f83682a.f398447id.get());
                h.this.k0(this.f83683b.f398449id.get(), (h.this.I(this.f83683b) - 1) - this.f83682a.vecReply.size());
                h.this.t(this.f83683b.f398449id.get(), this.f83682a.f398447id.get());
                SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(4, this.f83683b.f398449id.get(), this.f83682a, h.this.I(this.f83683b), this.f83684c));
                h hVar = h.this;
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f83683b;
                hVar.W(feedCloudMeta$StFeed, hVar.I(feedCloudMeta$StFeed));
                if (this.f83682a.typeFlag.get() == 1) {
                    h.this.o0(this.f83683b.f398449id.get(), "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoReplyRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83686a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f83687b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StReply f83688c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f83689d;

        f(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i3) {
            this.f83686a = feedCloudMeta$StFeed;
            this.f83687b = feedCloudMeta$StComment;
            this.f83688c = feedCloudMeta$StReply;
            this.f83689d = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoReplyRsp feedCloudWrite$StDoReplyRsp) {
            QLog.d("QFSCommentBusiness", 1, "[addCommentReply] -> onReceive: " + z16 + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16 && j3 == 0 && feedCloudWrite$StDoReplyRsp != null) {
                QLog.d("QFSCommentBusiness", 1, "addCommentReply Success, reply id: " + feedCloudWrite$StDoReplyRsp.reply.f398460id.get());
                String str2 = this.f83688c.f398460id.get();
                this.f83688c.f398460id.set(feedCloudWrite$StDoReplyRsp.reply.f398460id.get());
                this.f83688c.createTime.set(feedCloudWrite$StDoReplyRsp.reply.createTime.get());
                this.f83688c.likeInfo.set(feedCloudWrite$StDoReplyRsp.reply.likeInfo.get());
                this.f83688c.replyPic.set(feedCloudWrite$StDoReplyRsp.reply.replyPic.get());
                feedCloudWrite$StDoReplyRsp.reply.set(this.f83688c);
                h.this.k0(this.f83686a.f398449id.get(), h.this.I(this.f83686a) + 1);
                QCircleCommentUpdateEvent qCircleCommentUpdateEvent = new QCircleCommentUpdateEvent(5, this.f83686a.f398449id.get(), this.f83687b, this.f83688c, h.this.I(this.f83686a), this.f83689d);
                qCircleCommentUpdateEvent.fakeReplyId = str2;
                SimpleEventBus.getInstance().dispatchEvent(qCircleCommentUpdateEvent);
                SimpleEventBus.getInstance().dispatchEvent(new QFSInteractActionEvent(this.f83686a.f398449id.get(), 0));
                if (this.f83688c.replyFeed.has()) {
                    h.this.d0(false);
                    af.m(this.f83686a.f398449id.get(), true, false, this.f83688c.f398460id.get());
                }
                h.this.Y(this.f83686a, feedCloudWrite$StDoReplyRsp.reply.f398460id.get());
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(10, this.f83686a.f398449id.get(), this.f83687b, this.f83688c, this.f83689d));
            h.this.c0(j3, str, this.f83688c.replyFeed.has());
            if (this.f83688c.replyFeed.has()) {
                af.m(this.f83686a.f398449id.get(), false, false, this.f83688c.f398460id.get());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class g implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoReplyRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StReply f83691a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83692b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f83693c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f83694d;

        g(FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
            this.f83691a = feedCloudMeta$StReply;
            this.f83692b = feedCloudMeta$StFeed;
            this.f83693c = feedCloudMeta$StComment;
            this.f83694d = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoReplyRsp feedCloudWrite$StDoReplyRsp) {
            QLog.d("QFSCommentBusiness", 1, "[deleteCommentReply] -> onReceive: " + z16 + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16 && j3 == 0 && feedCloudWrite$StDoReplyRsp != null) {
                feedCloudWrite$StDoReplyRsp.reply.f398460id.set(this.f83691a.f398460id.get());
                h.this.k0(this.f83692b.f398449id.get(), h.this.I(this.f83692b) - 1);
                SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(6, this.f83692b.f398449id.get(), this.f83693c, this.f83691a, h.this.I(this.f83692b), this.f83694d));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.h$h, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0854h implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoTopRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83696a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f83697b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f83698c;

        C0854h(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
            this.f83696a = feedCloudMeta$StFeed;
            this.f83697b = feedCloudMeta$StComment;
            this.f83698c = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoTopRsp feedCloudWrite$StDoTopRsp) {
            QLog.d("QFSCommentBusiness", 1, "[stickyFeedComment] -> onReceive: " + z16 + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16 && j3 == 0 && feedCloudWrite$StDoTopRsp != null) {
                h.this.o0(this.f83696a.f398449id.get(), this.f83697b.f398447id.get());
                SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(7, this.f83696a.f398449id.get(), this.f83697b, h.this.I(this.f83696a), this.f83698c));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class i implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoTopRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f83700a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f83701b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f83702c;

        i(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
            this.f83700a = feedCloudMeta$StFeed;
            this.f83701b = feedCloudMeta$StComment;
            this.f83702c = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoTopRsp feedCloudWrite$StDoTopRsp) {
            QLog.d("QFSCommentBusiness", 1, "[cancelStickyFeedComment] -> onReceive: " + z16 + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16 && j3 == 0 && feedCloudWrite$StDoTopRsp != null) {
                h.this.o0(this.f83700a.f398449id.get(), "");
                SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(8, this.f83700a.f398449id.get(), this.f83701b, h.this.I(this.f83700a), this.f83702c));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public boolean f83704a;

        /* renamed from: b, reason: collision with root package name */
        public String f83705b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f83706c;

        j() {
        }

        public String toString() {
            return "CommentResponse{hasMore=" + this.f83704a + ", attachInfo='" + this.f83705b + "', hasResponse='" + this.f83706c + "'}";
        }
    }

    h() {
    }

    public static h G() {
        if (Q == null) {
            synchronized (h.class) {
                if (Q == null) {
                    Q = new h();
                }
            }
        }
        return Q;
    }

    private String K(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment != null && feedCloudMeta$StFeed != null) {
            HashMap<String, String> hashMap = this.f83657e.get(feedCloudMeta$StFeed.f398449id.get());
            if (hashMap == null) {
                return feedCloudMeta$StComment.replyAttachInfo.get();
            }
            String str = hashMap.get(feedCloudMeta$StComment.f398447id.get());
            if (TextUtils.isEmpty(str)) {
                return feedCloudMeta$StComment.replyAttachInfo.get();
            }
            return str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i3, boolean z16, long j3, String str, FeedCloudRead$StGetCommentListRsp feedCloudRead$StGetCommentListRsp, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z17) {
        N(i3, z16, j3, str, feedCloudRead$StGetCommentListRsp, feedCloudMeta$StFeed, z17, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RFWTestMock(id = "QFS_COMMENT_DATA")
    public void N(int i3, boolean z16, long j3, String str, FeedCloudRead$StGetCommentListRsp feedCloudRead$StGetCommentListRsp, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z17, boolean z18) {
        boolean z19;
        boolean z26;
        boolean z27;
        Object obj;
        ArrayList<FeedCloudMeta$StComment> arrayList;
        if (z16 && j3 == 0 && feedCloudRead$StGetCommentListRsp != null) {
            g0(feedCloudRead$StGetCommentListRsp.cmt_show_config.get());
            n0(feedCloudMeta$StFeed.f398449id.get(), true);
            QCircleUserLabelConfig qCircleUserLabelConfig = QCircleUserLabelConfig.INSTANCE;
            if (!com.tencent.biz.qqcircle.helpers.d.a(11, false) && feedCloudRead$StGetCommentListRsp.is_e_da_xia.get()) {
                z19 = true;
            } else {
                z19 = false;
            }
            qCircleUserLabelConfig.setIsEDaxia(z19);
            this.f83660i.put(feedCloudMeta$StFeed.f398449id.get(), Boolean.valueOf(feedCloudRead$StGetCommentListRsp.need_ad_req_nextpage.get()));
            if (feedCloudRead$StGetCommentListRsp.extInfo.has()) {
                updateSession(feedCloudRead$StGetCommentListRsp.extInfo.get());
                h0(feedCloudRead$StGetCommentListRsp.extInfo.mapInfo);
            }
            if (feedCloudRead$StGetCommentListRsp.epxs.share_cmt.get() == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            this.L = z26;
            if (feedCloudRead$StGetCommentListRsp.isFinish.get() == 1) {
                z27 = true;
            } else {
                z27 = false;
            }
            i0(feedCloudMeta$StFeed.f398449id.get(), feedCloudRead$StGetCommentListRsp.feedAttchInfo.get(), !z27, z17);
            String str2 = feedCloudMeta$StFeed.f398449id.get();
            List<FeedCloudMeta$StComment> list = feedCloudRead$StGetCommentListRsp.vecComment.get();
            cg.e(str2, list);
            cg.f(str2, list);
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleCommentResponse Success  isLoadMore:");
            sb5.append(z17);
            sb5.append(", isCache:");
            sb5.append(isProtocolCache);
            sb5.append(", cmt.size:");
            if (list != null) {
                obj = Integer.valueOf(list.size());
            } else {
                obj = "";
            }
            sb5.append(obj);
            sb5.append(", isFinish\uff1a");
            sb5.append(z27);
            sb5.append(", rsp.totalNum\uff1a");
            sb5.append(feedCloudRead$StGetCommentListRsp.totalNum.get());
            QLog.d("QFSCommentBusiness", 1, sb5.toString());
            if (z17) {
                x(str2, list);
                ArrayList<FeedCloudMeta$StComment> arrayList2 = this.f83656d.get(str2);
                if (arrayList2 != null) {
                    arrayList2.addAll(list);
                }
                l0(str2, list, z17, z27);
                QCircleCommentUpdateEvent qCircleCommentUpdateEvent = new QCircleCommentUpdateEvent(2, str2, list, I(feedCloudMeta$StFeed), i3, feedCloudRead$StGetCommentListRsp.tailText.get());
                qCircleCommentUpdateEvent.setFastCommentText(feedCloudRead$StGetCommentListRsp.fastCommentText.get());
                qCircleCommentUpdateEvent.setIsProtocolCache(isProtocolCache);
                SimpleEventBus.getInstance().dispatchEvent(qCircleCommentUpdateEvent);
            } else {
                com.tencent.biz.qqcircle.immersive.feed.ad.u.a(feedCloudMeta$StFeed, list);
                com.tencent.biz.qqcircle.helpers.g.f84619a.g(i3, feedCloudRead$StGetCommentListRsp.show_satisfy_vote.get());
                if (!RFSafeListUtils.isEmpty(list)) {
                    arrayList = (ArrayList) list;
                    FeedCloudMeta$StComment feedCloudMeta$StComment = feedCloudRead$StGetCommentListRsp.vecComment.get(0);
                    if (feedCloudMeta$StComment.typeFlag.get() == 1) {
                        o0(feedCloudMeta$StFeed.f398449id.get(), feedCloudMeta$StComment.f398447id.get());
                    }
                } else {
                    arrayList = null;
                }
                if (!z27) {
                    k0(str2, feedCloudRead$StGetCommentListRsp.totalNum.get());
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<>(0);
                }
                ArrayList<FeedCloudMeta$StComment> arrayList3 = arrayList;
                this.f83656d.put(str2, arrayList3);
                this.f83658f.clear();
                ArrayList<String> arrayList4 = new ArrayList<>();
                Iterator<FeedCloudMeta$StComment> it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList4.add(it.next().f398447id.get());
                }
                this.f83658f.put(str2, arrayList4);
                j0(str2, feedCloudRead$StGetCommentListRsp.cmt_show_config.upload_photo_icon.get());
                if (I(feedCloudMeta$StFeed) == 0) {
                    QLog.e("QFSCommentBusiness", 1, "\u540e\u53f0\u8fd4\u56de\u8bc4\u8bba\u6570\u4e3a0");
                }
                this.C.clear();
                this.C.addAll(feedCloudRead$StGetCommentListRsp.emojiAfterLikeComment.get());
                this.D.clear();
                this.D.addAll(feedCloudRead$StGetCommentListRsp.textAfterLikeComment.get());
                l0(str2, list, z17, z27);
                QCircleCommentUpdateEvent qCircleCommentUpdateEvent2 = new QCircleCommentUpdateEvent(1, str2, arrayList3, I(feedCloudMeta$StFeed), i3, feedCloudRead$StGetCommentListRsp.tailText.get());
                qCircleCommentUpdateEvent2.needShowCommentPanel = z18;
                qCircleCommentUpdateEvent2.setFastCommentText(feedCloudRead$StGetCommentListRsp.fastCommentText.get());
                qCircleCommentUpdateEvent2.setGuildDisplayInfo(feedCloudRead$StGetCommentListRsp.guildDisplayInfo.get());
                qCircleCommentUpdateEvent2.setIsProtocolCache(isProtocolCache);
                SimpleEventBus.getInstance().dispatchEvent(qCircleCommentUpdateEvent2);
            }
            com.tencent.biz.qqcircle.comment.sticker.b.b(feedCloudMeta$StFeed);
            a0(feedCloudRead$StGetCommentListRsp.ai_cmt_trans_info.get());
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(QCircleCommentUpdateEvent.getCommentListFailedEvent(feedCloudMeta$StFeed.f398449id.get(), i3));
        e0(j3, str);
        QLog.e("QFSCommentBusiness", 1, "getComment error:" + j3 + "  errorMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RFWTestMock(id = "QFS_REPLY_DATA")
    public void O(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudRead$StGetReplyListRsp feedCloudRead$StGetReplyListRsp, QFSReplyExtraBean qFSReplyExtraBean) {
        String str;
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        } else {
            str = "";
        }
        cg.g(str, feedCloudRead$StGetReplyListRsp.vecReply.get());
        m0(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudRead$StGetReplyListRsp.attchInfo.get());
        SimpleEventBus.getInstance().dispatchEvent(new QFSReplyListEvent(i3, feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudRead$StGetReplyListRsp, qFSReplyExtraBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z16, long j3, String str, QCircleGetCommentListRequest qCircleGetCommentListRequest) {
        if (z16 && j3 == 0 && !VSNetworkHelper.isProtocolCache(str)) {
            com.tencent.biz.qqcircle.immersive.report.a.b("comment", qCircleGetCommentListRequest.getCmd(), qCircleGetCommentListRequest.getTraceId());
        }
    }

    private boolean T(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && Boolean.TRUE.equals(this.f83660i.get(feedCloudMeta$StFeed.f398449id.get()))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(ITaskListener iTaskListener, WinkPublishParams winkPublishParams, WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        if (winkPublishServiceProxy2 == null) {
            return;
        }
        winkPublishServiceProxy2.addTaskListener2(iTaskListener);
        QLog.d("CommentPicTag", 1, "uploadCommentPic, add task");
        winkPublishServiceProxy2.addTask(winkPublishParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void W(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        e30.b bVar;
        MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, feedCloudMeta$StFeed.f398449id.get());
        if (globalData != null && (bVar = (e30.b) globalData.getValue()) != null && bVar.g() != null) {
            bVar.g().commentCount.set(i3);
            globalData.postValue(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
        dataBuilder.setActionType(60).setSubActionType(4).setExt9(str);
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private void Z(int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, boolean z16, int i17, String str2) {
        QCircleGetCommentListRequest qCircleGetCommentListRequest = new QCircleGetCommentListRequest(feedCloudMeta$StFeed, i16, str, 20, feedCloudMeta$StFeed.likeInfo.f398454id.get(), str2);
        qCircleGetCommentListRequest.req.extInfo.set(getSession(!z16));
        if (!z16 && i17 != 1) {
            qCircleGetCommentListRequest.req.ad_get_req.set(com.tencent.biz.qqcircle.immersive.utils.j.f90213a.r(feedCloudMeta$StFeed.poster.f398463id.get(), feedCloudMeta$StFeed.f398449id.get()));
        } else if (z16 && T(feedCloudMeta$StFeed)) {
            QLog.d("QFSCommentBusiness", 1, "[requestGetComments] load more add ad info");
            qCircleGetCommentListRequest.req.ad_get_req.set(com.tencent.biz.qqcircle.immersive.utils.j.f90213a.r(feedCloudMeta$StFeed.poster.f398463id.get(), feedCloudMeta$StFeed.f398449id.get()));
        }
        VSNetworkHelper.getInstance().sendRequest(i3, qCircleGetCommentListRequest, new c(feedCloudMeta$StFeed, i3, z16, qCircleGetCommentListRequest));
    }

    private void b0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        ByteStringMicro byteStringMicro;
        boolean z16;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        List<FeedCloudCommon$BytesEntry> list = feedCloudMeta$StFeed.busiTranparent.get();
        try {
            byteStringMicro = ByteStringMicro.copyFrom(String.valueOf(i3).getBytes("UTF8"));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            byteStringMicro = null;
        }
        if (byteStringMicro == null) {
            return;
        }
        Iterator<FeedCloudCommon$BytesEntry> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                FeedCloudCommon$BytesEntry next = it.next();
                if (next != null && "FeedCommentShowCount".equals(next.key.get())) {
                    next.value.set(byteStringMicro);
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set("FeedCommentShowCount");
            feedCloudCommon$BytesEntry.value.set(byteStringMicro);
            list.add(feedCloudCommon$BytesEntry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(long j3, String str, boolean z16) {
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8), 0, true, false);
        } else if (z16) {
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f189123yj), 0, true, false);
        } else if (cj.a(j3)) {
            QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(boolean z16) {
        String a16;
        boolean isSpecifiedPanelShowing = QCirclePanelStateEvent.isSpecifiedPanelShowing(0);
        int i3 = QCircleToast.f91646f;
        if (z16) {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f189133yk);
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f187953vd);
        }
        QCircleToast.l(i3, a16, 0, true, !isSpecifiedPanelShowing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(long j3, String str) {
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8), 0, true, false);
        } else if (cj.a(j3)) {
            QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
        }
    }

    private void g0(FeedCloudRead$CmtShowConfig feedCloudRead$CmtShowConfig) {
        if (feedCloudRead$CmtShowConfig != null && feedCloudRead$CmtShowConfig.ai_cmt_tip_dialog.has()) {
            this.K = feedCloudRead$CmtShowConfig.ai_cmt_tip_dialog.get();
        }
    }

    private void h0(PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField) {
        if (pBRepeatMessageField == null) {
            return;
        }
        String str = "0";
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : pBRepeatMessageField.get()) {
            if ("in_at_exp".equals(feedCloudCommon$Entry.key.get())) {
                this.I = "1".equals(feedCloudCommon$Entry.value.get());
            }
            if ("at_exp_type".equals(feedCloudCommon$Entry.key.get())) {
                str = feedCloudCommon$Entry.value.get();
            }
        }
        QFSCommentAtHelper.n0(str);
    }

    private void i0(String str, String str2, boolean z16, boolean z17) {
        if (this.F.get(str) == null) {
            j jVar = new j();
            jVar.f83705b = str2;
            jVar.f83704a = z16;
            jVar.f83706c = true;
            this.F.put(str, jVar);
            QLog.d("QFSCommentBusiness", 1, "getDetailCommentSize: feedAttachInfo is null: " + TextUtils.isEmpty(str2));
            return;
        }
        if (z17) {
            this.F.get(str).f83704a = z16;
            this.F.get(str).f83705b = str2;
        }
    }

    private void j0(String str, FeedCloudRead$UploadPhotoIcon feedCloudRead$UploadPhotoIcon) {
        this.G.put(str, feedCloudRead$UploadPhotoIcon);
    }

    private void l0(String str, List<FeedCloudMeta$StComment> list, boolean z16, boolean z17) {
        if (z16) {
            this.M += RFSafeListUtils.getSize(list);
        } else {
            this.M = RFSafeListUtils.getSize(list);
            this.N = 0;
            this.P = 0;
            Iterator<FeedCloudMeta$StComment> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().cmt_block_type.get() == 1) {
                    this.P++;
                }
            }
        }
        for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
            int i3 = feedCloudMeta$StComment.replyCount.get();
            this.N += i3;
            QLog.d("QFSCommentBusiness", 4, "[updateRealShowCommentCount] " + i3 + ", comment=" + feedCloudMeta$StComment.content.get());
        }
        int i16 = (this.M + this.N) - this.P;
        if (z17) {
            QLog.d("QFSCommentBusiness", 1, "[updateRealShowCommentCount] resultCount =" + i16 + ", mCommentCount = " + this.M + ", mReplyCount =" + this.N + ", mAdComment = " + this.P);
            k0(str, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        ArrayList<FeedCloudMeta$StComment> arrayList = this.f83656d.get(str);
        if (RFSafeListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<FeedCloudMeta$StComment> it = arrayList.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f398447id.get(), feedCloudMeta$StComment.f398447id.get())) {
                z16 = false;
            }
        }
        if (z16) {
            arrayList.add(feedCloudMeta$StComment);
            ArrayList<String> arrayList2 = this.f83658f.get(str);
            if (arrayList2 != null) {
                arrayList2.add(feedCloudMeta$StComment.f398447id.get());
            }
        }
    }

    private void n0(String str, boolean z16) {
        if (this.F.get(str) != null) {
            this.F.get(str).f83706c = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QFSCommentBusiness", 1, "updateStickyCommentId param error");
            return;
        }
        if (this.E == null) {
            this.E = new HashMap();
        }
        QLog.d("QFSCommentBusiness", 1, "updateStickyCommentId feedId:" + str + " commentId" + str2);
        this.E.put(str, str2);
    }

    private void r() {
        QLog.d("QFSCommentBusiness", 1, new Throwable("clearLoadedCommentsAndAttachInfo debug,"), new Object[0]);
        this.f83658f.clear();
        this.f83656d.clear();
        this.F.clear();
        this.f83657e.clear();
        this.G.clear();
        this.f83661m.clear();
        this.f83660i.clear();
    }

    private void w(String str) {
        String P = QFSCommentHelper.L().P(str);
        if (TextUtils.isEmpty(P)) {
            QLog.w("QFSCommentBusiness", 1, "deletePublishingFeed, taskId is empty");
            return;
        }
        QLog.d("QFSCommentBusiness", 1, "cancelUploadActually, taskIdStr: " + P);
        try {
            long parseLong = Long.parseLong(P);
            WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
            if (qfsService == null) {
                QLog.w("QFSCommentBusiness", 1, "deletePublishingFeed, fakeId = " + str);
                return;
            }
            qfsService.cancelTaskWithId(parseLong);
        } catch (Exception unused) {
            QLog.w("QFSCommentBusiness", 1, "deletePublishingFeed, e:" + P);
        }
    }

    private void x(String str, List<FeedCloudMeta$StComment> list) {
        if (list == null) {
            return;
        }
        ArrayList<String> arrayList = this.f83658f.get(str);
        if (RFSafeListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<FeedCloudMeta$StComment> it = list.iterator();
        while (it.hasNext()) {
            String str2 = it.next().f398447id.get();
            if (arrayList.contains(str2)) {
                QLog.d("QFSCommentBusiness", 1, "[filterDuplicateComment] commentId: " + str2);
                it.remove();
            }
        }
    }

    public String A(String str) {
        j jVar;
        String str2;
        if (!TextUtils.isEmpty(str) && (jVar = this.F.get(str)) != null) {
            if (jVar.f83706c && jVar.f83704a && (str2 = jVar.f83705b) != null) {
                return str2;
            }
            QLog.i("QFSCommentBusiness", 1, jVar.toString());
        }
        return null;
    }

    public String B(String str) {
        PBStringField pBStringField;
        FeedCloudRead$UploadPhotoIcon feedCloudRead$UploadPhotoIcon = this.G.get(str);
        if (feedCloudRead$UploadPhotoIcon == null) {
            return "";
        }
        if (QCircleSkinHelper.getInstance().isDarkMode()) {
            pBStringField = feedCloudRead$UploadPhotoIcon.pag_url_dark;
        } else {
            pBStringField = feedCloudRead$UploadPhotoIcon.pag_url;
        }
        return pBStringField.get();
    }

    public void C(int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, int i17, int i18, String str) {
        String str2;
        if (feedCloudMeta$StFeed == null) {
            QLog.i("QFSCommentBusiness", 1, "getComments  feed == null");
            return;
        }
        if (!z16) {
            s(feedCloudMeta$StFeed.f398449id.get());
        }
        if (z16) {
            String A = A(feedCloudMeta$StFeed.f398449id.get());
            if (A == null) {
                QLog.e("QFSCommentBusiness", 1, "getComments loadMore , attachInfo is null ");
                return;
            }
            b0(feedCloudMeta$StFeed, i17);
            QLog.i("QFSCommentBusiness", 1, "getComments, feedAttachInfo:" + A);
            str2 = A;
        } else {
            str2 = null;
        }
        Z(i3, i16, feedCloudMeta$StFeed, str2, z16, i18, str);
        n0(feedCloudMeta$StFeed.f398449id.get(), false);
    }

    public void D(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QQCircleFeedBase$StBusiInfoCommentListData qQCircleFeedBase$StBusiInfoCommentListData) {
        if (feedCloudMeta$StFeed == null) {
            QLog.i("QFSCommentBusiness", 1, "getComments  feed == null");
            return;
        }
        s(feedCloudMeta$StFeed.f398449id.get());
        boolean z16 = false;
        n0(feedCloudMeta$StFeed.f398449id.get(), false);
        QCircleGetCommentListRequest qCircleGetCommentListRequest = new QCircleGetCommentListRequest(feedCloudMeta$StFeed, null, 20, feedCloudMeta$StFeed.likeInfo.f398454id.get());
        qCircleGetCommentListRequest.req.extInfo.set(getSession(true));
        if (qQCircleFeedBase$StBusiInfoCommentListData != null) {
            qCircleGetCommentListRequest.req.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StBusiInfoCommentListData.toByteArray()));
        }
        qCircleGetCommentListRequest.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(i3, qCircleGetCommentListRequest, new a(feedCloudMeta$StFeed, i3, qCircleGetCommentListRequest));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("req traceId:");
        sb5.append(qCircleGetCommentListRequest.getTraceId());
        sb5.append("stBusiInfoCommentListData is ");
        if (qQCircleFeedBase$StBusiInfoCommentListData != null) {
            z16 = true;
        }
        sb5.append(z16);
        QLog.d("QFSCommentBusiness", 1, sb5.toString());
    }

    public List<String> E() {
        return this.C;
    }

    public List<String> F() {
        return this.D;
    }

    public ArrayList<FeedCloudMeta$StComment> H(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f83656d.get(str);
    }

    public int I(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Integer num = this.f83659h.get(feedCloudMeta$StFeed.f398449id.get());
        if (num != null) {
            return num.intValue();
        }
        return feedCloudMeta$StFeed.commentCount.get();
    }

    public List<String> J(String str) {
        return this.f83661m.get(str);
    }

    public void L(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, QFSReplyExtraBean qFSReplyExtraBean) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StComment != null) {
            String K = K(feedCloudMeta$StFeed, feedCloudMeta$StComment);
            if (K == null) {
                QLog.w("QFSCommentBusiness", 1, "getReplyList error: attachInfo==null,feedId=" + feedCloudMeta$StFeed.f398449id.get() + ",commentId=" + feedCloudMeta$StComment.f398447id.get());
                SimpleEventBus.getInstance().dispatchEvent(new QFSReplyListEvent(i3, false, qFSReplyExtraBean));
                return;
            }
            QLog.d("QFSCommentBusiness", 1, "[getReplyList]  feedId=" + feedCloudMeta$StFeed.f398449id.get() + ",commentId=" + feedCloudMeta$StComment.f398447id.get() + ",attachInfo=" + K);
            QCircleGetReplyListRequest qCircleGetReplyListRequest = new QCircleGetReplyListRequest(feedCloudMeta$StFeed, feedCloudMeta$StComment, K);
            VSNetworkHelper.getInstance().sendRequest(i3, qCircleGetReplyListRequest, new b(qCircleGetReplyListRequest, i3, qFSReplyExtraBean, feedCloudMeta$StFeed, feedCloudMeta$StComment));
            return;
        }
        QLog.w("QFSCommentBusiness", 1, "getReplyList error: feed=" + feedCloudMeta$StFeed + ",comment=" + feedCloudMeta$StComment);
        SimpleEventBus.getInstance().dispatchEvent(new QFSReplyListEvent(i3, false, qFSReplyExtraBean));
    }

    public boolean Q() {
        return this.I;
    }

    public boolean R() {
        return this.L;
    }

    public boolean S(String str) {
        if (this.F.get(str) == null) {
            return false;
        }
        return !r2.f83704a;
    }

    public boolean U(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StComment != null) {
            Map<String, String> map = this.E;
            if (map != null && map.containsKey(feedCloudMeta$StFeed.f398449id.get())) {
                String str = this.E.get(feedCloudMeta$StFeed.f398449id.get());
                if (!TextUtils.isEmpty(str) && !str.equals(feedCloudMeta$StComment.f398447id.get())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        QLog.e("QFSCommentBusiness", 1, "isReplaceStickyComment param is null");
        return false;
    }

    public void X(ITaskListener iTaskListener) {
        QLog.d("CommentPicTag", 1, "removeWinkPublishTaskListener");
        if (iTaskListener != null) {
            try {
                WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
                if (qfsService != null) {
                    qfsService.removeTaskListener(iTaskListener);
                }
            } catch (Exception e16) {
                QLog.e("CommentPicTag", 1, "[removeWinkPublishTaskListener]", e16);
            }
        }
    }

    public void a0(ByteStringMicro byteStringMicro) {
        this.J = byteStringMicro;
    }

    public void f0(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        VSNetworkHelper.getInstance().sendRequest(i3, new QCircleDoStickyRequest(feedCloudMeta$StFeed, feedCloudMeta$StComment, 1), new C0854h(feedCloudMeta$StFeed, feedCloudMeta$StComment, i3));
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        return this.H.getSessionCommonExt(z16);
    }

    public void k0(String str, int i3) {
        this.f83659h.put(str, Integer.valueOf(i3));
    }

    public void m(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, boolean z16, QCircleInitBean qCircleInitBean) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StComment != null && feedCloudMeta$StReply != null) {
            VSNetworkHelper.getInstance().sendRequest(i3, new QCircleDoReplyRequest(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, 1, z16, qCircleInitBean), new f(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, i3));
        }
    }

    public void m0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, String str) {
        if (feedCloudMeta$StComment != null && feedCloudMeta$StFeed != null) {
            HashMap<String, String> hashMap = this.f83657e.get(feedCloudMeta$StFeed.f398449id.get());
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put(feedCloudMeta$StComment.f398447id.get(), str);
            this.f83657e.put(feedCloudMeta$StFeed.f398449id.get(), hashMap);
        }
    }

    public void o(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, boolean z16, boolean z17, QCircleInitBean qCircleInitBean) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StComment != null) {
            com.tencent.biz.qqcircle.helpers.l.e().a(feedCloudMeta$StComment, feedCloudMeta$StFeed);
            VSNetworkHelper.getInstance().sendRequest(i3, new QCircleDoCommentRequest(feedCloudMeta$StFeed, feedCloudMeta$StComment, 1, z16, qCircleInitBean), new d(feedCloudMeta$StFeed, feedCloudMeta$StComment, i3, z17));
        }
    }

    public void p(String str, List<String> list) {
        this.f83661m.put(str, list);
    }

    public void p0(String str, final ITaskListener iTaskListener) {
        if (!TextUtils.isEmpty(str) && iTaskListener != null) {
            QLog.d("CommentPicTag", 1, "uploadCommentPic, path:" + str);
            Bundle bundle = new Bundle();
            bundle.putString(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE, String.valueOf(1));
            bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, QQWinkConstants.WinkPublishTaskID.XSJ_COMMENT_PIC);
            final WinkPublishParams winkPublishParams = new WinkPublishParams(1, UUID.randomUUID().toString(), QCirclePublishQualityReporter.getTraceId(), true, 23, Collections.singletonList(new ImageParams(str, 3, 0, 0, 0L, 0, 0, 0L, "", null)), null, null, bundle, null);
            WinkPublishHelper2.INSTANCE.bindService(1, new WinkPublishHelper2.Callback() { // from class: com.tencent.biz.qqcircle.comment.g
                @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
                public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                    h.V(ITaskListener.this, winkPublishParams, winkPublishServiceProxy2);
                }
            });
        }
    }

    public void q(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        VSNetworkHelper.getInstance().sendRequest(i3, new QCircleDoStickyRequest(feedCloudMeta$StFeed, feedCloudMeta$StComment, 2), new i(feedCloudMeta$StFeed, feedCloudMeta$StComment, i3));
    }

    public void s(String str) {
        if (TextUtils.isEmpty(str)) {
            r();
            return;
        }
        this.f83658f.remove(str);
        this.f83656d.remove(str);
        this.F.remove(str);
        this.f83657e.remove(str);
        this.f83660i.remove(str);
    }

    public void t(String str, String str2) {
        ArrayList<FeedCloudMeta$StComment> arrayList = this.f83656d.get(str);
        if (arrayList == null) {
            return;
        }
        Iterator<FeedCloudMeta$StComment> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FeedCloudMeta$StComment next = it.next();
            if (TextUtils.equals(str2, next.f398447id.get())) {
                arrayList.remove(next);
                break;
            }
        }
        this.f83656d.put(str, arrayList);
        ArrayList<String> arrayList2 = this.f83658f.get(str);
        if (arrayList2 != null) {
            arrayList2.remove(str2);
        }
    }

    public void u(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i16, boolean z16) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StComment != null && feedCloudMeta$StReply != null) {
            if (QFSCommentHelper.c0(feedCloudMeta$StReply.f398460id.get())) {
                w(feedCloudMeta$StReply.f398460id.get());
                SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(6, feedCloudMeta$StFeed.f398449id.get(), feedCloudMeta$StComment, feedCloudMeta$StReply, I(feedCloudMeta$StFeed), i3));
            } else {
                VSNetworkHelper.getInstance().sendRequest(i3, new QCircleDoReplyRequest(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, i16, z16, null), new g(feedCloudMeta$StReply, feedCloudMeta$StFeed, feedCloudMeta$StComment, i3));
            }
        }
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        this.H.updateSubSession(feedCloudCommon$StCommonExt);
    }

    public void v(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i16, boolean z16) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StComment != null) {
            if (QFSCommentHelper.c0(feedCloudMeta$StComment.f398447id.get())) {
                com.tencent.biz.qqcircle.helpers.l.e().k(feedCloudMeta$StComment, feedCloudMeta$StFeed);
                w(feedCloudMeta$StComment.f398447id.get());
                SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(4, feedCloudMeta$StFeed.f398449id.get(), feedCloudMeta$StComment, I(feedCloudMeta$StFeed), i3));
            } else {
                VSNetworkHelper.getInstance().sendRequest(i3, new QCircleDoCommentRequest(feedCloudMeta$StFeed, feedCloudMeta$StComment, i16, z16, null), new e(feedCloudMeta$StComment, feedCloudMeta$StFeed, i3));
            }
        }
    }

    public FeedCloudRead$CommDialog y() {
        return this.K;
    }

    public ByteStringMicro z() {
        return this.J;
    }
}
