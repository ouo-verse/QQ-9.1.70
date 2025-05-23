package com.tencent.aelight.camera.ae.gif;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.config.g;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<Frame> f65327a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private BaseFilter f65328b = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: c, reason: collision with root package name */
    private qq.c f65329c = new qq.c();

    /* renamed from: d, reason: collision with root package name */
    private qq.b f65330d = new qq.b();

    /* renamed from: e, reason: collision with root package name */
    private b f65331e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.gif.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0562a extends g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f65332d;

        C0562a(AppInterface appInterface) {
            this.f65332d = appInterface;
        }

        @Override // com.tencent.aelight.camera.ae.config.g
        public void onUpdateRecommendText(boolean z16, c cVar) {
            this.f65332d.removeObserver(this);
            if (z16) {
                a.this.f65331e.a(cVar);
            } else {
                a.this.f65331e.a(new c());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(c cVar);
    }

    private Bitmap d() {
        this.f65330d.b(this.f65327a);
        return RendererUtils.saveTexture(this.f65330d.a());
    }

    public void b(int i3, List<PointF> list, int i16, int i17) {
        this.f65327a.add(this.f65328b.RenderProcess(this.f65329c.a(i3, list, i16, i17).getTextureId(), 64, 64));
    }

    public void c() {
        Iterator<Frame> it = this.f65327a.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f65328b.clearGLSLSelf();
        this.f65329c.clearGLSLSelf();
        this.f65330d.clearGLSLSelf();
    }

    public int e() {
        return this.f65327a.size();
    }

    public void f() {
        this.f65328b.apply();
        this.f65329c.apply();
        this.f65330d.apply();
    }

    public void g() {
        if (!this.f65327a.isEmpty()) {
            AppInterface a16 = QQStoryContext.a();
            CameraPeakServiceHandler cameraPeakServiceHandler = (CameraPeakServiceHandler) a16.getBusinessHandler(PeakAppInterface.I);
            a16.addObserver(new C0562a(a16));
            cameraPeakServiceHandler.p3(d());
            return;
        }
        this.f65331e.a(new c());
    }

    public void h() {
        Iterator<Frame> it = this.f65327a.iterator();
        while (it.hasNext()) {
            it.next().unlock();
        }
        this.f65327a.clear();
    }

    public void i(b bVar) {
        this.f65331e = bVar;
    }
}
