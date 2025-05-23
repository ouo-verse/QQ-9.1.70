package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI;

/* loaded from: classes19.dex */
public class QAdInteractiveImmersiveProgressView extends QAdFeedBaseUI<bx2.a, Object> {
    protected SeekBar C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public QAdInteractiveImmersiveProgressView(Context context) {
        super(context);
        h(context);
    }

    protected void h(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fsl, this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.f28610je);
        this.C = seekBar;
        seekBar.incrementProgressBy(10);
        this.C.setMax(1000);
        this.C.setOnTouchListener(new a());
    }

    public void setProgress(int i3) {
        SeekBar seekBar = this.C;
        if (seekBar != null) {
            seekBar.setProgress(i3);
        }
    }

    public QAdInteractiveImmersiveProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
    }

    public QAdInteractiveImmersiveProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        h(context);
    }
}
