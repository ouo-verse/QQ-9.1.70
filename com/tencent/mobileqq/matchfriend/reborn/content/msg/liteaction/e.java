package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$DeleteInterMsgReq;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$DeleteInterMsgRsp;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$GetInterMsgListReq;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$GetInterMsgListRsp;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$MsgMetaInfo;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$ReadedReportReq;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$ReadedReportRsp;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b@\u0010AJH\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042.\u0010\f\u001a*\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bH\u0002J8\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\bH\u0002JJ\u0010\u001e\u001a\u00020\u000b2.\u0010\f\u001a*\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0012\u001a\u00020\u0011J\u001e\u0010#\u001a\u00020\u000b2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ6\u0010$\u001a\u00020\u000b2.\u0010\f\u001a*\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006J\u0006\u0010%\u001a\u00020\u000bJ(\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\nJ\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010*\u001a\u00020)J(\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\n2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R&\u00105\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010=R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010;\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/e;", "", "Lcom/tencent/trpcprotocol/kuolie/interactivemsg/interactive_msg_service/InteractiveMsgServicePB$GetInterMsgListReq;", "req", "Lcom/tencent/relation/common/servlet/a;", "handler", "Lkotlin/Function3;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "Lkotlin/collections/ArrayList;", "", "", "cb", "k", "Lcom/tencent/trpcprotocol/kuolie/interactivemsg/interactive_msg_service/InteractiveMsgServicePB$MsgMetaInfo;", "info", "y", "", "uid", "model", "e", "", "peerTinyId", "feedId", "curModels", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "curModel", "r", "isFinish", "isFirstScreen", "g", "o", ReportConstant.COSTREPORT_PREFIX, "j", IQQGameCommApi.K_ABTEST_MODELS, HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "isFromLiteActionList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "position", "f", "notifyUI", "Lkotlin/Function1;", "u", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/k;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/k;", "mockData", "b", "Ljava/util/ArrayList;", "cacheModel", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "userIdToMsgIdMap", "d", "Z", "fullSyncComplete", "J", "endTime", "isDestroy", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static Map<String, ArrayList<QQStrangerLiteActionModel>> f244578h = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final k mockData = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ArrayList<QQStrangerLiteActionModel> cacheModel = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, String> userIdToMsgIdMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean fullSyncComplete;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR2\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/e$a;", "", "", "msgTime", "", "a", "", "MAX_SIZE", "I", "SEPARATOR", "Ljava/lang/String;", "TAG", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "Lkotlin/collections/ArrayList;", "cachedModelMap", "Ljava/util/Map;", "", "isMockEnable", "Z", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.e$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(long msgTime) {
            String r16 = en.r(new StringBuffer(25), 1000 * msgTime, true, "", true);
            Intrinsics.checkNotNullExpressionValue(r16, "getRecentMessageDateTime\u2026       true\n            )");
            return r16;
        }

        Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean e(String uid, QQStrangerLiteActionModel model) {
        boolean z16;
        if (!com.tencent.mobileqq.matchfriend.reborn.utils.h.b(uid, model.getPeerTinyId(), model.getMsgInfo().getFeedId())) {
            if ((model.getInteractiveOption().getQuickReplyText().length() > 0) && !model.getMsgInfo().getIsFeedDeleted() && Intrinsics.areEqual(com.tencent.mobileqq.matchfriend.utils.b.d().j(), model.getMsgInfo().getFeedOwnerUid())) {
                z16 = true;
                if (QLog.isColorLevel()) {
                    QLog.d("QQStrangerLiteActionDataCenter", 2, "summary: " + model.getSummary() + ", hasUserUseQuickReply " + com.tencent.mobileqq.matchfriend.reborn.utils.h.b(uid, model.getPeerTinyId(), model.getMsgInfo().getFeedId()));
                }
                return (z16 || (model.getSceneId() != 8)) ? false : true;
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        if (z16) {
        }
    }

    private final void g(final Function3<? super ArrayList<QQStrangerLiteActionModel>, ? super Boolean, ? super Boolean, Unit> cb5, final boolean isFinish, final boolean isFirstScreen) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.d
            @Override // java.lang.Runnable
            public final void run() {
                e.i(Function3.this, this, isFinish, isFirstScreen);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function3 cb5, e this$0, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cb5.invoke(this$0.cacheModel, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    private final void k(InteractiveMsgServicePB$GetInterMsgListReq req, com.tencent.relation.common.servlet.a handler, final Function3<? super ArrayList<QQStrangerLiteActionModel>, ? super Boolean, ? super Boolean, Unit> cb5) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        final String currentUid = appInterface.getCurrentUid();
        handler.Z0("QQStranger.InteractiveMsgSvr.SsoGetInterMsgList", req.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.a
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                e.l(e.this, cb5, currentUid, i3, z16, obj);
            }
        });
    }

    private final void o() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        String uid = appInterface.getCurrentUid();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        Iterator<T> it = j(uid).iterator();
        while (it.hasNext()) {
            ((QQStrangerLiteActionModel) it.next()).o(true);
        }
        Iterator<T> it5 = this.cacheModel.iterator();
        while (it5.hasNext()) {
            ((QQStrangerLiteActionModel) it5.next()).o(true);
        }
    }

    private final boolean r(String uid, QQStrangerLiteActionModel curModel) {
        String str = curModel.getPeerTinyId() + "_" + curModel.getMsgInfo().getFeedId();
        if (!e(uid, curModel)) {
            return false;
        }
        if (this.userIdToMsgIdMap.containsKey(str)) {
            QLog.d("QQStrangerLiteActionDataCenter", 2, "Already exists " + str + ".");
            return false;
        }
        this.userIdToMsgIdMap.put(str, curModel.getMsgId());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        int collectionSizeOrDefault;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        String uid = appInterface.getCurrentUid();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        ArrayList<QQStrangerLiteActionModel> j3 = j(uid);
        ArrayList arrayList = new ArrayList();
        for (Object obj : j3) {
            if (((QQStrangerLiteActionModel) obj).getIsCommentDeleted()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((QQStrangerLiteActionModel) it.next()).getMsgId());
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerLiteActionDataCenter", 2, "The removed ids of the read and deleted reply messages: " + arrayList2);
        }
        ArrayList<QQStrangerLiteActionModel> j16 = j(uid);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : j16) {
            if (!((QQStrangerLiteActionModel) obj2).getIsCommentDeleted()) {
                arrayList3.add(obj2);
            }
        }
        f244578h.put(uid, arrayList3);
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        InteractiveMsgServicePB$DeleteInterMsgReq interactiveMsgServicePB$DeleteInterMsgReq = new InteractiveMsgServicePB$DeleteInterMsgReq();
        interactiveMsgServicePB$DeleteInterMsgReq.msg_ids.set(arrayList2);
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.InteractiveMsgSvr.SsoDeleteInterMsg", interactiveMsgServicePB$DeleteInterMsgReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.c
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj3) {
                e.t(i3, z16, obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(int i3, boolean z16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerLiteActionDataCenter", 2, "[SsoDeleteInterMsg after ListPart is destroyed] isSuccess=" + z16 + ".");
        }
        if (z16 && (obj instanceof byte[])) {
            InteractiveMsgServicePB$DeleteInterMsgRsp interactiveMsgServicePB$DeleteInterMsgRsp = new InteractiveMsgServicePB$DeleteInterMsgRsp();
            try {
                interactiveMsgServicePB$DeleteInterMsgRsp.mergeFrom((byte[]) obj);
                if (interactiveMsgServicePB$DeleteInterMsgRsp.rsp_head.ret_code.get() != 0) {
                    return;
                }
                QLog.i("QQStrangerLiteActionDataCenter", 1, "[SsoDeleteInterMsg after ListPart is destroyed] fail_list=" + interactiveMsgServicePB$DeleteInterMsgRsp.msg_ids_del_failed.get());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerLiteActionDataCenter", 2, "[SsoDeleteInterMsg after ListPart is destroyed] error: ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 function1, int i3, boolean z16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerLiteActionDataCenter", 2, "[SsoReadedReport] isSuccess=" + z16);
        }
        if (!z16 || !(obj instanceof byte[])) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        InteractiveMsgServicePB$ReadedReportRsp interactiveMsgServicePB$ReadedReportRsp = new InteractiveMsgServicePB$ReadedReportRsp();
        try {
            interactiveMsgServicePB$ReadedReportRsp.mergeFrom((byte[]) obj);
            if (interactiveMsgServicePB$ReadedReportRsp.rsp_head.ret_code.get() != 0) {
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                    return;
                }
                return;
            }
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            QLog.i("QQStrangerLiteActionDataCenter", 1, "[SsoReadedReport],retCod=" + interactiveMsgServicePB$ReadedReportRsp.rsp_head.ret_code.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QQStrangerLiteActionDataCenter", 2, "[SsoReadedReport] error: ", e16);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }
    }

    private final void z(String uid, long peerTinyId, String feedId, ArrayList<QQStrangerLiteActionModel> curModels) {
        ArrayList<QQStrangerLiteActionModel> arrayList = new ArrayList();
        Iterator<T> it = curModels.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            QQStrangerLiteActionModel qQStrangerLiteActionModel = (QQStrangerLiteActionModel) next;
            if (qQStrangerLiteActionModel.getPeerTinyId() == peerTinyId && Intrinsics.areEqual(qQStrangerLiteActionModel.getMsgInfo().getFeedId(), feedId)) {
                arrayList.add(next);
            }
        }
        boolean z16 = false;
        for (QQStrangerLiteActionModel qQStrangerLiteActionModel2 : arrayList) {
            qQStrangerLiteActionModel2.getInteractiveOption().d(!z16 && e(uid, qQStrangerLiteActionModel2));
            if (!z16) {
                z16 = qQStrangerLiteActionModel2.getInteractiveOption().getCanShowQuickReply();
            }
        }
    }

    public final ArrayList<QQStrangerLiteActionModel> j(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Map<String, ArrayList<QQStrangerLiteActionModel>> map = f244578h;
        ArrayList<QQStrangerLiteActionModel> arrayList = map.get(uid);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(uid, arrayList);
        }
        return arrayList;
    }

    public final ArrayList<QQStrangerLiteActionModel> m(QQStrangerLiteActionModel item, boolean isFromLiteActionList) {
        Intrinsics.checkNotNullParameter(item, "item");
        ArrayList<QQStrangerLiteActionModel> arrayList = this.cacheModel;
        arrayList.add(0, item);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return arrayList;
        }
        String uid = appInterface.getCurrentUid();
        if (!isFromLiteActionList) {
            return arrayList;
        }
        Map<String, ArrayList<QQStrangerLiteActionModel>> map = f244578h;
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        map.put(uid, arrayList);
        ArrayList<QQStrangerLiteActionModel> arrayList2 = f244578h.get(uid);
        if (arrayList2 != null) {
            z(uid, item.getPeerTinyId(), item.getMsgInfo().getFeedId(), arrayList2);
        }
        if (QLog.isColorLevel()) {
            ArrayList<QQStrangerLiteActionModel> arrayList3 = f244578h.get(uid);
            QLog.d("QQStrangerLiteActionDataCenter", 2, "After add data " + item + ". The size is " + (arrayList3 != null ? Integer.valueOf(arrayList3.size()) : null));
        }
        ArrayList<QQStrangerLiteActionModel> arrayList4 = f244578h.get(uid);
        return arrayList4 == null ? arrayList : arrayList4;
    }

    public final void q(Function3<? super ArrayList<QQStrangerLiteActionModel>, ? super Boolean, ? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppSetting.isDebugVersion();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        String uid = appInterface.getCurrentUid();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        ArrayList<QQStrangerLiteActionModel> j3 = j(uid);
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) businessHandler;
        InteractiveMsgServicePB$GetInterMsgListReq interactiveMsgServicePB$GetInterMsgListReq = new InteractiveMsgServicePB$GetInterMsgListReq();
        interactiveMsgServicePB$GetInterMsgListReq.end_time.set(this.endTime);
        PBUInt32Field pBUInt32Field = interactiveMsgServicePB$GetInterMsgListReq.max_size;
        int i3 = 12;
        if (this.endTime == 0 && (!j3.isEmpty())) {
            i3 = 12 + j3.size();
        }
        pBUInt32Field.set(i3);
        k(interactiveMsgServicePB$GetInterMsgListReq, aVar, cb5);
    }

    public final void u(boolean notifyUI, final Function1<? super Boolean, Unit> cb5) {
        q.f244623a.e(notifyUI);
        o();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        InteractiveMsgServicePB$ReadedReportReq interactiveMsgServicePB$ReadedReportReq = new InteractiveMsgServicePB$ReadedReportReq();
        interactiveMsgServicePB$ReadedReportReq.readed_time.set(System.currentTimeMillis() / 1000);
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.InteractiveMsgSvr.SsoReadedReport", interactiveMsgServicePB$ReadedReportReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.b
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                e.w(Function1.this, i3, z16, obj);
            }
        });
    }

    public final void x(ArrayList<QQStrangerLiteActionModel> models) {
        Intrinsics.checkNotNullParameter(models, "models");
        this.cacheModel = models;
    }

    public final void p() {
        v(this, false, null, 3, null);
        s();
        o();
        this.isDestroy = true;
    }

    private final void y(InteractiveMsgServicePB$MsgMetaInfo info) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        String uid = appInterface.getCurrentUid();
        String str = info.msg_id.get();
        boolean z16 = info.is_read.get();
        String str2 = info.peer_mini_profile.open_id.get();
        long j3 = info.peer_mini_profile.tiny_id.get();
        String str3 = info.peer_mini_profile.avatar.get();
        String str4 = info.peer_mini_profile.nick.get();
        String str5 = info.summary.get();
        String a16 = INSTANCE.a(info.msg_time.get());
        int i3 = info.inter_emoj_id.get();
        long j16 = info.feed_meta.feed_id.get();
        String str6 = info.msg_info.feed_id.get();
        Intrinsics.checkNotNullExpressionValue(str6, "info.msg_info.feed_id.get()");
        int i16 = info.msg_info.feed_source.get();
        String str7 = info.msg_info.content.get();
        Intrinsics.checkNotNullExpressionValue(str7, "info.msg_info.content.get()");
        String str8 = info.msg_info.pic.get();
        Intrinsics.checkNotNullExpressionValue(str8, "info.msg_info.pic.get()");
        String str9 = info.msg_info.comment_content.get();
        Intrinsics.checkNotNullExpressionValue(str9, "info.msg_info.comment_content.get()");
        String str10 = info.msg_info.comment_id.get();
        Intrinsics.checkNotNullExpressionValue(str10, "info.msg_info.comment_id.get()");
        String str11 = info.msg_info.feed_owner_uid.get();
        Intrinsics.checkNotNullExpressionValue(str11, "info.msg_info.feed_owner_uid.get()");
        String str12 = info.msg_info.reply_id.get();
        Intrinsics.checkNotNullExpressionValue(str12, "info.msg_info.reply_id.get()");
        QQStrangerLiteActionModel.MsgInfo msgInfo = new QQStrangerLiteActionModel.MsgInfo(str6, i16, str7, str8, str9, str10, str11, str12, info.msg_info.is_feed_delete.get() == 1);
        String str13 = info.quick_reply.content.get();
        Intrinsics.checkNotNullExpressionValue(str13, "info.quick_reply.content.get()");
        QQStrangerLiteActionModel.InteractiveOption interactiveOption = new QQStrangerLiteActionModel.InteractiveOption(false, str13, info.quick_reply.interactive_id.get(), 1, null);
        int i17 = info.scene_id.get();
        boolean z17 = info.flag_msg_status.get() == 2;
        boolean z18 = info.is_comment_delete.get() == 1;
        Intrinsics.checkNotNullExpressionValue(str, "get()");
        Intrinsics.checkNotNullExpressionValue(str2, "get()");
        Intrinsics.checkNotNullExpressionValue(str3, "get()");
        Intrinsics.checkNotNullExpressionValue(str4, "get()");
        Intrinsics.checkNotNullExpressionValue(str5, "get()");
        QQStrangerLiteActionModel qQStrangerLiteActionModel = new QQStrangerLiteActionModel(str, z16, str2, j3, str3, str4, str5, a16, i3, j16, i17, msgInfo, z17, z18, interactiveOption);
        QQStrangerLiteActionModel.InteractiveOption interactiveOption2 = qQStrangerLiteActionModel.getInteractiveOption();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        interactiveOption2.d(r(uid, qQStrangerLiteActionModel));
        this.cacheModel.add(qQStrangerLiteActionModel);
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerLiteActionDataCenter", 2, "Model data: " + qQStrangerLiteActionModel);
        }
    }

    public final ArrayList<QQStrangerLiteActionModel> f(int position) {
        ArrayList<QQStrangerLiteActionModel> arrayList = this.cacheModel;
        QQStrangerLiteActionModel qQStrangerLiteActionModel = new QQStrangerLiteActionModel(null, false, null, 0L, null, null, null, null, 0, 0L, 0, null, false, false, null, 32767, null);
        if (position < arrayList.size()) {
            QQStrangerLiteActionModel qQStrangerLiteActionModel2 = arrayList.get(position);
            Intrinsics.checkNotNullExpressionValue(qQStrangerLiteActionModel2, "modelTmp[position]");
            qQStrangerLiteActionModel = qQStrangerLiteActionModel2;
            arrayList.remove(position);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerLiteActionDataCenter", 2, "The delete data: " + qQStrangerLiteActionModel + ".");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return arrayList;
        }
        String uid = appInterface.getCurrentUid();
        if (qQStrangerLiteActionModel.getInteractiveOption().getCanShowQuickReply()) {
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            z(uid, qQStrangerLiteActionModel.getPeerTinyId(), qQStrangerLiteActionModel.getMsgInfo().getFeedId(), arrayList);
        }
        if (this.fullSyncComplete) {
            Map<String, ArrayList<QQStrangerLiteActionModel>> map = f244578h;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            map.put(uid, arrayList);
        } else {
            ArrayList<QQStrangerLiteActionModel> arrayList2 = f244578h.get(uid);
            if (arrayList2 != null && position < arrayList2.size()) {
                arrayList2.remove(position);
            }
        }
        if (QLog.isColorLevel()) {
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            QLog.d("QQStrangerLiteActionDataCenter", 2, "The cached data size is " + j(uid).size() + ", the model size " + arrayList.size());
        }
        ArrayList<QQStrangerLiteActionModel> arrayList3 = f244578h.get(uid);
        return arrayList3 == null ? arrayList : arrayList3;
    }

    static /* synthetic */ void h(e eVar, Function3 function3, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        eVar.g(function3, z16, z17);
    }

    public static /* synthetic */ ArrayList n(e eVar, QQStrangerLiteActionModel qQStrangerLiteActionModel, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return eVar.m(qQStrangerLiteActionModel, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, Function3 cb5, String uid, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerLiteActionDataCenter", 2, "[SsoGetInterMsgList] isSuccess=" + z16);
        }
        if (z16 && (obj instanceof byte[]) && !this$0.isDestroy) {
            InteractiveMsgServicePB$GetInterMsgListRsp interactiveMsgServicePB$GetInterMsgListRsp = new InteractiveMsgServicePB$GetInterMsgListRsp();
            try {
                interactiveMsgServicePB$GetInterMsgListRsp.mergeFrom((byte[]) obj);
                if (interactiveMsgServicePB$GetInterMsgListRsp.rsp_head.ret_code.get() != 0) {
                    QLog.i("QQStrangerLiteActionDataCenter", 2, "[SsoGetInterMsgList] retCode:" + interactiveMsgServicePB$GetInterMsgListRsp.rsp_head.ret_code.get());
                    h(this$0, cb5, true, false, 4, null);
                    return;
                }
                if (interactiveMsgServicePB$GetInterMsgListRsp.msg_meta_info.size() == 0) {
                    QLog.i("QQStrangerLiteActionDataCenter", 2, "[SsoGetInterMsgList] emptyList");
                    h(this$0, cb5, true, false, 4, null);
                    return;
                }
                for (InteractiveMsgServicePB$MsgMetaInfo pbInfo : new ArrayList(interactiveMsgServicePB$GetInterMsgListRsp.msg_meta_info.get())) {
                    if (pbInfo != null) {
                        Intrinsics.checkNotNullExpressionValue(pbInfo, "pbInfo");
                        this$0.y(pbInfo);
                    }
                }
                if (this$0.endTime == 0) {
                    int min = Math.min(this$0.cacheModel.size(), 12);
                    Map<String, ArrayList<QQStrangerLiteActionModel>> map = f244578h;
                    Intrinsics.checkNotNullExpressionValue(uid, "uid");
                    map.put(uid, new ArrayList<>(this$0.cacheModel.subList(0, min)));
                    if (QLog.isColorLevel()) {
                        QLog.d("QQStrangerLiteActionDataCenter", 2, "[SsoGetInterMsgList] Fully update cache.");
                    }
                    this$0.fullSyncComplete = true;
                }
                boolean z17 = this$0.endTime == 0;
                this$0.endTime = interactiveMsgServicePB$GetInterMsgListRsp.next_end_time.get();
                this$0.g(cb5, interactiveMsgServicePB$GetInterMsgListRsp.flag_end.get() == 1, z17);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerLiteActionDataCenter", 2, "[SsoGetInterMsgList] error: ", e16);
                h(this$0, cb5, true, false, 4, null);
                return;
            }
        }
        h(this$0, cb5, true, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v(e eVar, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        eVar.u(z16, function1);
    }
}
