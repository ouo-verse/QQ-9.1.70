package com.tencent.mobileqq.businessCard.views;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ClearEllipsisEditText extends ClearableEditText {
    static IPatchRedirector $redirector_;
    private int G;
    private int H;
    private String I;
    private boolean J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClearEllipsisEditText.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (ClearEllipsisEditText.this.J && !ClearEllipsisEditText.this.K) {
                ClearEllipsisEditText.this.I = charSequence.toString();
            }
            ClearEllipsisEditText.this.K = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClearEllipsisEditText.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (ClearEllipsisEditText.this.getCompoundDrawables()[2] == null) {
                return false;
            }
            if (motionEvent.getX() > (ClearEllipsisEditText.this.getWidth() - ClearEllipsisEditText.this.getPaddingRight()) - ClearEllipsisEditText.this.c().getIntrinsicWidth()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (motionEvent.getAction() != 0 || !z16) {
                return false;
            }
            ClearEllipsisEditText.this.setText("");
            ClearEllipsisEditText.this.setClearButtonVisible(false);
            return true;
        }
    }

    public ClearEllipsisEditText(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.I = "";
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = Integer.MAX_VALUE;
        this.N = 2;
        n();
    }

    private String l(String str) {
        if (str != null && this.L) {
            int length = str.length();
            if (this.N == 1) {
                length = str.getBytes().length;
            }
            while (length > this.M) {
                str = str.substring(0, str.length() - 1);
                length = str.length();
                if (this.N == 1) {
                    length = str.getBytes().length;
                }
            }
            return str;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private void n() {
        addTextChangedListener(new a());
        setOnTouchListener(new b());
    }

    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.ClearableEditText, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z16, int i3, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), rect);
            return;
        }
        super.onFocusChanged(z16, i3, rect);
        try {
            if (!z16) {
                this.J = false;
                this.I = getText().toString();
                setEllipsisText(getText().toString());
            } else {
                this.J = true;
                setText(this.I);
            }
        } catch (Throwable th5) {
            QLog.e("ClearEllipsisEditText", 1, "onFocusChanged fail!", th5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        this.G = getMeasuredHeight();
        this.H = getMeasuredWidth();
    }

    public void setEllipsisText(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        this.I = l(str);
        if (this.H <= 0) {
            post(new Runnable(str2) { // from class: com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f200909d;

                {
                    this.f200909d = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClearEllipsisEditText.this, (Object) str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ClearEllipsisEditText.this.K = true;
                        ClearEllipsisEditText clearEllipsisEditText = ClearEllipsisEditText.this;
                        clearEllipsisEditText.H = clearEllipsisEditText.getMeasuredWidth();
                        ClearEllipsisEditText.this.setText(this.f200909d);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        } else {
            this.K = true;
            setText(str2);
        }
    }

    public void setMaxLength(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 != 1 && i16 != 2) {
            this.N = 2;
        } else {
            this.N = i16;
        }
        this.L = true;
        this.M = i3;
    }

    public ClearEllipsisEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.I = "";
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = Integer.MAX_VALUE;
        this.N = 2;
        n();
    }

    public ClearEllipsisEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.I = "";
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = Integer.MAX_VALUE;
        this.N = 2;
        n();
    }
}
