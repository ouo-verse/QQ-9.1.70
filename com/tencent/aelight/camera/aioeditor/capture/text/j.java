package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j extends d {

    /* renamed from: a, reason: collision with root package name */
    private float f67066a;

    /* renamed from: b, reason: collision with root package name */
    private float f67067b;

    public j(float f16, float f17) {
        this.f67066a = f16;
        this.f67067b = f17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.aelight.camera.aioeditor.capture.text.d
    public void a(int i3, e eVar) {
        RectF rectF = eVar.f67006c;
        float f16 = rectF.right - rectF.left;
        float f17 = rectF.bottom - rectF.top;
        float abs = Math.abs(f16 - this.f67066a) / 2.0f;
        Math.abs(f17 - this.f67067b);
        RectF rectF2 = eVar.f67006c;
        rectF2.left += abs;
        rectF2.right += abs;
    }
}
