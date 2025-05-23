package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusAgeRange implements ISSOReqModel, ISSORspModel<QPlusAgeRange> {
    public final int from;

    /* renamed from: to, reason: collision with root package name */
    public final int f114256to;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QPlusAgeRange() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusAgeRange decode(e eVar) {
        return new QPlusAgeRange(eVar.k("from", 0), eVar.k("to", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("from", this.from);
        eVar.t("to", this.f114256to);
        return eVar;
    }

    public QPlusAgeRange(int i3, int i16) {
        this.from = i3;
        this.f114256to = i16;
    }

    public /* synthetic */ QPlusAgeRange(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0);
    }
}
