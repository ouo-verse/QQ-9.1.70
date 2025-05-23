package com.tencent.mobileqq.nearbypro.entry.api.impl;

import android.content.Intent;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.chats.event.NBPInteractivePushEvent;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService;
import com.tencent.mobileqq.nearbypro.entry.api.impl.NearbyProEntryUnreadServiceImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.x;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUnreadInfo;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001*\u0018\u0000 /2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e`\u001fH\u0016R\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryUnreadServiceImpl;", "Lcom/tencent/mobileqq/nearbypro/entry/api/INearbyProEntryUnreadService;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "unreadCnt", "", "tryToUpdateEntryUnreadDot", "getLastReadMsgCntFromMMKV", "lastReadMsgCnt", "updateLastReadMsgCntToMMKV", "tryToUpdateInteractUnreadDot", "notifyEntryUnreadDotChanged", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isShowRedDot", "hasUnreadMsgCntDot", "hasUnreadInteractCntDot", "hasTianShuServiceDot", "clearEntryUnreadMsgCnt", "clearEntryUnreadInteractCnt", "clearTianShuRedPoint", "Landroid/content/Intent;", "getJumpIntent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "mIsMsgInitialized", "Z", "mLastReadMsgCnt", "J", "mTotalUnreadMsgCnt", "mHasUnreadInteract", "Lcom/tencent/mobileqq/nearbypro/chats/repo/d;", "mInteractMsgRepo", "Lcom/tencent/mobileqq/nearbypro/chats/repo/d;", "com/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryUnreadServiceImpl$b", "mNearbyProListener", "Lcom/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryUnreadServiceImpl$b;", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProEntryUnreadServiceImpl implements INearbyProEntryUnreadService, SimpleEventReceiver<SimpleBaseEvent> {

    @NotNull
    private static final String ENTRY_LAST_READ_MSG_CNT = "entry_last_read_msg_cnt";

    @NotNull
    private static final String TAG = "NearbyProEntryUnreadService";
    private boolean mHasUnreadInteract;
    private boolean mIsMsgInitialized;
    private long mLastReadMsgCnt;
    private long mTotalUnreadMsgCnt;

    @NotNull
    private final com.tencent.mobileqq.nearbypro.chats.repo.d mInteractMsgRepo = new com.tencent.mobileqq.nearbypro.chats.repo.d();

    @NotNull
    private final b mNearbyProListener = new b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryUnreadServiceImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProUnreadInfo;", "unreadCnt", "", "onNearbyAllContactsUnreadCntChanged", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements IKernelNearbyProListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(NearbyProEntryUnreadServiceImpl this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.tryToUpdateEntryUnreadDot(j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener
        public void onNearbyAllContactsUnreadCntChanged(@Nullable NearbyProUnreadInfo unreadCnt) {
            if (unreadCnt != null) {
                final long j3 = unreadCnt.unreadCnt;
                final NearbyProEntryUnreadServiceImpl nearbyProEntryUnreadServiceImpl = NearbyProEntryUnreadServiceImpl.this;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.entry.api.impl.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        NearbyProEntryUnreadServiceImpl.b.b(NearbyProEntryUnreadServiceImpl.this, j3);
                    }
                });
            }
        }
    }

    private final long getLastReadMsgCntFromMMKV() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0L;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeLong(ENTRY_LAST_READ_MSG_CNT + peekAppRuntime.getCurrentAccountUin(), 0L);
    }

    private final void notifyEntryUnreadDotChanged() {
        AppInterface appInterface;
        BusinessHandler businessHandler;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null && (businessHandler = appInterface.getBusinessHandler(NearbyProEntryNotifyHandler.class.getName())) != null) {
            businessHandler.notifyUI(0, true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1$lambda$0(int i3, String str) {
        j.c().e(TAG, "getNearByAllContactsUnreadCnt result = " + i3 + " errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryToUpdateEntryUnreadDot(long unreadCnt) {
        if (!this.mIsMsgInitialized) {
            this.mIsMsgInitialized = true;
            this.mLastReadMsgCnt = getLastReadMsgCntFromMMKV();
        }
        j.c().e(TAG, "tryToUpdateEntryUnreadDot mLastReadMsgCnt = " + this.mLastReadMsgCnt + " mTotalUnreadMsgCnt = " + this.mTotalUnreadMsgCnt + " unreadCnt = " + unreadCnt);
        if (this.mTotalUnreadMsgCnt == unreadCnt) {
            return;
        }
        this.mTotalUnreadMsgCnt = unreadCnt;
        if (unreadCnt == 0) {
            this.mLastReadMsgCnt = 0L;
        }
        notifyEntryUnreadDotChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryToUpdateInteractUnreadDot(long unreadCnt) {
        boolean z16;
        j.c().e(TAG, "tryToUpdateInteractUnreadDot mHasUnreadInteract=" + this.mHasUnreadInteract + " unreadCnt=" + unreadCnt);
        if (unreadCnt > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mHasUnreadInteract == z16) {
            return;
        }
        this.mHasUnreadInteract = z16;
        notifyEntryUnreadDotChanged();
    }

    private final void updateLastReadMsgCntToMMKV(long lastReadMsgCnt) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong(ENTRY_LAST_READ_MSG_CNT + peekAppRuntime.getCurrentAccountUin(), lastReadMsgCnt);
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService
    public void clearEntryUnreadInteractCnt() {
        j.c().e(TAG, "clearEntryUnreadInteractCnt");
        tryToUpdateInteractUnreadDot(0L);
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService
    public void clearEntryUnreadMsgCnt() {
        if (!this.mIsMsgInitialized) {
            j.c().e(TAG, "clearEntryUnreadMsgCnt mIsInitialized is false");
            return;
        }
        j.c().e(TAG, "clearEntryUnreadMsgCnt mLastReadMsgCnt = " + this.mLastReadMsgCnt + " mTotalUnreadMsgCnt = " + this.mTotalUnreadMsgCnt);
        long j3 = this.mLastReadMsgCnt;
        long j16 = this.mTotalUnreadMsgCnt;
        if (j3 != j16) {
            this.mLastReadMsgCnt = j16;
            updateLastReadMsgCntToMMKV(j16);
            notifyEntryUnreadDotChanged();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService
    public void clearTianShuRedPoint() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IRedTouchManager) runtimeService).dismissRedTouch("4050");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(NBPInteractivePushEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService
    @NotNull
    public Intent getJumpIntent() {
        IRedTouchManager iRedTouchManager;
        BusinessInfoCheckUpdate.AppInfo appInfo;
        PBStringField pBStringField;
        String str;
        boolean z16;
        JSONObject optJSONObject;
        List split$default;
        List split$default2;
        Intent intent = new Intent();
        if (isShowRedDot() && !hasUnreadMsgCntDot() && !getMHasUnreadInteract() && MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            } else {
                iRedTouchManager = null;
            }
            if (iRedTouchManager != null && (appInfo = iRedTouchManager.getAppInfo(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_PRO, "4050")) != null && (pBStringField = appInfo.buffer) != null && (str = pBStringField.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(str, "get()");
                JSONObject jSONObject = new JSONObject(str);
                String adId = jSONObject.optString("ad_id");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("msg");
                if (optJSONObject2 != null) {
                    Intrinsics.checkNotNullExpressionValue(adId, "adId");
                    if (adId.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && optJSONObject2.has(adId) && (optJSONObject = optJSONObject2.optJSONObject(adId)) != null) {
                        String extInfo = optJSONObject.optString(QZoneHelper.INTENT_EXTINFO);
                        Intrinsics.checkNotNullExpressionValue(extInfo, "extInfo");
                        split$default = StringsKt__StringsKt.split$default((CharSequence) extInfo, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
                        Iterator it = split$default.iterator();
                        while (it.hasNext()) {
                            split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                            if (split$default2.size() == 2) {
                                intent.putExtra((String) split$default2.get(0), (String) split$default2.get(1));
                            }
                        }
                    }
                }
            }
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService
    public boolean hasTianShuServiceDot() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        BusinessInfoCheckUpdate.AppInfo appInfo = ((IRedTouchManager) runtimeService).getAppInfo(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_PRO, "4050");
        if (appInfo == null || appInfo.iNewFlag.get() == 0 || appInfo.exposure_max.get() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService
    /* renamed from: hasUnreadInteractCntDot, reason: from getter */
    public boolean getMHasUnreadInteract() {
        return this.mHasUnreadInteract;
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService
    public boolean hasUnreadMsgCntDot() {
        if (this.mIsMsgInitialized && this.mLastReadMsgCnt < this.mTotalUnreadMsgCnt) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService
    public boolean isShowRedDot() {
        if (!hasUnreadMsgCntDot() && !getMHasUnreadInteract() && !hasTianShuServiceDot()) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        AppInterface appInterface;
        x nearbyProService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (nearbyProService = iKernelService.getNearbyProService()) != null) {
            nearbyProService.addKernelNearbyProListener(this.mNearbyProListener);
            j.c().e(TAG, "onCreate getNearByAllContactsUnreadCnt");
            nearbyProService.Y(new IOperateCallback() { // from class: com.tencent.mobileqq.nearbypro.entry.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NearbyProEntryUnreadServiceImpl.onCreate$lambda$1$lambda$0(i3, str);
                }
            });
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        this.mInteractMsgRepo.d(false, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.nearbypro.entry.api.impl.NearbyProEntryUnreadServiceImpl$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num) {
                j.c().e("NearbyProEntryUnreadService", "getUnreadMsg result = " + num);
                if (num != null) {
                    NearbyProEntryUnreadServiceImpl.this.tryToUpdateInteractUnreadDot(num.intValue());
                }
            }
        });
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        AppInterface appInterface;
        x nearbyProService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (nearbyProService = iKernelService.getNearbyProService()) != null) {
            nearbyProService.removeKernelNearbyProListener(this.mNearbyProListener);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof NBPInteractivePushEvent) {
            tryToUpdateInteractUnreadDot(((NBPInteractivePushEvent) event).getUnreadNum());
        }
    }
}
