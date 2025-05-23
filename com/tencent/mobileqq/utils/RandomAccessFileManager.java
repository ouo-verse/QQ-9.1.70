package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RandomAccessFileManager {

    /* renamed from: f, reason: collision with root package name */
    private static RandomAccessFileManager f307238f = new RandomAccessFileManager();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f307239a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, a> f307240b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Runnable f307241c = null;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f307242d = new byte[0];

    /* renamed from: e, reason: collision with root package name */
    private byte[] f307243e = new byte[0];

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class CloseThread implements Runnable {
        final /* synthetic */ RandomAccessFileManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long j3 = 1000;
                try {
                    LockMethodProxy.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                synchronized (this.this$0.f307242d) {
                    if (this.this$0.f307240b.isEmpty()) {
                        synchronized (this.this$0.f307243e) {
                            this.this$0.f307241c = null;
                        }
                        return;
                    }
                    String[] strArr = new String[this.this$0.f307240b.size()];
                    Iterator it = this.this$0.f307240b.keySet().iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        strArr[i3] = (String) it.next();
                        i3++;
                    }
                    int i16 = 0;
                    while (i16 < i3) {
                        a aVar = (a) this.this$0.f307240b.get(strArr[i16]);
                        a aVar2 = aVar.f307248e;
                        while (true) {
                            a aVar3 = aVar2.f307248e;
                            if (aVar2.f307245b == 0 && System.currentTimeMillis() - aVar2.f307249f > j3) {
                                try {
                                    aVar2.f307244a.close();
                                    if (QLog.isColorLevel()) {
                                        QLog.d("AppleMojiHandler", 2, "file ", strArr[i16], "[", Long.valueOf(aVar2.f307246c), "]", " close by Thread:", Long.valueOf(Thread.currentThread().getId()));
                                    }
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                                RandomAccessFileManager randomAccessFileManager = this.this$0;
                                randomAccessFileManager.f(aVar, aVar2, strArr[i16], randomAccessFileManager.f307240b);
                            }
                            if (aVar == aVar2) {
                                break;
                            }
                            aVar2 = aVar3;
                            j3 = 1000;
                        }
                        i16++;
                        j3 = 1000;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public RandomAccessFile f307244a;

        /* renamed from: b, reason: collision with root package name */
        public volatile int f307245b;

        /* renamed from: c, reason: collision with root package name */
        public long f307246c;

        /* renamed from: d, reason: collision with root package name */
        public a f307247d;

        /* renamed from: e, reason: collision with root package name */
        public a f307248e;

        /* renamed from: f, reason: collision with root package name */
        public long f307249f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(a aVar, a aVar2, String str, Map<String, a> map) {
        if (aVar == null) {
            aVar = map.get(str);
        }
        if (aVar != null && aVar2 != null) {
            if (aVar2 == aVar) {
                a aVar3 = aVar.f307247d;
                if (aVar3 != aVar && aVar3 != null) {
                    map.put(str, aVar3);
                } else {
                    map.remove(str);
                }
            }
            a aVar4 = aVar2.f307248e;
            aVar4.f307247d = aVar2.f307247d;
            aVar2.f307247d.f307248e = aVar4;
            aVar2.f307247d = null;
            aVar2.f307248e = null;
        }
    }
}
