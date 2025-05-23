package com.tencent.av.doodle;

import android.os.SystemClock;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private DoodleLogic f73617a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f73618b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f73619c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f73620d = false;

    public c(DoodleLogic doodleLogic) {
        this.f73617a = doodleLogic;
    }

    private void c() {
        if (this.f73618b) {
            this.f73619c = SystemClock.elapsedRealtime();
        } else {
            e(this.f73617a.f73586e);
        }
    }

    private void e(int i3) {
        if (this.f73619c != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f73619c;
            if (elapsedRealtime > 3000) {
                HashMap hashMap = new HashMap();
                String hexString = Integer.toHexString(i3);
                String valueOf = String.valueOf(elapsedRealtime);
                hashMap.put("color", hexString);
                hashMap.put("duration", valueOf);
                UserAction.onUserAction("actAVFunChatDrawing", true, -1L, -1L, hashMap, true);
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleReportController", 2, "onUserAction colorString = " + hexString + ", durationString = " + valueOf);
                }
                this.f73620d = true;
            }
        }
    }

    public boolean a() {
        return this.f73618b;
    }

    public void b(int i3) {
        if (this.f73618b && i3 != this.f73617a.f73586e) {
            e(i3);
            this.f73619c = SystemClock.elapsedRealtime();
        }
    }

    public void d() {
        f(false);
        if (this.f73620d) {
            DoodleUtils.h("0X80077C2");
        } else {
            DoodleUtils.h("0X80077C1");
        }
    }

    public void f(boolean z16) {
        if (this.f73618b != z16) {
            this.f73618b = z16;
            c();
        }
    }
}
