package com.tencent.mobileqq.app.automator.step;

import com.tencent.imcore.message.w;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TimerCheckMsgCount extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;
    public static String C;
    public static String D;

    /* renamed from: i, reason: collision with root package name */
    public static String f195369i;

    /* renamed from: m, reason: collision with root package name */
    public static String f195370m;

    /* renamed from: d, reason: collision with root package name */
    private long f195371d;

    /* renamed from: e, reason: collision with root package name */
    private long f195372e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Runnable f195373f;

    /* renamed from: h, reason: collision with root package name */
    private final w f195374h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70137);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f195369i = "com.ss.android.article.news";
        f195370m = "com.ss.android.article.lite";
        C = "com.tencent.reading";
        D = "com.tencent.readingplus";
    }

    public TimerCheckMsgCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f195371d = 0L;
        this.f195372e = 0L;
        this.f195374h = new w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (this.f195373f != null) {
            QLog.i("IAutomator", 1, "TimerCheckMsgCount doStep: last task was running");
            return 7;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TimerCheckMsgCount.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TimerCheckMsgCount.this.f195374h.a(((Automator) TimerCheckMsgCount.this.mAutomator).E);
                ((Automator) TimerCheckMsgCount.this.mAutomator).E.getConversationFacade().u();
                TimerCheckMsgCount.this.f195373f = null;
            }
        };
        this.f195373f = runnable;
        ThreadManagerV2.executeOnNetWorkThread(runnable);
        return 7;
    }
}
