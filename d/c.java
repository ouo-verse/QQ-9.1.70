package d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f392540a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f392541a;

        /* renamed from: b, reason: collision with root package name */
        public int f392542b;

        /* renamed from: c, reason: collision with root package name */
        public long f392543c;

        /* renamed from: d, reason: collision with root package name */
        public long f392544d;

        /* renamed from: e, reason: collision with root package name */
        public String f392545e;

        /* renamed from: f, reason: collision with root package name */
        public String f392546f;

        /* renamed from: g, reason: collision with root package name */
        public long f392547g;

        /* renamed from: h, reason: collision with root package name */
        public long f392548h;

        b() {
            this.f392547g = -1L;
            this.f392548h = -1L;
        }
    }

    public static void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (Map.Entry<String, b> entry : f392540a.entrySet()) {
            String key = entry.getKey();
            b value = entry.getValue();
            if (elapsedRealtime - value.f392543c > 480000) {
                f392540a.remove(key);
                e(value, false);
            }
        }
    }

    public static void b(ToServiceMsg toServiceMsg) {
        int i3;
        boolean z16;
        long j3;
        String str;
        String str2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        if (!TextUtils.isEmpty(toServiceMsg.getUin()) && !"0".equals(toServiceMsg.getUin())) {
            ConcurrentHashMap<String, b> concurrentHashMap = f392540a;
            if (!concurrentHashMap.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq())) && BaseConstants.CMD_MSG_PBSENDMSG.equals(toServiceMsg.getServiceCmd())) {
                HashMap<String, Object> attributes = toServiceMsg.getAttributes();
                int i16 = -1;
                if (attributes.containsKey(AppConstants.Key.COLUMN_MSG_TYPE) && (obj6 = attributes.get(AppConstants.Key.COLUMN_MSG_TYPE)) != null) {
                    i3 = ((Integer) obj6).intValue();
                } else {
                    i3 = -1;
                }
                if (attributes.containsKey("resend_by_user") && (obj5 = attributes.get("resend_by_user")) != null) {
                    z16 = ((Boolean) obj5).booleanValue();
                } else {
                    z16 = false;
                }
                if (attributes.containsKey("retryIndex") && (obj4 = attributes.get("retryIndex")) != null) {
                    i16 = ((Integer) obj4).intValue();
                }
                if (attributes.containsKey("msgSeq") && (obj3 = attributes.get("msgSeq")) != null) {
                    j3 = ((Long) obj3).longValue();
                } else {
                    j3 = -1;
                }
                if (attributes.containsKey("fromUin") && (obj2 = attributes.get("fromUin")) != null) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
                if (attributes.containsKey("uin") && (obj = attributes.get("uin")) != null) {
                    str2 = (String) obj;
                } else {
                    str2 = null;
                }
                if (i3 == -1000 && !z16 && i16 <= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    b bVar = new b();
                    bVar.f392541a = toServiceMsg.getUin();
                    bVar.f392542b = toServiceMsg.getRequestSsoSeq();
                    bVar.f392543c = SystemClock.elapsedRealtime();
                    bVar.f392544d = j3;
                    bVar.f392545e = str;
                    bVar.f392546f = str2;
                    concurrentHashMap.put(str + str2 + j3, bVar);
                }
            }
        }
    }

    public static void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3;
        boolean z16;
        long j3;
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        if (!TextUtils.isEmpty(toServiceMsg.getUin()) && !"0".equals(toServiceMsg.getUin()) && BaseConstants.CMD_MSG_PBSENDMSG.equals(toServiceMsg.getServiceCmd()) && fromServiceMsg.isSuccess()) {
            HashMap<String, Object> attributes = toServiceMsg.getAttributes();
            int i16 = -1;
            if (attributes.containsKey(AppConstants.Key.COLUMN_MSG_TYPE) && (obj6 = attributes.get(AppConstants.Key.COLUMN_MSG_TYPE)) != null) {
                i3 = ((Integer) obj6).intValue();
            } else {
                i3 = -1;
            }
            if (attributes.containsKey("resend_by_user") && (obj5 = attributes.get("resend_by_user")) != null) {
                z16 = ((Boolean) obj5).booleanValue();
            } else {
                z16 = false;
            }
            if (attributes.containsKey("retryIndex") && (obj4 = attributes.get("retryIndex")) != null) {
                i16 = ((Integer) obj4).intValue();
            }
            if (attributes.containsKey("msgSeq") && (obj3 = attributes.get("msgSeq")) != null) {
                j3 = ((Long) obj3).longValue();
            } else {
                j3 = -1;
            }
            String str2 = null;
            if (attributes.containsKey("fromUin") && (obj2 = attributes.get("fromUin")) != null) {
                str = (String) obj2;
            } else {
                str = null;
            }
            if (attributes.containsKey("uin") && (obj = attributes.get("uin")) != null) {
                str2 = (String) obj;
            }
            if (i3 == -1000 && !z16 && i16 <= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str3 = str + str2 + j3;
                ConcurrentHashMap<String, b> concurrentHashMap = f392540a;
                b bVar = concurrentHashMap.get(str3);
                if (bVar != null) {
                    concurrentHashMap.remove(str3);
                    if (bVar.f392547g <= 0) {
                        return;
                    }
                    bVar.f392548h = SystemClock.elapsedRealtime();
                    e(bVar, true);
                }
            }
        }
    }

    public static void d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        int i3;
        boolean z17;
        long j3;
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        if (!TextUtils.isEmpty(toServiceMsg.getUin()) && !"0".equals(toServiceMsg.getUin()) && BaseConstants.CMD_MSG_PBSENDMSG.equals(toServiceMsg.getServiceCmd())) {
            HashMap<String, Object> attributes = toServiceMsg.getAttributes();
            int i16 = -1;
            if (attributes.containsKey(AppConstants.Key.COLUMN_MSG_TYPE) && (obj6 = attributes.get(AppConstants.Key.COLUMN_MSG_TYPE)) != null) {
                i3 = ((Integer) obj6).intValue();
            } else {
                i3 = -1;
            }
            if (attributes.containsKey("resend_by_user") && (obj5 = attributes.get("resend_by_user")) != null) {
                z17 = ((Boolean) obj5).booleanValue();
            } else {
                z17 = false;
            }
            if (attributes.containsKey("retryIndex") && (obj4 = attributes.get("retryIndex")) != null) {
                i16 = ((Integer) obj4).intValue();
            }
            if (attributes.containsKey("msgSeq") && (obj3 = attributes.get("msgSeq")) != null) {
                j3 = ((Long) obj3).longValue();
            } else {
                j3 = -1;
            }
            String str2 = null;
            if (attributes.containsKey("fromUin") && (obj2 = attributes.get("fromUin")) != null) {
                str = (String) obj2;
            } else {
                str = null;
            }
            if (attributes.containsKey("uin") && (obj = attributes.get("uin")) != null) {
                str2 = (String) obj;
            }
            if (i3 == -1000 && !z17 && i16 <= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str3 = str + str2 + j3;
                ConcurrentHashMap<String, b> concurrentHashMap = f392540a;
                b bVar = concurrentHashMap.get(str3);
                if (bVar != null) {
                    if (z16) {
                        if (bVar.f392548h <= 0) {
                            bVar.f392547g = SystemClock.elapsedRealtime();
                            return;
                        } else {
                            concurrentHashMap.remove(str3);
                            return;
                        }
                    }
                    concurrentHashMap.remove(str3);
                    if (bVar.f392547g <= 0) {
                        return;
                    }
                    if (bVar.f392548h <= 0) {
                        bVar.f392548h = SystemClock.elapsedRealtime();
                    }
                    e(bVar, true);
                }
            }
        }
    }

    private static void e(b bVar, boolean z16) {
        if (bVar != null) {
            long j3 = bVar.f392547g;
            if (j3 > 0) {
                long j16 = bVar.f392548h;
                if (j16 > 0 && j3 < j16 && MsfService.core.getStatReporter() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uin", bVar.f392541a);
                    hashMap.put("ssoSeq", "" + bVar.f392542b);
                    hashMap.put("msgSeq", "" + bVar.f392544d);
                    hashMap.put("fromUin", bVar.f392545e);
                    hashMap.put("toUin", bVar.f392546f);
                    hashMap.put("onsectime", "" + bVar.f392547g);
                    hashMap.put("normaltime", "" + bVar.f392548h);
                    MsfService.core.getStatReporter().a(g.E0, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
            }
        }
    }
}
