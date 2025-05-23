package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchText implements ISSOReqModel, ISSORspModel<UnifySearchText> {
    public final String jumpLink;
    public final String text;

    public UnifySearchText() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchText decode(e eVar) {
        return new UnifySearchText(eVar.q("text", ""), eVar.q("jump_link", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("text", this.text);
        eVar.v("jump_link", this.jumpLink);
        return eVar;
    }

    public UnifySearchText(String str, String str2) {
        this.text = str;
        this.jumpLink = str2;
    }

    public /* synthetic */ UnifySearchText(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }
}
