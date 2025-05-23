package com.qzone.reborn.intimate.part.feed;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import kotlin.Metadata;
import nk.aq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/intimate/part/feed/i;", "Lcom/qzone/reborn/intimate/part/feed/h;", "Lgf/a;", "", "feedId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "H9", "getDtPageId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends h {
    @Override // com.qzone.reborn.intimate.part.feed.h
    public BusinessFeedData H9(String feedId) {
        aq aqVar = (aq) getViewModel(aq.class);
        if (aqVar != null) {
            return aqVar.P1();
        }
        return null;
    }

    @Override // com.qzone.reborn.intimate.part.feed.h
    public String getDtPageId() {
        return "pg_qz_dynamic_detail_page";
    }
}
