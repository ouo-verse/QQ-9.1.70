package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import bt.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.api.observer.f;
import com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi;
import com.tencent.mobileqq.troop.troopapps.event.BackToAIO;
import com.tencent.mobileqq.troop.troopapps.event.CloseAIO;
import com.tencent.mobileqq.troop.troopapps.event.CloseFrame;
import com.tencent.mobileqq.troop.troopapps.event.RefreshData;
import com.tencent.mobileqq.troop.utils.TroopDrawerScrollChangedEvent;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatus;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ab;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0004\u0019\u0012D\u0015B\u000f\u0012\u0006\u0010\u0018\u001a\u00020!\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0007J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e`\u001fH\u0016R\u0014\u0010\u0018\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00109R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010$R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/drawer/TroopAppNewDrawer;", "Lcom/tencent/aio/frame/api/c;", "Lbt/a;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/frame/api/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopapps/event/CloseFrame;", "", DomainData.DOMAIN_NAME, "o", "", "scrollX", "oldScrollX", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "j", "b", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lbt/a$a;", "param", "a", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/aio/data/AIOSession;", "Lcom/tencent/aio/data/AIOSession;", BdhLogUtil.LogTag.Tag_Conn, "I", "reportFrom", "Lcom/tencent/mobileqq/troop/api/observer/f;", "D", "Lcom/tencent/mobileqq/troop/api/observer/f;", "mTroopPushObserver", "Lcom/tencent/mobileqq/troop/api/observer/b;", "E", "Lcom/tencent/mobileqq/troop/api/observer/b;", "mTroopMngObserver", "Lcom/tencent/mobileqq/activity/aio/drawer/TroopAppNewDrawer$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/aio/drawer/TroopAppNewDrawer$b;", "troopInfoChangedObserver", "G", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H", "Ljava/lang/String;", "troopUin", "Z", "init", "J", "width", "Landroidx/fragment/app/Fragment;", "K", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Lcom/tencent/aio/data/AIOSession;)V", "L", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class TroopAppNewDrawer extends com.tencent.aio.frame.api.c implements bt.a, LifecycleObserver, com.tencent.aio.frame.api.d, SimpleEventReceiver<CloseFrame> {

    /* renamed from: C, reason: from kotlin metadata */
    private int reportFrom;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private f mTroopPushObserver;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.api.observer.b mTroopMngObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private b troopInfoChangedObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean init;

    /* renamed from: J, reason: from kotlin metadata */
    private int width;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Fragment fragment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOSession param;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/drawer/TroopAppNewDrawer$b;", "Lcom/tencent/qqnt/troop/ab;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "newTroopInfo", "", "a", "Lcom/tencent/aio/data/AIOSession;", "Lcom/tencent/aio/data/AIOSession;", "param", "Lmqq/util/WeakReference;", "Lcom/tencent/aio/frame/api/e;", "kotlin.jvm.PlatformType", "b", "Lmqq/util/WeakReference;", "getControllerRef", "()Lmqq/util/WeakReference;", "controllerRef", "controller", "<init>", "(Lcom/tencent/aio/data/AIOSession;Lcom/tencent/aio/frame/api/e;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements ab {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOSession param;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<com.tencent.aio.frame.api.e> controllerRef;

        public b(@NotNull AIOSession param, @NotNull com.tencent.aio.frame.api.e controller) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.param = param;
            this.controllerRef = new WeakReference<>(controller);
        }

        @Override // com.tencent.qqnt.troop.ab
        public void a(@NotNull TroopInfo newTroopInfo) {
            Intrinsics.checkNotNullParameter(newTroopInfo, "newTroopInfo");
            if (this.controllerRef.get() != null && Intrinsics.areEqual(newTroopInfo.getTroopUin(), this.param.c().j())) {
                GroupStatus groupStatus = newTroopInfo.groupStatus;
                if (groupStatus == GroupStatus.KDELETE || newTroopInfo.memberRole == MemberRole.STRANGER) {
                    QLog.i("TroopAppNewDrawer", 1, "newTroopInfo " + groupStatus + ", " + newTroopInfo.memberRole);
                    com.tencent.aio.frame.api.e eVar = this.controllerRef.get();
                    if (eVar != null) {
                        com.tencent.aio.frame.api.e.g(eVar, 0, 1, null);
                    }
                    com.tencent.aio.frame.api.e eVar2 = this.controllerRef.get();
                    if (eVar2 != null) {
                        eVar2.h(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/drawer/TroopAppNewDrawer$c;", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "reqtype", "result", "", "troopUin", "", "l", "Lcom/tencent/aio/data/AIOSession;", "I", "Lcom/tencent/aio/data/AIOSession;", "param", "Lmqq/util/WeakReference;", "Lcom/tencent/aio/frame/api/e;", "kotlin.jvm.PlatformType", "J", "Lmqq/util/WeakReference;", "getControllerRef", "()Lmqq/util/WeakReference;", "controllerRef", "controller", "<init>", "(Lcom/tencent/aio/data/AIOSession;Lcom/tencent/aio/frame/api/e;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.b {

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final AIOSession param;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final WeakReference<com.tencent.aio.frame.api.e> controllerRef;

        public c(@NotNull AIOSession param, @NotNull com.tencent.aio.frame.api.e controller) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.param = param;
            this.controllerRef = new WeakReference<>(controller);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int reqtype, int result, @Nullable String troopUin) {
            if (Intrinsics.areEqual(troopUin, this.param.c().j()) && result == 0) {
                if (reqtype == 9 || reqtype == 2) {
                    com.tencent.aio.frame.api.e eVar = this.controllerRef.get();
                    if (eVar != null) {
                        com.tencent.aio.frame.api.e.g(eVar, 0, 1, null);
                    }
                    com.tencent.aio.frame.api.e eVar2 = this.controllerRef.get();
                    if (eVar2 != null) {
                        eVar2.h(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/drawer/TroopAppNewDrawer$d;", "Lcom/tencent/mobileqq/troop/api/observer/f;", "", "troopUin", "", "reason", "Lcom/tencent/mobileqq/troop/api/handler/ITroopPushHandler$PushType;", "pushType", "", "b", "a", "Lcom/tencent/aio/data/AIOSession;", "D", "Lcom/tencent/aio/data/AIOSession;", "param", "Lmqq/util/WeakReference;", "Lcom/tencent/aio/frame/api/e;", "kotlin.jvm.PlatformType", "E", "Lmqq/util/WeakReference;", "getControllerRef", "()Lmqq/util/WeakReference;", "controllerRef", "controller", "<init>", "(Lcom/tencent/aio/data/AIOSession;Lcom/tencent/aio/frame/api/e;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends f {

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final AIOSession param;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final WeakReference<com.tencent.aio.frame.api.e> controllerRef;

        public d(@NotNull AIOSession param, @NotNull com.tencent.aio.frame.api.e controller) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.param = param;
            this.controllerRef = new WeakReference<>(controller);
        }

        @Override // com.tencent.mobileqq.troop.api.observer.f
        protected void a(@Nullable String troopUin) {
            com.tencent.aio.frame.api.e eVar;
            if (troopUin != null && Intrinsics.areEqual(troopUin, this.param.c().j()) && (eVar = this.controllerRef.get()) != null) {
                eVar.h(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.f
        public void b(@Nullable String troopUin, int reason, @NotNull ITroopPushHandler.PushType pushType) {
            Intrinsics.checkNotNullParameter(pushType, "pushType");
            if (troopUin != null && Intrinsics.areEqual(troopUin, this.param.c().j()) && pushType == ITroopPushHandler.PushType.ONLINE) {
                com.tencent.aio.frame.api.e eVar = this.controllerRef.get();
                if (eVar != null) {
                    com.tencent.aio.frame.api.e.g(eVar, 0, 1, null);
                }
                com.tencent.aio.frame.api.e eVar2 = this.controllerRef.get();
                if (eVar2 != null) {
                    eVar2.h(false);
                }
            }
        }
    }

    public TroopAppNewDrawer(@NotNull AIOSession param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.reportFrom = 1;
        this.troopUin = param.c().j();
    }

    private final boolean l(int scrollX, int oldScrollX) {
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        if (oldScrollX < scrollX && scrollX > 0 && this.init) {
            Context f16 = f();
            Fragment fragment = null;
            if (f16 instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) f16;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                fragment = supportFragmentManager.findFragmentById(R.id.if5);
            }
            if (fragment == null) {
                return true;
            }
        }
        return false;
    }

    private final void m() {
        TroopInfo troopInfoFromCache;
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface != null && ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).isShowingAppShortCutBar(qQAppInterface, this.troopUin) && (troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.troopUin)) != null) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).refreshAppShortCutBarAppList(qQAppInterface, this.troopUin, (int) troopInfoFromCache.dwGroupClassExt);
        }
    }

    private final void n() {
        if (this.mTroopPushObserver == null) {
            this.mTroopPushObserver = new d(this.param, g());
        }
        if (this.mTroopMngObserver == null) {
            this.mTroopMngObserver = new c(this.param, g());
        }
        QQAppInterface f16 = TroopUtils.f();
        if (f16 != null) {
            f16.addObserver(this.mTroopPushObserver);
        }
        QQAppInterface f17 = TroopUtils.f();
        if (f17 != null) {
            f17.addObserver(this.mTroopMngObserver);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        if (this.troopInfoChangedObserver == null) {
            this.troopInfoChangedObserver = new b(this.param, g());
        }
        b bVar = this.troopInfoChangedObserver;
        if (bVar != null) {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).registerTroopInfoChangedObserver(i(), bVar);
        }
    }

    private final void o() {
        QQAppInterface f16;
        QQAppInterface f17;
        if (this.mTroopPushObserver != null && (f17 = TroopUtils.f()) != null) {
            f17.removeObserver(this.mTroopPushObserver);
        }
        if (this.mTroopMngObserver != null && (f16 = TroopUtils.f()) != null) {
            f16.removeObserver(this.mTroopMngObserver);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (this.troopInfoChangedObserver != null) {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).unregisterTroopInfoChangedObserver(this.troopInfoChangedObserver);
        }
    }

    @Override // bt.a
    public void a(@NotNull a.InterfaceC0149a param) {
        com.tencent.mobileqq.activity.aio.drawer.b bVar;
        Intrinsics.checkNotNullParameter(param, "param");
        if (param instanceof com.tencent.mobileqq.activity.aio.drawer.b) {
            bVar = (com.tencent.mobileqq.activity.aio.drawer.b) param;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            this.reportFrom = bVar.getSource();
        }
    }

    @Override // com.tencent.aio.frame.api.d
    public void b(int scrollX, int oldScrollX) {
        SimpleEventBus.getInstance().dispatchEvent(new TroopDrawerScrollChangedEvent(oldScrollX, scrollX));
        if (oldScrollX > 0 && scrollX == 0) {
            m();
            SimpleEventBus.getInstance().dispatchEvent(BackToAIO.INSTANCE);
            return;
        }
        if (oldScrollX < scrollX && scrollX == this.width && this.init) {
            QLog.d("TroopAppNewDrawer", 1, "drawer opened");
            SimpleEventBus.getInstance().dispatchEvent(RefreshData.INSTANCE);
            return;
        }
        if (oldScrollX < scrollX && scrollX > 0 && !this.init) {
            QLog.d("TroopAppNewDrawer", 1, "drawer start open");
            Fragment fragment = ((ITroopAppsApi) QRoute.api(ITroopAppsApi.class)).getFragment();
            this.fragment = fragment;
            if (fragment != null) {
                Context f16 = f();
                Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) f16;
                Bundle bundle = new Bundle();
                bundle.putString("troopUin", this.troopUin);
                bundle.putInt("pageType", 2);
                Fragment fragment2 = this.fragment;
                Intrinsics.checkNotNull(fragment2);
                fragment2.setArguments(bundle);
                try {
                    FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
                    Fragment fragment3 = this.fragment;
                    Intrinsics.checkNotNull(fragment3);
                    beginTransaction.add(R.id.if5, fragment3).addToBackStack(null).commitAllowingStateLoss();
                    this.init = true;
                    return;
                } catch (IllegalArgumentException e16) {
                    QLog.e("TroopAppNewDrawer", 1, "drawer open fail e: " + e16.getMessage());
                    return;
                }
            }
            return;
        }
        if (l(scrollX, oldScrollX)) {
            QLog.d("TroopAppNewDrawer", 1, "supportFragmentManager findFragmentById troopAppFragment is null");
            this.init = false;
        }
    }

    @Override // com.tencent.aio.frame.api.c
    public void d(@NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        super.d(container);
        o();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<CloseFrame>> getEventClass() {
        ArrayList<Class<CloseFrame>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(CloseFrame.class);
        return arrayListOf;
    }

    @Override // com.tencent.aio.frame.api.c
    @Nullable
    public View j() {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return null;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        if (((TroopManager) manager).V(this.troopUin)) {
            return null;
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.troopUin);
        if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
            n();
            i().getLifecycle().addObserver(this);
            g().a(this);
            this.rootView = LayoutInflater.from(f()).inflate(R.layout.f168548fv3, (ViewGroup) null);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = f().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            this.width = displayMetrics.widthPixels;
            return this.rootView;
        }
        g().h(false);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        if (r0.isAdded() == true) goto L10;
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDestroy() {
        boolean z16;
        i().getLifecycle().removeObserver(this);
        g().c(this);
        o();
        SimpleEventBus.getInstance().dispatchEvent(CloseAIO.INSTANCE);
        Fragment fragment = this.fragment;
        if (fragment != null) {
            if (fragment != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                Context f16 = f();
                Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentTransaction beginTransaction = ((FragmentActivity) f16).getSupportFragmentManager().beginTransaction();
                Fragment fragment2 = this.fragment;
                Intrinsics.checkNotNull(fragment2);
                beginTransaction.remove(fragment2).commitAllowingStateLoss();
                this.init = false;
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof CloseFrame) {
            com.tencent.aio.frame.api.e.g(g(), 0, 1, null);
        }
    }
}
