package com.tencent.mobileqq.activity.aio.drawer;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import bt.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.api.observer.f;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.troop.utils.TroopDrawerScrollChangedEvent;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u001a\u0012B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u001b\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0007J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u0019\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/drawer/TroopAppShortcutDrawer;", "Lcom/tencent/aio/frame/api/c;", "Lbt/a;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/frame/api/d;", "", "l", DomainData.DOMAIN_NAME, "", "troopUin", "", "reportFrom", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "scrollX", "oldScrollX", "b", "onResume", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lbt/a$a;", "param", "a", "Lcom/tencent/aio/data/AIOSession;", "Lcom/tencent/aio/data/AIOSession;", "Lcom/tencent/mobileqq/troop/troopapps/TroopAppShortcutContainer;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopapps/TroopAppShortcutContainer;", "mTroopAppShortcutContainer", "D", "I", "Lcom/tencent/mobileqq/troop/api/observer/f;", "E", "Lcom/tencent/mobileqq/troop/api/observer/f;", "mTroopPushObserver", "<init>", "(Lcom/tencent/aio/data/AIOSession;)V", UserInfo.SEX_FEMALE, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class TroopAppShortcutDrawer extends com.tencent.aio.frame.api.c implements bt.a, LifecycleObserver, com.tencent.aio.frame.api.d {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TroopAppShortcutContainer mTroopAppShortcutContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private int reportFrom;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private f mTroopPushObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOSession param;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/drawer/TroopAppShortcutDrawer$b;", "Lcom/tencent/mobileqq/troop/api/observer/f;", "", "troopUin", "", "reason", "Lcom/tencent/mobileqq/troop/api/handler/ITroopPushHandler$PushType;", "pushType", "", "b", "a", "Lcom/tencent/aio/data/AIOSession;", "D", "Lcom/tencent/aio/data/AIOSession;", "param", "Lmqq/util/WeakReference;", "Lcom/tencent/aio/frame/api/e;", "kotlin.jvm.PlatformType", "E", "Lmqq/util/WeakReference;", "getControllerRef", "()Lmqq/util/WeakReference;", "controllerRef", "controller", "<init>", "(Lcom/tencent/aio/data/AIOSession;Lcom/tencent/aio/frame/api/e;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends f {

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final AIOSession param;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final WeakReference<com.tencent.aio.frame.api.e> controllerRef;

        public b(@NotNull AIOSession param, @NotNull com.tencent.aio.frame.api.e controller) {
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

    public TroopAppShortcutDrawer(@NotNull AIOSession param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.reportFrom = 1;
    }

    private final void l() {
        if (this.mTroopPushObserver == null) {
            this.mTroopPushObserver = new b(this.param, g());
        }
        QQAppInterface f16 = TroopUtils.f();
        if (f16 != null) {
            f16.addObserver(this.mTroopPushObserver);
        }
    }

    private final void m(String troopUin, int reportFrom, View rootView) {
        VideoReport.setPageId(rootView, "pg_group_app");
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(reportFrom));
        hashMap.put("group_id", troopUin);
        VideoReport.setPageParams(rootView, new PageParams(hashMap));
        VideoReport.traversePage(rootView);
    }

    private final void n() {
        QQAppInterface f16;
        if (this.mTroopPushObserver != null && (f16 = TroopUtils.f()) != null) {
            f16.removeObserver(this.mTroopPushObserver);
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
            TroopAppShortcutContainer troopAppShortcutContainer = this.mTroopAppShortcutContainer;
            if (troopAppShortcutContainer != null) {
                troopAppShortcutContainer.P(bVar.getSource());
            }
        }
    }

    @Override // com.tencent.aio.frame.api.d
    public void b(int scrollX, int oldScrollX) {
        View l3;
        View l16;
        boolean z16;
        View l17;
        SimpleEventBus.getInstance().dispatchEvent(new TroopDrawerScrollChangedEvent(oldScrollX, scrollX));
        boolean z17 = false;
        if (oldScrollX < scrollX && scrollX > 0) {
            TroopAppShortcutContainer troopAppShortcutContainer = this.mTroopAppShortcutContainer;
            if (troopAppShortcutContainer != null && troopAppShortcutContainer.w()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.d("NTTroopAppShortcutDrawer", 4, "start open");
                TroopAppShortcutContainer troopAppShortcutContainer2 = this.mTroopAppShortcutContainer;
                if (troopAppShortcutContainer2 != null && (l17 = troopAppShortcutContainer2.l()) != null) {
                    String str = su3.b.b(this.param).f179559f;
                    if (str == null) {
                        str = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str, "param.getSessionInfo().troopUin ?: \"\"");
                    }
                    m(str, this.reportFrom, l17);
                    VideoReport.reportPgIn(l17);
                }
                TroopAppShortcutContainer troopAppShortcutContainer3 = this.mTroopAppShortcutContainer;
                if (troopAppShortcutContainer3 != null) {
                    troopAppShortcutContainer3.E();
                    return;
                }
                return;
            }
        }
        if (oldScrollX < scrollX) {
            TroopAppShortcutContainer troopAppShortcutContainer4 = this.mTroopAppShortcutContainer;
            if (troopAppShortcutContainer4 != null && (l16 = troopAppShortcutContainer4.l()) != null && scrollX == l16.getWidth()) {
                z17 = true;
            }
            if (z17) {
                QLog.d("NTTroopAppShortcutDrawer", 4, "opened");
                TroopAppShortcutContainer troopAppShortcutContainer5 = this.mTroopAppShortcutContainer;
                if (troopAppShortcutContainer5 != null) {
                    troopAppShortcutContainer5.P(1);
                }
                TroopAppShortcutContainer troopAppShortcutContainer6 = this.mTroopAppShortcutContainer;
                if (troopAppShortcutContainer6 != null) {
                    troopAppShortcutContainer6.D();
                    return;
                }
                return;
            }
        }
        if (oldScrollX > 0 && scrollX == 0) {
            QLog.d("NTTroopAppShortcutDrawer", 4, AudioContext.State.CLOSED);
            TroopAppShortcutContainer troopAppShortcutContainer7 = this.mTroopAppShortcutContainer;
            if (troopAppShortcutContainer7 != null) {
                troopAppShortcutContainer7.C();
                troopAppShortcutContainer7.R();
            }
            TroopAppShortcutContainer troopAppShortcutContainer8 = this.mTroopAppShortcutContainer;
            if (troopAppShortcutContainer8 != null && (l3 = troopAppShortcutContainer8.l()) != null) {
                VideoReport.reportPgOut(l3);
            }
            this.reportFrom = 1;
        }
    }

    @Override // com.tencent.aio.frame.api.c
    public void d(@NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        super.d(container);
        TroopAppShortcutContainer troopAppShortcutContainer = this.mTroopAppShortcutContainer;
        if (troopAppShortcutContainer != null) {
            troopAppShortcutContainer.B();
        }
        this.mTroopAppShortcutContainer = null;
        n();
    }

    @Override // com.tencent.aio.frame.api.c
    @Nullable
    public View j() {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return null;
        }
        final String j3 = this.param.c().j();
        Manager manager = qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        if (((TroopManager) manager).V(j3)) {
            return null;
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(j3);
        if (troopInfoFromCache == null || !troopInfoFromCache.hadJoinTroop()) {
            g().h(false);
        }
        l();
        final Context f16 = f();
        final SessionInfo b16 = su3.b.b(this.param);
        this.mTroopAppShortcutContainer = new TroopAppShortcutContainer(j3, this, f16, b16) { // from class: com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer$getRightFrame$1
            final /* synthetic */ TroopAppShortcutDrawer S;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type android.app.Activity");
                Activity activity = (Activity) f16;
            }

            @Override // com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer
            public void y(boolean bAnim) {
                com.tencent.aio.frame.api.e.g(this.S.g(), 0, 1, null);
            }
        };
        i().getLifecycle().addObserver(this);
        g().a(this);
        TroopAppShortcutContainer troopAppShortcutContainer = this.mTroopAppShortcutContainer;
        if (troopAppShortcutContainer == null) {
            return null;
        }
        return troopAppShortcutContainer.l();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        TroopAppShortcutContainer troopAppShortcutContainer = this.mTroopAppShortcutContainer;
        if (troopAppShortcutContainer != null) {
            troopAppShortcutContainer.B();
        }
        this.mTroopAppShortcutContainer = null;
        i().getLifecycle().removeObserver(this);
        g().c(this);
        n();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        TroopAppShortcutContainer troopAppShortcutContainer;
        if (g().i() && (troopAppShortcutContainer = this.mTroopAppShortcutContainer) != null) {
            troopAppShortcutContainer.I();
        }
    }
}
