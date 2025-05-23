package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class BlockableEditTextView extends EditText {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f211498d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f211499e;

    /* renamed from: f, reason: collision with root package name */
    int f211500f;

    /* renamed from: h, reason: collision with root package name */
    int f211501h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements ActionMode.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlockableEditTextView.this);
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) actionMode, (Object) menu)).booleanValue();
            }
            if (BlockableEditTextView.this.f211498d != 0) {
                return BlockableEditTextView.this.d();
            }
            return true;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f211503d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f211504e;

        /* renamed from: f, reason: collision with root package name */
        int f211505f;

        /* renamed from: h, reason: collision with root package name */
        int f211506h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f211507i;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlockableEditTextView.this);
                return;
            }
            this.f211503d = 0;
            this.f211504e = "";
            this.f211505f = -1;
            this.f211506h = -1;
            this.f211507i = false;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            if (!this.f211507i && (i3 = this.f211503d) != 0 && i3 < 0) {
                if (BlockableEditTextView.this.f211498d == 2) {
                    this.f211507i = true;
                    BlockableEditTextView.this.setText(this.f211504e);
                    this.f211507i = false;
                } else {
                    this.f211507i = true;
                    BlockableEditTextView blockableEditTextView = BlockableEditTextView.this;
                    CharSequence charSequence = this.f211504e;
                    blockableEditTextView.setText(TextUtils.concat(charSequence.subSequence(this.f211506h, charSequence.length()), this.f211504e.subSequence(0, this.f211505f)));
                    this.f211507i = false;
                    BlockableEditTextView.this.setSelection(this.f211505f);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            Editable editableText;
            c[] cVarArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (!this.f211507i && BlockableEditTextView.this.f211498d != 0) {
                this.f211503d = 0;
                if (i17 != i16 && (editableText = BlockableEditTextView.this.getEditableText()) != null && (cVarArr = (c[]) editableText.getSpans(i3, i3, c.class)) != null && cVarArr.length > 0) {
                    this.f211505f = editableText.getSpanStart(cVarArr[0]);
                    int spanEnd = editableText.getSpanEnd(cVarArr[0]);
                    this.f211506h = spanEnd;
                    if (spanEnd >= 0 && spanEnd >= this.f211505f && i16 > i17 && BlockableEditTextView.this.f211498d != 0 && i3 != this.f211505f && i3 != this.f211506h) {
                        this.f211504e = new SpannableStringBuilder(charSequence).subSequence(0, charSequence.length());
                        this.f211503d = -1;
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
    }

    public BlockableEditTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f211498d = 0;
        this.f211499e = false;
        this.f211500f = -1;
        this.f211501h = -1;
        c();
    }

    private void c() {
        setEditableFactory(TroopBarPublishUtils.f293664c);
        setCustomSelectionActionModeCallback(new a());
        addTextChangedListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (getEditableText() == null) {
            return false;
        }
        c[] cVarArr = (c[]) getEditableText().getSpans(selectionStart, selectionEnd, c.class);
        if (cVarArr != null && cVarArr.length > 0 && (cVarArr[0] instanceof c)) {
            int spanEnd = getEditableText().getSpanEnd(cVarArr[0]);
            int spanStart = getEditableText().getSpanStart(cVarArr[0]);
            if (spanStart >= 0 && spanEnd > spanStart) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onCreateContextMenu(ContextMenu contextMenu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) contextMenu);
        } else {
            d();
            super.onCreateContextMenu(contextMenu);
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i3, int i16) {
        c[] cVarArr;
        int spanEnd;
        int spanStart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onSelectionChanged(i3, i16);
        if (getEditableText() != null && (cVarArr = (c[]) getEditableText().getSpans(i3, i16, c.class)) != null && cVarArr.length > 0 && (spanEnd = getEditableText().getSpanEnd(cVarArr[0])) > (spanStart = getEditableText().getSpanStart(cVarArr[0])) && spanStart >= 0) {
            if (i3 == spanStart && i16 == spanStart && this.f211499e) {
                setSelection(spanEnd);
                return;
            }
            if (this.f211498d > 0) {
                if (i3 < spanEnd || i16 < spanEnd) {
                    if (i3 > spanStart || i16 > spanStart) {
                        if (i3 <= spanStart && i16 <= spanEnd) {
                            setSelection(i3, spanStart);
                            return;
                        }
                        if (i3 >= spanStart && i16 <= spanEnd) {
                            setSelection(spanStart);
                            return;
                        }
                        if (i3 >= spanStart && i16 >= spanEnd) {
                            setSelection(spanEnd, i16);
                        } else if (i3 <= spanStart && i16 >= spanEnd) {
                            setSelection(i3, spanStart);
                        }
                    }
                }
            }
        }
    }

    public void setBlockFront(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f211499e = z16;
        }
    }

    public void setEditStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f211498d = i3;
        }
    }

    public BlockableEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f211498d = 0;
        this.f211499e = false;
        this.f211500f = -1;
        this.f211501h = -1;
        c();
    }

    public BlockableEditTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f211498d = 0;
        this.f211499e = false;
        this.f211500f = -1;
        this.f211501h = -1;
        c();
    }
}
