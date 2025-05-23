package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountDetailPageLaunchInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountRedDotType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u001e\u0010\r\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0002J\u001e\u0010\u000f\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\t0\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001c\u0010\u0017\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountMessageServiceImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountMessageService;", "()V", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "curPreloadedMessageId", "", "curUpdatedMessageId", "fetchLastMessageInfo", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "fetchQCirclePublicAccountLatestMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "findQCirclePublicAccountContact", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "getAutoPlayFeedId", "getQCirclePublicAccountStaggerPreloadTriggerCount", "", "getRedDotType", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "getRedDotTypeFromCached", "hasUnReadMessage", "", "isCurrentImmersiveFlowType", "loadValidVideo", "messageInfo", "markMessageConsumed", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "setQCircleMessageRead", "tryLoadValidVideo", "tryUpdateMessageInfo", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountMessageServiceImpl implements IQCirclePublicAccountMessageService {

    @NotNull
    public static final String KEY_LAST_CONSUMED_MESSAGE_INFO_ID = "key_last_consumed_message_info_id";

    @NotNull
    public static final String KEY_LAST_EXCHANGED_URL_LAUNCH_INFO = "key_last_exchanged_url_launch_info";

    @NotNull
    public static final String KEY_LAST_EXCHANGED_URL_MESSAGE_INFO_ID = "key_last_exchanged_url_message_info_id";

    @NotNull
    public static final String KEY_QCIRCLE_PUBLIC_ACCOUNT_FLOW_TYPE = "key_qcircle_public_account_flow_type";

    @NotNull
    public static final String KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_AUTO_PLAY_ID = "key_qcircle_public_account_stagger_ap_feed_id";

    @NotNull
    public static final String KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_PRELOAD_TRIGGER_COUNT = "key_qcircle_public_account_stagger_preload_trigger_count";
    public static final int QCIRCLE_PUBLIC_ACCOUNT_FLOW_TYPE_DOUBLE_ROW = 1;
    public static final int QCIRCLE_PUBLIC_ACCOUNT_FLOW_TYPE_IMMERSIVE = 0;
    public static final int QCIRCLE_PUBLIC_ACCOUNT_STAGGER_PRELOAD_DEFAULT_TRIGGER_COUNT = 8;

    @NotNull
    public static final String TAG = "QCirclePublicAccountMessageServiceImpl";

    @Nullable
    private BaseQQAppInterface app;

    @NotNull
    private volatile String curPreloadedMessageId = "";

    @NotNull
    private volatile String curUpdatedMessageId = "";

    @NotNull
    private static final Contact qCirclePublicAccountContact = new Contact(103, AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UID, "");

    private final void fetchQCirclePublicAccountLatestMsg(final Function1<? super MsgRecord, Unit> callback) {
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            callback.invoke(null);
            return;
        }
        w msgService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")).getMsgService();
        if (msgService == null) {
            callback.invoke(null);
        } else {
            if (uq3.c.m7()) {
                ArrayList<Contact> arrayList = new ArrayList<>();
                arrayList.add(qCirclePublicAccountContact);
                msgService.getLastMessageList(arrayList, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.qcircle.api.impl.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i3, String str, ArrayList arrayList2) {
                        QCirclePublicAccountMessageServiceImpl.fetchQCirclePublicAccountLatestMsg$lambda$9(Function1.this, i3, str, arrayList2);
                    }
                });
                return;
            }
            findQCirclePublicAccountContact(new QCirclePublicAccountMessageServiceImpl$fetchQCirclePublicAccountLatestMsg$2(msgService, callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchQCirclePublicAccountLatestMsg$lambda$9(Function1 callback, int i3, String str, ArrayList msgList) {
        Object firstOrNull;
        String briefString;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgList);
        MsgRecord msgRecord = (MsgRecord) firstOrNull;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fetchQCirclePublicAccountLatestMsg=");
        briefString = QCirclePublicAccountMessageServiceImplKt.toBriefString(msgRecord);
        sb5.append(briefString);
        QLog.i(TAG, 1, sb5.toString());
        callback.invoke(msgRecord);
    }

    private final void findQCirclePublicAccountContact(final Function1<? super RecentContactInfo, Unit> callback) {
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            callback.invoke(null);
            return;
        }
        aa recentContactService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService == null) {
            callback.invoke(null);
        } else {
            recentContactService.F0(qCirclePublicAccountContact, new IGetContactsCallback() { // from class: com.tencent.mobileqq.qcircle.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                    QCirclePublicAccountMessageServiceImpl.findQCirclePublicAccountContact$lambda$5(Function1.this, i3, str, arrayList, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void findQCirclePublicAccountContact$lambda$5(Function1 callback, int i3, String str, ArrayList foundContacts, ArrayList arrayList) {
        Object firstOrNull;
        String briefString;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(foundContacts, "foundContacts");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) foundContacts);
        RecentContactInfo recentContactInfo = (RecentContactInfo) firstOrNull;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("findQCirclePublicAccountContact=");
        briefString = QCirclePublicAccountMessageServiceImplKt.toBriefString(recentContactInfo);
        sb5.append(briefString);
        QLog.i(TAG, 1, sb5.toString());
        callback.invoke(recentContactInfo);
    }

    private final boolean isCurrentImmersiveFlowType() {
        if (k.a().e(KEY_QCIRCLE_PUBLIC_ACCOUNT_FLOW_TYPE, 0) != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void loadValidVideo(final QCirclePublicAccountMessageInfo messageInfo) {
        QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo;
        if (Intrinsics.areEqual(messageInfo.getId(), this.curPreloadedMessageId)) {
            return;
        }
        QCirclePublicAccountDetailPageLaunchInfo qCirclePublicAccountDetailPageLaunchInfo = new QCirclePublicAccountDetailPageLaunchInfo(null, null, null, null, null, null, null, null, null, 0, 1023, null);
        String launchInfoStr = messageInfo.getLaunchInfoStr();
        if (launchInfoStr == null) {
            launchInfoStr = "";
        }
        final QCirclePublicAccountDetailPageLaunchInfo parseFromJSONStr = qCirclePublicAccountDetailPageLaunchInfo.parseFromJSONStr(launchInfoStr);
        if (parseFromJSONStr == null) {
            return;
        }
        QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo = parseFromJSONStr.getFeedInfo();
        if (feedInfo != null && (videoInfo = feedInfo.getVideoInfo()) != null) {
            this.curPreloadedMessageId = messageInfo.getId();
            com.tencent.biz.qqcircle.publicaccount.f fVar = com.tencent.biz.qqcircle.publicaccount.f.f91680a;
            String playUrl = videoInfo.getPlayUrl();
            if (playUrl == null) {
                playUrl = "";
            }
            if (fVar.f(playUrl)) {
                QLog.i(TAG, 1, "tryLoadValidVideo, needChangeUrl, url=" + videoInfo.getPlayUrl());
                fVar.g(videoInfo);
                fVar.a(videoInfo, new Function1<QCirclePublicAccountDetailPageLaunchInfo.VideoInfo, Unit>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImpl$loadValidVideo$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo2) {
                        invoke2(videoInfo2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo2) {
                        if (videoInfo2 != null) {
                            QLog.i(QCirclePublicAccountMessageServiceImpl.TAG, 1, "tryLoadValidVideo, exchange success, url=" + videoInfo2.getPlayUrl());
                            QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo2 = QCirclePublicAccountDetailPageLaunchInfo.this.getFeedInfo();
                            if (feedInfo2 != null) {
                                feedInfo2.setVideoInfo(videoInfo2);
                            }
                            k.a().p(QCirclePublicAccountMessageServiceImpl.KEY_LAST_EXCHANGED_URL_MESSAGE_INFO_ID, messageInfo.getId());
                            k.a().p(QCirclePublicAccountMessageServiceImpl.KEY_LAST_EXCHANGED_URL_LAUNCH_INFO, QCirclePublicAccountDetailPageLaunchInfo.this.toJSONStr());
                            com.tencent.biz.qqcircle.publicaccount.f.f91680a.e(videoInfo2);
                            return;
                        }
                        QLog.e(QCirclePublicAccountMessageServiceImpl.TAG, 1, "tryLoadValidVideo, exchangeUrl fail");
                    }
                });
            } else if (!fVar.c(videoInfo)) {
                QLog.i(TAG, 1, "tryLoadValidVideo, no cache, try load");
                fVar.g(videoInfo);
                fVar.e(videoInfo);
            } else {
                QLog.i(TAG, 1, "tryLoadValidVideo, video valid");
            }
            QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo2 = parseFromJSONStr.getFeedInfo();
            if (feedInfo2 == null) {
                return;
            }
            String coverUrl = feedInfo2.getCoverUrl();
            if (coverUrl != null) {
                fVar.d(coverUrl);
            }
        }
    }

    private final synchronized void markMessageConsumed() {
        fetchLastMessageInfo(new Function1<QCirclePublicAccountMessageInfo, Unit>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImpl$markMessageConsumed$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                invoke2(qCirclePublicAccountMessageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                if (qCirclePublicAccountMessageInfo != null) {
                    k.a().p(QCirclePublicAccountMessageServiceImpl.KEY_LAST_CONSUMED_MESSAGE_INFO_ID, qCirclePublicAccountMessageInfo.getId());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setQCircleMessageRead$lambda$0(int i3, String str) {
        QLog.d(TAG, 1, "mark read: result=" + i3 + " msg=" + str);
    }

    private final void tryLoadValidVideo() {
        if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isOnFetchMsgStage(this.app)) {
            QLog.i(TAG, 1, "tryLoadValidVideo, isOnFetchMsgStage, return");
        } else if (!isCurrentImmersiveFlowType()) {
            QLog.i(TAG, 1, "tryLoadValidVideo, isCurrentImmersiveFlowType == false, return");
        } else {
            hasUnReadMessage(new QCirclePublicAccountMessageServiceImpl$tryLoadValidVideo$1(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryUpdateMessageInfo(QCirclePublicAccountMessageInfo messageInfo) {
        Integer num;
        int coerceAtLeast;
        if (Intrinsics.areEqual(messageInfo.getId(), this.curUpdatedMessageId)) {
            return;
        }
        QLog.i(TAG, 2, "tryUpdateMessageInfo, id=" + messageInfo.getId());
        this.curUpdatedMessageId = messageInfo.getId();
        QCirclePublicAccountDetailPageLaunchInfo qCirclePublicAccountDetailPageLaunchInfo = new QCirclePublicAccountDetailPageLaunchInfo(null, null, null, null, null, null, null, null, null, 0, 1023, null);
        String launchInfoStr = messageInfo.getLaunchInfoStr();
        if (launchInfoStr == null) {
            launchInfoStr = "";
        }
        QCirclePublicAccountDetailPageLaunchInfo parseFromJSONStr = qCirclePublicAccountDetailPageLaunchInfo.parseFromJSONStr(launchInfoStr);
        Integer num2 = null;
        if (parseFromJSONStr != null) {
            num = parseFromJSONStr.getFlowType();
        } else {
            num = null;
        }
        if (num != null) {
            k.a().m(KEY_QCIRCLE_PUBLIC_ACCOUNT_FLOW_TYPE, num.intValue());
        }
        if (parseFromJSONStr != null) {
            num2 = parseFromJSONStr.getPreloadTriggerCount();
        }
        boolean z16 = false;
        if (num2 != null) {
            k a16 = k.a();
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(num2.intValue(), 0);
            a16.m(KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_PRELOAD_TRIGGER_COUNT, coerceAtLeast);
        }
        if (parseFromJSONStr != null && parseFromJSONStr.getAutoPlay() == 1) {
            String feedId = parseFromJSONStr.getFeedId();
            if (feedId == null || feedId.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                k.a().p(KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_AUTO_PLAY_ID, parseFromJSONStr.getFeedId());
                QLog.i(TAG, 2, "tryUpdateMessageInfo, autoPlay feedId=" + parseFromJSONStr.getFeedId());
            }
        }
        tryLoadValidVideo();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService
    public synchronized void fetchLastMessageInfo(@NotNull final Function1<? super QCirclePublicAccountMessageInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchQCirclePublicAccountLatestMsg(new Function1<MsgRecord, Unit>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImpl$fetchLastMessageInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MsgRecord msgRecord) {
                invoke2(msgRecord);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MsgRecord msgRecord) {
                QCirclePublicAccountMessageInfo tryExchangedUrl;
                QCirclePublicAccountMessageInfo consumed;
                QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo = msgRecord != null ? QCirclePublicAccountMessageServiceImplKt.toQCirclePublicAccountMessageInfo(msgRecord) : null;
                if (qCirclePublicAccountMessageInfo != null) {
                    this.tryUpdateMessageInfo(qCirclePublicAccountMessageInfo);
                }
                if (qCirclePublicAccountMessageInfo == null) {
                    callback.invoke(null);
                    return;
                }
                if (Intrinsics.areEqual(qCirclePublicAccountMessageInfo.getId(), k.a().h(QCirclePublicAccountMessageServiceImpl.KEY_LAST_CONSUMED_MESSAGE_INFO_ID, ""))) {
                    Function1<QCirclePublicAccountMessageInfo, Unit> function1 = callback;
                    consumed = QCirclePublicAccountMessageServiceImplKt.consumed(qCirclePublicAccountMessageInfo);
                    function1.invoke(consumed);
                } else {
                    Function1<QCirclePublicAccountMessageInfo, Unit> function12 = callback;
                    tryExchangedUrl = QCirclePublicAccountMessageServiceImplKt.tryExchangedUrl(qCirclePublicAccountMessageInfo);
                    function12.invoke(tryExchangedUrl);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService
    @NotNull
    public String getAutoPlayFeedId() {
        String h16 = k.a().h(KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_AUTO_PLAY_ID, "");
        Intrinsics.checkNotNullExpressionValue(h16, "g().getString(KEY_QCIRCL\u2026STAGGER_AUTO_PLAY_ID, \"\")");
        return h16;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService
    public int getQCirclePublicAccountStaggerPreloadTriggerCount() {
        return k.a().e(KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_PRELOAD_TRIGGER_COUNT, 8);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService
    public void getRedDotType(@NotNull final Function1<? super QCirclePublicAccountRedDotType, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        findQCirclePublicAccountContact(new Function1<RecentContactInfo, Unit>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImpl$getRedDotType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecentContactInfo recentContactInfo) {
                invoke2(recentContactInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable RecentContactInfo recentContactInfo) {
                callback.invoke(QCirclePublicAccountMessageServiceImplKt.getRedDotType(recentContactInfo));
            }
        });
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService
    @NotNull
    public QCirclePublicAccountRedDotType getRedDotTypeFromCached() {
        IKernelService iKernelService;
        aa recentContactService;
        List<RecentContactInfo> a16;
        boolean z16;
        BaseQQAppInterface baseQQAppInterface = this.app;
        RecentContactInfo recentContactInfo = null;
        if (baseQQAppInterface != null && (iKernelService = (IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "")) != null && (recentContactService = iKernelService.getRecentContactService()) != null && (a16 = recentContactService.a()) != null) {
            ListIterator<RecentContactInfo> listIterator = a16.listIterator(a16.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                RecentContactInfo previous = listIterator.previous();
                RecentContactInfo recentContactInfo2 = previous;
                if (recentContactInfo2.peerUin == AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN_LONGVALUE && recentContactInfo2.chatType == 103) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    recentContactInfo = previous;
                    break;
                }
            }
            recentContactInfo = recentContactInfo;
        }
        return QCirclePublicAccountMessageServiceImplKt.getRedDotType(recentContactInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService
    public void hasUnReadMessage(@NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        findQCirclePublicAccountContact(new Function1<RecentContactInfo, Unit>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImpl$hasUnReadMessage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecentContactInfo recentContactInfo) {
                invoke2(recentContactInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable RecentContactInfo recentContactInfo) {
                boolean hasUnreadMsg;
                Function1<Boolean, Unit> function1 = callback;
                hasUnreadMsg = QCirclePublicAccountMessageServiceImplKt.hasUnreadMsg(recentContactInfo);
                function1.invoke(Boolean.valueOf(hasUnreadMsg));
            }
        });
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        if (appRuntime instanceof BaseQQAppInterface) {
            this.app = (BaseQQAppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public synchronized void onDestroy() {
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService
    public void setQCircleMessageRead() {
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).markRead4PA(AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UID, new IOperateCallback() { // from class: com.tencent.mobileqq.qcircle.api.impl.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                QCirclePublicAccountMessageServiceImpl.setQCircleMessageRead$lambda$0(i3, str);
            }
        });
        markMessageConsumed();
    }
}
