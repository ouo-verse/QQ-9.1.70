package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLikeMan;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneLikeEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.UnLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedWriteService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneFakeDataUtil;
import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLike;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.log.KLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\"\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fJ\"\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fJ*\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedLikeManager;", "", "()V", "writeService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedWriteService;", "likeComment", "", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DoLikeRsp;", "likeFeed", "likeReply", "reply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "unlikeComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/UnLikeRsp;", "unlikeFeed", "unlikeReply", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedLikeManager {
    private QzoneFeedWriteService writeService = new QzoneFeedWriteService();

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedLikeManager$Companion;", "", "()V", "buildFakeCellLike", "Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "curCellLike", "isLike", "", "buildFakeCommonLike", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "curLike", "updateCommentStatusAndNotify", "", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "updateReplyStatusAndNotify", "reply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "updateStatusAndNotify", "linkedMediaId", "", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void updateCommentStatusAndNotify(CommonFeed commonFeed, CommonComment comment, boolean isLike) {
            CommonUnionID unionId;
            String str;
            CommonLike buildFakeCommonLike = buildFakeCommonLike(comment.getLike(), isLike);
            CommonCellCommon cellCommon = commonFeed.getCellCommon();
            if (cellCommon == null || (unionId = cellCommon.getUnionId()) == null) {
                return;
            }
            if (isLike) {
                str = QzoneDataUpdateAction.LIKE_COMMENT;
            } else {
                str = QzoneDataUpdateAction.UNLIKE_COMMENT;
            }
            QzoneEventBus.INSTANCE.postEvent(new QzoneLikeEvent(str, unionId, null, buildFakeCommonLike, null, 20, null));
        }

        public final void updateReplyStatusAndNotify(CommonFeed commonFeed, CommonReply reply, boolean isLike) {
            CommonUnionID unionId;
            String str;
            CommonLike buildFakeCommonLike = buildFakeCommonLike(reply.getLike(), isLike);
            CommonCellCommon cellCommon = commonFeed.getCellCommon();
            if (cellCommon == null || (unionId = cellCommon.getUnionId()) == null) {
                return;
            }
            if (isLike) {
                str = QzoneDataUpdateAction.LIKE_REPLY;
            } else {
                str = QzoneDataUpdateAction.UNLIKE_REPLY;
            }
            QzoneEventBus.INSTANCE.postEvent(new QzoneLikeEvent(str, unionId, null, buildFakeCommonLike, null, 20, null));
        }

        public final void updateStatusAndNotify(CommonFeed commonFeed, boolean isLike, String linkedMediaId) {
            CommonUnionID unionId;
            String str;
            CommonCellLike buildFakeCellLike = buildFakeCellLike(commonFeed.getCellLike(), isLike);
            CommonCellCommon cellCommon = commonFeed.getCellCommon();
            if (cellCommon == null || (unionId = cellCommon.getUnionId()) == null) {
                return;
            }
            if (isLike) {
                str = QzoneDataUpdateAction.LIKE_FEED;
            } else {
                str = QzoneDataUpdateAction.UNLIKE_FEED;
            }
            QzoneEventBus.INSTANCE.postEvent(new QzoneLikeEvent(str, unionId, buildFakeCellLike, null, linkedMediaId, 8, null));
        }

        Companion() {
        }

        public final CommonCellLike buildFakeCellLike(CommonCellLike curCellLike, boolean isLike) {
            Object obj;
            if (curCellLike == null) {
                curCellLike = new CommonCellLike();
            }
            if (isLike) {
                Iterator<T> it = curCellLike.likeMans.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    CommonUser user = ((CommonLikeMan) next).getUser();
                    if (Intrinsics.areEqual(user != null ? user.getUin() : null, QZoneComposePlatformModule.Companion.getUin())) {
                        obj = next;
                        break;
                    }
                }
                if (((CommonLikeMan) obj) == null) {
                    curCellLike.num++;
                    curCellLike.liked = true;
                    List<CommonLikeMan> list = curCellLike.likeMans;
                    CommonLikeMan commonLikeMan = new CommonLikeMan();
                    commonLikeMan.setUser(QzoneFakeDataUtil.INSTANCE.buildMasterUser());
                    Unit unit = Unit.INSTANCE;
                    list.add(0, commonLikeMan);
                }
            } else {
                curCellLike.num--;
                curCellLike.liked = false;
                CollectionsKt__MutableCollectionsKt.removeAll((List) curCellLike.likeMans, (Function1) new Function1<CommonLikeMan, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager$Companion$buildFakeCellLike$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(CommonLikeMan commonLikeMan2) {
                        CommonUser user2 = commonLikeMan2.getUser();
                        return Boolean.valueOf(Intrinsics.areEqual(user2 != null ? user2.getUin() : null, QZoneComposePlatformModule.Companion.getUin()));
                    }
                });
            }
            return curCellLike;
        }

        public final CommonLike buildFakeCommonLike(CommonLike curLike, boolean isLike) {
            Object obj;
            if (curLike == null) {
                curLike = new CommonLike();
            }
            if (isLike) {
                Iterator<T> it = curLike.getLikeMans().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    CommonUser user = ((CommonLikeMan) next).getUser();
                    if (Intrinsics.areEqual(user != null ? user.getUin() : null, QZoneComposePlatformModule.Companion.getUin())) {
                        obj = next;
                        break;
                    }
                }
                if (((CommonLikeMan) obj) == null) {
                    curLike.setCount(curLike.getCount() + 1);
                    curLike.setStatus(1);
                    List<CommonLikeMan> likeMans = curLike.getLikeMans();
                    CommonLikeMan commonLikeMan = new CommonLikeMan();
                    commonLikeMan.setUser(QzoneFakeDataUtil.INSTANCE.buildMasterUser());
                    Unit unit = Unit.INSTANCE;
                    likeMans.add(0, commonLikeMan);
                }
            } else {
                curLike.setCount(curLike.getCount() - 1);
                curLike.setStatus(0);
                CollectionsKt__MutableCollectionsKt.removeAll((List) curLike.getLikeMans(), (Function1) new Function1<CommonLikeMan, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager$Companion$buildFakeCommonLike$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(CommonLikeMan commonLikeMan2) {
                        CommonUser user2 = commonLikeMan2.getUser();
                        return Boolean.valueOf(Intrinsics.areEqual(user2 != null ? user2.getUin() : null, QZoneComposePlatformModule.Companion.getUin()));
                    }
                });
            }
            return curLike;
        }

        public static /* synthetic */ void updateStatusAndNotify$default(Companion companion, CommonFeed commonFeed, boolean z16, String str, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            companion.updateStatusAndNotify(commonFeed, z16, str);
        }
    }

    public final void likeFeed(final CommonFeed commonFeed, final DataCallback<DoLikeRsp> dataCallback) {
        if (commonFeed == null) {
            KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "likeFeed error, commonFeed is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "commonFeed is null");
                return;
            }
            return;
        }
        CommonCellLike cellLike = commonFeed.getCellLike();
        if (cellLike != null && cellLike.liked) {
            KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "likeFeed error, already like");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "already like");
                return;
            }
            return;
        }
        CommonCellCommon cellCommon = commonFeed.getCellCommon();
        CommonUnionID unionId = cellCommon != null ? cellCommon.getUnionId() : null;
        CommonCellCommon cellCommon2 = commonFeed.getCellCommon();
        String curLikeKey = cellCommon2 != null ? cellCommon2.getCurLikeKey() : null;
        Companion.updateStatusAndNotify$default(INSTANCE, commonFeed, true, null, 4, null);
        this.writeService.doLike(unionId, curLikeKey, 1, new DataCallback<DoLikeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager$likeFeed$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                QzoneFeedLikeManager.Companion.updateStatusAndNotify$default(QzoneFeedLikeManager.INSTANCE, commonFeed, false, null, 4, null);
                DataCallback<DoLikeRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(DoLikeRsp rsp, long retCode, String msg2, boolean isFinish) {
                DataCallback<DoLikeRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void unlikeFeed(final CommonFeed commonFeed, final DataCallback<UnLikeRsp> dataCallback) {
        if (commonFeed == null) {
            KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "unlikeFeed error, commonFeed is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "commonFeed is null");
                return;
            }
            return;
        }
        CommonCellLike cellLike = commonFeed.getCellLike();
        if ((cellLike == null || cellLike.liked) ? false : true) {
            KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "unlikeFeed error, already unlike");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "already unlike");
                return;
            }
            return;
        }
        CommonCellCommon cellCommon = commonFeed.getCellCommon();
        CommonUnionID unionId = cellCommon != null ? cellCommon.getUnionId() : null;
        CommonCellCommon cellCommon2 = commonFeed.getCellCommon();
        String curLikeKey = cellCommon2 != null ? cellCommon2.getCurLikeKey() : null;
        Companion.updateStatusAndNotify$default(INSTANCE, commonFeed, false, null, 4, null);
        this.writeService.unlike(unionId, curLikeKey, 1, new DataCallback<UnLikeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager$unlikeFeed$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                QzoneFeedLikeManager.Companion.updateStatusAndNotify$default(QzoneFeedLikeManager.INSTANCE, commonFeed, true, null, 4, null);
                DataCallback<UnLikeRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(UnLikeRsp rsp, long retCode, String msg2, boolean isFinish) {
                DataCallback<UnLikeRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void likeComment(final CommonFeed commonFeed, final CommonComment comment, final DataCallback<DoLikeRsp> dataCallback) {
        CommonCellCommon cellCommon;
        CommonUnionID unionId = (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) ? null : cellCommon.getUnionId();
        if (comment != null && unionId != null) {
            CommonLike like = comment.getLike();
            if (like != null && like.getStatus() == 1) {
                KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "likeComment error, already like, unionId: " + unionId + ", comment: " + comment);
                if (dataCallback != null) {
                    dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "already like");
                    return;
                }
                return;
            }
            CommonLike like2 = comment.getLike();
            String id5 = like2 != null ? like2.getId() : null;
            INSTANCE.updateCommentStatusAndNotify(commonFeed, comment, true);
            this.writeService.doLike(unionId, id5, 2, new DataCallback<DoLikeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager$likeComment$1
                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onFailure(long errorCode, String errorMsg) {
                    QzoneFeedLikeManager.INSTANCE.updateCommentStatusAndNotify(commonFeed, comment, false);
                    DataCallback<DoLikeRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onFailure(errorCode, errorMsg);
                    }
                }

                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onSuccess(DoLikeRsp rsp, long retCode, String msg2, boolean isFinish) {
                    DataCallback<DoLikeRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                    }
                }
            });
            return;
        }
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "likeComment error, unionId: " + unionId + ", comment: " + comment);
        if (dataCallback != null) {
            dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId or comment is null");
        }
    }

    public final void likeReply(final CommonFeed commonFeed, final CommonReply reply, final DataCallback<DoLikeRsp> dataCallback) {
        CommonCellCommon cellCommon;
        CommonUnionID unionId = (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) ? null : cellCommon.getUnionId();
        if (reply != null && unionId != null) {
            CommonLike like = reply.getLike();
            if (like != null && like.getStatus() == 1) {
                KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "likeReply error, already like, unionId: " + unionId + ", reply: " + reply);
                if (dataCallback != null) {
                    dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "already like");
                    return;
                }
                return;
            }
            CommonLike like2 = reply.getLike();
            String id5 = like2 != null ? like2.getId() : null;
            INSTANCE.updateReplyStatusAndNotify(commonFeed, reply, true);
            this.writeService.doLike(unionId, id5, 3, new DataCallback<DoLikeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager$likeReply$1
                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onFailure(long errorCode, String errorMsg) {
                    QzoneFeedLikeManager.INSTANCE.updateReplyStatusAndNotify(commonFeed, reply, false);
                    DataCallback<DoLikeRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onFailure(errorCode, errorMsg);
                    }
                }

                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onSuccess(DoLikeRsp rsp, long retCode, String msg2, boolean isFinish) {
                    DataCallback<DoLikeRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                    }
                }
            });
            return;
        }
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "likeReply error, unionId: " + unionId + ", reply: " + reply);
        if (dataCallback != null) {
            dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId or reply is null");
        }
    }

    public final void unlikeComment(final CommonFeed commonFeed, final CommonComment comment, final DataCallback<UnLikeRsp> dataCallback) {
        CommonCellCommon cellCommon;
        CommonUnionID unionId = (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) ? null : cellCommon.getUnionId();
        if (comment != null && unionId != null) {
            CommonLike like = comment.getLike();
            if (like != null && like.getStatus() == 0) {
                KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "likeComment error, already unlike, unionId: " + unionId + ", comment: " + comment);
                if (dataCallback != null) {
                    dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "already unlike");
                    return;
                }
                return;
            }
            CommonLike like2 = comment.getLike();
            String id5 = like2 != null ? like2.getId() : null;
            INSTANCE.updateCommentStatusAndNotify(commonFeed, comment, false);
            this.writeService.unlike(unionId, id5, 2, new DataCallback<UnLikeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager$unlikeComment$1
                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onFailure(long errorCode, String errorMsg) {
                    QzoneFeedLikeManager.INSTANCE.updateCommentStatusAndNotify(commonFeed, comment, true);
                    DataCallback<UnLikeRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onFailure(errorCode, errorMsg);
                    }
                }

                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onSuccess(UnLikeRsp rsp, long retCode, String msg2, boolean isFinish) {
                    DataCallback<UnLikeRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                    }
                }
            });
            return;
        }
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "likeComment error, unionId: " + unionId + ", comment: " + comment);
        if (dataCallback != null) {
            dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId or comment is null");
        }
    }

    public final void unlikeReply(final CommonFeed commonFeed, final CommonReply reply, final DataCallback<UnLikeRsp> dataCallback) {
        CommonCellCommon cellCommon;
        CommonUnionID unionId = (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) ? null : cellCommon.getUnionId();
        if (reply != null && unionId != null) {
            CommonLike like = reply.getLike();
            if (like != null && like.getStatus() == 0) {
                KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "unlikeReply error, already unlike, unionId: " + unionId + ", reply: " + reply);
                if (dataCallback != null) {
                    dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "already unlike");
                    return;
                }
                return;
            }
            CommonLike like2 = reply.getLike();
            String id5 = like2 != null ? like2.getId() : null;
            INSTANCE.updateReplyStatusAndNotify(commonFeed, reply, false);
            this.writeService.unlike(unionId, id5, 3, new DataCallback<UnLikeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager$unlikeReply$1
                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onFailure(long errorCode, String errorMsg) {
                    QzoneFeedLikeManager.INSTANCE.updateReplyStatusAndNotify(commonFeed, reply, true);
                    DataCallback<UnLikeRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onFailure(errorCode, errorMsg);
                    }
                }

                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onSuccess(UnLikeRsp rsp, long retCode, String msg2, boolean isFinish) {
                    DataCallback<UnLikeRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                    }
                }
            });
            return;
        }
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "unlikeReply error, unionId: " + unionId + ", reply: " + reply);
        if (dataCallback != null) {
            dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId or reply is null");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void likeComment$default(QzoneFeedLikeManager qzoneFeedLikeManager, CommonFeed commonFeed, CommonComment commonComment, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            dataCallback = null;
        }
        qzoneFeedLikeManager.likeComment(commonFeed, commonComment, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void likeFeed$default(QzoneFeedLikeManager qzoneFeedLikeManager, CommonFeed commonFeed, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dataCallback = null;
        }
        qzoneFeedLikeManager.likeFeed(commonFeed, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void likeReply$default(QzoneFeedLikeManager qzoneFeedLikeManager, CommonFeed commonFeed, CommonReply commonReply, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            dataCallback = null;
        }
        qzoneFeedLikeManager.likeReply(commonFeed, commonReply, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void unlikeComment$default(QzoneFeedLikeManager qzoneFeedLikeManager, CommonFeed commonFeed, CommonComment commonComment, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            dataCallback = null;
        }
        qzoneFeedLikeManager.unlikeComment(commonFeed, commonComment, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void unlikeFeed$default(QzoneFeedLikeManager qzoneFeedLikeManager, CommonFeed commonFeed, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dataCallback = null;
        }
        qzoneFeedLikeManager.unlikeFeed(commonFeed, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void unlikeReply$default(QzoneFeedLikeManager qzoneFeedLikeManager, CommonFeed commonFeed, CommonReply commonReply, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            dataCallback = null;
        }
        qzoneFeedLikeManager.unlikeReply(commonFeed, commonReply, dataCallback);
    }
}
