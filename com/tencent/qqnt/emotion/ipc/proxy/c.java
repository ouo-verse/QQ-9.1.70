package com.tencent.qqnt.emotion.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;

/* compiled from: P */
/* loaded from: classes24.dex */
public class c extends a<IEmoticonManagerService> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    protected com.tencent.qqnt.emotion.db.a f356289c;

    public c(BaseQQAppInterface baseQQAppInterface, com.tencent.qqnt.emotion.db.a aVar) {
        super(baseQQAppInterface, IEmoticonManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) aVar);
        } else {
            this.f356289c = aVar;
        }
    }

    public EmoticonPackage a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        T t16 = this.f356288b;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).syncFindEmoticonPackageById(str);
        }
        return b(str, 0);
    }

    public EmoticonPackage b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonManagerServiceProxy", 2, "syncFindEmoticonPackageById epId = " + str + ", type = " + i3);
        }
        com.tencent.qqnt.emotion.db.a aVar = this.f356289c;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonManagerServiceProxy", 4, "em is null.");
            }
            return null;
        }
        EmoticonPackage emoticonPackage = (EmoticonPackage) aVar.d(EmoticonPackage.class, str);
        if (emoticonPackage != null) {
            if (i3 == -1) {
                return emoticonPackage;
            }
            if (i3 == 0) {
                if (!emoticonPackage.aio) {
                    return null;
                }
                return emoticonPackage;
            }
            if (i3 == 1) {
                if (!emoticonPackage.kandian) {
                    return null;
                }
                return emoticonPackage;
            }
        }
        return emoticonPackage;
    }
}
