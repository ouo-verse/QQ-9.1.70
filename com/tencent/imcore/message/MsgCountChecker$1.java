package com.tencent.imcore.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
class MsgCountChecker$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f116419d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f116420e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ QQAppInterface f116421f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f116422h;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        w wVar = new w();
        String tableName = MessageRecord.getTableName(this.f116419d, this.f116420e);
        QQAppInterface qQAppInterface = this.f116421f;
        int i3 = this.f116420e;
        int i16 = this.f116422h;
        wVar.c(qQAppInterface, tableName, i3, i16, i16);
        QLog.d("MsgCountChecker", 2, "moveToToSlowForDebug uin=" + this.f116419d + ",type=" + this.f116420e + ",maxCount=" + this.f116422h);
    }
}
