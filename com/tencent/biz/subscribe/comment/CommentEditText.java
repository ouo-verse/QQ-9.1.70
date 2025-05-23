package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinIgnoreTypeface;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommentEditText extends EditText implements ISkinIgnoreTypeface {

    /* renamed from: d, reason: collision with root package name */
    private b f95851d;

    /* renamed from: e, reason: collision with root package name */
    private int f95852e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(View view);
    }

    public CommentEditText(Context context) {
        super(context);
        this.f95852e = 140;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        Handler handler;
        if (getContext() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager == null) {
                return super.dispatchKeyEventPreIme(keyEvent);
            }
            if (inputMethodManager.isActive() && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && (handler = getHandler()) != null) {
                handler.postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentEditText.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CommentEditText.this.f95851d != null) {
                            CommentEditText.this.f95851d.a(CommentEditText.this);
                        }
                    }
                }, 50L);
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public void setMaxLength(int i3) {
        this.f95852e = i3;
    }

    public void setOnInputBackListener(b bVar) {
        this.f95851d = bVar;
    }

    public CommentEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95852e = 140;
        addTextChangedListener(new a());
    }

    public CommentEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95852e = 140;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        String f95853d = null;

        /* renamed from: e, reason: collision with root package name */
        int f95854e = -1;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str = this.f95853d;
            if (str != null) {
                try {
                    int i3 = this.f95854e;
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
            if (indexOf >= i3 && indexOf < (i18 = i3 + i17) && (indexOf2 > i18 || indexOf2 == -1)) {
                this.f95854e = CommentEditText.this.getSelectionEnd();
                this.f95853d = charSequence.subSequence(0, indexOf).toString() + ((Object) charSequence.subSequence(i18, charSequence.length()));
                return;
            }
            this.f95853d = null;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
