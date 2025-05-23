package com.qzone.reborn.albumx.common.bean;

import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/e;", "", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "a", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "()Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "b", "(Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;)V", "stateData", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RFWDownloadTaskStateData stateData;

    public e(RFWDownloadTaskStateData stateData) {
        Intrinsics.checkNotNullParameter(stateData, "stateData");
        this.stateData = stateData;
    }

    /* renamed from: a, reason: from getter */
    public final RFWDownloadTaskStateData getStateData() {
        return this.stateData;
    }

    public final void b(RFWDownloadTaskStateData rFWDownloadTaskStateData) {
        Intrinsics.checkNotNullParameter(rFWDownloadTaskStateData, "<set-?>");
        this.stateData = rFWDownloadTaskStateData;
    }
}
