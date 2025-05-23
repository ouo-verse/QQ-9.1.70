package com.tencent.mobileqq.richstatus.topic;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.EditText;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TopicEditTextView extends EditText implements TextWatcher {
    static IPatchRedirector $redirector_;
    public static Editable.Factory D;
    ActionMode.Callback C;

    /* renamed from: d, reason: collision with root package name */
    private TextWatcher f282416d;

    /* renamed from: e, reason: collision with root package name */
    ITopic f282417e;

    /* renamed from: f, reason: collision with root package name */
    boolean f282418f;

    /* renamed from: h, reason: collision with root package name */
    int f282419h;

    /* renamed from: i, reason: collision with root package name */
    int f282420i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f282421m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Editable.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            }
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 1, 20);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements ActionMode.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TopicEditTextView.this);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) actionMode, (Object) menuItem)).booleanValue();
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return TopicEditTextView.this.d();
            }
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) actionMode, (Object) menu)).booleanValue();
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionMode);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionMode, (Object) menu)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74825);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            D = new a();
        }
    }

    public TopicEditTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f282421m = false;
        this.C = new b();
        c();
    }

    private void c() {
        setEditableFactory(D);
        setCustomSelectionActionModeCallback(this.C);
        super.addTextChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (getEditableText() == null) {
            return false;
        }
        ITopic[] iTopicArr = (ITopic[]) getEditableText().getSpans(selectionStart, selectionEnd, ITopic.class);
        if (iTopicArr != null && iTopicArr.length > 0 && (iTopicArr[0] instanceof ITopic)) {
            int spanEnd = getEditableText().getSpanEnd(iTopicArr[0]);
            int spanStart = getEditableText().getSpanStart(iTopicArr[0]);
            if (spanStart >= 0 && spanEnd > spanStart) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textWatcher);
        } else {
            this.f282416d = textWatcher;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) editable);
            return;
        }
        if (this.f282421m) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TopicEditTextView", 2, String.format("afterTextChanged [delTopic=%s] src=%s", this.f282417e, editable));
        }
        ITopic iTopic = this.f282417e;
        if (iTopic != null) {
            int spanStart = editable.getSpanStart(iTopic);
            int spanEnd = editable.getSpanEnd(this.f282417e);
            if (spanStart >= 0 && spanEnd > spanStart) {
                this.f282421m = true;
                editable.delete(spanStart, spanEnd);
                if (QLog.isColorLevel()) {
                    QLog.i("TopicEditTextView", 2, String.format("afterTextChanged after delete=%s", editable));
                }
                this.f282421m = false;
                setSelection(spanStart);
            }
        }
        TextWatcher textWatcher = this.f282416d;
        if (textWatcher != null) {
            textWatcher.afterTextChanged(editable);
        }
    }

    public void b(Exception exc) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) exc);
            return;
        }
        QLog.e("TopicEditTextView", 2, "handleException", exc);
        try {
            if (getEditableText().length() >= 0) {
                i3 = getEditableText().length();
            } else {
                i3 = 0;
            }
            setSelection(i3);
        } catch (Exception e16) {
            QLog.e("TopicEditTextView", 2, "handleException: setSelection", e16);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        boolean z16;
        Spannable spannable;
        ITopic c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.f282421m) {
            return;
        }
        this.f282417e = null;
        if ((charSequence instanceof Spannable) && (c16 = c.c((spannable = (Spannable) charSequence), i3)) != null) {
            int spanStart = spannable.getSpanStart(c16);
            int spanEnd = spannable.getSpanEnd(c16);
            if (spanEnd >= 0 && spanEnd >= spanStart && i16 > i17) {
                this.f282417e = c16;
            }
        }
        if (i17 >= i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f282418f = z16;
        this.f282419h = i3;
        this.f282420i = i17;
        if (QLog.isColorLevel()) {
            QLog.i("TopicEditTextView", 2, String.format("beforeTextChanged [bAdd=%b][delTopic=%s][edit=%s]", Boolean.valueOf(this.f282418f), this.f282417e, charSequence));
        }
        TextWatcher textWatcher = this.f282416d;
        if (textWatcher != null) {
            textWatcher.beforeTextChanged(charSequence, i3, i16, i17);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e16) {
            b(e16);
            return false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onCreateContextMenu(ContextMenu contextMenu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) contextMenu);
        } else if (d()) {
            super.onCreateContextMenu(contextMenu);
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i3, int i16) {
        ITopic[] iTopicArr;
        int spanEnd;
        int spanStart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onSelectionChanged(i3, i16);
        if (getEditableText() != null && (iTopicArr = (ITopic[]) getEditableText().getSpans(i3, i16, ITopic.class)) != null && iTopicArr.length > 0 && (spanEnd = getEditableText().getSpanEnd(iTopicArr[0])) > (spanStart = getEditableText().getSpanStart(iTopicArr[0])) && spanStart >= 0) {
            if (i3 == spanStart && i16 == spanEnd) {
                setSelection(spanEnd);
                return;
            }
            if (i3 < spanEnd || i16 < spanEnd) {
                if (i3 > spanStart || i16 > spanStart) {
                    setSelection(spanEnd, spanEnd);
                }
            }
        }
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        TextWatcher textWatcher = this.f282416d;
        if (textWatcher != null) {
            textWatcher.onTextChanged(charSequence, i3, i16, i17);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("TopicEditTextView", 2, th5.getMessage(), th5);
            }
            try {
                setSelection(getEditableText().length());
            } catch (Throwable unused) {
            }
            return true;
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        try {
            return super.performClick();
        } catch (Exception e16) {
            b(e16);
            return false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        try {
            return super.performLongClick();
        } catch (Exception e16) {
            b(e16);
            return false;
        }
    }

    public TopicEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f282421m = false;
        this.C = new b();
        c();
    }

    public TopicEditTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f282421m = false;
        this.C = new b();
        c();
    }
}
