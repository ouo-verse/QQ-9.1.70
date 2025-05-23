package com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces;

import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IReport {
    void report(String str, String str2, int i3, List<Node> list, String str3, e eVar, ISample iSample, Function1<? super Map<String, String>, Unit> function1);
}
