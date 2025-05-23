package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import tencent.im.nearfield_group.nearfield_group$BusiRespHead;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bx implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public bx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(nearfield_group$BusiRespHead nearfield_group_busiresphead) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) nearfield_group_busiresphead);
        }
    }

    public void b(nearfield_group$BusiRespHead nearfield_group_busiresphead, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) nearfield_group_busiresphead, (Object) str);
        }
    }

    public void c(nearfield_group$BusiRespHead nearfield_group_busiresphead, List<com.tencent.mobileqq.facetoface.c> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) nearfield_group_busiresphead, (Object) list);
        }
    }

    public void d(com.tencent.mobileqq.facetoface.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
        }
    }

    public void e(com.tencent.mobileqq.facetoface.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5 && z16 && obj != null) {
                            d((com.tencent.mobileqq.facetoface.f) ((Object[]) obj)[0]);
                            return;
                        }
                        return;
                    }
                    if (z16 && obj != null) {
                        e((com.tencent.mobileqq.facetoface.c) ((Object[]) obj)[0]);
                        return;
                    }
                    return;
                }
                if (z16 && obj != null) {
                    Object[] objArr = (Object[]) obj;
                    b((nearfield_group$BusiRespHead) objArr[0], (String) objArr[1]);
                    return;
                } else {
                    b(null, "");
                    return;
                }
            }
            if (z16 && obj != null) {
                a((nearfield_group$BusiRespHead) ((Object[]) obj)[0]);
                return;
            } else {
                a(null);
                return;
            }
        }
        if (z16 && obj != null) {
            Object[] objArr2 = (Object[]) obj;
            c((nearfield_group$BusiRespHead) objArr2[0], (List) objArr2[1]);
        } else {
            c(null, null);
        }
    }
}
