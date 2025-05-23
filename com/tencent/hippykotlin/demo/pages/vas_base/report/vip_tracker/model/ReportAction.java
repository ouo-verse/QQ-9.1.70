package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import b01.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zz0.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ReportAction implements b {
    public final int attr;

    /* renamed from: id, reason: collision with root package name */
    public final int f114311id;
    public final long timestamp = a.f453719a.a();
    public final long value;

    public ReportAction(int i3, long j3, int i16) {
        this.f114311id = i3;
        this.value = j3;
        this.attr = i16;
    }

    @Override // b01.b
    public final e serialization() {
        return new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportAction$serialization$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                eVar2.z("action_id", Integer.valueOf(ReportAction.this.f114311id));
                eVar2.z("action_value", Long.valueOf(ReportAction.this.value));
                eVar2.z("action_attr", Integer.valueOf(ReportAction.this.attr));
                eVar2.z("oper_time", Long.valueOf(ReportAction.this.timestamp));
                return Unit.INSTANCE;
            }
        });
    }
}
