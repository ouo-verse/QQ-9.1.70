package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.aebase.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes32.dex */
public class PngsTextDrawer {

    /* renamed from: j, reason: collision with root package name */
    private static String f65487j = "GIFCreator";

    /* renamed from: b, reason: collision with root package name */
    private Handler f65489b;

    /* renamed from: e, reason: collision with root package name */
    private int f65492e;

    /* renamed from: f, reason: collision with root package name */
    private int f65493f;

    /* renamed from: g, reason: collision with root package name */
    private String f65494g;

    /* renamed from: h, reason: collision with root package name */
    private rq.d f65495h;

    /* renamed from: i, reason: collision with root package name */
    private a f65496i;

    /* renamed from: a, reason: collision with root package name */
    private String f65488a = g.b.a.f65273b;

    /* renamed from: c, reason: collision with root package name */
    private int f65490c = 320;

    /* renamed from: d, reason: collision with root package name */
    private int f65491d = 320;

    /* loaded from: classes32.dex */
    public interface a {
        void a(String str);

        void onGifCreateFail();
    }

    public PngsTextDrawer(String str) {
        this.f65494g = str;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PngsTextDrawerHT" + System.currentTimeMillis());
        baseHandlerThread.start();
        this.f65489b = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> m(String str) {
        String[] list = new File(str).list();
        Arrays.sort(list);
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            arrayList.add(str + File.separator + str2);
        }
        return arrayList;
    }

    public void o(final a aVar) {
        this.f65496i = aVar;
        QLog.d(f65487j, 4, "start add text to png");
        this.f65489b.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                String str = PngsTextDrawer.this.f65488a + System.currentTimeMillis();
                try {
                    new File(str).mkdirs();
                    PngsTextDrawer.this.f65495h.b();
                    Bitmap d16 = PngsTextDrawer.this.f65495h.d();
                    PngsTextDrawer pngsTextDrawer = PngsTextDrawer.this;
                    Iterator it = pngsTextDrawer.m(pngsTextDrawer.f65494g).iterator();
                    while (true) {
                        z16 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = (String) it.next();
                        Bitmap e16 = k.e(str2, PngsTextDrawer.this.f65490c, PngsTextDrawer.this.f65491d, true);
                        if (e16 != null) {
                            new Canvas(e16).drawBitmap(d16, PngsTextDrawer.this.f65492e, PngsTextDrawer.this.f65493f, new Paint());
                            k.f(str + File.separator + new File(str2).getName(), e16);
                            e16.recycle();
                        } else {
                            QLog.d(PngsTextDrawer.f65487j, 4, "draw frame but bitmap == null, png path = ", str2);
                            z16 = false;
                            break;
                        }
                    }
                    PngsTextDrawer.this.f65495h.e();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        if (z16) {
                            aVar2.a(str);
                        } else {
                            aVar2.onGifCreateFail();
                        }
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    QLog.d(PngsTextDrawer.f65487j, 4, "start add text exception, msg = " + e17.getMessage());
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.onGifCreateFail();
                    }
                }
            }
        });
    }

    public void n(final String str, final int i3, final String str2, final String str3, final int i16, final String str4, final float f16, final float f17, final float f18, final float f19) {
        this.f65489b.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer.1
            @Override // java.lang.Runnable
            public void run() {
                PngsTextDrawer.this.f65495h = new rq.d((int) (r0.f65490c * f18), (int) (PngsTextDrawer.this.f65491d * f19));
                PngsTextDrawer.this.f65495h.j(str);
                PngsTextDrawer.this.f65495h.l(i3);
                PngsTextDrawer.this.f65495h.k(str2);
                PngsTextDrawer.this.f65495h.h(str3);
                PngsTextDrawer.this.f65495h.i(i16);
                PngsTextDrawer.this.f65495h.f(str4);
                PngsTextDrawer.this.f65492e = (int) (r0.f65490c * f16);
                PngsTextDrawer.this.f65493f = (int) (r0.f65491d * f17);
            }
        });
    }
}
