package com.tencent.could.huiyansdk.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, Integer> f100189a;

    /* renamed from: b, reason: collision with root package name */
    public Object f100190b;

    /* renamed from: c, reason: collision with root package name */
    public String f100191c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.could.huiyansdk.callback.e f100192d;

    /* renamed from: e, reason: collision with root package name */
    public HandlerThread f100193e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Handler f100194f;

    /* renamed from: g, reason: collision with root package name */
    public SimpleDateFormat f100195g;

    /* renamed from: h, reason: collision with root package name */
    public Date f100196h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final k f100197a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15557);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100197a = new k();
            }
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100189a = new HashMap();
        this.f100191c = "";
        this.f100190b = new Object();
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (this.f100192d == null || this.f100194f == null) {
                return;
            }
            Message obtainMessage = this.f100194f.obtainMessage();
            obtainMessage.what = 2;
            this.f100194f.sendMessage(obtainMessage);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.f100190b) {
            Log.e("LoggerManager", "release");
            this.f100191c = "";
            this.f100192d = null;
            this.f100195g = null;
            this.f100196h = null;
            a.C1019a.f100038a.f100037f = false;
            Map<String, Integer> map = this.f100189a;
            if (map != null) {
                map.clear();
            }
            if (this.f100194f == null) {
                return;
            }
            this.f100194f.removeCallbacksAndMessages(null);
            this.f100194f = null;
            HandlerThread handlerThread = this.f100193e;
            if (handlerThread != null && handlerThread.isAlive()) {
                this.f100193e.quitSafely();
            }
        }
    }

    public final void a(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (i3 == 1) {
            if (l.a.f100309a.f100307a) {
                AiLog.debug(str, str2);
            }
        } else if (i3 == 2) {
            if (l.a.f100309a.f100307a) {
                AiLog.error(str, str2);
            }
        } else if (l.a.f100309a.f100307a) {
            AiLog.debug(str, str2);
        }
        if (this.f100192d == null || this.f100194f == null) {
            return;
        }
        Message obtainMessage = this.f100194f.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str2;
        this.f100194f.sendMessage(obtainMessage);
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (this.f100192d == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.could.huiyansdk.callback.e eVar = this.f100192d;
        String str2 = this.f100191c;
        StringBuilder sb5 = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f100195g == null) {
            this.f100195g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
        if (this.f100196h == null) {
            this.f100196h = new Date();
        }
        this.f100196h.setTime(currentTimeMillis);
        sb5.append(this.f100195g.format(this.f100196h));
        sb5.append(APLogFileUtil.SEPARATOR_LOG);
        sb5.append(this.f100191c);
        sb5.append(APLogFileUtil.SEPARATOR_LOG);
        sb5.append(str);
        eVar.a(str2, sb5.toString());
    }
}
