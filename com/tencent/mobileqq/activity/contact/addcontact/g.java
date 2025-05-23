package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final String f181135h;

    /* renamed from: i, reason: collision with root package name */
    private static int[] f181136i;

    /* renamed from: j, reason: collision with root package name */
    public static int[] f181137j;

    /* renamed from: k, reason: collision with root package name */
    private static int[] f181138k;

    /* renamed from: l, reason: collision with root package name */
    private static int[] f181139l;

    /* renamed from: m, reason: collision with root package name */
    private static int[] f181140m;

    /* renamed from: n, reason: collision with root package name */
    private static int[] f181141n;

    /* renamed from: a, reason: collision with root package name */
    private b f181142a;

    /* renamed from: b, reason: collision with root package name */
    private long f181143b;

    /* renamed from: c, reason: collision with root package name */
    private String f181144c;

    /* renamed from: d, reason: collision with root package name */
    private int f181145d;

    /* renamed from: e, reason: collision with root package name */
    private int f181146e;

    /* renamed from: f, reason: collision with root package name */
    String f181147f;

    /* renamed from: g, reason: collision with root package name */
    ar f181148g;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        private void a(ArrayList<un2.a> arrayList) {
            int i3 = 0;
            if (arrayList != null && g.this.f181146e != 80000005 && arrayList.size() == 1) {
                g.this.f181145d = arrayList.get(0).f439269b;
            }
            if (arrayList != null && arrayList.size() >= 1) {
                Iterator<un2.a> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    un2.a next = it.next();
                    if (next.f439268a == 80000003) {
                        while (i3 < next.f439272e.size()) {
                            PBUInt32Field pBUInt32Field = next.f439272e.get(i3).number;
                            i3++;
                            pBUInt32Field.set(i3);
                        }
                        i3 = 1;
                    }
                }
                if (i3 != 0) {
                    if (g.this.f181146e != 80000005) {
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(g.this.i(), "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D96", "0X8005D96", 0, 0, g.this.f181145d + "", "", g.this.f181147f, "", false);
                        return;
                    }
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(g.this.i(), "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D94", "0X8005D94", 0, 0, "", "", g.this.f181147f, "", false);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSearchFriendResult(boolean z16, int i3, Object obj, int i16, String str, boolean z17, long j3, int i17, List<x> list) {
            int i18 = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z18 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), obj, Integer.valueOf(i16), str, Boolean.valueOf(z17), Long.valueOf(j3), Integer.valueOf(i17), list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(g.f181135h, 2, "onSearchFriendResult  searchType = " + i3 + " isSuccess = " + z16 + " subId = " + i17);
            }
            if (i18 == 83) {
                g.this.k();
            } else {
                if (i18 == 84) {
                    if (j3 != g.this.f181143b) {
                        return;
                    }
                    g.this.k();
                    if (!z17) {
                        if (g.this.f181142a != null) {
                            g.this.f181142a.a(g.this.f181146e, z16, obj, i16, str, i17, list);
                            return;
                        }
                        return;
                    } else if (z16) {
                        try {
                            a((ArrayList) obj);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(g.f181135h, 2, "", e16);
                            }
                            if (g.this.f181142a != null) {
                                g.this.f181142a.a(g.this.f181146e, z16, obj, i16, str, i17, list);
                                return;
                            }
                            return;
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d(g.f181135h, 2, "search failed error msg = " + str);
                    }
                } else {
                    g.this.k();
                }
                z18 = false;
            }
            if (g.this.f181142a != null) {
                b bVar = g.this.f181142a;
                if (!z18) {
                    i18 = g.this.f181146e;
                }
                bVar.a(i18, z16, obj, i16, str, i17, list);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void a(int i3, boolean z16, Object obj, int i16, String str, int i17, List<x> list);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f181135h = g.class.getName();
        f181136i = new int[]{80000000};
        f181137j = new int[]{80000001};
        f181138k = new int[]{80000002};
        f181139l = new int[]{80000003};
        f181140m = new int[]{80000000, 80000001, 80000002, 80000004, 80000003};
        f181141n = new int[]{80000002, 80000003};
    }

    public g(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        this.f181143b = 0L;
        this.f181147f = null;
        this.f181148g = new a();
        this.f181144c = PhoneCodeUtils.f(appInterface.getApplication());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppInterface i() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    final void g() {
        if (i() != null) {
            i().addObserver(this.f181148g, true);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f181142a = null;
        this.f181145d = 0;
        k();
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f181145d;
    }

    final void k() {
        if (i() != null) {
            i().removeObserver(this.f181148g);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f181145d = 0;
            this.f181143b = SystemClock.uptimeMillis();
        }
    }

    public void m(String str, int[] iArr, double d16, double d17, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, iArr, Double.valueOf(d16), Double.valueOf(d17), Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            ((FriendListHandler) i().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).searchFriend(str, this.f181144c, 3, this.f181145d, iArr, d16, d17, z16, i3, this.f181143b);
        }
    }

    public boolean n(String str, int i3, double d16, double d17, int i16) {
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Double.valueOf(d16), Double.valueOf(d17), Integer.valueOf(i16))).booleanValue();
        }
        g();
        this.f181147f = str;
        this.f181146e = i3;
        switch (i3) {
            case 80000000:
                iArr = f181136i;
                break;
            case 80000001:
                iArr = f181137j;
                break;
            case 80000002:
                iArr = f181138k;
                break;
            case 80000003:
                iArr = f181139l;
                break;
            case 80000004:
            default:
                iArr = null;
                break;
            case 80000005:
                iArr = f181140m;
                break;
            case 80000006:
                iArr = f181141n;
                break;
        }
        int[] iArr2 = iArr;
        if (iArr2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f181135h, 2, "warning! wrong request type = " + i3);
            }
            return false;
        }
        ((FriendListHandler) i().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).searchFriend(str, this.f181144c, 3, this.f181145d, iArr2, d16, d17, true, i16, this.f181143b);
        if (QLog.isColorLevel()) {
            QLog.d(f181135h, 2, "searchFriend nextPage = " + this.f181145d);
            return true;
        }
        return true;
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f181145d = i3;
        }
    }

    public void p(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f181142a = bVar;
        }
    }
}
