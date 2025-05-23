package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.media.QUISeekBar;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSeekBar extends QUISeekBar {
    private final com.tencent.biz.qqcircle.helpers.x S;

    public QFSSeekBar(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.tencent.widget.media.QUISeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            QLog.e("QFSSeekBar", 1, "isEnabled = false");
            return false;
        }
        return a().onTouchEvent(this.S.a(motionEvent, a()));
    }

    @Override // com.tencent.widget.media.QUISeekBar
    public void setMax(int i3) {
        a().setMax(i3);
    }

    @Override // com.tencent.widget.media.QUISeekBar
    public void setProgress(int i3) {
        a().setProgress(i3);
    }

    public QFSSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public QFSSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.S = new com.tencent.biz.qqcircle.helpers.x();
    }

    @Override // com.tencent.widget.media.QUISeekBar, com.tencent.widget.media.a
    public View d() {
        return this;
    }
}
