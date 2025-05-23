package com.qzone.reborn.feedx.viewmodel;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/s;", "", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedsData", "", "updateCount", "", "a", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class s {
    public void b(List<? extends BusinessFeedData> feedsData) {
        Intrinsics.checkNotNullParameter(feedsData, "feedsData");
    }

    public void a(List<? extends BusinessFeedData> feedsData, int updateCount) {
    }
}
