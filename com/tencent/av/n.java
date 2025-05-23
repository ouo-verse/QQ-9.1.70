package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: c, reason: collision with root package name */
    static volatile n f73845c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f73846d = "AvSessionMgr";

    /* renamed from: a, reason: collision with root package name */
    private SessionInfo f73847a = new SessionInfo();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, SessionInfo> f73848b = new HashMap();

    public static String b(int i3, String str, int... iArr) {
        if (!TextUtils.isEmpty(str) && str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        String str2 = String.valueOf(i3) + "-" + str;
        if (i3 == 1 && iArr != null && iArr.length == 1) {
            return str2 + "-" + iArr[0];
        }
        return str2;
    }

    public static n e() {
        if (f73845c == null) {
            synchronized (n.class) {
                if (f73845c == null) {
                    f73845c = new n();
                }
            }
        }
        return f73845c;
    }

    public static int h(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 3000) {
            return 3;
        }
        return 2;
    }

    public static boolean l(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return false;
        }
        int i3 = sessionInfo.f73067q;
        if (i3 != -1) {
            if (i3 == 3000 || i3 == 1) {
                return false;
            }
            return true;
        }
        int i16 = sessionInfo.S0;
        if (i16 != 0) {
            if (i16 != 3 && i16 != 100 && i16 != 4) {
                return false;
            }
            return true;
        }
        if (!sessionInfo.f73060o0) {
            return false;
        }
        return true;
    }

    public synchronized SessionInfo a(String str, boolean z16) {
        SessionInfo sessionInfo;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e(f73846d, 2, "createSession with null sessionId ");
            }
            return null;
        }
        if (this.f73848b.get(str) != null) {
            if (QLog.isColorLevel()) {
                QLog.d(f73846d, 2, "createSession already exist sessionId : " + str);
            }
            return this.f73848b.get(str);
        }
        if (this.f73848b.isEmpty()) {
            sessionInfo = this.f73847a;
        } else {
            sessionInfo = new SessionInfo();
        }
        this.f73848b.put(str, sessionInfo);
        sessionInfo.m0("createSession", str);
        QLog.w(f73846d, 1, "createSession, sessionId[" + str + "], TAG[" + sessionInfo.f73020f + "]");
        if (this.f73848b.size() != 1 && !z16) {
            p(str, 1);
            return sessionInfo;
        }
        p(str, 2);
        return sessionInfo;
    }

    public synchronized int c() {
        int i3;
        boolean z16;
        i3 = 0;
        for (String str : this.f73848b.keySet()) {
            SessionInfo sessionInfo = this.f73848b.get(str);
            if (!sessionInfo.D()) {
                i3++;
            }
            if (QLog.isColorLevel()) {
                String str2 = f73846d;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getAliveSessionCount, count[");
                sb5.append(i3);
                sb5.append("], key[");
                sb5.append(str);
                sb5.append("], main[");
                if (sessionInfo == this.f73847a) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append("], session[");
                sb5.append(sessionInfo);
                sb5.append("]");
                QLog.w(str2, 1, sb5.toString());
            }
        }
        return i3;
    }

    public synchronized SessionInfo d(String str) {
        SessionInfo sessionInfo;
        Iterator<String> it = this.f73848b.keySet().iterator();
        sessionInfo = null;
        while (it.hasNext()) {
            SessionInfo sessionInfo2 = this.f73848b.get(it.next());
            if (sessionInfo2 != null) {
                String str2 = sessionInfo2.f73091w;
                if (str2 != null) {
                    if (str2.equals(str)) {
                        if (sessionInfo != null && !l(sessionInfo2)) {
                        }
                        sessionInfo = sessionInfo2;
                    }
                }
            }
        }
        return sessionInfo;
    }

    public synchronized SessionInfo f() {
        return this.f73847a;
    }

    public synchronized SessionInfo g(String str) {
        SessionInfo sessionInfo;
        Iterator<String> it = this.f73848b.keySet().iterator();
        sessionInfo = null;
        while (it.hasNext()) {
            SessionInfo sessionInfo2 = this.f73848b.get(it.next());
            if (sessionInfo2 != null) {
                if (TextUtils.equals(str, sessionInfo2.f73091w)) {
                    if (sessionInfo == null) {
                        if (!sessionInfo2.f73060o0) {
                            sessionInfo = sessionInfo2;
                        }
                    }
                    if (l(sessionInfo2) && !sessionInfo2.f73060o0) {
                        sessionInfo = sessionInfo2;
                    }
                }
            }
        }
        return sessionInfo;
    }

    public synchronized SessionInfo i(String str) {
        if (!this.f73848b.containsKey(str) && QLog.isColorLevel()) {
            QLog.e(f73846d, 2, "getSession not exist sessionId : " + str);
        }
        return this.f73848b.get(str);
    }

    public synchronized boolean j(String str) {
        return this.f73848b.containsKey(str);
    }

    public synchronized boolean k() {
        Iterator<String> it = this.f73848b.keySet().iterator();
        while (it.hasNext()) {
            if (!this.f73848b.get(it.next()).D()) {
                return false;
            }
        }
        return true;
    }

    public synchronized boolean m() {
        boolean z16;
        z16 = true;
        if (c() <= 1) {
            z16 = false;
        }
        return z16;
    }

    public synchronized boolean n(long j3, String str) {
        boolean containsKey = this.f73848b.containsKey(str);
        QLog.w(f73846d, 1, "removeSession, sessionId[" + str + "], size[" + this.f73848b.size() + "], contains[" + containsKey + "], seq[" + j3 + "]");
        if (containsKey) {
            SessionInfo remove = this.f73848b.remove(str);
            if (this.f73848b.size() == 1) {
                Iterator<String> it = this.f73848b.keySet().iterator();
                while (it.hasNext()) {
                    o(it.next());
                }
            }
            if (this.f73847a == remove) {
                this.f73847a = new SessionInfo();
                QLog.i(f73846d, 1, "removeSession, active is cur need remove one. id[" + str + "]");
            }
            return true;
        }
        return false;
    }

    public synchronized boolean o(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(f73846d, 2, "setMainSession sessionId[" + str + "]", new Throwable("setMainSession"));
        }
        if (this.f73848b.containsKey(str)) {
            p(str, 2);
            return true;
        }
        return false;
    }

    public synchronized void p(String str, int i3) {
        StringBuilder sb5;
        int i16 = -1;
        int i17 = 0;
        if (this.f73848b.containsKey(str)) {
            SessionInfo sessionInfo = this.f73848b.get(str);
            if (sessionInfo == null) {
                i17 = 1;
            } else {
                i16 = sessionInfo.f73025g;
                if (i16 != i3) {
                    if (i3 == 2) {
                        this.f73847a = sessionInfo;
                    }
                    sessionInfo.o0(i3);
                } else if (i3 == 2 && this.f73847a != sessionInfo) {
                    this.f73847a = sessionInfo;
                    i17 = 2;
                }
            }
        }
        if (QLog.isColorLevel() || i16 != i3 || i17 != 0) {
            String str2 = f73846d;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("setSessionStatus, sessionId[");
            sb6.append(str);
            sb6.append("], status[");
            if (i17 == 0) {
                sb5 = new StringBuilder();
                sb5.append(i16);
                sb5.append("->");
                sb5.append(i3);
            } else {
                sb5 = new StringBuilder();
                sb5.append(i3);
                sb5.append("], step[");
                sb5.append(i17);
            }
            sb6.append(sb5.toString());
            sb6.append("]");
            QLog.w(str2, 1, sb6.toString());
        }
    }
}
