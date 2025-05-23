package org.junit.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RuleChain implements TestRule {
    private static final RuleChain EMPTY_CHAIN = new RuleChain(Collections.emptyList());
    private List<TestRule> rulesStartingWithInnerMost;

    RuleChain(List<TestRule> list) {
        this.rulesStartingWithInnerMost = list;
    }

    public static RuleChain emptyRuleChain() {
        return EMPTY_CHAIN;
    }

    public static RuleChain outerRule(TestRule testRule) {
        return emptyRuleChain().around(testRule);
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        Iterator<TestRule> it = this.rulesStartingWithInnerMost.iterator();
        while (it.hasNext()) {
            statement = it.next().apply(statement, description);
        }
        return statement;
    }

    public RuleChain around(TestRule testRule) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(testRule);
        arrayList.addAll(this.rulesStartingWithInnerMost);
        return new RuleChain(arrayList);
    }
}
