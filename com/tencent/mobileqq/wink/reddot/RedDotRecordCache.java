package com.tencent.mobileqq.wink.reddot;

import androidx.annotation.Keep;
import com.google.gson.annotations.Expose;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/reddot/RedDotRecordCache;", "", "id", "", "records", "", "Lcom/tencent/mobileqq/wink/reddot/RedDotRecord;", "(Ljava/lang/String;Ljava/util/Set;)V", "getId", "()Ljava/lang/String;", "getRecords", "()Ljava/util/Set;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class RedDotRecordCache {

    @Expose
    @NotNull
    private final String id;

    @Expose
    @NotNull
    private final Set<RedDotRecord> records;

    public RedDotRecordCache(@NotNull String id5, @NotNull Set<RedDotRecord> records) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(records, "records");
        this.id = id5;
        this.records = records;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Set<RedDotRecord> getRecords() {
        return this.records;
    }
}
