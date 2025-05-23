package com.qzone.feed.ui.comment;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UserNameSapn extends ClickableSpan {
    private OnUserNameClickListener onUserNameClickListener;
    private String uin;
    private int userNameColor;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnUserNameClickListener {
        void onClick(String str);
    }

    public UserNameSapn(String str, int i3, OnUserNameClickListener onUserNameClickListener) {
        this.uin = str;
        this.userNameColor = i3;
        this.onUserNameClickListener = onUserNameClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        OnUserNameClickListener onUserNameClickListener;
        if (TextUtils.isEmpty(this.uin) || (onUserNameClickListener = this.onUserNameClickListener) == null) {
            return;
        }
        onUserNameClickListener.onClick(this.uin);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i3 = this.userNameColor;
        if (i3 > 0) {
            textPaint.setColor(i3);
        }
        textPaint.setUnderlineText(false);
    }
}
