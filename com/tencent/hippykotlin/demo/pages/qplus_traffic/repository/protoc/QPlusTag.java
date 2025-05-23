package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusTag implements ISSOReqModel, ISSORspModel<QPlusTag> {
    public final String tagName;

    public QPlusTag() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusTag decode(e eVar) {
        return new QPlusTag(eVar.q("tag_name", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("tag_name", this.tagName);
        return eVar;
    }

    public QPlusTag(String str) {
        this.tagName = str;
    }

    public /* synthetic */ QPlusTag(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("");
    }
}
