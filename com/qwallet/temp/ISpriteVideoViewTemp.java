package com.qwallet.temp;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ISpriteVideoViewTemp extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
    }

    View getView();

    void play(String str, int i3, a aVar);

    void play(String str, a aVar);

    void setCenterCrop(boolean z16);

    void setFilePath(String str);

    void setId(int i3);

    void setLooping(boolean z16);

    void setPivotX(float f16);

    void setPivotY(float f16);

    void stop();
}
