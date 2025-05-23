package com.tencent.mobileqq.aio.notification.impl;

import androidx.annotation.UiThread;
import com.tencent.aio.main.businesshelper.b;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar;
import com.tencent.mobileqq.activity.aio.tips.UpgradeBigTroopNtTipsBar;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.base.AIONotificationEvent;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.aio.notification.base.d;
import com.tencent.mobileqq.aio.notification.d;
import com.tencent.mobileqq.aio.notification.debug.AIODebugNotificationProvider;
import com.tencent.mobileqq.aio.notification.e;
import com.tencent.mobileqq.aio.reserve1.toptip.NetStateTipsBar;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkTipsBar;
import com.tencent.mobileqq.dt.tip.O3AIONotifyBannerTipsBar;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.listentogether.nt.ListenTogetherHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.tipsbar.TroopSecurityTipsBanner;
import com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar;
import com.tencent.mobileqq.troop.troopownertask.TroopOwnerTaskTipsBar;
import com.tencent.mobileqq.troop.trooptodo.TroopToDoHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.toptip.LocationShareTipsBar;
import com.tencent.qqnt.aio.toptip.VideoStatusTipsBar;
import com.tencent.qqnt.aio.toptips.c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010+R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u00102R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00100R\"\u00109\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020 058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/aio/notification/impl/AIONotificationManager;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/qqnt/aio/toptips/c;", "Lcom/tencent/mobileqq/aio/notification/c;", "", "v", "t", "", "event", "w", "u", "Lcom/tencent/mobileqq/aio/notification/d;", "provider", "", ReportConstant.COSTREPORT_PREFIX, "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/qqnt/aio/toptips/b;", "tipsBarTask", "e", h.F, "needAnim", "i", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "uiModel", "c", "token", "j", "g", "k", "Lcom/tencent/aio/api/runtime/a;", "a", "b", "d", "Z", "isProviderInit", "hadDestroy", "", "f", "Ljava/util/List;", "pendingEvent", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "notificationProviderList", "", "Lcom/tencent/mobileqq/aio/notification/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "uiModelCompatMap", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationManager implements com.tencent.aio.main.businesshelper.h, c, com.tencent.mobileqq.aio.notification.c {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/tips/aio_tips_inject_config.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<d>> D;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isProviderInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hadDestroy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> pendingEvent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b helperParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<d> notificationProviderList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<e, IAIONotificationUIModel> uiModelCompatMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/impl/AIONotificationManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.impl.AIONotificationManager$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<d>> arrayList = new ArrayList<>();
        D = arrayList;
        arrayList.add(NetStateTipsBar.class);
        arrayList.add(com.tencent.mobileqq.aio.reserve1.toptip.c.class);
        arrayList.add(TroopOwnerTaskTipsBar.class);
        arrayList.add(TroopToDoHelper.class);
        arrayList.add(VideoStatusTipsBar.class);
        arrayList.add(ArkTipsBar.class);
        arrayList.add(BigTroopExpiredNtTipsBar.class);
        arrayList.add(UpgradeBigTroopNtTipsBar.class);
        arrayList.add(LocationShareTipsBar.class);
        arrayList.add(ListenTogetherHelper.class);
        arrayList.add(TroopAIONotifyBannerTipsBar.class);
        arrayList.add(O3AIONotifyBannerTipsBar.class);
        arrayList.add(TroopSecurityTipsBanner.class);
    }

    public AIONotificationManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pendingEvent = new ArrayList();
        this.notificationProviderList = new ArrayList();
        this.uiModelCompatMap = new LinkedHashMap();
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                AIONotificationManager.n(AIONotificationManager.this, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final AIONotificationManager this$0, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
        com.tencent.mobileqq.aio.notification.base.d.f192838a.a();
        AIONotificationUIUtils.f192828a.L(new Function0<Unit>(j3, this$0) { // from class: com.tencent.mobileqq.aio.notification.impl.AIONotificationManager$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $startTime;
            final /* synthetic */ AIONotificationManager this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$startTime = j3;
                this.this$0 = this$0;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), this$0);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                List list;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    long currentTimeMillis = System.currentTimeMillis() - this.$startTime;
                    list = this.this$0.pendingEvent;
                    int size = list.size();
                    z17 = this.this$0.hadDestroy;
                    QLog.d("AIONotificationManager", 2, "async init cost time: " + currentTimeMillis + ", eventCount=" + size + ", hadDestroy=" + z17);
                }
                z16 = this.this$0.hadDestroy;
                if (!z16) {
                    this.this$0.t();
                }
                this.this$0.isProviderInit = true;
            }
        });
    }

    private final boolean s(d provider) {
        boolean z16;
        Iterator<AIONotificationBusiId> it = provider.h().iterator();
        do {
            z16 = false;
            if (!it.hasNext()) {
                return false;
            }
            d.a aVar = com.tencent.mobileqq.aio.notification.base.d.f192838a.a().get(it.next());
            if (aVar != null && aVar.a()) {
                z16 = true;
            }
        } while (!z16);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void t() {
        try {
            Iterator<Integer> it = this.pendingEvent.iterator();
            while (it.hasNext()) {
                u(it.next().intValue());
            }
        } catch (Throwable th5) {
            QLog.e("AIONotificationManager", 1, "consumePendingEvent: ", th5);
        }
    }

    @UiThread
    private final void u(int event) {
        for (com.tencent.mobileqq.aio.notification.d dVar : this.notificationProviderList) {
            if (event == com.tencent.mobileqq.aio.notification.d.INSTANCE.a()) {
                if (s(dVar)) {
                    dVar.m(this, event, new Object[0]);
                }
            } else {
                dVar.m(this, event, new Object[0]);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        Object first;
        Iterator<Class<com.tencent.mobileqq.aio.notification.d>> it = D.iterator();
        while (it.hasNext()) {
            try {
                Constructor<?>[] constructors = it.next().getConstructors();
                Intrinsics.checkNotNullExpressionValue(constructors, "value.constructors");
                first = ArraysKt___ArraysKt.first(constructors);
                Object newInstance = ((Constructor) first).newInstance(new Object[0]);
                if (newInstance instanceof com.tencent.mobileqq.aio.notification.d) {
                    this.notificationProviderList.add(newInstance);
                }
            } catch (Exception e16) {
                QLog.e("AIONotificationManager", 1, "aio notification init error: ", e16);
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    throw e16;
                }
            }
        }
        if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            this.notificationProviderList.add(AIODebugNotificationProvider.f192877d);
        }
    }

    @UiThread
    private final void w(int event) {
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "onAIOEvent: isProviderInit=" + this.isProviderInit + ", event=" + event);
        }
        if (!this.isProviderInit) {
            this.pendingEvent.add(Integer.valueOf(event));
        } else {
            u(event);
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.c, com.tencent.mobileqq.aio.notification.c
    @NotNull
    public com.tencent.aio.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        return bVar.a();
    }

    @Override // com.tencent.qqnt.aio.toptips.c
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.aio.notification.c
    @NotNull
    public String c(@NotNull IAIONotificationUIModel uiModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uiModel);
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "addNotification: token=" + uiModel.getToken());
        }
        if (com.tencent.mobileqq.aio.notification.base.d.f192838a.a().containsKey(uiModel.b())) {
            b bVar = this.helperParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar = null;
            }
            bVar.a().e().h(new AIONotificationEvent.AddNotificationEvent(uiModel));
            return uiModel.getToken();
        }
        if (QLog.isColorLevel()) {
            QLog.e("AIONotificationManager", 2, "addNotification: error, \u8be5\u6d88\u606f\u7c7b\u578b\u6ca1\u6709\u6ce8\u518c\uff0c\u8bf7\u8054\u7cfbwybeeli/gricentwu");
        }
        return "";
    }

    @Override // com.tencent.qqnt.aio.toptips.c
    public boolean e(@NotNull com.tencent.qqnt.aio.toptips.b tipsBarTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) tipsBarTask)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(tipsBarTask, "tipsBarTask");
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "showTipsBar: " + tipsBarTask);
        }
        if (tipsBarTask instanceof e) {
            IAIONotificationUIModel e16 = ((e) tipsBarTask).e();
            IAIONotificationUIModel iAIONotificationUIModel = this.uiModelCompatMap.get(tipsBarTask);
            if (iAIONotificationUIModel != null) {
                j(iAIONotificationUIModel.getToken(), e16);
                return true;
            }
            this.uiModelCompatMap.put(tipsBarTask, e16);
            c(e16);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.notification.c
    public void g(@NotNull String token) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) token);
            return;
        }
        Intrinsics.checkNotNullParameter(token, "token");
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "removeNotification: " + token);
        }
        b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        bVar.a().e().h(new AIONotificationEvent.RemoveNotificationEvent(token));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 50;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AIONotificationManager";
    }

    @Override // com.tencent.qqnt.aio.toptips.c
    public void h(@Nullable com.tencent.qqnt.aio.toptips.b tipsBarTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tipsBarTask);
        } else {
            i(tipsBarTask, true);
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.c
    public void i(@Nullable com.tencent.qqnt.aio.toptips.b tipsBarTask, boolean needAnim) {
        IAIONotificationUIModel iAIONotificationUIModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tipsBarTask, Boolean.valueOf(needAnim));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "hideTipsBar: " + tipsBarTask);
        }
        if ((tipsBarTask instanceof e) && (iAIONotificationUIModel = this.uiModelCompatMap.get(tipsBarTask)) != null) {
            g(iAIONotificationUIModel.getToken());
            this.uiModelCompatMap.remove(tipsBarTask);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{4, 7, 8, 3, 9};
    }

    @Override // com.tencent.mobileqq.aio.notification.c
    public void j(@NotNull String token, @NotNull IAIONotificationUIModel uiModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) token, (Object) uiModel);
            return;
        }
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "updateNotification: token=" + token + ", uiModel=" + uiModel);
        }
        uiModel.a(token);
        if (com.tencent.mobileqq.aio.notification.base.d.f192838a.a().containsKey(uiModel.b())) {
            b bVar = this.helperParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar = null;
            }
            bVar.a().e().h(new AIONotificationEvent.UpdateNotificationEvent(uiModel));
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.c
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        bVar.a().e().h(AIONotificationEvent.CloseListEvent.f192820d);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "onCreate: ");
        }
        this.helperParam = param;
        w(com.tencent.mobileqq.aio.notification.d.INSTANCE.a());
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        h.a.b(this);
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "onDestroy: ");
        }
        this.hadDestroy = true;
        w(com.tencent.mobileqq.aio.notification.d.INSTANCE.c());
        this.notificationProviderList.clear();
        this.uiModelCompatMap.clear();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationManager", 2, "onMoveToState: state=" + state);
        }
        if (state != 3) {
            if (state != 4) {
                if (state != 7) {
                    if (state != 8) {
                        if (state == 9) {
                            w(com.tencent.mobileqq.aio.notification.d.INSTANCE.g());
                            return;
                        }
                        return;
                    }
                    w(com.tencent.mobileqq.aio.notification.d.INSTANCE.d());
                    return;
                }
                w(com.tencent.mobileqq.aio.notification.d.INSTANCE.f());
                return;
            }
            w(com.tencent.mobileqq.aio.notification.d.INSTANCE.b());
            return;
        }
        w(com.tencent.mobileqq.aio.notification.d.INSTANCE.e());
    }
}
