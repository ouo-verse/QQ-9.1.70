package com.tencent.mobileqq.zplan.smallhome.floatwindow;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J(\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J$\u0010!\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020\u0007H\u0016R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010,R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010,R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeEventImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/f;", "", "getCurrentMapId", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "", "inStablePos", "source", "", "notifyShowFloatWindow", "destroyFloatLogic", "notifyHideFloatWindow", ViewStickEventHelper.IS_SHOW, "setIsFloat", "isFloat", "setIsShowUE", "isShowUE", "", "getLastLocation", "progress", "tips1", "tips2", "mapSetLoadingProgress", "version1", "version2", "version3", "mapSetGameVer", "mapCloseLoadingView", "exitLoadStatus", "Lpk3/c;", "callback", "h5ShowMapFloatWindow", "id", "setSmallHomeServerId", "getSmallHomeServerId", "isStarting", "setUEActivityStarting", "isUEActivityStarting", "isInAvatar", "setIsInAvatarScene", "isInAvatarScene", "isSmallHomeFloatWindowShowing", "Z", "isUEActivityShow", "SMALL_HOME_SERVICE_ID", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSmallHomeEventImpl implements com.tencent.mobileqq.zootopia.ipc.f {
    public static final String TAG = "ZPlanSmallHomeEventImpl";
    private String SMALL_HOME_SERVICE_ID = "smallHomeServiceId";
    private volatile boolean isInAvatarScene;
    private volatile boolean isSmallHomeFloatWindowShowing;
    private volatile boolean isUEActivityShow;
    private volatile boolean isUEActivityStarting;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeEventImpl$b", "Lpk3/b;", "", "isContinueNext", "hasPermissionGranted", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements pk3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pk3.c f335652a;

        b(pk3.c cVar) {
            this.f335652a = cVar;
        }

        @Override // pk3.b
        public void a(boolean isContinueNext, boolean hasPermissionGranted) {
            pk3.c cVar = this.f335652a;
            if (cVar != null) {
                cVar.a(isContinueNext, hasPermissionGranted);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyHideFloatWindow$lambda$1(int i3, boolean z16) {
        ZPlanFloatWindowManager.f335646d.g(i3, "", false, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyShowFloatWindow$lambda$0(int i3, String str, boolean z16, int i16) {
        ZPlanFloatWindowManager.f335646d.l(i3, str, z16, true, i16);
    }

    public void exitLoadStatus() {
        ZPlanModLoadStatusManagerForMain.f335706a.f();
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public int getCurrentMapId() {
        return ZPlanFloatWindowManager.f335646d.e();
    }

    public int[] getLastLocation() {
        return ZPlanFloatWindowManager.f335646d.f();
    }

    public String getSmallHomeServerId() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(this.SMALL_HOME_SERVICE_ID, "0");
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void h5ShowMapFloatWindow(String mapId, String scheme, pk3.c callback) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        ZPlanFloatWindowManager zPlanFloatWindowManager = ZPlanFloatWindowManager.f335646d;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(mapId);
        zPlanFloatWindowManager.c(intOrNull, scheme, new b(callback));
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public boolean isFloat() {
        QLog.i(TAG, 1, "isFloat, " + this.isSmallHomeFloatWindowShowing);
        return this.isSmallHomeFloatWindowShowing;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public boolean isInAvatarScene() {
        QLog.d(TAG, 1, "isInAvatarScene, " + this.isInAvatarScene);
        return this.isInAvatarScene;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public boolean isShowUE() {
        QLog.d(TAG, 1, "isShowUE, " + this.isUEActivityShow);
        return this.isUEActivityShow;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    /* renamed from: isUEActivityStarting, reason: from getter */
    public boolean getIsUEActivityStarting() {
        return this.isUEActivityStarting;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void mapCloseLoadingView(int mapId) {
        ZPlanModLoadStatusManagerForMain.f335706a.k(mapId);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void mapSetGameVer(int mapId, String version1, String version2, String version3) {
        Intrinsics.checkNotNullParameter(version1, "version1");
        Intrinsics.checkNotNullParameter(version2, "version2");
        Intrinsics.checkNotNullParameter(version3, "version3");
        ZPlanModLoadStatusManagerForMain.f335706a.l(mapId, version1, version2, version3);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void mapSetLoadingProgress(int mapId, int progress, String tips1, String tips2) {
        Intrinsics.checkNotNullParameter(tips1, "tips1");
        Intrinsics.checkNotNullParameter(tips2, "tips2");
        ZPlanModLoadStatusManagerForMain.f335706a.m(mapId, progress, tips1, tips2);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void notifyHideFloatWindow(final int mapId, final boolean destroyFloatLogic) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSmallHomeEventImpl.notifyHideFloatWindow$lambda$1(mapId, destroyFloatLogic);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void notifyShowFloatWindow(final int mapId, final String scheme, final boolean inStablePos, final int source) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.g
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSmallHomeEventImpl.notifyShowFloatWindow$lambda$0(mapId, scheme, inStablePos, source);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void setIsFloat(boolean isShow) {
        QLog.d(TAG, 1, "setIsFloat, " + isShow);
        this.isSmallHomeFloatWindowShowing = isShow;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void setIsInAvatarScene(boolean isInAvatar) {
        QLog.d(TAG, 1, "setIsInAvatarScene, " + isInAvatar);
        this.isInAvatarScene = isInAvatar;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void setIsShowUE(boolean isShow) {
        QLog.d(TAG, 1, "setIsShowUE, " + isShow);
        this.isUEActivityShow = isShow;
    }

    public void setSmallHomeServerId(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(this.SMALL_HOME_SERVICE_ID, id5);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.f
    public void setUEActivityStarting(boolean isStarting) {
        this.isUEActivityStarting = isStarting;
    }
}
