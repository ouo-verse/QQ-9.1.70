package com.qzone.proxy.feedcomponent.text;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f50693d;

    /* renamed from: e, reason: collision with root package name */
    private static Bitmap f50694e;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<TextCellLayout> f50695a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerC0430c f50696b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f50697c = new a(f50693d.getLooper());

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TextCellLayout textCellLayout;
            if (message.what != 2) {
                return;
            }
            IETEngine c16 = e.f().c();
            if (c16 == null) {
                QLog.e("ETAnimator", 1, "ETAnimator get animation engine is null ");
                return;
            }
            b bVar = (b) message.obj;
            if (bVar == null || (textCellLayout = (TextCellLayout) c.this.f50695a.get()) == null) {
                return;
            }
            Bitmap G = textCellLayout.G();
            if ((G == null || G.isRecycled()) && (G = textCellLayout.q()) == null) {
                return;
            }
            int width = G.getWidth();
            int height = G.getHeight();
            if (c.f50694e != null && (c.f50694e.getWidth() < width || c.f50694e.getHeight() < height)) {
                c.f50694e.recycle();
                c.f50694e = null;
            }
            if (c.f50694e == null) {
                c.f50694e = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } else {
                c.f50694e.eraseColor(0);
            }
            IETDecoration a16 = bVar.f50702d.a(c16, false);
            if (a16 != null) {
                a16.gotoFrame(bVar.f50700b);
                bVar.f50702d.c(c16, c.f50694e, a16, true);
                a16.deleteDescriptor(c16);
                if (textCellLayout.cloneBitmap(bVar, c16, c.f50694e, G)) {
                    c.this.f50696b.obtainMessage(1, bVar).sendToTarget();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private long f50699a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f50700b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f50701c = -1;

        /* renamed from: d, reason: collision with root package name */
        public f f50702d = null;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f50703e = null;

        static b b(TextCellLayout textCellLayout) {
            if (textCellLayout.f50618k1 == null) {
                return null;
            }
            b bVar = new b();
            bVar.f50702d = textCellLayout.f50621l1;
            bVar.f50703e = textCellLayout.getText();
            bVar.f50700b = textCellLayout.f50618k1.currentFrameIndex();
            bVar.f50699a = System.currentTimeMillis();
            bVar.f50701c = textCellLayout.f50609h1;
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.qzone.proxy.feedcomponent.text.c$c, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class HandlerC0430c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<TextCellLayout> f50704a;

        HandlerC0430c(TextCellLayout textCellLayout, Looper looper) {
            super(looper);
            this.f50704a = new WeakReference<>(textCellLayout);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IETDecoration iETDecoration;
            TextCellLayout textCellLayout = this.f50704a.get();
            if (textCellLayout == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                b b16 = b.b(textCellLayout);
                if (b16 != null) {
                    textCellLayout.f50615j1.g(b16);
                    return;
                }
                return;
            }
            boolean z16 = true;
            if (i3 != 1) {
                return;
            }
            b bVar = (b) message.obj;
            if (bVar != null && textCellLayout.getText().equals(bVar.f50703e.toString()) && (iETDecoration = textCellLayout.f50618k1) != null && iETDecoration.currentFrameIndex() == bVar.f50700b && (textCellLayout.getPaint() instanceof d) && ((d) textCellLayout.getPaint()).f() != null && ((d) textCellLayout.getPaint()).f().getId() == bVar.f50702d.e().getId() && ((d) textCellLayout.getPaint()).f().getSize() == bVar.f50702d.e().getSize()) {
                boolean z17 = textCellLayout.f50603f1 && !textCellLayout.isScroll();
                if (z17) {
                    textCellLayout.postInvalidate();
                    IETDecoration iETDecoration2 = textCellLayout.f50618k1;
                    if (iETDecoration2.nextFrame()) {
                        int frameDelay = iETDecoration2.getFrameDelay();
                        int currentTimeMillis = (int) (System.currentTimeMillis() - bVar.f50699a);
                        if (currentTimeMillis > 0 && currentTimeMillis * 2 < frameDelay) {
                            frameDelay -= currentTimeMillis;
                        }
                        if (frameDelay <= 1) {
                            sendEmptyMessage(0);
                        } else {
                            sendEmptyMessageDelayed(0, frameDelay);
                        }
                    } else {
                        textCellLayout.f50606g1 = true;
                        textCellLayout.postInvalidateDelayed(200L);
                        z16 = false;
                    }
                } else {
                    z16 = z17;
                }
                textCellLayout.f50603f1 = z16;
                return;
            }
            QLog.e("ETAnimator", 1, "this textView reused!");
            textCellLayout.f50603f1 = false;
        }
    }

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("createDecoration");
        f50693d = baseHandlerThread;
        baseHandlerThread.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TextCellLayout textCellLayout, Looper looper) {
        this.f50695a = new WeakReference<>(textCellLayout);
        this.f50696b = new HandlerC0430c(textCellLayout, looper);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        Handler handler = this.f50697c;
        if (handler != null) {
            handler.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        HandlerC0430c handlerC0430c = this.f50696b;
        if (handlerC0430c != null) {
            handlerC0430c.removeMessages(0);
            this.f50696b.removeMessages(1);
        }
    }

    void g(b bVar) {
        Handler handler = this.f50697c;
        if (handler != null) {
            handler.obtainMessage(2, bVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        HandlerC0430c handlerC0430c = this.f50696b;
        if (handlerC0430c != null) {
            handlerC0430c.obtainMessage(0).sendToTarget();
        }
    }
}
