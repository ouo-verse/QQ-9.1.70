package com.tencent.state.battery;

import com.tencent.state.service.UserFormatKt;
import com.tencent.state.square.record.SquareRecordManager;
import hs4.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rt4.a;
import rt4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0007"}, d2 = {"Lrt4/g;", "", "uin", "", "isMale", "Lcom/tencent/state/battery/SquareBatteryLevelInfo;", "formatBatteryInfo", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SquareBatteryDataKt {
    public static final SquareBatteryLevelInfo formatBatteryInfo(g formatBatteryInfo, String uin, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(formatBatteryInfo, "$this$formatBatteryInfo");
        Intrinsics.checkNotNullParameter(uin, "uin");
        boolean areEqual = Intrinsics.areEqual(formatBatteryInfo.f432407b, SquareRecordManager.INSTANCE.getDressKey());
        if (areEqual) {
            str = formatBatteryInfo.f432407b;
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (isDressKeySame) dressKey else \"\"");
        a[] aVarArr = formatBatteryInfo.f432406a;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "this.batteryInfo");
        ArrayList arrayList = new ArrayList(aVarArr.length);
        for (a aVar : aVarArr) {
            int i3 = aVar.f432388a;
            int i16 = aVar.f432389b;
            r rVar = aVar.f432390c;
            Intrinsics.checkNotNullExpressionValue(rVar, "it.resource");
            arrayList.add(new SquareBatteryLevelItem(i3, i16, UserFormatKt.formatActionResource(rVar, areEqual, aVar.f432391d)));
        }
        return new SquareBatteryLevelInfo(uin, z16, str, arrayList);
    }
}
