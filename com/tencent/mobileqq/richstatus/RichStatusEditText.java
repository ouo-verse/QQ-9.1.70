package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.ClickableImageSpan;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RichStatusEditText extends EditText {
    static IPatchRedirector $redirector_;
    private static float D;
    int C;

    /* renamed from: d, reason: collision with root package name */
    private ClickableImageSpan f282158d;

    /* renamed from: e, reason: collision with root package name */
    private c f282159e;

    /* renamed from: f, reason: collision with root package name */
    private Context f282160f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f282161h;

    /* renamed from: i, reason: collision with root package name */
    private TextWatcher f282162i;

    /* renamed from: m, reason: collision with root package name */
    int f282163m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f282164d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f282165e;

        /* renamed from: f, reason: collision with root package name */
        private int f282166f;

        /* renamed from: h, reason: collision with root package name */
        private int f282167h;

        /* renamed from: i, reason: collision with root package name */
        private String f282168i;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RichStatusEditText.this);
            } else {
                this.f282164d = false;
                this.f282165e = false;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            RichStatusEditText richStatusEditText = RichStatusEditText.this;
            if (richStatusEditText.f282161h && this.f282165e) {
                richStatusEditText.f282161h = false;
                this.f282165e = false;
                Editable text = richStatusEditText.getText();
                int i3 = this.f282166f;
                text.replace(i3, this.f282167h + i3, this.f282168i);
                RichStatusEditText.this.setSelection(this.f282166f + this.f282168i.length());
                RichStatusEditText.this.f282161h = true;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            int spanStart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            RichStatusEditText richStatusEditText = RichStatusEditText.this;
            if (!richStatusEditText.f282161h) {
                return;
            }
            if (i17 > 0) {
                this.f282164d = true;
                this.f282166f = i3;
                this.f282167h = i17;
                richStatusEditText.f();
                RichStatusEditText.this.setCursorVisible(true);
                return;
            }
            this.f282164d = false;
            ClickableImageSpan h16 = richStatusEditText.h(i3, false, false);
            if (h16 != null && (spanStart = RichStatusEditText.this.l().getSpanStart(h16)) != i3) {
                this.f282165e = true;
                this.f282166f = spanStart;
                this.f282167h = i3 - spanStart;
                this.f282168i = "";
            }
            RichStatusEditText.this.q(i3, i16);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            RichStatusEditText richStatusEditText = RichStatusEditText.this;
            if (richStatusEditText.f282161h && this.f282164d) {
                int i18 = i17 + i3;
                ClickableImageSpan h16 = richStatusEditText.h(i18, true, false);
                if (h16 != null && RichStatusEditText.this.f282159e != null && !RichStatusEditText.this.f282159e.a(h16)) {
                    this.f282168i = "";
                    this.f282165e = true;
                    return;
                }
                String charSequence2 = charSequence.subSequence(i3, i18).toString();
                this.f282168i = charSequence2;
                if (charSequence2.contains("\n")) {
                    this.f282165e = true;
                    this.f282168i = this.f282168i.replace("\n", "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f282170a;

        /* renamed from: b, reason: collision with root package name */
        int f282171b;

        public b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f282170a = i3;
                this.f282171b = i16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        boolean a(ClickableImageSpan clickableImageSpan);

        void b(ClickableImageSpan clickableImageSpan);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74735);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            D = 1.0f;
        }
    }

    public RichStatusEditText(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f282158d = null;
        this.f282159e = null;
        this.f282161h = true;
        this.f282162i = new a();
        this.f282163m = -1;
        this.C = -1;
        m(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ClickableImageSpan clickableImageSpan = this.f282158d;
        if (clickableImageSpan != null) {
            clickableImageSpan.setDisselected(this);
            this.f282158d = null;
        }
    }

    private float g(float f16) {
        return Math.min((getWidth() - getTotalPaddingRight()) - 1, Math.max(0.0f, f16 - getTotalPaddingLeft())) + getScrollX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClickableImageSpan h(int i3, boolean z16, boolean z17) {
        for (ClickableImageSpan clickableImageSpan : (ClickableImageSpan[]) l().getSpans(0, getText().length(), ClickableImageSpan.class)) {
            int spanStart = l().getSpanStart(clickableImageSpan);
            int spanEnd = l().getSpanEnd(clickableImageSpan);
            if (i3 > spanStart && i3 < spanEnd) {
                return clickableImageSpan;
            }
            if (z16 && i3 == spanStart) {
                return clickableImageSpan;
            }
            if (z17 && i3 == spanEnd) {
                return clickableImageSpan;
            }
        }
        return null;
    }

    private int j(float f16) {
        return getLayout().getLineForVertical((int) (Math.min((getHeight() - getTotalPaddingBottom()) - 1, Math.max(0.0f, f16 - getTotalPaddingTop())) + getScrollY()));
    }

    private int k(int i3, float f16) {
        return getLayout().getOffsetForHorizontal(i3, g(f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spannable l() {
        return getText();
    }

    private int n(int i3, float f16, float f17) {
        boolean z16;
        ClickableImageSpan h16 = h(i3, false, true);
        ClickableImageSpan h17 = h(i3, true, false);
        if (h16 != null) {
            int spanEnd = l().getSpanEnd(h16);
            if (i3 != spanEnd) {
                return i3;
            }
            if (spanEnd != getText().length() && h17 == null) {
                z16 = false;
            } else {
                this.f282161h = false;
                getText().insert(spanEnd, " ");
                z16 = true;
            }
            int offsetForPosition = getOffsetForPosition((getTextSize() * D) + f16, f17);
            if (z16) {
                getText().replace(spanEnd, spanEnd + 1, "");
                this.f282161h = true;
            }
            if (offsetForPosition == spanEnd) {
                return offsetForPosition - 1;
            }
        }
        if (h17 != null) {
            int spanStart = l().getSpanStart(h17);
            if (i3 != spanStart) {
                return i3;
            }
            if (spanStart != 0 && h16 == null) {
                int offsetForPosition2 = getOffsetForPosition(f16 - (getTextSize() * D), f17);
                if (offsetForPosition2 == spanStart) {
                    return offsetForPosition2 + 1;
                }
            } else {
                this.f282161h = false;
                getText().insert(spanStart, " ");
                int offsetForPosition3 = getOffsetForPosition(f16 - (getTextSize() * D), f17);
                getText().replace(spanStart, spanStart + 1, "");
                this.f282161h = true;
                if (offsetForPosition3 - 1 == spanStart) {
                    return offsetForPosition3;
                }
            }
        }
        return i3;
    }

    private int o(int i3, float f16, float f17) {
        ClickableImageSpan h16;
        c cVar;
        int n3 = n(i3, f16, f17);
        if (n3 == 0 && (h16 = h(n3, true, false)) != null && (cVar = this.f282159e) != null && !cVar.a(h16)) {
            return n3 + 1;
        }
        return n3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, int i16) {
        ClickableImageSpan[] clickableImageSpanArr = (ClickableImageSpan[]) l().getSpans(i3, i16 + i3, ClickableImageSpan.class);
        for (ClickableImageSpan clickableImageSpan : clickableImageSpanArr) {
            c cVar = this.f282159e;
            if (cVar != null) {
                cVar.b(clickableImageSpan);
            }
            if (clickableImageSpan == this.f282158d) {
                this.f282158d = null;
            }
            l().removeSpan(clickableImageSpan);
        }
    }

    private ClickableImageSpan s(ClickableImageSpan clickableImageSpan) {
        if (clickableImageSpan != null) {
            clickableImageSpan.setSelected(this);
        }
        return clickableImageSpan;
    }

    @Override // android.widget.TextView
    public int getOffsetForPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Float.valueOf(f17))).intValue();
        }
        if (getLayout() == null) {
            return -1;
        }
        return k(j(f17), f16);
    }

    public b i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (b) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        int length = getText().length();
        if (i3 >= 0 && i3 <= length) {
            int i16 = 0;
            for (ImageSpan imageSpan : (ImageSpan[]) l().getSpans(0, length, ImageSpan.class)) {
                int spanStart = l().getSpanStart(imageSpan);
                int spanEnd = l().getSpanEnd(imageSpan);
                if (spanEnd <= i3 && spanEnd > i16) {
                    i16 = spanEnd;
                } else if (spanStart >= i3 && spanStart < length) {
                    length = spanStart;
                }
            }
            return new b(i16, length);
        }
        return new b(length, length);
    }

    public void m(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            addTextChangedListener(this.f282162i);
            this.f282160f = context;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onCreateContextMenu(ContextMenu contextMenu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) contextMenu);
            return;
        }
        super.onCreateContextMenu(contextMenu);
        contextMenu.removeItem(16908319);
        if (getSelectionEnd() == getSelectionStart()) {
            contextMenu.removeItem(16908321);
            contextMenu.removeItem(16908320);
        }
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 67 && keyEvent.getAction() == 0) {
            if (this.f282158d != null) {
                int spanStart = l().getSpanStart(this.f282158d);
                p(this.f282158d, true, true);
                this.f282158d = null;
                setSelection(spanStart);
                setCursorVisible(true);
                return true;
            }
            if (getSelectionStart() != getSelectionEnd()) {
                q(getSelectionStart(), getSelectionEnd() - getSelectionStart());
                return super.onKeyDown(i3, keyEvent);
            }
            ClickableImageSpan h16 = h(getSelectionStart(), false, true);
            if (h16 != null) {
                if (h16.isEnable()) {
                    this.f282158d = s(h16);
                    setCursorVisible(false);
                }
                return true;
            }
        } else if (i3 == 21 && keyEvent.getAction() == 0) {
            if (this.f282158d != null) {
                setCursorVisible(true);
                int spanStart2 = l().getSpanStart(this.f282158d);
                setSelection(spanStart2, spanStart2);
                f();
                return true;
            }
        } else if (i3 == 22 && keyEvent.getAction() == 0 && this.f282158d != null) {
            setCursorVisible(true);
            int spanEnd = l().getSpanEnd(this.f282158d);
            setSelection(spanEnd, spanEnd);
            f();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) parcelable);
            return;
        }
        this.f282161h = false;
        Editable text = getText();
        super.onRestoreInstanceState(parcelable);
        setText(text);
        this.f282161h = true;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i3, int i16) {
        ClickableImageSpan h16;
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != i16 && ((ClickableImageSpan[]) l().getSpans(Math.min(i3, i16), Math.max(i3, i16), ClickableImageSpan.class)).length != 0) {
            if (i3 == 0 && i16 == getText().length()) {
                b i17 = i(this.f282163m);
                this.f282163m = i17.f282170a;
                this.C = i17.f282171b;
            }
        } else if (i3 != i16 || i3 != 0 || (h16 = h(0, true, false)) == null || (cVar = this.f282159e) == null || cVar.a(h16)) {
            z16 = false;
        }
        if (z16) {
            if (this.C == -1 && this.f282163m == -1) {
                int length = getText().length();
                this.C = length;
                this.f282163m = length;
            }
            try {
                setSelection(this.f282163m, this.C);
                return;
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
        this.f282163m = i3;
        this.C = i16;
        super.onSelectionChanged(i3, i16);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MqqHandler handler;
        MqqHandler handler2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (isFocused() && getSelectionEnd() == getSelectionStart() && (action == 0 || action == 2 || action == 3 || action == 1)) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int offsetForPosition = getOffsetForPosition(x16, y16);
            if (offsetForPosition != -1) {
                offsetForPosition = o(offsetForPosition, x16, y16);
            }
            boolean z16 = false;
            ClickableImageSpan h16 = h(offsetForPosition, false, false);
            if (action == 0) {
                if (this.f282158d != null) {
                    f();
                }
                this.f282158d = h16;
                if (h16 != null) {
                    setCursorVisible(false);
                }
            } else if (action == 1 || action == 3) {
                setCursorVisible(true);
            }
            if (h16 == null && this.f282158d != null) {
                motionEvent.setAction(3);
            }
            ClickableImageSpan clickableImageSpan = this.f282158d;
            if (clickableImageSpan != null) {
                z16 = clickableImageSpan.onTouch(this, motionEvent);
                if (action == 1 || action == 3) {
                    this.f282158d = null;
                }
            }
            if (action == 1 && (handler2 = ((BaseActivity) this.f282160f).app.getHandler(EditActivity.class)) != null) {
                handler2.sendMessage(handler2.obtainMessage(4));
            }
            if (z16) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (action == 1 && (handler = ((BaseActivity) this.f282160f).app.getHandler(EditActivity.class)) != null) {
            handler.sendMessage(handler.obtainMessage(4));
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(ClickableImageSpan clickableImageSpan, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, clickableImageSpan, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        c cVar = this.f282159e;
        if (cVar != null && z17) {
            cVar.b(clickableImageSpan);
        }
        if (this.f282158d == clickableImageSpan) {
            this.f282158d = null;
        }
        if (!z16) {
            l().removeSpan(clickableImageSpan);
            return;
        }
        int spanStart = l().getSpanStart(clickableImageSpan);
        int spanEnd = l().getSpanEnd(clickableImageSpan);
        l().removeSpan(clickableImageSpan);
        if (spanStart != -1) {
            getText().replace(spanStart, spanEnd, "", 0, 0);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f282158d != null) {
            return true;
        }
        return super.performLongClick();
    }

    public void r(ClickableImageSpan clickableImageSpan, ClickableImageSpan clickableImageSpan2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) clickableImageSpan, (Object) clickableImageSpan2);
            return;
        }
        if (clickableImageSpan == this.f282158d) {
            this.f282158d = clickableImageSpan2;
        }
        int spanStart = l().getSpanStart(clickableImageSpan);
        int spanEnd = l().getSpanEnd(clickableImageSpan);
        if (spanStart != -1 && spanEnd != -1) {
            p(clickableImageSpan, false, false);
            setSpan(clickableImageSpan2, spanStart, spanEnd);
        }
    }

    public void setEditListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.f282159e = cVar;
        }
    }

    public void setSpan(ImageSpan imageSpan, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, imageSpan, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            l().setSpan(imageSpan, i3, i16, 33);
        }
    }

    public RichStatusEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f282158d = null;
        this.f282159e = null;
        this.f282161h = true;
        this.f282162i = new a();
        this.f282163m = -1;
        this.C = -1;
        m(context);
    }

    public RichStatusEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f282158d = null;
        this.f282159e = null;
        this.f282161h = true;
        this.f282162i = new a();
        this.f282163m = -1;
        this.C = -1;
        m(context);
    }
}
