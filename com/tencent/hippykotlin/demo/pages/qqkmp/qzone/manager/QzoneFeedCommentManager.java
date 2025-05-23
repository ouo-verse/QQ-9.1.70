package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCommentKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReplyKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRichMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneCommentEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneReplyEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.fake.QzoneFakeOperateHelper;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddReplyRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteReplyRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedWriteService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneFakeDataUtil;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import oicq.wlogin_sdk.tools.util;
import zz0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002JN\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J@\u0010\u0015\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0013J8\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0018\u001a\u00020\u0019J*\u0010\u001e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0013J2\u0010 \u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001d2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0013J,\u0010#\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedCommentManager;", "", "()V", "writeService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedWriteService;", "addPicComment", "", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "content", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "mediaItems", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "clientKey", "", "isPrivate", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddCommentRsp;", "addReply", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "targetUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddReplyRsp;", "addTextComment", "buildFakeReply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "deleteComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteCommentRsp;", "deleteReply", "reply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteReplyRsp;", "insertFakePicComment", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedCommentManager {
    public static final String TAG = "QzoneFeedCommentManager";
    private QzoneFeedWriteService writeService = new QzoneFeedWriteService();

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0004J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedCommentManager$Companion;", "", "()V", "TAG", "", "buildFakeComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "content", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "mediaItems", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "clientKey", "buildFakeCommentClientKey", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String buildFakeCommentClientKey(CommonUnionID unionId) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fake_");
            m3.append(unionId != null ? unionId.getUfKey() : null);
            m3.append(util.base64_pad_url);
            m3.append(a.f453719a.a());
            return m3.toString();
        }

        public final CommonComment buildFakeComment(CommonUnionID unionId, List<CommonRichMsg> content, List<CommonMedia> mediaItems, String clientKey) {
            CommonComment commonComment = new CommonComment();
            commonComment.setUser(QzoneFakeDataUtil.INSTANCE.buildMasterUser());
            commonComment.setContent(content);
            commonComment.setTime(a.f453719a.a() / 1000);
            if (clientKey.length() > 0) {
                commonComment.setClientKey(clientKey);
            } else {
                commonComment.setClientKey(QzoneFeedCommentManager.INSTANCE.buildFakeCommentClientKey(unionId));
            }
            commonComment.setMediaItems(mediaItems);
            return commonComment;
        }

        Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CommonComment buildFakeComment$default(Companion companion, CommonUnionID commonUnionID, List list, List list2, String str, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                list2 = new ArrayList();
            }
            if ((i3 & 8) != 0) {
                str = "";
            }
            return companion.buildFakeComment(commonUnionID, list, list2, str);
        }
    }

    public final CommonReply buildFakeReply(CommonUnionID unionId, List<CommonRichMsg> content, CommonUser targetUser) {
        CommonReply commonReply = new CommonReply();
        commonReply.setUser(QzoneFakeDataUtil.INSTANCE.buildMasterUser());
        commonReply.setContent(content);
        commonReply.setTime(a.f453719a.a() / 1000);
        commonReply.setClientKey(INSTANCE.buildFakeCommentClientKey(unionId));
        commonReply.setTargetUser(targetUser);
        return commonReply;
    }

    public final String insertFakePicComment(CommonUnionID unionId, List<CommonRichMsg> content, List<CommonMedia> mediaItems) {
        if (unionId == null) {
            KLog.INSTANCE.i(TAG, "addComment error, unionId is null");
            return "";
        }
        CommonComment buildFakeComment$default = Companion.buildFakeComment$default(INSTANCE, unionId, content, mediaItems, null, 8, null);
        QzoneFakeOperateHelper.INSTANCE.saveFakePicComment(unionId, buildFakeComment$default);
        QzoneEventBus.INSTANCE.postEvent(new QzoneCommentEvent(QzoneDataUpdateAction.ADD_COMMENT, unionId, buildFakeComment$default, null, 8, null));
        String clientKey = buildFakeComment$default.getClientKey();
        return clientKey == null ? "" : clientKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment] */
    public final void addPicComment(final CommonUnionID unionId, List<CommonRichMsg> content, List<CommonMedia> mediaItems, String clientKey, boolean isPrivate, final DataCallback<AddCommentRsp> dataCallback) {
        if (unionId == null) {
            KLog.INSTANCE.i(TAG, "addPicComment error, unionId is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId is null");
                return;
            }
            return;
        }
        if (clientKey == null || clientKey.length() == 0) {
            KLog.INSTANCE.i(TAG, "addPicComment error, clientKey is null or empty");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "clientKey is null or empty");
                return;
            }
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? buildFakeComment = INSTANCE.buildFakeComment(unionId, content, mediaItems, clientKey);
        objectRef.element = buildFakeComment;
        this.writeService.addComment(unionId, buildFakeComment, isPrivate, new DataCallback<AddCommentRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager$addPicComment$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                QzoneFakeOperateHelper.INSTANCE.removeFakePicComment(CommonUnionID.this, objectRef.element.getClientKey());
                DataCallback<AddCommentRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(AddCommentRsp rsp, long retCode, String msg2, boolean isFinish) {
                QzoneFakeOperateHelper.INSTANCE.removeFakePicComment(CommonUnionID.this, objectRef.element.getClientKey());
                StComment stComment = rsp.comment;
                if (stComment != null) {
                    QzoneEventBus.INSTANCE.postEvent(new QzoneCommentEvent(QzoneDataUpdateAction.UPDATE_COMMENT, CommonUnionID.this, CommonCommentKt.toCommon(stComment), null, 8, null));
                }
                DataCallback<AddCommentRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void addReply(final CommonUnionID unionId, List<CommonRichMsg> content, final CommonComment comment, CommonUser targetUser, final DataCallback<AddReplyRsp> dataCallback) {
        if (unionId == null) {
            KLog.INSTANCE.i(TAG, "addReply error, unionId is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId is null");
                return;
            }
            return;
        }
        CommonReply buildFakeReply = buildFakeReply(unionId, content, targetUser);
        QzoneEventBus.INSTANCE.postEvent(new QzoneReplyEvent(QzoneDataUpdateAction.ADD_REPLY, unionId, comment, buildFakeReply, null, 16, null));
        this.writeService.addReply(unionId, comment, buildFakeReply, new DataCallback<AddReplyRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager$addReply$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                DataCallback<AddReplyRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(AddReplyRsp rsp, long retCode, String msg2, boolean isFinish) {
                StReply stReply = rsp.reply;
                if (stReply != null) {
                    QzoneEventBus.INSTANCE.postEvent(new QzoneReplyEvent(QzoneDataUpdateAction.UPDATE_REPLY, unionId, comment, CommonReplyKt.toCommon(stReply), null, 16, null));
                }
                DataCallback<AddReplyRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void deleteComment(CommonUnionID unionId, CommonComment comment, final DataCallback<DeleteCommentRsp> dataCallback) {
        if (unionId == null) {
            KLog.INSTANCE.i(TAG, "deleteComment error, unionId is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId is null");
                return;
            }
            return;
        }
        QzoneEventBus.INSTANCE.postEvent(new QzoneCommentEvent(QzoneDataUpdateAction.DELETE_COMMENT, unionId, comment, null, 8, null));
        this.writeService.deleteComment(unionId, comment, new DataCallback<DeleteCommentRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager$deleteComment$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                DataCallback<DeleteCommentRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(DeleteCommentRsp rsp, long retCode, String msg2, boolean isFinish) {
                DataCallback<DeleteCommentRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void deleteReply(CommonUnionID unionId, CommonComment comment, CommonReply reply, final DataCallback<DeleteReplyRsp> dataCallback) {
        if (unionId == null) {
            KLog.INSTANCE.i(TAG, "deleteReply error, unionId is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId is null");
                return;
            }
            return;
        }
        QzoneEventBus.INSTANCE.postEvent(new QzoneReplyEvent(QzoneDataUpdateAction.DELETE_REPLY, unionId, comment, reply, null, 16, null));
        this.writeService.deleteReply(unionId, comment, reply, new DataCallback<DeleteReplyRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager$deleteReply$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                DataCallback<DeleteReplyRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(DeleteReplyRsp rsp, long retCode, String msg2, boolean isFinish) {
                DataCallback<DeleteReplyRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addTextComment$default(QzoneFeedCommentManager qzoneFeedCommentManager, CommonUnionID commonUnionID, List list, boolean z16, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            dataCallback = null;
        }
        qzoneFeedCommentManager.addTextComment(commonUnionID, list, z16, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deleteComment$default(QzoneFeedCommentManager qzoneFeedCommentManager, CommonUnionID commonUnionID, CommonComment commonComment, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            dataCallback = null;
        }
        qzoneFeedCommentManager.deleteComment(commonUnionID, commonComment, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deleteReply$default(QzoneFeedCommentManager qzoneFeedCommentManager, CommonUnionID commonUnionID, CommonComment commonComment, CommonReply commonReply, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            dataCallback = null;
        }
        qzoneFeedCommentManager.deleteReply(commonUnionID, commonComment, commonReply, dataCallback);
    }

    public final void addTextComment(final CommonUnionID unionId, List<CommonRichMsg> content, boolean isPrivate, final DataCallback<AddCommentRsp> dataCallback) {
        if (unionId == null) {
            KLog.INSTANCE.i(TAG, "addTextComment error, unionId is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "unionId is null");
                return;
            }
            return;
        }
        CommonComment buildFakeComment$default = Companion.buildFakeComment$default(INSTANCE, unionId, content, null, null, 12, null);
        QzoneEventBus.INSTANCE.postEvent(new QzoneCommentEvent(QzoneDataUpdateAction.ADD_COMMENT, unionId, buildFakeComment$default, null, 8, null));
        this.writeService.addComment(unionId, buildFakeComment$default, isPrivate, new DataCallback<AddCommentRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager$addTextComment$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                DataCallback<AddCommentRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(AddCommentRsp rsp, long retCode, String msg2, boolean isFinish) {
                StComment stComment = rsp.comment;
                if (stComment != null) {
                    QzoneEventBus.INSTANCE.postEvent(new QzoneCommentEvent(QzoneDataUpdateAction.UPDATE_COMMENT, unionId, CommonCommentKt.toCommon(stComment), null, 8, null));
                }
                DataCallback<AddCommentRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
            }
        });
    }

    public static /* synthetic */ void addReply$default(QzoneFeedCommentManager qzoneFeedCommentManager, CommonUnionID commonUnionID, List list, CommonComment commonComment, CommonUser commonUser, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            dataCallback = null;
        }
        qzoneFeedCommentManager.addReply(commonUnionID, list, commonComment, commonUser, dataCallback);
    }

    public static /* synthetic */ void addPicComment$default(QzoneFeedCommentManager qzoneFeedCommentManager, CommonUnionID commonUnionID, List list, List list2, String str, boolean z16, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            dataCallback = null;
        }
        qzoneFeedCommentManager.addPicComment(commonUnionID, list, list2, str, z16, dataCallback);
    }
}
