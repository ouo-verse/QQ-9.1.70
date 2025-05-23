package com.tencent.mobileqq.troop.trooptodo;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e$InfoValue;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e$UserNode;

/* compiled from: P */
/* loaded from: classes19.dex */
public class l implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f301809d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f301810e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f301811f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65108);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        int i3 = 0 + 1;
        f301810e = 0;
        f301809d = i3 + 1;
        f301811f = i3;
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(int i3, boolean z16, Object obj) {
        int i16;
        int i17;
        if (i3 != f301810e) {
            return;
        }
        QLog.i("TroopTodoInfoObserver-TodoInfo", 2, "[onUpdateTodoInfoDetail] invoke, type = " + i3 + ", isSuccess = " + z16);
        oidb_0xf8e$InfoValue oidb_0xf8e_infovalue = null;
        int i18 = -1;
        if (z16 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length <= 3) {
                Object obj2 = objArr[2];
                if (obj2 instanceof Integer) {
                    i17 = ((Integer) obj2).intValue();
                } else {
                    i17 = 0;
                }
                Object obj3 = objArr[1];
                if (obj3 instanceof Integer) {
                    i18 = ((Integer) obj3).intValue();
                }
                Object obj4 = objArr[0];
                if (obj4 instanceof oidb_0xf8e$InfoValue) {
                    oidb_0xf8e_infovalue = (oidb_0xf8e$InfoValue) obj4;
                }
                a(0, oidb_0xf8e_infovalue, i18, i17);
                return;
            }
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr2 = (Object[]) obj;
            if (objArr2.length <= 2) {
                Object obj5 = objArr2[1];
                if (obj5 instanceof Integer) {
                    i16 = ((Integer) obj5).intValue();
                } else {
                    i16 = 0;
                }
                Object obj6 = objArr2[0];
                if (obj6 instanceof Integer) {
                    i18 = ((Integer) obj6).intValue();
                }
                a(i18, null, 0, i16);
            }
        }
    }

    private void d(int i3, boolean z16, Object obj) {
        int i16;
        int i17;
        if (i3 != f301811f) {
            return;
        }
        QLog.i("TroopTodoInfoObserver-TodoInfo", 2, "[onUpdateTodoInfoList] invoke, type = " + i3 + ", isSuccess = " + z16);
        int i18 = -1;
        long j3 = 0;
        if (z16 && (obj instanceof Object[])) {
            ArrayList arrayList = new ArrayList();
            Object[] objArr = (Object[]) obj;
            if (objArr.length <= 4) {
                Object obj2 = objArr[3];
                if (obj2 instanceof Long) {
                    j3 = ((Long) obj2).longValue();
                }
                long j16 = j3;
                Object obj3 = objArr[2];
                if (obj3 instanceof Integer) {
                    i17 = ((Integer) obj3).intValue();
                } else {
                    i17 = 0;
                }
                Object obj4 = objArr[1];
                if (obj4 instanceof Integer) {
                    i18 = ((Integer) obj4).intValue();
                }
                int i19 = i18;
                Object obj5 = objArr[0];
                if (obj5 instanceof List) {
                    arrayList.addAll((List) obj5);
                }
                b(0, arrayList, i19, i17, j16);
                return;
            }
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr2 = (Object[]) obj;
            if (objArr2.length <= 3) {
                Object obj6 = objArr2[2];
                if (obj6 instanceof Long) {
                    j3 = ((Long) obj6).longValue();
                }
                long j17 = j3;
                Object obj7 = objArr2[1];
                if (obj7 instanceof Integer) {
                    i16 = ((Integer) obj7).intValue();
                } else {
                    i16 = 0;
                }
                Object obj8 = objArr2[0];
                if (obj8 instanceof Integer) {
                    i18 = ((Integer) obj8).intValue();
                }
                b(i18, null, 0, i16, j17);
            }
        }
    }

    public void a(int i3, oidb_0xf8e$InfoValue oidb_0xf8e_infovalue, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), oidb_0xf8e_infovalue, Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public void b(int i3, List<oidb_0xf8e$UserNode> list, int i16, int i17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), list, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            c(i3, z16, obj);
            d(i3, z16, obj);
        }
    }
}
