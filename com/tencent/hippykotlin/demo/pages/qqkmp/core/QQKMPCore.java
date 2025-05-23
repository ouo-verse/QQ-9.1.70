package com.tencent.hippykotlin.demo.pages.qqkmp.core;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.common.CommonModulesKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyAdModule;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.kmp.KMPPager;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/core/QQKMPCore;", "Lcom/tencent/kuikly/core/kmp/KMPPager;", "", "pagerEvent", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "eventData", "", "onReceivePagerEvent", "", "Lcom/tencent/kuikly/core/module/Module;", "createExternalModules", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QQKMPCore extends KMPPager {
    @Override // com.tencent.kuikly.core.pager.Pager
    public Map<String, Module> createExternalModules() {
        HashMap hashMap = new HashMap();
        CommonModulesKt.registerCommonModules(this);
        registerModule("QZoneComposePlatformModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.core.QQKMPCore$createExternalModules$1
            @Override // com.tencent.kuikly.core.pager.a
            public Module createModule() {
                return new QZoneComposePlatformModule();
            }
        });
        registerModule("QQKuiklyAdModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.core.QQKMPCore$createExternalModules$2
            @Override // com.tencent.kuikly.core.pager.a
            public Module createModule() {
                return new QQKuiklyAdModule();
            }
        });
        return hashMap;
    }

    @Override // com.tencent.kuikly.core.kmp.KMPPager, com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onReceivePagerEvent(String pagerEvent, e eventData) {
        super.onReceivePagerEvent(pagerEvent, eventData);
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("onReceivePagerEvent:", pagerEvent, KLog.INSTANCE, "QQKMPService");
    }
}
