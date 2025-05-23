package com.tencent.hippykotlin.demo.pages.base.module;

import com.tencent.hippykotlin.demo.pages.base.module.ICalendar;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CalendarModule extends Module {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public final class Calendar implements ICalendar {
        public final List<Operation> operationRecords = new ArrayList();
        public final long originTimestamp;

        public Calendar(long j3) {
            this.originTimestamp = j3;
        }

        public final int get(ICalendar.Field field) {
            Integer intOrNull;
            e eVar = new e();
            eVar.u("timeMillis", this.originTimestamp);
            eVar.v("operations", CalendarModuleKt.access$toJSONArray(this.operationRecords).toString());
            eVar.t("field", field.f114182id);
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(Module.toNative$default(CalendarModule.this, false, "method_get_field", eVar.toString(), null, true, 8, null).toString());
            if (intOrNull != null) {
                return intOrNull.intValue();
            }
            return 0;
        }

        public final long timeInMillis() {
            Long longOrNull;
            e eVar = new e();
            eVar.u("timeMillis", this.originTimestamp);
            eVar.v("operations", CalendarModuleKt.access$toJSONArray(this.operationRecords).toString());
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(Module.toNative$default(CalendarModule.this, false, "method_get_time_in_millis", eVar.toString(), null, true, 8, null).toString());
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            return 0L;
        }
    }

    public final String formatTime(long j3) {
        e eVar = new e();
        eVar.u("timeMillis", j3);
        eVar.v("format", "yyyyMMdd_HHmmssSSS");
        return Module.toNative$default(this, false, "method_format", eVar.toString(), null, true, 8, null).toString();
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "CalendarModule";
    }

    public final ICalendar newCalendarInstance(long j3) {
        Long longOrNull;
        if (j3 == 0) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(Module.toNative$default(this, false, "method_cur_timestamp", null, null, true, 8, null).toString());
            j3 = longOrNull != null ? longOrNull.longValue() : 0L;
        }
        return new Calendar(j3);
    }
}
