package com.tencent.hippykotlin.demo.pages.nearby.module;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.debug.NBPDebugSettingsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NBPAddressUtils;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.k;

/* loaded from: classes31.dex */
public final class NBPPublishBridgeModule$enterLocationPage$1 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ Function1<k, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPPublishBridgeModule$enterLocationPage$1(Function1<? super k, Unit> function1) {
        super(1);
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object obj) {
        boolean isBlank;
        if (obj != null && (obj instanceof byte[])) {
            final k kVar = (k) i.b(new k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151), (byte[]) obj);
            NBPSsoLocation nBPSsoLocation = NBPDebugSettingsKt.toNBPSsoLocation(kVar);
            isBlank = StringsKt__StringsJVMKt.isBlank(kVar.I);
            if (!isBlank && !Intrinsics.areEqual(kVar.I, "null")) {
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("got location "), kVar.f418087e, KLog.INSTANCE, "NBPPublishBridgeModule");
                this.$callback.invoke(kVar);
            } else {
                KLog.INSTANCE.i("NBPPublishBridgeModule", "city is null, fetch location info");
                NBPAddressUtils nBPAddressUtils = NBPAddressUtils.INSTANCE;
                double d16 = nBPSsoLocation.lat02;
                double d17 = nBPSsoLocation.lon02;
                final Function1<k, Unit> function1 = this.$callback;
                nBPAddressUtils.geo2Address(d16, d17, new Function1<NBPSsoLocation, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.module.NBPPublishBridgeModule$enterLocationPage$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPSsoLocation nBPSsoLocation2) {
                        NBPSsoLocation nBPSsoLocation3 = nBPSsoLocation2;
                        if (nBPSsoLocation3 == null) {
                            function1.invoke(kVar);
                        } else {
                            Function1<k, Unit> function12 = function1;
                            String str = nBPSsoLocation3.name;
                            String str2 = nBPSsoLocation3.nation;
                            String str3 = nBPSsoLocation3.province;
                            String str4 = nBPSsoLocation3.city;
                            String str5 = nBPSsoLocation3.district;
                            String str6 = nBPSsoLocation3.address;
                            k kVar2 = kVar;
                            function12.invoke(new k(kVar2.f418086d, str, kVar2.f418088f, kVar2.f418089h, str6, kVar2.f418091m, kVar2.C, kVar2.D, kVar2.E, kVar2.F, str2, str3, str4, kVar2.J, kVar2.K, kVar2.L, str5, kVar2.N, kVar2.P, str, 1048576));
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }
}
