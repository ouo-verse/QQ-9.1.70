package com.qzone.reborn.feedpro.viewmodel;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedpro.utils.n;
import com.qzone.reborn.feedpro.viewmodel.i;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRight;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionIDKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneDetailCacheManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDetailManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetRepliesRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.UnLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionExtID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneBitCheckUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.access;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 g2\u00020\u0001:\u0001hB\u0007\u00a2\u0006\u0004\be\u0010fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\bJ\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001eJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\u0019J\b\u0010$\u001a\u0004\u0018\u00010\u0002J&\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001eJ&\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001eJ.\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020(2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001eJ.\u0010+\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020(2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001eJ\b\u0010,\u001a\u00020\bH\u0014R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R.\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020:098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0019098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R(\u0010I\u001a\b\u0012\u0004\u0012\u00020\u0019098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010<\u001a\u0004\bG\u0010>\"\u0004\bH\u0010@R(\u0010M\u001a\b\u0012\u0004\u0012\u00020\u0019098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R(\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001c098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010<\u001a\u0004\bO\u0010>\"\u0004\bP\u0010@R(\u0010U\u001a\b\u0012\u0004\u0012\u00020\u0019098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010<\u001a\u0004\bS\u0010>\"\u0004\bT\u0010@R#\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0:098\u0006\u00a2\u0006\f\n\u0004\bW\u0010<\u001a\u0004\bX\u0010>R#\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Z0:098\u0006\u00a2\u0006\f\n\u0004\b[\u0010<\u001a\u0004\b\\\u0010>R#\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020_0^8\u0006\u00a2\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\u00a8\u0006i"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/i;", "Lcom/qzone/reborn/base/n;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "action", "", "index", "", "k2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", CommonConstant.KEY_UNION_ID, ZPlanPublishSource.FROM_SCHEME, "S1", "X1", "c2", "posId", "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "T1", "getLogTag", "y2", "e2", "Landroid/content/Intent;", "intent", "x2", "", "m2", "r2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "Lcom/qzone/reborn/base/n$a;", "dataCallback", ICustomDataEditor.STRING_PARAM_2, "W1", "U1", "o2", "d2", "feedData", "t2", "u2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "reply", "v2", "w2", "onCleared", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedLikeManager;", "i", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedLikeManager;", "feedManager", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedDetailManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedDetailManager;", "feedDetailManager", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "D", "Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "E", "Landroidx/lifecycle/MutableLiveData;", "f2", "()Landroidx/lifecycle/MutableLiveData;", "setFeedDetailData", "(Landroidx/lifecycle/MutableLiveData;)V", "feedDetailData", UserInfo.SEX_FEMALE, ICustomDataEditor.NUMBER_PARAM_2, "setFirstFetchDetailFeedSuccess", "isFirstFetchDetailFeedSuccess", "G", "p2", "setLoadMoreCommentSuccess", "isLoadMoreCommentSuccess", "H", "q2", "setLoadMoreRepliesSuccess", "isLoadMoreRepliesSuccess", "I", "l2", "setCloseMoreReplies", "isCloseMoreReplies", "J", "g2", "setMCommentDataChange", "mCommentDataChange", "Lcom/tencent/gdtad/aditem/GdtAd;", "K", "i2", "mDetailBottomAdData", "Lwd/b;", "L", "j2", "mDetailCommentAdData", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/qzone/reborn/feedpro/utils/n$a;", "M", "Ljava/util/concurrent/ConcurrentHashMap;", SemanticAttributes.DbSystemValues.H2, "()Ljava/util/concurrent/ConcurrentHashMap;", "mCommentExpandStatusMap", "<init>", "()V", "N", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends com.qzone.reborn.base.n {
    private static final String[] P = {QzoneDataUpdateAction.ADD_COMMENT, QzoneDataUpdateAction.UPDATE_COMMENT, QzoneDataUpdateAction.DELETE_COMMENT, QzoneDataUpdateAction.ADD_REPLY, QzoneDataUpdateAction.UPDATE_REPLY, QzoneDataUpdateAction.DELETE_REPLY, QzoneDataUpdateAction.FORWARD_FEED};

    /* renamed from: C, reason: from kotlin metadata */
    private CommonUnionID unionId;

    /* renamed from: F, reason: from kotlin metadata */
    private MutableLiveData<Boolean> isFirstFetchDetailFeedSuccess;

    /* renamed from: G, reason: from kotlin metadata */
    private MutableLiveData<Boolean> isLoadMoreCommentSuccess;

    /* renamed from: H, reason: from kotlin metadata */
    private MutableLiveData<Boolean> isLoadMoreRepliesSuccess;

    /* renamed from: I, reason: from kotlin metadata */
    private MutableLiveData<CommonComment> isCloseMoreReplies;

    /* renamed from: J, reason: from kotlin metadata */
    private MutableLiveData<Boolean> mCommentDataChange;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<GdtAd>> mDetailBottomAdData;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<wd.b>> mDetailCommentAdData;

    /* renamed from: M, reason: from kotlin metadata */
    private final ConcurrentHashMap<String, n.a> mCommentExpandStatusMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedLikeManager feedManager = new QzoneFeedLikeManager();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedDetailManager feedDetailManager = new QzoneFeedDetailManager();

    /* renamed from: D, reason: from kotlin metadata */
    private String scheme = "";

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<CommonFeed>> feedDetailData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "action", "", "index", "", "onDataUpdate", "", "list", "onListUpdate", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements IQzoneFeedUpdateCallback {
        a() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback
        public void onDataUpdate(CommonFeed commonFeed, String action, int index) {
            Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
            Intrinsics.checkNotNullParameter(action, "action");
            i.this.k2(commonFeed, action, index);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback
        public void onListUpdate(List<CommonFeed> list, String action, int index) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(action, "action");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$c", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements VasAdCallback {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(i this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i2().setValue(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(i this$0, UIStateData uIStateData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i2().setValue(uIStateData);
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, access.AdGetRsp adRsp, String msg2) {
            access.RetMsg retMsg;
            PBStringField pBStringField;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (QLog.isColorLevel()) {
                QLog.d("QzoneFeedProDetailViewModel", 1, "onAdRsp retCode:" + retCode + ", retMsg:" + ((adRsp == null || (retMsg = adRsp.ret_msg) == null || (pBStringField = retMsg.err_msg) == null) ? null : pBStringField.get()));
            }
            if (retCode == 0 && adRsp != null) {
                final i iVar = i.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    GdtAd gdtAd = new GdtAd(adRsp.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0));
                    final UIStateData obtainSuccess = UIStateData.obtainSuccess(false);
                    obtainSuccess.setDataList(gdtAd);
                    obtainSuccess.setFinish(true);
                    RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.viewmodel.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.c.d(i.this, obtainSuccess);
                        }
                    });
                    Result.m476constructorimpl(Unit.INSTANCE);
                    return;
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                    return;
                }
            }
            QLog.e("QzoneFeedProDetailViewModel", 1, "onAdRsp error");
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final i iVar2 = i.this;
            rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.viewmodel.j
                @Override // java.lang.Runnable
                public final void run() {
                    i.c.c(i.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "commentList", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements DataCallback<List<? extends CommonComment>> {
        d() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<CommonComment> commentList, long retCode, String msg2, boolean isFinish) {
            CommonFeed data;
            CommonCellComment cellComment;
            Intrinsics.checkNotNullParameter(commentList, "commentList");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            i.this.p2().setValue(Boolean.TRUE);
            CommonUnionID commonUnionID = i.this.unionId;
            int size = commentList.size();
            UIStateData<CommonFeed> value = i.this.f2().getValue();
            Integer valueOf = (value == null || (data = value.getData()) == null || (cellComment = data.getCellComment()) == null) ? null : Integer.valueOf(cellComment.getNum());
            QLog.d("QzoneFeedProDetailViewModel", 1, "loadMoreComment  onSuccess | unionId=" + commonUnionID + " | addSize=" + size + " | sum=" + valueOf + " | commentAttachInfo=" + i.this.feedDetailManager.getCommentAttachInfo() + " | hasMoreComment=" + i.this.o2());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            i.this.p2().setValue(Boolean.FALSE);
            QLog.d("QzoneFeedProDetailViewModel", 1, "loadMoreComment  onFailure | unionId=" + i.this.unionId + " | errorCode=" + errorCode + " | errorMsg=" + errorMsg + " | commentAttachInfo=" + i.this.feedDetailManager.getCommentAttachInfo() + " | hasMoreComment=" + i.this.o2());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetRepliesRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements DataCallback<GetRepliesRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonComment f54401b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ n.a<Boolean> f54402c;

        e(CommonComment commonComment, n.a<Boolean> aVar) {
            this.f54401b = commonComment;
            this.f54402c = aVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetRepliesRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            n.a aVar = i.this.h2().get(this.f54401b.getId());
            if (aVar != null) {
                aVar.a(t16.replys.size());
            }
            MutableLiveData<Boolean> q26 = i.this.q2();
            Boolean bool = Boolean.TRUE;
            q26.postValue(bool);
            RFWLog.d("QzoneFeedProDetailViewModel", RFWLog.USR, "onSuccess  | unionId=" + i.this.unionId + " | commentId=" + this.f54401b.getId() + " | replysSize=" + t16.replys.size() + " | hasMore=" + t16.hasMore);
            n.a<Boolean> aVar2 = this.f54402c;
            if (aVar2 != null) {
                aVar2.onSuccess(bool, retCode, msg2, isFinish);
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            i.this.q2().postValue(Boolean.FALSE);
            RFWLog.d("QzoneFeedProDetailViewModel", RFWLog.USR, "loadMoreCommentReply  onFailure | unionId=" + i.this.unionId + " | errorCode=" + errorCode + " | errorMsg=" + errorMsg + " | commentId=" + this.f54401b.getId() + " | commentAttachInfo=" + i.this.feedDetailManager.getCommentAttachInfo());
            n.a<Boolean> aVar = this.f54402c;
            if (aVar != null) {
                aVar.onFailure(errorCode, errorMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$f", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DoLikeRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class f implements DataCallback<DoLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<Boolean> f54403a;

        f(n.a<Boolean> aVar) {
            this.f54403a = aVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DoLikeRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            n.a<Boolean> aVar = this.f54403a;
            if (aVar != null) {
                aVar.onSuccess(Boolean.TRUE, retCode, msg2, isFinish);
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            n.a<Boolean> aVar = this.f54403a;
            if (aVar != null) {
                aVar.onFailure(errorCode, errorMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$g", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/UnLikeRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class g implements DataCallback<UnLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<Boolean> f54404a;

        g(n.a<Boolean> aVar) {
            this.f54404a = aVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(UnLikeRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            n.a<Boolean> aVar = this.f54404a;
            if (aVar != null) {
                aVar.onSuccess(Boolean.TRUE, retCode, msg2, isFinish);
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            n.a<Boolean> aVar = this.f54404a;
            if (aVar != null) {
                aVar.onFailure(errorCode, errorMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$h", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DoLikeRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class h implements DataCallback<DoLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<Boolean> f54405a;

        h(n.a<Boolean> aVar) {
            this.f54405a = aVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DoLikeRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            n.a<Boolean> aVar = this.f54405a;
            if (aVar != null) {
                aVar.onSuccess(Boolean.TRUE, retCode, msg2, isFinish);
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            n.a<Boolean> aVar = this.f54405a;
            if (aVar != null) {
                aVar.onFailure(errorCode, errorMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$i", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/UnLikeRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.viewmodel.i$i, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public static final class C0457i implements DataCallback<UnLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<Boolean> f54406a;

        C0457i(n.a<Boolean> aVar) {
            this.f54406a = aVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(UnLikeRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            n.a<Boolean> aVar = this.f54406a;
            if (aVar != null) {
                aVar.onSuccess(Boolean.TRUE, retCode, msg2, isFinish);
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            n.a<Boolean> aVar = this.f54406a;
            if (aVar != null) {
                aVar.onFailure(errorCode, errorMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/i$j", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class j implements DataCallback<CommonFeed> {
        j() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CommonFeed commonFeed, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            i.this.h2().clear();
            UIStateData<CommonFeed> obtainSuccess = UIStateData.obtainSuccess(false);
            obtainSuccess.setData(false, commonFeed);
            obtainSuccess.setType(100);
            i.this.f2().setValue(obtainSuccess);
            i.this.n2().setValue(Boolean.TRUE);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            UIStateData<CommonFeed> obtainError = UIStateData.obtainError(errorMsg);
            obtainError.setRetCode(errorCode);
            i.this.f2().setValue(obtainError);
        }
    }

    public i() {
        Boolean bool = Boolean.FALSE;
        this.isFirstFetchDetailFeedSuccess = new MutableLiveData<>(bool);
        this.isLoadMoreCommentSuccess = new MutableLiveData<>();
        this.isLoadMoreRepliesSuccess = new MutableLiveData<>();
        this.isCloseMoreReplies = new MutableLiveData<>();
        this.mCommentDataChange = new MutableLiveData<>(bool);
        this.mDetailBottomAdData = new MutableLiveData<>();
        this.mDetailCommentAdData = new MutableLiveData<>();
        this.mCommentExpandStatusMap = new ConcurrentHashMap<>();
        this.feedDetailManager.registerFeedUpdateCallback(new a(), true);
    }

    private final void X1() {
        VasNewAdParams T1 = T1("2115727318573492");
        if (T1 != null) {
            ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).requestFeedAdvAsync(T1, new oz2.a() { // from class: com.qzone.reborn.feedpro.viewmodel.f
                @Override // oz2.a
                public final void a(VasAdvServiceCode vasAdvServiceCode, String str, int i3, access.AdGetRsp adGetRsp) {
                    i.Z1(i.this, vasAdvServiceCode, str, i3, adGetRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(final i this$0, VasAdvServiceCode retCode, String str, int i3, access.AdGetRsp adGetRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        if (QLog.isColorLevel()) {
            QLog.i("QzoneFeedProDetailViewModel", 2, "index: " + i3 + ", adRsp: " + adGetRsp);
        }
        if (retCode == VasAdvServiceCode.SUCCEED && adGetRsp != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                GdtAd gdtAd = new GdtAd(adGetRsp.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0));
                final UIStateData obtainSuccess = UIStateData.obtainSuccess(false);
                obtainSuccess.setDataList(new wd.b(gdtAd, i3));
                obtainSuccess.setFinish(true);
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.viewmodel.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b2(i.this, obtainSuccess);
                    }
                });
                Result.m476constructorimpl(Unit.INSTANCE);
                return;
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
                return;
            }
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.viewmodel.g
            @Override // java.lang.Runnable
            public final void run() {
                i.a2(i.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mDetailCommentAdData.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(i this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mDetailCommentAdData.setValue(uIStateData);
    }

    private final void c2() {
        VasNewAdParams T1 = T1("6010627934636636");
        if (T1 != null) {
            ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestAd(T1, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(CommonFeed commonFeed, String action, int index) {
        boolean contains;
        if (!Intrinsics.areEqual(action, "REFRESH") && !Intrinsics.areEqual(action, QzoneDataUpdateAction.UPDATE) && !Intrinsics.areEqual(action, QzoneDataUpdateAction.MODIFY_PERMISSION)) {
            contains = ArraysKt___ArraysKt.contains(P, action);
            if (contains) {
                this.mCommentDataChange.setValue(Boolean.TRUE);
                return;
            }
            if (!Intrinsics.areEqual(action, QzoneDataUpdateAction.LIKE_FEED) && !Intrinsics.areEqual(action, QzoneDataUpdateAction.UNLIKE_FEED)) {
                if (Intrinsics.areEqual(action, QzoneDataUpdateAction.FORWARD_FEED)) {
                    ze.a.a().initOrUpdateGlobalState((ze.a) new zd.b(e2(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellForwardInfo(), Boolean.TRUE), true);
                    return;
                }
                return;
            }
            ze.a.a().initOrUpdateGlobalState((ze.a) new zd.c(e2(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellLike()), true);
            return;
        }
        UIStateData<CommonFeed> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setData(false, commonFeed);
        this.feedDetailData.setValue(obtainSuccess);
    }

    public final void U1() {
        this.mDetailBottomAdData.setValue(null);
    }

    public final void W1() {
        this.mDetailCommentAdData.setValue(null);
    }

    public final CommonFeed d2() {
        UIStateData<CommonFeed> value = this.feedDetailData.getValue();
        if (value != null) {
            return value.getData();
        }
        return null;
    }

    public final String e2() {
        return String.valueOf(this.contextHashCode);
    }

    public final MutableLiveData<UIStateData<CommonFeed>> f2() {
        return this.feedDetailData;
    }

    public final MutableLiveData<Boolean> g2() {
        return this.mCommentDataChange;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProDetailViewModel";
    }

    public final ConcurrentHashMap<String, n.a> h2() {
        return this.mCommentExpandStatusMap;
    }

    public final MutableLiveData<UIStateData<GdtAd>> i2() {
        return this.mDetailBottomAdData;
    }

    public final MutableLiveData<UIStateData<wd.b>> j2() {
        return this.mDetailCommentAdData;
    }

    public final MutableLiveData<CommonComment> l2() {
        return this.isCloseMoreReplies;
    }

    public final boolean m2() {
        return false;
    }

    public final MutableLiveData<Boolean> n2() {
        return this.isFirstFetchDetailFeedSuccess;
    }

    public final boolean o2() {
        return this.feedDetailManager.getHasMoreComment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.feedDetailManager.clear();
    }

    public final MutableLiveData<Boolean> p2() {
        return this.isLoadMoreCommentSuccess;
    }

    public final MutableLiveData<Boolean> q2() {
        return this.isLoadMoreRepliesSuccess;
    }

    public final void r2() {
        CommonUnionID commonUnionID;
        QLog.d("QzoneFeedProDetailViewModel", 1, "loadMoreComment  | unionId=" + this.unionId + " | commentAttachInfo=" + this.feedDetailManager.getCommentAttachInfo() + " | hasMoreComment=" + o2());
        if (o2() && (commonUnionID = this.unionId) != null) {
            this.feedDetailManager.fetchFeedComment(commonUnionID, new d());
        }
    }

    public final void s2(CommonComment comment, n.a<Boolean> dataCallback) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        com.qzone.reborn.feedpro.utils.n nVar = com.qzone.reborn.feedpro.utils.n.f54347a;
        if (nVar.c(comment, this.mCommentExpandStatusMap)) {
            MutableLiveData<Boolean> mutableLiveData = this.isLoadMoreRepliesSuccess;
            Boolean bool = Boolean.TRUE;
            mutableLiveData.postValue(bool);
            if (dataCallback != null) {
                dataCallback.onSuccess(bool, 0L, "", true);
            }
            RFWLog.d("QzoneFeedProDetailViewModel", RFWLog.USR, "loadMoreCommentReply expandReplyByLocal commentId:" + comment.getId());
            return;
        }
        CommonUnionID commonUnionID = this.unionId;
        if (commonUnionID != null) {
            this.feedDetailManager.fetchMoreReply(commonUnionID, comment, nVar.e(comment), new e(comment, dataCallback));
        }
    }

    public final void t2(CommonFeed feedData, CommonComment comment, n.a<Boolean> dataCallback) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        RFWLog.d("QzoneFeedProDetailViewModel", RFWLog.USR, "onCommentLike");
        this.feedManager.likeComment(feedData, comment, new f(dataCallback));
    }

    public final void u2(CommonFeed feedData, CommonComment comment, n.a<Boolean> dataCallback) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        RFWLog.d("QzoneFeedProDetailViewModel", RFWLog.USR, "onCommentUnLike");
        this.feedManager.unlikeComment(feedData, comment, new g(dataCallback));
    }

    public final void v2(CommonFeed feedData, CommonComment comment, CommonReply reply, n.a<Boolean> dataCallback) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        RFWLog.d("QzoneFeedProDetailViewModel", RFWLog.USR, "onReplyLike");
        this.feedManager.likeReply(feedData, reply, new h(dataCallback));
    }

    public final void w2(CommonFeed feedData, CommonComment comment, CommonReply reply, n.a<Boolean> dataCallback) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        RFWLog.d("QzoneFeedProDetailViewModel", RFWLog.USR, "onReplyUnLike");
        this.feedManager.unlikeReply(feedData, reply, new C0457i(dataCallback));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x2(Intent intent) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("context_hash_code");
        com.qzone.reborn.feedpro.utils.b bVar = com.qzone.reborn.feedpro.utils.b.f54315a;
        this.unionId = (CommonUnionID) bVar.a("key_common_union_id", stringExtra, CommonUnionID.class);
        String stringExtra2 = intent.getStringExtra(ChatsRevealApiImpl.KEY_JUMP_SCHEME);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.scheme = stringExtra2;
        CommonFeed commonFeed = (CommonFeed) bVar.a("key_common_feed", stringExtra, CommonFeed.class);
        CommonFeed copyFeed = commonFeed != null ? CommonFeedKt.copyFeed(commonFeed) : null;
        String S1 = S1(this.unionId, this.scheme);
        if (copyFeed != null) {
            CommonCellCommon cellCommon = copyFeed.getCellCommon();
            if (cellCommon != null) {
                int featureFlag = cellCommon.getFeatureFlag();
                CommonCellCommon cellCommon2 = copyFeed.getCellCommon();
                if (cellCommon2 != null) {
                    cellCommon2.setFeatureFlag((int) QzoneBitCheckUtil.INSTANCE.disableBit(featureFlag, 1));
                }
            }
            if (S1 != null) {
                if (S1.length() > 0) {
                    z17 = true;
                    r0 = z17 ? QzoneDetailCacheManager.INSTANCE.getFeedData(S1, ShortVideoConstants.VIDEO_MAX_DURATION) : null;
                    if (r0 == null) {
                        r0 = copyFeed;
                    }
                }
            }
            z17 = false;
            if (z17) {
            }
            if (r0 == null) {
            }
        } else {
            if (S1 != null) {
                if (S1.length() > 0) {
                    z16 = true;
                    if (z16) {
                        r0 = QzoneDetailCacheManager.INSTANCE.getFeedData(S1, 0L);
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        if (r0 != null) {
            UIStateData<CommonFeed> obtainSuccess = UIStateData.obtainSuccess(true);
            obtainSuccess.setData(false, r0);
            this.feedDetailData.setValue(obtainSuccess);
        }
    }

    public final void y2() {
        this.feedDetailManager.fetchFeedDetail(this.unionId, this.scheme, S1(this.unionId, this.scheme), new j());
        X1();
        c2();
    }

    private final VasNewAdParams T1(String posId) {
        String str;
        String str2;
        String str3;
        List<UnionExtID> list;
        CommonFeed data;
        CommonCellPermission cellPermission;
        CommonRight right;
        List<Integer> flag;
        UIStateData<CommonFeed> value = this.feedDetailData.getValue();
        Integer num = (value == null || (data = value.getData()) == null || (cellPermission = data.getCellPermission()) == null || (right = cellPermission.getRight()) == null || (flag = right.getFlag()) == null) ? null : flag.get(0);
        CommonUnionID commonUnionID = this.unionId;
        if (commonUnionID == null) {
            return null;
        }
        UnionID pb5 = CommonUnionIDKt.toPb(commonUnionID);
        access.UnionID unionID = new access.UnionID();
        PBStringField pBStringField = unionID.uf_key;
        if (pb5 == null || (str = pb5.ufKey) == null) {
            str = "";
        }
        pBStringField.set(str);
        PBStringField pBStringField2 = unionID.ugc_id;
        if (pb5 == null || (str2 = pb5.ugcId) == null) {
            str2 = "";
        }
        pBStringField2.set(str2);
        PBStringField pBStringField3 = unionID.feed_id;
        if (pb5 == null || (str3 = pb5.feedId) == null) {
            str3 = "";
        }
        pBStringField3.set(str3);
        PBRepeatMessageField<access.UnionExtID> pBRepeatMessageField = unionID.ext_ids;
        ArrayList arrayList = new ArrayList();
        if (pb5 != null && (list = pb5.extIds) != null) {
            for (UnionExtID unionExtID : list) {
                access.UnionExtID unionExtID2 = new access.UnionExtID();
                PBEnumField pBEnumField = unionExtID2.ext_id_type;
                Integer num2 = unionExtID.extIdType;
                pBEnumField.set(num2 != null ? num2.intValue() : 0);
                PBInt64Field pBInt64Field = unionExtID2.numeric;
                Long l3 = unionExtID.numeric;
                long j3 = 0;
                pBInt64Field.set(l3 != null ? l3.longValue() : 0L);
                PBStringField pBStringField4 = unionExtID2.str;
                String str4 = unionExtID.str;
                if (str4 == null) {
                    str4 = "";
                }
                pBStringField4.set(str4);
                PBUInt64Field pBUInt64Field = unionExtID2.unsigned_numeric;
                Long l16 = unionExtID.unsignedNumeric;
                if (l16 != null) {
                    j3 = l16.longValue();
                }
                pBUInt64Field.set(j3);
                arrayList.add(unionExtID2);
            }
        }
        pBRepeatMessageField.set(arrayList);
        access.QzoneInfo qzoneInfo = new access.QzoneInfo();
        qzoneInfo.union_id.set(unionID);
        qzoneInfo.feed_right_flag.set(num != null ? num.intValue() : 1);
        VasNewAdParams.Builder builder = new VasNewAdParams.Builder();
        builder.getAdvPos().add(posId);
        builder.setBusiType(85);
        builder.setQzoneInfo(qzoneInfo);
        return builder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String S1(CommonUnionID unionId, String scheme) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        if (unionId != null) {
            String ufKey = unionId.getUfKey();
            if (ufKey != null) {
                if (ufKey.length() > 0) {
                    z16 = true;
                    if (!z16) {
                        str = unionId.getUfKey();
                    } else {
                        String ugcId = unionId.getUgcId();
                        if (ugcId != null) {
                            if (ugcId.length() > 0) {
                                z17 = true;
                                if (!z17) {
                                    str = unionId.getUgcId();
                                } else {
                                    String feedId = unionId.getFeedId();
                                    if (feedId != null) {
                                        if (feedId.length() > 0) {
                                            z18 = true;
                                            if (z18) {
                                                str = unionId.getFeedId();
                                            }
                                        }
                                    }
                                    z18 = false;
                                    if (z18) {
                                    }
                                }
                            }
                        }
                        z17 = false;
                        if (!z17) {
                        }
                    }
                    if (!(str != null || str.length() == 0)) {
                        scheme = str;
                    }
                    return scheme == null ? "" : scheme;
                }
            }
            z16 = false;
            if (!z16) {
            }
            if (!(str != null || str.length() == 0)) {
            }
            if (scheme == null) {
            }
        }
        str = null;
        if (!(str != null || str.length() == 0)) {
        }
        if (scheme == null) {
        }
    }
}
