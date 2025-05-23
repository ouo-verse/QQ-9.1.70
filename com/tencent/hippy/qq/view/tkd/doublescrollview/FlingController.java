package com.tencent.hippy.qq.view.tkd.doublescrollview;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FlingController {
    private static final int MSG_FLING = 95;
    private static final String TAG = "FlingController";
    private static final int absA = 300;

    /* renamed from: a, reason: collision with root package name */
    private int f114169a;
    private IDoubleScroll flingListener;
    private int mVelocity;
    private int fps = 50;
    public boolean isFling = false;
    private Handler handler = new Handler() { // from class: com.tencent.hippy.qq.view.tkd.doublescrollview.FlingController.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 95) {
                int i3 = -FlingController.this.computeDistance();
                FlingController flingController = FlingController.this;
                if (flingController.isFling) {
                    flingController.flingListener.notifyNestViewToFling(0, i3);
                }
                if (Math.abs(i3) < 5 || Math.abs(FlingController.this.mVelocity) < 10) {
                    FlingController.this.finish();
                }
                FlingController flingController2 = FlingController.this;
                if (flingController2.isFling) {
                    flingController2.handler.sendEmptyMessageDelayed(95, 10L);
                }
            }
        }
    };
    private MyVelocity myVelocity = new MyVelocity();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class MyVelocity {
        private int max;
        private int length = 5;

        /* renamed from: ys, reason: collision with root package name */
        private FixLengthQueue f114170ys = new FixLengthQueue(5);
        private FixLengthQueue times = new FixLengthQueue(this.length);

        public int getVelocity() {
            long first = this.times.getFirst() - this.times.getEnd();
            long first2 = (this.f114170ys.getFirst() - this.f114170ys.getEnd()) * 1000;
            if (first == 0) {
                return 0;
            }
            return (int) ((first2 / first) * 1.2d);
        }

        public void refreash() {
            this.f114170ys.refreash();
            this.times.refreash();
        }

        public void setY(int i3) {
            this.f114170ys.add(i3);
            this.times.add(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.mVelocity = 0;
        refreash();
        this.isFling = false;
    }

    private void refreash() {
        this.myVelocity.refreash();
    }

    public int computeDistance() {
        int i3 = this.mVelocity - this.f114169a;
        int pxToDp = ImmersiveUtils.pxToDp((r0 + i3) >> 1);
        this.mVelocity = i3;
        if (Math.abs(-pxToDp) < 5 || Math.abs(this.mVelocity) < 10) {
            finish();
        }
        return pxToDp;
    }

    public void setFlingListener(IDoubleScroll iDoubleScroll) {
        this.flingListener = iDoubleScroll;
    }

    public void setY(int i3) {
        this.myVelocity.setY(i3);
    }

    public void startFling() {
        int velocity = this.myVelocity.getVelocity();
        int i3 = this.fps;
        int i16 = (velocity / i3) * 3;
        this.mVelocity = i16;
        if (i16 < 0) {
            this.f114169a = (-300) / i3;
        } else {
            this.f114169a = 300 / i3;
        }
        Log.d(TAG, "mVelocity: " + this.mVelocity + "  a: " + this.f114169a);
        this.isFling = true;
    }

    public void stop() {
        finish();
    }
}
