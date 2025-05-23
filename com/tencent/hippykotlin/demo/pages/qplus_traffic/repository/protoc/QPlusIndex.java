package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusIndex implements ISSOReqModel, ISSORspModel<QPlusIndex> {
    public final int cnt;
    public final String indexName;

    public QPlusIndex() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("index_name", this.indexName);
        eVar.t("cnt", this.cnt);
        return eVar;
    }

    public QPlusIndex(String str, int i3) {
        this.indexName = str;
        this.cnt = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusIndex decode(e eVar) {
        return new QPlusIndex(eVar.q("index_name", ""), eVar.k("cnt", 0));
    }

    public /* synthetic */ QPlusIndex(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0);
    }
}
