package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.fake;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneCommentEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneForwardFeedEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneLikeEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzonePermissionEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneReplyEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneTopEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneBitCheckUtil;
import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLikeKt;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u0004\u0018\u00010\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0002J$\u0010#\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010&\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010'\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0018\u0010(\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010)\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0018\u0010*\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0002J7\u0010+\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020,2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0.H\u0000\u00a2\u0006\u0002\b/J\u0018\u00100\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u00101\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u00102\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0018\u00103\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0016\u00105\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00106\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/fake/QzoneFakeOperateHelper;", "", "()V", "TAG", "", "fakeCommentCache", "", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "checkInsertFakeCommentToFeed", "", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "deleteCommentFromFeed", "comment", "deleteReplyFromComment", "reply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "findFeed", "feedList", "unionID", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "handleCommentEvent", "event", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneCommentEvent;", "handleForwardEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneForwardFeedEvent;", "handleLikeEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneLikeEvent;", "handlePermissionEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzonePermissionEvent;", "handleReplyEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneReplyEvent;", "handleTopEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneTopEvent;", "insertCommentToFeed", "linkedMediaId", "insertReplyToComment", "onAddComment", "onAddReply", "onDeleteComment", "onDeleteReply", "onLikeFeed", "onOperateEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneOperateEvent;", "notifyCallback", "Lkotlin/Function1;", "onOperateEvent$qecommerce_biz_release", "onUnlikeFeed", "onUpdateComment", "onUpdateReply", "removeFakePicComment", "clientKey", "saveFakePicComment", "fakeComment", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFakeOperateHelper {
    public static final String TAG = "QzoneFakeOperateHelper";
    public static final QzoneFakeOperateHelper INSTANCE = new QzoneFakeOperateHelper();
    private static final Map<String, List<CommonComment>> fakeCommentCache = new LinkedHashMap();
    public static final int $stable = 8;

    QzoneFakeOperateHelper() {
    }

    private final void deleteCommentFromFeed(CommonFeed commonFeed, final CommonComment comment) {
        CommonCellComment cellComment = commonFeed.getCellComment();
        if (cellComment != null) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) cellComment.getComments(), (Function1) new Function1<CommonComment, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.fake.QzoneFakeOperateHelper$deleteCommentFromFeed$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(CommonComment commonComment) {
                    return Boolean.valueOf(Intrinsics.areEqual(commonComment.getId(), CommonComment.this.getId()));
                }
            });
            cellComment.setNum(cellComment.getNum() - 1);
        }
    }

    private final void deleteReplyFromComment(CommonFeed commonFeed, CommonComment comment, final CommonReply reply) {
        CommonCellComment cellComment = commonFeed.getCellComment();
        if (cellComment != null) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) comment.getReplys(), (Function1) new Function1<CommonReply, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.fake.QzoneFakeOperateHelper$deleteReplyFromComment$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(CommonReply commonReply) {
                    return Boolean.valueOf(Intrinsics.areEqual(commonReply.getId(), CommonReply.this.getId()));
                }
            });
            comment.setReplyNum(comment.getReplyNum() - 1);
            cellComment.setNum(cellComment.getNum() - 1);
        }
    }

    private final CommonFeed findFeed(List<CommonFeed> feedList, CommonUnionID unionID) {
        Object obj;
        CommonUnionID unionId;
        Iterator<T> it = feedList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            CommonCellCommon cellCommon = ((CommonFeed) next).getCellCommon();
            if (cellCommon != null && (unionId = cellCommon.getUnionId()) != null) {
                obj = unionId.getUfKey();
            }
            if (Intrinsics.areEqual(obj, unionID.getUfKey())) {
                obj = next;
                break;
            }
        }
        return (CommonFeed) obj;
    }

    private final void handleCommentEvent(QzoneCommentEvent event, CommonFeed commonFeed) {
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode == -1054359637) {
            if (action.equals(QzoneDataUpdateAction.DELETE_COMMENT)) {
                onDeleteComment(event, commonFeed);
            }
        } else {
            if (hashCode != 63048833) {
                if (hashCode == 1868788937 && action.equals(QzoneDataUpdateAction.UPDATE_COMMENT)) {
                    onUpdateComment(event, commonFeed);
                    return;
                }
                return;
            }
            if (action.equals(QzoneDataUpdateAction.ADD_COMMENT)) {
                onAddComment(event, commonFeed);
            }
        }
    }

    private final void handleForwardEvent(QzoneForwardFeedEvent event, CommonFeed commonFeed) {
        if (Intrinsics.areEqual(event.getAction(), QzoneDataUpdateAction.FORWARD_FEED)) {
            commonFeed.setCellForwardInfo(event.getCellForwardInfo());
        }
    }

    private final void handleLikeEvent(QzoneLikeEvent event, CommonFeed commonFeed) {
        String action = event.getAction();
        if (Intrinsics.areEqual(action, QzoneDataUpdateAction.LIKE_FEED)) {
            onLikeFeed(event, commonFeed);
        } else if (Intrinsics.areEqual(action, QzoneDataUpdateAction.UNLIKE_FEED)) {
            onUnlikeFeed(event, commonFeed);
        }
    }

    private final void handlePermissionEvent(QzonePermissionEvent event, CommonFeed commonFeed) {
        commonFeed.setCellPermission(event.getPermission());
        CommonCellCommon cellCommon = commonFeed.getCellCommon();
        if (cellCommon != null) {
            int operateMask = cellCommon.getOperateMask();
            CommonCellCommon cellCommon2 = commonFeed.getCellCommon();
            if (cellCommon2 == null) {
                return;
            }
            cellCommon2.setOperateMask((int) QzoneBitCheckUtil.INSTANCE.disableBit(operateMask, 5));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleReplyEvent(QzoneReplyEvent event, CommonFeed commonFeed) {
        List<CommonComment> comments;
        CommonCellComment cellComment = commonFeed.getCellComment();
        CommonComment commonComment = null;
        if (cellComment != null && (comments = cellComment.getComments()) != null) {
            Iterator<T> it = comments.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((CommonComment) next).getId(), event.getComment().getId())) {
                    commonComment = next;
                    break;
                }
            }
            commonComment = commonComment;
        }
        if (commonComment == null) {
            KLog.INSTANCE.d(TAG, "handleReplyEvent error: cant find comment in list");
            return;
        }
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode == -1660473388) {
            if (action.equals(QzoneDataUpdateAction.UPDATE_REPLY)) {
                onUpdateReply(event, commonComment);
            }
        } else {
            if (hashCode != -1480275146) {
                if (hashCode == -250063476 && action.equals(QzoneDataUpdateAction.ADD_REPLY)) {
                    onAddReply(event, commonFeed, commonComment);
                    return;
                }
                return;
            }
            if (action.equals(QzoneDataUpdateAction.DELETE_REPLY)) {
                onDeleteReply(event, commonFeed, commonComment);
            }
        }
    }

    private final void handleTopEvent(QzoneTopEvent event, CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        String action = event.getAction();
        if (Intrinsics.areEqual(action, QzoneDataUpdateAction.SET_TOP)) {
            CommonCellCommon cellCommon2 = commonFeed.getCellCommon();
            if (cellCommon2 != null) {
                int featureFlag = cellCommon2.getFeatureFlag();
                CommonCellCommon cellCommon3 = commonFeed.getCellCommon();
                if (cellCommon3 == null) {
                    return;
                }
                cellCommon3.setFeatureFlag((int) QzoneBitCheckUtil.INSTANCE.enableBit(featureFlag, 1));
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(action, QzoneDataUpdateAction.SET_UN_TOP) || (cellCommon = commonFeed.getCellCommon()) == null) {
            return;
        }
        int featureFlag2 = cellCommon.getFeatureFlag();
        CommonCellCommon cellCommon4 = commonFeed.getCellCommon();
        if (cellCommon4 == null) {
            return;
        }
        cellCommon4.setFeatureFlag((int) QzoneBitCheckUtil.INSTANCE.disableBit(featureFlag2, 1));
    }

    private final void insertCommentToFeed(CommonFeed commonFeed, CommonComment comment, String linkedMediaId) {
        Object obj;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("insertCommentToFeed, commendFeed@");
        m3.append(commonFeed.hashCode());
        m3.append(", cellComment@");
        m3.append(commonFeed.getCellComment());
        m3.append(", comment@");
        m3.append(comment.hashCode());
        kLog.d(TAG, m3.toString());
        CommonCellComment cellComment = commonFeed.getCellComment();
        if (cellComment != null) {
            Iterator<T> it = cellComment.getComments().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((CommonComment) obj).getClientKey(), comment.getClientKey())) {
                        break;
                    }
                }
            }
            if (((CommonComment) obj) != null) {
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Comment with clientKey ");
                m16.append(comment.getClientKey());
                m16.append(" already exists, skip insertion");
                kLog2.d(TAG, m16.toString());
                return;
            }
            cellComment.getComments().add(comment);
            cellComment.setNum(cellComment.getNum() + 1);
            CommonFeedExtKt.increaseMediaCommentCount(commonFeed, linkedMediaId);
        }
    }

    private final void insertReplyToComment(CommonFeed commonFeed, CommonComment comment, CommonReply reply, String linkedMediaId) {
        Object obj;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("insertReplyToComment, commendFeed@");
        m3.append(commonFeed.hashCode());
        m3.append(", comment@");
        m3.append(comment.hashCode());
        m3.append(", reply: ");
        m3.append(reply.hashCode());
        kLog.d(TAG, m3.toString());
        CommonCellComment cellComment = commonFeed.getCellComment();
        if (cellComment != null) {
            Iterator<T> it = comment.getReplys().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((CommonReply) obj).getClientKey(), reply.getClientKey())) {
                        break;
                    }
                }
            }
            if (((CommonReply) obj) != null) {
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Reply with clientKey ");
                m16.append(reply.getClientKey());
                m16.append(" already exists, skip insertion");
                kLog2.d(TAG, m16.toString());
                return;
            }
            comment.getReplys().add(reply);
            comment.setReplyNum(comment.getReplyNum() + 1);
            cellComment.setNum(cellComment.getNum() + 1);
            CommonFeedExtKt.increaseMediaCommentCount(commonFeed, linkedMediaId);
        }
    }

    private final void onAddComment(QzoneCommentEvent event, CommonFeed commonFeed) {
        insertCommentToFeed(commonFeed, event.getComment(), event.getLinkedMediaId());
    }

    private final void onDeleteComment(QzoneCommentEvent event, CommonFeed commonFeed) {
        deleteCommentFromFeed(commonFeed, event.getComment());
        CommonFeedExtKt.reduceMediaCommentCount(commonFeed, event.getLinkedMediaId());
    }

    private final void onDeleteReply(QzoneReplyEvent event, CommonFeed commonFeed, CommonComment comment) {
        deleteReplyFromComment(commonFeed, comment, event.getReply());
        CommonFeedExtKt.reduceMediaCommentCount(commonFeed, event.getLinkedMediaId());
    }

    private final void onLikeFeed(QzoneLikeEvent event, CommonFeed commonFeed) {
        commonFeed.setCellLike(CommonCellLikeKt.toCommon(CommonCellLikeKt.toPb(event.getCellLike())));
        CommonFeedExtKt.increaseMediaLike(commonFeed, event.getLinkedMediaId());
    }

    private final void onUnlikeFeed(QzoneLikeEvent event, CommonFeed commonFeed) {
        if (CommonFeedExtKt.isSupportMinMediaOperate(commonFeed)) {
            String linkedMediaId = event.getLinkedMediaId();
            if (linkedMediaId == null || linkedMediaId.length() == 0) {
                commonFeed.setCellLike(CommonCellLikeKt.toCommon(CommonCellLikeKt.toPb(event.getCellLike())));
            }
        } else {
            commonFeed.setCellLike(CommonCellLikeKt.toCommon(CommonCellLikeKt.toPb(event.getCellLike())));
        }
        CommonFeedExtKt.reduceMediaLike(commonFeed, event.getLinkedMediaId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        if (r6 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onUpdateComment(QzoneCommentEvent event, CommonFeed commonFeed) {
        List<CommonComment> arrayList;
        List<CommonComment> comments;
        int collectionSizeOrDefault;
        CommonCellComment cellComment = commonFeed.getCellComment();
        if (cellComment == null) {
            return;
        }
        CommonCellComment cellComment2 = commonFeed.getCellComment();
        if (cellComment2 != null && (comments = cellComment2.getComments()) != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(comments, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (CommonComment commonComment : comments) {
                if (Intrinsics.areEqual(commonComment.getClientKey(), event.getComment().getClientKey())) {
                    commonComment = event.getComment();
                }
                arrayList2.add(commonComment);
            }
            arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        }
        arrayList = new ArrayList<>();
        cellComment.setComments(arrayList);
    }

    public final void checkInsertFakeCommentToFeed(CommonFeed commonFeed) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkInsertFakeCommentToFeed, commendFeed@");
        m3.append(commonFeed.hashCode());
        kLog.d(TAG, m3.toString());
        List<CommonComment> list = fakeCommentCache.get(CommonFeedExtKt.getFeedUniqueKey(commonFeed));
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                insertCommentToFeed$default(INSTANCE, commonFeed, (CommonComment) it.next(), null, 4, null);
            }
        }
    }

    public final void onOperateEvent$qecommerce_biz_release(QzoneOperateEvent event, List<CommonFeed> feedList, Function1<? super CommonFeed, Unit> notifyCallback) {
        CommonFeed findFeed = findFeed(feedList, event.getUnionID());
        if (findFeed == null) {
            KLog.INSTANCE.d(TAG, "onOperateEvent error: cant find feed in list");
            return;
        }
        if (event instanceof QzoneCommentEvent) {
            handleCommentEvent((QzoneCommentEvent) event, findFeed);
        } else if (event instanceof QzoneReplyEvent) {
            handleReplyEvent((QzoneReplyEvent) event, findFeed);
        } else if (event instanceof QzoneLikeEvent) {
            handleLikeEvent((QzoneLikeEvent) event, findFeed);
        } else if (event instanceof QzonePermissionEvent) {
            handlePermissionEvent((QzonePermissionEvent) event, findFeed);
        } else if (event instanceof QzoneTopEvent) {
            handleTopEvent((QzoneTopEvent) event, findFeed);
        } else if (event instanceof QzoneForwardFeedEvent) {
            handleForwardEvent((QzoneForwardFeedEvent) event, findFeed);
        }
        notifyCallback.invoke(findFeed);
    }

    public final void removeFakePicComment(CommonUnionID unionID, final String clientKey) {
        KLog kLog = KLog.INSTANCE;
        kLog.d(TAG, "removeFakePicComment, unionID: " + unionID + ", clientKey: " + clientKey);
        String ufKey = unionID.getUfKey();
        if (!(ufKey == null || ufKey.length() == 0)) {
            if (!(clientKey == null || clientKey.length() == 0)) {
                List<CommonComment> list = fakeCommentCache.get(ufKey);
                if (list != null) {
                    CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<CommonComment, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.fake.QzoneFakeOperateHelper$removeFakePicComment$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(CommonComment commonComment) {
                            return Boolean.valueOf(Intrinsics.areEqual(commonComment.getClientKey(), clientKey));
                        }
                    });
                    return;
                }
                return;
            }
        }
        kLog.d(TAG, "removeFakePicComment error: unionId or client key is empty");
    }

    public final void saveFakePicComment(CommonUnionID unionID, CommonComment fakeComment) {
        KLog kLog = KLog.INSTANCE;
        kLog.d(TAG, "saveFakePicComment, unionID: " + unionID + ", comment@" + fakeComment.hashCode());
        String ufKey = unionID.getUfKey();
        if (!(ufKey == null || ufKey.length() == 0)) {
            String clientKey = fakeComment.getClientKey();
            if (!(clientKey == null || clientKey.length() == 0)) {
                Map<String, List<CommonComment>> map = fakeCommentCache;
                List<CommonComment> list = map.get(ufKey);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(ufKey, list);
                }
                list.add(fakeComment);
                return;
            }
        }
        kLog.d(TAG, "saveFakePicComment error: unionId or client key is empty");
    }

    private final void onAddReply(QzoneReplyEvent event, CommonFeed commonFeed, CommonComment comment) {
        if (commonFeed != null) {
            INSTANCE.insertReplyToComment(commonFeed, comment, event.getReply(), event.getLinkedMediaId());
        }
    }

    private final void onUpdateReply(QzoneReplyEvent event, CommonComment comment) {
        int collectionSizeOrDefault;
        List<CommonReply> mutableList;
        if (comment != null) {
            List<CommonReply> replys = comment.getReplys();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(replys, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (CommonReply commonReply : replys) {
                if (Intrinsics.areEqual(commonReply.getClientKey(), event.getReply().getClientKey())) {
                    commonReply = event.getReply();
                }
                arrayList.add(commonReply);
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            comment.setReplys(mutableList);
        }
    }

    public static /* synthetic */ void insertCommentToFeed$default(QzoneFakeOperateHelper qzoneFakeOperateHelper, CommonFeed commonFeed, CommonComment commonComment, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        qzoneFakeOperateHelper.insertCommentToFeed(commonFeed, commonComment, str);
    }
}
