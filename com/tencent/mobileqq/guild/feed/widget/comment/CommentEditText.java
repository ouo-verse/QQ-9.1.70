package com.tencent.mobileqq.guild.feed.widget.comment;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class CommentEditText extends EditText {

    /* renamed from: d, reason: collision with root package name */
    private c f224288d;

    /* renamed from: e, reason: collision with root package name */
    private Map<StyleSpan, b> f224289e;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class AtSpan extends StyleSpan {
        public AtSpan(int i3) {
            super(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b extends SpannableString {

        /* renamed from: d, reason: collision with root package name */
        private String f224295d;

        public b(CharSequence charSequence, String str) {
            super(charSequence);
            this.f224295d = str;
        }

        public String a() {
            return this.f224295d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class c extends InputFilter.LengthFilter {

        /* renamed from: d, reason: collision with root package name */
        private int f224296d;

        public c(int i3, CommentEditText commentEditText) {
            super(i3);
            this.f224296d = i3;
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int length = this.f224296d - (spanned.length() - (i18 - i17));
            if (length <= 0) {
                return "";
            }
            if (length >= i16 - i3) {
                return null;
            }
            int i19 = length + i3;
            if (Character.isHighSurrogate(charSequence.charAt(i19 - 1)) && i19 - 1 == i3) {
                return "";
            }
            return charSequence.subSequence(i3, i19);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface d {
    }

    public CommentEditText(Context context) {
        super(context);
        this.f224289e = new HashMap();
    }

    static /* bridge */ /* synthetic */ d a(CommentEditText commentEditText) {
        commentEditText.getClass();
        return null;
    }

    private Editable d(Editable editable) {
        Map<StyleSpan, b> map;
        if (editable != null && (map = this.f224289e) != null && map.size() != 0) {
            editable.setFilters(new InputFilter[0]);
            for (AtSpan atSpan : (AtSpan[]) editable.getSpans(0, editable.length(), AtSpan.class)) {
                b bVar = this.f224289e.get(atSpan);
                if (bVar != null) {
                    editable.replace(editable.getSpanStart(atSpan), editable.getSpanEnd(atSpan), bVar.a());
                }
            }
        }
        return editable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Editable editable, int i3, int i16) {
        if (i3 < i16 && !TextUtils.isEmpty(editable)) {
            for (AtSpan atSpan : (AtSpan[]) editable.getSpans(0, editable.length(), AtSpan.class)) {
                if (atSpan != null) {
                    int spanStart = editable.getSpanStart(atSpan);
                    int spanEnd = editable.getSpanEnd(atSpan);
                    if (i3 == spanEnd) {
                        editable.replace(spanStart, spanEnd, "");
                        return;
                    }
                }
            }
        }
    }

    private int j(AtSpan[] atSpanArr, int i3) {
        for (AtSpan atSpan : atSpanArr) {
            int spanStart = getText().getSpanStart(atSpan);
            int spanEnd = getText().getSpanEnd(atSpan) + 1;
            if (spanEnd > i3 && spanStart < i3) {
                if (spanEnd - i3 >= i3 - spanStart) {
                    return spanStart;
                }
                return spanEnd;
            }
        }
        return i3;
    }

    public void c(String str, String str2, final int i3) {
        if (h(str + " ")) {
            return;
        }
        b bVar = new b(str, str2);
        AtSpan atSpan = new AtSpan(0) { // from class: com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText.3
            @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                int i16 = i3;
                if (i16 != 0) {
                    textPaint.setColor(i16);
                } else {
                    textPaint.setColor(CommentEditText.this.getContext().getResources().getColor(R.color.btd));
                }
            }
        };
        bVar.setSpan(atSpan, 0, bVar.length(), 33);
        this.f224289e.put(atSpan, bVar);
        int selectionStart = getSelectionStart();
        getText().insert(selectionStart, " ");
        getText().insert(selectionStart, bVar);
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (getContext() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager == null) {
                return super.dispatchKeyEventPreIme(keyEvent);
            }
            if (inputMethodManager.isActive() && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                getHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CommentEditText.a(CommentEditText.this);
                    }
                }, 50L);
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public int e() {
        c cVar = this.f224288d;
        if (cVar != null) {
            return cVar.f224296d;
        }
        return Integer.MAX_VALUE;
    }

    public Editable f() {
        return d(getText());
    }

    public boolean h(CharSequence charSequence) {
        c cVar = this.f224288d;
        if (cVar == null || cVar.f224296d > getText().length() + charSequence.length()) {
            return false;
        }
        return true;
    }

    public boolean i(@NonNull String str, @NonNull CharSequence charSequence) {
        boolean z16;
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        Editable editableText = getEditableText();
        if (editableText == null) {
            setText(charSequence);
            return true;
        }
        if (((editableText.length() - (selectionEnd - selectionStart)) + charSequence.length()) - e() <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart && z16) {
            editableText.replace(selectionStart, selectionEnd, charSequence);
            return true;
        }
        if (!h(charSequence)) {
            append(charSequence);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, "[replaceSelection] over max length, start=" + selectionStart + ", end=" + selectionEnd + ", srcLength=" + charSequence.length() + ", dstLength=" + length());
        }
        return false;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i3, int i16) {
        super.onSelectionChanged(i3, i16);
        AtSpan[] atSpanArr = (AtSpan[]) getText().getSpans(0, getText().length(), AtSpan.class);
        setSelection(j(atSpanArr, i3), j(atSpanArr, i16));
    }

    public void setMaxWordLength(int i3) {
        if (i3 == 0) {
            return;
        }
        c cVar = this.f224288d;
        if (cVar != null) {
            cVar.f224296d = i3;
            return;
        }
        c cVar2 = new c(i3, this);
        this.f224288d = cVar2;
        setFilters(new InputFilter[]{cVar2});
    }

    public CommentEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f224289e = new HashMap();
        addTextChangedListener(new a());
    }

    public CommentEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f224289e = new HashMap();
    }

    public void setOnInputBackListener(d dVar) {
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        String f224292d = null;

        /* renamed from: e, reason: collision with root package name */
        int f224293e = -1;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str = this.f224292d;
            if (str != null) {
                try {
                    int i3 = this.f224293e;
                    CommentEditText.this.setText(str);
                    if (i3 > CommentEditText.this.length()) {
                        CommentEditText commentEditText = CommentEditText.this;
                        commentEditText.setSelection(commentEditText.length());
                    }
                } catch (Exception unused) {
                    QLog.e("CommentInputPopupWindow", 1, "setTextError");
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            int i18;
            int indexOf = charSequence.toString().indexOf("[/", i3);
            int indexOf2 = charSequence.toString().indexOf(93, i3);
            if (indexOf >= i3 && indexOf < (i18 = i17 + i3) && (indexOf2 > i18 || indexOf2 == -1)) {
                this.f224293e = CommentEditText.this.getSelectionEnd();
                this.f224292d = charSequence.subSequence(0, indexOf).toString() + ((Object) charSequence.subSequence(i18, charSequence.length()));
            } else {
                this.f224292d = null;
            }
            if (i16 > 0) {
                CommentEditText.this.g((Editable) charSequence, i3, i16 + i3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
