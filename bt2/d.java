package bt2;

import androidx.annotation.NonNull;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f29101a;

    /* renamed from: b, reason: collision with root package name */
    private final GroupRobotInfo f29102b;

    public d(@NonNull GroupRobotInfo groupRobotInfo) {
        this.f29101a = groupRobotInfo.getStatus();
        this.f29102b = groupRobotInfo;
    }

    public String a() {
        return this.f29102b.getName();
    }

    public long b() {
        return this.f29102b.getRobotUin();
    }

    public boolean c() {
        if (this.f29102b.getOffline() == 1) {
            return true;
        }
        return false;
    }
}
