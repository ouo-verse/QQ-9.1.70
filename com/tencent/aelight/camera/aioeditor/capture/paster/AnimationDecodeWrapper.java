package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ir.i;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AnimationDecodeWrapper implements com.tencent.mobileqq.editor.composite.util.b {

    /* renamed from: a, reason: collision with root package name */
    private String f66800a;

    /* renamed from: b, reason: collision with root package name */
    private i f66801b;

    public AnimationDecodeWrapper(String str, String str2) {
        this.f66800a = str2;
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.GifDecoder
    public Bitmap getNextGifFrame(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("AnimationDecodeWrapper", 2, "timestamp:" + j3);
        }
        long j16 = (j3 / 1000) / 1000;
        if (QLog.isColorLevel()) {
            QLog.d("AnimationDecodeWrapper", 2, "timestampMs:" + j16);
        }
        i iVar = this.f66801b;
        if (iVar != null) {
            return iVar.f(j16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.editor.composite.util.b
    public int getType() {
        return 3;
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.GifDecoder
    public void init() {
        this.f66801b = hr.c.b(BaseApplication.getContext(), this.f66800a);
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.GifDecoder
    public void release() {
        this.f66801b = null;
    }
}
