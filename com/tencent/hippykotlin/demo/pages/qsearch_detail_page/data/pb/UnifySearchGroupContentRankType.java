package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchGroupContentRankType implements ISSOReqModel, ISSORspModel<UnifySearchGroupContentRankType> {
    public final int rankTypeId;
    public final String rankTypeText;

    public UnifySearchGroupContentRankType() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchGroupContentRankType decode(e eVar) {
        return new UnifySearchGroupContentRankType(eVar.k("rank_type_id", 0), eVar.q("rank_type_text", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("rank_type_id", this.rankTypeId);
        eVar.v("rank_type_text", this.rankTypeText);
        return eVar;
    }

    public UnifySearchGroupContentRankType(int i3, String str) {
        this.rankTypeId = i3;
        this.rankTypeText = str;
    }

    public /* synthetic */ UnifySearchGroupContentRankType(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "");
    }
}
