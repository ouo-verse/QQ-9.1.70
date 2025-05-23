package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import b01.b;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class TraceInfo implements b {
    public e detail;

    /* renamed from: id, reason: collision with root package name */
    public String f114312id;
    public String index;
    public int num;

    public TraceInfo() {
        this(null, null, null, 0, 15, null);
    }

    public final int hashCode() {
        int hashCode = this.f114312id.hashCode() * 31;
        e eVar = this.detail;
        return this.num + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.index, (hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31, 31);
    }

    public final void merge(TraceInfo traceInfo) {
        if (traceInfo.f114312id.length() > 0) {
            this.f114312id = traceInfo.f114312id;
        }
        if (traceInfo.index.length() > 0) {
            this.index = traceInfo.index;
        }
        int i3 = traceInfo.num;
        if (i3 > 0) {
            this.num = i3;
        }
        if (this.detail == null) {
            this.detail = traceInfo.detail;
            return;
        }
        e eVar = traceInfo.detail;
        if (eVar != null) {
            Iterator<String> c16 = eVar.c();
            while (c16.hasNext()) {
                String next = c16.next();
                e eVar2 = this.detail;
                if (eVar2 != null) {
                    eVar2.v(next, eVar.e(next));
                }
            }
        }
    }

    @Override // b01.b
    public final e serialization() {
        return new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceInfo$serialization$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                String valueOf;
                e eVar2 = eVar;
                eVar2.z("trace_id", TraceInfo.this.f114312id);
                e eVar3 = TraceInfo.this.detail;
                if (eVar3 == null) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(eVar3);
                }
                eVar2.z("trace_detail", valueOf);
                eVar2.z("trace_index", TraceInfo.this.index);
                eVar2.z("trace_num", Integer.valueOf(TraceInfo.this.num));
                return Unit.INSTANCE;
            }
        });
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("TraceInfo(id=");
        m3.append(this.f114312id);
        m3.append(", detail=");
        m3.append(this.detail);
        m3.append(", index=");
        m3.append(this.index);
        m3.append(", num=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.num, ')');
    }

    public TraceInfo(String str, e eVar, String str2, int i3) {
        this.f114312id = str;
        this.detail = eVar;
        this.index = str2;
        this.num = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TraceInfo)) {
            return false;
        }
        TraceInfo traceInfo = (TraceInfo) obj;
        return Intrinsics.areEqual(this.f114312id, traceInfo.f114312id) && Intrinsics.areEqual(this.detail, traceInfo.detail) && Intrinsics.areEqual(this.index, traceInfo.index) && this.num == traceInfo.num;
    }

    public /* synthetic */ TraceInfo(String str, e eVar, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", new e(), "", 0);
    }
}
