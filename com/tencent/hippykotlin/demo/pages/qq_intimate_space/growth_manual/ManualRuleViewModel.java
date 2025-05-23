package com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ManualRuleViewModel {
    public List<ManualRule> rules;

    public ManualRuleViewModel() {
        ArrayList arrayList = new ArrayList();
        this.rules = arrayList;
        arrayList.addAll(fetchRules());
    }

    public final List<ManualRule> fetchRules() {
        List<ManualRule> emptyList;
        String stringFromQQCommonConfig = ((QQCommonNApiModule) b.a().acquireModule("QQCommonNApiModule")).getStringFromQQCommonConfig("intimate_space_love_tree_growth_manual", "{}");
        KLog.INSTANCE.i("ManualRuleViewModel", "getQQMCConfig: intimate_space_love_tree_growth_manual: " + stringFromQQCommonConfig);
        try {
            ArrayList arrayList = new ArrayList();
            com.tencent.kuikly.core.nvi.serialization.json.b l3 = new e(stringFromQQCommonConfig).l("rules");
            if (l3 != null) {
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    e l16 = l3.l(i3);
                    if (l16 != null) {
                        arrayList.add(new ManualRule(l16.p("title"), l16.p("desc")));
                    }
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }
}
