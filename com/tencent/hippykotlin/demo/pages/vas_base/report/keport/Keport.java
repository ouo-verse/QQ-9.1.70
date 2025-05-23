package com.tencent.hippykotlin.demo.pages.vas_base.report.keport;

import com.tencent.hippykotlin.demo.pages.vas_base.kelper.Kelper;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Keport {
    public final Aggregator<ApiParam> apiAggregator;
    public final KRequest krequest;
    public final Aggregator<LogParam> logAggregator;

    public /* synthetic */ Keport() {
        this("https://h5.qzone.qq.com/v2/vip/keport");
    }

    public Keport(String str) {
        this.krequest = new KRequest(new RequestConfig(null, str, null, null, null, 0, null, 1019)).use(Kelper.INSTANCE.middleware());
        this.apiAggregator = new Aggregator<>(new Function1<List<ApiParam>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport$apiAggregator$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<ApiParam> list) {
                Keport keport = Keport.this;
                keport.getClass();
                BuildersKt.e(e.f117232d, null, null, new Keport$reportApi$1(keport, list, null), 3, null);
                return Unit.INSTANCE;
            }
        });
        this.logAggregator = new Aggregator<>(new Function1<List<LogParam>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport$logAggregator$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<LogParam> list) {
                Keport keport = Keport.this;
                keport.getClass();
                BuildersKt.e(e.f117232d, null, null, new Keport$reportLog$1(keport, list, null), 3, null);
                return Unit.INSTANCE;
            }
        });
    }
}
