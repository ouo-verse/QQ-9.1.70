package com.tencent.qimei.ae;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static k f342954b;

    /* renamed from: a, reason: collision with root package name */
    public l f342955a;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342955a = new l();
        }
    }

    public static k a() {
        if (f342954b == null) {
            synchronized (k.class) {
                if (f342954b == null) {
                    f342954b = new k();
                }
            }
        }
        return f342954b;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:8|(3:83|84|(11:92|11|(4:13|(4:15|16|17|(4:19|(5:21|22|23|(1:28)(2:25|26)|27)|31|(1:35)))|39|(2:33|35))|40|(2:42|(6:44|(3:46|(1:56)(3:48|49|51)|52)|57|58|(1:60)(1:71)|(2:66|67)))|72|73|(1:75)|76|(1:78)|80))|10|11|(0)|40|(0)|72|73|(0)|76|(0)|80) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0121, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0122, code lost:
    
        com.tencent.qimei.ad.c.a(r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0112 A[Catch: IOException -> 0x0121, TryCatch #3 {IOException -> 0x0121, blocks: (B:73:0x010c, B:75:0x0112, B:76:0x0117, B:78:0x011b), top: B:72:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011b A[Catch: IOException -> 0x0121, TRY_LEAVE, TryCatch #3 {IOException -> 0x0121, blocks: (B:73:0x010c, B:75:0x0112, B:76:0x0117, B:78:0x011b), top: B:72:0x010c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(int i3, m mVar) {
        int i16;
        byte[] bArr;
        String a16;
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        byte[] bArr2;
        l lVar;
        JSONObject jSONObject;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) mVar);
        }
        com.tencent.qimei.aa.g gVar = new com.tencent.qimei.aa.g();
        gVar.a("qmprishamem", 1024);
        if (gVar.f342920e) {
            try {
                gVar.f342918c.position(0);
            } catch (Exception e16) {
                com.tencent.qimei.ad.c.a(e16);
            }
            if (gVar.f342918c.getInt() == Process.myPid() && (i16 = gVar.f342918c.getInt()) != 0 && i16 <= gVar.f342919d) {
                bArr = new byte[i16];
                gVar.f342918c.get(bArr, 0, i16);
                if (bArr != null) {
                    String str2 = new String(bArr);
                    if (!str2.isEmpty()) {
                        lVar = new l();
                        try {
                            jSONObject = new JSONObject(str2);
                        } catch (JSONException e17) {
                            com.tencent.qimei.ad.c.a(e17);
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            for (int i17 = 1; i17 < 12; i17++) {
                                try {
                                    str = jSONObject.getString(String.valueOf(i17));
                                } catch (JSONException unused) {
                                    str = null;
                                }
                                if (str != null) {
                                    lVar.a(i17, str);
                                }
                            }
                            if (lVar != null && !lVar.equals(this.f342955a)) {
                                this.f342955a = lVar;
                            }
                        }
                    }
                    lVar = null;
                    if (lVar != null) {
                        this.f342955a = lVar;
                    }
                }
                a16 = this.f342955a.a(i3);
                if (a16 == null) {
                    a16 = mVar.a();
                    if (this.f342955a.a(i3, a16)) {
                        l lVar2 = this.f342955a;
                        JSONObject jSONObject2 = new JSONObject();
                        for (int i18 = 1; i18 < 12; i18++) {
                            String valueOf = String.valueOf(i18);
                            String a17 = lVar2.a(i18);
                            if (a17 != null) {
                                try {
                                    jSONObject2.put(valueOf, a17);
                                } catch (JSONException e18) {
                                    com.tencent.qimei.ad.c.a(e18);
                                }
                            }
                        }
                        String jSONObject3 = jSONObject2.toString();
                        if (!jSONObject3.isEmpty()) {
                            bArr2 = jSONObject3.getBytes();
                        } else {
                            bArr2 = null;
                        }
                        if (bArr2 != null && gVar.f342920e && bArr2.length <= gVar.f342919d) {
                            try {
                                gVar.f342918c.position(0);
                                gVar.f342918c.putInt(Process.myPid());
                                gVar.f342918c.putInt(bArr2.length);
                                gVar.f342918c.put(bArr2);
                            } catch (Exception e19) {
                                com.tencent.qimei.ad.c.a(e19);
                            }
                        }
                    }
                }
                gVar.f342918c = null;
                fileChannel = gVar.f342917b;
                if (fileChannel != null) {
                    fileChannel.close();
                    gVar.f342917b = null;
                }
                randomAccessFile = gVar.f342916a;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                    gVar.f342916a = null;
                }
                return a16;
            }
        }
        bArr = null;
        if (bArr != null) {
        }
        a16 = this.f342955a.a(i3);
        if (a16 == null) {
        }
        gVar.f342918c = null;
        fileChannel = gVar.f342917b;
        if (fileChannel != null) {
        }
        randomAccessFile = gVar.f342916a;
        if (randomAccessFile != null) {
        }
        return a16;
    }

    public String a(int i3, m mVar) {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) mVar);
        }
        synchronized (String.class) {
            a16 = this.f342955a.a(i3);
            if (a16 == null) {
                a16 = b(i3, mVar);
            }
        }
        return a16;
    }
}
