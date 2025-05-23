package com.tencent.qqnt.aio.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.menu.al;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SelectableLinearLayout extends LinearLayout implements nv3.b {
    static IPatchRedirector $redirector_;
    private static final int P;
    private static final int Q;
    private static final int R;
    private int[] C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private a J;
    private b K;
    private nv3.a L;
    private Paint M;
    private final DoubleClickDetector N;

    /* renamed from: d, reason: collision with root package name */
    private boolean f352455d;

    /* renamed from: e, reason: collision with root package name */
    private int f352456e;

    /* renamed from: f, reason: collision with root package name */
    private int f352457f;

    /* renamed from: h, reason: collision with root package name */
    private int f352458h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f352459i;

    /* renamed from: m, reason: collision with root package name */
    private int[] f352460m;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface b {
        void a();

        void b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48581);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
            return;
        }
        P = ViewUtils.dip2px(2.0f);
        Q = ViewUtils.dip2px(18.0f);
        R = ViewUtils.dip2px(5.0f);
    }

    public SelectableLinearLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f352455d = false;
        this.f352456e = -1;
        this.f352457f = -1;
        this.f352458h = -1;
        this.f352459i = new int[]{-1, -1};
        this.f352460m = new int[]{-1, -1};
        this.C = new int[]{-1, -1};
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = false;
        this.I = false;
        this.M = new Paint(1);
        this.N = new DoubleClickDetector(this);
    }

    private void o(Canvas canvas) {
        int[] iArr = this.f352460m;
        int i3 = iArr[0];
        int[] iArr2 = this.f352459i;
        int i16 = iArr2[0];
        int i17 = i3 - i16;
        this.D = i17;
        int i18 = iArr[1];
        int i19 = iArr2[1];
        int i26 = i18 - i19;
        this.E = i26;
        int[] iArr3 = this.C;
        int i27 = iArr3[0] - i16;
        this.F = i27;
        int i28 = iArr3[1] - i19;
        this.G = i28;
        if (i17 != -1 && i26 != -1 && i27 != -1 && i28 != -1) {
            this.H = true;
            Rect rect = new Rect();
            int i29 = this.D;
            int i36 = P;
            int i37 = this.E;
            int i38 = Q;
            rect.set(i29 - i36, i37 - i38, i29, i37);
            canvas.drawRect(rect, this.M);
            float centerX = rect.centerX();
            int i39 = rect.top;
            int i46 = R;
            canvas.drawCircle(centerX, i39 - i46, i46, this.M);
            int i47 = this.F;
            int i48 = this.G;
            rect.set(i47, (i48 - i38) - i46, i36 + i47, i48 - i46);
            canvas.drawRect(rect, this.M);
            canvas.drawCircle(rect.centerX(), rect.bottom + i46, i46, this.M);
            return;
        }
        QLog.eAsync("SelectableLinearLayout", 1, "cursorLocation is invalid");
        this.H = false;
    }

    private int[] p(int i3, int i16, int i17, int i18, int i19, int i26, boolean z16, int i27) {
        int i28 = R;
        int i29 = i17 - (i28 * 3);
        int i36 = i17 + (i28 * 3);
        int i37 = i18 - i19;
        int i38 = i18 + i26;
        if (i3 >= i29 && i3 <= i36 && i16 >= i37 && i16 <= i38 && z16) {
            i16 += i27;
        }
        return new int[]{i3, i16};
    }

    private int r(float f16, float f17) {
        int i3 = this.D;
        int i16 = R;
        int i17 = i3 - (i16 * 3);
        int i18 = i3 + (i16 * 3);
        int i19 = this.E;
        int i26 = Q;
        int i27 = (i19 - i26) - (i16 * 2);
        if (f16 >= i17 && f16 <= i18 && f17 >= i27 && f17 <= i19 && this.H) {
            return 1;
        }
        int i28 = this.F;
        int i29 = i28 - (i16 * 3);
        int i36 = i28 + (i16 * 3);
        int i37 = this.G;
        int i38 = i37 - i26;
        int i39 = i37 + (i16 * 2);
        if (f16 >= i29 && f16 <= i36 && f17 >= i38 && f17 <= i39 && this.H) {
            return 2;
        }
        return -1;
    }

    private void s(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!this.I) {
            int r16 = r(motionEvent.getX(), motionEvent.getY());
            if (r16 != -1 && action == 0) {
                this.I = true;
                this.f352456e = r16;
                a aVar = this.J;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            return;
        }
        if (action != 1 && action != 3) {
            if (action == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i3 = this.f352456e;
                if (i3 == 1) {
                    int i16 = this.D;
                    int i17 = this.E;
                    int i18 = Q;
                    int i19 = R;
                    int[] p16 = p(rawX, rawY, i16, i17, i18 + (i19 * 2), -i18, this.H, i19 * 2);
                    rawX = p16[0];
                    rawY = p16[1];
                } else if (i3 == 2) {
                    int i26 = this.F;
                    int i27 = this.G;
                    int i28 = R;
                    int[] p17 = p(rawX, rawY, i26, i27, 0, i28 * 2, this.H, (-i28) * 2);
                    rawX = p17[0];
                    rawY = p17[1];
                }
                v(rawX, rawY);
                return;
            }
            return;
        }
        this.I = false;
        a aVar2 = this.J;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    private void t(int i3, int i16) {
        h(i3, i16);
        getLocationInWindow(this.f352459i);
        this.f352460m = j(i3);
        this.C = j(i16);
        this.f352457f = i3;
        this.f352458h = i16;
        invalidate();
        QLog.dAsync("SelectableLinearLayout", 1, "selectContent start:" + i3 + " end:" + i16);
    }

    private void v(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int b16 = b(i3, i16);
        if (b16 == -1) {
            return;
        }
        int i27 = this.f352456e;
        if (i27 == 1) {
            i17 = this.f352457f;
        } else {
            i17 = this.f352458h;
        }
        if (b16 == i17) {
            return;
        }
        if (i27 == 1) {
            i18 = this.f352457f;
            if (b16 < i18) {
                i18 = this.f352458h;
                this.f352457f = b16;
            } else if (b16 > i18 && b16 < (i26 = this.f352458h)) {
                this.f352457f = b16;
                i18 = i26;
            } else {
                if (b16 == i18) {
                    b16 = this.f352458h;
                } else {
                    i18 = this.f352458h;
                    if (b16 == i18) {
                        b16 = i18 - 1;
                    } else {
                        this.f352456e = 2;
                    }
                }
                int i28 = i18;
                i18 = b16;
                b16 = i28;
            }
        } else {
            i18 = this.f352458h;
            if (b16 > i18) {
                i18 = this.f352457f;
            } else if (b16 < i18 && b16 > (i19 = this.f352457f)) {
                i18 = b16;
                b16 = i19;
            } else if (b16 == i18) {
                b16 = this.f352457f;
            } else {
                i18 = this.f352457f;
                if (b16 == i18) {
                    b16 = i18 + 1;
                } else {
                    this.f352456e = 1;
                }
            }
            int i282 = i18;
            i18 = b16;
            b16 = i282;
        }
        QLog.iAsync("SelectableLinearLayout", 1, "newStartIndex is " + b16 + " newEndIndex is " + i18);
        t(b16, i18);
    }

    @Override // nv3.a
    public CharSequence a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (CharSequence) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof nv3.a) {
                sb5.append(((nv3.a) childAt).a());
            }
        }
        return sb5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nv3.a
    public int b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int paddingLeft = (i3 - iArr[0]) - getPaddingLeft();
        int paddingTop = (i16 - iArr[1]) - getPaddingTop();
        int childCount = getChildCount();
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt instanceof nv3.a) {
                nv3.a aVar = (nv3.a) childAt;
                if (paddingLeft > childAt.getLeft() && paddingLeft < childAt.getRight() && paddingTop > childAt.getTop() && paddingTop < childAt.getBottom()) {
                    this.L = aVar;
                    return i17 + aVar.b(i3, i16);
                }
                i17 += aVar.contentLength();
            }
        }
        int i19 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            KeyEvent.Callback childAt2 = getChildAt(i26);
            if (childAt2 instanceof nv3.a) {
                nv3.a aVar2 = (nv3.a) childAt2;
                nv3.a aVar3 = this.L;
                if (aVar3 == aVar2) {
                    return i19 + aVar3.b(i3, i16);
                }
                i19 += aVar2.contentLength();
            }
        }
        return -1;
    }

    @Override // nv3.a
    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            KeyEvent.Callback childAt = getChildAt(i16);
            if (childAt instanceof nv3.a) {
                ((nv3.a) childAt).c(i3);
            }
        }
    }

    @Override // nv3.a
    public int contentLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        int childCount = getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            KeyEvent.Callback childAt = getChildAt(i16);
            if (childAt instanceof nv3.a) {
                i3 += ((nv3.a) childAt).contentLength();
            }
        }
        return i3;
    }

    @Override // nv3.b
    public al d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (al) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i3 = iArr[1];
        return new al(j(this.f352457f)[0], j(this.f352458h)[0], i3, getHeight() + i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        if (this.f352455d) {
            o(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.K != null) {
            if (motionEvent.getAction() == 0) {
                this.K.a();
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.K.b();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // nv3.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof nv3.a) {
                ((nv3.a) childAt).e();
            }
        }
    }

    @Override // nv3.b
    public View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this;
    }

    @Override // nv3.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (!this.f352455d) {
                return;
            }
            t(0, contentLength());
        }
    }

    @Override // nv3.a
    public void h(int i3, int i16) {
        int i17;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!this.f352455d) {
            QLog.dAsync("SelectableLinearLayout", 1, "highLightContent is not selecting");
            return;
        }
        int childCount = getChildCount();
        boolean z17 = false;
        for (int i18 = 0; i18 < childCount; i18++) {
            KeyEvent.Callback childAt = getChildAt(i18);
            if (childAt instanceof nv3.a) {
                nv3.a aVar = (nv3.a) childAt;
                int contentLength = aVar.contentLength();
                if (i3 > contentLength) {
                    aVar.e();
                    i3 -= contentLength;
                    i16 -= contentLength;
                } else if (z17) {
                    aVar.e();
                } else {
                    if (i16 <= contentLength) {
                        i17 = i16;
                        z16 = true;
                    } else {
                        boolean z18 = z17;
                        i17 = i16 - contentLength;
                        i16 = contentLength;
                        z16 = z18;
                    }
                    aVar.h(i3, i16);
                    i3 = 0;
                    i16 = i17;
                    z17 = z16;
                }
            }
        }
    }

    @Override // nv3.b
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            if (!this.f352455d) {
                return;
            }
            e();
            this.f352455d = false;
            this.H = false;
            invalidate();
        }
    }

    @Override // nv3.a
    public int[] j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (int[]) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        int[] iArr = new int[2];
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            KeyEvent.Callback childAt = getChildAt(i16);
            if (childAt instanceof nv3.a) {
                nv3.a aVar = (nv3.a) childAt;
                int contentLength = aVar.contentLength();
                if (i3 > contentLength) {
                    i3 -= contentLength;
                } else {
                    return aVar.j(i3);
                }
            }
        }
        return iArr;
    }

    @Override // nv3.b
    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.f352456e;
    }

    @Override // nv3.b
    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return this.f352458h - this.f352457f;
    }

    public CharSequence m() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (CharSequence) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        CharSequence a16 = a();
        if (a16 == null) {
            return "";
        }
        int i16 = this.f352457f;
        if (i16 != -1 && (i3 = this.f352458h) > i16 && i3 <= a16.length()) {
            return a16.subSequence(this.f352457f, this.f352458h);
        }
        return a16;
    }

    @Override // nv3.b
    public int[] n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (int[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return new int[]{this.f352457f, this.f352458h};
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.H && r(motionEvent.getX(), motionEvent.getY()) != -1) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.H) {
            s(motionEvent);
            return true;
        }
        if (this.N.j(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.f352455d;
    }

    public void setOnDoubleClickListener(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iVar);
        } else {
            this.N.k(iVar);
        }
    }

    public void setOnTouchViewListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.K = bVar;
        }
    }

    public void setTouchCursorListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.J = aVar;
        }
    }

    public void u(boolean z16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (this.f352455d) {
            QLog.dAsync("SelectableLinearLayout", 1, "is selecting");
            return;
        }
        int contentLength = contentLength();
        this.f352455d = true;
        Resources resources = getResources();
        if (z16) {
            i3 = R.color.skin_aio_cursor_color;
        } else {
            i3 = R.color.skin_aio_cursor_friend_color;
        }
        this.M.setColor(resources.getColor(i3));
        Resources resources2 = getResources();
        if (z16) {
            i16 = R.color.skin_aio_highlight_color;
        } else {
            i16 = R.color.skin_aio_highlight_friend_color;
        }
        c(resources2.getColor(i16));
        t(0, contentLength);
    }

    public SelectableLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f352455d = false;
        this.f352456e = -1;
        this.f352457f = -1;
        this.f352458h = -1;
        this.f352459i = new int[]{-1, -1};
        this.f352460m = new int[]{-1, -1};
        this.C = new int[]{-1, -1};
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = false;
        this.I = false;
        this.M = new Paint(1);
        this.N = new DoubleClickDetector(this);
    }

    public SelectableLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f352455d = false;
        this.f352456e = -1;
        this.f352457f = -1;
        this.f352458h = -1;
        this.f352459i = new int[]{-1, -1};
        this.f352460m = new int[]{-1, -1};
        this.C = new int[]{-1, -1};
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = false;
        this.I = false;
        this.M = new Paint(1);
        this.N = new DoubleClickDetector(this);
    }
}
