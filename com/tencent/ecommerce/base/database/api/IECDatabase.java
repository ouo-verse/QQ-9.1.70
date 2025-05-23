package com.tencent.ecommerce.base.database.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J)\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/base/database/api/IECDatabase;", "T", "", "delete", "", "dataList", "", "insert", "query", "conditions", "Lorg/json/JSONObject;", "limit", "", "(Lorg/json/JSONObject;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECDatabase<T> {
    void delete(@NotNull List<? extends T> dataList);

    void insert(@NotNull List<? extends T> dataList);

    @Nullable
    Object query(@NotNull JSONObject jSONObject, int i3, @NotNull Continuation<? super List<? extends T>> continuation);

    void update(@NotNull List<? extends T> dataList);
}
