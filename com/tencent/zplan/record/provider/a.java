package com.tencent.zplan.record.provider;

import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH&R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00008&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/zplan/record/provider/a;", "", "", "key", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "a", "(Ljava/lang/String;Lcom/tencent/zplan/record/model/SingleRecordRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchKey", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "Lkotlinx/coroutines/flow/Flow;", "c", "getNextProvider", "()Lcom/tencent/zplan/record/provider/a;", "b", "(Lcom/tencent/zplan/record/provider/a;)V", "nextProvider", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {
    @Nullable
    Object a(@NotNull String str, @NotNull SingleRecordRequestParams singleRecordRequestParams, @NotNull Continuation<? super ZPlanRecordResource> continuation);

    void b(@Nullable a aVar);

    @NotNull
    Flow<ZPlanRecordResource> c(@NotNull String batchKey, @NotNull BatchRecordRequestParams params);
}
