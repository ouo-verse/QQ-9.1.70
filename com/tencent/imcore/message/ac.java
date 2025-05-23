package com.tencent.imcore.message;

import android.util.Pair;
import com.tencent.imcore.message.f;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ac implements f.a {
    static IPatchRedirector $redirector_;

    public ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void A(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), list, list2, appRuntime);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void a(y yVar, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) yVar, (Object) appRuntime);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void b(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public List<MessageRecord> c(String str, String[] strArr, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, this, str, strArr, fVar);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public void d(String str, int i3, String str2, List<MessageRecord> list, long j3, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Integer.valueOf(i3), str2, list, Long.valueOf(j3), yVar);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void e(String str, int i3, boolean z16, y yVar, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), yVar, appRuntime);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void f(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), list);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public List<MessageRecord> g(String str, int i3, long j3, int i16, String str2, String[] strArr, y yVar, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str2, strArr, yVar, appRuntime);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public EntityManager h(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EntityManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public SQLiteDatabase i(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public void j(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void k(String str, MessageRecord messageRecord, List<MessageRecord> list, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, str, messageRecord, list, fVar);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public boolean l(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.f.a
    public void m(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), list);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public Object n(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public boolean o(String str, int i3, String str2, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), str2, yVar)).booleanValue();
        }
        return !yVar.l1().containsKey(str2);
    }

    @Override // com.tencent.imcore.message.f.a
    public boolean p(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) appRuntime, (Object) messageRecord)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.f.a
    public void q(AppRuntime appRuntime, EntityManager entityManager, ah ahVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, appRuntime, entityManager, ahVar);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public SQLiteDatabase r(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appRuntime);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public void s(String str, int i3, long j3, long j16, MessageRecord messageRecord, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), messageRecord, appRuntime);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void t(List<MessageRecord> list, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, list, messageRecord, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public int u(String str, int i3, long j3, int i16, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), appRuntime)).intValue();
        }
        return i16;
    }

    @Override // com.tencent.imcore.message.f.a
    public void v(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) messageRecord);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void w(List<MessageRecord> list, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) list, (Object) yVar);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public Pair<Long, Long> x(String str, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) appRuntime);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public void y(String str, int i3, long j3, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Long.valueOf(j3), appRuntime);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void z(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), list, list2, appRuntime);
        }
    }
}
