package com.tencent.qqnt.aio.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TextExtLinearLayout extends LinearLayout implements nv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private nv3.a f352467d;

    public TextExtLinearLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // nv3.a
    public CharSequence a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CharSequence) iPatchRedirector.redirect((short) 11, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
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
                    this.f352467d = aVar;
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
                nv3.a aVar3 = this.f352467d;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
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

    @Override // nv3.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
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

    @Override // nv3.a
    public void h(int i3, int i16) {
        int i17;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
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

    @Override // nv3.a
    public int[] j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this, i3);
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

    public TextExtLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TextExtLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
