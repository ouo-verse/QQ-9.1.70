package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchTabInfo implements ISSOReqModel, ISSORspModel<UnifySearchTabInfo> {
    public final long tabMask;
    public final String tabName;

    public UnifySearchTabInfo() {
        this(0L, 3);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("tab_name", this.tabName);
        eVar.u("tab_mask", this.tabMask);
        return eVar;
    }

    public UnifySearchTabInfo(String str, long j3) {
        this.tabName = str;
        this.tabMask = j3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchTabInfo decode(e eVar) {
        return new UnifySearchTabInfo(eVar.q("tab_name", ""), eVar.o("tab_mask", 0L));
    }

    public /* synthetic */ UnifySearchTabInfo(long j3, int i3) {
        this((i3 & 1) != 0 ? "" : null, (i3 & 2) != 0 ? 0L : j3);
    }
}
