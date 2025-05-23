package com.tencent.open.base;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.open.agent.util.n;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    protected b f341033a;

    /* renamed from: b, reason: collision with root package name */
    protected WtloginManager f341034b;

    /* renamed from: c, reason: collision with root package name */
    protected long f341035c;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.mobileqq.loginregister.servlet.f f341036d = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.mobileqq.loginregister.servlet.f {
        a() {
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void a(String str, int i3, int i16, Bundle bundle) {
            b bVar = k.this.f341033a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void b(String str, int i3, byte[] bArr, int i16, Bundle bundle) {
            if (i3 == 0) {
                String a16 = com.tencent.mobileqq.login.account.b.a(str);
                if (bArr != null && bArr.length > 0) {
                    util.LOGD("outA1 buff: " + util.buf_to_string(bArr));
                    byte[] EncryptData = new RSACrypt(com.tencent.open.adapter.a.f().e()).EncryptData(k.this.c(com.tencent.open.adapter.a.f().e(), k.this.f341035c, 1L), bArr);
                    util.LOGD("encrypt buff:" + util.buf_to_string(EncryptData));
                    b bVar = k.this.f341033a;
                    if (bVar != null) {
                        bVar.b(a16, EncryptData);
                        return;
                    }
                    return;
                }
                return;
            }
            b bVar2 = k.this.f341033a;
            if (bVar2 != null) {
                bVar2.a();
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void d(String str, int i3, Bundle bundle) {
            b bVar = k.this.f341033a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void a();

        void b(String str, byte[] bArr);
    }

    public void a() {
        this.f341033a = null;
    }

    public void b(AppRuntime appRuntime, long j3, String str) {
        WtloginManager wtloginManager = (WtloginManager) appRuntime.getManager(1);
        this.f341034b = wtloginManager;
        if (wtloginManager != null) {
            byte[] a16 = n.a(com.tencent.open.adapter.a.f().e(), str);
            this.f341035c = j3;
            ((ILoginServletService) appRuntime.getRuntimeService(ILoginServletService.class, "all")).ssoGetA1WithA1(com.tencent.open.adapter.a.f().l() + "", str.getBytes(), 16L, j3, 1L, "5.0".getBytes(), a16, this.f341036d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00e3, code lost:
    
        if (r8 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0101, code lost:
    
        return oicq.wlogin_sdk.tools.util.string_to_buf(oicq.wlogin_sdk.tools.RSACrypt.DEFAULT_PUB_KEY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f7, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f5, code lost:
    
        if (r8 == null) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0105  */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] c(Context context, long j3, long j16) {
        Cursor cursor;
        try {
            Class<?> cls = util.class.getClass();
            Class<?> cls2 = Long.TYPE;
            try {
                Object invoke = cls.getMethod("get_cp_pubkey", Context.class, cls2, cls2).invoke(this, context, Long.valueOf(j3), Long.valueOf(j16));
                if (invoke instanceof byte[]) {
                    return (byte[]) invoke;
                }
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                if (context != null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (context != null) {
            return new byte[0];
        }
        ContentResolver contentResolver = context.getContentResolver();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("content://");
        sb5.append("oicq.wlogin_sdk.WloginProvider");
        ?? r85 = "/rsa_pubkey";
        sb5.append("/rsa_pubkey");
        try {
            try {
                cursor = ContactsMonitor.query(contentResolver, Uri.parse(sb5.toString()), new String[]{"id", "appid", "subappid", "pubkey", "pubkey_md5"}, "appid=? and subappid=?", new String[]{j3 + "", j16 + ""}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            cursor.getInt(cursor.getColumnIndex("id"));
                            String string = cursor.getString(cursor.getColumnIndex("pubkey"));
                            if (MD5.toMD5(string).equals(cursor.getString(cursor.getColumnIndex("pubkey_md5")))) {
                                byte[] string_to_buf = util.string_to_buf(string);
                                cursor.close();
                                return string_to_buf;
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        f.j("TicketUtils", e.getMessage(), e);
                    }
                }
            } catch (Exception e19) {
                e = e19;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                r85 = 0;
                if (r85 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            if (r85 != 0) {
                r85.close();
            }
            throw th;
        }
    }

    public void d(b bVar) {
        this.f341033a = bVar;
    }
}
