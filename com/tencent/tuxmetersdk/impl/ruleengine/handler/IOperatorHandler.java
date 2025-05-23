package com.tencent.tuxmetersdk.impl.ruleengine.handler;

import com.tencent.tuxmetersdk.impl.ruleengine.ConditionItem;
import com.tencent.tuxmetersdk.impl.ruleengine.Fact;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IOperatorHandler {
    boolean handle(ConditionItem conditionItem, List<Fact> list);
}
