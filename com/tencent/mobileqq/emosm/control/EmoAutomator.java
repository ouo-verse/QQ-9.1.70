package com.tencent.mobileqq.emosm.control;

import android.annotation.TargetApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class EmoAutomator implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public long f204263d;

    /* renamed from: e, reason: collision with root package name */
    public int f204264e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected int f204265f = 0;

    /* renamed from: h, reason: collision with root package name */
    protected LinkedList<EmoAsyncStep> f204266h = new LinkedList<>();

    /* renamed from: i, reason: collision with root package name */
    private EmoLinearGroup f204267i = null;

    /* renamed from: m, reason: collision with root package name */
    private LinkedList<EmoLinearGroup> f204268m = new LinkedList<>();

    public void e() {
        if (QLog.isColorLevel()) {
            QLog.d("EmoAutomator", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        synchronized (this.f204266h) {
            this.f204266h.clear();
            this.f204265f = 0;
        }
        synchronized (this.f204268m) {
            this.f204268m.clear();
            EmoLinearGroup emoLinearGroup = this.f204267i;
            if (emoLinearGroup != null) {
                emoLinearGroup.i(8);
                this.f204267i = null;
            }
        }
        this.f204263d = 0L;
    }

    public void f(EmoAsyncStep[] emoAsyncStepArr) {
        synchronized (this.f204266h) {
            this.f204265f--;
            if (this.f204266h.size() > 0) {
                if (emoAsyncStepArr != null) {
                    for (EmoAsyncStep emoAsyncStep : emoAsyncStepArr) {
                        if (this.f204266h.remove(emoAsyncStep)) {
                            g(emoAsyncStep);
                            return;
                        }
                    }
                }
                g(this.f204266h.poll());
            }
        }
    }

    @TargetApi(9)
    public void g(EmoAsyncStep emoAsyncStep) {
    }
}
