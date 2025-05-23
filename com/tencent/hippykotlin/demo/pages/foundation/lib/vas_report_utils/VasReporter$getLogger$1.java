package com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils;

import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class VasReporter$getLogger$1 extends Lambda implements Function1<String, Unit> {
    public static final VasReporter$getLogger$1 INSTANCE = new VasReporter$getLogger$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String str) {
        String str2 = str;
        if (!PageDataExtKt.isPublic(c.f117352a.g().getPageData())) {
            KLog.INSTANCE.d("VasReporter", str2);
        }
        return Unit.INSTANCE;
    }

    public VasReporter$getLogger$1() {
        super(1);
    }
}
