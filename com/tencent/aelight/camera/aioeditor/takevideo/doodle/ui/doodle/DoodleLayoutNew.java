package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanelNew;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleLayoutNew extends DoodleLayout {
    private static final int X0 = DoodlePanelNew.I[0];
    private DoodlePanel.PenMode W0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements DoodlePanel.c {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void a(int i3) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = DoodleLayoutNew.this.r0();
            if (r06 != null) {
                DoodleLayoutNew.this.T1(i3);
                DoodleLayoutNew.this.U1(i3);
                DoodleLayoutNew.this.V0();
                if (r06.N()) {
                    ms.a.f("DoodleLayout", "onSelectColor when in mosaic mode, change to the before mode: ");
                    DoodleLayoutNew.this.S(DoodlePanel.PenMode.FREE_DRAW);
                }
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void b() {
            DoodleLayoutNew.this.R1();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void c(float f16) {
            if (DoodleLayoutNew.this.r0() != null) {
                DoodleLayoutNew.this.V1(f16);
                DoodleLayoutNew.this.W1(f16);
                DoodleLayoutNew.this.V0();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void d(DoodlePanel.PenMode penMode) {
            if (DoodleLayoutNew.this.S(penMode)) {
                DoodleLayoutNew.this.m1();
            } else if (DoodleLayoutNew.this.T(penMode)) {
                DoodleLayoutNew.this.p1();
            }
            DoodleLayoutNew.this.W0 = penMode;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void onFinish() {
            DoodleLayoutNew.this.g1(0);
            if (DoodleLayoutNew.this.f68171t0.B()) {
                return;
            }
            DoodleLayoutNew.this.f68171t0.G();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements DoodleShapePanel.d {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel.d
        public void a(int i3) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = DoodleLayoutNew.this.x0();
            if (x06 != null) {
                x06.I().B(i3);
                DoodleLayoutNew.this.V0();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel.d
        public void b() {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = DoodleLayoutNew.this.x0();
            if (x06 != null) {
                x06.I().k();
                DoodleLayoutNew.this.V0();
                DoodleLayoutNew.this.J0();
                DoodleLayoutNew doodleLayoutNew = DoodleLayoutNew.this;
                if (doodleLayoutNew.H0 == 9) {
                    doodleLayoutNew.L1();
                }
                DoodleLayoutNew doodleLayoutNew2 = DoodleLayoutNew.this;
                doodleLayoutNew2.g1(doodleLayoutNew2.H0);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel.d
        public void c(float f16) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = DoodleLayoutNew.this.x0();
            if (x06 != null) {
                x06.I().C(f16);
                DoodleLayoutNew.this.V0();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68233a;

        static {
            int[] iArr = new int[DoodlePanel.PenMode.values().length];
            f68233a = iArr;
            try {
                iArr[DoodlePanel.PenMode.RECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68233a[DoodlePanel.PenMode.OVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68233a[DoodlePanel.PenMode.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68233a[DoodlePanel.PenMode.ARROW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DoodleLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r0 < 0.01f) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Y1() {
        EditPicRawImage f06 = f0();
        if (f06 != null) {
            float o06 = f06.o0();
            float n06 = f06.n0();
            float q06 = f06.q0();
            float f16 = q06 - n06;
            float f17 = 0.0f;
            if (f16 <= 0.0f) {
                QLog.e("DoodleLayout", 1, "handleDoodleViewScale error, scaleLength <= 0!");
                return;
            }
            float f18 = q06 - o06;
            float f19 = f18 >= -0.01f ? 0.01f : -0.01f;
            f18 = f19;
            if (f18 > 0.0f) {
                f17 = DoodleLayout.V0 * (f18 / f16);
            } else if (f18 < 0.0f) {
                f17 = DoodleLayout.V0 / ((-f18) / f16);
            }
            V1(f17);
            W1(f17);
            return;
        }
        QLog.d("DoodleLayout", 1, "handleDoodleViewScale error, editPicRawImage is null!");
    }

    private void a2() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null) {
            return;
        }
        hd0.c.a("DoodleLayout", "undo, activeLayer:" + this.f68171t0.o() + ",pathCount:" + r06.L.m());
        r06.b0();
    }

    private void c2() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 != null) {
            x06.I().G();
            x06.n();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected int A0() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public void D1(int i3) {
        super.D1(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public DynamicTextItem I() {
        DynamicTextItem I = super.I();
        if (I != null) {
            I.M(0, getResources().getString(R.string.f174442vv));
        }
        return I;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected void K0() {
        I0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected void L1() {
        G1();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected void M0() {
        DoodlePanel doodlePanel = this.f68166o0;
        DoodlePanel.PenMode penMode = DoodlePanel.PenMode.FREE_DRAW;
        int i3 = X0;
        float f16 = DoodleLayout.V0;
        doodlePanel.c(penMode, i3, f16);
        this.f68167p0.c(DoodlePanel.PenMode.RECT, i3, f16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected EditTextDialog Q() {
        return new com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.a(super.getContext());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public void R1() {
        N();
        if (this.H0 == 9) {
            c2();
        } else {
            a2();
        }
    }

    public void Z1() {
        int i3;
        DoodlePanel.PenMode penMode = this.W0;
        if (penMode != null && penMode != DoodlePanel.PenMode.FREE_DRAW && ((i3 = c.f68233a[penMode.ordinal()]) == 1 || i3 == 2 || i3 == 3 || i3 == 4)) {
            p1();
        } else {
            m1();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 6 || action == 3) {
            Y1();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected int e0() {
        return 200;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public void h1(int i3, Object obj) {
        super.h1(i3, obj);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected int i0() {
        return R.layout.hci;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public void m1() {
        N();
        hd0.c.a("DoodleLayout", "onLinePressed, buttonState:" + this.H0 + ",activeLayer:" + this.f68171t0.o());
        id0.b.k("0X80076B8", id0.b.f407535d);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 != null) {
            x06.I().i();
        }
        G1();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null) {
            return;
        }
        r06.t(true);
        r06.U(false);
        R0();
        if (r06.L.m() > 0) {
            this.f68165n0.setUndoViewEnable(true);
        } else {
            this.f68165n0.setUndoViewEnable(false);
        }
        this.f68166o0.setUndoEnabled(r06.L.m() > 0);
        int i3 = this.H0;
        if (i3 == 3) {
            D1(2);
            this.F0.e0(false);
            DoodleEditView doodleEditView = this.f68172u0;
            if (doodleEditView != null) {
                doodleEditView.I(true);
                return;
            }
            return;
        }
        if (i3 == 1) {
            F1(this.f68171t0);
            setDoodleGLViewVisibility(0);
        }
        D1(2);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected int p0() {
        return R.layout.e6e;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public void p1() {
        N();
        hd0.c.a("DoodleLayout", "onShapePressed, buttonState:" + this.H0 + ",activeLayer:" + this.f68171t0.o());
        id0.b.k("0X80076B8", id0.b.f407535d);
        L1();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 != null) {
            x06.t(true);
            x06.L(false);
            x06.I().o();
        }
        R0();
        this.f68166o0.setUndoEnabled(true);
        int i3 = this.H0;
        if (i3 == 3) {
            D1(9);
            this.F0.e0(false);
            DoodleEditView doodleEditView = this.f68172u0;
            if (doodleEditView != null) {
                doodleEditView.I(true);
                return;
            }
            return;
        }
        if (i3 == 1) {
            F1(this.f68171t0);
            setDoodleGLViewVisibility(0);
        }
        D1(9);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected float v0(float f16) {
        return f16 * 3.2f;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected DoodleLayout.w z0() {
        return new DoodleLayout.w(this.D, new gr.a(this.f68171t0), new FaceLayer(this.f68171t0), new DynamicFaceLayer(this.f68171t0), new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c(this.f68171t0), new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.e(this.f68171t0), new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.h(this.f68171t0));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public void H1(DynamicTextItem dynamicTextItem, int i3, int i16) {
        super.I1(dynamicTextItem, i3, i16, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public void M1(boolean z16, boolean z17) {
        super.M1(z16, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    public void N1(boolean z16, boolean z17) {
        super.N1(z16, false);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected void L0() {
        DoodlePanel doodlePanel = (DoodlePanel) findViewById(R.id.ukc);
        this.f68166o0 = doodlePanel;
        doodlePanel.setPanelListener(new a());
        this.f68167p0 = (DoodlePanel) findViewById(R.id.ukd);
        DoodleShapePanel doodleShapePanel = (DoodleShapePanel) findViewById(R.id.uke);
        this.f68168q0 = doodleShapePanel;
        doodleShapePanel.setPanelListener(new b());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
    protected void K1(q qVar) {
    }
}
