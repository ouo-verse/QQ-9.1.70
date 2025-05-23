package com.tencent.adelie.av.ui;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieLoadingTextView extends AppCompatTextView {
    private static final String[] D = {"", ".", "..", MiniBoxNoticeInfo.APPNAME_SUFFIX, ""};
    private boolean C;

    /* renamed from: h, reason: collision with root package name */
    private CountDownTimer f61520h;

    /* renamed from: i, reason: collision with root package name */
    private long f61521i;

    /* renamed from: m, reason: collision with root package name */
    private int f61522m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends CountDownTimer {
        a(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AdelieLoadingTextView.this.e();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            AdelieLoadingTextView.this.g();
        }
    }

    public AdelieLoadingTextView(Context context) {
        super(context);
        this.f61522m = 0;
        this.C = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i3 = this.f61522m + 1;
        String[] strArr = D;
        int length = i3 % strArr.length;
        this.f61522m = length;
        setText(strArr[length]);
    }

    public void b(long j3) {
        this.f61521i = j3;
    }

    public void e() {
        stop();
    }

    public void f() {
        if (this.C) {
            return;
        }
        this.C = true;
        this.f61522m = 0;
        if (this.f61520h == null) {
            long j3 = this.f61521i;
            this.f61520h = new a(j3 * 500, j3);
        }
        this.f61520h.start();
    }

    public void stop() {
        this.C = false;
        CountDownTimer countDownTimer = this.f61520h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f61520h = null;
        }
    }

    public AdelieLoadingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61522m = 0;
        this.C = false;
    }

    public AdelieLoadingTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f61522m = 0;
        this.C = false;
    }
}
