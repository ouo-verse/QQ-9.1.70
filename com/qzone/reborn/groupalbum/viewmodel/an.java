package com.qzone.reborn.groupalbum.viewmodel;

import com.qzone.publish.business.publishqueue.common.CommonPublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/an;", "Lcom/qzone/reborn/albumx/common/viewmodel/k;", "", "getLogTag", "caseId", "Lcom/qzone/publish/business/publishqueue/common/CommonPublishQueue;", "T1", "Lcom/qzone/publish/business/task/IQueueTask;", "queueTask", "albumId", "", "U1", "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class an extends com.qzone.reborn.albumx.common.viewmodel.k {
    @Override // com.qzone.reborn.albumx.common.viewmodel.k
    public CommonPublishQueue T1(String caseId) {
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        return z8.c.f452134a.c(caseId);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.k
    public boolean U1(IQueueTask queueTask, String albumId) {
        Intrinsics.checkNotNullParameter(queueTask, "queueTask");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        return (queueTask instanceof GroupAlbumUploadAlbumTask) && Intrinsics.areEqual(((GroupAlbumUploadAlbumTask) queueTask).params.getAlbumInfo().getAlbumId(), albumId);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "GroupAlbumPublishQueueViewModel";
    }
}
