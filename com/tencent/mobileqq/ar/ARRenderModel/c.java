package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface c {
    Context d();

    Object e(int i3);

    void f(String str);

    void h(int i3, int i16);

    void i(Runnable runnable);

    void j(ArVideoResourceInfo arVideoResourceInfo);

    h k();

    void m(a aVar, ArCloudConfigInfo arCloudConfigInfo, int i3, int i16, Object obj);

    void n(ArVideoResourceInfo arVideoResourceInfo, c cVar);

    void requestRender();
}
