package com.tencent.mobileqq.wholepeople;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public static boolean C;

    /* renamed from: m, reason: collision with root package name */
    public static int f315336m;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f315337d;

    /* renamed from: e, reason: collision with root package name */
    WeakReferenceHandler f315338e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f315339f;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f315340h;

    /* renamed from: i, reason: collision with root package name */
    int f315341i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f315336m = ProfileContants.FILED_WHOLE_PEOPLE_VOTE_SWITCH;
            C = false;
        }
    }

    public b(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f315340h = false;
        this.f315341i = 0;
        if (qQAppInterface == null) {
            return;
        }
        this.f315337d = qQAppInterface;
        this.f315338e = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f315339f = qQAppInterface.getPreferences().getBoolean(qQAppInterface.getCurrentAccountUin() + "whole_people_vote_switch", false);
        if (QLog.isColorLevel()) {
            QLog.i("WholePeopleLebaEntryChecker", 2, "WholePeopleLebaEntryChecker init switch:" + this.f315339f);
        }
        if (C) {
            this.f315339f = true;
        }
    }

    public void a(QQAppInterface qQAppInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, Boolean.valueOf(z16));
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        this.f315339f = z16;
        if (C) {
            this.f315339f = true;
        }
        qQAppInterface.getPreferences().edit().putBoolean(qQAppInterface.getCurrentAccountUin() + "whole_people_vote_switch", z16).apply();
        if (QLog.isColorLevel()) {
            QLog.i("WholePeopleLebaEntryChecker", 2, String.format(Locale.getDefault(), "update show: %b", Boolean.valueOf(this.f315339f)));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 0) {
            ReportController.n(this.f315337d, "dc00898", "", "", "0X8008824", "0X8008824", 0, this.f315341i, 0, "", "", "", "");
            this.f315341i = 0;
        }
        return false;
    }
}
