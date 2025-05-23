package junit.extensions;

import junit.framework.Test;
import junit.framework.TestResult;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RepeatedTest extends TestDecorator {
    private int fTimesRepeat;

    public RepeatedTest(Test test, int i3) {
        super(test);
        if (i3 >= 0) {
            this.fTimesRepeat = i3;
            return;
        }
        throw new IllegalArgumentException("Repetition count must be >= 0");
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public int countTestCases() {
        return super.countTestCases() * this.fTimesRepeat;
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public void run(TestResult testResult) {
        for (int i3 = 0; i3 < this.fTimesRepeat && !testResult.shouldStop(); i3++) {
            super.run(testResult);
        }
    }

    @Override // junit.extensions.TestDecorator
    public String toString() {
        return super.toString() + "(repeated)";
    }
}
