package com.qq.e.comm.pi;

import com.qq.e.comm.adevent.ADListener;
import com.qq.e.tg.nativ.ADSize;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NEADVI {
    void destroy();

    void pause();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void resume();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);
}
