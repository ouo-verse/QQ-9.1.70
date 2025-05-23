package com.tencent.mobileqq.app.notification.processor.business;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cn;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends com.tencent.mobileqq.app.notification.struct.a {
    static IPatchRedirector $redirector_;

    protected g(QQAppInterface qQAppInterface, com.tencent.mobileqq.app.notification.struct.e eVar) {
        super(qQAppInterface, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) eVar);
        }
    }

    @Override // com.tencent.mobileqq.app.notification.struct.d
    public com.tencent.mobileqq.app.notification.struct.e a(Message message) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.app.notification.struct.e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        Bitmap d16 = cn.d(this.f196404a.getApp().getResources().getDrawable(R.drawable.icon_recent_public_account));
        this.f196405b.k(d16);
        String b16 = b();
        this.f196405b.j(b16);
        PAMessage b17 = ap.b(message);
        if (b17 != null && !b17.items.isEmpty()) {
            b16 = b17.items.get(0).title;
            if (b17.items.get(0).cover == null && b17.items.get(0).digestList != null) {
                this.f196405b.i(b16);
                b16 = b17.items.get(0).digestList.get(0);
                this.f196405b.j(b16);
            } else {
                this.f196405b.j(b16);
            }
        }
        this.f196405b.l(this.f196405b.f() + b16);
        g(message, this.f196405b);
        String str2 = message.extStr;
        if (str2 == null) {
            return null;
        }
        if ((message.extLong & 1) == 0 && !str2.contains("lockDisplay")) {
            return null;
        }
        if ((message.extLong & 1) == 1 && !message.getExtInfoFromExtStr("lockDisplay").equals("true")) {
            return null;
        }
        Intent b18 = this.f196405b.b();
        String c16 = this.f196405b.c();
        this.f196405b.a();
        b18.putExtra(AppConstants.Key.NEED_REPORT, true);
        b18.putExtra(AppConstants.Key.INCOMING_MSGUID, message.msgUid);
        b18.putExtra(AppConstants.Key.INCOMING_SHMSGSEQ, message.shmsgseq);
        String stringExtra = b18.getStringExtra("uin");
        if (!TextUtils.isEmpty(c16) && !TextUtils.isEmpty(stringExtra)) {
            str = c16.replace(stringExtra, "");
        } else {
            str = c16;
        }
        if (!TextUtils.isEmpty(str)) {
            b16 = str + ProgressTracer.SEPARATOR + b16;
        }
        if (AppConstants.REMINDER_UIN.equals(stringExtra)) {
            d16 = this.f196404a.getFaceBitmap(message.frienduin, true);
        } else {
            c16 = this.f196404a.getApp().getString(R.string.f170118gy);
        }
        this.f196405b.h(b18);
        this.f196405b.i(c16);
        this.f196405b.j(b16);
        this.f196405b.l(b16);
        this.f196405b.k(d16);
        return this.f196405b;
    }

    @Override // com.tencent.mobileqq.app.notification.struct.c
    public int e(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).intValue();
        }
        return 267;
    }
}
