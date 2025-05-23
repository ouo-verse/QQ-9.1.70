package com.tencent.mobileqq.activity.selectable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.selectable.e;
import com.tencent.qqnt.selectable.g;
import com.tencent.qqnt.selectable.i;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SelectableLinearLayout extends LinearLayout implements e {
    static IPatchRedirector $redirector_;
    private boolean C;
    private g D;
    private final int[] E;

    /* renamed from: d, reason: collision with root package name */
    private i f186127d;

    /* renamed from: e, reason: collision with root package name */
    private int f186128e;

    /* renamed from: f, reason: collision with root package name */
    private int f186129f;

    /* renamed from: h, reason: collision with root package name */
    private int f186130h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f186131i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f186132m;

    public SelectableLinearLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f186130h = -5250572;
        this.f186131i = false;
        this.f186132m = false;
        this.C = true;
        this.E = new int[2];
    }

    @Override // com.tencent.qqnt.selectable.g
    @Nullable
    public CharSequence a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof g) {
                sb5.append(((g) childAt).a());
            }
        }
        return sb5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.selectable.g
    public int b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        getLocationInWindow(this.E);
        int paddingLeft = (i3 - this.E[0]) - getPaddingLeft();
        int paddingTop = (i16 - this.E[1]) - getPaddingTop();
        int childCount = getChildCount();
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt instanceof g) {
                g gVar = (g) childAt;
                if (paddingLeft > childAt.getLeft() && paddingLeft < childAt.getRight() && paddingTop > childAt.getTop() && paddingTop < childAt.getBottom()) {
                    this.D = gVar;
                    return i17 + gVar.b(i3, i16);
                }
                i17 += gVar.contentLength();
            }
        }
        int i19 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            KeyEvent.Callback childAt2 = getChildAt(i26);
            if (childAt2 instanceof g) {
                g gVar2 = (g) childAt2;
                g gVar3 = this.D;
                if (gVar3 == gVar2) {
                    return i19 + gVar3.b(i3, i16);
                }
                i19 += gVar2.contentLength();
            }
        }
        return -1;
    }

    @Override // com.tencent.qqnt.selectable.g
    @Nullable
    public i c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (i) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f186127d;
    }

    @Override // com.tencent.qqnt.selectable.g
    public int contentLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int childCount = getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            KeyEvent.Callback childAt = getChildAt(i16);
            if (childAt instanceof g) {
                i3 += ((g) childAt).contentLength();
            }
        }
        return i3;
    }

    @Override // com.tencent.qqnt.selectable.g
    @NonNull
    public View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (View) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.qqnt.selectable.g
    public void g(@Nullable i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
        } else {
            this.f186127d = iVar;
        }
    }

    @Override // com.tencent.qqnt.selectable.g
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.f186131i = false;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof g) {
                ((g) childAt).h();
            }
        }
    }

    @Override // com.tencent.qqnt.selectable.g
    public boolean hasSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.f186132m;
    }

    @Override // com.tencent.qqnt.selectable.g
    public void i(int i3, @NonNull int[] iArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), iArr, Boolean.valueOf(z16));
            return;
        }
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            KeyEvent.Callback childAt = getChildAt(i16);
            if (childAt instanceof g) {
                g gVar = (g) childAt;
                int contentLength = gVar.contentLength();
                if (i3 > contentLength) {
                    i3 -= contentLength;
                } else {
                    gVar.i(i3, iArr, z16);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.selectable.g
    public void j(int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != -1 && i16 != -1) {
            if (i3 > i16) {
                this.f186128e = i16;
                this.f186129f = i3;
            } else {
                this.f186128e = i3;
                this.f186129f = i16;
            }
            if (this.f186129f - this.f186128e > 0) {
                this.f186132m = true;
            }
        } else {
            this.f186128e = -1;
            this.f186129f = -1;
            this.f186132m = false;
        }
        int i18 = this.f186128e;
        int i19 = this.f186129f;
        int childCount = getChildCount();
        boolean z16 = false;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            if (childAt instanceof g) {
                g gVar = (g) childAt;
                if (!z16) {
                    int contentLength = gVar.contentLength();
                    if (i18 >= contentLength) {
                        i18 -= contentLength;
                        i19 -= contentLength;
                        gVar.j(-1, -1);
                    } else {
                        if (i19 > contentLength) {
                            i17 = contentLength;
                        } else {
                            i17 = i19;
                            z16 = true;
                        }
                        gVar.j(i18, i17);
                        if (!z16) {
                            i19 -= contentLength;
                            i18 = 0;
                        }
                    }
                } else {
                    gVar.j(-1, -1);
                }
                childAt.invalidate();
            }
        }
    }

    @Override // com.tencent.qqnt.selectable.g
    @Nullable
    public CharSequence k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CharSequence) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        CharSequence a16 = a();
        if (a16 != null) {
            return a16.subSequence(this.f186128e, this.f186129f);
        }
        return null;
    }

    @Override // com.tencent.qqnt.selectable.g
    public void l(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, obj);
            return;
        }
        if (obj == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SelectableLinearLayout", 2, "doSelecting msg = null.");
            }
        } else {
            i iVar = this.f186127d;
            if (iVar != null) {
                iVar.n(obj);
            }
        }
    }

    @Override // com.tencent.qqnt.selectable.g
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!hasSelected()) {
            h();
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof g) {
                g gVar = (g) childAt;
                if (gVar.hasSelected()) {
                    gVar.n(this.f186130h);
                    gVar.m();
                } else {
                    gVar.h();
                }
            }
        }
    }

    @Override // com.tencent.qqnt.selectable.g
    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f186130h = i3;
        }
    }

    @Override // com.tencent.qqnt.selectable.e
    public void setCursorOffset(int[] iArr, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, iArr, Float.valueOf(f16));
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof e) {
                ((e) childAt).setCursorOffset(iArr, f16);
            }
        }
    }

    public SelectableLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f186130h = -5250572;
        this.f186131i = false;
        this.f186132m = false;
        this.C = true;
        this.E = new int[2];
    }

    public SelectableLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f186130h = -5250572;
        this.f186131i = false;
        this.f186132m = false;
        this.C = true;
        this.E = new int[2];
    }
}
