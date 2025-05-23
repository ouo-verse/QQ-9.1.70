package com.tencent.qqnt.aio.menu.processor;

import android.os.Bundle;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.utils.CustomWithRawUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class k implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final b f351465a;

    public k(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f351465a = bVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(com.tencent.qqnt.aio.menu.ui.c cVar, com.tencent.qqnt.aio.menu.ui.d dVar) {
        long j3;
        p.r rVar;
        if (this.f351465a == null || dVar == null) {
            return false;
        }
        if (dVar.d() != null) {
            AIOMsgItem d16 = dVar.d();
            if (d16.getMsgRecord() != null) {
                j3 = d16.getMsgRecord().getMsgTime();
                rVar = new p.r(dVar.d(), c(j3));
                this.f351465a.p0(rVar);
                if (rVar.b()) {
                    return false;
                }
                cVar.a(dVar);
                return true;
            }
        }
        j3 = 0;
        rVar = new p.r(dVar.d(), c(j3));
        this.f351465a.p0(rVar);
        if (rVar.b()) {
        }
    }

    private boolean c(long j3) {
        boolean z16;
        boolean o16 = MenuUtils.f351230a.o(this.f351465a);
        if (!CustomWithRawUtil.h(j3) && !o16) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("MenuRevokeProcessor", 1, "isOverTimeTwoMinutes: " + z16 + " isTroopOwnerOrAdmin: " + o16);
        return z16;
    }

    @Override // com.tencent.qqnt.aio.menu.processor.a
    public void a(com.tencent.qqnt.aio.menu.ui.c cVar, com.tencent.qqnt.aio.menu.ui.d dVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, cVar, dVar, bundle);
        } else {
            if (q.f351469a.a(bundle).booleanValue()) {
                return;
            }
            boolean b16 = b(cVar, dVar);
            if (bundle != null) {
                bundle.putBoolean("isInvokeMenuShow", b16);
            }
        }
    }
}
