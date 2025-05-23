package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQVideoView extends VideoView {
    private int mHeight;
    private int mWidth;

    public QQVideoView(Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void release() {
        setOnPreparedListener(null);
        setOnErrorListener(null);
        setOnCompletionListener(null);
    }

    public void setDimension(int i3, int i16) {
        this.mWidth = i3;
        this.mHeight = i16;
    }

    public QQVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QQVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
