package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface x extends u.a {
    void K(boolean z16);

    void b(Bitmap bitmap);

    void c0(TransferData transferData);

    void d(Bitmap bitmap, boolean z16);

    void d0(int i3, int i16, float f16);

    Bitmap m(int i3);

    void pause();

    void play();

    void setPlayMode(int i3);

    void setVolume(float f16);

    void u(int i3, byte[] bArr);
}
