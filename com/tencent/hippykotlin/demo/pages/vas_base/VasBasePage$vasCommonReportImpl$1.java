package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes33.dex */
public final class VasBasePage$vasCommonReportImpl$1 extends Lambda implements Function1<Map<String, ? extends String>, Unit> {
    public final /* synthetic */ VasBasePage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasBasePage$vasCommonReportImpl$1(VasBasePage vasBasePage) {
        super(1);
        this.this$0 = vasBasePage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Map<String, ? extends String> map) {
        VasModule vasModule = this.this$0.platformApi.getVasModule();
        vasModule.getClass();
        e eVar = new e();
        for (Map.Entry<String, ? extends String> entry : map.entrySet()) {
            eVar.v(entry.getKey(), entry.getValue());
        }
        vasModule.toNative(false, "reportVasCommon", eVar.toString(), null, false);
        return Unit.INSTANCE;
    }
}
