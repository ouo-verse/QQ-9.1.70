package com.tencent.mobileqq.nearbypro.entry.api.impl;

import android.content.Intent;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.chats.event.NBPInteractivePushEvent;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadMgr;
import com.tencent.mobileqq.nearbypro.entry.api.impl.NearbyProEntryUnreadMgrImpl;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.event.TianshuRedDataChangeEvent;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUnreadInfo;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
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

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00010\u0018\u0000 82\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f` H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0006\u0010$\u001a\u00020\u0004J\b\u0010%\u001a\u00020\bH\u0016R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010*\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryUnreadMgrImpl;", "Lcom/tencent/mobileqq/nearbypro/entry/api/INearbyProEntryUnreadMgr;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "count", "", "from", "", "updateUnreadMsgCnt", "updateUnreadInteractCnt", "notifyEntryUnreadDotChanged", "getUnreadMsgCntFromMMKV", "updateUnreadMsgCntToMMKV", "getUnreadInteractCntFromMMKV", "updateInteractMsgCntToMMKV", "refreshUnreadInteractCnt", "getLastEntryReadCount", "setLastEntryReadCount", "getRealCount", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "syncTianshuRedDotCount", "clearUnreadInteractCnt", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/content/Intent;", "getJumpIntent", "getVisibleCount", "markEntryCountRead", "mUnreadMsgCnt", "I", "mUnreadInteractCnt", "mLastSyncTotal", "mLastSyncSuccess", "Z", "Lcom/tencent/mobileqq/nearbypro/chats/repo/d;", "mInteractMsgRepo", "Lcom/tencent/mobileqq/nearbypro/chats/repo/d;", "mLastEntryReadCountCache", "com/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryUnreadMgrImpl$b", "mNearbyProListener", "Lcom/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryUnreadMgrImpl$b;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProEntryUnreadMgrImpl implements INearbyProEntryUnreadMgr, SimpleEventReceiver<SimpleBaseEvent> {

    @NotNull
    private static final String NBP_ENTRY_LAST_ENTRY_READ_COUNT = "nbp_entry_last_entry_read_count_";

    @NotNull
    private static final String NBP_ENTRY_LAST_UNREAD_INTERACT_COUNT = "nbp_entry_last_unread_interact_count";

    @NotNull
    private static final String NBP_ENTRY_LAST_UNREAD_MSG_COUNT = "nbp_entry_last_unread_msg_count";

    @NotNull
    private static final String NEARBY_PRO_REDDOT_TIANSHU_PATH = "4050.0";

    @NotNull
    private static final String TAG = "NearbyProEntryUnreadMgrImpl";
    private boolean mLastSyncSuccess;
    private int mUnreadInteractCnt;
    private int mUnreadMsgCnt;
    private int mLastSyncTotal = -1;

    @NotNull
    private final com.tencent.mobileqq.nearbypro.chats.repo.d mInteractMsgRepo = new com.tencent.mobileqq.nearbypro.chats.repo.d();
    private int mLastEntryReadCountCache = -1;

    @NotNull
    private final b mNearbyProListener = new b();

    @NotNull
    private AtomicBoolean mInitialized = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryUnreadMgrImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProUnreadInfo;", "unreadCnt", "", "onNearbyAllContactsUnreadCntChanged", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements IKernelNearbyProListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(NearbyProEntryUnreadMgrImpl this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.updateUnreadMsgCnt((int) j3, "\u76d1\u542cAIO\u6d88\u606f\u6570\u53d8\u66f4");
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener
        public void onNearbyAllContactsUnreadCntChanged(@Nullable NearbyProUnreadInfo unreadCnt) {
            if (unreadCnt != null) {
                final long j3 = unreadCnt.unreadCnt;
                final NearbyProEntryUnreadMgrImpl nearbyProEntryUnreadMgrImpl = NearbyProEntryUnreadMgrImpl.this;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.entry.api.impl.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        NearbyProEntryUnreadMgrImpl.b.b(NearbyProEntryUnreadMgrImpl.this, j3);
                    }
                });
            }
        }
    }

    private final int getLastEntryReadCount() {
        if (this.mLastEntryReadCountCache == -1) {
            this.mLastEntryReadCountCache = c.a.d(j.d(), NBP_ENTRY_LAST_ENTRY_READ_COUNT + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), 0, null, false, 12, null);
        }
        return this.mLastEntryReadCountCache;
    }

    private final int getRealCount() {
        return this.mUnreadMsgCnt + this.mUnreadInteractCnt;
    }

    private final int getUnreadInteractCntFromMMKV() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeInt(NBP_ENTRY_LAST_UNREAD_INTERACT_COUNT + peekAppRuntime.getCurrentAccountUin(), 0);
    }

    private final int getUnreadMsgCntFromMMKV() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeInt(NBP_ENTRY_LAST_UNREAD_MSG_COUNT + peekAppRuntime.getCurrentAccountUin(), 0);
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
    public static final void onReceiveEvent$lambda$1(NearbyProEntryUnreadMgrImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.syncTianshuRedDotCount(false);
    }

    private final void refreshUnreadInteractCnt() {
        this.mInteractMsgRepo.d(false, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.nearbypro.entry.api.impl.NearbyProEntryUnreadMgrImpl$refreshUnreadInteractCnt$1
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
                NearbyProEntryUnreadMgrImpl.this.updateUnreadInteractCnt(num != null ? num.intValue() : 0, "\u4e3b\u52a8\u66f4\u65b0\u4e92\u52a8\u6d88\u606f\u6570");
            }
        });
    }

    private final void setLastEntryReadCount(int count) {
        this.mLastEntryReadCountCache = count;
        c.a.k(j.d(), NBP_ENTRY_LAST_ENTRY_READ_COUNT + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), count, null, false, 12, null);
    }

    private final void updateInteractMsgCntToMMKV(int count) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeInt(NBP_ENTRY_LAST_UNREAD_INTERACT_COUNT + peekAppRuntime.getCurrentAccountUin(), count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void updateUnreadInteractCnt(int count, String from) {
        j.c().e(TAG, "\u66f4\u65b0\u4e92\u52a8: count=" + count + ", from=" + from);
        if (this.mUnreadInteractCnt != count) {
            this.mUnreadInteractCnt = count;
            updateInteractMsgCntToMMKV(count);
        }
        syncTianshuRedDotCount(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void updateUnreadMsgCnt(int count, String from) {
        j.c().e(TAG, "\u66f4\u65b0AIO: count=" + count + ", from=" + from);
        if (this.mUnreadMsgCnt != count) {
            this.mUnreadMsgCnt = count;
            updateUnreadMsgCntToMMKV(count);
        }
        syncTianshuRedDotCount(false);
    }

    private final void updateUnreadMsgCntToMMKV(int count) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeInt(NBP_ENTRY_LAST_UNREAD_MSG_COUNT + peekAppRuntime.getCurrentAccountUin(), count);
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadMgr
    public void clearUnreadInteractCnt() {
        updateUnreadInteractCnt(0, "clearUnreadInteractCnt");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(NBPInteractivePushEvent.class, TianshuRedDataChangeEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadMgr
    @NotNull
    public Intent getJumpIntent() {
        AppRuntime peekAppRuntime;
        IRedTouchManager iRedTouchManager;
        boolean z16;
        boolean z17;
        JSONObject optJSONObject;
        List split$default;
        List split$default2;
        Intent intent = new Intent();
        try {
            peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        } catch (Exception e16) {
            j.c().d(TAG, "getJumpIntent: " + e16);
        }
        if (peekAppRuntime != null && (iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")) != null) {
            BusinessInfoCheckUpdate.AppInfo appInfo = iRedTouchManager.getAppInfo(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_PRO, "4050");
            if (appInfo == null) {
                return intent;
            }
            j.c().e(TAG, "getJumpIntent: type=" + appInfo.type.get() + ", exposure_max=" + appInfo.exposure_max.get() + ", buffer=" + appInfo.buffer.get());
            if (appInfo.exposure_max.get() > 0 && appInfo.type.get() == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return intent;
            }
            JSONObject jSONObject = new JSONObject(appInfo.buffer.get());
            String adId = jSONObject.optString("ad_id");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("msg");
            if (optJSONObject2 != null) {
                Intrinsics.checkNotNullExpressionValue(adId, "adId");
                if (adId.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && optJSONObject2.has(adId) && (optJSONObject = optJSONObject2.optJSONObject(adId)) != null) {
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
            return intent;
        }
        return intent;
    }

    public final synchronized int getVisibleCount() {
        return 0;
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadMgr
    public synchronized void markEntryCountRead() {
        int realCount = getRealCount();
        j.c().e(TAG, "markEntryRead() realCount=" + realCount);
        setLastEntryReadCount(realCount);
        syncTianshuRedDotCount(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        Object obj;
        boolean z16;
        if (event instanceof NBPInteractivePushEvent) {
            updateUnreadInteractCnt(((NBPInteractivePushEvent) event).getUnreadNum(), "\u76d1\u542c\u4e92\u52a8\u901a\u77e5\u53d8\u66f4");
            return;
        }
        if (event instanceof TianshuRedDataChangeEvent) {
            Iterator<T> it = ((TianshuRedDataChangeEvent) event).getList().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((com.tencent.mobileqq.tianshu.bean.a) obj).a(), NEARBY_PRO_REDDOT_TIANSHU_PATH)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            j.c().e(TAG, "onReceiveEvent: TianshuRedDataChangeEvent, isNearbyTianshuLoaded=" + z16);
            if (z16) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.entry.api.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        NearbyProEntryUnreadMgrImpl.onReceiveEvent$lambda$1(NearbyProEntryUnreadMgrImpl.this);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadMgr
    public synchronized void syncTianshuRedDotCount(boolean force) {
        if (!this.mInitialized.get()) {
            return;
        }
        if (!TianshuRedTouch.INSTANCE.j()) {
            return;
        }
        if (force) {
            refreshUnreadInteractCnt();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
        int visibleCount = getVisibleCount();
        if (!force && this.mLastSyncTotal == visibleCount && this.mLastSyncSuccess) {
            j.c().e(TAG, "\u540c\u6b65\u5929\u67a2[\u5ffd\u7565]: visibleTotal=" + visibleCount + ", realTotal=" + getRealCount() + ", aio=" + this.mUnreadMsgCnt + ", \u4e92\u52a8=" + this.mUnreadInteractCnt);
            return;
        }
        this.mLastSyncTotal = visibleCount;
        this.mLastSyncSuccess = iRedTouchManager.updateNumberRedInfoByPath(NEARBY_PRO_REDDOT_TIANSHU_PATH, visibleCount);
        j.c().e(TAG, "\u540c\u6b65\u5929\u67a2: visibleTotal=" + visibleCount + ", realTotal=" + getRealCount() + ", aio=" + this.mUnreadMsgCnt + ", \u4e92\u52a8=" + this.mUnreadInteractCnt + ", success=" + this.mLastSyncSuccess + ", force=" + force);
        notifyEntryUnreadDotChanged();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
