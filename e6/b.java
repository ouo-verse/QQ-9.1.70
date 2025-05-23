package e6;

import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private QZoneTask f395744d;

    @Override // e6.a
    protected QZoneResult a(int i3) {
        QZoneTask qZoneTask = this.f395744d;
        if (qZoneTask != null) {
            return qZoneTask.getResult(i3);
        }
        return new QZoneResult(i3);
    }

    public QZoneTask g() {
        return this.f395744d;
    }

    public void h(QZoneTask qZoneTask) {
        this.f395744d = qZoneTask;
    }
}
