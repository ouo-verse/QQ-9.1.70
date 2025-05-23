package com.tencent.av.business.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Checker implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f73290d = new ConcurrentHashMap<>(5);

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedQueue<String> f73291e = new ConcurrentLinkedQueue<>();

    /* renamed from: f, reason: collision with root package name */
    private WeakReferenceHandler f73292f = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final com.tencent.av.business.manager.pendant.c f73295a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<String> f73296b;

        /* renamed from: c, reason: collision with root package name */
        String f73297c;

        /* renamed from: d, reason: collision with root package name */
        String f73298d;

        /* renamed from: e, reason: collision with root package name */
        int f73299e;

        /* renamed from: f, reason: collision with root package name */
        boolean f73300f;

        /* renamed from: g, reason: collision with root package name */
        boolean f73301g;

        a(com.tencent.av.business.manager.pendant.c cVar, ArrayList<String> arrayList, boolean z16) {
            ArrayList<String> arrayList2 = new ArrayList<>(0);
            this.f73296b = arrayList2;
            this.f73301g = false;
            this.f73295a = cVar;
            this.f73299e = 0;
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            this.f73300f = z16;
        }

        boolean a() {
            if (this.f73299e >= 3) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "ItemRecord{" + this.f73295a + "," + this.f73299e + "," + this.f73297c + "," + this.f73298d + "}";
        }
    }

    private void c(final String str, final a aVar) {
        if (aVar == null) {
            d();
            return;
        }
        if (aVar.a()) {
            d();
        } else if (aVar.f73295a == null) {
            aVar.f73299e++;
            d();
        } else {
            aVar.f73299e++;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.business.manager.Checker.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FileUtils.fileExists(aVar.f73297c)) {
                        Checker.this.e(str, aVar);
                    }
                    Checker.this.d();
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f73291e.size() > 0 && !this.f73292f.hasMessages(1)) {
            this.f73292f.sendEmptyMessage(1);
        }
    }

    public void b(com.tencent.av.business.manager.pendant.c cVar, String str, String str2, ArrayList<String> arrayList, boolean z16) {
        String id5;
        if (cVar == null) {
            id5 = null;
        } else {
            id5 = cVar.getId();
        }
        if (!TextUtils.isEmpty(id5) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !this.f73291e.contains(id5)) {
            if (QLog.isColorLevel()) {
                QLog.i("Checker", 2, "addToCheck, item[" + cVar + "]");
            }
            a aVar = this.f73290d.get(id5);
            if (aVar == null) {
                aVar = new a(cVar, arrayList, z16);
                aVar.f73297c = str;
                aVar.f73298d = str2;
                this.f73290d.put(id5, aVar);
            }
            if (aVar.a()) {
                return;
            }
            this.f73291e.offer(id5);
            d();
        }
    }

    void e(String str, a aVar) {
        boolean z16;
        String str2;
        boolean isUsable = aVar.f73295a.isUsable();
        if (isUsable && !FileUtils.fileExists(aVar.f73298d)) {
            z16 = true;
        } else if (isUsable && aVar.f73296b.size() > 0) {
            int i3 = 0;
            while (true) {
                if (i3 < aVar.f73296b.size()) {
                    String str3 = aVar.f73296b.get(i3);
                    if (!TextUtils.isEmpty(str3)) {
                        String str4 = aVar.f73298d;
                        String str5 = File.separator;
                        if (str4.endsWith(str5)) {
                            str2 = aVar.f73298d + str3;
                        } else {
                            str2 = aVar.f73298d + str5 + str3;
                        }
                        if (!FileUtils.fileExists(str2)) {
                            if (QLog.isColorLevel()) {
                                QLog.i("Checker", 2, "realCheck, id[" + str + "], unExistFile[" + str2 + "]");
                            }
                            z16 = true;
                        }
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                FileUtils.deleteDirectory(aVar.f73298d);
            }
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                FileUtils.uncompressZip(aVar.f73297c, aVar.f73298d, false);
                aVar.f73301g = true;
            } catch (IOException e16) {
                aVar.f73301g = false;
                QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + aVar + "]", e16);
            }
            if (!aVar.f73301g && aVar.a() && aVar.f73300f) {
                FileUtils.deleteFile(aVar.f73297c);
                if (QLog.isColorLevel()) {
                    QLog.i("Checker", 2, "realCheck, del zip id[" + str + "], path[" + aVar.f73297c + "]");
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        if (message.what == 1) {
            String poll = this.f73291e.poll();
            if (!TextUtils.isEmpty(poll)) {
                aVar = this.f73290d.get(poll);
            } else {
                aVar = null;
            }
            c(poll, aVar);
        }
        return true;
    }
}
