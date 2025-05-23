package com.qzone.reborn.qzmoment.view.blur;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMBlurTask {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f59055a;

    /* renamed from: b, reason: collision with root package name */
    private final b f59056b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap f59057c;

    /* renamed from: d, reason: collision with root package name */
    private final a f59058d;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    public QZMBlurTask(Context context, Bitmap bitmap, b bVar, a aVar) {
        this.f59056b = bVar;
        this.f59058d = aVar;
        this.f59055a = new WeakReference<>(context);
        this.f59057c = bitmap;
    }

    public void e() {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.view.blur.QZMBlurTask.1
            @Override // java.lang.Runnable
            public void run() {
                Context context = (Context) QZMBlurTask.this.f59055a.get();
                if (QZMBlurTask.this.f59058d != null && context != null) {
                    final Bitmap a16 = com.qzone.reborn.qzmoment.view.blur.a.a(context, QZMBlurTask.this.f59057c, QZMBlurTask.this.f59056b);
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.qzmoment.view.blur.QZMBlurTask.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZMBlurTask.this.f59058d.a(a16);
                        }
                    });
                } else {
                    QZMBlurTask.this.f59057c.recycle();
                }
            }
        });
    }
}
