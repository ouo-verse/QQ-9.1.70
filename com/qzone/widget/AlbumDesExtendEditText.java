package com.qzone.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import com.qzone.util.ar;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AlbumDesExtendEditText extends ExtendEditText {
    private int Q;

    public AlbumDesExtendEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = 7;
    }

    @Override // com.qzone.widget.ExtendEditText
    protected void c() {
        Layout layout;
        if (QZLog.isColorLevel()) {
            QZLog.d("AlbumDesExtendEditText", 2, "ajustLinePosition");
        }
        if (this.f60348h == getLineCount() || (layout = getLayout()) == null) {
            return;
        }
        int i3 = i();
        int lineTop = layout.getLineTop(i3);
        int lineBottom = layout.getLineBottom(i3);
        int scrollY = getScrollY();
        int scrollX = getScrollX();
        getTextSize();
        ar.e(3.0f);
        if (Math.abs(scrollY - lineTop) > Math.abs(lineBottom - scrollY)) {
            lineTop = lineBottom;
        }
        scrollTo(scrollX, lineTop);
    }

    @Override // com.qzone.widget.ExtendEditText
    protected void d() {
        int lineCount;
        if (QZLog.isColorLevel()) {
            QZLog.d("AlbumDesExtendEditText", 2, "ajustLineScollDown");
        }
        Layout layout = getLayout();
        if (layout != null && (lineCount = getLineCount() - this.Q) >= 0) {
            scrollTo(getScrollX(), layout.getLineTop(lineCount));
        }
    }

    @Override // com.qzone.widget.ExtendEditText
    protected void e() {
        int lineCount;
        if (QZLog.isColorLevel()) {
            QZLog.d("AlbumDesExtendEditText", 2, "ajustLineScollUp");
        }
        Layout layout = getLayout();
        if (layout != null && (lineCount = getLineCount() - this.Q) >= 0) {
            scrollTo(getScrollX(), layout.getLineTop(lineCount));
        }
    }

    @Override // com.qzone.widget.ExtendEditText, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        if (QZLog.isColorLevel()) {
            QZLog.d("AlbumDesExtendEditText", 2, "onTextChanged");
        }
        int lineCount = getLineCount();
        int i18 = this.f60348h;
        if (i18 != lineCount) {
            if (i18 < lineCount) {
                if (lineCount > this.Q) {
                    e();
                }
            } else if (lineCount >= this.Q) {
                d();
            }
            this.f60348h = lineCount;
            return;
        }
        c();
    }

    @Override // com.qzone.widget.ExtendEditText
    public void setMaxLineToScrollAlways(int i3) {
        this.Q = i3;
    }
}
