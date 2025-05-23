package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.luggage.wxa.ol.a1;
import com.tencent.luggage.wxa.ol.t0;
import com.tencent.mm.plugin.appbrand.widget.input.RepeatKeyTouchImageButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class z extends com.tencent.luggage.wxa.tl.a {
    public int G;
    public final SparseIntArray H;
    public InputConnection I;
    public com.tencent.luggage.wxa.tl.b J;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends SparseIntArray {
        public a() {
            put(1, R.id.jdw);
            put(2, R.id.jdx);
            put(3, R.id.jdy);
            put(4, R.id.jdz);
            put(5, R.id.f166954je0);
            put(6, R.id.f166955je1);
            put(7, R.id.f166956je2);
            put(8, R.id.f166957je3);
            put(9, R.id.f166958je4);
            put(0, R.id.jdv);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (z.this.I == null) {
                return;
            }
            if (view.getId() == R.id.je6) {
                int i3 = z.this.G;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return;
                    } else {
                        str = ".";
                    }
                } else {
                    str = "X";
                }
            } else {
                String str2 = null;
                for (int i16 = 0; i16 < z.this.H.size(); i16++) {
                    if (view.getId() == z.this.H.valueAt(i16)) {
                        str2 = String.valueOf(z.this.H.keyAt(i16));
                    }
                }
                str = str2;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            z.this.I.commitText(str, str.length());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements w0 {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.ol.w0
        public void a() {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onSingleTap");
            z.this.c();
        }

        @Override // com.tencent.luggage.wxa.ol.w0
        public void b() {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onRepeat");
            z.this.c();
        }
    }

    public z(Context context) {
        super(context);
        this.G = 0;
        this.H = new a();
        b();
    }

    @Override // com.tencent.luggage.wxa.tl.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setInputEditText(null);
    }

    @Override // com.tencent.luggage.wxa.tl.a
    public void setXMode(int i3) {
        super.setXMode(i3);
        this.G = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.tencent.luggage.wxa.tl.b bVar) {
        t0 a16;
        if (this.J == bVar) {
            return;
        }
        if (bVar == 0) {
            this.I = null;
            return;
        }
        boolean z16 = bVar instanceof View;
        if (z16 && (a16 = t0.a.a(((View) bVar).getContext())) != null) {
            a16.d();
        }
        if (bVar instanceof EditText) {
            EditText editText = (EditText) bVar;
            a1.a.b(editText);
            a1.a.a(editText);
        }
        if (z16) {
            ((View) bVar).requestFocus();
        }
        this.I = bVar.a();
    }

    public final void b() {
        b bVar = new b();
        for (int i3 = 0; i3 < this.H.size(); i3++) {
            findViewById(this.H.valueAt(i3)).setOnClickListener(bVar);
        }
        findViewById(R.id.je6).setOnClickListener(bVar);
        ((RepeatKeyTouchImageButton) findViewById(R.id.je5)).setRepeatKeyTouchListener(new c());
    }

    public final boolean c() {
        if (this.I == null) {
            return false;
        }
        if (!TextUtils.isEmpty(r0.getTextBeforeCursor(1, 0))) {
            this.I.deleteSurroundingText(1, 0);
        } else {
            this.I.sendKeyEvent(new KeyEvent(0, 67));
            this.I.sendKeyEvent(new KeyEvent(1, 67));
        }
        return true;
    }
}
