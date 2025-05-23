package com.tencent.qimei.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.am.e;
import com.tencent.qimei.sdk.S.DataFormatter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final a f343365a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f343366b;

    /* renamed from: c, reason: collision with root package name */
    public final String f343367c;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b extends AsyncTask<String, Integer, Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final a f343368a;

        /* renamed from: b, reason: collision with root package name */
        public final String f343369b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f343370c;

        public b(BroadcastReceiver.PendingResult pendingResult, a aVar, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, pendingResult, aVar, str, bundle);
                return;
            }
            this.f343368a = aVar;
            this.f343369b = str;
            this.f343370c = bundle;
        }

        /* JADX WARN: Type inference failed for: r15v16, types: [java.lang.Boolean, java.lang.Object] */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String[] strArr) {
            String str;
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            }
            Bundle bundle = this.f343370c;
            if (bundle != null) {
                a aVar = this.f343368a;
                String str2 = this.f343369b;
                e eVar = (e) aVar;
                synchronized (eVar) {
                    String string = bundle.getString(com.heytap.mcssdk.a.a.f36102l);
                    String string2 = bundle.getString("source");
                    String string3 = bundle.getString("spread_data");
                    String str3 = e.f343072f;
                    DataFormatter dataFormatter = new DataFormatter();
                    if (!TextUtils.isEmpty(string3)) {
                        try {
                            str = com.tencent.qimei.f.a.a(string3, str3);
                        } catch (Exception e16) {
                            com.tencent.qimei.ad.c.a(e16);
                            str = null;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                dataFormatter = (DataFormatter) new Gson().fromJson(str, DataFormatter.class);
                            } catch (Throwable th5) {
                                com.tencent.qimei.ad.c.a(th5);
                                dataFormatter = null;
                            }
                            if (dataFormatter == null) {
                                dataFormatter = new DataFormatter();
                            }
                        }
                    }
                    boolean a16 = eVar.a(dataFormatter.a(), string, string2);
                    if (eVar.f343077e.a().size() > dataFormatter.a().size()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    Object[] objArr = new Object[6];
                    objArr[0] = eVar.f343073a;
                    objArr[1] = eVar.f343074b;
                    objArr[2] = string;
                    objArr[3] = string2;
                    objArr[4] = dataFormatter;
                    if (!a16 && !z16) {
                        z17 = false;
                        objArr[5] = Boolean.valueOf(z17);
                        com.tencent.qimei.ad.c.b("SpreadQM", "%s%s received broadcast from %s%s|data = %s|,needReply:%b ", objArr);
                        if (TextUtils.isEmpty(str2) && (a16 || z16)) {
                            com.tencent.qimei.f.a.a(com.tencent.qimei.s.a.f343362b, string2, eVar.a());
                            com.tencent.qimei.ad.c.b("SpreadQM", "%s%s reply broadcast to %s", eVar.f343073a, eVar.f343074b, string2);
                        }
                    }
                    z17 = true;
                    objArr[5] = Boolean.valueOf(z17);
                    com.tencent.qimei.ad.c.b("SpreadQM", "%s%s received broadcast from %s%s|data = %s|,needReply:%b ", objArr);
                    if (TextUtils.isEmpty(str2)) {
                        com.tencent.qimei.f.a.a(com.tencent.qimei.s.a.f343362b, string2, eVar.a());
                        com.tencent.qimei.ad.c.b("SpreadQM", "%s%s reply broadcast to %s", eVar.f343073a, eVar.f343074b, string2);
                    }
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            } else {
                super.onPostExecute(bool);
            }
        }
    }

    public d(a aVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) str);
            return;
        }
        this.f343365a = aVar;
        this.f343366b = com.tencent.qimei.ap.d.c().e();
        this.f343367c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent.getAction() != null && com.tencent.qimei.s.a.f343362b.equals(intent.getAction()) && intent.getExtras() != null) {
            String string = intent.getExtras().getString(com.heytap.mcssdk.a.a.f36102l);
            String string2 = intent.getExtras().getString("source");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                z16 = !this.f343367c.equals(string + string2);
                if (z16) {
                    return;
                }
                new b(goAsync(), this.f343365a, intent.getPackage(), intent.getExtras()).execute(new String[0]);
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
