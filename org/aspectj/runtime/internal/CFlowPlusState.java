package org.aspectj.runtime.internal;

import org.aspectj.runtime.CFlow;

/* loaded from: classes29.dex */
public class CFlowPlusState extends CFlow {
    private Object[] state;

    public CFlowPlusState(Object[] objArr) {
        this.state = objArr;
    }

    @Override // org.aspectj.runtime.CFlow
    public Object get(int i3) {
        return this.state[i3];
    }

    public CFlowPlusState(Object[] objArr, Object obj) {
        super(obj);
        this.state = objArr;
    }
}
