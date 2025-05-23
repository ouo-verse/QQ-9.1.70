package com.tencent.biz.qqcircle.richframework.video.preview;

import android.view.View;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.richframework.video.preview.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0927a {
        void a();

        void onDecodeFirstFrame();
    }

    void a(InterfaceC0927a interfaceC0927a);

    void c(View view, ImageView imageView, int i3, int i16);

    void d(String str, long j3, int i3);

    void release();

    void reset();

    void seek(long j3);
}
