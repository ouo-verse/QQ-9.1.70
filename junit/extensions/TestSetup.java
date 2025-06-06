package junit.extensions;

import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestResult;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TestSetup extends TestDecorator {
    public TestSetup(Test test) {
        super(test);
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public void run(final TestResult testResult) {
        testResult.runProtected(this, new Protectable() { // from class: junit.extensions.TestSetup.1
            @Override // junit.framework.Protectable
            public void protect() throws Exception {
                TestSetup.this.setUp();
                TestSetup.this.basicRun(testResult);
                TestSetup.this.tearDown();
            }
        });
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
}
