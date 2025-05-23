package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusCity implements ISSOReqModel, ISSORspModel<QPlusCity> {
    public final int cityCode;
    public final int cityLevel;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QPlusCity() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("city_code", this.cityCode);
        eVar.t("city_level", this.cityLevel);
        return eVar;
    }

    public QPlusCity(int i3, int i16) {
        this.cityCode = i3;
        this.cityLevel = i16;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCity decode(e eVar) {
        return new QPlusCity(eVar.k("city_code", 0), eVar.k("city_level", 0));
    }

    public /* synthetic */ QPlusCity(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0);
    }
}
