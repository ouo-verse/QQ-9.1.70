package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.br.b;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b0 extends u {
    public c H;
    public final com.tencent.luggage.wxa.br.b I;
    public String J;
    public String K;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements b.e {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.br.b.e
        public final void a() {
            com.tencent.luggage.wxa.tn.w.a(b0.this.getMyTag$luggage_wxa_app_input_ext_release(), "onDone#secureInputWidgetLogic");
            c listener = b0.this.getListener();
            if (listener != null) {
                listener.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends MMTextWatcherAdapter {
        public b() {
        }

        @Override // com.tencent.mm.ui.widget.MMTextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f136664b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f136665c;

        public d(int i3, int i16) {
            this.f136664b = i3;
            this.f136665c = i16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b0.this.c(this.f136664b, this.f136665c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.luggage.wxa.br.b bVar = new com.tencent.luggage.wxa.br.b(context);
        this.I = bVar;
        setImeOptions(1);
        new h1(this);
        bVar.setText(getText());
        c(getSelectionStart(), getSelectionEnd());
        bVar.setOnPasswdInputListener(new a());
        bVar.addTextChangedListener(new b());
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public void b(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "onAttachedToPage");
    }

    public final void c(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0 && i3 <= i16) {
            try {
                this.I.setSelection(i3, i16);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public boolean d() {
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "supportsAutoFill");
        return false;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        KeyEvent keyEvent;
        Intrinsics.checkNotNullParameter(event, "event");
        if (a(event)) {
            keyEvent = new KeyEvent(event.getAction(), 155);
        } else {
            keyEvent = event;
        }
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "dispatchKeyEvent, event: " + event + ", dispatchedKeyEvent: " + keyEvent);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        boolean dispatchKeyEvent2 = this.I.dispatchKeyEvent(event);
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "dispatchKeyEvent, handled: " + dispatchKeyEvent + ", handled2: " + dispatchKeyEvent2);
        return dispatchKeyEvent;
    }

    @Nullable
    public final c getListener() {
        return this.H;
    }

    @NotNull
    public final String getMyTag$luggage_wxa_app_input_ext_release() {
        return "MicroMsg.AppBrand.AppBrandSecureInputWidget#" + getInputId();
    }

    @Nullable
    public final String getRealText$luggage_wxa_app_input_ext_release() {
        Editable text = this.I.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    @NotNull
    public final com.tencent.luggage.wxa.br.b getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release() {
        return this.I;
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public void k() {
        e0 inputPanel;
        if (ViewCompat.isAttachedToWindow(this) && (inputPanel = getInputPanel()) != null) {
            inputPanel.setInputWidget(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onCreateContextMenu(ContextMenu contextMenu) {
        if (contextMenu != null) {
            contextMenu.clearHeader();
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "onCreateInputConnection");
        return null;
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i3, int i16) {
        com.tencent.luggage.wxa.tn.w.d(getMyTag$luggage_wxa_app_input_ext_release(), "onSelectionChanged, selStart: " + i3 + ", selEnd: " + i16);
        a(i3, i16);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public void setInputId(int i3) {
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "setInputId, id: " + i3);
        super.setInputId(i3);
    }

    public final void setLength$luggage_wxa_app_input_ext_release(int i3) {
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "setLength, length: " + i3);
        this.I.a(i3, i3);
    }

    public final void setListener(@Nullable c cVar) {
        this.H = cVar;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        String str;
        char c16;
        if (charSequence != null) {
            StringBuilder sb5 = new StringBuilder();
            int length = charSequence.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                if (Character.isLetterOrDigit(charAt)) {
                    c16 = '*';
                } else {
                    c16 = charAt;
                }
                com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "setText, i: " + i3 + ", char: " + charAt + ", shownChar: " + c16);
                sb5.append(c16);
            }
            str = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        } else {
            str = (String) charSequence;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandSecureInputWidget", "setText, text: " + ((Object) charSequence) + ", shownText: " + str + ", type: " + bufferType);
        super.setText(str, bufferType);
        try {
            this.I.setText(charSequence, bufferType);
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public void a(char c16) {
        char c17 = Character.isLetterOrDigit(c16) ? '*' : c16;
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "saveLastKeyPressed, code: " + c16 + ", savedCode: " + c17);
        super.a(c17);
    }

    public final void b(int i3, int i16) {
        super.onSelectionChanged(i3, i16);
        post(new d(i3, i16));
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    @Nullable
    public e0 getInputPanel() {
        e0 a16 = e0.f136703h.a(this);
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "getInputPanel, keyboardPanel: " + a16);
        return a16;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public void a(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.tn.w.a(getMyTag$luggage_wxa_app_input_ext_release(), "onDetachedFromPage");
    }

    public final String a(com.tencent.luggage.wxa.kj.v env, String safePasswordCertPath) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(safePasswordCertPath, "safePasswordCertPath");
        if (Intrinsics.areEqual(safePasswordCertPath, this.J)) {
            String str = this.K;
            if (str != null) {
                return str;
            }
            com.tencent.luggage.wxa.tn.w.b(getMyTag$luggage_wxa_app_input_ext_release(), "readCertPem, cachedCertPem is null");
            throw new IllegalStateException("certPath is illegal");
        }
        try {
            String a16 = n0.f136895a.a(env, safePasswordCertPath);
            this.K = a16;
            this.J = safePasswordCertPath;
            return a16;
        } catch (o0 e16) {
            throw new IllegalStateException(e16.getMessage());
        }
    }

    public final void a(int i3, int i16) {
        Editable text = getText();
        int length = text != null ? text.length() : 0;
        com.tencent.luggage.wxa.tn.w.d(getMyTag$luggage_wxa_app_input_ext_release(), "onSelectionChangedDisable, sel: " + length);
        if (i3 == length && i16 == length) {
            b(i3, i16);
        } else {
            setSelection(length, length);
        }
    }

    public final boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (7 <= keyCode && keyCode < 17) {
            return true;
        }
        int keyCode2 = keyEvent.getKeyCode();
        return 29 <= keyCode2 && keyCode2 < 55;
    }
}
