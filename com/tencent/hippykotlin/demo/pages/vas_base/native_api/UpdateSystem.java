package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tenpay.proxy.dlg.location.QbAddrData;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class UpdateSystem {
    public final void downloadUpdateSystem(final String str, final Function1 function1) {
        KLog.INSTANCE.i("UpdateSystem", "downloadUpdateSystem 22 - " + str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(22L);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str);
        VasModule.Companion.getInstance().toNative(false, "downloadUpdateSystem", sb5.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.UpdateSystem$downloadUpdateSystem$1
            public final /* synthetic */ long $bid = 22;

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                String p16 = eVar2 != null ? eVar2.p("result") : null;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("downloadUpdateSystem ");
                m3.append(this.$bid);
                m3.append(" - ");
                m3.append(str);
                m3.append(" result = ");
                m3.append(p16);
                kLog.i("UpdateSystem", m3.toString());
                function1.invoke(Boolean.valueOf(Intrinsics.areEqual(p16, "0")));
                return Unit.INSTANCE;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }
        }, false);
    }
}
