package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.location.RoomOperate$RspRoomQuery;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125$MsgBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(com.tencent.mobileqq.location.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    protected void b(com.tencent.mobileqq.location.bean.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        }
    }

    protected void c(com.tencent.mobileqq.location.bean.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
        }
    }

    protected void d(com.tencent.mobileqq.location.bean.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
        }
    }

    protected void e(com.tencent.mobileqq.location.bean.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        }
    }

    protected void f(com.tencent.mobileqq.location.bean.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fVar);
        }
    }

    protected void g(com.tencent.mobileqq.location.bean.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationObserverBase", 2, "onUpdate: invoked. ", " type: ", Integer.valueOf(i3), " isSuccess: ", Boolean.valueOf(z16), " data: ", obj);
        }
        switch (i3) {
            case 1:
                Object[] objArr = (Object[]) obj;
                if (objArr != null && objArr.length != 0) {
                    com.tencent.mobileqq.location.bean.c cVar = new com.tencent.mobileqq.location.bean.c();
                    cVar.h(z16);
                    cVar.f(((Integer) objArr[0]).intValue());
                    cVar.g(((Integer) objArr[1]).intValue());
                    cVar.j(((Integer) objArr[2]).intValue());
                    cVar.i((String) objArr[3]);
                    c(cVar);
                    return;
                }
                return;
            case 2:
                if (!z16) {
                    return;
                }
                Object[] objArr2 = (Object[]) obj;
                com.tencent.mobileqq.location.bean.d dVar = new com.tencent.mobileqq.location.bean.d();
                dVar.d((RoomOperate$RspRoomQuery) objArr2[0]);
                dVar.e(((Integer) objArr2[1]).intValue());
                dVar.f((String) objArr2[2]);
                d(dVar);
                return;
            case 3:
                if (!z16) {
                    return;
                }
                com.tencent.mobileqq.location.bean.f fVar = new com.tencent.mobileqq.location.bean.f();
                fVar.b((com.tencent.mobileqq.location.data.b) ((Object[]) obj)[0]);
                f(fVar);
                return;
            case 4:
                if (!z16) {
                    return;
                }
                com.tencent.mobileqq.location.bean.a aVar = new com.tencent.mobileqq.location.bean.a();
                aVar.b((submsgtype0x125$MsgBody) ((Object[]) obj)[0]);
                a(aVar);
                return;
            case 5:
                Object[] objArr3 = (Object[]) obj;
                com.tencent.mobileqq.location.bean.e eVar = new com.tencent.mobileqq.location.bean.e();
                eVar.c(((Integer) objArr3[0]).intValue());
                eVar.d(String.valueOf(objArr3[1]));
                e(eVar);
                return;
            case 6:
                com.tencent.mobileqq.location.bean.b bVar = new com.tencent.mobileqq.location.bean.b();
                Object[] objArr4 = (Object[]) obj;
                bVar.e(((Integer) objArr4[0]).intValue());
                bVar.f(String.valueOf(objArr4[1]));
                bVar.d(((Integer) objArr4[2]).intValue());
                b(bVar);
                return;
            case 7:
                Object[] objArr5 = (Object[]) obj;
                if (objArr5 != null && objArr5.length != 0) {
                    com.tencent.mobileqq.location.bean.g gVar = new com.tencent.mobileqq.location.bean.g();
                    gVar.i(z16);
                    gVar.g(((Integer) objArr5[0]).intValue());
                    gVar.h(((Integer) objArr5[1]).intValue());
                    gVar.k(((Integer) objArr5[2]).intValue());
                    gVar.j((String) objArr5[3]);
                    gVar.l((LocationRoom.Venue) objArr5[4]);
                    g(gVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
