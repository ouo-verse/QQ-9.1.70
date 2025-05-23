package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import hr.d;
import hr.e;
import java.io.File;
import java.util.List;
import zr.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleEditView extends DoodleView implements DoodleLayout.x, f.a {
    protected com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f T;
    private float U;
    private float V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f68140a0;

    /* renamed from: b0, reason: collision with root package name */
    private b f68141b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.aelight.camera.aioeditor.capture.data.k f68142c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f68143d0;

    /* renamed from: e0, reason: collision with root package name */
    Runnable f68144e0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(c.a aVar);

        void b();
    }

    public DoodleEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = 0.0f;
        this.V = 0.0f;
        this.f68140a0 = false;
        this.f68143d0 = false;
        this.f68144e0 = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView.2
            @Override // java.lang.Runnable
            public void run() {
                DoodleEditView.this.setVisibility(0);
            }
        };
        v();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView
    public void C() {
        super.C();
        this.T.o();
        this.U = 0.0f;
        this.V = 0.0f;
    }

    protected com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f J() {
        return new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f(this);
    }

    public com.tencent.aelight.camera.aioeditor.capture.data.k K() {
        return this.f68142c0;
    }

    public int L() {
        return this.W;
    }

    public com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f M() {
        return this.T;
    }

    public boolean N() {
        return this.f68140a0;
    }

    public void O(int i3, int i16) {
        int i17 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i18 = getContext().getResources().getDisplayMetrics().heightPixels;
        int i19 = EditPicRawImage.Q;
        if (i19 != 0) {
            i18 = i19;
        }
        ms.a.f("DoodleEditView", "w: " + i3 + " h: " + i16 + " width: " + i17 + " height: " + i18);
        if (i17 > i3) {
            this.U = (i17 - i3) / 2.0f;
        }
        if (i18 > i16) {
            this.V = (i18 - i16) / 2.0f;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f.a
    public void a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        DoodleLayout doodleLayout = this.K;
        if (doodleLayout != null) {
            doodleLayout.t1(z16, z17, z18, z19, z26);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f.a
    public void c(c.a aVar) {
        FaceLayer l06;
        EditVideoParams editVideoParams;
        FaceLayer l07;
        if (aVar instanceof FaceLayer.b) {
            FaceLayer.b bVar = (FaceLayer.b) aVar;
            if (bVar.E) {
                EditVideoParams editVideoParams2 = this.f68239m;
                if (editVideoParams2 != null && editVideoParams2.s()) {
                    l07 = this.K.d0();
                } else {
                    l07 = this.K.l0();
                }
                l07.f67958b0.remove(bVar);
            } else {
                if (bVar.K == 1 && ((editVideoParams = this.f68239m) == null || editVideoParams.s())) {
                    l06 = this.K.d0();
                } else {
                    l06 = this.K.l0();
                }
                List<String> list = l06.f67957a0.get(bVar.f67965z);
                if (list != null) {
                    list.remove(bVar.A);
                }
            }
            this.T.J();
        } else if (aVar instanceof g.c) {
            this.T.J();
        } else {
            this.T.J();
        }
        this.K.l1();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f.a
    public void d(c.a aVar, int i3, int i16, float f16, float f17) {
        DynamicTextItem dynamicTextItem;
        if (!(aVar instanceof g.c) || (dynamicTextItem = ((g.c) aVar).f68001z) == null) {
            return;
        }
        if (!dynamicTextItem.F() && i16 == 0) {
            i16 = 3;
        }
        if (i16 == 0) {
            dynamicTextItem.P();
            dynamicTextItem.d(-1, this.K.f68172u0, false, 3000, 500, null);
            return;
        }
        if (i16 == 2) {
            dynamicTextItem.O(i3, true);
            if (i3 == -1) {
                i3 = 0;
            }
            this.K.H1(dynamicTextItem, i3, 1);
            return;
        }
        if (i16 != 3) {
            return;
        }
        if (i3 == -1) {
            i3 = 0;
        }
        dynamicTextItem.O(i3, true);
        this.K.H1(dynamicTextItem, i3, 2);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.L) {
            canvas.save();
            float f16 = this.U;
            if (f16 > 0.0f || this.V > 0.0f) {
                canvas.translate(f16, this.V);
            }
            this.T.d(canvas);
            canvas.restore();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        if (this.U > 0.0f || this.V > 0.0f) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation(motionEvent.getX() - this.U, motionEvent.getY() - this.V);
            motionEvent = obtain;
            z16 = true;
        } else {
            z16 = false;
        }
        if (motionEvent.getAction() == 0 && this.T.a(motionEvent)) {
            this.f68143d0 = true;
        }
        if (this.f68143d0) {
            z17 = this.T.D(motionEvent);
            invalidate();
        } else {
            H();
            z17 = false;
        }
        if (motionEvent.getAction() == 1) {
            this.f68143d0 = false;
        }
        if (z16) {
            motionEvent.recycle();
        }
        return z17;
    }

    public void setDoodleEditViewListener(b bVar) {
        this.f68141b0 = bVar;
    }

    public void setFrom(int i3) {
        this.W = i3;
    }

    public void setOnLayerTouchListener() {
        this.T.y(this.K.N0);
        this.T.M(this);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView
    protected void v() {
        this.T = J();
        setLayerType(1, null);
        this.f68142c0 = new a();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView
    public void w(EditVideoParams editVideoParams) {
        this.f68239m = editVideoParams;
    }

    public void H() {
        I(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.aelight.camera.aioeditor.capture.data.k {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void c() {
            DoodleEditView.this.T.J();
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void d(vr.a aVar, float f16, float f17, float f18, String str, SegmentKeeper segmentKeeper) {
            h(aVar, f16, f17, f18, str, segmentKeeper);
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void e(vr.a aVar, float f16, float f17, float f18, String str, SegmentKeeper segmentKeeper) {
            h(aVar, f16, f17, f18, str, segmentKeeper);
        }

        private void h(vr.a aVar, float f16, float f17, float f18, String str, SegmentKeeper segmentKeeper) {
            if (DoodleEditView.this.T.G()) {
                DoodleEditView.this.T.K(DoodleEditView.this.K.l0().P(DoodleEditView.this.T.F(), aVar.f443181a, aVar.f443182b, aVar.f443183c, zr.b.g(aVar, f16, f17, f18), str, aVar.f443184d, false, null, null, DoodleEditView.this.L()));
                DoodleEditView.this.postInvalidate();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void b(e.a aVar, float f16, float f17, float f18) {
            File fileInLocal;
            if (DoodleEditView.this.T.G()) {
                FaceLayer.d d16 = zr.b.d(aVar, DoodleEditView.this.getWidth(), DoodleEditView.this.getHeight(), f16, f17);
                if (d16 != null) {
                    Drawable drawable = aVar.f406050e;
                    if (drawable != null && (drawable instanceof URLDrawable) && (fileInLocal = ((URLDrawable) drawable).getFileInLocal()) != null && fileInLocal.exists()) {
                        DoodleEditView.this.T.K(DoodleEditView.this.K.l0().P(DoodleEditView.this.T.F(), aVar.f406054i, aVar.f406048c, aVar.f406050e, d16, fileInLocal.getAbsolutePath(), aVar.f406055j, false, null, null, DoodleEditView.this.L()));
                    }
                } else {
                    hd0.c.g("DoodleEditView", "create FaceLayer.ItemParams failed.");
                }
                DoodleEditView.this.postInvalidate();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(d.c cVar, String str, float f16, float f17, float f18) {
            Drawable drawable;
            float f19;
            float f26;
            float f27;
            c.a P;
            if (!DoodleEditView.this.T.G() || cVar == null) {
                return;
            }
            hd0.c.a("DoodleEditView", "addLocationFaceItem:" + cVar.toString());
            boolean z16 = DoodleEditView.this.getContext() instanceof EditPicActivity;
            if (z16) {
                cVar.f406037p = 0;
            } else {
                cVar.f406037p = 3;
            }
            ir.i c16 = hr.c.c(cVar, DoodleEditView.this.getContext(), -1L);
            if (z16) {
                if (c16 != null) {
                    drawable = new BitmapDrawable(DoodleEditView.this.getContext().getResources(), c16.h());
                    if (drawable == null) {
                        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleEditView", 2, "[" + drawable.getIntrinsicWidth() + "," + drawable.getIntrinsicHeight() + "]");
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleEditView", 2, "x:" + f16);
                        }
                        c.a aVar = DoodleEditView.this.T.K;
                        if (aVar instanceof FaceLayer.b) {
                            FaceLayer.b bVar = (FaceLayer.b) aVar;
                            if (bVar.f453046b > 4.0d) {
                                bVar.f453046b = 1.0f;
                            }
                            f19 = (bVar.f453045a.x - ((bVar.f453046b * drawable.getIntrinsicWidth()) / 2.0f)) + bVar.f453048d;
                            float f28 = bVar.f453045a.x;
                            if (f19 < ScreenUtil.dip2px(23.0f)) {
                                f28 = ScreenUtil.dip2px(23.0f) + (bVar.f453045a.x - f19);
                            }
                            f26 = f28;
                        } else {
                            f19 = 0.0f;
                            f26 = 0.0f;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleEditView", 2, "startX:" + f19 + "x:" + f16);
                        }
                        FaceLayer.d dVar = new FaceLayer.d(f16, f17, f18, 0.0f, 0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        String str2 = TextUtils.isEmpty(str) ? cVar.f406024c : str;
                        if (drawable instanceof ir.i) {
                            f27 = f26;
                            P = DoodleEditView.this.K.d0().P(DoodleEditView.this.T.F(), cVar.f406042u, str2, drawable, dVar, "", cVar.f406037p, cVar.f406038q, cVar.f406039r, ((ir.i) drawable).g(), DoodleEditView.this.L());
                        } else {
                            f27 = f26;
                            cVar.f406037p = 0;
                            P = DoodleEditView.this.K.l0().P(DoodleEditView.this.T.F(), cVar.f406042u, str2, drawable, dVar, "", cVar.f406037p, false, cVar.f406039r, null, DoodleEditView.this.L());
                        }
                        if (P instanceof FaceLayer.b) {
                            c.a aVar2 = DoodleEditView.this.T.K;
                            if (aVar2 instanceof FaceLayer.b) {
                                ((FaceLayer.b) P).J = ((FaceLayer.b) aVar2).J;
                            }
                        }
                        DoodleEditView.this.T.K(P);
                        P.f453045a.x = f27;
                        DoodleEditView.this.postInvalidate();
                        return;
                    }
                    return;
                }
                c16 = null;
            }
            drawable = c16;
            if (drawable == null) {
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void g(String str, String str2) {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void f(e.a aVar, float f16, float f17, float f18, SegmentKeeper segmentKeeper) {
        }
    }

    public void I(boolean z16) {
        DynamicTextItem dynamicTextItem;
        EditVideoParams editVideoParams;
        if (z16) {
            removeCallbacks(this.f68144e0);
        }
        if (z16 || (!z16 && getVisibility() == 0)) {
            if (this.T.G()) {
                c.a F = this.T.F();
                F.f453057m = false;
                if (F instanceof FaceLayer.b) {
                    FaceLayer faceLayer = (FaceLayer) this.K.f68171t0.t(FaceLayer.f67956d0);
                    FaceLayer.b bVar = (FaceLayer.b) F;
                    int i3 = bVar.K;
                    if ((i3 == 1 || i3 == 3) && ((editVideoParams = this.f68239m) == null || editVideoParams.s())) {
                        faceLayer = (FaceLayer) this.K.f68171t0.t("DynamicFaceLayer");
                        bVar.f67963x.setCallback(this.K.f68171t0);
                    }
                    if (faceLayer != null) {
                        faceLayer.K.add(bVar);
                    }
                } else if (F instanceof g.c) {
                    g.c cVar = (g.c) F;
                    DynamicTextItem dynamicTextItem2 = cVar.f68001z;
                    if (dynamicTextItem2 != null) {
                        dynamicTextItem2.O(-1, false);
                    }
                    com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g gVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g) this.K.f68171t0.t(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67980d0);
                    if (gVar != null && (dynamicTextItem = cVar.f68001z) != null) {
                        if (!dynamicTextItem.E() && dynamicTextItem.C()) {
                            dynamicTextItem.L(true);
                        }
                        if (!dynamicTextItem.D()) {
                            gVar.X.add(cVar);
                        }
                    }
                }
                this.K.f68171t0.invalidate();
            }
            this.T.J();
            setVisibility(8);
            b bVar2 = this.f68141b0;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.x
    public void b(boolean z16) {
        if (z16) {
            setVisibility(4);
        } else {
            postDelayed(this.f68144e0, com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67986j0);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f.a
    public void e(c.a aVar) {
        if (aVar == null) {
            return;
        }
        this.K.c1();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f.a
    public void f(c.a aVar, int i3, int i16) {
        b bVar;
        if (aVar == null || this.K.c1()) {
            return;
        }
        if (aVar instanceof g.c) {
            d(aVar, i3, i16, 0.0f, 0.0f);
        } else if (((aVar instanceof FaceLayer.b) || (aVar instanceof FaceLayer.a)) && (bVar = this.f68141b0) != null) {
            bVar.a(aVar);
        }
    }
}
