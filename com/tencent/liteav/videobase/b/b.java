package com.tencent.liteav.videobase.b;

import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends com.tencent.liteav.videobase.a.a {

    /* renamed from: i, reason: collision with root package name */
    private int f119216i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f119217j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f119218k = -1;

    @Override // com.tencent.liteav.videobase.a.a
    public final void a(int i3, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(this.f119218k, dVar, floatBuffer, floatBuffer2);
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void d() {
        super.d();
        OpenGlUtils.deleteTexture(this.f119218k);
        this.f119218k = -1;
    }

    public final void a(Buffer buffer, int i3, int i16) {
        if (this.f119216i != i3 || this.f119217j != i16) {
            this.f119216i = i3;
            this.f119217j = i16;
            OpenGlUtils.deleteTexture(this.f119218k);
            this.f119218k = -1;
        }
        this.f119218k = OpenGlUtils.loadTexture(6408, buffer, i3, i16, this.f119218k);
    }
}
