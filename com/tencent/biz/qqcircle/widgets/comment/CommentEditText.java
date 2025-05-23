package com.tencent.biz.qqcircle.widgets.comment;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommentEditText extends EditText {

    /* renamed from: d, reason: collision with root package name */
    private d f93549d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class AtSpan extends StyleSpan {

        /* renamed from: d, reason: collision with root package name */
        public HostSelectMemberUtils.QCircleResultData f93551d;

        public AtSpan(HostSelectMemberUtils.QCircleResultData qCircleResultData, int i3) {
            super(i3);
            this.f93551d = qCircleResultData;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements OnPromiseRejected {
        b() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
        public void onFail(String str) {
            RFWLog.fatal("CommentEditText", RFWLog.USR, new RuntimeException("ICommentAtIoc  error = " + str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtSpan f93556a;

        c(AtSpan atSpan) {
            this.f93556a = atSpan;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(com.tencent.biz.qqcircle.comment.at.a aVar) {
            aVar.b(this.f93556a.f93551d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a(View view);
    }

    public CommentEditText(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Editable editable, int i3, int i16) {
        if (i3 < i16 && !TextUtils.isEmpty(editable)) {
            for (AtSpan atSpan : (AtSpan[]) editable.getSpans(0, editable.length(), AtSpan.class)) {
                if (atSpan != null) {
                    int spanStart = editable.getSpanStart(atSpan);
                    int spanEnd = editable.getSpanEnd(atSpan);
                    if (i3 == spanEnd) {
                        editable.replace(spanStart, spanEnd, "");
                        f(atSpan);
                        return;
                    }
                }
            }
        }
    }

    private void f(AtSpan atSpan) {
        RFWIocAbilityProvider.g().getIoc(com.tencent.biz.qqcircle.comment.at.a.class).originView(this).done(new c(atSpan)).fail(new b()).run();
    }

    public void c(Spannable spannable, int i3, int i16, HostSelectMemberUtils.QCircleResultData qCircleResultData) {
        spannable.setSpan(new AtSpan(qCircleResultData, 0) { // from class: com.tencent.biz.qqcircle.widgets.comment.CommentEditText.2
            @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(QFSQUIUtilsKt.d(CommentEditText.this.getContext(), R.color.qui_common_text_link));
            }
        }, i3, i16, 33);
    }

    public void d(String str, HostSelectMemberUtils.QCircleResultData qCircleResultData) {
        SpannableString spannableString = new SpannableString(str + " ");
        c(spannableString, 0, spannableString.length() + (-1), qCircleResultData);
        getText().insert(getSelectionStart(), spannableString);
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (getContext() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager == null) {
                return super.dispatchKeyEventPreIme(keyEvent);
            }
            if (inputMethodManager.isActive() && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                getHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.comment.CommentEditText.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CommentEditText.this.f93549d != null) {
                            CommentEditText.this.f93549d.a(CommentEditText.this);
                        }
                    }
                }, 50L);
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public void g(HostSelectMemberUtils.QCircleResultData qCircleResultData) {
        Editable text = getText();
        for (AtSpan atSpan : (AtSpan[]) text.getSpans(0, text.length(), AtSpan.class)) {
            if (atSpan != null && TextUtils.equals(atSpan.f93551d.uin, qCircleResultData.uin)) {
                text.replace(text.getSpanStart(atSpan), text.getSpanEnd(atSpan) + 1, "");
                return;
            }
        }
    }

    public void setOnInputBackListener(d dVar) {
        this.f93549d = dVar;
    }

    public CommentEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addTextChangedListener(new a());
    }

    public CommentEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        String f93552d = null;

        /* renamed from: e, reason: collision with root package name */
        int f93553e = -1;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str = this.f93552d;
            if (str != null) {
                try {
                    int i3 = this.f93553e;
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
                this.f93553e = CommentEditText.this.getSelectionEnd();
                this.f93552d = charSequence.subSequence(0, indexOf).toString() + ((Object) charSequence.subSequence(i18, charSequence.length()));
            } else {
                this.f93552d = null;
            }
            if (i16 > 0) {
                CommentEditText.this.e((Editable) charSequence, i3, i16 + i3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
