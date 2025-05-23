package com.tencent.zplan.record.manager;

import com.tencent.mobileqq.app.face.util.FaceUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@"}, d2 = {"", "key", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "", "downloadFromNetIfLocalAbsent", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "addResource"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.manager.ZPlanResourceManager", f = "ZPlanResourceManager.kt", i = {0, 0, 0}, l = {101}, m = "addResource", n = {"this", "key", FaceUtil.IMG_TEMP}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes27.dex */
public final class ZPlanResourceManager$addResource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanResourceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanResourceManager$addResource$1(ZPlanResourceManager zPlanResourceManager, Continuation continuation) {
        super(continuation);
        this.this$0 = zPlanResourceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, false, this);
    }
}
