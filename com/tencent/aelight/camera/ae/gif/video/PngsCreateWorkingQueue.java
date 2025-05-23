package com.tencent.aelight.camera.ae.gif.video;

import android.content.Context;
import android.os.Handler;
import com.tencent.aelight.camera.ae.gif.video.PngsCreator;
import com.tencent.aelight.camera.aebase.k;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.light.device.LightDeviceUtils;
import rq.c;

/* loaded from: classes32.dex */
public class PngsCreateWorkingQueue {

    /* renamed from: g, reason: collision with root package name */
    private static String f65452g = "PngsCreateWorkingQueue";

    /* renamed from: a, reason: collision with root package name */
    private Handler f65453a;

    /* renamed from: b, reason: collision with root package name */
    private PngsCreator f65454b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.gif.video.b f65455c = new com.tencent.aelight.camera.ae.gif.video.b();

    /* renamed from: d, reason: collision with root package name */
    private b f65456d;

    /* renamed from: e, reason: collision with root package name */
    private Context f65457e;

    /* renamed from: f, reason: collision with root package name */
    private String f65458f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements PngsCreator.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.ae.gif.video.a f65461a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f65462b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Semaphore f65463c;

        a(com.tencent.aelight.camera.ae.gif.video.a aVar, String[] strArr, Semaphore semaphore) {
            this.f65461a = aVar;
            this.f65462b = strArr;
            this.f65463c = semaphore;
        }

        @Override // com.tencent.aelight.camera.ae.gif.video.PngsCreator.a
        public void a(String str) {
            QLog.d(PngsCreateWorkingQueue.f65452g, 4, "create pngs for material index = " + this.f65461a.f65539a + " end, pngDir = " + str);
            this.f65462b[0] = str;
            String[] list = new File(str).list();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("snapshot.png");
            String sb6 = sb5.toString();
            if (list.length != 0) {
                k.a(str + str2 + list[0], 320, 320, sb6);
            }
            PngsCreateWorkingQueue.this.f65455c.f65545c.add(sb6);
            PngsCreateWorkingQueue.this.f65455c.f65543a.add(str);
            String str3 = this.f65461a.f65542d;
            if (str3 != null && !str3.equals("")) {
                PngsCreateWorkingQueue.this.f65455c.f65544b.add(this.f65461a.f65542d);
            } else {
                PngsCreateWorkingQueue.this.f65455c.f65544b.add(this.f65461a.f65541c);
            }
            PngsCreateWorkingQueue.this.f65455c.f65546d.add(Integer.valueOf(this.f65461a.f65539a));
            this.f65463c.release();
        }
    }

    /* loaded from: classes32.dex */
    public interface b {
        void onComplete(int i3, String str);
    }

    public PngsCreateWorkingQueue(String str, List<PTFaceAttr> list, String str2, Context context) {
        this.f65454b = new PngsCreator(str, list);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PngsCreateWorkingQueue");
        baseHandlerThread.start();
        this.f65453a = new Handler(baseHandlerThread.getLooper());
        this.f65458f = str2;
        this.f65457e = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Iterator<String> it = this.f65455c.f65543a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            QLog.d(f65452g, 4, "clear frame files, dir = " + next);
            FileUtils.deleteDirectory(next);
        }
    }

    public void g(final com.tencent.aelight.camera.ae.gif.video.a aVar) {
        this.f65453a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue.1
            @Override // java.lang.Runnable
            public void run() {
                PngsCreateWorkingQueue.this.i(aVar);
            }
        });
    }

    public com.tencent.aelight.camera.ae.gif.video.b j() {
        return this.f65455c;
    }

    public void k(b bVar) {
        this.f65456d = bVar;
    }

    public void l(final boolean z16) {
        QLog.d(f65452g, 4, "stop, clearFiles = " + z16);
        this.f65453a.removeCallbacksAndMessages(null);
        this.f65453a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue.3
            @Override // java.lang.Runnable
            public void run() {
                PngsCreateWorkingQueue.this.f65454b.s();
                if (z16) {
                    PngsCreateWorkingQueue.this.h();
                }
                PngsCreateWorkingQueue.this.f65453a.getLooper().quit();
            }
        });
        this.f65457e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.tencent.aelight.camera.ae.gif.video.a aVar) {
        float f16;
        float f17;
        String[] strArr = {""};
        Semaphore semaphore = new Semaphore(0);
        List<c.a> list = rq.c.f431900b;
        int[] iArr = rq.c.f431899a;
        c.a aVar2 = list.get(iArr[aVar.f65539a % iArr.length]);
        if (aVar.f65541c.contains("\n")) {
            f16 = 0.67f;
            f17 = 0.3f;
        } else {
            f16 = 0.81f;
            f17 = 0.16f;
        }
        float f18 = f16;
        float f19 = f17;
        int screenWidth = this.f65457e != null ? ((int) (LightDeviceUtils.getScreenWidth(r6) * 0.44f)) + 1 : 1920;
        Context context = this.f65457e;
        int c16 = context != null ? (x.c(context, 2.0f) * 320) / screenWidth : 5;
        Context context2 = this.f65457e;
        this.f65454b.t(aVar.f65541c, context2 != null ? (x.j(context2, 23.0f) * 320) / screenWidth : 19, aVar2.f431901a, aVar2.f431902b, c16, this.f65458f, 0.0f, f18, 1.0f, f19);
        this.f65454b.r(aVar.f65540b);
        this.f65454b.u(new a(aVar, strArr, semaphore));
        try {
            semaphore.acquire();
            b bVar = this.f65456d;
            if (bVar != null) {
                bVar.onComplete(aVar.f65539a, strArr[0]);
            }
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }
}
