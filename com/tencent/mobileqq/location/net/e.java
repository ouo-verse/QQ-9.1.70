package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static volatile e f241356f;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f241357a;

    /* renamed from: b, reason: collision with root package name */
    public LocationRoom.b f241358b;

    /* renamed from: c, reason: collision with root package name */
    private LocationRoom.b f241359c;

    /* renamed from: d, reason: collision with root package name */
    public h f241360d;

    /* renamed from: e, reason: collision with root package name */
    public RoomQueryHandler f241361e;

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f241357a = false;
        this.f241360d = new h();
        this.f241361e = new RoomQueryHandler();
    }

    public static e c() {
        if (f241356f == null) {
            synchronized (f.class) {
                if (f241356f == null) {
                    f241356f = new e();
                }
            }
        }
        return f241356f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        if (com.tencent.mobileqq.location.util.b.b(r8) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (com.tencent.mobileqq.location.util.b.c(r8) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "[LocationManager] createOrJoinRoom: invoked.");
        }
        if (i3 != 0) {
            if (i3 != 1) {
                QLog.d("Q.LocationShare", 1, "createOrJoinRoom: invoked. (\u8fdb\u5165\u5df2\u5173\u95ed\u7684\u623f\u95f4\uff0c\u9700\u8981\u515c\u5e95\u903b\u8f91[\u5f39\u7a97\u3001\u5237\u65b0\u672c\u5730\u6807\u5fd7\u7b49]) ", " operateType: ", 0, " mLocationShareFragment.sessionUinType: ", Integer.valueOf(i3));
                i16 = 0;
            }
            this.f241360d.e(i16, i3, str);
        }
    }

    public LocationRoom.b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LocationRoom.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f241359c;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "joinOrCreateRoomNotReEntry: invoked. ", " isJoinOrCreateRoomNotReEntry: ", Boolean.valueOf(this.f241357a));
        }
        return this.f241357a;
    }

    public void e(int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (com.tencent.mobileqq.location.util.b.d(i3, str)) {
            ReportController.o(null, "CliOper", "", "", "0X800A76C", "0X800A76C", LocationHandler.I2(i16), 0, "" + i17, "0", "0", "");
            return;
        }
        ReportController.o(null, "CliOper", "", "", "0X800A765", "0X800A765", i17, 0, "", "0", "0", "");
    }

    public void f(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.f241359c = bVar;
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "setJoinOrCreateRoomNotReEntry: invoked. ", " joinOrCreateRoomNotReEntry: ", Boolean.valueOf(z16));
        }
        this.f241357a = z16;
    }
}
