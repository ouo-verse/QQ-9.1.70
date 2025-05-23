package com.tencent.richframework.gallery.datacenter;

import com.tencent.richframework.data.base.BaseDataStore;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/richframework/gallery/datacenter/ExtraDataStore;", "Lcom/tencent/richframework/data/base/BaseDataStore;", "Lcom/tencent/richframework/gallery/datacenter/ExtraDataWrapper;", "", "", "getAllData", "data", "getKeyFromData", "", "storeTag", "J", "getStoreTag", "()J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraDataWrappers", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ExtraDataStore extends BaseDataStore<ExtraDataWrapper> {
    private static final AtomicLong storeTagGenerator = new AtomicLong(0);
    private final long storeTag = storeTagGenerator.incrementAndGet();
    private final HashMap<String, ExtraDataWrapper> extraDataWrappers = new HashMap<>();

    @Override // com.tencent.richframework.data.idata.IDataStore
    @NotNull
    public Map<String, ExtraDataWrapper> getAllData() {
        return this.extraDataWrappers;
    }

    public final long getStoreTag() {
        return this.storeTag;
    }

    @Override // com.tencent.richframework.data.idata.IDataStore
    @NotNull
    public String getKeyFromData(@NotNull ExtraDataWrapper data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getKey();
    }
}
