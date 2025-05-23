package com.tencent.mobileqq.zplan.meme.frameanim.manager;

import android.view.View;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.sharedengine.ZPlanShareEngineScene;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t74.l;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/meme/frameanim/manager/ZPlanFilamentAvatarNativeManager$jsEventListener$1", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFilamentAvatarNativeManager$jsEventListener$1 implements uk0.e {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZPlanFilamentAvatarNativeManager f334032d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanFilamentAvatarNativeManager$jsEventListener$1(ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager) {
        this.f334032d = zPlanFilamentAvatarNativeManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ZPlanFilamentAvatarNativeManager this$0) {
        ZPlanMemoryUsageReport zPlanMemoryUsageReport;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        zPlanMemoryUsageReport = this$0.memoryUsageReporter;
        zPlanMemoryUsageReport.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String pngPath, String savePath, ZPlanFilamentAvatarNativeManager this$0) {
        Intrinsics.checkNotNullParameter(pngPath, "$pngPath");
        Intrinsics.checkNotNullParameter(savePath, "$savePath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileUtils.copyFile(pngPath, savePath);
        this$0.E0(savePath);
    }

    @Override // uk0.e
    public void onEvent(String type, String eventData) {
        JSONObject b16;
        ReentrantLock reportLock;
        JSONObject b17;
        JSONObject b18;
        boolean z16;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        QLog.i("FilamentAvatar_NativeV2", 1, "onJsEvent. type: " + type + ", eventData: " + eventData);
        switch (type.hashCode()) {
            case -1577124611:
                if (type.equals("onAvatarResourceReady") && (b16 = com.tencent.zplan.common.utils.h.f385294a.b(eventData)) != null) {
                    this.f334032d.H().h(al0.a.INSTANCE.a(b16));
                    return;
                }
                return;
            case -1565730423:
                if (type.equals("onFilamentRenderFail")) {
                    JSONObject b19 = com.tencent.zplan.common.utils.h.f385294a.b(eventData);
                    String num = b19 != null ? Integer.valueOf(b19.optInt("errorCode")).toString() : null;
                    String optString = b19 != null ? b19.optString("errorMessage") : null;
                    this.f334032d.H().getReloadAvatarStep().m(false);
                    this.f334032d.H().getReloadAvatarStep().i(al0.a.INSTANCE.b());
                    reportLock = this.f334032d.getReportLock();
                    ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager = this.f334032d;
                    reportLock.lock();
                    try {
                        Map<String, String> C = zPlanFilamentAvatarNativeManager.C();
                        if (num == null) {
                            num = "-111001";
                        }
                        C.put("params_error_code", num);
                        Map<String, String> C2 = zPlanFilamentAvatarNativeManager.C();
                        if (optString == null) {
                            optString = "";
                        }
                        C2.put("params_error_message", optString);
                        zPlanFilamentAvatarNativeManager.C().put("params_engine_type", zPlanFilamentAvatarNativeManager.v0());
                        zPlanFilamentAvatarNativeManager.C().put("params_business_scene", String.valueOf(zPlanFilamentAvatarNativeManager.getScene()));
                        Unit unit = Unit.INSTANCE;
                        reportLock.unlock();
                        AbsZPlanFilamentAvatarManager.t(this.f334032d, false, 1, null);
                        return;
                    } finally {
                    }
                }
                return;
            case -865948652:
                if (type.equals("onSoLoadFinish") && (b17 = com.tencent.zplan.common.utils.h.f385294a.b(eventData)) != null) {
                    this.f334032d.H().e(al0.a.INSTANCE.a(b17));
                    return;
                }
                return;
            case 361827844:
                if (type.equals("onFirstFrameImageReady")) {
                    final ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager2 = this.f334032d;
                    ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZPlanFilamentAvatarNativeManager$jsEventListener$1.c(ZPlanFilamentAvatarNativeManager.this);
                        }
                    });
                    JSONObject b26 = com.tencent.zplan.common.utils.h.f385294a.b(eventData);
                    final String optString2 = b26 != null ? b26.optString("imagePath") : null;
                    if (optString2 == null) {
                        return;
                    }
                    final String y16 = AbsZPlanFilamentAvatarManager.y(this.f334032d, null, 1, null);
                    final ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager3 = this.f334032d;
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZPlanFilamentAvatarNativeManager$jsEventListener$1.d(optString2, y16, zPlanFilamentAvatarNativeManager3);
                        }
                    }, 64, null, true);
                    return;
                }
                return;
            case 1147068880:
                if (type.equals("onAnimationResourceReady") && (b18 = com.tencent.zplan.common.utils.h.f385294a.b(eventData)) != null) {
                    this.f334032d.H().g(al0.a.INSTANCE.a(b18));
                    return;
                }
                return;
            case 1621140201:
                if (type.equals("onFirstFrameRenderEnd")) {
                    l lVar = l.f435563a;
                    final ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager4 = this.f334032d;
                    lVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanFilamentAvatarNativeManager$jsEventListener$1$onEvent$2
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
                            AbsBusinessScene absBusinessScene;
                            ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager5 = ZPlanFilamentAvatarNativeManager.this;
                            absBusinessScene = zPlanFilamentAvatarNativeManager5.currScene;
                            ZPlanShareEngineScene zPlanShareEngineScene = absBusinessScene instanceof ZPlanShareEngineScene ? (ZPlanShareEngineScene) absBusinessScene : null;
                            zPlanFilamentAvatarNativeManager5.S(zPlanShareEngineScene != null ? zPlanShareEngineScene.getHandPosition() : null);
                            QLog.i("FilamentAvatar_NativeV2", 1, "first render. filamentTextureView.alpha = 1, hand position=" + ZPlanFilamentAvatarNativeManager.this.getHandPosition());
                            ZPlanFilamentAvatarNativeManager.this.a0();
                            View filamentTextureView = ZPlanFilamentAvatarNativeManager.this.getFilamentTextureView();
                            if (filamentTextureView != null) {
                                filamentTextureView.setAlpha(1.0f);
                            }
                            ZPlanFilamentAvatarNativeManager.this.Y(false);
                        }
                    });
                    z16 = this.f334032d.hasReportFirstRender;
                    if (z16) {
                        return;
                    }
                    this.f334032d.hasReportFirstRender = true;
                    this.f334032d.H().getReloadAvatarStep().m(true);
                    this.f334032d.H().getReloadAvatarStep().i(al0.a.INSTANCE.b());
                    reportLock = this.f334032d.getReportLock();
                    ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager5 = this.f334032d;
                    reportLock.lock();
                    try {
                        zPlanFilamentAvatarNativeManager5.C().put("params_cache_duration", String.valueOf(zPlanFilamentAvatarNativeManager5.H().getReloadAvatarStep().f()));
                        zPlanFilamentAvatarNativeManager5.C().put("params_error_code", "0");
                        zPlanFilamentAvatarNativeManager5.C().put("params_engine_type", zPlanFilamentAvatarNativeManager5.v0());
                        zPlanFilamentAvatarNativeManager5.C().put("params_business_scene", String.valueOf(zPlanFilamentAvatarNativeManager5.getScene()));
                        Unit unit2 = Unit.INSTANCE;
                        reportLock.unlock();
                        this.f334032d.Q();
                        return;
                    } finally {
                    }
                }
                return;
            default:
                return;
        }
    }
}
