package com.tencent.hippykotlin.demo.pages.nearby.compose_base;

import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.pager.a;
import java.util.Map;

/* loaded from: classes31.dex */
public class NBPBaseActivity extends BaseComponentActivity {
    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final Map<String, Module> createExternalModules() {
        registerModule("QQNearbyModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.NBPBaseActivity$createExternalModules$1
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQNearbyModule();
            }
        });
        return super.createExternalModules();
    }
}
