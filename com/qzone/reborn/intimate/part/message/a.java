package com.qzone.reborn.intimate.part.message;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.intimate.part.feed.h;
import kotlin.Metadata;
import nk.ay;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/intimate/part/message/a;", "Lcom/qzone/reborn/intimate/part/feed/h;", "", "feedId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "H9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends h {
    @Override // com.qzone.reborn.intimate.part.feed.h
    public BusinessFeedData H9(String feedId) {
        ay ayVar = (ay) getViewModel(ay.class);
        if (ayVar != null) {
            return ayVar.T1();
        }
        return null;
    }
}
