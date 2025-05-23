package com.tencent.av.opengl.effects;

import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import org.light.CameraConfig;
import org.light.avatar.AvatarAIInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a {
    void a(long j3);

    boolean b(c cVar);

    void c(String str, String str2);

    void d(p pVar);

    void e(CameraConfig.DeviceCameraOrientation deviceCameraOrientation);

    boolean f();

    void g(PendantItem pendantItem, VideoMaterial videoMaterial);

    void h(int i3, int i16);

    void i(boolean z16);

    void j(FilterDesc filterDesc);

    int k(int i3, boolean z16, p pVar, boolean z17);

    boolean l();

    AvatarAIInfo m();

    void n();

    void o();

    void p(boolean z16);

    void q(int i3, int i16);

    boolean r();
}
