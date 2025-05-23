package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Deprecated(message = "\u8001\u7248\u672c\u903b\u8f91\uff0c\u63a8\u8350\u4f7f\u7528NetworkUtils")
/* loaded from: classes31.dex */
public abstract class SSORequestModel {
    public final String pagerId;

    public SSORequestModel(String str) {
        this.pagerId = str;
    }

    public abstract String cmd();

    public abstract e reqParam();

    public void requestData(final Function3<? super e, ? super Integer, ? super String, Unit> function3) {
        BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(this.pagerId);
        String cmd = cmd();
        e reqParam = reqParam();
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.SSORequestModel$requestData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                e eVar3 = new e();
                int i3 = 0;
                String str = "";
                if (eVar2 != null) {
                    SSORequestModel sSORequestModel = this;
                    String q16 = eVar2.q("data", "");
                    if (q16.length() > 0) {
                        eVar3 = new e(q16);
                    }
                    i3 = eVar2.k("errorCode", 0);
                    String q17 = eVar2.q("errorMsg", "");
                    eVar2.q("traceId", "");
                    sSORequestModel.getClass();
                    eVar2.q("spanContext", "");
                    str = q17;
                }
                function3.invoke(eVar3, Integer.valueOf(i3), str);
                return Unit.INSTANCE;
            }
        };
        int i3 = BridgeModule.$r8$clinit;
        bridgeModule.ssoRequest(cmd, reqParam, false, function1);
    }

    public /* synthetic */ SSORequestModel() {
        this(BridgeManager.f117344a.u());
    }
}
