package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* loaded from: classes5.dex */
public class AutoStartProgressBar extends MessageProgressView {
    protected static int O0 = 50;
    protected static int P0 = -1;
    protected int L0;
    protected String M0;
    protected boolean N0;

    /* loaded from: classes5.dex */
    private class ProgressThread extends BaseThread {
        final /* synthetic */ AutoStartProgressBar this$0;

        private boolean c(int i3, int i16) {
            return e(i3, i16, 1.0d, true);
        }

        private boolean d(int i3, int i16, double d16) {
            return e(i3, i16, d16, true);
        }

        private boolean e(int i3, int i16, double d16, boolean z16) {
            int i17;
            double d17;
            if (i3 < 0 || i16 < 0 || (i17 = this.this$0.f315824f) >= i3) {
                return false;
            }
            int i18 = (i3 - i17) / (i16 / AutoStartProgressBar.O0);
            if (i18 == 0) {
                i18 = 1;
            }
            while (this.this$0.f315824f <= i3) {
                if (z16 && o()) {
                    return false;
                }
                AutoStartProgressBar autoStartProgressBar = this.this$0;
                int i19 = autoStartProgressBar.f315824f + i18;
                autoStartProgressBar.f315824f = i19;
                autoStartProgressBar.setAnimProgress(i19, autoStartProgressBar.M0);
                this.this$0.postInvalidate();
                try {
                    double d18 = AutoStartProgressBar.O0;
                    if (d16 < 0.0d) {
                        d17 = this.this$0.t((int) d16);
                    } else {
                        d17 = d16;
                    }
                    LockMethodProxy.sleep((long) (d18 * d17));
                } catch (InterruptedException unused) {
                }
            }
            return true;
        }

        private boolean o() {
            AutoStartProgressBar autoStartProgressBar = this.this$0;
            if (autoStartProgressBar.N0) {
                return e(autoStartProgressBar.L0, 400, 0.33000001311302185d, false);
            }
            return false;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            if (!c((((int) ((Math.random() * 31.0d) + 40.0d)) * this.this$0.L0) / 100, 1500) || !c((this.this$0.L0 * 90) / 100, 1500)) {
                return;
            }
            d((this.this$0.L0 * 99) / 100, AutoStartProgressBar.O0 * 10, AutoStartProgressBar.P0);
        }
    }

    public AutoStartProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.L0 = 100;
        this.N0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double t(int i3) {
        if (i3 == P0) {
            return Math.pow(10.0d - ((1.0d - ((this.f315824f * 1.0d) / this.L0)) * 100.0d), 2.5d);
        }
        return 0.0d;
    }

    public void setKey(String str) {
        this.M0 = str;
    }

    public AutoStartProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoStartProgressBar(Context context) {
        this(context, null);
    }
}
