package com.tencent.hippykotlin.demo.pages.adelie.common.compose.page;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity;
import com.tencent.kuikly.core.module.Module;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* loaded from: classes31.dex */
public class BaseComposePager extends BaseComponentActivity {
    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public Map<String, Module> createExternalModules() {
        Map<String, Module> mapOf;
        super.createExternalModules();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("AdelieKuiklyBaseModule", new AdelieKuiklyBaseModule()), TuplesKt.to("AdelieRedDotModule", new AdelieRedDotModule()));
        return mapOf;
    }
}
