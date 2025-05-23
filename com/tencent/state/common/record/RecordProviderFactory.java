package com.tencent.state.common.record;

import androidx.collection.ArrayMap;
import com.tencent.state.PageType;
import com.tencent.state.common.record.provider.LibraryRecordDataProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/common/record/RecordProviderFactory;", "", "()V", "providers", "Landroidx/collection/ArrayMap;", "Lcom/tencent/state/PageType;", "Lcom/tencent/state/common/record/IRecordDataProvider;", "get", "pageType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class RecordProviderFactory {
    public static final RecordProviderFactory INSTANCE = new RecordProviderFactory();
    private static final ArrayMap<PageType, IRecordDataProvider> providers;

    static {
        ArrayMap<PageType, IRecordDataProvider> arrayMap = new ArrayMap<>();
        providers = arrayMap;
        arrayMap.put(PageType.Library, new LibraryRecordDataProvider());
    }

    RecordProviderFactory() {
    }

    public final IRecordDataProvider get(PageType pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        return providers.get(pageType);
    }
}
