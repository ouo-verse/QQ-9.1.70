package com.tencent.mobileqq.zplan.smallhome.floatwindow;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEScaleEvent;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t74.u;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006J,\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010\"\u001a\u00020\u000bJ1\u0010%\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010(R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010,R\u0014\u00100\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010,R\u0014\u00109\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010:R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanFloatWindowManager;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e;", "wrapper", "", "j", "", "e", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "", "inStablePos", "isFromGame", "source", "l", "withNotify", "destroyFloatLogic", "g", "b", HippyTKDListViewAdapter.X, "y", "k", "", "f", "onApplicationForeground", "onApplicationBackground", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "i", "Lpk3/b;", "checkCallback", "c", "(Ljava/lang/Integer;Ljava/lang/String;Lpk3/b;)V", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeFloatView;", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeFloatView;", "floatWindowView", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e;", tl.h.F, "I", "currentMapId", "WIDTH", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "HEIGHT", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "X", "D", "Y", "E", "[I", "locationCache", "J", "startShowFloatTime", "G", "Z", "isApplicationForeground", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFloatWindowManager implements IGuardInterface {

    /* renamed from: C, reason: from kotlin metadata */
    private static final float X;

    /* renamed from: D, reason: from kotlin metadata */
    private static final int Y;

    /* renamed from: E, reason: from kotlin metadata */
    private static final int[] locationCache;

    /* renamed from: F, reason: from kotlin metadata */
    private static long startShowFloatTime;

    /* renamed from: G, reason: from kotlin metadata */
    private static boolean isApplicationForeground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static ZPlanSmallHomeFloatView floatWindowView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static e wrapper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final int HEIGHT;

    /* renamed from: d, reason: collision with root package name */
    public static final ZPlanFloatWindowManager f335646d = new ZPlanFloatWindowManager();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int currentMapId = -1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final int WIDTH = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f12417e);

    static {
        int dimensionPixelSize = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f12407d);
        HEIGHT = dimensionPixelSize;
        u.Companion companion = u.INSTANCE;
        float c16 = ((companion.c(BaseApplication.getContext()) / 2) - (r0 / 2)) - com.tencent.sqshow.zootopia.utils.i.c(14);
        X = c16;
        int b16 = ((companion.b(BaseApplication.getContext()) / 2) - (dimensionPixelSize / 2)) - 214;
        Y = b16;
        locationCache = new int[]{(int) c16, b16};
        startShowFloatTime = -1L;
        isApplicationForeground = true;
    }

    ZPlanFloatWindowManager() {
    }

    public final void b(final String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.ZPlanFloatWindowManager$checkFloatWhenDeleteMod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i3;
                int i16;
                int i17;
                String str = mapId;
                i3 = ZPlanFloatWindowManager.currentMapId;
                ZPlanModLoadStatusManagerForMain zPlanModLoadStatusManagerForMain = ZPlanModLoadStatusManagerForMain.f335706a;
                ZPlanModLoadStatusInfo h16 = zPlanModLoadStatusManagerForMain.h();
                QLog.i("ZPlanFloatWindowManager", 1, "checkFloatWhenDeleteMod " + str + ", currentMapId= " + i3 + ", curStatusInfo= " + (h16 != null ? h16.printSimpleInfo() : null));
                i16 = ZPlanFloatWindowManager.currentMapId;
                if (Intrinsics.areEqual(String.valueOf(i16), mapId)) {
                    ZPlanFloatWindowManager zPlanFloatWindowManager = ZPlanFloatWindowManager.f335646d;
                    i17 = ZPlanFloatWindowManager.currentMapId;
                    zPlanFloatWindowManager.g(i17, null, true, true);
                    ZPlanModLoadStatusInfo h17 = zPlanModLoadStatusManagerForMain.h();
                    if (Intrinsics.areEqual(h17 != null ? h17.getMapId() : null, mapId)) {
                        zPlanModLoadStatusManagerForMain.f();
                    }
                }
            }
        });
    }

    public final void c(Integer mapId, String scheme, final pk3.b checkCallback) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.ZPlanFloatWindowManager$checkNeedShowFloatWindowAfterExit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                pk3.b bVar = pk3.b.this;
                if (bVar != null) {
                    bVar.a(true, false);
                }
            }
        });
    }

    public final int e() {
        return currentMapId;
    }

    public final int[] f() {
        return locationCache;
    }

    public final void g(int mapId, String scheme, boolean withNotify, boolean destroyFloatLogic) {
        QLog.d("ZPlanFloatWindowManager", 1, "hideFloatWindow, currentMapId: " + currentMapId + ", mapId: " + mapId + ",withNotify:" + withNotify + ",destroyFloatLogic:" + destroyFloatLogic);
        if (currentMapId != mapId) {
            return;
        }
        j(wrapper);
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(e.INSTANCE.a());
        if (withNotify) {
            SimpleEventBus.getInstance().dispatchEvent(new ZPlanUEScaleEvent(currentMapId, scheme, "", 2, 0, 16, null), true);
        }
        if (destroyFloatLogic) {
            i.Companion companion = k74.i.INSTANCE;
            if (((kk3.b) companion.a(kk3.b.class)).isInMeeting()) {
                ((kk3.b) companion.a(kk3.b.class)).leaveRoom();
            }
        }
        ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = floatWindowView;
        if (zPlanSmallHomeFloatView != null) {
            zPlanSmallHomeFloatView.h();
        }
        currentMapId = -1;
    }

    public final boolean i() {
        return isApplicationForeground;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        QLog.i("ZPlanFloatWindowManager", 1, "onApplicationForeground");
        isApplicationForeground = true;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        QLog.i("ZPlanFloatWindowManager", 1, "onApplicationBackground");
        isApplicationForeground = false;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
        QLog.i("ZPlanFloatWindowManager", 1, "onBackgroundTimeTick");
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
        QLog.i("ZPlanFloatWindowManager", 1, "onBackgroundUnguardTimeTick");
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
        QLog.i("ZPlanFloatWindowManager", 1, "onLiteTimeTick");
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
        QLog.i("ZPlanFloatWindowManager", 1, "onScreensStateChanged");
    }

    private final void j(e wrapper2) {
        VideoReport.reportPgOut(wrapper2 != null ? wrapper2.z() : null);
    }

    public final void k(int x16, int y16) {
        if (x16 == 0 || y16 == 0) {
            return;
        }
        int[] iArr = locationCache;
        iArr[0] = x16;
        iArr[1] = y16;
    }

    public static /* synthetic */ void h(ZPlanFloatWindowManager zPlanFloatWindowManager, int i3, String str, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        if ((i16 & 8) != 0) {
            z17 = false;
        }
        zPlanFloatWindowManager.g(i3, str, z16, z17);
    }

    public static /* synthetic */ void d(ZPlanFloatWindowManager zPlanFloatWindowManager, Integer num, String str, pk3.b bVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            bVar = null;
        }
        zPlanFloatWindowManager.c(num, str, bVar);
    }

    public final void l(int mapId, String scheme, boolean inStablePos, boolean isFromGame, int source) {
    }
}
