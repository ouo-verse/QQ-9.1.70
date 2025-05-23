package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.feedcloud;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LoadMoreFeedStatus implements ISSOReqModel, ISSORspModel<LoadMoreFeedStatus> {
    public final boolean canPageUp;
    public final String pageUpAttachInfo;

    public LoadMoreFeedStatus(boolean z16, String str) {
        this.canPageUp = z16;
        this.pageUpAttachInfo = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final LoadMoreFeedStatus decode(e eVar) {
        return new LoadMoreFeedStatus(eVar.g("can_page_up", false), eVar.q("page_up_attach_info", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.w("can_page_up", this.canPageUp);
        eVar.v("page_up_attach_info", this.pageUpAttachInfo);
        return eVar;
    }
}
