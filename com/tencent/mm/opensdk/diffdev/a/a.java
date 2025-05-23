package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements IDiffDevOAuth {

    /* renamed from: c, reason: collision with root package name */
    private b f151772c;

    /* renamed from: a, reason: collision with root package name */
    private Handler f151770a = null;

    /* renamed from: b, reason: collision with root package name */
    private List<OAuthListener> f151771b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private OAuthListener f151773d = new C7049a();

    /* compiled from: P */
    /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C7049a implements OAuthListener {

        /* compiled from: P */
        /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class RunnableC7050a implements Runnable {
            RunnableC7050a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a.this.f151771b);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((OAuthListener) it.next()).onQrcodeScanned();
                }
            }
        }

        C7049a() {
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
            Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
            a.this.f151772c = null;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.this.f151771b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
            }
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthGotQrcode(String str, byte[] bArr) {
            Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.this.f151771b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
            }
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onQrcodeScanned() {
            Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            if (a.this.f151770a != null) {
                a.this.f151770a.post(new RunnableC7050a());
            }
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void addListener(OAuthListener oAuthListener) {
        if (!this.f151771b.contains(oAuthListener)) {
            this.f151771b.add(oAuthListener);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            if (this.f151770a == null) {
                this.f151770a = new Handler(Looper.getMainLooper());
            }
            if (!this.f151771b.contains(oAuthListener)) {
                this.f151771b.add(oAuthListener);
            }
            if (this.f151772c != null) {
                Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
                return true;
            }
            b bVar = new b(str, str2, str3, str4, str5, this.f151773d);
            this.f151772c = bVar;
            bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return true;
        }
        Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
        return false;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void detach() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f151771b.clear();
        stopAuth();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeAllListeners() {
        this.f151771b.clear();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeListener(OAuthListener oAuthListener) {
        this.f151771b.remove(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean stopAuth() {
        boolean z16;
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            b bVar = this.f151772c;
            if (bVar == null) {
                z16 = true;
            } else {
                z16 = bVar.a();
            }
        } catch (Exception e16) {
            Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e16.getMessage());
            z16 = false;
        }
        this.f151772c = null;
        return z16;
    }
}
