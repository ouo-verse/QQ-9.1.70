package com.tencent.mobileqq.winkpublish.outbox.task.feature.group;

import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.group.UWEVideoCoverAsyncFeatGroup", f = "UWEVideoCoverAsyncFeatGroup.kt", i = {0, 0}, l = {42}, m = TencentLocation.RUN_MODE, n = {"this", "taskContext"}, s = {"L$0", "L$1"})
/* loaded from: classes35.dex */
public final class UWEVideoCoverAsyncFeatGroup$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UWEVideoCoverAsyncFeatGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UWEVideoCoverAsyncFeatGroup$run$1(UWEVideoCoverAsyncFeatGroup uWEVideoCoverAsyncFeatGroup, Continuation<? super UWEVideoCoverAsyncFeatGroup$run$1> continuation) {
        super(continuation);
        this.this$0 = uWEVideoCoverAsyncFeatGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
