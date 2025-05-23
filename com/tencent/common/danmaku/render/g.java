package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface g {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    float a();

    void b(a aVar);

    boolean c();

    void d(boolean z16);

    void destroy();

    boolean e();

    void f(boolean z16);

    boolean g();

    View getView();

    Canvas lockCanvas();

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void unlock();

    void unlockCanvasAndPost(Canvas canvas);
}
