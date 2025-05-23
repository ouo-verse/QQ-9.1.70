package com.tencent.mobileqq.troop.essencemsg;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements TroopManager.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TroopInfo f295348a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f295349b;

        a(TroopInfo troopInfo, HashMap hashMap) {
            this.f295348a = troopInfo;
            this.f295349b = hashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopInfo, (Object) hashMap);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
        public void a(TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f295349b.put(IPublicAccountBrowser.KEY_UIN_TYPE, String.valueOf(s.d(this.f295348a, troopMemberInfo)));
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
            }
        }
    }

    private static void b(TroopInfo troopInfo, HashMap<String, String> hashMap) {
        if (troopInfo == null) {
            return;
        }
        com.tencent.mobileqq.troop.troopcatalog.a c16 = c(String.valueOf(troopInfo.dwGroupClassExt));
        if (c16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopEssenceReportUtil", 1, "fillGroupClassExParams: catalogBean == null");
            }
        } else {
            if (c16.f299959a == 1) {
                hashMap.put("group_type1", String.valueOf(c16.f299961c));
                return;
            }
            com.tencent.mobileqq.troop.troopcatalog.a aVar = c16.f299963e;
            if (aVar != null) {
                hashMap.put("group_type1", String.valueOf(aVar.f299961c));
            }
            hashMap.put("group_type2", String.valueOf(c16.f299961c));
        }
    }

    private static com.tencent.mobileqq.troop.troopcatalog.a c(String str) {
        com.tencent.mobileqq.troop.troopcatalog.a c16;
        com.tencent.mobileqq.troop.troopcatalog.a aVar;
        if (TextUtils.isEmpty(str) || (c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(str)) == null) {
            return null;
        }
        if (c16.f299959a > 2 && (aVar = c16.f299963e) != null) {
            return c(aVar.f299961c);
        }
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        if (troopInfo != null && troopMemberInfo != null) {
            if (troopInfo.isTroopOwner(troopMemberInfo.memberuin)) {
                return 1;
            }
            if (troopInfo.isTroopAdmin(troopMemberInfo.memberuin)) {
                return 2;
            }
            return 3;
        }
        return 4;
    }

    private static void e(QQAppInterface qQAppInterface, String str, String str2, HashMap<String, String> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(str)) {
            hashMap = new HashMap<>();
        }
        String currentUin = qQAppInterface.getCurrentUin();
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo k3 = troopManager.k(str);
        hashMap.put("group_id", str);
        b(k3, hashMap);
        troopManager.D(str, currentUin, "TroopEssenceReportUtil", new a(k3, hashMap));
    }

    public static void f(QQAppInterface qQAppInterface, long j3, boolean z16) {
        String str;
        if (qQAppInterface == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("action_result", str);
        e(qQAppInterface, String.valueOf(j3), "click#group_aio_mulitple_choice#pin_button", hashMap);
    }

    public static void g(QQAppInterface qQAppInterface, long j3, boolean z16) {
        String str;
        if (qQAppInterface == null) {
            return;
        }
        String valueOf = String.valueOf(j3);
        String valueOf2 = String.valueOf(u.l(qQAppInterface, String.valueOf(j3)));
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(null, "dc00898", "", valueOf, "0X800B72A", "0X800B72A", 0, 0, valueOf2, "", str, "");
    }

    public static void h(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return;
        }
        e(qQAppInterface, str, "click#group_aio#pin_message_tail", null);
    }

    public static void i(QQAppInterface qQAppInterface, long j3, int i3, boolean z16) {
        String str;
        if (qQAppInterface == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, String.valueOf(i3));
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("action_result", str);
        e(qQAppInterface, String.valueOf(j3), "click#group_aio_fullscreen#pin_message_send", hashMap);
    }

    public static void j(QQAppInterface qQAppInterface, long j3, int i3, boolean z16) {
        String str;
        if (qQAppInterface == null) {
            return;
        }
        String valueOf = String.valueOf(j3);
        String valueOf2 = String.valueOf(u.l(qQAppInterface, String.valueOf(j3)));
        String valueOf3 = String.valueOf(i3);
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(null, "dc00898", "", valueOf, "0X800B727", "0X800B727", 0, 0, valueOf2, valueOf3, str, "");
    }

    public static void k(QQAppInterface qQAppInterface, long j3, int i3, boolean z16, int i16) {
        String str;
        if (qQAppInterface == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, String.valueOf(i3));
        if (i16 == 1) {
            e(qQAppInterface, String.valueOf(j3), "click#group_aio#message_more_pin", hashMap);
            return;
        }
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("action_result", str);
        e(qQAppInterface, String.valueOf(j3), "click#group_aio#message_more_pin_cancel", hashMap);
    }

    public static void l(QQAppInterface qQAppInterface, String str, boolean z16) {
        String str2;
        if (qQAppInterface == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (z16) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        hashMap.put("status_tag1", str2);
        e(qQAppInterface, str, "click#group_aio#pin_button", hashMap);
    }

    public static void m(QQAppInterface qQAppInterface, String str, boolean z16) {
        String str2;
        if (qQAppInterface == null) {
            return;
        }
        String valueOf = String.valueOf(u.l(qQAppInterface, str));
        if (z16) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        ReportController.o(null, "dc00898", "", str, "0X800B72C", "0X800B72C", 0, 0, valueOf, str2, "", "");
    }

    public static void n(QQAppInterface qQAppInterface, long j3, boolean z16) {
        String str;
        if (qQAppInterface == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put("status_tag1", str);
        e(qQAppInterface, String.valueOf(j3), "expose#group_aio#pin_button", hashMap);
    }

    public static void o(QQAppInterface qQAppInterface, long j3, boolean z16) {
        String str;
        if (qQAppInterface == null) {
            return;
        }
        String valueOf = String.valueOf(j3);
        String valueOf2 = String.valueOf(u.l(qQAppInterface, String.valueOf(j3)));
        if (z16) {
            str = "2";
        } else {
            str = "1";
        }
        ReportController.o(null, "dc00898", "", valueOf, "0X800B72B", "0X800B72B", 0, 0, valueOf2, str, "", "");
    }
}
