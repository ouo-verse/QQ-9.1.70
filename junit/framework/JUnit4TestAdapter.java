package junit.framework;

import java.util.Iterator;
import java.util.List;
import org.junit.Ignore;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;

/* compiled from: P */
/* loaded from: classes28.dex */
public class JUnit4TestAdapter implements Test, Filterable, Sortable, Describable {
    private final JUnit4TestAdapterCache fCache;
    private final Class<?> fNewTestClass;
    private final Runner fRunner;

    public JUnit4TestAdapter(Class<?> cls) {
        this(cls, JUnit4TestAdapterCache.getDefault());
    }

    private boolean isIgnored(Description description) {
        if (description.getAnnotation(Ignore.class) != null) {
            return true;
        }
        return false;
    }

    private Description removeIgnored(Description description) {
        if (isIgnored(description)) {
            return Description.EMPTY;
        }
        Description childlessCopy = description.childlessCopy();
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            Description removeIgnored = removeIgnored(it.next());
            if (!removeIgnored.isEmpty()) {
                childlessCopy.addChild(removeIgnored);
            }
        }
        return childlessCopy;
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        return this.fRunner.testCount();
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        filter.apply(this.fRunner);
    }

    @Override // org.junit.runner.Describable
    public Description getDescription() {
        return removeIgnored(this.fRunner.getDescription());
    }

    public Class<?> getTestClass() {
        return this.fNewTestClass;
    }

    public List<Test> getTests() {
        return this.fCache.asTestList(getDescription());
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        this.fRunner.run(this.fCache.getNotifier(testResult, this));
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        sorter.apply(this.fRunner);
    }

    public String toString() {
        return this.fNewTestClass.getName();
    }

    public JUnit4TestAdapter(Class<?> cls, JUnit4TestAdapterCache jUnit4TestAdapterCache) {
        this.fCache = jUnit4TestAdapterCache;
        this.fNewTestClass = cls;
        this.fRunner = Request.classWithoutSuiteMethod(cls).getRunner();
    }
}
