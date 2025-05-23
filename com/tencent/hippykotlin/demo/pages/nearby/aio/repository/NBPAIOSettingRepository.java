package com.tencent.hippykotlin.demo.pages.nearby.aio.repository;

import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kuikly.trpc.relation.blacklist.e;

/* loaded from: classes31.dex */
public final class NBPAIOSettingRepository {
    public static final NBPAIOSettingRepository INSTANCE = new NBPAIOSettingRepository();

    public final void requestCheckBlockStatus(String str, final Function1<? super e, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new GetCheckBlockRequest(str), false, new Function1<OIDBResponse<e>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.repository.NBPAIOSettingRepository$requestCheckBlockStatus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<e> oIDBResponse) {
                OIDBResponse<e> oIDBResponse2 = oIDBResponse;
                if (oIDBResponse2.success) {
                    function1.invoke(oIDBResponse2.rsp);
                } else {
                    function2.invoke(Integer.valueOf(oIDBResponse2.code), oIDBResponse2.f114186msg);
                }
                return Unit.INSTANCE;
            }
        });
    }
}
