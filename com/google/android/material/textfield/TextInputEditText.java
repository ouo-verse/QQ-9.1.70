package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TextInputEditText extends AppCompatEditText {
    private final Rect E;
    private boolean F;

    public TextInputEditText(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private CharSequence f() {
        TextInputLayout g16 = g();
        if (g16 != null) {
            return g16.U();
        }
        return null;
    }

    @Nullable
    private TextInputLayout g() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean h(@Nullable TextInputLayout textInputLayout) {
        if (textInputLayout != null && this.F) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout g16 = g();
        if (h(g16) && rect != null) {
            g16.getFocusedRect(this.E);
            rect.bottom = this.E.bottom;
        }
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect rect, @Nullable Point point) {
        TextInputLayout g16 = g();
        if (h(g16)) {
            return g16.getGlobalVisibleRect(rect, point);
        }
        return super.getGlobalVisibleRect(rect, point);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout g16 = g();
        if (g16 != null && g16.i0()) {
            return g16.U();
        }
        return super.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout g16 = g();
        if (g16 != null && g16.i0() && super.getHint() == null && com.google.android.material.internal.f.c()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = f();
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect rect) {
        TextInputLayout g16 = g();
        if (h(g16) && rect != null) {
            this.E.set(rect.left, rect.top, rect.right, rect.bottom + (g16.getHeight() - getHeight()));
            return super.requestRectangleOnScreen(this.E);
        }
        return super.requestRectangleOnScreen(rect);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z16) {
        this.F = z16;
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ada);
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, 0), attributeSet, i3);
        this.E = new Rect();
        TypedArray h16 = o.h(context, attributeSet, w0.a.f443957m9, i3, R.style.am6, new int[0]);
        setTextInputLayoutFocusedRectEnabled(h16.getBoolean(w0.a.f443968n9, false));
        h16.recycle();
    }
}
