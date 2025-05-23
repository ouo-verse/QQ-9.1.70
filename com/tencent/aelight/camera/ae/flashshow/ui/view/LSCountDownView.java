package com.tencent.aelight.camera.ae.flashshow.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSCountDownView extends RelativeLayout {
    private static final String F = "LSCountDownView";
    private AtomicBoolean C;
    private b D;
    private Handler E;

    /* renamed from: d, reason: collision with root package name */
    private TextView f65079d;

    /* renamed from: e, reason: collision with root package name */
    private Animation f65080e;

    /* renamed from: f, reason: collision with root package name */
    private PlayerUtil.Player f65081f;

    /* renamed from: h, reason: collision with root package name */
    private PlayerUtil.Player f65082h;

    /* renamed from: i, reason: collision with root package name */
    private int f65083i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f65084m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static final class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<LSCountDownView> f65085a;

        public a(LSCountDownView lSCountDownView) {
            this.f65085a = new WeakReference<>(lSCountDownView);
        }

        public void a(LSCountDownView lSCountDownView, Message message) {
            if (message.what == 1) {
                lSCountDownView.d(lSCountDownView.f65083i - 1);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f65085a.get() == null) {
                removeCallbacksAndMessages(null);
                return;
            }
            try {
                a(this.f65085a.get(), message);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a();

        void b();
    }

    public LSCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65083i = 0;
        this.C = new AtomicBoolean(true);
        this.E = new a(this);
        this.f65080e = AnimationUtils.loadAnimation(context, R.anim.f154395kh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3) {
        this.f65083i = i3;
        if (i3 <= 0) {
            setVisibility(4);
            b bVar = this.D;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        this.f65079d.setText(String.format(getResources().getConfiguration().locale, "%d", Integer.valueOf(i3)));
        this.f65080e.reset();
        this.f65079d.clearAnimation();
        this.f65079d.startAnimation(this.f65080e);
        if (this.f65084m) {
            if (this.C.get()) {
                this.C.set(false);
                try {
                    LockMethodProxy.sleep(150L);
                } catch (InterruptedException e16) {
                    LogUtils.e(e16);
                }
            }
            if (i3 == 1) {
                PlayerUtil.startPlayer(this.f65081f, true);
            } else if (i3 <= 3) {
                PlayerUtil.startPlayer(this.f65082h, true);
            }
        }
        this.E.sendEmptyMessageDelayed(1, 1000L);
    }

    public void c() {
        if (this.f65083i > 0) {
            this.f65083i = 0;
            this.E.removeMessages(1);
            setVisibility(4);
            b bVar = this.D;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f65079d = (TextView) findViewById(R.id.rzk);
    }

    public void setCountDownListener(b bVar) {
        this.D = bVar;
    }

    public void e(int i3, boolean z16) {
        if (i3 <= 0) {
            LogUtils.w(F, "Invalid input for countdown timer: " + i3 + " seconds");
            return;
        }
        setVisibility(0);
        this.f65084m = z16;
        d(i3);
    }
}
