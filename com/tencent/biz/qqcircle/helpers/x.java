package com.tencent.biz.qqcircle.helpers;

import android.view.MotionEvent;
import android.widget.SeekBar;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class x implements com.tencent.widget.media.b {

    /* renamed from: a, reason: collision with root package name */
    private float f84671a = 0.0f;

    private void b(float f16, SeekBar seekBar) {
        if (this.f84671a == 0.0f) {
            float progress = seekBar.getProgress() / seekBar.getMax();
            int measuredWidth = seekBar.getMeasuredWidth();
            float f17 = measuredWidth * progress;
            this.f84671a = f17 - f16;
            QLog.d("QFSSeekMotionEventHelper", 2, "calculateGAPX:" + this.f84671a + APLogFileUtil.SEPARATOR_LOG + f17 + "|" + progress + "|" + measuredWidth);
        }
    }

    @Override // com.tencent.widget.media.b
    public MotionEvent a(MotionEvent motionEvent, SeekBar seekBar) {
        if (motionEvent != null && seekBar != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return motionEvent;
                    }
                } else {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 1, motionEvent.getX() + this.f84671a, motionEvent.getY(), 0);
                    this.f84671a = 0.0f;
                    return obtain;
                }
            }
            b(motionEvent.getX(), seekBar);
            return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 2, motionEvent.getX() + this.f84671a, motionEvent.getY(), 0);
        }
        return motionEvent;
    }
}
