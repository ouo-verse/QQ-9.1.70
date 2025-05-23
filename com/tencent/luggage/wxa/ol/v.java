package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.view.ViewCompat;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v extends u implements com.tencent.luggage.wxa.tl.b {
    public InputConnection H;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends NumberKeyListener {
        public a() {
        }

        @Override // android.text.method.NumberKeyListener
        public char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', 'X', 'x', TokenParser.SP};
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            int i3;
            if (v.this.m()) {
                i3 = 16;
            } else {
                i3 = 0;
            }
            return i3 | 2;
        }
    }

    public v(Context context) {
        super(com.tencent.luggage.wxa.ye.c.a(context));
        super.setKeyListener(new a());
    }

    @Override // com.tencent.luggage.wxa.tl.b
    public InputConnection a() {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(new EditorInfo());
        this.H = onCreateInputConnection;
        return onCreateInputConnection;
    }

    @Override // com.tencent.luggage.wxa.ol.u, android.view.View
    public /* bridge */ /* synthetic */ boolean canScrollVertically(int i3) {
        return super.canScrollVertically(i3);
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.view.View
    public void clearFocus() {
        o();
    }

    @Override // com.tencent.luggage.wxa.ol.u, com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public void k() {
        y inputPanel;
        if (ViewCompat.isAttachedToWindow(this) && (inputPanel = getInputPanel()) != null) {
            inputPanel.setInputEditText(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.view.View
    public boolean requestFocus(int i3, Rect rect) {
        return a(i3, rect);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        int i3 = 0;
        if (inputFilterArr == null) {
            inputFilterArr = new InputFilter[0];
        }
        InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
        while (i3 < inputFilterArr.length) {
            inputFilterArr2[i3] = inputFilterArr[i3];
            i3++;
        }
        inputFilterArr2[i3] = new InputFilter.AllCaps();
        super.setFilters(inputFilterArr2);
    }

    @Override // com.tencent.luggage.wxa.ol.u, android.widget.TextView
    public /* bridge */ /* synthetic */ void setGravity(int i3) {
        super.setGravity(i3);
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public void setPasswordMode(boolean z16) {
        int i3;
        n();
        int inputType = getInputType() | 2;
        if (z16) {
            i3 = inputType | 16;
        } else {
            i3 = inputType & (-17);
        }
        setInputType(i3);
        super.setPasswordMode(z16);
        p();
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public y getInputPanel() {
        return y.a((View) this);
    }
}
