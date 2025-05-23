package com.tencent.qqnt.notification.impl;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.repo.TroopNotificationListRepo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.utils.p;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.k;
import com.tencent.qqnt.inner.observer.TroopNotificationChangedDispatcher;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsgType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyTemplateItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.notification.f;
import com.tencent.qqnt.troop.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0001oB\u0007\u00a2\u0006\u0004\bl\u0010mJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016Jy\u0010)\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\n2O\u0010(\u001aK\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\f0 j\u0002`'H\u0016J\u001a\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0+0*H\u0016J\u001e\u00100\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0.H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0015H\u0016J\u0010\u00103\u001a\u00020\f2\u0006\u00102\u001a\u00020\u000fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u000fH\u0016J\b\u00106\u001a\u00020\fH\u0016J\u001a\u00107\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010:\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u000108H\u0016J\b\u0010;\u001a\u00020\fH\u0016JP\u0010D\u001a\u00020\f2\u0006\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\b2\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020?\u0018\u00010>j\n\u0012\u0004\u0012\u00020?\u0018\u0001`@2\u001a\u0010C\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010>j\n\u0012\u0004\u0012\u00020B\u0018\u0001`@H\u0016J8\u0010J\u001a\u00020\f2\u0006\u0010<\u001a\u00020!2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0016Jh\u0010M\u001a\u00020\f2\u0006\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\u00052\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020?\u0018\u00010>j\n\u0012\u0004\u0012\u00020?\u0018\u0001`@2\u001a\u0010C\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010>j\n\u0012\u0004\u0012\u00020B\u0018\u0001`@H\u0016R\u0016\u0010E\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010NR\u0016\u0010F\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010OR\u0016\u0010P\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010OR\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010R\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010OR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR \u0010W\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u001b\u0010d\u001a\u00020_8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010a\u001a\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020!8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010k\u00a8\u0006p"}, d2 = {"Lcom/tencent/qqnt/notification/impl/TroopNotificationInnerServiceImpl;", "Lcom/tencent/qqnt/notification/ITroopNotificationInnerService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "", "obj", "", "getCacheContextKey", "category", "", "seq", "", "getCacheMsgKey", "", "updateFirstPageCache", "initAfterNTCreated", "Lcom/tencent/qqnt/notification/f;", "getLatestMsg", "getNotificationUnreadCount", "getNotificationUnhandledCount", "getNotificationUnreadUnhandledCount", "getNotificationUnreadExitCount", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/qqnt/troop/g;", "observer", "registerNotificationChangedObserver", "unregisterNotificationChangeObserver", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsgType;", QQBrowserActivity.KEY_MSG_TYPE, "groupCode", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errCode", "errMsg", "Lcom/tencent/qqnt/troop/OperateNotificationCallback;", "callback", "operateNotification", "", "", "getFirstPageNotification", "owner", "", "data", "saveNotificationMsg", "destroyNotificationMsg", "newMsg", "updateNotificationMsg", "msg", "removeNotificationMsg", "clearAllNotification", "getNotificationMsgFromCache", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "doubt", "curReadedSeq", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "Lkotlin/collections/ArrayList;", "notifies", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyTemplateItem;", DKConfiguration.Directory.TEMPLATES, "onGroupNotifiesUpdatedV2", "oldestUnreadSeq", "unreadCount", "unHandleCount", "unHandleAndUnreadCount", "memberQuitUnreadCount", "onGroupNotifiesUnreadCountUpdatedV2", "nextStartSeq", "hasMore", "onGroupSingleScreenNotifiesV2", "J", "I", "unhandledCount", "unreadUnhandledCount", "unreadExitCount", "Lcom/tencent/qqnt/notification/c;", "firstPageCacheInfo", "Lcom/tencent/qqnt/notification/c;", "", "notificationMsgCache", "Ljava/util/Map;", "", "cacheContextCounter", "Ljava/util/Set;", "Lcom/tencent/qqnt/inner/k;", "sequentialTaskControl", "Lcom/tencent/qqnt/inner/k;", "Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationListRepo;", "listRepo$delegate", "Lkotlin/Lazy;", "getListRepo", "()Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationListRepo;", "listRepo", "Lcom/tencent/qqnt/inner/observer/TroopNotificationChangedDispatcher;", "dispatcher$delegate", "getDispatcher", "()Lcom/tencent/qqnt/inner/observer/TroopNotificationChangedDispatcher;", "dispatcher", "isMainProcess", "()Z", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopNotificationInnerServiceImpl implements ITroopNotificationInnerService, IKernelGroupListener {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopNotificationInnerServiceImpl";

    @NotNull
    private final Set<Integer> cacheContextCounter;

    /* renamed from: dispatcher$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dispatcher;

    @NotNull
    private final com.tencent.qqnt.notification.c firstPageCacheInfo;

    /* renamed from: listRepo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy listRepo;

    @NotNull
    private final Map<String, f> notificationMsgCache;
    private long oldestUnreadSeq;

    @NotNull
    private final k sequentialTaskControl;
    private int unhandledCount;
    private int unreadCount;
    private int unreadExitCount;
    private int unreadUnhandledCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/notification/impl/TroopNotificationInnerServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.impl.TroopNotificationInnerServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationInnerServiceImpl() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.firstPageCacheInfo = new com.tencent.qqnt.notification.c();
        this.notificationMsgCache = new LinkedHashMap();
        this.cacheContextCounter = new LinkedHashSet();
        this.sequentialTaskControl = new k(TAG);
        lazy = LazyKt__LazyJVMKt.lazy(TroopNotificationInnerServiceImpl$listRepo$2.INSTANCE);
        this.listRepo = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopNotificationInnerServiceImpl$dispatcher$2.INSTANCE);
        this.dispatcher = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearAllNotification$lambda$3(TroopNotificationInnerServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.firstPageCacheInfo.b();
        this$0.getDispatcher().f();
    }

    private final int getCacheContextKey(Object obj) {
        return obj.hashCode();
    }

    private final String getCacheMsgKey(int category, long seq) {
        return category + "-" + seq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopNotificationChangedDispatcher getDispatcher() {
        return (TroopNotificationChangedDispatcher) this.dispatcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopNotificationListRepo getListRepo() {
        return (TroopNotificationListRepo) this.listRepo.getValue();
    }

    private final boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeNotificationMsg$lambda$2(TroopNotificationInnerServiceImpl this$0, f msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        this$0.firstPageCacheInfo.g(msg2, TroopNotificationInnerServiceImpl$removeNotificationMsg$1$1.INSTANCE);
        this$0.getDispatcher().h(msg2);
    }

    private final void updateFirstPageCache() {
        this.sequentialTaskControl.d(new TroopNotificationInnerServiceImpl$updateFirstPageCache$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateNotificationMsg$lambda$1(TroopNotificationInnerServiceImpl this$0, f newMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newMsg, "$newMsg");
        com.tencent.qqnt.notification.c.j(this$0.firstPageCacheInfo, newMsg, false, TroopNotificationInnerServiceImpl$updateNotificationMsg$1$1.INSTANCE, 2, null);
        this$0.getDispatcher().e(newMsg);
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    public void clearAllNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            bg.k(new Runnable() { // from class: com.tencent.qqnt.notification.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    TroopNotificationInnerServiceImpl.clearAllNotification$lambda$3(TroopNotificationInnerServiceImpl.this);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    public void destroyNotificationMsg(@NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.cacheContextCounter.remove(Integer.valueOf(getCacheContextKey(owner)));
        if (this.cacheContextCounter.isEmpty()) {
            this.notificationMsgCache.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "destroyNotificationMsg: owner=" + owner);
        }
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    @NotNull
    public Map<Integer, List<f>> getFirstPageNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Map) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        this.firstPageCacheInfo.k(this.oldestUnreadSeq);
        this.firstPageCacheInfo.c();
        this.firstPageCacheInfo.d();
        return this.firstPageCacheInfo.e();
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    @Nullable
    public f getLatestMsg() {
        Object firstOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<f> list = this.firstPageCacheInfo.e().get(0);
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            return (f) firstOrNull;
        }
        return null;
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    @Nullable
    public f getNotificationMsgFromCache(int category, long seq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (f) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(category), Long.valueOf(seq));
        }
        return this.notificationMsgCache.get(getCacheMsgKey(category, seq));
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public int getNotificationUnhandledCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.unhandledCount;
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public int getNotificationUnreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.unreadCount;
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public int getNotificationUnreadExitCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.unreadExitCount;
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public int getNotificationUnreadUnhandledCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.unreadUnhandledCount;
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    public void initAfterNTCreated() {
        s b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (isMainProcess() && (b16 = com.tencent.qqnt.f.f356721a.b()) != null) {
            b16.D(this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        s b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (isMainProcess() && (b16 = com.tencent.qqnt.f.f356721a.b()) != null) {
            b16.x0(this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
        am.a(this, j3, str, groupBulletinListResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupAdd(long j3) {
        am.b(this, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
        am.c(this, groupAllInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
        am.d(this, j3, groupArkInviteStateInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
        am.e(this, j3, groupBulletin);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
        am.f(this, j3, remindGroupBulletinMsg);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
        am.g(this, bulletinFeedsDownloadInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
        am.h(this, bulletinFeedsDownloadInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
        am.i(this, j3, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
        am.j(this, groupDetailInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupEssenceListChange(long j3) {
        am.k(this, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
        am.l(this, groupExtListUpdateType, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
        am.m(this, firstGroupBulletinInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupListInited(boolean z16) {
        am.n(this, z16);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
        am.o(this, groupListUpdateType, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
        am.p(this, j3, groupMemberLevelInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
        am.q(this, z16, j3, i3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupNotifiesUnreadCountUpdatedV2(boolean doubt, long oldestUnreadSeq, int unreadCount, int unHandleCount, int unHandleAndUnreadCount, int memberQuitUnreadCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(doubt), Long.valueOf(oldestUnreadSeq), Integer.valueOf(unreadCount), Integer.valueOf(unHandleCount), Integer.valueOf(unHandleAndUnreadCount), Integer.valueOf(memberQuitUnreadCount));
            return;
        }
        QLog.d(TAG, 1, "onGroupNotifiesUnreadCountUpdatedV2: doubt=" + doubt + ", oldestUnreadSeq=" + oldestUnreadSeq + ", unreadCount=" + unreadCount + ", unHandleCount=" + unHandleCount + ", unHandleAndUnreadCount=" + unHandleAndUnreadCount + ", memberQuitUnreadCount=" + memberQuitUnreadCount);
        if (!doubt) {
            this.unreadCount = unreadCount;
            this.unhandledCount = unHandleCount;
            this.oldestUnreadSeq = oldestUnreadSeq;
            this.unreadUnhandledCount = unHandleAndUnreadCount;
            this.unreadExitCount = memberQuitUnreadCount;
            getDispatcher().i(unreadCount, this.unhandledCount, unHandleAndUnreadCount);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
        am.s(this, z16, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupNotifiesUpdatedV2(boolean doubt, long curReadedSeq, @Nullable ArrayList<GroupNotifyMsg> notifies, @Nullable ArrayList<GroupNotifyTemplateItem> templates) {
        Integer num;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(doubt), Long.valueOf(curReadedSeq), notifies, templates);
            return;
        }
        if (notifies != null) {
            num = Integer.valueOf(notifies.size());
        } else {
            num = null;
        }
        QLog.d(TAG, 1, "onGroupNotifiesUpdatedV2: doubt=" + doubt + ", curReadedSeq=" + curReadedSeq + ", notifies=" + num);
        if (notifies != null && (!notifies.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (templates != null && (!templates.isEmpty())) {
                z17 = true;
            }
            if (z17) {
                updateFirstPageCache();
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
        am.u(this, z16, j3, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupSingleScreenNotifiesV2(final boolean doubt, long curReadedSeq, long nextStartSeq, boolean hasMore, int category, @Nullable final ArrayList<GroupNotifyMsg> notifies, @Nullable ArrayList<GroupNotifyTemplateItem> templates) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(doubt), Long.valueOf(curReadedSeq), Long.valueOf(nextStartSeq), Boolean.valueOf(hasMore), Integer.valueOf(category), notifies, templates);
            return;
        }
        if (QLog.isColorLevel()) {
            Integer num2 = null;
            if (notifies != null) {
                num = Integer.valueOf(notifies.size());
            } else {
                num = null;
            }
            if (templates != null) {
                num2 = Integer.valueOf(templates.size());
            }
            QLog.d(TAG, 2, "onGroupSingleScreenNotifiesV2: doubt=" + doubt + ", curReadedSeq=" + curReadedSeq + ", nextStartSeq=" + nextStartSeq + ", hasMore=" + hasMore + ", category=" + category + ", notifies=" + num + ", templates=" + num2);
        }
        p.f302196a.b(new Function0<Unit>(doubt, notifies, this) { // from class: com.tencent.qqnt.notification.impl.TroopNotificationInnerServiceImpl$onGroupSingleScreenNotifiesV2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $doubt;
            final /* synthetic */ ArrayList<GroupNotifyMsg> $notifies;
            final /* synthetic */ TroopNotificationInnerServiceImpl this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$doubt = doubt;
                this.$notifies = notifies;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Boolean.valueOf(doubt), notifies, this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.qqnt.notification.c cVar;
                com.tencent.qqnt.notification.c cVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.$doubt) {
                    ArrayList<GroupNotifyMsg> arrayList = this.$notifies;
                    boolean z16 = false;
                    if (arrayList != null && arrayList.size() == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        cVar = this.this$0.firstPageCacheInfo;
                        if (cVar.e().get(-1000) == null) {
                            cVar2 = this.this$0.firstPageCacheInfo;
                            cVar2.h(-1000);
                        }
                    }
                }
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
        am.w(this, j3, groupStatisticInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
        am.x(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
        am.y(this, j3, z16, z17);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
        am.z(this, joinGroupNotifyMsg);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
        am.A(this, j3, dataSource, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
        am.B(this, groupMemberListChangeInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
        am.C(this, str, str2, arrayList, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
        am.D(this, j3, arrayList);
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public void operateNotification(@NotNull GroupNotifyOperateType operateType, long seq, @NotNull GroupNotifyMsgType msgType, @NotNull String groupCode, @NotNull Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, operateType, Long.valueOf(seq), msgType, groupCode, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public void registerNotificationChangedObserver(@Nullable LifecycleOwner lifecycleOwner, @NotNull g observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) lifecycleOwner, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            getDispatcher().j(lifecycleOwner, observer);
        }
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    public void removeNotificationMsg(@NotNull final f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(TAG, 1, "removeNotificationMsg: msg=" + msg2);
        bg.k(new Runnable() { // from class: com.tencent.qqnt.notification.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationInnerServiceImpl.removeNotificationMsg$lambda$2(TroopNotificationInnerServiceImpl.this, msg2);
            }
        });
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    public void saveNotificationMsg(@NotNull LifecycleOwner owner, @NotNull List<f> data) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) owner, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(data, "data");
        this.cacheContextCounter.add(Integer.valueOf(getCacheContextKey(owner)));
        List<f> list = data;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            f fVar = (f) obj;
            linkedHashMap.put(getCacheMsgKey(fVar.c(), fVar.j().seq), obj);
        }
        this.notificationMsgCache.putAll(linkedHashMap);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveNotificationMsg: owner=" + owner);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public void unregisterNotificationChangeObserver(@Nullable g observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) observer);
        } else {
            if (observer == null) {
                return;
            }
            getDispatcher().k(observer);
        }
    }

    @Override // com.tencent.qqnt.notification.ITroopNotificationInnerService
    public void updateNotificationMsg(@NotNull final f newMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsg, "newMsg");
        QLog.d(TAG, 1, "updateNotificationMsg: newMsg=" + newMsg);
        bg.k(new Runnable() { // from class: com.tencent.qqnt.notification.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationInnerServiceImpl.updateNotificationMsg$lambda$1(TroopNotificationInnerServiceImpl.this, newMsg);
            }
        });
    }
}
