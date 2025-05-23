package com.tencent.mobileqq.msf.core;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes15.dex */
public class v {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f250120a = "WeakNetworkStat";

    /* renamed from: b, reason: collision with root package name */
    private static b f250121b = null;

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    private static final ConcurrentHashMap<String, b> f250122c;

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<b> f250123d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f250124e = 100;

    /* renamed from: f, reason: collision with root package name */
    private static final long f250125f = 3600000;

    /* renamed from: g, reason: collision with root package name */
    private static final int f250126g = 1000;

    /* renamed from: h, reason: collision with root package name */
    private static Handler f250127h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1000) {
                try {
                    v.c();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                v.f250127h.sendEmptyMessageDelayed(1000, 3600000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f250128a;

        /* renamed from: b, reason: collision with root package name */
        public int f250129b;

        /* renamed from: c, reason: collision with root package name */
        public long f250130c;

        /* renamed from: d, reason: collision with root package name */
        public long f250131d;

        /* renamed from: e, reason: collision with root package name */
        public StringBuilder f250132e;

        /* renamed from: f, reason: collision with root package name */
        public long f250133f;

        /* renamed from: g, reason: collision with root package name */
        public String f250134g;

        /* renamed from: h, reason: collision with root package name */
        public String f250135h;

        /* renamed from: i, reason: collision with root package name */
        public StringBuilder f250136i;

        /* renamed from: j, reason: collision with root package name */
        public long f250137j;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26156);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f250122c = new ConcurrentHashMap<>(100);
        f250123d = new ConcurrentLinkedQueue<>();
        f250127h = new a(q.r().getLooper());
    }

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        if (f250121b != null && SystemClock.elapsedRealtime() - f250121b.f250130c >= 3600000) {
            if (QLog.isColorLevel()) {
                QLog.d(f250120a, 2, "clean, clean infoLoginItem by interval check.");
            }
            a(f250121b, false, -1L);
            f250121b = null;
        }
        ConcurrentHashMap<String, b> concurrentHashMap = f250122c;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
                b value = entry.getValue();
                if (SystemClock.elapsedRealtime() - value.f250130c >= 3600000) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f250120a, 2, "clean, clean SendMsgItem by interval check.");
                    }
                    a(value, false, false);
                    f250122c.remove(entry.getKey());
                }
            }
        }
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = f250123d;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (elapsedRealtime - next.f250130c >= 3600000) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f250120a, 2, "clean, clean QuickSendedMsg by interval check.");
                    }
                    a(next, true, true);
                    f250123d.remove(next);
                }
            }
        }
    }

    public static void a(com.tencent.qphone.base.a aVar) {
        b bVar = f250121b;
        if (bVar != null) {
            if (bVar.f250132e.length() < 100) {
                StringBuilder sb5 = f250121b.f250132e;
                sb5.append(aVar.ordinal());
                sb5.append(",");
            } else if (QLog.isColorLevel()) {
                QLog.d(f250120a, 2, "onCloseConn, fail to append closeConnQueue by max size limit.");
            }
        }
        ConcurrentHashMap<String, b> concurrentHashMap = f250122c;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            Iterator<Map.Entry<String, b>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                b value = it.next().getValue();
                if (value.f250132e.length() < 100) {
                    StringBuilder sb6 = value.f250132e;
                    sb6.append(aVar.ordinal());
                    sb6.append(",");
                } else if (QLog.isColorLevel()) {
                    QLog.d(f250120a, 2, "onCloseConn, fail to append closeConnQueue by max size limit.");
                }
            }
        }
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = f250123d;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.size() <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<b> it5 = concurrentLinkedQueue.iterator();
        while (it5.hasNext()) {
            b next = it5.next();
            if (elapsedRealtime - next.f250137j <= 10000 && aVar == com.tencent.qphone.base.a.closeByNetDetectFailedNew) {
                StringBuilder sb7 = next.f250132e;
                sb7.append(aVar.ordinal());
                sb7.append(",");
            }
        }
    }

    public static void b(MsfCore msfCore, ToServiceMsg toServiceMsg) {
        b bVar = f250121b;
        if (bVar == null || TextUtils.isEmpty(bVar.f250128a) || !f250121b.f250128a.equals(toServiceMsg.getUin())) {
            b bVar2 = new b(null);
            f250121b = bVar2;
            bVar2.f250128a = toServiceMsg.getUin();
            f250121b.f250129b = toServiceMsg.getRequestSsoSeq();
            f250121b.f250130c = SystemClock.elapsedRealtime();
            f250121b.f250132e = new StringBuilder();
            f250121b.f250136i = new StringBuilder();
        }
        if (f250127h.hasMessages(1000)) {
            return;
        }
        f250127h.sendEmptyMessageDelayed(1000, 3600000L);
    }

    public static void a(FromServiceMsg fromServiceMsg) {
        b bVar = f250121b;
        if (bVar == null || TextUtils.isEmpty(bVar.f250128a) || !f250121b.f250128a.equals(fromServiceMsg.getUin())) {
            return;
        }
        b bVar2 = f250121b;
        if (bVar2.f250130c > 0) {
            a(bVar2, true, -1L);
            f250121b = null;
        }
    }

    public static void a(String str, long j3) {
        b bVar = f250121b;
        if (bVar == null || TextUtils.isEmpty(bVar.f250128a) || !f250121b.f250128a.equals(str) || f250121b.f250130c <= 0) {
            return;
        }
        QLog.d(f250120a, 1, "start to report info login uin:" + str + ", timeEnd:" + j3);
        a(f250121b, true, j3);
        f250121b = null;
    }

    public static void a(MsfCore msfCore, ToServiceMsg toServiceMsg) {
        if (TextUtils.isEmpty(toServiceMsg.getUin()) || "0".equals(toServiceMsg.getUin())) {
            return;
        }
        ConcurrentHashMap<String, b> concurrentHashMap = f250122c;
        if (concurrentHashMap.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq())) || !BaseConstants.CMD_MSG_PBSENDMSG.equals(toServiceMsg.getServiceCmd())) {
            return;
        }
        int intValue = toServiceMsg.getAttributes().containsKey(AppConstants.Key.COLUMN_MSG_TYPE) ? ((Integer) toServiceMsg.getAttributes().get(AppConstants.Key.COLUMN_MSG_TYPE)).intValue() : -1;
        boolean booleanValue = toServiceMsg.getAttributes().containsKey("resend_by_user") ? ((Boolean) toServiceMsg.getAttributes().get("resend_by_user")).booleanValue() : false;
        int intValue2 = toServiceMsg.getAttributes().containsKey("retryIndex") ? ((Integer) toServiceMsg.getAttributes().get("retryIndex")).intValue() : -1;
        long longValue = toServiceMsg.getAttributes().containsKey("msgSeq") ? ((Long) toServiceMsg.getAttributes().get("msgSeq")).longValue() : -1L;
        a aVar = null;
        String str = toServiceMsg.getAttributes().containsKey("fromUin") ? (String) toServiceMsg.getAttributes().get("fromUin") : null;
        String str2 = toServiceMsg.getAttributes().containsKey("uin") ? (String) toServiceMsg.getAttributes().get("uin") : null;
        if (intValue != -1000 || booleanValue || intValue2 > 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        b bVar = new b(aVar);
        bVar.f250128a = toServiceMsg.getUin();
        bVar.f250129b = toServiceMsg.getRequestSsoSeq();
        bVar.f250130c = SystemClock.elapsedRealtime();
        bVar.f250132e = new StringBuilder();
        bVar.f250133f = longValue;
        bVar.f250134g = str;
        bVar.f250135h = str2;
        bVar.f250136i = new StringBuilder();
        concurrentHashMap.put(str + str2 + longValue, bVar);
    }

    public static synchronized void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        StringBuilder sb5;
        synchronized (v.class) {
            if (toServiceMsg != null) {
                if (!TextUtils.isEmpty(fromServiceMsg.getUin()) && !"0".equals(fromServiceMsg.getUin()) && BaseConstants.CMD_MSG_PBSENDMSG.equals(fromServiceMsg.getServiceCmd())) {
                    int intValue = toServiceMsg.getAttributes().containsKey(AppConstants.Key.COLUMN_MSG_TYPE) ? ((Integer) toServiceMsg.getAttributes().get(AppConstants.Key.COLUMN_MSG_TYPE)).intValue() : -1;
                    boolean booleanValue = toServiceMsg.getAttributes().containsKey("resend_by_user") ? ((Boolean) toServiceMsg.getAttributes().get("resend_by_user")).booleanValue() : false;
                    if (toServiceMsg.getAttributes().containsKey("retryIndex")) {
                        ((Integer) toServiceMsg.getAttributes().get("retryIndex")).intValue();
                    }
                    long longValue = toServiceMsg.getAttributes().containsKey("msgSeq") ? ((Long) toServiceMsg.getAttributes().get("msgSeq")).longValue() : -1L;
                    String str = toServiceMsg.getAttributes().containsKey("fromUin") ? (String) toServiceMsg.getAttributes().get("fromUin") : null;
                    String str2 = toServiceMsg.getAttributes().containsKey("uin") ? (String) toServiceMsg.getAttributes().get("uin") : null;
                    if (intValue == -1000 && !booleanValue && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        ConcurrentHashMap<String, b> concurrentHashMap = f250122c;
                        if (concurrentHashMap.containsKey(str + str2 + longValue)) {
                            if (fromServiceMsg.isSuccess()) {
                                b remove = concurrentHashMap.remove(str + str2 + longValue);
                                if (z16 && remove.f250132e.length() <= 0) {
                                    remove.f250137j = SystemClock.elapsedRealtime();
                                    f250123d.offer(remove);
                                }
                                a(remove, true, z16);
                            } else {
                                b bVar = concurrentHashMap.get(str + str2 + longValue);
                                if (bVar != null && (sb5 = bVar.f250136i) != null && sb5.length() < 100) {
                                    StringBuilder sb6 = bVar.f250136i;
                                    sb6.append(fromServiceMsg.getBusinessFailCode());
                                    sb6.append(",");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void a(b bVar, boolean z16, long j3) {
        if (bVar == null || bVar.f250132e.length() <= 0) {
            return;
        }
        if (j3 == -1) {
            bVar.f250131d = SystemClock.elapsedRealtime() - bVar.f250130c;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(f250120a, 2, "report infologin start timestamp:" + bVar.f250130c);
            }
            bVar.f250131d = j3 - bVar.f250130c;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", bVar.f250128a);
        hashMap.put("ssoSeq", "" + bVar.f250129b);
        hashMap.put("closeConnReason", bVar.f250132e.toString());
        hashMap.put("infoVersion", "6.2.0");
        if (MsfService.core.getStatReporter() != null) {
            MsfService.core.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.V, z16, bVar.f250131d, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    private static void a(b bVar, boolean z16, boolean z17) {
        if (bVar != null) {
            if (bVar.f250132e.length() > 0 || z17) {
                bVar.f250131d = SystemClock.elapsedRealtime() - bVar.f250130c;
                HashMap hashMap = new HashMap();
                hashMap.put("uin", bVar.f250128a);
                hashMap.put("ssoSeq", "" + bVar.f250129b);
                hashMap.put("closeConnReason", bVar.f250132e.toString());
                hashMap.put("msgSeq", "" + bVar.f250133f);
                hashMap.put("fromUin", bVar.f250134g);
                hashMap.put("toUin", bVar.f250135h);
                hashMap.put("sendFailReason", bVar.f250136i.toString());
                hashMap.put("quickSend", "" + z17);
                hashMap.put("quickSuccTime", "" + bVar.f250137j);
                if (MsfService.core.getStatReporter() != null) {
                    MsfService.core.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.U, z16, bVar.f250131d, 0L, (Map<String, String>) hashMap, false, false);
                }
            }
        }
    }
}
