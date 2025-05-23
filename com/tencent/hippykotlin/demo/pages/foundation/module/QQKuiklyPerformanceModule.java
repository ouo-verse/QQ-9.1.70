package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QQKuiklyPerformanceModule extends Module {
    public final String getLaunchPerformanceData() {
        c cVar = c.f117352a;
        if (k.a(cVar)) {
            if (!(QQUtils.INSTANCE.compare("8.9.88") >= 0)) {
                return "{}";
            }
        }
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
            if (!(QQUtils.INSTANCE.compare("8.9.90") >= 0)) {
                return "{}";
            }
        }
        return syncToNativeMethod("getLaunchPerformanceData", (e) null, (Function1<? super e, Unit>) null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQKuiklyPerformanceModule";
    }
}
