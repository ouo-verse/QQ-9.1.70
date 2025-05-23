package org.junit.internal.runners.statements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RunAfters extends Statement {
    private final List<FrameworkMethod> afters;
    private final Statement next;
    private final Object target;

    public RunAfters(Statement statement, List<FrameworkMethod> list, Object obj) {
        this.next = statement;
        this.afters = list;
        this.target = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        ArrayList arrayList = new ArrayList();
        try {
            this.next.evaluate();
            Iterator<FrameworkMethod> it = this.afters.iterator();
            while (it.hasNext()) {
                try {
                    it.next().invokeExplosively(this.target, new Object[0]);
                } catch (Throwable th5) {
                    arrayList.add(th5);
                }
            }
        } catch (Throwable th6) {
            try {
                arrayList.add(th6);
                Iterator<FrameworkMethod> it5 = this.afters.iterator();
                while (it5.hasNext()) {
                    try {
                        it5.next().invokeExplosively(this.target, new Object[0]);
                    } catch (Throwable th7) {
                        arrayList.add(th7);
                    }
                }
            } catch (Throwable th8) {
                Iterator<FrameworkMethod> it6 = this.afters.iterator();
                while (it6.hasNext()) {
                    try {
                        it6.next().invokeExplosively(this.target, new Object[0]);
                    } catch (Throwable th9) {
                        arrayList.add(th9);
                    }
                }
                throw th8;
            }
        }
        MultipleFailureException.assertEmpty(arrayList);
    }
}
