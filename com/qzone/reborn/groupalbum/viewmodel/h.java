package com.qzone.reborn.groupalbum.viewmodel;

import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadQueueTaskInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/h;", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "Lo9/f;", "requestBean", "", "T1", "", "id", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "listener", "g2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueTaskInfo;", "taskInfo", "N1", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends com.qzone.reborn.albumx.common.viewmodel.e {
    @Override // com.qzone.reborn.albumx.common.viewmodel.e
    public void N1(RFWDownloadQueueTaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        zh.b.l().b(taskInfo);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.e
    public void T1(o9.f requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (requestBean instanceof ci.j) {
            ki.d.f412455a.g((ci.j) requestBean);
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.e
    public void g2(String id5, RFWDownloadQueueResultListener listener) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(listener, "listener");
        zh.b.l().r(id5, this);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.e
    public void n2(String id5, RFWDownloadQueueResultListener listener) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(listener, "listener");
        zh.b.l().s(id5, this);
    }
}
