package com.tencent.tuxmetersdk.impl.ruleengine.calculator;

import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IConditionCalculate {
    void calculate(List<TuxEvent> list);

    String getCid();

    boolean getResult();
}
