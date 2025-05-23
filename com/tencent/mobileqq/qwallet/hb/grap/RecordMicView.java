package com.tencent.mobileqq.qwallet.hb.grap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RecordMicView extends Button {

    /* renamed from: d, reason: collision with root package name */
    private final Handler f277394d;

    /* renamed from: e, reason: collision with root package name */
    private final int f277395e;

    /* renamed from: f, reason: collision with root package name */
    private int f277396f;

    /* renamed from: h, reason: collision with root package name */
    private int f277397h;

    /* renamed from: i, reason: collision with root package name */
    private a f277398i;

    /* renamed from: m, reason: collision with root package name */
    private float f277399m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a();

        void b();

        void onCancel();

        void onEnd();
    }

    public RecordMicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f277396f = 10000;
        this.f277397h = 0;
        this.f277399m = 0.0f;
        this.f277394d = new Handler(Looper.getMainLooper());
        this.f277395e = x.c(getContext(), 33.0f);
        setClickable(true);
        Log.d("nitetest", "RecordMicView: nitetset");
    }

    public void b() {
        this.f277394d.removeCallbacksAndMessages(null);
        this.f277397h = 0;
    }

    public void c() {
        this.f277394d.removeCallbacksAndMessages(null);
        this.f277394d.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.grap.RecordMicView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordMicView.this.b();
                if (RecordMicView.this.f277398i != null) {
                    RecordMicView.this.f277398i.b();
                }
            }
        }, this.f277396f);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.f277394d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z16 = true;
        if (action != 0) {
            if ((action == 1 || action == 3) && this.f277397h == 1) {
                if (this.f277399m - motionEvent.getRawY() <= this.f277395e) {
                    z16 = false;
                }
                b();
                if (z16) {
                    a aVar = this.f277398i;
                    if (aVar != null) {
                        aVar.onCancel();
                    }
                } else {
                    a aVar2 = this.f277398i;
                    if (aVar2 != null) {
                        aVar2.onEnd();
                    }
                }
            }
        } else if (this.f277397h == 0) {
            this.f277397h = 1;
            c();
            a aVar3 = this.f277398i;
            if (aVar3 != null) {
                aVar3.a();
            }
            this.f277399m = motionEvent.getRawY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRecordTime(int i3) {
        this.f277396f = i3;
    }

    public void setStatusListener(a aVar) {
        this.f277398i = aVar;
    }
}
