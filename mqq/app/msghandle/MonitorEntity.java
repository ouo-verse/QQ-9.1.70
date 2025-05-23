package mqq.app.msghandle;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MonitorEntity {
    static final int THRESHOLD_NOT_REPORT = -2;
    static final int THRESHOLD_UNINITIALIZED = -1;
    final int eventFamily;
    int reportThreshold = -1;
    int umNotReported = 0;

    public MonitorEntity(int i3) {
        this.eventFamily = i3;
    }
}
