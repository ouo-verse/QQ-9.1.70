package com.tencent.qimei.ah;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.aa.f;
import com.tencent.qimei.ab.d;
import com.tencent.qimei.ad.c;
import com.tencent.qimei.as.a;
import com.tencent.qimei.foundation.net.protocol.CMD;
import com.tencent.qimei.report.beat.BeatType;
import com.tencent.qimei.uin.U;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f342985a = "a";

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f342986b;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.ah.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class RunnableC9306a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f342987a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BeatType f342988b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f342989c;

        public RunnableC9306a(String str, BeatType beatType, String str2) {
            this.f342987a = str;
            this.f342988b = beatType;
            this.f342989c = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, beatType, str2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!com.tencent.qimei.u.a.f()) {
                return;
            }
            String str3 = this.f342987a;
            BeatType beatType = this.f342988b;
            String str4 = this.f342989c;
            JSONObject jSONObject = new JSONObject();
            String str5 = "";
            if (U.e()) {
                str = "";
            } else {
                str = com.tencent.qimei.ae.a.a(str3).c();
            }
            try {
                jSONObject.put("1", beatType.b());
                jSONObject.put("2", String.valueOf(System.currentTimeMillis()));
                jSONObject.put("3", str);
                jSONObject.put("4", str4);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("av", com.tencent.qimei.u.a.e());
                    jSONObject2.put("ch", com.tencent.qimei.u.a.a());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                jSONObject.put("5", jSONObject2.toString());
                str2 = jSONObject.toString();
            } catch (JSONException e17) {
                c.a(e17);
                str2 = null;
            }
            if (str2 != null) {
                str5 = str2;
            }
            String str6 = this.f342987a;
            CMD cmd = CMD.BEAT;
            String a16 = U.a(str6, cmd.b(), str5, cmd.a());
            if (!new com.tencent.qimei.x.c(a16).c()) {
                String str7 = this.f342987a;
                Iterator it = ((PriorityQueue) d.a(3, 10)).iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    it.remove();
                    try {
                        TimeUnit.SECONDS.sleep(num.intValue());
                    } catch (Exception unused) {
                    }
                    CMD cmd2 = CMD.BEAT;
                    String a17 = U.a(str7, cmd2.b(), str5, cmd2.a());
                    c.b(a.f342985a, "%s Beat data has been retry over,response = %s", str7, a17);
                    if (new com.tencent.qimei.x.c(a17).c()) {
                        break;
                    }
                }
            }
            c.b(a.f342985a, "%s Beat data has been reported over, type:%s response = %s", this.f342987a, Integer.valueOf(this.f342988b.b()), a16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19473);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f342986b = new ConcurrentHashMap<>();
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(f.b(str).d("is_first"))) {
            f342986b.put(str, Boolean.TRUE);
            return true;
        }
        f342986b.put(str, Boolean.FALSE);
        return false;
    }

    public static boolean a(String str, BeatType beatType) {
        BeatType beatType2;
        int intValue = a.b.G.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(str).f343094b.f343146r)).intValue();
        int ordinal = beatType.ordinal();
        if (ordinal == 1) {
            beatType2 = BeatType.INIT;
        } else if (ordinal == 2) {
            beatType2 = BeatType.REGISTER;
        } else if (ordinal == 3) {
            beatType2 = BeatType.AUDIT;
        } else {
            if (ordinal != 4) {
                return false;
            }
            beatType2 = BeatType.NET_CHANGE;
        }
        boolean a16 = com.tencent.qimei.f.a.a(beatType2.a(), intValue);
        beatType2.a();
        return a16;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, BeatType beatType, String str2) {
        boolean a16;
        com.tencent.qimei.u.c cVar;
        boolean z16;
        if (beatType == BeatType.NET_CHANGE) {
            synchronized (com.tencent.qimei.u.c.class) {
                cVar = com.tencent.qimei.u.c.f343390p;
            }
            synchronized (cVar) {
                z16 = cVar.f343397g;
            }
            if (!z16) {
                a16 = false;
                if (a16) {
                    return;
                }
                com.tencent.qimei.t.a.a().a(new RunnableC9306a(str, beatType, str2));
                return;
            }
        }
        Boolean bool = f342986b.get(str);
        if (bool == null) {
            bool = Boolean.valueOf(a(str));
        }
        a16 = Boolean.TRUE.equals(bool) ? true : a(str, beatType);
        if (a16) {
        }
    }
}
