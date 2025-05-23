package com.tencent.mobileqq.stt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.config.business.av;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.shard.d;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static long f290719m;

    /* renamed from: a, reason: collision with root package name */
    private final int f290720a;

    /* renamed from: b, reason: collision with root package name */
    private MessageForPtt f290721b;

    /* renamed from: c, reason: collision with root package name */
    private int f290722c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Handler> f290723d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<AppRuntime> f290724e;

    /* renamed from: f, reason: collision with root package name */
    private int f290725f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.stt.shard.c f290726g;

    /* renamed from: h, reason: collision with root package name */
    private d f290727h;

    /* renamed from: i, reason: collision with root package name */
    private volatile Long f290728i;

    /* renamed from: j, reason: collision with root package name */
    private volatile Long f290729j;

    /* renamed from: k, reason: collision with root package name */
    private a f290730k;

    /* renamed from: l, reason: collision with root package name */
    private final int f290731l;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f290719m = 0L;
        }
    }

    public c(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f290728i = 0L;
        this.f290729j = 0L;
        this.f290720a = i3;
        if (i3 != 1) {
            i16 = 0;
        } else {
            i16 = 3;
        }
        this.f290731l = i16;
    }

    private void a(int i3) {
        WeakReference<Handler> weakReference = this.f290723d;
        if (weakReference != null && !weakReference.isEnqueued()) {
            Handler handler = this.f290723d.get();
            if (handler.hasMessages(i3, this)) {
                QLog.e("Q.stt_SttTask", 1, "checkAndRemoveMsgHandler, hasMessages is true msgKey = " + i3 + " | sessionID = " + f());
                handler.removeMessages(i3, this);
                QLog.e("Q.stt_SttTask", 1, "checkAndRemoveMsgHandler, removeMessages removeResult = " + (handler.hasMessages(i3, this) ^ true) + " | msgKey = " + i3 + " | sessionID = " + f());
                return;
            }
            QLog.e("Q.stt_SttTask", 1, "checkAndRemoveMsgHandler, hasMessages is false msgKey = " + i3 + " | sessionID = " + f());
            return;
        }
        QLog.e("Q.stt_SttTask", 1, "checkAndRemoveMsgHandler, handlerWeakReference is Null msgKey = " + i3 + " | sessionID = " + f());
    }

    public static c c(int i3, MessageForPtt messageForPtt, AppRuntime appRuntime, int i16, a aVar) {
        if (messageForPtt != null && appRuntime != null) {
            c cVar = new c(i3);
            cVar.f290721b = messageForPtt;
            cVar.f290724e = new WeakReference<>(appRuntime);
            cVar.f290725f = i16;
            cVar.f290730k = aVar;
            return cVar;
        }
        return null;
    }

    public static long i() {
        long j3;
        if (f290719m == 0) {
            av avVar = (av) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100828");
            if (avVar != null) {
                j3 = avVar.a();
            } else {
                j3 = 0;
            }
            if (j3 == 0) {
                j3 = 45000;
            }
            f290719m = j3;
        }
        return f290719m;
    }

    private long k() {
        return (new Random().nextInt() & 4294967295L) | ((((int) (h().uniseq >> 32)) & (-1)) << 32);
    }

    private Long l() {
        if (QLog.isColorLevel()) {
            QLog.e("Q.stt_SttTask", 2, "realRetryStt session = " + f() + ", retryNum = " + this.f290722c);
        }
        this.f290729j = 0L;
        d dVar = this.f290727h;
        if (dVar != null) {
            dVar.c();
        }
        com.tencent.mobileqq.stt.shard.c cVar = this.f290726g;
        if (cVar != null) {
            cVar.b();
        }
        this.f290721b.getSttResult().e(false);
        return p();
    }

    private void m(int i3) {
        if (this.f290729j.longValue() == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f290729j.longValue();
        this.f290729j = 0L;
        if (QLog.isColorLevel()) {
            QLog.d("Q.stt_SttTask", 2, "PttSttReport reportSttFristPackTimeCost cost = " + currentTimeMillis + "  | type = " + i3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("timeCost", currentTimeMillis + "");
        hashMap.put("sttType", i3 + "");
        hashMap.put("ntimeCost", currentTimeMillis + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_STT_FRIST_SHOW_TIME_COST, true, 0L, 0L, hashMap, null);
    }

    private void n(int i3) {
        o(i3, -1L);
    }

    private void o(int i3, long j3) {
        WeakReference<Handler> weakReference = this.f290723d;
        if (weakReference != null && !weakReference.isEnqueued()) {
            QLog.e("Q.stt_SttTask", 1, "sendMsgHandlerDelayed,  msgKey = " + i3 + " | sessionID = " + f() + " | delayMillis = " + j3);
            Handler handler = this.f290723d.get();
            long longValue = f().longValue();
            Message obtainMessage = handler.obtainMessage(i3, ((int) (longValue >> 32)) & (-1), (int) (longValue & (-1)), this);
            if (j3 > 0) {
                handler.sendMessageDelayed(obtainMessage, j3);
                return;
            } else {
                handler.sendMessage(obtainMessage);
                return;
            }
        }
        QLog.e("Q.stt_SttTask", 1, "sendMsgHandlerDelayed, handlerWeakReference is Null msgKey = " + i3 + " | sessionID = " + f());
    }

    public Long b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Long) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.stt_SttTask", 2, "checkTimeOutRetryStt session = " + f() + ", timeoutType = " + i3 + ", retryNum = " + this.f290722c);
        }
        int i16 = this.f290722c + 1;
        this.f290722c = i16;
        if (i16 > this.f290731l) {
            h().getSttResult().f(3, i3);
            return null;
        }
        return l();
    }

    public boolean d(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), bundle)).booleanValue();
        }
        this.f290721b.getSttResult().g();
        Long valueOf = Long.valueOf(bundle.getLong("k_time_out", 60000L));
        int i3 = bundle.getInt("k_result_code", 0);
        String string = bundle.getString("k_ptt_trans_txt", null);
        bundle.getInt("k_retry", 0);
        if (QLog.isColorLevel()) {
            QLog.d("Q.stt_SttTask", 2, "onReceive, session = " + f() + ", timeout = " + valueOf + ", retryNum = " + this.f290722c);
        }
        if (z16) {
            if (i3 == 200) {
                this.f290721b.getSttResult().f(2, i3);
                n(1001);
            } else if (string != null) {
                this.f290721b.getSttResult().e(false);
                this.f290721b.getSttResult().h(string, true);
                n(2);
                m(3);
            } else {
                o(1, valueOf.longValue());
            }
        } else {
            this.f290721b.getSttResult().f(2, i3);
            n(1001);
        }
        return z16;
    }

    public boolean e(SttResultPush$MsgBody sttResultPush$MsgBody) {
        int c16;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) sttResultPush$MsgBody)).booleanValue();
        }
        if (sttResultPush$MsgBody == null) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.stt_SttTask", 2, "doReceivePushData resp is null. session = " + f());
            }
            return false;
        }
        if (j() != 2 && j() != 1) {
            return true;
        }
        if (sttResultPush$MsgBody.msg_ptt_shard_resp.has()) {
            if (this.f290727h == null) {
                this.f290727h = new d(h().getSttResult());
            }
            c16 = this.f290727h.d(sttResultPush$MsgBody);
            i3 = 1;
        } else if (sttResultPush$MsgBody.msg_ptt_resp.has()) {
            if (this.f290726g == null) {
                this.f290726g = new com.tencent.mobileqq.stt.shard.c(h().getSttResult());
            }
            c16 = this.f290726g.c(sttResultPush$MsgBody);
            i3 = 2;
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("Q.stt_SttTask", 2, "doReceivePushData msg_ptt_resp and msg_ptt_shard_resp all are null. session = " + f());
            }
            return false;
        }
        if (c16 != 0 && c16 != -10001 && c16 != -10002) {
            n(1002);
            return false;
        }
        a(1);
        a(3);
        if (c16 == -10002) {
            i16 = 4;
        } else {
            i16 = 2;
        }
        if (j() == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.stt_SttTask", 2, "doReceivePushData stt receive success session = " + f());
            }
            n(i16);
            m(i3);
        } else {
            if (j() == 2 && (c16 == -10001 || c16 == -10002)) {
                n(i16);
                if (i3 == 1) {
                    m(1);
                }
            }
            if (this.f290721b.getSttResult().d()) {
                o(3, i());
            }
        }
        return true;
    }

    public Long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Long) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f290728i;
    }

    public a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f290730k;
    }

    public MessageForPtt h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MessageForPtt) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f290721b;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f290721b.getSttResult().b();
    }

    public synchronized Long p() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Long) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        WeakReference<AppRuntime> weakReference = this.f290724e;
        if (weakReference != null && !weakReference.isEnqueued()) {
            appRuntime = this.f290724e.get();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            this.f290721b.getSttResult().f(2, 2005);
            n(1001);
            return null;
        }
        this.f290721b.getSttResult().i();
        long k3 = k();
        this.f290728i = Long.valueOf(k3);
        int i3 = this.f290720a;
        if (i3 == 1) {
            b.h(appRuntime, this.f290721b, Long.valueOf(k3), this.f290725f, 1, false, SttManager.class);
        } else if (i3 == 2) {
            MessageForPtt messageForPtt = this.f290721b;
            b.e(appRuntime, messageForPtt, messageForPtt.md5, Long.valueOf(k3), this.f290725f, 1, SttManager.class);
        } else if (i3 == 3) {
            b.h(appRuntime, this.f290721b, Long.valueOf(k3), this.f290725f, 1, true, SttManager.class);
        } else {
            QLog.w("Q.stt_SttTask", 1, "unknown task type");
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.stt_SttTask", 2, "sendSttRequest, session = " + f() + ", version = 1, retryNum = " + this.f290722c);
        }
        this.f290729j = Long.valueOf(System.currentTimeMillis());
        return Long.valueOf(k3);
    }

    public void q(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) handler);
        } else {
            if (handler == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.stt_SttTask", 2, "setTimeoutHandler timeoutHandler is null");
                    return;
                }
                return;
            }
            this.f290723d = new WeakReference<>(handler);
        }
    }
}
