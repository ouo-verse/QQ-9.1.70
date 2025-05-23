package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b;
import com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class PickerBarLayout extends RelativeLayout implements b.k, d.f {
    private float C;
    private float D;
    private float E;
    private float F;
    private List<String> G;
    private View H;
    private d I;
    private View J;
    private com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b K;
    private int L;
    private WeakReference<b> M;
    private float N;
    private int P;
    private CheckForLongPress Q;
    boolean R;

    /* renamed from: d, reason: collision with root package name */
    private a f68849d;

    /* renamed from: e, reason: collision with root package name */
    private float f68850e;

    /* renamed from: f, reason: collision with root package name */
    private float f68851f;

    /* renamed from: h, reason: collision with root package name */
    private float f68852h;

    /* renamed from: i, reason: collision with root package name */
    private float f68853i;

    /* renamed from: m, reason: collision with root package name */
    private float f68854m;

    /* loaded from: classes32.dex */
    class CheckForLongPress implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f68855d;

        CheckForLongPress() {
        }

        public void e() {
            this.f68855d = PickerBarLayout.this.getWindowAttachCount();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PickerBarLayout.this.getParent() == null || this.f68855d != PickerBarLayout.this.getWindowAttachCount()) {
                return;
            }
            PickerBarLayout pickerBarLayout = PickerBarLayout.this;
            pickerBarLayout.R = true;
            pickerBarLayout.getParent().requestDisallowInterceptTouchEvent(true);
            PickerBarLayout.this.sendAccessibilityEvent(2);
            PickerBarLayout pickerBarLayout2 = PickerBarLayout.this;
            pickerBarLayout2.D(pickerBarLayout2.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public class a extends ExploreByTouchHelper {
        public a(View view) {
            super(view);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            if (PickerBarLayout.this.z(f16)) {
                return PickerBarLayout.this.u(f17);
            }
            return Integer.MIN_VALUE;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(RelativeLayout.class.getName());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(a(i3));
            accessibilityEvent.setClassName(Button.class.getName());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setContentDescription(a(i3));
            accessibilityNodeInfoCompat.setClassName(Button.class.getName());
            accessibilityNodeInfoCompat.addAction(16);
            Rect rect = new Rect();
            if (PickerBarLayout.this.K != null && PickerBarLayout.this.K.U(i3) != null) {
                RectF U = PickerBarLayout.this.K.U(i3);
                rect.set(Math.round(U.left), Math.round(U.top), Math.round(U.right), Math.round(U.bottom));
            } else {
                QLog.e("PickerBarLayout", 1, "mGroundDrawable is null, virtualViewId=" + i3);
                rect = new Rect(0, 0, 1, 1);
            }
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int i3 = 0; i3 < PickerBarLayout.this.G.size(); i3++) {
                list.add(Integer.valueOf(i3));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (i16 != 16) {
                return false;
            }
            PickerBarLayout.this.C(i3, true);
            PickerBarLayout.this.t(i3, false, false);
            return true;
        }

        private String a(int i3) {
            if (i3 == 0) {
                return HardCodeUtil.qqStr(R.string.m2j);
            }
            if (i3 == 1) {
                return HardCodeUtil.qqStr(R.string.m2f);
            }
            if (i3 == 2) {
                return HardCodeUtil.qqStr(R.string.m1u);
            }
            if (i3 == 3) {
                return HardCodeUtil.qqStr(R.string.lz9);
            }
            if (i3 == 4) {
                return HardCodeUtil.qqStr(R.string.f171941m33);
            }
            if (i3 != 5) {
                return "";
            }
            return HardCodeUtil.qqStr(R.string.ly_);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public interface b {
        void a(int i3);

        void b(int i3);

        void c(int i3);

        void d(int i3);

        void e(int i3, String str, boolean z16, boolean z17);
    }

    public PickerBarLayout(Context context) {
        super(context);
        this.f68850e = 38.0f;
        this.f68851f = 50.0f;
        this.f68852h = 18.0f;
        this.f68853i = 146.0f;
        this.f68854m = 102.0f;
        this.C = 22.0f;
        this.D = 22.0f;
        this.E = 4.0f;
        this.F = 36.0f;
        this.G = new ArrayList();
        this.L = -1;
    }

    private int A(float f16) {
        this.N = f16;
        int u16 = u(f16);
        if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "movemark posY:" + f16 + " markindex:" + u16 + "  curIndex:" + this.P);
        }
        if (u16 != this.P) {
            this.P = u16;
            t(u16, false, false);
        }
        setMarkText(this.P);
        if (this.R) {
            f16 -= this.F;
        }
        B(f16);
        invalidate();
        return this.P;
    }

    private void B(float f16) {
        RelativeLayout.LayoutParams layoutParams;
        View view = this.H;
        if (view != null && (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) != null) {
            float f17 = this.f68854m;
            float f18 = this.C;
            if (f16 < (f17 / 2.0f) + f18) {
                f16 = (f17 / 2.0f) + f18;
            } else if (f16 > (getHeight() - (this.f68854m / 2.0f)) - this.D) {
                f16 = (getHeight() - (this.f68854m / 2.0f)) - this.D;
            }
            layoutParams.topMargin = Math.round(f16 - (this.f68854m / 2.0f));
            layoutParams.bottomMargin = Math.round(-this.f68854m);
        }
        requestLayout();
    }

    private void F(Context context) {
        this.f68850e = PickerContainer.r(context, this.f68850e);
        this.f68851f = PickerContainer.r(context, this.f68851f);
        this.f68852h = PickerContainer.r(context, this.f68852h);
        this.f68853i = PickerContainer.r(context, this.f68853i);
        this.f68854m = PickerContainer.r(context, this.f68854m);
        this.E = PickerContainer.r(context, this.E);
        this.C = PickerContainer.r(context, this.C);
        this.D = PickerContainer.r(context, this.D);
        this.F = PickerContainer.r(context, this.F);
    }

    private float r() {
        return ((Math.round(this.f68852h) - this.f68852h) - (Math.round(this.E) - this.E)) + (Math.round(this.f68851f) - this.f68851f);
    }

    private void s(int i3, boolean z16, boolean z17) {
        b bVar;
        WeakReference<b> weakReference = this.M;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        if (z16) {
            if (z17) {
                bVar.c(i3);
                return;
            } else {
                bVar.a(i3);
                return;
            }
        }
        if (z17) {
            bVar.b(i3);
        } else {
            bVar.d(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(float f16) {
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar = this.K;
        if (bVar != null) {
            return bVar.m0(f16);
        }
        return -1;
    }

    private void x() {
        this.J = new View(getContext());
        this.K = new com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b();
        float r16 = r();
        this.K.Y(getContext(), this.G.size(), ((Math.round(this.f68851f) - this.f68850e) / 2.0f) + r16, ((Math.round(this.f68851f) - this.f68850e) / 2.0f) - r16, this);
        this.J.setBackground(this.K);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(this.f68851f), -1);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, Math.round(this.f68852h), 0);
        addView(this.J, layoutParams);
    }

    private void y() {
        this.H = new View(getContext());
        d dVar = new d();
        this.I = dVar;
        dVar.D(getContext(), R.drawable.f160612ls, R.drawable.f160611lr, R.drawable.f160613lt, this);
        this.H.setBackground(this.I);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(this.f68853i), Math.round(this.f68854m));
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, Math.round(this.E), 0);
        addView(this.H, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(float f16) {
        return (((float) getWidth()) - this.f68852h) - this.f68851f <= f16;
    }

    public void C(int i3, boolean z16) {
        this.P = i3;
        setMarkText(i3);
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar = this.K;
        if (bVar != null) {
            bVar.Z(this.P, true, z16);
        }
        invalidate();
    }

    public void D(float f16) {
        if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "startenter:" + f16);
        }
        this.N = f16;
        int u16 = u(f16);
        this.P = u16;
        t(u16, true, false);
        d dVar = this.I;
        if (dVar == null || this.K == null) {
            return;
        }
        int z16 = dVar.z();
        boolean isRunning = this.I.isRunning();
        int M = this.K.M();
        boolean isRunning2 = this.K.isRunning();
        if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "drawable state, markdrawble:" + z16 + " isrun:" + isRunning + "  groundrawable:" + M + " isrun:" + isRunning2);
        }
        if (z16 == 1 && M == 0) {
            this.I.stop();
            this.I.H(6);
            this.I.start();
            this.K.stop();
            this.K.a0(1);
            this.K.start();
            return;
        }
        if (z16 == 4) {
            this.I.stop();
            this.I.H(2);
            this.I.start();
            return;
        }
        if (M == 3) {
            this.K.stop();
            this.K.a0(1);
            this.K.start();
            return;
        }
        if (z16 == 5) {
            this.I.stop();
            this.I.H(6);
            this.I.start();
            this.K.stop();
            this.K.a0(1);
            this.K.start();
            return;
        }
        if (M == 4) {
            this.K.stop();
            this.K.a0(1);
            this.K.start();
        } else if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "startenter: state not process!!");
        }
    }

    public void E(float f16) {
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar;
        if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "startleave:" + f16);
        }
        this.N = f16;
        int A = A(f16);
        if (A != this.P) {
            this.P = A;
        }
        t(this.P, false, true);
        if (this.I == null || (bVar = this.K) == null) {
            return;
        }
        bVar.Z(this.P, false, false);
        int z16 = this.I.z();
        boolean isRunning = this.I.isRunning();
        int M = this.K.M();
        boolean isRunning2 = this.K.isRunning();
        if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "drawable state, markdrawble:" + z16 + " isrun:" + isRunning + "  groundrawable:" + M + " isrun:" + isRunning2);
        }
        if (z16 == 3 && M == 2) {
            this.I.stop();
            this.I.H(4);
            this.I.start();
        } else if (M == 1) {
            this.K.stop();
            this.K.a0(3);
            this.K.start();
        } else if (z16 == 2) {
            this.I.stop();
            this.I.H(4);
            this.I.start();
        } else if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "startleave: state not process!!");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b.k
    public void e(int i3, int i16, RectF rectF) {
        if (this.K == null || rectF == null) {
            return;
        }
        B(rectF.centerY());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b.k
    public void f(int i3) {
        d dVar = this.I;
        if (dVar != null) {
            dVar.stop();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float y16;
        RectF T;
        int findPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.L = motionEvent.getPointerId(0);
            if (!z(motionEvent.getX())) {
                return false;
            }
            this.N = motionEvent.getY();
            this.R = false;
            if (this.Q == null) {
                this.Q = new CheckForLongPress();
            }
            this.Q.e();
            postDelayed(this.Q, ViewConfiguration.getLongPressTimeout());
        } else if (action == 1) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.L);
            if (findPointerIndex2 == -1) {
                if (QLog.isColorLevel()) {
                    QLog.d("PickerBarLayout", 2, "ACTION_UP with activePointerIndex = -1");
                }
                y16 = motionEvent.getY();
            } else {
                y16 = motionEvent.getY(findPointerIndex2);
            }
            if (!this.R) {
                CheckForLongPress checkForLongPress = this.Q;
                if (checkForLongPress != null) {
                    removeCallbacks(checkForLongPress);
                }
                com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar = this.K;
                if (bVar != null && (T = bVar.T(y16)) != null) {
                    A(T.centerY());
                    C(this.P, true);
                }
            } else {
                E(y16);
                this.L = -1;
                this.R = false;
            }
        } else if (action == 2) {
            int findPointerIndex3 = motionEvent.findPointerIndex(this.L);
            if (findPointerIndex3 != -1) {
                float y17 = motionEvent.getY(findPointerIndex3);
                if (this.R) {
                    A(y17);
                }
            }
        } else if (action == 3 && (findPointerIndex = motionEvent.findPointerIndex(this.L)) != -1) {
            motionEvent.getY(findPointerIndex);
            E(motionEvent.getY());
            this.L = -1;
            this.R = false;
        }
        return true;
    }

    public int v() {
        return this.G.size();
    }

    public boolean w(EditVideoParams editVideoParams, Context context, b bVar) {
        this.M = new WeakReference<>(bVar);
        F(context);
        this.G.add("4x");
        this.G.add("2x");
        this.G.add("1x");
        if (editVideoParams.j()) {
            this.G.add("1/2");
            this.G.add("1/4");
        }
        if (editVideoParams.g()) {
            this.G.add(PickerContainer.N);
        }
        x();
        y();
        a aVar = new a(this);
        this.f68849d = aVar;
        ViewCompat.setAccessibilityDelegate(this, aVar);
        return true;
    }

    public void G() {
        this.M = null;
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar = this.K;
        if (bVar != null) {
            bVar.stop();
        }
        d dVar = this.I;
        if (dVar != null) {
            dVar.stop();
        }
        this.G.clear();
        this.H = null;
        d dVar2 = this.I;
        if (dVar2 != null) {
            dVar2.R();
            this.I = null;
        }
        this.J = null;
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar2 = this.K;
        if (bVar2 != null) {
            bVar2.o0();
            this.K = null;
        }
        this.L = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3, boolean z16, boolean z17) {
        WeakReference<b> weakReference;
        b bVar;
        if (i3 < 0 || i3 >= this.G.size() || (weakReference = this.M) == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.e(i3, this.G.get(i3), z16, z17);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.d.f
    public void b(int i3) {
        s(i3, false, true);
    }

    public void setMarkText(int i3) {
        d dVar;
        if (i3 < 0 || i3 > this.G.size() || (dVar = this.I) == null) {
            return;
        }
        dVar.K(this.G.get(i3));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.d.f
    public void i(int i3, int i16, int i17) {
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar;
        RectF T;
        if (i3 != 4 || (bVar = this.K) == null || i17 == 0 || (T = bVar.T(this.N)) == null) {
            return;
        }
        float centerY = T.centerY();
        float f16 = this.N;
        float f17 = this.F;
        B((f16 - f17) + ((((centerY - f16) + f17) * (i16 + 1)) / i17));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b.k
    public void a(int i3) {
        d dVar;
        RectF S;
        if (i3 == 1) {
            View view = this.H;
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.K.T(this.N) != null) {
                B(this.N - this.F);
            }
            if (this.I != null) {
                setMarkText(this.P);
                this.I.stop();
                this.I.H(2);
                this.I.start();
            }
        } else if (i3 == 3) {
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar = this.K;
            if (bVar != null && (S = bVar.S()) != null) {
                B(S.centerY());
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            d dVar2 = this.I;
            if (dVar2 != null) {
                dVar2.stop();
                this.I.H(5);
                this.I.start();
            }
        } else if (i3 != 4 && i3 == 0 && (dVar = this.I) != null) {
            dVar.stop();
            this.I.H(1);
            this.I.start();
        }
        s(i3, true, false);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.d.f
    public void d(int i3) {
        if (i3 != 2) {
            if (i3 == 4) {
                com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b bVar = this.K;
                if (bVar != null) {
                    bVar.stop();
                    this.K.a0(3);
                    this.K.start();
                }
            } else if (i3 == 6) {
                B(this.N);
            }
        }
        s(i3, false, false);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b.k
    public void c(int i3) {
        d dVar;
        if (i3 != 1 && i3 != 4 && (dVar = this.I) != null) {
            dVar.stop();
        }
        s(i3, true, true);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b.k
    public void g(int i3, RectF rectF) {
        if ((i3 == 1 || i3 == 4) && rectF != null) {
            B(rectF.centerY());
        }
    }

    public PickerBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68850e = 38.0f;
        this.f68851f = 50.0f;
        this.f68852h = 18.0f;
        this.f68853i = 146.0f;
        this.f68854m = 102.0f;
        this.C = 22.0f;
        this.D = 22.0f;
        this.E = 4.0f;
        this.F = 36.0f;
        this.G = new ArrayList();
        this.L = -1;
    }

    public PickerBarLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f68850e = 38.0f;
        this.f68851f = 50.0f;
        this.f68852h = 18.0f;
        this.f68853i = 146.0f;
        this.f68854m = 102.0f;
        this.C = 22.0f;
        this.D = 22.0f;
        this.E = 4.0f;
        this.F = 36.0f;
        this.G = new ArrayList();
        this.L = -1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.d.f
    public void h(int i3) {
    }
}
