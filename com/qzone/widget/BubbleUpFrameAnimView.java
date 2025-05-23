package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.qzone.widget.util.FrameAnimEndListener;
import com.qzone.widget.util.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public class BubbleUpFrameAnimView extends View {
    public static final int ANIM_POSITION_MID = 1;
    public static final int ANIM_POSITION_MID_TOP = 0;
    private int C;
    private boolean D;
    private boolean E;
    private e F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.widget.util.c f60177d;

    /* renamed from: e, reason: collision with root package name */
    private c.d f60178e;

    /* renamed from: f, reason: collision with root package name */
    private int f60179f;

    /* renamed from: h, reason: collision with root package name */
    private int f60180h;

    /* renamed from: i, reason: collision with root package name */
    private int f60181i;

    /* renamed from: m, reason: collision with root package name */
    private Rect f60182m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements c.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f60183d;

        a(int i3) {
            this.f60183d = i3;
        }

        @Override // com.qzone.widget.util.c.d
        public void a(int i3) {
            if (BubbleUpFrameAnimView.this.f60179f != 0 && BubbleUpFrameAnimView.this.f60177d != null) {
                int j3 = (this.f60183d + BubbleUpFrameAnimView.this.C) - ((BubbleUpFrameAnimView.this.f60179f * i3) / BubbleUpFrameAnimView.this.f60177d.j());
                BubbleUpFrameAnimView.this.f60182m.top = j3;
                BubbleUpFrameAnimView.this.f60182m.bottom = j3 + BubbleUpFrameAnimView.this.f60181i;
            }
            BubbleUpFrameAnimView.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements c.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f60185d;

        b(View view) {
            this.f60185d = view;
        }

        @Override // com.qzone.widget.util.c.d
        public void a(int i3) {
            BubbleUpFrameAnimView.this.i(this.f60185d, 1, 0);
            if (BubbleUpFrameAnimView.this.f60179f != 0 && BubbleUpFrameAnimView.this.f60177d != null) {
                int j3 = BubbleUpFrameAnimView.this.f60182m.top - ((BubbleUpFrameAnimView.this.f60179f * i3) / BubbleUpFrameAnimView.this.f60177d.j());
                BubbleUpFrameAnimView.this.f60182m.top = j3;
                BubbleUpFrameAnimView.this.f60182m.bottom = j3 + BubbleUpFrameAnimView.this.f60181i;
            }
            BubbleUpFrameAnimView.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class c implements c.InterfaceC0506c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.InterfaceC0506c f60187d;

        c(c.InterfaceC0506c interfaceC0506c) {
            this.f60187d = interfaceC0506c;
        }

        @Override // com.qzone.widget.util.c.InterfaceC0506c
        public void onEnd() {
            BubbleUpFrameAnimView.this.invalidate();
            c.InterfaceC0506c interfaceC0506c = this.f60187d;
            if (interfaceC0506c != null) {
                interfaceC0506c.onEnd();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class d implements c.InterfaceC0506c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameAnimEndListener f60189d;

        d(FrameAnimEndListener frameAnimEndListener) {
            this.f60189d = frameAnimEndListener;
        }

        @Override // com.qzone.widget.util.c.InterfaceC0506c
        public void onEnd() {
            BubbleUpFrameAnimView.this.invalidate();
            FrameAnimEndListener frameAnimEndListener = this.f60189d;
            if (frameAnimEndListener != null) {
                frameAnimEndListener.onEnd();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface e {
        void a(BubbleUpFrameAnimView bubbleUpFrameAnimView);
    }

    public BubbleUpFrameAnimView(Context context) {
        super(context);
        h(null, 0, 0);
    }

    private void h(AttributeSet attributeSet, int i3, int i16) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jj2.b.N, i3, i16);
        g(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void j(View view, int i3) {
        com.qzone.widget.util.c cVar = this.f60177d;
        if (cVar == null) {
            return;
        }
        this.E = true;
        cVar.r(this.f60178e);
        new PopupWindow().showAsDropDown(view);
        com.qzone.widget.util.c cVar2 = this.f60177d;
        cVar2.t(0, cVar2.j() - 1, i3);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        com.qzone.widget.util.c cVar = this.f60177d;
        if (cVar == null || !cVar.l() || this.f60182m == null) {
            return;
        }
        int i3 = this.G;
        if (i3 > 0) {
            canvas.clipRect(0, i3, getWidth(), getHeight());
        }
        this.f60177d.e(canvas, this.f60182m);
        if (this.E) {
            this.E = false;
            e eVar = this.F;
            if (eVar == null) {
                return;
            }
            eVar.a(this);
            this.F = null;
        }
    }

    public void play(View view) {
        play(view, 0, 0);
    }

    public void resetAnim(String str, int i3, int i16, int i17) {
        com.qzone.widget.util.c cVar = this.f60177d;
        if (cVar != null) {
            cVar.v();
            this.f60177d.n();
            this.f60177d = null;
        }
        Context context = getContext();
        int max = Math.max(1, i3);
        int max2 = Math.max(1, i16);
        if (i17 < 1) {
            i17 = 16;
        }
        this.f60177d = new com.qzone.widget.util.c(context, str, 1, max, max2, i17);
    }

    public void scroll(int i3, int i16) {
        com.qzone.widget.util.c cVar = this.f60177d;
        if (cVar == null || !cVar.l()) {
            return;
        }
        if (i3 == 0 && i16 == 0) {
            return;
        }
        if (this.D) {
            c.d dVar = this.f60178e;
            if (dVar != null) {
                dVar.a(this.f60177d.g());
                return;
            }
            return;
        }
        this.C += i16;
        Rect rect = this.f60182m;
        rect.left += i3;
        rect.right += i3;
        rect.top += i16;
        rect.bottom += i16;
        invalidate();
    }

    public void setOnEndListener(c.InterfaceC0506c interfaceC0506c) {
        com.qzone.widget.util.c cVar = this.f60177d;
        if (cVar == null) {
            interfaceC0506c.onEnd();
        } else {
            cVar.p(new c(interfaceC0506c));
        }
    }

    public void setOnEndListener2(FrameAnimEndListener frameAnimEndListener) {
        com.qzone.widget.util.c cVar = this.f60177d;
        if (cVar == null) {
            frameAnimEndListener.onEnd();
        } else {
            cVar.p(new d(frameAnimEndListener));
        }
    }

    public void setOnStartListener(e eVar) {
        this.F = eVar;
    }

    public void stop() {
        com.qzone.widget.util.c cVar = this.f60177d;
        if (cVar == null) {
            return;
        }
        cVar.v();
        invalidate();
    }

    private void g(TypedArray typedArray) {
        String string;
        int i3;
        int i16;
        Drawable drawable = typedArray.getDrawable(2);
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
            i3 = bitmap2.getWidth();
            i16 = bitmap2.getHeight();
            string = null;
            bitmap = bitmap2;
        } else {
            string = typedArray.getString(3);
            i3 = 0;
            i16 = 0;
        }
        if (bitmap == null && string == null) {
            return;
        }
        int i17 = typedArray.getInt(6, 1);
        int i18 = i17 < 1 ? 1 : i17;
        int i19 = typedArray.getInt(1, 1);
        int i26 = i19 < 1 ? 1 : i19;
        this.f60180h = typedArray.getDimensionPixelSize(5, i3 / i18);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(0, i16 / i26);
        this.f60181i = dimensionPixelSize;
        if (this.f60180h < 1 || dimensionPixelSize < 1) {
            return;
        }
        int i27 = typedArray.getInt(4, 16);
        int i28 = i27 < 1 ? 16 : i27;
        this.f60179f = typedArray.getDimensionPixelSize(7, 0);
        if (bitmap == null) {
            this.f60177d = new com.qzone.widget.util.c(getContext(), string, 1, i18, i26, i28);
        } else {
            this.f60177d = new com.qzone.widget.util.c(bitmap, i18, i26, i28);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(View view, int i3, int i16) {
        int height;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        getLocationOnScreen(iArr2);
        int width = ((iArr[0] - iArr2[0]) + (view.getWidth() / 2)) - (this.f60180h / 2);
        int height2 = (iArr[1] - iArr2[1]) + (view.getHeight() / 2);
        if (i3 == 1) {
            height = this.f60181i / 2;
        } else {
            height2 -= this.f60181i;
            height = view.getHeight() / 2;
        }
        int i17 = (height2 - height) + i16;
        this.f60182m = new Rect(width, i17, this.f60180h + width, this.f60181i + i17);
    }

    public void play(View view, int i3, int i16) {
        play(view, i3, i16, 0, 0);
    }

    public void playAim(View view, int i3, int i16) {
        this.D = true;
        this.G = i16;
        this.f60178e = new b(view);
        j(view, i3);
    }

    public BubbleUpFrameAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(attributeSet, 0, 0);
    }

    public void play(View view, int i3, int i16, int i17, int i18) {
        this.D = false;
        this.G = i18;
        i(view, i3, i16);
        this.C = 0;
        this.f60178e = new a(this.f60182m.top);
        j(view, i17);
    }

    public BubbleUpFrameAnimView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        h(attributeSet, i3, 0);
    }

    public void resetAnimSize(int i3, int i16, int i17) {
        if (i3 < 1 || i16 < 1) {
            return;
        }
        com.qzone.widget.util.c cVar = this.f60177d;
        if (cVar == null || !cVar.l()) {
            this.f60180h = i3;
            this.f60181i = i16;
            this.f60179f = i17;
        }
    }

    public BubbleUpFrameAnimView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        h(attributeSet, i3, i16);
    }
}
