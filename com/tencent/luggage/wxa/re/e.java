package com.tencent.luggage.wxa.re;

import android.util.Size;
import android.view.View;
import com.tencent.luggage.wxa.xd.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e extends g.d, g.b, g.c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
    }

    float a(float f16);

    void a();

    void a(int i3, int i16, int i17, int i18);

    void a(com.tencent.luggage.wxa.xd.d dVar, String str);

    void a(String str, boolean z16);

    void a(boolean z16, boolean z17);

    boolean a(int i3, int i16, boolean z16);

    void b();

    void b(boolean z16);

    void c();

    void e();

    int getCameraId();

    View getView();

    void release();

    void setAppId(String str);

    void setCameraId(int i3);

    void setCameraLife(a aVar);

    void setCompressRecord(boolean z16);

    void setDisplayScreenSize(Size size);

    void setFlash(String str);

    void setFrameLimitSize(int i3);

    void setMode(String str);

    void setNeedOutput(boolean z16);

    void setOperateCallBack(c cVar);

    void setOutPutCallBack(b bVar);

    void setPage(com.tencent.luggage.wxa.xd.f fVar);

    void setPageOrientation(boolean z16);

    void setPreviewCenterCrop(boolean z16);

    void setQuality(String str);

    void setResolution(String str);

    void setScanFreq(int i3);
}
