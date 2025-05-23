package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.common.app.AppInterface;
import qs.f;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends com.tencent.aelight.camera.aioeditor.capture.data.a {
    private float C;
    private AppInterface D;
    private QIMPtvTemplateManager E;
    private f F;
    private PtvTemplateManager.a G;

    /* renamed from: m, reason: collision with root package name */
    private int f66853m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements PtvTemplateManager.a {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.a
        public void a(f fVar, boolean z16) {
            synchronized (c.this.F) {
                if (fVar.f429433a.equals(c.this.F.f429433a)) {
                    c.this.F.f429440h = false;
                    c.this.F.f429439g = z16;
                }
                if (z16) {
                    if (c.this.F.f429433a.equals(fVar.f429433a)) {
                        c.this.f66853m = 3;
                        c.this.C = 1.0f;
                        c.this.n();
                    }
                } else {
                    c.this.m(4);
                    c.this.f66853m = 2;
                }
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.a
        public void b(f fVar, int i3) {
            synchronized (c.this.F) {
                if (fVar.f429433a.equals(c.this.F.f429433a)) {
                    c.this.F.f429440h = true;
                    c.this.C = (i3 * 1.0f) / 100.0f;
                    c.this.f66853m = 1;
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        f fVar = this.F;
        if (fVar == null || !fVar.f429439g) {
            return -1;
        }
        String str = QIMPtvTemplateManager.L + this.F.f429437e;
        this.E.I(this.F, 111);
        QIMPtvTemplateManager qIMPtvTemplateManager = this.E;
        f fVar2 = this.F;
        qIMPtvTemplateManager.J(fVar2.f429433a, fVar2.f429444l, str);
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int h() {
        f fVar = this.F;
        if (fVar == null) {
            this.f66853m = 3;
            return 3;
        }
        if (!fVar.f429439g) {
            this.E.K(this.D, fVar, this.G);
            l();
            this.f66853m = 1;
        } else if (fVar.f429440h) {
            this.f66853m = 1;
        } else {
            this.C = 1.0f;
            this.f66853m = 3;
            n();
        }
        return this.f66853m;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized float i() {
        return this.C;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int j() {
        return this.f66853m;
    }

    public c(String str) {
        super(null);
        this.f66853m = 2;
        this.C = 0.0f;
        this.G = new a();
        this.D = fr.f.e();
        QIMPtvTemplateManager qIMPtvTemplateManager = (QIMPtvTemplateManager) fr.f.c(3);
        this.E = qIMPtvTemplateManager;
        f l3 = qIMPtvTemplateManager.l(str);
        this.F = l3;
        if (l3 != null && l3.f429439g) {
            this.f66853m = 3;
        } else if (l3 == null) {
            this.f66853m = 3;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
    }
}
