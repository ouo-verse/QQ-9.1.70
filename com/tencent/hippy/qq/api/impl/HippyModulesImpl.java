package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyModules;
import com.tencent.hippy.qq.module.HippyDebugToolModule;
import com.tencent.hippy.qq.module.HippyQQBridgeModule;
import com.tencent.hippy.qq.module.HippyQQCacheModule;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import com.tencent.hippy.qq.module.HippyQQReportModule;
import com.tencent.hippy.qq.module.JSIDataModule;
import com.tencent.hippy.qq.module.JSIDeviceModule;
import com.tencent.hippy.qq.module.JSIPreRequestModule;
import com.tencent.hippy.qq.module.JSITicketModule;
import com.tencent.hippy.qq.module.JSIUiModule;
import com.tencent.hippy.qq.module.QQBridgeModule;
import com.tencent.hippy.qq.module.QQDataModule;
import com.tencent.hippy.qq.module.QQDebugModule;
import com.tencent.hippy.qq.module.QQDebugToolModule;
import com.tencent.hippy.qq.module.QQDeviceModule;
import com.tencent.hippy.qq.module.QQEventCenterModule;
import com.tencent.hippy.qq.module.QQEventModule;
import com.tencent.hippy.qq.module.QQFontModule;
import com.tencent.hippy.qq.module.QQHippyBundleModule;
import com.tencent.hippy.qq.module.QQMiniAppModule;
import com.tencent.hippy.qq.module.QQNavigatorModule;
import com.tencent.hippy.qq.module.QQOfflineModule;
import com.tencent.hippy.qq.module.QQPayModule;
import com.tencent.hippy.qq.module.QQPublicPlatMsgModule;
import com.tencent.hippy.qq.module.QQRedPointModule;
import com.tencent.hippy.qq.module.QQRenderViewModule;
import com.tencent.hippy.qq.module.QQSensorModule;
import com.tencent.hippy.qq.module.QQTreasureCardModule;
import com.tencent.hippy.qq.module.QQWebDataModule;
import com.tencent.hippy.qq.module.QQWidgetModule;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyModulesImpl implements IHippyModules {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getDebugModules$0(HippyEngineContext hippyEngineContext) {
        return new HippyDebugToolModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getDebugModules$1(HippyEngineContext hippyEngineContext) {
        return new QQDebugToolModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$10(HippyEngineContext hippyEngineContext) {
        return new QQTreasureCardModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$11(HippyEngineContext hippyEngineContext) {
        return new QQDebugModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$12(HippyEngineContext hippyEngineContext) {
        return new QQFontModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$13(HippyEngineContext hippyEngineContext) {
        return new QQEventModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$14(HippyEngineContext hippyEngineContext) {
        return new QQDeviceModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$15(HippyEngineContext hippyEngineContext) {
        return new QQRedPointModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$16(HippyEngineContext hippyEngineContext) {
        return new QQWebDataModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$17(HippyEngineContext hippyEngineContext) {
        return new QQDataModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$18(HippyEngineContext hippyEngineContext) {
        return new JSIDeviceModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$19(HippyEngineContext hippyEngineContext) {
        return new JSIDataModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$2(HippyEngineContext hippyEngineContext) {
        return new HippyQQReportModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$20(HippyEngineContext hippyEngineContext) {
        return new JSIPreRequestModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$21(HippyEngineContext hippyEngineContext) {
        return new JSIUiModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$22(HippyEngineContext hippyEngineContext) {
        return new QQPayModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$23(HippyEngineContext hippyEngineContext) {
        return new QQPublicPlatMsgModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$24(HippyEngineContext hippyEngineContext) {
        return new JSITicketModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$25(HippyEngineContext hippyEngineContext) {
        return new QQEventCenterModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$26(HippyEngineContext hippyEngineContext) {
        return new QQMiniAppModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$27(HippyEngineContext hippyEngineContext) {
        return new QQWidgetModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$28(HippyEngineContext hippyEngineContext) {
        return new QQSensorModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$3(HippyEngineContext hippyEngineContext) {
        return new HippyQQCacheModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$4(HippyEngineContext hippyEngineContext) {
        return new HippyQQBridgeModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$5(HippyEngineContext hippyEngineContext) {
        return new HippyQQHttpModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$6(HippyEngineContext hippyEngineContext) {
        return new QQHippyBundleModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$7(HippyEngineContext hippyEngineContext) {
        return new QQNavigatorModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$8(HippyEngineContext hippyEngineContext) {
        return new QQOfflineModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$getReleaseModules$9(HippyEngineContext hippyEngineContext) {
        return new QQRenderViewModule(hippyEngineContext);
    }

    @Override // com.tencent.hippy.qq.api.IHippyModules
    public Object createQQBridgeModule(HippyEngineContext hippyEngineContext) {
        QQBridgeModule qQBridgeModule = new QQBridgeModule();
        qQBridgeModule.setEngineId(hippyEngineContext.getEngineId());
        return qQBridgeModule;
    }

    @Override // com.tencent.hippy.qq.api.IHippyModules
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getDebugModules(final HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.put(HippyDebugToolModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.ac
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getDebugModules$0;
                lambda$getDebugModules$0 = HippyModulesImpl.lambda$getDebugModules$0(HippyEngineContext.this);
                return lambda$getDebugModules$0;
            }
        });
        hashMap.put(QQDebugToolModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.ad
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getDebugModules$1;
                lambda$getDebugModules$1 = HippyModulesImpl.lambda$getDebugModules$1(HippyEngineContext.this);
                return lambda$getDebugModules$1;
            }
        });
        return hashMap;
    }

    @Override // com.tencent.hippy.qq.api.IHippyModules
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getReleaseModules(final HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.put(HippyQQReportModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.j
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$2;
                lambda$getReleaseModules$2 = HippyModulesImpl.lambda$getReleaseModules$2(HippyEngineContext.this);
                return lambda$getReleaseModules$2;
            }
        });
        hashMap.put(HippyQQCacheModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.l
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$3;
                lambda$getReleaseModules$3 = HippyModulesImpl.lambda$getReleaseModules$3(HippyEngineContext.this);
                return lambda$getReleaseModules$3;
            }
        });
        hashMap.put(HippyQQBridgeModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.t
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$4;
                lambda$getReleaseModules$4 = HippyModulesImpl.lambda$getReleaseModules$4(HippyEngineContext.this);
                return lambda$getReleaseModules$4;
            }
        });
        hashMap.put(HippyQQHttpModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.v
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$5;
                lambda$getReleaseModules$5 = HippyModulesImpl.lambda$getReleaseModules$5(HippyEngineContext.this);
                return lambda$getReleaseModules$5;
            }
        });
        hashMap.put(QQHippyBundleModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.w
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$6;
                lambda$getReleaseModules$6 = HippyModulesImpl.lambda$getReleaseModules$6(HippyEngineContext.this);
                return lambda$getReleaseModules$6;
            }
        });
        hashMap.put(QQNavigatorModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.x
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$7;
                lambda$getReleaseModules$7 = HippyModulesImpl.lambda$getReleaseModules$7(HippyEngineContext.this);
                return lambda$getReleaseModules$7;
            }
        });
        hashMap.put(QQOfflineModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.y
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$8;
                lambda$getReleaseModules$8 = HippyModulesImpl.lambda$getReleaseModules$8(HippyEngineContext.this);
                return lambda$getReleaseModules$8;
            }
        });
        hashMap.put(QQRenderViewModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.z
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$9;
                lambda$getReleaseModules$9 = HippyModulesImpl.lambda$getReleaseModules$9(HippyEngineContext.this);
                return lambda$getReleaseModules$9;
            }
        });
        hashMap.put(QQTreasureCardModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.aa
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$10;
                lambda$getReleaseModules$10 = HippyModulesImpl.lambda$getReleaseModules$10(HippyEngineContext.this);
                return lambda$getReleaseModules$10;
            }
        });
        hashMap.put(QQDebugModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.ab
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$11;
                lambda$getReleaseModules$11 = HippyModulesImpl.lambda$getReleaseModules$11(HippyEngineContext.this);
                return lambda$getReleaseModules$11;
            }
        });
        hashMap.put(QQFontModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.u
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$12;
                lambda$getReleaseModules$12 = HippyModulesImpl.lambda$getReleaseModules$12(HippyEngineContext.this);
                return lambda$getReleaseModules$12;
            }
        });
        hashMap.put(QQEventModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.ae
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$13;
                lambda$getReleaseModules$13 = HippyModulesImpl.lambda$getReleaseModules$13(HippyEngineContext.this);
                return lambda$getReleaseModules$13;
            }
        });
        hashMap.put(QQDeviceModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.af
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$14;
                lambda$getReleaseModules$14 = HippyModulesImpl.lambda$getReleaseModules$14(HippyEngineContext.this);
                return lambda$getReleaseModules$14;
            }
        });
        hashMap.put(QQRedPointModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.ag
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$15;
                lambda$getReleaseModules$15 = HippyModulesImpl.lambda$getReleaseModules$15(HippyEngineContext.this);
                return lambda$getReleaseModules$15;
            }
        });
        hashMap.put(QQWebDataModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.ah
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$16;
                lambda$getReleaseModules$16 = HippyModulesImpl.lambda$getReleaseModules$16(HippyEngineContext.this);
                return lambda$getReleaseModules$16;
            }
        });
        hashMap.put(QQDataModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.ai
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$17;
                lambda$getReleaseModules$17 = HippyModulesImpl.lambda$getReleaseModules$17(HippyEngineContext.this);
                return lambda$getReleaseModules$17;
            }
        });
        hashMap.put(JSIDeviceModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.aj
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$18;
                lambda$getReleaseModules$18 = HippyModulesImpl.lambda$getReleaseModules$18(HippyEngineContext.this);
                return lambda$getReleaseModules$18;
            }
        });
        hashMap.put(JSIDataModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.ak
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$19;
                lambda$getReleaseModules$19 = HippyModulesImpl.lambda$getReleaseModules$19(HippyEngineContext.this);
                return lambda$getReleaseModules$19;
            }
        });
        hashMap.put(JSIPreRequestModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.al
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$20;
                lambda$getReleaseModules$20 = HippyModulesImpl.lambda$getReleaseModules$20(HippyEngineContext.this);
                return lambda$getReleaseModules$20;
            }
        });
        hashMap.put(JSIUiModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.k
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$21;
                lambda$getReleaseModules$21 = HippyModulesImpl.lambda$getReleaseModules$21(HippyEngineContext.this);
                return lambda$getReleaseModules$21;
            }
        });
        hashMap.put(QQPayModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.m
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$22;
                lambda$getReleaseModules$22 = HippyModulesImpl.lambda$getReleaseModules$22(HippyEngineContext.this);
                return lambda$getReleaseModules$22;
            }
        });
        hashMap.put(QQPublicPlatMsgModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.n
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$23;
                lambda$getReleaseModules$23 = HippyModulesImpl.lambda$getReleaseModules$23(HippyEngineContext.this);
                return lambda$getReleaseModules$23;
            }
        });
        hashMap.put(JSITicketModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.o
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$24;
                lambda$getReleaseModules$24 = HippyModulesImpl.lambda$getReleaseModules$24(HippyEngineContext.this);
                return lambda$getReleaseModules$24;
            }
        });
        hashMap.put(QQEventCenterModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.p
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$25;
                lambda$getReleaseModules$25 = HippyModulesImpl.lambda$getReleaseModules$25(HippyEngineContext.this);
                return lambda$getReleaseModules$25;
            }
        });
        hashMap.put(QQMiniAppModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.q
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$26;
                lambda$getReleaseModules$26 = HippyModulesImpl.lambda$getReleaseModules$26(HippyEngineContext.this);
                return lambda$getReleaseModules$26;
            }
        });
        hashMap.put(QQWidgetModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.r
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$27;
                lambda$getReleaseModules$27 = HippyModulesImpl.lambda$getReleaseModules$27(HippyEngineContext.this);
                return lambda$getReleaseModules$27;
            }
        });
        hashMap.put(QQSensorModule.class, new Provider() { // from class: com.tencent.hippy.qq.api.impl.s
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase lambda$getReleaseModules$28;
                lambda$getReleaseModules$28 = HippyModulesImpl.lambda$getReleaseModules$28(HippyEngineContext.this);
                return lambda$getReleaseModules$28;
            }
        });
        ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).putQQGameWadlModule(hippyEngineContext, hashMap);
        return hashMap;
    }
}
