package com.tencent.kuikly.core.module;

import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0002\t\u0007B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/module/b;", "Lcom/tencent/kuikly/core/module/Module;", "", "moduleName", "", "timeMillis", "Lcom/tencent/kuikly/core/module/ICalendar;", "b", "format", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends Module {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/kuikly/core/module/b$a;", "Lcom/tencent/kuikly/core/module/ICalendar;", "Lcom/tencent/kuikly/core/module/ICalendar$Field;", "field", "", "value", "b", "d", "c", "", "a", "J", "getOriginTimestamp", "()J", "originTimestamp", "", "Lcom/tencent/kuikly/core/module/l;", "Ljava/util/List;", "operationRecords", "<init>", "(Lcom/tencent/kuikly/core/module/b;J)V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public final class a implements ICalendar {

        /* renamed from: a, reason: from kotlin metadata */
        private final long originTimestamp;

        /* renamed from: b, reason: from kotlin metadata */
        private final List<l> operationRecords = new ArrayList();

        public a(long j3) {
            this.originTimestamp = j3;
        }

        @Override // com.tencent.kuikly.core.module.ICalendar
        public long a() {
            com.tencent.kuikly.core.nvi.serialization.json.b c16;
            Long longOrNull;
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar.u("timeMillis", this.originTimestamp);
            c16 = c.c(this.operationRecords);
            eVar.v("operations", c16.toString());
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(Module.toNative$default(b.this, false, "method_get_time_in_millis", eVar.toString(), null, true, 8, null).toString());
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            return 0L;
        }

        @Override // com.tencent.kuikly.core.module.ICalendar
        public ICalendar b(ICalendar.Field field, int value) {
            Intrinsics.checkNotNullParameter(field, "field");
            this.operationRecords.add(new l.b(field, value));
            return this;
        }

        @Override // com.tencent.kuikly.core.module.ICalendar
        public int c(ICalendar.Field field) {
            com.tencent.kuikly.core.nvi.serialization.json.b c16;
            Integer intOrNull;
            Intrinsics.checkNotNullParameter(field, "field");
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar.u("timeMillis", this.originTimestamp);
            c16 = c.c(this.operationRecords);
            eVar.v("operations", c16.toString());
            eVar.t("field", field.getId());
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(Module.toNative$default(b.this, false, "method_get_field", eVar.toString(), null, true, 8, null).toString());
            if (intOrNull != null) {
                return intOrNull.intValue();
            }
            return 0;
        }

        @Override // com.tencent.kuikly.core.module.ICalendar
        public ICalendar d(ICalendar.Field field, int value) {
            Intrinsics.checkNotNullParameter(field, "field");
            this.operationRecords.add(new l.a(field, value));
            return this;
        }
    }

    public final String a(long timeMillis, String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.u("timeMillis", timeMillis);
        eVar.v("format", format);
        return Module.toNative$default(this, false, "method_format", eVar.toString(), null, true, 8, null).toString();
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRCalendarModule";
    }

    public static /* synthetic */ ICalendar c(b bVar, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        return bVar.b(j3);
    }

    public final ICalendar b(long timeMillis) {
        Long longOrNull;
        if (timeMillis == 0) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(Module.toNative$default(this, false, "method_cur_timestamp", null, null, true, 8, null).toString());
            timeMillis = longOrNull != null ? longOrNull.longValue() : 0L;
        }
        return new a(timeMillis);
    }
}
