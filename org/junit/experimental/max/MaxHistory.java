package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MaxHistory implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<String, Long> fDurations = new HashMap();
    private final Map<String, Long> fFailureTimestamps = new HashMap();
    private final File fHistoryStore;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private final class RememberingListener extends RunListener {
        private long overallStart;
        private Map<Description, Long> starts;

        RememberingListener() {
            this.overallStart = System.currentTimeMillis();
            this.starts = new HashMap();
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFailure(Failure failure) throws Exception {
            MaxHistory.this.putTestFailureTimestamp(failure.getDescription(), this.overallStart);
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFinished(Description description) throws Exception {
            MaxHistory.this.putTestDuration(description, System.nanoTime() - this.starts.get(description).longValue());
        }

        @Override // org.junit.runner.notification.RunListener
        public void testRunFinished(Result result) throws Exception {
            MaxHistory.this.save();
        }

        @Override // org.junit.runner.notification.RunListener
        public void testStarted(Description description) throws Exception {
            this.starts.put(description, Long.valueOf(System.nanoTime()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private class TestComparator implements Comparator<Description> {
        TestComparator() {
        }

        private Long getFailure(Description description) {
            Long failureTimestamp = MaxHistory.this.getFailureTimestamp(description);
            if (failureTimestamp == null) {
                return 0L;
            }
            return failureTimestamp;
        }

        @Override // java.util.Comparator
        public int compare(Description description, Description description2) {
            if (MaxHistory.this.isNewTest(description)) {
                return -1;
            }
            if (MaxHistory.this.isNewTest(description2)) {
                return 1;
            }
            int compareTo = getFailure(description2).compareTo(getFailure(description));
            return compareTo != 0 ? compareTo : MaxHistory.this.getTestDuration(description).compareTo(MaxHistory.this.getTestDuration(description2));
        }
    }

    MaxHistory(File file) {
        this.fHistoryStore = file;
    }

    public static MaxHistory forFolder(File file) {
        if (file.exists()) {
            try {
                return readHistory(file);
            } catch (CouldNotReadCoreException e16) {
                e16.printStackTrace();
                file.delete();
            }
        }
        return new MaxHistory(file);
    }

    private static MaxHistory readHistory(File file) throws CouldNotReadCoreException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    return (MaxHistory) objectInputStream.readObject();
                } finally {
                    objectInputStream.close();
                }
            } finally {
                fileInputStream.close();
            }
        } catch (Exception e16) {
            throw new CouldNotReadCoreException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fHistoryStore));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    Long getFailureTimestamp(Description description) {
        return this.fFailureTimestamps.get(description.toString());
    }

    Long getTestDuration(Description description) {
        return this.fDurations.get(description.toString());
    }

    boolean isNewTest(Description description) {
        return !this.fDurations.containsKey(description.toString());
    }

    public RunListener listener() {
        return new RememberingListener();
    }

    void putTestDuration(Description description, long j3) {
        this.fDurations.put(description.toString(), Long.valueOf(j3));
    }

    void putTestFailureTimestamp(Description description, long j3) {
        this.fFailureTimestamps.put(description.toString(), Long.valueOf(j3));
    }

    public Comparator<Description> testComparator() {
        return new TestComparator();
    }
}
