package com.tencent.hippykotlin.demo.pages.base.common;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.OpenTelemetryModule;
import com.tencent.hippykotlin.demo.pages.base.module.AddWindowModule;
import com.tencent.hippykotlin.demo.pages.base.module.CalendarModule;
import com.tencent.hippykotlin.demo.pages.base.module.QQPermissionModule;
import com.tencent.hippykotlin.demo.pages.base.module.QQSearchModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QKRNetworkModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQAppModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQHippyModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyBundleModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyCalendarModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyDataModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyFontModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyMediaModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPageDataCacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPerformanceModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQOfflineModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQRedPointModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQWidgetModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CommonModulesKt {
    public static final void registerCommonModules(Pager pager) {
        pager.registerModule("HRBridgeModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$1
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new BridgeModule();
            }
        });
        pager.registerModule("HROpenTelemetryModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$2
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new OpenTelemetryModule();
            }
        });
        pager.registerModule("HRShareModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$3
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new ShareModule();
            }
        });
        pager.registerModule("HRAddWindowModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$4
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new AddWindowModule();
            }
        });
        pager.registerModule("HRCacheModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$5
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new CacheModule();
            }
        });
        pager.registerModule("CalendarModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$6
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new CalendarModule();
            }
        });
        pager.registerModule("QKRNetworkModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$7
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QKRNetworkModule();
            }
        });
        pager.registerModule("QQKuiklyPlatformApi", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$8
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQKuiklyPlatformApi();
            }
        });
        pager.registerModule("QQOfflineModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$9
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQOfflineModule();
            }
        });
        pager.registerModule("QQRedPointModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$10
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQRedPointModule();
            }
        });
        pager.registerModule("QQKuiklyHippyModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$11
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQHippyModule();
            }
        });
        pager.registerModule("QQKuiklyPerformanceModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$12
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQKuiklyPerformanceModule();
            }
        });
        pager.registerModule("QQKuiklyMediaModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$13
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQKuiklyMediaModule();
            }
        });
        pager.registerModule("QQAppModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$14
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQAppModule();
            }
        });
        pager.registerModule("QQKuiklyFontModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$15
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQKuiklyFontModule();
            }
        });
        pager.registerModule("QQKuiklyBundleModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$16
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQKuiklyBundleModule();
            }
        });
        pager.registerModule("QQWidgetModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$17
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQWidgetModule();
            }
        });
        pager.registerModule("QQUIModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$18
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQUIModule();
            }
        });
        pager.registerModule("QQKuiklyDataModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$19
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQKuiklyDataModule();
            }
        });
        pager.registerModule("QQKuiklyPageDataCacheModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$20
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQKuiklyPageDataCacheModule();
            }
        });
        pager.registerModule("QQSearchModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$21
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQSearchModule();
            }
        });
        pager.registerModule("QQKuiklyCalendarModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$22
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQKuiklyCalendarModule();
            }
        });
        pager.registerModule("QQPermissionModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$23
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQPermissionModule();
            }
        });
        pager.registerModule("QQCommonNApiModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt$registerCommonModules$24
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQCommonNApiModule();
            }
        });
    }
}
