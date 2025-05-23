package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.model.KTVAlertInfo;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NearbyProSafeTip {
    public static final NearbyProSafeTip INSTANCE = new NearbyProSafeTip();
    public static final Set<Integer> PUNISHED_ERROR_CODES;

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{50000, 50001, 50002});
        PUNISHED_ERROR_CODES = of5;
    }

    public final void dangerTip(String str) {
        Utils.INSTANCE.currentBridgeModule().showAlert(new KTVAlertInfo("", str, 12.0f, 2), "\u6211\u77e5\u9053\u4e86", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProSafeTip$dangerTip$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                return Unit.INSTANCE;
            }
        });
    }
}
