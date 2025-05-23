package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r extends d {

    /* renamed from: a, reason: collision with root package name */
    private int f67154a;

    public r(int i3) {
        this.f67154a = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.aelight.camera.aioeditor.capture.text.d
    public void a(int i3, e eVar) {
        RectF rectF = eVar.f67006c;
        float f16 = rectF.top;
        int i16 = this.f67154a;
        rectF.top = f16 + (i3 * i16);
        rectF.bottom += i3 * i16;
    }
}
