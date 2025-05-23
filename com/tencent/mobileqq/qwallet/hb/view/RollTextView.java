package com.tencent.mobileqq.qwallet.hb.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RollTextView extends TextSwitcher {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private c f277900d;

    /* renamed from: e, reason: collision with root package name */
    private Context f277901e;

    /* renamed from: f, reason: collision with root package name */
    private b f277902f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f277903h;

    /* renamed from: i, reason: collision with root package name */
    private int f277904i;

    /* renamed from: m, reason: collision with root package name */
    private int f277905m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class ContentSupplyThread implements Runnable {
        ContentSupplyThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RollTextView.this.H) {
                try {
                    LockMethodProxy.sleep(RollTextView.this.C * 170);
                } catch (InterruptedException e16) {
                    QLog.e("RollTextView", 1, "error msg in qqpay-impl module: ", e16);
                }
            }
            while (RollTextView.this.f277904i != RollTextView.this.f277905m) {
                RollTextView rollTextView = RollTextView.this;
                if (!rollTextView.f277903h) {
                    break;
                }
                try {
                    int i3 = rollTextView.f277904i % 10;
                    Message obtainMessage = RollTextView.this.f277900d.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("content", Integer.toString(i3));
                    obtainMessage.setData(bundle);
                    RollTextView.this.f277900d.sendMessage(obtainMessage);
                    LockMethodProxy.sleep(170L);
                    if (RollTextView.this.f277904i > RollTextView.this.f277905m) {
                        RollTextView.i(RollTextView.this);
                    } else {
                        RollTextView.h(RollTextView.this);
                    }
                } catch (InterruptedException e17) {
                    QLog.e("RollTextView", 1, "error msg in qqpay-impl module: ", e17);
                }
            }
            if (RollTextView.this.f277904i == RollTextView.this.f277905m) {
                Message obtainMessage2 = RollTextView.this.f277900d.obtainMessage();
                obtainMessage2.what = 1;
                Bundle bundle2 = new Bundle();
                bundle2.putString("content", Integer.toString(RollTextView.this.f277904i % 10));
                obtainMessage2.setData(bundle2);
                RollTextView.this.f277900d.sendMessage(obtainMessage2);
            }
            if (RollTextView.this.f277902f != null) {
                RollTextView.this.f277902f.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ViewSwitcher.ViewFactory {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f277906d;

        a(boolean z16) {
            this.f277906d = z16;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            String str;
            TextView textView = new TextView(RollTextView.this.f277901e);
            try {
                textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                textView.setTextSize(0, RollTextView.this.F);
                textView.setIncludeFontPadding(false);
                textView.setTextColor(RollTextView.this.G);
                if (this.f277906d) {
                    str = "0";
                } else {
                    str = "";
                }
                textView.setText(str);
            } catch (Exception e16) {
                QLog.e("RollTextView", 1, "error msg in qqpay-impl module: ", e16);
            }
            return textView;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    interface b {
        void a();

        void b(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<RollTextView> f277908a;

        c(RollTextView rollTextView) {
            this.f277908a = new WeakReference<>(rollTextView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            RollTextView rollTextView = this.f277908a.get();
            if (rollTextView != null && (data = message.getData()) != null && message.what == 1) {
                rollTextView.setText(data.getString("content"));
                if (rollTextView.f277902f != null) {
                    rollTextView.f277902f.b(null);
                }
            }
        }
    }

    public RollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f277900d = new c(this);
        this.f277901e = null;
        this.f277902f = null;
        this.f277903h = true;
        this.C = 0;
        this.D = 200;
        this.E = 200;
        this.F = 50;
        this.H = true;
        l(context, true);
    }

    static /* synthetic */ int h(RollTextView rollTextView) {
        int i3 = rollTextView.f277904i;
        rollTextView.f277904i = i3 + 1;
        return i3;
    }

    static /* synthetic */ int i(RollTextView rollTextView) {
        int i3 = rollTextView.f277904i;
        rollTextView.f277904i = i3 - 1;
        return i3;
    }

    private void m(boolean z16) {
        this.H = z16;
        if (z16) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f277901e, R.anim.f154882ew);
            loadAnimation.setFillAfter(true);
            setInAnimation(loadAnimation);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f277901e, R.anim.f154883ex);
            loadAnimation2.setFillAfter(true);
            setOutAnimation(loadAnimation2);
            return;
        }
        setInAnimation(null);
        setOutAnimation(null);
    }

    public void l(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        this.f277901e = context;
        m(z16);
        setFactory(new a(z16));
    }

    public void n() {
        ThreadManagerV2.postImmediately(new ContentSupplyThread(), null, true);
    }

    public void o() {
        this.f277903h = false;
    }

    public void setContext(int i3, int i16) {
        this.f277904i = i3;
        this.f277905m = i16;
    }

    public void setFactor(int i3) {
        if (i3 >= 0) {
            this.C = i3;
        }
    }

    public void setListener(b bVar) {
        this.f277902f = bVar;
    }

    public void setScope(int i3, int i16) {
        if (!this.H) {
            this.f277905m = i16;
            this.f277904i = i16;
        } else {
            this.f277904i = i3;
            this.f277905m = i16;
        }
    }

    public RollTextView(Context context) {
        super(context);
        this.f277900d = new c(this);
        this.f277901e = null;
        this.f277902f = null;
        this.f277903h = true;
        this.C = 0;
        this.D = 200;
        this.E = 200;
        this.F = 50;
        this.H = true;
        l(context, true);
    }

    public RollTextView(Context context, int i3, int i16, boolean z16) {
        super(context);
        this.f277900d = new c(this);
        this.f277901e = null;
        this.f277902f = null;
        this.f277903h = true;
        this.C = 0;
        this.D = 200;
        this.E = 200;
        this.H = true;
        this.F = i3;
        this.G = i16;
        l(context, z16);
    }
}
