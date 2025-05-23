package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopapps.event.TroopAppsListUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xea3.oidb_0xea3$BackMsg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3));
        }
    }

    protected void b(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    protected void c(long j3, boolean z16, List<oidb_0xea3$BackMsg> list, List<Long> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Boolean.valueOf(z16), list, list2);
        }
    }

    protected void d(TroopInfo troopInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopInfo, Boolean.valueOf(z16));
        }
    }

    protected void e(long j3, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void f(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        List<oidb_0xea3$BackMsg> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopShortcutBarObserver", 2, "onUpdate type:" + i3 + ", isSuccess:" + z16 + ", data:" + obj);
        }
        switch (i3) {
            case 1:
                b(((Long) ((Object[]) obj)[0]).longValue(), z16);
                return;
            case 2:
                Object[] objArr = (Object[]) obj;
                e(((Long) objArr[0]).longValue(), z16, ((Integer) objArr[1]).intValue());
                return;
            case 3:
                f(((Long) ((Object[]) obj)[0]).longValue());
                SimpleEventBus.getInstance().dispatchEvent(new TroopAppsListUpdateEvent());
                return;
            case 4:
                Object[] objArr2 = (Object[]) obj;
                Object obj2 = objArr2[1];
                List<Long> list2 = null;
                if (obj2 != null) {
                    list = (List) obj2;
                } else {
                    list = null;
                }
                Object obj3 = objArr2[2];
                if (obj3 != null) {
                    list2 = (List) obj3;
                }
                c(((Long) objArr2[0]).longValue(), z16, list, list2);
                return;
            case 5:
                d((TroopInfo) ((Object[]) obj)[0], z16);
                break;
            case 6:
                break;
            default:
                return;
        }
        Object[] objArr3 = (Object[]) obj;
        if (objArr3.length > 1) {
            Object obj4 = objArr3[0];
            if (obj4 instanceof String) {
                Object obj5 = objArr3[1];
                if (obj5 instanceof Long) {
                    a((String) obj4, ((Long) obj5).longValue());
                }
            }
        }
    }
}
