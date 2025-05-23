package com.tencent.state.library;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.template.map.TemplateMapViewLocator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/library/LibraryServerLocator;", "Lcom/tencent/state/template/map/TemplateMapViewLocator;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "dataList", "", "Lcom/tencent/state/map/MapItem;", "(Lcom/tencent/state/map/MapViewConfig;Ljava/util/List;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryServerLocator extends TemplateMapViewLocator {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryServerLocator(MapViewConfig config, List<? extends MapItem> dataList) {
        super(config, dataList);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
    }
}
