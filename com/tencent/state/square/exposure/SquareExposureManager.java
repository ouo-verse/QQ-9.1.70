package com.tencent.state.square.exposure;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.map.MapItem;
import com.tencent.state.service.VasSquareReportService;
import com.tencent.state.square.data.NewInfo;
import com.tencent.state.square.data.SquareAvatarItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u000eH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/exposure/SquareExposureManager;", "Lcom/tencent/state/square/exposure/IExposureManager;", "()V", "exposureSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "canExposure", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/map/MapItem;", "doExposure", "", "onExposure", "Lcom/tencent/state/square/data/SquareAvatarItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareExposureManager implements IExposureManager {
    private final HashSet<String> exposureSet = new HashSet<>();

    private final void onExposure(SquareAvatarItem item) {
        Long longOrNull;
        if (item.hasNewFlag()) {
            VasSquareReportService vasSquareReportService = new VasSquareReportService();
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(item.getUin());
            long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
            List<NewInfo> newInfoList = item.getNewInfoList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : newInfoList) {
                if (((NewInfo) obj).getHasNewFlag()) {
                    arrayList.add(obj);
                }
            }
            vasSquareReportService.reportNewInfo(longValue, arrayList);
        }
    }

    @Override // com.tencent.state.square.exposure.IExposureManager
    public boolean canExposure(MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return !this.exposureSet.contains(item.getUin());
    }

    @Override // com.tencent.state.square.exposure.IExposureManager
    public void doExposure(MapItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.exposureSet.add(item.getUin());
        if (item instanceof SquareAvatarItem) {
            onExposure((SquareAvatarItem) item);
        }
    }
}
