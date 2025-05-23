package com.tencent.mobileqq.wink.editor.util;

import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcooperation/qzone/LbsDataV2$PoiList;", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "a", "", "b", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class l {
    @Nullable
    public static final LbsDataV2.PoiInfo a(@NotNull LbsDataV2.PoiList poiList) {
        Object orNull;
        Object obj;
        Intrinsics.checkNotNullParameter(poiList, "<this>");
        ArrayList<LbsDataV2.PoiInfo> arrayList = poiList.poiInfos;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (!Intrinsics.areEqual(((LbsDataV2.PoiInfo) obj).poiId, "local_city_id")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) obj;
            if (poiInfo != null) {
                return poiInfo;
            }
        }
        ArrayList<LbsDataV2.PoiInfo> arrayList2 = poiList.poiInfos;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "this.poiInfos");
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList2, 0);
        return (LbsDataV2.PoiInfo) orNull;
    }

    public static final int b(@NotNull LbsDataV2.PoiList poiList) {
        Integer num;
        Intrinsics.checkNotNullParameter(poiList, "<this>");
        ArrayList<LbsDataV2.PoiInfo> arrayList = poiList.poiInfos;
        if (arrayList != null) {
            Iterator<LbsDataV2.PoiInfo> it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (!Intrinsics.areEqual(it.next().poiId, "local_city_id")) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            num = Integer.valueOf(i3);
        } else {
            num = null;
        }
        if (num == null || num.intValue() < 0) {
            return 0;
        }
        return num.intValue();
    }
}
