package com.tencent.mobileqq.winkpublish.outbox.task.feature.group;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.UploadVideoCoverFeat;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/group/d;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;", "", "e", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup$RunMode;", "f", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", "d", "Lkotlinx/coroutines/channels/Channel;", "", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends FeatureGroup {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Channel<Integer> channel;

    public d(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(bVar);
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> d(TaskContext taskContext) {
        List<com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a> listOf;
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a[]{new h(this.channel), new UploadVideoCoverFeat(0, this.channel)});
        return listOf;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public String e() {
        return "WinkPublish-upload2-UploadVideoAndCoverAsyncFeatGroup";
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup
    public FeatureGroup.RunMode f() {
        return FeatureGroup.RunMode.ASYNC_RUN_MODE;
    }

    public /* synthetic */ d(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
