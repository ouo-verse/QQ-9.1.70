package com.tencent.richframework.text.rich.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BoldClickableSpan extends ClickableSpan {
    private int mClickAreaColor;
    private boolean mNeedBold;
    private Object mRespondObj;
    private WeakReference<OnClickBoldTextListener> mWeakListener;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnClickBoldTextListener {
        void onClick(Object obj);
    }

    public BoldClickableSpan(OnClickBoldTextListener onClickBoldTextListener, int i3, boolean z16) {
        this.mWeakListener = new WeakReference<>(onClickBoldTextListener);
        this.mClickAreaColor = i3;
        this.mNeedBold = z16;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        OnClickBoldTextListener onClickBoldTextListener;
        WeakReference<OnClickBoldTextListener> weakReference = this.mWeakListener;
        if (weakReference == null) {
            onClickBoldTextListener = null;
        } else {
            onClickBoldTextListener = weakReference.get();
        }
        if (onClickBoldTextListener != null) {
            onClickBoldTextListener.onClick(this.mRespondObj);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i3 = this.mClickAreaColor;
        if (i3 != 0) {
            textPaint.setColor(i3);
        }
        textPaint.setUnderlineText(false);
        if (this.mNeedBold) {
            textPaint.setFakeBoldText(true);
        }
    }

    public BoldClickableSpan(OnClickBoldTextListener onClickBoldTextListener, int i3, boolean z16, Object obj) {
        this.mWeakListener = new WeakReference<>(onClickBoldTextListener);
        this.mClickAreaColor = i3;
        this.mNeedBold = z16;
        this.mRespondObj = obj;
    }
}
