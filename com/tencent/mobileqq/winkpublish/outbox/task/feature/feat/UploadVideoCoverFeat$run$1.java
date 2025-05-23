package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.UploadVideoCoverFeat", f = "UploadVideoCoverFeat.kt", i = {0, 0, 0}, l = {63, 69}, m = TencentLocation.RUN_MODE, n = {"this", "taskContext", "it"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes35.dex */
public final class UploadVideoCoverFeat$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadVideoCoverFeat this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadVideoCoverFeat$run$1(UploadVideoCoverFeat uploadVideoCoverFeat, Continuation<? super UploadVideoCoverFeat$run$1> continuation) {
        super(continuation);
        this.this$0 = uploadVideoCoverFeat;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
