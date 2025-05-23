package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.ol.q0;
import com.tencent.mobileqq.R;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i0 extends EditText implements q0, com.tencent.luggage.wxa.ll.c {
    public boolean C;
    public final int[] D;
    public boolean E;
    public q0.b F;
    public char G;

    /* renamed from: a, reason: collision with root package name */
    public InputConnection f136762a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136763b;

    /* renamed from: c, reason: collision with root package name */
    public Function1 f136764c;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f136765d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.pl.b f136766e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f136767f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f136768g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f136769h;

    /* renamed from: i, reason: collision with root package name */
    public final d f136770i;

    /* renamed from: j, reason: collision with root package name */
    public final PasswordTransformationMethod f136771j;

    /* renamed from: k, reason: collision with root package name */
    public final k0 f136772k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f136773l;

    /* renamed from: m, reason: collision with root package name */
    public int f136774m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends Editable.Factory {
        public a() {
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            return i0.this.a(super.newEditable(charSequence));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends InputConnectionWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputConnection f136776a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InputConnection inputConnection, boolean z16, InputConnection inputConnection2) {
            super(inputConnection, z16);
            this.f136776a = inputConnection2;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i3) {
            if (!TextUtils.isEmpty(charSequence)) {
                i0.this.a(charSequence.charAt(charSequence.length() - 1));
            }
            return super.commitText(charSequence, i3);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i3, int i16) {
            i0.this.a('\b');
            return super.deleteSurroundingText(i3, i16);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean finishComposingText() {
            Editable editableText;
            InputConnection inputConnection = this.f136776a;
            if (inputConnection instanceof BaseInputConnection) {
                editableText = ((BaseInputConnection) inputConnection).getEditable();
            } else {
                editableText = i0.this.getEditableText();
            }
            boolean b16 = a1.b(editableText);
            boolean finishComposingText = super.finishComposingText();
            if (finishComposingText && i0.this.f136762a == this && b16) {
                i0.this.f136772k.a();
            }
            return finishComposingText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean setComposingText(CharSequence charSequence, int i3) {
            if (!TextUtils.isEmpty(charSequence)) {
                i0.this.a(charSequence.charAt(charSequence.length() - 1));
            }
            return super.setComposingText(charSequence, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f136778a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f136778a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f136778a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class d implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final Map f136779a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f136781a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f136782b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f136783c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f136784d;

            public a(boolean z16, String str, int i3, int i16) {
                this.f136781a = z16;
                this.f136782b = str;
                this.f136783c = i3;
                this.f136784d = i16;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f136781a) {
                    i0.this.a(this.f136782b);
                } else {
                    i0.this.setText(this.f136782b);
                }
                try {
                    i0.this.setSelection(Math.min(this.f136783c + this.f136784d, this.f136782b.length()));
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", e16);
                }
            }
        }

        public d() {
            this.f136779a = new ArrayMap();
        }

        public void a() {
            this.f136779a.clear();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a(editable);
        }

        public void b(TextWatcher textWatcher) {
            if (textWatcher != null) {
                this.f136779a.remove(textWatcher);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            a(charSequence, i3, i16, i17);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            b(charSequence, i3, i16, i17);
        }

        public void a(TextWatcher textWatcher) {
            if (textWatcher != null) {
                this.f136779a.put(textWatcher, this);
            }
        }

        public void b(CharSequence charSequence, int i3, int i16, int i17) {
            if (i0.this.l()) {
                return;
            }
            a(charSequence, i3, i17, StyleSpan.class);
            a(charSequence, i3, i17, RelativeSizeSpan.class);
            a(charSequence, i3, i17, AlignmentSpan.class);
            if (this.f136779a.isEmpty()) {
                return;
            }
            for (TextWatcher textWatcher : (TextWatcher[]) this.f136779a.keySet().toArray(new TextWatcher[this.f136779a.size()])) {
                textWatcher.onTextChanged(charSequence, i3, i16, i17);
            }
        }

        public /* synthetic */ d(i0 i0Var, a aVar) {
            this();
        }

        public final void a(CharSequence charSequence, int i3, int i16, Class cls) {
            SpannableStringBuilder spannableStringBuilder;
            Object[] spans;
            try {
                if (!(charSequence instanceof SpannableStringBuilder) || (spans = (spannableStringBuilder = (SpannableStringBuilder) charSequence).getSpans(i3, i16 + i3, cls)) == null || spans.length <= 0) {
                    return;
                }
                for (Object obj : spans) {
                    spannableStringBuilder.removeSpan(obj);
                }
            } catch (Throwable unused) {
            }
        }

        public void a(CharSequence charSequence, int i3, int i16, int i17) {
            if (i0.this.l() || this.f136779a.isEmpty()) {
                return;
            }
            for (TextWatcher textWatcher : (TextWatcher[]) this.f136779a.keySet().toArray(new TextWatcher[this.f136779a.size()])) {
                textWatcher.beforeTextChanged(charSequence, i3, i16, i17);
            }
        }

        public void a(Editable editable) {
            if (h.c() && h.b()) {
                com.tencent.luggage.wxa.dn.a aVar = new com.tencent.luggage.wxa.dn.a();
                com.tencent.luggage.wxa.dn.c cVar = new com.tencent.luggage.wxa.dn.c();
                String a16 = i0.this.a(editable, aVar, cVar);
                int i3 = cVar.f124397a;
                if (aVar.f124395a && !com.tencent.luggage.wxa.tn.w0.c(a16)) {
                    i0.this.post(new a(i0.this.l(), a16, Selection.getSelectionEnd(editable), i3));
                    return;
                }
            }
            if (i0.this.l()) {
                return;
            }
            i0.this.q();
            if (this.f136779a.isEmpty()) {
                return;
            }
            for (TextWatcher textWatcher : (TextWatcher[]) this.f136779a.keySet().toArray(new TextWatcher[this.f136779a.size()])) {
                textWatcher.afterTextChanged(editable);
            }
        }
    }

    public i0(Context context) {
        super(context);
        this.f136763b = false;
        this.f136765d = -1;
        this.f136771j = new p();
        this.f136774m = 0;
        this.C = false;
        this.D = new int[2];
        this.E = false;
        this.G = (char) 0;
        d dVar = new d(this, null);
        this.f136770i = dVar;
        this.f136767f = new ArrayMap();
        this.f136769h = new ArrayMap();
        this.f136768g = new ArrayMap();
        this.f136772k = new k0(this);
        setBackgroundDrawable(null);
        setIncludeFontPadding(false);
        b();
        setSingleLine(true);
        setTextCursorDrawable(R.drawable.ja6);
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLineSpacing(0.0f, 1.0f);
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(dVar);
        super.setPadding(0, 0, 0, 0);
        super.setEditableFactory(new a());
        if (d()) {
            this.f136766e = new com.tencent.luggage.wxa.pl.b(this);
        } else {
            this.f136766e = null;
        }
        this.f136773l = true;
    }

    @Override // android.widget.TextView, com.tencent.luggage.wxa.ol.q0
    public void addTextChangedListener(TextWatcher textWatcher) {
        this.f136770i.a(textWatcher);
    }

    @Override // com.tencent.luggage.wxa.ll.c
    public boolean c() {
        return false;
    }

    @Override // android.view.View
    public void clearFocus() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setFocusableInTouchMode(true);
            ((ViewGroup) getParent()).setDescendantFocusability(131072);
        }
        super.clearFocus();
    }

    public boolean d() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void destroy() {
        this.f136767f.clear();
        this.f136769h.clear();
        this.f136768g.clear();
        this.f136770i.a();
        com.tencent.luggage.wxa.pl.b bVar = this.f136766e;
        if (bVar != null) {
            bVar.b();
        }
        super.setOnFocusChangeListener(null);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Function1 function1 = this.f136764c;
        if (function1 != null && keyEvent.getAction() == 0 && (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 23)) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.WebEditText|WMPF.KeyBoardNav", "dispatchKeyEvent: transfer focus");
            function1.invoke(null);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void e() {
        b(1);
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public boolean f() {
        return this.C;
    }

    @Override // android.view.View
    public View focusSearch(int i3) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void g() {
        b(5);
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public com.tencent.luggage.wxa.pl.b getAutoFillController() {
        return this.f136766e;
    }

    @Override // android.widget.TextView, android.view.View
    public int getAutofillType() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public int getInputId() {
        return this.f136765d;
    }

    public abstract /* synthetic */ View getInputPanel();

    @Override // com.tencent.luggage.wxa.ol.q0
    public char getLastKeyPressed() {
        return this.G;
    }

    @Override // android.widget.TextView
    @Nullable
    public Drawable getTextSelectHandle() {
        try {
            return super.getTextSelectHandle();
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public final void i() {
        Layout.Alignment alignment;
        int gravity = getGravity();
        CharSequence hint = getHint();
        if (!TextUtils.isEmpty(hint)) {
            Spannable a16 = a1.a(hint);
            int i3 = gravity & 7;
            int i16 = 5;
            if (i3 != 1) {
                if (i3 != 5) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                }
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            a16.setSpan(new AlignmentSpan.Standard(alignment), 0, getHint().length(), 18);
            super.setHint(a16);
            int i17 = c.f136778a[alignment.ordinal()];
            if (i17 != 1) {
                if (i17 == 2) {
                    i16 = 6;
                }
            } else {
                i16 = 4;
            }
            super.setTextAlignment(i16);
        }
    }

    public int j() {
        return a(getLineCount()) + getPaddingBottom();
    }

    public abstract void k();

    public final boolean l() {
        if (this.f136774m > 0) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        return this.f136763b;
    }

    public final void n() {
        this.f136774m++;
    }

    public final void o() {
        super.clearFocus();
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.f136767f.isEmpty()) {
            for (q0.a aVar : (q0.a[]) this.f136767f.keySet().toArray(new q0.a[this.f136767f.size()])) {
                aVar.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        this.f136762a = new b(onCreateInputConnection, false, onCreateInputConnection);
        editorInfo.imeOptions |= 268435456;
        if (getImeOptions() != 0) {
            editorInfo.imeOptions &= -1073741825;
        }
        return this.f136762a;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z16, int i3, Rect rect) {
        super.onFocusChanged(z16, i3, rect);
        if (!z16) {
            clearComposingText();
        }
        if (z16) {
            k();
        }
        if (!this.f136768g.isEmpty()) {
            for (View.OnFocusChangeListener onFocusChangeListener : (View.OnFocusChangeListener[]) this.f136768g.keySet().toArray(new View.OnFocusChangeListener[this.f136768g.size()])) {
                onFocusChangeListener.onFocusChange(this, z16);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 67) {
            a('\b');
        }
        boolean onKeyDown = super.onKeyDown(i3, keyEvent);
        if (onKeyDown && i3 == 66) {
            a('\n');
        }
        this.E = onKeyDown;
        return onKeyDown;
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        q0.b bVar;
        if (!this.E && (bVar = this.F) != null && bVar.a(i3, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        com.tencent.luggage.wxa.tn.w.e("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i3, int i16) {
        com.tencent.luggage.wxa.tn.w.e("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
        super.onMeasure(i3, i16);
        if (!this.f136769h.isEmpty()) {
            for (Object obj : this.f136769h.keySet().toArray()) {
                ((q0.c) obj).a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public final void p() {
        this.f136774m = Math.max(0, this.f136774m - 1);
    }

    public final void q() {
        this.f136774m = 0;
    }

    public final void r() {
        n();
        setText(getEditableText());
        p();
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        this.f136770i.b(textWatcher);
    }

    @Override // android.view.View
    public boolean requestFocus(int i3, Rect rect) {
        if (130 == i3 && rect == null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setDescendantFocusability(262144);
            ((ViewGroup) getParent()).setFocusableInTouchMode(false);
        }
        try {
            return super.requestFocus(i3, rect);
        } catch (RuntimeException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WebEditText", "requestFocus e=%s", e16);
            try {
                return super.requestFocus(i3, rect);
            } catch (RuntimeException e17) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WebEditText", "requestFocus try again e=%s", e17);
                return false;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void setFixed(boolean z16) {
        this.C = z16;
    }

    public void setInputId(int i3) {
        this.f136765d = i3;
    }

    @Override // android.widget.TextView
    @CallSuper
    public void setInputType(int i3) {
        if (getInputType() == i3) {
            return;
        }
        super.setInputType(i3);
    }

    @Override // android.widget.TextView
    public void setMaxHeight(int i3) {
        if (getMaxHeight() == i3) {
            return;
        }
        super.setMaxHeight(i3);
    }

    @Override // android.widget.TextView
    public void setMinHeight(int i3) {
        if (getMinHeight() == i3) {
            return;
        }
        super.setMinHeight(i3);
    }

    public void setOnComposingDismissedListener(com.tencent.luggage.wxa.sl.b bVar) {
        this.f136772k.a(bVar);
    }

    @Override // android.view.View
    @Deprecated
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.f136768g == null) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            b(onFocusChangeListener);
        }
    }

    public void setOnFocusTransferListener(Function1<Void, Void> function1) {
        this.f136764c = function1;
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void setOnKeyUpPostImeListener(q0.b bVar) {
        this.F = bVar;
    }

    @CallSuper
    public void setPasswordMode(boolean z16) {
        PasswordTransformationMethod passwordTransformationMethod;
        n();
        this.f136763b = z16;
        if (z16) {
            passwordTransformationMethod = this.f136771j;
        } else {
            passwordTransformationMethod = null;
        }
        setTransformationMethod(passwordTransformationMethod);
        p();
    }

    @Override // android.widget.EditText
    public void setSelection(int i3) {
        if (getEditableText() == null) {
            return;
        }
        super.setSelection(Math.min(i3, getEditableText().length()));
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    @Override // android.widget.TextView
    public final void setTextCursorDrawable(@DrawableRes int i3) {
        try {
            new com.tencent.luggage.wxa.u9.b(this, "mCursorDrawableRes", TextView.class.getName()).a(Integer.valueOf(i3));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", com.tencent.luggage.wxa.tn.w0.a((Throwable) e16));
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(float f16) {
        setTextSize(0, f16);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
    }

    @Override // android.view.View
    public String toString() {
        return String.format(Locale.US, "[%s|%s]", getClass().getSimpleName(), Integer.valueOf(getInputId()));
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void b(View.OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.f136768g.put(onFocusChangeListener, this);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f16) {
        super.setTextSize(i3, f16);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i3) {
        super.setTypeface(typeface, i3);
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void a(float f16, float f17) {
        throw new IllegalStateException("Should implement performClick(float, float) in this class!");
    }

    public final void b(int i3) {
        setGravity(i3 | (getGravity() & (-8388612) & (-8388614)));
        i();
    }

    @Override // android.widget.EditText
    public void setSelection(int i3, int i16) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 >= getEditableText().length()) {
            i3 = getEditableText().length();
        }
        if (i16 < i3) {
            i16 = i3;
        }
        if (i16 >= getEditableText().length()) {
            i16 = getEditableText().length();
        }
        super.setSelection(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void a(q0.a aVar) {
        if (aVar != null) {
            this.f136767f.put(aVar, this);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.f136768g.remove(onFocusChangeListener);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void a(q0.c cVar) {
        if (cVar != null) {
            this.f136769h.put(cVar, this);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public void b() {
        b(3);
    }

    public Editable a(Editable editable) {
        return this.f136772k.a(editable);
    }

    public final void b(CharSequence charSequence) {
        Editable editableText = getEditableText();
        if (editableText == null) {
            setText(charSequence, TextView.BufferType.EDITABLE);
            return;
        }
        clearComposingText();
        if (TextUtils.isEmpty(charSequence)) {
            editableText.clear();
        } else {
            editableText.replace(0, editableText.length(), charSequence);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public int a(int i3) {
        int paddingTop = getPaddingTop() + ((int) (i3 * (getLineHeight() + getLineSpacingExtra())));
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", Integer.valueOf(i3), Integer.valueOf(paddingTop), getLayout());
        return paddingTop;
    }

    public final void a(CharSequence charSequence) {
        n();
        b(charSequence);
        p();
    }

    public void a(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.pl.b bVar = this.f136766e;
        if (bVar != null) {
            bVar.b(vVar);
        }
    }

    public void b(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.pl.b bVar = this.f136766e;
        if (bVar != null) {
            bVar.a(vVar);
        }
    }

    public final String a(Editable editable, com.tencent.luggage.wxa.dn.a aVar, com.tencent.luggage.wxa.dn.c cVar) {
        cVar.f124397a = 0;
        aVar.f124395a = false;
        if (editable == null || editable.length() <= 0) {
            return null;
        }
        String obj = editable.toString();
        int length = editable.length();
        for (int i3 = 0; i3 < length; i3++) {
            com.tencent.luggage.wxa.ql.a.a().b(obj.codePointAt(i3));
        }
        return obj;
    }

    public void a(char c16) {
        this.G = c16;
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public final View getView() {
        return this;
    }

    public final boolean a(int i3, Rect rect) {
        return super.requestFocus(i3, rect);
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z16) {
    }
}
