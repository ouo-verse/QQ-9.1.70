package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private int f119341a = -1;

    public final void a() {
        if (this.f119341a == -1) {
            this.f119341a = OpenGlUtils.generateFrameBufferId();
        }
    }

    public final void b() {
        OpenGlUtils.bindFramebuffer(36160, this.f119341a);
    }

    public final void c() {
        int i3 = this.f119341a;
        if (i3 == -1) {
            LiteavLog.d("GLFrameBuffer", "FrameBuffer is invalid");
        } else {
            OpenGlUtils.detachTextureFromFrameBuffer(i3);
        }
    }

    public final void d() {
        int i3 = this.f119341a;
        if (i3 != -1) {
            OpenGlUtils.deleteFrameBuffer(i3);
            this.f119341a = -1;
        }
    }

    public final void a(int i3) {
        int i16 = this.f119341a;
        if (i16 == -1) {
            LiteavLog.d("GLFrameBuffer", "FrameBuffer is invalid");
        } else {
            OpenGlUtils.attachTextureToFrameBuffer(i3, i16);
        }
    }
}
