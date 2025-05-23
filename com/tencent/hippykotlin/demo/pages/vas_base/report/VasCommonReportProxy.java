package com.tencent.hippykotlin.demo.pages.vas_base.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.random.Random;

/* loaded from: classes33.dex */
public final class VasCommonReportProxy extends VasBaseReportProxy {
    public static final boolean isHit;
    public static final String subVersion;
    public final String eventName;
    public final Function1<Map<String, String>, Unit> realReport;
    public String value1 = "";
    public String value2 = "";
    public String value3 = "";
    public String value4 = "";
    public String value5 = "";
    public long num1 = -1;
    public long num2 = -1;
    public long num3 = -1;

    static {
        isHit = Random.INSTANCE.nextInt(1000) == 500;
        subVersion = String.valueOf(PageDataExtKt.getResVersion(c.f117352a.g().getPageData()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VasCommonReportProxy(String str, Function1<? super Map<String, String>, Unit> function1) {
        this.eventName = str;
        this.realReport = function1;
    }

    public final void report(boolean z16) {
        KLog.INSTANCE.i("VasBaseReportProxy", toString());
        if (!z16 || isHit) {
            Function1<Map<String, String>, Unit> function1 = this.realReport;
            HashMap hashMap = new HashMap();
            recordString(hashMap, AdMetricTag.EVENT_NAME, this.eventName);
            recordString(hashMap, "value1", this.value1);
            recordString(hashMap, "value2", this.value2);
            recordString(hashMap, "value3", this.value3);
            recordString(hashMap, "value4", this.value4);
            recordString(hashMap, "value5", this.value5);
            recordNum(hashMap, "num1", this.num1);
            recordNum(hashMap, "num2", this.num2);
            recordNum(hashMap, "num3", this.num3);
            hashMap.put(AdMetricTag.Report.TYPE, "vasTech");
            hashMap.put("subVersion", subVersion);
            function1.invoke(hashMap);
        }
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ReportInfo(eventName='");
        m3.append(this.eventName);
        m3.append("', value1='");
        m3.append(this.value1);
        m3.append("', value2='");
        m3.append(this.value2);
        m3.append("', value3='");
        m3.append(this.value3);
        m3.append("', value4='");
        m3.append(this.value4);
        m3.append("', value5='");
        m3.append(this.value5);
        m3.append("', num1=");
        m3.append(this.num1);
        m3.append(", num2=");
        m3.append(this.num2);
        m3.append(", num3=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.num3, ')');
    }
}
