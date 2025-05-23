package com.tencent.mobileqq.winkpublish.outbox.task.feature.group;

import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u000fB\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/group/c;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;", "", "e", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup$RunMode;", "f", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", "d", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends FeatureGroup {
    public c(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> d(TaskContext taskContext) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        List<UploadMediaInfo> l3 = taskContext.l();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(l3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : l3) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new g(i3, null, 2, 0 == true ? 1 : 0));
            i3 = i16;
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public String e() {
        return "WinkPublish-upload2-UploadImagesFeatGroup";
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public FeatureGroup.RunMode f() {
        return FeatureGroup.RunMode.ASYNC_RUN_MODE;
    }
}
