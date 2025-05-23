package com.qzone.widget.util;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.util.Log;
import com.qzone.widget.util.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AbCircleFrameAnimDirector extends c {
    private int Q;
    private int R;
    private final Handler S;
    private boolean T;
    private long U;
    private UpdateFrameTask V;
    private long W;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class UpdateFrameTask implements Runnable {
        UpdateFrameTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this != AbCircleFrameAnimDirector.this.V) {
                AbCircleFrameAnimDirector.this.m();
                return;
            }
            long nanoTime = ((System.nanoTime() - AbCircleFrameAnimDirector.this.U) * AbCircleFrameAnimDirector.this.E) / 1000000000;
            Log.i("AbCircleFrameAnimDirect", "run: " + nanoTime);
            if (nanoTime > AbCircleFrameAnimDirector.this.W) {
                int i3 = (int) (nanoTime - AbCircleFrameAnimDirector.this.W);
                AbCircleFrameAnimDirector.this.W = nanoTime;
                int g16 = AbCircleFrameAnimDirector.this.g() + i3;
                if (AbCircleFrameAnimDirector.this.T && g16 > AbCircleFrameAnimDirector.this.R) {
                    Log.i("AbCircleFrameAnimDirect", "run: " + g16);
                    g16 = AbCircleFrameAnimDirector.this.Q == AbCircleFrameAnimDirector.this.R ? AbCircleFrameAnimDirector.this.Q : (((g16 - AbCircleFrameAnimDirector.this.R) - 1) % ((AbCircleFrameAnimDirector.this.R - AbCircleFrameAnimDirector.this.Q) + 1)) + AbCircleFrameAnimDirector.this.Q;
                }
                Log.i("AbCircleFrameAnimDirect", "run: " + AbCircleFrameAnimDirector.this.T + " " + g16);
                AbCircleFrameAnimDirector.this.w(g16);
                if (g16 < AbCircleFrameAnimDirector.this.j()) {
                    AbCircleFrameAnimDirector.this.S.postDelayed(AbCircleFrameAnimDirector.this.V, ValueAnimator.getFrameDelay());
                    return;
                }
                Log.i("AbCircleFrameAnimDirect", "run: end");
                AbCircleFrameAnimDirector.this.V = null;
                AbCircleFrameAnimDirector.this.m();
                return;
            }
            Log.i("AbCircleFrameAnimDirect", "run: continue");
            AbCircleFrameAnimDirector.this.S.postDelayed(AbCircleFrameAnimDirector.this.V, ValueAnimator.getFrameDelay());
        }
    }

    public AbCircleFrameAnimDirector(List<String> list, c.b bVar, int i3) {
        super(list, bVar, i3);
        this.S = new Handler();
    }

    @Override // com.qzone.widget.util.c
    public void d() {
        Log.i("AbCircleFrameAnimDirect", "breakLoop: ");
        this.T = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.util.c
    public int i(int i3) {
        int i16;
        if (this.T && i3 >= (i16 = this.Q)) {
            int i17 = i3 + 1;
            return i17 > this.R ? ((i17 - r1) - 1) + i16 : i17;
        }
        return super.i(i3);
    }

    @Override // com.qzone.widget.util.c
    public boolean l() {
        return super.l() || this.V != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.util.c
    public void m() {
        super.m();
        this.T = false;
    }

    @Override // com.qzone.widget.util.c
    public void u() {
        v();
        this.T = true;
        this.U = System.nanoTime();
        this.V = new UpdateFrameTask();
        this.W = 0L;
        w(0);
        this.S.postDelayed(this.V, ValueAnimator.getFrameDelay());
    }

    @Override // com.qzone.widget.util.c
    public void v() {
        super.v();
        this.V = null;
    }

    public void H(int i3, int i16) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 >= j()) {
            i16 = j() - 1;
        }
        if (i3 > i16) {
            i3 = i16;
        }
        this.Q = i3;
        this.R = i16;
    }
}
