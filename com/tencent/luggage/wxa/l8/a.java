package com.tencent.luggage.wxa.l8;

import android.content.Context;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.luggage.wxa.br.b;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.e0;
import com.tencent.luggage.wxa.ol.g1;
import com.tencent.luggage.wxa.ol.h1;
import com.tencent.luggage.wxa.ol.i0;
import com.tencent.luggage.wxa.ol.n0;
import com.tencent.luggage.wxa.ol.o0;
import com.tencent.luggage.wxa.ol.s;
import com.tencent.luggage.wxa.qo.a;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends i0 {
    public static final c N = new c(null);
    public final InputConnection H;
    public final com.tencent.luggage.wxa.br.b I;
    public d J;
    public String K;
    public String L;
    public com.tencent.luggage.wxa.vl.f M;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.l8.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6425a implements b.e {
        public C6425a() {
        }

        @Override // com.tencent.luggage.wxa.br.b.e
        public final void a() {
            w.a("MicroMsg.DelegateEditText", "onDone#secureInputWidgetLogic");
            d listener = a.this.getListener();
            if (listener != null) {
                listener.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends MMTextWatcherAdapter {
        @Override // com.tencent.mm.ui.widget.MMTextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133119b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f133120c;

        public e(int i3, int i16) {
            this.f133119b = i3;
            this.f133120c = i16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.c(this.f133119b, this.f133120c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f133121a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f133122b;

        public f(Ref.ObjectRef objectRef, a aVar) {
            this.f133121a = objectRef;
            this.f133122b = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            Integer num = (Integer) this.f133121a.element;
            if (num != null) {
                int intValue = num.intValue();
                w.d("MicroMsg.DelegateEditText", "updateStyle, maxLength: " + intValue);
                s.a(this.f133122b).b(intValue).a(false).a(a.EnumC6654a.MODE_CHINESE_AS_1).a((b.a) null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, InputConnection sameLayerInputConnection) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sameLayerInputConnection, "sameLayerInputConnection");
        this.H = sameLayerInputConnection;
        com.tencent.luggage.wxa.br.b bVar = new com.tencent.luggage.wxa.br.b(context);
        this.I = bVar;
        setImeOptions(1);
        new h1(this);
        c(getSelectionStart(), getSelectionEnd());
        bVar.setOnPasswdInputListener(new C6425a());
        bVar.addTextChangedListener(new b());
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public void b(v vVar) {
        w.a("MicroMsg.DelegateEditText", "onAttachedToPage");
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
        w.a("MicroMsg.DelegateEditText", "supportsAutoFill");
        return false;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        KeyEvent keyEvent;
        int i3;
        Intrinsics.checkNotNullParameter(event, "event");
        if (a(event)) {
            keyEvent = new KeyEvent(event.getAction(), 155);
        } else {
            keyEvent = event;
        }
        w.a("MicroMsg.DelegateEditText", "dispatchKeyEvent, event: " + event + ", dispatchedKeyEvent: " + keyEvent);
        if (a(event) && event.getAction() == 0) {
            Editable text = getText();
            if (text != null) {
                i3 = text.length();
            } else {
                i3 = 0;
            }
            if (i3 >= getMaxEms()) {
                w.d("MicroMsg.DelegateEditText", "over max ems, return");
                return false;
            }
        }
        super.dispatchKeyEvent(keyEvent);
        this.I.requestFocus();
        boolean dispatchKeyEvent = this.I.dispatchKeyEvent(event);
        this.I.clearFocus();
        InputConnection inputConnection = this.H;
        if (inputConnection != null) {
            inputConnection.sendKeyEvent(keyEvent);
        }
        return dispatchKeyEvent;
    }

    @Nullable
    public final d getListener() {
        return this.J;
    }

    @Nullable
    public final Editable getRealText$luggage_xweb_ext_release() {
        return this.I.getText();
    }

    @NotNull
    public final com.tencent.luggage.wxa.br.b getSecureInputWidgetLogic$luggage_xweb_ext_release() {
        return this.I;
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public boolean h() {
        return false;
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

    @Override // android.widget.TextView
    public void onSelectionChanged(int i3, int i16) {
        w.d("MicroMsg.DelegateEditText", "onSelectionChanged, selStart: " + i3 + ", selEnd: " + i16);
        a(i3, i16);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public void setInputId(int i3) {
        w.a("MicroMsg.DelegateEditText", "setInputId, id: " + i3);
        super.setInputId(i3);
    }

    public final void setListener(@Nullable d dVar) {
        this.J = dVar;
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
                w.a("MicroMsg.DelegateEditText", "setText, i: " + i3 + ", char: " + charAt + ", shownChar: " + c16);
                sb5.append(c16);
            }
            str = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        } else {
            str = (String) charSequence;
        }
        w.d("MicroMsg.DelegateEditText", "setText, text: " + ((Object) charSequence) + ", shownText: " + str + ", type: " + bufferType);
        super.setText(str, bufferType);
        try {
            this.I.setText(charSequence, bufferType);
        } catch (NullPointerException unused) {
        }
        InputConnection inputConnection = this.H;
        if (inputConnection != null) {
            inputConnection.deleteSurroundingText(Integer.MAX_VALUE, Integer.MAX_VALUE);
            inputConnection.commitText(str, 1);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public void a(char c16) {
        char c17 = Character.isLetterOrDigit(c16) ? '*' : c16;
        w.a("MicroMsg.DelegateEditText", "saveLastKeyPressed, code: " + c16 + ", savedCode: " + c17);
        super.a(c17);
    }

    public final void b(int i3, int i16) {
        super.onSelectionChanged(i3, i16);
        post(new e(i3, i16));
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    @Nullable
    public e0 getInputPanel() {
        e0 a16 = e0.f136703h.a(this);
        w.a("MicroMsg.DelegateEditText", "getInputPanel, keyboardPanel: " + a16);
        return a16;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public void a(v vVar) {
        w.a("MicroMsg.DelegateEditText", "onDetachedFromPage");
    }

    public final com.tencent.luggage.wxa.vl.f a(com.tencent.luggage.wxa.vl.f fVar) {
        a((com.tencent.luggage.wxa.vl.i) fVar);
        return this.M;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Number] */
    public final com.tencent.luggage.wxa.vl.i a(com.tencent.luggage.wxa.vl.i iVar) {
        w.a("MicroMsg.DelegateEditText", IECSearchBar.METHOD_UPDATE_STYLE);
        com.tencent.luggage.wxa.vl.f fVar = this.M;
        if (fVar == null) {
            Intrinsics.checkNotNull(iVar, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.input.params.InsertParams");
            this.M = (com.tencent.luggage.wxa.vl.f) iVar;
        } else if (iVar != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.a(iVar);
            g1.f136743a.a(iVar, iVar);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        com.tencent.luggage.wxa.vl.f fVar2 = this.M;
        ?? r06 = fVar2 != null ? fVar2.I : 0;
        objectRef.element = r06;
        if (r06 != 0) {
            this.I.a(r06.intValue(), ((Number) objectRef.element).intValue());
            setMaxEms(((Number) objectRef.element).intValue());
        }
        com.tencent.luggage.wxa.zp.h.f146825d.a(new f(objectRef, this));
        return this.M;
    }

    public final void a(int i3, int i16) {
        Editable text = getText();
        int length = text != null ? text.length() : 0;
        w.d("MicroMsg.DelegateEditText", "onSelectionChangedDisable, sel: " + length);
        if (i3 == length && i16 == length) {
            b(i3, i16);
        } else {
            setSelection(length, length);
        }
    }

    public final String a(com.tencent.luggage.wxa.xd.f env, String safePasswordCertPath) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(safePasswordCertPath, "safePasswordCertPath");
        if (Intrinsics.areEqual(safePasswordCertPath, this.K)) {
            String str = this.L;
            if (str != null) {
                return str;
            }
            w.b("MicroMsg.DelegateEditText", "readCertPem, cachedCertPem is null");
            throw new IllegalStateException("certPath is illegal");
        }
        try {
            String a16 = n0.f136895a.a(env, safePasswordCertPath);
            this.L = a16;
            this.K = safePasswordCertPath;
            return a16;
        } catch (o0 e16) {
            throw new IllegalStateException(e16.getMessage());
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
