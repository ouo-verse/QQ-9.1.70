package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCommentKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReplyKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.IEventObserver;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneBaseEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneRefreshDetailFeedEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.fake.QzoneFakeOperateHelper;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ClientFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedDetailRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetRepliesRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedDetailService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eJ2\u0010!\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001eJ,\u0010$\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020(0\u001eJ\u0018\u0010)\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010*\u001a\u00020-H\u0016J\u0016\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0010J\u000e\u00101\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u00063"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedDetailManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/IEventObserver;", "()V", "commentAttachInfo", "", "getCommentAttachInfo", "()Ljava/lang/String;", "setCommentAttachInfo", "(Ljava/lang/String;)V", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "dataUpdateCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "detailService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedDetailService;", "hasMoreComment", "", "getHasMoreComment", "()Z", "setHasMoreComment", "(Z)V", "lastCommentAttachInfo", "getLastCommentAttachInfo", "setLastCommentAttachInfo", QCircleLpReportDc05507.KEY_CLEAR, "", "fetchFeedComment", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "fetchFeedDetail", ZPlanPublishSource.FROM_SCHEME, "cacheKey", "fetchMoreReply", "curComment", "pageSize", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetRepliesRsp;", "notifyFeedChange", "event", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneOperateEvent;", "onEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneBaseEvent;", "registerFeedUpdateCallback", "callback", "applyCache", "unregisterFeedUpdateCallback", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedDetailManager implements IEventObserver {
    public static final String TAG = "QzoneFeedDetailManager";
    private CommonFeed commonFeed;
    private IQzoneFeedUpdateCallback dataUpdateCallback;
    private boolean hasMoreComment;
    public static final int $stable = 8;
    private QzoneFeedDetailService detailService = new QzoneFeedDetailService();
    private String lastCommentAttachInfo = "";
    private String commentAttachInfo = "";

    public QzoneFeedDetailManager() {
        QzoneEventBus.INSTANCE.register(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyFeedChange(CommonFeed commonFeed, QzoneOperateEvent event) {
        KLog kLog = KLog.INSTANCE;
        String logTag = QzoneFriendFeedManager.INSTANCE.getLogTag();
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("notifyFeedChange, commonFeed@");
        m3.append(commonFeed.hashCode());
        m3.append(", event: ");
        m3.append(event);
        kLog.d(logTag, m3.toString());
        IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback = this.dataUpdateCallback;
        if (iQzoneFeedUpdateCallback != null) {
            IQzoneFeedUpdateCallback.DefaultImpls.onDataUpdate$default(iQzoneFeedUpdateCallback, commonFeed, event.getAction(), 0, 4, null);
        }
    }

    public final void fetchFeedComment(CommonUnionID unionId, final DataCallback<List<CommonComment>> dataCallback) {
        String str = this.commentAttachInfo;
        if (str == null || str.length() == 0) {
            KLog.INSTANCE.d(TAG, "fetchFeedComment fail, commentAttachInfo is empty");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "commentAttachInfo is empty");
                return;
            }
            return;
        }
        this.detailService.fetchFeedDetailComment$qecommerce_biz_release(unionId, this.commentAttachInfo, new DataCallback<GetCommentRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDetailManager$fetchFeedComment$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            /* JADX WARN: Code restructure failed: missing block: B:56:0x00d2, code lost:
            
                r8 = r14.this$0.dataUpdateCallback;
             */
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSuccess(GetCommentRsp rsp, long retCode, String msg2, boolean isFinish) {
                ArrayList arrayList;
                CommonFeed commonFeed;
                CommonFeed commonFeed2;
                CommonFeed commonFeed3;
                IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback;
                CommonCellComment cellComment;
                List<CommonComment> comments;
                CommonCellComment cellComment2;
                List<CommonComment> comments2;
                List<StComment> list;
                StFeedCellComment stFeedCellComment = rsp.cellComment;
                if (stFeedCellComment != null && (list = stFeedCellComment.comments) != null) {
                    arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        CommonComment common2 = CommonCommentKt.toCommon((StComment) it.next());
                        if (common2 != null) {
                            arrayList.add(common2);
                        }
                    }
                } else {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList2 = arrayList;
                HashSet hashSet = new HashSet();
                commonFeed = QzoneFeedDetailManager.this.commonFeed;
                if (commonFeed != null && (cellComment2 = commonFeed.getCellComment()) != null && (comments2 = cellComment2.getComments()) != null) {
                    Iterator<T> it5 = comments2.iterator();
                    while (it5.hasNext()) {
                        hashSet.add(((CommonComment) it5.next()).getId());
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it6 = arrayList2.iterator();
                while (true) {
                    boolean z16 = true;
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next = it6.next();
                    CommonComment commonComment = (CommonComment) next;
                    String id5 = commonComment.getId();
                    if (!(id5 == null || id5.length() == 0) && hashSet.contains(commonComment.getId())) {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList3.add(next);
                    }
                }
                commonFeed2 = QzoneFeedDetailManager.this.commonFeed;
                if (commonFeed2 != null && (cellComment = commonFeed2.getCellComment()) != null && (comments = cellComment.getComments()) != null) {
                    comments.addAll(arrayList3);
                }
                QzoneFeedDetailManager qzoneFeedDetailManager = QzoneFeedDetailManager.this;
                qzoneFeedDetailManager.setLastCommentAttachInfo(qzoneFeedDetailManager.getCommentAttachInfo());
                QzoneFeedDetailManager.this.setCommentAttachInfo(rsp.attachInfo);
                QzoneFeedDetailManager.this.setHasMoreComment(rsp.hasMore);
                commonFeed3 = QzoneFeedDetailManager.this.commonFeed;
                if (commonFeed3 != null && iQzoneFeedUpdateCallback != null) {
                    IQzoneFeedUpdateCallback.DefaultImpls.onDataUpdate$default(iQzoneFeedUpdateCallback, commonFeed3, QzoneDataUpdateAction.LOAD_MORE_COMMENT, 0, 4, null);
                }
                dataCallback.onSuccess(arrayList2, retCode, msg2, !QzoneFeedDetailManager.this.getHasMoreComment());
            }
        });
    }

    public final void fetchFeedDetail(final CommonUnionID unionId, final String scheme, final String cacheKey, final DataCallback<CommonFeed> dataCallback) {
        this.detailService.fetchFeedDetail$qecommerce_biz_release(unionId, scheme, new DataCallback<GetFeedDetailRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDetailManager$fetchFeedDetail$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x00a1, code lost:
            
                if ((r4.length() > 0) == true) goto L46;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v13 */
            /* JADX WARN: Type inference failed for: r1v16 */
            /* JADX WARN: Type inference failed for: r1v17 */
            /* JADX WARN: Type inference failed for: r1v18 */
            /* JADX WARN: Type inference failed for: r1v19 */
            /* JADX WARN: Type inference failed for: r1v22 */
            /* JADX WARN: Type inference failed for: r1v23 */
            /* JADX WARN: Type inference failed for: r1v24 */
            /* JADX WARN: Type inference failed for: r1v25 */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r1v9 */
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSuccess(GetFeedDetailRsp rsp, long retCode, String msg2, boolean isFinish) {
                CommonFeed commonFeed;
                IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback;
                ?? r16;
                String ufKey;
                StFeed stFeed;
                QzoneFeedDetailManager qzoneFeedDetailManager = QzoneFeedDetailManager.this;
                ClientFeed clientFeed = rsp.feed;
                Unit unit = null;
                r4 = null;
                String str = null;
                qzoneFeedDetailManager.commonFeed = (clientFeed == null || (stFeed = clientFeed.feed) == null) ? null : CommonFeedKt.toCommonFeed(stFeed);
                commonFeed = QzoneFeedDetailManager.this.commonFeed;
                if (commonFeed != null) {
                    QzoneFeedDetailManager qzoneFeedDetailManager2 = QzoneFeedDetailManager.this;
                    DataCallback<CommonFeed> dataCallback2 = dataCallback;
                    String str2 = cacheKey;
                    CommonUnionID commonUnionID = unionId;
                    String str3 = scheme;
                    qzoneFeedDetailManager2.setLastCommentAttachInfo("");
                    qzoneFeedDetailManager2.setCommentAttachInfo(rsp.attachInfo);
                    qzoneFeedDetailManager2.setHasMoreComment(rsp.hasMore);
                    QzoneFakeOperateHelper.INSTANCE.checkInsertFakeCommentToFeed(commonFeed);
                    boolean z16 = true;
                    dataCallback2.onSuccess(commonFeed, retCode, msg2, !qzoneFeedDetailManager2.getHasMoreComment());
                    iQzoneFeedUpdateCallback = qzoneFeedDetailManager2.dataUpdateCallback;
                    if (iQzoneFeedUpdateCallback != null) {
                        IQzoneFeedUpdateCallback.DefaultImpls.onDataUpdate$default(iQzoneFeedUpdateCallback, commonFeed, "REFRESH", 0, 4, null);
                    }
                    if ((str2.length() > 0) == true) {
                        str = str2;
                    } else {
                        if (commonUnionID != null && (ufKey = commonUnionID.getUfKey()) != null) {
                            if ((ufKey.length() > 0) == true) {
                                r16 = true;
                                if (r16 == true) {
                                    if ((str3.length() > 0) != false) {
                                        str = str3;
                                    }
                                } else if (commonUnionID != null) {
                                    str = commonUnionID.getUfKey();
                                }
                            }
                        }
                        r16 = false;
                        if (r16 == true) {
                        }
                    }
                    if (str != null) {
                    }
                    z16 = false;
                    if (z16) {
                        QzoneDetailCacheManager.INSTANCE.saveFeedDetailData(str, commonFeed);
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    dataCallback.onFailure(QzoneBaseService.ERROR_CODE_NO_ANY_DATA, "detail feed data is null");
                }
            }
        });
    }

    public final void fetchMoreReply(CommonUnionID unionId, final CommonComment curComment, int pageSize, final DataCallback<GetRepliesRsp> dataCallback) {
        String id5 = curComment.getId();
        if (id5 == null || id5.length() == 0) {
            KLog.INSTANCE.d(TAG, "fetchMoreReply fail, commentId is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "commentId is null");
                return;
            }
            return;
        }
        String replyAttachInfo = curComment.getReplyAttachInfo();
        if (replyAttachInfo == null) {
            replyAttachInfo = "";
        }
        this.detailService.fetchMoreReply$qecommerce_biz_release(unionId, this.lastCommentAttachInfo, curComment, replyAttachInfo, pageSize, new DataCallback<GetRepliesRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDetailManager$fetchMoreReply$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
            
                if (r1 == null) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00b4, code lost:
            
                r7 = r2.dataUpdateCallback;
             */
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSuccess(GetRepliesRsp rsp, long retCode, String msg2, boolean isFinish) {
                Iterable arrayList;
                CommonFeed commonFeed;
                IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback;
                List<StReply> list = rsp.replys;
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        CommonReply common2 = CommonReplyKt.toCommon((StReply) it.next());
                        if (common2 != null) {
                            arrayList2.add(common2);
                        }
                    }
                    arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
                }
                arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                Iterator<T> it5 = CommonComment.this.getReplys().iterator();
                while (it5.hasNext()) {
                    hashSet.add(((CommonReply) it5.next()).getId());
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it6 = arrayList.iterator();
                while (true) {
                    boolean z16 = true;
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next = it6.next();
                    CommonReply commonReply = (CommonReply) next;
                    String id6 = commonReply.getId();
                    if (!(id6 == null || id6.length() == 0) && hashSet.contains(commonReply.getId())) {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList3.add(next);
                    }
                }
                List<CommonReply> replys = CommonComment.this.getReplys();
                if (replys != null) {
                    replys.addAll(arrayList3);
                }
                CommonComment.this.setReplyAttachInfo(rsp.replyAttachInfo);
                CommonComment.this.setHasMoreReply(Boolean.valueOf(rsp.hasMore));
                commonFeed = this.commonFeed;
                if (commonFeed != null && iQzoneFeedUpdateCallback != null) {
                    IQzoneFeedUpdateCallback.DefaultImpls.onDataUpdate$default(iQzoneFeedUpdateCallback, commonFeed, QzoneDataUpdateAction.LOAD_MORE_REPLY, 0, 4, null);
                }
                dataCallback.onSuccess(rsp, retCode, msg2, true ^ rsp.hasMore);
            }
        });
    }

    public final String getCommentAttachInfo() {
        return this.commentAttachInfo;
    }

    public final boolean getHasMoreComment() {
        return this.hasMoreComment;
    }

    public final String getLastCommentAttachInfo() {
        return this.lastCommentAttachInfo;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.IEventObserver
    public void onEvent(final QzoneBaseEvent event) {
        List<CommonFeed> mutableListOf;
        KLog kLog = KLog.INSTANCE;
        kLog.d(TAG, "onEvent: " + event);
        if (event instanceof QzoneOperateEvent) {
            CommonFeed commonFeed = this.commonFeed;
            if (commonFeed == null) {
                kLog.d(TAG, "receive event but feed is null");
                return;
            }
            Intrinsics.checkNotNull(commonFeed);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(commonFeed);
            QzoneFakeOperateHelper.INSTANCE.onOperateEvent$qecommerce_biz_release((QzoneOperateEvent) event, mutableListOf, new Function1<CommonFeed, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDetailManager$onEvent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CommonFeed commonFeed2) {
                    invoke2(commonFeed2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CommonFeed commonFeed2) {
                    QzoneFeedDetailManager.this.notifyFeedChange(commonFeed2, (QzoneOperateEvent) event);
                }
            });
            return;
        }
        if (event instanceof QzoneRefreshDetailFeedEvent) {
            QzoneRefreshDetailFeedEvent qzoneRefreshDetailFeedEvent = (QzoneRefreshDetailFeedEvent) event;
            if (Intrinsics.areEqual(qzoneRefreshDetailFeedEvent.getUnionID().getUfKey(), CommonFeedExtKt.getFeedUniqueKey(this.commonFeed))) {
                fetchFeedDetail(qzoneRefreshDetailFeedEvent.getUnionID(), "", "", new DataCallback<CommonFeed>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDetailManager$onEvent$2
                    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                    public void onSuccess(CommonFeed t16, long retCode, String msg2, boolean isFinish) {
                    }

                    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                    public void onFailure(long errorCode, String errorMsg) {
                    }
                });
            }
        }
    }

    public final void registerFeedUpdateCallback(IQzoneFeedUpdateCallback callback, boolean applyCache) {
        CommonFeed commonFeed;
        this.dataUpdateCallback = callback;
        if (!applyCache || (commonFeed = this.commonFeed) == null) {
            return;
        }
        Intrinsics.checkNotNull(commonFeed);
        IQzoneFeedUpdateCallback.DefaultImpls.onDataUpdate$default(callback, commonFeed, QzoneDataUpdateAction.MEMORY_CACHE, 0, 4, null);
    }

    public final void setCommentAttachInfo(String str) {
        this.commentAttachInfo = str;
    }

    public final void setHasMoreComment(boolean z16) {
        this.hasMoreComment = z16;
    }

    public final void setLastCommentAttachInfo(String str) {
        this.lastCommentAttachInfo = str;
    }

    public final void clear() {
        this.commonFeed = null;
        QzoneEventBus.INSTANCE.unregister(this);
        this.dataUpdateCallback = null;
    }

    public final void unregisterFeedUpdateCallback(IQzoneFeedUpdateCallback callback) {
        this.dataUpdateCallback = null;
    }

    public static /* synthetic */ void fetchFeedDetail$default(QzoneFeedDetailManager qzoneFeedDetailManager, CommonUnionID commonUnionID, String str, String str2, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        qzoneFeedDetailManager.fetchFeedDetail(commonUnionID, str, str2, dataCallback);
    }
}
