package com.tencent.luggage.wxa.x0;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f144442a;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f144443b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f144444c = {"_id", InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "_data", "bucket_display_name", "duration"};

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.x0.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC6894a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f144445a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f144446b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f144447c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList f144448d;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.luggage.wxa.a1.c f144449e;

        public RunnableC6894a(boolean z16, boolean z17, boolean z18, ArrayList arrayList, com.tencent.luggage.wxa.a1.c cVar) {
            this.f144445a = z16;
            this.f144446b = z17;
            this.f144447c = z18;
            this.f144448d = arrayList;
            this.f144449e = cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
        
            if (r0.moveToLast() != false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            r6 = r0.getLong(r0.getColumnIndex(r13.f144450f.f144444c[0]));
            r8 = r0.getString(r0.getColumnIndex(r13.f144450f.f144444c[1]));
            r9 = r0.getString(r0.getColumnIndex(r13.f144450f.f144444c[2]));
            r4 = r0.getString(r0.getColumnIndex(r13.f144450f.f144444c[3]));
            r10 = r0.getLong(r0.getColumnIndex(r13.f144450f.f144444c[4]));
            r5 = com.tencent.luggage.wxa.x0.a.b(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00b4, code lost:
        
            if (r5 == null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00b6, code lost:
        
            r12 = r13.f144448d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00b8, code lost:
        
            if (r12 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00be, code lost:
        
            if (r12.contains(r5) == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00c1, code lost:
        
            r12 = new com.tencent.luggage.wxa.f1.b(r6, r8, r9, r10);
            r2.add(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00ca, code lost:
        
            if (r3 == null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00cc, code lost:
        
            r5 = (com.tencent.luggage.wxa.f1.a) r3.get(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00d2, code lost:
        
            if (r5 != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00d4, code lost:
        
            r5 = new com.tencent.luggage.wxa.f1.a(r4);
            r3.put(r4, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00dc, code lost:
        
            r5.b().add(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00e7, code lost:
        
            if (r0.moveToPrevious() != false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00e9, code lost:
        
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ec, code lost:
        
            if (r3 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ee, code lost:
        
            r1 = new java.util.ArrayList(r3.values());
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00f7, code lost:
        
            r13.f144449e.a(r2, r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00fc, code lost:
        
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            String str2;
            Cursor query;
            HashMap hashMap;
            boolean z16 = this.f144446b;
            ArrayList arrayList = null;
            if (z16 && !this.f144447c) {
                str2 = "media_type=1";
            } else if (this.f144447c && !z16) {
                str2 = "media_type=3";
            } else {
                str = null;
                query = ContactsMonitor.query(a.this.f144442a.getContentResolver(), MediaStore.Files.getContentUri("external"), a.this.f144444c, str, null, "date_added");
                if (query != null) {
                    this.f144449e.onFailed(new NullPointerException());
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                if (this.f144445a) {
                    hashMap = new HashMap();
                } else {
                    hashMap = null;
                }
            }
            str = str2;
            query = ContactsMonitor.query(a.this.f144442a.getContentResolver(), MediaStore.Files.getContentUri("external"), a.this.f144444c, str, null, "date_added");
            if (query != null) {
            }
        }
    }

    public a(Context context) {
        this.f144442a = context;
    }

    public final ExecutorService b() {
        if (this.f144443b == null) {
            this.f144443b = ProxyExecutors.newSingleThreadExecutor();
        }
        return this.f144443b;
    }

    public void a(boolean z16, boolean z17, boolean z18, ArrayList arrayList, com.tencent.luggage.wxa.a1.c cVar) {
        b().execute(new RunnableC6894a(z16, z17, z18, arrayList, cVar));
    }

    public void a() {
        ExecutorService executorService = this.f144443b;
        if (executorService != null) {
            executorService.shutdown();
            this.f144443b = null;
        }
    }

    public static File b(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return new File(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
