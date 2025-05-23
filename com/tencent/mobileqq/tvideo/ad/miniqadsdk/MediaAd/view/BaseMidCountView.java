package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class BaseMidCountView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    protected Context f303676d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f303677e;

    /* renamed from: f, reason: collision with root package name */
    protected ViewState f303678f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f303679h;

    /* renamed from: i, reason: collision with root package name */
    protected int f303680i;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f303681m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public enum ViewState {
        DEFAULT,
        RESIZED,
        HIDDEN,
        OPENED,
        REMOVED,
        CLOSED,
        DESTROYED
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaseMidCountView.this.g(message);
        }
    }

    public BaseMidCountView(Context context) {
        super(context);
        this.f303680i = -1;
        this.f303681m = new a(Looper.getMainLooper());
        this.f303676d = context;
        h();
    }

    private void e() {
        n.e("BaseMidCountView", "destroy");
        ViewState viewState = this.f303678f;
        ViewState viewState2 = ViewState.DESTROYED;
        if (viewState == viewState2) {
            return;
        }
        if (getParent() != null) {
            removeAllViews();
            ((ViewGroup) getParent()).removeView(this);
        }
        this.f303677e = null;
        this.f303678f = viewState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        if (message == null) {
            return;
        }
        int i3 = message.what;
        if (i3 != 1000) {
            if (i3 != 1001) {
                if (i3 != 1004) {
                    if (i3 == 1005) {
                        i(message.arg1);
                        return;
                    }
                    return;
                }
                e();
                return;
            }
            j();
            setVisibility(0);
            return;
        }
        d();
        setVisibility(4);
    }

    private void h() {
        this.f303681m.sendEmptyMessage(1000);
        this.f303678f = ViewState.HIDDEN;
    }

    private void i(int i3) {
        if (this.f303680i != i3) {
            n.g("BaseMidCountView", "setCount: " + i3);
            if (this.f303679h != null) {
                this.f303679h.setText(f(i3));
            }
            this.f303680i = i3;
        }
    }

    private void j() {
        n.e("BaseMidCountView", "showView");
        ViewGroup viewGroup = this.f303677e;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            this.f303677e.addView(this);
        }
    }

    public void b(ViewGroup viewGroup) {
        n.g("BaseMidCountView", "attachTo");
        if (viewGroup == null) {
            return;
        }
        this.f303677e = viewGroup;
        this.f303681m.sendEmptyMessage(1001);
        this.f303678f = ViewState.OPENED;
    }

    public void c() {
        n.e("BaseMidCountView", "close");
        ViewState viewState = this.f303678f;
        ViewState viewState2 = ViewState.CLOSED;
        if (viewState != viewState2) {
            this.f303681m.sendEmptyMessage(1004);
            this.f303678f = viewState2;
        }
    }

    abstract void d();

    abstract String f(int i3);

    public void setCountDown(int i3) {
        if (i3 < 0) {
            return;
        }
        Message obtainMessage = this.f303681m.obtainMessage(1005);
        obtainMessage.arg1 = i3 / 1000;
        this.f303681m.sendMessage(obtainMessage);
    }
}
