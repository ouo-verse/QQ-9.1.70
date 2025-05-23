package com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class IntimateSpaceFilamentView extends DeclarativeBaseView<IntimateSpaceFilamentViewAttr, IntimateSpaceFilamentViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$call(IntimateSpaceFilamentView intimateSpaceFilamentView, Object obj) {
        intimateSpaceFilamentView.getClass();
        e eVar = obj instanceof e ? (e) obj : null;
        if (eVar == null) {
            return;
        }
        String p16 = eVar.p("methodName");
        if (Intrinsics.areEqual(p16, "setSceneId")) {
            long n3 = eVar.n("methodParam");
            FilamentSceneMessageChannelModule filamentSceneMessageChannelModule = (FilamentSceneMessageChannelModule) b.a().acquireModule("FilamentSceneMessageChannelModule");
            filamentSceneMessageChannelModule.getClass();
            e eVar2 = new e();
            eVar2.u(WadlProxyConsts.SCENE_ID, n3);
            filamentSceneMessageChannelModule.toNative(false, "setSceneId", eVar2.toString(), null, true);
            KLog.INSTANCE.i("IntimateSpaceFilamentView", "messageChannelReady");
            Function0<Unit> function0 = ((IntimateSpaceFilamentViewAttr) intimateSpaceFilamentView.getAttr()).onMessageChannelReady;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(p16, "notifySceneReady")) {
            KLog.INSTANCE.i("IntimateSpaceFilamentView", "sceneReady");
            Function0<Unit> function02 = ((IntimateSpaceFilamentViewAttr) intimateSpaceFilamentView.getAttr()).onSceneReady;
            if (function02 != null) {
                function02.invoke();
                return;
            }
            return;
        }
        Utils.INSTANCE.logToNative("unknown method:" + p16);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new IntimateSpaceFilamentViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new IntimateSpaceFilamentViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void createRenderView() {
        super.createRenderView();
        KLog.INSTANCE.i("IntimateSpaceFilamentView", "createRenderView");
        onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        ((IntimateSpaceFilamentViewEvent) getEvent()).register(IECSearchBar.METHOD_SET_CALLBACK, new IntimateSpaceFilamentView$didInit$1(this));
        KLog.INSTANCE.i("IntimateSpaceFilamentView", "didInit");
    }

    public final void onResume() {
        KLog.INSTANCE.i("IntimateSpaceFilamentView", "onResume");
        AbstractBaseView.callRenderViewMethod$default(this, "onResume", null, null, 6, null);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "IntimateSpaceFilamentView";
    }
}
