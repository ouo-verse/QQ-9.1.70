package com.qzone.reborn.qzmoment.comment;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMCommentEditText extends EditText {

    /* renamed from: d, reason: collision with root package name */
    private b f58840d;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void a(View view);
    }

    public QZMCommentEditText(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (getContext() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager == null) {
                return super.dispatchKeyEventPreIme(keyEvent);
            }
            if (inputMethodManager.isActive() && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                getHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentEditText.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZMCommentEditText.this.f58840d != null) {
                            QZMCommentEditText.this.f58840d.a(QZMCommentEditText.this);
                        }
                    }
                }, 50L);
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public void setOnInputBackListener(b bVar) {
        this.f58840d = bVar;
    }

    public QZMCommentEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addTextChangedListener(new a());
    }

    public QZMCommentEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        String f58841d = null;

        /* renamed from: e, reason: collision with root package name */
        int f58842e = -1;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str = this.f58841d;
            if (str != null) {
                try {
                    int i3 = this.f58842e;
                    QZMCommentEditText.this.setText(str);
                    if (i3 > QZMCommentEditText.this.length()) {
                        QZMCommentEditText qZMCommentEditText = QZMCommentEditText.this;
                        qZMCommentEditText.setSelection(qZMCommentEditText.length());
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
            if (indexOf >= i3 && indexOf < (i18 = i3 + i17) && (indexOf2 > i18 || indexOf2 == -1)) {
                this.f58842e = QZMCommentEditText.this.getSelectionEnd();
                this.f58841d = charSequence.subSequence(0, indexOf).toString() + ((Object) charSequence.subSequence(i18, charSequence.length()));
                return;
            }
            this.f58841d = null;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
