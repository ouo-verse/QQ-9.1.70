package com.tencent.state.common.push;

import androidx.collection.ArrayMap;
import com.tencent.state.PageType;
import com.tencent.state.common.push.service.VasLibraryPushService;
import com.tencent.state.common.push.service.VasRoomPushService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/common/push/PushServiceFactory;", "", "()V", "providers", "Landroidx/collection/ArrayMap;", "Lcom/tencent/state/PageType;", "Lcom/tencent/state/common/push/IVasPushService;", "get", "pageType", "appId", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class PushServiceFactory {
    public static final PushServiceFactory INSTANCE = new PushServiceFactory();
    private static final ArrayMap<PageType, IVasPushService> providers;

    static {
        ArrayMap<PageType, IVasPushService> arrayMap = new ArrayMap<>();
        providers = arrayMap;
        arrayMap.put(PageType.Library, new VasLibraryPushService());
        arrayMap.put(PageType.ChatLand, new VasRoomPushService(1001));
        arrayMap.put(PageType.ChatLand_Fixed, new VasRoomPushService(1002));
        arrayMap.put(PageType.Relax_Fixed, new VasRoomPushService(1003));
        arrayMap.put(PageType.ChatLand_Wuji_1, new VasRoomPushService(1004));
        arrayMap.put(PageType.ChatLand_Wuji_2, new VasRoomPushService(1005));
    }

    PushServiceFactory() {
    }

    public final IVasPushService get(PageType pageType, int appId) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        if (10001 <= appId && 19999 >= appId) {
            return new VasRoomPushService(appId);
        }
        return providers.get(pageType);
    }

    public static /* synthetic */ IVasPushService get$default(PushServiceFactory pushServiceFactory, PageType pageType, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return pushServiceFactory.get(pageType, i3);
    }
}
