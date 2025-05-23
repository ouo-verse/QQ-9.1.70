package com.tencent.cachedrawable.dynamicdrawable.business.download;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005H&J:\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/business/download/c;", "", "", "url", "filePath", "Lkotlin/Function2;", "", "", "loadCallback", "a", "", "bid", "scid", "b", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public interface c {
    void a(@NotNull String url, @NotNull String filePath, @NotNull Function2<? super Integer, ? super String, Unit> loadCallback);

    void b(long bid, @NotNull String scid, @NotNull String filePath, @NotNull Function2<? super Integer, ? super String, Unit> loadCallback);
}
