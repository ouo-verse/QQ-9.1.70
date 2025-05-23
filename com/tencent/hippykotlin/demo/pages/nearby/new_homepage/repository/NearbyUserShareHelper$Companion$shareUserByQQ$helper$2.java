package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository;

import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyUserShareHelper$Companion$shareUserByQQ$helper$2 extends Lambda implements Function2<Boolean, String, Unit> {
    public static final NearbyUserShareHelper$Companion$shareUserByQQ$helper$2 INSTANCE = new NearbyUserShareHelper$Companion$shareUserByQQ$helper$2();

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Boolean bool, String str) {
        bool.booleanValue();
        String str2 = str;
        if (str2 != null) {
            Utils.INSTANCE.currentBridgeModule().qToast(str2, QToastMode.Info);
        }
        return Unit.INSTANCE;
    }

    public NearbyUserShareHelper$Companion$shareUserByQQ$helper$2() {
        super(2);
    }
}
