package mh;

import android.text.TextUtils;
import com.qzone.reborn.feedx.video.QZonePlayer;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private int f416757b;

    public c(boolean z16) {
        this.f416757b = z16 ? 1 : 0;
    }

    public synchronized QZonePlayer d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d("QZonePlayerManagerProxy", 1, "new circle player, uniqueKey = " + str + ", playerType = " + this.f416757b);
        e();
        int i3 = this.f416757b;
        if (i3 == 0) {
            return d.d().e(str);
        }
        if (i3 != 1) {
            return null;
        }
        return b.d().e(str);
    }

    public synchronized boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QLog.d("QZonePlayerManagerProxy", 1, "releasePlayer uniquekey = " + str + ", playerType = " + this.f416757b);
        int i3 = this.f416757b;
        if (i3 == 0) {
            return d.d().g(str);
        }
        if (i3 != 1) {
            return false;
        }
        return b.d().g(str);
    }

    public void e() {
        QLog.d("QZonePlayerManagerProxy", 1, "release all");
        d.d().f();
        b.d().f();
    }
}
