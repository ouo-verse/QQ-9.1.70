package com.tencent.biz.qqcircle.immersive.viewmodel.newbarrage.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBlackStrokeTextView extends RFWAsyncRichTextView {

    /* renamed from: h, reason: collision with root package name */
    private TextView f90264h;

    public QFSBlackStrokeTextView(Context context) {
        this(context, null);
    }

    private void e() {
        TextPaint paint = this.f90264h.getPaint();
        paint.setStrokeWidth(2.0f);
        paint.setStyle(Paint.Style.STROKE);
        this.f90264h.setTextColor(-16777216);
        this.f90264h.setGravity(getGravity());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f90264h.draw(canvas);
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f90264h.layout(i3, i16, i17, i18);
    }

    @Override // com.tencent.richframework.text.rich.RFWSafeTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        CharSequence text = this.f90264h.getText();
        if (text == null || !text.equals(getText())) {
            this.f90264h.setText(getText());
            postInvalidate();
        }
        super.onMeasure(i3, i16);
        this.f90264h.measure(i3, i16);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f90264h.setLayoutParams(layoutParams);
    }

    public QFSBlackStrokeTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSBlackStrokeTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90264h = null;
        this.f90264h = new TextView(getContext(), attributeSet, i3);
        setSpecialClickAreaColor(R.color.cla);
        setNeedSpecialAreaBold(false);
        e();
    }
}
