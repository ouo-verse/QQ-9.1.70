package com.tencent.hippykotlin.demo.pages.vas_base.report.chain.impl;

import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.report.VasCommonReportProxy;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReport;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.ISample;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import defpackage.j;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BeaconReport implements IReport {
    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReport
    public final void report(String str, String str2, int i3, List<Node> list, String str3, e eVar, ISample iSample, Function1<? super Map<String, String>, Unit> function1) {
        CharSequence trim;
        CharSequence trim2;
        trim = StringsKt__StringsKt.trim((CharSequence) str2);
        if (!Intrinsics.areEqual(trim.toString(), "")) {
            trim2 = StringsKt__StringsKt.trim((CharSequence) str);
            if (!Intrinsics.areEqual(trim2.toString(), "")) {
                e eVar2 = new e();
                b bVar = new b();
                for (Node node : list) {
                    node.getClass();
                    e eVar3 = new e();
                    eVar3.t(ReportConstant.COSTREPORT_PREFIX, node.stage);
                    eVar3.u("st", node.startTime);
                    Node node2 = node.preNode;
                    eVar3.u("c", node2 == null ? 0L : node.startTime - node2.startTime);
                    e eVar4 = node.ext;
                    if ((eVar4 != null ? eVar4.d() : 0) > 0 && !Intrinsics.areEqual(Node.DEF_JSON, node.ext)) {
                        eVar3.v("ext", node.ext);
                    }
                    bVar.t(eVar3);
                }
                eVar2.v("d", bVar);
                KLog kLog = KLog.INSTANCE;
                StringBuilder a16 = j.a("report sn: ", str, " k: ", str2, " v:");
                a16.append(i3);
                a16.append(" e: ");
                a16.append(eVar);
                a16.append(" j: cc: ");
                a16.append(str3);
                a16.append("  ");
                a16.append(eVar2);
                a16.append(" sample: ");
                a16.append(iSample != null ? Boolean.valueOf(iSample.isUseDefSample()) : null);
                kLog.i("VasReportQLogProxy", a16.toString());
                boolean isUseDefSample = iSample != null ? iSample.isUseDefSample() : true;
                VasCommonReportProxy vasCommonReportProxy = new VasCommonReportProxy(str, function1);
                vasCommonReportProxy.num1 = i3;
                String eVar5 = eVar.toString();
                if (eVar5 != null) {
                    vasCommonReportProxy.value1 = eVar5;
                }
                if (str2 != null) {
                    vasCommonReportProxy.value2 = str2;
                }
                String eVar6 = eVar2.toString();
                if (eVar6 != null) {
                    vasCommonReportProxy.value3 = eVar6;
                }
                if (str3 != null) {
                    vasCommonReportProxy.value4 = str3;
                }
                vasCommonReportProxy.value5 = "vas_chain_report_key";
                vasCommonReportProxy.report(isUseDefSample);
                return;
            }
        }
        KLog.INSTANCE.i("VasReportQLogProxy", QUISkinImage$$ExternalSyntheticOutline0.m("setKey or serviceName cannot be null,setKey:", str2, " serviceName:", str));
    }
}
