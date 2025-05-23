package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
class s implements j {

    /* renamed from: b, reason: collision with root package name */
    private static String f389481b = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* renamed from: c, reason: collision with root package name */
    private static String f389482c = f389481b + "OAID";

    /* renamed from: d, reason: collision with root package name */
    private static String f389483d = f389481b + "VAID_";

    /* renamed from: e, reason: collision with root package name */
    private static String f389484e = f389481b + "AAID_";

    /* renamed from: f, reason: collision with root package name */
    private static String f389485f = f389481b + "OAIDSTATUS";

    /* renamed from: g, reason: collision with root package name */
    private static String f389486g = "persist.sys.identifierid.supported";

    /* renamed from: a, reason: collision with root package name */
    private Context f389487a;

    public s(Context context) {
        this.f389487a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r10 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
    
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003d, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(String str) {
        Throwable th5;
        Cursor cursor;
        String str2 = null;
        try {
            cursor = ContactsMonitor.query(this.f389487a.getContentResolver(), Uri.parse(str), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        str2 = cursor.getString(cursor.getColumnIndex("value"));
                    }
                } catch (Exception unused) {
                } catch (Throwable th6) {
                    th5 = th6;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th5;
                }
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th7) {
            th5 = th7;
            cursor = null;
        }
    }

    public static boolean c(Context context) {
        boolean z16;
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f389481b).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.xiaomi.push.j
    /* renamed from: a */
    public boolean mo299a() {
        return "1".equals(ih.a(f389486g, "0"));
    }

    @Override // com.xiaomi.push.j
    public String a() {
        return b(f389482c);
    }
}
