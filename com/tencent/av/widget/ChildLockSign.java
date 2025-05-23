package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.widget.api.IChildLockSignApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ChildLockSign extends View implements Handler.Callback, View.OnClickListener {
    private Handler C;
    private boolean D;
    private ChangeSignThread E;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f77211d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f77212e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f77213f;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f77214h;

    /* renamed from: i, reason: collision with root package name */
    private int f77215i;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f77216m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class ChangeSignThread extends BaseThread {
        ChangeSignThread() {
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            ChildLockSign childLockSign = ChildLockSign.this;
            childLockSign.f77213f = childLockSign.f77212e;
            ChildLockSign.this.D = false;
            ChildLockSign.this.postInvalidate();
            try {
                LockMethodProxy.sleep(500L);
            } catch (InterruptedException unused) {
            }
            ChildLockSign.this.f(1);
        }
    }

    public ChildLockSign(Context context) {
        super(context);
        this.f77214h = new RectF();
        this.f77216m = new Paint();
        this.D = true;
        this.E = null;
        e(null, 0);
        setOnClickListener(this);
    }

    private void e(AttributeSet attributeSet, int i3) {
        setId(R.id.m0u);
        Resources resources = getResources();
        this.D = true;
        try {
            this.f77211d = BitmapFactory.decodeResource(resources, R.drawable.daq);
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.dar);
            this.f77212e = decodeResource;
            if (this.D) {
                this.f77213f = this.f77211d;
            } else {
                this.f77213f = decodeResource;
            }
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
        this.f77216m.setFlags(1);
        this.f77216m.setColor(-1);
        this.C = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3) {
        Message message = new Message();
        message.what = i3;
        this.C.sendMessage(message);
    }

    private void g() {
        ChangeSignThread changeSignThread = new ChangeSignThread();
        this.E = changeSignThread;
        changeSignThread.start();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            setVisibility(8);
            ((IChildLockSignApi) QRoute.api(IChildLockSignApi.class)).handleSuccessMsg(getContext());
            setEnabled(true);
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.D) {
            setEnabled(false);
            g();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f77216m.setStrokeWidth(8.0f);
        this.f77216m.setStyle(Paint.Style.STROKE);
        this.f77216m.setAlpha(255);
        Bitmap bitmap = this.f77213f;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f77213f, (Rect) null, this.f77214h, this.f77216m);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.f77215i = Math.min(i3, i16);
        if (QLog.isDevelopLevel()) {
            QLog.d("ChildLockSign", 1, "ChildLock : w = " + i3 + "  h = " + i16 + " min = " + this.f77215i + "  " + (this.f77215i / 6) + "  " + (this.f77215i / 6) + "  " + ((this.f77215i * 5) / 6) + "  " + ((this.f77215i * 5) / 6));
        }
        RectF rectF = this.f77214h;
        int i19 = this.f77215i;
        rectF.set(i19 / 6, i19 / 6, (i19 * 5) / 6, (i19 * 5) / 6);
    }

    public void setLocked(boolean z16) {
        this.D = z16;
        if (z16) {
            this.f77213f = this.f77211d;
        } else {
            this.f77213f = this.f77212e;
        }
    }

    public ChildLockSign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f77214h = new RectF();
        this.f77216m = new Paint();
        this.D = true;
        this.E = null;
        e(attributeSet, 0);
    }

    public ChildLockSign(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f77214h = new RectF();
        this.f77216m = new Paint();
        this.D = true;
        this.E = null;
        e(attributeSet, i3);
        new ChildLockSign(context);
    }
}
