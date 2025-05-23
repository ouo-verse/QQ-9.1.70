package com.tencent.mobileqq.winkpublish.outbox.task.feature.group;

import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.UploadVideoCoverFeat;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/group/e;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;", "", "e", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup$RunMode;", "f", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", "d", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends FeatureGroup {
    public e(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> d(TaskContext taskContext) {
        List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> listOf;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a[]{new h(null, 1, 0 == true ? 1 : 0), new UploadVideoCoverFeat(0, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0)});
        return listOf;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public String e() {
        return "UploadVideoFeatureGroup";
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public FeatureGroup.RunMode f() {
        return FeatureGroup.RunMode.SYNC_RUN_MODE;
    }
}
