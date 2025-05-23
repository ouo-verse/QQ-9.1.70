package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleMagicAlgoHandler;
import com.tencent.filter.GLSLRender;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l extends c {

    /* renamed from: b, reason: collision with root package name */
    public String f68407b;

    /* renamed from: c, reason: collision with root package name */
    CopyOnWriteArrayList<PointF> f68408c;

    /* renamed from: d, reason: collision with root package name */
    int f68409d;

    /* renamed from: e, reason: collision with root package name */
    int f68410e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f68411f;

    /* renamed from: g, reason: collision with root package name */
    volatile boolean f68412g;

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f68413h;

    /* renamed from: i, reason: collision with root package name */
    boolean f68414i;

    /* renamed from: j, reason: collision with root package name */
    int f68415j;

    /* renamed from: k, reason: collision with root package name */
    Frame f68416k;

    /* renamed from: l, reason: collision with root package name */
    boolean f68417l;

    /* renamed from: m, reason: collision with root package name */
    ArrayList<DoodleMagicAlgoHandler.RenderPoint> f68418m;

    public l(int i3, String str, int i16) {
        super(i3);
        this.f68408c = new CopyOnWriteArrayList<>();
        this.f68417l = false;
        this.f68418m = new ArrayList<>();
        this.f68407b = str;
        this.f68410e = i16;
        this.f68408c.clear();
        this.f68411f = false;
        this.f68413h = false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.c
    public void a() {
        Frame frame;
        if (!this.f68413h || (frame = this.f68416k) == null || this.f68417l) {
            return;
        }
        this.f68417l = true;
        frame.clear();
        RendererUtils.clearTexture(this.f68415j);
    }

    public Frame b(int i3, int i16) {
        this.f68415j = RendererUtils.createTexture();
        this.f68416k = new Frame();
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f68415j);
        this.f68416k.bindFrame(this.f68415j, i3, i16, 1.0d);
        GLES20.glBindFramebuffer(36160, this.f68416k.getFBO());
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        GLES20.glFlush();
        return this.f68416k;
    }

    public void c() {
        this.f68411f = true;
        this.f68412g = true;
    }
}
